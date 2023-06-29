package com.exxeta.loccounter.pacman.implementation;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class GamePanel extends JPanel {
 
  /**
   * This class represents the game panel where the Pacman game is played.
   */

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    // Draw the Pacman character
    g.setColor(Color.YELLOW);
    g.fillArc(50, 50, 200, 200, 45, 270);
  }
}