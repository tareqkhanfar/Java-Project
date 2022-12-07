package application;

import java.util.Date;

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
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class RentedMedia extends BorderPane {

	public RentedMedia() {
		// TODO Auto-generated constructor stub

		setStyle("-fx-background-color:#FEFEFE;\r\n");

		VBox root = new VBox(30);
		GridPane RootGrid = new GridPane();
		setPadding(new Insets(10));

		Label id = new Label("Costomer Id :");
		id.setTextFill(Color.WHITE);
		id.setFont(new Font(20));
		TextField Tid = new TextField();
		Tid.setPrefSize(70, 30);
		Label code = new Label("Media Code :");
		code.setFont(new Font(20));
		code.setTextFill(Color.WHITE);

		TextField Tcode = new TextField();
		Tcode.setPrefSize(70, 30);

		TextArea AreaC = new TextArea();
		TextArea AreaM = new TextArea();
		Label date = new Label("Rented Date:");
		date.setTextFill(Color.WHITE);

		date.setFont(new Font(20));
		TextField TDate = new TextField();
		TDate.setPrefSize(170, 30);

		Date cl = new Date();
		TDate.setText((1900 + cl.getYear()) + "/" + (cl.getMonth() + 1) + "/" + cl.getDate());
		Tid.setOnAction(e -> {
			for (Coustomer c : MediaRental.custms) {
				if (c.getId().equals(Tid.getText())) {

					AreaC.setText(c.GetInfoCustomer());

					return;
				}

			}
			AlertMessage.MessageNotExistCustomer();
		});
		Tcode.setOnAction(e -> {
			for (Media m : MediaRental.med) {
				if (m.getCode().equals(Tcode.getText())) {

					AreaM.setText(m.GETDATAINFO());

					return;
				}
			}
			AlertMessage.MessageNotExistMedia();

		});
		Button AddTOCart = new Button("Add To cart");
		AddTOCart.setFont(new Font(20));
		Image imgAddCart = new Image(getClass().getResourceAsStream("icons/addcart.png"), 50, 50, false, false);
		ImageView iconAddCart = new ImageView(imgAddCart);
		AddTOCart.setGraphic(iconAddCart);
		AddTOCart.setPrefSize(190, 60);

		AddTOCart.setOnAction(e -> {
			MediaRental m = new MediaRental();
			if (Tid.getText() == "" || Tcode.getText() == "") {
				AlertMessage.MessageWarningEmptyData();
			} else {
				m.addToCart(Tid.getText(), Tcode.getText());
				AlertMessage.MessageSaveData();
			}

		});
		Button back = new Button("Back");
		back.setFont(new Font(20));
		// back.setStyle("-fx-background-color:rgba(0,0,0,0);");
		Image imgBack = new Image(getClass().getResourceAsStream("icons/back.png"), 50, 50, false, false);
		ImageView iconBack = new ImageView(imgBack);
		back.setGraphic(iconBack);

		back.setOnAction(e -> {
			Login.STAGE.setTitle("Rent - Main");

			Login.STAGE.getScene().setRoot(new RentedData());

		});
		Button ProcessCart = new Button("Process Cart");
		ProcessCart.setFont(new Font(20));
		Image imgProcess = new Image(getClass().getResourceAsStream("icons/process.png"), 50, 50, false, false);
		ImageView iconProcess = new ImageView(imgProcess);
		ProcessCart.setGraphic(iconProcess);
		ProcessCart.setPrefSize(190, 60);
		ProcessCart.setOnAction(e -> {
			MediaRental m = new MediaRental();
			m.processRequest();
			AlertMessage.MessageSaveData();
		});
		back.setPrefSize(190, 60);

		back.setStyle("-fx-background-color:#FEFEFE;\r\n");
		AddTOCart.setStyle("-fx-background-color:#FEFEFE;\r\n");
		ProcessCart.setStyle("-fx-background-color:#FEFEFE;\r\n");

		RootGrid.add(id, 0, 0);
		RootGrid.add(Tid, 1, 0);

		RootGrid.add(AreaC, 1, 1);

		RootGrid.add(code, 0, 2);
		RootGrid.add(Tcode, 1, 2);

		RootGrid.add(AreaM, 1, 3);

		RootGrid.add(date, 0, 4);
		RootGrid.add(TDate, 1, 4);

		root.getChildren().addAll(AddTOCart, ProcessCart, back);
		root.setPadding(new Insets(50));
		RootGrid.setPadding(new Insets(30));
		RootGrid.setVgap(30);
		RootGrid.setHgap(30);
		root.setAlignment(Pos.CENTER);
		root.setStyle("-fx-background-color:#1AE59A;\r\n" + " -fx-background-radius:40;\n");
		RootGrid.setStyle("-fx-background-color:#FE6F6F;\r\n" + " -fx-background-radius:40;\n");
		setLeft(RootGrid);
		setRight(root);

	}

}
