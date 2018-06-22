package com.example.acer.npkonwerter;
import java.util.*;
import java.lang.Character.*;

import android.text.TextUtils;
import android.text.TextUtils.*;
/**
 * Created by Acer on 16.06.2018.
 */

public class Elem {

    String key;
    Elem next;
    int prior;

    public Elem(){
        next=null;
        key=null;
        prior=checkPriority();
    }
    public Elem(String x){
        key=x;
        prior=checkPriority();
    }
    /* konstruktor */
    public Elem(String x, Elem n){
        next=n;
        key=x;
        prior=checkPriority();
    }

    /* zwracam wskzaznik na nastepny obiekt */
    public Elem getNext(){
        return next;
    }

    /* ustawiam wartosc wskaznika */
    public void setNext(Elem e){
        next = e;
    }

    /* zwracam przechowywana wartosc */
    public String getKey() {
        return key;
    }

    /* sprawdzam czy element jest liczba */
    public boolean isNumber(){
        if(TextUtils.isDigitsOnly(key)){
            return true;
        } else return false;
    }

    public boolean isLetter(){
        if(("A").equals(key) || ("C").equals(key) ||
                ("E").equals(key) || ("K").equals(key) || ("N").equals(key)){
            return true;
        }
        else return false;
    }
    public String convertToSign(){
        String sign = new String();
        if (key.equals("A")) sign="\\/";
        else if (key.equals("K")) sign = "/\\";
        else if (key.equals("E")) sign = "<=>";
        else if (key.equals("C")) sign = "=>";
        return sign;
    }

    /* wyznaczam priorytet symbolu */
    public int checkPriority(){
        if(this.isNumber()) return 0;
        else if((")").equals(this.key)) return 4;
        else if(("+").equals(this.key) || ("-").equals(this.key) || ("K").equals(this.key) ||
                ("A").equals(this.key) || ("N").equals(this.key)) return 2;
        else if(("*").equals(this.key) || ("/").equals(this.key) || ("E").equals(this.key) ||
                ("C").equals(this.key)) return 1;
        else if (("(").equals(this.key)) return 3;
        else return -1;
    }

}
