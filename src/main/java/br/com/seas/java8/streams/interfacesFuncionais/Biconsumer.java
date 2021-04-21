package br.com.seas.java8.streams.interfacesFuncionais;

public class Biconsumer {
    public static void main(String[] args) {

        // O Java 8 veio com algumas interfaces para se utilizar com os Streams
        // são interfaces funcionais (têm inclusive a anotação @FunctionInterface)

        // Enquanto o forEach recebe uma interface funcional 'Consumer'
        // que tem um método accept que recebe UM ÚNICO valor e não retorna nada
        // o BICONSUMER recebe DOIS valores e não retorna nada

        /******************************************************************************
         * Interface that has single abstract method (SAM), is known as functional
         * interface. We can supply a lambda expression whenever an object of an
         * functional interface is expected.
         * 
         * The compiler will treat any interface meeting the definition of a functional
         * interface as a functional interface regardless of whether or not a
         * FunctionalInterface annotation is present on the interface declaration.
         *********************************************************************************/

    }
}
