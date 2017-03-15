package game;

import java.awt.Graphics2D;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Bird implements Updateable, Renderable {

    private float x, y;
    private float yVelocity;
    private float baseYVel = -6.0f;
    private float gravity = 0.25f;

    private Pipes pipes;
    private int scoredPipes = 0;

    private int score = 0;

    private Font gameFont = new Font("Arial", Font.BOLD, 30);

    private BufferedImage flapUp;
    private BufferedImage flapDown;

    public Bird(Pipes pipes) {
        resetBird();

        this.pipes = pipes;

        try {
            flapUp = Sprite.getSprite("bird_up.png");
            flapDown = Sprite.getSprite("bird_down.png");

        }
        catch (IOException ex) {
            System.err.println(ex.getMessage());
            System.exit(1);
        }
    }

    public void resetBird() {
        x = 100;
        y = 100;
        yVelocity = baseYVel;
    }

    private void flap() {
    yVelocity = baseYVel;
  }

    @Override
    public void update(Input input) {
        y += yVelocity;
        yVelocity += gravity;

        if (y < 0) {
            y = 0;
            yVelocity = 0;
        }

        if (input.isSpacePressed()) {
            flap();
        }

        
    }

    @Override
    public void render(Graphics2D g, float interpolation) {}

}