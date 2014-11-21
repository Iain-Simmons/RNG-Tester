package RNG;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.math3.random.JDKRandomGenerator;
import org.apache.commons.math3.random.MersenneTwister;
import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.random.Well19937c;

public class Equidistribution {

	public static void main(String[] args) {

		RandomGenerator mt = new MersenneTwister();
		RandomGenerator well = new Well19937c();
		RandomGenerator javaRandom = new JDKRandomGenerator();

		List<int[]> myDataColumns = new ArrayList<>();

		myDataColumns.add(doExperiments(javaRandom));
		myDataColumns.add(doExperiments(mt));
		myDataColumns.add(doExperiments(well));

		saveToFile(myDataColumns);
	}

	public static int[] doExperiments(RandomGenerator generator) {
		int numExperiments = 10000;
		int tenth = numExperiments / 10;

		int[] results = new int[numExperiments];
		for (int i = 0; i < numExperiments; i++) {
			results[i] = getBiggest(buildSamples(generator));
			if (i % tenth == 0)
				System.out.println("Run complete: " + i);
		}

		return results;
	}

	public static void saveToFile(List<int[]> data) {

		String newLine = System.getProperty("line.separator");
		Path filePath = Paths.get("testFile.csv");

		BufferedWriter writer;
		try {
			writer = Files
					.newBufferedWriter(filePath, Charset.forName("UTF-8"));

			for (int j = 0; j < data.get(0).length; j++) {
				StringBuilder b = new StringBuilder();

				for (int i = 0; i < data.size(); i++) {
					b.append(data.get(i)[j]);
					if (i < data.size() - 1)
						b.append(",");
				}

				writer.append(b);
				writer.append(newLine);
			}

			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static int[] buildSamples(RandomGenerator rg) {
		int numBins = 1000;
		int numReps = 1000000;

		int[] bins = new int[numBins];
		Arrays.fill(bins, 0);

		// System.out.println("Running with " + rg);

		int x = 0;
		for (int i = 0; i < numReps; i++) {
			int binNumber = generateBinNumber(rg, bins);
			incrementValueInBin(binNumber, bins);

		}
		return bins;
	}

	public static int getBiggest(int[] bins) {
		int x = 0;

		for (int i = 0; i < bins.length; i++) {
			if (bins[i] > x) {
				x = bins[i];
			}
		}

		return x;
	}

	public static int[] normalise(int[] bins) {

		int counter = 0;
		for (int i = 0; i < bins.length; i++) {
			counter = counter + bins[i];
		}
		counter = counter / bins.length;

		int[] binsCopy = Arrays.copyOf(bins, bins.length);

		for (int i = 0; i < bins.length; i++) {
			binsCopy[i] = binsCopy[i] - counter;
		}

		return binsCopy;

	}

	public static int generateBinNumber(RandomGenerator rg, int[] bins) {
		double d = rg.nextDouble();
		int i = (int) (d * bins.length);
		return i;
	}

	public static void incrementValueInBin(int i, int[] bins) {
		bins[i] = bins[i] + 1;
	}

	public static void printOutNicely(int[] bins) {
		StringBuilder b = new StringBuilder();
		for (int i = 0; i < bins.length; i++) {
			b.append(bins[i]);
			b.append(", ");
		}
		System.out.println(b.toString());
	}
}
