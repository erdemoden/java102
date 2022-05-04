
public class Magaza extends NormalKonum {

	public Magaza(Oyuncu player) {
		super(player, "Ma�aza");
	}


	@Override
	public boolean konum() {
		System.out.println("	HO�GELD�N!Sat�n almak icin secim yapin!!");
		System.out.println("1 - Silahlar");
		System.out.println("2 - Z�rhlar");
		System.out.println("3 - ��k�� yap");
		System.out.print("Se�imin: ");
		int sec = Oyun.scan.nextInt();
		
		while(sec < 1 || sec > 3) {
			System.out.print("Ge�ersiz i�lem Tekrar i�lem se�iniz: ");
			sec = Oyun.scan.nextInt();
		}
		
		switch(sec) {
			case 1:
				silahBilgisi();
				break;
			case 2:
				zirhBilgisi();
				break;
			default:
				return true;
		}
		
		return true;
	}

	private void zirhBilgisi() {
		System.out.println();
		this.getOyuncu().printInfo();
		System.out.println();
		System.out.println("------ Z�rhlar ------");
		System.out.println("0 - Geri");
		for (Zirh a : Zirh.getZirhlar()) {
			a.bilgiyiYazdir();
		}
		
		System.out.print("Bir z�rh se�ebilirsin: ");
		int zirhSec = Oyun.scan.nextInt();
		
		if(zirhSec != 0) {
			System.out.println();
			while(zirhSec < 1 || zirhSec > Silah.getSilahlar().length) {
				System.out.print("Ge�ersiz de�er, l�tfen tekrar silah se�: ");
				zirhSec = Oyun.scan.nextInt();
			}
			
			Zirh secilenZirh= Zirh.getZirhId(zirhSec);
			if(secilenZirh != null) {
				this.getOyuncu().zirhSatinAl(secilenZirh);
			}
		}
	}

	private void silahBilgisi() {
		System.out.println();
		this.getOyuncu().printInfo();
		System.out.println();
		System.out.println("***********************Silahlar*********************");
		System.out.println("0 - GeriD�n");
		for (Silah weapon : Silah.getSilahlar()) {
			weapon.printInfo();
		}
		
		System.out.print("**********Silah Se�ebilirsin*****************: ");
		int silahSec = Oyun.scan.nextInt();
		
		if(silahSec != 0) {
			System.out.println();
			while(silahSec < 1 || silahSec > Silah.getSilahlar().length) {
				System.out.print("Tekrar S�LAH Se�in: ");
				silahSec = Oyun.scan.nextInt();
			}
			
			Silah secilenSilah = Silah.getSecilenSilahId(silahSec);
			if(secilenSilah != null) {
				this.getOyuncu().silahSatinAl(secilenSilah);
			}
		}
	}
}
