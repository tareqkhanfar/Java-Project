package application;

import PROJECT.Coustomer;
import PROJECT.Media;
import PROJECT.MediaRental;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class ReturnMedia extends BorderPane {
	TextField Tid = new TextField();

	public ReturnMedia() {
		// TODO Auto-generated constructor stub

		setStyle("-fx-background-color:#FEFEFE;\r\n");
		VBox rootButton = new VBox(30);
		GridPane root = new GridPane();

		Label id = new Label("Costomer Id :");
		id.setFont(new Font(20));

		Tid.setPrefSize(170, 30);
		Label code = new Label("Media Code :");
		code.setFont(new Font(20));

		TextField Tcode = new TextField();
		Tcode.setPrefSize(170, 30);
		TextArea AreaM = new TextArea();
		AreaM.setPrefSize(400, 250);
		Button print = new Button("Print");
		print.setFont(new Font(20));

		print.setStyle("-fx-background-color:#FEFEFE;");
		Image imgprint = new Image(getClass().getResourceAsStream("icons/show.png"), 50, 50, false, false);
		ImageView iconprint = new ImageView(imgprint);
		print.setGraphic(iconprint);
		print.setPrefSize(700, 60);
		print.setOnAction(e -> {
			System.out.println("hello5" + RENTED_MEDIA());
			AreaM.setText(RENTED_MEDIA());
		});

		Button Return = new Button("Return Media");

		Return.setFont(new Font(20));
		Return.setStyle("-fx-background-color:#FEFEFE;");
		Image imgReturn = new Image(getClass().getResourceAsStream("icons/remove.png"), 50, 50, false, false);
		ImageView iconReturn = new ImageView(imgReturn);
		Return.setGraphic(iconReturn);
		Return.setPrefSize(700, 60);
		Return.setOnAction(e -> {
			MediaRental m = new MediaRental();
			m.returnMedia(Tid.getText(), Tcode.getText());
			AreaM.setText(RENTED_MEDIA());
		});

		Image imgclear = new Image(getClass().getResourceAsStream("icons/clear.png"), 50, 50, false, false);
		ImageView iconclear = new ImageView(imgclear);

		Button back = new Button("Back");
		back.setFont(new Font(20));
		back.setStyle("-fx-background-color:#FEFEFE;");
		Image imgBack = new Image(getClass().getResourceAsStream("icons/back.png"), 50, 50, false, false);
		ImageView iconBack = new ImageView(imgBack);
		back.setGraphic(iconBack);
		back.setPrefSize(700, 60);
		back.setOnAction(e -> {
			Login.STAGE.setTitle("Rented Main");

			Login.STAGE.getScene().setRoot(new RentedData());

		});

		root.add(id, 0, 0);
		root.add(Tid, 1, 0);

		root.add(AreaM, 1, 2);
		root.add(code, 0, 3);
		root.add(Tcode, 1, 3);

		rootButton.getChildren().addAll(print, Return, back);
		root.setStyle("-fx-background-color:#3CC1C1;\r\n");
		rootButton.setStyle("-fx-background-color:#37267C;\n" + "-fx-background-radius:40;\n ");
		root.setPadding(new Insets(50));
		rootButton.setPadding(new Insets(70));
		rootButton.setAlignment(Pos.CENTER);
		root.setVgap(30);
		root.setHgap(30);

		setRight(rootButton);
		setLeft(root);
	}

	private String RENTED_MEDIA() {
		String str = "";
		for (Coustomer c : MediaRental.custms) {
			if (c.getId().equals(Tid.getText())) {
				for (Media s : c.rentedCart) {
					str += s.GETDATAINFO() + "\n";
				}
			}
		}
		return str;
	}

}
