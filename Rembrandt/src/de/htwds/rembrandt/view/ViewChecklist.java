package de.htwds.rembrandt.view;


import javax.swing.JPanel;
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

import de.htwds.rembrandt.model.CheckElement;
import de.htwds.rembrandt.model.CheckList;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewChecklist extends JPanel {
	private JTextField txtBagElement;
	private JTextField txtCount;
	private JTextField txtCheckElement;
	private DefaultTableModel bagModel;
	private Object[][] bagData;
	private JTable tblBag;
	private JTable tblCheck;
	private CheckList listBag;
	private CheckList listCheck;

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
		btnBagCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = tblBag.getSelectedRow();
				if(index != -1)
				{
					listBag.checkElement(index);
					fillBagTable();
				}
			}
		});
		
		JButton btnBagAdd = new JButton("Hinzuf\u00FCgen");
		btnBagAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(listBag == null)
				{
					listBag = new CheckList();
				}
				listBag.addLast(txtBagElement.getText(), Integer.parseInt(txtCount.getText()));
				fillBagTable();
				}
		});
		
		
		
		JButton btnBagDelete = new JButton("X");
		btnBagDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = tblBag.getSelectedRow();
				if(index != -1)
				{
					listBag.deleteElement(index);
					fillBagTable();
				}
			}
		});
		btnBagDelete.setForeground(Color.RED);
		btnBagDelete.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JScrollPane scrpnlBag = new JScrollPane();
		
		GroupLayout gl_pnlBag = new GroupLayout(pnlBag);
		gl_pnlBag.setHorizontalGroup(
			gl_pnlBag.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pnlBag.createSequentialGroup()
					.addGroup(gl_pnlBag.createParallelGroup(Alignment.LEADING)
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
							.addGap(65)
							.addComponent(lblBagHeader))
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
		
		tblBag = new JTable();
		
		scrpnlBag.setViewportView(tblBag);
		
		bagModel = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Bezeichnung", "Menge", "Abgearbeitet"
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
		
		tblBag.setModel(bagModel);
		
		
		
		pnlBag.setLayout(gl_pnlBag);
		
		JPanel pnlCheck = new JPanel();
		add(pnlCheck);
		
		JLabel lblNewLabel = new JLabel("Checkliste");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JButton btnCheck = new JButton("Abhaken");
		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = tblCheck.getSelectedRow();
				if(index != -1)
				{
					listCheck.checkElement(index);
					fillCheckTable();
				}
			}
		});
		
		JLabel lblCheckElement = new JLabel("Checkelement:");
		
		txtCheckElement = new JTextField();
		txtCheckElement.setColumns(10);
		
		JButton btnCheckAdd = new JButton("Hinzuf\u00FCgen");
		btnCheckAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(listCheck == null)
				{
					listCheck = new CheckList();
				}
				listCheck.addLast(txtCheckElement.getText(), 0);
				fillCheckTable();
			}
		});
		
		JButton btnCheckDelete = new JButton("X");
		btnCheckDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = tblCheck.getSelectedRow();
				if(index != -1)
				{
					listCheck.deleteElement(index);
					fillCheckTable();
				}
			}
		});
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
		TableModel checkModel = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Bezeichnung", "Abgearbeitet"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Boolean.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		};
		scrpnlCheck.setViewportView(tblCheck);
		pnlCheck.setLayout(gl_pnlCheck);
		tblCheck.setModel(checkModel);
	}
	
	private void fillBagTable()
	{
		int rows = ((DefaultTableModel)tblBag.getModel()).getRowCount();
		for(int i = 0; i < rows; i++)
		{
			((DefaultTableModel)tblBag.getModel()).removeRow(0);
		}
		CheckElement actelement = listBag.getRoot();
		for(int i = 0; i < listBag.getElementNumber(); i++)
		{
			Object[] rowdata = new Object[3];
			rowdata[0] = actelement.getDescription();
			rowdata[1] = actelement.getAmount();
			rowdata[2] = actelement.getChecked();
			((DefaultTableModel)tblBag.getModel()).addRow(rowdata);
			actelement = actelement.getNext();
		}
		((DefaultTableModel)tblBag.getModel()).fireTableDataChanged();
	}
	
	private void fillCheckTable()
	{
		int rows = ((DefaultTableModel)tblCheck.getModel()).getRowCount();
		for(int i = 0; i < rows; i++)
		{
			((DefaultTableModel)tblCheck.getModel()).removeRow(0);
		}
		CheckElement actelement = listCheck.getRoot();
		for(int i = 0; i < listCheck.getElementNumber(); i++)
		{
			Object[] rowdata = new Object[3];
			rowdata[0] = actelement.getDescription();
			rowdata[1] = actelement.getChecked();
			((DefaultTableModel)tblCheck.getModel()).addRow(rowdata);
			actelement = actelement.getNext();
		}
		((DefaultTableModel)tblCheck.getModel()).fireTableDataChanged();
	}
}
