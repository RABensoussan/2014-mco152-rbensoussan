package bensoussan.nytimes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.io.IOException;
import java.net.URI;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class NewsFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	public NewsFrame() throws IOException {
		setSize(1500, 700);
		setTitle("New York Times");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		News a = new News();
		NYTimes news = a.getNews(); // try/catch, not throws?
		final Docs[] docs = news.getResponse().getDocs();
		String[][] headlineandparag = new String[docs.length][2];
		Headline[] headlines = new Headline[docs.length];
		String[] mainHeadlines = new String[headlines.length];
		String[] leadParagraphs = new String[docs.length];
		for (int i = 0; i < docs.length; i++) {
			headlines[i] = docs[i].getHeadline();
			mainHeadlines[i] = headlines[i].getMain();
			leadParagraphs[i] = docs[i].getLead_paragraph();
			headlineandparag[i][0] = docs[i].getHeadline().getMain();
			headlineandparag[i][1] = docs[i].getLead_paragraph();
		}

		String[] colNames = {"Headline", "Lead Paragraph"};
		
	//	JTable newstable = new JTable(headlineandparag, colNames);
	//	newstable.setDefaultRenderer(String.class, new MyCellRenderer());
		
		JList<String> headlinelist = new JList<String>(mainHeadlines);
		headlinelist.setLayoutOrientation(JList.VERTICAL);
		headlinelist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		headlinelist.setCellRenderer(new MyCellRenderer());
		headlinelist.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		headlinelist.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				int index = e.getFirstIndex();
				try {
					Desktop.getDesktop().browse(
							URI.create(docs[index].getWeb_url()));
				} catch (IOException e1) {
				}
			}
		});

		JList<String> leadparaglist = new JList<String>(leadParagraphs);
		leadparaglist.setCellRenderer(new MyCellRenderer());
		leadparaglist
				.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		JLabel title = new JLabel("New York Times Headlines");
		title.setFont(new Font("Constantia", Font.BOLD, 40));
		title.setPreferredSize(new Dimension(100, 100));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setVerticalAlignment(SwingConstants.CENTER);

		Container container = getContentPane();
		container.setLayout(new BorderLayout());
		container.setBackground(Color.CYAN);

		container.add(title, BorderLayout.NORTH);
		//container.add(newstable, BorderLayout.CENTER);
		container.add(headlinelist, BorderLayout.WEST);
		container.add(leadparaglist, BorderLayout.CENTER);

	}

	public static void main(String args[]) throws IOException {
		NewsFrame frame = new NewsFrame();
		frame.setVisible(true);
	}

}