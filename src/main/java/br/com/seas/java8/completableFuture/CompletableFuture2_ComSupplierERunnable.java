package br.com.seas.java8.completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.stream.IntStream;

public class CompletableFuture2_ComSupplierERunnable {

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

        // O CompletableFuture tem um método estático que recebe uma
        // Interface Functional (@FunctionInterface) Supplier.
        // Assim, podemos passar essa função que calcula e retorna o valor
        CompletableFuture<Double> future = CompletableFuture.supplyAsync(() -> 2.5 + 2.5);

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

        // O CompletableFuture também tem um que recebe interface funcional Runnable
        // Runnable. Mas Runnable não tem retorno
        CompletableFuture<Void> futureRunnable = CompletableFuture.runAsync(() -> System.out.println("Entremo"));
        System.out.println(futureRunnable);
    }

    public static int enrolando() {
        int soma = IntStream.range(1, 1_000_000).reduce(0, (a, b) -> a + b);
        return soma;
    }
}