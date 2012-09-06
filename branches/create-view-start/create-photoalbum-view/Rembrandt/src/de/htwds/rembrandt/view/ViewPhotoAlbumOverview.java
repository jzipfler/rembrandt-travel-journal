package de.htwds.rembrandt.view;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.Font;

/**
 * Photo Album View
 * Overview
 * 
 * @author sFey
 */
public class ViewPhotoAlbumOverview extends JPanel {

    private static final long serialVersionUID = 1L;

    public ViewPhotoAlbumOverview() {
        setLayout(new BorderLayout(0, 0));
        
        JPanel pnlImageArea = new JPanel();
        pnlImageArea.setBackground(Color.LIGHT_GRAY);
        add(pnlImageArea, BorderLayout.CENTER);
        pnlImageArea.setLayout(new GridLayout(0, 5, 5, 0));
        
        JLabel lblPhoto1 = new JLabel("1");
        lblPhoto1.setFont(new Font("Arial", Font.PLAIN, 13));
        lblPhoto1.setBackground(Color.WHITE);
        lblPhoto1.setForeground(Color.BLACK);
        pnlImageArea.add(lblPhoto1);
        
        JLabel lblPhoto2 = new JLabel("2");
        lblPhoto2.setFont(new Font("Arial", Font.PLAIN, 13));
        pnlImageArea.add(lblPhoto2);
        
        JLabel lblPhoto3 = new JLabel("3");
        lblPhoto3.setFont(new Font("Arial", Font.PLAIN, 13));
        pnlImageArea.add(lblPhoto3);
        
        JLabel lblPhoto4 = new JLabel("4");
        lblPhoto4.setFont(new Font("Arial", Font.PLAIN, 13));
        pnlImageArea.add(lblPhoto4);
        
        JLabel lblPhoto5 = new JLabel("5");
        lblPhoto5.setFont(new Font("Arial", Font.PLAIN, 13));
        pnlImageArea.add(lblPhoto5);
        
        JLabel lblPhoto6 = new JLabel("6");
        lblPhoto6.setFont(new Font("Arial", Font.PLAIN, 13));
        pnlImageArea.add(lblPhoto6);
        
        JLabel lblPhoto7 = new JLabel("7");
        lblPhoto7.setFont(new Font("Arial", Font.PLAIN, 13));
        pnlImageArea.add(lblPhoto7);
        
        JLabel lblPhoto8 = new JLabel("8");
        lblPhoto8.setFont(new Font("Arial", Font.PLAIN, 13));
        pnlImageArea.add(lblPhoto8);
        
        JLabel lblPhoto9 = new JLabel("9");
        lblPhoto9.setFont(new Font("Arial", Font.PLAIN, 13));
        pnlImageArea.add(lblPhoto9);
        
        JLabel lblPhoto10 = new JLabel("10");
        lblPhoto10.setFont(new Font("Arial", Font.PLAIN, 13));
        pnlImageArea.add(lblPhoto10);
        
        JLabel lblPhoto11 = new JLabel("11");
        lblPhoto11.setFont(new Font("Arial", Font.PLAIN, 13));
        pnlImageArea.add(lblPhoto11);
        
        JLabel lblPhoto12 = new JLabel("12");
        lblPhoto12.setFont(new Font("Arial", Font.PLAIN, 13));
        pnlImageArea.add(lblPhoto12);
        
        JLabel lblPhoto13 = new JLabel("13");
        lblPhoto13.setFont(new Font("Arial", Font.PLAIN, 13));
        pnlImageArea.add(lblPhoto13);
        
        JLabel lblPhoto14 = new JLabel("14");
        lblPhoto14.setFont(new Font("Arial", Font.PLAIN, 13));
        pnlImageArea.add(lblPhoto14);
        
        JLabel lblPhoto15 = new JLabel("15");
        lblPhoto15.setFont(new Font("Arial", Font.PLAIN, 13));
        pnlImageArea.add(lblPhoto15);
        
        JLabel lblPhoto16 = new JLabel("16");
        lblPhoto16.setFont(new Font("Arial", Font.PLAIN, 13));
        pnlImageArea.add(lblPhoto16);
        
        JLabel lblPhoto17 = new JLabel("17");
        lblPhoto17.setFont(new Font("Arial", Font.PLAIN, 13));
        pnlImageArea.add(lblPhoto17);
        
        JLabel lblPhoto18 = new JLabel("18");
        lblPhoto18.setFont(new Font("Arial", Font.PLAIN, 13));
        pnlImageArea.add(lblPhoto18);
        
        JLabel lblPhoto19 = new JLabel("19");
        lblPhoto19.setFont(new Font("Arial", Font.PLAIN, 13));
        pnlImageArea.add(lblPhoto19);
        
        JLabel lblPhoto20 = new JLabel("20");
        lblPhoto20.setFont(new Font("Arial", Font.PLAIN, 13));
        pnlImageArea.add(lblPhoto20);
        
        JLabel lblPhoto21 = new JLabel("21");
        lblPhoto21.setFont(new Font("Arial", Font.PLAIN, 13));
        pnlImageArea.add(lblPhoto21);
        
        JLabel lblPhoto22 = new JLabel("22");
        lblPhoto22.setFont(new Font("Arial", Font.PLAIN, 13));
        pnlImageArea.add(lblPhoto22);
        
        JLabel lblPhoto23 = new JLabel("23");
        lblPhoto23.setFont(new Font("Arial", Font.PLAIN, 13));
        pnlImageArea.add(lblPhoto23);
        
        JLabel lblPhoto24 = new JLabel("24");
        lblPhoto24.setFont(new Font("Arial", Font.PLAIN, 13));
        pnlImageArea.add(lblPhoto24);
        
        JLabel lblPhoto25 = new JLabel("25");
        lblPhoto25.setFont(new Font("Arial", Font.PLAIN, 13));
        pnlImageArea.add(lblPhoto25);
        
        JPanel pnlNavigation = new JPanel();
        pnlNavigation.setMinimumSize(new Dimension(440,100));
        FlowLayout fl_pnlNavigation = (FlowLayout) pnlNavigation.getLayout();
        fl_pnlNavigation.setAlignOnBaseline(true);
        add(pnlNavigation, BorderLayout.SOUTH);
        
        JButton btnBack = new JButton("<<");
        btnBack.setFont(new Font("Arial", Font.PLAIN, 13));
        pnlNavigation.add(btnBack);
        
        JButton btnDetails = new JButton("details");
        btnDetails.setFont(new Font("Arial", Font.PLAIN, 13));
        pnlNavigation.add(btnDetails);
        
        JButton btnForward = new JButton(">>");
        btnForward.setFont(new Font("Arial", Font.PLAIN, 13));
        pnlNavigation.add(btnForward);
      

    }

}
