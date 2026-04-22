import java.util.Scanner;

public class Main {
    
    static GestorLibros gestor = new GestorLibros();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args)
    {
        gestor.crearCarpetayArchivo();

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
                    gestor.mostrarLibros();
                    break;
                case 2:
                    Libro libro = leerLibro();
                    if(libro!=null)
                        gestor.agregarLibro(leerLibro());
                    else{
                        System.out.println("\tOperacion cancelda");
                        Utilidades.pausa();
                    }
                    break;
                case 3:
                    gestor.guardarLibros();
                    break;
                case 4:
                    gestor.cargarLibros();
                    break;
            }
        }while(opcion != 5);

    }

    public static Libro leerLibro()
    {
        String autor = "", titulo = "", codigo = "", anoStr = "";
        int ano = 0;

        boolean valido = true;

        do
        {

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
                

            }while(!Validaciones.validarCodigo(codigo));

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

            String respuesta;

            do 
            {
                System.out.println("\nLibro registrado correctamente\nDesea registrar otro libro (si/no)?: ");
                respuesta = sc.nextLine();

                respuesta.toUpperCase();

                if(Validaciones.validarPalabra(respuesta))
                {
                    System.out.println("\nSI PASO EL PRIMER PUTO IF");
                    System.out.println("\nSI ES PALABRA");
                    if(Utilidades.validarSiNo(respuesta))
                    {
                        System.out.println("\nSI ES SI O NO");
                        if(respuesta.equals("NO"))
                        {
                            valido = false;                        
                        }
                        else
                            System.out.println("\nIntroduce si o no");
                    }
                    else
                        System.out.println("\nIntroduce si o no");
                } 
                else
                    System.out.println("\nIntroduce si o no");              
            }while(!Validaciones.validarPalabra(respuesta) || !Utilidades.validarSiNo(respuesta));


        }while(valido);
        
        ano = Integer.parseInt(anoStr);

        return new Libro("L" + codigo, titulo, autor, ano);


    }

}
