import java.util.Scanner;

public class Oyun {
	public Oyuncu player;
	public Konum konum;
	public static Scanner scan = new Scanner(System.in);

	public void start() {
		System.out.println("Macera Oyununa Ho�geldiniz!");
		System.out.print("�siminizi girin : ");
		this.player = new Oyuncu(scan.nextLine());
		System.out.println("Merhabalar " + this.player.getIsim() + ", bu karanl�k ve sisli adaya ho�geldin. Burada ya�ananlar�n hepsi ger�ek!");
		
		System.out.println("Bu maceradaki rol�n nedir?");
		player.selectCharacter();
		System.out.println();
		
		while(true) {
			Konum location = null;
			System.out.println("B�lgeler");
			System.out.println("0 - Oyunu Sonland�r");
			System.out.println("1 - G�venli Ev");
			System.out.println("2 - E�ya D�kkan�");
			System.out.println("3 - Ma�ara");
			System.out.println("4 - Orman");
			System.out.println("5 - Nehir");
			System.out.println("6 - Maden");
			System.out.print("Gitmek istedi�in b�lgeyi se�: ");
			int selectionLoc = Oyun.scan.nextInt();
			switch(selectionLoc) {
				case 0:
					break;
				case 1:
					location = new GuvenliEv(player);
					break;
				case 2:
					location = new Magaza(player);
					break;
				case 3:
					if(this.player.getEnvanter().getOduller().contains("Yemek")) {
						System.out.println();
						System.out.println("MAGARA TEM�Z G�R�S YOK!");
						System.out.println();
						continue;
					}else {
						location = new Magara(player);
						break;
					}
				case 4:
					if(this.player.getEnvanter().getOduller().contains("Odun")) {
						System.out.println();
						System.out.println("ORMAN TEM�Z G�R�S YOK!");
						System.out.println();
						continue;
					}else {
						location = new Orman(player);
						break;
					}
				case 5:
					if(this.player.getEnvanter().getOduller().contains("Su")) {
						System.out.println();
						System.out.println("NEH�R TEM�ZLEND� G�R�S YOK");
						System.out.println();
						continue;
					}else {
						location = new Nehir(player);
						break;
					}
				case 6:
					location = new Maden(player);
					break;
				default:
					location = new GuvenliEv(player);
			}
			
			if(location == null) {
				System.out.println();
				System.out.println("PES ETT�N!!!");
				break;
			}
			
			System.out.println();
			if (!location.konum()) {
				System.out.println("OYUN B�TT�  !!!");
				break;
			}
			System.out.println();
		}
	}
}
