import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DrawingPanel extends JPanel implements ActionListener {

    private final int PANEL_WIDTH;
    private final int PANEL_HEIGHT;
    private final int TIMER_DELAY;
    private final boolean TIME_OF_DAY;
    private final Timer timer;
    private int ticksFromStart = -100;

    private final Tractor tractor;
    private final Background background;
    public DrawingPanel(final int width, final int height, final int timerDelay, final boolean timeOfDay) {
        this.PANEL_WIDTH = width;
        this.PANEL_HEIGHT = height;
        this.TIMER_DELAY = timerDelay;
        this.TIME_OF_DAY = timeOfDay;
        timer = new Timer(timerDelay, this);
        timer.start();

        this.background = new Background(this.PANEL_WIDTH, this.PANEL_HEIGHT, timeOfDay);
        this.tractor = new Tractor(ticksFromStart, 400,250, 400, Color.GREEN, timeOfDay);
    }

    @Override
    public void paint(final Graphics gr) {
        super.paint(gr);
        background.draw(gr);
        tractor.setX(ticksFromStart);
        tractor.draw(gr);
    }

    @Override
    public void actionPerformed(final ActionEvent e) {
        if (e.getSource() == timer) {
            repaint();
            ticksFromStart += 3;
        }
    }
}
