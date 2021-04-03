package br.com.seas.java8.datetime;

import java.time.LocalTime;

public class APITimeLocalTime {

//Somente hora (sem data, sem timezone)
        public static void main( String[] args )
        {
                LocalTime n = LocalTime.now();
                System.out.println("Somente hora agora: " + n.toString() );
        }
}
