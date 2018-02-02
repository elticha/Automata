package pkgswitch;

import java.util.Scanner;

public class Switch {

    public static void main(String[] args) {
        boolean ok = true;
        Scanner input = new Scanner(System.in);
        String cadena;
        String elementos[];  //División de la cadena por %            
        //Cadena original = Switch(#VAR#){%case#VAR#:print("TEXT");break;%}
        System.out.print("\nIngrese la cadena >> ");
        cadena = input.nextLine();
        String splitPorcentaje[] = null;
        //Split a cada posición resultante por #
        String splitResultante0[] = null;
        String splitResultante1[] = null;
        //Split a splitResultante[2] por "\"".
        String splitResultanteComillas[] = null;
        
        /*
            Hago esto por la seguridad del programa,
            ya que si el usuario metía algo así:
            Swicth(#var#)%ALGOMAS
            no podría hacer el split de manera adecuada,
            entonces, arrojo el error sin que se crashee :v
            Continúa con el algoritmo siempre y cuando no haya ocurrido
            una excepción.
        
            # PincheAutómataTodoMecoSionoRasa :v
            # PincheDiseñadorDelAutómataTodoMecoSionoRasa :v
            
            Este código le costó 3 litros de Coca Cola, sudor y sangre a ---> Luis Fernando Hernández Morales
        */
        
        try{
            splitPorcentaje = cadena.split("%");
            splitResultante0 = splitPorcentaje[0].split("#");
            splitResultante1 = splitPorcentaje[1].split("#");
            splitResultanteComillas = splitResultante1[2].split("\"");
        }catch(Exception e){
            ok = false;
            printErrorMessage();
        }
        
        if(ok){
            //Llamar a q0
            if(q0(splitResultante0[0])){
                //Transición a q1
                if(q1(splitResultante0[1])){//Si es letra se irá hacia q3
                    //Transición a q3
                    if(q3(splitResultante0[1])){
                        if(q4(splitResultante0[2])){
                            if(q5(splitResultante1[0])){
                                if(q6(splitResultante1[1])){//Si es una variable de letras
                                    
                                }else{//Si es una variable de números
                                    
                                }
                            }else{
                                printErrorMessage();
                            }
                        }else{
                            printErrorMessage();
                        }
                    }else{
                        printErrorMessage();
                    }
                }else{
                    //Transición a q2
                    if(q2(splitResultante0[1])){
                        if(q4(splitResultante0[2])){
                            if(q5(splitResultante1[0])){
                                if(q6(splitResultante1[1])){//Si es una variable de letras
                                    
                                }else{//Si es una variable de números
                                    
                                }
                            }else{
                                printErrorMessage();
                            }
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
        }
        
    }

    static void printErrorMessage() {
        System.err.println("¡¡¡ CADENA NO ADMITIDA !!!");
    }

    static boolean q0(String s) {
       return s.equals("Switch(");
       //Pero mira esa optimización papá :v
    }

    //Si es letra retorna TRUE
    //Si es número retorna FALSE
    static boolean q1(String cadenita) {
        return isLetter(cadenita.charAt(0));
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
        return s.equals("){");
    }
    
    static boolean q5(String s){
        return s.equals("case");
    }
    
    /*
    TRUE si es leta
    FALSE si es número
    */
    static boolean q6(String s){
        return isLetter(s.charAt(0));
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
