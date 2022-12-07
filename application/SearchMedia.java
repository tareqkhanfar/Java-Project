package application;

import java.util.ArrayList;

import PROJECT.Media;
import PROJECT.MediaRental;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class SearchMedia extends BorderPane {

	public SearchMedia() {

		GridPane root = new GridPane();
		root.setVgap(20);
		root.setHgap(20);
		root.setPadding(new Insets(30));
		Label title = new Label("Media Title :");
		title.setTextFill(Color.WHITE);
		TextField Ttitle = new TextField();
		Ttitle.setPrefSize(180, 30);
		title.setFont(new Font(20));

		Label artist = new Label("Artist :");
		TextField Tartist = new TextField();
		Tartist.setPrefSize(180, 30);
		artist.setFont(new Font(20));
		artist.setTextFill(Color.WHITE);

		Label songs = new Label("songs :");
		songs.setTextFill(Color.WHITE);

		TextField Tsong = new TextField();
		Tsong.setPrefSize(180, 30);
		songs.setFont(new Font(20));

		TextField Trating = new TextField();
		Trating.setPrefSize(180, 30);

		Label rating = new Label("Rating :");
		rating.setTextFill(Color.WHITE);

		rating.setFont(new Font(20));

		Button search = new Button("Search");
		search.setFont(new Font(20));
		search.setPrefSize(170, 90);
		Button back = new Button("back");
		back.setPrefSize(170, 90);
		back.setFont(new Font(20));

		back.setStyle("-fx-background-color:#FEFEFE;");
		search.setStyle("-fx-background-color:#FEFEFE;");

		root.addRow(0, title, Ttitle);
		root.addRow(1, artist, Tartist);
		root.addRow(2, songs, Tsong);
		root.addRow(3, rating, Trating);
		root.addRow(4, search);
		root.addRow(5, back);
		TextArea data = new TextArea();
		MediaRental m = new MediaRental();

		search.setOnAction(e -> {

			ArrayList<String> list = m.searchMedia(Ttitle.getText(), Trating.getText(), Tartist.getText(),
					Tsong.getText());

			String temp = "";
			for (String i : list) {
				for (Media M : MediaRental.med) {
					if (i.equals(M.getCode())) {
						temp += M.GETDATAINFO();
					}
				}
			}

			data.setText(temp);

		});
		data.setFont(new Font(14));
		Image imgBack = new Image(getClass().getResourceAsStream("icons/back.png"), 50, 50, false, false);
		ImageView iconBack = new ImageView(imgBack);
		back.setGraphic(iconBack);
		back.setOnAction(e -> {
			Login.STAGE.setTitle("Media - Main");

			Login.STAGE.getScene().setRoot(new MediaData());

		});
		root.setStyle("-fx-background-color:#723303;");
		data.setPrefWidth(900);
		setRight(data);
		setLeft(root);

	}

}
