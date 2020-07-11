/*
javac -version
javac GearDemo.java -d ClassFiles
java -cp ClassFiles learnJava.GearDemo
*/

package learnJava;

class Gear{

	private int chainRing;
	private int cog;
	private Wheel wheel;

	public Gear(int chainRing, int cog, Wheel wheel){
		this.chainRing = chainRing;
		this.cog = cog;
		this.wheel = wheel;
	}

	public Gear(int chainRing, int cog){
		this.chainRing = chainRing;
		this.cog = cog;
	}

	public double ratio(){
		return chainRing / (double) cog;
	}

	public double gearInches(){
		return ratio() * wheel.diameter();
	}

}

class Wheel{
	private double rim;
	private double tire;

	public Wheel(double rim, double tire){
		this.rim = rim;
		this.tire = tire;
	}

	public double diameter(){
		return rim + (tire * 2.0);
	}

	public double circumference(){
		return diameter() * Math.PI;
	}

}

public class GearDemo{
	public static void main(String[] args) {

		Wheel wheel = new Wheel(26, 1.5);
		System.out.println(wheel.circumference());
		System.out.println((new Gear(52, 11, wheel)).gearInches());
		System.out.println((new Gear(52, 11, new Wheel(26, 1.5))).gearInches());
		System.out.println((new Gear(52, 11)).ratio());
	}
}