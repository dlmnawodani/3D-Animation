import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Dashboard extends JFrame implements ActionListener {

	public Dashboard() {
		// TODO Auto-generated constructor stub

	}

	private String topPanel1Color = "#946610";
	private String topPanel2Color = "#000435";
	private String topPanel2TextColor = "#FFFFFF";
	private String topPanel3Color = "#FFBF00";
	private String topPanel3TextColor = "#000000";
	private JButton homeButton;
	private JButton pantryButton;
	private JButton livingButton;
	private JButton diningButton;
	private JButton bedRoomsButton;
	private JComboBox comboBox;
	private JButton addButton;

	private JPanel topPanel;
	private JPanel topPanel1;
	private JPanel topPanel2;
	private JPanel topPanel3;
	private JPanel topPanel4;
	private JPanel bottomPanel;
	private FurnitureShowPage showPage;

	public JPanel getBottomPanel() {
		return bottomPanel;
	}

	public void setBottomPanel(JPanel bottomPanel) {
		this.bottomPanel = bottomPanel;
	}

	String[] pantryOptions = { "All", "Pantry Cupboard", "Chair", "Table" };
	String[] livingOptions = { "All", "Chair", "Table" };
	String[] diningOptions = { "All", "Chair", "Table" };
	String[] bedRoomsOptions = { "All", "Chair", "Table", "Cubboard", "Bed" };

	private String buttonValue;
	private String dropDownValue;

	public JPanel designTopPanel() {
		this.setButtonValue("Home");
		this.setDropDownValue("All");

		this.showPage = new FurnitureShowPage(getButtonValue(), getDropDownValue());
		this.setBottomPanel(showPage.designTopPanel());

		topPanel = createPanel(topPanel3Color, 4, 1, 0, 0);
		topPanel1 = createPanel(topPanel1Color, 1, 3, 0, 0);
		topPanel2 = createPanel(topPanel2Color, 1, 2, 0, 0);
		topPanel3 = createPanel(topPanel3Color, 1, 5, 0, 0);
		topPanel4 = createPanel(topPanel2Color, 1, 3, 0, 0);

		topPanel2.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 10));

		JPanel phoneLablePanel = createPanel(topPanel1Color, 1, 2, 0, 0);
		phoneLablePanel.add(createLable("0117685645", topPanel2TextColor, 15, 2));
		phoneLablePanel.add(createLable("0756789022", topPanel2TextColor, 15, 2));

		topPanel1.add(createEmptyPanel(topPanel1Color));
		topPanel1.add(createEmptyPanel(topPanel1Color));
		topPanel1.add(phoneLablePanel);

		topPanel2.add(createLable("Furniture Store", topPanel2TextColor, 24, 1));

		JPanel taskPanel = createPanel(topPanel2Color, 1, 3, 0, 0);

		taskPanel.add(createButton("Favourites", topPanel2TextColor, topPanel2Color, 14));
		taskPanel.add(createButton("Account", topPanel2TextColor, topPanel2Color, 14));
		taskPanel.add(createButton("Cart", topPanel2TextColor, topPanel2Color, 14));
		topPanel2.add(taskPanel);

		homeButton = createButton("HOME", topPanel3TextColor, topPanel3Color, 15);
		this.homeButton.addActionListener(this);
		topPanel3.add(homeButton);
		this.pantryButton = createButton("PANTRY", topPanel3TextColor, topPanel3Color, 15);
		this.pantryButton.addActionListener(this);
		topPanel3.add(this.pantryButton);
		this.livingButton = createButton("LIVING", topPanel3TextColor, topPanel3Color, 15);
		this.livingButton.addActionListener(this);
		topPanel3.add(this.livingButton);
		this.diningButton = createButton("DINING", topPanel3TextColor, topPanel3Color, 15);
		this.diningButton.addActionListener(this);
		topPanel3.add(this.diningButton);
		this.bedRoomsButton = createButton("BED ROOMS", topPanel3TextColor, topPanel3Color, 15);
		this.bedRoomsButton.addActionListener(this);
		topPanel3.add(this.bedRoomsButton);

		comboBox = new JComboBox(pantryOptions);
		comboBox.addActionListener(this);
		topPanel4.add(createEmptyPanel(topPanel2Color));
		topPanel4.add(comboBox);
		this.comboBox.setVisible(false);
		this.addButton = createButton("+ ADD ITEM", topPanel2TextColor, topPanel2Color, 15);
		topPanel4.add(this.addButton);

		topPanel.add(topPanel1);
		topPanel.add(topPanel2);
		topPanel.add(topPanel3);
		topPanel.add(topPanel4);

		return topPanel;

	}

	private JButton createButton(String text, String textColor, String buttonColor, int textSize) {

		JButton button = new JButton(text);
		button.setForeground(Color.decode(textColor));
		button.setFont(new Font(text, 1, textSize));
		button.setBackground(Color.decode(buttonColor));

		return button;
	}

	private JLabel createLable(String text, String textColor, int textSize, int type) {

		JLabel label = new JLabel(text);
		label.setFont(new Font(text, type, textSize));
		label.setForeground(Color.decode(textColor));

		return label;
	}

	private JPanel createEmptyPanel(String color) {

		JPanel emptyPanel = new JPanel();
		emptyPanel.setBackground(Color.decode(color));

		return emptyPanel;
	}

	private JPanel createPanel(String color, int rows, int cols, int hgap, int vgap) {

		JPanel panel = new JPanel(new GridLayout(rows, cols, hgap, vgap));
		panel.setBackground(Color.decode(color));

		return panel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(homeButton)) {
			this.setButtonValue("Home");
			this.comboBox.setVisible(false);
			this.switchMaintoShow();

		} else if (e.getSource().equals(this.pantryButton)) {
			this.setButtonValue("Pantry");
			this.addComboBoxItems(pantryOptions);
			this.switchMaintoShow();

		} else if (e.getSource().equals(this.livingButton)) {
			this.setButtonValue("Living");
			this.addComboBoxItems(this.livingOptions);
			this.switchMaintoShow();

		} else if (e.getSource().equals(this.diningButton)) {
			this.setButtonValue("Dining");
			this.addComboBoxItems(this.diningOptions);
			this.switchMaintoShow();

		} else if (e.getSource().equals(this.bedRoomsButton)) {
			this.setButtonValue("Bed Room");
			this.addComboBoxItems(this.bedRoomsOptions);
			this.switchMaintoShow();

		} else if (e.getSource().equals(this.comboBox) & this.getButtonValue() != "Home") {
			if (this.comboBox.getSelectedItem() != null) {

				this.setDropDownValue(this.comboBox.getSelectedItem().toString());
				
				
				
			}

		}

	}

	public void switchMaintoShow() {
		BasicFrame.dash.getBottomPanel().setVisible(false);
		showPage.getMainPanel().setVisible(false);
		showPage.getShowPanel().setVisible(true);

		BasicFrame.dash.getBottomPanel().setVisible(true);
		BasicFrame.dash.setBottomPanel(showPage.getMainPanel());
	}

	public String getButtonValue() {
		return buttonValue;
	}

	public void setButtonValue(String buttonValue) {
		this.buttonValue = buttonValue;
	}

	public String getDropDownValue() {
		return dropDownValue;
	}

	public void setDropDownValue(String dropDownValue) {
		this.dropDownValue = dropDownValue;
	}

	private void addComboBoxItems(String[] items) {
		this.comboBox.setVisible(true);
		this.comboBox.removeAllItems();
		for (String option : items) {
			this.comboBox.addItem(option);
		}
	}

}
