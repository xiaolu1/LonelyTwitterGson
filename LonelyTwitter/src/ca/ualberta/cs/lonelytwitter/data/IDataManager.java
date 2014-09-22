package ca.ualberta.cs.lonelytwitter.data;

import java.util.ArrayList;
import java.util.List;

import ca.ualberta.cs.lonelytwitter.Tweet;

public interface IDataManager {
	
	public ArrayList<Tweet> loadTweets();
	
	public void saveTweets(List<Tweet> lts);

}
