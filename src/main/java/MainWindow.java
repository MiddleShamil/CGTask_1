import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MainWindow extends JFrame {

    public MainWindow(final int width, final int height) throws HeadlessException{
        boolean timeOfDay = true;
        List<DrawInt> list = new ArrayList<>();
        list.add(new Background(width,height,timeOfDay));
        list.add(new Tractor(160,420,width,height, Color.GREEN, timeOfDay));
        DrawingPanel panel = new DrawingPanel(width, height, timeOfDay, list);
        this.add(panel);
    }
}
