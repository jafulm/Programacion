package codigo;


import java.awt.EventQueue;
import java.awt.ScrollPane;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Tabla extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2948646344449608560L;
	private JPanel contentPane;
	private JTable tabla;
	private ScrollPane scrollPane;
	private DefaultTableModel model;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tabla frame = new Tabla();
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
	public Tabla() {
		super("JTable Column Header Custom Renderer Basic");
		
		String[] columnNames = new String[] { "Title", "Author", "Publisher", "Published Date", "Pages", "Rating" };
		Object[][] rowData = new String[][] {
				{ "Effective Java", "Joshua Bloch", "Addision-Wesley", "May 08th 2008", "346", "5" },
				{ "Thinking in Java", "Bruce Eckel", "Prentice Hall", "Feb 26th 2006", "1150", "4" },
				{ "Head First Java", "Kathy Sierra & Bert Bates", "O'Reilly Media", "Feb 09th 2005", "688", "4.5" }, };
		
		
		
		
		contentPane = new JPanel();
		model=new DefaultTableModel();
				//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//contentPane.setLayout(null);
		
		scrollPane = new ScrollPane();
		scrollPane.setBounds(27, 60, 465, 223);
		contentPane.add(scrollPane);
		

		
		
		
		
		
		
		tabla = new JTable(rowData,columnNames);
		
		tabla.setBounds(33, 131, 450, 100);
		
		scrollPane.add(tabla);
		tabla.getTableHeader();
        
	
		/*for(int x=0; x<columnNames.length;x++){
			System.out.println(columnNames[x]);
			model.addColumn(columnNames[x]);
		}
		for(int x=0; x<rowData.length;x++){
			System.out.println(rowData.getClass().isArray());
		    String [] datos;
		    datos= new String [6];
		  datos[0]=rowData.getClass().getTypeName();
		    
		    System.out.println(datos[0]);
		}*/
		
	//	model.addRow(rowData);
		
		
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 513, 360);
		
		
	
	
		
		
		
	}
}
