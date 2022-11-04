import java.util.Scanner;
public class Practica{
    public static void main(String args[]){
        
        int menu,second,third ;
        

        Scanner lector = new Scanner(System.in);
        // The basic structure of the menu is a do while with a switch
        do{
            System.out.println("***************");
            System.out.println("**Calculadora**");
            System.out.println("***************");
            System.out.println("1. Operaciones aritméticas");
            System.out.println("2. Conversiones de base");
            System.out.println("--------------------------");
            System.out.println("0. Salir del programa");
            System.out.println("");
            System.out.println("Elija una opción:");
            menu=lector.nextInt();
            lector.nextLine();
            switch(menu){
            case 1 : 
                do{
                    //Second sub menu for basic opertaions
                    System.out.println("*****************************");
                    System.out.println("** OPERACIONES ARITMÉTICAS **");
                    System.out.println("*****************************");
                    System.out.println("1. Sumar");
                    System.out.println("2. Restar");
                    System.out.println("3. Multiplicar");
                    System.out.println("4. Dividir");
                    System.out.println("5. Resto de la división");
                    System.out.println("---------------------------");
                    System.out.println("0. Volver al menú principal");
                    System.out.println("");
                    System.out.println("Elija una opción:");
                    second=lector.nextInt();
                    lector.nextLine();
                    switch(second){
                    case 1:
                        System.out.println("Prueba1");
                        break;
                    case 2:
                        System.out.println("Prueba2");
                        break;
                    case 3: 
                        System.out.println("Prueba3");
                        break;
                    case 4:
                        System.out.println("Prueba4");
                        break;
                    case 5:
                        System.out.println("Prueba5");
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
            System.out.println("Test2");
            //Other five operations
            break;
            case 0 :
            System.out.println("Fin");
            
            break;
            

            default :
            System.out.println("Dato introducido incorrecto, introduce dato correcto");
            
            }
        }while((menu!=0));

    }

}