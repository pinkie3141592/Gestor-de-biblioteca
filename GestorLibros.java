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
    }

    public void guardarLibros()
    {
        try{
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
                libros.add(l);
            }
            br.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }


    }   

    public void mostrarLibros()
    {
        boolean existe = false;
        try
        {
            BufferedReader br = new BufferedReader(new FileReader(archivo));

            String linea;
            while ((linea = br.readLine()) != null) 
            {
                System.out.println(linea);
                existe = true;
            }

            br.close();

            if(!existe)
            {
                System.out.println("\n\tNo se han registrado libros en el catalogo");
                Utilidades.pausa();
            }

        }

        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

}
