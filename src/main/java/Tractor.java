import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Arc2D;

public class Tractor {
    private int x;
    private int y;
    private int width;
    private int height;
    private Color color;
    private boolean timeOfDay;

    public Tractor(final int x, final int y, final int width, final int height, final Color color, final boolean timeOfDay){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
        this.timeOfDay = timeOfDay;
    }

    public void setX (int x) {
        this.x = x;
    }

    public void setY (int y) {
        this.y = y;
    }

    public void setColor (Color color) {
        this.color = color;
    }

    public void setWidth (int width) {
        this.width = width;
    }

    public void setHeight (int height) {
        this.height = height;
    }

    void draw(final Graphics gr) {
        Graphics2D g = (Graphics2D) gr;
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Lights from headlights
        if (!timeOfDay) {
            g.setColor(new Color(255,255,255,100));
            g.fill(new Polygon(new int[]{this.x + 400, this.x + 900, this.x + 900},
                               new int[]{this.y - 123, this.y - 123 - 150, this.y - 123 + 150 },
                        3));
            g.setColor(new Color(255,255,255,100));
            g.fill(new Polygon(new int[]{this.x - 400, this.x + 75, this.x - 400},
                               new int[]{this.y - 260 - 300, this.y - 255, this.y - 260 + 300 },
                        3));
        }

        // Carcass
        g.setColor(this.color);
        g.fillRect(this.x + 20, this.y - 100 - 130 + 40, 400, 150);
        g.fillRect(this.x + 80, this.y - 100 - 160,170, 200);
        g.setColor(Color.BLACK);
        g.fillRect(this.x + 80 + 110, this.y - 100 + 6, 45, 52);
        g.setColor(Color.DARK_GRAY);
        g.fillRect(this.x + 80 + 110 + 10, this.y - 100 + 6, 25, 52);
        g.setColor(this.color);
        g.fillRect(this.x + 80 + 110, this.y - 100 + 18, 46, 7);
        g.fillRect(this.x + 80 + 110, this.y - 100 + 38, 46, 7);
        g.setColor(Color.YELLOW);
        g.fillRect(this.x + 80 + 169, this.y - 100 - 60, 151, 13);
        g.setColor(Color.BLACK);
        Font font = new Font("Lucida Sans Regular", Font.BOLD, 12);
        g.setFont(font);
        g.drawString("T r a c t o R", this.x + 80 + 160 + 20, this.y - 100 - 60 + 10 );



        // Windows and cabin
        GradientPaint gradientPaint;
        if(this.timeOfDay) {
            gradientPaint = new GradientPaint(0, 0, new Color(60, 160, 208), 0, this.height, new Color(60, 108, 223));
        } else {
            gradientPaint = new GradientPaint(0, 0, new Color(228, 0, 69), 0, this.height, new Color(42, 6, 103));
        }
        g.setPaint(gradientPaint);
        g.fillRect(this.x + 90, this.y - 100 - 160 + 10, 160, 156);

        g.setColor(Color.BLACK);
        g.fillRect(this.x + 90, this.y - 250 + 142, 160, 14);
        g.fillRect(this.x + 238, this.y - 190, 12, 96);
        g.fillOval(this.x + 145, this.y - 145, 60,10);
        g.fill(new Polygon(
                new int[]{this.x + 145 - 10, this.x + 145 - 5, this.x + 145 + 47},
                new int[] {this.y - 145 + 9, this.y - 145 + 50, this.y - 145 + 9},
                3 ));
        g.fillRect(this.x + 145, this.y - 196, 10, 55);
        g.fillOval(this.x + 145 + 5, this.y - 196, 10, 55);
        g.fill(new Polygon(
                new int[] {this.x + 216, this.x + 216 + 8, this.x + 223 + 25, this.x + 223 + 25},
                new int[] {this.y - 178, this.y - 178, this.y - 136, this.y - 125},
                4
        ));
        g.setStroke(new BasicStroke(6));
        g.draw(new Arc2D.Float(this.x + 208, this.y - 195, 16, 30, 90, 360, Arc2D.CHORD));
        g.fillRect(this.x + 216, this.y - 195, 3, 18);
        g.fillRect(this.x + 208, this.y - 180, 18,3);
        g.draw(new Arc2D.Float(this.x + 212, this.y - 195 + 68, 30, 20, 80, 100, Arc2D.OPEN));
        g.fill(new Polygon(
                new int[] {this.x + 216, this.x + 216 + 8, this.x + 223 + 25, this.x + 223 + 25},
                new int[] {this.y - 125, this.y - 125, this.y - 105, this.y - 97},
                4
        ));


        g.setPaint(new Color(60, 160, 208,67));
        g.fillRect(this.x + 90, this.y - 100 - 160 + 10, 160, 156);
        g.setColor(this.color);
        g.fillOval(this.x + 20, this.y - 100 - 60,158, 136);

        // Exhaust
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(this.x + 380, this.y - 300, 20, 110);
        g.fillRect(this.x + 380 + 5, this.y - 300 - 20, 10, 21);
        g.setColor(Color.DARK_GRAY);
        g.fillOval(this.x + 380, this.y - 288, 10, 10);
        g.fillOval(this.x + 390, this.y - 270, 10, 10);
        g.fillOval(this.x + 380, this.y - 252, 10, 10);
        g.fillOval(this.x + 390, this.y - 230, 10, 10);
        g.fillOval(this.x + 380, this.y - 212, 10, 10);

        // Engine
        g.setColor(Color.DARK_GRAY);
        g.fillRoundRect(this.x + 345, this.y - 100 - 40, 50, 100, 50,40);
        g.fillRect(this.x + 370, this.y - 100 - 40, 50, 100);
        g.setColor(Color.BLACK);
        g.fillRect(this.x + 352, this.y - 100 - 40 + 6, 5, 87);
        g.fillRect(this.x + 364, this.y  - 100 - 40, 5, 100);
        g.fillRect(this.x + 376, this.y  - 100 - 40, 5, 100);
        g.fillRect(this.x + 388, this.y  - 100 - 40, 5, 100);
        g.fillRect(this.x + 400, this.y  - 100 - 40, 5, 100);
        g.fillRect(this.x + 412, this.y  - 100 - 40, 5, 100);

        // Headlights
        g.setColor(new Color(246, 0, 24));
        g.fillRoundRect(this.x + 19, this.y - 190 - 5, 24,20, 20, 15);
        g.setColor(this.color);
        g.fillOval(this.x + 20, this.y - 190, 40, 20);
        g.setColor(Color.DARK_GRAY);
        g.fillRect(this.x + 75, this.y - 260 + 3, 8, 4);
        g.fillOval(this.x + 67, this.y - 260, 10, 10);
        g.setColor(Color.WHITE);
        g.fillOval(this.x + 62, this.y - 260, 10,10);
        g.setColor(Color.DARK_GRAY);
        g.fillRect(this.x + 67, this.y - 260, 5, 10);
        g.setColor(Color.BLACK);
        g.fillRect(this.x + 243, this.y - 260 - 7, 4,7);
        g.fillRect(this.x + 243 - 5, this.y - 260 - 7 - 4, 14,5);
        g.setColor(Color.ORANGE);
        g.fillOval(this.x + 243 - 5, this.y - 260 - 7 - 15, 15,12);
        g.fillRect(this.x + 243 - 5, this.y - 260 - 7 - 10, 15,7);
        g.setColor(Color.WHITE);
        g.fillOval(this.x + 408, this.y - 140 + 10, 18,15);
        g.setColor(Color.GRAY);
        g.fillRect(this.x + 408, this.y - 140 + 10, 12, 15);

        // Left wheel
        g.setColor(Color.BLACK);
        g.fillOval(this.x - 15, this.y - 100 - 15 - 20, 180, 180);
        g.setColor(Color.YELLOW);
        g.fillOval(this.x, this.y - 100 - 20, 150,150);
        g.setColor(Color.ORANGE);
        g.fillOval(this.x + 10, this.y - 100 + 10 - 20, 130, 130);
        g.setColor(Color.YELLOW);
        g.fillOval(this.x + 30, this.y - 100 + 30 - 20, 90, 90);
        g.setColor(Color.GRAY);
        g.fillOval(this.x + 60, this.y - 100 - 20 + 60, 30, 30);
        g.setColor(Color.BLACK);
        g.setStroke(new BasicStroke(12));
        g.draw(new Arc2D.Float(this.x - 23, this.y - 100 - 50, 200, 200,20,140,Arc2D.OPEN));


        // Right wheel
        g.setColor(Color.BLACK);
        g.fillOval(this.x - 15 + 320, this.y - 100 - 15 + 10, 150, 150);
        g.setColor(Color.YELLOW);
        g.fillOval(this.x + 320, this.y - 100 + 10, 120,120);
        g.setColor(Color.ORANGE);
        g.fillOval(this.x + 10 + 320, this.y - 100 + 10 + 10, 100, 100);
        g.setColor(Color.YELLOW);
        g.fillOval(this.x + 30 + 320, this.y - 100 + 30 + 10, 60, 60);
        g.setColor(Color.GRAY);
        g.fillOval(this.x + 50 + 320, this.y - 100 + 50 + 10, 20, 20);
        g.setColor(Color.BLACK);
        g.setStroke(new BasicStroke(12));
        g.draw(new Arc2D.Float(this.x - 27 + 320, this.y - 100 - 21, 170, 170,60,120,Arc2D.OPEN));


    }
}
