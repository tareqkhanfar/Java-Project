package application;

import PROJECT.Media;
import PROJECT.MediaRental;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

public class DeleteMedia extends GridPane {

	public DeleteMedia() {
		setStyle("-fx-background-color:#FFC1C1;\r\n");

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
		// TtypeMedia.setDisable(true);

		Label typeMedia = new Label("Type Media : ");
		typeMedia.setFont(new Font(20));
		TextField TtypeMedia = new TextField();
		TtypeMedia.setPrefSize(180, 30);

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

		TextField Trating = new TextField();
		Trating.setPrefSize(180, 30);

		Label rating = new Label("Rating :");
		rating.setFont(new Font(20));
		Button remove = new Button("Remove");
		remove.setPrefSize(160, 60);
		remove.setFont(new Font(20));
		remove.setStyle("-fx-background-color:rgba(0,0,0,0);");
		Image imgRemove = new Image(getClass().getResourceAsStream("icons/remove.png"), 50, 50, false, false);
		ImageView iconRemove = new ImageView(imgRemove);
		remove.setGraphic(iconRemove);
		remove.setOnAction(e -> {
			for (Media m : MediaRental.med) {
				if (Tcode.getText().equals(m.getCode())) {
					MediaRental.med.remove(m);
					AlertMessage.MessageDeleteMedia();
					Ttitle.clear();
					Tcode.clear();
					TnumberOfCopies.clear();
					Tartist.clear();
					Tsong.clear();
					Tweigh.clear();
					Trating.clear();

					break;
				}
			}

		});
		Button back = new Button("Back");
		back.setFont(new Font(20));
		back.setStyle("-fx-background-color:rgba(0,0,0,0);");
		Image imgBack = new Image(getClass().getResourceAsStream("icons/back.png"), 50, 50, false, false);
		ImageView iconBack = new ImageView(imgBack);
		back.setGraphic(iconBack);

		back.setPrefSize(130, 60);
		Button find = new Button("Find");
		find.setFont(new Font(20));
		find.setStyle("-fx-background-color:rgba(0,0,0,0);");
		Image imgFind = new Image(getClass().getResourceAsStream("icons/search.png"), 50, 50, false, false);
		ImageView iconFind = new ImageView(imgFind);
		find.setGraphic(iconFind);
		////////////////////////////////////////////////////////////////////////////
		find.setOnAction(e -> {
			if (Tcode.getText() == "") {
				AlertMessage.MessageWarningEmptyData();
				return;
			} else {
				MediaRental data = new MediaRental();
				String info[] = data.Search_Media(Tcode.getText());
				if (info[0] == "") {
					AlertMessage.MessageNotExistMedia();
					return;
				}
				if (info[0].equals("Album")) {

					Tartist.setDisable(false);
					Tsong.setDisable(false);
					Tweigh.setDisable(true);
					Trating.setDisable(true);
					TtypeMedia.setText(info[0]);
					Ttitle.setText(info[1]);
					TnumberOfCopies.setText(info[2]);
					Tartist.setText(info[3]);
					Tsong.setText(info[4]);

				} else if (info[0].equals("Game")) {
					Tartist.setDisable(true);
					Tsong.setDisable(true);
					Tweigh.setDisable(false);
					Trating.setDisable(true);
					TtypeMedia.setText(info[0]);

					Ttitle.setText(info[1]);
					TnumberOfCopies.setText(info[2]);
					Tweigh.setText(info[3]);

				} else if (info[0].equals("Movie")) {
					Tartist.setDisable(true);
					Tsong.setDisable(true);
					Tweigh.setDisable(true);
					Trating.setDisable(false);
					TtypeMedia.setText(info[0]);

					Ttitle.setText(info[1]);
					TnumberOfCopies.setText(info[2]);
					Trating.setText(info[3]);
				}
			}
		});
		add(code, 0, 0);
		add(Tcode, 1, 0);
		add(typeMedia, 0, 1);
		add(TtypeMedia, 1, 1);

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
		add(Trating, 1, 7);

		back.setOnAction(e -> {
			Login.STAGE.setTitle("Media - Main");

			Login.STAGE.getScene().setRoot(new MediaData());

		});
		add(find, 0, 8);
		add(remove, 1, 8);
		add(back, 2, 8);

	}

}
