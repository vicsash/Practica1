import java.util.Scanner;
public class Practica{
    public static void main(String args[]){
        
        int menu,second,third,decimal, numero ;

        int r = 0;
        //String decimal;

        Scanner lector = new Scanner(System.in);

        // create an object (class output)
        output s = new output();
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
                            System.out.print("Introduce un numero entero >= 0: ");
                            numero = lector.nextInt();
                        
                            System.out.print(decimalABinario(numero));
                            
                            break;
                        case 2:
                            System.out.print("Introduce un numero entero >= 0: ");
                            numero = lector.nextInt();
                        
                            System.out.print(decimalAHexadecimal(numero));
                            break;
                        case 3: 
                            System.out.print("Introduce un numero entero >= 0: ");
                            numero = lector.nextInt();
                        
                            System.out.print(binarioADecimal(numero));
                            break;
                        case 4:
                            System.out.println("Prueba4");
                            break;
                        case 5:
                            System.out.println("Prueba5");
                            break;
                        case 6:
                            System.out.println("Prueba6"); 
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
     * @return numero en formato binario, -1 si el numero es negativo
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
     * @return numero en formato binario, -1 si el numero es negativo
     */
    public static String decimalAHexadecimal(int decimal) {
        String hexadecimal = "";
        String caracteresHexadecimales = "0123456789abcdef";
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
}