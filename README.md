# Book Manager (Java CLI)

![Java](https://img.shields.io/badge/Java-17+-blue)
![Status](https://img.shields.io/badge/Status-Completed-green)
![License](https://img.shields.io/badge/License-MIT-lightgrey)

A console-based Java application for managing a book catalog. It allows users to register, store, view, and sort books using local file persistence.

---

## Description

This project implements a simple book management system in the terminal, focused on applying object-oriented programming principles, file handling, and data validation.

The system automatically loads stored data on startup and allows user interaction through a menu-driven interface.

---

## Features

- Book registration with:
  - Unique code (`L###`)
  - Title
  - Author
  - Publication year
- Text file persistence
- Automatic data loading on startup
- Input validation
- Sorting by:
  - Code
  - Title
  - Author

---

## Project Structure

├── Main.java
├── GestorLibros.java
├── Libro.java
├── Validaciones.java
├── Utilidades.java


---

## Installation & Usag
```bash
javac *.java
```

## Data persistence

Books are stored in:
```bash
biblioteca/libros.txt
```

Record Format:
```bash
L001,El Quijote,Cervantes,1605
```

## Concepts applied
Concepts Applied
Object-Oriented Programming (OOP)
File handling (reading and writing)
Use of collections (ArrayList)
Sorting with Comparator and lambda expressions
Input validation using regular expressions
Separation of responsibilities







