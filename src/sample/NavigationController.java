package sample;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import lk.vivoxalabs.customstage.CustomStage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class NavigationController implements Initializable {

    @FXML
    Button btnS1,btnS2,btnS3;

    private Pane scene1,scene2,scene3;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //Load Scene1.fxml,Scene2.fxml and Scene3.fxml files
        try {
            scene1 = FXMLLoader.load(getClass().getResource("/sample/Scene1.fxml"));
            scene2 = FXMLLoader.load(getClass().getResource("/sample/Scene2.fxml"));
            scene3 = FXMLLoader.load(getClass().getResource("/sample/Scene3.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //set Scene1.fxml as the view of the window when "Load Scene 1" is clicked
        btnS1.setOnAction(event->{
            CustomStage stage = ((CustomStage)btnS1.getScene().getWindow());
            stage.changeScene(scene1);
        });

        //set Scene2.fxml as the view of the window when "Load Scene 2" is clicked
        btnS2.setOnAction(event->{
            ((CustomStage)btnS2.getScene().getWindow()).changeScene(scene2);
        });

        //set Scene3.fxml as the view of the window when "Load Scene 3" is clicked
        btnS3.setOnAction(event->{
            ((CustomStage)btnS1.getScene().getWindow()).changeScene(scene3);
        });


    }
}