package game;

import java.awt.Graphics2D;
import java.awt.Color;
import java.util.Random;

public class Pipes implements Updateable, Renderable {

  private int pipeWidth = 100;
  private int pipeHorizontalSpace = 210;
  private int pipeVerticalSpace = 180;

  private float xVelocity = -5.0f;
  private float x1, x2, x3;
  private float y1, y2, y3;

  // Pipe closest to Bird
  private int currentPipe;
  // Array to store Pipe coordinates
  private float[][] pipeCoords = new float[3][2];

  private Random randObj;

  public Pipes() {
    randObj = new Random();

    resetPipes();
  }

  public void resetPipes() {
    currentPipe = 0;

    x1 = Game.WIDTH * 2;
    x2 = x1 + pipeWidth + pipeHorizontalSpace;
    x3 = x2 + pipeWidth + pipeHorizontalSpace;

    y1 = getRandomY();
    y2 = getRandomY();
    y3 = getRandomY();

  }

  private int getRandomY() {
    return randObj.nextInt((int) (Game.HEIGHT * 0.4f)) + (Game.HEIGHT / 10);
  }

  @Override
  public void update(Input input) {

    x1 += xVelocity;
    x2 += xVelocity;
    x3 += xVelocity;

    if (x1 + pipeWidth < 0) {
      x1 = Game.WIDTH;
      y1 = getRandomY();
      currentPipe = 1;
    }
    if (x2 + pipeWidth < 0) {
      x2 = Game.WIDTH;
      y2 = getRandomY();
      currentPipe = 2;
    }
    if (x3 + pipeWidth < 0) {
      x3 = Game.WIDTH;
      y3 = getRandomY();
      currentPipe = 3;
    }

    // Update Pipe Coordinates
    switch(currentPipe) {
      case 0:
        pipeCoords[0][0] = x1;
        pipeCoords[0][1] = y1;
        break;
      case 1:
        pipeCoords[1][0] = x2;
        pipeCoords[1][1] = y2;
        break;
      case 2:
        pipeCoords[2][0] = x3;
        pipeCoords[2][1] = y3;
        break;
    }
  }

  @Override
  public void render(Graphics2D g, float interpolation) {
    g.setColor(Color.RED);

    // Pipe 1
    g.fillRect((int) (x1 + (xVelocity * interpolation)), 0, pipeWidth, (int) y1);
    g.fillRect((int) (x1 + (xVelocity * interpolation)), (int) (y1 + pipeVerticalSpace), pipeWidth, Game.HEIGHT);

    // Pipe 2
    g.fillRect((int) (x2 + (xVelocity * interpolation)), 0, pipeWidth, (int) y2);
    g.fillRect((int) (x2 + (xVelocity * interpolation)), (int) (y2 + pipeVerticalSpace), pipeWidth, Game.HEIGHT);

    // Pipe 3
    g.fillRect((int) (x3 + (xVelocity * interpolation)), 0, pipeWidth, (int) y3);
    g.fillRect((int) (x3 + (xVelocity * interpolation)), (int) (y3 + pipeVerticalSpace), pipeWidth, Game.HEIGHT);

  }

  public float[] getCurrentPipe() {
    return pipeCoords[currentPipe];
  }

  public int getCurrentPipeID() {
    return currentPipe;
  }

  public int getPipeWidth() {
    return pipeWidth;
  }

  public int getPipeHorizontalSpace() {
    return pipeHorizontalSpace;
  }

  public int getPipeVerticalSpace() {
    return pipeVerticalSpace;
  }

}