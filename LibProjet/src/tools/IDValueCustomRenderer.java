package tools;

import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author Yvan
 */
public class IDValueCustomRenderer extends JLabel implements ListCellRenderer<IDValue> {
        
    public IDValueCustomRenderer(){
        setOpaque(true);
    }

    @Override
    public Component getListCellRendererComponent(JList list, IDValue element, int index, boolean isSelected, boolean cellHasFocus) {
        if (isSelected) {
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        } else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }

        setText(element.value);            
        setFont(list.getFont());

        return this;
    }

}
