package gui;

import model.Model;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
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
                } else if(source == teaButton) {
                    model.addTea = !model.addTea;
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

        constraints.gridx = 2;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        coffeeLabel = new JLabel("Coffee : " + model.cup.getContent().getCoffeeSponsNumber());
        pane.add(coffeeLabel, constraints);

        constraints.gridx = 3;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        sugarLabel = new JLabel("Sugar : " + model.cup.getContent().getSugarCubesNumber());
        pane.add(sugarLabel, constraints);

        constraints.gridx = 4;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        waterLabel = new JLabel("Water : " + model.cup.getContent().getWaterCapacity());
        pane.add(waterLabel, constraints);

        constraints.gridx = 5;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        teaLabel = new JLabel("Tea : " + model.cup.getContent().getTeaSponsNumber());
        pane.add(teaLabel, constraints);

        constraints.gridx = 6;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        milkLabel = new JLabel("Milk : " + model.cup.getContent().getMilkCapacity());
        pane.add(milkLabel, constraints);

        constraints.gridx = 0;
        constraints.gridy = 6;
        constraints.gridwidth = 2;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        makeCoffeeButton = new JButton("Make coffee");
        makeCoffeeButton.setPreferredSize(new Dimension(150, 40));
        pane.add(makeCoffeeButton, constraints);

        constraints.gridx = 2;
        constraints.gridy = 6;
        constraints.gridwidth = 2;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        makeCoffeeWithMilkButton = new JButton("Make coffee with milk");
        makeCoffeeWithMilkButton.setPreferredSize(new Dimension(150, 40));
        pane.add(makeCoffeeWithMilkButton, constraints);

        constraints.gridx = 4;
        constraints.gridy = 6;
        constraints.gridwidth = 2;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        makeTeaButton = new JButton("Make tea");
        makeTeaButton.setPreferredSize(new Dimension(150, 40));
        pane.add(makeTeaButton, constraints);

        constraints.gridx = 6;
        constraints.gridy = 6;
        constraints.gridwidth = 2;
        newCoffeeCupButton = new JButton("New cup");
        newCoffeeCupButton.setPreferredSize(new Dimension(150, 40));
        pane.add(newCoffeeCupButton, constraints);

        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        contentLabel = new JLabel("Add components: ");
        pane.add(contentLabel, constraints);

        constraints.gridx = 2;
        constraints.gridy = 4;
        constraints.gridwidth = 1;
        coffeeButton = new JCheckBox("Coffee spons");
        coffeeButton.setMnemonic(KeyEvent.VK_0);
        coffeeButton.setSelected(false);
        pane.add(coffeeButton, constraints);

        constraints.gridx = 3;
        constraints.gridy = 4;
        constraints.gridwidth = 1;
        sugarButton = new JCheckBox("Sugar cubes");
        sugarButton.setMnemonic(KeyEvent.VK_1);
        sugarButton.setSelected(false);
        pane.add(sugarButton, constraints);

        constraints.gridx = 4;
        constraints.gridy = 4;
        constraints.gridwidth = 1;
        teaButton = new JCheckBox("Tea");
        teaButton.setMnemonic(KeyEvent.VK_2);
        teaButton.setSelected(false);
        pane.add(teaButton, constraints);

        coffeeButton.addItemListener(itemListener);
        sugarButton.addItemListener(itemListener);
        teaButton.addItemListener(itemListener);

        newCoffeeCupButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    model.initializeCup();

                    coffeeLabel.setText("Coffee : " + model.cup.getContent().getCoffeeSponsNumber());
                    sugarLabel.setText("Sugar : " + model.cup.getContent().getSugarCubesNumber());
                    waterLabel.setText("Water : " + model.cup.getContent().getWaterCapacity());
                    milkLabel.setText("Milk : " + model.cup.getContent().getMilkCapacity());
                    teaLabel.setText("Tea : " + model.cup.getContent().getTeaSponsNumber());
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
                    if (model.cup.getContent().getTeaSponsNumber() != 0 ||
                            model.cup.getContent().getMilkCapacity() != 0) {
                        throw new IllegalArgumentException("Please take a new cup my friend!");
                    }
                    model.student.makeCoffee(model.cup, model.addCoffee, model.addSugar, model.addTea);
                    coffeeLabel.setText("Coffee : " + model.cup.getContent().getCoffeeSponsNumber());
                    sugarLabel.setText("Sugar : " + model.cup.getContent().getSugarCubesNumber());
                    waterLabel.setText("Water : " + model.cup.getContent().getWaterCapacity());
                }
                catch (Exception exception) {
                    JOptionPane.showMessageDialog(null,
                            "Description : " + exception.getMessage(),
                            "Exception caught!", JOptionPane.WARNING_MESSAGE);

                }
            }
        });

        makeCoffeeWithMilkButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    if (model.cup.getContent().getTeaSponsNumber() != 0 ||
                            (model.cup.getContent().getWaterCapacity() != 0 && model.cup.getContent().getMilkCapacity() == 0)) {
                        throw new IllegalArgumentException("Please take a new cup my friend!");
                    }
                    model.student.makeCoffeeWithMilk(model.cup, model.addCoffee, model.addSugar, model.addTea);
                    coffeeLabel.setText("Coffee : " + model.cup.getContent().getCoffeeSponsNumber());
                    sugarLabel.setText("Sugar : " + model.cup.getContent().getSugarCubesNumber());
                    waterLabel.setText("Water : " + model.cup.getContent().getWaterCapacity());
                    milkLabel.setText("Milk : " + model.cup.getContent().getMilkCapacity());
                }
                catch (Exception exception) {
                    JOptionPane.showMessageDialog(null,
                            "Description : " + exception.getMessage(),
                            "Exception caught!", JOptionPane.WARNING_MESSAGE);

                }
            }
        });

        makeTeaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    if (model.cup.getContent().getCoffeeSponsNumber() != 0 ) {
                        throw new IllegalArgumentException("Please take a new cup my friend!");
                    }
                    model.student.makeTea(model.cup, model.addTea, model.addSugar, model.addCoffee);
                    sugarLabel.setText("Sugar : " + model.cup.getContent().getSugarCubesNumber());
                    waterLabel.setText("Water : " + model.cup.getContent().getWaterCapacity());
                    milkLabel.setText("Milk : " + model.cup.getContent().getMilkCapacity());
                    teaLabel.setText("Tea : " + model.cup.getContent().getTeaSponsNumber());
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
        frame.setSize(800, 150);
        frame.setResizable(false);

        addComponentsToPane(frame.getContentPane());
        frame.setVisible(true);
    }

    private JLabel studentLabel;
    private JLabel studentName;
    private JLabel coffeeLabel;
    private JLabel sugarLabel;
    private JLabel waterLabel;
    private JLabel teaLabel;
    private JLabel milkLabel;
    private JButton newCoffeeCupButton;
    private JButton makeCoffeeButton;
    private JButton makeTeaButton;
    private JButton makeCoffeeWithMilkButton;
    private JLabel contentLabel;
    private JCheckBox coffeeButton;
    private JCheckBox sugarButton;
    private JCheckBox teaButton;
    private ItemListener itemListener;

    private Model model;
}