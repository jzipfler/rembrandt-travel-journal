package de.htwds.rembrandt.view;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import javax.swing.JTextArea;
import javax.swing.DropMode;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import net.miginfocom.swing.MigLayout;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.Font;

/**
 * Photo Album View
 * Details
 * 
 * @author sFey
 */
public class ViewPhotoAlbumDetails extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTextField txtFileName;
    private JTextField txtFileDate;
    private JTextField txtComment;

    public ViewPhotoAlbumDetails() {
        setLayout(new BorderLayout(0, 0));
        
        JPanel pnlPhotoArea = new JPanel();
        add(pnlPhotoArea, BorderLayout.CENTER);
        pnlPhotoArea.setLayout(new BorderLayout(0, 0));
        
        JButton btnPhotoBack = new JButton("<");
        btnPhotoBack.setFont(new Font("Arial", Font.PLAIN, 13));
        pnlPhotoArea.add(btnPhotoBack, BorderLayout.WEST);
        
        JButton btnPhotoForward = new JButton(">");
        btnPhotoForward.setFont(new Font("Arial", Font.PLAIN, 13));
        pnlPhotoArea.add(btnPhotoForward, BorderLayout.EAST);
        
        JLabel lblCurrentPhoto = new JLabel("current");
        lblCurrentPhoto.setFont(new Font("Arial", Font.PLAIN, 13));
        pnlPhotoArea.add(lblCurrentPhoto, BorderLayout.CENTER);
        
        JPanel pnlInformation = new JPanel();
        add(pnlInformation, BorderLayout.EAST);
        
        JLabel lblFileName = new JLabel("Name");
        lblFileName.setFont(new Font("Arial", Font.PLAIN, 13));
        
        txtFileName = new JTextField();
        txtFileName.setFont(new Font("Arial", Font.PLAIN, 13));
        txtFileName.setColumns(10);
        
        JLabel lblFileDate = new JLabel("Date");
        lblFileDate.setFont(new Font("Arial", Font.PLAIN, 13));
        
        txtFileDate = new JTextField();
        txtFileDate.setFont(new Font("Arial", Font.PLAIN, 13));
        txtFileDate.setColumns(10);
        
        JLabel lblComment = new JLabel("Comment");
        lblComment.setFont(new Font("Arial", Font.PLAIN, 13));
        pnlInformation.setLayout(new MigLayout("", "[87px,grow]", "[14px][20px][14px][20px][14px][22px,grow]"));
        pnlInformation.add(lblFileName, "cell 0 0,alignx left,aligny top");
        pnlInformation.add(txtFileName, "cell 0 1,alignx right,aligny top");
        pnlInformation.add(lblFileDate, "cell 0 2,alignx left,aligny top");
        pnlInformation.add(txtFileDate, "cell 0 3,alignx right,aligny top");
        pnlInformation.add(lblComment, "cell 0 4,alignx left,aligny top");
        
        JScrollPane spnComment = new JScrollPane();
        spnComment.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        pnlInformation.add(spnComment, "cell 0 5,growy");
        
        txtComment = new JTextField();
        txtComment.setFont(new Font("Arial", Font.PLAIN, 13));
        spnComment.setViewportView(txtComment);
        txtComment.setColumns(10);
        
        JPanel pnlThumbnail = new JPanel();
        add(pnlThumbnail, BorderLayout.SOUTH);
        pnlThumbnail.setLayout(new GridLayout(0, 8, 0, 0));
        
        JButton btnThumbnailBack = new JButton("<");
        btnThumbnailBack.setFont(new Font("Arial", Font.PLAIN, 13));
        pnlThumbnail.add(btnThumbnailBack);
        
        JLabel lblThumbnail1 = new JLabel("1");
        lblThumbnail1.setFont(new Font("Arial", Font.PLAIN, 13));
        pnlThumbnail.add(lblThumbnail1);
        
        JLabel lblThumbnail2 = new JLabel("2");
        lblThumbnail2.setFont(new Font("Arial", Font.PLAIN, 13));
        pnlThumbnail.add(lblThumbnail2);
        
        JLabel lblThumbnail3 = new JLabel("3");
        lblThumbnail3.setFont(new Font("Arial", Font.PLAIN, 13));
        pnlThumbnail.add(lblThumbnail3);
        
        JLabel lblThumbnail4 = new JLabel("4");
        lblThumbnail4.setFont(new Font("Arial", Font.PLAIN, 13));
        pnlThumbnail.add(lblThumbnail4);
        
        JLabel lblThumbnail5 = new JLabel("5");
        lblThumbnail5.setFont(new Font("Arial", Font.PLAIN, 13));
        pnlThumbnail.add(lblThumbnail5);
        
        JButton btnThumbnailForward = new JButton(">");
        btnThumbnailForward.setFont(new Font("Arial", Font.PLAIN, 13));
        pnlThumbnail.add(btnThumbnailForward);
        
        JButton btnOverview = new JButton("Overview");
        btnOverview.setFont(new Font("Arial", Font.PLAIN, 13));
        pnlThumbnail.add(btnOverview);

    }

}
