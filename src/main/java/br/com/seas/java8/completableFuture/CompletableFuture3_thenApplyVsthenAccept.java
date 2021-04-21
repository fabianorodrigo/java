package br.com.seas.java8.completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.stream.IntStream;

public class CompletableFuture3_thenApplyVsthenAccept {

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

        CompletableFuture<String> futureInicial = CompletableFuture.supplyAsync(() -> "Olá ");

        // O método 'thenApply' recebe uma Function (@FunctionInterface) que realizará o
        // processamento do resultado da Future original e retornará uma outra
        // Future com o resultado deste processamento realizado
        // OBS: 'thenApply' é bloqueante, para não bloqueante, use 'thenApplyAsync'
        CompletableFuture<String> futureFinal = futureInicial.thenApply(fn -> fn.concat(" Mundo"));

        /**
         * thenApply: We can use this method to work with a result of the previous call.
         * However, a key point to remember is that the return type will be combined of
         * all calls. So this method is useful when we want to transform the result of a
         * CompletableFuture call
         * 
         * thenCompose: is similar to thenApply() in that both return a new Completion
         * Stage. However, thenCompose() uses the previous stage as the argument. It
         * will FLATTEN and return a Future with the result directly, rather than a
         * nested future as we observed in thenApply():
         * 
         * So if the idea is to chain CompletableFuture methods then it’s better to use
         * thenCompose().
         */

        // Mas caso você não precise de um valor retorno, mas apenas executar algo a
        // partir, do valor da Future inicial, pode-se usar o método 'thenAccept', que
        // recebe uma interface funcional Consumer e retorna um Future<Void>
        // OBS: 'thenAccept' é bloqueante, para não bloqueante, use 'thenAcceptAsync'
        CompletableFuture<Void> futureConsumer = futureInicial
                .thenAccept(fn -> System.out.println(fn.concat(" Mundo sem volta")));
        System.out.println(futureConsumer);

        enrolando();
        String resultado;
        try {
            // espera N segundos, se não voltar, exceção
            final int N = 3;
            resultado = futureFinal.get(N, TimeUnit.SECONDS);
            System.out.println(resultado);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }

    }

    public static int enrolando() {
        int soma = IntStream.range(1, 1_000_000).reduce(0, (a, b) -> a + b);
        System.out.print("olha a soma da enrolação: ");
        System.out.println(soma);
        return soma;
    }
}