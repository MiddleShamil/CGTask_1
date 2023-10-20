import javax.swing.*;
import java.awt.*;
import java.util.List;

public class DrawingPanel extends JPanel  {

    private final int PANEL_WIDTH;
    private final int PANEL_HEIGHT;

    private final boolean TimeOfDay;

    private final List<DrawInt> list;
    public DrawingPanel(final int width, final int height, final boolean timeOfDay, List<DrawInt> list) {
        this.PANEL_WIDTH = width;
        this.PANEL_HEIGHT = height;
        this.TimeOfDay = timeOfDay;
        this.list = list;

    }

    @Override
    public void paint(final Graphics gr) {
        super.paint(gr);
        for (DrawInt art : list) {
            art.draw(gr);
        }
    }

    public void addArt(final DrawInt art) { this.list.add(art); }
}
