import java.util.List;
import java.util.Random;
import java.io.IOException;
 
public class JuegoCifras {
    
    private LT lt;
    private int rondas;
    private BolsaCifras bolsa;
    private Random random;
    
    public JuegoCifras(int rondas){
        this.rondas = rondas;
        lt = new LT();
        bolsa = new BolsaCifras();
        random = new Random();
        
    }
    
    public void jugar(){
        int puntosJugador = 0;
        int puntosCPU = 0;
        
        
        
        for(int i=1; i<=rondas/2;i++){
            System.out.println("****************");
            System.out.println("\n¡Comencemos con Cifras!");
            System.out.println("   ¡A Jugar!   ");
            System.out.println("****************");
            System.out.println("--- Ronda "+i+" ---");
            System.out.println(" ");
            int[] valuesJugador = new int[6];
            int[] valuesCpu = new int[6];
            for (i=0; i < 6; i++) {
                int valorRandom = bolsa.extraerCifra();
                valuesJugador[i] = valorRandom;
                valuesCpu[i] = valorRandom;
            }
            int objetivo = 100 + random.nextInt(999);
            
            
            int resultadoJugador = turnoJugador(valuesJugador, objetivo);
            int resultadoCPU = turnoCPU(valuesCpu, objetivo);
            
            puntosJugador += calcularPuntos(objetivo, resultadoJugador);
            puntosCPU += calcularPuntos(objetivo, resultadoCPU);
            
            System.out.println("Jugador: "+resultadoJugador+" son "+puntosJugador+" puntos.");
            System.out.println("CPU: "+resultadoCPU+" son "+puntosCPU+" puntos.");
            
            
        }
        
        System.out.println("****************");
        System.out.println("Resultado Final: ");
        System.out.println("Jugador: "+puntosJugador+" puntos.");
        System.out.println("CPU: "+puntosCPU+" puntos.");
        
        if(puntosJugador<puntosCPU) System.out.println("¡¡Has ganado!!");
        else if(puntosJugador>puntosCPU) System.out.println("Has perdido...jo");
        else System.out.println("¡Empate! Algo es algo, ¿no?");
        
    }
    
    private int turnoJugador(int[] values, int objetivo){
        int[] valuesJugadas = values;
        int operacionesRealizadas = 0;
        int resultado = 0;
        boolean continuar = true;
        
        while(operacionesRealizadas < 5 && continuar){
            System.out.println("Objetivo: "+objetivo);
            System.out.print("Números disponibles: ");
            for (int j : valuesJugadas) {
                if (j == 0) continue;
                System.out.print(j);
                System.out.print(" ");
            }
            System.out.println(" ");
            System.out.println("Introduce dos números de los disponibles: ");
        
            int elegido1 = lt.llegirEnter();
            int elegido2 = lt.llegirEnter();
        
            int indice1 = -1;
            int indice2 = -1;
            
            int cuenta = 0;
            boolean existe1 = false;
            for (int i : valuesJugadas) {
                if (i == elegido1) {
                    indice1 = cuenta;
                    existe1 = true;
                    break; // Detiene el bucle al encontrarlo
                }
                cuenta ++;
            }
            cuenta = 0;
            boolean existe2 = false;
            for (int i : valuesJugadas) {
                if (i == elegido2) {
                    indice2 = cuenta;
                    existe2 = true;
                    break; // Detiene el bucle al encontrarlo
                }
                cuenta ++;
            }

            if (!existe2 || !existe1) {
                    System.out.println("##################");
                    System.out.println("Elemento no encontrado");
                    System.out.println("##################");
                    System.out.println(" ");
                continue;
            }

        
            System.out.println("Elige la operación: 1.+ 2.- 3.* 4./");
            int operacion = lt.llegirEnter();
            resultado = 0;
            int resultadoTemporal = 0;
        
            switch(operacion){
                case 1:
                    resultado = elegido1 + elegido2; 
                    break;
                case 2:
                    resultado = elegido1 - elegido2; 
                    break;
                case 3:
                    resultado = elegido1 * elegido2; 
                    break;
                case 4:
                    resultadoTemporal = elegido1 / elegido2;
                    if (resultadoTemporal % 1 != 0) {
                        System.out.println(resultadoTemporal + " El resultado no es un entero."); // Se ejecutará
                    } else {
                        resultado = resultadoTemporal;
                    }
                    break;
                default:
                    System.out.println("##################");
                    System.out.println("Operación invalida");
                    System.out.println("##################");
                    System.out.println(" ");
                    continue;
            }
            
            valuesJugadas[indice1] = resultado;
            valuesJugadas[indice2] = 0;      
            System.out.println("Este es tu resultado actual: " + resultado);

            
            operacionesRealizadas++;
            
            if(operacionesRealizadas < 5){
                System.out.println("¿Quieres plantarte en este resultado? 1.Sí 2.No");
                try{
                    int opcion = lt.llegirEnter();
                    if(opcion==1) continuar = false;
                } catch(Exception e){
                    System.out.println("##################");
                    System.out.println("Si no has seleccionado nada supongo que quieres seguir.");
                    System.out.println("##################");
                    System.out.println(" ");
                }
            }
        
        }
        
        return resultado; 
    }

