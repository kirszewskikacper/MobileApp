package zsk.edu.zadanko;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private TextView wartosc;
    private Button sprawdz_cene;
    private Button zatwierdz;
    private RadioButton pocztowka;
    private RadioButton list;
    private RadioButton paczka;
    private EditText ulica;
    private EditText kod;
    private EditText miasto;
    private ImageView zdjecie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        zdjecie = findViewById(R.id.zdjecie);
        wartosc = findViewById(R.id.wartosc);
        sprawdz_cene = findViewById(R.id.cena);
        zatwierdz = findViewById(R.id.zatwierdz);
        pocztowka = findViewById(R.id.pocztowka);
        list = findViewById(R.id.list);
        paczka = findViewById(R.id.paczka);
        ulica = findViewById(R.id.ulica);
        kod = findViewById(R.id.kod);
        miasto = findViewById(R.id.miasto);

        sprawdz_cene.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(pocztowka.isChecked()){
                    wartosc.setText("Cena: 1zł");
                    zdjecie.setImageResource(R.drawable.pocztowka);
                } else if(list.isChecked()){
                    wartosc.setText("Cena: 1.5zł");
                    zdjecie.setImageResource(R.drawable.list);
                } else if(paczka.isChecked()){
                    wartosc.setText("Cena: 10zł");
                    zdjecie.setImageResource(R.drawable.paczka);
        }}});

        zatwierdz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int wynik;
                try{
                    wynik = Integer.parseInt(kod.getText().toString().trim());
                    if(wynik < 100000 && wynik>9999){
                        //Toast.makeText(, "Dane przesyłki zostały wprowadzone", Toast.LENGTH_LONG).show();
                    }
                }
                catch(Exception e){

                }
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}