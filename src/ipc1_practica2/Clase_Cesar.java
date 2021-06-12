package ipc1_practica2;

import static ipc1_practica2.IPC1_PRACTICA2.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import school.poo.Alumno;
import school.poo.Profesor;

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
    
    public static void CargarAlumnos(){
        String datos_a = LeerArchivo(consola.inputString("Ingrese La ruta del Archivo para la carga de Alumnos:\n-->"));
        String datos[] = datos_a.split("\n");
        for(int i = 0; i< datos.length; i++){
            if(i > 0){
                try {
                    int Id = Integer.parseInt(datos[i].split(",")[0].trim());
                    int Carnet = Integer.parseInt(datos[i].split(",")[1].trim());
                    String Nombre = datos[i].split(",")[2].trim();
                    String Fecha = datos[i].split(",")[3].trim();
                    char Genero = datos[i].split(",")[4].trim().charAt(0);
                    int dia = Integer.parseInt(Fecha.split("/")[0].trim());
                    int mes = Integer.parseInt(Fecha.split("/")[1].trim());
                    int ayo = Integer.parseInt(Fecha.split("/")[2].trim());
                    if((dia> 0 && dia< 32) && (mes > 0 && mes <13) && (ayo > 1950 && ayo < 2021) && Id > 0 && Carnet > 0){
                        if(alumnos[99] == null){
                            for (int j = 0; j < alumnos.length; j++) {
                                if(alumnos[j] != null){
                                    if(alumnos[j].getId() == Id|| alumnos[j].getCarnet() == Carnet){
                                        System.out.println("Este alumno tiene el mismo alumno");
                                        System.out.println("Base de Datos: "+ alumnos[j].getId() + " Nombre: " + alumnos[j].getNombre());
                                        System.out.println("En el Archivo: " + Id + " Nombre: " + Nombre);
                                        break;
                                    }
                                }else{
                                    System.out.println("Ingresamos a crear un nuevo alumnos\n\n");
                                    alumnos[j] = new Alumno(Id, Carnet, Nombre, Fecha, Genero);
                                    System.out.println("Nuevo Alumno\n Id: "+ alumnos[j].getId() + " Nombre: "+ alumnos[j].getNombre());
                                    break;
                                }
                            }
                        }
                    }else{
                        System.out.println("error en la fecha");
                    }
                } catch (Exception e) {
                    System.out.println("Error en el formato de algo");
                    System.out.println(e);
                }
            }
        }
    }
    
    public static void CargaProfesores(){
        String datos_a = LeerArchivo(consola.inputString("Ingrese La ruta del Archivo para la carga de Profesores:\n-->"));
        String datos[] = datos_a.split("\n");
        for(int i = 0; i< datos.length; i++){
            if(i > 0){
                try {
                    int Id = Integer.parseInt(datos[i].split(",")[0].trim());
                    int Registo = Integer.parseInt(datos[i].split(",")[1].trim());
                    String Nombre = datos[i].split(",")[2].trim();
                    String FechaNacimiento = datos[i].split(",")[3].trim();
                    String FechaContratacion = datos[i].split(",")[4].trim();
                    char Genero = datos[i].split(",")[5].trim().charAt(0);
                    int diaN = Integer.parseInt(FechaNacimiento.split("/")[0].trim());
                    int mesN = Integer.parseInt(FechaNacimiento.split("/")[1].trim());
                    int ayoN = Integer.parseInt(FechaNacimiento.split("/")[2].trim());
                    int diaC = Integer.parseInt(FechaContratacion.split("/")[0].trim());
                    int mesC = Integer.parseInt(FechaContratacion.split("/")[1].trim());
                    int ayoC = Integer.parseInt(FechaContratacion.split("/")[2].trim());
                    if((diaN> 0 && diaN< 32) && (mesC > 0 && mesC <13) && (ayoC > 1950 && ayoC <= 2021) && 
                            (diaC> 0 && diaC< 32) && (mesN > 0 && mesN <13) && (ayoN > 1950 && ayoN <= 2021) && Id > 0 && Registo > 0){
                        if(profesores[19] == null){
                            for (int j = 0; j < profesores.length; j++) {
                                if(profesores[j] != null){
                                    if(profesores[j].getId() == Id || profesores[j].getRegisto()== Registo){
                                        System.out.println("Este alumno tiene el mismo alumno");
                                        System.out.println("Base de Datos: "+ profesores[j].getId() + " Nombre: " + profesores[j].getNombre());
                                        System.out.println("En el Archivo: " + Id + " Nombre: " + Nombre);
                                        break;
                                    }
                                }else{
                                    System.out.println("Ingresamos a crear un nuevo alumnos\n\n");
                                    profesores[j] = new Profesor(Id, Registo, Nombre, FechaNacimiento, FechaContratacion, Genero);
                                    System.out.println("Nuevo Alumno\n Id: "+ profesores[j].getId() + " Nombre: "+ profesores[j].getNombre());
                                    break;
                                }
                            }
                        }
                    }else{
                        System.out.println("error en la fecha");
                    }
                } catch (Exception e) {
                    System.out.println("Error en el formato de algo");
                    System.out.println(e);
                }
            }
        }
    }
    
    public static String LeerArchivo(String srtRuta){
        //C:\Users\cesar.monroy\Desktop\ipc\LecturaArchivos_CSV\CargaAlumnos.csv
        //C:\Users\cesar.monroy\Desktop\ipc\LecturaArchivos_CSV\CargaProfesores.csv
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
        // Apertura del fichero y creacion de BufferedReader para poder
        // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File(srtRuta);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
        // Lectura del fichero
            String content = "";
            String linea;
            while ((linea = br.readLine()) != null) {
                content += linea + "\n";
            }
        return content;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        // En el finally cerramos el fichero, para asegurarnos
        // que se cierra tanto si todo va bien como si salta
        // una excepcion.
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return "";
    }
}
