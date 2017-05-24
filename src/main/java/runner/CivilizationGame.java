package runner;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

import controller.GameController;
import view.StartScreen;
import view.CivEnum;
import view.GameScreen;
import model.QinDynasty;
import model.RomanEmpire;
import model.Egypt;
import model.Bandit;

import view.GridFX;
import javafx.scene.control.TextInputDialog;
import java.util.Optional;

/**
 * Created by Tian-Yo Yang on 11/11/2016.
 */
public class CivilizationGame extends Application {

    /**
     * this method is called upon running/launching the application
     * this method should display a scene on the stage
     */
    private static String name;
    private static int size;
    private static int enemies;
    public void start(Stage primaryStage) {
        StartScreen root = new StartScreen();
        Scene s = new Scene(root, 1000, 1000);
        primaryStage.setScene(s);
        primaryStage.show();
        root.getStartButton().setOnAction(e ->
            {
                TextInputDialog dialog = new TextInputDialog("Town Name");
                dialog.setTitle("A New Settlement");
                dialog.setHeaderText("You have built a Settlement!");
                dialog.setContentText("Enter the Name of your first town:");
                Optional<String> result = dialog.showAndWait();
                result.ifPresent(town -> {
                        System.out.println("Your first town: " + town);
                        name = town;
                    });
                TextInputDialog dialog2 = new TextInputDialog("Size of Game");
                dialog2.setTitle("A New Map");
                dialog2.setHeaderText(null);
                dialog2.setContentText("Select size for the map(I recommend 5 "
                    + "to 20):");
                Optional<String> result2 = dialog2.showAndWait();
                result2.ifPresent(size2 -> {
                        System.out.println("The size of the map is: " + size2);
                        size = Integer.parseInt(size2);
                    });
                if (root.getSelected() == CivEnum.ANCIENT_EGYPT
                    || root.getSelected() == null) {
                    Egypt egypt = new Egypt();
                    GameController.setCivilization(egypt);
                    GridFX.getInstance().getMap()
                        .putSettlement(name, egypt , 0 , getSize() - 1);

                }
                if (root.getSelected() == CivEnum.QIN_DYNASTY) {
                    QinDynasty qinDynasty = new QinDynasty();
                    GameController.setCivilization(qinDynasty);
                    GridFX.getInstance().getMap()
                        .putSettlement(name, qinDynasty, 0, getSize() - 1);
                }
                if (root.getSelected() == CivEnum.ROMAN_EMPIRE) {
                    RomanEmpire romanEmpire = new RomanEmpire();
                    GameController.setCivilization(romanEmpire);
                    GridFX.getInstance().getMap()
                        .putSettlement(name, romanEmpire, 0, getSize() - 1);
                }
                TextInputDialog dialog3 = new TextInputDialog("Difficulty");
                dialog3.setTitle("Difficulty Level");
                dialog3.setHeaderText(null);
                dialog3.setContentText("Select a Difficulty Level (Integer) "
                    + "(I recommend 1 to 5):");
                Optional<String> result3 = dialog3.showAndWait();
                result3.ifPresent(size3 -> {
                        System.out.println("The Difficulty Level is: " + size3);
                        enemies = Integer.parseInt(size3);
                    });
                GridFX.getInstance().getMap().addEnemies(new Bandit(), enemies);
                GridFX.getInstance().setSize(size);
                GameScreen root2 = new GameScreen();
                Scene scene = new Scene(root2, 1000, 1000);
                primaryStage.setScene(scene);
                primaryStage.show();
            });
    }
    /**
     * This is the main method that launches the javafx application
     */
    public static void main(String[] args) {
        launch(args);
    }
    /**
    * This method is responsible for setting the scene to the corresponding
    * layout.
    * and returning the scene.
    * @return Scene
    */

    public Scene startGame() {

        StartScreen root = new StartScreen();
        Scene s = new Scene(root, 1000, 1000);
        return s;
    }

    public static int getSize() {
        return size;
    }
}

