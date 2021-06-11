package ipc1_practica2;

import static ipc1_practica2.IPC1_PRACTICA2.*;

public class Clase_Cesar {
    
    public static void IngresarUsuario(){
        boolean estado = true; int contador =0;
        if(users[5][0] == null){
            do{
                contador = 0;
                String newUsers = consola.inputString("Ingrese usuario nuevo: ");
                do{
                    String newPass_1 = consola.inputString("Ingrese la Contraseña: ");
                    String newPass_2 = consola.inputString("Confirme la contraseña: ");
                    if(newPass_1.equals(newPass_2)){
                        for(int i = 0; i < users.length; i++){
                            contador++;
                            if(users[i][0] != null){
                                if(users[i][0].equals(newUsers)){
                                    System.out.println(""
                                            + "\t***************************\n"
                                            + "\t**  El Usuario ya exite  **\n"
                                            + "\t***************************\n");
                                    break;
                                }
                            }else{
                                users[i][0] = newUsers;
                                users[i][1] = newPass_1;
                                estado = false;
                                System.out.println("-->>Se a creado un nuevo usuario: "+ newUsers);
                                break;
                            }
                        }
                    }else{
                        estado = true;
                        System.out.println(""
                                + "\t**********************************\n"
                                + "\t**  La Contraseña no coinviden  **\n"
                                + "\t**********************************\n");
                    }
                }while(estado);
            }while(estado);
        }else{
            System.out.println("\n"
                + "\t*********************************************\n"
                + "\t**  Ya el cupo de Usuarios esta al Limite  **\n"
                + "\t*********************************************\n"); 
        }
    }
    
}
