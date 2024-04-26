package com.example;

import hello.*;

import java.util.List;

public class Service {

	void create(List<Object> args, Foo foo) {
		System.out.println(foo.bar());
		System.out.println(Foo$.MODULE$.baz());;
        System.out.println(Foo.baz());;
	}
}
