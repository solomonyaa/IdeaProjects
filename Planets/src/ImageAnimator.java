import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ImageAnimator extends JPanel implements ActionListener {

    private Image image;
    private List<Point> points;
    private int currentIndex;
    private Timer timer;


    public ImageAnimator(String imagePath, List<Point> points, int width, int height) {
        // Load and scale the image
        try {
            BufferedImage originalImage = ImageIO.read(new File(imagePath));
            image = originalImage.getScaledInstance(width, height, Image.SCALE_DEFAULT);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Initialize animation points
        this.points = points;
        this.currentIndex = 0;

        // Set up a timer to animate the image
        timer = new Timer(100, this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw the image at the current position
        if (image != null && !points.isEmpty()) {
            Point currentPoint = points.get(currentIndex);
            g.drawImage(image, currentPoint.x, currentPoint.y, this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Move to the next point
        currentIndex = (currentIndex + 1) % points.size();
        repaint();
    }


    public static void createAndShowGUI(ArrayList<Planet> planets, List<Point> points) {

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        for (Planet planet : planets) {
            frame.add(new ImageAnimator(planet.getImagePath(), points, (int) planet.getRadiusInKm() / 100, (int) planet.getRadiusInKm() / 100));
        }

        frame.setSize(1920, 1080);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
