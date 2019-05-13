package com.revature.soap;

import javax.xml.ws.Endpoint;

public class AircraftPublisher {
	static Endpoint publisher;

	public static void publish() {
		publisher = Endpoint.publish("http://localhost:8080/aircraft", new AircraftService());
	}

	public static void stopPublisher() {
		if (publisher != null)
			publisher.stop();
	}
}
