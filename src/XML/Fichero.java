
package XML;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Fichero {
    
    //atributo para guardar el nombre del fichero
    private String nombre;
    
    public Fichero(String nombre){
        this.nombre=nombre;
    }
    
    //Graba cualquier objeto JavaBean que le pasen gracias a poner Object
    public void grabar(Object o){
        try{
        XMLEncoder codificador= new XMLEncoder(new FileOutputStream(new File(nombre)));
        //Escribimos el objeto en el fichero
        codificador.writeObject(o);
        //Cerramos el canal
        codificador.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Error no se ha podido grabar: " + ex.getMessage());
        }
        
    }
    
    //Lee un objeto JavaBean de un fichero XML y lo devuelve
    //Devuelve NULL si no existe el fichero
    public Object leer(){
        try {
            XMLDecoder decodificador = new XMLDecoder(new FileInputStream(new File(nombre)));
            return decodificador.readObject();
        } catch (FileNotFoundException ex) {
            System.out.println("Todavía no existe el fichero");
            return null;
        }
    }
}
