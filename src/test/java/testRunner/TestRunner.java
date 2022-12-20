package testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/features",glue ="stepDefinitions"
                 ,monochrome=true,
plugin= {"pretty","html:target/cucumber.html","io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
         "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
        })
public class TestRunner {
 
 
}