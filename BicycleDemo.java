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
	String style;
	String size;
	String tape_color;
	String front_shock;
	String rear_shock;
	Map<String, String> spares;

	public Bicycle(Map<String, String> args){
		style = args.get("style");
		size = args.get("size");
		tape_color = args.get("tape_color");
		front_shock = args.get("front_shock");
		rear_shock = args.get("rear_shock");
		spares = getSpares();
	}

	private Map<String, String> getSpares(){
		Map<String, String> newSpares = new HashMap<>();
		if (style.equals("road")){
			newSpares.put("chain", "10-speed");
			newSpares.put("tire_size", "23");
			newSpares.put("tape_color", this.tape_color);
		}else{
			newSpares.put("chain", "10-speed");
			newSpares.put("tire_size", "2.1");
			newSpares.put("rear_shock", this.rear_shock);
		}
		return newSpares;
	}
}

public class BicycleDemo{
	public static void main(String[] arg) {
		Map<String, String> args = new HashMap<>();
		args.put("style", "mountain");
		args.put("size", "S");
		args.put("front_shock", "Manitou");
		args.put("rear_shock", "Fox");
		Bicycle bike = new Bicycle(args);
		System.out.println(bike.size);
		System.out.println(Arrays.asList(bike.spares));
	}
}