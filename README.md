Descripción

Aplicación de consola desarrollada en Java para la gestión de un catálogo de libros. Permite registrar, almacenar, visualizar y ordenar libros utilizando persistencia en archivos locales.

Características
Registro de libros con los siguientes atributos:
Código único (formato: L###)
Título
Autor
Año de publicación
Almacenamiento en archivo de texto
Carga automática de datos al iniciar el programa
Validación de entradas del usuario
Ordenamiento de libros por:
Código
Título
Autor
Estructura del proyecto
.
├── Main.java
├── GestorLibros.java
├── Libro.java
├── Validaciones.java
├── Utilidades.java

Compilación y ejecución

Compilar:

javac *.java


Ejecutar:

java Main

Persistencia de datos

Los datos se almacenan en:

biblioteca/libros.txt


Formato de cada registro:

L001,El Quijote,Cervantes,1605

Conceptos aplicados
Programación Orientada a Objetos
Manejo de archivos (lectura y escritura)
Uso de colecciones dinámicas (ArrayList)
Ordenamiento con Comparator y expresiones lambda
Validación de datos mediante expresiones regulares
Separación de responsabilidades por clases
Limitaciones
No incluye edición ni eliminación de registros
Depende de archivos planos (no base de datos)
Persistencia manual si el programa lo requiere
