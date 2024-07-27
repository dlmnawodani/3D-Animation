import java.awt.BorderLayout;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLJPanel;

public class FurnitureShowPage extends JFrame implements ActionListener {

	private String buttonValue;
	private String dropDownValue;
	private JPanel showPanel;
	private FurnitureColors[] furniColors = new FurnitureColors[FurnitureColors.values().length];
	private OtherColors[] otherColors = new OtherColors[OtherColors.values().length];
	private JComboBox furniCombo;
	private JComboBox otherCombo;
	private GLJPanel gljPanel;
	private JPanel bigPanel;
	private JPanel subPanel;
	public static Furniture furniture = DataStore.furnitures[0];
	
	private JPanel mainPanel;

	private OtherColors otherCo = null;
	private FurnitureColors furniCo = null;

	final GLProfile profile = GLProfile.get(GLProfile.GL2);
	GLCapabilities capabilities = new GLCapabilities(profile);
	private GLJPanel[] gljpanels = {};
	private JPanel[] subPanels = {};
	private JPanel[] mainPanels = {};
	private JButton[] moreButtons = {};

	public JPanel getShowPanel() {
		return showPanel;
	}

	public void setShowPanel(JPanel showPanel) {
		this.showPanel = showPanel;
	}

	public JPanel getMainPanel() {
		return mainPanel;
	}

	public void setMainPanel(JPanel mainPanel) {
		this.mainPanel = mainPanel;
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

	public FurnitureShowPage(String buttonValue, String dropDownValue) {
		this.setButtonValue(buttonValue);
		this.setDropDownValue(dropDownValue);
		this.gljpanels = new GLJPanel[DataStore.furnitures.length];
		this.subPanels = new JPanel[DataStore.furnitures.length];
		this.mainPanels = new JPanel[DataStore.furnitures.length];
		this.moreButtons = new JButton[DataStore.furnitures.length];
	}

	public JPanel designTopPanel() {
		setFurnitureColors();
		setOtherColors();
		this.gljPanel = new GLJPanel(capabilities);
		mainPanel = new JPanel(new BorderLayout());
		showPanel = new JPanel(new GridLayout(2, DataStore.furnitures.length / 2, 0, 0));
		this.setItems();
		mainPanel.add(showPanel, BorderLayout.CENTER);
		return mainPanel;

	}

	public void setItems() {
		Furniture furni;
		for (int i = 0; i < DataStore.furnitures.length; i++) {
			furni = DataStore.furnitures[i];
			if (this.dropDownValue == "Chair") {

			this.getChairs(furni, i);
			} else if (this.dropDownValue == "Table") {
				getTable(furni, i);
			} else if (this.dropDownValue == "All") {
				if(furni.getType() == "Chair") {
					this.getChairs(furni, i);
				}else {
					getTable(furni, i);
				}
				
			}

		}
	}

	private void getChairs(Furniture furni, int i) {
		this.mainPanels[i] = new JPanel(new BorderLayout(0, 0));
		this.gljpanels[i] = new GLJPanel(capabilities);

		ChairWithBackRest chair = new ChairWithBackRest(furni.getFurniRed(), furni.getFurniGreen(),
				furni.getFurniBlue(), furni.getSeatRed(), furni.getSeatGreen(), furni.getSeatBlue());
		gljpanels[i].addGLEventListener(chair);

		this.subPanels[i] = new JPanel(new GridLayout(3, 1, 0, 0));
		this.subPanels[i].add(new JLabel(furni.getType()));
		if(furni.getQuantity() > 0) {
			this.subPanels[i].add(new JLabel("In Stock"));
		}
		
		this.moreButtons[i] = new JButton("More");
		this.moreButtons[i].addActionListener(this);
		this.subPanels[i].add(this.moreButtons[i]);
		this.mainPanels[i].add(this.gljpanels[i], BorderLayout.CENTER);
		this.mainPanels[i].add(this.subPanels[i], BorderLayout.SOUTH);
		showPanel.add(this.mainPanels[i]);
	}

	private void getTable(Furniture furni, int i) {
		this.mainPanels[i] = new JPanel(new BorderLayout(0, 0));
		this.gljpanels[i] = new GLJPanel(capabilities);

		Table table = new Table(furni.getFurniRed(), furni.getFurniGreen(), furni.getFurniBlue(), furni.getSeatRed(),
				furni.getSeatGreen(), furni.getSeatBlue());
		gljpanels[i].addGLEventListener(table);

		this.subPanels[i] = new JPanel(new GridLayout(3, 1, 0, 0));
		
		this.subPanels[i].add(new JLabel(furni.getType()));
		if(furni.getQuantity() > 0) {
			this.subPanels[i].add(new JLabel("In Stock"));
		}
		
		this.moreButtons[i] = new JButton("More");
		this.moreButtons[i].addActionListener(this);
		this.subPanels[i].add(this.moreButtons[i]);
		this.mainPanels[i].add(this.gljpanels[i], BorderLayout.CENTER);
		this.mainPanels[i].add(this.subPanels[i], BorderLayout.SOUTH);
		showPanel.add(this.mainPanels[i]);
	}

	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(furniCombo)) {
			Color furniColor = new Color(this.furniCombo.getSelectedItem().toString());

			for (FurnitureColors color : FurnitureColors.values()) {
				if (color.toString().equals(furniColor.getColorName())) {
					furniCo = color;
					if (otherCo != null) {
						Color otCol = new Color(this.otherCombo.getSelectedItem().toString());
						furniture.setSeatColor(otherCo);
						furniture.setSeatRed(otCol.getRed());
						furniture.setSeatGreen(otCol.getGreen());
						furniture.setSeatBlue(otCol.getBlue());
					}
					this.bigPanel.setVisible(false);
					Room room = new Room(furniColor.getRed(), furniColor.getGreen(), furniColor.getBlue(),
							furniture.getSeatRed(), furniture.getSeatGreen(), furniture.getSeatBlue());
					gljPanel.addGLEventListener(room);
					bigPanel = new JPanel(new BorderLayout());
					subPanel = createSubPanel(furniCo, furniture.getSeatColor());
					bigPanel.add(gljPanel, BorderLayout.CENTER);
					bigPanel.add(subPanel, BorderLayout.EAST);
					this.bigPanel.setVisible(true);
					this.mainPanel.add(bigPanel);
					break;
				}
			}

		} else if (e.getSource().equals(otherCombo)) {
			Color otherColor = new Color(this.otherCombo.getSelectedItem().toString());

			for (OtherColors color : OtherColors.values()) {
				if (color.toString().equals(otherColor.getColorName())) {
					otherCo = color;

					if (furniCo != null) {
						Color otCol = new Color(this.furniCombo.getSelectedItem().toString());
						furniture.setFurniColor(furniCo);
						furniture.setFurniRed(otCol.getRed());
						furniture.setFurniGreen(otCol.getGreen());
						furniture.setFurniBlue(otCol.getBlue());
					}
					this.bigPanel.setVisible(false);
					Room room = new Room(furniture.getFurniRed(), furniture.getFurniGreen(), furniture.getFurniBlue(),
							otherColor.getRed(), otherColor.getGreen(), otherColor.getBlue());
					gljPanel.addGLEventListener(room);
					bigPanel = new JPanel(new BorderLayout());
					subPanel = createSubPanel(furniture.getFurniColor(), otherCo);
					bigPanel.add(gljPanel, BorderLayout.CENTER);
					bigPanel.add(subPanel, BorderLayout.EAST);
					this.bigPanel.setVisible(true);
					this.mainPanel.add(bigPanel);
					break;
				}
			}

		}

