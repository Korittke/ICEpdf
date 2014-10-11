package info.korittke.icepdf; 

import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        ViewerCtrl viewer = new ViewerCtrl();
        
        JFrame applicationFrame = new JFrame("Hallo Welt!");
        applicationFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        applicationFrame.getContentPane().add(viewer.getControl());
       
        // show the component
        applicationFrame.pack();
        applicationFrame.setVisible(true);
    }
}
