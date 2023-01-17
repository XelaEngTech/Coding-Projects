import javax.swing.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.awt.*;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

public class Lab6P2 {
	public static void main(String[] args) {
		Galaxy g = new Galaxy();
        JFrame frame = new JFrame();
		frame.setTitle("Galaxy");
        frame.setSize(450, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(g);
    }
}
class Galaxy extends JPanel implements ActionListener {
	private spaceRocks objects[];
	private javax.swing.Timer timer;

    public Galaxy() {
		setBackground(Color.BLACK);
        objects = new spaceRocks[4];

        objects[0] = new spaceRocks(25, 50, Color.YELLOW);
        objects[1] = new spaceRocks(80, 18, Color.RED);
        objects[2] = new spaceRocks(180, 22, Color.BLUE);
        objects[3] = new spaceRocks(65, 10, Color.WHITE);

        timer = new javax.swing.Timer(25, this);
        timer.start();
    }
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        for (int i = 0; i <= 3; i++) {
			objects[i].print(g2d);
        }
    }
	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i <= 3; i++) {
			objects[3].setOrigin(objects[2]);
            objects[i].Orbit();
        }
        repaint();
    }	
}
class spaceRocks {
	private Ellipse2D object = new Ellipse2D.Double();
    private static Random random = new Random();

    private double orbit;
    private double planetSize;
	private Color color;
	private double o = 0;
	private double x = 250;
    private double y = 250;
    private double originX = 250;
    private double originY = 250;
    private double speed = random.nextDouble() * 0.03 + 0.004;
   
	spaceRocks(double orbit, double planetSize, Color color) {
		x = x + orbit;
        this.orbit = orbit;
        this.planetSize = planetSize;
        this.color = color;
		this.object.setFrame(x, y, planetSize, planetSize);
    }
	public double[] getOrigin() {
		double[] r = {this.x, this.y};
        return r;
    }
	public void setOrigin(spaceRocks o) {
		double[] r = o.getOrigin();
        this.originX = r[0];
        this.originY = r[1];
    }
	 public void print(Graphics2D g) {
        Color c = g.getColor();
        g.setColor(color);
        g.fill(object);
        g.setColor(c);
    }
	 public void Orbit() {
		o = o + speed;
        int size = 25;
        if (o == 2.02)
            o = 0;
		if (planetSize == 50)
            size = 0;
		if (planetSize == 10)
            size = 11;

        x = originX + size + orbit * Math.cos(o);
        y = originY + size + orbit * Math.sin(o);

        this.object.setFrame(x, y, planetSize, planetSize);
	 }
}