package gui;
/**
 * <h1>Student representation</h1>
 * This program represents the work of
 * coffee machine
 * <p>
 *
 * @author  Sergei Obolevich
 * @version 1.0
 * @since   2018-04-04
 */
import model.Model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;

public class GUI {
    /**
     * This is the default constructor , which serves to initialize
     * the data model, which is going to be used throughout the program.
     *
     * Also setting the listener for checkBox elements,
     * which describe the properties of the coffee machine by "Student"
     */
    public GUI() {
        model = new Model();

        itemListener = new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                Object source = e.getItemSelectable();

                if(source == coffeeButton) {
                    model.addCoffee = !model.addCoffee;
                } else if(source == sugarButton) {
                    model.addSugar = !model.addSugar;
                } else if(source == waterButton) {
                    model.addWater = !model.addWater;
                }
            }
        };
    }
    /**
     * This method is used to configure the pane
     * for the program to be able to interact with user
     * @param pane This is the parameter, which contains all
     *             the GUI elements.
     * @return void.
     * @see Container
     */

    private void addComponentsToPane(Container pane) {
        pane.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = 1;
        constraints.insets.left = 20;
        constraints.insets.right = 20;

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        studentLabel = new JLabel("Student: ");
        pane.add(studentLabel, constraints);

        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.gridwidth = 3;
        studentName = new JLabel(model.student.getName());
        pane.add(studentName, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        pane.add(new JLabel("Content: "), constraints);


        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        coffeeLabel = new JLabel("Coffee : " + model.cup.getContent().getCoffeeSponsNumber());
        pane.add(coffeeLabel, constraints);

        constraints.gridx = 3;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        sugarLabel = new JLabel("Sugar : " + model.cup.getContent().getSugarCubesNumber());
        pane.add(sugarLabel, constraints);

        constraints.gridx = 5;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        waterLable = new JLabel("Water : " + model.cup.getContent().getWaterCapacity());
        pane.add(waterLable, constraints);

        constraints.gridx = 6;
        constraints.gridy = 2;
        constraints.gridwidth = 3;
        newCoffeeCupButton = new JButton("New coffee cup");
        newCoffeeCupButton.setPreferredSize(new Dimension(120, 50));
        pane.add(newCoffeeCupButton, constraints);


        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.gridwidth = 2;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        makeCoffeeButton = new JButton("Make coffee");
        makeCoffeeButton.setPreferredSize(new Dimension(120, 50));
        pane.add(makeCoffeeButton, constraints);

        constraints.gridx = 2;
        constraints.gridy = 4;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        contentLabel = new JLabel("Add components: ");
        pane.add(contentLabel, constraints);

        constraints.gridx = 4;
        constraints.gridy = 4;
        constraints.gridwidth = 1;
        coffeeButton = new JCheckBox("Coffee spons");
        coffeeButton.setMnemonic(KeyEvent.VK_C);
        coffeeButton.setSelected(true);
        pane.add(coffeeButton, constraints);

        constraints.gridx = 5;
        constraints.gridy = 4;
        constraints.gridwidth = 1;
        sugarButton = new JCheckBox("Sugar cubes");
        sugarButton.setMnemonic(KeyEvent.VK_G);
        sugarButton.setSelected(true);
        pane.add(sugarButton, constraints);

        constraints.gridx = 6;
        constraints.gridy = 4;
        constraints.gridwidth = 1;
        waterButton = new JCheckBox("Water");
        waterButton.setMnemonic(KeyEvent.VK_H);
        waterButton.setSelected(true);
        pane.add(waterButton, constraints);

        coffeeButton.addItemListener(itemListener);
        sugarButton.addItemListener(itemListener);
        waterButton.addItemListener(itemListener);

        newCoffeeCupButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    model.initializeCoffeeCup();

                    coffeeLabel.setText("Coffee : " + model.cup.getContent().getCoffeeSponsNumber());
                    sugarLabel.setText("Sugar : " + model.cup.getContent().getSugarCubesNumber());
                    waterLable.setText("Water : " + model.cup.getContent().getWaterCapacity());
                }
                catch (Exception exception) {
                    JOptionPane.showMessageDialog(null,
                            "Description : " + exception.getMessage(),
                            "Exception caught!", JOptionPane.WARNING_MESSAGE);

                }
            }
        });

        makeCoffeeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    model.student.makeCoffee(model.cup, model.sugar, model.coffee, model.kettle,
                            model.addCoffee, model.addSugar, model.addWater);
                    coffeeLabel.setText("Coffee : " + model.cup.getContent().getCoffeeSponsNumber());
                    sugarLabel.setText("Sugar : " + model.cup.getContent().getSugarCubesNumber());
                    waterLable.setText("Water : " + model.cup.getContent().getWaterCapacity());
                }
                catch (Exception exception) {
                    JOptionPane.showMessageDialog(null,
                            "Description : " + exception.getMessage(),
                            "Exception caught!", JOptionPane.WARNING_MESSAGE);

                }
            }
        });
    }

    public void createAndShowGUI() {
        JFrame frame = new JFrame("Coffee machine");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 200);
        frame.setResizable(false);

        addComponentsToPane(frame.getContentPane());
        frame.setVisible(true);
    }

    private JLabel studentLabel;
    private JLabel studentName;
    private JLabel coffeeLabel;
    private JLabel sugarLabel;
    private JLabel waterLable;
    private JButton newCoffeeCupButton;
    private JButton makeCoffeeButton;
    private JLabel contentLabel;
    private JCheckBox coffeeButton;
    private JCheckBox sugarButton;
    private JCheckBox waterButton;
    private ItemListener itemListener;

    private Model model;
}