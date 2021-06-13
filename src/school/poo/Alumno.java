package school.poo;

public class Alumno {
   private int Id;
   private int Carnet;
   private String Nombre;
   private String FechaIngreso;
   private char Genero;
   private Curso[] Curso;

    public Alumno() {}

    public Alumno(int Id, int Carnet, String Nombre, String FechaIngreso, char Genero) {
        this.Id = Id;
        this.Carnet = Carnet;
        this.Nombre = Nombre;
        this.FechaIngreso = FechaIngreso;
        this.Genero = Genero;
        this.Curso = new Curso[15];
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

    public Curso[] getCurso() {
        return Curso;
    }

    public void setCurso(Curso Curso, int i) {
        this.Curso[i] = Curso;
    }
   
    public Curso getCurso(int i){
        return this.Curso[i];
    }
    
    public Alumno getAlumno(Alumno[] alumnos, int id){
        for (int i = 0; i < alumnos.length; i++) {
            if(alumnos[i] != null){
                if(alumnos[i].getId() == id){
                    return alumnos[i];//Encontramos al alumnos
                }
            }
        }
        return null;//Recorio todo el ciclo y no encontro al alumno
    }
    
    public boolean getCursoAlumno(Curso[] curso, int id){
        for (int i = 0; i < curso.length; i++) {
            if(curso[i] != null){
                if(curso[i].getId() == id){
                  return true;//El curso si lo tiene
                }
            }
        }
        return false;//El curso no lo tiene el alumno
    }
    
    public void setCursoAlumno(Curso curso, int i){
        this.Curso[i] = new Curso(curso.getId(), curso.getCodigo(), curso.getNombre());
    }
    
}
