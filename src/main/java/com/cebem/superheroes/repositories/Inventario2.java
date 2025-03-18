package com.cebem.superheroes.repositories;

import java.util.Arrays;
import java.util.HashSet;

public class Inventario2 {
    String productos[] = { "Manzana", "Pera", "Plátano", "Pera", "Uva", "Plátano" };

    /*
     * Método optimizado para buscar un producto en la lista con opción de
     * distinguir mayúsculas y minúsculas
     * Solución devolver true directamente cuando lo encuentre
     */

    boolean busca(String productoBuscar, boolean caseSensitive) {
        for (String producto : productos) {
            if (caseSensitive) {
                if (producto.equals(productoBuscar)) {
                    return true; // Retorna inmediatamente si encuentra coincidencia
                }
            } else {
                if (producto.equalsIgnoreCase(productoBuscar)) {
                    return true; // Retorna inmediatamente si encuentra coincidencia sin importar mayúsculas
                }
            }
        }
        return false; // Retorna false si no encuentra coincidencias
    }

    /*
     * Devuelve el producto con el nombre más corto (si hay varios de igual tamaño
     * devuelve el primero que se encuentra)
     * solucion: empezar en 1
     */
    String masCorto() {
        if (productos.length == 0)
            return null; // Manejo de array vacío

        String masCorto = productos[0]; // Se inicializa con el primer elemento
        for (int i = 1; i < productos.length; i++) { // Se empieza en 1
            if (productos[i].length() < masCorto.length()) {
                masCorto = productos[i];
            }
        }
        return masCorto;
    }

    /*
     * Cuenta cuántos productos tienen entre un mínimo y un máximo de letras
     * sobra variable num
     * contador será int
     * la longitud se calcula 1 vez
     */
    int cuentaProductosConCantidadLetras(int minimoLetras, int maximoLetras) {
        int contador = 0;
        for (String producto : productos) {
            int longitud = producto.length();
            if (longitud >= minimoLetras && longitud <= maximoLetras) {
                contador++;
            }
        }
        return contador;
    }

    /*
     * Calcula la media de caracteres de todos los productos
     * Solución: suma será int
     */

    float mediaCaracteres() {
        if (productos.length == 0)
            return 0; // Evita división por cero

        int suma = 0; // Se usa int en lugar de float, ya que solo sumamos enteros
        for (String producto : productos) {
            suma += producto.length();
        }
        return (float) suma / productos.length; // Conversión final a float
    }

    /*
     * Por cada producto, devuelve el número de caracteres de cada nombre dividido
     * por la media de caracteres totales
     * El calculo de la media de caracteres se hace fuera del for
     */
    float[] numerosCaracteresEntreMediaTotal() {
        float[] resultado = new float[productos.length];
        float media = mediaCaracteres();
        for (int i = 0; i < productos.length; i++) {
            resultado[i] = productos[i].length() / media;
        }
        return resultado;
    }
   

    /**
     * Método para contar las vocales en todos los productos
     * 
     */
    int contarVocales() {
        int totalVocales = 0;
        String vocales = "aeiouAEIOU"; // Evita conversiones innecesarias
    
        for (String producto : productos) {
            for (char c : producto.toCharArray()) { // Usa un array de caracteres
                if (vocales.indexOf(c) != -1) { // Busca en la cadena de vocales
                    totalVocales++;
                }
            }
        }
        return totalVocales;
    }

    /*
     * Método optimizado para verificar si hay productos duplicados
     * Mejora: Usar un hashset
     */
    boolean tieneDuplicados() {
        HashSet<String> setProductos = new HashSet<>();
        for (String producto : productos) {
            if (!setProductos.add(producto)) { // Si ya existe en el conjunto, hay duplicados
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        new Inventario2();
    }

    public Inventario2() {
        System.out.println("Productos: " + Arrays.toString(productos));
        System.out.println("Contiene el producto Pera: " + busca("Pera", false));
        System.out.println("Hay " + cuentaProductosConCantidadLetras(5,7) + " productos con al menos 5 letras");
        System.out.println("El producto con el nombre más largo es: " + masCorto());
        System.out.println("Número total de vocales en los productos: " + contarVocales());
        System.out.println("¿Hay productos duplicados? " + tieneDuplicados());
    }

}
