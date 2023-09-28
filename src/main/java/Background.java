import java.awt.*;
import java.awt.geom.Arc2D;

public class Background {
    private int width;
    private int height;
    // if TimeOfDay is true - morning, else - evening
    private boolean timeOfDay;

    public void setWidth (int width) {
        this.width = width;
    }

    public void setHeight (int height) {
        this.height = height;
    }

    public void setTimeOfDay (boolean timeOfDay) {
        this.timeOfDay = timeOfDay;
    }

    public Background(final int width, final int height, final boolean timeOfDay) {
        this.width = width;
        this.height = height;
        this.timeOfDay = timeOfDay;
    }

    void draw(final Graphics gr) {
        Graphics2D g = (Graphics2D) gr;
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Background
        GradientPaint gradientPaint;
        if(this.timeOfDay) {
            gradientPaint = new GradientPaint(0, 0, new Color(60, 160, 208), 0, this.height, new Color(60, 108, 223));
        } else {
            gradientPaint = new GradientPaint(0, 0, new Color(228, 0, 69), 0, this.height, new Color(50, 10, 110));
        }
        g.setPaint(gradientPaint);
        g.fillRect(0,0,this.width, this.height);
        if(this.timeOfDay ) {
            g.setColor(new Color(255,222,115));
            g.fillOval(200, 30, 30,30);
        }

        // Road
        if (this.timeOfDay) g.setColor(Color.DARK_GRAY);
        else g.setColor(new Color(15,15,15));
        g.fillRect(0,this.height - 200,this.width, 180);
        g.setColor(Color.WHITE);
        g.fillRect(0,this.height - 125, 100, 10);
        g.fillRect(120,this.height - 125, 100, 10);
        g.fillRect(240,this.height - 125, 100, 10);
        g.fillRect(360,this.height - 125, 100, 10);
        g.fillRect(480,this.height - 125, 100, 10);
        g.fillRect(600,this.height - 125, 100, 10);
        g.fillRect(720,this.height - 125, 100, 10);

        // Lampposts
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(this.width - 650, this.height - 500, 20, 300);
        if (timeOfDay) {
            g.setColor(Color.WHITE);
        } else {
            g.setColor(new Color(255,255,0,60));
            g.fill(new Polygon(
                    new int[] {this.width - 800 + 9 - 16, this.width - 600 + 9, this.width - 400 + 9 + 16},
                    new int[]{this.height, this.height - 515, this.height},
                    3));
            g.setColor(Color.YELLOW);
        }
        g.fillOval(this.width - 601, this.height - 504, 20,20);
        g.setColor(Color.LIGHT_GRAY);
        g.fillOval(this.width - 601 - 5, this.height - 504, 30, 10);
        g.setStroke(new BasicStroke(20));
        g.draw(new Arc2D.Float(this.width - 641, this.height - 520, 49, 30, 0, 180, Arc2D.OPEN));
        g.setColor(Color.BLACK);
        g.fillRect(this.width - 650 - 1, this.height - 500, 21 ,10);

        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(this.width - 200, this.height - 500, 20, 300);
        if (timeOfDay){
            g.setColor(Color.WHITE);
        } else {
            g.setColor(new Color(255,255,0,60));
            g.fill(new Polygon(
                    new int[]{this.width - 450 + 9 - 16, this.width - 247 + 9, this.width - 50 + 9 + 16},
                    new int[] {this.height, this.height - 515, this.height},
                    3 ));
            g.setColor(Color.YELLOW);
        }
        g.fillOval(this.width - 248, this.height - 504, 20,20);
        g.setColor(Color.LIGHT_GRAY);
        g.fillOval(this.width - 248 - 5, this.height - 504, 30, 10);
        g.setStroke(new BasicStroke(20));
        g.draw(new Arc2D.Float(this.width - 239, this.height - 520, 49,30,0,180, Arc2D.OPEN));
        g.setColor(Color.BLACK);
        g.fillRect(this.width - 200, this.height - 500, 21 ,10);
    }
}
