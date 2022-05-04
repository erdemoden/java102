import java.util.ArrayList;
import java.util.List;

public class Envanter {
	private Silah silah;
	private Zirh zirh;
	private List<String> oduller;

	public Envanter() {
		this.silah = new Silah(0, "Yumruk", 0, 0);
		this.zirh = new Zirh(0, "Pa�avra", 0, 0);
		this.oduller = new ArrayList<String>();
	}

	public void addOdul(String odul) {
		this.oduller.add(odul);
	}
	
	public List<String> getOduller() {
		return this.oduller;
	}
	
	public Silah getSilah() {
		return silah;
	}

	public void setSilah(Silah silah) {
		System.out.println(this.silah.getIsim() + " b�rak�ld�.");
		System.out.println(silah.getIsim() + " ku�an�ld�.");
		int yeniHasar = silah.getHasar() - this.silah.getHasar();
		if(yeniHasar > 0)
			System.out.println("Hasar --> +" + yeniHasar);
		else if(yeniHasar < 0)
			System.out.println("Hasar --> " + yeniHasar);
		
		this.silah = silah;
	}

	public Zirh getZirh() {
		return zirh;
	}

	public void setZirh(Zirh zirh) {
		System.out.println(this.zirh.getIsim() + " b�rak�ld�.");
		System.out.println(zirh.getIsim() + " ku�nd�.");
		int yeniBlok = zirh.getBlok() - this.zirh.getBlok();
		if(yeniBlok > 0)
			System.out.println("Koruma: +" + yeniBlok);
		else if(yeniBlok < 0)
			System.out.println("Koruma: " + yeniBlok);
		
		this.zirh = zirh;
	}
}
