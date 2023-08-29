/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.basedatos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import mundo.Alumno;

/**
 *
 * @author JUAN DAVID
 */
public class BaseDatos {
//hola hola asdasdasda
    public static void main(String[] args) throws FileNotFoundException, IOException {
        //definiendo variables lector y activo
        Scanner lector = new Scanner(System.in);
        boolean activo = true;
        
        //creando el array en el que se va a guardar cada cosa
        ArrayList<Alumno> listadoAlumnos = new ArrayList<Alumno>();
        reporteAlumC(listadoAlumnos);
        //abriendo un do-while para que el menu se repita hasta que la bandera sea 5
        do {
            System.out.println("1. Insertar Alumno:");
            System.out.println("2. Eliminar Alumno:");
            System.out.println("3. Modificar Alumno:");
            System.out.println("4. Consultar Alumno:");
            System.out.println("5. imprimir Semestre:");
            System.out.println("6. reporte alumnos:");
            System.out.println("7. Terminar Programa:");
            System.out.print("elige una opcion: ");
            
            int opcion = lector.nextInt();
           
            //menu de las opciones
            switch (opcion) {
                case 1:
                    System.out.println("============================");
                    System.out.println("OPCION 1: INSERTAR ALUMNO");
                    System.out.println("============================");
                    //se hace el llamado a la funcion para insertar un alumno nuevo
                    insertarAlumno(listadoAlumnos, lector);
                   
                
                    break;
                case 2:
                    System.out.println("============================");
                    System.out.println("OPCION 2: ELIMINAR ALUMNO");
                    System.out.println("============================");
                    //se hace el llamado a la funcion para eliminar un alumno
                    eliminarAlumno(listadoAlumnos, lector);
                   
             
                    break;
                case 3:
                    System.out.println("============================");
                    System.out.println("OPCION 3: modificar un alumno");
                    System.out.println("============================");
                    //se hace el llamado a la funcion para modificar un alumno
                    modificarAlumno(listadoAlumnos,lector);
                   
                  
                    break;
                case 4:
                    System.out.println("============================");
                    System.out.println("OPCION 4: consultar un alumno");
                    System.out.println("============================");
                    //se hace el llamado a la funcion para hacer la consulta de un alumno
                    mostrarAlumnos(listadoAlumnos);
                    
                   
                    break;
                case 5:
                    System.out.println("============================");
                    System.out.println("OPCION 5: Imprimir Semestre");
                    System.out.println("============================");
                    //se llama a la funcion imprimirA
                    imprimirSemestre(listadoAlumnos);
                    
                    
                    break;
                case 6: 
                    System.out.println("============================");
                    System.out.println("OPCION 6: reporte alumno");
                    System.out.println("============================");                   
                    //se llama al metodo 
                    reporteAlum(listadoAlumnos);
                   
                  
                    break;
                case 7: 
                     // se cierra el programa
                    System.out.println("============================");
                    System.out.println("SALIR DEL PROGRAMA");
                    System.out.println("============================");
                    activo = false;
                    break;
                default:
                    System.out.println("ups!! no has seleccionado ninguna opcion, intenta de nuevo");
                    break;
            }
            //aqui cerramos el while
        } while (activo);
         //y aqui cerramos el lector
        lector.close();
    }
    //funcion para insertar un nuevo alumno

