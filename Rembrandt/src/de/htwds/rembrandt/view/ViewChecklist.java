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

public class ViewChecklist extends JPanel {
	private JTextField txtBagElement;
	private JTextField txtCount;
	private JTextField txtCheckElement;

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
		
		JList lstBag = new JList();
		
		txtBagElement = new JTextField();
		txtBagElement.setColumns(10);
		
		JLabel lblBagElement = new JLabel("Kofferelement:");
		
		JLabel lblCount = new JLabel("Anzahl:");
		
		txtCount = new JTextField();
		txtCount.setColumns(10);
		
		JButton btnBagCheck = new JButton("Abhaken");
		
		JButton btnBagAdd = new JButton("Hinzufügen");
		GroupLayout gl_pnlBag = new GroupLayout(pnlBag);
		gl_pnlBag.setHorizontalGroup(
			gl_pnlBag.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_pnlBag.createSequentialGroup()
					.addGroup(gl_pnlBag.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_pnlBag.createSequentialGroup()
							.addContainerGap()
							.addComponent(lstBag, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
						.addGroup(Alignment.LEADING, gl_pnlBag.createSequentialGroup()
							.addGap(65)
							.addComponent(lblBagHeader))
						.addGroup(gl_pnlBag.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_pnlBag.createParallelGroup(Alignment.LEADING)
								.addComponent(btnBagCheck, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
								.addGroup(Alignment.TRAILING, gl_pnlBag.createSequentialGroup()
									.addGroup(gl_pnlBag.createParallelGroup(Alignment.LEADING)
										.addComponent(lblBagElement)
										.addComponent(lblCount))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_pnlBag.createParallelGroup(Alignment.LEADING)
										.addComponent(txtCount, GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
										.addComponent(txtBagElement, GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)))
								.addComponent(btnBagAdd, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))))
					.addContainerGap())
		);
		gl_pnlBag.setVerticalGroup(
			gl_pnlBag.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlBag.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblBagHeader)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lstBag, GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
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
					.addComponent(btnBagAdd)
					.addContainerGap())
		);
		pnlBag.setLayout(gl_pnlBag);
		
		JPanel pnlCheck = new JPanel();
		add(pnlCheck);
		
		JLabel lblNewLabel = new JLabel("Checkliste");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JList list = new JList();
		
		JButton btnCheck = new JButton("Abhaken");
		
		JLabel lblCheckElement = new JLabel("Checkelement:");
		
		txtCheckElement = new JTextField();
		txtCheckElement.setColumns(10);
		
		JButton btnCheckAdd = new JButton("Hinzufügen");
		GroupLayout gl_pnlCheck = new GroupLayout(pnlCheck);
		gl_pnlCheck.setHorizontalGroup(
			gl_pnlCheck.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlCheck.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnlCheck.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlCheck.createSequentialGroup()
							.addComponent(btnCheckAdd, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(Alignment.TRAILING, gl_pnlCheck.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addGap(74))
						.addGroup(Alignment.TRAILING, gl_pnlCheck.createSequentialGroup()
							.addGroup(gl_pnlCheck.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnCheck, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
								.addComponent(list, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
							.addContainerGap())
						.addGroup(gl_pnlCheck.createSequentialGroup()
							.addComponent(lblCheckElement)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtCheckElement, GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
							.addContainerGap())))
		);
		gl_pnlCheck.setVerticalGroup(
			gl_pnlCheck.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlCheck.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(list, GroupLayout.PREFERRED_SIZE, 280, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnCheck)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pnlCheck.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCheckElement)
						.addComponent(txtCheckElement, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnCheckAdd, GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
					.addContainerGap())
		);
		pnlCheck.setLayout(gl_pnlCheck);

	}
}
