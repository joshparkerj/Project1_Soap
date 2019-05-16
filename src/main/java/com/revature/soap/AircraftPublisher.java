package com.revature.soap;

import javax.xml.ws.Endpoint;

public class AircraftPublisher {

	public static void main(String[] args) {
		Endpoint.publish("http://0.0.0.0:3006/aircraft", new AircraftService());
	}

}
