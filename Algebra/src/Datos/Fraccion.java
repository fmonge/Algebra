/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

/**
 *
 * @author alexis
 */
public class Fraccion {
    private int denominador;
    private int nominador;

    public Fraccion(int denominador, int nominador) {
        this.denominador = denominador;
        this.nominador = nominador;
    }

    public int getDenominador() {
        return denominador;
    }

    public void setDenominador(int denominador) {
        this.denominador = denominador;
    }

    public int getNominador() {
        return nominador;
    }

    public void setNominador(int nominador) {
        this.nominador = nominador;
    }
    
}
