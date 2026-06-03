package hust.soict.dsai.aims.screen;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.store.Store;

public class AddBookToStoreScreen extends JFrame {
    private Store store;

    private JTextField tfTitle;
    private JTextField tfCategory;
    private JTextField tfCost;

    public AddBookToStoreScreen(Store store) {
        this.store = store;

        Container cp = getContentPane();
        cp.setLayout(new GridLayout(4, 2, 5, 5));

        cp.add(new JLabel("Title:"));
        tfTitle = new JTextField();
        cp.add(tfTitle);

        cp.add(new JLabel("Category:"));
        tfCategory = new JTextField();
        cp.add(tfCategory);

        cp.add(new JLabel("Cost:"));
        tfCost = new JTextField();
        cp.add(tfCost);

        JButton btnAdd = new JButton("Add Book");
        cp.add(btnAdd);

        btnAdd.addActionListener(e -> {
            try {
                String title = tfTitle.getText();
                String category = tfCategory.getText();
                float cost = Float.parseFloat(tfCost.getText());

                Book book = new Book(title, category, cost);
                store.addMedia(book);

                JOptionPane.showMessageDialog(this, "Book added successfully!");
                dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        setTitle("Add Book");
        setSize(400, 250);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}