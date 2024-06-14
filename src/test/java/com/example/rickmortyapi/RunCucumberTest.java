package com.example.rickmortyapi;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    plugin = {"pretty", "html:target/cucumber-reports/cucumber-html-report.html", "json:target/surefire-reports/CucumberTestReport.json"},
    features = "src/test/java/resources/com/example/rickmortyapi",
    glue = "com.example.rickmortyapi"
)
public class RunCucumberTest {
}
