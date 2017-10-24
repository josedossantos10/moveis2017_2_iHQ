package br.com.projeto.ihq.util;


import java.util.ArrayList;
import java.util.List;

public class Util {
    public static String nome;
    private static List<String> nomes = new ArrayList<>();

    public static void addNomeNaLista(String s) {
        nomes.add(s);
    }

    public static List<String> getNomes() {
        return nomes;
    }
}
