package application;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public class CoustomerData extends BorderPane {

	public CoustomerData() {
		Image img = new Image(getClass().getResourceAsStream("icons/bg2.jpg"), 1400, 710, false, false);
		BackgroundImage bImg = new BackgroundImage(img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

		Background bGround = new Background(bImg);
		setBackground(bGround);
		VBox root = new VBox(30);
		Font font = Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 50);
		Label MAIN = new Label("MAIN MENU FOR CUSTOMER");
		MAIN.setTextFill(Color.WHITE);
		MAIN.setStyle("-fx-background-color: #F90C63;\n" + " -fx-background-radius:40;\n");
		MAIN.setFont(font);

		MAIN.setPadding(new Insets(20));
		Button b1 = new Button("Add new Customer");
		b1.setOnAction(e -> {
			Login.STAGE.setTitle("Add new customer");

			Login.STAGE.getScene().setRoot(new AddNewCostomer());
		});
		Image imgCustomer = new Image(getClass().getResourceAsStream("icons/add2.png"), 50, 50, false, false);

		ImageView iconCustomer = new ImageView(imgCustomer);
		b1.setGraphic(iconCustomer);
		Button b2 = new Button("Delete Customer");
		Image DelCustomer = new Image(getClass().getResourceAsStream("icons/delete2.png"), 50, 50, false, false);

		ImageView IconDelCustomer = new ImageView(DelCustomer);
		b2.setGraphic(IconDelCustomer);
		b2.setOnAction(e -> {
			Login.STAGE.setTitle("Delete Customer");

			Login.STAGE.getScene().setRoot(new DeleteCustomer());

		});

		Button b3 = new Button("Update Customer");
		Image UpdCustomer = new Image(getClass().getResourceAsStream("icons/update2.png"), 50, 50, false, false);

		ImageView IconUpdCustomer = new ImageView(UpdCustomer);
		b3.setGraphic(IconUpdCustomer);
		b3.setOnAction(e -> {
			Login.STAGE.setTitle("Update customer info .");

			Login.STAGE.getScene().setRoot(new UpdataInfoCustomer());

		});
		Button b4 = new Button("Search a Customer");
		Image SearchCustomer = new Image(getClass().getResourceAsStream("icons/search2.png"), 50, 50, false, false);

		ImageView IconSearchCustomer = new ImageView(SearchCustomer);
		b4.setGraphic(IconSearchCustomer);
		b4.setOnAction(e -> {
			Login.STAGE.setTitle("Search by id ");

			Login.STAGE.getScene().setRoot(new SearchById());

		});
		Button b5 = new Button("Return to main page");
		Image backCustomer = new Image(getClass().getResourceAsStream("icons/back2.png"), 50, 50, false, false);

		ImageView IconBackCustomer = new ImageView(backCustomer);
		b5.setGraphic(IconBackCustomer);
		b5.setOnAction(e -> {
			Login.STAGE.setTitle("Main - ");

			Login.STAGE.getScene().setRoot(new Main());
		});
		Button b6 = new Button("Print All Customer");
		Image printCustomer = new Image(getClass().getResourceAsStream("icons/show2.png"), 50, 50, false, false);

		ImageView IconprintCustomer = new ImageView(printCustomer);
		b6.setGraphic(IconprintCustomer);
		b6.setOnAction(e -> {
			Login.STAGE.setTitle("Print All Customer");

			Login.STAGE.getScene().setRoot(new PrintAllCustomer());
		});
		b1.setPrefSize(215, 90);
		b2.setPrefSize(215, 90);
		b3.setPrefSize(215, 90);
		b4.setPrefSize(215, 90);
		b5.setPrefSize(215, 90);
		b6.setPrefSize(215, 90);
		b1.setFont(new Font(14));
		b2.setFont(new Font(14));

		b3.setFont(new Font(14));

		b4.setFont(new Font(14));

		b5.setFont(new Font(14));

		b6.setFont(new Font(14));

		root.setPadding(new Insets(60));

		// root.setStyle("-fx-background-color: #41F6AD;\r\n");
		root.setStyle("-fx-background-color:rgba(0,0,0,0);");

		// setStyle("-fx-background-color: #121A5D;\r\n");

		root.getChildren().addAll(b1, b2, b3, b4, b6, b5);
		setLeft(root);
		setCenter(MAIN);

	}

}
