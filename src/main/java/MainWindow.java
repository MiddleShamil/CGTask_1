import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private final DrawingPanel panel;

    public MainWindow(int width, int height) throws HeadlessException{
        panel = new DrawingPanel(width, height, 50, false);
        this.add(panel);
    }
}
