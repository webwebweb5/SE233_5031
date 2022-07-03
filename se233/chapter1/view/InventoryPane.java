package se233.chapter1.view;

import javafx.geometry.Insets;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import se233.chapter1.Launcher;
import se233.chapter1.model.item.BasedEquipment;

import java.util.ArrayList;

public class InventoryPane extends ScrollPane {
    private BasedEquipment[] equipmentArray;

    public InventoryPane() {
    }

    private Pane getDetailsPane() {
        Pane inventoryInfoPane = new HBox(10);
        inventoryInfoPane.setBorder(null);
        inventoryInfoPane.setPadding(new Insets(25, 25, 25, 25));
        if (equipmentArray != null) {
            ImageView[] imageViewList = new ImageView[equipmentArray.length];

            for (int i = 0; i < equipmentArray.length; i++) {
                imageViewList[i] = new ImageView();
                imageViewList[i].setImage(new Image(Launcher.class.getResource(equipmentArray[i].getImagepath()).toString()));
            }
            inventoryInfoPane.getChildren().addAll(imageViewList);
        }
        return inventoryInfoPane;
    }

    public void drawPane(BasedEquipment[] equipmentArray) {
        this.equipmentArray = equipmentArray;
        Pane invetoryInfo = getDetailsPane();
        this.setStyle("-fx-background-color:Red;");
        this.setContent(invetoryInfo);
    }
}
