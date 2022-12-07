package application;

import PROJECT.Coustomer;
import PROJECT.MediaRental;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

public class SearchById extends GridPane {

	public SearchById() {
		// TODO Auto-generated constructor stub

		setVgap(30);
		setHgap(20);

		setAlignment(Pos.CENTER);

		Label id = new Label("Costomer Id :");

		id.setFont(new Font(20));

		Label name = new Label("Costomer Name :");
		name.setFont(new Font(20));

		Label address = new Label("Costomer address :");
		address.setFont(new Font(20));

		Label mobile = new Label("Costomer mobile :");
		mobile.setFont(new Font(20));

		TextField Tid = new TextField();
		Tid.setPrefSize(170, 30);
		TextField Tname = new TextField();
		Tname.setPrefSize(170, 30);

		TextField Taddress = new TextField();
		Taddress.setPrefSize(170, 30);

		TextField Tmobile = new TextField();
		Tmobile.setPrefSize(170, 30);

		add(id, 0, 0);
		add(Tid, 1, 0);
		add(name, 0, 1);
		add(Tname, 1, 1);
		add(address, 0, 2);
		add(Taddress, 1, 2);
		add(mobile, 0, 3);
		add(Tmobile, 1, 3);
		RadioButton limited = new RadioButton("LIMITED");
		RadioButton Unlimited = new RadioButton("UNLIMITED");
		add(limited, 1, 4);

		add(Unlimited, 2, 4);

		Button search = new Button("Search");
		search.setFont(new Font(20));
		search.setStyle("-fx-background-color:rgba(0,0,0,0);");
		Image imgSearch = new Image(getClass().getResourceAsStream("icons/search.png"), 50, 50, false, false);
		ImageView iconSearch = new ImageView(imgSearch);
		search.setGraphic(iconSearch);
		search.setOnAction(e -> {
			if (Tid.getText() == "") {
				AlertMessage.MessageWarningEmptyData();
			} else {
				for (Coustomer c : MediaRental.custms) {
					if (c.getId().equals(Tid.getText())) {
						Tname.setText(c.getName());
						Tmobile.setText(c.getMobile_phone());
						Taddress.setText(c.getAdress());

						if (c.getPlan().equals("LIMITED")) {
							limited.setSelected(true);
						} else {
							Unlimited.setSelected(true);
						}
						return;

					}
				}
				AlertMessage.MessageNotExistCustomer();

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
			Login.STAGE.setTitle("Customer - Main");

			Login.STAGE.getScene().setRoot(new CoustomerData());

		});
		add(search, 1, 5);
		add(back, 2, 5);

	}

}
