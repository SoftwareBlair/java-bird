package game;

import java.awt.Graphics2D;

public class Bird implements Updateable, Renderable {

  private float x, y;
  private float yVelocity;
  private float baseYVel = -6.0f;
  private float gravity = 0.25f;

  public void resetBird() {
    x = 100;
    y = 100;
    yVelocity = baseYVel;
  }

  private void flap() {
    yVelocity = baseYVel;
  }

  @Override
  public void update(Input input) {}

  @Override
  public void render(Graphics2D g, float interpolation) {}

}