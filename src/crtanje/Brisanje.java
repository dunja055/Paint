package crtanje;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
@SuppressWarnings("serial")
public class Brisanje extends JDialog {
	/**
	 * 
	 */
	private final JPanel contentPanel = new JPanel();
	private int n=0;
	JButton btnDa;
	JButton btnNe;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Brisanje dialog = new Brisanje();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Create the dialog.
	 */
	public Brisanje() {
		setTitle("Iliæ Dunja IT48-2016");
		setModal(true);
		setBounds(100, 100, 385, 217);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{41, 107, 33, 122, 0};
		gbl_contentPanel.rowHeights = new int[]{14, 33, 23, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			 btnNe = new JButton("Ne");
			btnNe.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					n=2;
					setVisible(false);
				}
			});
			{
				JLabel lblPoruka = new JLabel("Da li ste sigurni da zelite da se obriše selektovani oblik?");
				GridBagConstraints gbc_lblPoruka = new GridBagConstraints();
				gbc_lblPoruka.anchor = GridBagConstraints.NORTHWEST;
				gbc_lblPoruka.insets = new Insets(0, 0, 5, 0);
				gbc_lblPoruka.gridwidth = 3;
				gbc_lblPoruka.gridx = 1;
				gbc_lblPoruka.gridy = 0;
				contentPanel.add(lblPoruka, gbc_lblPoruka);
			}
			{
				btnDa = new JButton("Da");
				btnDa.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						n=1;
						setVisible(false);
					}
				});
				GridBagConstraints gbc_btnDa = new GridBagConstraints();
				gbc_btnDa.anchor = GridBagConstraints.NORTHWEST;
				gbc_btnDa.insets = new Insets(0, 0, 0, 5);
				gbc_btnDa.gridx = 1;
				gbc_btnDa.gridy = 2;
				contentPanel.add(btnDa, gbc_btnDa);
			}
			GridBagConstraints gbc_btnNe = new GridBagConstraints();
			gbc_btnNe.anchor = GridBagConstraints.NORTHWEST;
			gbc_btnNe.gridx = 3;
			gbc_btnNe.gridy = 2;
			contentPanel.add(btnNe, gbc_btnNe);
		}
		{
			JPanel btnDugmad = new JPanel();
			btnDugmad.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(btnDugmad, BorderLayout.SOUTH);
		}
	}
	public int getOpcije()
	{
		return n;
	}
	public JButton getBtnDa() {
		return btnDa;
	}
	public JButton getBtnNe() {
		return btnNe;
	}
	public void setBtnDa(JButton btnDa) {
		this.btnDa = btnDa;
	}
	public void setBtnNe(JButton btnNe) {
		this.btnNe = btnNe;
	}
}
