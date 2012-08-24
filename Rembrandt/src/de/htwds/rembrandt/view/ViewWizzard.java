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
import javax.swing.JSplitPane;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import java.awt.Rectangle;
import java.awt.Point;
import javax.swing.JTextField;

public class ViewWizzard extends JFrame {

	private JPanel pnlQuestionCards;
	private JTextField txtInputCountry;
	private JTextField txtInputCity;

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
		pnlViewContent.setLayout(new BorderLayout(0, 5));
		
		JLabel lblHeadLine = new JLabel("WILLKOMMEN");
		lblHeadLine.setSize(new Dimension(67, 17));
		lblHeadLine.setMaximumSize(new Dimension(67, 20));
		lblHeadLine.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeadLine.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblHeadLine.setFont(new Font("Tahoma", Font.BOLD, 14));
		pnlViewContent.add(lblHeadLine, BorderLayout.NORTH);
		
		JPanel pnlContainer = new JPanel();
		pnlViewContent.add(pnlContainer, BorderLayout.CENTER);
		pnlContainer.setLayout(new GridLayout(2, 0, 0, 0));
		
		JTextPane txtpnExplanation = new JTextPane();
		pnlContainer.add(txtpnExplanation);
		txtpnExplanation.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtpnExplanation.setSelectedTextColor(Color.BLACK);
		txtpnExplanation.setSelectionColor(Color.WHITE);
		txtpnExplanation.setText("Dieser Wizzard wird Ihnen helfen eine neue Reise anzulegen.\r\n\r\nDazu werden Ihnen verschiedene Fragen, ihre Reise betreffend gestellt. \r\nSie werden nach Ihrem:\r\n\r\n\t- Datum\r\n\t- Reiseland\r\n\t- Ort\r\n\t- usw.\r\n\r\ngefragt. \r\nDiese Angaben dienen ebenfalls dazu den Reiseeintrag sp\u00E4ter wieder zu finden. Daher sollten die Angaben m\u00F6glichst pr\u00E4zise sein.");
		txtpnExplanation.setEditable(false);
		
		JPanel pnlQuestion = new JPanel();
		pnlContainer.add(pnlQuestion);
		pnlQuestion.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(186dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(186dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblCountry = new JLabel("In welches Land reisen Sie?");
		pnlQuestion.add(lblCountry, "4, 4");
		
		JLabel lblCity = new JLabel("Name des Ortes Ihres Aufenthalts?");
		pnlQuestion.add(lblCity, "8, 4");
		
		txtInputCountry = new JTextField();
		pnlQuestion.add(txtInputCountry, "4, 6");
		txtInputCountry.setColumns(10);
		
		txtInputCity = new JTextField();
		pnlQuestion.add(txtInputCity, "8, 6, fill, default");
		txtInputCity.setColumns(10);
	}

}
