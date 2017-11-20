package Objects;

import java.io.Serializable;

public class Libro implements Serializable {
	
	//Identificador, titulo, autor, anyo  de publicacion , editor, numero de paginas.
	
	String id;
	String titulo;
	String autor;
	String anoPubli;
	String editor;
	String numPag;
	
	public Libro(String id, String titulo, String autor, String anoPubli, String editor, String numPag) {
		super();
		System.out.println("Generando nuevo libro");
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.anoPubli = anoPubli;
		this.editor = editor;
		this.numPag = numPag;
	}
	
	public String mostrarDatos() {
		String datos = "";

		datos += ("Identificador: " + this.id + "\n");
		datos += ("Titulo: " + this.titulo + "\n");
		datos += ("Autor: " + this.autor + "\n");
		datos += ("Año publicación: " + this.anoPubli + "\n");
		datos += ("Editor: " + this.editor + "\n");
		datos += ("Número Páginas: " + this.numPag);
		
		
		return datos;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getAnoPubli() {
		return anoPubli;
	}
	public void setAnoPubli(String anoPubli) {
		this.anoPubli = anoPubli;
	}
	public String getEditor() {
		return editor;
	}
	public void setEditor(String editor) {
		this.editor = editor;
	}
	public String getNumPag() {
		return numPag;
	}
	public void setNumPag(String numPag) {
		this.numPag = numPag;
	}
}