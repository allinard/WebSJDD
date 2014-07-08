package net.viralpatel.struts2.action;

import twitter4j.*;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * @author Alexis Linard
 * 
 */
public class GetTweet {

	private static final int MAXCAPTEDTWEETS = 300;

	private static List<Status> getTweet(String query) throws TwitterException{

		// Instance of twitter researcher
		Twitter twitter = new TwitterFactory().getInstance();

		// pour les @
		try {
			// First param of Paging() is the page number, second is the
			// number per page.
			Paging paging = new Paging(1, MAXCAPTEDTWEETS);
			return twitter.getUserTimeline(query, paging);
		}
		// si il s'agit de #
		catch (TwitterException e) {
			// The query for getting tweets
			Query q = new Query(query);

			// The result of the query
			QueryResult result;

			List<Status> tweets = new ArrayList<Status>();

			do {
				// the query is executed here
				result = twitter.search(q);

				// gets all the tweets from results
				tweets.addAll(result.getTweets());

			} while ((q = result.nextQuery()) != null);

			return tweets;
		}

	}

	private static List<Tweet> convertInTweet(List<Status> listeStatus) {
		List<Tweet> listeSortie = new ArrayList<Tweet>();

		for (Status s : listeStatus) {
			Tweet t = new Tweet();
			t.setUser(s.getUser().getScreenName());
			t.setText(s.getText());
			for (HashtagEntity h : s.getHashtagEntities()) {
				t.addHashtag(h.getText());
			}
			t.setRetweet(s.isRetweet());
			t.setRetweeted(s.isRetweeted());
			t.setRetweetCount(s.getRetweetCount());
			listeSortie.add(t);
		}

		return listeSortie;
	}
	
	
	public static List<Tweet> processGetTweet(String query) throws TwitterException
	{
		return convertInTweet(getTweet(query));
	}

}
