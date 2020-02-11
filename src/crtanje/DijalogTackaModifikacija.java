package crtanje;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import crtanje.GlavniPanelCrtanje;
import geometrija.Tacka;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
public class DijalogTackaModifikacija extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel pnlGlavni = new JPanel();
	private JTextField txtX;
	private JTextField txtY;
	private int x;
	private int y;
	Color bojaKonture;
	Tacka tacka ;
	Tacka t1= new Tacka();
	JButton btnBojaKonture;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DijalogTackaModifikacija dialog = new DijalogTackaModifikacija();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Create the dialog.
	 */
	public DijalogTackaModifikacija() {
		setModal(true);
		setTitle("Iliæ Dunja IT48-2016");
		setBounds(100, 100, 320, 226);
		getContentPane().setLayout(new BorderLayout());
		pnlGlavni.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(pnlGlavni, BorderLayout.CENTER);
		GridBagLayout gbl_pnlGlavni = new GridBagLayout();
		gbl_pnlGlavni.columnWidths = new int[]{20, 50, 86, 0};
		gbl_pnlGlavni.rowHeights = new int[]{20, 20, 20, 14, 0};
		gbl_pnlGlavni.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlGlavni.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlGlavni.setLayout(gbl_pnlGlavni);
		{
			JLabel lblX = new JLabel("Unesite x koordinatu:");
			GridBagConstraints gbc_lblX = new GridBagConstraints();
			gbc_lblX.anchor = GridBagConstraints.EAST;
			gbc_lblX.fill = GridBagConstraints.VERTICAL;
			gbc_lblX.insets = new Insets(0, 0, 5, 5);
			gbc_lblX.gridx = 1;
			gbc_lblX.gridy = 1;
			pnlGlavni.add(lblX, gbc_lblX);
		}
		{
			txtX = new JTextField();
			GridBagConstraints gbc_txtX = new GridBagConstraints();
			gbc_txtX.anchor = GridBagConstraints.WEST;
			gbc_txtX.insets = new Insets(0, 0, 5, 0);
			gbc_txtX.gridx = 2;
			gbc_txtX.gridy = 1;
			pnlGlavni.add(txtX, gbc_txtX);
			txtX.setColumns(10);
			txtX.setText("" + ((Tacka) GlavniPanelCrtanje.getSelektovan()).getX());
		}
		{
			JLabel lblY = new JLabel("Unesite y koordinatu:");
			GridBagConstraints gbc_lblY = new GridBagConstraints();
			gbc_lblY.anchor = GridBagConstraints.EAST;
			gbc_lblY.insets = new Insets(0, 0, 5, 5);
			gbc_lblY.gridx = 1;
			gbc_lblY.gridy = 2;
			pnlGlavni.add(lblY, gbc_lblY);
		}
		btnBojaKonture = new JButton("");
		btnBojaKonture.setBackground(((Tacka) GlavniPanelCrtanje.getSelektovan()).getBoja());
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
			txtY = new JTextField();
			GridBagConstraints gbc_txtY = new GridBagConstraints();
			gbc_txtY.anchor = GridBagConstraints.WEST;
			gbc_txtY.insets = new Insets(0, 0, 5, 0);
			gbc_txtY.gridx = 2;
			gbc_txtY.gridy = 2;
			pnlGlavni.add(txtY, gbc_txtY);
			txtY.setColumns(10);
			txtY.setText("" + ((Tacka) GlavniPanelCrtanje.getSelektovan()).getY());
		}
		{
			JLabel lblBojaKonture = new JLabel("Boja konture:");
			GridBagConstraints gbc_lblBojaKonture = new GridBagConstraints();
			gbc_lblBojaKonture.anchor = GridBagConstraints.NORTHWEST;
			gbc_lblBojaKonture.insets = new Insets(0, 0, 0, 5);
			gbc_lblBojaKonture.gridx = 1;
			gbc_lblBojaKonture.gridy = 3;
			pnlGlavni.add(lblBojaKonture, gbc_lblBojaKonture);
		}
		
		GridBagConstraints gbc_btnBojaKonture = new GridBagConstraints();
		gbc_btnBojaKonture.gridx = 2;
		gbc_btnBojaKonture.gridy = 3;
		pnlGlavni.add(btnBojaKonture, gbc_btnBojaKonture);
		{
			System.out.println(((Tacka) GlavniPanelCrtanje.getSelektovan()).getBoja());
		}
		{
			JPanel pnlDugmad = new JPanel();
			pnlDugmad.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(pnlDugmad, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Potvrdi");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							x=Integer.parseInt(txtX.getText());
							y=Integer.parseInt(txtY.getText());
							if (x <= 0 || y<=0 )
							{
								JOptionPane.showMessageDialog(null, "Koordinate moraju da budu pozitivne!");
								System.out.println("Pogrešan unos, koordinate negativne!");
							}
							else {
								tacka= new Tacka (x,y,btnBojaKonture.getBackground());
								setVisible(false);
							}
						} catch (Exception e1) {
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
	public Tacka getPodaci()
	{
		return tacka;
	}
}
