package pkgswitch;

import java.util.Scanner;

/**
 * Autómata para la estructura Switch().
 * Materia: Lenguajes y Autómatas.
 * Fecha: 01 de febrero de 2018
 * Lugar: UP-Chiapas 5º "A"
 * @author David Pérez S.
 */
public class Switch {

      static String[] elementos;          // = cadena.split("%");
      static String[] elementosGatitos;          // Almacena los arreglos de String llamados "elementos_gatoX"
      static String[] elementos_gato1;        // = elementos[1].split("#");
      static String[] elementos_gato2;        // = elementos[1].split("#");
      static String[] elementos_comillas;     // = elementos_gato2[1].split("\"");
      static int posicionCase= 1;

      public static void main(String[] args) {

            boolean ok = true;
            Scanner lecturaTeclado = new Scanner(System.in);
            String cadena;
            //Cadena original = Switch(#VAR#){%case#VAR#:print("TEXT");break;%}
            System.out.println(" Autómata para la estructura Switch()");
            System.out.println("-------------------------------------------------------------\n\n");
            System.out.print(" Ingrese cadena a validar >> ");
            cadena = lecturaTeclado.nextLine();
            System.out.println("\n\n");
            try {
                  elementos = cadena.split("%");      //División de la cadena introducida por el usuario, por "%"
                  elementos_gato1 = elementos[0].split("#");
                  elementos_gato2 = elementos[1].split("#");
                  elementos_comillas = elementos_gato2[2].split("\"");
            } catch (IndexOutOfBoundsException e) {
                  printErrorMessage();
                  ok = false;
            }
            /*
            if (ok) {
                  // Impresión de datos opcional
                  System.out.println(" Subdivisiones manejadas internamente");
                  System.out.println(" -----------------------------------------------------------\n");
                  for (int i = 0; i < elementos.length; i++) {
                        System.out.println(" " + elementos[i]);
                  }
                  System.out.println("**************************");
                  for (int i = 0; i < elementos_gato1.length; i++) {
                        System.out.println(" " + elementos_gato1[i]);
                  }
                  System.out.println("****************");
                  for (int i = 0; i < elementos_gato2.length; i++) {
                        System.out.println(" " + elementos_gato2[i]);
                  }
                  System.out.println("**************************");
                  for (int i = 0; i < elementos_comillas.length; i++) {
                        System.out.println(" " + elementos_comillas[i]);
                  }
                  System.out.println("************************\n\n\n");
            }
            */
            try {
                  // Comienza lógica del Autómata
                  if (ok) {
                        System.out.println(" Transiciones");
                        System.out.println(" ---------------------------\n");
                        if (q0(elementos_gato1[0])) {             // Si se lee la palabra "Switch("
                              System.out.println(" (q0, Switch(#, q1)");
                              if (q1(elementos_gato1[1])) {         //Si recibo un número
                                    System.out.println(" (q1, " + elementos_gato1[1] + ", q2)");
                                    if (q2(elementos_gato1[1])) {     // Si recibo puros números
                                          System.out.println(" (q2, e, q4)");
                                          if (q4(elementos_gato1[2])) {   // Comprobar el paréntesis de cierre y llave de apertura
                                                System.out.println(" (q4, #){, q5)");
                                                if (q5(elementos_gato2[0])) {     // Comprobar palabra "case"
                                                      System.out.println(" (q5, %case#, q6)");
                                                      if (redundanciaDeCase(elementos_gato2[1])) {
                                                            if (q12(elementos[2])) {
                                                                  System.out.println(" (q15, %}, q16)");
                                                                  System.out.println("\n\n FELICIDADES !!!");
                                                            } else {
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
                                    } else {
                                          printErrorMessage();
                                    }
                              } else if (q1Aux(elementos_gato1[1])) {     //Si recibo una letra
                                    System.out.println(" (q1, " + elementos_gato1[1] + ", q3)");
                                    if (q3(elementos_gato1[1])) {           // Si recibo puras letras
                                          System.out.println(" (q3, e, q4)");
                                          if (q4(elementos_gato1[2])) {         // Comprobar el paréntesis de cierre y llave de apertura
                                                System.out.println(" (q4, #){, q5)");
                                                if (q5(elementos_gato2[0])) {     // Comprobar palabra "case"
                                                      System.out.println(" (q5, %case#, q6)");
                                                      if (redundanciaDeCase(elementos_gato2[1])) {
                                                            if (q12(elementos[2])) {
                                                                  System.out.println(" (q15, %}, q16)");
                                                                  System.out.println("\n\n FELICIDADES !!!");
                                                            } else {
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
            } catch (StringIndexOutOfBoundsException e) {
                  printErrorMessage();
            }
            System.out.println("\n\n Integrantes de Equipo:");
            System.out.println(" --------------------------------");
            System.out.println(" * David Pérez S.");
            System.out.println(" * Luis Fernando Hernández Morales.");
            System.out.println(" * Carlos André Sánchez Malpica\n\n");
      }

      static boolean redundanciaDeCase(String cadenaAux) {

            boolean bandera = false;
            String elementosCase= cadenaAux;

            if (q6(elementosCase)) {     //Si vuelvo a recibir un número
                  System.out.println(" (q6, " + elementosCase + ", q7)");
                  if (q7(elementosCase)) { // Si vuelvo a recibir puros números
                        System.out.println(" (q8, e, q9)");
                        if (q9(elementos_comillas[0])) {          // Se comprueba la palabra ":print("
                              System.out.println(" (q9, #:, q10)");
                              System.out.println(" (q10, print(\", q11)");
                              if (q10(elementos_comillas[1])) {         // Compruba si la cadena contiene sólo letras o números
                                    System.out.println(" (q11, e, q12)");
                                    if (q11(elementos_comillas[2])) {         // Comprobar palabra ");break;"
                                          System.out.println(" (q12, \"), q13)");
                                          System.out.println(" (q13, ;break;, q14)");
                                          if(elementos.length > 3){
                                                redundanciaDeCase(elementos[++posicionCase]);
                                          }else{
                                                System.out.println(" (q14, e, q15)");
                                                bandera = true;
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
                  } else {
                        printErrorMessage();
                  }
            } else if (q6Aux(elementosCase)) {      //Si vuelvo a recibir una letra
                  System.out.println(" (q6, " + elementosCase + ", q8)");
                  if (q8(elementosCase)) {       // Si vuelvo a recibir puras letras
                        System.out.println(" (q7, e, q9)");        // Se comprueba la palabra ":print(".
                        if (q9(elementos_comillas[0])) {          // Se comprueba la palabra ":print("
                              System.out.println(" (q9, #:, q10)");
                              System.out.println(" (q10, print(\", q11)");
                              if (q10(elementos_comillas[1])) {         // Compruba si la cadena contiene sólo letras o números
                                    System.out.println(" (q11, e, q12)");
                                    if (q11(elementos_comillas[2])) {         // Comprobar palabra ");break;"
                                          System.out.println(" (q12, \"), q13)");
                                          System.out.println(" (q13, ;break;, q14)");
                                          if(elementos.length > 3){
                                                redundanciaDeCase(elementos[++posicionCase]);
                                          }else{
                                                System.out.println(" (q14, e, q15)");
                                                bandera = true;
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
                  } else {
                        printErrorMessage();
                  }
            } else {
                  printErrorMessage();
            }
            return bandera;
      }

      // Mensaje de ERROR !!
      static void printErrorMessage() {
            System.err.println(" ¡¡¡ CADENA NO ADMITIDA !!!");
      }
      // Comprobar palabra "Switch(" del inicio
      static boolean q0(String s) {
            boolean ok = true;
            if (!s.equals("Switch(")) {
                  ok = false;
            }
            return ok;
      }
      // Si es número retorna TRUE
      // Sino retorna FALSE
      static boolean q1(String cadenita) {
            return isDigit(cadenita.charAt(0));
      }
      // Si es letra retorna TRUE
      // Sino retorna FALSE

      static boolean q1Aux(String cadenita) {
            return isLetter(cadenita.charAt(0));
      }
      // Si son puros números retorna TRUE
      // Sino FALSE
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
      // Si son puras letras retorna TRUE
      // Sino FALSE
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
      // Comprobar el paréntesis de cierre y llave de apertura
      static boolean q4(String s) {
            return s.equals("){");
      }
      // Comprobar palabra "case"
      static boolean q5(String s) {
            return s.equals("case");
      }
      static boolean q6(String s) {
            return q1(s); // Si es número retorna TRUE
            // Sino retorna FALSE
      }
      static boolean q6Aux(String s) {
            return q1Aux(s); // Si es letra retorna TRUE
            // Sino retorna FALSE
      }
      static boolean q7(String s) {
            return q2(s); // Si son puros números retorna TRUE
            // Sino retorna FALSE
      }
      static boolean q8(String s) {
            return q3(s); // Si son puras letras retorna TRUE
            // Sino retorna FALSE
      }
      // Comprobar palabra ":print("
      static boolean q9(String s) {
            return s.equals(":print(");
      }
      // Compruba si la cadena contiene sólo letras o números
      static boolean q10(String cadenita) {

            boolean bandera = false;
            int i = 0;
            while (i < cadenita.length()) {
                  if (isLetter(cadenita.charAt(i)) || isDigit(cadenita.charAt(i))) {
                        bandera = true;
                  } else {
                        bandera = false;
                        break;
                  }
                  i++;
            }
            return bandera;
      }
      // Comprobar palabra ");break;"
      static boolean q11(String s) {
            return s.equals(");break;");
      }
      // Comprobar palabra "}"
      static boolean q12(String s) {
            return s.equals("}");
      }
      // Comprueba si un caracter es letra
      static boolean isLetter(char c) {
            int asciiCode = (int) c;
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
      // Comprueba si un caracter es dígito
      static boolean isDigit(char c) {
            int asciiCode = (int) c;
            for (int i = 48; i <= 57; i++) {
                  if (asciiCode == i) {
                        return true;
                  }
            }
            return false;
      }
}