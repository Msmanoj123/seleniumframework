package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="C:\\Users\\manoj.ms\\eclipse-workspace\\completeselenium\\src\\test\\java\\cucumber\\features\\beyoung.feature",
glue="stepdefinitions",
plugin="html:reports/report1.html")
public class beyoung {

}
