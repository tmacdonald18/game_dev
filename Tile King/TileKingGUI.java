package tileKing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JCheckBoxMenuItem;
import java.awt.GridLayout;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JScrollBar;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

public class TileKingGUI extends JFrame {

	private JPanel contentPane;
	private JTextField columns;
	private JTextField rows;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TileKingGUI frame = new TileKingGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TileKingGUI() {
		setTitle("Tile King");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1210, 775);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNew = new JMenuItem("New");
		mnNewMenu.add(mntmNew);
		
		JMenuItem mntmOpen = new JMenuItem("Open...");
		mnNewMenu.add(mntmOpen);
		
		JMenuItem mntmSave = new JMenuItem("Save");
		mnNewMenu.add(mntmSave);
		
		JMenuItem mntmSaveAs = new JMenuItem("Save As...");
		mnNewMenu.add(mntmSaveAs);
		
		JMenu mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);
		
		JCheckBoxMenuItem chckbxmntmShowGrid = new JCheckBoxMenuItem("Show Grid");
		mnEdit.add(chckbxmntmShowGrid);
		
		JMenuItem mntmResizeGrid = new JMenuItem("Resize Grid");
		mnEdit.add(mntmResizeGrid);
		
		JMenuItem mntmUpdateTiles = new JMenuItem("Update Tiles");
		mnEdit.add(mntmUpdateTiles);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 11, 166, 693);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel height = new JLabel("Rows:");
		height.setFont(new Font("Tahoma", Font.BOLD, 12));
		height.setBounds(10, 36, 87, 14);
		panel.add(height);
		
		JLabel width = new JLabel("Columns:");
		width.setFont(new Font("Tahoma", Font.BOLD, 12));
		width.setBounds(10, 11, 87, 14);
		panel.add(width);
		
		columns = new JTextField();
		columns.setText("10");
		columns.setBounds(70, 9, 86, 20);
		panel.add(columns);
		columns.setColumns(10);
		
		rows = new JTextField();
		rows.setText("10");
		rows.setBounds(70, 34, 86, 20);
		panel.add(rows);
		rows.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(186, 11, 998, 693);
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(1, 0, 0, 0));
		
		GridPanel gridPanel = new GridPanel(Integer.parseInt(columns.getText()), Integer.parseInt(rows.getText()));
		panel_1.add(gridPanel);
		gridPanel.setLayout(null);
	}
}
