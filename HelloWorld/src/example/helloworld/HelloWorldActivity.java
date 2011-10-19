package example.helloworld;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class HelloWorldActivity extends Activity {
    TextView helloView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Make a text view and set it to be the content view
        helloView = new TextView(this);
        setContentView(helloView);

        // Make an Intent instance to fill in
        Intent helloIntent = new Intent();

        // Set the action, and type
        helloIntent.setAction("android.intent.action.PICK");
        helloIntent.setType("vnd.example.greeting/vnd.example.greeting-text");

        // Ask an activity that matches our Intent object
        startActivityForResult(helloIntent, 0);
    }

    @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent result) 
          {
        if (resultCode == RESULT_OK) {
                String greeting = result.getStringExtra("result");

            helloView.setText(greeting);
        }
    }
}