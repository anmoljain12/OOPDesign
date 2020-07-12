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

	public Bicycle(Map<String, String> args){
		size = args.get("size");
		tape_color = args.get("tape_color");
		spares = getSpares();
	}

	private Map<String, String> getSpares(){
		Map<String, String> newSpares = new HashMap<>();
		newSpares.put("chain", "10-speed");
		newSpares.put("tire_size", "23");
		newSpares.put("tape_color", tape_color);
		return newSpares;
	}
}

class MountainBike extends Bicycle{
	String front_shock;
	String rear_shock;

	public MountainBike(Map<String, String> args){
		super(args);
		front_shock = args.get("front_shock");
		rear_shock = args.get("rear_shock");
		spares = getSpares();
	}

	private Map<String, String> getSpares(){
		spares.put("rear_shock", rear_shock);
		return spares;
	}

}

public class BicycleDemo{
	public static void main(String[] arg) {
		Map<String, String> args = new HashMap<>();
		args.put("style", "mountain");
		args.put("size", "S");
		args.put("front_shock", "Manitou");
		args.put("rear_shock", "Fox");
		MountainBike mountain_bike = new MountainBike(args);
		System.out.println(mountain_bike.size);
		System.out.println(Arrays.asList(mountain_bike.spares));
	}
}