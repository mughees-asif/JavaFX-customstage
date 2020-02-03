package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.vivoxalabs.customstage.CustomStage;
import lk.vivoxalabs.customstage.CustomStageBuilder;
import lk.vivoxalabs.customstage.tools.HorizontalPos;
import lk.vivoxalabs.customstage.tools.NavigationType;
import lk.vivoxalabs.customstage.tools.Style;

public class CustomStageApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        AnchorPane navigationPane = FXMLLoader.load(getClass().getResource("/sample/Navigation.fxml"));

        CustomStage stage = new CustomStageBuilder()
                .setWindowTitle("CustomStage App", HorizontalPos.RIGHT,HorizontalPos.CENTER)
                .setNavigationPane(Style.DYNAMIC, NavigationType.LEFT,navigationPane,60,0,true)
                .setTitleColor("black")
                .setStyleSheet(getClass().getResource("/sample/customapp.css"))
                .setButtonHoverColor("FFAB40","FFAB40","d32f2f")
                .setDimensions(450,450,1920,1280) //Set min,max values for window resizing
                .setWindowColor("FF6D00")
                .build();

        // Show/hide the navigation pane when the window is clicked
        stage.getScene().getRoot().setOnMouseClicked(e->stage.dynamicDrawerEvent(NavigationType.LEFT));

        stage.show();
    }
}
