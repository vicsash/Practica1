import java.util.Scanner;
public class Output {
	int x = 0;
	int y = 0;

	public static Scanner scan = new Scanner(System.in);
	//constructor
    public Output(){
	    this.x = 0;
        this.y = 0;
	}
	public void outputnum(int x, int y){
		this.x = x;
		this.y = y;
	}
	public void write(Object x){
		System.out.println(x);
	}
	public void numinput(){
        write("Introduce el primer numero:");
	    this.x = Integer.parseInt(scan.nextLine());
        write("Introduce el segundo numero:");
	    this.y = Integer.parseInt(scan.nextLine());
	}

}




