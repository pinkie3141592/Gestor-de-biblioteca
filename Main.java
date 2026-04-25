import java.util.Scanner;

public class Main {
    
    static GestorLibros gestor = new GestorLibros();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args)
    {
        gestor.crearCarpetayArchivo();
        gestor.cargarLibros(); //esto hace que si ya hay libros guardados, se consideren en la nueva sesion

        String respuesta;
        int opcion = 0;
        do
        {
            do
            {

                Utilidades.limpiarConsola();

                System.out.println("\t\tGESTOR DE LIBROS\n\n");
                System.out.println("""
                    \t1. Mostrar catalogo\n
                    \t2. Agregar un libro\n
                    \t3. Guardar catalogo\n
                    \t4. Cargar catalogo\n
                    \t5. Salir\n  
                """);
                System.out.println("Opcion: ");

                opcion = sc.nextInt();
                sc.nextLine();

                if(!Validaciones.validarEntero(opcion, 1, 5))
                {
                    System.out.println("\nSelecciona una opcion valida.");
                    Utilidades.pausa();
                }

            }while(!Validaciones.validarEntero(opcion, 1, 5));

            switch(opcion)
            {
                case 1:
                    mostrarCatalogoOrdenado();
                    Utilidades.pausa();
                    break;

                case 2:
                    Libro libro = leerLibro();
                    
                    if(libro!=null)
                        gestor.agregarLibro(libro);
                    else
                        System.out.println("\tOperacion cancelda");
                    
                    Utilidades.pausa();
                    break;
                case 3:
                    gestor.guardarLibros();
                    Utilidades.pausa();
                    break;
                case 4:
                    gestor.cargarLibros();
                    Utilidades.pausa();
                    break;
                case 5:
                    System.out.println("\n\tSi no guardaste el catalogo, los libros registrados se perderan.");
                    System.out.println("\n\tPara regresar presiona n, o cualquier otra tecla para salir.");
                    System.out.println("\n\t(si ya guardaste, haz caso omiso a esta advertencia)");
                    respuesta = sc.nextLine();

                    if(respuesta.equals("n"))
                        opcion = 0;

                }
        }while(opcion != 5);

    }

    public static Libro leerLibro()
    {
        String autor = "", titulo = "", codigo = "", anoStr = "";
        int ano = 0;

//CICLO PARA CODIGO--------------------------------------------------------------------
        do{
            Utilidades.limpiarConsola();
            System.out.println("\nREGISTRO DE LIBRO\n");

            codigo = Utilidades.leerCampo("\nCODIGO (L###): ");

            if (codigo == null) 
                return null;

            if(!Validaciones.validarCodigo(codigo))
            {
                System.out.println("\n\tIntroduce un codigo valido");
                Utilidades.pausa();
            }
            
            if(gestor.confirmarExistencia(codigo))
            {
                System.out.println("\n\tEste codigo ya esta registrado. Utilice uno distinto.");
                Utilidades.pausa();
            }
            

        }while(!Validaciones.validarCodigo(codigo) || gestor.confirmarExistencia(codigo));


//CICLO PARA TITULO ----------------------------------------------------------------------
        do 
        {
            titulo = Utilidades.leerCampo("\nTITULO (Letras y caracteres)");
            if (titulo == null) return null;    
            
            if(!Validaciones.validarTitulo(titulo))
            {
                System.out.println("\n\tIntroduce un titulo valido");
                Utilidades.pausa();
            }    

        } while(!Validaciones.validarTitulo(titulo));


//CICLO PARA AUTOR -----------------------------------------------------------------------
        do 
        {
            autor = Utilidades.leerCampo("\nAUTOR (Solo letras y espacios): ");
            if (autor == null) return null;  

            if(!Validaciones.validarAutor(autor))
            {
                System.out.println("\n\tIntroduce solo letras y espacios");
                Utilidades.pausa();
            }  

        } while (!Validaciones.validarAutor(autor));


//CICLO PARA AÑO --------------------------------------------------------------------------------
        do 
        {
            anoStr = Utilidades.leerCampo("\nAÑO: ");
            if (anoStr == null) 
                return null;

            if(Validaciones.validarAno(anoStr))
            {
                ano = Integer.parseInt(anoStr);
                if(!Validaciones.validarEntero(ano, 1000, 2100))
                {
                    System.out.println("\n\tIntroduce un año valido");
                    Utilidades.pausa();
                }
            }
            else
            {
                System.out.println("\n\tIntroduce un año valido");
                Utilidades.pausa();
            }

        }while(!Validaciones.validarEntero(ano, 0, 2100) || !Validaciones.validarAno(anoStr));

        ano = Integer.parseInt(anoStr);

        return new Libro(codigo, titulo, autor, ano);

    }

    public static void mostrarCatalogoOrdenado()
    {
        int opcion;

        do 
        {
            System.out.println("""
                \n\t\tComo deseas visualizar el catalogo?
                \n\t1. Orden por codigo
                \n\t2. Orden alfabetico de titulo
                \n\t3. Orden alfabetico de autor   
            """);
            opcion = sc.nextInt();

            if(!Validaciones.validarEntero(opcion, 1, 3))
            {
                System.out.println("\n\tIntroduce una opcion valida");
                Utilidades.pausa();
            }
            
        }while(!Validaciones.validarEntero(opcion, 1, 3));

        switch(opcion)
        {
            case 1:
                gestor.mostrarCatalogo(gestor.ordenarCodigo());
                break;

            case 2:
                gestor.mostrarCatalogo(gestor.ordenarTitulo());
                break;

            case 3:
                gestor.mostrarCatalogo(gestor.ordenarAutor());
                break;
        }



    }

}
