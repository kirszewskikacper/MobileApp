package com.example.zadanko;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button przycisk;
    TextView cytat;
    TextView rozmiar;
    SeekBar suwak;
    String[] cytaty = {"Dzień dobry", "Good morning", "Buenos dias"};
    public int licznik = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        przycisk = findViewById(R.id.przycisk);
        cytat = findViewById(R.id.cytat);
        rozmiar = findViewById(R.id.rozmiar);
        suwak = findViewById(R.id.suwak);




        suwak.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            @Override
            public void onProgressChanged(SeekBar suwak, int progres, boolean fromUser){
                cytat.setTextSize(progres);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        przycisk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(licznik == 3){
                    licznik = 0;
                }
                cytat.setText(cytaty[licznik]);
                licznik++;
            }
        });
    }
}