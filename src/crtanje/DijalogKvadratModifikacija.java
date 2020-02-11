package crtanje;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import geometrija.Kvadrat;
import geometrija.Tacka;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
@SuppressWarnings("serial")
public class DijalogKvadratModifikacija extends JDialog {
	private final JPanel pnlKomande = new JPanel();
	private JTextField txtX;
	private JTextField txtY;
	private JTextField txtDuzinaStranice;
	private int x;
	private int y;
	private int duzinaStranice;
	JButton btnBojaKonture;
	JButton btnBojaUnutrasnjosti;
	Kvadrat k1=null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DijalogKvadratModifikacija dialog = new DijalogKvadratModifikacija();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Create the dialog.
	 */
	public DijalogKvadratModifikacija() {
		setModal(true);
		setTitle("Iliæ Dunja IT48-2016");
		setBounds(50, 50, 400, 250);
		getContentPane().setLayout(new BorderLayout());
		pnlKomande.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(pnlKomande, BorderLayout.CENTER);
		GridBagLayout gbl_pnlKomande = new GridBagLayout();
		gbl_pnlKomande.columnWidths = new int[]{20, 100, 70, 80, 0};
		gbl_pnlKomande.rowHeights = new int[]{20, 20, 20, 20, 10, 10, 0};
		gbl_pnlKomande.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlKomande.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlKomande.setLayout(gbl_pnlKomande);
		{
			JLabel lblX = new JLabel("X koordinata taèke gore levo:");
			GridBagConstraints gbc_lblX = new GridBagConstraints();
			gbc_lblX.anchor = GridBagConstraints.WEST;
			gbc_lblX.insets = new Insets(0, 0, 5, 5);
			gbc_lblX.gridx = 1;
			gbc_lblX.gridy = 0;
			pnlKomande.add(lblX, gbc_lblX);
		}
		{
			txtX = new JTextField();
			GridBagConstraints gbc_txtX = new GridBagConstraints();
			gbc_txtX.anchor = GridBagConstraints.NORTH;
			gbc_txtX.insets = new Insets(0, 0, 5, 0);
			gbc_txtX.gridx = 3;
			gbc_txtX.gridy = 0;
			pnlKomande.add(txtX, gbc_txtX);
			txtX.setColumns(10);
			txtX.setText("" + ((Kvadrat)GlavniPanelCrtanje.getSelektovan()).getGoreLevo().getX());
		}
		{
			JLabel lblY = new JLabel("Y koordinata taèke gore levo:");
			GridBagConstraints gbc_lblY = new GridBagConstraints();
			gbc_lblY.anchor = GridBagConstraints.WEST;
			gbc_lblY.insets = new Insets(0, 0, 5, 5);
			gbc_lblY.gridx = 1;
			gbc_lblY.gridy = 1;
			pnlKomande.add(lblY, gbc_lblY);
		}
		{
			txtY = new JTextField();
			GridBagConstraints gbc_txtY = new GridBagConstraints();
			gbc_txtY.anchor = GridBagConstraints.NORTH;
			gbc_txtY.insets = new Insets(0, 0, 5, 0);
			gbc_txtY.gridx = 3;
			gbc_txtY.gridy = 1;
			pnlKomande.add(txtY, gbc_txtY);
			txtY.setColumns(10);
			txtY.setText("" + ((Kvadrat)GlavniPanelCrtanje.getSelektovan()).getGoreLevo().getY());
		}
		{
			JLabel lblDuzinaStranice = new JLabel("Dužina stranice:");
			GridBagConstraints gbc_lblDuzinaStranice = new GridBagConstraints();
			gbc_lblDuzinaStranice.anchor = GridBagConstraints.WEST;
			gbc_lblDuzinaStranice.insets = new Insets(0, 0, 5, 5);
			gbc_lblDuzinaStranice.gridx = 1;
			gbc_lblDuzinaStranice.gridy = 2;
			pnlKomande.add(lblDuzinaStranice, gbc_lblDuzinaStranice);
		}
		{
			txtDuzinaStranice = new JTextField();
			GridBagConstraints gbc_txtDuzinaStranice = new GridBagConstraints();
			gbc_txtDuzinaStranice.anchor = GridBagConstraints.NORTH;
			gbc_txtDuzinaStranice.insets = new Insets(0, 0, 5, 0);
			gbc_txtDuzinaStranice.gridx = 3;
			gbc_txtDuzinaStranice.gridy = 2;
			pnlKomande.add(txtDuzinaStranice, gbc_txtDuzinaStranice);
			txtDuzinaStranice.setColumns(10);
			txtDuzinaStranice.setText(""+((Kvadrat)GlavniPanelCrtanje.getSelektovan()).getDuzinaStranica());
		}
		{
			JLabel lblBojaKonture = new JLabel("Boja konture:");
			GridBagConstraints gbc_lblBojaKonture = new GridBagConstraints();
			gbc_lblBojaKonture.anchor = GridBagConstraints.NORTHWEST;
			gbc_lblBojaKonture.insets = new Insets(0, 0, 5, 5);
			gbc_lblBojaKonture.gridx = 1;
			gbc_lblBojaKonture.gridy = 3;
			pnlKomande.add(lblBojaKonture, gbc_lblBojaKonture);
		}
		{
			 btnBojaKonture = new JButton("");
			 btnBojaKonture.setBackground(((Kvadrat)GlavniPanelCrtanje.getSelektovan()).getBoja());
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
			GridBagConstraints gbc_btnBojaKonture = new GridBagConstraints();
			gbc_btnBojaKonture.insets = new Insets(0, 0, 5, 0);
			gbc_btnBojaKonture.gridx = 3;
			gbc_btnBojaKonture.gridy = 3;
			pnlKomande.add(btnBojaKonture, gbc_btnBojaKonture);
		}
		{
			JLabel lblBojaUnutrasnjosti = new JLabel("Boja unutrašnjosti:");
			GridBagConstraints gbc_lblBojaUnutrasnjosti = new GridBagConstraints();
			gbc_lblBojaUnutrasnjosti.anchor = GridBagConstraints.NORTHWEST;
			gbc_lblBojaUnutrasnjosti.insets = new Insets(0, 0, 0, 5);
			gbc_lblBojaUnutrasnjosti.gridx = 1;
			gbc_lblBojaUnutrasnjosti.gridy = 4;
			pnlKomande.add(lblBojaUnutrasnjosti, gbc_lblBojaUnutrasnjosti);
		}
		{
			 btnBojaUnutrasnjosti = new JButton("");
			 btnBojaUnutrasnjosti.setBackground(((Kvadrat)GlavniPanelCrtanje.getSelektovan()).getBojaUnutrasnjosti());
			 
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
			GridBagConstraints gbc_btnBojaUnutrasnjosti = new GridBagConstraints();
			gbc_btnBojaUnutrasnjosti.gridx = 3;
			gbc_btnBojaUnutrasnjosti.gridy = 4;
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
							duzinaStranice=Integer.parseInt(txtDuzinaStranice.getText());
							if (x<=0 || y<=0 || duzinaStranice<=0 )
							{
								System.out.println("Greška! Negativni brojevi!");
								JOptionPane.showMessageDialog(null, "Greška, brojevi moraju biti pozitivni!");
							}
							else
							{
								setVisible(false);
								k1= new Kvadrat(new Tacka(x,y), duzinaStranice, btnBojaKonture.getBackground(), btnBojaUnutrasnjosti.getBackground());
							}
						} catch (Exception e) {
							System.out.println("Greška pri unosu, nije unet broj!");
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
	public Kvadrat getPodaci()
	{
		return k1;
	}
}
