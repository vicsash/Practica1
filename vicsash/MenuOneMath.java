import java.util.Scanner;

public class MenuOneMath {
    
    /**
     * Inputs a number that says what operation to use, 
     * prints text asking the user to input two numbers and
     * uses those numbers to do math depending on the number 
     * supplied by the programmer.
     * @param arithmatic
     * @return
     */
    public double inMathOut(int arithmatic){
        double result = 0, num1 = 0, num2 = 0;

        // Closing the scanner inside the method closes "System.in" meaning scanners outside of the method will fail
        // its advised not to close the scanner: https://stackoverflow.com/questions/26970355/how-to-properly-close-a-scanner-class-inside-a-method
        Scanner userInput = new Scanner(System.in);
        boolean noError = false;

        // Output and input for "num1"
        do{
            try{
                System.out.println("Introduce el primer numero: ");
                num1 = Double.parseDouble(userInput.nextLine()); 
                noError = true;
            } catch (Exception e) {
                System.out.println("Habia un error. Intente de vuelta ");
            }
        } while (!noError);

        noError = false;

        // Output and input for num2
        do{
            try{
                System.out.println("Introduce el segundo numero: ");
                num2 = Double.parseDouble(userInput.nextLine()); 
                noError = true;
            } catch (Exception e) {
                System.out.println("Habia un error. Intente de vuelta ");
            }
        } while (!noError);
    
        

        switch (arithmatic){
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
                // NEED DEFAULT FOR WHEN USER INPUTS NUMBER OVER 5
                break;
        }

        return result;
        
    }
    //public static void main(String[] args){
    //    System.out.println(inMathOut(1));
    //}
}