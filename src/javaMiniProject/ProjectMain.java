package javaMiniProject;


import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ProjectMain extends Application {

	private Stage primaryStage;
	private BorderPane rootLayout;

	@Override
	public void start(Stage primaryStage) throws Exception {
		// 1 primary stage 설정(모든 메서드에서 사용 가능)
		this.primaryStage = primaryStage;

		// 2 Initialize RootLayout
		initRootLayout();

		// 3 부서 관리 페이지 border center에 연결
//		showHomeView();

	}

	public void initRootLayout() {
		try {
			rootLayout = FXMLLoader.load(getClass().getResource("view/RootView.fxml"));
			Scene scene = new Scene(rootLayout, 650, 450);

			primaryStage.setTitle("이거는 창에 뜨는 글자");
			primaryStage.setScene(scene);
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	public void showHomeView() {
//		try {
//			BorderPane homeView = FXMLLoader.load(getClass().getResource("view/HomeView.fxml"));
//			rootLayout.setCenter(homeView);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}

	public static void main(String[] args) {
		launch(args);
	}

}
