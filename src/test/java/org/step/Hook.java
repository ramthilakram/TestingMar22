package org.step;

import org.base.BaseClass1;


import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hook extends BaseClass1{
	@Before
	public void beforeClass() {
		browserConfigChrome();
		openUrl("https://www.facebook.com/");
		maximizeWindow();
	}
	
	
	@After
	public void afterClass() {
		closeBrowser();
	}
	
}
