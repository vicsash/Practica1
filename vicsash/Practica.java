import java.util.Scanner;
public class Practica{
    public static void main(String args[]){
        
        int menu,second,third,numero ;

        int r = 0;
        //String decimal;

        Scanner lector = new Scanner(System.in);

        // create an object (class output)
        Output s = new Output();
        // The basic structure of the menu is a do while with a switch
        do{
            System.out.println("*******************\n**  Calculadora  **\n*******************");
            System.out.println("1. Operaciones aritméticas\n2. Conversiones de base\n--------------------------\n0. Salir del programa \n\nElija una opción:");
            menu=lector.nextInt();
            lector.nextLine();
            switch(menu){
            case 1 : 
                
                    //Second sub menu for basic opertaions
                    System.out.println("*****************************\n** OPERACIONES ARITMÉTICAS **\n*****************************");
                    System.out.println("1. Sumar\n2. Restar\n3. Multiplicar\n4. Dividir\n5. Resto de la división\n-----------------------------\n0. Volver al menú principal");
                    System.out.println("Elija una opción:");
                    do{
                        second=lector.nextInt();
                        lector.nextLine();
                        switch(second){
                            case 1:
                            s.numinput(); //call method from class "output"
                            r = s.x + s.y; //call call variable x & y
                            System.out.println(s.x + " + " + s.y + " = "  + r);
                            break;
                        case 2:
                            s.numinput();
                            r = s.x - s.y;
                            System.out.println(s.x + " - " + s.y + " = "  + r);
                            break;
                        case 3:
                            s.numinput();
                            r = s.x * s.y;
                            System.out.println(s.x + " * " + s.y + " = "  + r);
                            break;
                        case 4:
                            s.numinput();
                            r = s.x / s.y;
                            System.out.println(s.x + " / " + s.y + " = "  + r);
                            break;
                        case 5:
                            s.numinput();
                            r = s.x % s.y;
                            System.out.println(s.x + " % " + s.y + " = "  + r);
                            break;
                        case 0:
                            System.out.println("Return");
                            break;
                        default:
                            System.out.println("Dato incorrecto, repitir");
                        break;
                        }
                }while((second!=0));
                
            
            
            break;
            case 2 :
                System.out.println("**************************\n** CONVERSIONES DE BASE **\n**************************");
                System.out.println("");
                System.out.println("");
                System.out.println("1. De decimal a binario\n2. De decimal a hexadecimal\n3. De binario a decimal\n4. De binario a hexadecimal\n5. De hexadecimal a binario\n6. De hexadecimal a decimal\n---------------------------\n");
                System.out.println("0. Volver al menú principal\n");
                System.out.println("Elija una opción:");
                do{
                    third=lector.nextInt();
                    lector.nextLine();
                    switch(third){
                        case 1:
                            System.out.print("Introduce un numero Decimal >= 0: ");
                            numero = lector.nextInt();
                            System.out.print(decimalABinario(numero));
                            
                            break;
                        case 2:
                            System.out.print("Introduce un numero Decimal >= 0: ");
                            numero = lector.nextInt();
                        
                            System.out.print(decimalAHexadecimal(numero));
                            break;
                        case 3: 
                            System.out.print("Introduce un numero binario: ");
                            numero = lector.nextInt();
                            if (!validarBinario(numero)){
                                System.out.println("Número no válido");
                                return;
                            }
                            int decimal = binarioADecimal(numero);
                            System.out.print(decimal);
                            break;
                        case 4:
                            System.out.print("Introduce un numero binario: ");
                            numero = lector.nextInt();
                            if (!validarBinario(numero)){
                                System.out.println("Número no válido");
                                return;
                            }
                            decimal = binarioADecimal(numero);
                            String hexadecimal = binarioAHexadecimal(numero);
                            System.out.print(hexadecimal);
                            break;
                        case 5:
                            System.out.print("Introduce un numero hexadecimal: ");
                            hexadecimal = lector.nextLine().toUpperCase().toLowerCase();
                            if (!validarHexadecimal(hexadecimal)) {
                                System.out.println("Número no válido");
                                return;
                            }
                            decimal = hexadecimalADecimal(hexadecimal);
                            Long binarioResultante = decimalABinario(decimal);
                            System.out.print(binarioResultante);
                            break;
                        case 6:
                            System.out.print("Introduce un numero hexadecimal: ");
                            hexadecimal = lector.nextLine().toUpperCase().toLowerCase();
                            if (!validarHexadecimal(hexadecimal)) {
                                System.out.println("Número no válido");
                                return;
                            }
                            decimal = hexadecimalADecimal(hexadecimal);
                            System.out.print(decimal);
                            break;
                        case 0:
                            System.out.println("Return");
                            break;
                        default:
                        System.out.println("Dato incorrecto, repitir");
                        break;
                        }

                }while((third!=0));
            //Other five operations
            break;
            case 0 :
            System.out.println("Fin");
            
            break;
            
            default :
            System.out.println("Dato introducido incorrecto, introduce dato correcto");
            
            }
        }while((menu!=0));
        lector.close();
    }
    
