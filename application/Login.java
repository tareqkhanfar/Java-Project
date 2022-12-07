package application;

import PROJECT.FileDataInput;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Login extends Application {
	static Stage STAGE;
	static Scene SCENE;

	public Login() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void start(Stage stage) throws Exception {
		STAGE = stage;
		// TODO Auto-generated method stub
		VBox root = new VBox(220);
		FileDataInput DATAINPUT = new FileDataInput();

		Image img = new Image(getClass().getResourceAsStream("icons/bg1.jpg"));
		BackgroundImage bImg = new BackgroundImage(img, null, null, null, null);
		Background bGround = new Background(bImg);
		root.setBackground(bGround);
		root.setPadding(new Insets(100));
		root.setAlignment(Pos.TOP_CENTER);

		Label welcome = new Label("    Welome to my Media Rental System...    ");
		welcome.setStyle("-fx-background-color: #AF831D;\n" + " -fx-background-radius:40;\n");
		welcome.setFont(new Font(50));
		welcome.setTextFill(Color.WHITESMOKE);
		Button login = new Button("LOGIN");
		login.setPrefWidth(70);
		login.setFont(new Font(18));
		login.setStyle("     -fx-background-radius:40;\r\n ;  -fx-background-color:#61FF96;");
		login.setPrefSize(200, 70);
		login.setOnAction(e -> {
			STAGE.setTitle("Main");

			STAGE.getScene().setRoot(new Main());
		});
		root.getChildren().addAll(welcome, login);
		SCENE = new Scene(root);
		STAGE.setTitle("Login");
		STAGE.setScene(SCENE);
		STAGE.setMaximized(true);
		STAGE.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
