package net.viralpatel.struts2.action;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ArffWriter {

	public static void writeCrisisDAsma(String processArffLineCrisisDAsma) {
		try {

			File file = new File(
					"/home/alexis/git/WebSJDD/input/outputCrisisDAsma.arff");
			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);

			// Encabezado
			List<String> listaCampos = Files
					.readAllLines(
							Paths.get("/home/alexis/git/WebSJDD/input/encabezadoCrisisDAsma.arff"),
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

			File file = new File(
					"/home/alexis/git/WebSJDD/input/outputSimptomesIntercrisisAsma.arff");
			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);

			// Encabezado
			List<String> listaCampos = Files
					.readAllLines(
							Paths.get("/home/alexis/git/WebSJDD/input/encabezadoSimptomesIntercrisisAsma.arff"),
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

			File file = new File(
					"/home/alexis/git/WebSJDD/input/outputTotesUrgencies.arff");
			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);

			// Encabezado
			List<String> listaCampos = Files
					.readAllLines(
							Paths.get("/home/alexis/git/WebSJDD/input/encabezadoTotesUrgencies.arff"),
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
