package school.poo;

public class Profesor {
    private int Id;
    private int Registo;
    private String Nombre;
    private String FechaNacimiento;
    private String FechaContratacion;
    private char Genero;
    private String[] Cursos;//[CantidadCursos]

    public Profesor() {
    }

    public Profesor(int Id, int Registo, String Nombre, String FechaNacimiento, String FechaContratacion, char Genero) {
        this.Id = Id;
        this.Registo = Registo;
        this.Nombre = Nombre;
        this.FechaNacimiento = FechaNacimiento;
        this.FechaContratacion = FechaContratacion;
        this.Genero = Genero;
    }

    public Profesor(int Id, int Registo, String Nombre, String FechaNacimiento, String FechaContratacion, char Genero, String[] Cursos) {
        this.Id = Id;
        this.Registo = Registo;
        this.Nombre = Nombre;
        this.FechaNacimiento = FechaNacimiento;
        this.FechaContratacion = FechaContratacion;
        this.Genero = Genero;
        this.Cursos = Cursos;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getRegisto() {
        return Registo;
    }

    public void setRegisto(int Registo) {
        this.Registo = Registo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getFechaNacimiento() {
        return FechaNacimiento;
    }

    public void setFechaNacimiento(String FechaNacimiento) {
        this.FechaNacimiento = FechaNacimiento;
    }

    public String getFechaContratacion() {
        return FechaContratacion;
    }

    public void setFechaContratacion(String FechaContratacion) {
        this.FechaContratacion = FechaContratacion;
    }

    public char getGenero() {
        return Genero;
    }

    public void setGenero(char Genero) {
        this.Genero = Genero;
    }

    public String[] getCursos() {
        return Cursos;
    }

    public void setCursos(String[] Cursos) {
        this.Cursos = Cursos;
    }
    
}
