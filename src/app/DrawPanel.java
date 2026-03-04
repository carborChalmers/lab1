package app;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.List;

// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    // Just a single image, TODO: Generalize
    private BufferedImage volvoImage;
    private BufferedImage saabImage;
    private BufferedImage scaniaImage;
    public boolean showVolvo = true;
    // To keep track of a single car's position
    private List<Vehicle> vehicles;
    private Workshop<Volvo240> workshop;
    private BufferedImage workshopImage;


    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        // Print an error message in case file is not found with a try/catch block
        try {
            // You can remove the "pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            // volvoImage = ImageIO.read(new File("Volvo240.jpg"));

            // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.
            volvoImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"));
            saabImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg"));
            scaniaImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg"));
            workshopImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/VolvoBrand.jpg"));
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }

    }
    public void update(List<Vehicle> vehicles, Workshop<Volvo240> workshop){
        this.vehicles = vehicles;
        this.workshop = workshop;
        repaint();
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(vehicles == null) return;
        if(workshop != null){
            g.drawImage(workshopImage, 300, 300, null);
        }
        for (Vehicle v: vehicles){
            if(v instanceof Volvo240){
                g.drawImage(volvoImage,(int)v.getX(),(int)v.getY(),null);
            }
            if(v instanceof Saab95){
                g.drawImage(saabImage,(int)v.getX(),(int)v.getY(),null);
            }
            if(v instanceof Scania){
                g.drawImage(scaniaImage,(int)v.getX(),(int)v.getY(),null);
            }
        }
    }
}