     private int turnoCPU(int[] values,  int objetivo){
     int[] valuesJugadas = values;
        int operacionesRealizadas = 0;
        int resultado = 0;        
        System.out.println("\n --- Turno de la CPU --- ");
        System.out.println("Objetivo: "+objetivo);
        System.out.print("Números disponibles: ");
        for (int j : valuesJugadas) {
            if (j == 0) continue;
            System.out.print(j);
            System.out.print(" ");
        }
        System.out.println(" ");


        while(operacionesRealizadas < 10){
            operacionesRealizadas++;
            //multiplicamos
                System.out.println(" Pensando... ");
                int resultadoTemporal = 1;
                int[]  valuesJugadasTemporal = valuesJugadas;
                for (int i=0; i < 5; i++) {
                    for (int x=1; x < 6; x++) {
                        resultadoTemporal =  valuesJugadasTemporal[i] * valuesJugadasTemporal[x] * resultadoTemporal;
                        if (resultadoTemporal > objetivo ) resultadoTemporal= 1;
                        if (resultadoTemporal > resultado) {
                            resultado = resultadoTemporal;
                        }
                    }             
                }
                System.out.println(" Pensando... Resultado final  MULTIPLICACION "+ resultado);
             //Sumamos
                System.out.println(" Pensando... ");
                valuesJugadasTemporal = valuesJugadas;
                resultadoTemporal = resultado;
                for (int i=0; i < 5; i++) {
                    for (int x=1; x < 6; x++) {
                        resultadoTemporal = valuesJugadasTemporal[i] + valuesJugadasTemporal[x] + resultadoTemporal;
                        if (resultadoTemporal > objetivo ) resultadoTemporal = resultado;
                        if (resultadoTemporal > resultado) {
                            resultado = resultadoTemporal;
                        }
                    }             
                }
                
                System.out.println(" Pensando... Resultado final SUMA"+ resultado);
        }
        System.out.println(" Resultado " + resultado );
        System.out.println("****************");
        return resultado;
    }

    
    public int calcularPuntos(int objetivo, int Resultado){
        int diferencia = Math.abs(objetivo-Resultado);
        
        int puntajeCifrasJ; 
        if(diferencia == 0) puntajeCifrasJ =10;
        else if(diferencia <=5) puntajeCifrasJ =7;
        else if(diferencia <= 10) puntajeCifrasJ =5;
        else puntajeCifrasJ =0;
        
        int puntajeCifrasC; 
        if(diferencia == 0) puntajeCifrasC =10;
        else if(diferencia <=5) puntajeCifrasC =7;
        else if(diferencia <= 10) puntajeCifrasC =5;
        else puntajeCifrasC =0;
        
        
         
        return diferencia;
    }
    
}