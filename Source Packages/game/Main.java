package game;

public class Main {
    public static void main(String[] args) {
        Game g = new Game();

        // Initialize Game Objects
        Pipes p = new Pipes();

        // Add Updateables and Renderables
        g.addRenderable(p);
        g.addUpdateable(p);

        // Start Game
        g.start();
    }
}