package com.example.asmaprediccio;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.example.asmaprediccio.utils.Constants;

public class ArffWriter {

	public static void writeCrisisDAsma(String processArffLineCrisisDAsma) {
		try {

			File file = new File(Constants.OUTPUT_CRISIS_D_ASMA_ARFF);
			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);

			// Encabezado
			List<String> listaCampos = Files
					.readAllLines(
							Paths.get(Constants.ENCABEZADO_CRISIS_D_ASMA_ARFF),
							Charset.forName("UTF-8"));
			for (String s : listaCampos) {
				bw.write(s);
				bw.write("\n");
			}

			bw.write(processArffLineCrisisDAsma);

			bw.write("\n");

			bw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void writeSimptomesIntercrisisAsma(
			String processArffLineSimptomesIntercrisisAsma) {
		try {

			File file = new File(Constants.OUTPUT_SIMPTOMES_INTERCRISIS_ASMA_ARFF);
			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);

			// Encabezado
			List<String> listaCampos = Files
					.readAllLines(
							Paths.get(Constants.ENCABEZADO_SIMPTOMES_INTERCRISIS_ASMA_ARFF),
							Charset.forName("UTF-8"));
			for (String s : listaCampos) {
				bw.write(s);
				bw.write("\n");
			}

			bw.write(processArffLineSimptomesIntercrisisAsma);

			bw.write("\n");

			bw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void writeTotesUrgencies(String processArffLineTotesUrgencies) {
		try {

			File file = new File(Constants.OUTPUT_TOTES_URGENCIES_ARFF);
			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);

			// Encabezado
			List<String> listaCampos = Files
					.readAllLines(
							Paths.get(Constants.ENCABEZADO_TOTES_URGENCIES_ARFF),
							Charset.forName("UTF-8"));
			for (String s : listaCampos) {
				bw.write(s);
				bw.write("\n");
			}

			bw.write(processArffLineTotesUrgencies);

			bw.write("\n");

			bw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
