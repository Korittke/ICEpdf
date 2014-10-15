package info.korittke.icepdf;

import java.awt.BorderLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

public class AddFrm extends JFrame {
    
    public AddFrm() {
        super("Hallo Welt!");
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        JComboBox choice = new JComboBox();
        choice.addItem("Mike: Mein Gott Walter");
        choice.addItem("Sweet: Co Co");
        
        ViewerCtrl viewer = new ViewerCtrl();
        ListCtrl list = new ListCtrl(viewer);
        
        this.add(new JScrollPane(list), BorderLayout.WEST);
        this.add(viewer.getControl(), BorderLayout.CENTER);
        
        this.setExtendedState(this.getExtendedState() | AddFrm.MAXIMIZED_BOTH);

        // show the component
        this.pack();
        this.setVisible(true);
    }
}
