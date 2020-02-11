package crtanje;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
@SuppressWarnings("serial")
public class DijalogKvadrataCrtanje extends JDialog {
	private final JPanel pnlGlavni = new JPanel();
	private JTextField txtDuzinaStranice;
	private int duzinaStranice;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DijalogKvadrataCrtanje dialog = new DijalogKvadrataCrtanje();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Create the dialog.
	 */
	public DijalogKvadrataCrtanje() {
		setTitle("Iliæ Dunja IT48-2016");
		setModal(true);
		setBounds(100, 100, 350, 150);
		getContentPane().setLayout(new BorderLayout());
		pnlGlavni.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(pnlGlavni, BorderLayout.CENTER);
		GridBagLayout gbl_pnlGlavni = new GridBagLayout();
		gbl_pnlGlavni.columnWidths = new int[]{20, 0, 0, 0};
		gbl_pnlGlavni.rowHeights = new int[]{20, 0};
		gbl_pnlGlavni.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlGlavni.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		pnlGlavni.setLayout(gbl_pnlGlavni);
		{
			JLabel lblDuzinaStranice = new JLabel("Dužina stranice");
			GridBagConstraints gbc_lblDuzinaStranice = new GridBagConstraints();
			gbc_lblDuzinaStranice.anchor = GridBagConstraints.SOUTHEAST;
			gbc_lblDuzinaStranice.insets = new Insets(0, 0, 0, 5);
			gbc_lblDuzinaStranice.gridx = 1;
			gbc_lblDuzinaStranice.gridy = 0;
			pnlGlavni.add(lblDuzinaStranice, gbc_lblDuzinaStranice);
		}
		{
			txtDuzinaStranice = new JTextField();
			GridBagConstraints gbc_txtDuzinaStranice = new GridBagConstraints();
			gbc_txtDuzinaStranice.anchor = GridBagConstraints.WEST;
			gbc_txtDuzinaStranice.fill = GridBagConstraints.VERTICAL;
			gbc_txtDuzinaStranice.gridx = 2;
			gbc_txtDuzinaStranice.gridy = 0;
			pnlGlavni.add(txtDuzinaStranice, gbc_txtDuzinaStranice);
			txtDuzinaStranice.setColumns(10);
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
							duzinaStranice=Integer.parseInt(txtDuzinaStranice.getText());
							if (duzinaStranice <= 0)
							{
								System.out.println("Dužina stranice mora biti pozitivna!");
								JOptionPane.showMessageDialog(null, "Dužina stranice mora biti pozitivna!");
							}
							else
							{
								setVisible(false);
							}
						} catch (Exception e1) {
							System.out.println("Nije unet broj!");
							JOptionPane.showMessageDialog(null, "Mora broj da se unese!");
						}
					}
				});
				okButton.setActionCommand("OK");
				pnlDugmad.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}
	public int getDuzinaStranice()
	{
		return duzinaStranice;
	}
}
