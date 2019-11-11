package com.automation.interfaces;

public interface ConfigProps {

	 static String getSystemTestProperty(String name) {
		return System.getProperty("system.test" + name);
	}

	static String getBrowser() {
	 	return getSystemTestProperty("browser");
	}

}
