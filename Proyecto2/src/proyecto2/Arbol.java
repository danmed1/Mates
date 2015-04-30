package proyecto2;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * <h1>Clase árbol.</h1>
 * Clase intermediaria entre el prgrama con el usuario yel backend.
 *
 * @author Luis Daniel Medina Lugo
 * @author Alejandro Ulacia Flores
 * @version 1.0
 * @since 2015-04-30
 */
public class Arbol {

    private HashMap<String, Simbolo> noTerminales;
    private NodoArbol raiz;

    public Arbol(String inicial) {
        raiz = new NodoArbol(inicial);
        noTerminales = new HashMap<>();
    }

    /**
     * Metododo para añadir la referencia de un objeto tipo Simbolo a HashMap de
     * éstos
     *
     * @param str llave (Caracter)
     * @param s Objeto de tipo Simbolo.
     */
    public void addNoTerminal(String str, Simbolo s) {
        noTerminales.put(str, s);
    }

    /**
     * Metododo que devuelve un HashMap de los simbolos no terminales
     * @return HashMap de simbolos no terminales.
     */
    
    public HashMap<String, Simbolo> getNoTerminales() {
        return noTerminales;
    }

    /**
     * Metododo para obtener todas las producciones posibles de una cadena con
     * algún simbolo no Terminal
     *
     * @param nodo. Recibe un nodo para generar sus hijos a partir de su
     * contenido
     * @return ArrayList<NodoArbol> de los hijos de una produccion
     */
    private ArrayList<NodoArbol> generaHijos(NodoArbol nodo) {
        String str = nodo.getContenido();
        int index = getLeftNoTerminal(str);
        ArrayList<NodoArbol> nuevo = new ArrayList<>();
        if (index > -1) {
            nuevo = new ArrayList<>();
            Simbolo aux = noTerminales.get((str.charAt(index) + ""));
            for (int i = 0; i < aux.getProduccion().size(); i++) {
                nuevo.add(new NodoArbol(str.substring(0, index) + aux.getProduccion().get(i) + str.substring(index + 1, str.length())));
            }
        }
        nodo.setHijos(nuevo);
        return nuevo;
    }

    /**
     * Metododo para buscar letras Mayusculas en una cadena de caracteres.
     *
     * @param str. Cadena a evaluar.
     * @return devuelve el indice del simbolo no terminal más a la izquierda. Si no hay alguno devuelve -1
     */
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

    /**
     * Metododo para realizar toda la ogica de derivaciones de una gramatica con
     * los valores ingresados
     *
     * @param input. Cadena a buscar
     * @param profundidad. Profundidad maxima del árbol
     * @return devuelve un booleano que indica si se encontró una coincidencia con la cadena ingresada
     */
    public boolean analize(String input, int profundidad) {
        NodoArbol nod = raiz;
        ArrayList<NodoArbol> nodosEnNivel = new ArrayList<>();
        ArrayList<NodoArbol> nuevoNivel = new ArrayList<>();
        boolean ret = false;
        int n = profundidad;
        nodosEnNivel.add(nod);
        while (n > 0) {
            for (NodoArbol aux : nodosEnNivel) {
                nuevoNivel.addAll(generaHijos(aux));
            }
            if (!nuevoNivel.contains(new NodoArbol(input))) {
                nodosEnNivel.clear();
                nodosEnNivel.addAll(nuevoNivel);
                nuevoNivel.clear();
            } else {
                ret = true;
                n = 0;
            }
            n--;
        }
        return ret;
    }

    /**
     * Devuelve un String con el árbol en versión de impresión.
     * @return String con el arból en formato de impresión.
     */
    public String print() {
        return treeString(raiz, 4);
    }

    /**
     * Metododo para generar el String del árbol.
     *
     * @param nodo. Nodo con el cual se comenzará la busqueda.
     * @param sp. Numero de espacios iniciales para la presentación de la
     * impresón final.
     * @return Árbol en formato de impresión
     */
    private String treeString(NodoArbol nodo, int sp) {
        String ret = "";
        if (nodo.getHijos() != null && nodo.getHijos().isEmpty()) {
            ret += String.format("%1$" + sp + "s", "[" + nodo.getContenido() + "]\n");
        } else {
            for (NodoArbol aux : nodo.getHijos()) {
                ret = ret + treeString(aux, sp + 4);
            }
            ret = String.format("%1$" + sp + "s", "[" + nodo.getContenido() + "]\n") + ret;
        }
        return ret;
    }
}
