package com.pstomi.gametransaction.service;

import org.junit.runner.RunWith;


import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(plugin = "pretty", features = "src/main/resources/features/")
public class CucumberStarter {
	

}
