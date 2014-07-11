package net.viralpatel.struts2.action;

import java.util.ArrayList;
import java.util.List;

import weka.classifiers.bayes.NaiveBayes;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.SerializationHelper;
import weka.core.converters.ConverterUtils.DataSource;

public class WekaPredictor {
	public static String PATH_TO_MODEL_FILE = "/home/alexis/git/WebSJDD/input/outputModelCorpusTweetNB.model";

	public static List<double[]> classify() {

		List<double[]> retour = new ArrayList<double[]>();

		System.gc();

		NaiveBayes rf;
		try {
			rf = (NaiveBayes) SerializationHelper.read(PATH_TO_MODEL_FILE);

			DataSource source = new DataSource(
					"/home/alexis/git/WebSJDD/input/outputReaded.arff");
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

		} catch (Exception e) {
			e.printStackTrace();
		}

		return retour;

	}
}
