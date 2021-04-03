package br.com.seas.java8;

interface UmaInterface{
    public static void Metodo(){
        System.out.println("Eu sou um método estático em uma interface");
    }
}

public class MetodosEstaticosInterface {
    public static void main(String[] args){
        UmaInterface.Metodo();
    }
}
