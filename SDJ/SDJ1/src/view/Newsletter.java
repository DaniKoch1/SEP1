package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import controler.VIAController;

public class Newsletter extends VIAPanel {

	private static JTable table;
	private JScrollPane scrollPane;
	private JLabel listOfNewsletter;
	private JButton generateText;
	private JLabel newsletter;
	private JTextArea info;
	private JLabel addInfo;
	private JFrame frame;
	private JPanel parentPanel;
	private JButton back;

	public Newsletter(JFrame frame, JPanel parentPanel) {
		super();
		this.frame = frame;
		this.parentPanel = parentPanel;
		setLayout(new BorderLayout());
		initializeComponents();
		registerEventHandlers();
		addComponentsToPanel();
	}

	private void initializeComponents() {
		DefaultTableModel model = VIAController.getNewsletterTableModel();

		table = new JTable(model);
		table.removeColumn(table.getColumnModel().getColumn(1));
		table.setPreferredScrollableViewportSize(new Dimension(450, 50));

		scrollPane = new JScrollPane(table);

		listOfNewsletter = new VIALabel("LIST OF NEWSLETTER", 20);
		generateText = new VIAButtonSimple("Generate text", 30);
		newsletter = new VIALabel("NEWSLETTER", 50);
		info = new JTextArea(10, 30);
		addInfo = new VIALabel("ADDITIONAL INFO", 20);
		back = new VIAButtonBack(frame, parentPanel);
	}

	private void registerEventHandlers() {
		JPanel currentPanel = this;

		table.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent mouseEvent) {
				JTable table = (JTable) mouseEvent.getSource();
				Point point = mouseEvent.getPoint();
				int row = table.rowAtPoint(point);
				if (mouseEvent.getClickCount() == 2) {
					TableModel model = table.getModel();
					int selRow = table.getSelectedRow();
					File newsletter = (File) model.getValueAt(selRow, 1);

					JFrame newsletterFrame = new JFrame();
					newsletterFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					newsletterFrame.setSize(900, 500);
					newsletterFrame.setLocationRelativeTo(null);
					newsletterFrame.setResizable(false);
					newsletterFrame.setTitle("VIA - Add new member");
					newsletterFrame.setContentPane(new NewsletterContent(newsletter));
					newsletterFrame.setVisible(true);
				}
			}
		});

		generateText.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					VIAController.generateNewsletter(info.getText());
				} catch (IOException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(frame, "File not found", "File error", JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
	}

	private void addComponentsToPanel() {
		JScrollPane scrollPane = new JScrollPane(table);
		add(scrollPane);

		JPanel left = new JPanel(new BorderLayout());
		left.add(listOfNewsletter, BorderLayout.NORTH);
		left.add(scrollPane, BorderLayout.CENTER);
		left.setOpaque(false);

		JPanel right = new JPanel(new BorderLayout());
		right.add(addInfo, BorderLayout.NORTH);
		right.add(info, BorderLayout.CENTER);
		right.setOpaque(false);

		JPanel buttonBack = new JPanel(new FlowLayout(FlowLayout.LEFT));
		buttonBack.add(back);
		buttonBack.setOpaque(false);

		ImageIcon img = new ImageIcon("src/resources/Logo.png");
		JLabel imgLab = new JLabel(img);

		JPanel logo = new JPanel(new BorderLayout());
		logo.setOpaque(false);
		logo.add(imgLab, BorderLayout.CENTER);
		logo.add(buttonBack, BorderLayout.WEST);

		JPanel title = new JPanel();
		title.add(newsletter);
		title.setOpaque(false);

		JPanel north = new JPanel(new BorderLayout());
		north.add(logo, BorderLayout.NORTH);
		north.add(title, BorderLayout.CENTER);
		north.setOpaque(false);

		JPanel textArea = new JPanel(new BorderLayout());
		textArea.add(right, BorderLayout.CENTER);
		textArea.add(generateText, BorderLayout.SOUTH);
		textArea.setOpaque(false);

		add(north, BorderLayout.NORTH);
		add(left, BorderLayout.WEST);
		add(textArea, BorderLayout.EAST);
	}

	public static void refreshTable() {
		if (table != null) {
			DefaultTableModel model = VIAController.getNewsletterTableModel();
			table.setModel(model);
			table.removeColumn(table.getColumnModel().getColumn(1));
		}
	}

}
