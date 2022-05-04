
public class GuvenliEv extends NormalKonum {

	public GuvenliEv(Oyuncu oyuncu) {
		super(oyuncu, "G�venli ev");
	}

	@Override
	public boolean konum() {
		if(this.getOyuncu().getEnvanter().getOduller().size() == 3) {
			System.out.println("Tebrikler!!! "+this.getOyuncu().getIsim()+" TEBR�KLER! ");
			System.exit(0);

		}
			
		System.out.println("G�venli evdesin burada d��man yok!");
		this.getOyuncu().getKarakter().fullSaglik();
		System.out.println("Can�n tazelendi !");
		System.out.println("Can durumun : " + this.getOyuncu().getKarakter().getSaglik());
		return true;
	}
}