		else {
			for (int i = 0; i < this.moreButtons.length; i++) {
				if (e.getSource().equals(this.moreButtons[i])) {
					this.gljPanel = new GLJPanel(capabilities);
					furniture = DataStore.furnitures[i];
					Room room = new Room(furniture.getFurniRed(), furniture.getFurniGreen(), furniture.getFurniBlue(),
							furniture.getSeatRed(), furniture.getSeatGreen(), furniture.getSeatBlue());
					gljPanel.addGLEventListener(room);
					bigPanel = new JPanel(new BorderLayout());
					subPanel = createSubPanel(furniture.getFurniColor(), furniture.getSeatColor());
					bigPanel.add(gljPanel, BorderLayout.CENTER);
					bigPanel.add(subPanel, BorderLayout.EAST);
					this.mainPanel.add(bigPanel);
					switchShowtoMain();
					break;
				}

			}

		}

	}

	public void setFurnitureColors() {
		int i = 0;
		for (FurnitureColors color : FurnitureColors.values()) {
			this.furniColors[i] = color;
			i++;
		}
	}

	public void setOtherColors() {
		int i = 0;
		for (OtherColors color : OtherColors.values()) {
			this.otherColors[i] = color;
			i++;
		}
	}

	public JPanel createSubPanel(FurnitureColors furniColor, OtherColors otherColor) {
		JPanel subPanel = new JPanel(new GridLayout(6, 2, 0, 0));
		subPanel.setBorder(new EmptyBorder(10, 20, 10, 10));
		subPanel.setPreferredSize(new Dimension(300, 50));

		subPanel.add(new JLabel("Category"));
		JTextField catText = new JTextField();
		catText.setText(furniture.getCategory());
		catText.setEditable(false);
		subPanel.add(catText);

		subPanel.add(new JLabel("Furniture Type"));
		JTextField typeText = new JTextField();
		typeText.setText(furniture.getType());
		typeText.setEditable(false);
		subPanel.add(typeText);

		subPanel.add(new JLabel("Furniture Color"));
		this.furniCombo = new JComboBox(this.furniColors);
		this.furniCombo.setSelectedItem(furniColor);
		this.furniCombo.addActionListener(this);
		subPanel.add(this.furniCombo);

		subPanel.add(new JLabel("Seat Color"));
		this.otherCombo = new JComboBox(this.otherColors);
		this.otherCombo.setSelectedItem(otherColor);
		this.otherCombo.addActionListener(this);
		subPanel.add(this.otherCombo);

		subPanel.add(new JLabel("Available Items"));
		JTextField qText = new JTextField();
		qText.setText(String.valueOf(furniture.getQuantity()));
		qText.setEditable(false);
		subPanel.add(qText);

		subPanel.add(new JLabel("Unit Price Rs."));
		JTextField upText = new JTextField();
		upText.setText(String.valueOf(furniture.getUnitPrice()));
		upText.setEditable(false);
		subPanel.add(upText);

		return subPanel;
	}

	public void switchShowtoMain() {

		BasicFrame.dash.getBottomPanel().setVisible(false);
		this.showPanel.setVisible(false);
		this.mainPanel.setVisible(true);
		BasicFrame.dash.getBottomPanel().setVisible(true);
		BasicFrame.dash.setBottomPanel(mainPanel);

	}

}
