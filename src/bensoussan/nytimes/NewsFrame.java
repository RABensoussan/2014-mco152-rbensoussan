package bensoussan.nytimes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.io.IOException;
import java.net.URI;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class NewsFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	public NewsFrame() {
		setSize(700, 700);
		setTitle("New York Times");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		Container container = getContentPane();
		container.setLayout(new BorderLayout());
		container.setBackground(Color.LIGHT_GRAY);

		News aNews = new News();
		NYTimes news;
		news = aNews.getNews();
		final Docs[] docs = news.getResponse().getDocs();
		String[] headandparag = new String[docs.length];

		for (int i = 0; i < docs.length; i++) {
			String a = docs[i].getHeadline().getMain();
			String b = docs[i].getLead_paragraph();
			if (b != null) {
				headandparag[i] = "Headline: " + a + "   Lead Paragraph: " + b;
			} else {
				headandparag[i] = "Headline: " + a;
			}
		}

		JList<String> newsList = new JList<String>(headandparag);
		newsList.setCellRenderer(new MyCellRenderer());
		newsList.addListSelectionListener(new ListSelectionListener() {
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

		container.add(newsList, BorderLayout.CENTER);

		// set title preferences
		JLabel title = new JLabel("New York Times Headlines");
		title.setFont(new Font("Constantia", Font.BOLD, 40));
		title.setPreferredSize(new Dimension(100, 75));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setVerticalAlignment(SwingConstants.CENTER);
		container.add(title, BorderLayout.NORTH);

	}

	public static void main(String args[]) throws IOException {
		NewsFrame frame = new NewsFrame();
		frame.setVisible(true);
	}

}
