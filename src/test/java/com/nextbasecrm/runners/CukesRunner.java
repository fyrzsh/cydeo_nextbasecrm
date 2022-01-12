package com.nextbasecrm.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        plugin = {
                "html:target/cucumber-report.html"
        },

        features = "src/test/resources/features",
        glue = "src/test/java/com/nextbasecrm/step_defs",
        dryRun = false,
        tags = "@wip"
)

public class CukesRunner { }
