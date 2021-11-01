package com.myntra.runner;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:features",//to tell cucumber where is your feature file are...
        glue ="com.myntra.stepdefination", // to tell cucumber where is your step definition code reside in the framework......
        tags = "@second",//use for single scenario tag run
        plugin = {"pretty", // to generate reports
                "html:target/html/htmlreport.html",
                "json:target/json/file.json",
        },
        publish = true,
        dryRun = false
)

public class Test_Runner {
}
