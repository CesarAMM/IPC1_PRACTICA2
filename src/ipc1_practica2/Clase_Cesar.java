package ipc1_practica2;

import static ipc1_practica2.IPC1_PRACTICA2.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import school.poo.*;

public class Clase_Cesar {
    
    public static void IngresarUsuario(){
        boolean estado = true; int contador =0;
        if(users[5][0] == null){
            do{
                contador = 0;
                String newUsers = consola.inputString("Ingrese usuario nuevo: ");
                do{
                    System.out.print("Ingrese la Contraseña: ");
                    char[] newPass1 = System.console().readPassword();
                    char[] newPass2 = System.console().readPassword();
                    String newPass_1 ="", newPass_2=""; 
                    for (int i = 0; i < newPass1.length; i++) {
                        newPass_1 += newPass1[i];
                    }
                    for (int i = 0; i < newPass2.length; i++) {
                        newPass_2 += newPass2[i];
                    }
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
                    if((dia> 0 && dia< 32) && (mes > 0 && mes <13) && (ayo > 1900 && ayo <= 2021) && Id > 0 && Carnet > 0){
                        if(alumnos[99] == null){
                            for (int j = 0; j < alumnos.length; j++) {
                                if(alumnos[j] != null){
                                    if(alumnos[j].getId() == Id|| alumnos[j].getCarnet() == Carnet){
                                        addToEndFile("Error en la linea ("+(i+2)+"): Carnet: "+ alumnos[j].getCarnet() +" Nombre"+ alumnos[j].getNombre());
                                        break;
                                    }
                                }else{
                                    alumnos[j] = new Alumno(Id, Carnet, Nombre, Fecha, Genero);
                                    System.out.println("Nuevo Alumno\n Id: "+ alumnos[j].getId() + " Nombre: "+ alumnos[j].getNombre());
                                    break;
                                }
                            }
                        }
                    }else{
                        addToEndFile("Error en la Liena("+(i+2)+"): Por la fecha en mal formato");
                    }
                } catch (Exception e) {
                    addToEndFile("Error en la Liena("+(i+2)+"):ID: "+datos[i].split(",")[0].trim() +""
                            + "Carnet: "+datos[i].split(",")[1].trim()+""
                                    + "Nombre: "+datos[i].split(",")[2].trim()
                                    + "Fecha: "+datos[i].split(",")[3].trim()
                                    + "Genero: "+ datos[i].split(",")[4].trim().charAt(0));
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
                                        addToEndFile(""
                                                + "Error en la line("+(i+2)+"): Ya existe este profesor: "+ Nombre+" Registro: "+ Registo);
                                        break;
                                    }
                                }else{
                                    profesores[j] = new Profesor(Id, Registo, Nombre, FechaNacimiento, FechaContratacion, Genero);
                                    break;
                                }
                            }
                        }
                    }else{
                        addToEndFile("Error en la Liena("+(i+2)+"): Por la fecha en mal formato");
                    }
                } catch (Exception e) {
                    addToEndFile("Error en la Liena("+(i+2)+"):ID: "+datos[i].split(",")[0].trim() +""
                            + "Carnet: "+datos[i].split(",")[1].trim()+""
                                    + "Nombre: "+datos[i].split(",")[2].trim()
                                    + "Fecha: "+datos[i].split(",")[3].trim()
                                    + "Genero: "+ datos[i].split(",")[4].trim().charAt(0));
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
                                addToEndFile("El cuso ya lo tiene asignado Linea "+(i)+"");
                            }
                        }else{
                            if(alumno == null){//el alumno no existe
                                addToEndFile("El alumno no existe Linea "+(i)+"");
                            }
                            if(curso == null){//El curso no existe
                                addToEndFile("El curso no existe Linea "+(i)+"");
                            }
                        }
                    }else{
                        addToEndFile("error en la fecha Linea "+(i)+"");
                    }
                } catch (Exception e) {
                    addToEndFile("Error en el formato de algo Linea "+(i)+"");
                    
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
                                addToEndFile("El cuso ya lo tiene asignado Linea "+(i)+"");
                            }
                        }else{
                            if(profesor == null){//el alumno no existe
                                addToEndFile("El alumno no existe Linea "+(i)+"");
                            }
                            if(curso == null){//El curso no existe
                                addToEndFile("El curso no existe Linea "+(i)+"");
                            }
                        }
                    }else{
                        addToEndFile("error en la fecha Linea "+(i)+"");
                    }
                } catch (Exception e) {
                    addToEndFile("Error en el formato de algo Linea "+(i)+"");
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
                                        addToEndFile("Error en el formato de algo Linea "+(i)+""
                                                + "El Curso ya se encuentra: Base de Datos: "+ cusros[j].getId() + " Nombre: " + cusros[j].getNombre()+"");
                                        break;
                                    }
                                }else{
                                    cusros[j] = new Curso(Id, Codigo, Nombre);
                                    break;
                                }
                            }
                        }else{
                            addToEndFile("*******error Ya no hay Capacidad para mas cursos.******"
                                    + "\nId:" + datos[i].split(",")[0].trim()+""
                                            + "\nCodigo: "+datos[i].split(",")[1].trim());
                        }
                    }else{
                        addToEndFile("error en la fecha");
                    }
                } catch (Exception e) {
                    addToEndFile("Error en el formato de algo");
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
                            addToEndFile("El id del alumno no puede ser negativo");
                        }
                        if(IdCurso <= 0){
                            addToEndFile("el id del curso no puede ser negativo");
                        }
                        if(Nota < 0 && Nota > 100){
                            addToEndFile("La nota esta fuera de rango");
                        }
                    }
                } catch (Exception e) {
                    addToEndFile("Error en el formato de algo");
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
        //C:\Users\cesar.monroy\Desktop\ipc\LecturaArchivos_CSV\CargaNotas.csv
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
    
    public static void CrearReportes(String NameReport, String strRepote){
        String ArcchivoHTML = ""
                + "<!DOCTYPE html>\n" +"<html lang=\"en\">\n" +"<head>\n"
                + "<meta charset=\"UTF-8\">\n"
                + "<meta name='viewport' content='width=device-width, initial-scale=1.0'>\n" +
                "<meta http-equiv='X-AU-Compatible' content='ie=edge'>\n" +
                "<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x\" crossorigin=\"anonymous\">\n" +
                "<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4\" crossorigin=\"anonymous\"></script>\n" +
                "<link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.7.0/css/all.css\" integrity=\"sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ\" crossorigin=\"anonymous\"/>\n" +
                "<title>"+NameReport+"</title>" +
                "</head>\n" +
                "<body class=\"bg-light container-fluid\">"
                + ""+strRepote+""
                + "</body>\n" +
                "</html>";
        File f = new File(NameReport+".html");
        if(!f.exists()){
            try {
                f.createNewFile();
            } catch (IOException e) {
                System.out.println(e);
            }
        }
        try {
            FileWriter file = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(file);
            bw.write(ArcchivoHTML);
            bw.close();
            System.out.println("Se a genereado el reporte");
        } catch (Exception e) {
        }
    }
    
    public static String GenerarReporteAlumnos(){
        String HTML_tbody = "";
        for (int i = 0; i < alumnos.length; i++) {
            if(alumnos[i] != null){
                HTML_tbody += "<tr>";
                HTML_tbody += ""
                        + "<th scope='col'>"+(i+1)+"</th>"
                        + "<td>"+alumnos[i].getCarnet()+"</td>"
                        + "<td>"+alumnos[i].getNombre()+"</td>"
                        + "<td>"+alumnos[i].def_Edad()+"</td>"
                        + "<td>"+alumnos[i].def_genero()+"</td>";
                HTML_tbody += "</tr>";
            }
        }
        return consola.defaultHTML_BODY("Reporte de Alumnos", "Carne,Nombre,Edad,Genero").replace("Info_TBODY", HTML_tbody);
    }
    
    public static String GenerarReporteAsignacionAlumnos(){
        String HTML_tbody = ""; int contador =0;
        for(int i = 0; i < alumnos.length; i++){
            if(alumnos[i] != null){
                for (int j = 0; j < alumnos[i].getCurso().length; j++) {
                    if(alumnos[i].getCurso()[j] != null){
                        contador++;
                        HTML_tbody += "<tr>";
                        HTML_tbody += ""
                                + "<th scope='col'>"+(contador)+"</th>"
                                + "<td>"+alumnos[i].getCarnet()+"</td>"
                                + "<td>"+alumnos[i].getNombre()+"</td>"
                                + "<td>"+alumnos[i].getCurso()[j].getCodigo()+"</td>"
                                + "<td>"+alumnos[i].getCurso()[j].getNombre()+"</td>"
                                + "<td>"+alumnos[i].getCurso()[j].getFecha()+"</td>";
                        HTML_tbody += "</tr>";
                    }
                }
            }
        }
        return consola.defaultHTML_BODY("Reporte de Asignaciones de Alumnos", "Carne,Nombre,Codigo Curso, Curso, Fecha Asignacion").replace("Info_TBODY", HTML_tbody);
    }
    
    public static String GenerarReporteAsignacionesProfesores(){
        String HTML_tbody = "";int contador = 0;
        for(int i = 0; i < profesores.length; i++){
            if(profesores[i] != null){
                for (int j = 0; j < profesores[i].getCursos().length; j++) {
                    if(profesores[i].getCursos()[j] != null){
                        contador++;
                        HTML_tbody += "<tr>";
                        HTML_tbody += ""
                                + "<th scope='col'>"+(contador)+"</th>"
                                + "<td>"+profesores[i].getRegisto()+"</td>"
                                + "<td>"+profesores[i].getNombre()+"</td>"
                                + "<td>"+profesores[i].getCursos()[j].getCodigo()+"</td>"
                                + "<td>"+profesores[i].getCursos()[j].getNombre()+"</td>"
                                + "<td>"+profesores[i].getCursos()[j].getFecha()+"</td>";
                        HTML_tbody += "</tr>";
                    }
                }
            }
        }
        return consola.defaultHTML_BODY("Reporte de Asignaciones de Profesores", "Registro,Nombre,Codigo Curso, Curso, Fecha Asignacion").replace("Info_TBODY", HTML_tbody);
    }
    
    public static String GenerarRepoteGeneralCurso(){
        String[][] info = contadorAlumnos_vs_Curso();
        String HTML_tbody = "";
        for(int i = 0; i < info.length; i++){
            if(info[i] != null){
                HTML_tbody += ""
                        + "<tr>"
                            + "<th>"+(i+1)+"</th>"
                            + "<td>"+info[i][0]+"</td>"
                            + "<td>"+info[i][1]+"</td>"
                            + "<td>"+info[i][2]+"</td>"
                        + "</tr>";
            }
        }
        return consola.defaultHTML_BODY("Reporte General de Cursos", "Codigo Curso, Curso, Cantidad").replace("Info_TBODY", HTML_tbody);
    }
    
    public static String GenerarReporteCursoEspecifico(){
        Curso curso = BuscarCurso();
        Profesor profesor = BuscarProfesor(curso);
        String[][] listadoAlumnos = BuscarAlumnos(curso);
        String HTML_tbody = "";
        for(int i = 0; i < listadoAlumnos.length; i++){
            if(listadoAlumnos[i] != null){
                String Set_Color ="";
                if(Float.parseFloat(listadoAlumnos[i][2]) > 60.0){
                    Set_Color = "Aprobado";
                }else{
                    Set_Color = "Reprobado";
                }
                HTML_tbody += ""
                        + "<tr>"
                            + "<th>"+(i+1)+"</th>"
                            + "<td>"+listadoAlumnos[i][0]+"</td>"
                            + "<td>"+listadoAlumnos[i][1]+"</td>"
                            + "<td>"+listadoAlumnos[i][2]+"</td>"
                            + "<td>"+Set_Color+"</td>"
                        + "</tr>";
            }
        }
        String nameReport = ""+ curso.getCodigo()+": " + curso.getNombre() +" -- " + profesor.getRegisto() + ": " + profesor.getNombre();
        return consola.defaultHTML_BODY(nameReport, "Carnet, Nombre, Nota, Aprobado/Reprobado").replace("Info_TBODY", HTML_tbody);
    }
    
    public static String GenerarReporteTop_5(){
        Curso curso = BuscarCurso();
        Profesor profesor = BuscarProfesor(curso);
        String[][] listaAlumnos = MetodoBurbuja(BuscarAlumnos(curso));
        String HTML_tbody = "";
        for (int i = 5; i >=0; i--) {
            if(listaAlumnos[i][0] != null){
                HTML_tbody += "<tr>";
                HTML_tbody += ""
                        + "<th scope='col'>"+(i+1)+"</th>"
                        + "<td>"+listaAlumnos[i][0]+"</td>"
                        + "<td>"+listaAlumnos[i][1]+"</td>"
                        + "<td>"+listaAlumnos[i][2]+"</td>";
                HTML_tbody += "</tr>";
            }
        }
        String nameReport = ""+ curso.getCodigo()+": " + curso.getNombre() +" -- " + profesor.getRegisto() + ": " + profesor.getNombre();
        return consola.defaultHTML_BODY(nameReport, "Carnet, Nombre, Nota").replace("Info_TBODY", HTML_tbody);
    }
    
    public static String[][] MetodoBurbuja(String[][] alumnos){
        for (int i = 0; i < (alumnos.length - 1); i++) {
            for (int j = 0; j < (alumnos.length -1); j++) {
                float Notaacutial = Float.parseFloat(alumnos[j][2]);
                float NotaSig = Float.parseFloat(alumnos[j+1][2]);
                if(Notaacutial > NotaSig){
                    String carnetaux = alumnos[j][0];
                    String NombreAux = alumnos[j][1];
                    String NotaAux = alumnos[j][2];
                    alumnos[j][0] = alumnos[j+1][0];
                    alumnos[j][1] = alumnos[j+1][1];
                    alumnos[j][2] = alumnos[j+1][2];
                    alumnos[j+1][0] = carnetaux;
                    alumnos[j+1][1] = NombreAux;
                    alumnos[j+1][2] = NotaAux;
                }
            }
        }
      return alumnos;
    }
    
    public static String[][] BuscarAlumnos(Curso curso){
        String listadoAlumnos = "";
        for (int i = 0; i < alumnos.length; i++) {//Busqueda de Los alumnos asignados a un curso especifico
            if(alumnos[i] != null){
                for (int j = 0; j < alumnos[i].getCurso().length; j++) {
                    if(alumnos[i].getCurso()[j] != null){
                        if(alumnos[i].getCurso()[j].getCodigo() == curso.getCodigo()){
                            listadoAlumnos+= ""+alumnos[i].getCarnet()+","+alumnos[i].getNombre()+","+alumnos[i].getCurso()[j].getNota()+"\n";
                        }
                    }
                }
            }
        }
        String Listado[][] = new String[listadoAlumnos.split("\n").length][3];
        for (int i = 0; i < Listado.length; i++) {
            for (int j = 0; j < Listado[0].length; j++) {
                Listado[i][j] = listadoAlumnos.split("\n")[i].split(",")[j];
            }
        }
        return Listado;
    }
    
    public static String[][] contadorAlumnos_vs_Curso(){
        String[][] contador = new String[15][3];
        for (int i = 0; i < cusros.length; i++) {
            if(cusros[i] != null){
                int CodigoCurso = cusros[i].getCodigo();
                int CantidadEncontrados = 0;
                for (int j = 0; j < alumnos.length; j++) {
                    if(alumnos[j] != null){
                        for (int k = 0; k < alumnos[j].getCurso().length; k++) {
                            if(alumnos[j].getCurso()[k] != null){
                                if(alumnos[j].getCurso()[k].getCodigo() == CodigoCurso){
                                    CantidadEncontrados++;
                                }
                            }
                        }
                    }
                }
                for (int j = 0; j < contador.length; j++) {
                    if(null == contador[j][0]){
                        contador[j][0] = "" + cusros[i].getCodigo();
                        contador[j][1] = cusros[i].getNombre();
                        contador[j][2] = "" + CantidadEncontrados;
                        break;
                    }
                    
                }
            }
            
        }
        return contador;
    }
    
    public static Profesor BuscarProfesor(Curso curso){
        for (int i = 0; i < profesores.length; i++) {//Busqueda del profesro que tenga asignado el curso
            if(profesores[i] != null){
                for (int j = 0; j < profesores[i].getCursos().length; j++) {
                    if(profesores[i].getCursos()[j] != null){
                        if(profesores[i].getCursos()[j].getCodigo() == curso.getCodigo()){
                            return profesores[i];
                        }
                    }
                }
            }
        }
        return null;
    }
    
    public static Curso BuscarCurso(){
        int CodigoCurso = 0;
        Curso curso = null;
        do{
            CodigoCurso =  consola.inputInt("Ingrese el Codigo del Curso: \n-->");
            for (int i = 0; i < cusros.length; i++) {
                if(cusros[i] != null){
                    if(cusros[i].getCodigo() == CodigoCurso){
                        curso = cusros[i];
                        break;
                    }
                }
            }
            if(curso == null){
                CodigoCurso = 0;
                System.out.println("-----   El codigo de Curso no existe   ----");
            }
        }while(CodigoCurso == 0);
        return curso;
    }
    
    public static void addToEndFile(String data) {
        FileWriter flwriter = null;
        try {
            flwriter = new FileWriter("Logs.txt", true); // True indica que se va a agregar datos al final
            BufferedWriter bfwriter = new BufferedWriter(flwriter);
            // Escribe los datos en el archivo
            bfwriter.write(data + "\n");
            bfwriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (flwriter != null) {
                try {
                    flwriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
