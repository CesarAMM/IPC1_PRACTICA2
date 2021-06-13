package ipc1_practica2;

import static ipc1_practica2.IPC1_PRACTICA2.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import school.poo.*;

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
    
    public static void CargaAsignacionAlumnos(){
        String datos_a = LeerArchivo(consola.inputString("Ingrese La ruta del Archivo para la carga de asignaciones Alumnos:\n-->"));
        String datos[] = datos_a.split("\n");
        for(int i = 0; i< datos.length; i++){
            if(i > 0){
                try {
                    int IdAlumno = Integer.parseInt(datos[i].split(",")[0].trim());
                    int IdCurso = Integer.parseInt(datos[i].split(",")[1].trim());
                    if(IdCurso > 0 && IdAlumno > 0){
                        Alumno alumno = new Alumno().getAlumno(alumnos, IdAlumno);//Almacenamos al alumnos
                        Curso curso = new Curso().getCurso(cusros, IdCurso);
                        if(alumno != null && curso != null){//Validamos que el alumno y el curso si exista
                            if(!alumno.getCursoAlumno(alumno.getCurso(), IdCurso)){//Validamos si ya con el curso
                                for (int j = 0; j < alumnos.length; j++) {
                                    if(alumnos[j] != null){
                                        if(alumnos[j].getId() == IdAlumno){
                                            for (int k = 0; k < alumnos[j].getCurso().length; k++) {
                                                if(alumnos[j].getCurso()[k]==null){
                                                    alumnos[j].setCursoAlumno(curso, k);
                                                    break;
                                                }
                                            }
                                        }
                                    }
                                }
                            }else{
                                System.out.println("El cuso ya lo tiene asignado");
                            }
                        }else{
                            if(alumno == null){//el alumno no existe
                                System.out.println("El alumno no existe");
                            }
                            if(curso == null){//El curso no existe
                                System.out.println("El curso no existe");
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
    
    public static void CargaAsignacionProfesor(){
        String datos_a = LeerArchivo(consola.inputString("Ingrese La ruta del Archivo para la carga de asignacionesProfesor:\n-->"));
        String datos[] = datos_a.split("\n");
        for(int i = 0; i< datos.length; i++){
            if(i > 0){
                try {
                    int IdProfesor = Integer.parseInt(datos[i].split(",")[0].trim());
                    int IdCurso = Integer.parseInt(datos[i].split(",")[1].trim());
                    if(IdCurso > 0 && IdProfesor > 0){
                        Profesor profesor = new Profesor().getProfesor(profesores, IdProfesor);//Almacenamos al alumnos
                        Curso curso = new Curso().getCurso(cusros, IdCurso);
                        if(profesor != null && curso != null){//Validamos que el alumno y el curso si exista
                            if(!profesor.getCursoProfesor(profesor.getCursos(), IdCurso)){//Validamos si ya con el curso
                                for (int j = 0; j < profesores.length; j++) {
                                    if(profesores[j] != null){
                                        if(profesores[j].getId() == IdProfesor){
                                            for (int k = 0; k < profesores[j].getCursos().length; k++) {
                                                if(profesores[j].getCursos()[k]==null){
                                                    profesores[j].setCursoProfesor(curso, k);
                                                    break;
                                                }
                                            }
                                        }
                                    }
                                }
                            }else{
                                System.out.println("El cuso ya lo tiene asignado");
                            }
                        }else{
                            if(profesor == null){//el alumno no existe
                                System.out.println("El alumno no existe");
                            }
                            if(curso == null){//El curso no existe
                                System.out.println("El curso no existe");
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
    
    public static void CargaCursos(){
        String datos_a = LeerArchivo(consola.inputString("Ingrese La ruta del Archivo para la carga de los Cursos:\n-->"));
        String datos[] = datos_a.split("\n");
        for(int i = 0; i< datos.length; i++){
            if(i > 0){
                try {
                    int Id = Integer.parseInt(datos[i].split(",")[0].trim());
                    int Codigo = Integer.parseInt(datos[i].split(",")[1].trim());
                    String Nombre = datos[i].split(",")[2].trim();
                    if(Id > 0 && Codigo > 0 && Nombre.length() != 0){
                        if(cusros[14] == null){
                            for (int j = 0; j < cusros.length; j++) {
                                if(cusros[j] != null){
                                    if(cusros[j].getId() == Id || cusros[j].getCodigo()== Codigo || cusros[j].getNombre().equals(Nombre)){
                                        System.out.println("Este alumno tiene el mismo alumno");
                                        System.out.println("Base de Datos: "+ cusros[j].getId() + " Nombre: " + cusros[j].getNombre());
                                        System.out.println("En el Archivo: " + Id + " Nombre: " + Nombre);
                                        break;
                                    }
                                }else{
                                    System.out.println("Ingresamos a crear un nuevo alumnos");
                                    cusros[j] = new Curso(Id, Codigo, Nombre);
                                    System.out.println("Nuevo Alumno\n Id: "+ cusros[j].getId() + " Nombre: "+ cusros[j].getNombre());
                                    break;
                                }
                            }
                        }else{
                            System.out.println("*******Eroror Ya no hay Capacidad para mas cursos.******");
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
    
    public static void CargaNotas(){
        String datos_a = LeerArchivo(consola.inputString("Ingrese La ruta del Archivo para la carga de Notas:\n-->"));
        String datos[] = datos_a.split("\n");
        for(int i = 0; i< datos.length; i++){
            if(i > 0){
                try {
                    int IdAlumno = Integer.parseInt(datos[i].split(",")[0].trim());
                    int IdCurso = Integer.parseInt(datos[i].split(",")[1].trim());
                    float Nota = Float.parseFloat(datos[i].split(",")[2].trim());
                    if(IdAlumno > 0 && IdCurso > 0 && Nota >= 0 && Nota <= 100){
                        for (int j = 0; j < alumnos.length; j++) {
                            if(alumnos[j] != null){
                                if(alumnos[j].getId() == IdAlumno){
                                    for (int k = 0; k < alumnos[j].getCurso().length; k++) {
                                        if(alumnos[j].getCurso()[k] != null){
                                            if(alumnos[j].getCurso()[k].getId() == IdCurso){
                                                alumnos[j].getCurso()[k].setNota(Nota);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }else{
                        if(IdAlumno <= 0){
                            System.out.println("El id del alumno no puede ser negativo");
                        }
                        if(IdCurso <= 0){
                            System.out.println("el id del curso no puede ser negativo");
                        }
                        if(Nota < 0 && Nota > 100){
                            System.out.println("La nota esta fuera de rango");
                        }
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
        //C:\Users\cesar.monroy\Desktop\ipc\LecturaArchivos_CSV\CargaCursos.csv
        
        //C:\Users\cesar.monroy\Desktop\ipc\LecturaArchivos_CSV\AsigncacionAlumnos.csv
        //C:\Users\cesar.monroy\Desktop\ipc\LecturaArchivos_CSV\AsigncacionProfesores.csv
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
