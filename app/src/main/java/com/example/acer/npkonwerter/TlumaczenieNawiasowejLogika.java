package com.example.acer.npkonwerter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TlumaczenieNawiasowejLogika extends AppCompatActivity {
    Stack stos = new Stack();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tlumaczenie_nawiasowej_logika);

        final Button bPowrot = (Button) findViewById(R.id.bPowrot);
        final Button bP = (Button) findViewById(R.id.bP);
        final Button bQ = (Button) findViewById(R.id.bQ);
        final Button bR = (Button) findViewById(R.id.bR);
        final Button bS = (Button) findViewById(R.id.bS);
        final Button bT = (Button) findViewById(R.id.bT);
        final Button bNegacja = (Button) findViewById(R.id.bNegacja);
        final Button bKoniunkcja = (Button) findViewById(R.id.bKoniunkcja);
        final Button bAlternatywa = (Button) findViewById(R.id.bAlternatywa);
        final Button bImplikacja = (Button) findViewById(R.id.bImplikacja);
        final Button bRownowaznosc = (Button) findViewById(R.id.bRownowaznosc);
        final Button bNawiasLewy = (Button) findViewById(R.id.bNawiasLewy);
        final Button bNawiasPrawy = (Button) findViewById(R.id.bNawiasPrawy);


        final Button bGotowe = (Button) findViewById(R.id.bGotowe);
        final EditText etDzialanie = (EditText) findViewById(R.id.etDzialanie);
        final EditText etWynik = (EditText) findViewById(R.id.etWynik);
        final Button bPonow = (Button) findViewById(R.id.bPonow);

        bPowrot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent powrotIntent = new Intent(TlumaczenieNawiasowejLogika.this, StronaGlowna.class);
                TlumaczenieNawiasowejLogika.this.startActivity(powrotIntent);
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
                stos.push("N");
            }
        });
        bAlternatywa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etDzialanie.setText(etDzialanie.getText().toString() + bAlternatywa.getText());
                stos.push("A");
            }
        });
        bKoniunkcja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etDzialanie.setText(etDzialanie.getText().toString() + bKoniunkcja.getText());
                stos.push("K");
            }
        });
        bImplikacja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etDzialanie.setText(etDzialanie.getText().toString() + bImplikacja.getText());
                stos.push("C");
            }
        });
        bRownowaznosc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etDzialanie.setText(etDzialanie.getText().toString() + "<=>");
                stos.push("E");
            }
        });
        bNawiasLewy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etDzialanie.setText(etDzialanie.getText().toString() + bNawiasLewy.getText());
                stos.push(bNawiasLewy.getText().toString());
            }
        });
        bNawiasPrawy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etDzialanie.setText(etDzialanie.getText().toString() + bNawiasPrawy.getText());
                stos.push(bNawiasPrawy.getText().toString());
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
        ////////////////////////////////////////////////////////////////////////
        bGotowe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Stack stos2 = new Stack();
                Stack stos3 = new Stack();

                //SPRAWDZANIE BLEDOW: jesli tablica jest pusta, to uzytkownik nie wpisal dzialania
                if (stos.isEmpty()){
                    Toast.makeText(TlumaczenieNawiasowejLogika.this, "Nie wpisano działania.", Toast.LENGTH_SHORT).show();
                    bPonow.performClick();
                    return;
                }

                //SPRAWDZANIE BLEDOW: jesli na stosie jest wiecej niz 30 elementow, to program nie przewiduje wykoywania dzialania
                if (stos.size() >= 30) {
                    Toast.makeText(TlumaczenieNawiasowejLogika.this, "Wpisano za duzo znakow. To dzialanie nie zostanie juz przetlumaczone. Wpisz je ponownie", Toast.LENGTH_LONG).show();
                    bPonow.performClick();
                    return;
                }

                //SPRAWDZANIE BLEDOW
                //jesli najpierw wystepuje znak, to wyskakuje komunikat
                if (stos.bottom().isLetter() && !("N").equals(stos.bottom().key)){
                    Toast.makeText(TlumaczenieNawiasowejLogika.this, "Ten znak nie moze byc pierwszym znakiem", Toast.LENGTH_SHORT).show();
                    bPonow.performClick();
                    return;
                }

                //SPRAWDZANIE BLEDOW:
                //sprawdzanie ilosci operatorow
                int liczbaOperatorow=stos.numberOfOperators();
                int liczbaNawiasow=stos.numberOfBrackets();
                int liczbaNegacji=stos.numberOfNegation();

                if((2*liczbaOperatorow<stos.size()-liczbaNawiasow-liczbaNegacji-1 && stos.size()>2) || liczbaOperatorow==0){
                    Toast.makeText(TlumaczenieNawiasowejLogika.this, "Za malo operatorow. Wpisz poprawione dzialanie", Toast.LENGTH_SHORT).show();
                    bPonow.performClick();
                    return;
                }
                if(2*liczbaOperatorow>stos.size()-liczbaNawiasow-liczbaNegacji-1 && stos.size()>2){
                    Toast.makeText(TlumaczenieNawiasowejLogika.this, "Za duzo operatorow. Wpisz poprawione dzialanie", Toast.LENGTH_SHORT).show();
                    bPonow.performClick();
                    return;
                }

                //ALGORYTM KONWERSJI
                //czytanie stosu, wrzucanie zdan logicznych na stos3, a spojnikow na stos2
                while (!stos.isEmpty()){

                    //SPRAWDZANIE BLEDOW: jesli napotkamy znak negacji, a stos3 jest pusty, to komunikat o bledzie
                    if(("N").equals(stos.top().key) && stos3.isEmpty()){
                        Toast.makeText(TlumaczenieNawiasowejLogika.this, "Po znaku negacji musi występować zdanie logiczne. Ponow wpisywanie dzialania", Toast.LENGTH_SHORT).show();
                        bPonow.performClick();
                        return;
                    }

                    //negacje dopisac od razu do odpowiedniego zdania
                    if(("N").equals(stos.top().key)) stos3.top().key="N"+stos3.top().key;
                    //operatory i prawe nawiasy trzyma sie na stosie2
                    else if(stos.top().isLetter() ||  (")").equals(stos.top().key))  //jesli na szczycie jest liczba lub prawy nawias
                        stos2.push(stos.top().key); //wlozyc na stos2

                    //jesli pojawi sie lewy nawias, to wypisac wszystko az do prawego nawiasu ze stosu2
                    else if(("(").equals(stos.top().key)) {

                        //SPRAWDZENIE BLEDU: jesli na stosie jest '(', a nie ma ")" na stosie2, to za duzo '('
                        if(!stos2.toString().contains(")")){
                            Toast.makeText(TlumaczenieNawiasowejLogika.this, "Za duzo nawiasow '('. Ponow wpisywanie dzialania", Toast.LENGTH_SHORT).show();
                            bPonow.performClick();
                            return;
                        }
                        String temp = "";
                        while(!(")").equals(stos2.top().key)){
                            temp = stos2.top().key+stos3.top().key;
                            stos2.pop();
                            stos3.pop();
                            temp=temp+stos3.top().key;
                            stos3.pop();
                            stos3.push(temp);
                        }
                        stos2.pop();
                    }
                    else if (!stos2.isEmpty() && stos2.top().prior < stos.top().prior){ //jesli szczyt stosu ma wiekszy prior od szczytu stosu2

                        //SPRAWDZENIE BLEDU: jesli na stosie jest '(', a nie ma juz innych znakow na stosie2, to za duzo '('
                        if(stos.top().getNext()==null && !stos2.toString().contains(")")){
                            Toast.makeText(TlumaczenieNawiasowejLogika.this, "Za duzo nawiasow '('. Ponow wpisywanie dzialania", Toast.LENGTH_SHORT).show();
                            bPonow.performClick();
                            return;
                        }
                        while (!stos2.isEmpty() && stos2.top().prior< stos.top().prior) { //dopoki priorytet znaku ze szczytu stosu2 jest mniejszy niz znaku ze stosu
                            stos3.push(stos2.top().key);   //dodanie szczytu stosu2 do stosu3
                            stos2.pop();    //zdjecie szczytu stosu2
                        }
                        if(("(").equals(stos.top().key) && (")").equals(stos2.top().key)) stos2.pop();
                        else stos2.push(stos.top().key);
                    }
                    else{
                        stos3.push(stos.top().key);
                    }
                    stos.pop();

                }

                //dopisywanie pozanawiasowych elementow do wyniku
                while(!stos2.isEmpty()){
                    stos3.top().key=stos2.top().key+stos3.top().key;
                    stos2.pop();
                }

                //SPRAWDZANIE BLEDOW:
                //sprawdzanie, czy ilosc ')' sie zgadzala
                if (stos3.wypisz().contains(")")){
                    Toast.makeText(TlumaczenieNawiasowejLogika.this, "Za duzo nawiasow ')'. Ponow wpisywanie dzialania.", Toast.LENGTH_SHORT).show();
                    bPonow.performClick();
                    return;
                }

                //wypisywnie wyniku ze stosu3
                etWynik.setText(stos3.wypisz());
            }

        });
    }
}

