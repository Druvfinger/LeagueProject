import com.fasterxml.jackson.core.JsonParser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Test extends JFrame implements ActionListener {

    JPanel basePanel = new JPanel(new BorderLayout());
    ImageIcon icon;
    Util util = new Util();
    JLabel label = new JLabel("Select Champion");


    public Test(){
        icon = util.getChampPortrait("Aatrox");
        add(basePanel);
        basePanel.add(new JLabel(icon));

        setSize(410, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public ImageIcon getChampPortrait(){

        return new ImageIcon();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) {
        Test test = new Test();
    }
}
