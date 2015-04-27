/* 
 * Creation : 11 avr. 2015
 */

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 * @date 11 avr. 2015
 * @author Anthony CHAFFOT
 */
public class DrawPanel extends JPanel {

    JScrollPane scroll;
    private HeadBar p_hb;
    private Color color = Color.RED;
    private int currentX = 0;
    private int currentY = 0;
    private boolean canDraw = false;
    private boolean erasing = true;
    private int size = 5;
    private double angle = -Math.PI/2;
    private double angle2 = Math.PI / 8;
    private ArrayList<Line> lines = new ArrayList<Line>();

    int temp = 1;

    //**************************************************************************
    // CONSTRUCTOR
    //**************************************************************************
    public DrawPanel(HeadBar hb) {
        this.p_hb = hb;
        scroll = new JScrollPane(this);
        this.setPreferredSize(new Dimension(800, 600));
        currentY = 600;
    }

    //**************************************************************************
    // METHODS
    //**************************************************************************
    public void paintComponent(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        Graphics2D g2d = (Graphics2D) g;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setStroke(new BasicStroke(4, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));

        //On parcourt notre collection de lignes
        for (Line l : this.lines) {
            g2d.setColor(l.getColor());
            g2d.setStroke(new BasicStroke(l.getSize(), BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
            g2d.drawLine(l.getPointA().x, l.getPointA().y, l.getPointB().x, l.getPointB().y);
        }
        g2d.setColor(color);
        g2d.drawOval(currentX - 5, currentY - 5, 10, 10);

    }

    //Efface le contenu
    public void erase() {
        this.erasing = true;
        this.lines = new ArrayList();
        repaint();
    }

    public void move(int length) {
        if (canDraw) {
            drawLine(length);
            repaint();
        } else {
            currentX += (int) (length * Math.cos(angle));
            currentY += (int) (length * Math.sin(angle));
            repaint();
        }
    }

    public void drawLine(int length) {
        Point a = new Point(0, 0);
        Point b = new Point(0, 0);
        a.x = currentX;
        a.y = currentY;
        b.x = (int) (length * Math.cos(angle)) + a.x;
        b.y = (int) (length * Math.sin(angle)) + a.y;

        System.out.print("Point A (" + a.x + "," + a.y + ")");
        System.out.println("/ Point B (" + b.x + "," + b.y + ")");

        lines.add(new Line(a, b, size, color));

        currentX = b.x;
        currentY = b.y;
    }

    public void turnAngle() {
        angle -= angle2;
        angle = angle % (2 * Math.PI);
        p_hb.l_angle.setText((int)(Math.toDegrees(angle)) + " deg");

        System.out.println("Angle : " + angle + " rad");
    }

    public void pickColor() {
        int rand = ((int) (Math.random() * (9 + 1 - 1)) + 1);

        switch (rand) {
            case 1:
                color = Color.BLACK;
                break;
            case 2:
                color = Color.CYAN;
                break;
            case 3:
                color = Color.GRAY;
                break;
            case 4:
                color = Color.GREEN;
                break;
            case 5:
                color = Color.MAGENTA;
                break;
            case 6:
                color = Color.ORANGE;
                break;
            case 7:
                color = Color.RED;
                break;
            case 8:
                color = Color.YELLOW;
                break;
            case 9:
                color = Color.BLUE;
                break;
            default:
                color = Color.BLUE;
                break;
        }
        p_hb.p_color.setBackground(color);
    }

    void takePicture(JPanel panel) {
        System.out.println("SAVE png");
        BufferedImage img = new BufferedImage(panel.getWidth(), panel.getHeight(), BufferedImage.TYPE_INT_RGB);
        panel.print(img.getGraphics());
        try {
            ImageIO.write(img, "png", new File("panel.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //**************************************************************************
    // SETTERS / GETTERS
    //**************************************************************************
    public void setPointerColor(Color c) {
        this.color = c;
        p_hb.p_color.setBackground(c);
    }

    public void setAngle(int angleDeg) {
        this.angle = Math.toRadians(angleDeg);
        this.angle2 = angle;
        p_hb.l_angle.setText(String.valueOf(angle) + " rad");
    }

    public void setCanDraw(boolean b) {
        this.canDraw = b;
    }

    public void setSize(int x) {
        this.size = x;
        p_hb.l_taille.setText(String.valueOf(size) + " px");
    }
    
    public void setColor(int value) {
        //int rand = ((int) (Math.random() * (9 + 1 - 1)) + 1);

        switch (value) {
            case 1:
                color = Color.BLACK;
                break;
            case 2:
                color = Color.CYAN;
                break;
            case 3:
                color = Color.GRAY;
                break;
            case 4:
                color = Color.GREEN;
                break;
            case 5:
                color = Color.MAGENTA;
                break;
            case 6:
                color = Color.ORANGE;
                break;
            case 7:
                color = Color.RED;
                break;
            case 8:
                color = Color.YELLOW;
                break;
            case 9:
                color = Color.BLUE;
                break;
            default:
                color = Color.BLUE;
                break;
        }
        p_hb.p_color.setBackground(color);
    }

}
