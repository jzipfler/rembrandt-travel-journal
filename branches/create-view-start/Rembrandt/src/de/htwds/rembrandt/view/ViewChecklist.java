package de.htwds.rembrandt.view;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JScrollPane;

public class ViewChecklist extends JPanel {
	private JTextField txtBagElement;
	private JTextField txtCount;
	private JTextField txtCheckElement;
	private JTable tblBag;
	private JTable tblCheck;
	private DefaultTableModel bagModel;

	/**
	 * Create the panel.
	 */
	public ViewChecklist() {
		setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel pnlBag = new JPanel();
		add(pnlBag);
		
		JLabel lblBagHeader = new JLabel("Kofferinhalt");
		lblBagHeader.setHorizontalAlignment(SwingConstants.LEFT);
		lblBagHeader.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		txtBagElement = new JTextField();
		txtBagElement.setColumns(10);
		
		JLabel lblBagElement = new JLabel("Kofferelement:");
		
		JLabel lblCount = new JLabel("Anzahl:");
		
		txtCount = new JTextField();
		txtCount.setColumns(10);
		
		JButton btnBagCheck = new JButton("Abhaken");
		
		JButton btnBagAdd = new JButton("Hinzufügen");
		btnBagAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Object[] rowData = new Object[3];
				rowData[0] = txtBagElement.getText();
				rowData[1] = txtCount.getText();
				rowData[2] = false;
				bagModel.addRow(rowData);
			}
		});
		
		
		
		JButton btnBagDelete = new JButton("X");
		btnBagDelete.setForeground(Color.RED);
		btnBagDelete.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JScrollPane scrpnlBag = new JScrollPane();
		GroupLayout gl_pnlBag = new GroupLayout(pnlBag);
		gl_pnlBag.setHorizontalGroup(
			gl_pnlBag.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pnlBag.createSequentialGroup()
					.addGroup(gl_pnlBag.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlBag.createSequentialGroup()
							.addGap(65)
							.addComponent(lblBagHeader))
						.addGroup(gl_pnlBag.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_pnlBag.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnBagCheck, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
								.addGroup(gl_pnlBag.createSequentialGroup()
									.addGroup(gl_pnlBag.createParallelGroup(Alignment.LEADING)
										.addComponent(lblBagElement)
										.addComponent(lblCount))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_pnlBag.createParallelGroup(Alignment.LEADING)
										.addComponent(txtCount, GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
										.addComponent(txtBagElement, GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)))
								.addGroup(gl_pnlBag.createSequentialGroup()
									.addComponent(btnBagAdd, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnBagDelete, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_pnlBag.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrpnlBag, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_pnlBag.setVerticalGroup(
			gl_pnlBag.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlBag.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblBagHeader)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrpnlBag, GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnBagCheck)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pnlBag.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblBagElement)
						.addComponent(txtBagElement, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_pnlBag.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCount)
						.addComponent(txtCount, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pnlBag.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnBagAdd)
						.addComponent(btnBagDelete))
					.addContainerGap())
		);
		
		bagModel = new DefaultTableModel(
				new Object[][] {
					},
				new String[] {
					"Bezeichnung", "Menge", "Abgehakt"
				}
			) {
				Class[] columnTypes = new Class[] {
					String.class, Integer.class, Boolean.class
				};
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
				boolean[] columnEditables = new boolean[] {
					false, false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			};
		
		tblBag = new JTable();
		tblBag.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Bezeichnung", "Menge", "Abgehakt"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Integer.class, Boolean.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrpnlBag.setViewportView(tblBag);
		pnlBag.setLayout(gl_pnlBag);
		
		JPanel pnlCheck = new JPanel();
		add(pnlCheck);
		
		JLabel lblNewLabel = new JLabel("Checkliste");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JButton btnCheck = new JButton("Abhaken");
		
		JLabel lblCheckElement = new JLabel("Checkelement:");
		
		txtCheckElement = new JTextField();
		txtCheckElement.setColumns(10);
		
		JButton btnCheckAdd = new JButton("Hinzufügen");
		
		JButton btnCheckDelete = new JButton("X");
		btnCheckDelete.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCheckDelete.setForeground(Color.RED);
		
		JScrollPane scrpnlCheck = new JScrollPane();
		GroupLayout gl_pnlCheck = new GroupLayout(pnlCheck);
		gl_pnlCheck.setHorizontalGroup(
			gl_pnlCheck.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlCheck.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnlCheck.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_pnlCheck.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addGap(74))
						.addGroup(Alignment.TRAILING, gl_pnlCheck.createSequentialGroup()
							.addComponent(lblCheckElement)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtCheckElement, GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(Alignment.TRAILING, gl_pnlCheck.createSequentialGroup()
							.addComponent(btnCheckAdd, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnCheckDelete, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(Alignment.TRAILING, gl_pnlCheck.createSequentialGroup()
							.addGroup(gl_pnlCheck.createParallelGroup(Alignment.TRAILING)
								.addComponent(scrpnlCheck, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
								.addComponent(btnCheck, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
							.addContainerGap())))
		);
		gl_pnlCheck.setVerticalGroup(
			gl_pnlCheck.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlCheck.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrpnlCheck, GroupLayout.PREFERRED_SIZE, 280, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnCheck)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pnlCheck.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCheckElement)
						.addComponent(txtCheckElement, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pnlCheck.createParallelGroup(Alignment.LEADING)
						.addComponent(btnCheckAdd, GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
						.addComponent(btnCheckDelete, GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE))
					.addContainerGap())
		);
		
		tblCheck = new JTable();
		tblCheck.setModel(new DefaultTableModel(
			new Object[][] {
				},
			new String[] {
				"Bezeichnung", "Menge", "Abgehakt"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Integer.class, Boolean.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrpnlCheck.setViewportView(tblCheck);
		pnlCheck.setLayout(gl_pnlCheck);
		
		
	}
}