    public static Alumno insertarAlumno(ArrayList<Alumno> listadoAlumnos, Scanner lector) {
    Alumno nAlumno = new Alumno();
    //listadoAlumnos.add(nAlumno);
    
    System.out.print("Ingrese un nombre: ");
    String nombre = lector.next();
    while (nombre.isEmpty()) {
        System.out.println("El nombre no puede estar en blanco. Por favor, ingrese un nombre.");
        nombre = lector.next();
    }
    nAlumno.setNombre(nombre);
        

    System.out.print("Ingrese un apellido: ");
    String apellido = lector.next();
    while (apellido.isEmpty()) {
        System.out.println("El apellido no puede estar en blanco. Por favor, ingrese un apellido.");
        apellido = lector.next();
    }
    nAlumno.setApellido(apellido);


    System.out.print("Ingrese una cédula: ");
    String cedula = lector.next();
    while (cedula.isEmpty()) {
        System.out.println("La cédula no puede estar en blanco. Por favor, ingrese una cédula.");
        cedula = lector.next();
    }
    nAlumno.setCedula(cedula);

    System.out.print("Ingrese un semestre: ");
    String semestre = lector.next();
    while (semestre.isEmpty()) {
        System.out.println("El semestre no puede estar en blanco. Por favor, ingrese un semestre.");
        semestre = lector.next();
    }
    nAlumno.setSemestre(semestre);

    System.out.print("Ingrese un correo: ");
    String correo = lector.next();
    while (correo.isEmpty()) {
        System.out.println("El correo no puede estar en blanco. Por favor, ingrese un correo.");
        correo = lector.next();
    }
    nAlumno.setCorreo(correo);

    System.out.print("Ingrese un celular: ");
    String celular = lector.next();
    while (celular.isEmpty()) {
        System.out.println("El celular no puede estar en blanco. Por favor, ingrese un celular.");
        celular = lector.next();
    }
    nAlumno.setCelular(celular);
 
    
    
    listadoAlumnos.add(new Alumno(nombre, apellido, cedula,semestre,celular,correo));
    System.out.println("¡Felicidades! Te has registrado correctamente.");

    return nAlumno;
}
    
    public static void eliminarAlumno(ArrayList<Alumno> listadoAlumnos, Scanner lector) {
           System.out.println("ingrese la cedula");
           String eliminar=lector.next();
           lector.nextInt();
           for(Alumno nAlumo: listadoAlumnos){
               if(eliminar.equals(nAlumo.getCedula())){
                   listadoAlumnos.remove(nAlumo);
                   System.out.println("se ha eliminado exitosamente");
                   break;
               }else{
                   System.out.println("no se encontro");
               }
           }
           

}
    
    public static void modificarAlumno(ArrayList<Alumno> listadoAlumnos, Scanner lector) {
    System.out.print("Ingrese la cédula del alumno a modificar: ");
    String cedulaModificar = lector.next();

    boolean encontrado = false;
    for (Alumno alumno : listadoAlumnos) {
        if (alumno.getCedula().equals(cedulaModificar)) {
            System.out.println("modificar datos: " + alumno.getNombre() + " " + alumno.getApellido());

            System.out.print("ingrese un nuevo nombre ");
            String nNombre = lector.next();
            if (!nNombre.isEmpty()) {
                alumno.setNombre(nNombre);
            }

            System.out.print("ingrese un nuevo apellido: ");
            String nApellido = lector.next();
            if (!nApellido.isEmpty()) {
                alumno.setApellido(nApellido);
            }

            System.out.print("Ingrese un nuevo semestre): ");
            String nSemestre = lector.next();
            if (!nSemestre.isEmpty()) {
                alumno.setSemestre(nSemestre);
            }

            System.out.print("Ingrese un nuevo correo: ");
            String nCorreo = lector.next();
            if (!nCorreo.isEmpty()) {
                alumno.setCorreo(nCorreo);
            }

            System.out.print("Ingrese un nuevo celular: ");
            String nCelular = lector.next();
            if (!nCelular.isEmpty()) {
                alumno.setCelular(nCelular);
            }

            System.out.println("se modificaron los datos correctamente.");
            encontrado = true;
            break;
        }
    }

    if (!encontrado) {
        System.out.println("hubo un error al buscar este alumno, ingrese la cedula nuevamente.");
    }
}
    
    public static void mostrarAlumnos(ArrayList<Alumno> listadoAlumnos) {
    if (listadoAlumnos.isEmpty()) {
        System.out.println("no hemos encontrado ninguna lista.");
    } else {
        System.out.println("Listado de Alumnos:");
        for (Alumno alumno : listadoAlumnos) {
            System.out.println("Nombre: " + alumno.getNombre());
            System.out.println("Apellido: " + alumno.getApellido());
            System.out.println("Cédula: " + alumno.getCedula());
            System.out.println("Semestre: " + alumno.getSemestre());
            System.out.println("Correo: " + alumno.getCorreo());
            System.out.println("Celular: " + alumno.getCelular());
            System.out.println("===================================");
        }
    }
}

