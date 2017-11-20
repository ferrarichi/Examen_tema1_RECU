package view;

import java.awt.Dimension;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Window.Type;
import java.awt.event.KeyEvent;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.Color;

public class LaunchView extends JFrame {

	private JButton comparar,buscar,copiar;
	private JTextArea textArea;
	private JTextField fichero1,fichero2,palabra;
	private JLabel label_f1,label_f2,label_pal;
	private JCheckBox primera;
	
	private JPanel panel;
	private JMenuBar menuBar;
	private JMenu mnArchivo;
	private JMenuItem mntmCompararContenido, mntmBuscarPalabra, mntmCopiarArchivo;
	private JPanel panelCrearLibro;
	private JLabel lblIdentificador;
	private JTextField txtID;
	private JLabel lblTitulo;
	private JTextField txtTitulo;
	private JLabel lblAutor;
	private JTextField txtAutor;
	private JLabel lblAoPublicacin;
	private JTextField txtAno;
	private JLabel lblEditor;
	private JTextField txtEditor;
	private JLabel lblNmeroDePginas;
	private JTextField txtPag;
	private JPanel panelButtons;
	private JButton btnGuardar;
	private JMenu mnLibro;
	private JMenuItem mntmGuardarLibro;
	private JMenuItem mntmRecuperarLibro;
	private JButton btnRecuperar;
	private JMenuItem mntmListarLibros;
	private JMenu mnProyecto;
	private Component horizontalGlue;
	private JMenuItem mntmGithub;
	private JMenuItem mntmFloridaUniversitaria;
	private JMenuItem mntmJorgeLpezGil;
	private JSeparator separator;
	private JMenuItem mntmCambiarAoLibro;
	private JButton btnCambiarAno;
	private JMenuItem mntmLocalizarNumPalabras;
	private JButton btnNumPalab;
	private JButton btnPalabraMasLarga;
	
	public JMenuItem getMntmCompararContenido() {
		return mntmCompararContenido;
	}

	public void setMntmCompararContenido(JMenuItem mntmCompararContenido) {
		this.mntmCompararContenido = mntmCompararContenido;
	}

	public JMenuItem getMntmBuscarPalabra() {
		return mntmBuscarPalabra;
	}

	public void setMntmBuscarPalabra(JMenuItem mntmBuscarPalabra) {
		this.mntmBuscarPalabra = mntmBuscarPalabra;
	}

	public JMenuItem getMntmCopiarArchivo() {
		return mntmCopiarArchivo;
	}

	public void setMntmCopiarArchivo(JMenuItem mntmCopiarArchivo) {
		this.mntmCopiarArchivo = mntmCopiarArchivo;
	}

