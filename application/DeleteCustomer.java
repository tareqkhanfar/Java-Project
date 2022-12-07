package application;

import PROJECT.Coustomer;
import PROJECT.MediaRental;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class DeleteCustomer extends BorderPane {

	public DeleteCustomer() {
		// TODO Auto-generated constructor stub

		VBox rootButton = new VBox(30);
		GridPane root = new GridPane();
		setStyle("-fx-background-color:#FEFEFE;\n");
		root.setStyle("-fx-background-color:#D3D3D4;\n" + "-fx-background-radius:40;\n ");

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

		Button remove = new Button("Remove");
		remove.setPrefSize(270, 60);
		remove.setFont(new Font(20));
		remove.setStyle("-fx-background-color:#FEFEFE;");
		Image imgRemove = new Image(getClass().getResourceAsStream("icons/remove.png"), 50, 50, false, false);
		ImageView iconRemove = new ImageView(imgRemove);
		remove.setGraphic(iconRemove);

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
						return;
					}

				}
				AlertMessage.MessageNotExistCustomer();
			}

		});
		remove.setOnAction(e -> {

			for (Coustomer c : MediaRental.custms) {
				if (c.getId().equals(Tid.getText())) {
					MediaRental.custms.remove(c);
					AlertMessage.MessageDeleteCustomer();
					Tname.clear();
					Taddress.clear();
					Tid.clear();
					Tmobile.clear();
					break;
				}
			}
		});

		back.setOnAction(e -> {
			Login.STAGE.setTitle("Customer - Main");

			Login.STAGE.getScene().setRoot(new CoustomerData());

		});
		rootButton.getChildren().addAll(find, remove, back);

		rootButton.setStyle("-fx-background-color:#FE6186;\n" + "-fx-background-radius:40;\n ");
		root.setPadding(new Insets(60));
		rootButton.setPadding(new Insets(120));
		setRight(rootButton);
		setLeft(root);
	}

}
