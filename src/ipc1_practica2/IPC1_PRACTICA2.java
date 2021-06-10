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
                        System.out.println("encontramos al usuario");
                        if(i == 0){//Admin
                            strMenuAdmin = ""
                                    + "** 3) Carga de Datos              **\n"
                                    + "** 4) Asignacion de datos         **\n"
                                    + "** 5) Agregar usuario al sistema  **\n";
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
                System.out.println(""
                    + "************************************\n"
                    + "** 1) Reportes                    **\n"
                    + "** 2) Solicitudes                 **\n"
                    +strMenuAdmin
                    + "** 6) Salir                       **\n"
                    + "************************************");
                indice = consola.inputInt("-->>");
            }while(indice == 0);
            switch(indice){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    if(strMenuAdmin.length()!=0){
                        IngresarUsuario();
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
                    if(strMenuAdmin.length()!=0){
                        IngresarUsuario();
                    }else{
                        consola.strErrorFueraRango();
                    }
                    break;
                case 6:
                    System.out.println("\n"
                            + "\t**********************************\n"
                            + "\t**  Saliste del Menu Principal  **\n"
                            + "\t**********************************\n");
                    break;
                default:
                    consola.strErrorFueraRango();
                    break;
            }
        }while(indice != 6);
        return true;
    }
    
}
