package view;

import controller.GameController;
import model.Building;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
/**
 * This class should represents the bulding menu
 */
public class BuildingMenu extends AbstractMenu {
    /**
    * there should be an invest and demolish button for this menu
    * as well as functions associated with the buttons
    */
    private Button investButton = new Button("Invest");
    private Button demolishButton = new Button("Demolish");

    public BuildingMenu() {
        addMenuItem(investButton);
        addMenuItem(demolishButton);
        investButton.setOnMousePressed(e -> {
                if (GameController.getLastClicked().getTile().getOccupant()
                    .getOwner().getTreasury().getCoins() >= 25) {
                    GameController.getLastClicked().getTile().getOccupant()
                        .getOwner().getSettlement("TEMPORARY").invest();
                    GameController.getLastClicked().getTile().getOccupant()
                        .getOwner().getTreasury().spend(25);
                    GameController.updateResourcesBar();
                    GridFX.update();
                }
            });
        demolishButton.setOnMousePressed(e -> {
                if (GameController.getLastClicked().getTile().getOccupant()
                    .getOwner().getNumSettlements() > 1) {
                    if (GameController.getLastClicked().getTile().getOccupant()
                        .isBuilding()) {
                        ((Building) (GameController.getLastClicked().getTile()
                            .getOccupant())).demolish();
                        GameController.getLastClicked().getTile()
                        .setOccupant(null);
                        GameController.getLastClicked().getTile().getOccupant()
                        .getOwner().decrementNumSettlements();
                    }
                } else {
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Dialog");
                    alert.setHeaderText(null);
                    alert.setContentText("Cannot demolish.");
                    alert.showAndWait();
                }
                GameController.updateResourcesBar();
                GridFX.update();
            });
    }
}
