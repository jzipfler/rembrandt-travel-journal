package de.htwds.rembrandt.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.GridLayout;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Cursor;
import javax.swing.BoxLayout;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.Sizes;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import java.awt.Insets;
import javax.swing.SwingConstants;

public class ViewWizzard extends JFrame {

	private JPanel pnlQuestionCards;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewWizzard frame = new ViewWizzard();
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
	public ViewWizzard() {
		setTitle("Reise anlegen");
		setMinimumSize(new Dimension(640, 480));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 807, 497);
		pnlQuestionCards = new JPanel();
		pnlQuestionCards.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pnlQuestionCards);
		pnlQuestionCards.setLayout(new CardLayout(0, 0));
		
		JPanel pnlFirstView = new JPanel();
		pnlQuestionCards.add(pnlFirstView, "name_6546871643145");
		pnlFirstView.setLayout(new BorderLayout(0, 0));
		
		JPanel pnlNavigation = new JPanel();
		pnlNavigation.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		pnlFirstView.add(pnlNavigation, BorderLayout.SOUTH);
		pnlNavigation.setLayout(new FormLayout(new ColumnSpec[] {
				new ColumnSpec(ColumnSpec.FILL, Sizes.bounded(Sizes.PREFERRED, Sizes.constant("75px", true), Sizes.constant("75px", true)), 1),
				FormFactory.GROWING_BUTTON_COLSPEC,
				new ColumnSpec(ColumnSpec.FILL, Sizes.bounded(Sizes.PREFERRED, Sizes.constant("75px", true), Sizes.constant("75px", true)), 1),
				FormFactory.GROWING_BUTTON_COLSPEC,
				new ColumnSpec(ColumnSpec.FILL, Sizes.bounded(Sizes.PREFERRED, Sizes.constant("75px", true), Sizes.constant("75px", true)), 1),},
			new RowSpec[] {
				RowSpec.decode("23px"),}));
		
		JButton btnNext = new JButton("Weiter");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JButton btnExit = new JButton("Ende");
		pnlNavigation.add(btnExit, "2, 1");
		btnExit.setSize(new Dimension(80, 23));
		btnExit.setMaximumSize(new Dimension(80, 23));
		btnExit.setMinimumSize(new Dimension(80, 23));
		pnlNavigation.add(btnNext, "4, 1");
		btnNext.setSize(new Dimension(80, 23));
		btnNext.setMaximumSize(new Dimension(80, 23));
		btnNext.setMinimumSize(new Dimension(80, 23));
		
		JPanel pnlViewContent = new JPanel();
		pnlFirstView.add(pnlViewContent, BorderLayout.CENTER);
		pnlViewContent.setLayout(new BorderLayout(0, 0));
		
		JLabel lblHeadLine = new JLabel("WILLKOMMEN");
		lblHeadLine.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeadLine.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblHeadLine.setFont(new Font("Tahoma", Font.BOLD, 14));
		pnlViewContent.add(lblHeadLine, BorderLayout.NORTH);
		
		JLabel lblExplanationText = new JLabel("Dieser kleine Wizzard wird Ihnen helfen eine neue Reise anzulegen.");
		pnlViewContent.add(lblExplanationText);
	}

}
