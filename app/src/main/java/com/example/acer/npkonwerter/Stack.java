package com.example.acer.npkonwerter;

/**
 * Created by Acer on 16.06.2018.
 */

public class Stack {
    /* wierzcholek stosu */
    Elem start;

    Stack(){
        start=null;
    }

    /* zwracam wartosc wierzcholka */
    public Elem top(){
        return start;
    }

    public boolean isEmpty(){
        //jesli wartosc logiczna wyrazenia bedzie prawda, to stos jest pusty
        return start == null;
    }

    /* dodaje element do stosu */
    public void push(String x){
        Elem temp = new Elem(x,start);
        start=temp;
    }

    /* sciagam element ze stosu */
    public void pop(){
        if(!isEmpty()){
            start = start.getNext();
        } else {
            System.out.println("Stos jest pusty");
        }

    }
    /* czyszcze tablice ustawiajac pierwszy element na null */
    public void clear(){
        start=null;
    }

    /* zwracam element lezacy na dnie stosu */
    public Elem bottom(){
        Elem temp = start;
        if(start!=null){
            while(temp.getNext()!=null){
                temp = temp.getNext();
            }
        } return temp;
    }

    /* zwracam String z kolejnymi elementami stosu */
    public String toString(){
        Elem temp = start;
        String ciag = new String();
        while(temp!=null){
            ciag=ciag+temp.key+" ";
            temp=temp.getNext();
        }
        return ciag;
    }

    /*zwracam String z kolejymi elementami stosu, gdy chce pominac spacje */
    public String wypisz(){
        Elem temp = start;
        String ciag = new String();
        while(temp!=null){
            ciag=ciag+temp.key;
            temp=temp.getNext();
        }
        return ciag;
    }

    /* zwracam ile elementow jest na stosie */
    public int size(){
        Elem temp = start;
        int licznik=0;
        if(temp!=null){
            while(temp!=null) {
                licznik++;
                temp = temp.getNext();
            }
        }
        return licznik;
    }

    /* obliczam ilosc liczb na stosie */
    public int numberOfNumbers(){
        int n=0;
        Elem temp = start;
        while(temp!=null){
            if(temp.isNumber())n++;
            temp=temp.getNext();
        }
        return n;
    }

    /* obliczam ilosc nawiasow na stosie */
    public int numberOfBrackets(){
        int n=0;
        Elem temp = start;
        while(temp!=null){
            if(("(").equals(temp.key) || (")").equals(temp.key))n++;
            temp=temp.getNext();
        }
        return n;
    }

    /*obliczam ilosc operatorow w stosie */
    public int numberOfOperators(){
        int n=0;
        Elem temp =start;
        while(temp!=null){
            if (temp.isLetter() && !("N").equals(temp.key)) n++;
            temp=temp.getNext();
        }
        return n;
    }

    /*obliczam ilosc znakow negacji w stosie */
    public int numberOfNegation(){
        int n=0;
        Elem temp=start;
        while(temp!=null){
            if (("N").equals(temp.key)) n++;
            temp=temp.getNext();
        }
        return n;
    }

}
