import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;


public class HelloWorld extends Application {
	public static void main(String[] args) {
		launch(args);
		
		
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Button btn = new Button("Click me");
		Button exit = new Button("Exit");
		//lambda expression
		exit.setOnAction(e-> {
			System.out.println("Goodbye");
			System.exit(0);
		});
		btn.setOnAction(new EventHandler<ActionEvent>() {
			
			public void handle(ActionEvent event) {
				System.out.println("Hello World");
				System.out.println("Hello World");
							}
		});
		
		VBox root = new VBox();
		
		//StackPane root = new StackPane();
		root.getChildren().addAll(btn, exit);
		
		Scene scene = new Scene(root);
		primaryStage.setTitle("My App");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

}
