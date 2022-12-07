package application;

import PROJECT.Media;
import PROJECT.MediaRental;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;

public class AddNewMedia extends GridPane {

	public AddNewMedia() {

		setVgap(30);
		setHgap(20);

		setAlignment(Pos.CENTER);

		Label code = new Label("Media Code :");
		code.setFont(new Font(20));
		Label numberOfCopies = new Label("Number of copies :");
		numberOfCopies.setFont(new Font(20));

		Label title = new Label("Media Title :");
		title.setFont(new Font(20));

		TextField Ttitle = new TextField();
		Ttitle.setPrefSize(180, 30);

		TextField Tcode = new TextField();
		Tcode.setPrefSize(180, 30);

		TextField TnumberOfCopies = new TextField();
		TnumberOfCopies.setPrefSize(180, 30);

		Label typeMedia = new Label("Type Media : ");
		typeMedia.setFont(new Font(20));

		ComboBox media = new ComboBox();

		media.getItems().addAll("Album", "Game", "Movie");

		///////////////////////////////////////////////////////////////////////////
		Label artist = new Label("Artist :");
		artist.setFont(new Font(20));

		TextField Tartist = new TextField();
		Tartist.setPrefSize(180, 30);

		Label songs = new Label("songs :");
		songs.setFont(new Font(20));

		TextField Tsong = new TextField();
		Tsong.setPrefSize(180, 30);

		Label weigh = new Label("weigh :");
		weigh.setFont(new Font(20));

		TextField Tweigh = new TextField();
		Tweigh.setPrefSize(180, 30);

		Label rating = new Label("Rating :");
		rating.setFont(new Font(20));

		HBox Rating = new HBox(10);
		RadioButton rb1 = new RadioButton("HR");
		RadioButton rb2 = new RadioButton("DC");
		RadioButton rb3 = new RadioButton("AC");
		ToggleGroup tg = new ToggleGroup();
		rb1.setToggleGroup(tg);
		rb2.setToggleGroup(tg);
		rb3.setToggleGroup(tg);
		Rating.getChildren().addAll(rb1, rb2, rb3);
		////////////////////////////////////////////////////////////////////////////
		media.setOnAction(e -> {
			if (media.getValue().toString().equals("Album")) {
				Tartist.setDisable(false);
				Tsong.setDisable(false);
				Tweigh.setDisable(true);
				Rating.setDisable(true);

			} else if (media.getValue().toString().equals("Game")) {
				Tartist.setDisable(true);
				Tsong.setDisable(true);
				Tweigh.setDisable(false);
				Rating.setDisable(true);

			} else if (media.getValue().toString().equals("Movie")) {
				Tartist.setDisable(true);
				Tsong.setDisable(true);
				Tweigh.setDisable(true);
				Rating.setDisable(false);
			}
		});
		add(typeMedia, 0, 0);
		add(media, 1, 0);
		add(code, 0, 1);
		add(Tcode, 1, 1);

		add(title, 0, 2);
		add(Ttitle, 1, 2);

		add(numberOfCopies, 0, 3);
		add(TnumberOfCopies, 1, 3);

		add(weigh, 0, 4);
		add(Tweigh, 1, 4);

		add(artist, 0, 5);
		add(Tartist, 1, 5);
		add(songs, 0, 6);
		add(Tsong, 1, 6);

		add(rating, 0, 7);
		add(Rating, 1, 7);

		Button add = new Button("Add");
		add.setFont(new Font(20));
		add.setStyle("-fx-background-color:rgba(0,0,0,0);");
		Image imgAdd = new Image(getClass().getResourceAsStream("icons/add.png"), 50, 50, false, false);
		ImageView iconAdd = new ImageView(imgAdd);
		add.setGraphic(iconAdd);

		add.setPrefSize(120, 60);
		add.setOnAction(e -> {
			try {
				Media.CheckCodeMedia(Tcode.getText());
				MediaRental md = new MediaRental();
				if (media.getValue().toString().equals("Album")) {
					if (Ttitle.getText() == "" || TnumberOfCopies.getText() == "" || Tartist.getText() == ""
							|| Tsong.getText() == "" || Tcode.getText() == "") { // this to check if any field equal
																					// null
						AlertMessage.MessageWarningEmptyData();
					} else { // this to add album in database
						md.addAlbum(Ttitle.getText(), Integer.parseInt(TnumberOfCopies.getText()), Tartist.getText(),
								Tsong.getText() + ",", Tcode.getText());
						AlertMessage.MessageAddMedia();
						Ttitle.clear();
						Tcode.clear();
						TnumberOfCopies.clear();
						Tartist.clear();
						Tsong.clear();
						Tweigh.clear();
						rb1.setSelected(false);
						rb2.setSelected(false);
						rb3.setSelected(false);

					}

				} else if (media.getValue().toString().equals("Game")) {
					if (Ttitle.getText() == "" || TnumberOfCopies.getText() == "" || Tweigh.getText() == ""
							|| Tcode.getText() == "") { // this to check if any field equal null
						AlertMessage.MessageWarningEmptyData();
					} else {

						md.addGame(Ttitle.getText(), Integer.parseInt(TnumberOfCopies.getText()),
								Double.parseDouble(Tweigh.getText()), Tcode.getText());
						AlertMessage.MessageAddMedia();
						Ttitle.clear();
						Tcode.clear();
						TnumberOfCopies.clear();
						Tartist.clear();
						Tsong.clear();
						Tweigh.clear();
						rb1.setSelected(false);
						rb2.setSelected(false);
						rb3.setSelected(false);

					}

				} else if (media.getValue().toString().equals("Movie")) {

					String RATING = "";
					if (rb1.isSelected()) {
						RATING = "HR";
					} else if (rb2.isSelected()) {
						RATING = "DC";
					} else {
						RATING = "AC";

					}

					if (Ttitle.getText() == "" || TnumberOfCopies.getText() == "" || RATING == ""
							|| Tcode.getText() == "") {
						// this to check if any field equal null
						AlertMessage.MessageWarningEmptyData();

					} else {
						md.addMovie(Ttitle.getText(), Integer.parseInt(TnumberOfCopies.getText()), RATING,
								Tcode.getText());
						AlertMessage.MessageAddMedia();
						Ttitle.clear();
						Tcode.clear();
						TnumberOfCopies.clear();
						Tartist.clear();
						Tsong.clear();
						Tweigh.clear();
						rb1.setSelected(false);
						rb2.setSelected(false);
						rb3.setSelected(false);

					}

				}
			} catch (IllegalArgumentException ex) {
				AlertMessage.MessageErrorMedia();

			}

		});
		Button back = new Button("Back");
		back.setFont(new Font(20));
		back.setStyle("-fx-background-color:rgba(0,0,0,0);");
		Image imgBack = new Image(getClass().getResourceAsStream("icons/back.png"), 50, 50, false, false);
		ImageView iconBack = new ImageView(imgBack);
		back.setGraphic(iconBack);

		back.setPrefSize(130, 60);

		back.setOnAction(e -> {
			Login.STAGE.setTitle("Media - Main");

			Login.STAGE.getScene().setRoot(new MediaData());

		});

		add(add, 1, 8);
		add(back, 2, 8);

	}

}
