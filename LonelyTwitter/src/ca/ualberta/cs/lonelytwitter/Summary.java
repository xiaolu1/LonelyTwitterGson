package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;

import ca.ualberta.cs.lonelytwitter.data.FileDataManager;
import ca.ualberta.cs.lonelytwitter.data.IDataManager;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.TextView;


public class Summary extends Activity
{
	private IDataManager summaryManager;
	private ArrayList<Tweet> theSummary;
	private TextView numberTweet,latencyTweet,lengthTweet;


	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.summary);
		summaryManager = new FileDataManager(this);
		numberTweet=(TextView)findViewById(R.id.numberTweet);
		latencyTweet=(TextView)findViewById(R.id.latencyTweet);
		lengthTweet=(TextView)findViewById(R.id.lengthTweet);
	}
	protected void onStart() {
		super.onStart();
		theSummary=summaryManager.loadTweets();
		int i=0;
		i=theSummary.get(0).getTweetSummary();
		int j=theSummary.get(1).getTweetSummary()/i;
		String a="Number of tweets: "+i;
		String b="Average Latency of tweets: "+j;
		//String c="Average Length of tweets: ";
		//numberTweet.setText("sdfsa");
		numberTweet.setText(a);
		latencyTweet.setText(b);
	}
}
