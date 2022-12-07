package application;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public final class AlertMessage {

	public AlertMessage() {

	}

	public static void MessageWarningEmptyData() {
		Alert Empty = new Alert(AlertType.WARNING);

		Empty.setContentText("One of the fields is empty.\\n Please fill in all fields");
		Empty.showAndWait();
	}

	public static void MessageErrorCustomer() {
		Alert Empty = new Alert(AlertType.ERROR);

		Empty.setContentText("this Id already exist in data base");
		Empty.showAndWait();
	}

	public static void MessageNotExistCustomer() {
		Alert Empty = new Alert(AlertType.WARNING);
		Empty.setContentText("this ID DOES NOT  exist in data base");
		Empty.showAndWait();
	}

	public static void MessageNotExistMedia() {
		Alert Empty = new Alert(AlertType.WARNING);

		Empty.setContentText("this CODE DOES NOT  exist in data base");
		Empty.showAndWait();
	}

	public static void MessageErrorMedia() {
		Alert Empty = new Alert(AlertType.ERROR);

		Empty.setContentText("this Code already exist in data base");
		Empty.showAndWait();
	}

	public static void MessageAddCustomer() {
		Alert Empty = new Alert(AlertType.INFORMATION);

		Empty.setContentText("This customer has been successfully added");
		Empty.showAndWait();
	}

	public static void MessageDeleteCustomer() {
		Alert Empty = new Alert(AlertType.INFORMATION);

		Empty.setContentText("This customer has been successfully deleted");
		Empty.showAndWait();
	}

	public static void MessageAddMedia() {
		Alert Empty = new Alert(AlertType.INFORMATION);

		Empty.setContentText("This Media has been successfully added");
		Empty.showAndWait();
	}

	public static void MessageDeleteMedia() {
		Alert Empty = new Alert(AlertType.INFORMATION);

		Empty.setContentText("This Media has been successfully deleted");
		Empty.showAndWait();
	}

	public static void MessageSaveData() {
		Alert Empty = new Alert(AlertType.INFORMATION);

		Empty.setContentText("Data saved successfully");
		Empty.showAndWait();
	}

}
