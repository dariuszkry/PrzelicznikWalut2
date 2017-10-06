package waluty;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Waluta {
	private final String kod;
	private final String nazwa;
	private final BigDecimal kurs;
	
	public Waluta() {
		// Konstruktor domyślny dodajemy po to, aby klasa była Java Bean
		// i działała np. w technologii JAXB albo JSP
		kod = null;
		nazwa = null;
		kurs = null;
	}
	
	public Waluta(String kod, String nazwa, BigDecimal kurs) {
		this.kod = kod;
		this.nazwa = nazwa;
		this.kurs = kurs;
	}

	public Waluta(String kod, String nazwa, String kurs) {
		this(kod, nazwa, new BigDecimal(kurs));
	}

	public String getKod() {
		return kod;
	}

	public String getNazwa() {
		return nazwa;
	}

	public BigDecimal getKurs() {
		return kurs;
	}

	@Override
	public String toString() {
		return nazwa + " (" + kod + ") : "+ kurs;
	}

	public BigDecimal przeliczWaluteNaPln(BigDecimal kwota) {
		return kwota.multiply(kurs).setScale(2, RoundingMode.HALF_UP);
	}

	public BigDecimal przeliczPlnNaWalute(BigDecimal kwota) {
		return kwota.divide(kurs, 2, RoundingMode.HALF_UP);
	}
}
