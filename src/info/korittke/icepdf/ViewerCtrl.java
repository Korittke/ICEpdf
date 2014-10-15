package info.korittke.icepdf;

import javax.swing.JPanel;
import org.icepdf.ri.common.SwingController;
import org.icepdf.ri.common.SwingViewBuilder;

public class ViewerCtrl {
    JPanel viewerComponentPanel;
    SwingController controller;
    
    public ViewerCtrl() {
        super();
        
        controller = new SwingController();
        SwingViewBuilder factory = new SwingViewBuilder(controller);
        viewerComponentPanel = factory.buildViewerPanel();
    }
    
    JPanel getControl() {
        return viewerComponentPanel;
    }
    
    void openFile(String filePath) {
        controller.openDocument(filePath);
    }
}