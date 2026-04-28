import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileReader;

public class GestorLibros {

    ArrayList<Libro> libros;
    File carpeta = new File("biblioteca");
    File archivo = new File("biblioteca/libros.txt");

    public GestorLibros()
    {
        libros = new ArrayList<>();
    }

    public void crearCarpetayArchivo()
    {
        
        if(!carpeta.exists())
        {
            carpeta.mkdir();
        }

        try{
            if(!archivo.exists())
            {
                archivo.createNewFile();
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

    }

    public void agregarLibro(Libro libro)
    {
        if(libro != null)
            libros.add(libro);

        String codigo  = libro.getCodigo();
        String titulo  = libro.getTitulo();
        String autor  = libro.getAutor();
        int ano  = libro.getAno();

        System.out.println("\nEl libro se agrego correctamente!");
       

    }

    public void guardarLibros()
    {
        try
        {
        BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));

            for(Libro l : libros)
            {
                bw.write(l.toFileString());
                bw.newLine();
            }

            bw.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

    }

    public void cargarLibros()
    {
        libros.clear();
        try
        {
            BufferedReader br = new BufferedReader(new FileReader(archivo));
            String linea;

            while((linea = br.readLine()) != null)
            {
                String[] partes = linea.split(",");

                Libro l = new Libro(
                    partes[0],
                    partes[1],
                    partes[2],
                    Integer.parseInt(partes[3])
                );
                System.out.println();
                libros.add(l);
            }
            br.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }


    }   

    public boolean confirmarExistencia(String codigo)//confirma existencia por codigo
    {
        for(Libro l : libros)
        {
            if(l.getCodigo().equalsIgnoreCase(codigo))
                return true;
        }

        return false;
    }

    public void mostrarLibro(Libro libro)
    {
        if(!confirmarExistencia(libro.getCodigo()))
        {
            System.out.println("\n\tEl libro buscado no existe en el catalogo");
            Utilidades.pausa();
            return;
        }   

        System.out.println("\n------------------------");
        System.out.printf("%-10s %s\n", "CODIGO:", libro.getCodigo());
        System.out.printf("%-10s %s\n", "TITULO:", libro.getTitulo());
        System.out.printf("%-10s %s\n", "AUTOR:", libro.getAutor());
        System.out.printf("%-10s %s\n", "AÑO:", libro.getAno());
        System.out.println("------------------------");

    }

    public void mostrarCatalogo(ArrayList<Libro> lista)
    {
        if(lista.isEmpty())
        {
            System.out.println("\n\tNo se han registrado libros");
            return;
        }

        for(Libro l : lista)
            mostrarLibro(l);
    }

    public ArrayList<Libro> ordenarAutor()
    {
        ArrayList<Libro> copia = new ArrayList<>(libros);

        copia.sort((a,b) -> a.getAutor().compareToIgnoreCase(b.getAutor()));

        return copia;
    }

    public ArrayList<Libro> ordenarTitulo()
    {
        ArrayList<Libro> copia = new ArrayList<>(libros);

        copia.sort((a,b) -> a.getTitulo().compareToIgnoreCase(b.getTitulo()));

        return copia;
    }

    public ArrayList<Libro> ordenarCodigo()
    {
        ArrayList<Libro> copia = new ArrayList<>(libros);

        copia.sort((a,b) -> 
        {
            int numA = Integer.parseInt(a.getCodigo().substring(1));
            int numB = Integer.parseInt(b.getCodigo().substring(1));
            return Integer.compare(numA, numB);
        });

        return copia;
    }

    public ArrayList<Libro> ordenarAno()
    {
        ArrayList<Libro> copia = new ArrayList<> (libros);

        copia.sort((a,b) -> Integer.compare(a.getAno(), b.getAno()));

        return copia;
    }

}
