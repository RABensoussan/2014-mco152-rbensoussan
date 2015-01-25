package bensoussan.iss;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JTextField;

public class ISSOverheadFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	public ISSOverheadFrame() {
		setSize(500, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		final Container container = getContentPane();
		container.setLayout(new BorderLayout());

		Container northernCont = new Container();
		northernCont.setLayout(new BorderLayout());
		container.add(northernCont, BorderLayout.NORTH);

		final JTextField addressBox = new JTextField(35);
		addressBox.setSize(100, 100);
		northernCont.add(addressBox, BorderLayout.WEST);

		final JList<String> timeslist = new JList<String>();
		JButton button = new JButton("Get Times");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ISSOverheadRequestThread t = new ISSOverheadRequestThread(timeslist, addressBox.getText());
				t.start();
			}

		});
		container.add(timeslist, BorderLayout.CENTER);
		northernCont.add(button, BorderLayout.EAST);

	}

	public String[] getTimes(String address) throws IOException {
		GetISS anISSGetter;
		anISSGetter = new GetISS(address);
		ISS iss = anISSGetter.getIss();
		Response[] responses = iss.getResponse();

		String[] timestamps = new String[responses.length];
		SimpleDateFormat formatter = new SimpleDateFormat(
				"yyyy-MM-dd' 'HH:mm:ss' 'zzz");

		for (int i = 0; i < responses.length; i++) {
			long time = responses[i].getRisetime();
			Date date = new Date(time * 1000L);
			timestamps[i] = formatter.format(date);
		}
		return timestamps;
	}

	public static void main(String args[]) {
		ISSOverheadFrame aFrame = new ISSOverheadFrame();
		aFrame.setVisible(true);
	}
}
