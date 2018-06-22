package com.example.acer.npkonwerter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.StringTokenizer;

public class TlumaczenieNawiasowej extends AppCompatActivity {

    //tworze ciag pomocniczy, ktory bedzie przechowywal ciag cyfr, dopoki nie pojawi sie znak
    String tmp = new String();

    //tworze stos
    final Stack stos = new Stack();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tlumaczenie_nawiasowej);


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
        final Button bNawiasLewy = (Button) findViewById(R.id.bNawiasLewy);
        final Button bNawiasPrawy = (Button) findViewById(R.id.bNawiasPrawy);
        final Button bGotowe = (Button) findViewById(R.id.bGotowe);
        final EditText etDzialanie = (EditText) findViewById(R.id.etDzialanie);
        final EditText etWynik = (EditText) findViewById(R.id.etWynik);
        final Button bPonow = (Button) findViewById(R.id.bPonow);

        bPowrot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent powrotIntent = new Intent(TlumaczenieNawiasowej.this, StronaGlowna.class);
                TlumaczenieNawiasowej.this.startActivity(powrotIntent);
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
        bNawiasPrawy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etDzialanie.setText(etDzialanie.getText() + bNawiasPrawy.getText().toString());
                emptyTmp();
                stos.push(bNawiasPrawy.getText().toString());
            }
        });
        bNawiasLewy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etDzialanie.setText(etDzialanie.getText() + bNawiasLewy.getText().toString());
                emptyTmp();
                stos.push(bNawiasLewy.getText().toString());
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


        ////////////////////////////////////////////////////////////////////////
        bGotowe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                emptyTmp();

                //SPRAWDZANIE BLEDOW: jesli stos jest pusty, to uzytkownik nie wpisal dzialania
                if (stos.isEmpty()) {
                    Toast.makeText(TlumaczenieNawiasowej.this, "Nie wpisano działania.", Toast.LENGTH_SHORT).show();
                    bPonow.performClick();
                    return;
                }

                //SPRAWDZANIE BLEDOW: jesli na stosie jest wiecej niz 30 elementow, to program nie przewiduje wykoywania dzialania
                if (stos.size() >= 30) {
                    Toast.makeText(TlumaczenieNawiasowej.this, "Wpisano za duzo znakow. To dzialanie nie zostanie juz przetlumaczone. " +
                            "Wpisz je ponownie", Toast.LENGTH_LONG).show();
                    bPonow.performClick();
                    return;
                }

                //SPRAWDZANIE BLEDOW: jesli na stosie jest mniej niz 3 elementy, to nie jest to dzialanie
                if (stos.size() < 3) {
                    Toast.makeText(TlumaczenieNawiasowej.this, "To nie jest dzialanie.", Toast.LENGTH_LONG).show();
                    bPonow.performClick();
                    return;
                }

                //SPRAWDZANIE BLEDOW:
                //jesli pierwszym znakiem nie jest liczba lub'(', to wyskakuje toast
                if (stos.bottom().isNumber() == false && !("(").equals(stos.bottom().key)) {
                    Toast.makeText(TlumaczenieNawiasowej.this, "Znak " + stos.bottom().key + " nie moze byc pierwszym znakiem", Toast.LENGTH_SHORT).show();
                    bPonow.performClick();
                    return;
                }

                //SPRAWDZANIE BLEDOW: sprawdzanie, czy nie podano za duzo lub za malo operatorow (operatory+1==liczby)
                int iloscLiczb = stos.numberOfNumbers();
                int iloscNawiasow = stos.numberOfBrackets();

                if (stos.size()-iloscNawiasow+1 > iloscLiczb*2) {
                    Toast.makeText(TlumaczenieNawiasowej.this, "Wpisano za duzo operatorow. Ponow wpisywanie dzialania.", Toast.LENGTH_SHORT).show();
                    bPonow.performClick();
                    return;
                }
                if (stos.size()-iloscNawiasow+1 < iloscLiczb*2) {
                    Toast.makeText(TlumaczenieNawiasowej.this, "Wpisano za malo operatorow. Ponow wpisywanie dzialania", Toast.LENGTH_SHORT).show();
                    bPonow.performClick();
                    return;
                }

                //ALGORYTM KONWERSJI
                //czytanie kolejno elementow stosu, wrzucanie znakow na stos2, a liczb do stosu3

                //stos do przechowywania znakow
                Stack stos2 = new Stack();
                //stos wynikowy
                Stack stos3 = new Stack();

                while (!stos.isEmpty()) { //dopoki stos nie jest pusty
                    if (stos.top().isNumber()) {  //jesli szczyt stosu jest liczba
                        stos3.push(stos.top().key); //przypisanie wartosci szczytu stosu do stosu3
                    }
                    else if (stos.top().prior==4){  //jesli szczyt jest prawym nawiasem
                        stos2.push(stos.top().key); //przypisanie wartosci szczytu do stosu2
                    }
                    else if (!stos2.isEmpty() && stos2.top().prior < stos.top().prior){ //jesli szczyt stosu ma wiekszy prior od szczytu stosu2

                        //SPRAWDZENIE BLEDU: jesli na stosie jest '(', a nie ma juz innych znakow na stosie2, to za duzo '('
                        if(stos.top().getNext()==null && !stos2.toString().contains(")")){
                            Toast.makeText(TlumaczenieNawiasowej.this, "Za duzo nawiasow '('. Ponow wpisywanie dzialania", Toast.LENGTH_SHORT).show();
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
                        stos2.push(stos.top().key);
                    }
                    stos.pop(); //zdjac szczyt stosu
                }
                while (!stos2.isEmpty()) {   //dopoki na stosie2 sa znaki
                    stos3.push(stos2.top().key);   //dodawac znaki do stosu3
                    stos2.pop();    //zdejmowac przepisane znaki ze stosu2
                }

                //SPRAWDZANIE BLEDOW:
                //sprawdzanie, czy ilosc ')' sie zgadzala
                if (stos3.toString().contains(")")){
                    Toast.makeText(TlumaczenieNawiasowej.this, "Za duzo nawiasow ')'. Ponow wpisywanie dzialania.", Toast.LENGTH_SHORT).show();
                    bPonow.performClick();
                    return;
                }
                //SPRAWDZANIE BLEDOW:
                //sprawdzanie, czy ilosc '(' sie zgadzala
                if (stos3.toString().contains("(")){
                    Toast.makeText(TlumaczenieNawiasowej.this, "Za duzo nawiasow '('. Ponow wpisywanie dzialania.", Toast.LENGTH_SHORT).show();
                    bPonow.performClick();
                    return;
                }

                etWynik.setText(stos3.toString());


/*

                        //sprawdzanie, czy na wierzchu stosu jest znak o wyzszym priorytecie,
                        // jesli tak, to dopisanie na wyjscie znaku z tablicy

                        } else if (tablica[i].equals("(")) {
                            j = j - 1;
                            while (j > z) {
                                wyjscie = " "+ stos[j] + wyjscie;
                                stos[j] = null;
                                stossize--;
                                j--;
                            }

                            //SPRAWDZANIE BLEDOW: jesli jest za duzo '(', to przerywa prace
                            if (z < 0) {
                                Toast.makeText(TlumaczenieNawiasowej.this, "Za duzo nawiasow '('. Ponow wpisywanie dzialania", Toast.LENGTH_SHORT).show();
                                return;
                            }
                            //usuwa znak ")" ze stosu bez wypisywania go
                            stos[z] = null;
                            stossize--;
                            j--;
                            z = -1;

                            //sprawdza, czy na stosie jest jeszcze znak ")" i wpisuje go do z
                            for (j = j; j >= 0 && z < 0; j--) {
                                if (stos[j].equals(")")) z = j;
                            }
                        }

                        //dopisanie znaku do stosu
                        else {
                            stos[j] = tablica[i];
                            stossize++;
                        }

                    }
                }
                //wypisywanie reszty stosu na wyjscie
                for(int i=stossize-1; i>=0; i--){
                    wyjscie=" " + stos[i] +wyjscie;
                    stos[i]=null;
                    stossize--;

                }

                //SPRAWDZANIE BLEDOW:
                //sprawdzanie, czy ilosc ')' sie zgadzala
                if (kolejka.contains(")")){
                    Toast.makeText(TlumaczenieNawiasowej.this, "Za duzo nawiasow ')'. Ponow wpisywanie dzialania.", Toast.LENGTH_SHORT).show();
                    return;
                }

                //SPRAWDZANIE BLEDOW: sprawdzanie, czy nie podano za duzo lub za malo operatorow
                StringTokenizer stZnaki = new StringTokenizer(wyjscie);
                StringTokenizer stLiczby = new StringTokenizer(wyjscie, "+-/*() ");
                if ((stZnaki.countTokens()+1)>stLiczby.countTokens()*2){
                    Toast.makeText(TlumaczenieNawiasowej.this, "Wpisano za duzo operatorow. Ponow wpisywanie dzialania.", Toast.LENGTH_SHORT).show();
                    return;
                }
                if ((stZnaki.countTokens()+1<stLiczby.countTokens()*2)){
                    Toast.makeText(TlumaczenieNawiasowej.this, "Wpisano za malo operatorow. Ponow wpisywanie dzialania", Toast.LENGTH_SHORT).show();
                    return;
                }
*/


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
