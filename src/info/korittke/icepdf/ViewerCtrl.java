package info.korittke.icepdf;

import java.util.ResourceBundle;
import javax.swing.JPanel;
import org.icepdf.ri.common.SwingController;
import org.icepdf.ri.common.SwingViewBuilder;
import org.icepdf.ri.util.PropertiesManager;

public class ViewerCtrl {
    JPanel viewerComponentPanel;
    SwingController controller;
    
    public ViewerCtrl() {
        super();
        
        // build a component controller
        controller = new SwingController();
        controller.setIsEmbeddedComponent(true);

        PropertiesManager properties = new PropertiesManager(
                System.getProperties(),
                ResourceBundle.getBundle(PropertiesManager.DEFAULT_MESSAGE_BUNDLE));

        properties.set(PropertiesManager.PROPERTY_DEFAULT_ZOOM_LEVEL, "1.75");

        SwingViewBuilder factory = new SwingViewBuilder(controller, properties);

        // add interactive mouse link annotation support via callback
        controller.getDocumentViewController().setAnnotationCallback(
                new org.icepdf.ri.common.MyAnnotationCallback(controller.getDocumentViewController()));
        viewerComponentPanel = factory.buildViewerPanel();
    }
    
    JPanel getControl() {
        return viewerComponentPanel;
    }
    
    void openFile(String filePath) {
        controller.openDocument(filePath);
    }
}