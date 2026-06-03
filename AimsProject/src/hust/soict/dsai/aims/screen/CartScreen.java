package hust.soict.dsai.aims.screen;

import java.awt.Dimension;
import java.io.IOException;

import javax.swing.JFrame;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.store.Store;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class CartScreen extends JFrame {
    private Cart cart;
    private Store store;

    public CartScreen(Cart cart) {
        this(cart, null);
    }

    public CartScreen(Cart cart, Store store) {
        super();

        this.cart = cart;
        this.store = store;

        JFXPanel fxPanel = new JFXPanel();
        this.add(fxPanel);

        this.setTitle("Cart");
        this.setSize(new Dimension(1024, 768));
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    FXMLLoader loader = new FXMLLoader(
                            getClass().getResource("/hust/soict/dsai/aims/screen/cart.fxml")
                    );

                    CartScreenController controller = new CartScreenController(cart, store);
                    loader.setController(controller);

                    Parent root = loader.load();
                    Scene scene = new Scene(root);

                    fxPanel.setScene(scene);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}