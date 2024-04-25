package com.example;

import java.util.List;

public class Service {

	void create(List<Object> args) {
		var second = (java.util.Optional<String>) args.get(2);

		System.out.println(second);
	}
}
