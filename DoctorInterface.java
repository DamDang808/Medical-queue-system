/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;
import net.miginfocom.swing.MigLayout;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
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
import javax.swing.table.*;

/**
 * @author ADMIN
 */
public class DoctorInterface extends JFrame {

    /**
     * Creates new form NewJFrame
     */
    // Variables declaration
    private JPanel doctor;
    private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;
    private JButton jButton4;
    private JButton jButton5;
    private JButton jButton6;
    private JButton newPatientButton;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JScrollPane jScrollPane1;
    private JTextArea jTextArea1;
    private Patient patient;
    private Queue<Patient> patientsWaiting = new LinkedList<>();
    private List<Patient> diagnosedPatients = new LinkedList<>();
    private String department;
    private String dataLocation;

    public DoctorInterface(String department) {
        UIManager.put("defaultFont", new Font(FlatRobotoFont.FAMILY, Font.PLAIN, 13));
        this.setTitle("Bác sĩ");
        this.department = department;
        switch (department) {
            case "Khoa Nội":
                dataLocation = "csv/khoanoi.csv";
                break;
            case "Khoa Ngoại":
                dataLocation = "csv/khoangoai.csv";
                break;
            case "Khoa Phụ sản":
                dataLocation = "csv/khoaphusan.csv";
                break;
            case "Khoa Tai-Mũi-Họng":
                dataLocation = "csv/khoataimuihong.csv";
                break;
            case "Khoa Hồi sức tích cực":
                dataLocation = "csv/khoahoisuctichcuc.csv";
                break;
            case "Khoa Răng-Hàm-Mặt":
                dataLocation = "csv/khoaranghammat.csv";
                break;
            case "Khoa Ung bướu":
                dataLocation = "csv/khoaungbuou.csv";
                break;
            case "Khoa Xương khớp":
                dataLocation = "csv/khoaxuongkhop.csv";
                break;
        }
        setSize(new Dimension(1200, 800));
        initComponents();
    }

    private void initComponents() {
        jScrollPane1 = new JScrollPane();

        jTextArea1 = new JTextArea();

        jPanel1 = new JPanel();
        jPanel2 = new JPanel();
        jPanel3 = new JPanel();
        doctor = new JPanel();

        jButton1 = new JButton();
        jButton2 = new JButton();
        jButton3 = new JButton();
        jButton4 = new JButton();
        jButton5 = new JButton();
        jButton6 = new JButton();

        newPatientButton = new JButton();

        jButton1.setIcon(changeImageSize("Interface-image/icons8-test-results-100.png"));
        jButton1.setText("Danh sách bệnh nhân đang chờ khám");
        jButton1.setFont(new Font("Segeo UI", Font.PLAIN, 18));
        jButton1.setPreferredSize(new Dimension(500, 80));
        jButton1.addActionListener(this::jButton1ActionPerformed);

        jButton2.setIcon(changeImageSize("Interface-image/img1.icons8.png"));
        jButton2.setText("Chấn đoán cho bệnh nhân đã khám xong");
        jButton2.setFont(new Font("Segeo UI", Font.PLAIN, 18));
        jButton2.setPreferredSize(new Dimension(500, 80));
        jButton2.addActionListener(this::jButton2ActionPerformed);

        jButton3.setIcon(changeImageSize("Interface-image/icons8-prescription-64.png"));
        jButton3.setText("Kê đơn thuốc cho bệnh nhân");
        jButton3.setFont(new Font("Segeo UI", Font.PLAIN, 18));
        jButton3.setPreferredSize(new Dimension(500, 80));
        jButton3.addActionListener(this::jButton3ActionPerformed);

        jButton4.setIcon(changeImageSize("Interface-image/OIP.jpg"));
        jButton4.setText("Chuyển bệnh nhân sang khoa khác");
        jButton4.setFont(new Font("Segeo UI", Font.PLAIN, 18));
        jButton4.setPreferredSize(new Dimension(500, 80));
        jButton4.addActionListener(this::jButton4ActionPerformed);

        jButton5.setIcon(changeImageSize("Interface-image/icons8-todo-list-48.png"));
        jButton5.setText("Danh sách bệnh nhân đã khám xong");
        jButton5.setFont(new Font("Segeo UI", Font.PLAIN, 18));
        jButton5.setPreferredSize(new Dimension(500, 80));
        jButton5.addActionListener(this::jButton5ActionPerformed);

        jButton6.setIcon(changeImageSize("Interface-image/icons8-exit-100.png"));
        jButton6.setText("Thoát");
        jButton6.setFont(new Font("Segeo UI", Font.PLAIN, 18));
        jButton6.setPreferredSize(new Dimension(500, 80));
        jButton6.addActionListener(this::jButton6ActionPerformed);

        newPatientButton.setText("Gọi bệnh nhân mới");
        newPatientButton.setFont(new Font("Segeo UI", Font.PLAIN, 18));
        newPatientButton.setPreferredSize(new Dimension(500, 80));
        newPatientButton.addActionListener(this::newPatientButtonActionPerformed);

        setLayout(new MigLayout("fill,insets 20", "[center]", "[center]"));
        JPanel panel = new JPanel(new MigLayout("wrap,fillx,insets 35 45 30 45", "[fill,360]"));

        panel.add(jButton1, "split 2");
        panel.add(newPatientButton, "gapy 8");
        panel.add(jButton2, "gapy 8");
        panel.add(jButton3, "gapy 8");
        panel.add(jButton4, "gapy 8");
        panel.add(jButton5, "gapy 8");
        panel.add(jButton6, "gapy 8");

        add(panel);
    }

