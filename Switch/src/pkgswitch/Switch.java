package pkgswitch;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Switch {

    static boolean stillBeingNumber = false;
    static boolean stillBeingLetter = false;

    public static void main(String[] args) {
        boolean ok = true;
        Scanner input = new Scanner(System.in);
        String cadena;
        String elementos[];  //División de la cadena por %            
        //Cadena original = Switch(#VAR#){%case#VAR#:print("TEXT");break;%default:print("TEXT");}
        System.out.print("Ingrese la cadena >> ");
        cadena = input.nextLine();
        elementos = cadena.split("%");
        String elementos_gato1[] = null;// = elementos[0].split("#");
        String elementos_gato2[] = null;// = elementos[1].split("#");
        String elementos_gato3[] = null;// = elementos[2].split("\"");

        try {
            elementos_gato1 = elementos[0].split("#");
            elementos_gato2 = elementos[1].split("#");
            elementos_gato3 = elementos[2].split("\"");
        } catch (IndexOutOfBoundsException e) {
            printErrorMessage();
            ok = false;
        }

        if (ok) {
            for (int i = 0; i < elementos.length; i++) {
                System.out.println(elementos[i]);
            }
            System.out.println("**************************");
            for (int i = 0; i < elementos_gato1.length; i++) {
                System.out.println(elementos_gato1[i]);
            }
            System.out.println("****************");
            for (int i = 0; i < elementos_gato2.length; i++) {
                System.out.println(elementos_gato2[i]);
            }
            System.out.println(elementos[2]);
            System.out.println("**************************");

            String ult[] = elementos_gato2[2].split("\"");
            for (int i = 0; i < ult.length; i++) {
                System.out.println(ult[i]);
            }
            System.out.println("****************");
            for (int i = 0; i < elementos_gato3.length; i++) {
                System.out.println(elementos_gato3[i]);
            }
            System.out.println("************************\n\n\n");
            
            if (q0(elementos_gato1)) {
                if (q1(elementos_gato1[1])) {//Si recibo puros numeros
                    if (q2(elementos_gato1[1])) {
                        //q4
                        if(q4(elementos_gato1[2])){
                            System.out.println(" >>>>>> " + elementos_gato2[0]);
                            if(q5(elementos_gato2[0])){
                                
                            }else{
                                printErrorMessage();
                            }
                        }else{
                            printErrorMessage();
                        }
                    } else {
                        printErrorMessage();
                    }
                } else if (!q1(elementos_gato1[1])) {
                    //c va a q3()
                    //q3(elementos_gato1[1]);
                    if (q3(elementos_gato1[1])) {
                        //q4
                        if(q4(elementos_gato1[2])){
                            System.out.println(" >>>>>> " + elementos_gato2[0]);
                            if(q5(elementos_gato2[0])){
                                
                            }else{
                                printErrorMessage();
                            }
                        }else{
                            printErrorMessage();
                        }
                    } else {
                        printErrorMessage();
                    }
                } else {
                    printErrorMessage();
                }
            } else {
                printErrorMessage();
            }
        }
    }

    static void printErrorMessage() {
        System.err.println("¡¡¡ CADENA NO ADMITIDA !!!");
    }

    static boolean q0(String s[]) {
        boolean ok = true;
        if (!s[0].equals("Switch(")) {
            ok = false;
        }
        return ok;
    }

    static boolean q1(String cadenita) {
        if (isLetter(cadenita.charAt(0))) {
            return false;
        } else {
            return true;
        }
    }

    static boolean q2(String cadenita) {
        boolean bandera = false;
        int i = 0;
        while (i < cadenita.length()) {
            if (isDigit(cadenita.charAt(i))) {
                bandera = true;
            } else {
                bandera = false;
                break;
            }
            i++;
        }
        return bandera;
    }

    static boolean q3(String cadenita) {
        boolean bandera = false;
        int i = 0;
        while (i < cadenita.length()) {
            if (isLetter(cadenita.charAt(i))) {
                bandera = true;
            } else {
                bandera = false;
                break;
            }
            i++;
        }
        return bandera;
    }
    
    static boolean q4(String s){
        if(s.equals(")}")){
            return true;
        }else{
            return false;
        }
    }
    
    static boolean q5(String s){
        System.out.println("S = " + s);
        if(s.equals("case")){
            return true;
        }else{
            return false;
        }
    }

    static boolean isLetter(char c) {
        int asciiCode = (int)c;
        for (int i = 65; i <= 90; i++) {
            if (asciiCode == i) {
                return true;
            }
        }
        for (int k = 97; k <= 122; k++) {
            if (asciiCode == k) {
                return true;
            }
        }
        return false;
    }

    static boolean isDigit(char c) {
        int asciiCode = (int)c;
        for (int i = 48; i <= 57; i++) {
            if (asciiCode == i) {
                return true;
            }
        }
        return false;
    }
}
