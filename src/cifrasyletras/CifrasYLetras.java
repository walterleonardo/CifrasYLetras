/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cifrasyletras;

public class CifrasYLetras {

    LT lt = new LT();
    
    private boolean salirMenu = false;
    
    public static void main(String[] args) {
       
        CifrasYLetras app = new CifrasYLetras();
        app.menu();
        
    }
    
    public CifrasYLetras(){
        
        lt = new LT();
        salirMenu = false;
    }
    
    
    private void menu(){
        
        while(!salirMenu){
        
            System.out.println("\nBienvenido a Cifras Y Letras");
            System.out.println("MENU PRINCIPAL");
            System.out.println("1. Jugar");
            System.out.println("2.Registro de Partidas");
            System.out.println(" S.Salir");
            System.out.print("Inserta un número: ");
        
            char selection = lt.llegirCaracter();
       
            if(selection == '1'){
                menuJugar();
            }else if(selection == '2'){
                partidasJugadas();
            }else if(selection == 'S'){
                salir();
            } else {
                System.out.println("Opción no válida.");
            }
        }
    }
    
    private void menuJugar(){
        
        boolean volver = false;
        
        while(!volver){
            System.out.println("\n Vamos a Jugar!");
            System.out.print(" 1.Jugar contra la CPU\n 2.Jugar contra otro jugador\n M.Volver al menu\n");
            System.out.print("Inserta un número: ");
            
            char selection = lt.llegirCaracter();
            
            if (selection == '1'){
                jugarContraCPU();
            }else if(selection == '2'){
//                jugarContraOtroJugador();
            }else if(selection == 'M'){
                volver = true;
            }else{
                System.out.print("Opción no válida");
            }
            
        }
        
    }
    
    private void jugarContraCPU(){
        
        boolean numeroValido = false;
        int nRondas = 0;
        
        while(!numeroValido){
            System.out.println("\n Has elegido jugar contra la CPU");
            System.out.println("¿Cuántas rondas quieres jugar? Introduce un número de rondas (par y >=2): ");
            
            nRondas = lt.llegirEnter();
            
            if(nRondas >= 2 && nRondas % 2 == 0){
                numeroValido = true;
            }else{
                System.out.println("Número de rondas incorrecto.");
            }
        }
        
        iniciarJuegos(nRondas);
        
    }
    
    private void iniciarJuegos(int nRondas){
        System.out.println("\n Comienza la partida con " + nRondas + " rondas.");
        
        JuegoCifras juegoCifras = new JuegoCifras(nRondas);
        juegoCifras.jugar();
        
        JuegoLetras juegoLetras = new JuegoLetras(nRondas);
        juegoLetras.jugar();
    }
    
    
    private void salir(){
        System.out.println("Has salido del programa.\nGracias por Jugar.\n");
        salirMenu = true;
    }
    
    private void partidasJugadas(){
        System.out.println("\n REGISTRO DE PARTIDAS: ");
        
    }
}
