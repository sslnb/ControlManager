package com.arshiner;


import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.arshiner.nio.transmitServer.TransmitServer;

@Component
public class MyCommandLineRunner2 implements CommandLineRunner {

	@Async
	@Override
	public void run(String... var1) throws Exception {
	
		TransmitServer.run();
	}
}
