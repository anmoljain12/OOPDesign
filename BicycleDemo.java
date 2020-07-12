/*
javac -version
javac BicycleDemo.java -d ClassFiles
java -cp ClassFiles learnJava.BicycleDemo
*/
package learnJava;

import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

class Bicycle{
	String size;
	String tape_color;
	Map<String, String> spares;

	public Bicycle(String size, String tape_color){
		this.size = size;
		this.tape_color = tape_color;
		spares = getSpares();
	}

	private Map<String, String> getSpares(){
		Map<String, String> newSpares = new HashMap<>();
		newSpares.put("chain", "10-speed");
		newSpares.put("tire_size", "23");
		newSpares.put("tape_color", this.tape_color);
		return newSpares;
	}
}

public class BicycleDemo{
	public static void main(String[] args) {
		Bicycle bike = new Bicycle("M", "red");
		System.out.println(bike.size);
		System.out.println(Arrays.asList(bike.spares));
	}
}