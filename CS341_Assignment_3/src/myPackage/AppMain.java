package myPackage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class AppMain {

	private JFrame frmShoppingList;
	private JTextField textFieldItem;
	private JTextField textFieldPrice;
	private JTextField textFieldQuantity;
	private JTextField textFieldTotal;
	private JTextArea textAreaOutput;
	private JButton btnGo;
	
	private SalesSlip slip;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppMain window = new AppMain();
					window.frmShoppingList.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AppMain() {
		initialize();
		createEvents();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		slip = new SalesSlip();
		
		frmShoppingList = new JFrame();
		frmShoppingList.setTitle("Shopping List");
		frmShoppingList.setBounds(100, 100, 450, 414);
		frmShoppingList.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmShoppingList.getContentPane().setLayout(null);
		
		JLabel lblShoppingList = new JLabel("Shopping List");
		lblShoppingList.setBounds(176, 13, 82, 16);
		frmShoppingList.getContentPane().add(lblShoppingList);
		
		textFieldItem = new JTextField();
		textFieldItem.setBounds(143, 42, 199, 22);
		frmShoppingList.getContentPane().add(textFieldItem);
		textFieldItem.setColumns(10);
		
		textFieldPrice = new JTextField();
		textFieldPrice.setBounds(143, 77, 116, 22);
		frmShoppingList.getContentPane().add(textFieldPrice);
		textFieldPrice.setColumns(10);
		
		textFieldQuantity = new JTextField();
		textFieldQuantity.setBounds(142, 112, 116, 22);
		frmShoppingList.getContentPane().add(textFieldQuantity);
		textFieldQuantity.setColumns(10);
		
		JLabel lblCost = new JLabel("Item:");
		lblCost.setBounds(12, 45, 56, 16);
		frmShoppingList.getContentPane().add(lblCost);
		
		JLabel lblPrice = new JLabel("Price:");
		lblPrice.setBounds(12, 80, 56, 16);
		frmShoppingList.getContentPane().add(lblPrice);
		
		JLabel lblQuantity = new JLabel("Quantity:");
		lblQuantity.setBounds(12, 115, 56, 16);
		frmShoppingList.getContentPane().add(lblQuantity);
		
		btnGo = new JButton("Add Item");
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnGo.setBounds(143, 147, 97, 25);
		frmShoppingList.getContentPane().add(btnGo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(12, 187, 408, 100);
		frmShoppingList.getContentPane().add(scrollPane);
		
		textAreaOutput = new JTextArea();
		scrollPane.setViewportView(textAreaOutput);
		
		textFieldTotal = new JTextField();
		textFieldTotal.setBounds(142, 300, 116, 22);
		frmShoppingList.getContentPane().add(textFieldTotal);
		textFieldTotal.setColumns(10);
		
		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setBounds(12, 303, 56, 16);
		frmShoppingList.getContentPane().add(lblTotal);
	}
	
	private void createEvents() {
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addItem();
			}
		});
	}
	
	private void addItem() {
		String item = textFieldItem.getText();
		String cost = textFieldPrice.getText();
		String quantity = textFieldQuantity.getText();
		if (cost.length()!=5 && cost.length()!=4) {
			textAreaOutput.setText("Invalid Price: Please a Valid price less than $100 Including decimals.");
			return;
		}
		
		SalesItem salesItem = new SalesItem(item, cost, quantity);
		slip.addSalesItem(salesItem);
		
		textFieldTotal.setText(slip.computeTotal());
		textAreaOutput.setText(slip.constructList());
	}
}
