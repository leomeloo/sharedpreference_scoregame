package com.example.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView resultado;
    Button somar, subtrair;

    int x = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultado = findViewById(R.id.resultado);
        somar = findViewById(R.id.btsomar);
        subtrair = findViewById(R.id.btsubtrair);

        //Carregar o SharedPreference
        SharedPreferences prefs = this.getSharedPreferences("SALVANDO PONTOS", MODE_PRIVATE);
        x = prefs.getInt("pontos", 0);
        resultado.setText("Pontos:" + x);

        somar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                x += 50;

                resultado.setText("Pontos: " + x);

                //Salvar valor de X no sharedpreference
                SharedPreferences prefs = getSharedPreferences("SALVANDO PONTOS", MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putInt("pontos", x);
                editor.apply();
            }
        });

        subtrair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                x -= 50;
                resultado.setText("Pontos: " + x);

                //Salvar valor de X no sharedpreference
                SharedPreferences prefs = getSharedPreferences("SALVANDO PONTOS", MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putInt("pontos", x);
                editor.apply();
            }
        });


    }
}
