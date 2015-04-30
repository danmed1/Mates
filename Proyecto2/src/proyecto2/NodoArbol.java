/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author Dan
 */
public class NodoArbol {

    private String contenido;
    private ArrayList<NodoArbol> hijos;
    public NodoArbol(String contenido) {
        this.contenido = contenido;
        this.hijos=new ArrayList<>();
    }
    

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public ArrayList<NodoArbol> getHijos() {
        return hijos;
    }

    public void setHijos(ArrayList<NodoArbol> hijos) {
        this.hijos = hijos;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 73 * hash + Objects.hashCode(this.contenido);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final NodoArbol other = (NodoArbol) obj;
        if (!Objects.equals(this.contenido, other.contenido)) {
            return false;
        }
        return true;
    }

    

}
