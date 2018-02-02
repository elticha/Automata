package pkgswitch;

import java.util.Scanner;

/**
 * Autómata para la estructura Switch(). Materia: Lenguajes y Autómatas. Fecha:
 * 01 de febrero de 2018 Lugar: UP-Chiapas 5º "A"
 *
 * @author David Pérez S.
 */
public class Switch {

      static String[] elementos;
      static String[] elementos_gato1;        // = elementos[1].split("#");
      static String[] elementos_gato2;        // = elementos[1].split("#");
      static String[] elementos_comillas;     // = elementos_gato2[1].split("\"");

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
                  elementos = cadena.split("%"); //División de la cadena introducida por el usuario, por "%".
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
                        if (q0(elementos_gato1[0])) {             // Si se lee la palabra "Switch("
                              if (q1(elementos_gato1[1])) {         //Si recibo un número
                                    if (q2(elementos_gato1[1])) {     // Si recibo puros números
                                          if (q4(elementos_gato1[2])) {   // Comprobar el paréntesis de cierre y llave de apertura
                                                if (q5(elementos_gato2[0])) {     // Comprobar palabra "case"
                                                      if (redundanciaDeCase()) {
                                                            if (q12(elementos[2])) {
                                                                  System.out.println(" FELICIDADES !!!");
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
                                    if (q3(elementos_gato1[1])) {           // Si recibo puras letras
                                          if (q4(elementos_gato1[2])) {         // Comprobar el paréntesis de cierre y llave de apertura
                                                if (q5(elementos_gato2[0])) {     // Comprobar palabra "case"
                                                      if (redundanciaDeCase()) {
                                                            if (q12(elementos[2])) {
                                                                  System.out.println("FELICIDADES !!!");
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
      }

      static boolean redundanciaDeCase() {

            boolean bandera = false;

            if (q6(elementos_gato2[1])) {     //Si vuelvo a recibir un número
                  if (q7(elementos_gato2[1])) { // Si vuelvo a recibir puros números
                        if (q9(elementos_comillas[0])) {
                              if (q10(elementos_comillas[1])) {
                                    if (q11(elementos_comillas[2])) {
                                          bandera = true;
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
            } else if (q6Aux(elementos_gato2[1])) {      //Si vuelvo a recibir una letra
                  if (q8(elementos_gato2[1])) { // Si vuelvo a recibir puros números
                        if (q9(elementos_comillas[0])) {
                              if (q10(elementos_comillas[1])) {
                                    if (q11(elementos_comillas[2])) {
                                          bandera = true;
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
            if (isDigit(cadenita.charAt(0))) {
                  return true;
            } else {
                  return false;
            }
      }
      // Si es letra retorna TRUE
      // Sino retorna FALSE

      static boolean q1Aux(String cadenita) {
            if (isLetter(cadenita.charAt(0))) {
                  return true;
            } else {
                  return false;
            }
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
            if (s.equals("){")) {
                  return true;
            } else {
                  return false;
            }
      }
      // Comprobar palabra "case"

      static boolean q5(String s) {
            if (s.equals("case")) {
                  return true;
            } else {
                  return false;
            }
      }

      static boolean q6(String s) {
            if (q1(s)) {
                  return true; // Si es número retorna TRUE
            } else {
                  return false; // Sino retorna FALSE
            }
      }

      static boolean q6Aux(String s) {
            if (q1Aux(s)) {
                  return true; // Si es letra retorna TRUE
            } else {
                  return false; // Sino retorna FALSE
            }
      }

      static boolean q7(String s) {
            if (q2(s)) {
                  return true; // Si son puros números retorna TRUE
            } else {
                  return false; // Sino retorna FALSE
            }
      }

      static boolean q8(String s) {
            if (q3(s)) {
                  return true; // Si son puras letras retorna TRUE
            } else {
                  return false; // Sino retorna FALSE
            }
      }

      // Comprobar palabra ":print("
      static boolean q9(String s) {
            if (s.equals(":print(")) {
                  return true;
            } else {
                  return false;
            }
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
            if (s.equals(");break;")) {
                  return true;
            } else {
                  return false;
            }
      }

      // Comprobar palabra "}"
      static boolean q12(String s) {
            if (s.equals("}")) {
                  return true;
            } else {
                  return false;
            }
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