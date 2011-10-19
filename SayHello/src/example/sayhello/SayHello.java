package example.sayhello;

import example.sayhello.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


/**
 * An activity returning a result
 */
public class SayHello extends Activity
{
        protected void onCreate(Bundle savedInstanceState)
    {
        // Call the parent class
        super.onCreate(savedInstanceState);

        // Put up the view for acquiring some input from the user
        setContentView(R.layout.main);

        // Set up the listeners for the buttons
        ((Button)findViewById(R.id.hello)).setOnClickListener(helloListener);
        ((Button)findViewById(R.id.goaway)).setOnClickListener(goAwayListener);
    }

    private OnClickListener helloListener = new OnClickListener()
    {
        public void onClick(View v)
        {
            returnResult("Hello, other Android!");
        }
    };

    private OnClickListener goAwayListener = new OnClickListener()
    {
        public void onClick(View v)
        {
                returnResult("Get off my lawn, damn kids!");
        }
    };

    // Put a result in an Intent object and set the result for this activity
    void returnResult(String greeting) {

    // Create the Intent object
    Intent i = new Intent();

    // Put an extra named "result" in the intent
    i.putExtra("result", greeting);

    // Make this Intent the result for this activity
    setResult(RESULT_OK, i);

    // End this activity
        finish();
    }
}