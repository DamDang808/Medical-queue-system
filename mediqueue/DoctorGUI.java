/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mediqueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author ADMIN
 */
public class DoctorGUI extends JFrame {
    private JLabel lblPatientName, lblPatientAge, lblPatientCondition;
    private JTextArea txtDiagnosis;
    private JButton btnPrescribeMedication, btnSendToLab;

    public DoctorGUI() {
        super("Giao diện bác sĩ");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        // Khởi tạo các thành phần giao diện
        lblPatientName = new JLabel("Tên bệnh nhân: ");
        lblPatientAge = new JLabel("Tuổi: ");
        lblPatientCondition = new JLabel("Tình trạng: ");

        txtDiagnosis = new JTextArea(10, 30);
        JScrollPane scrollPane = new JScrollPane(txtDiagnosis);

        btnPrescribeMedication = new JButton("Kê đơn thuốc");
        btnSendToLab = new JButton("Gửi bệnh nhân tới phòng xét nghiệm");

        // Xếp các thành phần vào giao diện
        JPanel panel = new JPanel();
        panel.add(lblPatientName);
        panel.add(lblPatientAge);
        panel.add(lblPatientCondition);
        panel.add(scrollPane);
        panel.add(btnPrescribeMedication);
        panel.add(btnSendToLab);

        add(panel);
        setVisible(true);
    }

    public void receivePatientInfo(String patientName, int patientAge, String patientCondition) {
        lblPatientName.setText("Tên bệnh nhân: " + patientName);
        lblPatientAge.setText("Tuổi: " + patientAge);
        lblPatientCondition.setText("Tình trạng: " + patientCondition);
    }
}
