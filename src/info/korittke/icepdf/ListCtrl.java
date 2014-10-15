package info.korittke.icepdf;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListSelectionModel;

public class ListCtrl extends JList {

    private JList list;
    private ViewerCtrl viewer;
    private DefaultListModel model;
    private File[] files;
    private final String path = "//Epson0ee12c/usbstorage/EPSCAN/001/";
    //private final String path = "C:\\Users\\Christian\\Documents\\MMG\\";

    public ListCtrl(ViewerCtrl viewer) {
        super();
        this.list = this;
        this.viewer = viewer;
        setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        model = new DefaultListModel();
        addFiles();

        setModel(model);

        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int index = list.locationToIndex(e.getPoint());
                    Object item = model.getElementAt(index);
                    viewer.openFile(path + item.toString());
                }
            }
        });
    }

    private void addFiles() {
        files = new File(path).listFiles((File dir, String filename) -> filename.toLowerCase().endsWith(".pdf"));
        if (files != null) {
            for (File file : files) {
                model.addElement(file.getName());
            }
        }
    }
}
