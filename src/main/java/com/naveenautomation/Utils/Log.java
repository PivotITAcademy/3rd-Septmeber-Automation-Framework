package com.naveenautomation.Utils;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Log {

	public static Logger getLoggerData(String nameOfClass) {
		PropertyConfigurator.configure("log4j.properties");
		return Logger.getLogger(nameOfClass);
	}

}
