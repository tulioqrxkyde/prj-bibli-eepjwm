/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.*;

/**
 *
 * @author lab07
 */
public class Collection {

    public static void main(String[] args) {
        List<String> listaDeCompras = new ArrayList<>();

        String[] itensAComprar = {"Arroz", "Feijão", "Carne", "Macarrão"};

        for (String item : itensAComprar) {
            listaDeCompras.add(item);
        }

        List<String> listaItensComprados = new ArrayList<String>();

        String[] itensComprados = {"Arroz", "Feijão"};

        for (String item : itensComprados) {
            listaItensComprados.add(item);
        }


    }

    public static void listar(List<String> lista) {
        Iterator<String> iterator = lista.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public static void verifica(String item, List<String> verifica) {
        if (verifica.contains(item)) {
            System.out.println("Lista contém o item: " + item);
        }

    }

    public static void removeItem(String item, List<String> lista) {
        lista.remove(item);
    }
    
        public static void listaraoinverso(List<String> lista) {
        ListIterator<String> iterator = lista.listIterator(lista.size());
        

        while (iterator.hasPrevious()) {
            System.out.println(iterator.previous());
        }
    }
   
}
