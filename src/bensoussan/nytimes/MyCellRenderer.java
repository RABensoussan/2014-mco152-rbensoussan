package bensoussan.nytimes;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ListCellRenderer;
import javax.swing.table.TableCellRenderer;

public class MyCellRenderer extends JTextArea implements ListCellRenderer<String> {

	private static final long serialVersionUID = 1L;

	public MyCellRenderer() {
		setOpaque(true);
		setLineWrap(true);
		setWrapStyleWord(true);
		setSize(500, 20);
		setMargin(new Insets(5, 5, 5, 5));
		setFont(new Font("Arial", Font.BOLD, 14));
	}


	@Override
	public Component getListCellRendererComponent(JList<? extends String> list,
			String value, int index, boolean isSelected, boolean cellHasFocus) {
		setText(value);
		return this;
	}

}
