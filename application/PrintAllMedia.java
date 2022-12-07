package application;

import PROJECT.MediaRental;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class PrintAllMedia extends BorderPane {

	public PrintAllMedia() {
		// TODO Auto-generated constructor stub

		setStyle("-fx-background-color:#bdb76b;\r\n");

		setPadding(new Insets(40));
		Button back = new Button("Back");
		back.setFont(new Font(20));
		Image imgBack = new Image(getClass().getResourceAsStream("icons/back.png"), 50, 50, false, false);
		ImageView iconBack = new ImageView(imgBack);
		back.setGraphic(iconBack);
		back.setPrefSize(150, 75);

		Button show = new Button("Show Data");
		back.setFont(new Font(20));
		Image imgShow = new Image(getClass().getResourceAsStream("icons/show.png"), 50, 50, false, false);
		ImageView iconShow = new ImageView(imgShow);
		show.setGraphic(iconShow);
		show.setPrefSize(150, 75);

		VBox buttons = new VBox();
		buttons.getChildren().addAll(back, show);
		setRight(buttons);
		back.setOnAction(e -> {
			Login.STAGE.setTitle("Print All Media");

			Login.STAGE.getScene().setRoot(new MediaData());

		});
		TextArea ta = new TextArea();

		show.setOnAction(e -> {
			MediaRental re = new MediaRental();

			ta.setText(re.getAllMedia());
		});
		setCenter(ta);

	}

}
