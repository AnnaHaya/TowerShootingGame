import processing.core.PApplet;

public class Enemy {
    int x, y, speedX, speedY;
    public static final int width = 30;
    public static final int length = 30;
    PApplet parent;

    public Enemy(PApplet parent, int x, int y, int speedX, int speedY) {
        this.parent = parent;
        this.x = x;
        this.y = y;
        this.speedX = speedX;
        this.speedY = speedY;
    }

    public void move() {
        x += speedX;
        y += speedY;

        if (x > parent.width) {
            x = 0-width;
        }
    }

    public void draw(PApplet parent) {
        parent.fill(0);
        parent.rect(x, y, width, length);
    }
}
