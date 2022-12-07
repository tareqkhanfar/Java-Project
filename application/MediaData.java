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

public class MediaData extends BorderPane {
	public MediaData() {
		Image img = new Image(getClass().getResourceAsStream("icons/bg3.jpg"), 1400, 710, false, false);
		BackgroundImage bImg = new BackgroundImage(img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

		Background bGround = new Background(bImg);
		setBackground(bGround);
		Label MAIN = new Label("MAIN MENU FOR MEDIA");
		MAIN.setTextFill(Color.WHITE);
		MAIN.setStyle("-fx-background-color: #0B3B45;\n" + " -fx-background-radius:40;\n");
		Font font = Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 50);

		MAIN.setFont(font);

		MAIN.setPadding(new Insets(20));

		VBox root = new VBox(15);
		Button b1 = new Button("Add new Media");
		Image addMedia = new Image(getClass().getResourceAsStream("icons/addm.png"), 50, 50, false, false);
		ImageView iconaddMedia = new ImageView(addMedia);
		b1.setGraphic(iconaddMedia);
		b1.setOnAction(e -> {
			Login.STAGE.setTitle("Add new Media");

			Login.STAGE.getScene().setRoot(new AddNewMedia());

		});
		Button b2 = new Button("Delete Media");
		Image delMedia = new Image(getClass().getResourceAsStream("icons/deletem.png"), 50, 50, false, false);
		ImageView icondelMedia = new ImageView(delMedia);
		b2.setGraphic(icondelMedia);
		b2.setOnAction(e -> {
			Login.STAGE.setTitle("Delete Media");

			Login.STAGE.getScene().setRoot(new DeleteMedia());

		});

		Button b3 = new Button("Update Information\n    about Media");
		Image UpdMedia = new Image(getClass().getResourceAsStream("icons/update2.png"), 50, 50, false, false);
		ImageView iconUpdMedia = new ImageView(UpdMedia);
		b3.setGraphic(iconUpdMedia);
		b3.setOnAction(e -> {
			Login.STAGE.setTitle("Update Media ");

			Login.STAGE.getScene().setRoot(new UpdateInfoMedia());

		});
		Button b4 = new Button("Search a Media\n      by code");
		Image searchMedia = new Image(getClass().getResourceAsStream("icons/searchm.png"), 50, 50, false, false);
		ImageView iconsearchMedia = new ImageView(searchMedia);
		b4.setGraphic(iconsearchMedia);
		b4.setOnAction(e -> {
			Login.STAGE.setTitle("Search Media By Code");

			Login.STAGE.getScene().setRoot(new SearchByCode());

		});
		Button b5 = new Button("          Print All\n   Media information");
		Image printMedia = new Image(getClass().getResourceAsStream("icons/show2.png"), 50, 50, false, false);
		ImageView iconprintMedia = new ImageView(printMedia);
		b5.setGraphic(iconprintMedia);
		b5.setOnAction(e -> {
			Login.STAGE.setTitle("Print All Media ");

			Login.STAGE.getScene().setRoot(new PrintAllMedia());

		});

		Button b6 = new Button("Return to main page");
		Image backMedia = new Image(getClass().getResourceAsStream("icons/back2.png"), 50, 50, false, false);
		ImageView iconbackMedia = new ImageView(backMedia);
		b6.setGraphic(iconbackMedia);
		b6.setOnAction(e -> {
			Login.STAGE.setTitle("Main");

			Login.STAGE.getScene().setRoot(new Main());
		});

		Button b7 = new Button("Search Media");
		Image searchMedia2 = new Image(getClass().getResourceAsStream("icons/searchm.png"), 50, 50, false, false);
		ImageView iconsearchMedia2 = new ImageView(searchMedia2);
		b7.setGraphic(iconsearchMedia2);
		b7.setOnAction(e -> {
			Login.STAGE.setTitle("Search Media");

			Login.STAGE.getScene().setRoot(new SearchMedia());

		});
		b1.setPrefSize(215, 90);
		b2.setPrefSize(215, 90);
		b3.setPrefSize(215, 90);
		b4.setPrefSize(215, 90);
		b5.setPrefSize(215, 90);
		b6.setPrefSize(215, 90);
		b7.setPrefSize(215, 90);

		b1.setFont(new Font(14));
		b2.setFont(new Font(14));

		b3.setFont(new Font(14));

		b4.setFont(new Font(14));

		b5.setFont(new Font(14));

		b6.setFont(new Font(14));
		b7.setFont(new Font(14));

		root.setPadding(new Insets(60));

		// root.setStyle("-fx-background-color: #EC498F;\r\n");
		root.setStyle("-fx-background-color:rgba(0,0,0,0);");
		root.getChildren().addAll(b1, b2, b3, b4, b5, b7, b6);
		setLeft(root);
		setCenter(MAIN);
	}

}
