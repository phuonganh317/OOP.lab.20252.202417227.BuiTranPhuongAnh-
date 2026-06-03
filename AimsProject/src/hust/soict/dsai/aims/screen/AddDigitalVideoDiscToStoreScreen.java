package hust.soict.dsai.aims.screen;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import hust.soict.dsai.aims.media.DVD;
import hust.soict.dsai.aims.store.Store;

public class AddDigitalVideoDiscToStoreScreen extends JFrame {
    private Store store;

    private JTextField tfTitle;
    private JTextField tfCategory;
    private JTextField tfDirector;
    private JTextField tfLength;
    private JTextField tfCost;

    public AddDigitalVideoDiscToStoreScreen(Store store) {
        this.store = store;

        Container cp = getContentPane();
        cp.setLayout(new GridLayout(6, 2, 5, 5));

        cp.add(new JLabel("Title:"));
        tfTitle = new JTextField();
        cp.add(tfTitle);

        cp.add(new JLabel("Category:"));
        tfCategory = new JTextField();
        cp.add(tfCategory);

        cp.add(new JLabel("Director:"));
        tfDirector = new JTextField();
        cp.add(tfDirector);

        cp.add(new JLabel("Length:"));
        tfLength = new JTextField();
        cp.add(tfLength);

        cp.add(new JLabel("Cost:"));
        tfCost = new JTextField();
        cp.add(tfCost);

        JButton btnAdd = new JButton("Add DVD");
        cp.add(btnAdd);

        btnAdd.addActionListener(e -> {
            try {
                String title = tfTitle.getText();
                String category = tfCategory.getText();
                String director = tfDirector.getText();
                int length = Integer.parseInt(tfLength.getText());
                float cost = Float.parseFloat(tfCost.getText());

                DVD dvd = new DVD(title, category, director, length, cost);
                store.addMedia(dvd);

                JOptionPane.showMessageDialog(this, "DVD added successfully!");
                dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        setTitle("Add DVD");
        setSize(400, 300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}