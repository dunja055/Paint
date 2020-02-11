package crtanje;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import geometrija.Pravougaonik;
@SuppressWarnings("serial")
public class DijalogPravougaonikCrtanje extends JDialog {
	private final JPanel pnlDijalog = new JPanel();
	private JTextField txtVisina;
	private JTextField txtSirina;
	protected int sirina;
	protected int visina;
	Pravougaonik pravougaonik=null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DijalogPravougaonikCrtanje dialog = new DijalogPravougaonikCrtanje();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Create the dialog.
	 */
	public DijalogPravougaonikCrtanje() {
		setModal(true);
		setTitle("Iliæ Dunja IT48-2016");
		setBounds(100, 100, 350, 220);
		getContentPane().setLayout(new BorderLayout());
		pnlDijalog.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(pnlDijalog, BorderLayout.CENTER);
		GridBagLayout gbl_pnlDijalog = new GridBagLayout();
		gbl_pnlDijalog.columnWidths = new int[]{20, 80, 70, 100, 0};
		gbl_pnlDijalog.rowHeights = new int[]{20, 20, 20, 20, 20, 0, 0};
		gbl_pnlDijalog.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlDijalog.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlDijalog.setLayout(gbl_pnlDijalog);
		{
			JLabel lblVisina = new JLabel("Visina:");
			GridBagConstraints gbc_lblVisina = new GridBagConstraints();
			gbc_lblVisina.fill = GridBagConstraints.HORIZONTAL;
			gbc_lblVisina.insets = new Insets(0, 0, 5, 5);
			gbc_lblVisina.gridx = 1;
			gbc_lblVisina.gridy = 1;
			pnlDijalog.add(lblVisina, gbc_lblVisina);
		}
		{
			txtVisina = new JTextField();
			GridBagConstraints gbc_txtVisina = new GridBagConstraints();
			gbc_txtVisina.anchor = GridBagConstraints.NORTHWEST;
			gbc_txtVisina.insets = new Insets(0, 0, 5, 5);
			gbc_txtVisina.gridx = 2;
			gbc_txtVisina.gridy = 1;
			pnlDijalog.add(txtVisina, gbc_txtVisina);
			txtVisina.setColumns(10);
		}
		{
			JLabel lblSirina = new JLabel("Sirina:");
			GridBagConstraints gbc_lblSirina = new GridBagConstraints();
			gbc_lblSirina.anchor = GridBagConstraints.NORTH;
			gbc_lblSirina.fill = GridBagConstraints.HORIZONTAL;
			gbc_lblSirina.insets = new Insets(0, 0, 5, 5);
			gbc_lblSirina.gridx = 1;
			gbc_lblSirina.gridy = 2;
			pnlDijalog.add(lblSirina, gbc_lblSirina);
		}
		{
			txtSirina = new JTextField();
			GridBagConstraints gbc_txtSirina = new GridBagConstraints();
			gbc_txtSirina.insets = new Insets(0, 0, 5, 5);
			gbc_txtSirina.anchor = GridBagConstraints.SOUTHWEST;
			gbc_txtSirina.gridx = 2;
			gbc_txtSirina.gridy = 2;
			pnlDijalog.add(txtSirina, gbc_txtSirina);
			txtSirina.setColumns(10);
		}
		{
			JPanel btnDugmad = new JPanel();
			btnDugmad.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(btnDugmad, BorderLayout.SOUTH);
			{
				JButton btnPotvrdi = new JButton("Potvrdi");
				btnPotvrdi.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try{
							visina=Integer.parseInt(txtVisina.getText());
							sirina=Integer.parseInt(txtSirina.getText());
						if ( visina <= 0 || sirina <=0 )
						{
							System.out.println("Greška! Broj mora biti pozitivan!");
							JOptionPane.showMessageDialog(null, "Greška! Broj mora biti pozitivan!");
						}
						else
						{
							setVisible(false);
						}
						} catch (Exception e1) {
							System.out.println("Greška pri unosu nije unet broj!");
							JOptionPane.showMessageDialog(null, "Greška, pri unosu nije unet broj!");
						}
					}
				});
				btnPotvrdi.setActionCommand("OK");
				btnDugmad.add(btnPotvrdi);
				getRootPane().setDefaultButton(btnPotvrdi);
			}
		}
	}
	public int  getSirina ()
	{
		return sirina;
	}
	public int getDuzina()
	{
		return visina;
	}
}
