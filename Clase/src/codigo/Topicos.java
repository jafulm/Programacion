package codigo;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import org.w3c.dom.events.Event;

import javax.swing.ImageIcon;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Topicos extends JFrame {

	private JPanel contentPane;
	private JTextField textField_3;
	private JTextField textField_5;
	private JTextField textField;
	private String nombre;
	private String año;
	private String clasificacion;
	private String tipo;
	private ButtonGroup radio;
	private static int a;
	private static int b;
	private static int c;
	private static int d;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Topicos frame = new Topicos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Topicos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 595, 316);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(30, 144, 255));
		contentPane.setForeground(Color.BLUE);
		contentPane.setBorder(new EmptyBorder(9, 9, 9, 9));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBuscadordejuegos = new JLabel("Buscador de juegos");
		lblBuscadordejuegos.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBuscadordejuegos.setBounds(9, 11, 163, 27);
		contentPane.add(lblBuscadordejuegos);
		
		JLabel lblModelo = new JLabel("A�o");
		lblModelo.setBounds(19, 80, 46, 14);
		contentPane.add(lblModelo);
		
		textField_3 = new JTextField();
		textField_3.addKeyListener(new KeyAdapter() {
			@Override
		public void keyTyped(KeyEvent Año) {
			       char a=Año.getKeyChar(); 
			          if(Character.isLetter(a)) { 
			              getToolkit().beep(); 
			              Año.consume(); 
					JOptionPane.showMessageDialog(null, "No puede ingresar letras!!!", "Validando Datos",
							JOptionPane.ERROR_MESSAGE);
			}
		}});

		textField_3.setBounds(97, 77, 327, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(97, 52, 327, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(19, 55, 46, 14);
		contentPane.add(lblNombre);
		
		JLabel lblClasificacion = new JLabel("Clasificacion");
		lblClasificacion.setBounds(9, 105, 89, 14);
		contentPane.add(lblClasificacion);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent Clasificacion) {
				char b=Clasificacion.getKeyChar(); 
		          if(Character.isDigit(b)) { 
		              getToolkit().beep(); 
		        Clasificacion.consume(); 
		      JOptionPane.showMessageDialog(null, "No puede ingresar numeros!!!", "Validando Datos",
					JOptionPane.ERROR_MESSAGE);
			}
		}});
		textField.setBounds(97, 105, 327, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblqueTipoDe = new JLabel("�Que tipo de juego buscas?");
		lblqueTipoDe.setBounds(9, 140, 175, 14);
		contentPane.add(lblqueTipoDe);
		
		JRadioButton rdbtnViolento = new JRadioButton("Violento");
		rdbtnViolento.setBounds(288, 136, 97, 23);
		contentPane.add(rdbtnViolento);
		
		JRadioButton rdbtnAccion = new JRadioButton("Accion");
		rdbtnAccion.setBounds(491, 173, 82, 23);
		contentPane.add(rdbtnAccion);
		
		JRadioButton rdbtnPuzzle = new JRadioButton("Puzzle");
		rdbtnPuzzle.setBounds(175, 136, 89, 22);
		contentPane.add(rdbtnPuzzle);
		
		JRadioButton rdbtnEstrateguia = new JRadioButton("Estrategia");
		rdbtnEstrateguia.setBounds(214, 173, 115, 23);
		contentPane.add(rdbtnEstrateguia);
		
		JRadioButton rdbtnJuegoDeMesa = new JRadioButton("Juego de mesa");
		rdbtnJuegoDeMesa.setBounds(353, 173, 122, 23);
		contentPane.add(rdbtnJuegoDeMesa);
		
		radio=new ButtonGroup();
		radio.add(rdbtnJuegoDeMesa);
		radio.add(rdbtnEstrateguia);
		radio.add(rdbtnPuzzle);
		radio.add(rdbtnAccion);
		radio.add(rdbtnViolento);
		
		JCheckBox chckbxEstoyDeAcuerdo = new JCheckBox("Estas de acuerdo con el juego seleccionado");
		chckbxEstoyDeAcuerdo.setBounds(9, 203, 323, 46);
		contentPane.add(chckbxEstoyDeAcuerdo);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean v=true;
				tipo="";
				if (textField_5.getText().equals("")){
					JOptionPane.showMessageDialog(null,"no escribiste el nombre");
					v=false;
					
				}
				if(textField_3.getText().equals("")){
					JOptionPane.showMessageDialog(null,"no escribiste el a�o");
					v=false;
				}
				if(textField.getText().equals("")){
					JOptionPane.showMessageDialog(null,"no escribiste la clasificacion");
					v=false;
				}
				if (rdbtnJuegoDeMesa.isSelected()){
					tipo="juego de mesa";
				}
				if (rdbtnEstrateguia.isSelected()){
					tipo="estrategia";
				}
				if (rdbtnPuzzle.isSelected()){
					tipo="puzzle";
				}
				if (rdbtnAccion.isSelected()){
					tipo="accion";
				}
				if (rdbtnViolento.isSelected()){
					tipo="violento";
				}
				
				if(tipo==""){
					v=false;
					JOptionPane.showMessageDialog(null,"seleciona un tipo de juego");
				}
				
				if(v==true){
					if(chckbxEstoyDeAcuerdo.isSelected()){
						nombre=textField_5.getText();
						año=textField_3.getText();
						clasificacion=textField.getText();
						JOptionPane.showMessageDialog(null,"el juego "+nombre+" del a�o "+año+" de la clasificacion "+clasificacion+" del tipo "+tipo+" no se encuentra en la base de datos");
					}else{
						JOptionPane.showMessageDialog(null,"marca la casilla de confimacion de juego");
					}
					
				}
				
				
				}
		});
		btnAceptar.setForeground(Color.DARK_GRAY);
		btnAceptar.setBackground(UIManager.getColor("Table.selectionBackground"));
		btnAceptar.setBounds(430, 222, 97, 27);
		contentPane.add(btnAceptar);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBackground(new Color(30, 144, 255));
		btnNewButton.setIcon(new ImageIcon("E:\\\u00A0\\dosblaster.png"));
		btnNewButton.setBounds(430, 18, 139, 136);
		contentPane.add(btnNewButton);
	}
}