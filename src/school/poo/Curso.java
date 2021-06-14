package school.poo;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Curso {
    private int Id;
    private int Codigo;
    private String Nombre;
    private String Fecha;
    private float Nota;
    
    public Curso() {}

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public Curso(int Id, int Codigo, String Nombre) {
        this.Id = Id;
        this.Codigo = Codigo;
        this.Nombre = Nombre;
        this.Fecha= "";
        this.Nota = 0;
    }
    
    public Curso(int Id, int Codigo, String Nombre, int i){
        this.Id = Id;
        this.Codigo = Codigo;
        this.Nombre = Nombre;
        this.Fecha= FechaAsignacion();
        this.Nota = 0;
    }
    
    private String FechaAsignacion(){
        Calendar fecha = new GregorianCalendar();
        int mesAC = fecha.get(Calendar.MONTH) +1;
        int diaAC = fecha.get(Calendar.DATE);
        int ayoAC = fecha.get(Calendar.YEAR);
        return ""+diaAC+"/"+mesAC+"/"+ayoAC;
    }
    
    public Curso(int Id, int Codigo, String Nombre, float Nota) {
        this.Id = Id;
        this.Codigo = Codigo;
        this.Nombre = Nombre;
        this.Nota = Nota;
    }

    public float getNota() {
        return Nota;
    }

    public void setNota(float Nota) {
        this.Nota = Nota;
    }
    
    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int Codigo) {
        this.Codigo = Codigo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    
    public Curso getCurso(Curso[] curso, int Id){
        for (int i = 0; i < curso.length; i++) {
            if(curso[i] != null){
                if(curso[i].getId() == Id){
                    return curso[i];
                }
            }
        }
        return null;
    }
}
