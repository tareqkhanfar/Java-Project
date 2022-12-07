package application;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public class RentedData extends BorderPane {
	public RentedData() {

		Image img = new Image(getClass().getResourceAsStream("icons/bg4.jpeg"), 1400, 710, false, false);
		BackgroundImage bImg = new BackgroundImage(img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

		Background bGround = new Background(bImg);
		setBackground(bGround);

		Label MAIN = new Label("MAIN MENU FOR RENT MEDIA");
		MAIN.setTextFill(Color.WHITE);
		MAIN.setStyle("-fx-background-color: #504E4E;\n" + " -fx-background-radius:40;\n");
		Font font = Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 50);

		MAIN.setFont(font);

		MAIN.setPadding(new Insets(20));

		VBox root = new VBox(30);
		Button rentedMedia = new Button("    Rent Media\n    and Process it");
		Image processMedia = new Image(getClass().getResourceAsStream("icons/process2.png"), 50, 50, false, false);
		ImageView iconprocessMedia = new ImageView(processMedia);
		rentedMedia.setGraphic(iconprocessMedia);
		rentedMedia.setOnAction(e -> {
			Login.STAGE.setTitle("Rented Media");

			Login.STAGE.getScene().setRoot(new RentedMedia());

		});
		Button request = new Button("Requested cart Media");
		Image requestMedia = new Image(getClass().getResourceAsStream("icons/request.png"), 50, 50, false, false);
		ImageView iconrequestMedia = new ImageView(requestMedia);
		request.setGraphic(iconrequestMedia);
		request.setOnAction(e -> {
			Login.STAGE.setTitle("Request Media");

			Login.STAGE.getScene().setRoot(new RequestMedia());

		});

		Button rentCart = new Button("Rented cart Media");
		Image rentMedia = new Image(getClass().getResourceAsStream("icons/rent.png"), 50, 50, false, false);
		ImageView iconrentMedia = new ImageView(rentMedia);
		rentCart.setGraphic(iconrentMedia);
		rentCart.setOnAction(e -> {
			Login.STAGE.setTitle("Rented Cart Media");

			Login.STAGE.getScene().setRoot(new RentCart());

		});
		Button Return = new Button("Return Rented media");
		Image ReturnMedia = new Image(getClass().getResourceAsStream("icons/deletem.png"), 50, 50, false, false);
		ImageView iconReturnMedia = new ImageView(ReturnMedia);
		Return.setGraphic(iconReturnMedia);
		Return.setOnAction(e -> {
			Login.STAGE.setTitle("Return Media");

			Login.STAGE.getScene().setRoot(new ReturnMedia());
		});
		Button exit = new Button("Return to main page");
		Image exitMedia = new Image(getClass().getResourceAsStream("icons/back2.png"), 50, 50, false, false);
		ImageView iconexitMedia = new ImageView(exitMedia);
		exit.setGraphic(iconexitMedia);
		exit.setOnAction(e -> {
			Login.STAGE.setTitle("Main - ");

			Login.STAGE.getScene().setRoot(new Main());

		});
		rentedMedia.setPrefSize(215, 90);
		request.setPrefSize(215, 90);
		rentCart.setPrefSize(215, 90);
		Return.setPrefSize(215, 90);
		exit.setPrefSize(215, 90);
		root.setPadding(new Insets(60));
		rentedMedia.setFont(new Font(14));
		request.setFont(new Font(14));

		rentCart.setFont(new Font(14));

		Return.setFont(new Font(14));

		exit.setFont(new Font(14));

		root.getChildren().addAll(rentedMedia, request, rentCart, Return, exit);
		root.setStyle("-fx-background-color:rgba(0,0,0,0);");

		setLeft(root);
		setCenter(MAIN);
	}

}
