package br.com.seas.java8.streams;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;

//Diferentes formas de criar Streams no Java 8
public class CriarStreams {

    public static void main(String[] args) throws FileNotFoundException {

        // A partir de Collection, basta chamar o método "stream"
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        list.stream().forEach(System.out::println);

        // A partir de Arrays, basta chamar o stream para o Arrays.stream
        Integer[] intArray = new Integer[] { 1, 2, 3 };
        Arrays.stream(intArray).forEach(System.out::println);

        // A partir do método "Stream.of"
        Stream.of("criou", "a", "partir", "do", "Stream.of").forEach(System.out::println);

        // A partir do método "IntStream.range" (exclusive)
        IntStream.range(0, 10).forEach(System.out::println);

        // A partir do método "Stream.iterate": recebe o valor inicial e depois vai
        // pegando o resultado e passando para a função novamente
        int valorInicial = 7;
        Stream.iterate(valorInicial, n -> n * 2).limit(10).forEach(System.out::println);

        try {
            // A partir do BefferedReader.lines
            File file = new File("streams.txt");
            try (FileReader in = new FileReader(file)) {
                try (BufferedReader br = new BufferedReader(in)) {
                    br.lines().forEach(System.out::println);
                }
            }

            // A partir do Files.list
            Path p = Paths.get("");
            Files.list(p).forEach(System.out::println);
        } catch (IOException ioE) {
            System.out.println(ioE);
        }

        // A partir de um Pattern.splitAsStream (expressões regulares)
        String s = "Opa, estamos aí tentando";
        Pattern p = Pattern.compile(" ");
        p.splitAsStream(s).forEach(System.out::println);

    }
}
