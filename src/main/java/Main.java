import javax.swing.*;

public class Main {
    public static void main (String[] args) {
        int width = 800;
        int height = 600;

        MainWindow window = new MainWindow(width, height);
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.setSize(width, height);
        window.setVisible(true);
    }
}
