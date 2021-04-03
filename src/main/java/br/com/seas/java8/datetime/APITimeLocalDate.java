package br.com.seas.java8.datetime;

import java.time.LocalDate;

public class APITimeLocalDate {

    //Somente data (sem hora, sem timezone)
    public static void main( String[] args )
    {
        LocalDate n = LocalDate.now();
        System.out.println("Somente data agora: " + n.toString() );
    }
}
