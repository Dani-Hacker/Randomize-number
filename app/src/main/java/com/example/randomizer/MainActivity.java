package com.example.randomizer;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button randomize;
    private TextView output;
    private SeekBar progress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setup();
        randomize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 output.setText(Integer.toString(random(progress.getProgress())));
            }
        });
        progress.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                //Toast.makeText(getApplicationContext(),"seekbar progress: "+i, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //Toast.makeText(getApplicationContext(),"seekbar touch started!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this, "Progress is " + seekBar.getProgress() , Toast.LENGTH_SHORT).show();

            }
        });
    }
    private void setup()
    {
        randomize=(Button) findViewById(R.id.random_button);
        output=(TextView) findViewById(R.id.result);
        progress=(SeekBar) findViewById(R.id.progressor);
    }
    private static int random(int x)
    {
        Random r=new Random();
        int low=0;
        int high=x+1;
        int print=r.nextInt(high);
        return print;
    }
}