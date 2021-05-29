package bank;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.Font;

public class les_comptes {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void table() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					les_comptes window = new les_comptes();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public les_comptes() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 700, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				labnquecreation nouveau_compte= new labnquecreation();
				nouveau_compte.creerCompte();
			}
		});
		btnAjouter.setFont(new Font("Georgia", Font.BOLD, 16));
		btnAjouter.setBackground(UIManager.getColor("ProgressBar.foreground"));
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setFont(new Font("Georgia", Font.BOLD, 16));
		btnSupprimer.setBackground(UIManager.getColor("ProgressBar.foreground"));
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.setBackground(UIManager.getColor("ProgressBar.foreground"));
		btnModifier.setFont(new Font("Georgia", Font.BOLD, 16));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(80)
					.addComponent(btnAjouter)
					.addGap(82)
					.addComponent(btnSupprimer)
					.addGap(95)
					.addComponent(btnModifier)
					.addContainerGap(104, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(121, Short.MAX_VALUE)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 558, GroupLayout.PREFERRED_SIZE)
					.addGap(87))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(25)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAjouter, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSupprimer)
						.addComponent(btnModifier))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Prenom", "Nom", "DOB", "Sexe", "Adresse", "Numero de Compte", "Type de Compte"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			Class[] columnTypes = new Class[] {
				Object.class, String.class, String.class, String.class, String.class, Integer.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(5).setPreferredWidth(114);
		table.getColumnModel().getColumn(6).setPreferredWidth(98);
		scrollPane.setViewportView(table);
		frame.getContentPane().setLayout(groupLayout);
	}

	public DefaultTableModel getModel() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
