package model;

import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.channels.ShutdownChannelGroupException;
import java.util.ArrayList;

import Objects.*;

import javax.imageio.ImageIO;


public class GestionDatos {
		
	public GestionDatos() {
		
	}

	//TODO: Implementa una funcion para abrir ficheros
	public BufferedReader abrirFichero(String fichero) {
		try {
			
			
			FileReader fileR = new FileReader(fichero);
			
			
			BufferedReader fileBR = new BufferedReader(fileR);
			
			
			return fileBR;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error al abrir el archivo " + fichero);
			return null;
		}
	}
	
	//Abrir ficheros binarios
	public void abrirFicheroBin (String fichero){
		
	}
	
	//TODO: Implementa una funcion para cerrar ficheros
	public void cerrarFichero(BufferedReader fichero) {
		try {
			fichero.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("No se ha podido cerrar el fichero");
		}
	}
	
	public boolean compararContenido (String fichero1, String fichero2) throws IOException{
		//TODO: Implementa la funcion
		BufferedReader archivo1 = abrirFichero(fichero1);
		BufferedReader archivo2 = abrirFichero(fichero2);
		
		String cadena1, cadena2;
		
		while ((cadena1 = archivo1.readLine()) != null && (cadena2 = archivo2.readLine()) != null){
			if (!cadena1.equals(cadena2)){
				cerrarFichero(archivo1);
				cerrarFichero(archivo2);
				return false;
			}
		}
		return true;
	}
	
	public int buscarPalabra (String fichero1, String palabra, boolean primera_aparicion) throws IOException{
		//TODO: Implementa la funcion
		
		BufferedReader archivo1 = abrirFichero(fichero1);
		String cadena1;
		
		if (primera_aparicion){
			//Primera aparicion
			int i=0;
			while ((cadena1 = archivo1.readLine()) != null){
				i++;
				if (cadena1.equals(palabra)){
					cerrarFichero(archivo1);
					return i;
				}
			}
		} else {
			//Ultima palabra encontrada
			int i=0, line = -1;
			while ((cadena1 = archivo1.readLine()) != null){
				i++;
				if (cadena1.equals(palabra)){
					line = i;
				}
			}
			
			//Devuelve ultima line encontrada o ninguna
			return line;
		}
		
		return -1;
	}	

	
	//Funcion copiar ficheros
	public int copiarFicehro(String fichero1, String fichero2) throws IOException{
		
		if (fichero2 == "") {
			System.out.println("Esta vacio");
			throw new IOException("El destino esta vacio");
		} else {
			System.out.println("Copiar a " + fichero2);
		}
		
        File origen = new File(fichero1);
        File destino = new File(fichero2);
        
        if (destino.exists()){
        		//TODO: Error no puedo crear
        		throw new IOException("El archivo destino ya existe");
        }
        destino.createNewFile();
        
        DataInputStream din = new DataInputStream(new FileInputStream(origen));
        DataOutputStream dout = new DataOutputStream(new FileOutputStream(destino));

        int c = -1; 
        int bites = 0;
        while((c =  din.read()) !=-1)
        {
        	bites++;
        	dout.write((byte)c);
        }
        
		return bites;
	}
	
	//Funcion Guardar Libros
	public int guardar_libro(Libro libro) throws IOException {
		
		//Preparamos Archivo
		File nuevoFile = new File("LibroJava_" + libro.getId() + ".lbj");
		
		//Checkeamos si existe
		if (nuevoFile.exists()) {
			//Error porque ya existe uno
			return -2;
		} else {
			//Creamos archivo
			if (!nuevoFile.createNewFile()) {
				//Fichero fallido al crear
				return -1;
			}
		}
		
		ObjectOutputStream objFile = new ObjectOutputStream(new FileOutputStream(nuevoFile));
		
		try {
			objFile.writeObject(libro);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Ha petado al escribir el libro loco!");
			return -1;
		}
		
		//Ceramos archivo
		objFile.close();
		
		//Se ha creado con éxito
		return 1;
	}
	
	//Recuperar libro
	public Libro recuperar_libro(String identificador) throws FileNotFoundException, IOException{
		//Buscamos si existe el fichero
		File fileBook = new File("LibroJava_" + identificador + ".lbj");
		if (!fileBook.exists()) {
			//No existe, es imposible
			return null;
		}
		
		//Leemos archivo
		ObjectInputStream lector = new ObjectInputStream(new FileInputStream(fileBook));
		
		//Lemos archivo y lo asignamos al libro recuperado
		Libro lbRecu;
		try {
			lbRecu = (Libro) lector.readObject();
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		
		return lbRecu;
	}
	
	public ArrayList<Libro> recuperar_todos() throws FileNotFoundException, IOException{
		ArrayList <Libro> biblioteca = new ArrayList <Libro>();
		
		System.out.println("Voy a empezar");

		//Cotilleamos el directorio actual
		File dir = new File(".");
		
		//Añadimos los archivos al String para buscar
		String[] archivos = dir.list();
		
		//Analizamos el nombre de cada archivo
		for (int i=0; i<archivos.length; i++) {
			if (archivos[i].startsWith("LibroJava_")) {
				//Archivo valido
		        //Borramos los primeros cinco caracteres.
		        String identidad = archivos[i].substring(10, archivos[i].length()-4);
		        
		        System.out.println(identidad);
		        
		        biblioteca.add(recuperar_libro(identidad));
			}
		}
		
		return biblioteca;
	}
	
	// #EJ1 Metodo encargado de eliminar el anterior libro
	public int eliminarLibro(Libro lb) {
		//Creamos fichero
		File origen = new File("LibroJava_" + lb.getId() + ".lbj");
		
		//Comprobamos que existe
		if (!origen.exists()) {
			//No existe, salta un error!
			return -3;
		}
		
		//Procedemos a eliminar el fichero
		if (!origen.delete()) {
			//No se ha podido eliminar el anterior fichero
			return -2;
		}
		
		//Fichero del libro eliminado correctamente
		return 1;
	}
	
	// #EJ2 Metodo para buscar palabras con una x longitud
	public int leerLongitudes (String file, int longitud) throws IOException{
		
		//Abrimos el nuevo archivo
		BufferedReader archivo = abrirFichero(file);

		//Creamos variables para contener el contador y la palabra temp
		int contador = 0;
		String palabra;
		
		//Leemos cada linea
		while ((palabra = archivo.readLine()) != null){
			
			//Si la palabra tiene menos de la longitud introducida por el usuario, cuentala!
			if (palabra.length() < longitud) {
				//Palabra válida
				contador++;
			}
		}
		
		//Cerramos archivo
		archivo.close();
		
		return contador;
	}

	// EJERCICIO 1 RECU
	public String palabraLarga (String file) throws IOException{
		
		
		//Abrimos el nuevo archivo
		try {
			BufferedReader archivo = abrirFichero(file);

		

		
		//Creamos variables para contener el contador y la palabra temp
		int contador = 0;
		String palabra;
		String palabra2 = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		String palabraLarga = "";
		
		//Leemos cada linea
		while ((palabra = archivo.readLine()) != null){
			
			
			
			//Si la palabra tiene menos de la longitud introducida por el usuario, cuentala!
			if (palabra.length() > palabra2.length()) {
				//Palabra válida
				palabraLarga = palabra;
			}
			
			palabra2 = palabra;
		}
		
		//Cerramos archivo
		archivo.close();
		
		return palabraLarga;
			} catch (Exception e) {
			
		}
		return null;
	}
}