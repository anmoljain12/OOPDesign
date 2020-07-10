/*
javac -version
javac Gear.java -d ClassFiles
java -cp ClassFiles learnJava.Gear
*/

package learnJava;

public class Gear{

	int chainRing;
	int cog;
	double rim;
	double tire;

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


	public static void main(String[] args) {
		System.out.println((new Gear(52, 11, 26, 1.5)).gearInches());
		System.out.println((new Gear(52, 11, 24, 1.25)).gearInches());
	}
}