package ergasia3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

 import javax.swing.JButton;
import javax.swing.JFrame;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class SearchPage extends JFrame {
     private Registry registry;

    public SearchPage(Registry registry) {
        
    	this.registry = registry;
         setTitle("Find Suspect");
         setSize(300, 150);
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setLayout(null);

      JLabel searchLabel = new JLabel("Please enter suspect's name:");
        searchLabel.setBounds(10, 10, 200, 25);
         add(searchLabel);

           JTextField searchField = new JTextField();
           searchField.setBounds(10, 40, 200, 25);
          
           add(searchField);

           
           ////////
        JButton findButton = new JButton("Find");
        findButton.setBounds(220, 40, 60, 25);
        add(findButton);

        findButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = searchField.getText();
                Suspect suspect = registry.findSuspectByName(name);

                if (suspect != null) {
                    SuspectPage suspectPage = new SuspectPage(suspect, registry);
                    suspectPage.setVisible(true);
                } else {
                	
                    JOptionPane.showMessageDialog(SearchPage.this,
                            "Suspect " + name +  " Not Found",
                            "MESSAGE" ,
                              JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }
}
