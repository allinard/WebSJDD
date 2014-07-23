package com.example.asmaprediccio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import com.example.asmaprediccio.utils.Constants;

import weka.classifiers.Classifier;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

public class WekaPredictor {

	public static List<double[]> classify() {

		List<double[]> retour = new ArrayList<double[]>();

		System.gc();

		try {
			predictorTotesUrgencies(retour);
			predictorSimtomesIntercrisisAsma(retour);
			predictorCrisisAsma(retour);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return retour;

	}

	private static void predictorCrisisAsma(List<double[]> retour)
			throws IOException, FileNotFoundException, ClassNotFoundException,
			Exception {
		// deserialize model
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
				Constants.PATH_TO_MODEL_CRISIS_ASMA_FILE));
		Classifier rf = (Classifier) ois.readObject();
		ois.close();

		// reading instances to classify
		DataSource source = new DataSource(Constants.OUTPUT_CRISIS_D_ASMA_ARFF);
		Instances data = source.getDataSet();

		// setting class attribute if the data format does not provide this
		// information
		// For example, the XRFF format saves the class attribute
		// information as
		// well
		if (data.classIndex() == -1)
			data.setClassIndex(data.numAttributes() - 1);

		Instance inst;
		for (int i = 0; i < data.numInstances(); i++) {
			inst = data.instance(i);
			retour.add(rf.distributionForInstance(inst));
		}

	}

	private static void predictorSimtomesIntercrisisAsma(List<double[]> retour)
			throws IOException, FileNotFoundException, ClassNotFoundException,
			Exception {
		// deserialize model
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
				Constants.PATH_TO_MODEL_SIMPTOMES_INTERCRISIS_ASMA_FILE));
		Classifier rf = (Classifier) ois.readObject();
		ois.close();

		// reading instances to classify
		DataSource source = new DataSource(
				Constants.OUTPUT_SIMPTOMES_INTERCRISIS_ASMA_ARFF);
		Instances data = source.getDataSet();

		// setting class attribute if the data format does not provide this
		// information
		// For example, the XRFF format saves the class attribute
		// information as
		// well
		if (data.classIndex() == -1)
			data.setClassIndex(data.numAttributes() - 1);

		Instance inst;
		for (int i = 0; i < data.numInstances(); i++) {
			inst = data.instance(i);
			retour.add(rf.distributionForInstance(inst));
		}

	}

	private static void predictorTotesUrgencies(List<double[]> retour)
			throws IOException, FileNotFoundException, ClassNotFoundException,
			Exception {
		// deserialize model
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
				Constants.PATH_TO_MODEL_TOTES_URGENCIES_FILE));
		Classifier rf = (Classifier) ois.readObject();
		ois.close();

		// reading instances to classify
		DataSource source = new DataSource(Constants.OUTPUT_TOTES_URGENCIES_ARFF);
		Instances data = source.getDataSet();

		// setting class attribute if the data format does not provide this
		// information
		// For example, the XRFF format saves the class attribute
		// information as
		// well
		if (data.classIndex() == -1)
			data.setClassIndex(data.numAttributes() - 1);

		Instance inst;
		for (int i = 0; i < data.numInstances(); i++) {
			inst = data.instance(i);
			retour.add(rf.distributionForInstance(inst));
		}
	}
}
