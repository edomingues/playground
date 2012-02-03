package edomingues.twitter;

import java.io.IOException;

import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;
import twitter4j.TwitterException;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;


/**
 * Hello world!
 *
 */
public class App 
{
	public static void main(String[] args) throws TwitterException, IOException{
	    StatusListener listener = new StatusListener(){

			public void onException(Exception e) {
				e.printStackTrace();				
			}

			public void onDeletionNotice(StatusDeletionNotice arg0) {}

			public void onScrubGeo(long arg0, long arg1) {}

			public void onStatus(Status status) {
				System.out.println(status.getUser().getName() + " : " + status.getText());
			}

			public void onTrackLimitationNotice(int arg0) {}
	    };
	    TwitterStream twitterStream = new TwitterStreamFactory().getInstance();
	    twitterStream.addListener(listener);
	    twitterStream.sample();
	}
}
