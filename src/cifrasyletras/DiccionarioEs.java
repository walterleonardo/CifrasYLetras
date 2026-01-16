/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cifrasyletras;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author isa
 */
public class DiccionarioEs {
    
    //private Palabra p1,p2,p3,p4,p5,p6,p7,p8,p9,p10;
    //private int total;
    String[] dict;

    public DiccionarioEs(){
        leer();
    }
    
    public String[] leer(){
        try{
            int total = 0;
            
            System.out.println("Cargamos el diccionario ");

            File archivo = new File("src/cifrasyletras/Data/dic_es.txt");

            Scanner scannerContador = new Scanner(archivo);
            int numeroPalabra = 0;
            while (scannerContador.hasNextLine()) {
                total++;
                scannerContador.nextLine();
            }
            scannerContador.close();

            Scanner scanner = new Scanner(archivo);
            System.out.println("***********************************");  
            System.out.println("Palabras en el diccionario:" + total);

            dict = new String[total];

            while (scanner.hasNextLine()) {
                String palabra = scanner.nextLine();
                if (palabra != null) {
                    dict[numeroPalabra] = palabra;
                    numeroPalabra++;
                }
            }
            scanner.close();



        }catch(Exception e){
            System.out.println("Error diccionario");
        }
        return dict;
    }
    
    public boolean  buscarPalabra(char[] palabraAbuscar){
        for (String palabra : dict) {
                if (palabra != null && palabra.contentEquals(palabraAbuscar.toString()))System.out.println("PALABRA ENCONTRADA " + palabra);
        return true;
            }
            return false;
    }
    
}