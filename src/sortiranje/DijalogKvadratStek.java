package sortiranje;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import geometrija.Kvadrat;
import geometrija.Tacka;

@SuppressWarnings("serial")
public class DijalogKvadratStek extends JDialog {
	private JTextField txtX;
	private JTextField txtY;
	private JTextField txtDuzinaIviceKvadrata;
	public int x;
	public int y;
	public int duzinaIviceKvadrata;
	public String bojaIvice;
	public String bojaUnutrasnjosti;
	
	
	boolean dugmeOK=false;
	Kvadrat k = null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DijalogKvadratStek dialog = new DijalogKvadratStek();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public DijalogKvadratStek() {

		setModal(true);
		setTitle("Iliæ Dunja IT48-2016");
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{185, 83, 79, 67, 0};
		gridBagLayout.rowHeights = new int[]{20, 23, 20, 20, 20, 10, 56, 23, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
				
						JLabel lblX = new JLabel("X koordinata taèke gore levo:");
						GridBagConstraints gbc_lblX = new GridBagConstraints();
						gbc_lblX.anchor = GridBagConstraints.EAST;
						gbc_lblX.insets = new Insets(0, 0, 5, 5);
						gbc_lblX.gridx = 0;
						gbc_lblX.gridy = 0;
						getContentPane().add(lblX, gbc_lblX);
								
										txtX = new JTextField();
										GridBagConstraints gbc_txtX = new GridBagConstraints();
										gbc_txtX.anchor = GridBagConstraints.NORTH;
										gbc_txtX.insets = new Insets(0, 0, 5, 0);
										gbc_txtX.gridwidth = 2;
										gbc_txtX.gridx = 2;
										gbc_txtX.gridy = 0;
										getContentPane().add(txtX, gbc_txtX);
										txtX.setColumns(10);
						
							
								JLabel lblY = new JLabel("Y koordinata taèke gore levo:");
								GridBagConstraints gbc_lblY = new GridBagConstraints();
								gbc_lblY.anchor = GridBagConstraints.NORTHEAST;
								gbc_lblY.insets = new Insets(0, 0, 5, 5);
								gbc_lblY.gridx = 0;
								gbc_lblY.gridy = 1;
								getContentPane().add(lblY, gbc_lblY);
				
						txtY = new JTextField();
						GridBagConstraints gbc_txtY = new GridBagConstraints();
						gbc_txtY.anchor = GridBagConstraints.SOUTH;
						gbc_txtY.insets = new Insets(0, 0, 5, 0);
						gbc_txtY.gridwidth = 2;
						gbc_txtY.gridx = 2;
						gbc_txtY.gridy = 1;
						getContentPane().add(txtY, gbc_txtY);
						txtY.setColumns(10);
		
				JLabel lblDuzinaIviceKvadrata = new JLabel("Dužina ivice kvadrata:");
				GridBagConstraints gbc_lblDuzinaIviceKvadrata = new GridBagConstraints();
				gbc_lblDuzinaIviceKvadrata.anchor = GridBagConstraints.EAST;
				gbc_lblDuzinaIviceKvadrata.insets = new Insets(0, 0, 5, 5);
				gbc_lblDuzinaIviceKvadrata.gridx = 0;
				gbc_lblDuzinaIviceKvadrata.gridy = 2;
				getContentPane().add(lblDuzinaIviceKvadrata, gbc_lblDuzinaIviceKvadrata);
		
				txtDuzinaIviceKvadrata = new JTextField();
				GridBagConstraints gbc_txtDuzinaIviceKvadrata = new GridBagConstraints();
				gbc_txtDuzinaIviceKvadrata.anchor = GridBagConstraints.NORTH;
				gbc_txtDuzinaIviceKvadrata.insets = new Insets(0, 0, 5, 0);
				gbc_txtDuzinaIviceKvadrata.gridwidth = 2;
				gbc_txtDuzinaIviceKvadrata.gridx = 2;
				gbc_txtDuzinaIviceKvadrata.gridy = 2;
				getContentPane().add(txtDuzinaIviceKvadrata, gbc_txtDuzinaIviceKvadrata);
				txtDuzinaIviceKvadrata.setColumns(10);
		
				JLabel lblBojaIvice = new JLabel("Boja ivice:");
				GridBagConstraints gbc_lblBojaIvice = new GridBagConstraints();
				gbc_lblBojaIvice.anchor = GridBagConstraints.EAST;
				gbc_lblBojaIvice.insets = new Insets(0, 0, 5, 5);
				gbc_lblBojaIvice.gridx = 0;
				gbc_lblBojaIvice.gridy = 3;
				getContentPane().add(lblBojaIvice, gbc_lblBojaIvice);
		
		JComboBox cbxBojaIvice = new JComboBox();
		cbxBojaIvice.setModel(new DefaultComboBoxModel(new String[] {"Crna", "Plava", "Zuta", "Ljubicasta", "Crvena", "Zelena", "Roza"}));
		GridBagConstraints gbc_cbxBojaIvice = new GridBagConstraints();
		gbc_cbxBojaIvice.anchor = GridBagConstraints.NORTH;
		gbc_cbxBojaIvice.insets = new Insets(0, 0, 5, 5);
		gbc_cbxBojaIvice.gridx = 2;
		gbc_cbxBojaIvice.gridy = 3;
		getContentPane().add(cbxBojaIvice, gbc_cbxBojaIvice);
		
				JLabel lblBojaUnutrasnjosti = new JLabel("Boja unutrašnjosti:");
				GridBagConstraints gbc_lblBojaUnutrasnjosti = new GridBagConstraints();
				gbc_lblBojaUnutrasnjosti.anchor = GridBagConstraints.EAST;
				gbc_lblBojaUnutrasnjosti.insets = new Insets(0, 0, 5, 5);
				gbc_lblBojaUnutrasnjosti.gridx = 0;
				gbc_lblBojaUnutrasnjosti.gridy = 4;
				getContentPane().add(lblBojaUnutrasnjosti, gbc_lblBojaUnutrasnjosti);
		
		JComboBox cbxBojaUnutrasnjosti = new JComboBox();
		cbxBojaUnutrasnjosti.setModel(new DefaultComboBoxModel(new String[] {"Bela", "Crna", "Plava", "Roza", "Ljubicasta", "Zuta", "Zelena"}));
		GridBagConstraints gbc_cbxBojaUnutrasnjosti = new GridBagConstraints();
		gbc_cbxBojaUnutrasnjosti.anchor = GridBagConstraints.NORTH;
		gbc_cbxBojaUnutrasnjosti.insets = new Insets(0, 0, 5, 5);
		gbc_cbxBojaUnutrasnjosti.gridx = 2;
		gbc_cbxBojaUnutrasnjosti.gridy = 4;
		getContentPane().add(cbxBojaUnutrasnjosti, gbc_cbxBojaUnutrasnjosti);
		{
			JPanel pnlDugmad = new JPanel();
			pnlDugmad.setLayout(new FlowLayout(FlowLayout.RIGHT));
			GridBagConstraints gbc_pnlDugmad = new GridBagConstraints();
			gbc_pnlDugmad.anchor = GridBagConstraints.NORTH;
			gbc_pnlDugmad.fill = GridBagConstraints.HORIZONTAL;
			gbc_pnlDugmad.insets = new Insets(0, 0, 5, 0);
			gbc_pnlDugmad.gridwidth = 4;
			gbc_pnlDugmad.gridx = 0;
			gbc_pnlDugmad.gridy = 5;
			getContentPane().add(pnlDugmad, gbc_pnlDugmad);
		}
		{
			JButton btnPotvrdi = new JButton("Potvrdi");
			GridBagConstraints gbc_btnPotvrdi = new GridBagConstraints();
			gbc_btnPotvrdi.anchor = GridBagConstraints.NORTHEAST;
			gbc_btnPotvrdi.gridx = 3;
			gbc_btnPotvrdi.gridy = 7;
			getContentPane().add(btnPotvrdi, gbc_btnPotvrdi);
			btnPotvrdi.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {


					try{
						
						x=Integer.parseInt(txtX.getText());
						y=Integer.parseInt(txtY.getText());
						duzinaIviceKvadrata=Integer.parseInt(txtDuzinaIviceKvadrata.getText());
						bojaIvice=(String)cbxBojaIvice.getSelectedItem();
						bojaUnutrasnjosti=(String)cbxBojaUnutrasnjosti.getSelectedItem();
						
						
						
						if(x <= 0 || y <= 0 || duzinaIviceKvadrata<= 0){
							System.out.println("Greška! Broj mora biti pozitivan!");
							JOptionPane.showMessageDialog(null, "Greška! Broj mora biti pozitivan!");
						}else{
							System.out.println(bojaIvice);
							k = new Kvadrat(new Tacka(Integer.parseInt(txtX.getText()), Integer.parseInt(txtY.getText())), Integer.parseInt(txtDuzinaIviceKvadrata.getText()),bojaIvice,bojaUnutrasnjosti);
							setVisible(false);
						}

						
						
					}catch(Exception e){ 
						System.out.println("Greška! Broj nije unet!");
						JOptionPane.showMessageDialog(null, "Greška! Broj nije unet!");
					}



				}
			});
			btnPotvrdi.setActionCommand("OK");
			getRootPane().setDefaultButton(btnPotvrdi);


		}
		setBounds(100, 100, 450, 300);
		
		
		
		




	}
	
	public Kvadrat getPodaci(){

		System.out.println("Podaci");
	
		
		return k;
	}
}
