package helloworld.kimbriant.texts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView responseString;
    Button rotater;
    EditText textualEdit;
    TextView welcomeString;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        responseString = findViewById(R.id.response_string);
        rotater = findViewById(R.id.button);
        textualEdit = findViewById(R.id.name);
        welcomeString = findViewById(R.id.welcome);
        final String[] allStarWords = getResources().getStringArray(R.array.texts);
        final int length = allStarWords.length;

        rotater.setOnClickListener(new View.OnClickListener() {
            int index = 0;
            @Override
            public void onClick(View view) {
                String rotater = "rotater button";
                Log.v(rotater, Integer.toString(index) + " " + allStarWords[index]);
                index++;
                if(index >= length) { index = 0; }
                responseString.setText(allStarWords[index]);
            }
        });

        textualEdit.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean focus) {
                if(!focus) {
                    String current = textualEdit.getText().toString();
                    String awesomeWow = getString(R.string.nameStar, current);
                    welcomeString.setText(awesomeWow);
                }
            }
        });
    }
}
