package crtanje;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Stack;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import geometrija.Krug;
import geometrija.Kvadrat;
import geometrija.Linija;
import geometrija.Oblik;
import geometrija.Pravougaonik;
import geometrija.Tacka;
public class GlavniPanelCrtanje extends JFrame {
	private static final long serialVersionUID = 1L;
	private int xTacka;
	private int yTacka;
	private Tacka t1;
	private Linija l1;
	private Kvadrat kv1;
	private Pravougaonik pr1;
	private Krug kr1;
	private PnlCrtez crtanje; 
	private JButton btnOdabranoDugme;
	private JButton btnObrisi;
	static Oblik selektovan = null;
	private Stack<Oblik> stek = new Stack<Oblik>();
	int klik = 1;
	private JPanel pnlGlavni;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GlavniPanelCrtanje frame = new GlavniPanelCrtanje();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the frame.
	 */
	public GlavniPanelCrtanje() { 
		crtanje = new PnlCrtez();  
		crtanje.setBackground(Color.white);
		setTitle("Iliæ Dunja IT48-2016");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 500);
		pnlGlavni = new JPanel();
		pnlGlavni.setBorder(new EmptyBorder(5, 5, 5, 5));
		pnlGlavni.setLayout(new BorderLayout(0, 0));
		setContentPane(pnlGlavni);
		JPanel pnlKomande = new JPanel();
		pnlGlavni.add(pnlKomande, BorderLayout.NORTH);
		pnlGlavni.add(crtanje, BorderLayout.CENTER);
		pnlKomande.setLayout(new BoxLayout(pnlKomande, BoxLayout.X_AXIS));
		JButton btnTacka = new JButton("Taèka", new ImageIcon("images/tacka.png"));
		btnTacka.setMargin(getInsets());
		btnTacka.setVerticalTextPosition(SwingConstants.TOP);
		btnTacka.setHorizontalTextPosition(SwingConstants.CENTER);
		
