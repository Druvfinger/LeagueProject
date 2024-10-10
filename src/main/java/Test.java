import Champion.Champion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Objects;

public class Test extends JFrame implements ActionListener {

    JPanel basePanel = new JPanel(new GridLayout(1,0));
    Util util = new Util();
    JComboBox<Object> dropdownList = new JComboBox<>();
    List<String> championNames = util.getChampionNameList();
    JPanel dropDownPanel = new JPanel();
    JPanel userChampPoolPanel = new JPanel();
    JLabel userChampPoolHeader = new JLabel("Your Champ Pool");
    JButton addToChampPoolButton = new JButton("Add Chosen Champ to Pool");

    public Test() throws FileNotFoundException {

        basePanel.setLayout(new BoxLayout(basePanel, BoxLayout.Y_AXIS));

        userChampPoolPanel.setLayout(new BoxLayout(userChampPoolPanel, BoxLayout.Y_AXIS));
        basePanel.add(userChampPoolPanel, BorderLayout.NORTH);
        displayChampPool(util.getChampPool());
        championNames.forEach(championName -> dropdownList.addItem(championName));
        AutoCompletion.enable(dropdownList);

        dropdownList.setPreferredSize(new Dimension(400, 50));
        dropDownPanel.setLayout(new BoxLayout(dropDownPanel, BoxLayout.Y_AXIS));
        dropDownPanel.add(dropdownList);
        dropDownPanel.add(addToChampPoolButton);
        addToChampPoolButton.addActionListener(this);
        basePanel.add(dropDownPanel, BorderLayout.SOUTH);
        add(basePanel);


        setSize(410, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public void displayChampPool(List<String> champPool){
        userChampPoolPanel.removeAll();
        userChampPoolPanel.add(userChampPoolHeader);
        for (String champ : champPool){
            JPanel panel = new JPanel();
            JButton removeButton = new JButton("remove");
            removeButton.addActionListener(e -> {util.removeFromChampPool(champ); displayChampPool(util.getChampPool());});
            panel.add(new JLabel(champ));
            panel.add(removeButton);
            userChampPoolPanel.add(panel);
        }
        repaint();
        revalidate();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       String champName = (String) Objects.requireNonNull(dropdownList.getSelectedItem());
       Champion champion = util.getChampion(champName);
       util.addToChampPool(champion.name());
       displayChampPool(util.getChampPool());
       revalidate();
       repaint();
    }

    public static void main(String[] args) throws FileNotFoundException {
        new Test();
    }

}
