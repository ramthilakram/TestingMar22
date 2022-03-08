package org.testing;


import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src\\test\\resources\\Features\\FaceBook.feature", glue = "org.step")

public class TestRunner2 {
	
	

}
