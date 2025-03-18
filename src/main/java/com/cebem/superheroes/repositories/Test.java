package com.cebem.superheroes.repositories;

public class Robot {
    String nombre = "default"; // Nombre del robot
    String descripcion; // Breve descripción del robot
    boolean desactivado = false; // Determina si el robot está desactivado
    int ataque = 100; // Potencia de ataque del robot
    int energia = 10; // Puntos de energía disponibles
    TipoRobot tipo = TipoRobot.Explorador; // Tipo de robot (Explorador, Asalto, Defensivo, Tecnológico)
 
    // Datos de los módulos (pueden ser varios) que contiene este robot. Su nombre y su valor
    String nombresModulos[];
    int valoresModulos[];
 
    int cargaBateria = 5; // Nivel de carga de la batería, usado para robots tecnológicos
 
    enum TipoRobot {
        Explorador, Asalto, Defensivo, Tecnológico
    };
 
    // Determina si el robot está fuera de servicio
    boolean fueraDeServicio() {
        if (energia < 0 || energia == 0) {
            if (desactivado) {
                return true;
            } else {
                return true;
            }
        } else {
            if (desactivado) {
                return true;
            } else {
                return false;
            }
        }
    }
 
    // Calcula el daño que el robot puede causar en combate
    float calcularPotenciaAtaque() {
        switch (tipo) {
            case Explorador:
                if (fueraDeServicio()) return 0;
                return ataque / 2;
            case Asalto:
                if (fueraDeServicio()) return 0;
                return ataque * 2;
            case Defensivo:
                if (fueraDeServicio()) return 0;
                return ataque;
            case Tecnológico:
                if (fueraDeServicio()) return 0;
                if (cargaBateria <= 0) return 0;
                return ataque * cargaBateria * 0.1f;
            default:
                return 0;
        }
    }
 
    public static void main(String[] args) {
        Robot r = new Robot();
        r.tipo = TipoRobot.Tecnológico;
        System.out.println(r.calcularPotenciaAtaque());
    }
 }
 