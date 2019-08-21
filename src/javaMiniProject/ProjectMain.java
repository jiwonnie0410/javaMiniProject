package javaMiniProject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ProjectMain extends Application {

	private Stage primaryStage;
	private BorderPane rootLayout;
	
	public static int ID = 0;

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		
		// 1 primary stage 설정(모든 메서드에서 사용 가능)
		this.primaryStage = primaryStage;

		// 2 Initialize RootLayout
		initRootLayout();
	}
	
	public void initRootLayout() {
		try {
			rootLayout = FXMLLoader.load(getClass().getResource("view/RootView.fxml"));
			Scene scene = new Scene(rootLayout, 1000, 750);

			primaryStage.setTitle("이거는 창에 뜨는 글자");
			primaryStage.setScene(scene);
			primaryStage.show();
			
			AnchorPane homeView = FXMLLoader.load(getClass().getResource("view/HomeView.fxml"));
			rootLayout.setCenter(homeView);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
