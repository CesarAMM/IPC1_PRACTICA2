package ipc1_practica2;

import school.poo.*;

public class IPC1_PRACTICA2 {

    private static Alumno alumnos[] = new Alumno[100];
    private static Profesor profesores[] = new Profesor[20];
    private static Curso cusros[] = new Curso[15];
    private static String[][] users= new String[6][2];
    public static void main(String[] args) {
        users[0][0] = "Admin";//Este es el usurio
        users[0][1] = "Admin";//Este es la contraseña
        boolean estado = true; String strMenuAdmin = "";
        do{
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
                        break;
                    }
                }
                if(i == (users.length-1)){
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
            System.out.println(""
                    + "************************************\n"
                    + "** 1) Reportes                    **\n"
                    + "** 2) Solicitudes                 **\n"
                    +strMenuAdmin
                    + "** 6) Salir                       **\n"
                    + "************************************"); 
            indice = consola.inputInt("-->>");
        }while(estado);
        return true;
    }
    
}
