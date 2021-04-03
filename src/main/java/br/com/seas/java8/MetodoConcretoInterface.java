package br.com.seas.java8;


interface Corredor{
    void Correr();
    //A partir do Java 8, é possível implementar métodos na interface
    default void CorrerRapido(){
        System.out.println("Correndo rápido");
    }
}

interface Maratonista{
    //A partir do Java 8, é possível implementar métodos na interface
    default void CorrerRapido(){
        System.out.println("Correndo rápido");
    }
}


class  Pessoa implements Corredor, Maratonista{

    @Override
    public void Correr() {
        System.out.println("Pessoa correndo");
    }

    //Se mais de uma interface tem o mesmo método 'default'
    //a classe que implementa, neste caso, é obrigada a (re)implementar
    //o método. Por exemplo, escolhendo chamar o método de uma delas
    @Override
    public void CorrerRapido(){
        Corredor.super.CorrerRapido();
    }

}
class Avestruz implements Corredor{

    @Override
    public void Correr() {
        System.out.println("Avestruz correndo");
    }
}

public class MetodoConcretoInterface {
    public static void main(String[] args){
        Pessoa p = new Pessoa();
        p.Correr();
        p.CorrerRapido();

        Avestruz a = new Avestruz();
        a.Correr();
        a.CorrerRapido();
    }
}