    public static void imprimirSemestre(ArrayList<Alumno> listadoAlumnos) throws FileNotFoundException {
    try {
        File archivo = new File("./data.txt");
        PrintWriter pluma = new PrintWriter(archivo);
        
        System.out.println("¿Qué semestre desea consultar?");
        String semestre = new Scanner(System.in).next();

        pluma.println("alumnos en el semestre " + semestre);
        pluma.println("==================");

        for (Alumno alumno : listadoAlumnos) {
            if (alumno.getSemestre().equals(semestre)) {
                pluma.println("Cedula: " + alumno.getCedula() +
                        " Nombre: " + alumno.getNombre() +
                        " Apellido: " + alumno.getApellido() +
                        " Celular: " + alumno.getCelular() +
                        " Correo: " + alumno.getCorreo() +
                        " Semestre: " + alumno.getSemestre());
            }
        }
        pluma.close();
        System.out.println("=====================================");
        System.out.println("Has generado el reporte exitosamente");
        System.out.println("=====================================");
    } catch (Exception e) {
        e.printStackTrace();
        System.out.println("Ups!! Se generó un error");
    }
}
    public static void reporteAlum (ArrayList<Alumno>listadoAlumnos) throws FileNotFoundException{
        // Crear un objeto File que apunte al archivo "reporteAlumnos.txt"
        File archivo = new File("reporteAlumnos.txt");
        try (PrintWriter pw = new PrintWriter(archivo)) {
            // Iterar a través de cada objeto Alumno en el listadoAlumnos
            for (Alumno alumno : listadoAlumnos) {
                // Construir una línea de datos concatenando las propiedades del Alumno separadas por guiones
                pw.println(alumno.getNombre()+ "-" +
                        alumno.getApellido()+ "-" +
                        alumno.getCedula()+ "-" +
                        alumno.getSemestre()+ "-" +
                        alumno.getCorreo() + "-" +
                        alumno.getCelular());
                
            }
            //cerramos el printwriter
            pw.close();
        }
    }

    public static void reporteAlumC(ArrayList<Alumno> listadoAlumnos) {
    // Crear un objeto File que apunte al archivo "reporteAlumnos.txt"
    File archivo = new File("reporteAlumnos.txt");
    
    try (BufferedReader leer = new BufferedReader(new FileReader(archivo))) {
        String cas; // Variable para almacenar cada línea leída del archivo
        
        // Leer cada línea del archivo hasta que se alcance el final
        while ((cas = leer.readLine()) != null) {
            // Dividir la línea en partes usando el guión como separador
            String[] pos = cas.split("-");
            
            // Asegurarse de que haya exactamente 6 partes en los datos
            if (pos.length == 6) {
                // Obtener cada parte de los datos y eliminar espacios en blanco al inicio y al final
                String nombre = pos[0].trim();
                String apellido = pos[1].trim();
                String cedula = pos[2].trim();
                String semestre = pos[3].trim();
                String correo = pos[4].trim();
                String celular = pos[5].trim();
                
                // Crear un objeto Alumno con los datos obtenidos y agregarlo a la lista
                Alumno nAlum = new Alumno(nombre, apellido, cedula, semestre, correo, celular);
                listadoAlumnos.add(nAlum);
            } else {
                // En caso de que la línea no tenga exactamente 6 partes, hacer algo aquí si es necesario
            }
        }

        // Mostrar un mensaje de éxito después de procesar el archivo
        System.out.println("=====================================");
        System.out.println("Has generado el reporte exitosamente");
        System.out.println("=====================================");
    } catch (IOException e) {
        // Manejar cualquier error que pueda ocurrir durante la lectura del archivo
        System.out.println("ups!! ocurrio un error con el archivo");
    }
}
}