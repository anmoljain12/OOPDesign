/*
javac -version
javac GearDemo.java -d ClassFiles
java -cp ClassFiles learnJava.GearDemo
*/

package learnJava;

class Gear{

	private class Wheel{
		double rim;
		double tire;

		Wheel(double rim, double tire){
			this.rim = rim;
			this.tire = tire;
		}

		double diameter(){
			return rim + (tire * 2);
		}

	}

	private int chainRing;
	private int cog;
	private Wheel wheel;

	public Gear(int chainRing, int cog, double rim, double tire){
		this.chainRing = chainRing;
		this.cog = cog;
		wheel = new Wheel(rim, tire);
	}

	public double ratio(){
		return chainRing/ (double) cog;
	}

	public double gearInches(){
		return ratio() * wheel.diameter();
	}

}

public class GearDemo{
	public static void main(String[] args) {
		System.out.println((new Gear(52, 11, 26, 1.5)).gearInches());
		System.out.println((new Gear(52, 11, 24, 1.25)).gearInches());
	}
}