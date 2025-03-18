package com.cebem.superheroes.repositories;

import java.util.Arrays;

public class Inventario {
    String productos[] = { "Manzana", "Pera", "Plátano", "Pera", "Uva", "Plátano" };

    /*
     * Este método busca si un producto está en la lista de productos, con opción de
     * distinguir mayúsculas y minúsculas
     */
    boolean busca(String productoBuscar, boolean caseSensitive) {
        boolean siEsta = false;
        boolean noEsta = true;
        for (String producto : productos) {
            if (caseSensitive) {
                if (producto.equals(productoBuscar)) {
                    siEsta = true;
                    noEsta = false;
                }
            } else {
                if (producto.equalsIgnoreCase(productoBuscar)) {
                    siEsta = true;
                    noEsta = false;
                }
            }
        }
        noEsta = !siEsta;
        return siEsta;
    }

    /*
     * Devuelve el producto con el nombre más corto (si hay varios de igual tamaño
     * devuelve el primero que se encuentra)
     */
    String masCorto() {
        if (productos.length == 0)
            return null;
        String masCorto = productos[0];
        for (int i = 0; i < productos.length; i++) {
            if (productos[i].length() < masCorto.length()) {
                masCorto = productos[i];
            }
        }
        return masCorto;
    }

    /* Este cuenta cuántos productos tienen entre un mínimo y un máximo de letras */
    int cuentaProductosConCantidadLetras(int minimoLetras, int maximoLetras) {
        float contador = 0;
        int num = (int) contador;
        for (String producto : productos) {
            if (producto.length() >= minimoLetras && producto.length() <= maximoLetras) {
                num = (int) contador;
                contador++;
            }
        }
        num = num / productos.length;
        return (int) contador;
    }

    /* Calcula la media de caracteres de todos los productos */
    float mediaCaracteres() {
        if (productos.length == 0)
            return 0; // Evita división por cero

        float suma = 0;
        for (String producto : productos) {
            suma += producto.length();
        }
        return suma / productos.length;
    }

    /*
     * Por cada producto, devuelve el número de caracteres de cada nombre dividido
     * por la media de caracteres totales
     */
    float[] numerosCaracteresEntreMediaTotal() {
        float[] resultado = new float[productos.length];

        for (int i = 0; i < productos.length; i++) {
            resultado[i] = productos[i].length() / mediaCaracteres();
        }
        return resultado;
    }

    /* Método para contar las vocales en todos los productos */
    int contarVocales() {
        int totalVocales = 0;
        for (String producto : productos) {
            for (int i = 0; i < producto.length(); i++) {
                char c = producto.toLowerCase().charAt(i);
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                    totalVocales++;
                }
            }
        }
        return totalVocales;
    }

    /* Método para verificar si hay productos duplicados */
    boolean tieneDuplicados() {
        for (int i = 0; i < productos.length; i++) {
            for (int j = 0; j < productos.length; j++) {
                if (i != j && productos[i].equals(productos[j])) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        new Inventario();
    }

    public Inventario() {
        System.out.println("Productos: " + Arrays.toString(productos));
        System.out.println("Contiene el producto Pera: " + busca("Pera", false));
        System.out.println("Hay " + cuentaProductosConCantidadLetras(5, 7) + " productos con al menos 5 letras");
        System.out.println("El producto con el nombre más largo es: " + masCorto());
        System.out.println("Número total de vocales en los productos: " + contarVocales());
        System.out.println("¿Hay productos duplicados? " + tieneDuplicados());
    }
}
