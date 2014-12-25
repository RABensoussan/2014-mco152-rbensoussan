package bensoussan.nytimes;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.ListCellRenderer;

public class MyCellRenderer extends JTextArea implements
		ListCellRenderer<String> {

	private static final long serialVersionUID = 1L;

	public MyCellRenderer() {
		setOpaque(true);
		setLineWrap(true);
		setWrapStyleWord(true);
		setPreferredSize(new Dimension(10, 60));
		setFont(new Font("Constantia", Font.PLAIN, 14));
		setBorder(BorderFactory.createEtchedBorder());
		setMargin(new Insets(10, 10, 10, 10));
		//setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
	}

	@Override
	public Component getListCellRendererComponent(JList<? extends String> list,
			String value, int index, boolean isSelected, boolean cellHasFocus) {
		setText(value);
		return this;
	}

}
