package com.example.egzamin1;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button rzut;
    Button reset;
    ImageView kosc1;
    ImageView kosc2;
    ImageView kosc3;
    ImageView kosc4;
    ImageView kosc5;
    TextView wynik_gry;
    TextView wynik_losowania;

    int wynik_ostateczny = 0;

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

        rzut = findViewById(R.id.Rzut);
        reset = findViewById(R.id.reset);
        kosc1 = findViewById(R.id.kosc1);
        kosc2 = findViewById(R.id.kosc2);
        kosc3 = findViewById(R.id.kosc3);
        kosc4 = findViewById(R.id.kosc4);
        kosc5 = findViewById(R.id.kosc5);
        wynik_gry = findViewById(R.id.wynik_gry);
        wynik_losowania = findViewById(R.id.wynik_losowania);

        rzut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int tablicaKosci[] = {(int)(Math.random()*6+1),(int)(Math.random()*6+1),(int)(Math.random()*5+1),(int)(Math.random()*5+1),(int)(Math.random()*5+1)};

                int iloscWynikow[] = {0,0,0,0,0,0};

                int wynik = 0;


                //ustawianie obrazków
                switch (tablicaKosci[0]){
                    case 1:
                        kosc1.setImageResource(R.drawable.k1);
                        break;
                    case 2:
                        kosc1.setImageResource(R.drawable.k2);
                        break;
                    case 3:
                        kosc1.setImageResource(R.drawable.k3);
                        break;
                    case 4:
                        kosc1.setImageResource(R.drawable.k4);
                        break;
                    case 5:
                        kosc1.setImageResource(R.drawable.k5);
                        break;
                    case 6:
                        kosc1.setImageResource(R.drawable.k6);
                        break;
                }

                switch (tablicaKosci[1]){
                    case 1:
                        kosc2.setImageResource(R.drawable.k1);
                        break;
                    case 2:
                        kosc2.setImageResource(R.drawable.k2);
                        break;
                    case 3:
                        kosc2.setImageResource(R.drawable.k3);
                        break;
                    case 4:
                        kosc2.setImageResource(R.drawable.k4);
                        break;
                    case 5:
                        kosc2.setImageResource(R.drawable.k5);
                        break;
                    case 6:
                        kosc2.setImageResource(R.drawable.k6);
                        break;
                }

                switch (tablicaKosci[2]){
                    case 1:
                        kosc3.setImageResource(R.drawable.k1);
                        break;
                    case 2:
                        kosc3.setImageResource(R.drawable.k2);
                        break;
                    case 3:
                        kosc3.setImageResource(R.drawable.k3);
                        break;
                    case 4:
                        kosc3.setImageResource(R.drawable.k4);
                        break;
                    case 5:
                        kosc3.setImageResource(R.drawable.k5);
                        break;
                    case 6:
                        kosc3.setImageResource(R.drawable.k6);
                        break;
                }

                switch (tablicaKosci[3]){
                    case 1:
                        kosc4.setImageResource(R.drawable.k1);
                        break;
                    case 2:
                        kosc4.setImageResource(R.drawable.k2);
                        break;
                    case 3:
                        kosc4.setImageResource(R.drawable.k3);
                        break;
                    case 4:
                        kosc4.setImageResource(R.drawable.k4);
                        break;
                    case 5:
                        kosc4.setImageResource(R.drawable.k5);
                        break;
                    case 6:
                        kosc4.setImageResource(R.drawable.k6);
                        break;
                }

                switch (tablicaKosci[4]){
                    case 1:
                        kosc5.setImageResource(R.drawable.k1);
                        break;
                    case 2:
                        kosc5.setImageResource(R.drawable.k2);
                        break;
                    case 3:
                        kosc5.setImageResource(R.drawable.k3);
                        break;
                    case 4:
                        kosc5.setImageResource(R.drawable.k4);
                        break;
                    case 5:
                        kosc5.setImageResource(R.drawable.k5);
                        break;
                    case 6:
                        kosc5.setImageResource(R.drawable.k6);
                        break;
                }


                for(int i = 0; i< tablicaKosci.length; i++){
                    switch (tablicaKosci[i]){
                        case 1:
                            iloscWynikow[0]+=1;
                            break;
                        case 2:
                            iloscWynikow[1]+=1;
                            break;
                        case 3:
                            iloscWynikow[2]+=1;
                            break;
                        case 4:
                            iloscWynikow[3]+=1;
                            break;
                        case 5:
                            iloscWynikow[4]+=1;
                            break;
                        case 6:
                            iloscWynikow[5]+=1;
                            break;
                    }
                }
                for(int i = 0; i< iloscWynikow.length; i++){
                    if(iloscWynikow[i]>1){
                        wynik = wynik + iloscWynikow[i] * (i+1);
                    }
                }
                wynik_ostateczny += wynik;

                wynik_losowania.setText("Wynik tego losowania: " + wynik);

                wynik_gry.setText("Wynik gry: " + wynik_ostateczny);
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kosc1.setImageResource(R.drawable.question);
                kosc2.setImageResource(R.drawable.question);
                kosc3.setImageResource(R.drawable.question);
                kosc4.setImageResource(R.drawable.question);
                kosc5.setImageResource(R.drawable.question);

                wynik_ostateczny = 0;
                wynik_losowania.setText("Wynik tego losowania: 0");
                wynik_gry.setText("Wynik gry: 0");
            }
        });

    }
}
