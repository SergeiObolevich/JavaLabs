package gui;

/**
 * <h1>Main</h1>
 *
 * Main simply implements "main" method
 */

public class Main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                GUI userInterface = new GUI();
                userInterface.createAndShowGUI();
            }
        });
    }
}