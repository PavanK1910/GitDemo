package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/cucumber",glue="rahulshettyaccadmy.stepDefination", monochrome=true,
tags = "@Regration", plugin={"html:target/cucumber.html"})

public class TestNgTestRunner extends AbstractTestNGCucumberTests{

}
