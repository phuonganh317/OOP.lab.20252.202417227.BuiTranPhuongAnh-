package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.store.Store;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class CartScreenController {
    private Cart cart;
    private Store store;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private Button btnPlaceOrder;

    @FXML
    private Label lblTotalCost;

    @FXML
    private TextField tfFilter;

    @FXML
    private RadioButton radioBtnFilterId;

    @FXML
    private RadioButton radioBtnFilterTitle;

    public CartScreenController(Cart cart) {
        this(cart, null);
    }

    public CartScreenController(Cart cart, Store store) {
        this.cart = cart;
        this.store = store;
    }

    @FXML
    private void initialize() {
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));

        tblMedia.setItems(cart.getItemsOrdered());

        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        updateTotalCost();

        tblMedia.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<Media>() {
                    @Override
                    public void changed(
                            ObservableValue<? extends Media> observable,
                            Media oldValue,
                            Media newValue
                    ) {
                        if (newValue != null) {
                            updateButtonBar(newValue);
                        } else {
                            btnPlay.setVisible(false);
                            btnRemove.setVisible(false);
                        }
                    }
                }
        );
    }

    private void updateButtonBar(Media media) {
        btnRemove.setVisible(true);

        if (media instanceof Playable) {
            btnPlay.setVisible(true);
        } else {
            btnPlay.setVisible(false);
        }
    }

    private void updateTotalCost() {
        lblTotalCost.setText(String.format("%.2f $", cart.totalCost()));
    }

    @FXML
    private void btnRemovePressed() {
        Media selectedMedia = tblMedia.getSelectionModel().getSelectedItem();

        if (selectedMedia != null) {
            cart.removeMedia(selectedMedia);
            updateTotalCost();

            tblMedia.getSelectionModel().clearSelection();

            btnPlay.setVisible(false);
            btnRemove.setVisible(false);
        }
    }

    @FXML
    private void btnPlayPressed() {
        Media selectedMedia = tblMedia.getSelectionModel().getSelectedItem();

        if (selectedMedia instanceof Playable) {
            try {
                ((Playable) selectedMedia).play();

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Play");
                alert.setHeaderText(null);
                alert.setContentText("Playing: " + selectedMedia.getTitle());
                alert.showAndWait();
            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Play Error");
                alert.setHeaderText(null);
                alert.setContentText(e.getMessage());
                alert.showAndWait();
            }
        }
    }

    @FXML
    private void btnPlaceOrderPressed() {
        if (cart.getItemsOrdered().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Place Order");
            alert.setHeaderText(null);
            alert.setContentText("Your cart is empty.");
            alert.showAndWait();
            return;
        }

        cart.getItemsOrdered().clear();
        updateTotalCost();

        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Place Order");
        alert.setHeaderText(null);
        alert.setContentText("Order placed successfully!");
        alert.showAndWait();
    }

    @FXML
    private void menuViewStorePressed() {
        if (store != null) {
            new StoreScreen(store, cart);
        }
    }

    @FXML
    private void menuAddBookPressed() {
        if (store != null) {
            new AddBookToStoreScreen(store);
        }
    }

    @FXML
    private void menuAddDVDPressed() {
        if (store != null) {
            new AddDigitalVideoDiscToStoreScreen(store);
        }
    }

    @FXML
    private void menuAddCDPressed() {
        if (store != null) {
            new AddCompactDiscToStoreScreen(store);
        }
    }
}