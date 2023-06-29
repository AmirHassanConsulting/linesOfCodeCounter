package com.exxeta.loccounter.games.collection;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class PacmanGame extends JPanel implements ActionListener {

  private static final int SCREEN_WIDTH = 600;
  private static final int SCREEN_HEIGHT = 600;
  private static final int UNIT_SIZE = 40;
  private static final int DELAY = 150;

  private int pacmanX;
  private int pacmanY;
  private int pacmanSize;
  public char pacmanDirection;

  public PacmanGame() {
    setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
    setBackground(Color.black);
    setFocusable(true);
    addKeyListener(new PacmanKeyListener());

    pacmanSize = UNIT_SIZE;
    pacmanX = SCREEN_WIDTH / 2;
    pacmanY = SCREEN_HEIGHT / 2;
    pacmanDirection = 'R';

    Timer timer = new Timer(DELAY, this);
    timer.start();
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    drawPacman(g);
  }

  private void drawPacman(Graphics g) {
    g.setColor(Color.yellow);
    g.fillArc(pacmanX, pacmanY, pacmanSize, pacmanSize, getAngle(pacmanDirection) + 45, 270);
  }

  private int getAngle(char direction) {
    switch (direction) {
      case 'U':
        return 90;
      case 'D':
        return 270;
      case 'L':
        return 180;
      case 'R':
      default:
        return 0;
    }
  }

  private void movePacman() {
    switch (pacmanDirection) {
      case 'U':
        pacmanY -= UNIT_SIZE;
        break;
      case 'D':
        pacmanY += UNIT_SIZE;
        break;
      case 'L':
        pacmanX -= UNIT_SIZE;
        break;
      case 'R':
        pacmanX += UNIT_SIZE;
        break;
    }
  }

  private class PacmanKeyListener extends KeyAdapter {

    @Override
    public void keyPressed(KeyEvent e) {
      char key = e.getKeyChar();
      switch (key) {
        case 'w':
          pacmanDirection = 'U';
          break;
        case 's':
          pacmanDirection = 'D';
          break;
        case 'a':
          pacmanDirection = 'L';
          break;
        case 'd':
          pacmanDirection = 'R';
          break;
      }
    }
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    movePacman();
    repaint();
  }

  public static void main(String[] args) {
    JFrame frame = new JFrame("Pacman Game");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().add(new PacmanGame());
    frame.pack();
    frame.setVisible(true);
  }
}

