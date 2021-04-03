package br.com.seas.java8.datetime;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class APITimeLocalTime {

//Somente hora (sem data, sem timezone)
        public static void main( String[] args )
        {
                LocalTime n = LocalTime.now();
                System.out.println("Somente hora agora: " + n.toString() );

                LocalTime lt = n.plus(1, ChronoUnit.HOURS);
                System.out.println("É possível adicionar horas/minutos/segundos ao um LocalTime com o método imutável plus: " + lt.toString());
        
        }
}
