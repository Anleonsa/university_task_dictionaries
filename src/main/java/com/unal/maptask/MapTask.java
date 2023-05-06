
package com.unal.maptask;

//Se importan utilidades necesarias
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MapTask {
    
    //Se declara el objeto sc, el cual es instanciado de la clase Scanner
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        
        //Se pide el nombre al autor
        System.out.println("Ingrese su nombre");
        String nombre = sc.nextLine();
        
        //Se pide el identificador del autor
        System.out.println("Ingrese su Id");
        int id = sc.nextInt();
        
        //Al leer el nextInt en la anterior sentencia, queda pendiente un salto de linea
        //que si se omitiese esta linea, se consumiría en la siguiente sentencia en
        //La que se pide el programa.
        //Esta linea rellena ese salto de línea faltante
        sc.nextLine();
        
        //Se pide el programa curricular del cual hace parte el autor
        System.out.println("Ingrese el programa al que pertenece");
        String programa = sc.nextLine();
        
        //Se pide el código del programa
        System.out.println("Ingrese codigo de ese programa");
        int id_programa = sc.nextInt();
        
        //Se pide la edad del autor
        System.out.println("Ingrese su edad");
        int edad = sc.nextInt();
        
        //
        //Creación de los mapas
        //
        Map<String, Integer> Names = new HashMap<>();
        Names.put(nombre,id);
        Names.put("Juan Reyes",1088954327);
        Names.put("Hernan Crespo",27894653);
        Names.put("Alessandro Marques",1356872);
        Names.put("Emanuel Cardoso",1075463465);
        
        Map<Integer,String> Program = new HashMap<>();
        Program.put(id_programa,programa);
        Program.put(1088954327,"Medicina");
        Program.put(27894653,"ingeniria ambiental");
        Program.put(1356872,"Ingenieria Química");
        Program.put(1075463465,"Mecatronica");
        
        Map<Integer,Integer> Edad = new HashMap<>();
        Edad.put(id,edad);
        Edad.put(1088954327,18);
        Edad.put(27894653,28);
        Edad.put(1356872,42);
        Edad.put(1075463465,41);
        
        Map<Integer,Boolean> EstadoCivil = new HashMap<>();   
        EstadoCivil.put(id,null);
        EstadoCivil.put(1088954327,null);
        EstadoCivil.put(27894653,null);
        EstadoCivil.put(1356872,null);
        EstadoCivil.put(1075463465,null);
        
        //Se rellenan los valores del estado civil según la edad
        EstadoCivil.forEach((K,V) -> {
            Boolean estaCasado = (Edad.get(K) > 40);
            EstadoCivil.replace(K,estaCasado);
        });
        
        //
        //Se muestran los primeros 4 entradas de cada HashMap
        //
        System.out.println("\n- - - Nombres:");
        int count = 0;
        for(Map.Entry<String,Integer> entry : Names.entrySet()){
            if(count++ == 4) break;
            System.out.println("Nombre: " + entry.getKey() + " Id: " + entry.getValue());
        }
       
        System.out.println("\n- - - Programas:");
        count = 0;
        for(Map.Entry<Integer,String> entry : Program.entrySet()){
            if(count++ == 4) break;
            System.out.println("Id: " + entry.getKey() + "Programa: " + entry.getValue());
        }

        System.out.println("\n- - - Edades:");
        count = 0;
        for(Map.Entry<Integer,Integer> entry : Edad.entrySet()){
            if(count++ == 4) break;
            System.out.println("Id: " + entry.getKey() + "Edad: " + entry.getValue());
        }
        
        System.out.println("\n- - - Estado civil:");
        count = 0;
        for(Map.Entry<Integer,Boolean> entry : EstadoCivil.entrySet()){
            if(count++ == 4) break;
            System.out.println("Id: " + entry.getKey() + "Estado Civil: " + entry.getValue());
        }
       
        //Se remplaza el ID del segundo elemento del HashMap Names
        Names.replace("Hernan Crespo",666666);
       
        //
       //Se imprimen todos los HashMap con el forEach
        System.out.println("\n- - - Nombres (Lista completa)");
        Names.forEach((K,V) -> {System.out.println("Id: " + K + " Nombre: " + V);});
        
        System.out.println("\n- - - Programas (Lista completa)");
        Program.forEach((K,V) -> {System.out.println("Id: " + K + " Programa: " + V);});
        
        System.out.println("\n- - - Edades (Lista completa)");
        Edad.forEach((K,V) -> {System.out.println("Id: " + K + " Edad: " + V);});
        
        System.out.println("\n- - - Estado civil (Lista completa)");
        EstadoCivil.forEach((K,V) -> {System.out.println("Id: " + K + "Estado Civil: " + V);});
       
       //Se muestran los datos del autor
       int identificadorAutor = Names.get(nombre);
        System.out.println(
            "\n- - - Datos del autor:" +
            "\nNombre : " + nombre +
            "\nIdentificador  : " + identificadorAutor +
            "\nEdad : " + Edad.get(identificadorAutor) +
            "\nEstado civil : " +EstadoCivil.get(identificadorAutor)  +
            "\nPrograma : " + Program.getOrDefault(identificadorAutor, "Diseño gráfico")
        );
    }
}
