package codigo;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Main extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String[] ArrayEncabezado;
	private String[][] Arraydatos;
	private Object[][] datos;
	private Object[] Encabezado;
	private DefaultTableModel model;
	
	//private DefaultTableModel model = new DefaultTableModel(new Object[][] {
	//		{ "some", "text" }, { "any", "text" }, { "even", "more" },
	//		{ "text", "strings" }, { "and", "other" }, { "text", "values" } },
	//		new Object[] { "Column 1", "Column 2" });

	public Main() {
		
		/*Arraydatos[0][0]="15";
		Arraydatos[0][1]="Juan Jaime";
		Arraydatos[0][2]="Angostura";
		
		
		
		ArrayEncabezado[0]="ID";
		ArrayEncabezado[0]="Nombre";
		ArrayEncabezado[0]]="Direcci�n";
		
		datos=Arraydatos;
		Encabezado=ArrayEncabezado;
		
		ArrayEncabezado[0]="ID";
		ArrayEncabezado[0]="Nombre";
		ArrayEncabezado[0]="Direcci�n";
		
		Encabezado=ArrayEncabezado;
		
		*/
		
		
		
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		model = new DefaultTableModel(new Object[][] {{"15","Juan Jaime"},{ "some", "text" }},
						new Object[] { "Id", "nombre" });
				
		//model.setDataVector(datos, Encabezado);
		JTable table = new JTable(model);
		getContentPane().add(new JScrollPane(table), BorderLayout.CENTER);
		pack();
	}

	public static void main(String arg[]) {
		new Main().setVisible(true);
	}

}
