package de.htwds.rembrandt.view;

import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

public class ViewConfig extends JPanel {
	private JTextField txtSavePath;

	/**
	 * Create the panel.
	 */
	public ViewConfig() {
		
		JLabel lblSavePath = new JLabel(Messages.getString("ViewConfig.0")); //$NON-NLS-1$
		lblSavePath.setFont(new Font(Messages.getString("ViewConfig.1"), Font.BOLD, 14)); //$NON-NLS-1$
		
		txtSavePath = new JTextField();
		txtSavePath.setColumns(10);
		
		JButton btnSave = new JButton(Messages.getString("ViewConfig.2")); //$NON-NLS-1$
		
		JButton btnOk = new JButton(Messages.getString("ViewConfig.3")); //$NON-NLS-1$
		
		JButton btnCancel = new JButton(Messages.getString("ViewConfig.4")); //$NON-NLS-1$
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(60)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblSavePath)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnOk, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
						.addComponent(txtSavePath))
					.addGap(88))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(60)
					.addComponent(lblSavePath)
					.addGap(5)
					.addComponent(txtSavePath, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(222)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnOk, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(54, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}
}
