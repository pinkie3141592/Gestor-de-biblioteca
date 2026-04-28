# Gestor de Libros (Java CLI)

![Java](https://img.shields.io/badge/Java-17+-blue)
![Status](https://img.shields.io/badge/Status-Completed-green)
![License](https://img.shields.io/badge/License-MIT-lightgrey)

Aplicación de consola desarrollada en Java para la gestión de un catálogo de libros. Permite registrar, almacenar, visualizar y ordenar información utilizando persistencia en archivos locales.

---

## Descripción

Este proyecto implementa un sistema sencillo de gestión de libros desde la terminal, enfocado en aplicar principios de programación orientada a objetos, manejo de archivos y validación de datos.

El sistema carga automáticamente la información almacenada y permite al usuario interactuar mediante un menú.

---

## Características

- Registro de libros con:
  - Código único (`L###`)
  - Título
  - Autor
  - Año de publicación
- Persistencia en archivo de texto
- Carga automática de datos
- Validación de entradas
- Ordenamiento por:
  - Código
  - Título
  - Autor

---

## Estructura del Proyecto

.
├── Main.java
├── GestorLibros.java
├── Libro.java
├── Validaciones.java
├── Utilidades.java


---

## Instalación y Uso

### Compilar
```bash
javac *.java

Ejecutar

java Main

Persistencia de Datos

Los libros se almacenan en:

biblioteca/libros.txt

Formato de los registros:

L001,El Quijote,Cervantes,1605

Conceptos Aplicados

    Programación Orientada a Objetos (POO)

    Manejo de archivos (lectura y escritura)

    Uso de colecciones (ArrayList)

    Ordenamiento con Comparator y expresiones lambda

    Validación con expresiones regulares

    Separación de responsabilidades
