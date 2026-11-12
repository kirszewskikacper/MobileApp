package com.example.egzamin2;

import android.graphics.Color;
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

    Button pobierz;
    SeekBar r;
    SeekBar g;
    SeekBar b;
    TextView r_wartosc;
    TextView g_wartosc;
    TextView b_wartosc;
    TextView prostokat;
    TextView etykieta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        pobierz = findViewById(R.id.pobierz);
        r = findViewById(R.id.r);
        g = findViewById(R.id.g);
        b = findViewById(R.id.b);
        r_wartosc = findViewById(R.id.R_wartosc);
        g_wartosc = findViewById(R.id.G_wartosc);
        b_wartosc = findViewById(R.id.B_wartosc);
        prostokat = findViewById(R.id.prostokat);
        etykieta = findViewById(R.id.etykieta);

        pobierz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int czerwony = r.getProgress();
                int zielony = g.getProgress();
                int niebieski = b.getProgress();

                etykieta.setText(czerwony + ", " + zielony + ", " + niebieski);
                etykieta.setBackgroundColor(Color.rgb(czerwony, zielony, niebieski));
            }
        });

        r.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int czerwony = r.getProgress();
                int zielony = g.getProgress();
                int niebieski = b.getProgress();

                prostokat.setBackgroundColor(Color.rgb(czerwony, zielony, niebieski));
                r_wartosc.setText("" + czerwony);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        g.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int czerwony = r.getProgress();
                int zielony = g.getProgress();
                int niebieski = b.getProgress();

                prostokat.setBackgroundColor(Color.rgb(czerwony, zielony, niebieski));
                g_wartosc.setText("" + zielony);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        b.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int czerwony = r.getProgress();
                int zielony = g.getProgress();
                int niebieski = b.getProgress();

                prostokat.setBackgroundColor(Color.rgb(czerwony, zielony, niebieski));
                b_wartosc.setText("" + niebieski);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}