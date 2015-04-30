/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2;

/**
 *
 * @author Dan
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String h="hola";
        int sp=16;
        h=String.format("%1$" + sp + "s", h)+"*";
        System.out.println(h);
    }
    
}
