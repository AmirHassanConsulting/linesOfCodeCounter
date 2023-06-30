package com.exxeta.loccounter.games.collection;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

  private static final int BOARD_SIZE = 3;
  private static final char EMPTY_CELL = '-';
  private static final char PLAYER_X = 'X';
  private static final char PLAYER_O = 'O';

  private char[][] board;
  private char currentPlayer;
  private Random random;

  /**
   * Initializes the Tic-Tac-Toe game by creating an empty board, setting the current player as X,
   * and creating a random object.
   */
  public TicTacToe() {
    board = new char[BOARD_SIZE][BOARD_SIZE];
    currentPlayer = PLAYER_X;
    random = new Random();
    initializeBoard();
  }

  /**
   * Initializes the game board with empty cells.
   */
  private void initializeBoard() {
    for (int i = 0; i < BOARD_SIZE; i++) {
      for (int j = 0; j < BOARD_SIZE; j++) {
        board[i][j] = EMPTY_CELL;
      }
    }
  }

  /**
   * Prints the current state of the game board.
   */
  private void printBoard() {
    for (int i = 0; i < BOARD_SIZE; i++) {
      for (int j = 0; j < BOARD_SIZE; j++) {
        System.out.print(board[i][j] + " ");
      }
      System.out.println();
    }
  }

  /**
   * Makes a move on the game board at the specified row and column for the current player. If the
   * move is invalid, it prompts the user to try again. If the current player is O (computer), it
   * generates a random valid move.
   *
   * @param row The row index of the move.
   * @param col The column index of the move.
   */
  private void makeMove(int row, int col) {
    if (isValidMove(row, col)) {
      board[row][col] = currentPlayer;
      currentPlayer = (currentPlayer == PLAYER_X) ? PLAYER_O : PLAYER_X;
    } else {
      System.out.println("Invalid move! Please try again.");
    }
  }

  /**
   * Checks if the move at the specified row and column is valid. A move is valid if the cell is
   * empty and the row and column indices are within the board bounds.
   *
   * @param row The row index of the move.
   * @param col The column index of the move.
   * @return True if the move is valid, false otherwise.
   */
  private boolean isValidMove(int row, int col) {
    return (row >= 0 && row < BOARD_SIZE && col >= 0 && col < BOARD_SIZE
        && board[row][col] == EMPTY_CELL);
  }

  /**
   * Checks if the game board is full, indicating a tie.
   *
   * @return True if the board is full, false otherwise.
   */
  private boolean isBoardFull() {
    for (int i = 0; i < BOARD_SIZE; i++) {
      for (int j = 0; j < BOARD_SIZE; j++) {
        if (board[i][j] == EMPTY_CELL) {
          return false;
        }
      }
    }
    return true;
  }

  /**
   * Checks if the specified player has won the game. A player wins if they have three marks in a
   * row, column, or diagonal.
   *
   * @param player The player to check for a win.
   * @return True if the player has won, false otherwise.
   */
  private boolean hasPlayerWon(char player) {
    // Check rows
    for (int i = 0; i < BOARD_SIZE; i++) {
      if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
        return true;
      }
    }

    // Check columns
    for (int j = 0; j < BOARD_SIZE; j++) {
      if (board[0][j] == player && board[1][j] == player && board[2][j] == player) {
        return true;
      }
    }

    // Check diagonals
    if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
      return true;
    }
    if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
      return true;
    }

    return false;
  }

  /**
   * Starts and plays the Tic-Tac-Toe game until there is a winner or a tie.
   */
  public void play() {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Tic-Tac-Toe Game");
    System.out.println("Enter row and column (0-2) to make a move.");

    while (true) {
      System.out.println("\nCurrent Player: " + currentPlayer);
      printBoard();

      if (currentPlayer == PLAYER_X) {
        System.out.print("Enter row: ");
        int row = scanner.nextInt();

        System.out.print("Enter column: ");
        int col = scanner.nextInt();

        makeMove(row, col);
      } else {
        // Computer player (O)
        int row, col;
        do {
          row = random.nextInt(BOARD_SIZE);
          col = random.nextInt(BOARD_SIZE);
        } while (!isValidMove(row, col));

        System.out.println("Computer plays: " + row + ", " + col);
        makeMove(row, col);
      }

      if (hasPlayerWon(PLAYER_X)) {
        System.out.println("\nPlayer X wins!");
        break;
      }

      if (hasPlayerWon(PLAYER_O)) {
        System.out.println("\nPlayer O wins!");
        break;
      }

      if (isBoardFull()) {
        System.out.println("\nIt's a tie!");
        break;
      }
    }

    scanner.close();
  }

  /**
   * The entry point of the Tic-Tac-Toe game.
   *
   * @param args The command-line arguments (not used).
   */
  public static void main(String[] args) {
    TicTacToe game = new TicTacToe();
    game.play();
  }
}