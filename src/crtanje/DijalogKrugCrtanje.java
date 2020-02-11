package crtanje;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
@SuppressWarnings("serial")
public class DijalogKrugCrtanje extends JDialog {
	private final JPanel pnlGlavni = new JPanel();
	private JTextField txtPoluprecnik;
	private int poluprecnik;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DijalogKrugCrtanje dialog = new DijalogKrugCrtanje();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Create the dialog.
	 */
	public DijalogKrugCrtanje() {
		setTitle("Iliæ Dunja IT48-2016");
		setModal(true); 
		setBounds(10, 10, 250, 165);
		getContentPane().setLayout(new BorderLayout());
		pnlGlavni.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(pnlGlavni, BorderLayout.CENTER);
		pnlGlavni.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		{
			JLabel lblPoluprecnik = new JLabel("Polupreènik:");
			pnlGlavni.add(lblPoluprecnik);
		}
		{
			txtPoluprecnik = new JTextField();
			pnlGlavni.add(txtPoluprecnik);
			txtPoluprecnik.setColumns(10);
		}
		{
			JPanel pnlDugmad = new JPanel();
			pnlDugmad.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(pnlDugmad, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Potvrdi");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try{
							poluprecnik=Integer.parseInt(txtPoluprecnik.getText());
							System.out.println(poluprecnik);
							if (poluprecnik <= 0) 
							{
								System.out.println("Polupreènik je negativan, greška!");
								JOptionPane.showMessageDialog(null, "Polupreènik ne može da bude negativan!");
							}
							else
							{
								setVisible(false);
							}
						} catch (Exception e1) {
							System.out.println("Nije unet broj!");
							JOptionPane.showMessageDialog(null, "Greška, broj nije unet!");
						}
					}
				});
				okButton.setActionCommand("OK");
				pnlDugmad.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}
	public int getPoluprecnik()
	{
		return poluprecnik;
	}
}