    private void newPatientButtonActionPerformed(ActionEvent actionEvent) {
        // TODO add your handling code here:
        patient = patientsWaiting.peek();
        String anouncement;
        if (patient != null) {
            anouncement = "Số " + patient.getID() + " Bệnh nhân " + patient.getName() + " vào khám";
        } else {
            anouncement = "Không có bệnh nhân nào đang chờ khám";
        }
        new TextToSpeech().speak(anouncement);
    }

    private void jButton1ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        showPatientsWaitingTable();
    }

    private void jButton2ActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
        patient = patientsWaiting.peek();
        if (patient == null) {
            JOptionPane.showMessageDialog(this, "Không có bệnh nhân nào đang chờ khám!",
                    "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        String diagnosis = "";
        JTextArea ta = new JTextArea(20, 20);
        if (JOptionPane.showConfirmDialog(null, new JScrollPane(ta),
                "Nhập chẩn đoán cho bệnh nhân " + patient.getName(), JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
            diagnosis = ta.getText();
        }
        if (diagnosis != null && !diagnosis.isEmpty()) {
            patient.setDoctorsDiagnosis(diagnosis);
            diagnosedPatients.add(patient);
            patientsWaiting.poll();
            deleteFirstRowInCSV(dataLocation);
            String[] data = {patient.getID(), patient.getName(), patient.getPhone(), patient.getAge(),
                    patient.getGender(), patient.getAddress(), patient.getDoctorsDiagnosis(), patient.getMedicine()};
            writeToCSV(data, "csv/diagnosed.csv");
            JOptionPane.showMessageDialog(this, "Chẩn đoán của bệnh nhân: " + diagnosis,
                    "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        } else {
            patient = null;
            JOptionPane.showMessageDialog(this, "Chưa nhập chẩn đoán!",
                    "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void jButton3ActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
        prescribeMedicineToPatient();
    }


    private void jButton4ActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
        transferPatientToAnotherDepartment();
    }

    private void jButton5ActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
        showDiagnosedPatientsTable();
    }

    private void jButton6ActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
        int option = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn thoát?",
                "Xác nhận", JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {
            this.setVisible(false);
        }
    }

    private void showPatientsWaitingTable() {
        String[] columnNames = {"Số thứ tự", "Họ tên bệnh nhân", "Số điện thoại", "Tuổi", "Giới tính", "Địa chỉ",
                "Tình trạng bệnh", "Thuốc đang sử dụng", "Ngày khám"};
        JTable table = new JTable(0, columnNames.length);
        DefaultTableModel model = new DefaultTableModel(new Object[][]{}, columnNames);
        table.setAutoCreateRowSorter(true);
        table.setModel(model);

        patientsWaiting.clear();
        // Thêm dữ liệu từ file csv vào bảng
        try {
            Reader reader = Files.newBufferedReader(Paths.get(dataLocation));
            // create csv reader
            CSVReader csvReader = new CSVReader(reader);
            // read all records at once
            List<String[]> records = csvReader.readAll();
            // Get today's date
            LocalDate date = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            boolean firstRow = true;
            // Import data from CSV file to table
            for (String[] data : records) {
                if (firstRow) {
                    firstRow = false;
                    continue;
                }
                String[] row = new String[]{data[0], data[1], data[2], data[3], data[4], data[5], data[6], "", date.format(formatter)};
                Patient patient = new Patient(data[0], data[1], data[2], data[3], data[4], data[5], data[6]);
                model.addRow(row);
                patientsWaiting.add(patient);
            }
            reader.close();
        } catch (IOException | CsvException e) {
            throw new RuntimeException(e);
        }

        // căn giữa các cột
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int x = 0; x < columnNames.length; x++) {
            table.getColumnModel().getColumn(x).setCellRenderer(centerRenderer);
        }

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(1200, 800));

        JPanel panel = new JPanel();
        panel.add(new JLabel("Tìm kiếm: "));
        panel.add(addSearchBar(table));
        panel.add(scrollPane);

        JOptionPane.showMessageDialog(this, panel, "Danh sách bệnh nhân đang chờ khám", JOptionPane.PLAIN_MESSAGE);
    }

    private void prescribeMedicineToPatient() {
        if (patient == null) {
            JOptionPane.showMessageDialog(this, "Không còn bệnh nhân nào cần kê đơn thuốc.",
                    "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        // Người dùng đã chọn một bệnh nhân đã khám, tiếp tục nhập đơn thuốc
        String patientName = patient.getName();
        String prescription = "";
        JTextArea ta = new JTextArea(20, 20);
        if (JOptionPane.showConfirmDialog(null, new JScrollPane(ta),
                "Nhập đơn thuốc cho bệnh nhân " + patientName, JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
            prescription = ta.getText();
        }

        if (prescription != null && !prescription.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Đã nhập đơn thuốc cho " + patientName + ": " + prescription, "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            // Lưu thông tin đơn thuốc vào cơ sở dữ liệu
            patient.setMedicine(prescription);
        } else {
            JOptionPane.showMessageDialog(this, "Chưa nhập đơn thuốc!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void transferPatientToAnotherDepartment() {
        if (patient == null) {
            JOptionPane.showMessageDialog(this, "Chưa chọn bệnh nhân!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String[] department = new String[]{"Khoa Nội", "Khoa Ngoại", "Khoa Phụ sản",
                "Khoa Tai-Mũi-Họng", "Khoa Hồi sức tích cực", "Khoa Răng-Hàm-Mặt", "Khoa Ung bướu", "Khoa Cấp cứu", "Khoa Xương khớp"};
        String selectedDepartment = (String) JOptionPane.showInputDialog(
                this, "Chọn khoa cần chuyển bệnh nhân đến:",
                "Danh sách khoa",
                JOptionPane.PLAIN_MESSAGE,
                null,
                department,
                department[0]
        );

        if (selectedDepartment != null && !selectedDepartment.isEmpty()) {
            patient = null;
            JOptionPane.showMessageDialog(this, "Đã chuyển bệnh nhân đến " + selectedDepartment,
                    "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            String[] patientData = {patient.getID(), patient.getName(), patient.getPhone(), patient.getAge(),
                    patient.getGender(), patient.getAddress(), patient.getDoctorsDiagnosis()};
            switch (selectedDepartment) {
                case "Khoa Nội":
                    writeToCSV(patientData, "csv/khoanoi.csv");
                    break;
                case "Khoa Ngoại":
                    writeToCSV(patientData, "csv/khoangoai.csv");
                    break;
                case "Khoa Phụ sản":
                    writeToCSV(patientData, "csv/khoaphusan.csv");
                    break;
                case "Khoa Tai-Mũi-Họng":
                    writeToCSV(patientData, "csv/khoataimuihong.csv");
                    break;
                case "Khoa Hồi sức tích cực":
                    writeToCSV(patientData, "csv/khoahoisuctichcuc.csv");
                    break;
                case "Khoa Răng-Hàm-Mặt":
                    writeToCSV(patientData, "csv/khoaranghammat.csv");
                    break;
                case "Khoa Ung bướu":
                    writeToCSV(patientData, "csv/khoaungbuou.csv");
                    break;
                case "Khoa Xương khớp":
                    writeToCSV(patientData, "csv/khoaxuongkhop.csv");
                    break;
            }
        } else {
            JOptionPane.showMessageDialog(this, "Chưa chọn khoa!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void showDiagnosedPatientsTable() {
        String[] columnNames = {"Số thứ tự", "Họ tên", "Tuổi", "Giới tính", "Chẩn đoán", "Đơn thuốc"};
        JTable table = new JTable(0, columnNames.length);
        DefaultTableModel model = new DefaultTableModel(new Object[][]{}, columnNames);
        table.setAutoCreateRowSorter(true);
        table.setModel(model);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(800, 600));

        for (Patient patient : diagnosedPatients) {
            String[] row = new String[]{patient.getID(), patient.getName(), patient.getAge(), patient.getGender(),
                    patient.getDoctorsDiagnosis(), patient.getMedicine()};
            model.addRow(row);
        }
        // căn giữa các cột
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int x = 0; x < columnNames.length; x++) {
            table.getColumnModel().getColumn(x).setCellRenderer(centerRenderer);
        }

        JPanel panel = new JPanel();
        panel.add(new JLabel("Tìm kiếm: "));
        panel.add(addSearchBar(table));
        panel.add(scrollPane);

        JOptionPane.showMessageDialog(this, panel, "Danh sách bệnh nhân đã khám xong", JOptionPane.PLAIN_MESSAGE);
    }

    private void deleteFirstRowInCSV(String fileLocation) {
        List<String[]> allElements;
        try {
            CSVReader reader2 = new CSVReader(new FileReader(fileLocation));
            allElements = reader2.readAll();
            if (allElements.isEmpty()) {
                return;
            }
            allElements.remove(1);
            FileWriter sw = new FileWriter(fileLocation);
            CSVWriter writer = new CSVWriter(sw);
            writer.writeAll(allElements);
            writer.close();
        } catch (IOException | CsvException e) {
            throw new RuntimeException(e);
        }
    }

    private ImageIcon changeImageSize(String fileLocation) {
        ImageIcon imageIcon = new ImageIcon(fileLocation); // load the image to a imageIcon
        Image image = imageIcon.getImage(); // transform it
        Image newImg = image.getScaledInstance(70, 70, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        imageIcon = new ImageIcon(newImg);  // transform it back
        return imageIcon;
    }

    public void writeToCSV(String[] data, String fileLocation) {
        String csv = fileLocation;
        try {
            CSVWriter writer = new CSVWriter(new FileWriter(csv, true));
            writer.writeNext(data);
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private JTextField addSearchBar(JTable table) {
        TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(table.getModel());
        table.setRowSorter(rowSorter);
        JTextField searchField = new JTextField(20);
        searchField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = searchField.getText();

                if (text.trim().isEmpty()) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = searchField.getText();

                if (text.trim().isEmpty()) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

        });
        return searchField;
    }

    public static void main(String[] args) {
        new DoctorInterface("Khoa Nội").setVisible(true);
    }
}
