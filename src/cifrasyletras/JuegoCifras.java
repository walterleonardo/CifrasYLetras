/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cifrasyletras;

import java.util.List;
import java.util.Random;
import java.io.IOException;
/**
 *
 * @author isa
 */
        
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
    
    public int jugar(){
        int puntosJugador = 0;
        int puntosCPU = 0;
        
        
        
        for(int i=1; i<=rondas/2;i++){
            System.out.println("\n¡Comencemos con Cifras!");
            System.out.println("   ¡A Jugar!   ");
            System.out.println("--- Ronda "+i+" ---");
            System.out.println(" ");
            int[] values = new int[6];
            for (i=0; i < 6; i++) {
                values[i] = bolsa.extraerCifra();
            }

            int objetivo = 100 + random.nextInt(900);
            
            
            int resultadoJugador = turnoJugador(values,objetivo);
            int resultadoCPU = turnoCPU(values,objetivo);
            
            puntosJugador += calcularPuntos(objetivo, resultadoJugador);
            puntosCPU += calcularPuntos(objetivo, resultadoCPU);
            
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
                    resultado = elegido1 / elegido2;
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

            // System.out.println("Disponibles: ");
            // for (int j : valuesJugadas) {
            //     if (j == 0) break;
            //     System.out.print(j);
            //     System.out.print(" ");
            // }
            // System.out.println(" ");
            // System.out.println();
            
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
    
    private boolean numDis(int num, int v1,int v2,int v3,int v4,int v5,int v6,boolean vu1,boolean vu2,boolean vu3 ,boolean vu4 ,boolean vu5, boolean vu6,int r1,int r2,int r3,int r4,int r5,boolean ru1,boolean ru2,boolean ru3,boolean ru4,boolean ru5){
        
        if(num==v1 && !vu1) return true;
        if(num==v2 && !vu2) return true;
        if(num==v3 && !vu3) return true;
        if(num==v4 && !vu4) return true;
        if(num==v5 && !vu5) return true;
        if(num==v6 && !vu6) return true;
        
        if(num==r1 && !ru1) return true;
        if(num==r2 && !ru2) return true;
        if(num==r3 && !ru3) return true;
        if(num==r4 && !ru4) return true;
        if(num==r5 && !ru5) return true;
        
        return false;
    }
    
    private int turnoCPU(int[] values,  int objetivo){
        
        int r1=0, r2=0, r3=0, r4=0, r5=0;
        boolean vu1=false,vu2=false,vu3=false,vu4=false,vu5=false,vu6=false;
        boolean ru1=false, ru2=false, ru3=false, ru4=false, ru5=false;
        
        int v1 = values[0];
        int v2 = values[1];
        int v3 = values[2];
        int v4 = values[3];
        int v5 = values[4];
        int v6 = values[5];



        int[] valuesJugadas = values;
        int operacionesRealizadas = 0;
        int ResultadoCPU = 0;
        
        System.out.println("\n --- Turno de la CPU --- ");
            System.out.println("Objetivo: "+objetivo);
            System.out.print("Números disponibles: ");
            for (int j : valuesJugadas) {
                if (j == 0) continue;
                System.out.print(j);
                System.out.print(" ");
            }
            System.out.println(" ");
        

        while(operacionesRealizadas < 5){
            
            int mejorResultado = 0;
            int elegido1 = 0, elegido2 = 0;
            int operacionElegida = 0;
            int minDiferencia = Integer.MAX_VALUE;
            int a,b,c;
            
            if(!vu1 && !vu2){ 
                a=v1; 
                b=v2;
                int sum=a+b, res=a-b, mul=a*b, div=(b!=0)? a/b:Integer.MAX_VALUE;
                if(Math.abs(objetivo-sum)<minDiferencia){minDiferencia=Math.abs(objetivo-sum);mejorResultado=sum;elegido1=a;elegido2=b;operacionElegida=1;}
                if(Math.abs(objetivo-res)<minDiferencia){minDiferencia=Math.abs(objetivo-res);mejorResultado=res;elegido1=a;elegido2=b;operacionElegida=2;}
                if(Math.abs(objetivo-mul)<minDiferencia){minDiferencia=Math.abs(objetivo-mul);mejorResultado=mul;elegido1=a;elegido2=b;operacionElegida=3;}
                if(Math.abs(objetivo-div)<minDiferencia){minDiferencia=Math.abs(objetivo-div);mejorResultado=div;elegido1=a;elegido2=b;operacionElegida=4;}
            }
            if(!vu1 && !vu3){ 
                a=v1; 
                b=v3;
                int sum=a+b, res=a-b, mul=a*b, div=(b!=0)? a/b:Integer.MAX_VALUE;
                if(Math.abs(objetivo-sum)<minDiferencia){minDiferencia=Math.abs(objetivo-sum);mejorResultado=sum;elegido1=a;elegido2=b;operacionElegida=1;}
                if(Math.abs(objetivo-res)<minDiferencia){minDiferencia=Math.abs(objetivo-res);mejorResultado=res;elegido1=a;elegido2=b;operacionElegida=2;}
                if(Math.abs(objetivo-mul)<minDiferencia){minDiferencia=Math.abs(objetivo-mul);mejorResultado=mul;elegido1=a;elegido2=b;operacionElegida=3;}
                if(Math.abs(objetivo-div)<minDiferencia){minDiferencia=Math.abs(objetivo-div);mejorResultado=div;elegido1=a;elegido2=b;operacionElegida=4;}
            }
            if(!vu1 && !vu4){ 
                a=v1; 
                b=v4;
                int sum=a+b, res=a-b, mul=a*b, div=(b!=0)? a/b:Integer.MAX_VALUE;
                if(Math.abs(objetivo-sum)<minDiferencia){minDiferencia=Math.abs(objetivo-sum);mejorResultado=sum;elegido1=a;elegido2=b;operacionElegida=1;}
                if(Math.abs(objetivo-res)<minDiferencia){minDiferencia=Math.abs(objetivo-res);mejorResultado=res;elegido1=a;elegido2=b;operacionElegida=2;}
                if(Math.abs(objetivo-mul)<minDiferencia){minDiferencia=Math.abs(objetivo-mul);mejorResultado=mul;elegido1=a;elegido2=b;operacionElegida=3;}
                if(Math.abs(objetivo-div)<minDiferencia){minDiferencia=Math.abs(objetivo-div);mejorResultado=div;elegido1=a;elegido2=b;operacionElegida=4;}
            }
            if(!vu1 && !vu5){ 
                a=v1; 
                b=v5;
                int sum=a+b, res=a-b, mul=a*b, div=(b!=0)? a/b:Integer.MAX_VALUE;
                if(Math.abs(objetivo-sum)<minDiferencia){minDiferencia=Math.abs(objetivo-sum);mejorResultado=sum;elegido1=a;elegido2=b;operacionElegida=1;}
                if(Math.abs(objetivo-res)<minDiferencia){minDiferencia=Math.abs(objetivo-res);mejorResultado=res;elegido1=a;elegido2=b;operacionElegida=2;}
                if(Math.abs(objetivo-mul)<minDiferencia){minDiferencia=Math.abs(objetivo-mul);mejorResultado=mul;elegido1=a;elegido2=b;operacionElegida=3;}
                if(Math.abs(objetivo-div)<minDiferencia){minDiferencia=Math.abs(objetivo-div);mejorResultado=div;elegido1=a;elegido2=b;operacionElegida=4;}
            }
            if(!vu1 && !vu6){ 
                a=v1; 
                b=v6;
                int sum=a+b, res=a-b, mul=a*b, div=(b!=0)? a/b:Integer.MAX_VALUE;
                if(Math.abs(objetivo-sum)<minDiferencia){minDiferencia=Math.abs(objetivo-sum);mejorResultado=sum;elegido1=a;elegido2=b;operacionElegida=1;}
                if(Math.abs(objetivo-res)<minDiferencia){minDiferencia=Math.abs(objetivo-res);mejorResultado=res;elegido1=a;elegido2=b;operacionElegida=2;}
                if(Math.abs(objetivo-mul)<minDiferencia){minDiferencia=Math.abs(objetivo-mul);mejorResultado=mul;elegido1=a;elegido2=b;operacionElegida=3;}
                if(Math.abs(objetivo-div)<minDiferencia){minDiferencia=Math.abs(objetivo-div);mejorResultado=div;elegido1=a;elegido2=b;operacionElegida=4;}
            }
            if(!vu2 && !vu1){ 
                a=v2; 
                b=v1;
                int sum=a+b, res=a-b, mul=a*b, div=(b!=0)? a/b:Integer.MAX_VALUE;
                if(Math.abs(objetivo-sum)<minDiferencia){minDiferencia=Math.abs(objetivo-sum);mejorResultado=sum;elegido1=a;elegido2=b;operacionElegida=1;}
                if(Math.abs(objetivo-res)<minDiferencia){minDiferencia=Math.abs(objetivo-res);mejorResultado=res;elegido1=a;elegido2=b;operacionElegida=2;}
                if(Math.abs(objetivo-mul)<minDiferencia){minDiferencia=Math.abs(objetivo-mul);mejorResultado=mul;elegido1=a;elegido2=b;operacionElegida=3;}
                if(Math.abs(objetivo-div)<minDiferencia){minDiferencia=Math.abs(objetivo-div);mejorResultado=div;elegido1=a;elegido2=b;operacionElegida=4;}
            }
            if(!vu2 && !vu3){ 
                a=v2; 
                b=v3;
                int sum=a+b, res=a-b, mul=a*b, div=(b!=0)? a/b:Integer.MAX_VALUE;
                if(Math.abs(objetivo-sum)<minDiferencia){minDiferencia=Math.abs(objetivo-sum);mejorResultado=sum;elegido1=a;elegido2=b;operacionElegida=1;}
                if(Math.abs(objetivo-res)<minDiferencia){minDiferencia=Math.abs(objetivo-res);mejorResultado=res;elegido1=a;elegido2=b;operacionElegida=2;}
                if(Math.abs(objetivo-mul)<minDiferencia){minDiferencia=Math.abs(objetivo-mul);mejorResultado=mul;elegido1=a;elegido2=b;operacionElegida=3;}
                if(Math.abs(objetivo-div)<minDiferencia){minDiferencia=Math.abs(objetivo-div);mejorResultado=div;elegido1=a;elegido2=b;operacionElegida=4;}
            }
            if(!vu2 && !vu4){ 
                a=v2; 
                b=v4;
                int sum=a+b, res=a-b, mul=a*b, div=(b!=0)? a/b:Integer.MAX_VALUE;
                if(Math.abs(objetivo-sum)<minDiferencia){minDiferencia=Math.abs(objetivo-sum);mejorResultado=sum;elegido1=a;elegido2=b;operacionElegida=1;}
                if(Math.abs(objetivo-res)<minDiferencia){minDiferencia=Math.abs(objetivo-res);mejorResultado=res;elegido1=a;elegido2=b;operacionElegida=2;}
                if(Math.abs(objetivo-mul)<minDiferencia){minDiferencia=Math.abs(objetivo-mul);mejorResultado=mul;elegido1=a;elegido2=b;operacionElegida=3;}
                if(Math.abs(objetivo-div)<minDiferencia){minDiferencia=Math.abs(objetivo-div);mejorResultado=div;elegido1=a;elegido2=b;operacionElegida=4;}
            }
            if(!vu2 && !vu5){ 
                a=v1; 
                b=v5;
                int sum=a+b, res=a-b, mul=a*b, div=(b!=0)? a/b:Integer.MAX_VALUE;
                if(Math.abs(objetivo-sum)<minDiferencia){minDiferencia=Math.abs(objetivo-sum);mejorResultado=sum;elegido1=a;elegido2=b;operacionElegida=1;}
                if(Math.abs(objetivo-res)<minDiferencia){minDiferencia=Math.abs(objetivo-res);mejorResultado=res;elegido1=a;elegido2=b;operacionElegida=2;}
                if(Math.abs(objetivo-mul)<minDiferencia){minDiferencia=Math.abs(objetivo-mul);mejorResultado=mul;elegido1=a;elegido2=b;operacionElegida=3;}
                if(Math.abs(objetivo-div)<minDiferencia){minDiferencia=Math.abs(objetivo-div);mejorResultado=div;elegido1=a;elegido2=b;operacionElegida=4;}
            }
            if(!vu2 && !vu6){ 
                a=v2; 
                b=v6;
                int sum=a+b, res=a-b, mul=a*b, div=(b!=0)? a/b:Integer.MAX_VALUE;
                if(Math.abs(objetivo-sum)<minDiferencia){minDiferencia=Math.abs(objetivo-sum);mejorResultado=sum;elegido1=a;elegido2=b;operacionElegida=1;}
                if(Math.abs(objetivo-res)<minDiferencia){minDiferencia=Math.abs(objetivo-res);mejorResultado=res;elegido1=a;elegido2=b;operacionElegida=2;}
                if(Math.abs(objetivo-mul)<minDiferencia){minDiferencia=Math.abs(objetivo-mul);mejorResultado=mul;elegido1=a;elegido2=b;operacionElegida=3;}
                if(Math.abs(objetivo-div)<minDiferencia){minDiferencia=Math.abs(objetivo-div);mejorResultado=div;elegido1=a;elegido2=b;operacionElegida=4;}
            }
            if(!vu3 && !vu1){ 
                a=v3; 
                b=v1;
                int sum=a+b, res=a-b, mul=a*b, div=(b!=0)? a/b:Integer.MAX_VALUE;
                if(Math.abs(objetivo-sum)<minDiferencia){minDiferencia=Math.abs(objetivo-sum);mejorResultado=sum;elegido1=a;elegido2=b;operacionElegida=1;}
                if(Math.abs(objetivo-res)<minDiferencia){minDiferencia=Math.abs(objetivo-res);mejorResultado=res;elegido1=a;elegido2=b;operacionElegida=2;}
                if(Math.abs(objetivo-mul)<minDiferencia){minDiferencia=Math.abs(objetivo-mul);mejorResultado=mul;elegido1=a;elegido2=b;operacionElegida=3;}
                if(Math.abs(objetivo-div)<minDiferencia){minDiferencia=Math.abs(objetivo-div);mejorResultado=div;elegido1=a;elegido2=b;operacionElegida=4;}
            }
            if(!vu3 && !vu2){ 
                a=v3; 
                b=v2;
                int sum=a+b, res=a-b, mul=a*b, div=(b!=0)? a/b:Integer.MAX_VALUE;
                if(Math.abs(objetivo-sum)<minDiferencia){minDiferencia=Math.abs(objetivo-sum);mejorResultado=sum;elegido1=a;elegido2=b;operacionElegida=1;}
                if(Math.abs(objetivo-res)<minDiferencia){minDiferencia=Math.abs(objetivo-res);mejorResultado=res;elegido1=a;elegido2=b;operacionElegida=2;}
                if(Math.abs(objetivo-mul)<minDiferencia){minDiferencia=Math.abs(objetivo-mul);mejorResultado=mul;elegido1=a;elegido2=b;operacionElegida=3;}
                if(Math.abs(objetivo-div)<minDiferencia){minDiferencia=Math.abs(objetivo-div);mejorResultado=div;elegido1=a;elegido2=b;operacionElegida=4;}
            }
            if(!vu3 && !vu4){ 
                a=v3; 
                b=v4;
                int sum=a+b, res=a-b, mul=a*b, div=(b!=0)? a/b:Integer.MAX_VALUE;
                if(Math.abs(objetivo-sum)<minDiferencia){minDiferencia=Math.abs(objetivo-sum);mejorResultado=sum;elegido1=a;elegido2=b;operacionElegida=1;}
                if(Math.abs(objetivo-res)<minDiferencia){minDiferencia=Math.abs(objetivo-res);mejorResultado=res;elegido1=a;elegido2=b;operacionElegida=2;}
                if(Math.abs(objetivo-mul)<minDiferencia){minDiferencia=Math.abs(objetivo-mul);mejorResultado=mul;elegido1=a;elegido2=b;operacionElegida=3;}
                if(Math.abs(objetivo-div)<minDiferencia){minDiferencia=Math.abs(objetivo-div);mejorResultado=div;elegido1=a;elegido2=b;operacionElegida=4;}
            }
            if(!vu3 && !vu5){ 
                a=v3; 
                b=v5;
                int sum=a+b, res=a-b, mul=a*b, div=(b!=0)? a/b:Integer.MAX_VALUE;
                if(Math.abs(objetivo-sum)<minDiferencia){minDiferencia=Math.abs(objetivo-sum);mejorResultado=sum;elegido1=a;elegido2=b;operacionElegida=1;}
                if(Math.abs(objetivo-res)<minDiferencia){minDiferencia=Math.abs(objetivo-res);mejorResultado=res;elegido1=a;elegido2=b;operacionElegida=2;}
                if(Math.abs(objetivo-mul)<minDiferencia){minDiferencia=Math.abs(objetivo-mul);mejorResultado=mul;elegido1=a;elegido2=b;operacionElegida=3;}
                if(Math.abs(objetivo-div)<minDiferencia){minDiferencia=Math.abs(objetivo-div);mejorResultado=div;elegido1=a;elegido2=b;operacionElegida=4;}
            }
            if(!vu3 && !vu6){ 
                a=v3; 
                b=v6;
                int sum=a+b, res=a-b, mul=a*b, div=(b!=0)? a/b:Integer.MAX_VALUE;
                if(Math.abs(objetivo-sum)<minDiferencia){minDiferencia=Math.abs(objetivo-sum);mejorResultado=sum;elegido1=a;elegido2=b;operacionElegida=1;}
                if(Math.abs(objetivo-res)<minDiferencia){minDiferencia=Math.abs(objetivo-res);mejorResultado=res;elegido1=a;elegido2=b;operacionElegida=2;}
                if(Math.abs(objetivo-mul)<minDiferencia){minDiferencia=Math.abs(objetivo-mul);mejorResultado=mul;elegido1=a;elegido2=b;operacionElegida=3;}
                if(Math.abs(objetivo-div)<minDiferencia){minDiferencia=Math.abs(objetivo-div);mejorResultado=div;elegido1=a;elegido2=b;operacionElegida=4;}
            }
            if(!vu4 && !vu1){ 
                a=v4; 
                b=v1;
                int sum=a+b, res=a-b, mul=a*b, div=(b!=0)? a/b:Integer.MAX_VALUE;
                if(Math.abs(objetivo-sum)<minDiferencia){minDiferencia=Math.abs(objetivo-sum);mejorResultado=sum;elegido1=a;elegido2=b;operacionElegida=1;}
                if(Math.abs(objetivo-res)<minDiferencia){minDiferencia=Math.abs(objetivo-res);mejorResultado=res;elegido1=a;elegido2=b;operacionElegida=2;}
                if(Math.abs(objetivo-mul)<minDiferencia){minDiferencia=Math.abs(objetivo-mul);mejorResultado=mul;elegido1=a;elegido2=b;operacionElegida=3;}
                if(Math.abs(objetivo-div)<minDiferencia){minDiferencia=Math.abs(objetivo-div);mejorResultado=div;elegido1=a;elegido2=b;operacionElegida=4;}
            }
            if(!vu4 && !vu2){ 
                a=v4; 
                b=v2;
                int sum=a+b, res=a-b, mul=a*b, div=(b!=0)? a/b:Integer.MAX_VALUE;
                if(Math.abs(objetivo-sum)<minDiferencia){minDiferencia=Math.abs(objetivo-sum);mejorResultado=sum;elegido1=a;elegido2=b;operacionElegida=1;}
                if(Math.abs(objetivo-res)<minDiferencia){minDiferencia=Math.abs(objetivo-res);mejorResultado=res;elegido1=a;elegido2=b;operacionElegida=2;}
                if(Math.abs(objetivo-mul)<minDiferencia){minDiferencia=Math.abs(objetivo-mul);mejorResultado=mul;elegido1=a;elegido2=b;operacionElegida=3;}
                if(Math.abs(objetivo-div)<minDiferencia){minDiferencia=Math.abs(objetivo-div);mejorResultado=div;elegido1=a;elegido2=b;operacionElegida=4;}
            }
            if(!vu4 && !vu3){ 
                a=v4; 
                b=v3;
                int sum=a+b, res=a-b, mul=a*b, div=(b!=0)? a/b:Integer.MAX_VALUE;
                if(Math.abs(objetivo-sum)<minDiferencia){minDiferencia=Math.abs(objetivo-sum);mejorResultado=sum;elegido1=a;elegido2=b;operacionElegida=1;}
                if(Math.abs(objetivo-res)<minDiferencia){minDiferencia=Math.abs(objetivo-res);mejorResultado=res;elegido1=a;elegido2=b;operacionElegida=2;}
                if(Math.abs(objetivo-mul)<minDiferencia){minDiferencia=Math.abs(objetivo-mul);mejorResultado=mul;elegido1=a;elegido2=b;operacionElegida=3;}
                if(Math.abs(objetivo-div)<minDiferencia){minDiferencia=Math.abs(objetivo-div);mejorResultado=div;elegido1=a;elegido2=b;operacionElegida=4;}
            }
            if(!vu4 && !vu5){ 
                a=v4; 
                b=v5;
                int sum=a+b, res=a-b, mul=a*b, div=(b!=0)? a/b:Integer.MAX_VALUE;
                if(Math.abs(objetivo-sum)<minDiferencia){minDiferencia=Math.abs(objetivo-sum);mejorResultado=sum;elegido1=a;elegido2=b;operacionElegida=1;}
                if(Math.abs(objetivo-res)<minDiferencia){minDiferencia=Math.abs(objetivo-res);mejorResultado=res;elegido1=a;elegido2=b;operacionElegida=2;}
                if(Math.abs(objetivo-mul)<minDiferencia){minDiferencia=Math.abs(objetivo-mul);mejorResultado=mul;elegido1=a;elegido2=b;operacionElegida=3;}
                if(Math.abs(objetivo-div)<minDiferencia){minDiferencia=Math.abs(objetivo-div);mejorResultado=div;elegido1=a;elegido2=b;operacionElegida=4;}
            }
            if(!vu4 && !vu6){ 
                a=v4; 
                b=v6;
                int sum=a+b, res=a-b, mul=a*b, div=(b!=0)? a/b:Integer.MAX_VALUE;
                if(Math.abs(objetivo-sum)<minDiferencia){minDiferencia=Math.abs(objetivo-sum);mejorResultado=sum;elegido1=a;elegido2=b;operacionElegida=1;}
                if(Math.abs(objetivo-res)<minDiferencia){minDiferencia=Math.abs(objetivo-res);mejorResultado=res;elegido1=a;elegido2=b;operacionElegida=2;}
                if(Math.abs(objetivo-mul)<minDiferencia){minDiferencia=Math.abs(objetivo-mul);mejorResultado=mul;elegido1=a;elegido2=b;operacionElegida=3;}
                if(Math.abs(objetivo-div)<minDiferencia){minDiferencia=Math.abs(objetivo-div);mejorResultado=div;elegido1=a;elegido2=b;operacionElegida=4;}
            }
            if(!vu5 && !vu1){ 
                a=v5; 
                b=v1;
                int sum=a+b, res=a-b, mul=a*b, div=(b!=0)? a/b:Integer.MAX_VALUE;
                if(Math.abs(objetivo-sum)<minDiferencia){minDiferencia=Math.abs(objetivo-sum);mejorResultado=sum;elegido1=a;elegido2=b;operacionElegida=1;}
                if(Math.abs(objetivo-res)<minDiferencia){minDiferencia=Math.abs(objetivo-res);mejorResultado=res;elegido1=a;elegido2=b;operacionElegida=2;}
                if(Math.abs(objetivo-mul)<minDiferencia){minDiferencia=Math.abs(objetivo-mul);mejorResultado=mul;elegido1=a;elegido2=b;operacionElegida=3;}
                if(Math.abs(objetivo-div)<minDiferencia){minDiferencia=Math.abs(objetivo-div);mejorResultado=div;elegido1=a;elegido2=b;operacionElegida=4;}
            }
            if(!vu5 && !vu2){ 
                a=v5; 
                b=v2;
                int sum=a+b, res=a-b, mul=a*b, div=(b!=0)? a/b:Integer.MAX_VALUE;
                if(Math.abs(objetivo-sum)<minDiferencia){minDiferencia=Math.abs(objetivo-sum);mejorResultado=sum;elegido1=a;elegido2=b;operacionElegida=1;}
                else if(Math.abs(objetivo-res)<minDiferencia){minDiferencia=Math.abs(objetivo-res);mejorResultado=res;elegido1=a;elegido2=b;operacionElegida=2;}
                else if(Math.abs(objetivo-mul)<minDiferencia){minDiferencia=Math.abs(objetivo-mul);mejorResultado=mul;elegido1=a;elegido2=b;operacionElegida=3;}
                else if(Math.abs(objetivo-div)<minDiferencia){minDiferencia=Math.abs(objetivo-div);mejorResultado=div;elegido1=a;elegido2=b;operacionElegida=4;}
            }
            if(!vu5 && !vu3){ 
                a=v5; 
                b=v3;
                int sum=a+b, res=a-b, mul=a*b, div=(b!=0)? a/b:Integer.MAX_VALUE;
                if(Math.abs(objetivo-sum)<minDiferencia){minDiferencia=Math.abs(objetivo-sum);mejorResultado=sum;elegido1=a;elegido2=b;operacionElegida=1;}
                if(Math.abs(objetivo-res)<minDiferencia){minDiferencia=Math.abs(objetivo-res);mejorResultado=res;elegido1=a;elegido2=b;operacionElegida=2;}
                if(Math.abs(objetivo-mul)<minDiferencia){minDiferencia=Math.abs(objetivo-mul);mejorResultado=mul;elegido1=a;elegido2=b;operacionElegida=3;}
                if(Math.abs(objetivo-div)<minDiferencia){minDiferencia=Math.abs(objetivo-div);mejorResultado=div;elegido1=a;elegido2=b;operacionElegida=4;}
            }
            if(!vu5 && !vu4){ 
                a=v5; 
                b=v4;
                int sum=a+b, res=a-b, mul=a*b, div=(b!=0)? a/b:Integer.MAX_VALUE;
                if(Math.abs(objetivo-sum)<minDiferencia){minDiferencia=Math.abs(objetivo-sum);mejorResultado=sum;elegido1=a;elegido2=b;operacionElegida=1;}
                if(Math.abs(objetivo-res)<minDiferencia){minDiferencia=Math.abs(objetivo-res);mejorResultado=res;elegido1=a;elegido2=b;operacionElegida=2;}
                if(Math.abs(objetivo-mul)<minDiferencia){minDiferencia=Math.abs(objetivo-mul);mejorResultado=mul;elegido1=a;elegido2=b;operacionElegida=3;}
                if(Math.abs(objetivo-div)<minDiferencia){minDiferencia=Math.abs(objetivo-div);mejorResultado=div;elegido1=a;elegido2=b;operacionElegida=4;}
            }
            if(!vu5 && !vu6){ 
                a=v5; 
                b=v6;
                int sum=a+b, res=a-b, mul=a*b, div=(b!=0)? a/b:Integer.MAX_VALUE;
                if(Math.abs(objetivo-sum)<minDiferencia){minDiferencia=Math.abs(objetivo-sum);mejorResultado=sum;elegido1=a;elegido2=b;operacionElegida=1;}
                if(Math.abs(objetivo-res)<minDiferencia){minDiferencia=Math.abs(objetivo-res);mejorResultado=res;elegido1=a;elegido2=b;operacionElegida=2;}
                if(Math.abs(objetivo-mul)<minDiferencia){minDiferencia=Math.abs(objetivo-mul);mejorResultado=mul;elegido1=a;elegido2=b;operacionElegida=3;}
                if(Math.abs(objetivo-div)<minDiferencia){minDiferencia=Math.abs(objetivo-div);mejorResultado=div;elegido1=a;elegido2=b;operacionElegida=4;}
            }
            if(!vu6 && !vu1){ 
                a=v6; 
                b=v1;
                int sum=a+b, res=a-b, mul=a*b, div=(b!=0)? a/b:Integer.MAX_VALUE;
                if(Math.abs(objetivo-sum)<minDiferencia){minDiferencia=Math.abs(objetivo-sum);mejorResultado=sum;elegido1=a;elegido2=b;operacionElegida=1;}
                if(Math.abs(objetivo-res)<minDiferencia){minDiferencia=Math.abs(objetivo-res);mejorResultado=res;elegido1=a;elegido2=b;operacionElegida=2;}
                if(Math.abs(objetivo-mul)<minDiferencia){minDiferencia=Math.abs(objetivo-mul);mejorResultado=mul;elegido1=a;elegido2=b;operacionElegida=3;}
                if(Math.abs(objetivo-div)<minDiferencia){minDiferencia=Math.abs(objetivo-div);mejorResultado=div;elegido1=a;elegido2=b;operacionElegida=4;}
            }
            if(!vu6 && !vu2){ 
                a=v6; 
                b=v2;
                int sum=a+b, res=a-b, mul=a*b, div=(b!=0)? a/b:Integer.MAX_VALUE;
                if(Math.abs(objetivo-sum)<minDiferencia){minDiferencia=Math.abs(objetivo-sum);mejorResultado=sum;elegido1=a;elegido2=b;operacionElegida=1;}
                if(Math.abs(objetivo-res)<minDiferencia){minDiferencia=Math.abs(objetivo-res);mejorResultado=res;elegido1=a;elegido2=b;operacionElegida=2;}
                if(Math.abs(objetivo-mul)<minDiferencia){minDiferencia=Math.abs(objetivo-mul);mejorResultado=mul;elegido1=a;elegido2=b;operacionElegida=3;}
                if(Math.abs(objetivo-div)<minDiferencia){minDiferencia=Math.abs(objetivo-div);mejorResultado=div;elegido1=a;elegido2=b;operacionElegida=4;}
            }
            if(!vu6 && !vu3){ 
                a=v6; 
                b=v3;
                int sum=a+b, res=a-b, mul=a*b, div=(b!=0)? a/b:Integer.MAX_VALUE;
                if(Math.abs(objetivo-sum)<minDiferencia){minDiferencia=Math.abs(objetivo-sum);mejorResultado=sum;elegido1=a;elegido2=b;operacionElegida=1;}
                if(Math.abs(objetivo-res)<minDiferencia){minDiferencia=Math.abs(objetivo-res);mejorResultado=res;elegido1=a;elegido2=b;operacionElegida=2;}
                if(Math.abs(objetivo-mul)<minDiferencia){minDiferencia=Math.abs(objetivo-mul);mejorResultado=mul;elegido1=a;elegido2=b;operacionElegida=3;}
                if(Math.abs(objetivo-div)<minDiferencia){minDiferencia=Math.abs(objetivo-div);mejorResultado=div;elegido1=a;elegido2=b;operacionElegida=4;}
            }
            if(!vu6 && !vu4){ 
                a=v6; 
                b=v4;
                int sum=a+b, res=a-b, mul=a*b, div=(b!=0)? a/b:Integer.MAX_VALUE;
                if(Math.abs(objetivo-sum)<minDiferencia){minDiferencia=Math.abs(objetivo-sum);mejorResultado=sum;elegido1=a;elegido2=b;operacionElegida=1;}
                else if(Math.abs(objetivo-res)<minDiferencia){minDiferencia=Math.abs(objetivo-res);mejorResultado=res;elegido1=a;elegido2=b;operacionElegida=2;}
                else if(Math.abs(objetivo-mul)<minDiferencia){minDiferencia=Math.abs(objetivo-mul);mejorResultado=mul;elegido1=a;elegido2=b;operacionElegida=3;}
                else if(Math.abs(objetivo-div)<minDiferencia){minDiferencia=Math.abs(objetivo-div);mejorResultado=div;elegido1=a;elegido2=b;operacionElegida=4;}
            }
            if(!vu6 && !vu5){ 
                a=v6; 
                b=v5;
                int sum=a+b, res=a-b, mul=a*b, div=(b!=0)? a/b:Integer.MAX_VALUE;
                if(Math.abs(objetivo-sum)<minDiferencia){minDiferencia=Math.abs(objetivo-sum);mejorResultado=sum;elegido1=a;elegido2=b;operacionElegida=1;}
                if(Math.abs(objetivo-res)<minDiferencia){minDiferencia=Math.abs(objetivo-res);mejorResultado=res;elegido1=a;elegido2=b;operacionElegida=2;}
                if(Math.abs(objetivo-mul)<minDiferencia){minDiferencia=Math.abs(objetivo-mul);mejorResultado=mul;elegido1=a;elegido2=b;operacionElegida=3;}
                if(Math.abs(objetivo-div)<minDiferencia){minDiferencia=Math.abs(objetivo-div);mejorResultado=div;elegido1=a;elegido2=b;operacionElegida=4;}
            }
            
            ResultadoCPU = mejorResultado;
            
            if(!ru1){ r1 = ResultadoCPU; ru1=true;}
            else if(!ru2){ r2 = ResultadoCPU; ru2=true;}
            else if(!ru3){ r3 = ResultadoCPU; ru3=true;}
            else if(!ru4){ r4 = ResultadoCPU; ru4=true;}
            else if(!ru5){ r5 = ResultadoCPU; ru5=true;}
            
            if(elegido1==v1||elegido2==v1) vu1=true;
            else if(elegido1==v2||elegido2==v2) vu2=true;
            else if(elegido1==v3||elegido2==v3) vu3=true;
            else if(elegido1==v4||elegido2==v4) vu4=true;
            else if(elegido1==v5||elegido2==v5) vu5=true;
            else if(elegido1==v6||elegido2==v6) vu6=true;
            
            System.out.println("Operación "+ (operacionesRealizadas+1) +": "+elegido1+ ((operacionElegida==1)?" + ":(operacionElegida==2)?" - ":(operacionElegida==3)?" * ":" / ")+elegido2+" = "+ ResultadoCPU);
            
            operacionesRealizadas++;
            if(vu1 && vu2 && vu3 && vu4 && vu5 && vu6) break;
        }
        
        System.out.print("Resultado final CPU: " + ResultadoCPU);
        return ResultadoCPU;
    }
    
    private int calcularPuntos(int objetivo, int Resultado){
        int diferencia = Math.abs(objetivo-Resultado);
        
        if(diferencia == 0) return 10;
        else if(diferencia <=5) return 7;
        else if(diferencia <= 10) return 5;
        else return 0;
    }
    
}