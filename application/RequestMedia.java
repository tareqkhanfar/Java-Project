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
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

public class RequestMedia extends GridPane {

	public RequestMedia() {
		// TODO Auto-generated constructor stub

		setStyle("-fx-background-color:#faf0e6;\r\n");

		setVgap(15);
		setHgap(15);
		setPadding(new Insets(40));
		setAlignment(Pos.TOP_CENTER);

		Label id = new Label("Costomer Id :");
		id.setFont(new Font(20));
		TextField Tid = new TextField();
		Tid.setPrefSize(170, 30);

		TextArea AreaC = new TextArea();
		AreaC.setPrefSize(400, 400);
		Button print = new Button("Print");
		print.setFont(new Font(20));
		print.setStyle("-fx-background-color:rgba(0,0,0,0);");
		Image imgprint = new Image(getClass().getResourceAsStream("icons/show.png"), 50, 50, false, false);
		ImageView iconprint = new ImageView(imgprint);
		print.setGraphic(iconprint);
		print.setPrefSize(150, 60);
		print.setOnAction(e -> {
			String str = "";
			for (Coustomer c : MediaRental.custms) {
				if (c.getId().equals(Tid.getText())) {
					for (Media s : c.requestCart) {
						str += s.GETDATAINFO() + "\n";
					}
				}
			}
			AreaC.setText(str);
		});

		Button back = new Button("Back");
		back.setFont(new Font(20));
		back.setStyle("-fx-background-color:rgba(0,0,0,0);");
		Image imgBack = new Image(getClass().getResourceAsStream("icons/back.png"), 50, 50, false, false);
		ImageView iconBack = new ImageView(imgBack);
		back.setGraphic(iconBack);
		back.setPrefSize(150, 60);
		back.setOnAction(e -> {
			Login.STAGE.setTitle("Rented Main");

			Login.STAGE.getScene().setRoot(new RentedData());

		});

		add(id, 0, 0);
		add(Tid, 1, 0);
		add(AreaC, 1, 2);

		add(print, 1, 4);
		add(back, 2, 4);

	}

}
