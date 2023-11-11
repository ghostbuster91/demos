package hello;

import java.util.List;

public class BClient {

	void doSth(Person person, List<String> names) {
		names.stream().count();
		// try to uncomment this and invoke completion
		// System.out.println(person.na);
	}
}
