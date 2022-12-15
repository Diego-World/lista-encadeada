package diegogouveia.estruturadedados;

public class Main {
    public static void main(String[] args) {
        ListaEncadeada<String> minhaListaEncadeada = new ListaEncadeada<>();

        minhaListaEncadeada.add("Filosofia");
        minhaListaEncadeada.add("Matematica");
        minhaListaEncadeada.add("Portugues");
        minhaListaEncadeada.add("Sociologia");

        System.out.println(minhaListaEncadeada.get(-1));
        System.out.println(minhaListaEncadeada.get(0));
        System.out.println(minhaListaEncadeada.get(1));
        System.out.println(minhaListaEncadeada.get(2));

        System.out.println(minhaListaEncadeada);

        System.out.println(minhaListaEncadeada.remove(-1));
    }
}
