package bd;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Formulario {

	private JFrame frmFormulario;
	private JTextField txtEscribeSuNombre;
	private JTextField txtEscribaSuApellido;
	private JTextField txtEscibaSuDireccin;
	private JTextField txtEscribaSeEmail;
	private JTextField txtEscribaSuTelefono;
	
	private JButton btnLimpiar;
	private JButton btnSalir;
	
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	
	private JPasswordField passwordField;
	private JRadioButton rdbtnHombre;
	private ButtonGroup grupoOpciones;
	private JRadioButton rdbtnMujer;
	
	private JComboBox comboBox_1;
	private JComboBox comboBox_2;
	private JComboBox comboBox_3;
	
	private boolean validacion;
	private boolean validacionT;

	private JCheckBox chckbxNewCheckBox;
	private JCheckBox chckbxAtletismo;
	private JCheckBox chckbxFutbol;
	private JCheckBox chckbxVoleyball;
	private JCheckBox chckbxPintura;
	private JCheckBox chckbxBeisbol;
	
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel;
	
	private ResultSet resultadoQuery;
	
	private JButton btnBaja;
	private JButton btnConsultar;
	private JButton btnAlta;
	private JButton btnEditRegistro;
	private String sexo;
	private Object dia;
	private Object mes;
	private Object año;
	private Object Taller1;
	private String IdBd;
	
	private int ID;
	private int idregistro;
	private int idupdate;
	private int idinsert;
	
	private String Id;
	private String IdBaD;
	private String tel;
	private String correo;
	private String Nombre;
	private String Apellidos;
	private String Direccion;
	private String eMail;
	private String Sexo;
	private String telefono;
	private String fecha;
	private String usuario;
	private String Taller;
	private String fecha_nacimiento;
	private String MujerBase = "Mujer";
	private ResultSet IDRegitrado;
	

	Conector conexionBD = new Conector();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Formulario window = new Formulario();
					window.frmFormulario.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Formulario() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmFormulario = new JFrame();
		frmFormulario.setSize(648, 600);
		frmFormulario.getContentPane().setForeground(Color.BLACK);
		frmFormulario.setTitle("Formulario");
		frmFormulario.getContentPane().setBackground(Color.WHITE);
		frmFormulario.getContentPane().setLayout(null);

		txtEscribeSuNombre = new JTextField();
		txtEscribeSuNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent event) {
				char car = event.getKeyChar();
				if ((car < 'a' || car > 'z') && (car < 'A' || car > 'Z')
						&& (car != (char) KeyEvent.VK_SPACE)) {
					event.consume();
				}
			}
		});
		txtEscribeSuNombre.setForeground(Color.BLACK);
		txtEscribeSuNombre.setBackground(Color.WHITE);
		txtEscribeSuNombre.setBounds(98, 42, 136, 22);
		frmFormulario.getContentPane().add(txtEscribeSuNombre);
		txtEscribeSuNombre.setColumns(10);

		txtEscribaSuApellido = new JTextField();
		txtEscribaSuApellido.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char car = evt.getKeyChar();
				if ((car < 'a' || car > 'z') && (car < 'A' || car > 'Z')
						&& (car != (char) KeyEvent.VK_SPACE)) {
					evt.consume();

				}

			}
		});
		txtEscribaSuApellido.setForeground(Color.BLACK);
		txtEscribaSuApellido.setBackground(Color.WHITE);
		txtEscribaSuApellido.setColumns(10);
		txtEscribaSuApellido.setBounds(98, 91, 136, 22);
		frmFormulario.getContentPane().add(txtEscribaSuApellido);

		txtEscibaSuDireccin = new JTextField();
		txtEscibaSuDireccin.setForeground(Color.BLACK);
		txtEscibaSuDireccin.setColumns(10);
		txtEscibaSuDireccin.setBounds(98, 128, 136, 22);
		frmFormulario.getContentPane().add(txtEscibaSuDireccin);

		JLabel lblNombre = new JLabel("Nombre ");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNombre.setBounds(9, 45, 79, 18);
		frmFormulario.getContentPane().add(lblNombre);

		JLabel lblDireccin = new JLabel("Direcci\u00F3n");
		lblDireccin.setBounds(10, 132, 67, 14);
		frmFormulario.getContentPane().add(lblDireccin);

		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(10, 94, 46, 14);
		frmFormulario.getContentPane().add(lblApellido);

		JLabel lblFechaDeNacimiento = new JLabel("Fecha de Nacimiento");
		lblFechaDeNacimiento.setBounds(277, 44, 119, 18);
		frmFormulario.getContentPane().add(lblFechaDeNacimiento);

		JLabel lblEmail = new JLabel("e-Mail");
		lblEmail.setBounds(10, 177, 46, 14);
		frmFormulario.getContentPane().add(lblEmail);

		ManejadorCampoTexto manejador = new ManejadorCampoTexto();
		txtEscribaSeEmail = new JTextField();
		txtEscribaSeEmail.addActionListener(manejador);

		txtEscribaSeEmail.setBackground(Color.WHITE);
		txtEscribaSeEmail.setForeground(Color.BLACK);
		txtEscribaSeEmail.setColumns(10);
		txtEscribaSeEmail.setBounds(99, 173, 171, 23);
		frmFormulario.getContentPane().add(txtEscribaSeEmail);

		btnSalir = new JButton("Salir");
		btnSalir.setBounds(514, 490, 89, 23);
		frmFormulario.getContentPane().add(btnSalir);

		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBackground(Color.WHITE);
		btnLimpiar.setBounds(425, 490, 79, 23);
		frmFormulario.getContentPane().add(btnLimpiar);

		textField = new JTextField();
		textField.setBounds(319, 75, 0, 50);
		frmFormulario.getContentPane().add(textField);
		textField.setColumns(10);

		JLabel lblSexo = new JLabel("Sexo ");
		lblSexo.setBounds(11, 232, 46, 14);
		frmFormulario.getContentPane().add(lblSexo);

		JLabel lblUsuario = new JLabel("Usuario ");
		lblUsuario.setBounds(338, 95, 67, 14);
		frmFormulario.getContentPane().add(lblUsuario);

		textField_1 = new JTextField();
		textField_1.setBounds(444, 91, -87, 22);
		frmFormulario.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent usuario) {
				char car = usuario.getKeyChar();
				if ((car < 'a' || car > 'z') && (car < 'A' || car > 'Z')) {
					usuario.consume();
				}

			}
		});
		textField_2.setForeground(Color.BLACK);
		textField_2.setBounds(415, 91, 136, 22);
		frmFormulario.getContentPane().add(textField_2);
		textField_2.setColumns(10);

		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setBounds(314, 155, 67, 14);
		frmFormulario.getContentPane().add(lblContrasea);

		passwordField = new JPasswordField();
		passwordField.setForeground(Color.BLACK);
		passwordField.setToolTipText("");
		passwordField.setBounds(415, 151, 153, 22);
		frmFormulario.getContentPane().add(passwordField);

		rdbtnMujer = new JRadioButton("Mujer");
		rdbtnMujer.setBounds(98, 203, 109, 23);
		frmFormulario.getContentPane().add(rdbtnMujer);

		rdbtnHombre = new JRadioButton("Hombre");
		rdbtnHombre.setBounds(98, 228, 109, 23);
		frmFormulario.getContentPane().add(rdbtnHombre);

		grupoOpciones = new ButtonGroup();
		grupoOpciones.add(rdbtnMujer);
		grupoOpciones.add(rdbtnHombre);

		comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"01",
				"02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13",
				"14", "15", "16", "17", "18", "19", "20", "21", "22", "23",
				"24", "25", "26", "27", "28", "29", "30", "31" }));
		comboBox_1.setBounds(415, 38, 51, 30);
		frmFormulario.getContentPane().add(comboBox_1);
		comboBox_1.setMaximumRowCount(10);

		comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] { "01",
				"02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
		comboBox_2.setBounds(476, 38, 67, 30);
		frmFormulario.getContentPane().add(comboBox_2);
		comboBox_2.setMaximumRowCount(10);

		comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {
				"1950", "1951", "1952", "1953", "1954", "1955", "1956", "1957",
				"1958", "1959", "1960", "1961", "1962", "1963", "1964", "1965",
				"1966", "1967", "1968", "1969", "1970", "1971", "1972", "1973",
				"1974", "1975", "1976", "1977", "1978", "1979", "1980", "1981",
				"1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989",
				"1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997",
				"1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005",
				"2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013",
				"2014" }));
		comboBox_3.setBounds(553, 39, 69, 28);
		frmFormulario.getContentPane().add(comboBox_3);
		comboBox_3.setMaximumRowCount(10);

		chckbxNewCheckBox = new JCheckBox("Nataci\u00F3n");
		chckbxNewCheckBox.setBounds(9, 360, 97, 23);
		frmFormulario.getContentPane().add(chckbxNewCheckBox);

		chckbxAtletismo = new JCheckBox("Atletismo");
		chckbxAtletismo.setBounds(9, 398, 97, 23);
		frmFormulario.getContentPane().add(chckbxAtletismo);

		chckbxFutbol = new JCheckBox("Futbol");
		chckbxFutbol.setBounds(9, 435, 97, 23);
		frmFormulario.getContentPane().add(chckbxFutbol);

		chckbxVoleyball = new JCheckBox("Voleyball");
		chckbxVoleyball.setBounds(144, 360, 97, 23);
		frmFormulario.getContentPane().add(chckbxVoleyball);

		chckbxPintura = new JCheckBox("Pintura");
		chckbxPintura.setBounds(144, 398, 97, 23);
		frmFormulario.getContentPane().add(chckbxPintura);

		chckbxBeisbol = new JCheckBox("Beisbol");
		chckbxBeisbol.setBounds(144, 435, 97, 23);
		frmFormulario.getContentPane().add(chckbxBeisbol);

		JLabel lblNewLabel = new JLabel("\u00BFQu\u00E9 taller prefieres?");
		lblNewLabel.setBounds(98, 325, 128, 18);
		frmFormulario.getContentPane().add(lblNewLabel);

		lblNewLabel_1 = new JLabel("Telefono");
		lblNewLabel_1.setBounds(9, 277, 67, 14);
		frmFormulario.getContentPane().add(lblNewLabel_1);

		txtEscribaSuTelefono = new JTextField();
		txtEscribaSuTelefono.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent telefono) {
				char car = telefono.getKeyChar();
				if (txtEscribaSuTelefono.getText().length() >= 10)
					telefono.consume();
				if ((car < '0' || car > '9')
						&& (car != (char) KeyEvent.VK_SPACE)) {
					telefono.consume();

				}
			}
		});

		txtEscribaSuTelefono.setBounds(98, 274, 172, 22);
		frmFormulario.getContentPane().add(txtEscribaSuTelefono);
		txtEscribaSuTelefono.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Nuevo Registro");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(240, 0, 194, 20);
		frmFormulario.getContentPane().add(lblNewLabel_2);

		btnBaja = new JButton("Dar de Baja");
		btnBaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBaja.setBounds(396, 323, 108, 20);
		frmFormulario.getContentPane().add(btnBaja);

		btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(514, 323, 89, 23);
		frmFormulario.getContentPane().add(btnConsultar);

		ManejadorJButton manejadorJButton = new ManejadorJButton();
		btnAlta = new JButton("Registrar");
		btnAlta.setBounds(297, 323, 89, 23);
		frmFormulario.getContentPane().add(btnAlta);

		btnEditRegistro = new JButton("Editar un Registro");
		btnEditRegistro.setBounds(255, 490, 153, 23);
		frmFormulario.getContentPane().add(btnEditRegistro);

		btnSalir.addActionListener(manejadorJButton);
		btnLimpiar.addActionListener(manejadorJButton);
		btnAlta.addActionListener(manejadorJButton);
		btnBaja.addActionListener(manejadorJButton);
		btnConsultar.addActionListener(manejadorJButton);
		btnEditRegistro.addActionListener(manejadorJButton);

	}

	private class ManejadorJButton implements ActionListener {

		public void actionPerformed(ActionEvent EventosBtn) {
			if (EventosBtn.getActionCommand().equals("Salir")) {

				System.exit(0);
			}
			if (EventosBtn.getActionCommand().equals("Limpiar")) {

				txtEscribeSuNombre.setText("");
				txtEscribaSuApellido.setText("");
				txtEscibaSuDireccin.setText("");
				txtEscribaSeEmail.setText("");
				txtEscribaSuTelefono.setText("");
				comboBox_1.removeAllItems();
				comboBox_2.removeAllItems();
				comboBox_3.removeAllItems();
				textField_2.setText("");
				passwordField.setText("");
				chckbxNewCheckBox.setSelected(false);
				chckbxAtletismo.setSelected(false);
				chckbxFutbol.setSelected(false);
				chckbxFutbol.setSelected(false);
				chckbxVoleyball.setSelected(false);
				chckbxPintura.setSelected(false);
				chckbxPintura.setSelected(false);
				chckbxBeisbol.setSelected(false);

			}
			if (EventosBtn.getActionCommand().equals("Registrar")) {
				Conector conexionBD = new Conector();
				if (rdbtnMujer.isSelected()) {
					sexo = "Mujer";
				} else if (rdbtnHombre.isSelected()) {
					sexo = "Hombre";
				}
				fecha_nacimiento = (comboBox_3.getSelectedItem().toString()
						+ "/" + comboBox_2.getSelectedItem().toString() + "/" + comboBox_1
						.getSelectedItem().toString());

				if (chckbxNewCheckBox.isSelected() == true) {
					Taller1 = "Natacion";
				}
				if (chckbxAtletismo.isSelected() == true) {
					Taller1 = "Atletismo";

				}
				if (chckbxFutbol.isSelected() == true) {
					Taller1 = "Futbol";

				}
				if (chckbxVoleyball.isSelected() == true) {
					Taller1 = "Voleyball";

				}
				if (chckbxPintura.isSelected() == true) {
					Taller1 = "Pintura";
				}
				if (chckbxBeisbol.isSelected() == true) {

					Taller1 = "Beisbol";
				}

				conexionBD
						.setQuery("insert into anapaola.registro (Nombre,Apellidos,Direccion,eMail,Sexo,Telefono,FechadeNacimiento,Usuario,Contraseña, Taller)values('"
								+ txtEscribeSuNombre.getText()
								+ "','"
								+ txtEscribaSuApellido.getText()
								+ "','"
								+ txtEscibaSuDireccin.getText()
								+ "','"
								+ txtEscribaSeEmail.getText()
								+ "','"
								+ sexo
								+ "','"
								+ txtEscribaSuTelefono.getText()
								+ "','"
								+ fecha_nacimiento
								+ "','"
								+ textField_2.getText()
								+ "','"
								+ passwordField.getText()
								+ "','"
								+ Taller1
								+ "')");
				IDRegitrado = conexionBD
						.getQuery("SELECT MAX(idregistro) AS idregistro FROM anapaola.registro");
				try {
					if (IDRegitrado.next()) {
						idinsert = IDRegitrado.getInt(1);

					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				JOptionPane.showMessageDialog(null, " Registro Exitoso "
						+ "Su ID es: " + idinsert);
			} else if (EventosBtn.getActionCommand() == "Dar de Baja") {
				IdBd = JOptionPane
						.showInputDialog("Escriba el ID a Dar de Baja");

				Conector conexion = new Conector();

				ID = Integer.parseInt(IdBd);

				conexion.setQuery("delete from anapaola.registro where idregistro= "
						+ ID + ";");
				;

				txtEscribeSuNombre.setText("");
				txtEscribaSuApellido.setText("");
				txtEscibaSuDireccin.setText("");
				txtEscribaSeEmail.setText("");
				txtEscribaSuTelefono.setText("");
				comboBox_1.removeAllItems();
				comboBox_2.removeAllItems();
				comboBox_3.removeAllItems();
				textField_2.setText("");
				passwordField.setText("");
				chckbxNewCheckBox.setSelected(false);
				chckbxAtletismo.setSelected(false);
				chckbxFutbol.setSelected(false);
				chckbxFutbol.setSelected(false);
				chckbxVoleyball.setSelected(false);
				chckbxPintura.setSelected(false);
				chckbxPintura.setSelected(false);
				chckbxBeisbol.setSelected(false);
			} else if (EventosBtn.getActionCommand() == "Consultar") {
				Id = JOptionPane.showInputDialog("Escriba el ID a consultar");
				Conector conexionBD = new Conector();
				idregistro = Integer.parseInt(Id);

				//
				resultadoQuery = conexionBD
						.getQuery("select Nombre,Apellidos,Direccion,eMail,Sexo,Telefono,FechadeNacimiento,Usuario,Contraseña,Taller from anapaola.registro  where idregistro="
								+ idregistro + ";");
				;

				try {
					while (resultadoQuery.next()) {

						Nombre = resultadoQuery.getString("Nombre");
						Apellidos = resultadoQuery.getString("Apellidos");
						Direccion = resultadoQuery.getString("Direccion");
						eMail = resultadoQuery.getString("eMail");
						Sexo = resultadoQuery.getString("Sexo");
						telefono = resultadoQuery.getString("Telefono");
						fecha = resultadoQuery.getString("FechadeNacimiento");
						usuario = resultadoQuery.getString("Usuario");
						Taller = resultadoQuery.getString("Taller");

						if (Sexo.equals(MujerBase)) {
							rdbtnMujer.setSelected(true);

						} else {
							rdbtnHombre.setSelected(true);
						}

						txtEscribeSuNombre.setText(Nombre);
						txtEscribaSuApellido.setText(Apellidos);
						txtEscibaSuDireccin.setText(Direccion);
						txtEscribaSeEmail.setText(eMail);
						sexo = (Sexo);
						txtEscribaSuTelefono.setText(telefono);

						String Anoc = fecha.substring(0, 4);
						System.out.println(Anoc);

						String mes = fecha.substring(5, 7);
						System.out.println(mes);

						String dia = fecha.substring(8, fecha.length());
						System.out.println(dia);

						for (int I = 0; I < comboBox_3.getItemCount(); I++) {
							String anoaux = (String) comboBox_3.getItemAt(I);
							if (Anoc.equals(anoaux)) {
								comboBox_3.setSelectedIndex(I);
							}
						}
						for (int x = 0; x < comboBox_2.getItemCount(); x++) {
							String mesaux = (String) comboBox_2.getItemAt(x);
							if (mes.equals(mesaux)) {
								comboBox_2.setSelectedIndex(x);
							}
						}
						for (int y = 0; y < comboBox_1.getItemCount(); y++) {
							String diaaux = (String) comboBox_1.getItemAt(y);
							if (dia.equals(diaaux)) {
								comboBox_1.setSelectedIndex(y);
							}
						}

						textField_2.setText(usuario);
						String tallers = "Natacion";
						String taller2 = "Atletismo";
						String taller3 = "Futbol";
						String taller4 = "Voleyball";
						String taller5 = "Pintura";
						String taller6 = "Beisbol";
						if (Taller.equals(tallers)) {
							chckbxNewCheckBox.setSelected(true);

						}
						if (Taller.equals(taller2)) {
							chckbxAtletismo.setSelected(true);
						}
						if (Taller.equals(taller3)) {
							chckbxFutbol.setSelected(true);
						}
						if (Taller.equals(taller4)) {
							chckbxVoleyball.setSelected(true);

						}
						if (Taller.equals(taller5)) {
							chckbxPintura.setSelected(true);
						}
						if (Taller.equals(taller6)) {
							chckbxBeisbol.setSelected(true);
						}

					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			if (EventosBtn.getActionCommand() == "Editar un Registro") {
				IdBaD = JOptionPane
						.showInputDialog("Escriba el ID a modificar");
				Conector conexionBD = new Conector();
				idupdate = Integer.parseInt(IdBaD);
				
				if(txtEscribeSuNombre.equals(" ")){
					conexionBD.setQuery("update anapaola.registro set Nombre='"
							+ txtEscribeSuNombre.getText() + "' where idregistro="
							+ idupdate + " ");	
				}
				if(txtEscribaSuApellido.equals(" ")){
				
					conexionBD.setQuery("update anapaola.registro set Apellidos='"
							+ txtEscribaSuApellido.getText()
							+ "' where idregistro=" + idupdate + " ");	
				}
				if(txtEscibaSuDireccin.equals(" ")){
			
					conexionBD.setQuery("update anapaola.registro set Direccion='"
							+ txtEscibaSuDireccin.getText() + "' where idregistro="
							+ idupdate + " ");
				}
				if(txtEscribaSeEmail.equals("")){
			
					conexionBD.setQuery("update anapaola.registro set eMail='"
							+ txtEscribaSeEmail.getText() + "' where idregistro="
							+ idupdate + " ");
				}
				conexionBD.setQuery("update anapaola.registro set Sexo='"
						+ Sexo + "' where idregistro="
						+ idupdate + " ");
				
				if(txtEscribaSuTelefono.equals(" ")){
			
					conexionBD.setQuery("update anapaola.registro set Telefono='"
							+ txtEscribaSuTelefono.getText()
							+ "' where idregistro=" + idupdate + " ");
				}
				conexionBD.setQuery("update anapaola.registro set FechadeNacimiento='"
						+ fecha + "' where idregistro="
						+ idupdate + " ");
				
				if(textField_2.equals("")){
			
					conexionBD.setQuery("update anapaola.registro set Usuario='"
							+ textField_2.getText() + "' where idregistro="
							+ idupdate + "");
					
				}
				if(passwordField.equals("")){
			
					conexionBD.setQuery("update anapaola.registro set Contraseña='"
							+ passwordField.getText() + "' where idregistro="
							+ idupdate + "");	
				}
				conexionBD.setQuery("update anapaola.registro set Taller='"
						+ Taller + "' where idregistro="
						+ idupdate + " ");
			}

		}
	}

	private class ManejadorCampoTexto implements ActionListener {

		public void actionPerformed(ActionEvent event) {
			if (event.getSource() == txtEscribaSeEmail) {
				correo = event.getActionCommand();
				validacion = isEmail(correo);
				if (validacion == false) {
					JOptionPane.showMessageDialog(null, "Correo Invalido");
				}

			}

		}

		public boolean isEmail(String correo) {
			Pattern pat = null;
			Matcher mat = null;

			pat = Pattern
					.compile("^([0-9a-zA-Z]([_.w]*[0-9a-zA-Z])*@([0-9a-zA-Z][-w]*[0-9a-zA-Z].)+([a-zA-Z]{2,9}.)+[a-zA-Z]{2,3})$");
			mat = pat.matcher(correo);

			if (mat.find()) {
				return true;
			} else {
				return false;

			}
		}

	}
}