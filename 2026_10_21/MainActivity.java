package com.example.zadanko;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button przycisk;
    private ListView lista;
    private SeekBar suwak;
    private TextView lata;
    private String gatunek = "";
    private TextView dane;
    private TextView cel;
    private TextView czas;
    private TextView wynik;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        lista = findViewById(R.id.lista);
        przycisk = findViewById(R.id.przycisk);
        suwak = findViewById(R.id.suwak);
        lata = findViewById(R.id.lata);
        dane = findViewById(R.id.daneWlasciciela);
        cel = findViewById(R.id.cel);
        czas = findViewById(R.id.czas);
        wynik = findViewById(R.id.wynik);

        List<String> elemnty = Arrays.asList("Pies", "Kot", "Świnka Morska");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, elemnty);
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(((parent, view, position, id) -> {
            String element = elemnty.get(position);

            if (element.equals("Pies")) {
                suwak.setMax(18);
                gatunek = "Pies";
            } else if (element.equals("Kot")) {
                suwak.setMax(20);
                gatunek = "Kot";
            } else if (element.equals("Świnka Morska")) {
                suwak.setMax(9);
                gatunek = "Świnka Morska";
            }

            suwak.setProgress(0);
            lata.setText("0");
        }));

        suwak.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                lata.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        przycisk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String tekstWyniku = dane.getText().toString() + ", " + gatunek + ", " + lata.getText().toString() + ", " + cel.getText().toString() + ", " + czas.getText().toString();

                wynik.setText(tekstWyniku);
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
