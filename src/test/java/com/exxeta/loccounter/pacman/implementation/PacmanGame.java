package com.exxeta.loccounter.pacman.implementation;

import javax.swing.JFrame;

public class PacmanGame extends JFrame {

  /**
   * This class represents a Pacman game.
   */

  public PacmanGame() {
    // Set up the game window
    setTitle("Pacman Game");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setResizable(false);

    // Set up the game panel
    GamePanel gamePanel = new GamePanel();
    add(gamePanel);

    // Pack and display the window
    pack();
    setLocationRelativeTo(null);
    setVisible(true);
  }

  public static void main(String[] args) {
    // Create an instance of the PacmanGame class
    PacmanGame game = new PacmanGame();
  }
}
