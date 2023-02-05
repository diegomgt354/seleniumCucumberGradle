package pages;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
// clase de prueba en java, no tiene que ver con el proyecto
public class programapapa {
    public static void main(String[] args) {
        // listas
        ArrayList<String> figura = new ArrayList<String>();
        figura.add("cuadrado");
        figura.add("triangulo");
        figura.add("rectangulo");
        figura.add("circulo");
        figura.add("pentagono");
        figura.add("hexagono");
        figura.add("rombo");
        figura.add("trapecio");
        figura.add("paralelogramo");
        System.out.println(figura);
        figura.remove(figura.size()-1);
        figura.add(4,"manzana"); //agrega en el index
        figura.set(2, "pera"); // reemplaza en el index
        System.out.println(figura.get(figura.size()-1));
        System.out.println(figura);

        // iteradores
        Iterator<String> iterador = figura.iterator();
        while(iterador.hasNext()){
            String next = iterador.next();
            System.out.println(next);
        }
        // diccionarios
        // craemos una instancia de un hashtable. pasamos 2 tipos, Key:Value
        Hashtable<String,String> diccionario =  new Hashtable<String,String>();

        // metodo put
        diccionario.put("Peru", "peruanos");
        diccionario.put("Argentina", "argentinos");
        diccionario.put("Uruguay", "Charruas");
        diccionario.put("Chile", "Rotos");
        diccionario.put("Mexico", "Weyes");

        // metodo get
        System.out.println("Valor para la key: "+diccionario.get("Peru"));
        // metodo saber si esta vacio
        System.out.println("Está vacío el diccionario?: "+diccionario.isEmpty());
        // remove
        System.out.println(diccionario);
        diccionario.remove("Uruguay");
        System.out.println(diccionario);

        for (Map.Entry<String, String> entry : diccionario.entrySet()) {
            final String valorActual = entry.getValue();
        
            System.out.println(valorActual);
        }

        // menejo de errores
        try {
            int data = 50/0;
        } catch (ArithmeticException e) {
            System.out.println("error aritmetico: "+e.fillInStackTrace());
        }catch (Exception e) {
            System.out.println("I AM SORRY BABY, ERROR!!!");
        }finally{
            System.out.println("Termino el codigo try-catch");
        }
    }
}
