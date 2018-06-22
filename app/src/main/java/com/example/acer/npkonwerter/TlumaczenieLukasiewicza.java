package com.example.acer.npkonwerter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TlumaczenieLukasiewicza extends AppCompatActivity {

    //tworze ciag pomocniczy, ktory bedzie przechowywal ciag cyfr, dopoki nie pojawi sie znak
    String tmp = new String();

    //tworze stos
    final Stack stos = new Stack();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tlumaczenie_lukasiewicza);

        final Button bPowrot = (Button) findViewById(R.id.bPowrot);
        final Button b0 = (Button) findViewById(R.id.b0);
        final Button b1 = (Button) findViewById(R.id.b1);
        final Button b2 = (Button) findViewById(R.id.b2);
        final Button b3 = (Button) findViewById(R.id.b3);
        final Button b4 = (Button) findViewById(R.id.b4);
        final Button b5 = (Button) findViewById(R.id.b5);
        final Button b6 = (Button) findViewById(R.id.b6);
        final Button b7 = (Button) findViewById(R.id.b7);
        final Button b8 = (Button) findViewById(R.id.b8);
        final Button b9 = (Button) findViewById(R.id.b9);
        final Button bPlus = (Button) findViewById(R.id.bPlus);
        final Button bMinus = (Button) findViewById(R.id.bMinus);
        final Button bRazy = (Button) findViewById(R.id.bRazy);
        final Button bPodzielic = (Button) findViewById(R.id.bPodzielic);
        final Button bGotowe = (Button) findViewById(R.id.bGotowe);
        final EditText etDzialanie = (EditText) findViewById(R.id.etDzialanie);
        final EditText etWynik = (EditText) findViewById(R.id.etWynik);
        final Button bSpacja = (Button) findViewById(R.id.bSpacja);
        final Button bPonow = (Button) findViewById(R.id.bPonow);

        bPowrot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent powrotIntent = new Intent(TlumaczenieLukasiewicza.this, StronaGlowna.class);
                TlumaczenieLukasiewicza.this.startActivity(powrotIntent);
            }
        });

        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etDzialanie.setText(etDzialanie.getText().toString() + b0.getText());
                tmp = tmp + b0.getText().toString();
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etDzialanie.setText(etDzialanie.getText() + b1.getText().toString());
                tmp = tmp + b1.getText().toString();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etDzialanie.setText(etDzialanie.getText() + b2.getText().toString());
                tmp = tmp + b2.getText().toString();
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etDzialanie.setText(etDzialanie.getText() + b3.getText().toString());
                tmp = tmp + b3.getText().toString();
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etDzialanie.setText(etDzialanie.getText() + b4.getText().toString());
                tmp = tmp + b4.getText().toString();
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etDzialanie.setText(etDzialanie.getText() + b5.getText().toString());
                tmp = tmp + b5.getText().toString();
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etDzialanie.setText(etDzialanie.getText() + b6.getText().toString());
                tmp = tmp + b6.getText().toString();
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etDzialanie.setText(etDzialanie.getText() + b7.getText().toString());
                tmp = tmp + b7.getText().toString();
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etDzialanie.setText(etDzialanie.getText() + b8.getText().toString());
                tmp = tmp + b8.getText().toString();
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etDzialanie.setText(etDzialanie.getText() + b9.getText().toString());
                tmp = tmp + b9.getText().toString();
            }
        });
        bPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etDzialanie.setText(etDzialanie.getText() + bPlus.getText().toString());
                emptyTmp();
                stos.push(bPlus.getText().toString());
            }
        });
        bMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etDzialanie.setText(etDzialanie.getText() + bMinus.getText().toString());
                emptyTmp();
                stos.push(bMinus.getText().toString());
            }
        });
        bRazy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etDzialanie.setText(etDzialanie.getText() + bRazy.getText().toString());
                emptyTmp();
                stos.push(bRazy.getText().toString());
            }
        });
        bPodzielic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etDzialanie.setText(etDzialanie.getText() + bPodzielic.getText().toString());
                emptyTmp();
                stos.push(bPodzielic.getText().toString());
            }
        });

        bSpacja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etDzialanie.setText(etDzialanie.getText() + " ");
                emptyTmp();
                tmp = "";
            }
        });
        bPonow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etDzialanie.setText("");
                etWynik.setText("");
                stos.clear();
                tmp = "";
            }
        });
        bGotowe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                emptyTmp();

                //SPRAWDZANIE BLEDOW: jesli stos jest pusty, to uzytkownik nie wpisal dzialania
                if (stos.isEmpty()) {
                    Toast.makeText(TlumaczenieLukasiewicza.this, "Nie wpisano działania.", Toast.LENGTH_SHORT).show();
                    bPonow.performClick();
                    return;
                }
                //SPRAWDZANIE BLEDOW: jesli na stosie jest wiecej niz 30 elementow, to program nie przewiduje wykoywania dzialania
                if(stos.size()>=30){
                    Toast.makeText(TlumaczenieLukasiewicza.this, "Wpisano za duzo znakow. To dzialanie nie zostanie juz przetlumaczone. Wpisz je ponownie", Toast.LENGTH_LONG).show();
                    bPonow.performClick();
                    return;
                }

                //SPRAWDZANIE BLEDOW: jesli dzialanie zaczyna sie od liczby, to wyswietla komunikat
                if (stos.bottom().isNumber()) {
                    Toast.makeText(TlumaczenieLukasiewicza.this, "Dzialanie powinno zaczynac sie od znaku. To nie jest notacja polska", Toast.LENGTH_SHORT).show();
                    bPonow.performClick();
                    return;
                }

                //SPRAWDZANIE BLEDOW: sprawdzanie, czy nie podano za duzo lub za malo operatorow (operatory+1==liczby)
                int iloscLiczb = stos.numberOfNumbers();

                if (stos.size()+1 > iloscLiczb*2) {
                    Toast.makeText(TlumaczenieLukasiewicza.this, "Wpisano za duzo operatorow. Ponow wpisywanie dzialania.", Toast.LENGTH_SHORT).show();
                    bPonow.performClick();
                    return;
                }
                if (stos.size()+1 < iloscLiczb*2) {
                    Toast.makeText(TlumaczenieLukasiewicza.this, "Wpisano za malo operatorow. Ponow wpisywanie dzialania", Toast.LENGTH_SHORT).show();
                    bPonow.performClick();
                    return;
                }

                //ALGORYTM KONWERSJI
                //pobieranie kolejnych elementow stosu, wstawianie liczb na stos2, po znalezieniu znaku pobieranie szczytu stosu2,
                //ustawiaie szczytu stosu2 na szczyt2.start.next, laczenie ze znakiem, nowym szczytem stosu2 (kolejna zmiana szczytu)
                //i wstawianie z powrotem do stosu

                Stack stos2 = new Stack();
                String tmp = new String();

                while (!stos.isEmpty()) { //dopoki stos nie jest pusty
                    while (stos.top().isNumber()) {  //dopoki szczyt stosu jest liczba
                        stos2.push(stos.top().key); //przypisanie wartosci szczytu stosu do szczytu stosu2
                        stos.pop(); //zdjecie przepisanego elementu ze stosu
                    }
                    tmp = "(" + stos2.top().key + stos.top().key; //zapisanie wartosci szczytu stosu2 i znaku ze szczytu stosu do tmp
                    stos2.pop();    //zdjecie ze stosu2 elementu
                    stos.pop();     //zdjecie ze stosu elementu
                    tmp = tmp + stos2.top().key + ")";    //dopisanie nowego szczytu stosu2 do tmp
                    stos2.top().key = tmp;    //zapisanie wartosci tmp do szczytu stosu2
                    tmp = ""; //wyczyszczenie wartosci tmp
                }

                etWynik.setText(stos2.top().key.toString());
            }

        });
    }
    //oproznianie zmiennej tmp
    void emptyTmp() {
        if (tmp != null && !("").equals(tmp)) {
            stos.push(tmp);
            tmp = "";
        }
    }




}
