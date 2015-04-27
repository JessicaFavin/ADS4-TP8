/* 
 * Creation : 14 avr. 2015
 */

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JPanel;



/**
 * @date    14 avr. 2015
 * @author  Anthony CHAFFOT
 */
public class HeadBar extends JPanel{
    public JLabel angle = new JLabel("Angle : ");
    public JLabel taille = new JLabel(" Taille :" );
    public JLabel l_taille = new JLabel("5 px");
    public JLabel l_angle = new JLabel("0.0");
    public JPanel p_color = new JPanel();
    public JLabel status = new JLabel("Status :");
    public JLabel l_status = new JLabel("Write");
    
    //**************************************************************************
    // CONSTRUCTOR
    //**************************************************************************
    public HeadBar(){
        p_color.setPreferredSize(new Dimension(40,30));
        p_color.setBackground(Color.red);
        this.add(p_color);
        this.add(taille);
        this.add(l_taille);
        this.add(angle);
        this.add(l_angle);
        this.add(status);
        this.add(l_status);
        
    }

    //**************************************************************************
    // METHODS
    //**************************************************************************

    //**************************************************************************
    // SETTERS / GETTERS
    //**************************************************************************

}
