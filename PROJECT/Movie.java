package PROJECT;

public class Movie extends Media {

	private String rating;

	public Movie(String title, int numbersCompies, String rating, String code) {
		super();
		setCode(code);
		setTitle(title);
		setNumbersCompies(numbersCompies);
		setRating(rating);

	}

	@Override
	public int compareTo(Media m) {
		if (this.getCode().compareTo(m.getCode()) > 0) {
			return 1;
		} else if (this.getCode().compareTo(m.getCode()) == 0) {
			return 0;
		} else {
			return -1;
		}

	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getNumbersCompies() {
		return NumbersCompies;
	}

	public void setNumbersCompies(int numbersCompies) {
		try {
			WrongNegativeException.checkNegativeNumber(numbersCompies);
			NumbersCompies = numbersCompies;

		}

		catch (WrongNegativeException ex) {
			System.out.println(ex.getMessage());
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		if (rating.equals("DR") || rating.equals("HR") || rating.equals("AC")) {
			this.rating = rating;
		}

	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "Movie:" + getTitle() + ":" + getNumbersCompies() + ":" + getRating() + ":" + getCode() + "\n";
	}

	/*
	 * public boolean equals(Object o) { if (this.getCode().equals(((Movie)
	 * o).getCode())) { return true; } return false; }
	 */
	public String GETDATAINFO() {
		String str = String.format("Type Media : Movie \n Media Code : %s", this.getCode());
		str += String.format("\n Media Title : %s ", this.getTitle());
		str += String.format("\n Number of copies : %d ", this.getNumbersCompies());
		str += String.format("\n Rating %s \n ", this.getRating());
		str += "############################################################################\n";
		return str;
	}

}
