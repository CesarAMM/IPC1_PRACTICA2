package school.poo;

public class Profesor {
    private int Id;
    private int Registo;
    private String Nombre;
    private String FechaNacimiento;
    private String FechaContratacion;
    private char Genero;
    private Curso[] Cursos;//[CantidadCursos]

    public Profesor() {
    }

    public Profesor(int Id, int Registo, String Nombre, String FechaNacimiento, String FechaContratacion, char Genero) {
        this.Id = Id;
        this.Registo = Registo;
        this.Nombre = Nombre;
        this.FechaNacimiento = FechaNacimiento;
        this.FechaContratacion = FechaContratacion;
        this.Genero = Genero;
        this.Cursos = new  Curso[15];
    }

    public Profesor(int Id, int Registo, String Nombre, String FechaNacimiento, String FechaContratacion, char Genero, Curso[] Cursos) {
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

    public Curso[] getCursos() {
        return Cursos;
    }

    public void setCursos(Curso[] Cursos) {
        this.Cursos = Cursos;
    }
     
        public Profesor getProfesor(Profesor[] profesores, int id){
        for (int i = 0; i < profesores.length; i++) {
            if(profesores[i] != null){
                if(profesores[i].getId() == id){
                    return profesores[i];//Encontramos al alumnos
                }
            }
        }
        return null;//Recorio todo el ciclo y no encontro al alumno
    }
    
    public boolean getCursoProfesor(Curso[] curso, int id){
        for (int i = 0; i < curso.length; i++) {
            if(curso[i] != null){
                if(curso[i].getId() == id){
                  return true;//El curso si lo tiene
                }
            }
        }
        return false;//El curso no lo tiene el alumno
    }
    
    public void setCursoProfesor(Curso curso, int i){
        this.Cursos[i] = new Curso(curso.getId(), curso.getCodigo(), curso.getNombre(),1);
    }
    
}
