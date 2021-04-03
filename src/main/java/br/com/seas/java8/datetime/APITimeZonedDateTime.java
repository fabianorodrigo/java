package br.com.seas.java8.datetime;

import java.time.ZonedDateTime;

public class APITimeZonedDateTime {
    
    //Data, hora e TimeZone
    public static void main( String[] args )
    {
        ZonedDateTime n = ZonedDateTime.now();
        System.out.println("Data e Hora com o timezone: " + n.toString() );
    }
}
