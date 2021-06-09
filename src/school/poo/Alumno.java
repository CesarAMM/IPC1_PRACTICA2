package school.poo;

public class Alumno {
   private int Id;
   private int Carnet;
   private String Nombre;
   private String FechaIngreso;
   private char Genero;
   private String[][] Curso;//[CantidadCursos][2]

    public Alumno() {
    }

    public Alumno(int Id, int Carnet, String Nombre, String FechaIngreso, char Genero, String[][] Curso) {
        this.Id = Id;
        this.Carnet = Carnet;
        this.Nombre = Nombre;
        this.FechaIngreso = FechaIngreso;
        this.Genero = Genero;
        this.Curso = Curso;
    }

    public Alumno(int Id, int Carnet, String Nombre, String FechaIngreso, char Genero) {
        this.Id = Id;
        this.Carnet = Carnet;
        this.Nombre = Nombre;
        this.FechaIngreso = FechaIngreso;
        this.Genero = Genero;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getCarnet() {
        return Carnet;
    }

    public void setCarnet(int Carnet) {
        this.Carnet = Carnet;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getFechaIngreso() {
        return FechaIngreso;
    }

    public void setFechaIngreso(String FechaIngreso) {
        this.FechaIngreso = FechaIngreso;
    }

    public char getGenero() {
        return Genero;
    }

    public void setGenero(char Genero) {
        this.Genero = Genero;
    }

    public String[][] getCurso() {
        return Curso;
    }

    public void setCurso(String[][] Curso) {
        this.Curso = Curso;
    }
   
}
