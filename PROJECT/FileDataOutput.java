package PROJECT;

import java.io.File;
import java.io.FileWriter;

public class FileDataOutput {

	public FileDataOutput() {
		try {

			File m = new File("media.txt");
			File c = new File("coustomer.txt");
			FileWriter outMedia = new FileWriter(m, false);
			FileWriter outCustomer = new FileWriter(c, false);

			for (Media me : MediaRental.med) {
				outMedia.write(me.toString());
			}
			outMedia.close();
			for (Coustomer co : MediaRental.custms) {
				outCustomer.write(co.toString() + printRented(co));
			}

			outCustomer.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private String printRented(Coustomer c) {
		String n = "";
		for (Media re : c.rentedCart) {
			if (re instanceof Album) {
				n += re.getCode() + ":";

			} else if (re instanceof Game) {
				n += re.getCode() + ":";
			} else {
				n += re.getCode() + ":";

			}
		}
		return n + "\n";

	}

}
