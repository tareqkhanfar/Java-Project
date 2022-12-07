package PROJECT;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

public class FileDataInput {
	public FileDataInput() throws NumberFormatException, IOException {

		File m = new File("media.txt");
		File c = new File("coustomer.txt");
		if (!(m.exists() && c.exists())) {
			Alert Empty = new Alert(AlertType.CONFIRMATION);

			Empty.setContentText("One of the Files is not found in the system .\\n do you want to creat files ??");
			Empty.showAndWait().ifPresent(response -> {
				if (response == ButtonType.OK) {
					if (!m.exists()) {
						try {
							m.createNewFile();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} else if (!c.exists()) {
						try {
							c.createNewFile();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}

				else {
					System.exit(0);
				}
			});
			;
		}
		MediaRental media = new MediaRental();
		BufferedReader MediaFile = new BufferedReader(new FileReader(m));
		BufferedReader customerFile = new BufferedReader(new FileReader(c));

		String str = "";
		while ((str = MediaFile.readLine()) != null) {
			String arrStr[] = str.split(":");
			if (arrStr[0].equals("Game")) {
				media.addGame(arrStr[1], Integer.parseInt(arrStr[2]), Double.parseDouble(arrStr[3]), arrStr[4]);
			} else if (arrStr[0].equals("Album")) {
				media.addAlbum(arrStr[1], Integer.parseInt(arrStr[2]), arrStr[3], arrStr[4], arrStr[5]);
			} else if (arrStr[0].equals("Movie")) {
				media.addMovie(arrStr[1], Integer.parseInt(arrStr[2]), arrStr[3], arrStr[4]);
			}
		}
		str = "";
		int counter = 0;

		while ((str = customerFile.readLine()) != null) {
			String arrStr[] = str.split(":");
			if (arrStr[0].equals("Coustomer")) {
				MediaRental.custms.add(new Coustomer(arrStr[1], arrStr[2], arrStr[3], Integer.parseInt(arrStr[4]),
						Integer.parseInt(arrStr[5]), arrStr[6], arrStr[7]));
				for (int i = 8; i < arrStr.length; i++) {
					System.out.println(arrStr[i]);
					MediaRental.custms.get(counter).rentedCart.add(getMedia(arrStr[i]));
				}
			}
			counter += 1;
		}
		MediaFile.close();
		customerFile.close();

	}

	private Media getMedia(String code) {
		for (Media m : MediaRental.med) {
			if (m.getCode().equals(code)) {
				return m;
			}
		}
		return null;

	}
}