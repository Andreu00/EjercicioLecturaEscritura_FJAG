package javaapplication62;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class JavaApplication62 {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        FileInputStream entrada=null;
        BufferedReader lectura=null;
        BufferedWriter escritura=null;
        FileWriter nuevoArchivo=null;
        try{
            //Aqui declararemos el nombre del fichero txt del que leeremos su contenido
            entrada = new FileInputStream("alumnosNotas.txt");
            //En esta linea leeremos el fichero txt
            lectura=new BufferedReader(new InputStreamReader(entrada));
            //Declaramos el archivo txt en el que almacenaremos el contenido de las medias.
            //True nos ayudará para no sobreescribir el contenido de este cada vez que ejecutemos
            nuevoArchivo=new FileWriter("media.txt", true);
            //Declaramos el BufferedWiter para indicar donde almacenaremos el contenido utilizando la variable creada para ello
            escritura=new BufferedWriter(nuevoArchivo);
            String linea;
            //Creamos un String linea para utilizarlo en este bucle para comprobar cual será el final del fichero txt
            while ((linea = lectura.readLine()) != null) {
                String[] partes = linea.split(":"); //El split lo que hace es, con el valor que le indicamos, marcar la separacion de la cual cogerá los elementos
                String nombre = partes[0];
                //Pasamos las notas a int para trabajar con ellas
                int nota1 = Integer.parseInt(partes[1]);
                int nota2 = Integer.parseInt(partes[2]);
                int nota3 = Integer.parseInt(partes[3]);

                int promedio = (nota1 + nota2 + nota3) / 3;
                
                
                String mensaje="Nombre: " + nombre + ", Promedio: " + promedio+"\n";
                //Escribimos en el fichero en el que vamos a almacenar la nota media de cada uno
                escritura.write(mensaje);
            }
        }catch(IOException e){
            System.out.println(e);
        }
        lectura.close();
        escritura.close();
    }
    
}
