import processing.core.PApplet;
import java.util.ArrayList;

public class Game extends PApplet {
    ArrayList<Tower> towers = new ArrayList<>();
    ArrayList<Bullet> bullets = new ArrayList<>();
    ArrayList<Enemy> enemies = new ArrayList<>();

    public void settings() {
        size(800, 800);
    }

    public void setup() {
        for (int i = 0; i < 10; i++) {
            enemies.add(new Enemy(this, i * 100 + 50, 405, 2, 0));
        }
    }

    public void draw() {
        background(255);
        fill(105);
        rect(0, 350, 800, 150);
        for (Tower tower : towers) {
            Bullet bullet;
           if(tower.getY() > 500) {
               bullet = tower.shoot( -3);
           }
           else {
               bullet = tower.shoot(3);
           }

            if (bullet != null) {
                bullets.add(bullet);
            }
            tower.draw(this);
        }

        ArrayList<Enemy> hitEnemies = new ArrayList<>();
        for (Bullet bullet : bullets) {
            bullet.move();
            bullet.draw(this);
            for (Enemy enemy : enemies) {
                if (bullet.collidesWith(enemy)) {
                    hitEnemies.add(enemy);
                }
            }
        }

        enemies.removeAll(hitEnemies);
        for (Enemy enemy : enemies) {
            enemy.move();
            enemy.draw(this);
        }
        if(enemies.size() ==0) {
            textSize(75);
            fill(0, 408, 612);
            text("YOU WIN! YIPEEE", 100, 400);


        }

    }

    public void mousePressed() {
        // When mouse is pressed, place a tower
        if(mouseY < 325 || mouseY > 525) {
            towers.add(new Tower(this, mouseX, mouseY));
        }
    }

    public static void main(String[] args) {
        PApplet.main("Game");
    }
}
