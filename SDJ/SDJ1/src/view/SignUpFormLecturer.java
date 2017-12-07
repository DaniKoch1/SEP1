package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SignUpFormLecturer extends VIAPanel{

	private JLabel signUp;
	private JLabel name;
	private JLabel email;
	private JLabel id;
	private JLabel phone;
	private JLabel category;
	private JCheckBox advertisment;
	private JTextField fieldName;
	private JTextField fieldEmail;
	private JTextField fieldID;
	private JTextField fieldPhone;
	private JTextField fieldCategory;
	private JButton add;
	private JFrame frame;
	private JPanel parentPanel;
	private JButton back;

	public SignUpFormLecturer(JFrame frame) {
		super();
		this.frame = frame;
		this.parentPanel = parentPanel;
		setLayout(new BorderLayout());
		initializeComponents();
		registerEventHandlers();
		addComponentsToPanel();

	}

	public void initializeComponents() {
		signUp = new JLabel("Sign-Up Form for LECTURER");
		signUp.setFont(new Font("Arial", Font.PLAIN, 30));
		name = new JLabel("Name:");
		email = new JLabel("E-mail:");
		id = new JLabel("ID:");
		phone = new JLabel("Phone:");
		category = new JLabel("Category:");
		advertisment = new JCheckBox("Advertisment");
		advertisment.setOpaque(false);
		fieldName = new JTextField(8);
		fieldEmail = new JTextField(8);
		fieldID = new JTextField(8);
		fieldPhone = new JTextField(8);
		fieldCategory = new JTextField(8);
		
		add = new VIAButtonSmall("Add to list");
		back = new VIAButtonBack(frame, parentPanel);



	}

	public void registerEventHandlers() {

	}

	public void addComponentsToPanel() {
		JPanel leftLabel = new JPanel(new GridLayout(4, 1));
		leftLabel.add(name);
		leftLabel.add(email);
		leftLabel.add(category);
		leftLabel.setOpaque(false);

		JPanel leftField = new JPanel(new GridLayout(4, 1));

		JPanel fieldOne = new JPanel();
		fieldOne.add(fieldName);
		fieldOne.setOpaque(false);

		JPanel fieldTwo = new JPanel();
		fieldTwo.add(fieldEmail);
		fieldTwo.setOpaque(false);

		JPanel fieldThree = new JPanel();
		fieldThree.add(fieldCategory);
		fieldThree.setOpaque(false);

		JPanel fieldFour = new JPanel();
		fieldFour.add(fieldID);
		fieldFour.setOpaque(false);

		leftField.add(fieldOne);
		leftField.add(fieldTwo);
		leftField.add(fieldThree);
		leftField.setOpaque(false);

		JPanel left = new JPanel(new GridLayout(1, 2));
		left.add(leftLabel);
		left.add(leftField);
		left.setOpaque(false);

		JPanel leftSide = new JPanel();
		leftSide.add(left);
		leftSide.setOpaque(false);

		JPanel rightLabel = new JPanel(new GridLayout(3, 1));
		rightLabel.add(id);
		rightLabel.add(phone);
		rightLabel.add(advertisment);
		rightLabel.setOpaque(false);

		JPanel rightField = new JPanel(new GridLayout(3, 1));

		JPanel fieldFive = new JPanel();
		fieldFive.add(fieldPhone);
		fieldFive.setOpaque(false);
		
		rightField.add(fieldFour);
		rightField.add(fieldFive);
		rightField.setOpaque(false);

		JPanel right = new JPanel(new GridLayout(1, 2));
		right.add(rightLabel);
		right.add(rightField);
		right.setOpaque(false);

		JPanel rightSide = new JPanel();
		rightSide.add(right);
		rightSide.setOpaque(false);

		JPanel content = new JPanel(new GridLayout(1, 2));
		content.add(leftSide);
		content.add(rightSide);
		content.setOpaque(false);

		JPanel button = new JPanel();
		button.add(add);
		button.setOpaque(false);

		JPanel titul = new JPanel();
		titul.add(signUp);
		titul.setOpaque(false);

		JPanel components = new JPanel(new BorderLayout());
		components.add(titul, BorderLayout.NORTH);
		components.add(content, BorderLayout.CENTER);
		components.add(button, BorderLayout.SOUTH);
		components.setOpaque(false);

		JPanel buttonBack = new JPanel(new FlowLayout(FlowLayout.LEFT));
		buttonBack.add(back);
		buttonBack.setOpaque(false);

		ImageIcon img = new ImageIcon("src/resources/Logo.png");
		JLabel imgLab = new JLabel(img);

		JPanel logo = new JPanel(new BorderLayout());
		logo.setOpaque(false);
		logo.add(imgLab, BorderLayout.CENTER);
		logo.add(buttonBack, BorderLayout.WEST);;

		add(logo, BorderLayout.NORTH);
		add(components, BorderLayout.CENTER);
	}

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				JFrame frame = new JFrame();
				frame.setSize(900, 500);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setContentPane(new SignUpFormLecturer(frame));
				frame.setVisible(true);
			}
		});

	}

}
