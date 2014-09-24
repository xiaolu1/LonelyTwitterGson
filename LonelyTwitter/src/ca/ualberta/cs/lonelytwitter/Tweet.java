package ca.ualberta.cs.lonelytwitter;

import java.io.Serializable;
import java.util.Date;

public class Tweet implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Date tweetDate;
	private String tweetBody;
	private int summaryTweet;
	
	public Tweet() {
		super();
	}

	public Tweet(Date tweetDate, String tweetBody,int summaryTweet) {
		this.tweetDate = tweetDate;
		this.tweetBody = tweetBody;
		this.summaryTweet=summaryTweet;
	}

	public Date getTweetDate() {
		return tweetDate;
	}
	public int getTweetSummary() {
		return summaryTweet;
	}
	public void setTweetDate(Date tweetDate) {
		this.tweetDate = tweetDate;
	}

	public String getTweetBody() {
		return tweetBody;
	}

	public void setTweetBody(String tweetBody) {
		this.tweetBody = tweetBody;
	}

	@Override
	public String toString() {
		return tweetDate + " | " + tweetBody;
	}
}
