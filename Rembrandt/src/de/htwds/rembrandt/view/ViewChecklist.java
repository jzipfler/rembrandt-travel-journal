package de.htwds.rembrandt.view;


import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import de.htwds.rembrandt.controler.viewChecklistControler.ViewChecklistLoad;
import de.htwds.rembrandt.controler.viewChecklistControler.ViewChecklistSave;
import de.htwds.rembrandt.model.CheckElement;
import de.htwds.rembrandt.model.CheckList;

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
	private ViewMain main;

	/**
	 * Create the panel.
	 */
	public ViewChecklist(final ViewMain main) {
		this.main = main;
		listBag = new CheckList();
		listCheck = new CheckList();
		loadChecklists();
		
		
		addAncestorListener(new AncestorListener() {
			@Override
			public void ancestorAdded(AncestorEvent arg0) {
			}
			@Override
			public void ancestorMoved(AncestorEvent arg0) {
			}
			@Override
			public void ancestorRemoved(AncestorEvent arg0) {
				saveChecklists();
			}
		});
		setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel pnlBag = new JPanel();
		add(pnlBag);
		
		JLabel lblBagHeader = new JLabel(Messages.getString("ViewChecklist.0")); //$NON-NLS-1$
		lblBagHeader.setHorizontalAlignment(SwingConstants.LEFT);
		lblBagHeader.setFont(new Font(Messages.getString("ViewChecklist.1"), Font.BOLD, 15)); //$NON-NLS-1$
		
		txtBagElement = new JTextField();
		txtBagElement.setFont(new Font(Messages.getString("ViewChecklist.2"), Font.PLAIN, 13)); //$NON-NLS-1$
		txtBagElement.setColumns(10);
		
		JLabel lblBagElement = new JLabel(Messages.getString("ViewChecklist.3")); //$NON-NLS-1$
		lblBagElement.setFont(new Font(Messages.getString("ViewChecklist.4"), Font.PLAIN, 13)); //$NON-NLS-1$
		
		JLabel lblCount = new JLabel(Messages.getString("ViewChecklist.5")); //$NON-NLS-1$
		lblCount.setFont(new Font(Messages.getString("ViewChecklist.6"), Font.PLAIN, 13)); //$NON-NLS-1$
		
		txtCount = new JTextField();
		txtCount.setFont(new Font(Messages.getString("ViewChecklist.7"), Font.PLAIN, 13)); //$NON-NLS-1$
		txtCount.setColumns(10);
		
		JButton btnBagCheck = new JButton(Messages.getString("ViewChecklist.8")); //$NON-NLS-1$
		btnBagCheck.setFont(new Font(Messages.getString("ViewChecklist.9"), Font.PLAIN, 13)); //$NON-NLS-1$
		btnBagCheck.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int index = tblBag.getSelectedRow();
				if(index != -1)
				{
					listBag.checkElement(index);
					fillBagTable();
				}
			}
		});
		
		JButton btnBagAdd = new JButton(Messages.getString("ViewChecklist.10")); //$NON-NLS-1$
		btnBagAdd.setFont(new Font(Messages.getString("ViewChecklist.11"), Font.PLAIN, 13)); //$NON-NLS-1$
		btnBagAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(!txtCount.getText().trim().equals(Messages.getString("ViewChecklist.12")) && !txtBagElement.getText().trim().equals(Messages.getString("ViewChecklist.13"))) //$NON-NLS-1$ //$NON-NLS-2$
				{
				if(listBag == null)
				{
					listBag = new CheckList();
				}
				listBag.addLast(txtBagElement.getText(), Integer.parseInt(txtCount.getText()));
				fillBagTable();
				}
			}
		});
		
		
		
		JButton btnBagDelete = new JButton(Messages.getString("ViewChecklist.14")); //$NON-NLS-1$
		btnBagDelete.addActionListener(new ActionListener() {
			@Override
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
		btnBagDelete.setFont(new Font(Messages.getString("ViewChecklist.15"), Font.BOLD, 13)); //$NON-NLS-1$
		
		JScrollPane scrpnlBag = new JScrollPane();
		scrpnlBag.setFont(new Font(Messages.getString("ViewChecklist.16"), Font.PLAIN, 13)); //$NON-NLS-1$
		
		GroupLayout gl_pnlBag = new GroupLayout(pnlBag);
		gl_pnlBag.setHorizontalGroup(
			gl_pnlBag.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pnlBag.createSequentialGroup()
					.addGroup(gl_pnlBag.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlBag.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_pnlBag.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnBagCheck, GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
								.addGroup(gl_pnlBag.createSequentialGroup()
									.addGroup(gl_pnlBag.createParallelGroup(Alignment.LEADING)
										.addComponent(lblBagElement)
										.addComponent(lblCount))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_pnlBag.createParallelGroup(Alignment.LEADING)
										.addComponent(txtCount, GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
										.addComponent(txtBagElement, GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)))
								.addGroup(gl_pnlBag.createSequentialGroup()
									.addComponent(btnBagAdd, GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
									.addGap(4)
									.addComponent(btnBagDelete))))
						.addGroup(gl_pnlBag.createSequentialGroup()
							.addGap(65)
							.addComponent(lblBagHeader))
						.addGroup(gl_pnlBag.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrpnlBag, GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_pnlBag.setVerticalGroup(
			gl_pnlBag.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlBag.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblBagHeader)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrpnlBag, GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
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
					Messages.getString("ViewChecklist.17"), Messages.getString("ViewChecklist.18"), Messages.getString("ViewChecklist.19") //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				}
			) {
				Class[] columnTypes = new Class[] {
					String.class, Integer.class, Boolean.class
				};
				@Override
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
				boolean[] columnEditables = new boolean[] {
					false, false, false
				};
				@Override
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			};
		
		tblBag.setModel(bagModel);
		
		
		
		pnlBag.setLayout(gl_pnlBag);
		
		JPanel pnlCheck = new JPanel();
		add(pnlCheck);
		
		JLabel lblNewLabel = new JLabel(Messages.getString("ViewChecklist.20")); //$NON-NLS-1$
		lblNewLabel.setFont(new Font(Messages.getString("ViewChecklist.21"), Font.BOLD, 15)); //$NON-NLS-1$
		
		JButton btnCheck = new JButton(Messages.getString("ViewChecklist.22")); //$NON-NLS-1$
		btnCheck.setFont(new Font(Messages.getString("ViewChecklist.23"), Font.PLAIN, 13)); //$NON-NLS-1$
		btnCheck.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int index = tblCheck.getSelectedRow();
				if(index != -1)
				{
					listCheck.checkElement(index);
					fillCheckTable();
				}
			}
		});
		
		JLabel lblCheckElement = new JLabel(Messages.getString("ViewChecklist.24")); //$NON-NLS-1$
		lblCheckElement.setFont(new Font(Messages.getString("ViewChecklist.25"), Font.PLAIN, 13)); //$NON-NLS-1$
		
		txtCheckElement = new JTextField();
		txtCheckElement.setFont(new Font(Messages.getString("ViewChecklist.26"), Font.PLAIN, 13)); //$NON-NLS-1$
		txtCheckElement.setColumns(10);
		
		JButton btnCheckAdd = new JButton(Messages.getString("ViewChecklist.27")); //$NON-NLS-1$
		btnCheckAdd.setFont(new Font(Messages.getString("ViewChecklist.28"), Font.PLAIN, 13)); //$NON-NLS-1$
		btnCheckAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!txtCheckElement.getText().trim().equals(Messages.getString("ViewChecklist.29"))) //$NON-NLS-1$
				{
				if(listCheck == null)
				{
					listCheck = new CheckList();
				}
				listCheck.addLast(txtCheckElement.getText(), 0);
				fillCheckTable();
				}
			}
		});
		
		JButton btnCheckDelete = new JButton(Messages.getString("ViewChecklist.30")); //$NON-NLS-1$
		btnCheckDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int index = tblCheck.getSelectedRow();
				if(index != -1)
				{
					listCheck.deleteElement(index);
					fillCheckTable();
				}
			}
		});
		btnCheckDelete.setFont(new Font(Messages.getString("ViewChecklist.31"), Font.BOLD, 13)); //$NON-NLS-1$
		btnCheckDelete.setForeground(Color.RED);
		
		JScrollPane scrpnlCheck = new JScrollPane();
		scrpnlCheck.setFont(new Font(Messages.getString("ViewChecklist.32"), Font.PLAIN, 13)); //$NON-NLS-1$
		GroupLayout gl_pnlCheck = new GroupLayout(pnlCheck);
		gl_pnlCheck.setHorizontalGroup(
			gl_pnlCheck.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlCheck.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnlCheck.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_pnlCheck.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addGap(74))
						.addGroup(gl_pnlCheck.createSequentialGroup()
							.addComponent(lblCheckElement)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtCheckElement, GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(gl_pnlCheck.createSequentialGroup()
							.addComponent(btnCheckAdd, GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnCheckDelete, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_pnlCheck.createSequentialGroup()
							.addGroup(gl_pnlCheck.createParallelGroup(Alignment.TRAILING)
								.addComponent(scrpnlCheck, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
								.addComponent(btnCheck, GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE))
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
						.addComponent(btnCheckDelete, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnCheckAdd, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap())
		);
		
		tblCheck = new JTable();
		TableModel checkModel = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				Messages.getString("ViewChecklist.33"), Messages.getString("ViewChecklist.34") //$NON-NLS-1$ //$NON-NLS-2$
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Boolean.class
			};
			@Override
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false
			};
			@Override
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		};
		scrpnlCheck.setViewportView(tblCheck);
		pnlCheck.setLayout(gl_pnlCheck);
		tblCheck.setModel(checkModel);
		
		if(listBag != null)
		{
			this.fillBagTable();
		}
		if(listCheck != null)
		{
			this.fillCheckTable();
		}
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
	
	public ViewMain getParentFrame() {
		return main;
	}
	
	public void loadChecklists()
	{
		ViewChecklistLoad loader = new ViewChecklistLoad(main.getJourneyModel());
		listBag = loader.loadChecklistBag();
		listCheck = loader.loadChecklistCheck();
	}
	
	public void saveChecklists()
	{
		ViewChecklistSave saver = new ViewChecklistSave(main.getJourneyModel());
		saver.save(listBag, listCheck);
	}
	
	public void refreshTables()
	{
		loadChecklists();
		fillCheckTable();
		fillBagTable();
	}
	
}
