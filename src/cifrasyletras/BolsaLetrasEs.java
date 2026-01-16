/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cifrasyletras;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class BolsaLetrasEs {
    private Random random;

    private char[] datos;
    

    public BolsaLetrasEs(){
        random = new Random();
        leerFicheroEs();
    }
    
    public void leerFicheroEs(){
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/cifrasyletras/Data/letras_es.txt"));
            String linea = br.readLine();
            br.close();
            
            datos = linea.toCharArray();
              System.out.print("Letras leidas: ");
            for (int j : datos) {
                if (j == 0) continue;
                System.out.print( (char) j);
            }
            System.out.println(" ");            
        }catch(IOException e){
            System.out.print("Error leyendo archivo.");
        }
    }
    
    public char extraerLetraEs(){
        char letra = datos[random.nextInt(0,99)];
        return letra;
    }
    
}