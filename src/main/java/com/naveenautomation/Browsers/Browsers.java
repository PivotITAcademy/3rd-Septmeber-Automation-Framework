package com.naveenautomation.Browsers;

public enum Browsers {

	// Enum class for browser
	GOOGLE_CHROME("chrome"), EDGE("edge"), FIREFOX("firefox");

	String name;

	private Browsers(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public static Browsers getBrowserByName(String browserName) {

		Browsers browser = null;

		Browsers[] allBrowser = Browsers.values();

		for (Browsers browserElement : allBrowser) {
			if (browserElement.toString().equals(browserName)) {
				browser = browserElement;
				break;
			}
		}

		return browser;
	}

}
