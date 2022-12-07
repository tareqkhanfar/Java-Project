package PROJECT;

public class Album extends Media {
	// declere proprty of album
	private String artist = "hh ";
	private String songs = " ";

	@Override // Overrride compareTO
	public int compareTo(Media m) { // sorting by title
		if (this.getCode().compareTo(m.getCode()) > 0) {
			return 1;
		} else if (this.getCode().compareTo(m.getCode()) == 0) {
			return 0;
		} else {
			return -1;
		}

	}

	public Album(String title, int numbersCompies, String artist, String songs, String code) {
		super();
		setCode(code);
		setTitle(title);
		setNumbersCompies(numbersCompies);
		this.artist = artist;
		this.songs = songs; // add comma in end of string , until it is split by comma

	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		try {
			this.title = title;
		} catch (Exception e) {
			System.out.println("please enter correct name .");
		}
	}

	public int getNumbersCompies() {
		return NumbersCompies;
	}

	public void setNumbersCompies(int numbersCompies) {
		try {
			WrongNegativeException.checkNegativeNumber(numbersCompies); // check value if it negative or not
			NumbersCompies = numbersCompies;

		}

		catch (WrongNegativeException ex) {
			System.out.println(ex.getMessage());
		}

	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getSongs() {
		return songs;
	}

	public void setSongs(String songs) {
		this.songs = songs;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "Album:" + getTitle() + ":" + getNumbersCompies() + ":" + getArtist() + ":" + getSongs() + ":"
				+ getCode() + "\n";

	}

	/*
	 * public boolean equals(Object o) { if ((this.getCode()).equals(((Album)
	 * o).getCode())) { return true; } return false; }
	 */

	public String GETDATAINFO() {

		String str = String.format("Type Media : ALBUM \n Media Code : %s", this.getCode());
		str += String.format("\n Media Title : %s ", this.getTitle());
		str += String.format("\n Number of copies : %d ", this.getNumbersCompies());
		str += String.format("\n Artist : %s \n ", this.getArtist());
		str += String.format("\n Songs : %s \n ", this.getSongs());

		str += "############################################################################\n";
		return str;
	}

}
