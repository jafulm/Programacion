package codigo;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;

/**
 * A Swing program demonstrates how to use a custom renderer for all column
 * headers of a JTable component.
 * 
 * @author www.codejava.net
 *
 */
public class JTableHeaderRendererSimple extends JFrame {

	private JTable table;

	public JTableHeaderRendererSimple() {
		super("JTable Column Header Custom Renderer Basic");

		// constructs the table
		String[] columnNames = new String[] { "Title", "Author", "Publisher", "Published Date", "Pages", "Rating" };
		String[][] rowData = new String[][] {
				{ "Effective Java", "Joshua Bloch", "Addision-Wesley", "May 08th 2008", "346", "5" },
				{ "Thinking in Java", "Bruce Eckel", "Prentice Hall", "Feb 26th 2006", "1150", "4" },
				{ "Head First Java", "Kathy Sierra & Bert Bates", "O'Reilly Media", "Feb 09th 2005", "688", "4.5" }, };

		table = new JTable(rowData, columnNames);
	//	table.getTableHeader().setDefaultRenderer(new SimpleHeaderRenderer());

		add(new JScrollPane(table));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(640, 150);
		setLocationRelativeTo(null);
	}

	public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new JTableHeaderRendererSimple().setVisible(true);
            }
        });
    }
}
