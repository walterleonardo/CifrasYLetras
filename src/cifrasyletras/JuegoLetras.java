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
    
    public JuegoLetras(int rondas){
        this.rondas = rondas;
        lt = new LT();
        bolsa = new BolsaLetrasEs();
        random = new Random();
        
    }
    
    public int jugar(){
        int puntosJugador = 0;
        int puntosCPU = 0;
        
        for(int i=1; i<=rondas/2;i++){
            System.out.println("\n¡Comencemos con Letras!");
            System.out.println("   ¡A Jugar!   ");
            System.out.println("--- Ronda "+(i/2)+" ---");
            
            String letra1 = bolsa.extraerLetraEs();
            String letra2 = bolsa.extraerLetraEs();
            String letra3 = bolsa.extraerLetraEs();
            String letra4 = bolsa.extraerLetraEs();
            String letra5 = bolsa.extraerLetraEs();
            String letra6 = bolsa.extraerLetraEs();
            String letra7 = bolsa.extraerLetraEs();
            String letra8 = bolsa.extraerLetraEs();
            String letra9 = bolsa.extraerLetraEs();
            String letra10 = bolsa.extraerLetraEs();
            
            System.out.println("Letras disponibles: " + letra1 + " " + letra2 + " " + letra3 + " " + letra4 + " " + letra5 + " "+letra6+" "+ letra7+" "+letra8+" "+letra9+" "+letra10);
            
            int resultadoJugador = turnoJugador(letra1,letra2,letra3,letra4,letra5,letra6,letra7,letra8,letra9,letra10);
            int resultadoCPU = turnoCPU(letra1,letra2,letra3,letra4,letra5,letra6,letra7,letra8,letra9,letra10);
            
            puntosJugador += calcularPuntos(palabraJugador);
            puntosCPU += calcularPuntos(palabraCPU);
            
            System.out.println("Jugador: "+resultadoJugador+" son "+puntosJugador+" puntos.");
            System.out.println("CCPU: "+resultadoCPU+" son "+puntosCPU+" puntos.");
               
            
        }
        
        System.out.println("Resultado Final: ");
        System.out.println("Jugador: "+puntosJugador+" puntos.");
        System.out.println("CPU: "+puntosCPU+" puntos.");
        
        if(puntosJugador>puntosCPU) System.out.println("¡¡Has ganado!!");
        else if(puntosJugador<puntosCPU) System.out.println("Has perdido...jo");
        else System.out.println("¡Empate! Algo es algo, ¿no?");
        
        return puntosJugador - puntosCPU;
        
    }
    
    private int turnoJugador(String letra1,String letra2,String letra3,String letra4,String letra5,String letra6,String letra7,String letra8,String letra9,String letra10){
        
    }
    
    private int turnoCPU(String letra1,String letra2,String letra3,String letra4,String letra5,String letra6,String letra7,String letra8,String letra9,String letra10){
        
    }
    
    private int calcularPuntos(String palabra){
        
    }
    
}
