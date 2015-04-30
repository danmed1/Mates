package proyecto2;

import java.util.ArrayList;

/**
 * Clase para guardar reglas de producción en un simbolo.
 *
 * @author Luis Daniel Medina Lugo
 * @author Alejandro Ulacia Flores
 * @version 1.0
 * @since 2015-04-30
 */
public class Simbolo {

    private char caracter;
    private ArrayList<String> produccion;

    public Simbolo(char caracter) {
        this.caracter = caracter;
        this.produccion = new ArrayList<>();
    }

    /**
     * Gettter de Caracter de un Simbolo
     * @return caracter
     */
    public char getCaracter() {
        return caracter;
    }

    /**
     * Setter de caracter de un Simbolo.
     *
     * @param caracter. Caracter a ingresar.
     */
    public void setCaracter(char caracter) {
        this.caracter = caracter;
    }

    /**
     * Getter de producciones de un simbolo
     * @return ArrayList de Produccines
     */
    public ArrayList<String> getProduccion() {
        return produccion;
    }

    /**
     * Setter de producciones de un Simbolo
     *
     * @param produccion. Arraylist a ingresar.
     */
    public void setProduccion(ArrayList<String> produccion) {
        this.produccion = produccion;
    }

    /**
     * Sobreescritura del metodo toString, imprime el caracter seguido de todas
     * sus producciones.
     * @return formato de impresión
     */
    @Override
    public String toString() {
        return caracter + " -> " + produccion;
    }

    /**
     * Sobreescritura del metodo equals. compara objetos por su caracter.
     * @param obj objeto a comparar.
     * @return verdadero si el caracter del otro objeto del mismo tipo es similar
     */
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

    /**
     * Metodo para insertar una produccion al simbolo
     *
     * @param str. Produccion a la que se convierte el simbolo.
     */
    public void insertProduction(String str) {
        if (!produccion.contains(str)) {
            produccion.add(str);
        }
    }
}
