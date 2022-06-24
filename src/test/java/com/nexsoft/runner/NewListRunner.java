package com.nexsoft.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "", 
features = "src/test/resources/NewList.feature", 
glue = "com.nexsoft.definitions")
public class NewListRunner extends AbstractTestNGCucumberTests {

}
