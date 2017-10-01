package pl.alx.waluty;

import java.time.LocalDate;

import javax.swing.JOptionPane;

public class WypiszKursyHistoryczne {

	public static void main(String[] args) {
		String data = JOptionPane.showInputDialog(
				"Pobieranie kursów walut.\nPodaj datę:", LocalDate.now());
		
		Tabela tabela = ObslugaNBP.pobierzTabeleZDnia(data);
		
		System.out.println(tabela);
		
		for(Waluta waluta : tabela.getWszystkieWaluty()) {
			System.out.println(waluta);
		}
		
		System.out.println("Koniec");
	}
}
