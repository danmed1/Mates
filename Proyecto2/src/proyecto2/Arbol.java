/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Dan
 */
public class Arbol {

    private String[] alfabeto;
    private Simbolo inicial;
    private HashMap<String, Simbolo> noTerminales;
    private NodoArbol raiz;

    public Arbol(String[] alfabeto, Simbolo inicial) {
        this.alfabeto = alfabeto;
        this.inicial = inicial;
        raiz = new NodoArbol(inicial.getCaracter()+"");
        noTerminales = new HashMap<>();
    }

    public String[] getAlfabeto() {
        return alfabeto;
    }

    public void setAlfabeto(String[] alfabeto) {
        this.alfabeto = alfabeto;
    }

    public Simbolo getInicial() {
        return inicial;
    }

    public void setInicial(Simbolo inicial) {
        this.inicial = inicial;
    }

    public void addNoTerminal(String str, Simbolo s) {
        noTerminales.put(str, s);
    }

    private ArrayList<NodoArbol> generaHijos(NodoArbol nodo) {
        String str = nodo.getContenido();
        int index = getLeftNoTerminal(str);
        ArrayList<NodoArbol> nuevo = new ArrayList<>();
        if (index > -1) {
            nuevo = new ArrayList<>();
            Simbolo aux = noTerminales.get((str.charAt(index) + ""));
            for (int i = 0; i < aux.getProduccion().size(); i++) {
                nuevo.add(new NodoArbol(str.substring(0, index) + noTerminales.get((str.charAt(index) + "")).getProduccion().get(i) + str.substring(index + 1, str.length())));
            }
        }
        nodo.setHijos(nuevo);
        return nuevo;
    }

    private int getLeftNoTerminal(String str) {
        int aux = -1;
        if (str.matches(".*[A-Z].*")) {
            for (int i = 0; i < str.length(); i++) {
                if ((str.charAt(i) + "").matches(".*[A-Z].*")) {
                    aux = i;
                    i = str.length();
                }
            }
        }
        return aux;
    }

    public boolean analize(String input, int profundidad) {
        NodoArbol nod = raiz;
        ArrayList<NodoArbol> nodosEnNivel= new ArrayList<>();
        ArrayList<NodoArbol> nuevoNivel= new ArrayList<>();
        boolean ret=false;
        int n = profundidad;
        nodosEnNivel.add(nod);
        while (n > 0) {
            for(NodoArbol aux: nodosEnNivel){
                nuevoNivel.addAll(generaHijos(aux));
            }
            if(!nuevoNivel.contains(new NodoArbol(input))){
                nodosEnNivel.clear();
                nodosEnNivel.addAll(nuevoNivel);
                nuevoNivel.clear();
            }else{
                ret=true;
                n=0;
            }
            n--;
        }
        return ret;
    }
    public String print (){
        return treeString(raiz, 4);
    }
    
    private String treeString(NodoArbol nodo, int sp){
        String ret="";
        if(nodo.getHijos()!=null && nodo.getHijos().isEmpty()){
            ret+=String.format("%1$" + sp + "s", "["+nodo.getContenido()+"]\n");
        }else{
            for(NodoArbol aux: nodo.getHijos()){
                ret=ret+treeString(aux, sp+4);
            }
            ret=String.format("%1$" + sp + "s", "["+nodo.getContenido()+"]\n")+ret;
        }
        return ret;
    }
}
