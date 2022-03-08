package com.testing;

import org.base.BaseClass;


import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends BaseClass {
	@Before
	public void beforeClass() {
		getdriver();
		loadUrl("https://www.facebook.com/");
		maximize();
	}
	
	
	@After
	public void afterClass() {
		close();
	}
	
}
