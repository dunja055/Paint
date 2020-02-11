package crtanje;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;
import geometrija.Oblik;
public class PnlCrtez extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Oblik> oblici;
	public PnlCrtez()
	{
		oblici=new ArrayList<Oblik>();
	}
	public void add(Oblik o){
		oblici.add(o);
		repaint();
	}
	public void remove(Oblik o)
	{
		oblici.remove(o);
		repaint();
	}
	protected void paintComponent(Graphics g) 
	{
		super.paintComponent(g);
		for (Oblik o : oblici)
		{
			o.crtajSe(g); 
		}
	}
}
