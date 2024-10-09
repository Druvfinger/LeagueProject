import Champion.Champion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Objects;

public class Test extends JFrame implements ActionListener {

    JPanel basePanel = new JPanel(new BorderLayout());
    Util util = new Util();
    JTextField searchField = new JTextField();
    JComboBox<Object> dropdownList = new JComboBox<>();
    List<String> championNames = util.getChampionNameList();
    JLabel westImgLabel = new JLabel();
    ImageIcon westImgIcon;
    JPanel panelNorth = new JPanel(new BorderLayout());
    JPanel panelSouth = new JPanel(new BorderLayout());
    JPanel panelEast = new JPanel(new BorderLayout());
    JPanel panelWest = new JPanel(new BorderLayout());
    JPanel panelCenter = new JPanel(new BorderLayout());
    JLabel champNameLabelWest;

    public Test(){
        add(basePanel);
        basePanel.add(panelNorth, BorderLayout.NORTH);
        basePanel.add(panelSouth, BorderLayout.SOUTH);
        basePanel.add(panelEast, BorderLayout.EAST);
        basePanel.add(panelWest, BorderLayout.WEST);
        basePanel.add(panelCenter, BorderLayout.CENTER);
        championNames.forEach(championName -> dropdownList.addItem(championName));
        searchField.setToolTipText("Search for Champion");
        AutoCompletion.enable(dropdownList);

        //PANEL NORTH
        panelNorth.add(new JButton("Add Champ to champ pool"));

        //PANEL SOUTH
        panelSouth.add(dropdownList);
        dropdownList.addActionListener(this);
        //PANEL WEST


        //PANEL EAST


        //Panel Center


        setSize(410, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
       String champName = (String) Objects.requireNonNull(dropdownList.getSelectedItem());
       Champion champion = util.getChampion(champName);
       System.out.println(champName);
       panelCenter.removeAll();
       JPanel panel = new JPanel();
       panel.add(new JLabel(new ImageIcon(util.getChampPortrait(champion.image()).getImage())));
       panel.add(new JLabel(champion.name()));
       panelCenter.add(panel);
       revalidate();
       repaint();
    }

    public static void main(String[] args) {
        Test test = new Test();
    }

}
