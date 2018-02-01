package pkgswitch;

import java.util.Scanner;

public class Switch {

    static boolean stillBeingNumber = false;
    static boolean stillBeingLetter = false;

    public static void main(String[] args) {
        boolean ok = true;
        boolean nextPart = false;
        Scanner input = new Scanner(System.in);
        String cadena;
        String elementos[];  //División de la cadena por %            
        //Cadena original = Switch(#VAR#){%case#VAR#:print("TEXT");break;%default:print("TEXT");}
        //Cadena original = 
        // Switch(VAR)#{case VAR:print("TEXT");break;default:print("TEXT");}
        System.out.print("Ingrese la cadena >> ");
        cadena = input.nextLine();
        String separacionDeSwitch[] = cadena.split("#"); // -> Esto genera lo siguiente:
                                                         // [0] Switch(var)
                                                         // [1] {caseVAR:print("TEXT");break;default:print("TEXT");}
        String separacionSemiColon[] = separacionDeSwitch[1].split(";");
        
        for(int i = 0; i < separacionSemiColon.length; i++){
            System.out.println(separacionSemiColon[i]);
        }
        //Verificar que el usuario haya introducido -> Switch(----)
        if(q0(separacionDeSwitch[0])){
            //Validar la variable del usuario
            String variableUsuario = separacionDeSwitch[0].substring(7,separacionDeSwitch[0].length()-1);
            System.out.println("Variable = " + variableUsuario);    //OK
            //Validar si va a q2 o a q3
            if(q1(variableUsuario)){//Si es una variable de números
                //validar con q2 que la variable sea un número
                if(q2(variableUsuario)){
                    //proceder al estado q4
                    if(q4(separacionDeSwitch[0].substring(separacionDeSwitch[0].length()-1, separacionDeSwitch[0].length()))){
                        //Si la primera parte termina con ")" ----> OK
                        nextPart = true;
                    }else{
                        printErrorMessage();
                    }
                }else{
                    printErrorMessage();
                }
            }else{// si es una variable de caracteres
                //validar con q3 que la variable sea un string
                if(q3(variableUsuario)){
                    //proceder al estado q4
                    if(q4(separacionDeSwitch[0].substring(separacionDeSwitch[0].length()-1, separacionDeSwitch[0].length()))){
                        //Si la primera parte termina con ")" ----> OK
                        nextPart = true;
                    }else{
                        printErrorMessage();
                    }
                }else{
                    printErrorMessage();
                }
            }
        }else{
            printErrorMessage();
        }
        
        
        //  Si la parte del Switch salió con éxito, continuar con el complemento
        if(nextPart){
            
        }
    }

    static void printErrorMessage() {
        System.err.println("¡¡¡ CADENA NO ADMITIDA !!!");
    }

    static boolean q0(String s) {
       boolean ok = false;
       String subcadena = s.substring(0,7); //---> "Switch(" --> OK
       if(subcadena.equals("Switch(") && s.charAt(s.length()-1) == ')'){ //---> "Switch(" ")"
        ok = true;
       }
       return ok;
    }

    //Si es letra retorna FALSE
    //Si es número retorna TRUE
    static boolean q1(String cadenita) {
        if(isLetter(cadenita.charAt(0))) {
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
        if(s.equals(")")){
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
