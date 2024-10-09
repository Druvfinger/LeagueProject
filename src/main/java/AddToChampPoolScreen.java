import Champion.Champion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class AddToChampPoolScreen extends JFrame implements ActionListener {

    Util util = new Util();

    private JPanel basePanel = new JPanel();
    private final JPanel yourChampPoolPanel = new JPanel(new GridLayout(0,8));
    private final JPanel championPanel = new JPanel(new GridLayout(0,8));
    JScrollPane scrollPane;
    public AddToChampPoolScreen() {

        for (Champion champion : Util.champions) {
            ImageIcon icon = new ImageIcon(util.getChampPortrait(champion.image()).getImage());
            JButton button = new JButton(icon);
            button.setMaximumSize(new Dimension(3,3));
            button.addActionListener(e -> {
                if (yourChampPoolPanel.isAncestorOf(button)){
                    yourChampPoolPanel.remove(button);
                    championPanel.add(button);
                } else if (championPanel.isAncestorOf(button)) {
                    championPanel.remove(button);
                    yourChampPoolPanel.add(button);
                } else {
                    throw new RuntimeException("ERROR");
                }

                repaint();
                revalidate();
            }) ;
            championPanel.add(button);
        }
        basePanel.add(yourChampPoolPanel);
        basePanel.add(championPanel);
        scrollPane = new JScrollPane();
        scrollPane.setWheelScrollingEnabled(true);

        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); // Disable horizontal scrolling
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); // Enable vertical scrolling as needed
        scrollPane.add(basePanel);
        add(scrollPane);

        setSize(800,1200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) {
        AddToChampPoolScreen x = new AddToChampPoolScreen();
    }
}
