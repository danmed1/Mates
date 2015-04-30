
package proyecto2;

import java.util.ArrayList;
import java.util.Objects;

/**
* Clase Nodo para el árbol

* @author  Luis Daniel Medina Lugo
* @author  Alejandro Ulacia Flores
* @version 1.0
* @since   2015-04-30 
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
    
    /**
     * Setter de contenido de un nodo
     * @param contenido. Contenido a ingresar.
     */

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
    
    /**
     * Getter de hijos de un nodo, devuelve un ArrayList de tipo NodoArbol
     * @return producciones resultantes del nodo luego de aplicar una regla de produccion
     */
    
    public ArrayList<NodoArbol> getHijos() {
        return hijos;
    }
    
    /**
     * Setter de hijos de un nodo
     * @param hijos. Arraylist a ingresar.
     */
    
    public void setHijos(ArrayList<NodoArbol> hijos) {
        this.hijos = hijos;
    }
    
    /**
     * Sobreescritura del metodo hashCode
     * @return devuelve hashcode
     */
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 73 * hash + Objects.hashCode(this.contenido);
        return hash;
    }
    
    /**
     * Sobreescritura del metodo equals
     * @param obj. Checa igualdad por contenido.
     * @return devuelve verdadero si el contenido de los 2 objetos del mismo tipo sn similarer
     */
    
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
