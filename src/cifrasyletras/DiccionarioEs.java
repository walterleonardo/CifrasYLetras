/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cifrasyletras;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author isa
 */
public class DiccionarioEs {
    
    private Palabra p1,p2,p3,p4,p5,p6,p7,p8,p9,p10;
    private int total;
    
    public DiccionarioEs(){
        leer();
    }
    
    private void leer(){
        try{
            BufferedReader br = new BufferedReader(new FileReader("src/cifrasyletras/Data/dic_es.txt"));
            String linea;
            int i = 1;
            
            while((linea = br.readLine()) != null){
                guardar(i, new Palabra(linea));
                i++;
            }
            total = i-1;
            br.close();
            
        }catch(Exception e){
            System.out.println("Error diccionario");
        }
        
    }
    
    private void guardar(int i, Palabra p){
        
    }
    
}