    /**
    * Convierte de decimal a binario. Solo positivos
    *
    * @param decimal Decimal a convertir
     * @return numero en formato binario
    */
    public static long decimalABinario(int decimal) {
        long binario = 0;
        int digito;
        final int DIVISOR = 2;
        for (int i = decimal, j = 0; i > 0; i /= DIVISOR, j++) {
            digito = i % DIVISOR;
            binario += digito * Math.pow(10, j);
    }
    return binario;
    }
    
    /**
     * Convierte de decimal a Hexadecimal. Solo positivos
     * @param decimal Decimal a convertir
     * @return numero en formato hexadecimal
     */
    public static String decimalAHexadecimal(int decimal) {
        String hexadecimal = "";
        String caracteresHexadecimales = "0123456789ABCDEF";
        while (decimal > 0) {
            int residuo = decimal % 16;
            hexadecimal = caracteresHexadecimales.charAt(residuo) + hexadecimal; // Agregar a la izquierda
            decimal /= 16;
        }
        return hexadecimal;
    }
    /**
    * Convierte de decimal a binario. Solo positivos
    *
    * @param binario Binario a convertir en formato numerico
     * @return numero en formato decimal, -1 si no es un numero binario
     */
    public static int binarioADecimal(long binario) {
 
        int decimal = 0;
        int digito;
        final long DIVISOR = 10;
        for (long i = binario, j = 0; i > 0; i /= DIVISOR, j++) {
            digito = (int) (i % DIVISOR);
            if (digito != 0 && digito != 1) {
                return -1;
            }
            decimal += digito * Math.pow(2, j);
        }
        return decimal;
     
    }
    /**
    * Pasa un número binario (en base 2) a hexadecimal (base 16).
   * 
   * @param binario número entero en binario
   * @return        número inicial pasado a hexadecimal
   */
    public static String binarioAHexadecimal(long binario) {
    String hexadecimal = "";
    String digitosHexa = "0123456789ABCDEF";
    while (binario > 0) {
      hexadecimal = digitosHexa.charAt((int)binarioADecimal(binario % 10000)) + hexadecimal;
      binario = binario / 10000;
    };
    return hexadecimal;
  }
   /**
   * Pasa un número hexadecimal (en base 10) a binario (base 2).
   * 
   * @param hexadecimal número entero en hexadecimal
   * @return            número inicial pasado a binario
   */
    public static long hexadecimalABinario(String hexadecimal) {
    String digitosHexa = "0123456789ABCDEF";
    long binario = 0;
  
    for (int i = 0; i < hexadecimal.length(); i++) {
      final long decimal = decimalABinario(digitosHexa.indexOf(hexadecimal.charAt(i)));
      binario = binario * 10000 + decimal;
    }

    return binario;
    }
    /**
     * Pasa un numero hexadecimal a un numero decimal
     * @param hexadecimal numero a pasar 
     * @return numero incial pasado a decimal
     */
    public static int hexadecimalADecimal(String hexadecimal) {
        String caracteresHexadecimales = "0123456789ABCDEF";
        hexadecimal = hexadecimal.toUpperCase();
        int decimal = 0;
        for (int i = 0; i < hexadecimal.length(); i++) {
            char caracter = hexadecimal.charAt(i);
            int posicionEnCaracteres = caracteresHexadecimales.indexOf(caracter);
            decimal = 16 * decimal + posicionEnCaracteres;
    }
    return decimal;
    }

    /**
     * comprobacion del numero introduccido en binario
     * @param binario numero a comprobar
     * @return comprueba si esta bien introduccido o no
     */
    public static boolean validarBinario(int binario) {
        // Comprobar si solo se compone de unos y ceros
        String binarioComoCadena = String.valueOf(binario);
        for (int i = 0; i < binarioComoCadena.length(); i++) {
            char caracter = binarioComoCadena.charAt(i);
            if (caracter != '0' && caracter != '1') {
                return false;
            }
        }
        return true;
    }
    /**
     * comprobacion de lo que se intoduce es hexdecimal
     * @param hexadecimal numero hexadecimal a comprobar
     * @return comprueba si esta bien introduccido o no
     */
    public static boolean validarHexadecimal(String hexadecimal) {
        // Comprobar si solo tiene números del 0 al 9 y letras de la A a la F
        String caracteresHexadecimales = "0123456789ABCDEF";
        for (int i = 0; i < hexadecimal.length(); i++) {
            char caracter = hexadecimal.charAt(i);
            // Si no se encuentra dentro de los caracteres válidos, regresamos false
            if (caracteresHexadecimales.indexOf(caracter) == -1) {
                return false;
            }
        }
        return true;
    }

}

