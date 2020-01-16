package com.pstomi.gametransaction.service;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONException;
import org.json.JSONObject;

import com.pstomi.gametransaction.model.GameTransactionModel;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GameTransactionRestServiceTest {
    private static final String BASE_URL = "http://localhost:9000/gametransaction";
    private ObjectMapper objectMapper = new ObjectMapper();
    HttpResponse response;

    @Given("There is no transaction stored")
    public void noTransactions() throws ClientProtocolException, IOException, JSONException {

    }
    
    @When("I create game transaction where {int} of monetary amount spent by {word} user for {word} product")
    public void testTransfer(String userId, String productId, int monetaryAmount) throws ClientProtocolException, IOException, JSONException {
    	HttpClient httpClient = HttpClientBuilder.create().build();
    	HttpPost request = new HttpPost( BASE_URL + "/store-transaction");
    	JSONObject data = new JSONObject();
    	data.put("userId", userId);
    	data.put("productId", productId);
    	data.put("monetaryAmount", monetaryAmount);
    	request.setEntity(new StringEntity(data.toString(), ContentType.APPLICATION_JSON));
        response = httpClient.execute( request );
    }
    
    @When("I check transactions")
    public void testBalance() throws ClientProtocolException, IOException {
    	HttpClient httpClient = HttpClientBuilder.create().build();
    	HttpGet request = new HttpGet( BASE_URL + "/all-transactions");
        response = httpClient.execute( request );

    }
    
    @Then("I have {int} game transaction")
    public void amountOfTransaction(int amount) throws JsonParseException, JsonMappingException, UnsupportedOperationException, IOException {
        List<GameTransactionModel> balance = objectMapper.readValue(response.getEntity().getContent(), objectMapper.getTypeFactory().constructCollectionType(List.class, GameTransactionModel.class));
        assertEquals(amount, balance.size());    	
    }
}
