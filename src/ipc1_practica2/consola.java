package ipc1_practica2;import java.util.Scanner;
public class consola {
    private static Scanner s;
    private consola(){}
    
    public static String inputString(String d){
        s=new Scanner(System.in);System.out.print(d);
        return s.nextLine();
    }
    
    public static int inputInt(String d){
        s = new Scanner(System.in);System.out.print(d); int valor =0;
        try {
            valor = s.nextInt();
        } catch (Exception e) {
            System.out.println(""
                    + "\t********************************\n"
                    + "\t**  Error. Ingrese un numero  **\n"
                    + "\t********************************\n");
        }
        return valor;
    }
}