package com.example.acer.npkonwerter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StronaGlowna extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_strona_glowna);

        final Button bLukasiewicza = (Button) findViewById(R.id.bLukasiewicza);
        final Button bNawiasowa = (Button) findViewById(R.id.bNawiasowa);
        final Button bLogicznaLukasiewicza = (Button) findViewById(R.id.bLogicznaLukasiewicza);
        final Button bLogicznaNawiasowa = (Button) findViewById(R.id.bLogicznaNawiasowa);

        bLukasiewicza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nawiasowaIntent = new Intent(StronaGlowna.this, TlumaczenieNawiasowej.class);
                StronaGlowna.this.startActivity(nawiasowaIntent);
            }
        });

        bNawiasowa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent lukasiewiczaIntent = new Intent(StronaGlowna.this, TlumaczenieLukasiewicza.class);
                StronaGlowna.this.startActivity(lukasiewiczaIntent);
            }
        });

        bLogicznaNawiasowa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent lukasiewiczalogikaIntent = new Intent(StronaGlowna.this, TlumaczenieLukasiewiczaLogika.class);
                StronaGlowna.this.startActivity(lukasiewiczalogikaIntent);
            }
        });

        bLogicznaLukasiewicza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nawiasowalogikaIntent = new Intent(StronaGlowna.this, TlumaczenieNawiasowejLogika.class);
                StronaGlowna.this.startActivity(nawiasowalogikaIntent);
            }
        });


    }


}
