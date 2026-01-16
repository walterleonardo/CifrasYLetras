/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cifrasyletras;

import java.util.Random;

/**
 *
 * @author isa
 */

public class JuegoLetras {
    
    private int rondas;
    private LT lt;
    private BolsaLetrasEs bolsa;
    private Random random;
    private DiccionarioEs compara;

    public JuegoLetras(int rondas){
        this.rondas = rondas;
        lt = new LT();
        bolsa = new BolsaLetrasEs();
        random = new Random();
        compara = new DiccionarioEs();

    }
    
    public int jugar(){
        int puntosJugador = 0;
        int puntosCPU = 0;
        
        for(int i=1; i<=rondas/2;i++){
            System.out.println("****************");
            System.out.println("\n¡Comencemos con Letras!");
            System.out.println("   ¡A Jugar!   ");
            System.out.println("****************");
            System.out.println("--- Ronda "+i+" ---");
            
            char[] letrasJugador = new char[10];
            char[] letrasCPU = new char[10];
            
            for(i=0; i<10;i++){
                char letraRandom = bolsa.extraerLetraEs();
                letrasJugador[i] = letraRandom;
                letrasCPU[i] = letraRandom;
            }
            
            puntosJugador = turnoJugador(letrasJugador);
            puntosCPU = turnoCPU(letrasJugador);

            
        }
        
        System.out.println("****************");
        System.out.println("Resultado Final: ");
        System.out.println("Jugador: "+puntosJugador+" puntos.");
        System.out.println("CPU: "+puntosCPU+" puntos.");
        
        if(puntosJugador>puntosCPU) System.out.println("¡¡Has ganado!!");
        else if(puntosJugador<puntosCPU) System.out.println("Has perdido...jo");
        else System.out.println("¡Empate! Algo es algo, ¿no?");
        
        int puntajeLetrasC = puntosCPU;
        int puntajeLetrasJ = puntosJugador;
        
        return puntosJugador - puntosCPU;
        
    }
    
    private int turnoJugador(char[] letrasJugador){
        
        char[] letrasUtilizadas = letrasJugador;
        boolean continuar = true;
        int numeroLetrasJ = 0;

        char [] palabra = new char[10];
        while(continuar == true){
        
            System.out.println("Letras disponibles: ");
            for( char l : letrasUtilizadas){
                System.out.print(l);
                System.out.print(" ");
            }
            System.out.println(" ");
            System.out.println("Introduzca una palabra que contenga estas letras, sin espacios y pulse enter: ");
        
            palabra = lt.llegirLinia();
        
        
            System.out.println("¿seguro que quieres usar esa palabra?");
            System.out.println("1. Sí 2.No");
            char opcion = lt.llegirCaracter();
        
                if(opcion == '1'){
                    continuar = false;
                }
        }
        
        boolean encontrada = compara.buscarPalabra(palabra);
        
        if (!encontrada){
            System.out.println("Palabra no válida en este diccionario.");
        } else {
            System.out.println("Palabra válida en este diccionario.");
        }
        

        for (char s : palabra) {
            numeroLetrasJ++;
        }

        return numeroLetrasJ;
    }
    
    public int turnoCPU(char[] letrasCPU){
        
        int maxLetras = 0;
        char [] mejorPalabra = new char[10];
        
        System.out.println("************");
        System.out.println("Turno de la CPU. ");
        System.out.println("Letras disponibles de la CPU: ");
        
        for(int i=0; i<10;i++){
            System.out.print(letrasCPU[i]+" ");
        }
        System.out.println(" ");    
        
        String[] diccionario = compara.leer();
        String palabrafinal = "";
        for (String palabra : diccionario) {
            boolean encontrada=false;
                int cuantasLetras = 0;
                for (char letra : letrasCPU) {
                    int contiene = palabra.indexOf(letra);
                    //System.out.println("indice de letra " + palabra + " "+ letra + " " + contiene);
                    if (contiene != -1){
                        cuantasLetras++;
                    }
                }

                encontrada = cuantasLetras >= palabra.length();
                    
                if (encontrada && palabrafinal.length() <= 10 ){
                    //System.out.println(" Encontrada " + cuantasLetras + " >= " + palabra.length()); 
                    //for(int i=0; i<10;i++){
                    //    System.out.print(letrasCPU[i]+" ");
                    //}
                    //System.out.println(" "); 
                    //System.out.println("palabra encontrada  temporal " + palabra);
                    
                    if (palabra.length() > palabrafinal.length()) {
                        palabrafinal = palabra;
                    }
                }
        }
        System.out.println("palabra encontrada  final " + palabrafinal);
        
        maxLetras = palabrafinal.length();

        System.out.println("La CPU ha encontrado una palabra de "+ maxLetras +" Letras.");
        return maxLetras;
        
    }
    
}