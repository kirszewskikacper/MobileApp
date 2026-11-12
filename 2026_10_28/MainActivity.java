package com.example.egzamin;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private TextView zaszyforawnie;
    private EditText tekst;
    private EditText klucz;
    private Button zaszyfruj;
    private Button zapisz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        zaszyforawnie = findViewById(R.id.zaszyforwane);
        tekst = findViewById(R.id.tekst);
        klucz = findViewById(R.id.klucz);
        zaszyfruj = findViewById(R.id.zaszyfruj);
        zapisz = findViewById(R.id.zapisz);

        zaszyfruj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String wynik = "";
                String[] alfabet = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
                int kluczyk;
                try{
                    kluczyk = Integer.parseInt(klucz.getText().toString().trim());
                }
                catch(NumberFormatException e){
                    kluczyk = 0;
                }
                String przed_szyfrem = tekst.getText().toString();
                for(int i =0; i< przed_szyfrem.length(); i++){
                    String litera = String.valueOf(przed_szyfrem.charAt(i));
                    int pozycja = 0;
                    for(int j = 0; j < 26; j++){
                        if(litera.equals(alfabet[j])) {
                            pozycja = j;
                            break;
                        }
                    }
                    pozycja+=kluczyk;
                    while(pozycja < 0 || pozycja > 26){
                    if(pozycja < 0){
                        pozycja +=26;
                    }
                    else{
                        pozycja -=26;
                    }}
                    wynik += alfabet[pozycja];
                }

                zaszyforawnie.setText(wynik);
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}