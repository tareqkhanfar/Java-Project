package application;

import PROJECT.FileDataOutput;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public class Main extends BorderPane {

	public Main() {
		setStyle("-fx-background-color:#F5F5DC ;");

		VBox main = new VBox(20);
		main.setStyle("-fx-background-color:#654321;");

		setLeft(main);
		Label MAIN = new Label("MAIN - MENU");

		main.setAlignment(Pos.CENTER_LEFT);
		main.setPadding(new Insets(75));
		Font font = Font.font("Permanent Marker", FontWeight.BOLD, FontPosture.REGULAR, 18);

		Button b1 = new Button("Coustomer");
//F5F5DC  DCB190
		b1.setStyle("     -fx-background-radius:40;\r\n ;  -fx-background-color:#F5F5DC;");
		b1.setTextFill(Color.BLACK);
		b1.setFont(font);
		Image imgCustomer = new Image(getClass().getResourceAsStream("icons/customer.png"), 50, 50, false, false);

		ImageView iconCustomer = new ImageView(imgCustomer);
		b1.setGraphic(iconCustomer);

		Button b2 = new Button("  Media");
		b2.setTextFill(Color.BLACK);
		b2.setFont(font);

		b2.setStyle("     -fx-background-radius:40;\r\n ;  -fx-background-color:#F5F5DC;");
		Image imgMedia = new Image(getClass().getResourceAsStream("icons/mediaIcon.png"), 40, 40, false, false);

		ImageView iconMedia = new ImageView(imgMedia);
		b2.setGraphic(iconMedia);
		b2.setOnAction(e -> {

			Login.STAGE.setTitle("Media  Data");
			Login.STAGE.getScene().setRoot(new MediaData());
		});
		Button b3 = new Button("Rent");
		b3.setTextFill(Color.BLACK);
		b3.setFont(font);

		Image imgRent = new Image(getClass().getResourceAsStream("icons/rentIcon.png"), 40, 40, false, false);

		ImageView iconRent = new ImageView(imgRent);
		b3.setGraphic(iconRent);
		b3.setStyle("     -fx-background-radius:40;\r\n ;  -fx-background-color:#F5F5DC;");

		Button save = new Button("Save");
		save.setStyle("     -fx-background-radius:40;\r\n ;  -fx-background-color:#F5F5DC;");
		Image imgSave = new Image(getClass().getResourceAsStream("icons/saveIcon.png"), 40, 40, false, false);
		save.setTextFill(Color.BLACK);
		ImageView iconSave = new ImageView(imgSave);
		save.setGraphic(iconSave);

		save.setOnAction(e -> {

			FileDataOutput t = new FileDataOutput();
			Alert saveMessage = new Alert(AlertType.INFORMATION);
			saveMessage.setContentText("Data saved successfully");
			saveMessage.showAndWait();

		});
		b1.setPrefSize(220, 90);
		b2.setPrefSize(220, 90);
		b3.setPrefSize(220, 90);
		save.setPrefSize(220, 90);
		save.setFont(font);
		save.setTextFill(Color.BLACK);
		b1.setOnAction(e -> {
			Login.STAGE.setTitle("Customer Data");
			Login.STAGE.getScene().setRoot(new CoustomerData());
		});
		b3.setOnAction(e -> {

			Login.STAGE.setTitle("Rented  Data");
			Login.STAGE.getScene().setRoot(new RentedData());
		});
		MAIN.setFont(font);
		MAIN.setTextFill(Color.WHITE);
		main.getChildren().addAll(MAIN, b1, b2, b3, save);
		VBox v2 = new VBox(20);
		v2.setPadding(new Insets(53, 150, 0, 0));
		Image m = new Image(getClass().getResourceAsStream("icons/media.png"));
		Label title = new Label("Media Rental System");
		title.setTranslateX(120);
		title.setFont(new Font(50));

		ImageView im = new ImageView(m);
		v2.getChildren().addAll(im, title);

		// im.setFitHeight(500);
		// im.setFitWidth(800);
		setRight(v2);

	}

}
