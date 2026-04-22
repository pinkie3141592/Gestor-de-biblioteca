public class Validaciones {
    
    public static boolean validarEntero(int num, int min, int max)
    {
        if(num < min || num > max)
            return false;
        return true;
    }

    public static boolean validarTitulo(String titulo) 
    {
        return titulo.matches("[a-zA-Z0-9 ]+");
    }

    public static boolean validarCodigo(String codigo) 
    {
        return codigo.matches("L\\d{3}");
    }

    public static boolean validarAutor(String autor) 
    {
        return autor.matches("[a-zA-Z ]+");
    }

    public static boolean validarAno(String ano) 
    {
        return ano.matches("\\d{4}");
    }

    public static boolean validarPalabra(String palabra)
    {
        return palabra.matches("[a-zA-Z]+");
    }


}
