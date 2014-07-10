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

	public static List<String> MOTS_DROLES;
	public static List<String> SMILEYS;
	public static List<String> SMILEYSCONTENT;
	public static List<String> SMILEYSPASCONTENT;
	public static List<String> ARGOT_TWITTER;
	public static List<String> PONCTUATION;
	public static List<String> ATTRIBUTS;
	public static List<String> ATTRIBUTS_FILE;
	public static int NOMBREATTRIBUTS;

	public ArffWriter() {
	}

	private void init() {
		try {
			MOTS_DROLES = Files
					.readAllLines(
							Paths.get("/home/alexis/git/WebTweetDrole/input/listeMotsHumour.txt"),
							Charset.forName("UTF-8"));
			SMILEYS = Files
					.readAllLines(
							Paths.get("/home/alexis/git/WebTweetDrole/input/listeSmileys.txt"),
							Charset.forName("UTF-8"));
			ARGOT_TWITTER = Files
					.readAllLines(
							Paths.get("/home/alexis/git/WebTweetDrole/input/listeArgotTwitter.txt"),
							Charset.forName("UTF-8"));
			PONCTUATION = Files
					.readAllLines(
							Paths.get("/home/alexis/git/WebTweetDrole/input/listePonctuation.txt"),
							Charset.forName("UTF-8"));
			ATTRIBUTS_FILE = Files
					.readAllLines(
							Paths.get("/home/alexis/git/WebTweetDrole/input/corpusTweetTest.arff"),
							Charset.forName("UTF-8"));
			SMILEYSCONTENT = Files
					.readAllLines(
							Paths.get("/home/alexis/git/WebTweetDrole/input/listeSmileysContents.txt"),
							Charset.forName("UTF-8"));
			SMILEYSPASCONTENT = Files
					.readAllLines(
							Paths.get("/home/alexis/git/WebTweetDrole/input/listeSmileysPasContents.txt"),
							Charset.forName("UTF-8"));

			ATTRIBUTS = new ArrayList<String>();
			for (String s : ATTRIBUTS_FILE) {
				if (s.contains("@ATTRIBUTE")) {
					String[] nomAttr = s.split(" ");
					ATTRIBUTS.add(nomAttr[1]);
				}
			}
			for (int i = 0; i <= 8; i++) {
				ATTRIBUTS.remove(ATTRIBUTS.size() - 1);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void processListeTweets(List<Tweet> t) throws IOException {

		init();

		String arffContent = "";

		List<String> temp = Files.readAllLines(Paths
				.get("/home/alexis/git/WebTweetDrole/input/outputTemp.arff"),
				Charset.forName("UTF-8"));

		for (String s : temp) {
			arffContent += s + "\n";
		}

		for (Tweet tweet : t) {
			NOMBREATTRIBUTS = 0;
			arffContent += "{";

			for (String attr : ATTRIBUTS) {
				if (tweet.getText().contains(attr)) {
					arffContent += NOMBREATTRIBUTS + " 1,";
				}
				NOMBREATTRIBUTS++;
			}

			arffContent += processHashtagAttribute(arffContent, tweet);
			arffContent += processSmileyPasContentAttribute(arffContent, tweet);
			arffContent += processSmileyContentAttribute(arffContent, tweet);
			arffContent += processPonctuationAttribute(arffContent, tweet);
			arffContent += processRetweetAttribute(arffContent, tweet);
			arffContent += processNbRetweetAttribute(arffContent, tweet);
			arffContent += processLongeurAttribute(arffContent, tweet);
			arffContent += processNbMotsAttribute(arffContent, tweet);
			arffContent += processDroleAttribute(arffContent, tweet);

		}

		File file = new File(
				"/home/alexis/git/WebTweetDrole/input/outputReaded.arff");
		// if file doesnt exists, then create it
		if (!file.exists()) {
			file.createNewFile();
		}
		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(arffContent);
		bw.close();

	}

	private String processNbMotsAttribute(String arffContent, Tweet t) {
		NOMBREATTRIBUTS++;
		String[] motsTexte = t.getText().split(" ");
		return NOMBREATTRIBUTS - 1 + " " + motsTexte.length + ",";
	}

	private String processLongeurAttribute(String arffContent, Tweet t) {
		NOMBREATTRIBUTS++;
		return NOMBREATTRIBUTS - 1 + " " + t.getText().length() + ",";
	}

	private String processNbRetweetAttribute(String arffContent, Tweet t) {
		NOMBREATTRIBUTS++;
		return NOMBREATTRIBUTS - 1 + " " + t.getRetweetCount() + ",";
	}

	private String processRetweetAttribute(String arffContent, Tweet t) {
		NOMBREATTRIBUTS++;
		return t.isRetweet() ? NOMBREATTRIBUTS - 1 + " \"true\","
				: NOMBREATTRIBUTS - 1 + " \"false\",";

	}

	private String processPonctuationAttribute(String arffContent, Tweet t) {
		NOMBREATTRIBUTS++;
		if (t.getText().contains("!")) {
			int count = 0;
			for (int i = 0; i < t.getText().length(); i++)
				if (t.getText().charAt(i) == ',')
					count++;
			if (count > 0 && count < 4) {
				return NOMBREATTRIBUTS - 1 + " \"regulier\",";
			} else {
				return NOMBREATTRIBUTS - 1 + " \"surnombre\",";
			}
		} else {
			return NOMBREATTRIBUTS - 1 + " \"absent\",";
		}

	}

	private String processSmileyContentAttribute(String arffContent, Tweet t) {
		boolean ok = false;

		for (String smile : SMILEYSCONTENT) {
			if (t.getText().contains(smile))
				ok = true;
		}
		NOMBREATTRIBUTS++;
		if (ok) {
			return NOMBREATTRIBUTS - 1 + " \"true\",";
		} else {
			return NOMBREATTRIBUTS - 1 + " \"false\",";
		}
	}

	private String processSmileyPasContentAttribute(String arffContent, Tweet t) {

		boolean ok = false;

		for (String smile : SMILEYSPASCONTENT) {
			if (t.getText().contains(smile))
				ok = true;
		}
		NOMBREATTRIBUTS++;
		if (ok) {
			return NOMBREATTRIBUTS - 1 + " \"true\",";
		} else {
			return NOMBREATTRIBUTS - 1 + " \"false\",";
		}
	}

	private String processHashtagAttribute(String arffContent, Tweet t) {
		boolean ok = false;
		for (String hashtag : t.getHashtags()) {
			for (String arg : ARGOT_TWITTER) {
				if (hashtag.contains(arg))
					ok = true;
			}
			for (String arg : MOTS_DROLES) {
				if (hashtag.contains(arg))
					ok = true;
			}
			for (String arg : SMILEYS) {
				if (hashtag.contains(arg))
					ok = true;
			}
		}
		NOMBREATTRIBUTS++;
		if (ok) {
			return NOMBREATTRIBUTS - 1 + " \"true\",";
		} else {
			return NOMBREATTRIBUTS - 1 + " \"false\",";
		}
	}

	private String processDroleAttribute(String arffContent, Tweet t) {
		return NOMBREATTRIBUTS + " ?}\n";
	}

}
