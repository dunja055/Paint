package crtanje;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import geometrija.Krug;
import geometrija.Tacka;
@SuppressWarnings("serial")
public class DijalogKrugModifikacija extends JDialog {
	private final JPanel pnlKomande = new JPanel();
	private JTextField txtX;
	private JTextField txtY;
	private JTextField txtPoluprecnik;
	private int x;
	private int y;
	private int poluprecnik;
	private JButton btnBojaKonture;
	private JButton btnBojaUnutrasnjosti;
	Krug k=null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DijalogKrugModifikacija dialog = new DijalogKrugModifikacija();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Create the dialog.
	 */
	public DijalogKrugModifikacija() {
		setModal(true);
		setBounds(50, 50, 350, 250);
		setTitle("Iliæ Dunja IT48-2016");
		getContentPane().setLayout(new BorderLayout());
		pnlKomande.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(pnlKomande, BorderLayout.CENTER);
		GridBagLayout gbl_pnlKomande = new GridBagLayout();
		gbl_pnlKomande.columnWidths = new int[]{20, 100, 70, 80, 0};
		gbl_pnlKomande.rowHeights = new int[]{20, 20, 0, 0, 0, 0, 0};
		gbl_pnlKomande.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlKomande.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlKomande.setLayout(gbl_pnlKomande);
		{
			 btnBojaKonture = new JButton("");
			 btnBojaKonture.setBackground(((Krug)GlavniPanelCrtanje.getSelektovan()).getBoja());
			 btnBojaKonture.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						final JColorChooser colorChooser = new JColorChooser(Color.black);

					    ActionListener okActionListener = new ActionListener() {
					      public void actionPerformed(ActionEvent actionEvent) {
					    	  btnBojaKonture.setBackground(colorChooser.getColor());
					      }
					    };

					    ActionListener cancelActionListener = new ActionListener() {
					      public void actionPerformed(ActionEvent actionEvent) {
					        
					      }
					    };

					    final JDialog dialog = JColorChooser.createDialog(null, "Izaberi boju", true,
					        colorChooser, okActionListener, cancelActionListener);

					    dialog.setVisible(true);
						
						
					}
				});
			 	
			{
				JLabel lblX = new JLabel("X koordinata centra:");
				GridBagConstraints gbc_lblX = new GridBagConstraints();
				gbc_lblX.anchor = GridBagConstraints.WEST;
				gbc_lblX.insets = new Insets(0, 0, 5, 5);
				gbc_lblX.gridx = 1;
				gbc_lblX.gridy = 1;
				pnlKomande.add(lblX, gbc_lblX);
			}
			{
				txtX = new JTextField();
				GridBagConstraints gbc_txtX = new GridBagConstraints();
				gbc_txtX.anchor = GridBagConstraints.NORTH;
				gbc_txtX.insets = new Insets(0, 0, 5, 0);
				gbc_txtX.gridx = 3;
				gbc_txtX.gridy = 1;
				pnlKomande.add(txtX, gbc_txtX);
				txtX.setColumns(10);
				txtX.setText(""+ ((Krug)GlavniPanelCrtanje.getSelektovan()).getCentar().getX());
			}
			{
				JLabel lblY = new JLabel("Y koordinata centra:");
				GridBagConstraints gbc_lblY = new GridBagConstraints();
				gbc_lblY.anchor = GridBagConstraints.WEST;
				gbc_lblY.insets = new Insets(0, 0, 5, 5);
				gbc_lblY.gridx = 1;
				gbc_lblY.gridy = 2;
				pnlKomande.add(lblY, gbc_lblY);
			}
			{
				txtY = new JTextField();
				GridBagConstraints gbc_txtY = new GridBagConstraints();
				gbc_txtY.anchor = GridBagConstraints.NORTH;
				gbc_txtY.insets = new Insets(0, 0, 5, 0);
				gbc_txtY.gridx = 3;
				gbc_txtY.gridy = 2;
				pnlKomande.add(txtY, gbc_txtY);
				txtY.setColumns(10);
				txtY.setText("" + ((Krug)GlavniPanelCrtanje.getSelektovan()).getCentar().getY());
			}
			{
				JLabel lblPoluprecnik = new JLabel("Polupreènik:");
				GridBagConstraints gbc_lblPoluprecnik = new GridBagConstraints();
				gbc_lblPoluprecnik.anchor = GridBagConstraints.WEST;
				gbc_lblPoluprecnik.insets = new Insets(0, 0, 5, 5);
				gbc_lblPoluprecnik.gridx = 1;
				gbc_lblPoluprecnik.gridy = 3;
				pnlKomande.add(lblPoluprecnik, gbc_lblPoluprecnik);
			}
			{
				txtPoluprecnik = new JTextField();
				GridBagConstraints gbc_txtPoluprecnik = new GridBagConstraints();
				gbc_txtPoluprecnik.anchor = GridBagConstraints.NORTH;
				gbc_txtPoluprecnik.insets = new Insets(0, 0, 5, 0);
				gbc_txtPoluprecnik.gridx = 3;
				gbc_txtPoluprecnik.gridy = 3;
				pnlKomande.add(txtPoluprecnik, gbc_txtPoluprecnik);
				txtPoluprecnik.setColumns(10);
				txtPoluprecnik.setText("" + ((Krug)GlavniPanelCrtanje.getSelektovan()).getR());
			}
			{
				JLabel lblBojaKonture = new JLabel("Boja konture:");
				GridBagConstraints gbc_lblBojaKonture = new GridBagConstraints();
				gbc_lblBojaKonture.anchor = GridBagConstraints.NORTHWEST;
				gbc_lblBojaKonture.insets = new Insets(0, 0, 5, 5);
				gbc_lblBojaKonture.gridx = 1;
				gbc_lblBojaKonture.gridy = 4;
				pnlKomande.add(lblBojaKonture, gbc_lblBojaKonture);
			}
			GridBagConstraints gbc_btnBojaKonture = new GridBagConstraints();
			gbc_btnBojaKonture.insets = new Insets(0, 0, 5, 0);
			gbc_btnBojaKonture.gridx = 3;
			gbc_btnBojaKonture.gridy = 4;
			pnlKomande.add(btnBojaKonture, gbc_btnBojaKonture);
		}
		{
			 btnBojaUnutrasnjosti = new JButton("");
			 btnBojaUnutrasnjosti.setBackground(((Krug)GlavniPanelCrtanje.getSelektovan()).getBojaUnutrasnjosti());
			 btnBojaUnutrasnjosti.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						final JColorChooser colorChooser = new JColorChooser(Color.black);

					    ActionListener okActionListener = new ActionListener() {
					      public void actionPerformed(ActionEvent actionEvent) {
								btnBojaUnutrasnjosti.setBackground(colorChooser.getColor());
					      }
					    };

					    
					    ActionListener cancelActionListener = new ActionListener() {
					      public void actionPerformed(ActionEvent actionEvent) {
					       
					      }
					    };

					    final JDialog dialog = JColorChooser.createDialog(null, "Izaberi boju", true,
					        colorChooser, okActionListener, cancelActionListener);

					    dialog.setVisible(true);
						
						
					}
				});
			{
				JLabel lblBojaUnutrasnjosti = new JLabel("Boja unutrašnjosti:");
				GridBagConstraints gbc_lblBojaUnutrasnjosti = new GridBagConstraints();
				gbc_lblBojaUnutrasnjosti.anchor = GridBagConstraints.NORTHWEST;
				gbc_lblBojaUnutrasnjosti.insets = new Insets(0, 0, 0, 5);
				gbc_lblBojaUnutrasnjosti.gridx = 1;
				gbc_lblBojaUnutrasnjosti.gridy = 5;
				pnlKomande.add(lblBojaUnutrasnjosti, gbc_lblBojaUnutrasnjosti);
			}
			GridBagConstraints gbc_btnBojaUnutrasnjosti = new GridBagConstraints();
			gbc_btnBojaUnutrasnjosti.gridx = 3;
			gbc_btnBojaUnutrasnjosti.gridy = 5;
			pnlKomande.add(btnBojaUnutrasnjosti, gbc_btnBojaUnutrasnjosti);
		}
		{
			JPanel pnlDugmad = new JPanel();
			pnlDugmad.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(pnlDugmad, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Potvrdi");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						try{
							x=Integer.parseInt(txtX.getText());
							y=Integer.parseInt(txtY.getText());
							poluprecnik=Integer.parseInt(txtPoluprecnik.getText());
							if (x <=0 || y<=0 || poluprecnik<=0)
							{
								JOptionPane.showMessageDialog(null, "Greška, brojevi moraju da budu pozitivni!");
							}
							else{
								setVisible(false);
								k= new Krug(new Tacka (x,y), poluprecnik, btnBojaKonture.getBackground(), btnBojaUnutrasnjosti.getBackground());
							}
						} catch (Exception e) {
							System.out.println("Greška, nije unet broj!");
							JOptionPane.showMessageDialog(null, "Greška, nije unet broj!");
						}
					}
				});
				okButton.setActionCommand("OK");
				pnlDugmad.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}
	public Krug getPodaci()
	{
		return k;
	}
	
}
