import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Test extends JFrame implements ActionListener {

    JPanel basePanel = new JPanel(new BorderLayout());
    Util util = new Util();
    JTextField searchField = new JTextField();
    JComboBox<Object> dropdownList = new JComboBox<>();
    List<String> championNames = util.getChampionNameList();
    public Test(){
        add(basePanel);

        championNames.forEach(championName -> dropdownList.addItem(championName));
        searchField.setToolTipText("Search for Champion");
        AutoCompletion.enable(dropdownList);

        basePanel.add(dropdownList, BorderLayout.SOUTH);
        setSize(410, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void filterComboBox(){
        String searchTerm = searchField.getText();
        dropdownList.removeAllItems();

        for (String champName : championNames){
            if (champName.toLowerCase().contains(searchTerm.toLowerCase())){
                dropdownList.addItem(champName);
            }
        }
        if (dropdownList.getItemCount() == 0){
            dropdownList.addItem("No Champions Found");
        }
        dropdownList.setSelectedItem(searchTerm);
        dropdownList.showPopup();
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) {
        Test test = new Test();
    }
}
