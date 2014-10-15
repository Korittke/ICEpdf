package info.korittke.icepdf;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.text.MaskFormatter;

public class DateSpinner extends JPanel {

    private static final long serialVersionUID = 1L;

    private JFormattedTextField date;
    private JCheckBox checkbox;

    public DateSpinner() {
        setLayout(new BorderLayout());

        MaskFormatter formatter;
        try {
            formatter = new MaskFormatter("##.##.####");
            formatter.setPlaceholderCharacter('_');
            date = new JFormattedTextField(formatter);
        } catch (ParseException e1) {
        }

        add(date, BorderLayout.CENTER);
        add(checkbox = new JCheckBox(), BorderLayout.WEST);

        date.setEnabled(false);
        checkbox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                date.setEnabled(checkbox.getModel().isSelected());
            }
        });
    }

    public Long getDate() throws ParseException {
        if (date.isEnabled()) {
            return new SimpleDateFormat("dd.MM.yyyy").parse(date.getText()).getTime();
        } else {
            return null;
        }
    }
}
