/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author ADMIN
 */
public class DoctorItf extends JFrame {
    public DoctorItf() {
        this.setTitle("Doctor");
        this.setSize(900, 500);
        this.setLocationRelativeTo(null);
        
        ActionListener ac = new DoctorListener(this);
        JPanel buttonPanel = new JPanel();
        JPanel tablePanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        
        
        
        this.setVisible(true);
        
        
        JButton jButton1 = new JButton("Danh sách bệnh nhân đang chờ khám");
        jButton1.addActionListener(ac);
        JButton jButton2 = new JButton("Chấn đoán cho bệnh nhân đã khám xong");
        jButton2.addActionListener(ac);
        JButton jButton3 = new JButton("Kê đơn thuốc cho bệnh nhân");
        jButton3.addActionListener(ac);
        JButton jButton4 = new JButton("Chuyển bệnh nhân đi xét nghiệm hoặc chuyển qua chuyên khoa khác");
        jButton4.addActionListener(ac);
        JButton jButton5 = new JButton("Danh sách bệnh nhân đã khám xong");
        jButton5.addActionListener(ac);
        JButton jButton6 = new JButton("Thoát");
        jButton6.addActionListener(ac);
        
        
        buttonPanel.add(jButton1);
        buttonPanel.add(jButton2);
        buttonPanel.add(jButton3);
        buttonPanel.add(jButton4);
        buttonPanel.add(jButton5);
        buttonPanel.add(jButton6);
        
        this.add(buttonPanel, BorderLayout.WEST);
                
        
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
      
    }
  
}
