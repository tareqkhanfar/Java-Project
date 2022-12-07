package PROJECT;

public class WrongNegativeException extends Exception {

	public WrongNegativeException() {

	}

	@Override
	public String getMessage() {

		return "error = \"Please DONT ENTER VALUR NEGATIVE !!! \";";
	}

	public static void checkNegativeNumber(int num) throws WrongNegativeException {
		if (num < 0) {

			throw new WrongNegativeException();
		}
	}

	public static void checkNegativeNumber(double num) throws WrongNegativeException {
		if (num < 0) {

			throw new WrongNegativeException();
		}
	}

}
