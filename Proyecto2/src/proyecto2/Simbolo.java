/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2;

import java.util.ArrayList;

/**
 *
 * @author Dan
 */
public class Simbolo {
    
    private char caracter;
    private ArrayList<String> produccion;
    
    public Simbolo(char caracter) {
        this.caracter = caracter;
        this.produccion = new ArrayList<>();
    }    
    
    public char getCaracter() {
        return caracter;
    }

    public void setCaracter(char caracter) {
        this.caracter = caracter;
    }

    public ArrayList<String> getProduccion() {
        return produccion;
    }

    public void setProduccion(ArrayList<String> produccion) {
        this.produccion = produccion;
    }    

    @Override
    public String toString() {
        return caracter + " -> " + produccion;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Simbolo other = (Simbolo) obj;
        if (this.caracter != other.caracter) {
            return false;
        }
        return true;
    }
    
    
    
    public void insertProduction(String str){
        if(!produccion.contains(str)){
            produccion.add(str);
        }
    }            
}
