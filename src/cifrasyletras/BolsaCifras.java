/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cifrasyletras;

import java.util.Random;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
/**
 *
 * @author isa
 */
public class BolsaCifras {
    private Random random;
    private int cantidadNumeros = 24;
    int[] resultado = new int[cantidadNumeros];

    public BolsaCifras(){
        random = new Random();
        leerFichero();
    }
    
    private void leerFichero(){
        try{
            BufferedReader br = new BufferedReader(new FileReader("src/cifrasyletras/Data/Cifras.txt"));
            String linea = br.readLine();
            br.close();
            
            char[] datos = linea.toCharArray();
            boolean esNumero = false;
            int indiceResultado = 0;
            int numeroActual = 0;

            for (char c : datos) {
                if (c >= '0' && c <= '9') {
                    numeroActual = (numeroActual * 10) + (c - '0');
                    esNumero = true;
                } else if (c == ' ' && esNumero) {
                    resultado[indiceResultado++] = numeroActual;
                    numeroActual = 0;
                    esNumero = false;
                }
            }
            
            // Si no tiene espacio igual guardamos el numero
            if (esNumero) {
                resultado[indiceResultado] = numeroActual;
            }

            // check list
            System.out.println("Numeros leidos: ");
            for (int n : resultado) {
                System.out.print(n + " ");
            }
            System.out.println(" ");

        } catch(IOException e){
            System.out.println("Error de lectura.");
        }
    }
    
    public int extraerCifra(){
        int numero = resultado[random.nextInt(cantidadNumeros)];
        return numero;
    }
    
}