		btnTacka.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				btnOdabranoDugme = btnTacka;
			}
		});
		JButton btnLinija = new JButton("Linija", new ImageIcon("images/linija.png"));
		btnLinija.setMargin(getInsets());
		btnLinija.setVerticalTextPosition(SwingConstants.TOP);
		btnLinija.setHorizontalTextPosition(SwingConstants.CENTER);
		btnLinija.addMouseListener(new MouseAdapter() {
			@Override//***
			public void mouseClicked(MouseEvent e) {
				btnOdabranoDugme = btnLinija;
			}
		});
		JButton btnPravougaonik = new JButton("Pravougaonik", new ImageIcon("images/pravougaonik.png"));
		btnPravougaonik.setMargin(getInsets());
		btnPravougaonik.setVerticalTextPosition(SwingConstants.TOP);
		btnPravougaonik.setHorizontalTextPosition(SwingConstants.CENTER);
		btnPravougaonik.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnOdabranoDugme = btnPravougaonik;
			}
		});
		JButton btnKvadrat = new JButton("Kvadrat", new ImageIcon("images/kvadrat.jpg"));
		btnKvadrat.setMargin(getInsets());
		btnKvadrat.setVerticalTextPosition(SwingConstants.TOP);
		btnKvadrat.setHorizontalTextPosition(SwingConstants.CENTER);
		btnKvadrat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnOdabranoDugme = btnKvadrat;
			}
		});
		JButton btnKrug = new JButton("Krug", new ImageIcon("images/krug.jpg"));
		btnKrug.setMargin(getInsets());
		btnKrug.setVerticalTextPosition(SwingConstants.TOP);
		btnKrug.setHorizontalTextPosition(SwingConstants.CENTER);
		btnKrug.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnOdabranoDugme = btnKrug;
			}
		});
		pnlKomande.add(Box.createRigidArea(new Dimension(5, 0)));
		pnlKomande.add(btnTacka);
		pnlKomande.add(Box.createRigidArea(new Dimension(5, 0)));
		pnlKomande.add(btnLinija);
		pnlKomande.add(Box.createRigidArea(new Dimension(5, 0)));
		pnlKomande.add(btnPravougaonik);
		pnlKomande.add(Box.createRigidArea(new Dimension(5, 0)));
		pnlKomande.add(btnKvadrat);
		pnlKomande.add(Box.createRigidArea(new Dimension(5, 0)));
		pnlKomande.add(btnKrug);
		pnlKomande.add(Box.createRigidArea(new Dimension(10, 0)));
		JLabel lblBojaUnutrasnjosti = new JLabel("Boja unutrašnjosti");
		pnlKomande.add(lblBojaUnutrasnjosti);
		pnlKomande.add(Box.createRigidArea(new Dimension(5, 0)));
		JButton btnUnutrasnjost = new JButton("Boja unutrašnjosti");
		btnUnutrasnjost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				final JColorChooser colorChooser = new JColorChooser(Color.black);

			    ActionListener okActionListener = new ActionListener() {
			      public void actionPerformed(ActionEvent actionEvent) {
						btnUnutrasnjost.setBackground(colorChooser.getColor());
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
		btnUnutrasnjost.setBackground(Color.WHITE);
		btnUnutrasnjost.setForeground(Color.WHITE);
		pnlKomande.add(btnUnutrasnjost);
		pnlKomande.add(Box.createRigidArea(new Dimension(5, 0)));
		JLabel lblBojaIvice = new JLabel("Boja konture");
		pnlKomande.add(lblBojaIvice);
		pnlKomande.add(Box.createRigidArea(new Dimension(5, 0)));
		JButton btnKontura = new JButton("Boja konture");
		btnKontura.setMaximumSize(new Dimension(Integer.MAX_VALUE, btnKontura.getMaximumSize().height));
		btnKontura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				final JColorChooser colorChooser = new JColorChooser(Color.black);

			    ActionListener okActionListener = new ActionListener() {
			      public void actionPerformed(ActionEvent actionEvent) {
			    	  btnKontura.setBackground(colorChooser.getColor());
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
			
		btnKontura.setBackground(Color.BLACK);
		btnKontura.setForeground(Color.BLACK);
		pnlKomande.add(btnKontura);
		pnlKomande.add(Box.createRigidArea(new Dimension(5, 0)));
		JButton btnSelektovanje = new JButton("Odaberi", new ImageIcon("images/select.png"));
		btnSelektovanje.setMargin(getInsets());
		btnSelektovanje.setVerticalTextPosition(SwingConstants.TOP);
		btnSelektovanje.setHorizontalTextPosition(SwingConstants.CENTER);
		btnSelektovanje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnOdabranoDugme = btnSelektovanje;
			}
		});
		
		pnlKomande.add(btnSelektovanje);
		pnlKomande.add(Box.createRigidArea(new Dimension(5, 0)));
		JButton btnModifikacija = new JButton("Izmeni", new ImageIcon("images/modify.png"));
		btnModifikacija.setMargin(getInsets());
		btnModifikacija.setVerticalTextPosition(SwingConstants.TOP);
		btnModifikacija.setHorizontalTextPosition(SwingConstants.CENTER);
		btnModifikacija.setEnabled(false);
		btnModifikacija.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (selektovan instanceof Tacka) {
					DijalogTackaModifikacija dt = new DijalogTackaModifikacija();
					dt.setVisible(true);
					if (dt.getPodaci() == null) {
					} else {
						
						t1 = dt.getPodaci();
						((Tacka) selektovan).IzmenaTacke(t1);
						selektovan.setSelektovan(false);
						selektovan = null;
						repaint();
					}
				} else if (selektovan instanceof Linija) {
					DijalogLinijaModifikacija dl = new DijalogLinijaModifikacija();
					dl.setVisible(true);
					if (dl.getPodaci() == null) {
					} else {
						
						l1 = dl.getPodaci();
						
						((Linija) selektovan).IzmenaLinije(l1);
						selektovan.setSelektovan(false);
						selektovan = null;
						repaint();
					}
				} else if (selektovan instanceof Pravougaonik) {
					DijalogPravougaonikModifikacija dp = new DijalogPravougaonikModifikacija();
					dp.setVisible(true);
					if (dp.getPodaci() == null) {
					} else {
						
						pr1 = dp.getPodaci();
						((Pravougaonik) selektovan).IzmenaPravougaonik(pr1);
						selektovan.setSelektovan(false);
						selektovan = null;
						repaint();
					}
				} else if (selektovan instanceof Kvadrat) {
					DijalogKvadratModifikacija dk = new DijalogKvadratModifikacija();
					dk.setVisible(true);
					if (dk.getPodaci() == null) {
					} else {
						
						kv1 = dk.getPodaci();
						((Kvadrat) selektovan).IzmenaKvadrat(kv1);
						selektovan.setSelektovan(false);
						selektovan = null;
						repaint();
					}
				} else if (selektovan instanceof Krug) {
					DijalogKrugModifikacija dkr = new DijalogKrugModifikacija();
					dkr.setVisible(true);
					if (dkr.getPodaci() == null) {
					} else {
						
						kr1 = dkr.getPodaci();
						((Krug) selektovan).IzmenaKruga(kr1);
						selektovan.setSelektovan(false);
						selektovan = null;
						repaint();
					}
				}
				btnModifikacija.setEnabled(false);
				btnObrisi.setEnabled(false);
			}
		});
		
		pnlKomande.add(btnModifikacija);
		pnlKomande.add(Box.createRigidArea(new Dimension(5, 0)));
		btnObrisi = new JButton("Obriši", new ImageIcon("images/delete.png"));
		btnObrisi.setMargin(getInsets());
		btnObrisi.setVerticalTextPosition(SwingConstants.TOP);
		btnObrisi.setHorizontalTextPosition(SwingConstants.CENTER);
		btnObrisi.setEnabled(false);
		btnObrisi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Brisanje b = new Brisanje();
				b.setVisible(true);
				if (b.getOpcije() == 1) {
					stek.remove(selektovan);
					crtanje.remove(selektovan);
					selektovan = null;
				}
				btnModifikacija.setEnabled(false);
				btnObrisi.setEnabled(false);
			}
		});
		pnlKomande.add(btnObrisi);

		crtanje.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				
				if (btnOdabranoDugme == btnTacka) {
					xTacka = e.getX();
					yTacka = e.getY();
					t1 = new Tacka(xTacka, yTacka, btnKontura.getBackground());
					crtanje.add(t1);
					stek.push(t1);
					
				} else if (btnOdabranoDugme == btnLinija) {
					if (klik == 1) {
						xTacka = e.getX();
						yTacka = e.getY();
						klik++;
					} else {
						int xTacka1 = e.getX();
						int yTacka1 = e.getY();
						System.out.println(btnKontura.getBackground());
						l1 = new Linija(new Tacka(xTacka, yTacka), new Tacka(xTacka1, yTacka1),
								btnKontura.getBackground());
						crtanje.add(l1);
						stek.push(l1);
						klik = 1;
					}
				} else if (btnOdabranoDugme == btnKvadrat) {
					xTacka = e.getX();
					yTacka = e.getY();
					DijalogKvadrataCrtanje dk = new DijalogKvadrataCrtanje();
					dk.setVisible(true);
					kv1 = new Kvadrat(new Tacka(xTacka, yTacka), dk.getDuzinaStranice(), btnKontura.getBackground(),
							btnUnutrasnjost.getBackground());
					crtanje.add(kv1);
					stek.push(kv1);
				} else if (btnOdabranoDugme == btnPravougaonik) {
					xTacka = e.getX();
					yTacka = e.getY();
					DijalogPravougaonikCrtanje dijalogPravougaonik = new DijalogPravougaonikCrtanje();
					dijalogPravougaonik.setVisible(true);
					pr1 = new Pravougaonik(new Tacka(xTacka, yTacka), dijalogPravougaonik.getSirina(),
							dijalogPravougaonik.getDuzina(), btnKontura.getBackground(),
							btnUnutrasnjost.getBackground());
					crtanje.add(pr1);
					stek.push(pr1);
				} else if (btnOdabranoDugme == btnKrug) {
					xTacka = e.getX();
					yTacka = e.getY();
					DijalogKrugCrtanje dijalogKrug = new DijalogKrugCrtanje();
					dijalogKrug.setVisible(true);
					kr1 = new Krug(new Tacka(xTacka, yTacka), dijalogKrug.getPoluprecnik(), btnKontura.getBackground(),
							btnUnutrasnjost.getBackground());
					System.out.println(dijalogKrug.getPoluprecnik());
					crtanje.add(kr1);
					stek.push(kr1);
				} else if (btnOdabranoDugme == btnSelektovanje) {
					btnModifikacija.setEnabled(false);
					btnObrisi.setEnabled(false);
					if (selektovan != null) {
						selektovan.setSelektovan(false);
					}
					selektovan = null;
					xTacka = e.getX();
					yTacka = e.getY();
					
					for (int i = stek.size() - 1; i >= 0; i--) {
						if (stek.elementAt(i).sadrzi(xTacka, yTacka)) {
							selektovan = stek.elementAt(i);
							selektovan.setSelektovan(true);
							btnModifikacija.setEnabled(true);
							btnObrisi.setEnabled(true);
							repaint();
							return;
						}
					}
				}
				System.out.println("Trenutno stanje na steku");
				for (int i = stek.size() - 1; i >= 0; i--) {
					System.out.println(stek.elementAt(i));
				}
			}
		});
	}
	static Oblik getSelektovan() {
		return selektovan;
	}
}
