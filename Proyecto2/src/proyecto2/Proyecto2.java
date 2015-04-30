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
public class Proyecto2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Simbolo in = new Simbolo('S');
        in.insertProduction("aA");
        in.insertProduction("bB");
        Simbolo sa = new Simbolo('A');
        sa.insertProduction("a");
        Simbolo sb = new Simbolo('B');
        sb.insertProduction("b");
        sb.insertProduction("bB");
        
        String[] alfabeto = {"a","b"};
        
        Arbol tree = new Arbol(alfabeto,in);
        tree.addNoTerminal(in.toString(), in);
        tree.addNoTerminal(sa.toString(), sa);
        tree.addNoTerminal(sb.toString(), sb);
        
        System.out.println(tree.analize("bbb", 8));
        System.out.println(tree.print());
        // TODO code application logic here
    }
    
}
