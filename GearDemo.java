/*
javac -version
javac GearDemo.java -d ClassFiles
java -cp ClassFiles learnJava.GearDemo
*/

package learnJava;

class Gear{

	private int chainRing;
	private int cog;

	public Gear(int chainRing, int cog){
		this.chainRing = chainRing;
		this.cog = cog;
	}

	public double ratio(){
		return chainRing / (double) cog;
	}

	public double gearInches(double diameter){
		return ratio() * diameter;
	}

}

class Wheel{
	private double rim;
	private double tire;
	private Gear gear;

	public Wheel(double rim, double tire, Gear gear){
		this.rim = rim;
		this.tire = tire;
		this.gear = gear;
	}

	public double diameter(){
		return rim + (tire * 2.0);
	}

	public double gearInches(){
		return gear.gearInches(diameter());
	}

	public double circumference(){
		return diameter() * Math.PI;
	}

}

public class GearDemo{
	public static void main(String[] args) {

		Gear gear = new Gear(52,11);
		System.out.println(gear.ratio());
		System.out.println(new Wheel(26, 1.5, gear).gearInches());
	}
}