package school.poo;
public class Curso {
    private int Id;
    private int Codigo;
    private String Nombre;
    private float Nota;

    public Curso() {
    }

    public Curso(int Id, int Codigo, String Nombre) {
        this.Id = Id;
        this.Codigo = Codigo;
        this.Nombre = Nombre;
        this.Nota = 0;
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
    
}
