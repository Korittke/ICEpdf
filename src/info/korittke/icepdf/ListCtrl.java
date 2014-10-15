package info.korittke.icepdf;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListSelectionModel;

public class ListCtrl extends JList {

    private DefaultListModel<File> model;
    private File[] files;
    private final String path = "//Epson0ee12c/usbstorage/EPSCAN/001/";
    //private final String path = "C:\\Users\\Christian\\Documents\\MMG\\";

    public ListCtrl(ViewerCtrl pdf) {
        super();
        final JList list = this;
        final ViewerCtrl viewer = pdf;
        
        setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        model = new DefaultListModel<>();
        addFiles();
        setModel(model);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int index = list.locationToIndex(e.getPoint());
                    File item = model.getElementAt(index);
                    viewer.openFile(item.getAbsolutePath());
                }
            }
        });
    }

    private void addFiles() {
        files = new File(path).listFiles((File dir, String filename) -> filename.toLowerCase().endsWith(".pdf"));
        if (files != null) {
            for (File file : files) {
                model.addElement(file);
            }
        }
    }
}
