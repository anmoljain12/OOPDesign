/*
javac -version
javac GearDemo.java -d ClassFiles
java -cp ClassFiles learnJava.GearDemo
*/

package learnJava;

class Gear{

	private int chainRing;
	private int cog;
	private double rim;
	private double tire;

	public Gear(int chainRing, int cog, double rim, double tire){
		this.chainRing = chainRing;
		this.cog = cog;
		this.rim = rim;
		this.tire = tire;
	}

	public double ratio(){
		return chainRing/ (double) cog;
	}

	public double gearInches(){
		return this.ratio()*(rim+(tire*2));
	}

}

public class GearDemo{
	public static void main(String[] args) {
		System.out.println((new Gear(52, 11, 26, 1.5)).gearInches());
		System.out.println((new Gear(52, 11, 24, 1.25)).gearInches());
	}
}