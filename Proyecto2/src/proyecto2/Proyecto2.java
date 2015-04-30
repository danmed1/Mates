/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 * @author Dan
 */
public class Proyecto2 {

    private static ArrayList<Simbolo> terminales = new ArrayList<>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        File list = new File("prueba.txt");
        try {
            FileReader fileReader = new FileReader(list);
            BufferedReader reader = new BufferedReader(fileReader);
            String line = null;

            //Inicialización de Gramatica
            line = reader.readLine();
            String[] noTerminales = line.split(",");
            ArrayList<Simbolo> gramatica = new ArrayList<>();
            for (String aux : noTerminales) {
                Simbolo tem = new Simbolo(aux.charAt(0));
                gramatica.add(tem);
            }

            //Arreglo de Simbolos Terminales
            line = reader.readLine();
            String[] sTerminales = line.split(",");
            for (String aux : sTerminales) {
                Simbolo tem = new Simbolo(aux.charAt(0));
                terminales.add(tem);
            }

            //Inicializa árbol
            line = reader.readLine();
            Arbol tree = new Arbol(line);
            for (Simbolo aux : gramatica) {
                tree.addNoTerminal(aux.getCaracter() + "", aux);
            }

            //Llena la gramatica
            while ((line = reader.readLine()) != null) {
                String[] produccion = line.split("->");

                gramatica.get(gramatica.indexOf(produccion[0])).getProduccion().add(produccion[1]);
            }

            Simbolo in = new Simbolo('S');
            in.insertProduction("aA");
            in.insertProduction("bB");
            Simbolo sa = new Simbolo('A');
            sa.insertProduction("a");
            Simbolo sb = new Simbolo('B');
            sb.insertProduction("b");
            sb.insertProduction("bB");

            tree.addNoTerminal(in.toString(), in);
            tree.addNoTerminal(sa.toString(), sa);
            tree.addNoTerminal(sb.toString(), sb);

            System.out.println("Gramatica");
            for (Simbolo aux : tree.getNoTerminales().values()) {
                System.out.println(aux);
            }
            System.out.println("Gramatica");
            System.out.println(tree.print());

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
