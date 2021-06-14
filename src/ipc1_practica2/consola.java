package ipc1_practica2;import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
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
    
    public static void strErrorFueraRango(){
        System.out.println("\n"
                + "\t**********************************************\n"
                + "\t**  Has ingresado un nuemro fuera de rango  **\n"
                + "\t**********************************************\n");
    }
    
    public static String defautlTable(String columnas){
        String[] col = columnas.split(",");
        columnas = "<tr>"+ "<th scope='col'>#</th>";
        for (int i = 0; i < col.length; i++) {
            columnas+= "<th scope='col'>"+col[i]+"</th>";
        }
        columnas+= "</tr>";
        
        return ""
                + "<table class='table table-striped table-hover table-bordered table-sm'>"
                    + "<thead class='text-center text-white bg-dark fs-5'>"
                        +columnas
                    + "</thead>"
                    + "<tbody>Info_TBODY</tbody>"
                + "</table>"; 
    }
    
    public static String defaultHTML_BODY(String nameReport, String columnas){
        return ""
                + "<div class='row'>"
                    +"<div class='col-12 text-center fs-3 fw-bold'>"
                    +nameReport+ " -- " +Fecha()
                    + "</div>"
                + "</div>"
                + "<div class='row'>"
                + "<div class='col-12'>"
                +  defautlTable(columnas)
                + "</div>"
                + "</div>";
    }
    private static String Fecha(){
        Calendar fecha = new GregorianCalendar();
        int mes = fecha.get(Calendar.MONTH) +1;
        int dia = fecha.get(Calendar.DATE);
        int ayo = fecha.get(Calendar.YEAR);
        int hora = fecha.get(Calendar.HOUR);
        int min = fecha.get(Calendar.MINUTE);
        return ""+mes+"/"+dia+"/"+ayo +" -- " +hora+":"+min;
    }
}