package br.com.seas.java8;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Stream;

public class RetornoOptional {

    public static void main(String[] args) {
        // Optional.isPresent + Optional.get
        System.out.println(
                "OPTIONAL.isPresent: Se tudo der certo, retorna um objeto Optional onde pode ser usado .isPresent() e .get() ");
        Optional<Integer> o = converteEmNumero("210");
        if (o.isPresent()) {
            Integer x = o.get();
            System.out.println(x);
        }

        // Optional.ifPresent
        System.out.println(
                "OPTIONAL.ifPresent: ou ir diretamente usar o método .ifPresent() que só executará a função Lambda se existir um valor ");
        o.ifPresent(x -> System.out.println(x));

        // Optional.orElse
        Integer x = converteEmNumero("numeroStr").orElse(0);
        System.out.println("OPTIONAL.orElse: também é possível dar tratamento quando o Optional voltar sem valor: "
                + x.toString());

        // Optional.orElseGet
        x = converteEmNumero("numeroStr").orElseGet(() -> {
            return 10 * 2 * 5;
        });
        System.out.println(
                "OPTIONAL.orElseGet: também é possível dar tratamento quando o Optional voltar sem valor passando uma função lambda: "
                        + x.toString());

        // Optional.orElseThrow
        try {
            x = converteEmNumero("numeroStr").orElseThrow(() -> new NullPointerException("valor vazio no orElseThrow"));
        } catch (NullPointerException e) {
            System.out.println(e);
        }

        // Como os Streams retornam Optional, também é possível fazer um código mais
        // enxuto
        Stream.of(1, 2, 3).findFirst().ifPresent((n) -> System.out
                .println("Como os Streams retornam Optional, também é possível fazer um código mais enxuto:" + n));

        // Optional Primitivos
        converteEmNumeroPrimitivo("10").ifPresent((action) -> System.out
                .println("O Java8 também oferece os Optionals primitivos (OptionalInt, OptionalDouble...): " + action));
    }

    public static Optional<Integer> converteEmNumero(String numeroStr) {
        try {
            Integer i = Integer.valueOf(numeroStr);
            return Optional.of(i);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    public static OptionalInt converteEmNumeroPrimitivo(String numeroStr) {
        try {
            int i = Integer.parseInt(numeroStr);
            return OptionalInt.of(i);
        } catch (Exception e) {
            return OptionalInt.empty();
        }
    }
}
