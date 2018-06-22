package com.example.acer.npkonwerter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TlumaczenieLukasiewiczaLogika extends AppCompatActivity {

    //tworze ciag pomocniczy, ktory bedzie przechowywal ciag cyfr, dopoki nie pojawi sie znak
    String tmp = new String();

    //tworze stos
    final Stack stos = new Stack();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tlumaczenie_lukasiewicza_logika);

        final Button bPowrot = (Button) findViewById(R.id.bPowrot);
        final Button bP = (Button) findViewById(R.id.bP);
        final Button bQ = (Button) findViewById(R.id.bQ);
        final Button bR = (Button) findViewById(R.id.bR);
        final Button bS = (Button) findViewById(R.id.bS);
        final Button bT = (Button) findViewById(R.id.bT);


        final Button bGotowe = (Button) findViewById(R.id.bGotowe);
        final EditText etDzialanie = (EditText) findViewById(R.id.etDzialanie);
        final EditText etWynik = (EditText) findViewById(R.id.etWynik);
        final Button bPonow = (Button) findViewById(R.id.bPonow);
        final Button bNegacja = (Button) findViewById(R.id.bNegacja);
        final Button bKoniunkcja = (Button) findViewById(R.id.bKoniunkcja);
        final Button bAlternatywa = (Button) findViewById(R.id.bAlternatywa);
        final Button bImplikacja = (Button) findViewById(R.id.bImplikacja);
        final Button bRownowaznosc = (Button) findViewById(R.id.bRownowaznosc);

        bPowrot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent powrotIntent = new Intent(TlumaczenieLukasiewiczaLogika.this, StronaGlowna.class);
                TlumaczenieLukasiewiczaLogika.this.startActivity(powrotIntent);
            }
        });
        bP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etDzialanie.setText(etDzialanie.getText() + bP.getText().toString());
                stos.push(bP.getText().toString());
            }
        });
        bQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etDzialanie.setText(etDzialanie.getText() + bQ.getText().toString());
                stos.push(bQ.getText().toString());
            }
        });
        bR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etDzialanie.setText(etDzialanie.getText() + bR.getText().toString());
                stos.push(bR.getText().toString());
            }
        });
        bS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etDzialanie.setText(etDzialanie.getText() + bS.getText().toString());
                stos.push(bS.getText().toString());
            }
        });
        bT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etDzialanie.setText(etDzialanie.getText() + bT.getText().toString());
                stos.push(bT.getText().toString());
            }
        });


        bNegacja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etDzialanie.setText(etDzialanie.getText().toString() + bNegacja.getText());
                stos.push(bNegacja.getText().toString());
            }
        });
        bAlternatywa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etDzialanie.setText(etDzialanie.getText().toString() + bAlternatywa.getText());
                stos.push(bAlternatywa.getText().toString());
            }
        });
        bKoniunkcja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etDzialanie.setText(etDzialanie.getText().toString() + bKoniunkcja.getText());
                stos.push(bKoniunkcja.getText().toString());
            }
        });
        bImplikacja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etDzialanie.setText(etDzialanie.getText().toString() + bImplikacja.getText());
                stos.push(bImplikacja.getText().toString());
            }
        });
        bRownowaznosc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etDzialanie.setText(etDzialanie.getText().toString() + bRownowaznosc.getText());
                stos.push(bRownowaznosc.getText().toString());
            }
        });
        bPonow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etDzialanie.setText("");
                etWynik.setText("");
                stos.clear();
            }
        });
        bGotowe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Stack stos2 = new Stack();


                //SPRAWDZANIE BLEDOW: jesli stos jest pusty, to uzytkownik nie wpisal dzialania
                if (stos.isEmpty()){
                    Toast.makeText(TlumaczenieLukasiewiczaLogika.this, "Nie wpisano działania.", Toast.LENGTH_SHORT).show();
                    bPonow.performClick();
                    return;
                }

                //SPRAWDZANIE BLEDOW: jesli na stosie jest wiecej niz 30 elementow, to program nie przewiduje wykoywania dzialania
                if(stos.size()>=30){
                    Toast.makeText(TlumaczenieLukasiewiczaLogika.this, "Wpisano za duzo znakow. " +
                            "To dzialanie nie zostanie juz przetlumaczone. Wpisz je ponownie", Toast.LENGTH_LONG).show();
                    bPonow.performClick();
                    return;
                }

                //SPRAWDZANIE BLEDOW:
                //sprawdzanie ilosci operatorow
                int liczbaOperatorow=stos.numberOfOperators();
                int liczbaNegacji = stos.numberOfNegation();
                if(2*liczbaOperatorow+liczbaNegacji<stos.size()-1 || stos.size()<2){
                    Toast.makeText(TlumaczenieLukasiewiczaLogika.this, "Za malo operatorow. Wpisz poprawione dzialanie", Toast.LENGTH_SHORT).show();
                    bPonow.performClick();
                    return;
                }
                if(2*liczbaOperatorow+liczbaNegacji>stos.size()-1){
                    Toast.makeText(TlumaczenieLukasiewiczaLogika.this, "Za duzo operatorow. Wpisz poprawione dzialanie", Toast.LENGTH_SHORT).show();
                    bPonow.performClick();
                    return;
                }

                //ALGORYTM KONWERSJI
                //odczytywanie kolejno elementow stosu, po napotkaniu spojnika pobieranie dwoch ostatnich zdan
                //ze stosu i wpisywanie ich na stos2
                while(!stos.isEmpty()){

                    if(bNegacja.getText().toString().equals(stos.top().key)){
                        //SPRAWDZANIE BLEDOW: jesli napotkamy znak negacji, a stos jest pusty, to komunikat
                        if(stos2.top()==null) {
                            Toast.makeText(TlumaczenieLukasiewiczaLogika.this, "Po znaku negacji musi występować zdanie logiczne. " +
                                    "Ponow wpisywanie dzialania", Toast.LENGTH_SHORT).show();
                            bPonow.performClick();
                            return;
                        }
                        stos2.push("~"+stos2.top().key);
                    }
                    //gdy pojawi sie spojnik, to od rau laczymy go z dwoma elementami stosu2
                    else if(stos.top().isLetter()){// && stos.size()>1){
                        if (stos2.size() < 2) {
                            Toast.makeText(TlumaczenieLukasiewiczaLogika.this, "Spojnik " +stos.top().key+
                                    " nie ma dwóch zdan do polaczenia. Ponow wpisywanie dzialania, sprawdzajac " +
                                    "czy wszystkie znaki sa na wlasciwym miejscu", Toast.LENGTH_SHORT).show();
                            bPonow.performClick();
                            return;
                        }
                        tmp="("+stos2.top().key+stos.top().convertToSign();
                        stos2.pop();
                        tmp=tmp+stos2.top().key+")";
                        stos2.pop();
                        stos2.push(tmp);
                    }
                    else{
                        stos2.push(stos.top().key);
                    }
                    stos.pop();
                }

                etWynik.setText(stos2.top().key);
            }
        });

    }
}
