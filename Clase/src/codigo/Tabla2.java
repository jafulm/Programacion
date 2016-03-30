package codigo;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class Tabla2 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	// se declara una variable tipo model que permitira agregar los datos la
	// tabla
	private DefaultTableModel model;
	// se declara la j tabla donde se mostraran los datos 0
	private JTable table;
	// se declara un variable tipo objeto lo que permitira guardar la
	// informaci�n
	private Object[] datos;
	private JButton btnEliminar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tabla2 frame = new Tabla2();

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
	public Tabla2() {
		getContentPane().setLayout(null);

		MyDataAcces conexion = new MyDataAcces();
		ResultSet resultado;
		// String nombres;
		// int llave;
		// String direccion;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 561, 358);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		// se inicializa
		model = new DefaultTableModel();
		datos = new Object[3];

		JScrollPane scrollPane = new JScrollPane();
		table = new JTable();
		scrollPane.setViewportView(table);

		// vinculamos la tabla al model
		table.setModel(model);

		btnEliminar = new JButton("Eliminar");

		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// model.getDataVector();
				// System.out.println(model.getDataVector());
				model.removeRow(table.getSelectedRow());

				// dtm.removeRow(jTableProducto.getSelectedRow());
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(61)
					.addComponent(btnEliminar, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
					.addGap(81)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 309, GroupLayout.PREFERRED_SIZE)
					.addGap(11))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(30)
							.addComponent(btnEliminar))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(172, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);

		// llenar los Titulos de tabla
		model.addColumn("ID");
		model.addColumn("Nombre");
		model.addColumn("Domicilio");

		resultado = conexion.getQuery("SELECT LLAVE,NOMBRE,DIRECCION FROM eclipse.datos");

		try {
			if (resultado.next()) { // verifica si esta vacio, pero desplaza el
									// puntero al siguiente elemento

				resultado.beforeFirst();// esta regresa el puntero al inicio
										// para no perder el 1er dato

				while (resultado.next()) {

					datos[0] = resultado.getInt("LLAVE");
					datos[1] = resultado.getString("NOMBRE");
					datos[2] = resultado.getString("DIRECCION");

					// Aqui se agrega cada columna de la base de datos
					model.addRow(datos);

				}
				resultado.close();

			} else {
				JOptionPane.showMessageDialog(null, "El resultado esta vacio");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// se llena el arreglo con el encabezado para que se utilice

	}
}
