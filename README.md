<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Gestor de Libros (Java CLI)</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 40px;
            background-color: #f5f5f5;
            color: #333;
        }
        .container {
            background-color: #ffffff;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
        h1, h2 {
            border-bottom: 2px solid #ddd;
            padding-bottom: 5px;
        }
        pre {
            background-color: #eee;
            padding: 10px;
            border-radius: 5px;
            overflow-x: auto;
        }
        code {
            background-color: #eee;
            padding: 2px 5px;
            border-radius: 3px;
        }
        .ascii {
            font-family: monospace;
            white-space: pre;
            text-align: center;
            margin-bottom: 20px;
        }
    </style>
</head>
<body>
    <div class="container">

        <div class="ascii">
========================================
        GESTOR DE LIBROS (JAVA CLI)
========================================
        </div>

        <h2>Descripción</h2>
        <p>
            Aplicación de consola desarrollada en Java para la gestión de un catálogo de libros.
            Permite registrar, almacenar, visualizar y ordenar libros utilizando persistencia en archivos locales.
        </p>

        <h2>Características</h2>
        <ul>
            <li>Registro de libros con:
                <ul>
                    <li>Código único (L###)</li>
                    <li>Título</li>
                    <li>Autor</li>
                    <li>Año de publicación</li>
                </ul>
            </li>
            <li>Almacenamiento en archivo de texto</li>
            <li>Carga automática de datos al iniciar el programa</li>
            <li>Validación de entradas</li>
            <li>Ordenamiento por código, título y autor</li>
        </ul>

        <h2>Estructura del proyecto</h2>
        <pre>
.
├── Main.java
├── GestorLibros.java
├── Libro.java
├── Validaciones.java
├── Utilidades.java
        </pre>

        <h2>Compilación y ejecución</h2>
        <p>Compilar:</p>
        <pre><code>javac *.java</code></pre>

        <p>Ejecutar:</p>
        <pre><code>java Main</code></pre>

        <h2>Persistencia de datos</h2>
        <p>Los datos se almacenan en:</p>
        <pre><code>biblioteca/libros.txt</code></pre>

        <p>Formato:</p>
        <pre><code>L001,El Quijote,Cervantes,1605</code></pre>

        <h2>Conceptos aplicados</h2>
        <ul>
            <li>Programación Orientada a Objetos</li>
            <li>Manejo de archivos</li>
            <li>ArrayList</li>
            <li>Comparator y expresiones lambda</li>
            <li>Expresiones regulares</li>
            <li>Separación de responsabilidades</li>
        </ul>

        <h2>Limitaciones</h2>
        <ul>
            <li>No incluye edición ni eliminación</li>
            <li>Uso de archivos planos en lugar de base de datos</li>
        </ul>

        <h2>Posibles mejoras</h2>
        <ul>
            <li>Búsqueda de libros</li>
            <li>Edición y eliminación</li>
            <li>Base de datos</li>
            <li>Interfaz gráfica</li>
            <li>Manejo de errores más robusto</li>
        </ul>

    </div>
</body>
</html>
