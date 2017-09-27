package dodatkowe;

import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class PobierzObrazek {

	public static void main(String[] args) {
		
		try {
			URL url = new URL("https://upload.wikimedia.org/wikipedia/commons/1/10/Caloenas_maculata.jpg");
			
			try(InputStream strumien = url.openStream()) {
				Files.copy(strumien, Paths.get("obrazek.jpg"), StandardCopyOption.REPLACE_EXISTING);
				System.out.println("Gotowe");
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
