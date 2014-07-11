package net.viralpatel.struts2.action;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ArffWriter {

	public static void write(String t) {

		try {

			File file = new File(
					"/home/alexis/git/WebTweetDrole/input/outputReaded.arff");
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
