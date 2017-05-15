package vcvgen;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class VCVGenGUI implements ActionListener{
	
	private static JFrame frame;
	private static JTextField txtConsonants;
	private static JTextField txtVowels;
	private static JTextField txtMaxsyl;
	private static JTextField txtInitoff;
	private static JTextField txtTempo;
	private static JTextField txtMaxdups;
	private static JButton btnGenerate;
	
	public static void main(String[] args){
		VCVGenGUI nya = new VCVGenGUI();
		nya.GWEEE();
	}
	
	public void GWEEE(){
		frame = new JFrame("VCV Generator");
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{235, 0};
		gridBagLayout.rowHeights = new int[]{25, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel.anchor = GridBagConstraints.NORTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		frame.getContentPane().add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0};
		gbl_panel.rowHeights = new int[]{15, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblReclist = new JLabel("Reclist");
		GridBagConstraints gbc_lblReclist = new GridBagConstraints();
		gbc_lblReclist.gridwidth = 2;
		gbc_lblReclist.anchor = GridBagConstraints.NORTH;
		gbc_lblReclist.insets = new Insets(0, 0, 5, 0);
		gbc_lblReclist.gridx = 0;
		gbc_lblReclist.gridy = 0;
		panel.add(lblReclist, gbc_lblReclist);
		
		JLabel lblConsonants = new JLabel("Consonants");
		GridBagConstraints gbc_lblConsonants = new GridBagConstraints();
		gbc_lblConsonants.anchor = GridBagConstraints.WEST;
		gbc_lblConsonants.gridwidth = 2;
		gbc_lblConsonants.insets = new Insets(0, 0, 5, 0);
		gbc_lblConsonants.gridx = 0;
		gbc_lblConsonants.gridy = 1;
		panel.add(lblConsonants, gbc_lblConsonants);
		
		txtConsonants = new JTextField();
		txtConsonants.setText("separated by spaces");
		GridBagConstraints gbc_txtConsonants_1 = new GridBagConstraints();
		gbc_txtConsonants_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtConsonants_1.gridwidth = 2;
		gbc_txtConsonants_1.insets = new Insets(0, 0, 5, 0);
		gbc_txtConsonants_1.gridx = 0;
		gbc_txtConsonants_1.gridy = 2;
		panel.add(txtConsonants, gbc_txtConsonants_1);
		txtConsonants.setColumns(10);
		
		JLabel lblVowels = new JLabel("Vowels");
		GridBagConstraints gbc_lblVowels = new GridBagConstraints();
		gbc_lblVowels.anchor = GridBagConstraints.WEST;
		gbc_lblVowels.gridwidth = 2;
		gbc_lblVowels.insets = new Insets(0, 0, 5, 0);
		gbc_lblVowels.gridx = 0;
		gbc_lblVowels.gridy = 3;
		panel.add(lblVowels, gbc_lblVowels);
		
		txtVowels = new JTextField();
		txtVowels.setText("separated by spaces");
		GridBagConstraints gbc_txtVowels = new GridBagConstraints();
		gbc_txtVowels.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtVowels.gridwidth = 2;
		gbc_txtVowels.insets = new Insets(0, 0, 5, 0);
		gbc_txtVowels.gridx = 0;
		gbc_txtVowels.gridy = 4;
		panel.add(txtVowels, gbc_txtVowels);
		txtVowels.setColumns(10);
		
		JLabel lblMaxsyl = new JLabel("Maximum syllables");
		GridBagConstraints gbc_lblMaxsyl = new GridBagConstraints();
		gbc_lblMaxsyl.anchor = GridBagConstraints.WEST;
		gbc_lblMaxsyl.insets = new Insets(0, 0, 5, 5);
		gbc_lblMaxsyl.gridx = 0;
		gbc_lblMaxsyl.gridy = 5;
		panel.add(lblMaxsyl, gbc_lblMaxsyl);
		
		txtMaxsyl = new JTextField();
		GridBagConstraints gbc_txtMaxsyl = new GridBagConstraints();
		gbc_txtMaxsyl.insets = new Insets(0, 0, 5, 0);
		gbc_txtMaxsyl.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtMaxsyl.gridx = 1;
		gbc_txtMaxsyl.gridy = 5;
		panel.add(txtMaxsyl, gbc_txtMaxsyl);
		txtMaxsyl.setColumns(10);
		
		JLabel lblOto = new JLabel("OTO");
		GridBagConstraints gbc_lblOto = new GridBagConstraints();
		gbc_lblOto.insets = new Insets(0, 0, 5, 0);
		gbc_lblOto.gridwidth = 2;
		gbc_lblOto.anchor = GridBagConstraints.NORTH;
		gbc_lblOto.gridx = 0;
		gbc_lblOto.gridy = 6;
		panel.add(lblOto, gbc_lblOto);
		
		JLabel lblInitoff = new JLabel("Initial offset");
		GridBagConstraints gbc_lblInitoff = new GridBagConstraints();
		gbc_lblInitoff.anchor = GridBagConstraints.WEST;
		gbc_lblInitoff.insets = new Insets(0, 0, 5, 5);
		gbc_lblInitoff.gridx = 0;
		gbc_lblInitoff.gridy = 7;
		panel.add(lblInitoff, gbc_lblInitoff);
		
		txtInitoff = new JTextField();
		GridBagConstraints gbc_txtInitoff = new GridBagConstraints();
		gbc_txtInitoff.insets = new Insets(0, 0, 5, 0);
		gbc_txtInitoff.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtInitoff.gridx = 1;
		gbc_txtInitoff.gridy = 7;
		panel.add(txtInitoff, gbc_txtInitoff);
		txtInitoff.setColumns(10);
		
		JLabel lblTempo = new JLabel("Tempo");
		GridBagConstraints gbc_lblTempo = new GridBagConstraints();
		gbc_lblTempo.anchor = GridBagConstraints.WEST;
		gbc_lblTempo.insets = new Insets(0, 0, 5, 5);
		gbc_lblTempo.gridx = 0;
		gbc_lblTempo.gridy = 8;
		panel.add(lblTempo, gbc_lblTempo);
		
		txtTempo = new JTextField();
		GridBagConstraints gbc_txtTempo = new GridBagConstraints();
		gbc_txtTempo.insets = new Insets(0, 0, 5, 0);
		gbc_txtTempo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTempo.gridx = 1;
		gbc_txtTempo.gridy = 8;
		panel.add(txtTempo, gbc_txtTempo);
		txtTempo.setColumns(10);
		
		JLabel lblMaxdups = new JLabel("Maximum duplicates");
		GridBagConstraints gbc_lblMaxdups = new GridBagConstraints();
		gbc_lblMaxdups.anchor = GridBagConstraints.WEST;
		gbc_lblMaxdups.insets = new Insets(0, 0, 5, 5);
		gbc_lblMaxdups.gridx = 0;
		gbc_lblMaxdups.gridy = 9;
		panel.add(lblMaxdups, gbc_lblMaxdups);
		
		txtMaxdups = new JTextField();
		GridBagConstraints gbc_txtMaxdups = new GridBagConstraints();
		gbc_txtMaxdups.insets = new Insets(0, 0, 5, 0);
		gbc_txtMaxdups.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtMaxdups.gridx = 1;
		gbc_txtMaxdups.gridy = 9;
		panel.add(txtMaxdups, gbc_txtMaxdups);
		txtMaxdups.setColumns(10);
		
		btnGenerate = new JButton("Generate");
		GridBagConstraints gbc_btnGenerate = new GridBagConstraints();
		gbc_btnGenerate.gridwidth = 2;
		gbc_btnGenerate.insets = new Insets(0, 0, 0, 5);
		gbc_btnGenerate.gridx = 0;
		gbc_btnGenerate.gridy = 10;
		panel.add(btnGenerate, gbc_btnGenerate);
		
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		btnGenerate.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e) { 
		if (e.getSource() == btnGenerate){
			String cons = txtConsonants.getText();
			String vows = txtVowels.getText();
			int syls = Integer.parseInt(txtMaxsyl.getText());
			int off = Integer.parseInt(txtInitoff.getText());
			int tempo = Integer.parseInt(txtTempo.getText());
			int dups = Integer.parseInt(txtMaxdups.getText());
			
			if (syls < 2){
				JOptionPane.showMessageDialog(null, "Invalid number of syllables", "VCV Generator", JOptionPane.ERROR_MESSAGE);
			} else if (tempo < 1){
				JOptionPane.showMessageDialog(null, "Invalid tempo", "VCV Generator", JOptionPane.ERROR_MESSAGE);
			}else {
				VCVGenerator.reclist(cons,vows,syls);
				VCVGenerator.oto(off, tempo, dups);
				
				JOptionPane.showMessageDialog(null, "Done.", "VCV Generator", JOptionPane.INFORMATION_MESSAGE);
			 	frame.dispose();
			}
		}
	}
}
