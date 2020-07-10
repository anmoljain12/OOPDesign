/*
javac -version
javac Gear.java -d ClassFiles
java -cp ClassFiles learnJava.Gear
*/

package learnJava;

public class Gear{

	int chainRing;
	int cog;

	public Gear(int chainRing, int cog){
		this.chainRing = chainRing;
		this.cog = cog;
	}

	public double ratio(){
		return chainRing/ (double) cog;
	}


	public static void main(String[] args) {
		System.out.println((new Gear(52,11)).ratio());
		System.out.println((new Gear(30,27)).ratio());
	}
}