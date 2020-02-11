package sortiranje;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometrija.Kvadrat;

@SuppressWarnings("serial")
public class GlavnaSortiranje extends JFrame {

	private JPanel pnlGlavni;
	List lista;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GlavnaSortiranje frame = new GlavnaSortiranje();
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
	public GlavnaSortiranje() {
		setTitle("Iliæ Dunja IT48-2016");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		pnlGlavni = new JPanel();
		pnlGlavni.setBorder(new EmptyBorder(5, 5, 5, 5));
		pnlGlavni.setLayout(new BorderLayout(0, 0));
		setContentPane(pnlGlavni);
		
		JPanel panel = new JPanel();
		pnlGlavni.add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblRandomLista = new JLabel("Nesortirana lista");
		GridBagConstraints gbc_lblRandomLista = new GridBagConstraints();
		gbc_lblRandomLista.insets = new Insets(0, 0, 5, 5);
		gbc_lblRandomLista.gridx = 0;
		gbc_lblRandomLista.gridy = 1;
		panel.add(lblRandomLista, gbc_lblRandomLista);
		
		JLabel lblSortiranaLista = new JLabel("Sortirana lista");
		GridBagConstraints gbc_lblSortiranaLista = new GridBagConstraints();
		gbc_lblSortiranaLista.insets = new Insets(0, 0, 5, 0);
		gbc_lblSortiranaLista.gridx = 1;
		gbc_lblSortiranaLista.gridy = 1;
		panel.add(lblSortiranaLista, gbc_lblSortiranaLista);
		
		List listNesortirana = new List();
		GridBagConstraints gbc_listNesortirana = new GridBagConstraints();
		gbc_listNesortirana.fill = GridBagConstraints.BOTH;
		gbc_listNesortirana.insets = new Insets(0, 0, 0, 5);
		gbc_listNesortirana.gridx = 0;
		gbc_listNesortirana.gridy = 2;
		panel.add(listNesortirana, gbc_listNesortirana);
		
		List listSortirana = new List();
		GridBagConstraints gbc_listSortirana = new GridBagConstraints();
		gbc_listSortirana.fill = GridBagConstraints.BOTH;
		gbc_listSortirana.gridx = 1;
		gbc_listSortirana.gridy = 2;
		panel.add(listSortirana, gbc_listSortirana);
		
		ArrayList<Kvadrat> lista = new ArrayList<Kvadrat>();
		
		JButton btnDodajUListu = new JButton("Dodaj u listu");
		btnDodajUListu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DijalogKvadratStek dk = new DijalogKvadratStek();
				dk.setVisible(true);
				Kvadrat k = dk.getPodaci();
				if (k != null)
				{
				listNesortirana.add(k.opis());
				}
				
				lista.add(dk.getPodaci());
				lista.sort(null);
				
				listSortirana.removeAll();
				
				for(Kvadrat k1 : lista){
					listSortirana.add(k1.opis());
				}
				
			}
		});
		
		GridBagConstraints gbc_btnDodajUListu = new GridBagConstraints();
		gbc_btnDodajUListu.gridwidth = 2;
		gbc_btnDodajUListu.insets = new Insets(0, 0, 5, 0);
		gbc_btnDodajUListu.gridx = 0;
		gbc_btnDodajUListu.gridy = 0;
		panel.add(btnDodajUListu, gbc_btnDodajUListu);
	}

}
