package org.springframework.boot;

import java.io.PrintStream;

import org.springframework.core.env.Environment;

public class CustomBanner extends SpringBootBanner {

	public void printBanner(Environment environment, Class<?> sourceClass, PrintStream printStream) {
		String startProfile = "";
		if (null != environment.getActiveProfiles() && environment.getActiveProfiles().length != 0) {
			startProfile = environment.getActiveProfiles()[0];
		} else {
			startProfile = environment.getDefaultProfiles()[0];
		}
		printStream.println("准备启动" + startProfile + "环境。");
		// super.printBanner(environment, sourceClass, printStream);
	}

}
