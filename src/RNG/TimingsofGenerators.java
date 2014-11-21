package RNG;

import java.util.Random;

import org.apache.commons.lang3.time.StopWatch;
import org.apache.commons.math3.random.MersenneTwister;
import org.apache.commons.math3.random.Well1024a;
import org.apache.commons.math3.random.Well19937c;
import org.apache.commons.math3.random.Well44497b;
import org.uncommons.maths.random.MersenneTwisterRNG;

public class TimingsofGenerators {
	public static void main(String... Args) {

		int numTrials = 9999999;

		// MersenneTwister (Apache Commons)

		MersenneTwister mt = new MersenneTwister();
		double value;
		StopWatch sw = new StopWatch();

		sw.start();
		for (int i = 0; i <= numTrials; i++) {
			value = mt.nextDouble();

		}
		sw.stop();
		System.out.println("Time taken for " + mt.getClass() + "to generate "
				+ numTrials + " random numbers: " + sw + " seconds");
		sw.reset();
		// Well19937c

		Well19937c wellc = new Well19937c();

		sw.start();
		for (int i = 0; i <= numTrials; i++) {
			value = wellc.nextDouble();
		}
		sw.stop();
		System.out.println("Time taken for " + wellc.getClass()
				+ " to generate " + numTrials + " random numbers: " + sw
				+ " seconds");
		sw.reset();

		// Well44497b

		Well44497b wellb = new Well44497b();

		sw.start();

		for (int i = 0; i <= numTrials; i++) {
			value = wellb.nextDouble();
		}
		sw.stop();

		System.out.println("Time taken for " + wellb.getClass()
				+ " to generate " + numTrials + " random numbers: " + sw
				+ " seconds");
		sw.reset();

		// MersenneTwister(Uncommon)

		MersenneTwisterRNG mtu = new MersenneTwisterRNG();
		sw.start();
		for (int i = 0; i <= numTrials; i++) {
			value = mtu.nextDouble();
		}
		sw.stop();
		System.out.println("Time taken for " + mtu.getClass() + " to generate "
				+ numTrials + " random numbers: " + sw + " seconds");
		sw.reset();

		// MersenneTwister (Colt)

		cern.jet.random.engine.MersenneTwister mtc = new cern.jet.random.engine.MersenneTwister();
		sw.start();
		for (int i = 0; i <= numTrials; i++) {
			value = mtc.nextDouble();
		}
		sw.stop();
		System.out.println("Time taken for " + mtc.getClass() + " to generate "
				+ numTrials + " random numbers: " + sw + " seconds");
		sw.reset();

		// Well1024a

		Well1024a wella = new Well1024a();
		sw.start();
		for (int i = 0; i <= numTrials; i++) {
			value = wella.nextDouble();
		}
		sw.stop();
		System.out.println("Time taken for " + wella.getClass()
				+ " to generate " + numTrials + " random numbers: " + sw
				+ " seconds");
		sw.reset();
		
		//Java Random

		Random r= new Random();
		sw.start();
		
		for (int i=0; i<= numTrials; i++){
			value= r.nextDouble();
			}
		sw.stop();
		System.out.println("Time taken for " + r.getClass()
				+ " to generate " + numTrials + " random numbers: " + sw
				+ " seconds");
		}
}
