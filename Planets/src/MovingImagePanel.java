import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.imageio.ImageIO;

public class MovingImagePanel extends JPanel implements ActionListener {
    private BufferedImage image;
    private List<Point> points;
    private int width;
    private int height;
    private Timer timer;

    public MovingImagePanel(String imagePath, List<Point> points, int width, int height) {
        this.points = points;
        this.width = width;
        this.height = height;

        try {
            image = ImageIO.read(new File(imagePath));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Initialize a timer to update the positions of the images
        timer = new Timer(30, this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw the image at each point
        for (Point point : points) {
            g.drawImage(image, point.x, point.y, width, height, this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Update the positions of the images
        for (Point point : points) {
            point.x += 1; // Example: Move each image 1 pixel to the right
            point.y += 1; // Example: Move each image 1 pixel down
        }
        repaint();
    }

    public static void main(String[] args) {
        // Example usage
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Moving Images");
            List<Point> points = List.of(new Point(50, 50), new Point(100, 100), new Point(150, 150));
            MovingImagePanel panel = new MovingImagePanel("src/images/earth01.jpg", points, 50, 50);
            frame.add(panel);
            frame.setSize(400, 400);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
