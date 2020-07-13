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
	String chain;
	String tire_size;

	public Bicycle(Map<String, String> args){
		size = args.get("size");
		chain = args.get("chain") != null ? args.get("chain") : "10-speed";
		tire_size = args.get("tire_size");
	}

}

class RoadBike extends Bicycle{
	String tape_color;
	Map<String, String> spares;

	public RoadBike(Map<String, String> args){
		super(args);
		tire_size = (tire_size!=null) ? tire_size:"23";
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
		tire_size = (tire_size!=null) ? tire_size: "2.1";
		front_shock = args.get("front_shock");
		rear_shock = args.get("rear_shock");
		//spares = getSpares();
	}

	//private Map<String, String> getSpares(){
	//	spares.put("rear_shock", rear_shock);
	//	return spares;
	//}

}

public class BicycleDemo{
	public static void main(String[] arg) {
		Map<String, String> args1 = new HashMap<>();
		args1.put("size", "M");
		args1.put("tape_color", "red");
		RoadBike road_bike = new RoadBike(args1);
		System.out.println(road_bike.tire_size);
		System.out.println(road_bike.chain);
		//System.out.println(Arrays.asList(road_bike.spares));

		
		Map<String, String> args2 = new HashMap<>();
		args2.put("size", "S");
		args2.put("front_shock", "Manitou");
		args2.put("rear_shock", "Fox");
		MountainBike mountain_bike = new MountainBike(args2);
		System.out.println(mountain_bike.tire_size);
		System.out.println(mountain_bike.chain);

		//System.out.println(Arrays.asList(mountain_bike.spares));
		
	}
}