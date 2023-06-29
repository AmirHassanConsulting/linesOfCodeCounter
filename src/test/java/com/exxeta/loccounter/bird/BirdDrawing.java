package com.exxeta.loccounter.bird;

public class BirdDrawing {

  /**
   * This method draws a bird in ASCII art.
   */
  public static void drawBird() {
    System.out.println("       _");
    System.out.println("     _( )_");
    System.out.println("   (_  ,_)_)");
    System.out.println("     /     \\");
    System.out.println("   (   \\_/   )");
    System.out.println("    \\       /");
    System.out.println("     \\ `-' /");
    System.out.println("      `-.-'");
  }

  public static void main(String[] args) {
    // Call the drawBird method to draw the bird
    drawBird();
  }
}