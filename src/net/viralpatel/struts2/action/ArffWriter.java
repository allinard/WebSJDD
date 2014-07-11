package net.viralpatel.struts2.action;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ArffWriter {

	public static void write(String t) {

		try {

			File file = new File(
					"/home/alexis/git/WebSJDD/input/outputReaded.arff");
			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(t);
			bw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
