package application;

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
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class AddNewCostomer extends BorderPane {

	public AddNewCostomer() {
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
		Label plan = new Label("Plan :");
		plan.setFont(new Font(20));

		RadioButton limited = new RadioButton("LIMITED");
		RadioButton Unlimited = new RadioButton("UNLIMITED");
		ToggleGroup tg = new ToggleGroup();
		limited.setToggleGroup(tg);
		Unlimited.setToggleGroup(tg);
		root.add(id, 0, 0);
		root.add(Tid, 1, 0);
		root.add(name, 0, 1);
		root.add(Tname, 1, 1);
		root.add(address, 0, 2);
		root.add(Taddress, 1, 2);
		root.add(mobile, 0, 3);
		root.add(Tmobile, 1, 3);
		root.add(plan, 0, 4);
		root.add(limited, 1, 4);
		root.add(Unlimited, 2, 4);

		Button add = new Button("Add");
		add.setFont(new Font(20));
		add.setStyle("-fx-background-color:#FEFEFE;\n");
		Image imgAdd = new Image(getClass().getResourceAsStream("icons/add.png"), 50, 50, false, false);
		ImageView iconAdd = new ImageView(imgAdd);
		add.setGraphic(iconAdd);

		add.setPrefSize(270, 60);
		add.setOnAction(e -> {

			MediaRental Data = new MediaRental();
			if (!(Tname.getText() == "" || Taddress.getText() == "" || limited.getText() == "" || Tid.getText() == ""
					|| Tmobile.getText() == "")) {

				if (limited.isSelected()) {
					try {
						Data.addCustomer(Tname.getText(), Taddress.getText(), limited.getText(), Tid.getText(),
								Tmobile.getText());
						AlertMessage.MessageAddCustomer();
						Tname.clear();
						Taddress.clear();
						Tid.clear();
						Tmobile.clear();
					} catch (IllegalArgumentException ex) {
						AlertMessage.MessageErrorCustomer();
					}

				} else if (Unlimited.isSelected()) {
					try {
						Data.addCustomer(Tname.getText(), Taddress.getText(), Unlimited.getText(), Tid.getText(),
								Tmobile.getText());
						AlertMessage.MessageAddCustomer();

						Tname.clear();
						Taddress.clear();
						Tid.clear();
						Tmobile.clear();
					} catch (IllegalArgumentException ex) {
						AlertMessage.MessageErrorCustomer();

					}

				}

			} else {
				AlertMessage.MessageWarningEmptyData();
			}

		});
		Button back = new Button("Back");
		back.setFont(new Font(20));
		back.setStyle("-fx-background-color:#FEFEFE;\n");
		Image imgBack = new Image(getClass().getResourceAsStream("icons/back.png"), 50, 50, false, false);
		ImageView iconBack = new ImageView(imgBack);
		back.setGraphic(iconBack);

		back.setPrefSize(270, 60);

		back.setOnAction(e -> {
			Login.STAGE.setTitle("Customer Main");

			Login.STAGE.getScene().setRoot(new CoustomerData());

		});
		rootButton.setStyle("-fx-background-color:#6ED26E;\n" + "-fx-background-radius:40;\n ");
		root.setPadding(new Insets(50));
		rootButton.setPadding(new Insets(120));
		rootButton.getChildren().addAll(add, back);
		setRight(rootButton);
		setLeft(root);
	}

}
