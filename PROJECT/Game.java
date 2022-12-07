package PROJECT;

public class Game extends Media {

	private double weigh = 0;

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

	public Game(String title, int numbersCompies, double weigh, String code) {
		super();
		setCode(code);
		setTitle(title);
		setNumbersCompies(numbersCompies);
		setWeigh(weigh);

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
		}
	}

	public double getWeigh() {
		return weigh;
	}

	public void setWeigh(double weigh) {

		try {
			WrongNegativeException.checkNegativeNumber(weigh);
			this.weigh = weigh;

		}

		catch (WrongNegativeException ex) {
			System.out.println(ex.getMessage());
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
		return "Game:" + getTitle() + ":" + getNumbersCompies() + ":" + getWeigh() + ":" + getCode() + "\n";
	}

	public String GETDATAINFO() {
		String str = String.format("Type Media : Game \n Media Code : %s", this.getCode());
		str += String.format("\n Media Title : %s ", this.getTitle());
		str += String.format("\n Number of copies : %d ", this.getNumbersCompies());
		str += String.format("\n Weight %.2f \n ", this.getWeigh());
		str += "############################################################################\n";
		return str;
	}

	/*
	 * public boolean equals(Object o) { if
	 * (this.getCode().equals(((Game)o).getCode())) { return true; } return false; }
	 */
}
