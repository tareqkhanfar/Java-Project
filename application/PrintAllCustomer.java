package application;

import PROJECT.Coustomer;
import PROJECT.MediaRental;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class PrintAllCustomer extends BorderPane {

	public PrintAllCustomer() {
		// TODO Auto-generated constructor stub

		Button show = new Button("Show DATA");
		show.setPrefSize(160, 60);
		Button back = new Button("back");
		back.setPrefSize(160, 60);

		VBox v = new VBox(20);
		v.setAlignment(Pos.CENTER);
		v.setStyle("-fx-background-color : #2945B9;");
		v.setPadding(new Insets(30));
		v.setPrefWidth(350);
		v.getChildren().addAll(show, back);
		setLeft(v);
		TableView table = new TableView();
		ObservableList<Coustomer> data = FXCollections.observableArrayList(MediaRental.custms);
		TableColumn name = new TableColumn("Name");
		TableColumn id = new TableColumn("ID");

		TableColumn plan = new TableColumn("Plan");

		TableColumn mobile = new TableColumn("Mobile Phone");

		TableColumn adress = new TableColumn("Adress");
		TableColumn limited = new TableColumn("Number Plan Limited ");
		TableColumn Unlimited = new TableColumn("Number Plan UnLimited ");

		table.getColumns().addAll(id, name, mobile, adress, plan, limited, Unlimited);
		show.setOnAction(e -> {
			table.setItems(data);

		});

		name.setCellValueFactory(new PropertyValueFactory<>("name"));
		id.setCellValueFactory(new PropertyValueFactory<>("id"));
		mobile.setCellValueFactory(new PropertyValueFactory<>("mobile_phone"));
		adress.setCellValueFactory(new PropertyValueFactory<>("adress"));
		plan.setCellValueFactory(new PropertyValueFactory<>("Plan"));
		limited.setCellValueFactory(new PropertyValueFactory<>("LimitedPlan"));
		Unlimited.setCellValueFactory(new PropertyValueFactory<>("UnLIimitedPlan"));

		back.setOnAction(e -> {
			Login.STAGE.setTitle("Customer - Main");

			Login.STAGE.getScene().setRoot(new CoustomerData());

		});
		table.setPrefSize(1000, 900);
		id.setPrefWidth(140);
		name.setPrefWidth(140);
		adress.setPrefWidth(140);
		mobile.setPrefWidth(160);
		limited.setPrefWidth(160);
		Unlimited.setPrefWidth(160);

		setRight(table);

	}

}
