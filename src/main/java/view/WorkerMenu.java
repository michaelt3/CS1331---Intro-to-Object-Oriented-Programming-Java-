package view;

import controller.GameController;
import model.Convertable;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * Created by RuYiMarone on 11/11/2016.
 */
public class WorkerMenu extends AbstractMenu {
    /**
    * There should be a convert and move button
    * as well as the functions associated with those
    * buttons
    */
    private Button moveButton = new Button("Move");
    private Button convertButton = new Button("Convert");
    public WorkerMenu() {
        addMenuItem(moveButton);
        addMenuItem(convertButton);
        moveButton.setOnMousePressed(e -> {
                GameController.moving();
                GridFX.update();
            });
        convertButton.setOnMousePressed(e -> {
                if (GameController.getLastClicked().getTile().getOccupant()
                    .isWorker()) {
                    if (((Convertable) GameController.getLastClicked().getTile()
                        .getOccupant()).canConvert(GameController
                        .getLastClicked()
                        .getTile().getType())) {
                        GameController.getLastClicked().getTile()
                            .setOccupant(((Convertable) GameController
                            .getLastClicked()
                            .getTile().getOccupant()).convert());
                        System.out.println("ahhhh");
                    } else {
                        Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("Information Dialog");
                        alert.setHeaderText(null);
                        alert.setContentText("The "
                            + "Tile selected cannot be converted.");
                        alert.showAndWait();
                    }
                } else {
                    Alert alert2 = new Alert(AlertType.INFORMATION);
                    alert2.setTitle("Information Dialog");
                    alert2.setHeaderText(null);
                    alert2.setContentText("The Tile "
                        + "selected cannot be converted.");
                    alert2.showAndWait();
                }
                GameController.updateResourcesBar();
                GridFX.update();
            });
    }
}
