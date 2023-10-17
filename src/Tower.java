import processing.core.PApplet;

public class Tower {
    int x, y;
    PApplet parent;
    private int cooldown = 0;
    private static final int SHOOT_INTERVAL = 60;  // shoots every 60 frames

    public Tower(PApplet parent, int x, int y) {
        this.parent = parent;
        this.x = x;
        this.y = y;
    }
    public int getY() {
        return y;
    }
    public Bullet shoot(int speedY) {

        if (cooldown <= 0) {
            cooldown = SHOOT_INTERVAL;
            return new Bullet(parent, x, y, 0,speedY);
        }
        cooldown--;  // reduce the cooldown counter
        return null;
    }

    public void draw(PApplet parent) {
        parent.fill(100, 100, 255);
        parent.rect(x - 20, y - 20, 40, 40);
    }
}
