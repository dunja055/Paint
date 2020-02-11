package crtanje;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import geometrija.Linija;
import geometrija.Tacka;
import javax.swing.LayoutStyle.ComponentPlacement;
@SuppressWarnings("serial")
public class DijalogLinijaModifikacija extends JDialog {
	private final JPanel pnlKomande = new JPanel();
	private JTextField txtX1;
	private JTextField txtY1;
	private JTextField txtX2;
	private JTextField txtY2;
	private int x1;
	private int y1;
	private int x2;
	private int y2;
	Linija l1=null;
	JButton btnBojaLinije;
	private JLabel lblX1;
	private JLabel lblY1;
	private JLabel lblX2;
	private JLabel lblY2;
	private JLabel lblBoja;
	private JButton okButton;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DijalogLinijaModifikacija dialog = new DijalogLinijaModifikacija();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Create the dialog.
	 */
	public DijalogLinijaModifikacija() {
		setModal(true);
		setTitle("Iliæ Dunja IT48-2016");
		setBounds(10, 10, 352, 300);
		getContentPane().setLayout(new BorderLayout());
		pnlKomande.setBorder(new EmptyBorder(10,10,10,10));
		getContentPane().add(pnlKomande, BorderLayout.SOUTH);
		getContentPane().setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		{
			lblX1 = new JLabel("X koordinatu prve taèke:");
		}
		{
			txtX1 = new JTextField();
			txtX1.setColumns(10);
			txtX1.setText("" + ((Linija)GlavniPanelCrtanje.getSelektovan()).gettPocetna().getX());
		}
		{
			lblY1 = new JLabel("Y koordinatu prve taèke:");
		}
		{
			txtY1 = new JTextField();
			txtY1.setColumns(10);
			txtY1.setText(""  + ((Linija)GlavniPanelCrtanje.getSelektovan()).gettPocetna().getY());
		}
		{
			lblX2 = new JLabel("X koordinata druge taèke:");
		}
		{
			txtX2 = new JTextField();
			txtX2.setColumns(10);
			txtX2.setText("" + ((Linija)GlavniPanelCrtanje.getSelektovan()).gettKrajnja().getX());
		}
		{
			lblY2 = new JLabel("Y koordinata druge taèke:");
		}
		{
			{
				txtY2 = new JTextField();
				txtY2.setColumns(10);
				txtY2.setText("" + ((Linija)GlavniPanelCrtanje.getSelektovan()).gettKrajnja().getY());
			}
			{
				lblBoja = new JLabel("Boja:");
			}
		}
		btnBojaLinije = new JButton("");
		btnBojaLinije.setBackground(Color.BLACK);
			btnBojaLinije.setBackground(((Linija) GlavniPanelCrtanje.getSelektovan()).getBoja());
			btnBojaLinije.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					final JColorChooser colorChooser = new JColorChooser(Color.black);

				    ActionListener okActionListener = new ActionListener() {
				      public void actionPerformed(ActionEvent actionEvent) {
				    	  btnBojaLinije.setBackground(colorChooser.getColor());
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
							okButton = new JButton("Potvrdi");
							okButton.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									try{
										x1=Integer.parseInt(txtX1.getText());
										y1=Integer.parseInt(txtY1.getText());
										x2=Integer.parseInt(txtX2.getText());
										y2=Integer.parseInt(txtY2.getText());
										if (x1<=0 || y1<=0 || x2<=0 || y2<=0)
										{
											System.out.println("Greška! Negativan broj!");
											JOptionPane.showMessageDialog(null, "Greška, broj je negativan!");
										}
										else
										{
											l1=new Linija (new Tacka (x1,y1), new Tacka (x2,y2), btnBojaLinije.getBackground());
											setVisible(false);
										}
									} catch (Exception e1) {
										System.out.println("Greška! Nije unet broj!");
										JOptionPane.showMessageDialog(null, "Greška, nije unet broj!");
									}
								}
							});
							okButton.setActionCommand("OK");
							getRootPane().setDefaultButton(okButton);
						}
						GroupLayout gl_pnlKomande = new GroupLayout(pnlKomande);
						gl_pnlKomande.setHorizontalGroup(
							gl_pnlKomande.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_pnlKomande.createSequentialGroup()
									.addGroup(gl_pnlKomande.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_pnlKomande.createSequentialGroup()
											.addContainerGap()
											.addComponent(okButton, GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE))
										.addComponent(lblX1)
										.addComponent(lblY1)
										.addGroup(gl_pnlKomande.createSequentialGroup()
											.addComponent(lblX2)
											.addGap(18)
											.addComponent(txtX2, GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE))
										.addGroup(gl_pnlKomande.createSequentialGroup()
											.addComponent(lblY2)
											.addGap(18)
											.addComponent(txtY2, GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE))
										.addGroup(gl_pnlKomande.createSequentialGroup()
											.addComponent(lblBoja)
											.addGap(48)
											.addComponent(btnBojaLinije, GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)))
									.addContainerGap())
								.addGroup(Alignment.LEADING, gl_pnlKomande.createSequentialGroup()
									.addGap(141)
									.addComponent(txtX1, GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
									.addContainerGap())
								.addGroup(Alignment.LEADING, gl_pnlKomande.createSequentialGroup()
									.addGap(141)
									.addComponent(txtY1, GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
									.addContainerGap())
						);
						gl_pnlKomande.setVerticalGroup(
							gl_pnlKomande.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_pnlKomande.createSequentialGroup()
									.addGroup(gl_pnlKomande.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblX1)
										.addComponent(txtX1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_pnlKomande.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblY1)
										.addComponent(txtY1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGap(18)
									.addGroup(gl_pnlKomande.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblX2)
										.addComponent(txtX2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGap(18)
									.addGroup(gl_pnlKomande.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblY2)
										.addComponent(txtY2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGap(26)
									.addGroup(gl_pnlKomande.createParallelGroup(Alignment.LEADING, false)
										.addComponent(btnBojaLinije, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblBoja, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
									.addGap(38)
									.addComponent(okButton)
									.addContainerGap())
						);
						pnlKomande.setLayout(gl_pnlKomande);
	}
	public Linija getPodaci()
	{
		return l1;
	}
}
