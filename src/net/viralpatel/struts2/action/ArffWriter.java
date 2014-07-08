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

	public static List<String> MOTS_DROLES;
	public static List<String> SMILEYS;
	public static List<String> ARGOT_TWITTER;
	public static List<String> PONCTUATION;


	public ArffWriter() {
	}


	private void init() {
		try {
			MOTS_DROLES = Files.readAllLines(
					Paths.get("/home/alexis/git/WebTweetDrole/input/listeMotsHumour.txt"),
					Charset.forName("UTF-8"));
			SMILEYS = Files.readAllLines(Paths.get("/home/alexis/git/WebTweetDrole/input/listeSmileys.txt"),
					Charset.forName("UTF-8"));
			ARGOT_TWITTER = Files.readAllLines(
					Paths.get("/home/alexis/git/WebTweetDrole/input/listeArgotTwitter.txt"),
					Charset.forName("UTF-8"));
			PONCTUATION = Files.readAllLines(
					Paths.get("/home/alexis/git/WebTweetDrole/input/listePonctuation.txt"),
					Charset.forName("UTF-8"));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public StringBuilder processListeTweets(Tweet t) {
		
		init();
		
		StringBuilder arffContent = new StringBuilder();

		// arffContent.append("@RELATION tweet\n\n");
		// arffContent.append("@ATTRIBUTE user {true,false}\n");
		// arffContent.append("@ATTRIBUTE word {true,false}\n");
		// arffContent.append("@ATTRIBUTE hashtag {true,false}\n");
		// arffContent.append("@ATTRIBUTE smiley {true,false}\n");
		// arffContent.append("@ATTRIBUTE argoInternet {true,false}\n");
		// arffContent
		// .append("@ATTRIBUTE ponctuation {absent, regulier, surnombre}\n");
		// arffContent.append("@ATTRIBUTE retweet {true,false}\n");
		// arffContent.append("@ATTRIBUTE nbRetweet NUMERIC\n");
		// arffContent.append("@ATTRIBUTE longeur NUMERIC\n");
		// arffContent.append("@ATTRIBUTE tweetDrole {true,false}\n\n");
		// arffContent.append("@DATA\n");

			processUserAttribute(arffContent, t);
			processWordAttribute(arffContent, t);
			processHashtagAttribute(arffContent, t);
			processSmileyAttribute(arffContent, t);
			processArgotAttribute(arffContent, t);
			processPonctuationAttribute(arffContent, t);
			processRetweetAttribute(arffContent, t);
			processNbRetweetAttribute(arffContent, t);
			processLongeurAttribute(arffContent, t);
			processTweetDroleAttribute(arffContent, t);


		return arffContent;
	}

	private void processLongeurAttribute(StringBuilder arffContent, Tweet t) {
		arffContent.append(t.getText().length()).append(",");
	}

	private void processNbRetweetAttribute(StringBuilder arffContent, Tweet t) {
		arffContent.append(t.getRetweetCount()).append(",");
	}

	private void processRetweetAttribute(StringBuilder arffContent, Tweet t) {
		arffContent.append(t.isRetweet() ? "true," : "false,");

	}

	private void processPonctuationAttribute(StringBuilder arffContent, Tweet t) {
		if (t.getText().contains("!")) {
			int count = 0;
			for (int i = 0; i < t.getText().length(); i++)
				if (t.getText().charAt(i) == ',')
					count++;
			if (count > 0 && count < 4) {
				arffContent.append("regulier,");
			} else {
				arffContent.append("surnombre,");
			}
		} else {
			arffContent.append("absent,");
		}

	}

	private void processArgotAttribute(StringBuilder arffContent, Tweet t) {
		boolean ok = false;

		for (String argot : ARGOT_TWITTER) {
			if (t.getText().toLowerCase().contains(argot))
				ok = true;
		}

		if (ok) {
			arffContent.append("true,");
		} else {
			arffContent.append("false,");
		}
	}

	private void processSmileyAttribute(StringBuilder arffContent, Tweet t) {
		boolean ok = false;

		for (String smile : SMILEYS) {
			if (t.getText().contains(smile))
				ok = true;
		}

		if (ok) {
			arffContent.append("true,");
		} else {
			arffContent.append("false,");
		}
	}

	private void processHashtagAttribute(StringBuilder arffContent, Tweet t) {
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

		if (ok) {
			arffContent.append("true,");
		} else {
			arffContent.append("false,");
		}
	}

	private void processWordAttribute(StringBuilder arffContent, Tweet t) {

		boolean ok = false;

		for (String smile : ARGOT_TWITTER) {
			if (t.getText().toLowerCase().contains(smile))
				ok = true;
		}
		for (String smile : MOTS_DROLES) {
			if (t.getText().toLowerCase().contains(smile))
				ok = true;
		}

		if (ok) {
			arffContent.append("true,");
		} else {
			arffContent.append("false,");
		}
	}

	private void processTweetDroleAttribute(StringBuilder arffContent, Tweet t) {
		arffContent.append("?");

	}

	private void processUserAttribute(StringBuilder arffContent, Tweet t) {

		boolean ok = false;

		for (String smile : MOTS_DROLES) {
			if (t.getUser().toLowerCase().contains(smile))
				ok = true;
		}
		for (String smile : ARGOT_TWITTER) {
			if (t.getUser().toLowerCase().contains(smile))
				ok = true;
		}
		for (String smile : SMILEYS) {
			if (t.getUser().contains(smile))
				ok = true;
		}

		if (ok) {
			arffContent.append("true,");
		} else {
			arffContent.append("false,");
		}
	}

}
