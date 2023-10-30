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
            entrada = new FileInputStream("alumnosNotas.txt");
            lectura=new BufferedReader(new InputStreamReader(entrada));
            nuevoArchivo=new FileWriter("media.txt", true);
            escritura=new BufferedWriter(nuevoArchivo);
            String linea;
            while ((linea = lectura.readLine()) != null) {
                String[] partes = linea.split(":");
                String nombre = partes[0];
                int nota1 = Integer.parseInt(partes[1]);
                int nota2 = Integer.parseInt(partes[2]);
                int nota3 = Integer.parseInt(partes[3]);

                int promedio = (nota1 + nota2 + nota3) / 3;
                
                
                String mensaje="Nombre: " + nombre + ", Promedio: " + promedio+"\n";
                escritura.write(mensaje);
                //System.out.println("Nombre: " + nombre + ", Promedio: " + promedio);
            }
        }catch(IOException e){
            System.out.println(e);
        }
        lectura.close();
        escritura.close();
    }
    
}
