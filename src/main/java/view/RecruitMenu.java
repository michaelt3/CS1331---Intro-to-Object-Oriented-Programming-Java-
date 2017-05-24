package view;

import controller.GameController;
import model.Unit;
import javafx.scene.control.ListView;
import javafx.collections.FXCollections;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * Created by RuYiMarone on 11/11/2016.
 */

public class RecruitMenu extends AbstractMenu {
    /**
    * recuit menu should have a list of worker/units
    * to choose from. There should also be a select button
    * and the function of the button should be implemented
    *here
    */

    public enum Workers {
        MELEE {
            @Override
            public String toString() {
                return "Melee Unit";
            }
        },
        RANGE {
            @Override
            public String toString() {
                return "Ranged Unit";
            }
        },
        HYBRID {
            @Override
            public String toString() {
                return "Hybrid Unit";
            }
        },
        SIEGE {
            @Override
            public String toString() {
                return "Siege Unit";
            }
        },
        SETTLER {
            @Override
            public String toString() {
                return "Settlers";
            }
        },
        FARMER {
            @Override
            public String toString() {
                return "Farmers";
            }
        },
        COAL {
            @Override
            public String toString() {
                return "Coal Miners";
            }
        },
        ANGLER {
            @Override
            public String toString() {
                return "Anglers";
            }
        },
        MASTER {
            @Override
            public String toString() {
                return "Master Builders";
            }
        };
    }

    private ListView<Workers> list = new ListView<Workers>(FXCollections
        .observableArrayList(Workers.MELEE, Workers.RANGE, Workers.HYBRID,
            Workers.SIEGE, Workers.SETTLER, Workers.FARMER, Workers.COAL,
            Workers.ANGLER, Workers.MASTER));
    private static Workers test;
    private Button button = new Button("Select");
    private static int index = 0;
    private Unit unit;

    public RecruitMenu() {
        list.setMaxHeight(230);
        VBox vbox = new VBox(20);
        vbox.getChildren().addAll(list, button);
        addMenuItem(vbox);
        list.getSelectionModel().select(0);
        list.setOnMouseClicked(e -> {
                index = list.getSelectionModel().getSelectedIndex();
                list.getSelectionModel().select(index);
                test = list.getSelectionModel().getSelectedItem();
            });
        button.setOnAction(e -> {
                if (test == Workers.MELEE) {
                    unit = GameController.getCivilization().getMeleeUnit();
                    if (unit.isAffordable()) {
                        GameController.getLastClicked().getTile()
                            .setOccupant(GameController.getCivilization()
                            .getMeleeUnit());
                        unit.applyInitialCosts();
                    } else {
                        Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("Information Dialog");
                        alert.setHeaderText(null);
                        alert.setContentText("You cannot afford this unit.");
                        alert.showAndWait();
                    }
                }
                if (test == Workers.RANGE) {
                    unit = GameController.getCivilization().getRangedUnit();
                    if (unit.isAffordable()) {
                        GameController.getLastClicked().getTile()
                            .setOccupant(GameController.getCivilization()
                            .getRangedUnit());
                        unit.applyInitialCosts();
                    } else {
                        Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("Information Dialog");
                        alert.setHeaderText(null);
                        alert.setContentText("You cannot afford this unit.");
                        alert.showAndWait();
                    }
                }
                if (test == Workers.HYBRID) {
                    unit = GameController.getCivilization().getHybridUnit();
                    if (unit.isAffordable()) {
                        GameController.getLastClicked().getTile()
                            .setOccupant(GameController.getCivilization()
                            .getHybridUnit());
                        unit.applyInitialCosts();
                    } else {
                        Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("Information Dialog");
                        alert.setHeaderText(null);
                        alert.setContentText("You cannot afford this unit.");
                        alert.showAndWait();
                    }
                }
                if (test == Workers.SIEGE) {
                    unit = GameController.getCivilization().getSiegeUnit();
                    if (unit.isAffordable()) {
                        GameController.getLastClicked().getTile()
                            .setOccupant(GameController.getCivilization()
                            .getSiegeUnit());
                        unit.applyInitialCosts();
                    } else {
                        Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("Information Dialog");
                        alert.setContentText("You cannot afford this unit.");
                        alert.showAndWait();
                    }
                }
                if (test == Workers.SETTLER) {
                    unit = GameController.getCivilization().getSettlerUnit("T");
                    if (unit.isAffordable()) {
                        GameController.getLastClicked().getTile()
                            .setOccupant(GameController.getCivilization()
                            .getSettlerUnit("TEST"));
                        unit.applyInitialCosts();
                    } else {
                        Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("Information Dialog");
                        alert.setHeaderText(null);
                        alert.setContentText("You cannot afford this unit.");
                        alert.showAndWait();
                    }
                }
                if (test == Workers.FARMER) {
                    unit = GameController.getCivilization().getFarmerUnit();
                    if (unit.isAffordable()) {
                        GameController.getLastClicked().getTile()
                            .setOccupant(GameController.getCivilization()
                            .getFarmerUnit());
                        unit.applyInitialCosts();
                    } else {
                        Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("Information Dialog");
                        alert.setHeaderText(null);
                        alert.setContentText("You cannot afford this unit.");
                        alert.showAndWait();
                    }
                }
                if (test == Workers.COAL) {
                    unit = GameController.getCivilization().getCoalMinerUnit();
                    if (unit.isAffordable()) {
                        GameController.getLastClicked().getTile()
                            .setOccupant(GameController.getCivilization()
                            .getCoalMinerUnit());
                        unit.applyInitialCosts();
                    } else {
                        Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("Information Dialog");
                        alert.setContentText("You cannot afford this unit.");
                        alert.showAndWait();
                    }
                }
                if (test == Workers.ANGLER) {
                    unit = GameController.getCivilization().getAnglerUnit();
                    if (unit.isAffordable()) {
                        GameController.getLastClicked().getTile()
                            .setOccupant(GameController.getCivilization()
                            .getAnglerUnit());
                        unit.applyInitialCosts();
                    } else {
                        Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("Information Dialog");
                        alert.setHeaderText(null);
                        alert.setContentText("You cannot afford this unit.");
                        alert.showAndWait();
                    }
                }
                if (test == Workers.MASTER) {
                    unit = GameController.getCivilization()
                        .getMasterBuilderUnit();
                    if (unit.isAffordable()) {
                        GameController.getLastClicked().getTile()
                            .setOccupant(GameController.getCivilization()
                            .getMasterBuilderUnit());
                        unit.applyInitialCosts();
                    } else {
                        Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("Information Dialog");
                        alert.setHeaderText(null);
                        alert.setContentText("You cannot afford this unit.");
                        alert.showAndWait();
                    }
                }
                GameController.updateResourcesBar();
                GridFX.update();
            });
    }
}































