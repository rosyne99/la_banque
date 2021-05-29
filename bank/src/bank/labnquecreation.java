package bank;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.awt.event.ActionEvent;

public class labnquecreation {

	private JFrame frame;
	private JTextField txtnom;
	private JTextField txtprenom;
	private JTextField txtdob;
	private JTextField txtsexe;
	private JTextField txtadresse;
	private JTextField txtcompte;

	/**
	 * Launch the application.
	 */
	public static void creerCompte() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					labnquecreation window = new labnquecreation();
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
	public labnquecreation() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100,450, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblCreezUnNouveau = new JLabel("Creez un nouveau compte");
		lblCreezUnNouveau.setForeground(SystemColor.textHighlight);
		lblCreezUnNouveau.setFont(new Font("Microsoft JhengHei", Font.BOLD, 26));
		
		JLabel nom = new JLabel("Nom");
		nom.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 20));
		
		txtnom = new JTextField();
		txtnom.setColumns(10);
		
		JLabel prenom = new JLabel("Prenom");
		prenom.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 20));
		
		txtprenom = new JTextField();
		txtprenom.setColumns(10);
		
		JLabel dob = new JLabel("DOB");
		dob.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 20));
		
		txtdob = new JTextField();
		txtdob.setColumns(10);
		
		JLabel sexe = new JLabel("Sexe");
		sexe.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 20));
		
		txtsexe = new JTextField();
		txtsexe.setColumns(10);
		
		JLabel adresse = new JLabel("Adresse");
		adresse.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 20));
		
		txtadresse = new JTextField();
		txtadresse.setColumns(10);
		
		JLabel lblNumeroDeCompte = new JLabel("Numero de compte");
		lblNumeroDeCompte.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 20));
		
		txtcompte = new JTextField();
		txtcompte.setColumns(10);
		
		JLabel lblTypeDeCompte = new JLabel("Type De Compte");
		lblTypeDeCompte.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 20));
		
		JComboBox txtcombo = new JComboBox();
		txtcombo.setModel(new DefaultComboBoxModel(new String[] {"Courant", "Joint", "Epargne"}));
		txtcombo.setBackground(SystemColor.text);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtnom.setText("");
				txtprenom.setText("");							
				txtdob.setText("");
				txtsexe.setText("");
				txtadresse .setText("");
				
				txtcompte.setText("");
				
				
			}
		});
		btnClear.setBackground(SystemColor.textHighlight);
		btnClear.setFont(new Font("Georgia", Font.BOLD, 16));
		
		JButton btnSauvegarder = new JButton("Sauvegarder");
		btnSauvegarder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Nom= txtnom.getText().toString();
				String Prenom= txtprenom.getText().toString();
				String Sexe= txtsexe.getText().toString();
				String Adresse= txtadresse.getText().toString();
				String DOB= txtdob.getText().toString();
				String Typedecompte= txtcompte.getText().toString();
				
				
				try {
					FileWriter writer= new FileWriter("comptes.txt", true);
					writer.write("Voici le resultats");
					writer.write(Nom);
					writer.write("");
					writer.write(Prenom);
					writer.write("");
					
					writer.write(Sexe);
					writer.write("");
					writer.write(Adresse);
					writer.write("");
					writer.write(Typedecompte);
					writer.write("");
					writer.write(DOB);
					
					writer.close();
					final JFrame myFrame = new JFrame();
					JOptionPane.showMessageDialog(myFrame, 
							  "Good", "top", JOptionPane.ERROR_MESSAGE);
				}
				
				catch(Exception error){
					final JFrame myFrame = new JFrame();
					JOptionPane.showMessageDialog(myFrame, 
							  "ErrorMsg", "Failure", JOptionPane.ERROR_MESSAGE);
				}
				
				les_comptes n= new les_comptes();
				
				DefaultTableModel model= (DefaultTableModel) n.getModel();
				model.addRow(new Object[]{
						txtnom.getText(),
						txtprenom.getText(),
						txtdob.getText(),
						txtsexe.getText(),
						txtadresse.getText(),
						txtcombo.getSelectedItem(),
						txtcompte.getText()
						
					
				});
				
			}
		});
		btnSauvegarder.setBackground(SystemColor.textHighlight);
		btnSauvegarder.setFont(new Font("Georgia", Font.BOLD, 16));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(90)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(nom)
						.addComponent(prenom)
						.addComponent(dob)
						.addComponent(sexe)
						.addComponent(adresse))
					.addPreferredGap(ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(txtadresse, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtsexe, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtdob, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtprenom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtnom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(102))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(54, Short.MAX_VALUE)
					.addComponent(lblCreezUnNouveau)
					.addGap(51))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(35)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblTypeDeCompte)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addComponent(btnClear)
							.addComponent(lblNumeroDeCompte)))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addComponent(txtcombo, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(txtcompte))
						.addComponent(btnSauvegarder))
					.addContainerGap(102, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblCreezUnNouveau)
					.addGap(36)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(nom)
						.addComponent(txtnom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(prenom)
						.addComponent(txtprenom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(dob)
						.addComponent(txtdob, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(sexe)
						.addComponent(txtsexe, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(adresse)
						.addComponent(txtadresse, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNumeroDeCompte)
						.addComponent(txtcompte, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(31)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblTypeDeCompte)
						.addComponent(txtcombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnClear)
						.addComponent(btnSauvegarder))
					.addGap(23))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
