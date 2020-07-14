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
	Map<String, String> spares = new HashMap<>();

	public Bicycle() {}

	public Bicycle(Map<String, String> args){
		size = args.get("size");
		chain = args.get("chain") != null ? args.get("chain") : this.getDefaultChain();
		tire_size = args.get("tire_size")!= null ? args.get("tire_size") : this.getDefaultTire();
		spares = getSpares();
	}

	public Map<String, String> getSpares(){
		spares.put("chain", chain);
		spares.put("tire_size", tire_size);
		return spares;
	}

	public String getDefaultChain(){
		return "10-speed";
	}

	public String getDefaultTire(){
		return null;
	}

}

class RoadBike extends Bicycle{
	String tape_color;

	public RoadBike(Map<String, String> args){
		super(args);
		tape_color = args.get("tape_color");
		spares = getSpares();
	}

	public Map<String, String> getSpares(){
		spares = super.getSpares();
		spares.put("tape_color", tape_color);
		return spares;
	}

	public String getDefaultTire(){
		return "23";
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

	public Map<String, String> getSpares(){
		spares = super.getSpares();
		spares.put("rear_shock", rear_shock);
		return spares;
	}

	public String getDefaultTire(){
		return "2.1";
	}
}

class RecumbentBike extends Bicycle{
	String flag;

	public RecumbentBike(Map<String, String> args){
		super(args);   Super not called
		flag = args.get("flag");
		spares = getSpares();
	}

	public Map<String, String> getSpares(){
		spares = super.getSpares();
		spares.put("flag", flag);
		return spares;
	}

	public String getDefaultChain(){
		return "9-speed";
	}

	public String getDefaultTire(){
		return "28";
	}


}


public class BicycleDemo{
	public static void main(String[] arg) {
		Map<String, String> args1 = new HashMap<>();
		args1.put("size", "M");
		args1.put("tape_color", "red");
		RoadBike road_bike = new RoadBike(args1);
		System.out.println(road_bike.tire_size);
		System.out.println(road_bike.chain);
		System.out.println(Arrays.asList(road_bike.spares));

		Map<String, String> args2 = new HashMap<>();
		args2.put("size", "S");
		args2.put("front_shock", "Manitou");
		args2.put("rear_shock", "Fox");
		MountainBike mountain_bike = new MountainBike(args2);
		System.out.println(mountain_bike.tire_size);
		System.out.println(mountain_bike.chain);
		System.out.println(Arrays.asList(mountain_bike.spares));

		Map<String, String> args3 = new HashMap<>();
		args3.put("flag", "Tall and orange");
		RecumbentBike recumbent_bike = new RecumbentBike(args3);
		System.out.println(recumbent_bike.tire_size);
		System.out.println(recumbent_bike.chain);
		System.out.println(Arrays.asList(recumbent_bike.spares));
		
	}
}