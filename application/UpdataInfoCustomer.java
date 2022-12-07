package application;

import PROJECT.Coustomer;
import PROJECT.MediaRental;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;

public class UpdataInfoCustomer extends BorderPane {

	public UpdataInfoCustomer() {
		// TODO Auto-generated constructor stub

		setStyle("-fx-background-color:#FEFEFE;\r\n");
		HBox rootButton = new HBox(30);
		GridPane root = new GridPane();
		root.setVgap(30);
		root.setHgap(20);

		root.setAlignment(Pos.CENTER);
		rootButton.setAlignment(Pos.CENTER);

		Label id = new Label("Costomer Id :");
		id.setFont(new Font(20));

		Label name = new Label("Costomer Name :");
		name.setFont(new Font(20));

		Label address = new Label("Costomer address :");
		address.setFont(new Font(20));

		Label mobile = new Label("Costomer mobile :");
		mobile.setFont(new Font(20));

		TextField Tid = new TextField();
		Tid.setPrefSize(220, 30);
		TextField Tname = new TextField();
		Tname.setPrefSize(220, 30);

		TextField Taddress = new TextField();
		Taddress.setPrefSize(220, 30);

		TextField Tmobile = new TextField();
		Tmobile.setPrefSize(220, 30);

		root.add(id, 0, 0);
		root.add(Tid, 1, 0);
		root.add(name, 0, 1);
		root.add(Tname, 1, 1);
		root.add(address, 0, 2);
		root.add(Taddress, 1, 2);
		root.add(mobile, 0, 3);
		root.add(Tmobile, 1, 3);
		RadioButton limited = new RadioButton("LIMITED");
		RadioButton Unlimited = new RadioButton("UNLIMITED");
		ToggleGroup tg = new ToggleGroup();
		limited.setToggleGroup(tg);
		Unlimited.setToggleGroup(tg);
		root.add(limited, 1, 4);
		root.add(Unlimited, 2, 4);

		Button Update = new Button("Update & Save");
		Update.setPrefSize(270, 30);
		Update.setFont(new Font(20));
		Update.setStyle("-fx-background-color:#FEFEFE;");
		Image imgUpdate = new Image(getClass().getResourceAsStream("icons/update.png"), 50, 50, false, false);
		ImageView iconUpdate = new ImageView(imgUpdate);
		Update.setGraphic(iconUpdate);
		Update.setOnAction(e -> {
			for (Coustomer c : MediaRental.custms) {

				if (c.getId().equals(Tid.getText())) {

					c.setId(Tid.getText());
					c.setAdress(Taddress.getText());
					c.setMobile_phone(Tmobile.getText());
					c.setName(Tname.getText());
					if (limited.isSelected()) {
						c.setPlan(limited.getText());
					} else {
						c.setPlan(Unlimited.getText());

					}

				}
			}
			AlertMessage.MessageSaveData();

		});
		Button back = new Button("Back");
		back.setFont(new Font(20));
		back.setStyle("-fx-background-color:#FEFEFE;");
		Image imgBack = new Image(getClass().getResourceAsStream("icons/back.png"), 50, 50, false, false);
		ImageView iconBack = new ImageView(imgBack);
		back.setGraphic(iconBack);

		back.setPrefSize(270, 60);
		Button find = new Button("Find");
		find.setPrefSize(270, 60);

		find.setFont(new Font(20));
		find.setStyle("-fx-background-color:#FEFEFE;");
		Image imgFind = new Image(getClass().getResourceAsStream("icons/search.png"), 50, 50, false, false);
		ImageView iconFind = new ImageView(imgFind);
		find.setGraphic(iconFind);
		find.setOnAction(e -> {
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
		back.setOnAction(e -> {
			Login.STAGE.setTitle("Customer - Main");

			Login.STAGE.getScene().setRoot(new CoustomerData());

		});
		rootButton.setStyle("-fx-background-color:#876F37;\n" + "-fx-background-radius:40;\n ");
		rootButton.setPadding(new Insets(120));
		rootButton.getChildren().addAll(find, Update, back);
		setCenter(root);
		setBottom(rootButton);
	}

}
