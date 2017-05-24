package view;

import javafx.scene.layout.StackPane;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import javafx.collections.FXCollections;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;

/**
 * Created by Tian-Yo Yang on 11/11/2016.
 * This class represents the Start Screen for the Civ applicatios. This is the
 * layout that should be displayed upon running the Civ application.
 *
 * This class should have and display
 * 1. a background
 * 2. a list of Civilizations
 * 3. a Start button
 */

public class StartScreen extends StackPane {
    /**
    * constuctor of the start screen. Should set the background
    * image and display a list of civilizations and a start button
    */
    private Button start = new Button("Start");
    private ListView<CivEnum> list
        = new ListView<CivEnum>(FXCollections.observableArrayList(
            CivEnum.ANCIENT_EGYPT, CivEnum.QIN_DYNASTY, CivEnum.ROMAN_EMPIRE));
    private static CivEnum test;

    public StartScreen() {
        ImageView iv1 =
            new ImageView("File:./src/main/java/view/civ_background.png");
        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);
        Text message = new Text(0, 0, "Select a Civilization");
        message.setFill(Color.RED);
        getCivList();
        vbox.getChildren().addAll(message, list, start);
        this.setAlignment(Pos.CENTER);
        this.getChildren().addAll(iv1, vbox);
    }
    /**
    * gets the start button
    * @return the start button
    */
    public Button getStartButton() {
        return start;
    }
    /**
    * return a ListView of CivEnums representing the list of
    * available civilizations to choose from
    * @return listview of CivEnum
    */
    public ListView<CivEnum> getCivList() {
        list.setMaxWidth(125);
        list.setMaxHeight(90);
        list.getSelectionModel().select(0);
        list.setOnMouseClicked(e-> {
                int index = list.getSelectionModel().getSelectedIndex();
                test = list.getSelectionModel().getSelectedItem();
            });
        return list;
    }

    public CivEnum getSelected() {
        return test;
    }


}








