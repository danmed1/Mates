
package proyecto2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
* <h1>Generador de una gramatica.</h1>
* El programa Principal apartir de un documento genera la gramatica buscando una cadena
* de caracteres ingresada y en una altura igualmente establecida por el usuario.

* @author  Luis Daniel Medina Lugo
* @author  Alejandro Ulacia Flores
* @version 1.0
* @since   2015-04-30 
*/
public class Principal {

    private static ArrayList<Simbolo> terminales = new ArrayList<>();

    /**
     * Este es el metodo main que apartir de un archivo lee y contruye la gramatica
     * y realiza su árbol de derivaciones
     * @param args Unused
     */
    public static void main(String[] args) {

        File list = new File("gramatica.txt");
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
                int index = gramatica.indexOf(new Simbolo(produccion[0].charAt(0)));
                gramatica.get(index).getProduccion().add(produccion[1]);
            }            

            System.out.println("Gramatica");
            for (Simbolo aux : tree.getNoTerminales().values()) {
                System.out.println(aux);
            }
            System.out.println("\nÁrbol");
            String input = JOptionPane.showInputDialog("Escriba la cadena que desea comprobar");
            int profundidad = Integer.parseInt(JOptionPane.showInputDialog("Escriba el nivel de profundidad del árbol"));
            if(tree.analize(input, profundidad)){
                System.out.println(tree.print());
            }else{
                System.out.println("No se encontró una solución para la cadena");
            }           
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
