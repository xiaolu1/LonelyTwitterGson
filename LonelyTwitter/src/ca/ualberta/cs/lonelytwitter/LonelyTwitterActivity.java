package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import ca.ualberta.cs.lonelytwitter.data.FileDataManager;
import ca.ualberta.cs.lonelytwitter.data.GsonFileDataManager;
import ca.ualberta.cs.lonelytwitter.data.IDataManager;

public class LonelyTwitterActivity extends Activity {

	private IDataManager dataManager,summaryManager;

	private EditText bodyText;

	private ListView oldTweetsList;

	private ArrayList<Tweet> tweets;

	private ArrayAdapter<Tweet> tweetsViewAdapter;
	
	private int nTweet, laTweet, leTweet;
	
	private ArrayList<Tweet> theSummary;
	
	

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.main);

		dataManager = new GsonFileDataManager(this);
		summaryManager = new FileDataManager(this);
		bodyText = (EditText) findViewById(R.id.body);
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);
	}

	@Override
	protected void onStart() {
		super.onStart();

		tweets = dataManager.loadTweets();
		theSummary=summaryManager.loadTweets();
		nTweet=theSummary.get(0).getTweetSummary();
		tweetsViewAdapter = new ArrayAdapter<Tweet>(this,
				R.layout.list_item, tweets);
		oldTweetsList.setAdapter(tweetsViewAdapter);
	}

	public void save(View v) {
		String text = bodyText.getText().toString();

		Tweet tweet = new Tweet(new Date(), text,0);
		Date date1=tweet.getTweetDate();
		//Date date2=tweets.get(-1).getTweetDate();
		tweets.add(tweet);

		tweetsViewAdapter.notifyDataSetChanged();
		
		theSummary.clear();
		nTweet+=1;
		Tweet num= new Tweet(new Date(),"", nTweet);
		theSummary.add(num);
		leTweet+=text.length();
		Tweet num1= new Tweet(new Date(),"", leTweet);
		theSummary.add(num1);
		//long a=new Date()l
		//laTweet+=date1.getDate()-date2.getDate();
		bodyText.setText("");
		dataManager.saveTweets(tweets);

		summaryManager.saveTweets(theSummary);

	}

	public void clear(View v) {
		theSummary.clear();
		nTweet=0;
		Tweet num= new Tweet(new Date(),"", nTweet);
		theSummary.add(num);
		leTweet=0;
		Tweet num1= new Tweet(new Date(),"", leTweet);
		theSummary.add(num1);
		laTweet=0;
		Tweet num2= new Tweet(new Date(),"", leTweet);
		theSummary.add(num2);
		summaryManager.saveTweets(theSummary);
		tweets.clear();
		tweetsViewAdapter.notifyDataSetChanged();
		dataManager.saveTweets(tweets);
	}
	public void summary(View v) {
		
		Intent intent = new Intent(LonelyTwitterActivity.this, Summary.class);
		LonelyTwitterActivity.this.startActivity(intent);
	}

}