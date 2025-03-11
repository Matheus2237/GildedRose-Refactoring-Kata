package com.gildedrose;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/com/gildedrose",
        glue = "com.gildedrose",
        plugin = "pretty"
)
public class RunCucumberTest {
}