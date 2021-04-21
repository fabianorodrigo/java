package br.com.seas.java8.completableFuture;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.stream.IntStream;

public class CompletableFuture1_VsFuture {

    /***********************************************************************
     * CompletableFuture is at the same time a building block and a framework, with
     * about 50 different methods for composing, combining, and executing
     * asynchronous computation steps and handling errors.
     * 
     * https://www.baeldung.com/java-completablefuture
     * 
     ************************************************************************/

    private static ExecutorService executor = Executors.newFixedThreadPool(1);

    public static void main(String[] args) {

        // Código assíncrono feito antes do Java 8
        // CodigoAssincronoAntesJava8();
        // Código feito usando CompletableFuture (pós Java 8)
        // basicamente fazendo o mesmo
        CodigoAssincronoPosJava8();
    }

    /**
     * Código assíncrono feito após do Java 8
     */
    public static void CodigoAssincronoPosJava8() {

        CompletableFuture<Double> future = new CompletableFuture<>();

        // usamos lambda pra passar um callable pro 'submit'
        // Com lambda
        executor.submit(() -> {
            TimeUnit.SECONDS.sleep(2);
            // chamamos o Comparable.complete pra passar o valor ao invés de retorná-lo
            // retornando, como feito pré-java, rolou timeout exception
            future.complete(2000D);
            return null;
        });

        enrolando();
        Double resultado;
        try {
            // espera N segundos, se não voltar, exceção
            final int N = 3;
            resultado = future.get(N, TimeUnit.SECONDS);
            System.out.println(resultado);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }

    /**
     * Código assíncrono feito antes do Java 8
     */
    public static void CodigoAssincronoAntesJava8() {

        Future<Double> future = executor.submit(new Callable<Double>() {
            @Override
            public Double call() throws Exception {
                TimeUnit.SECONDS.sleep(2);
                return 2000D;
            }
        });

        enrolando();
        Double resultado;
        try {
            // espera N segundos, se não voltar, exceção
            final int N = 3;
            resultado = future.get(N, TimeUnit.SECONDS);
            System.out.println(resultado);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }

    public static void enrolando() {
        IntStream.range(1, 1_000_000).reduce(0, (a, b) -> a + b);
    }
}