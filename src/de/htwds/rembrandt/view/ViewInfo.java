package de.htwds.rembrandt.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Toolkit;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import java.awt.Font;
import javax.swing.SwingConstants;

public class ViewInfo extends JFrame {

	public static final String PURPOSE_1 = 	"Diese Software wurde für eine Vorlesung an der HTW";
	public static final String PURPOSE_2 =	"als Prüfungsleistung erstellt.";
	public static final String INFO_1 =		"Informationen finden Sie unter GoogleCodes:";
	public static final String INFO_2 =		"https://code.google.com/p/rembrandt-travel-journal/";
	
	private JPanel contentPane;
	private JLabel lblLogo;
	private ImageIcon htwLogo;
	private JPanel panelHeader;
	private JPanel panelCenter;
	private JLabel lblPurpose;
	private JLabel lblPurposeTwo;
	private JLabel lblInfoOne;
	private JLabel lblInfoTwo;
	private JLabel lblEmptyOne;
	private JLabel lblEmptyTwo;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ViewInfo frame = new ViewInfo();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public ViewInfo( ViewWrapperWindow viewWrapper ) {
		
		setLocationRelativeTo( viewWrapper );
		
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(ViewInfo.class.getResource("/de/htwds/rembrandt/resources/images/Info.png")));
		setTitle("Info");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 330);
		this.contentPane = new JPanel();
		this.contentPane.setBackground(Color.WHITE);
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(this.contentPane);
		
		this.panelHeader = new JPanel();
		this.panelHeader.setBackground(Color.WHITE);
		this.contentPane.add(this.panelHeader, BorderLayout.NORTH);
		
		htwLogo = new ImageIcon(ViewInfo.class.getResource("/de/htwds/rembrandt/resources/images/htw-logo.jpg"));
		htwLogo.setImage( htwLogo.getImage().getScaledInstance( 400, 82, Image.SCALE_DEFAULT ) );
		
		this.lblLogo = new JLabel("");
		this.lblLogo.setIcon( htwLogo );
		this.panelHeader.add(this.lblLogo);
		
		this.panelCenter = new JPanel();
		this.panelCenter.setBackground(Color.WHITE);
		this.contentPane.add(this.panelCenter, BorderLayout.CENTER);
		this.panelCenter.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("center:default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		this.lblEmptyOne = new JLabel(" ");
		this.lblEmptyOne.setFont(new Font("Arial", Font.BOLD, 20));
		this.panelCenter.add(this.lblEmptyOne, "4, 2");
		
		this.lblPurpose = new JLabel( PURPOSE_1 );
		this.lblPurpose.setHorizontalAlignment(SwingConstants.CENTER);
		this.lblPurpose.setFont(new Font("Arial", Font.BOLD, 13));
		this.panelCenter.add(this.lblPurpose, "4, 4");
		
		this.lblPurposeTwo = new JLabel( PURPOSE_2 );
		this.lblPurposeTwo.setFont(new Font("Arial", Font.BOLD, 13));
		this.lblPurposeTwo.setHorizontalAlignment(SwingConstants.CENTER);
		this.panelCenter.add(this.lblPurposeTwo, "4, 6");
		
		this.lblEmptyTwo = new JLabel(" ");
		this.lblEmptyTwo.setFont(new Font("Arial", Font.BOLD, 20));
		this.panelCenter.add(this.lblEmptyTwo, "4, 8");
		
		this.lblInfoOne = new JLabel( INFO_1 );
		this.lblInfoOne.setFont(new Font("Arial", Font.BOLD, 13));
		this.lblInfoOne.setHorizontalAlignment(SwingConstants.CENTER);
		this.panelCenter.add(this.lblInfoOne, "4, 10");
		
		this.lblInfoTwo = new JLabel( INFO_2 );
		this.lblInfoTwo.setFont(new Font("Arial", Font.BOLD, 13));
		this.panelCenter.add(this.lblInfoTwo, "4, 12");
	}

}
