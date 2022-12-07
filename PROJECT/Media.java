package PROJECT;

public abstract class Media implements Comparable<Media> {
	public Media() {

	}

	protected int NumbersCompies;
	protected String title;
	protected String code;

	public abstract String getCode();

	public abstract void setCode(String code);

	public abstract int getNumbersCompies();

	public abstract void setTitle(String title);

	public abstract String getTitle();

	public abstract void setNumbersCompies(int numbersCompies);

	@Override
	public abstract String toString();

	/*
	 * @Override public abstract boolean equals(Object o);
	 */
	public abstract String GETDATAINFO();

	public static boolean CheckCodeMedia(String code) throws IllegalArgumentException {
		for (Media m : MediaRental.med) {
			if (m.getCode().equals(code)) {
				throw new IllegalArgumentException();
			}
		}
		return true;

	}
}
