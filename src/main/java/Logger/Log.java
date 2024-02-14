package Logger;

import org.apache.logging.log4j.Logger;

import Reports.ExtentLogger;

public class Log {
	
	public static void info(String message, boolean requiredOnExtent, Logger logger) {
		if (requiredOnExtent)
			ExtentLogger.info(message);
			logger.info(message);
	}
	
	public static void success(String message, boolean requiredOnExtent, Logger logger) {
		if (requiredOnExtent) 
			ExtentLogger.pass(message);
			logger.info(message);
	}
	
	public static void error(String message, boolean requiredOnExtent, Logger logger) {
		if (requiredOnExtent)
			ExtentLogger.fail(message);
			logger.error(message);
	}
}
