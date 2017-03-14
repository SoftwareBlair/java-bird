package game;

import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;

public class Game {

  public final static int WIDTH = 800, HEIGHT = 600;

  private String gameName = "Java Bird";

  private Canvas game = new Canvas();

  public void start() {
    // Initialize Window Object
    Dimension gameSize = new Dimension(Game.WIDTH, Game.HEIGHT);
    JFrame gameWindow = new JFrame(gameName);

    gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    gameWindow.setSize(gameSize);
    gameWindow.setResizable(false);
    gameWindow.setVisible(true);
    game.setSize(gameSize);
    game.setMinimumSize(gameSize);
    game.setMinimumSize(gameSize);
    game.setPreferredSize(gameSize);
    gameWindow.add(game);
    gameWindow.setLocationRelativeTo(null);

    // Game Loop
    boolean running = true;

    while(running) {

    }
    // Game End
  }

}