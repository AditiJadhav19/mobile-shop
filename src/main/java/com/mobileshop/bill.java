package com.mobileshop;

import java.awt.*;
import java.awt.event.*;
import java.awt.Desktop;
import javax.swing.*;
import java.applet.*;
import java.sql.*;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.border.TitledBorder;
import java.awt.Component;
import java.awt.Container;
import java.awt.print.*;
import java.awt.Toolkit;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.File;
import com.itextpdf.text.Image;
import java.io.*;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

public class bill extends JFrame implements ActionListener {
    JButton b1;
    JLabel l1, l2, l3, l4, l5, l6;
    JTextField t1, t2, t3, t4, t5, t6;

    public bill() {
        initComponent();
    }

    public void initComponent() {
        setVisible(true);
        setSize(400, 500);
        setLayout(null);

        l1 = new JLabel("Repair No:");
        l2 = new JLabel("Device Model:");
        l3 = new JLabel("Serial No:");
        l4 = new JLabel("Price:");
        l5 = new JLabel("Amount:");
        l6 = new JLabel("Due:");

        t1 = new JTextField();
        t2 = new JTextField();
        t3 = new JTextField();
        t4 = new JTextField();
        t5 = new JTextField();
        t6 = new JTextField();

        b1 = new JButton("Generate Bill");

        l1.setBounds(50, 50, 100, 30);
        l2.setBounds(50, 100, 100, 30);
        l3.setBounds(50, 150, 100, 30);
        l4.setBounds(50, 200, 100, 30);
        l5.setBounds(50, 250, 100, 30);
        l6.setBounds(50, 300, 100, 30);

        t1.setBounds(150, 50, 200, 30);
        t2.setBounds(150, 100, 200, 30);
        t3.setBounds(150, 150, 200, 30);
        t4.setBounds(150, 200, 200, 30);
        t5.setBounds(150, 250, 200, 30);
        t6.setBounds(150, 300, 200, 30);

        b1.setBounds(150, 350, 200, 30);

        add(l1);
        add(l2);
        add(l3);
        add(l4);
        add(l5);
        add(l6);
        add(t1);
        add(t2);
        add(t3);
        add(t4);
        add(t5);
        add(t6);
        add(b1);

        b1.addActionListener(this);
    }

    public void actionPerformed(ActionEvent ae) {
        String s = ae.getActionCommand();
        if (s.equals("Generate Bill")) {
            try {
                Document dc = new Document();
                PdfWriter.getInstance(dc, new FileOutputStream("/pdfs/bill.pdf"));
                dc.open();
                PdfPTable tb = new PdfPTable(2);
                PdfPCell tc;

                tc = new PdfPCell(new Phrase("Repair No:"));
                tb.addCell(tc);
                tc = new PdfPCell(new Phrase(t1.getText()));
                tb.addCell(tc);

                tc = new PdfPCell(new Phrase("Device Model:"));
                tb.addCell(tc);
                tc = new PdfPCell(new Phrase(t2.getText()));
                tb.addCell(tc);

                tc = new PdfPCell(new Phrase("Serial No:"));
                tb.addCell(tc);
                tc = new PdfPCell(new Phrase(t3.getText()));
                tb.addCell(tc);

                tc = new PdfPCell(new Phrase("Price:"));
                tb.addCell(tc);
                tc = new PdfPCell(new Phrase(t4.getText()));
                tb.addCell(tc);

                tc = new PdfPCell(new Phrase("Amount:"));
                tb.addCell(tc);
                tc = new PdfPCell(new Phrase(t5.getText()));
                tb.addCell(tc);

                tc = new PdfPCell(new Phrase("Due:"));
                tb.addCell(tc);
                tc = new PdfPCell(new Phrase(t6.getText()));
                tb.addCell(tc);

                dc.add(tb);
                dc.close();
                JOptionPane.showMessageDialog(this, "PDF generated successfully!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new bill();
    }
}