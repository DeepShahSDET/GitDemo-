package com.example.logger;

import org.apache.log4j.Logger;

public class Log {

	private static Logger log = Logger.getLogger(Log.class.getName());

	public static void error(String message) {
		log.error(message);
	}

	public static void trace(String message) {
		log.trace(message);
	}

	public static void warn(String message) {
		log.warn(message);
	}

	public static void fatal(String message) {
		log.fatal(message);
	}

	public static void info(String message) {
		// TODO Auto-generated method stub
		log.info(message);
	}
}