	public LaunchView() {
		
		setBounds(200,200,1150,350);
		setTitle("Proyecto Buffers");	
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		primera = new JCheckBox("Primera aparición");
		panel.add(primera);

		textArea = new JTextArea(10, 80);
		textArea.setEditable(false);
		JScrollPane scroll = new JScrollPane(textArea);
		scroll.setBounds(50,50,50,50);
		panel.add(scroll);
		
        // Añadimos el JPanel al JFrame
        this.getContentPane().add(panel, BorderLayout.CENTER);		
        
        panelCrearLibro = new JPanel();
        panelCrearLibro.setVisible(false);
        getContentPane().add(panelCrearLibro, BorderLayout.SOUTH);
        
        lblIdentificador = new JLabel("ID");
        panelCrearLibro.add(lblIdentificador);
        
        txtID = new JTextField();
        panelCrearLibro.add(txtID);
        txtID.setColumns(10);
        
        lblTitulo = new JLabel("Titulo");
        panelCrearLibro.add(lblTitulo);
        
        txtTitulo = new JTextField();
        panelCrearLibro.add(txtTitulo);
        txtTitulo.setColumns(10);
        
        lblAutor = new JLabel("Autor");
        panelCrearLibro.add(lblAutor);
        
        txtAutor = new JTextField();
        panelCrearLibro.add(txtAutor);
        txtAutor.setColumns(10);
        
        lblAoPublicacin = new JLabel("Año");
        panelCrearLibro.add(lblAoPublicacin);
        
        txtAno = new JTextField();
        panelCrearLibro.add(txtAno);
        txtAno.setColumns(10);
        
        lblEditor = new JLabel("Editor");
        panelCrearLibro.add(lblEditor);
        
        txtEditor = new JTextField();
        panelCrearLibro.add(txtEditor);
        txtEditor.setColumns(10);
        
        lblNmeroDePginas = new JLabel("Pag");
        panelCrearLibro.add(lblNmeroDePginas);
        
        txtPag = new JTextField();
        panelCrearLibro.add(txtPag);
        txtPag.setColumns(10);
        
        btnGuardar = new JButton("Guardar");
        panelCrearLibro.add(btnGuardar);
        
        btnCambiarAno = new JButton("Cambiar Año");
        panelCrearLibro.add(btnCambiarAno);
        
        btnRecuperar = new JButton("Recuperar");
        panelCrearLibro.add(btnRecuperar);
        
        panelButtons = new JPanel();
        getContentPane().add(panelButtons, BorderLayout.NORTH);
        
        comparar = new JButton("Comparar");
        panelButtons.add(comparar);
        comparar.setPreferredSize(new Dimension(150, 26));
        buscar = new JButton("Buscar palabra");
        panelButtons.add(buscar);
        buscar.setPreferredSize(new Dimension(150, 26));
        copiar = new JButton("Copiar fichero");
        panelButtons.add(copiar);
        copiar.setPreferredSize(new Dimension(150, 26));
        
        btnNumPalab = new JButton("Buscar palabras");
        btnNumPalab.setPreferredSize(new Dimension(150, 26));
        btnNumPalab.setVisible(false);
        panelButtons.add(btnNumPalab);
        
        btnPalabraMasLarga = new JButton("Palabra mas larga");
        panelButtons.add(btnPalabraMasLarga);
        
        label_f1 = new JLabel("Fichero 1:");
        panelButtons.add(label_f1);
        
		fichero1 = new JTextField("",10);
		panelButtons.add(fichero1);
		label_f2 = new JLabel("Fichero 2:");
		panelButtons.add(label_f2);
		fichero2 = new JTextField("",10);
		panelButtons.add(fichero2);
		label_pal = new JLabel("Palabra:");
		panelButtons.add(label_pal);
		palabra = new JTextField("",10);
		panelButtons.add(palabra);
        
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        
        mnArchivo = new JMenu("Archivo");
        menuBar.add(mnArchivo);
        
        mntmCompararContenido = new JMenuItem("Comparar contenido");
        mnArchivo.add(mntmCompararContenido);
        
        mntmBuscarPalabra = new JMenuItem("Buscar palabra");
        mnArchivo.add(mntmBuscarPalabra);
        
        mntmCopiarArchivo = new JMenuItem("Copiar archivo");
        mnArchivo.add(mntmCopiarArchivo);
        
        mntmLocalizarNumPalabras = new JMenuItem("Localizar num Palabras");
        mnArchivo.add(mntmLocalizarNumPalabras);
        
        mnLibro = new JMenu("Libro");
        menuBar.add(mnLibro);
        
        mntmGuardarLibro = new JMenuItem("Guardar libro");
        mnLibro.add(mntmGuardarLibro);
        
        mntmRecuperarLibro = new JMenuItem("Recuperar libro");
        mnLibro.add(mntmRecuperarLibro);
        
        mntmListarLibros = new JMenuItem("Listar libros");
        mnLibro.add(mntmListarLibros);
        
        mntmCambiarAoLibro = new JMenuItem("Cambiar año libro");
        mnLibro.add(mntmCambiarAoLibro);
        
        horizontalGlue = Box.createHorizontalGlue();
        menuBar.add(horizontalGlue);
        
        mnProyecto = new JMenu("Proyecto");
        menuBar.add(mnProyecto);
        
        mntmGithub = new JMenuItem("GitHub");
        mnProyecto.add(mntmGithub);
        
        mntmFloridaUniversitaria = new JMenuItem("Florida Universitaria");
        mnProyecto.add(mntmFloridaUniversitaria);
        
        separator = new JSeparator();
        mnProyecto.add(separator);
        
        mntmJorgeLpezGil = new JMenuItem("Jorge López Gil");
        mntmJorgeLpezGil.setEnabled(false);
        mnProyecto.add(mntmJorgeLpezGil);
        
        //Botones Web
        mntmGithub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				openWeb("https://github.com/JHORJE18");
			}});
        mntmFloridaUniversitaria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				openWeb("http://www.floridauniversitaria.es/");
			}});

	}	
	
	public JButton getBtnPalabraMasLarga() {
		return btnPalabraMasLarga;
	}

	public void setBtnPalabraMasLarga(JButton btnPalabraMasLarga) {
		this.btnPalabraMasLarga = btnPalabraMasLarga;
	}

	public JMenuItem getMntmLocalizarNumPalabras() {
		return mntmLocalizarNumPalabras;
	}

	public void setMntmLocalizarNumPalabras(JMenuItem mntmLocalizarNumPalabras) {
		this.mntmLocalizarNumPalabras = mntmLocalizarNumPalabras;
	}

	public JLabel getLabel_f2() {
		return label_f2;
	}

	public void setLabel_f2(JLabel label_f2) {
		this.label_f2 = label_f2;
	}

	public JLabel getLabel_pal() {
		return label_pal;
	}

	public void setLabel_pal(JLabel label_pal) {
		this.label_pal = label_pal;
	}

	public JButton getBtnNumPalab() {
		return btnNumPalab;
	}

	public void setBtnNumPalab(JButton btnNumPalab) {
		this.btnNumPalab = btnNumPalab;
	}

	public JMenuItem getMntmCambiarAoLibro() {
		return mntmCambiarAoLibro;
	}

	public void setMntmCambiarAoLibro(JMenuItem mntmCambiarAoLibro) {
		this.mntmCambiarAoLibro = mntmCambiarAoLibro;
	}

	public JMenuItem getMntmListarLibros() {
		return mntmListarLibros;
	}

	public void setMntmListarLibros(JMenuItem mntmListarLibros) {
		this.mntmListarLibros = mntmListarLibros;
	}

	public JButton getBtnRecuperar() {
		return btnRecuperar;
	}

	public void setBtnRecuperar(JButton btnRecuperar) {
		this.btnRecuperar = btnRecuperar;
	}

	public JTextField getTxtID() {
		return txtID;
	}

	public void setTxtID(JTextField txtID) {
		this.txtID = txtID;
	}

	public JTextField getTxtTitulo() {
		return txtTitulo;
	}

	public void setTxtTitulo(JTextField txtTitulo) {
		this.txtTitulo = txtTitulo;
	}

	public JTextField getTxtAutor() {
		return txtAutor;
	}

	public void setTxtAutor(JTextField txtAutor) {
		this.txtAutor = txtAutor;
	}

	public JTextField getTxtAno() {
		return txtAno;
	}

	public void setTxtAno(JTextField txtAno) {
		this.txtAno = txtAno;
	}

	public JTextField getTxtEditor() {
		return txtEditor;
	}

	public void setTxtEditor(JTextField txtEditor) {
		this.txtEditor = txtEditor;
	}

	public JTextField getTxtPag() {
		return txtPag;
	}

	public void setTxtPag(JTextField txtPag) {
		this.txtPag = txtPag;
	}

	public JButton getBtnGuardar() {
		return btnGuardar;
	}

	public void setBtnGuardar(JButton btnGuardar) {
		this.btnGuardar = btnGuardar;
	}

	public JPanel getPanelCrearLibro() {
		return panelCrearLibro;
	}

	public void setPanelCrearLibro(JPanel panelCrearLibro) {
		this.panelCrearLibro = panelCrearLibro;
	}
	
	public void visiblidadPanel (Boolean valor) {
		this.panelCrearLibro.setVisible(valor);
	}

	public JMenuItem getMntmGuardarLibro() {
		return mntmGuardarLibro;
	}

	public void setMntmGuardarLibro(JMenuItem mntmGuardarLibro) {
		this.mntmGuardarLibro = mntmGuardarLibro;
	}

	public JButton getComparar() {
		return comparar;
	}

	public void setComparar(JButton comparar) {
		this.comparar = comparar;
	}
	
	public JButton getCopiar() {
		return copiar;
	}

	public void setCopiar(JButton comparar) {
		this.copiar = copiar;
	}

	public JButton getBuscar() {
		return buscar;
	}

	public void setBuscar(JButton buscar) {
		this.buscar = buscar;
	}

	public JTextArea getTextArea() {
		return textArea;
	}

	public void setTextArea(String txt) {
		this.textArea.setText(txt);
	}
	
	public void addTextArea(String txt) {
		String antes = this.textArea.getText();
		this.textArea.setText(antes + "\n" + txt);
	}
			
	public JTextField getFichero1() {
		return fichero1;
	}

	public void setFichero1(JTextField fichero1) {
		this.fichero1 = fichero1;
	}

	public JTextField getFichero2() {
		return fichero2;
	}
	
	public JTextField getPalabra() {
		return palabra;
	}

	public void setFichero2(JTextField fichero2) {
		this.fichero2 = fichero2;
	}
	
	public JCheckBox getPrimera(){
		return primera;
	}
	
	public JButton getBtnCambiarAno() {
		return btnCambiarAno;
	}

	public void setBtnCambiarAno(JButton btnCambiarAno) {
		this.btnCambiarAno = btnCambiarAno;
	}
	
	public void mostrarSoloID(Boolean valor) {
		this.lblTitulo.setVisible(!valor);
		this.txtTitulo.setVisible(!valor);
		this.lblAutor.setVisible(!valor);
		this.txtAutor.setVisible(!valor);
		this.lblAoPublicacin.setVisible(!valor);
		this.txtAno.setVisible(!valor);
		this.lblEditor.setVisible(!valor);
		this.txtEditor.setVisible(!valor);
		this.lblNmeroDePginas.setVisible(!valor);
		this.txtPag.setVisible(!valor);
		this.btnGuardar.setVisible(!valor);
		this.btnCambiarAno.setVisible(!valor);
		this.btnRecuperar.setVisible(valor);
	}

	// #EJ1 Creamos interfaz unica
	public void mostrarIDAno(Boolean valor) {
		this.lblTitulo.setVisible(!valor);
		this.txtTitulo.setVisible(!valor);
		this.lblAutor.setVisible(!valor);
		this.txtAutor.setVisible(!valor);
		this.lblEditor.setVisible(!valor);
		this.txtEditor.setVisible(!valor);
		this.lblNmeroDePginas.setVisible(!valor);
		this.txtPag.setVisible(!valor);
		this.btnGuardar.setVisible(!valor);
		this.btnRecuperar.setVisible(!valor);
		this.btnCambiarAno.setVisible(valor);
		this.txtAno.setVisible(valor);
		this.lblAoPublicacin.setVisible(valor);
	}

	public JMenuItem getMntmRecuperarLibro() {
		return mntmRecuperarLibro;
	}

	public void setMntmRecuperarLibro(JMenuItem mntmRecuperarLibro) {
		this.mntmRecuperarLibro = mntmRecuperarLibro;
	}

	public void showError(String m){
		JOptionPane.showMessageDialog(this.panel,
			    m,
			    "Error",
			    JOptionPane.ERROR_MESSAGE);
	}
	
	//Abrir acceso directo
	public void openWeb(String link) {
		try {
			  Desktop desktop = java.awt.Desktop.getDesktop();
			  URI oURL = new URI(link);
			  desktop.browse(oURL);
			} catch (Exception e) {
			  showError("No se ha podido abrir la web " + link);
			}
	}


}
