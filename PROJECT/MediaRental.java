package PROJECT;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MediaRental implements MediaRentInt {

	public MediaRental() {

	}

	public static ArrayList<Coustomer> custms = new ArrayList<>(); // create array of cosumer (data base )
	public static ArrayList<Media> med = new ArrayList<>(); // create array of media and put static even all cousomer
															// accesss
	// to this data base

	public void UpdateInfoMedia(String info[]) {

		if (info[0].equals("Album")) {
			for (Media m : med) {
				if (m.getCode().equals(info[1])) {
					m.setCode(info[1]);

					m.setTitle(info[2]);
					m.setNumbersCompies(Integer.parseInt(info[3]));
					((Album) m).setArtist(info[4]);
					((Album) m).setSongs(info[5]);
					return;

				}
			}
		} else if (info[0].equals("Game")) {
			for (Media m : med) {
				if (m.getCode().equals(info[1])) {
					m.setCode(info[1]);

					m.setTitle(info[2]);
					m.setNumbersCompies(Integer.parseInt(info[3]));
					((Game) m).setWeigh(Double.parseDouble(info[4]));
					return;
				}
			}
		} else {
			for (Media m : med) {
				if (m.getCode().equals(info[1])) {
					m.setCode(info[1]);

					m.setTitle(info[2]);
					m.setNumbersCompies(Integer.parseInt(info[3]));
					((Movie) m).setRating(info[4]);
					return;
				}
			}
		}
	}

	public void addCustomer(String name, String address, String plan, String id, String mobile_phone)
			throws IllegalArgumentException {
		checkID(id);
		custms.add(new Coustomer(name, address, plan, id, mobile_phone));
	}

	private boolean checkID(String id) throws IllegalArgumentException {
		for (Coustomer c : MediaRental.custms) {
			if (c.getId().equals(id)) {
				throw new IllegalArgumentException();
			}
		}
		return true;
	}

	public String[] Search_Media(String code) {
		String infoMedia[] = new String[6];
		for (Media m : med) {
			if (m.getCode().equals(code)) {
				if (m instanceof Album) {
					infoMedia[0] = "Album";

					infoMedia[1] = m.getTitle();
					infoMedia[2] = m.getNumbersCompies() + "";
					infoMedia[3] = ((Album) m).getArtist();
					infoMedia[4] = ((Album) m).getSongs();

					return infoMedia;
				} else if (m instanceof Movie) {
					infoMedia[0] = "Movie";

					infoMedia[1] = m.getTitle();
					infoMedia[2] = m.getNumbersCompies() + "";
					infoMedia[3] = ((Movie) m).getRating();
					return infoMedia;

				} else if (m instanceof Game) {
					infoMedia[0] = "Game";

					infoMedia[1] = m.getTitle();
					infoMedia[2] = m.getNumbersCompies() + "";
					infoMedia[3] = ((Game) m).getWeigh() + "";
					return infoMedia;

				}

			}

		}
		infoMedia[0] = "";
		return infoMedia;
	}

	public void addMovie(String title, int CopiesAvalible, String rating, String code) {
		med.add(new Movie(title, CopiesAvalible, rating, code));

	}

	public void addGame(String title, int CopiesAvalible, double weigth, String code) {
		med.add(new Game(title, CopiesAvalible, weigth, code));
	}

	public void addAlbum(String title, int CopiesAvalible, String atrtist, String songs, String code) {
		med.add(new Album(title, CopiesAvalible, atrtist, songs, code));
	}

	public void setLimitedPlanLimit(int value) {
// to change value limit plane of coustomer
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the ID of coustomer : ");
		String id = in.next();
		for (Coustomer coustomer : custms) { // search coustomer name in data base
			if (coustomer.getId().equals(id) && coustomer.getPlan().equalsIgnoreCase("LIMITED")) {
				coustomer.setLimitedPlan(value);

			}
		}
		in.close();

	}

	public String getAllCoustomers() {
		Collections.sort(custms); // sorting by costm name
		String str = "";
		for (Coustomer i : custms) { // to access all media (Sequanitial )
			str += i.GetInfoCustomer(); // add all costm info. in string and separeted by new line
		}
		return str; // return all inforomation
	}

	public String getAllMedia() {
		Collections.sort(med); // sorting by media title
		String str = "";
		for (Media i : med) {// add all media info. in string and separeted by new line
			str += i.GETDATAINFO();
		}
		return str;
	}

	public Media SearchMedia(String code) {
		for (Media m : med) {
			if (m.getCode().equals(code)) {

				return m;
			}
		}
		return null;
	}

	public boolean addToCart(String coustomerId, String mediaCode) {
		System.out.println(coustomerId + "------> " + mediaCode);
		for (Coustomer coustomer : custms) {

			if (coustomer.getId().equals(coustomerId)) {

				if (coustomer.requestCart.size() == 0) {
					coustomer.requestCart.add(SearchMedia(mediaCode));
					System.out.println(
							"####################################################################################");

					System.out.println("This item has been successfully added");
					System.out.println(
							"####################################################################################");

					return true;
				} else {
					if (!contain(coustomer, mediaCode)) {
						coustomer.requestCart.add(SearchMedia(mediaCode));
						System.out.println(
								"####################################################################################");

						System.out.println("This item has been successfully added");
						System.out.println(
								"####################################################################################");

						return true;

					}
				}

				return false;

			}
		}
		return false;
	}

	private boolean contain(Coustomer c, String code) {
		for (Media m : c.requestCart) {
			if (m.getCode().equals(code)) {
				return true;
			}
		}
		return false;
	}

	public boolean removeToCart(String costomerId, String mediaCode) {
		for (Coustomer coustomer : custms) {
			if (coustomer.getId().equals(costomerId)) {
				for (int j = 0; j < coustomer.requestCart.size(); j++) {
					if ((coustomer.requestCart.get(j).equals(SearchMedia(mediaCode)))) {

						coustomer.requestCart.remove(SearchMedia(mediaCode));
						System.out.println(
								"####################################################################################");

						System.out.println("This item has been successfully removed");
						System.out.println(
								"####################################################################################");

						return true;
					}
				}
			}

		}
		return false;

	}

	public String processRequest() {
		// Scanner in = new Scanner(System.in);
		Collections.sort(custms);
		String n = "";

		for (Coustomer coustomer : custms) {
			if (coustomer.getPlan().equalsIgnoreCase("LIMITED")) {
				/*
				 * if ((coustomer.getLimitedPlan() <= coustomer.requestCart.size())) { while
				 * ((coustomer.getLimitedPlan() <= coustomer.requestCart.size()))
				 * 
				 * System.out.println("Please enter Code name ");
				 * 
				 * String code = in.next(); removeToCart(coustomer.getId(), code); }
				 */
				if (coustomer.getLimitedPlan() >= coustomer.requestCart.size()) {
					System.out.println("testt999");
					for (int j = 0; j < coustomer.requestCart.size(); j++) {

						for (Media media : med) {
							System.out.println("testt777779");

							if (coustomer.requestCart.get(j).getCode().equals(SearchMedia(media.getCode()).getCode())) {
								System.out.println("testt88888");

								if (media.getNumbersCompies() > 0) {
									coustomer.rentedCart.add(coustomer.requestCart.get(j));
									System.out.println(8855);
									media.setNumbersCompies(media.getNumbersCompies() - 1);
									coustomer.requestCart.clear();
									n += "Sending [" + media.getCode() + "]" + " to [" + coustomer.getId() + "]\n";
								}
							}
						}
					}
				}

			} else {

				for (int j = 0; j < coustomer.requestCart.size(); j++) {
					for (Media media : med) {
						if (coustomer.requestCart.get(j).getCode().equals(SearchMedia(media.getCode()).getCode())) {
							if (media.getNumbersCompies() > 0) {
								coustomer.rentedCart.add(coustomer.requestCart.get(j));
								media.setNumbersCompies(media.getNumbersCompies() - 1);
								coustomer.requestCart.clear();

								n += "Sending [" + media.getCode() + "]" + " to [" + coustomer.getId() + "]\n";

							}
						}
					}
				}
			}

		}

		return n;

	}

	public boolean returnMedia(String costomerId, String mediaCode) {
		for (Coustomer c : custms) {
			if (c.getId().equals(costomerId)) {
				c.rentedCart.remove(SearchMedia(mediaCode));
				for (Media m : med) {
					if (m.getCode().equals(mediaCode)) {

						m.setNumbersCompies(m.getNumbersCompies() + 1);

						return true;
					}
				}

			}
		}
		return false;
	}

	public void printInfo() {
		for (Coustomer c : custms) {
			System.out.println(c.getName());
			for (Media r : c.rentedCart) {
				System.out.print(r + "   ");
			}
			System.out.println();
		}
	}

	public ArrayList<String> searchMedia(String title, String rating, String artist, String songs) {
		ArrayList<String> list = new ArrayList<>();
		if (title == "" && rating == "" && artist == "" && songs == "") {
			for (Media m : med) {
				list.add(m.getCode());
			}
		} else if (title != "" && rating == "" && artist == "" && songs == "") {
			for (Media m : med) {
				if (m.getTitle().equals(title))
					list.add(m.getCode());
			}
		} else if (title != "" && rating != "" && artist == "" && songs == "") {
			for (Media m : med) {

				if (m instanceof Movie && m.getTitle().equals(title) && ((Movie) m).getRating().equals(rating))
					list.add(m.getCode());
			}
		} else if (title != "" && rating == "" && artist != "" && songs == "") {
			for (Media m : med) {
				if (m instanceof Album && m.getTitle().equals(title) && ((Album) m).getArtist().equals(artist))
					list.add(m.getCode());
			}
		} else if (title != "" && rating == "" && artist != "" && songs != "") {
			for (Media m : med) {
				if (m instanceof Album && m.getTitle().equals(title) && ((Album) m).getArtist().equals(artist)
						&& ((Album) m).getSongs().equals(songs + ","))
					list.add(m.getCode());
			}
		} else if (title == "" && rating != "" && artist == "" && songs == "") {
			for (Media m : med) {
				if (m instanceof Movie && ((Movie) m).getRating().equals(rating))
					list.add(m.getCode());
			}
		} else if (title == "" && rating == "" && artist != "" && songs == "") {
			for (Media m : med) {
				if (m instanceof Album && ((Album) m).getArtist().equals(artist))
					list.add(m.getCode());
			}
		} else if (title == "" && rating == "" && artist == "" && songs != "") {
			for (Media m : med) {
				if (m instanceof Album && ((Album) m).getSongs().equals(songs + ","))
					list.add(m.getCode());
			}
		} else if (title == "" && rating == "" && artist != "" && songs != "") {
			for (Media m : med) {
				if (m instanceof Album && ((Album) m).getArtist().equals(artist)
						&& ((Album) m).getSongs().equals(songs + ","))
					list.add(m.getCode());
			}
		}
		Collections.sort(list);
		return list;
	}

	public void getAllRented() {
		for (Coustomer c : custms) {
			System.out.println(c.getName() + ">>>" + c.rentedCart);
		}
	}

}
