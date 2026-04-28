public class Libro {

    private String codigo;
    private String titulo; 
    private String autor; 
    private int ano;


    public Libro(String codigo, String titulo, String autor, int ano)
    {
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
    }

    @Override
    public String toString()
    {
        return "CODIGO: " + codigo + "\nTITULO: " + titulo + "\nAUTOR: " + autor + "\nAÑO: " + ano;
    }

    public String toFileString()
    {
        return codigo + "," + titulo + "," + autor + "," + ano;
    }

    //GETTERS
    public String getCodigo()
    {
        return codigo;
    }

    public String getAutor()
    {
        return autor;
    }

    public String getTitulo()
    {
        return titulo;
    }

    public int getAno()
    {
        return ano;
    }

    //SETTERS

    public void setCodigo(String codigo)
    {
        this.codigo = codigo;
    }
    public void setTitulo(String titulo)
    {
        this.titulo = titulo;
    }

    public void setAutor(String autor)
    {
        this.autor = autor;
    }
    public void setAno(int ano)
    {
        this.ano = ano;
    }

}