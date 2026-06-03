package hust.soict.dsai.aims.screen;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import hust.soict.dsai.aims.store.Store;

public class AddCompactDiscToStoreScreen extends JFrame {
    private Store store;

    private JTextField tfTitle;
    private JTextField tfCategory;
    private JTextField tfArtist;
    private JTextField tfCost;

    public AddCompactDiscToStoreScreen(Store store) {
        this.store = store;

        Container cp = getContentPane();
        cp.setLayout(new GridLayout(5, 2, 5, 5));

        cp.add(new JLabel("Title:"));
        tfTitle = new JTextField();
        cp.add(tfTitle);

        cp.add(new JLabel("Category:"));
        tfCategory = new JTextField();
        cp.add(tfCategory);

        cp.add(new JLabel("Artist:"));
        tfArtist = new JTextField();
        cp.add(tfArtist);

        cp.add(new JLabel("Cost:"));
        tfCost = new JTextField();
        cp.add(tfCost);

        JButton btnAdd = new JButton("Add CD");
        cp.add(btnAdd);

        btnAdd.addActionListener(e -> {
            JOptionPane.showMessageDialog(
                    this,
                    "CD screen is created. To add CD to store, update this class according to your CompactDisc constructor.",
                    "Add CD",
                    JOptionPane.INFORMATION_MESSAGE
            );
        });

        setTitle("Add CD");
        setSize(400, 280);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}