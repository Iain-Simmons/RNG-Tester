package RNG;

import java.util.Random;

import org.apache.commons.math3.random.MersenneTwister;
import org.apache.commons.math3.random.Well19937c;
import org.apache.commons.math3.random.Well44497b;
import org.apache.commons.math3.random.Well1024a;
import org.uncommons.maths.random.MersenneTwisterRNG;

public class GeneratorComparison {

	public static void main(String[] args) {

		// MERSENNE TWISTER (Apache Commons)

		MersenneTwister mt = new MersenneTwister();
		double value;

		for (int i = 0; i < 0; i++) {
			value = mt.nextDouble();
			System.out.println(value);
		}

		// PRNG suitable for Monte-Carlo Simulations.
		// It has a long period(2^19937-1).
		// Takes very little Memory Space and passes many tests for statistical
		// randomness.
		// Equidistributed up to dimenstion 623

		// The large state space stresses the CPU cache.
		// Can take a while to start generating output that passes randomness
		// tests.

		// WELL19937

		Well19937c wellc = new Well19937c();
		double value1;

		for (int i = 0; i < 0; i++) {
			value1 = wellc.nextDouble();
			System.out.println(value1);

			// PRNG suitable for Monte-Carlo Simulations.
			// It has a long period (2^19937-1).
			// Equidistributed up to dimension 623
			// Passes many tests for statistical randomness.
			// Offers quick recovery

			// Slower compared to other generators

		}
		// WELL44497b
		Well44497b wellb = new Well44497b();
		double value2;

		for (int i1 = 0; i1 < 0; i1++) {
			value2 = wellb.nextDouble();
			System.out.println(value2);

			// PRNG suitable for Monte-Carlo Simulations.
			// It has a long period (2^44497-1).
			// Passes many tests for statistical randomness.

			// Slower compared to other generators.
		}

		// MERSENNE TWISTER (Uncommons)

		MersenneTwisterRNG mtu = new MersenneTwisterRNG();
		double value3;

		for (int i = 0; i < 0; i++) {
			value3 = mtu.nextDouble();
			System.out.println(value3);

			// PRNG suitable for Monte-Carlo Simulations.
			// It has a long period (2^19937-1).

			// Slow compared to other generators
		}

		// MERSENNE TWISTER (Colt)

		cern.jet.random.engine.MersenneTwister mtc = new cern.jet.random.engine.MersenneTwister();
		double value4;

		for (int i = 0; i < 0; i++) {
			value4 = mtc.nextDouble();
			System.out.println(value4);

			// PRNG suitable for Monte-Carlo simulations
			// It has a long period (2^19937 - 1)
			// It passes many statistical tests for randomness
			// Equidistributed up to dimension 623
		}

		// Well1024a

		Well1024a wella = new Well1024a();
		double value5;

		for (int i = 0; i < 0; i++) {
			value5 = wella.nextDouble();

			System.out.println(value5);

			// PRNG suitable for Monte-Carlo simulations
			// It has a short period (2^1024 -1)
			// Equidistributed up to 32 bits (proven)

			// Suitable for where less than 16 doubles are generated each round
		}
		//Java Random
		
		Random r = new Random();
		double value6;
		
		for(int i=0; i< 0; i++){
			value6=r.nextDouble();
			
			System.out.println(value6);
		}
		}
		
} 

