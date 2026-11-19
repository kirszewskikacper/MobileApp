package com.example.zadanie;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Spinner lista;
    private EditText imie;
    private EditText nazwiko;
    private EditText ilosc_znakow;
    private CheckBox male_i_wielkie;
    private CheckBox cyfra;
    private CheckBox specjalne;
    private Button generuj;
    private Button zatwierdz;
    private String haslo = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        imie = findViewById(R.id.imie);
        nazwiko = findViewById(R.id.nazwisko);
        lista = findViewById(R.id.stan);
        ilosc_znakow = findViewById(R.id.ilosc_znakow);
        male_i_wielkie = findViewById(R.id.male_i_wielkie);
        cyfra = findViewById(R.id.cyfry);
        specjalne = findViewById(R.id.znaki_specjalne);
        generuj = findViewById(R.id.generowanie);
        zatwierdz = findViewById(R.id.zatwierdz);


        generuj.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Random random = new Random();

                haslo = "";

                String cyfry = "0123456789";
                String male = "qwertyuioplkjhgfdsazxcvbnm";
                String duze = "QWERTYUIOPLKJHGFDSAZXCVBNM";
                String specjalnie = "!@#$%^&*()_+-=";

                for(int i = 0; i<Integer.parseInt(ilosc_znakow.getText().toString());i++){
                    if (cyfra.isChecked() && i ==0){
                        haslo += cyfry.charAt(random.nextInt(cyfry.length()));
                    }
                    else if(male_i_wielkie.isChecked() && i ==1){
                        haslo += duze.charAt(random.nextInt(duze.length()));
                    }
                    else if(specjalne.isChecked() && i == 2){
                        haslo += specjalnie.charAt(random.nextInt(specjalnie.length()));
                    }
                    else{
                        haslo += male.charAt(random.nextInt(male.length()));
                    }


                }

                Toast.makeText(MainActivity.this, haslo, Toast.LENGTH_LONG).show();
            }
        });

        String[] elementy_listy = {"Kierownik", "Starszy programista", "Młodszy programista", "Tester"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, elementy_listy);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        lista.setAdapter(adapter);

        zatwierdz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String imi = imie.getText().toString().trim();
                String nazw = nazwiko.getText().toString().trim();
                String stan = lista.getSelectedItem().toString();
                Toast.makeText(MainActivity.this, "Dane pracownika: " + imi + " " + nazw + " " + stan + " Hasło:" + haslo, Toast.LENGTH_LONG).show();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}