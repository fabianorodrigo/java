package br.com.seas.java8.datetime;

import java.time.Instant;

public class APITimeInstant {

    //Quantidade de milliseconds a partir de 01/01/1970 00:00:00.0000 (no timezone GMT/UTC)
    public static void main( String[] args )
    {
        Instant n = Instant.now();
        System.out.println("Instante (milisegundos desde 1970) agora em UTC: " + n.toString() );
    }
}
