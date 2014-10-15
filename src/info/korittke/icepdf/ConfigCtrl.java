package info.korittke.icepdf;

import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class ConfigCtrl extends JPanel {

    private DateSpinner eingang, ausgang, erstellt;
    private JTextField betreff;
    private JComboBox firma, kunde, tag, person;

    public ConfigCtrl() {
        setLayout(new BorderLayout());
        add(new JPanel())
        
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(new JLabel("Posteingang"));
        add(eingang = new DateSpinner());
        add(new JLabel("Postausgang"));
        add(ausgang = new DateSpinner());
        add(new JLabel("Erstelldatum"));
        add(erstellt = new DateSpinner());
        add(new JLabel("Firma"));
        add(firma = new JComboBox());
        add(new JLabel("Kundennummer"));
        add(kunde = new JComboBox());
        add(new JLabel("Tag"));
        add(tag = new JComboBox());
        add(new JLabel("Betreff"));
        add(betreff = new JTextField(""));
        add(new JLabel("Person"));
        add(person = new JComboBox());
    }
}
