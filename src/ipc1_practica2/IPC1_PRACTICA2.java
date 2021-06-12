package ipc1_practica2;

import static ipc1_practica2.Clase_Cesar.*;
import java.io.Console;
import school.poo.*;

public class IPC1_PRACTICA2 {

    static Alumno alumnos[] = new Alumno[100];
    static Profesor profesores[] = new Profesor[20];
    static Curso cusros[] = new Curso[15];
    static String[][] users= new String[6][2];
    
    public static void main(String[] args) {
        Console cons = System.console();
        users[0][0] = "Admin";//Este es el usurio
        users[0][1] = "Admin";//Este es la contraseña
        boolean estado = true; String strMenuAdmin = "";
        do{
            strMenuAdmin ="";
            String user = consola.inputString("Usuario: ");
            String pass = consola.inputString("Password: ");
            for(int i = 0; i< users.length; i++){
                if(users[i][0] != null && users[i][1] != null){
                    if(users[i][0].equals(user) && users[i][1].equals(pass)){
                        
                        if(i == 0){//Admin
                            strMenuAdmin = ""
                                    + "** 2) Carga de Datos              **\n"
                                    + "** 3) Asignacion de datos         **\n"
                                    + "** 4) Agregar usuario al sistema  **\n";
                        }
                        estado = true;
                        break;
                    }
                }
                if(i == (users.length-1)){
                    estado = false;
                    System.out.println("\n"
                            + "\t**********************************************\n"
                            + "\t** El usuario o contraseña son incorrectos  **\n"
                            + "\t**********************************************\n");
                }
            }
            if(estado){
                estado = MenuGeneral(strMenuAdmin, user);
            }else{
             estado = true;   
            }
        }while(estado);
    }
    
    public static boolean MenuGeneral(String strMenuAdmin, String user){
        System.out.println("******    Bien Venido: "+ user+"    ******");
        boolean estado = true;
        int indice = 0;
        do{ 
            do{
                System.out.println("\n\n"
                    + "************************************\n"
                    + "** 1) Reportes                    **\n"
                    +strMenuAdmin
                    + "** 5) Salir                       **\n"
                    + "************************************");
                indice = consola.inputInt("-->>");
            }while(indice == 0);
            switch(indice){
                case 1:
                    MenuReporte();
                    break;
                case 2:
                    if(strMenuAdmin.length()!=0){
                        MenuCarga();
                    }else{
                        consola.strErrorFueraRango();
                    }
                    break;
                case 3:
                    if(strMenuAdmin.length()!=0){
                        MenuAsignaciones();
                    }else{
                        consola.strErrorFueraRango();
                    }
                    break;
                case 4:
                    if(strMenuAdmin.length()!=0){
                        IngresarUsuario();
                    }else{
                        consola.strErrorFueraRango();
                    }
                    break;
                case 5:
                    System.out.println("\n"
                            + "\t**********************************\n"
                            + "\t**  Saliste del Menu Principal  **\n"
                            + "\t**********************************\n");
                    break;
                default:
                    consola.strErrorFueraRango();
                    break;
            }
        }while(indice != 5);
        return true;
    }
    
    public static void MenuReporte(){
        int indice = 0;
        do{
            do{
                System.out.println("\n\n"
                    + "\t******************************************************\n"
                    + "\t** 1) Reporte de Aumnos                             **\n"
                    + "\t** 2) Reporte de Asignaciones de Alumnos            **\n"
                    + "\t** 3) Reporte de Asignaciones de Profesores         **\n"
                    + "\t** 4) Reporte General de cursos                     **\n"
                    + "\t** 5) Reporte de un Curso Especifico                **\n"
                    + "\t** 6) Reporte de TOP 5 Mejores Alumnos de un Curso  **\n"
                    + "\t** 7) Regresar Al Menu Principal                    **\n"
                    + "\t******************************************************\n");
                indice = consola.inputInt("-->>");
            }while(indice == 0);
            switch(indice){
                
                default:
                    consola.strErrorFueraRango();
                    break;
            }
        }while(indice != 7);
    }
    
    public static void MenuCarga(){
        int indice = 0;
        do{
            do{
                System.out.println("\n\n"
                    + "\t***********************************\n"
                    + "\t** 1) Carga de Aumnos            **\n"
                    + "\t** 2) Carga de Profesores        **\n"
                    + "\t** 3) Carga de Cursos            **\n"
                    + "\t** 4) Regresar Al Menu Anterior  **\n"
                    + "\t***********************************\n");
                indice = consola.inputInt("-->>");
            }while(indice == 0);
            switch(indice){
                case 1:
                    CargarAlumnos();
                    break;
                case 2:
                    CargaProfesores();
                    break;
                case 4:
                    System.out.println("\n\n------Regresando al Menu inicial -------\n\n");
                    break;
                default:
                    consola.strErrorFueraRango();
                    break;
            }
        }while(indice != 4);
    }
    
    public static void MenuAsignaciones(){
        int indice = 0;
        do{
            do{
                System.out.println("\n\n"
                    + "\t***********************************\n"
                    + "\t** 1) Asignacion de Aumnos       **\n"
                    + "\t** 2) Asignacion de Profesores   **\n"
                    + "\t** 3) Carga de Notas             **\n"
                    + "\t** 4) Regresar Al Menu Anterior  **\n"
                    + "\t***********************************\n");
                indice = consola.inputInt("-->>");
            }while(indice == 0);
            switch(indice){
                
                default:
                    consola.strErrorFueraRango();
                    break;
            }
        }while(indice != 4);
    }
    
}
