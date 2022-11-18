import java.util.Scanner;

public class Practica {
    public static void main(String args[]) {

        // Declaring variables
        int menu, second = 0, third, numero, decimal;
        boolean repeatIfErr = false;
        String hexadecimal;

        Scanner lector = new Scanner(System.in);

        // The basic structure of the menu is a do while with a switch
        do {
            System.out.println(Menu(0));
            menu = lector.nextInt();
            lector.nextLine();
            switch (menu) {

                // Menu for Aritmatic operations
                case 1:

                    // Second sub menu for basic opertaions

                    System.out.println(Menu(1));

                    // Repeat if the user dosent input a number or inputs a higher than 5 or lower
                    // than 0
                    // Repite si el usuario no pone un numero o pone un numero mayor que 5 o menor
                    // que 0
                    repeatIfErr = false;
                    do {
                        try {
                            // asks user for input
                            second = Integer.parseInt(lector.nextLine());

                            // if input too high or low, repeat input
                            if (second > 5 || second < 0) {
                                System.out.println("Error: Introduce 0, 1, 2 ,3 , 4 o 5");
                                continue;
                            }

                            // if input correct, exit "do while" loop and either goes back (0) or does the
                            // operation
                            // si el entrada era correcto, sale del "do while", si es un 0 sale al menu
                            // principaly si es otro numero menor que 6 imprime el resultado del operacion
                            repeatIfErr = true;
                        } catch (Exception e) {
                            System.out.println("Error: Introduce 0, 1, 2 ,3 , 4 o 5");
                        }
                    } while (repeatIfErr == false);

                    // if 0, go to main menu. else print text with result of operation
                    if (second == 0) {
                        break;
                    } else {
                        // asks user for operation numbers, prints operation result
                        // pide el usuario para los numeros del operacion, imprime el resultado
                        System.out.printf("El resultado es: %.2f \n", aritmetica(second));
                        break;
                    }

                // Menu for conversions
                case 2:
                    do {
                        System.out.println(Menu(2));
                        third = lector.nextInt();
                        lector.nextLine();
                        switch (third) {
                            // Decimal to binary
                            case 1:

                                System.out.print("Introduce un numero Decimal >= 0: ");
                                numero = lector.nextInt();
                                if(numero<0){
                                    System.out.println("Número no válido");
                                    break;
                                }
                                System.out.print(decimalABinario(numero));

                                break;
                            // Decimal to hexadecimal
                            case 2:

                                System.out.print("Introduce un numero Decimal >= 0: ");
                                numero = lector.nextInt();
                                if(numero<0){
                                    System.out.println("Número no válido");
                                    break;
                                }
                                System.out.print(decimalAHexadecimal(numero));

                                break;
                            // Binary to decimal
                            case 3:

                                System.out.print("Introduce un numero binario: ");
                                numero = lector.nextInt();
                                if (!validarBinario(numero)) {
                                    System.out.println("Número no válido");
                                    break;
                                }
                                decimal = binarioADecimal(numero);
                                System.out.print(decimal);

                                break;
                            // Binary to hexadecimal
                            case 4:

                                System.out.print("Introduce un numero binario: ");
                                numero = lector.nextInt();
                                if (!validarBinario(numero)) {
                                    System.out.println("Número no válido");
                                    break;
                                }
                                decimal = binarioADecimal(numero);
                                hexadecimal = binarioAHexadecimal(numero);
                                System.out.print(hexadecimal);

                                break;
                            // Hexadecimal to binary
                            case 5:

                                System.out.print("Introduce un numero hexadecimal: ");
                                hexadecimal = lector.nextLine().toUpperCase();
                                if (!validarHexadecimal(hexadecimal)) {
                                    System.out.print("Número no válido");
                                    break;
                                }
                                decimal = hexadecimalADecimal(hexadecimal);
                                Long binarioResultante = decimalABinario(decimal);
                                System.out.println(binarioResultante);

                                break;
                            // Hexadecimal to decimal
                            case 6:

                                System.out.print("Introduce un numero hexadecimal: ");
                                hexadecimal = lector.nextLine().toUpperCase();
                                if (!validarHexadecimal(hexadecimal)) {
                                    System.out.println("Número no válido");
                                    break;
                                }
                                decimal = hexadecimalADecimal(hexadecimal);
                                System.out.print(decimal);

                                break;
                            default:
                                if (third > 6 || 0 < third) {
                                    System.out.println("Dato incorrecto, repetir");
                                    break;
                                }
                        }

                    } while ((third != 0));

                    break;
                
                // Exit program
                case 0:
                    System.out.println("Fin");

                    break;

                // Default for if user inputs incorrect data
                default:
                    System.out.println("Dato introducido incorrecto, introduce dato correcto");

            }
        } while ((menu != 0));
        lector.close();
    }

