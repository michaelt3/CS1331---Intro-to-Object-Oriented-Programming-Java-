package view;

import controller.GameController;
import javafx.scene.control.Button;


/**
 * Created by William on 11/11/2016.
 */

public class MilitaryMenu extends AbstractMenu {
    /**
    * Implement the buttons and actions associated with
    * the buttons for the military menu
    */
    private Button attackButton = new Button("Attack");
    private Button moveButton = new Button("Move");
    public MilitaryMenu() {
        addMenuItem(attackButton);
        addMenuItem(moveButton);
        attackButton.setOnMouseClicked(e -> {
                GameController.attacking();
                GameController.updateResourcesBar();
            });
        moveButton.setOnMouseClicked(e -> {
                GameController.moving();
            });
    }
}
