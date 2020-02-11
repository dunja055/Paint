package geometrija;

import java.awt.Color;
import java.awt.Graphics;

public class Kvadrat extends PovrsinskiOblik implements Pomerljiv{
	protected Tacka goreLevo;
	protected int duzinaStranice;
	protected String bojaKonture;
	protected String bojaUnutrasnjosti;
	protected String boja;
	


	public Kvadrat(){

	}
	public Kvadrat(Tacka goreLevo, int duzinaStranice){
		this.goreLevo = goreLevo;
		this.duzinaStranice = duzinaStranice;
	}
	public Kvadrat(Tacka goreLevo, int duzinaStranice, Color boja){
		setBoja(boja);
		this.goreLevo = goreLevo;
		this.duzinaStranice = duzinaStranice;
		
	}

	public Kvadrat(Tacka goreLevo, int duzinaStranice, Color bojaKonture, Color bojaUnutrasnjosti){
		this(goreLevo,duzinaStranice,bojaKonture);
		setBojaUnutrasnjosti(bojaUnutrasnjosti);
		
	}
	
	
	
	public Kvadrat (Tacka goreLevo, int duzinaStranice, String bojaIvice)
	{
		this.goreLevo=goreLevo;
		this.duzinaStranice=duzinaStranice;
		this.boja=bojaIvice;
	}
	
	
	
	
	
	public Kvadrat(Tacka goreLevo, int duzinaStranice, String bojaKonture, String bojaUnutrasnjosti){
		this(goreLevo,duzinaStranice);
		setBojaStr(bojaKonture);
		setBojaUnutrasnjostiStr(bojaUnutrasnjosti);
		
	}


	public Linija dijagonala(){
		return new Linija(goreLevo, new Tacka(goreLevo.getX() + duzinaStranice,goreLevo.getY() + duzinaStranice));
	}

	public Tacka centarKvadrata(){
		return dijagonala().sredinaLinije();
	}

	public String toString(){
		return "Tacka gore levo=("+goreLevo.getX()+","+goreLevo.getY()+"), stranica="+duzinaStranice + ", boja ivice=" + bojaKonture+ ", boja unutrasnjosti=" + bojaUnutrasnjosti  ;
	}
	
	public String opis(){
		return "Tacka gore levo=("+goreLevo.getX()+","+goreLevo.getY()+"), stranica="+duzinaStranice + ", boja konture: \"" + getBojaStr() + "\", boja unutrasnjosti: \"" + getBojaUnutrasnjostiStr() + "\"";
	}

	public boolean equals(Object obj){
		if(obj instanceof Kvadrat){
			Kvadrat pomocni=(Kvadrat) obj;
			if(this.goreLevo.equals(pomocni.goreLevo) && this.duzinaStranice==pomocni.duzinaStranice)
				return true;
			else
				return false;
		}
		else 
			return false;
	}

	public void pomeriNa(int x, int y) {
		goreLevo.setX(x);
		goreLevo.setY(y);
	}

	public void pomeriZa(int x, int y) {
		goreLevo.setX(goreLevo.getX()+x);
		goreLevo.setY(goreLevo.getY()+y);
	}

	public int obim(){
		return 4 * duzinaStranice;
	}
	public int povrsina(){
		return duzinaStranice * duzinaStranice;
	}
	public boolean sadrzi(int x, int y) {
		if(this.getGoreLevo().getX()<=x 
				&& x<=(this.getGoreLevo().getX() + duzinaStranice)
				&& this.getGoreLevo().getY()<=y 
				&& y<=(this.getGoreLevo().getY() + duzinaStranice))
			return true;
		else 
			return false;

	}
	public void selektovan(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.BLUE);
		new Linija(getGoreLevo(), new Tacka(getGoreLevo().getX()+duzinaStranice, getGoreLevo().getY())).selektovan(g);
		new Linija(getGoreLevo(), new Tacka(getGoreLevo().getX(), getGoreLevo().getY()+duzinaStranice)).selektovan(g);
		new Linija(new Tacka(getGoreLevo().getX()+duzinaStranice, getGoreLevo().getY()), dijagonala().gettKrajnja()).selektovan(g);
		new Linija(new Tacka(getGoreLevo().getX(), getGoreLevo().getY()+duzinaStranice), dijagonala().gettKrajnja()).selektovan(g);

	}
	public void crtajSe(Graphics g){
		g.setColor(getBoja());
		g.drawRect(goreLevo.getX(), goreLevo.getY(), duzinaStranice, duzinaStranice);
		popuni(g);
		if(isSelektovan())
			selektovan(g);
	}
	public void popuni(Graphics g){
		g.setColor(getBojaUnutrasnjosti());
		g.fillRect(goreLevo.getX()+1, goreLevo.getY()+1, duzinaStranice-1, duzinaStranice-1);
	}

	public int compareTo(Object o) {
		if(o instanceof Kvadrat){
			Kvadrat pomocni  = (Kvadrat) o;
			return this.povrsina() - pomocni.povrsina();
		}
		else 
			return 0;
	}
	public Tacka getGoreLevo() {
		return goreLevo;
	}
	public int getDuzinaStranica() {
		return duzinaStranice;
	}
	public void setGoreLevo(Tacka goreLevo) {
		this.goreLevo = goreLevo;
	}
	
	public int getDuzinaStranice() {
		return duzinaStranice;
	}

	
	public void IzmenaKvadrat(Kvadrat kv){
		this.duzinaStranice = kv.duzinaStranice;
		this.goreLevo = kv.goreLevo;
		this.setBoja(kv.getBoja());
		this.setBojaStr(kv.getBojaStr());
		this.setBojaUnutrasnjosti(kv.getBojaUnutrasnjosti());
	}

}
