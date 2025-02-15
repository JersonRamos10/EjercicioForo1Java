
package registroestudiantesudbvirtual;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * @author Jerson_ramos
 * @author Rodrigo_orellana
 * @author Giovanni_Quijano
 * @author Maria_palacios
 * @author Sandra_palacios
 * 
 */
//clase estudiantes
class Estudiantes{
   
    //atributos de la clase 
    String nombre;
    String carnet;
    
    //metodo constructor de la clase estudiantes
    public Estudiantes(String nombre, String carnet){
        this.nombre = nombre;
        this.carnet = carnet;
    }
}

public class RegistroEstudiantesUdbVirtual {
    //creamos la lista
    static List<Estudiantes> estudiantesLista = new ArrayList<>();
    //clase scanner para la entrada de datos del usuario
    static Scanner datosEntrada = new Scanner(System.in);
    
    public static void main(String[] args) {
     
        //declaracion de variables
        int opcion = 0; 
            System.out.println("\t Bienvenido al sistema de registro de alumno");
            System.out.println("\t\t De la  UDB virtual Materia POO");
        do{
            
            System.out.println("\nMenu");
            System.out.println("1. Ingresar alumno");
            System.out.println("2. Buscar alumno");
            System.out.println("3. Eliminar alumno");
            System.out.println("4. Mostrar todos los alumnos");
            System.out.println("5. Salir");
            System.out.println("Seleccione una opcion: ");
            opcion = datosEntrada.nextInt();
             datosEntrada.nextLine(); // Consumir el salto de linea
        
            switch(opcion){
                case 1 :
                    ingresarEstudiante();
                    break;
            case 2 :
                busquedaEstudiante();
                    break;
            case 3 :
                eliminarEstudiante();
                   break;
            case 4 :
                mostrarTodosEstudiantes();
                    break;
            case 5 :
                           System.out.println("Saliendo del sistema...");
                    break;
            default : 
                System.out.println("Opcion invalida.");
                break;
                
            }
        }while(opcion != 5);
        
        datosEntrada.close();
    }
    
    
   //metodo para registrar un alumno en udb virtual
     static void ingresarEstudiante(){
        System.out.println("Ingrese el nombre completo del alumno: ");
        String nombre = datosEntrada.nextLine();
        System.out.println("Ingrese el carnet del Alumno: ");
        String carnet = datosEntrada.nextLine();

        //agregamos el alumno registrado en la lista con nombreLista.dd()
        estudiantesLista.add(new Estudiantes (nombre,carnet));
        System.out.println("Alumno ingresado exitosamente ");
        
    }
     
     //metodo para buscar un alumno en udb virtual mediante carnet
     static void busquedaEstudiante(){
         System.out.println("Ingrese el carnet del alumno a buscar: ");
         //variable que almacena el carnet a buscar
         String carnetBusqueda = datosEntrada.nextLine();
         //for each para recorrer la lista
         for(Estudiantes estudiante : estudiantesLista ){
             //comproba cartnet
             if(estudiante.carnet.equals(carnetBusqueda)){
                 System.out.println("Alumno encontrado: " + estudiante.nombre + ", con carnet: " + estudiante.carnet);
                 return; 
             }
         
         }
         System.out.println("Error, Alumno no encontrado, no se puede mostrar.");
         
     }
     
     //metodo para eliminar alumno 
    static void eliminarEstudiante(){
        System.out.println("Ingrese el carnet del alumno a eliminar: ");
        String carnetBusqueda = datosEntrada.nextLine();
        
        for (Estudiantes estudiantes : estudiantesLista){
            //comparamos el valor con el metodo equals();
            if(estudiantes.carnet.equals(carnetBusqueda)){
            estudiantesLista.remove(estudiantes);
                System.out.println("Alumno eliminado exitosamente.");
                return;
            }
        }
        System.out.println("Alumno no encontrado el carnet es Incorrecto, no se puede Eliminar.");
        
    }
    
    //metodo para mostrar todos los alumnos
    static void mostrarTodosEstudiantes(){
        if (estudiantesLista.isEmpty()){
            System.out.println("No hay alumnos registrados.");
            
        }
        else {
            System.out.println("Lista de alumnos registrados en UDB virtual");
            //recorremos la lista con for each
            for (Estudiantes estudiantes : estudiantesLista){
                System.out.println("Carnet" + estudiantes.carnet + ", Nombre: " + estudiantes.nombre);
            
            }               
        }
    
    }

}
