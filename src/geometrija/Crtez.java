package geometrija;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings({ "serial", "unused" })
public class Crtez extends JPanel{
	int x;
	int y;
	int i;
	public Crtez() {
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				x = e.getX();
				y = e.getY();
			}
		});
	}
	
	public static void main(String[] args){
		JFrame prozor = new JFrame("Crtanje");
		prozor.setSize(800, 600);
		Crtez c = new Crtez();
		prozor.getContentPane().add(c);
		prozor.setVisible(true);
		prozor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	

}
