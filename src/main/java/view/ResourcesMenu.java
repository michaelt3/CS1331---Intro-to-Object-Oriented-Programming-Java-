package view;

import controller.GameController;
import javafx.scene.layout.HBox;
import javafx.scene.control.Label;

public class ResourcesMenu {

    /**
    * creates a resource bar and display the current state of
    * your civilization's resouces
    */
    private Label strategyLevel = new Label();
    private Label resources = new Label();
    private Label settlements = new Label();
    private Label coins = new Label();
    private Label food = new Label();
    private Label happiness = new Label();
    private HBox resourceBar = new HBox();

    public ResourcesMenu() {
        resourceBar.setSpacing(15);
        resourceBar.getChildren().addAll(strategyLevel, resources, settlements,
            coins, food, happiness);
    }
    /**
    * should update all the resouce values to the current
    * state of your resource values
    */
    public void update() {
        strategyLevel.setText("Strat Level: " + GameController.getCivilization()
            .getStrategy().getStrategyLevel());
        resources.setText("Resources: " + GameController.getCivilization()
            .getResources());
        settlements.setText("Settlements: " + GameController.getCivilization()
            .getNumSettlements());
        coins.setText("Coins: " + GameController.getCivilization()
            .getTreasury().getCoins());
        food.setText("Food: " + GameController.getCivilization().getFood());
        happiness.setText("Happiness: " + GameController.getCivilization()
            .getHappiness());
    }
    /**
    * updates the resource bar and returns the resource bar
    * @return a hbox representation of the resource bar
    */
    public HBox getRootNode() {
        update();
        return resourceBar;
    }
}