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
import geometrija.Pravougaonik;
import geometrija.Tacka;
import javax.swing.LayoutStyle.ComponentPlacement;
public class DijalogPravougaonikModifikacija extends JDialog {
	private static final long serialVersionUID = 1L;
	private final JPanel pnlKomande = new JPanel();
	private JTextField txtX;
	private JTextField txtY;
	private JTextField txtVisina;
	private JTextField txtSirina;
	JButton btnBojaKonture;
	JButton btnBojaUnutrasnjosti;
	private int x;
	private int y;
	private int visina;
	private int sirina;
	Pravougaonik pr1=null;
	private JLabel lblX;
	private JLabel lblY;
	private JLabel lblVisina;
	private JLabel lblSirina;
	private JLabel lblBojaKonture;
	private JLabel lblBojaUnutrasnjosti;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DijalogPravougaonikModifikacija dialog = new DijalogPravougaonikModifikacija();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Create the dialog.
	 */
	public DijalogPravougaonikModifikacija() {
		setTitle("Iliæ Dunja IT48-2016");
		setModal(true);
		setBounds(100, 100, 420, 260);
		getContentPane().setLayout(new BorderLayout());
		pnlKomande.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(pnlKomande, BorderLayout.CENTER);
		{
			lblX = new JLabel("X koordinata taèke gore levo:");
		}
		{
			txtX = new JTextField();
			txtX.setColumns(10);
			txtX.setText("" + ((Pravougaonik)GlavniPanelCrtanje.getSelektovan()).getGoreLevo().getX());
		}
		{
			lblY = new JLabel("Y koordinata taèke gore levo:");
		}
		{
			txtY = new JTextField();
			txtY.setColumns(10);
			txtY.setText(""+ ((Pravougaonik)GlavniPanelCrtanje.getSelektovan()).getGoreLevo().getY());
		}
		{
			lblVisina = new JLabel("Visina:");
		}
		{
			txtVisina = new JTextField();
			txtVisina.setColumns(10);
			txtVisina.setText("" + ((Pravougaonik)GlavniPanelCrtanje.getSelektovan()).getVisina());
		}
		{
			lblSirina = new JLabel("Širina:");
		}
		{
			 btnBojaKonture = new JButton("");
			 btnBojaKonture.setBackground(((Pravougaonik)GlavniPanelCrtanje.getSelektovan()).getBoja());
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
				txtSirina = new JTextField();
				txtSirina.setColumns(10);
				txtSirina.setText("" + ((Pravougaonik)GlavniPanelCrtanje.getSelektovan()).getSirina());
			}
			{
				lblBojaKonture = new JLabel("Boja konture:");
			}
		}
		{
			lblBojaUnutrasnjosti = new JLabel("Boja unutrašnjosti:");
		}
		{
			 btnBojaUnutrasnjosti = new JButton("");
			 btnBojaUnutrasnjosti.setBackground(((Pravougaonik)GlavniPanelCrtanje.getSelektovan()).getBojaUnutrasnjosti());
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
			
		}
		GroupLayout gl_pnlKomande = new GroupLayout(pnlKomande);
		gl_pnlKomande.setHorizontalGroup(
			gl_pnlKomande.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlKomande.createSequentialGroup()
					.addGap(30)
					.addGroup(gl_pnlKomande.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlKomande.createParallelGroup(Alignment.LEADING)
							.addComponent(lblSirina)
							.addComponent(lblBojaKonture)
							.addComponent(lblBojaUnutrasnjosti))
						.addGroup(gl_pnlKomande.createParallelGroup(Alignment.TRAILING, false)
							.addGroup(gl_pnlKomande.createSequentialGroup()
								.addComponent(lblX)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(txtX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_pnlKomande.createSequentialGroup()
								.addComponent(lblY)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(txtY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGroup(Alignment.LEADING, gl_pnlKomande.createSequentialGroup()
								.addComponent(lblVisina)
								.addGap(155)
								.addGroup(gl_pnlKomande.createParallelGroup(Alignment.LEADING)
									.addComponent(txtVisina, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGroup(gl_pnlKomande.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(btnBojaKonture, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(txtSirina, Alignment.LEADING)
										.addComponent(btnBojaUnutrasnjosti, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
					.addContainerGap(93, Short.MAX_VALUE))
		);
		gl_pnlKomande.setVerticalGroup(
			gl_pnlKomande.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlKomande.createSequentialGroup()
					.addGap(3)
					.addGroup(gl_pnlKomande.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblX)
						.addComponent(txtX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(gl_pnlKomande.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblY)
						.addComponent(txtY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(8)
					.addGroup(gl_pnlKomande.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlKomande.createSequentialGroup()
							.addGap(3)
							.addComponent(lblVisina))
						.addComponent(txtVisina, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_pnlKomande.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlKomande.createSequentialGroup()
							.addGap(6)
							.addComponent(txtSirina, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnBojaKonture, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnBojaUnutrasnjosti, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pnlKomande.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblSirina)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblBojaKonture)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblBojaUnutrasnjosti))))
		);
		pnlKomande.setLayout(gl_pnlKomande);
		{
			JPanel btnDugmad = new JPanel();
			btnDugmad.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(btnDugmad, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Potvrdi");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							x=Integer.parseInt(txtX.getText());
							y=Integer.parseInt(txtY.getText());
							visina=Integer.parseInt(txtVisina.getText());
							sirina=Integer.parseInt(txtSirina.getText());
							if (x<=0 || y<=0 || visina<=0 || sirina<=0)
							{
								System.out.println("Greška, broj mora biti pozitivan!");
								JOptionPane.showMessageDialog(null, "Greška, broj mora biti pozitivan!");
							}
							else {
								setVisible(false);
								pr1= new Pravougaonik(new Tacka(x,y), sirina, visina, btnBojaKonture.getBackground(), btnBojaUnutrasnjosti.getBackground());
							}
						} catch (Exception e1) {
							System.out.println("Greška, nije unet broj!");
							JOptionPane.showMessageDialog(null, "Greška, nije unet broj!");
						}
					}
				});
				okButton.setActionCommand("OK");
				btnDugmad.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}
	public Pravougaonik getPodaci()
	{
		return pr1;
	}
}
