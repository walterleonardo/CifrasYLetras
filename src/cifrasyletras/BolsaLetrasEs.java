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
    private int totalLetras;
    
    private String l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
    private String l11,l12,l13,l14,l15,l16,l17,l18,l19,l20;
    private String l21,l22,l23,l24,l25,l26,l27,l28,l29,l30;
    private String l31,l32,l33,l34,l35,l36,l37,l38,l39,l40;
    private String l41,l42,l43,l44,l45,l46,l47,l48,l49,l50;
    private String l51,l52,l53,l54,l55,l56,l57,l58,l59,l60;
    private String l61,l62,l63,l64,l65,l66,l67,l68,l69,l70;
    private String l71,l72,l73,l74,l75,l76,l77,l78,l79,l80;
    private String l81,l82,l83,l84,l85,l86,l87,l88,l89,l90;
    private String l91,l92,l93,l94,l95,l96,l97,l98,l99,l100;
    
    public BolsaLetrasEs(){
        random = new Random();
        leerFicheroEs();
    }
    
    public void leerFicheroEs(){
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/cifrasyletras/Data/letras"));
            String linea = br.readLine();
            br.close();
            
            char[] datos = linea.toCharArray();
            
            int posicion = 0;
            
            while (posicion < 100){
                String letra = String.valueOf(datos[posicion]);
                guardarLetraEs(posicion + 1, letra);
                posicion++;
            }
            
            totalLetras = 100;
            
        }catch(IOException e){
            System.out.print("Error leyendo archivo.");
        }
    }
    
    private void guardarLetraEs(int indice, String letra){
        
        switch(indice){
            case 1: l1 = letra; break;case 2: l2 = letra; break;case 3: l3 = letra; break;case 4: l4 = letra; break;case 5: l5 = letra; break;
            case 6: l6 = letra; break;case 7: l7 = letra; break;case 8: l8 = letra; break;case 9: l9 = letra; break;case 10: l10 = letra; break;
            case 11: l11 = letra; break;case 12: l12 = letra; break;case 13: l13 = letra; break;case 14: l14 = letra; break;case 15: l15 = letra; break;
            case 16: l16 = letra; break;case 17: l17 = letra; break;case 18: l18 = letra; break;case 19: l19 = letra; break;case 20: l20 = letra; break;
            case 21: l21 = letra; break;case 22: l22 = letra; break;case 23: l23 = letra; break;case 24: l24 = letra; break;case 25: l25 = letra; break;
            case 26: l26 = letra; break;case 27: l27 = letra; break;case 28: l28 = letra; break;case 29: l29 = letra; break;case 30: l30 = letra; break;
            case 31: l31 = letra; break;case 32: l32 = letra; break;case 33: l33 = letra; break;case 34: l34 = letra; break;case 35: l35 = letra; break;
            case 36: l36 = letra; break;case 37: l37 = letra; break;case 38: l38 = letra; break;case 39: l39 = letra; break;case 40: l40 = letra; break;
            case 41: l41 = letra; break;case 42: l42 = letra; break;case 43: l43 = letra; break;case 44: l44 = letra; break;case 45: l45 = letra; break;
            case 46: l46 = letra; break;case 47: l47 = letra; break;case 48: l48 = letra; break;case 49: l49 = letra; break;case 50: l50 = letra; break;
            case 51: l51 = letra; break;case 52: l52 = letra; break;case 53: l53 = letra; break;case 54: l54 = letra; break;case 55: l55 = letra; break;
            case 56: l56 = letra; break;case 57: l57 = letra; break;case 58: l58 = letra; break;case 59: l59 = letra; break;case 60: l60 = letra; break;
            case 61: l61 = letra; break;case 62: l62 = letra; break;case 63: l63 = letra; break;case 64: l64 = letra; break;case 65: l65 = letra; break;
            case 66: l66 = letra; break;case 67: l67 = letra; break;case 68: l68 = letra; break;case 69: l69 = letra; break;case 70: l70 = letra; break;
            case 71: l71 = letra; break;case 72: l72 = letra; break;case 73: l73 = letra; break;case 74: l74 = letra; break;case 75: l75 = letra; break;
            case 76: l76 = letra; break;case 77: l77 = letra; break;case 78: l78 = letra; break;case 79: l79 = letra; break;case 80: l80 = letra; break;
            case 81: l81 = letra; break;case 82: l82 = letra; break;case 83: l83 = letra; break;case 84: l84 = letra; break;case 85: l85 = letra; break;
            case 86: l86 = letra; break;case 87: l87 = letra; break;case 88: l88 = letra; break;case 89: l89 = letra; break;case 90: l90 = letra; break;
            case 91: l91 = letra; break;case 92: l92 = letra; break;case 93: l93 = letra; break;case 94: l94 = letra; break;case 95: l95 = letra; break;
            case 96: l96 = letra; break;case 97: l97 = letra; break;case 98: l98 = letra; break;case 99: l99 = letra; break;case 100: l100 = letra; break;
            
        }
    }
    
    public String extraerLetraEs(){
        int op = 1 + random.nextInt(totalLetras);
        String letra = "";
        switch(op){
            case 1: letra=l1; break;case 2: letra=l2; break;case 3: l3 = letra; break;case 4: l4 = letra; break;case 5: l5 = letra; break;
            case 6: letra=l6; break;case 7: letra=l7; break;case 8: l8 = letra; break;case 9: l9 = letra; break;case 10: l10 = letra; break;
            case 11: letra=l11; break;case 12: letra=l12; break;case 13: l13 = letra; break;case 14: l14 = letra; break;case 15: l15 = letra; break;
            case 16: letra=l16; break;case 17: letra=l17; break;case 18: l18 = letra; break;case 19: l19 = letra; break;case 20: l20 = letra; break;
            case 21: letra=l21; break;case 22: letra=l22; break;case 23: l23 = letra; break;case 24: l24 = letra; break;case 25: l25 = letra; break;
            case 26: letra=l26; break;case 27: letra=l27; break;case 28: l28 = letra; break;case 29: l29 = letra; break;case 30: l30 = letra; break;
            case 31: letra=l31; break;case 32: letra=l32; break;case 33: l33 = letra; break;case 34: l34 = letra; break;case 35: l35 = letra; break;
            case 36: letra=l36; break;case 37: letra=l37; break;case 38: l38 = letra; break;case 39: l39 = letra; break;case 40: l40 = letra; break;
            case 41: letra=l41; break;case 42: letra=l42; break;case 43: l43 = letra; break;case 44: l44 = letra; break;case 45: l45 = letra; break;
            case 46: letra=l46; break;case 47: letra=l47; break;case 48: l48 = letra; break;case 49: l49 = letra; break;case 50: l50 = letra; break;
            case 51: letra=l51; break;case 52: letra=l52; break;case 53: l53 = letra; break;case 54: l54 = letra; break;case 55: l55 = letra; break;
            case 56: letra=l56; break;case 57: letra=l57; break;case 58: l58 = letra; break;case 59: l59 = letra; break;case 60: l60 = letra; break;
            case 61: letra=l61; break;case 62: letra=l62; break;case 63: l63 = letra; break;case 64: l64 = letra; break;case 65: l65 = letra; break;
            case 66: letra=l66; break;case 67: letra=l67; break;case 68: l68 = letra; break;case 69: l69 = letra; break;case 70: l70 = letra; break;
            case 71: letra=l71; break;case 72: letra=l72; break;case 73: l73 = letra; break;case 74: l74 = letra; break;case 75: l75 = letra; break;
            case 81: letra=l81; break;case 82: letra=l82; break;case 83: l83 = letra; break;case 84: l84 = letra; break;case 85: l85 = letra; break;
            case 86: letra=l86; break;case 87: letra=l87; break;case 88: l88 = letra; break;case 89: l89 = letra; break;case 90: l90 = letra; break;
            case 91: letra=l91; break;case 92: letra=l92; break;case 93: l93 = letra; break;case 94: l94 = letra; break;case 95: l95 = letra; break;
            case 96: letra=l96; break;case 97: letra=l97; break;case 98: l98 = letra; break;case 99: l99 = letra; break;case 100: l100 = letra; break;
        }
        return letra;
    }
    
}