    /**
     * Inputs a number that says what operation to use,
     * prints text asking the user to input two number and
     * uses those numbers to do math depending on the number
     * 
     * Usa un numero de 1 a 5 para decidir que operacion hay que usar,
     * imprime dos veces para la entrada de datos
     * 
     * @param op
     * @return
     */
    public static double aritmetica(int op) {
        double result = 0, num1 = 0, num2 = 0;

        // Closing the scanner inside the method closes "System.in" meaning scanners
        // outside of the method will fail
        // Cerrando un scanner dentro de un metodo cierra "System.in", significa que el
        // scanner dejara de funcionar dentro del programa
        Scanner userInput = new Scanner(System.in);
        boolean noError = false;

        // Output and input for "num1"
        do {
            try {
                System.out.println("Introduce el primer numero: ");
                num1 = Double.parseDouble(userInput.nextLine());
                noError = true;
            } catch (Exception e) {
                System.out.println("Habia un error. Intente de vuelta ");
            }
        } while (!noError);

        noError = false;

        // Output and input for "num2"
        do {
            try {
                System.out.println("Introduce el segundo numero: ");
                num2 = Double.parseDouble(userInput.nextLine());
                noError = true;
            } catch (Exception e) {
                System.out.println("Habia un error. Intente de vuelta ");
            }
        } while (!noError);

        switch (op) {
            case 1:
                // Addition
                result = num1 + num2;
                break;
            case 2:
                // Subtraction
                result = num1 - num2;
                break;
            case 3:
                // Multiplication
                result = num1 * num2;
                break;
            case 4:
                // Division
                result = num1 / num2;
                break;
            case 5:
                // Modulo
                result = num1 % num2;
                break;
            default:
                System.out.println("Error: Introduce 0, 1, 2 ,3 , 4 o 5");
                userInput.close();
        }

        return result;

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
     * 
     * @param decimal Decimal a convertir
     * @return numero en formato hexadecimal
     */
    public static String decimalAHexadecimal(int decimal) {
        String hexadecimal = "";
        String caracteresHexadecimales = "0123456789abcdf";
        while (decimal > 0) {
            int residuo = decimal % 16;
            // Agregar a la izquierda
            hexadecimal = caracteresHexadecimales.charAt(residuo) + hexadecimal;
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
     * @return número inicial pasado a hexadecimal
     */
    public static String binarioAHexadecimal(long binario) {
        String hexadecimal = "";
        String digitosHexa = "0123456789ABCDEF";
        while (binario > 0) {
            hexadecimal = digitosHexa.charAt((int) binarioADecimal(binario % 10000)) + hexadecimal;
            binario = binario / 10000;
        }
        ;
        return hexadecimal;
    }

    /**
     * Pasa un número hexadecimal (en base 10) a binario (base 2).
     * 
     * @param hexadecimal número entero en hexadecimal
     * @return número inicial pasado a binario
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
     * 
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
     * 
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
     * 
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

    /**
     * Input an int (0, 1 or 2) for a menu
     * menu 0 is the main menu
     * menu 1 is the sub menu for arthmetic
     * menu 2 is the sub menu for conversions
     * @param menuNum
     * @return
     */
    public static String Menu(int menuNum){

        String line = "\n--------------------------";

        // Headers
        String calculadora = "*******************\n**  Calculadora  **\n*******************\n";
        String operacionAritmetica = "*****************************\n** OPERACIONES ARITMÉTICAS **\n*****************************\n";
        String conversionBase = "**************************\n** CONVERSIONES DE BASE **\n**************************\n";

        // Options
        String menuPrincipal = "\n1. Operaciones aritméticas\n2. Conversiones de base";
        String subMenuAritmetica = "\n1. Sumar\n2. Restar\n3. Multiplicar\n4. Dividir\n5. Resto de la división";
        String subMenuConversionp1 = "1. De decimal a binario\n2. De decimal a hexadecimal\n3. De binario a decimal";
        String subMenuConversionp2 = "\n4. De binario a hexadecimal\n5. De hexadecimal a binario\n6. De hexadecimal a decimal";

        // Exit
        String exitChoice = "\n0.Salir del programa \n Elija una opción:";

        String menu = "";

        switch(menuNum){
            case 0:

                menu = calculadora + menuPrincipal + line + exitChoice;
    
                break;
            case 1:

                menu = operacionAritmetica + subMenuAritmetica + line + exitChoice;
        
                break;
            case 2:

                menu = "\n" + conversionBase + "\n" + subMenuConversionp1 + subMenuConversionp2 + line + exitChoice;
                
                break;
            default:
                return "error";
        }
        return menu;
    }




    /**
     * Method for printing out the main menu
     * 
     * @return the String menu which represents the main menu
     */
    public static String MenuPrincipal() {
        String Calculadora = "*******************\n**  Calculadora  **\n*******************";
        String MenuPrincipal = "\n1. Operaciones aritméticas\n2. Conversiones de base";
        String Line = "\n--------------------------";
        String ExitChoice = "\n0.Salir del programa \n Elija una opción:";
        String menu = Calculadora + MenuPrincipal + Line + ExitChoice;

        return menu;
    }

    /**
     * Method to print out the submenu for basic operations
     * 
     * @return submenu string to print it out
     */
    public static String SubMenuAritmetica() {
        String OperacionAritmetica = "*****************************\n** OPERACIONES ARITMÉTICAS **\n*****************************";
        String SubMenuAritmetica = "\n1. Sumar\n2. Restar\n3. Multiplicar\n4. Dividir\n5. Resto de la división";
        String Line = "\n--------------------------";
        String ExitChoice = "\n0.Salir del programa \n Elija una opción:";
        String submenu = OperacionAritmetica + SubMenuAritmetica + Line + ExitChoice;

        return submenu;
    }

    /**
     * Method to print out the submenu for conversions
     * 
     * @return submenu string to print it out
     */
    public static String SubMenuConversion() {
        String ConversionBase = "**************************\n** CONVERSIONES DE BASE **\n**************************";
        String Space = "\n";
        String SubMenuConversionp1 = "1. De decimal a binario\n2. De decimal a hexadecimal\n3. De binario a decimal";
        String SubMenuConversionp2 = "\n4. De binario a hexadecimal\n5. De hexadecimal a binario\n6. De hexadecimal a decimal";
        String Line = "\n--------------------------";
        String ExitChoice = "\n0.Salir del programa \n Elija una opción:";
        String submenu = "\n"+ConversionBase + Space + SubMenuConversionp1 + SubMenuConversionp2 + Line + ExitChoice;
        return submenu;
    }

}
