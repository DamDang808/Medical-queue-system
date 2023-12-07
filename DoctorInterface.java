/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author ADMIN
 */
public class DoctorInterface extends JFrame {

    /**
     * Creates new form NewJFrame
     */
    private DefaultTableModel diagnosedPatientsModel;

    public DoctorInterface() {
        this.diagnosedPatientsModel = new DefaultTableModel();
        initializeDiagnosedPatientsTable();
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new JScrollPane();
        jTextArea1 = new JTextArea();
        jPanel1 = new JPanel();
        jPanel2 = new JPanel();
        jPanel3 = new JPanel();
        Doctor = new JPanel();
        jButton1 = new JButton();
        jButton2 = new JButton();
        jButton3 = new JButton();
        jButton4 = new JButton();
        jButton5 = new JButton();
        jButton6 = new JButton();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jButton1.setIcon(new ImageIcon("mediqueue\\icons8-test-results-100.png")); // NOI18N
        jButton1.setText("Danh sách bệnh nhân đang chờ khám");
        jButton1.addActionListener(this::jButton1ActionPerformed);

        jButton2.setIcon(new ImageIcon("mediqueue\\img1.icons8.png")); // NOI18N
        jButton2.setText("Chấn đoán cho bệnh nhân đã khám xong");
        jButton2.addItemListener(this::jButton2ItemStateChanged);
        jButton2.addActionListener(this::jButton2ActionPerformed);

        jButton3.setIcon(new ImageIcon("mediqueue\\icons8-prescription-64.png")); // NOI18N
        jButton3.setText("Kê đơn thuốc cho bệnh nhân");
        jButton3.addActionListener(this::jButton3ActionPerformed);

        jButton4.setIcon(new ImageIcon("mediqueue\\OIP.jpg")); // NOI18N
        jButton4.setText("Chuyển bệnh nhân đi xét nghiệm hoặc chuyển qua chuyên khoa khác");
        jButton4.addActionListener(this::jButton4ActionPerformed);

        jButton5.setIcon(new ImageIcon("mediqueue\\icons8-todo-list-48.png")); // NOI18N
        jButton5.setText("Danh sách bệnh nhân đã khám xong");
        jButton5.addActionListener(this::jButton5ActionPerformed);

        jButton6.setIcon(new ImageIcon("mediqueue\\icons8-exit-100.png")); // NOI18N
        jButton6.setText("Thoát");
        jButton6.addActionListener(this::jButton6ActionPerformed);

        GroupLayout DoctorLayout = new GroupLayout(Doctor);
        Doctor.setLayout(DoctorLayout);
        DoctorLayout.setHorizontalGroup(
            DoctorLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(DoctorLayout.createSequentialGroup()
                .addGroup(DoctorLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(DoctorLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(DoctorLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addComponent(jButton2)
                            .addComponent(jButton6)))
                    .addGroup(DoctorLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton3))
                    .addGroup(DoctorLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton5))
                    .addGroup(DoctorLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton4)))
                .addGap(475, 475, 475))
        );
        DoctorLayout.setVerticalGroup(
            DoctorLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(DoctorLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(jButton2)
                .addGap(56, 56, 56)
                .addComponent(jButton4)
                .addGap(47, 47, 47)
                .addComponent(jButton5)
                .addGap(41, 41, 41)
                .addComponent(jButton3)
                .addGap(53, 53, 53)
                .addComponent(jButton6, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Doctor, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Doctor, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        Doctor.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        prescribeMedicineToPatient();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        showPatientsWaitingTable();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        String diagnosis = JOptionPane.showInputDialog(this, "Nhập chẩn đoán cho bệnh nhân đã khám xong:");
        if (diagnosis != null && !diagnosis.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Chẩn đoán của bệnh nhân: " + diagnosis, "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Chưa nhập chẩn đoán!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        transferPatientToAnotherDepartment();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        showDiagnosedPatientsTable();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        int option = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn thoát?", "Xác nhận", JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton2ItemStateChanged(ItemEvent evt) {//GEN-FIRST:event_jButton2ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ItemStateChanged

    private void initializeDiagnosedPatientsTable() {
        diagnosedPatientsModel.addColumn("Số thứ tự");
        diagnosedPatientsModel.addColumn("Họ tên");
        diagnosedPatientsModel.addColumn("Tuổi");
        diagnosedPatientsModel.addColumn("Giới tính");
        diagnosedPatientsModel.addColumn("Chẩn đoán");
    }

//    private void search1(String text) {
//        // Lọc dữ liệu dựa trên nội dung tìm kiếm
//        List<Object[]> filteredData = new ArrayList<>();
//        for (int i = 0; i < diagnosedPatientsModel.getRowCount(); i++) {
//            boolean found = false;
//            for (int j = 0; j < diagnosedPatientsModel.getColumnCount(); j++) {
//                Object cellValue = diagnosedPatientsModel.getValueAt(i, j);
//                if (cellValue != null && cellValue.toString().toLowerCase().contains(text.toLowerCase())) {
//                    found = true;
//                    break;
//                }
//            }
//            if (found) {
//                Object[] rowData = new Object[diagnosedPatientsModel.getColumnCount()];
//                for (int k = 0; k < diagnosedPatientsModel.getColumnCount(); k++) {
//                    rowData[k] = diagnosedPatientsModel.getValueAt(i, k);
//                }
//                filteredData.add(rowData);
//            }
//        }
//
//        // Xóa hết dữ liệu hiện tại trên JTable
//        while (diagnosedPatientsModel.getRowCount() > 0) {
//            diagnosedPatientsModel.removeRow(0);
//        }
//
//        // Thêm lại dữ liệu đã lọc vào JTable
//        filteredData.forEach(diagnosedPatientsModel::addRow);
//    }
    private void showDiagnosedPatientsTable() {
        JTable diagnosedPatientsTable = new JTable(diagnosedPatientsModel);
        JScrollPane scrollPane = new JScrollPane(diagnosedPatientsTable);

        JTextField searchField = new JTextField(20);
        searchField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                search(searchField.getText(), diagnosedPatientsTable);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                search(searchField.getText(), diagnosedPatientsTable);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                search(searchField.getText(), diagnosedPatientsTable);
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Tìm kiếm: "));
        panel.add(searchField);
        panel.add(scrollPane);

        JOptionPane.showMessageDialog(this, panel, "Danh sách bệnh nhân đã khám xong", JOptionPane.PLAIN_MESSAGE);
    }

    private void showPatientsWaitingTable() {

        String[] columnNames = {"Số thứ tự", "Họ tên bệnh nhân","Số điện thoại", "Tuổi", "Giới tính", "Địa chỉ",  "Tình trạng bệnh", "Ngày khám"};
        JTable table = new JTable(0, columnNames.length);
        DefaultTableModel model = new DefaultTableModel(new Object[][]{}, columnNames);
        table.setAutoCreateRowSorter(true);
        table.setModel(model);

        try {
            Reader reader = Files.newBufferedReader(Paths.get("data.csv"));

            // create csv reader
            CSVReader csvReader = new CSVReader(reader);

            // read all records at once
            List<String[]> records = csvReader.readAll();
            LocalDate date = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            for (String[] data : records) {
                String[] row = new String[]{data[0], data[1], data[2], data[3], data[4], data[5], data[6], date.format(formatter)};
                model.addRow(row);
            }
            reader.close();
        } catch (IOException | CsvException e) {
            throw new RuntimeException(e);
        }

        JScrollPane scrollPane = new JScrollPane(table);

        JTextField searchField = new JTextField(20);
        searchField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                search(searchField.getText(), table);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                search(searchField.getText(), table);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                search(searchField.getText(), table);
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Tìm kiếm: "));
        panel.add(searchField);
        panel.add(scrollPane);

        JOptionPane.showMessageDialog(this, panel, "Danh sách bệnh nhân đang chờ khám", JOptionPane.PLAIN_MESSAGE);
    }

    private void prescribeMedicineToPatient() {
        // Ví dụ danh sách bệnh nhân đã khám
        String[] diagnosedPatients = {"Bệnh nhân A", "Bệnh nhân B", "Bệnh nhân C"}; // Thay thế bằng danh sách bệnh nhân đã khám thực tế

        boolean isPrescriptionGiven = false;

        // Kiểm tra xem còn bệnh nhân đã khám nào chưa được kê đơn thuốc
        for (String patient : diagnosedPatients) {
            // Xử lý logic kiểm tra xem bệnh nhân đã được kê đơn thuốc hay chưa, ví dụ sử dụng một danh sách bệnh nhân đã kê đơn
            // Nếu bệnh nhân chưa được kê đơn thuốc
            if (!isPrescriptionGiven) {
                // Hiển thị danh sách bệnh nhân đã khám cho người dùng chọn
                String selectedDiagnosedPatient = (String) JOptionPane.showInputDialog(
                        this, "Chọn bệnh nhân đã khám:",
                        "Danh sách bệnh nhân đã khám",
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        diagnosedPatients,
                        diagnosedPatients[0]
                );

                if (selectedDiagnosedPatient != null) {
                    // Người dùng đã chọn một bệnh nhân đã khám, tiếp tục nhập đơn thuốc
                    String prescription = JOptionPane.showInputDialog(this, "Nhập đơn thuốc cho " + selectedDiagnosedPatient + ":");
                    if (prescription != null && !prescription.isEmpty()) {
                        JOptionPane.showMessageDialog(this, "Đã nhập đơn thuốc cho " + selectedDiagnosedPatient + ": " + prescription, "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                        // Lưu thông tin đơn thuốc vào cơ sở dữ liệu hoặc xử lý theo ý bạn
                        isPrescriptionGiven = true; // Đã kê đơn thuốc cho ít nhất một bệnh nhân
                    } else {
                        JOptionPane.showMessageDialog(this, "Chưa nhập đơn thuốc!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Thoát khỏi việc kê đơn thuốc.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                return;
                }
            }
        }

        // Kiểm tra xem đã kê đơn thuốc cho tất cả bệnh nhân đã khám hay chưa
        if (!isPrescriptionGiven) {
            JOptionPane.showMessageDialog(this, "Không còn bệnh nhân nào cần kê đơn thuốc.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    private void transferPatientToAnotherDepartment() {
    // Ví dụ danh sách bệnh nhân đã khám
    String[] diagnosedPatients = {"Bệnh nhân A", "Bệnh nhân B", "Bệnh nhân C"}; // Thay thế bằng danh sách bệnh nhân đã khám thực tế

    boolean isTransferred = false;

    // Kiểm tra xem còn bệnh nhân đã khám nào chưa được chuyển sang khoa khác
    for (String patient : diagnosedPatients) {
        // Xử lý logic kiểm tra xem bệnh nhân đã được chuyển khoa khác hay chưa, ví dụ sử dụng một danh sách bệnh nhân đã chuyển khoa khác
        // Nếu bệnh nhân chưa được chuyển khoa khác
        if (!isTransferred) {
            // Hiển thị danh sách bệnh nhân đã khám để người dùng chọn bệnh nhân muốn chuyển
            String selectedDiagnosedPatient = (String) JOptionPane.showInputDialog(
                this, "Chọn bệnh nhân đã khám:",
                "Danh sách bệnh nhân đã khám",
                JOptionPane.PLAIN_MESSAGE,
                null,
                diagnosedPatients,
                diagnosedPatients[0]
            );

            if (selectedDiagnosedPatient != null) {
                // Người dùng đã chọn một bệnh nhân đã khám, tiếp tục chuyển bệnh nhân sang khoa khác
                String department = JOptionPane.showInputDialog(this, "Nhập tên khoa muốn chuyển bệnh nhân đến:");
                if (department != null && !department.isEmpty()) {
                    // Xử lý chuyển bệnh nhân sang khoa khác
                    // sendToOtherDepartment(department, selectedDiagnosedPatient); // Phương thức này chuyển bệnh nhân sang khoa khác
                    JOptionPane.showMessageDialog(this, "Đã chuyển bệnh nhân " + selectedDiagnosedPatient + " đến khoa " + department, "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    isTransferred = true; // Đã chuyển bệnh nhân thành công
                } else {
                    JOptionPane.showMessageDialog(this, "Chưa nhập tên khoa!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                // Người dùng không chọn bệnh nhân đã khám hoặc ấn X
                JOptionPane.showMessageDialog(this, "Thoát khỏi việc chuyển bệnh nhân.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                return; // Thoát ra khỏi phương thức khi người dùng không chọn bệnh nhân hoặc ấn X
            }
        }
    }

    // Kiểm tra xem đã chuyển bệnh nhân cho tất cả bệnh nhân đã khám hay chưa
    if (!isTransferred) {
        JOptionPane.showMessageDialog(this, "Không còn bệnh nhân nào cần chuyển khoa.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
    }
}
//    private void diagnoseLatestPatient(Doctor doctor) {
//    Patient latestPatient = doctor.getLatestPatient();
//    if (latestPatient != null) {
//        String patientName = latestPatient.getName();
//        String diagnosis = JOptionPane.showInputDialog(doctor, "Nhập chẩn đoán cho bệnh nhân " + patientName + ":");
//        if (diagnosis != null && !diagnosis.isEmpty()) {
//            PatientVisit patientVisit = new PatientVisit(patientName, diagnosis);
//            doctor.setLatestPatientVisit(patientVisit);
//            JOptionPane.showMessageDialog(doctor, "Chẩn đoán của bệnh nhân " + patientName + ": " + diagnosis, "Thông báo", JOptionPane.INFORMATION_MESSAGE);
//        } else {
//            JOptionPane.showMessageDialog(doctor, "Chưa nhập chẩn đoán!", "Lỗi", JOptionPane.ERROR_MESSAGE);
//        }
//    } else {
//        JOptionPane.showMessageDialog(doctor, "Không có bệnh nhân nào được chọn!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
//    }
//}


    private void search(String text, JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        table.setRowSorter(sorter);
        sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                 UnsupportedLookAndFeelException ex) {
            Logger.getLogger(DoctorInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        EventQueue.invokeLater(() -> new DoctorInterface().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JPanel Doctor;
    private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;
    private JButton jButton4;
    private JButton jButton5;
    private JButton jButton6;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JScrollPane jScrollPane1;
    private JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}