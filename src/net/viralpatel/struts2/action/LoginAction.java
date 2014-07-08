package net.viralpatel.struts2.action;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import twitter4j.Status;
import twitter4j.TwitterException;
import weka.core.mathematicalexpression.sym;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
    private String username;
    private String password;
    private List<Tweet> listeTweets;
    private int totalTrue;
    private int totalFalse;
 
    public String execute() {
 
        if(!this.username.isEmpty())
        {
        	totalTrue = 0;
        	totalFalse = 0;
        	
        	try {
				listeTweets = GetTweet.processGetTweet(this.username);
			} catch (TwitterException e) {
				e.printStackTrace();
			}
        	
        	ArffWriter aW = new ArffWriter();
        	List<Tweet> listeTweets2 = new ArrayList<Tweet>();
        	listeTweets2.addAll(listeTweets);
        	
        	for(Tweet t : listeTweets2)
        	{
        		double i;
        		try {
       			i = WekaClassifier.classify(aW.processListeTweets(t).toString());
        			if(i==0)
        			{
        				totalTrue++;
        			}
        			else
        			{
        				listeTweets.remove(t);
        				totalFalse++;
        			}
				} catch (Exception e) {
					e.printStackTrace();
				}
        	}
       	
        	return "success";
        }
        else
        {
        	addActionError(getText("error.login"));
            return "error";
        }
    }
 
    public String getUsername() {
        return username;
    }
 
    public void setUsername(String username) {
        this.username = username;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }

	public List<Tweet> getListeTweets() {
		return listeTweets;
	}

	public void setListeTweets(List<Tweet> listeTweets) {
		this.listeTweets = listeTweets;
	}

	public int getTotalTrue() {
		return totalTrue;
	}

	public void setTotalTrue(int totalTrue) {
		this.totalTrue = totalTrue;
	}

	public int getTotalFalse() {
		return totalFalse;
	}

	public void setTotalFalse(int totalFalse) {
		this.totalFalse = totalFalse;
	}
    
 
}

