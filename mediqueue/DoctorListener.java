/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mediqueue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADMIN
 */
public class DoctorListener implements ActionListener {

    private Doctor doctor;
    private DefaultTableModel diagnosedPatientsModel;

    public DoctorListener(Doctor doctor) {
        this.doctor = doctor;
        this.diagnosedPatientsModel = new DefaultTableModel();
        initializeDiagnosedPatientsTable();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        String actionCommand = e.getActionCommand();

        switch (actionCommand) {
            case "Danh sách bệnh nhân đang chờ khám":
                
            JTable table = new JTable(0, 8);

            
            String[] columnNames = {"Số thứ tự", "Họ tên bệnh nhân", "Tuổi", "Giới tính", "Địa chỉ", "Số điện thoại", "Tình trạng bệnh", "Ngày khám"};
            table.setModel(new javax.swing.table.DefaultTableModel(new Object[][]{}, columnNames));

            
            JScrollPane scrollPane = new JScrollPane(table);

            
            JOptionPane.showMessageDialog(doctor, scrollPane, "Danh sách bệnh nhân đang chờ khám", JOptionPane.PLAIN_MESSAGE);
                break;
            case "Chấn đoán cho bệnh nhân đã khám xong":
                String diagnosis = JOptionPane.showInputDialog(doctor, "Nhập chẩn đoán cho bệnh nhân đã khám xong:");
                if (diagnosis != null && !diagnosis.isEmpty()) {
                    JOptionPane.showMessageDialog(doctor, "Chẩn đoán của bệnh nhân: " + diagnosis, "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(doctor, "Chưa nhập chẩn đoán!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
                break;
            case "Kê đơn thuốc cho bệnh nhân":
                String prescription = JOptionPane.showInputDialog(doctor, "Nhập đơn thuốc cho bệnh nhân:");
                if (prescription != null && !prescription.isEmpty()) {
                    JOptionPane.showMessageDialog(doctor, "Đơn thuốc cho bệnh nhân: " + prescription, "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(doctor, "Chưa nhập đơn thuốc!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
                break;
            case "Chuyển bệnh nhân đi xét nghiệm hoặc chuyển qua chuyên khoa khác":
                String department = JOptionPane.showInputDialog(doctor, "Nhập tên khoa muốn chuyển bệnh nhân đến:");
                if (department != null && !department.isEmpty()) {
                    String patientInfo = "Thông tin bệnh nhân: [Dữ liệu bệnh nhân]";
                 //   sendToOtherDoctor(department, patientInfo); // Gửi thông tin bệnh nhân đến bác sĩ khác
                    JOptionPane.showMessageDialog(doctor, "Đã gửi thông tin bệnh nhân đến khoa " + department, "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(doctor, "Chưa nhập tên khoa!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
                break;
            case "Danh sách bệnh nhân đã khám xong":
                // Hiển thị danh sách bệnh nhân đã chẩn đoán
                JTable diagnosedPatientsTable = new JTable(diagnosedPatientsModel);
                JScrollPane scrollPane1 = new JScrollPane(diagnosedPatientsTable);
                JOptionPane.showMessageDialog(doctor, scrollPane1, "Danh sách bệnh nhân đã khám xong", JOptionPane.PLAIN_MESSAGE);
                break;
            case "Thoát":
                int option = JOptionPane.showConfirmDialog(doctor, "Bạn có chắc muốn thoát?", "Xác nhận", JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }     
                break;
            default:
                break;
        }

    }
    private void initializeDiagnosedPatientsTable() {
        diagnosedPatientsModel.addColumn("Mã số");
        diagnosedPatientsModel.addColumn("Họ tên");
        diagnosedPatientsModel.addColumn("Tuổi");
        diagnosedPatientsModel.addColumn("Giới tính");
        diagnosedPatientsModel.addColumn("Chẩn đoán");
    }
}
