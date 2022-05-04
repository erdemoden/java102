
public class Oyuncu {
	private OyuncuTip karakter;
	private Envanter envanter;
	private String isim;

	public Oyuncu(String name) {
		this.envanter = new Envanter();
		this.isim = name;
	}

	public OyuncuTip getKarakter() {
		return karakter;
	}

	public void setKarakter(OyuncuTip karakter) {
		this.karakter = karakter;
	}

	public Envanter getEnvanter() {
		return envanter;
	}

	public void setEnvanter(Envanter envanter) {
		this.envanter = envanter;
	}

	public String getIsim() {
		return isim;
	}

	public void setIsim(String isim) {
		this.isim = isim;
	}

	public void selectCharacter() {
		OyuncuTip[] types = { new Samuray(), new Okcu(), new Sovalye() };

		System.out.println("*************************************************************************************");
		for (OyuncuTip type : types) {
			System.out.println(type.getId() + ". Karakter: " + type.getIsim() + "\t Hasar: " + type.getHasar()
					+ "\t Sa�l�k: " + type.getSaglik() + "\t Para: " + type.getPara());
		}
		System.out.println("*************************************************************************************");
		System.out.print("L�tfen bir karakter gir: ");
		int choice = Oyun.scan.nextInt();
		if(choice > 0 && choice < (types.length + 1)) {
			this.karakter = types[choice-1];
		}else {
			this.karakter = types[0];
		}
		System.out.println("Art�k bir "+this.karakter.getIsim()+" olarak yoluna devam et.");
	}

	public void printInfo() {
		System.out.print("Silah: "+ this.envanter.getSilah().getIsim()
				+ ", Z�rh: " + this.envanter.getZirh().getIsim()
				+", Hasar: "+this.getHasar()
				+", Sa�l�k: "+this.karakter.getSaglik()
				+", Para: "+this.karakter.getPara());
		
		if(this.envanter.getZirh().getBlok() > 0)
			System.out.println(", Koruma: "+this.envanter.getZirh().getBlok());
		else
			System.out.println();
	}
	
	private int getHasar() {
		return this.karakter.getHasar() + this.envanter.getSilah().getHasar();
	}
	
	public void silahSatinAl(Silah silah) {
		if(silah.getPrice() <= this.karakter.getPara()) {
			this.karakter.buyItem(silah.getPrice());
			System.out.println(silah.getIsim()+" sat�n ald�n�z.");
			this.envanter.setSilah(silah);
			this.printInfo();
		}
		else {
			System.out.println("Yeterli paran�z bulunmamaktad�r!");
		}
	}

	public void zirhSatinAl(Zirh zirh) {
		if(zirh.getFiyat() <= this.karakter.getPara()) {
			this.karakter.buyItem(zirh.getFiyat());
			System.out.println(zirh.getIsim()+" sat�n ald�n�z.");
			this.envanter.setZirh(zirh);
			this.printInfo();
		}
		else {
			System.out.println("Yeterli paran�z bulunmamaktad�r!");
		}
	}

	public void saldiri(Dusman dusman) {
		if(this.getKarakter().getSaglik() > 0) {
			System.out.println(this.karakter.getIsim() +" "+ this.isim +" "+ this.envanter.getSilah().getIsim()+" ile sald�r�yor..." );
			dusman.setSaglik(dusman.getSaglik() - this.getHasar());
			dusman.bilgiyiYazdir();
			System.out.println();
		}
	}
}

