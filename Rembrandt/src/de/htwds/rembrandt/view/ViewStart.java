package de.htwds.rembrandt.view;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.JTextField;

public class ViewStart extends JPanel {
	private JTextField txtName;
	private JTextField txtTarget;
	private JTextField txtStart;
	private JTextField txtEnd;
	private JTextField txtInfo5;
	private JTextField txtInfo6;

	/**
	 * Create the panel.
	 */
	public ViewStart() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel pnlButtons = new JPanel();
		add(pnlButtons, BorderLayout.WEST);
		pnlButtons.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnNewJourney = new JButton("Neue Reise");
		pnlButtons.add(btnNewJourney);
		
		JButton btnShow = new JButton("Anzeigen");
		pnlButtons.add(btnShow);
		
		JButton btnSearch = new JButton("Suchen");
		pnlButtons.add(btnSearch);
		
		JPanel pnlList = new JPanel();
		add(pnlList, BorderLayout.CENTER);
		pnlList.setLayout(new GridLayout(2, 1, 0, 0));
		
		JList lstJourneys = new JList();
		pnlList.add(lstJourneys);
		
		JPanel pnlInfos = new JPanel();
		pnlList.add(pnlInfos);
		
		JLabel lblHeader = new JLabel("Reiseinfos:");
		lblHeader.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JLabel lblName = new JLabel("Name:");
		
		JLabel lblTarget = new JLabel("Ziel:");
		
		JLabel lblStart = new JLabel("Beginn:");
		
		JLabel lblEnd = new JLabel("Ende:");
		
		JLabel lblInfo5 = new JLabel("Info 5:");
		
		JLabel lblInfo6 = new JLabel("Info 6:");
		
		txtName = new JTextField();
		txtName.setColumns(10);
		
		txtTarget = new JTextField();
		txtTarget.setColumns(10);
		
		txtStart = new JTextField();
		txtStart.setColumns(10);
		
		txtEnd = new JTextField();
		txtEnd.setColumns(10);
		
		txtInfo5 = new JTextField();
		txtInfo5.setColumns(10);
		
		txtInfo6 = new JTextField();
		txtInfo6.setColumns(10);
		GroupLayout gl_pnlInfos = new GroupLayout(pnlInfos);
		gl_pnlInfos.setHorizontalGroup(
			gl_pnlInfos.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlInfos.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnlInfos.createParallelGroup(Alignment.LEADING)
						.addComponent(lblHeader)
						.addGroup(gl_pnlInfos.createSequentialGroup()
							.addGroup(gl_pnlInfos.createParallelGroup(Alignment.LEADING)
								.addComponent(lblName)
								.addComponent(lblTarget)
								.addComponent(lblStart)
								.addComponent(lblEnd)
								.addComponent(lblInfo5)
								.addComponent(lblInfo6))
							.addGap(18)
							.addGroup(gl_pnlInfos.createParallelGroup(Alignment.LEADING)
								.addComponent(txtStart, GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
								.addComponent(txtTarget, GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
								.addComponent(txtName, GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
								.addComponent(txtEnd, GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
								.addComponent(txtInfo5, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
								.addComponent(txtInfo6, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE))))
					.addContainerGap())
		);
		gl_pnlInfos.setVerticalGroup(
			gl_pnlInfos.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlInfos.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblHeader)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_pnlInfos.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblName)
						.addComponent(txtName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_pnlInfos.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTarget)
						.addComponent(txtTarget, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_pnlInfos.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblStart)
						.addComponent(txtStart, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_pnlInfos.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEnd)
						.addComponent(txtEnd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_pnlInfos.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblInfo5)
						.addComponent(txtInfo5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_pnlInfos.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblInfo6)
						.addComponent(txtInfo6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(37, Short.MAX_VALUE))
		);
		pnlInfos.setLayout(gl_pnlInfos);

	}
}
