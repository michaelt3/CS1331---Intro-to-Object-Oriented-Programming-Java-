package view;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.ScrollPane;
import controller.GameController;

/**
 * This class represents the GameScreen class
 */
public class GameScreen extends BorderPane {

    private static MilitaryMenu militaryMenu = new MilitaryMenu();
    private static ResourcesMenu resourcesMenu = new ResourcesMenu();
    private static AbstractMenu abstractMenu = new AbstractMenu();
    private static WorkerMenu workerMenu = new WorkerMenu();
    private static RecruitMenu recruitMenu = new RecruitMenu();
    private static BuildingMenu buildingMenu = new BuildingMenu();

    /**
     * Creates a new view into the game. this layout should include
     * the rescource bar, grid map, and action menus
     *
     */
    private static VBox vbox = new VBox();
    private static ScrollPane scrollPane = new ScrollPane();
    public GameScreen() {
        this.setTop(resourcesMenu.getRootNode());
        vbox.getChildren().add(abstractMenu.getRootNode());
        this.setLeft(vbox);
        scrollPane.setContent(GridFX.getInstance());
        this.setCenter(scrollPane);
        update();
    }

    /**
     * This method should update the gridfx and the resouce bar
     */
    public static void update() {
        GridFX.getInstance().update();
        GameController.updateResourcesBar();
    }
    /**
    * this method should return the resource menu
    * @return reosuce menu
    */
    public static ResourcesMenu getResources() {
        return resourcesMenu;
    }


    /**
     * This method switches menus based on passed in game state.
     * Game.java calls this to selectively control which menus are displayed
     * @param state
     */
    public static void switchMenu(GameController.GameState state) {
        // Check what state has been passed in. Depending on what was passed in,
        // Change the side bar
        // state == GameController.Gamestate.ENUM
        if (state == GameController.GameState.NEUTRAL) {
            vbox.getChildren().setAll(abstractMenu.getRootNode());
        }
        if (state == GameController.GameState.MILITARY) {
            vbox.getChildren().setAll(militaryMenu.getRootNode());
        }
        if (state == GameController.GameState.WORKER) {
            vbox.getChildren().setAll(workerMenu.getRootNode());
        }
        if (state == GameController.GameState.BUILDING) {
            vbox.getChildren().setAll(buildingMenu.getRootNode());
        }
        if (state == GameController.GameState.RECRUITING) {
            vbox.getChildren().setAll(recruitMenu.getRootNode());
        }
    }
}























