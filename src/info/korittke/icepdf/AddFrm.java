package info.korittke.icepdf;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

public class AddFrm extends JFrame {
    
    public AddFrm() {
        super("Dokumentenverwaltung");
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        
        ViewerCtrl viewer = new ViewerCtrl();
        ListCtrl list = new ListCtrl(viewer);
        ConfigCtrl config = new ConfigCtrl();
        
        this.add(new JScrollPane(list), BorderLayout.WEST);
        this.add(viewer.getControl(), BorderLayout.CENTER);
        this.add(new JScrollPane(config), BorderLayout.EAST);
        
        this.setExtendedState(this.getExtendedState() | AddFrm.MAXIMIZED_BOTH);

        // show the component
        this.pack();
        this.setVisible(true);
    }
}
