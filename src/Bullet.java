import processing.core.PApplet;

public class Bullet {
    int x, y, speedX, speedY;
    PApplet parent;

    public Bullet(PApplet parent, int x, int y, int speedX, int speedY) {
        this.parent = parent;
        this.x = x;
        this.y = y;
        this.speedX = speedX;
        this.speedY = speedY;
    }

    public void move() {
        x += speedX;
        y += speedY;
    }

    public boolean collidesWith(Enemy enemy) {
        return x > enemy.x && x < enemy.x + Enemy.width &&
                y > enemy.y && y < enemy.y + Enemy.length;
    }

    public void draw(PApplet parent) {
        parent.fill(255, 0, 0);
        parent.ellipse(x, y, 10, 10);
    }
}
