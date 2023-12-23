/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import net.miginfocom.swing.MigLayout;
import com.opencsv.CSVWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author adm
 */
public class AddPatientRecord extends JFrame {
    /**
     * Creates new form addPatient
     */
    // Variables declaration
    private static PriorityQueue<Doctor> allDoctors;
    private final String REGEX_FOR_NAME = "^[A-ZÀÁẠẢÃÂẦẤẬẨẪĂẰẮẶẲẴÈÉẸẺẼÊỀẾỆỂỄÌÍỊỈĨÒÓỌỎÕÔỒỐỘỔỖƠỜỚỢỞỠÙÚỤỦŨƯỪỨỰỬỮỲÝỴỶỸĐ]" +
            "[a-zàáạảãâầấậẩẫăằắặẳẵèéẹẻẽêềếệểễìíịỉĩòóọỏõôồốộổỗơờớợởỡùúụủũưừứựửữỳýỵỷỹđ]" +
            "*(?:[ ][A-ZÀÁẠẢÃÂẦẤẬẨẪĂẰẮẶẲẴÈÉẸẺẼÊỀẾỆỂỄÌÍỊỈĨÒÓỌỎÕÔỒỐỘỔỖƠỜỚỢỞỠÙÚỤỦŨƯỪỨỰỬỮỲÝỴỶỸĐ]" +
            "[a-zàáạảãâầấậẩẫăằắặẳẵèéẹẻẽêềếệểễìíịỉĩòóọỏõôồốộổỗơờớợởỡùúụủũưừứựửữỳýỵỷỹđ]*)*$";
    private int numOfPatientToday = 1;
    private JButton saveButton;
    private JComboBox<String> departmentBox;
    private JComboBox<String> doctorBox;
    private JRadioButton jrMale;
    private JRadioButton jrFemale;
    private ButtonGroup groupGender;
    private JTextField idTextField;
    private JTextField txtFirstName;
    private JTextField txtLastName;
    private JTextField txtPhoneNumber;
    private JTextField txtAge;
    private JTextField txtAddress;
    private JTextField txtHistory;

    public AddPatientRecord() {
        UIManager.put("defaultFont", new Font(FlatRobotoFont.FAMILY, Font.PLAIN, 13));

        setTitle("Thêm bệnh nhân");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        setExtendedState(JFrame.MAXIMIZED_BOTH);
//        setUndecorated(true);
        setSize(new Dimension(1200, 800));
        setLocationRelativeTo(null);

        allDoctors = new PriorityQueue<>();
        importDoctor(allDoctors);

        initComponents();
    }

    private void initComponents() {

        idTextField = new JTextField(numOfPatientToday + "");
        txtFirstName = new JTextField();
        txtLastName = new JTextField();
        txtPhoneNumber = new JTextField();
        txtAge = new JTextField();
        txtAddress = new JTextField();
        txtHistory = new JTextField();

        departmentBox = new JComboBox<>();
        doctorBox = new JComboBox<>();

        saveButton = new JButton("Lưu");

        //setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        setLayout(new MigLayout("fill,insets 20", "[center]", "[center]"));

        JPanel panel = new JPanel(new MigLayout("wrap,fillx,insets 35 45 30 45", "[fill,360]"));
        panel.putClientProperty(FlatClientProperties.STYLE, "arc:20;" +
                "[light]background:darken(@background,3%);" +
                "[dark]background:lighten(@background,3%)");

        txtFirstName.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Họ");
        txtLastName.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Tên");
        txtPhoneNumber.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Số điện thoại");
        txtAddress.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Địa chỉ");
        txtAge.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Tuổi");
        txtHistory.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Tiền sử bệnh án");
        departmentBox.setModel(new DefaultComboBoxModel<>(new String[]{"Khoa Nội", "Khoa Ngoại", "Khoa Phụ sản",
                "Khoa Tai-Mũi-Họng", "Khoa Hồi sức tích cực", "Khoa Răng-Hàm-Mặt", "Khoa Ung bướu", "Khoa Cấp cứu", "Khoa Xương khớp"}));
        departmentBox.addActionListener(this::departmentBoxActionPerformed);

        saveButton.putClientProperty(FlatClientProperties.STYLE, "[light]background:darken(@background,10%);" +
                "[dark]background:lighten(@background,10%);" +
                "borderWidth:0;" +
                "focusWidth:0;" +
                "innerFocusWidth:0");
        saveButton.addActionListener(this::saveButtonActionPerformed);

        JLabel lbTitle = new JLabel("Thông tin bệnh nhân");
        lbTitle.putClientProperty(FlatClientProperties.STYLE, "font:bold +10");
        JLabel lbTitle1 = new JLabel("Lưu ý: Chỉ mở 1 màn hình này trong quá trình hoạt động!");
        lbTitle1.putClientProperty(FlatClientProperties.STYLE, "font:bold +2");


        panel.add(lbTitle);
        panel.add(lbTitle1);

        panel.add(new JLabel("ID"), "gapy 5");
        panel.add(idTextField);
        panel.add(new JLabel("Họ và tên"), "gapy 5");
        panel.add(txtFirstName, "split 2");
        panel.add(txtLastName);
        panel.add(new JLabel("Giới tính"), "gapy 5");
        panel.add(createGenderPanel());
        panel.add(new JSeparator(), "gapy 5 5");
        panel.add(new JLabel("Số điện thoại"), "gapy 5");
        panel.add(txtPhoneNumber);
        panel.add(new JLabel("Tuổi"), "gapy 5");
        panel.add(txtAge);
        panel.add(new JLabel("Địa chỉ"), "gapy 5");
        panel.add(txtAddress);
        panel.add(new JLabel("Tiền sử bệnh án"), "gapy 5");
        panel.add(txtHistory);
        panel.add(new JLabel("Khoa"), "gapy 5");
        panel.add(departmentBox);
        panel.add(new JLabel("Bác sĩ"), "gapy 5");
        panel.add(doctorBox);
        getAllDoctors();
        panel.add(saveButton, "gapy 20");

        add(panel);
    }

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            int id = Integer.parseInt(idTextField.getText());
            numOfPatientToday = id + 1;
            int age = Integer.parseInt(txtAge.getText());

            if (age <= 0) {
                JOptionPane.showMessageDialog(this, "Tuổi phải là số nguyên dương.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String name = txtFirstName.getText() + " " + txtLastName.getText();
            if (!name.matches(REGEX_FOR_NAME)) {
                JOptionPane.showMessageDialog(this, "Tên phải là chuỗi hợp lệ.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String address = txtAddress.getText();
            String phone = txtPhoneNumber.getText();
            String history = txtHistory.getText();

            if (address.isEmpty() || phone.isEmpty() || history.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin của bệnh nhân.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (!phone.matches("^\\d+$")) {
                JOptionPane.showMessageDialog(this, "Số điện thoại không hợp lệ.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }
//            if (phone.length() != 10) {
//                JOptionPane.showMessageDialog(this, "Số điện thoại phải có 10 chữ số.", "Lỗi", JOptionPane.ERROR_MESSAGE);
//                return;
//            }

            String gender = getGender();
            String department = String.valueOf(departmentBox.getSelectedItem());
            String doctorID = String.valueOf(doctorBox.getSelectedItem()).substring(0, 1);
            // Success
            String[] patient = new String[]{id + "", name, phone, age + "", gender, address, history, doctorID};
            switch (department) {
                case "Khoa Nội":
                    writeToCSV(patient, "csv/khoanoi.csv");
                    break;
                case "Khoa Ngoại":
                    writeToCSV(patient, "csv/khoangoai.csv");
                    break;
                case "Khoa Phụ sản":
                    writeToCSV(patient, "csv/khoaphusan.csv");
                    break;
                case "Khoa Tai-Mũi-Họng":
                    writeToCSV(patient, "csv/khoataimuihong.csv");
                    break;
                case "Khoa Hồi sức tích cực":
                    writeToCSV(patient, "csv/khoahoisuctichcuc.csv");
                    break;
                case "Khoa Răng-Hàm-Mặt":
                    writeToCSV(patient, "csv/khoaranghammat.csv");
                    break;
                case "Khoa Ung bướu":
                    writeToCSV(patient, "csv/khoaungbuou.csv");
                    break;
                case "Khoa Cấp cứu":
                    writeToCSV(patient, "csv/khoacapcuu.csv");
                    break;
                case "Khoa Xương khớp":
                    writeToCSV(patient, "csv/khoaxuongkhop.csv");
                    break;
            }
            JOptionPane.showMessageDialog(this, "Thêm bệnh nhân thành công.");

            // Update UI
            idTextField.setText(numOfPatientToday + "");
            txtFirstName.setText("");
            txtLastName.setText("");
            jrMale.setSelected(true);
            txtPhoneNumber.setText("");
            txtAge.setText("");
            txtAddress.setText("");
            txtHistory.setText("");
            increaseExaminingPatient(doctorID);
            importDoctor(allDoctors);
            getAllDoctors();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "ID và tuổi phải là số nguyên.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void departmentBoxActionPerformed(ActionEvent actionEvent) {
        getAllDoctors();
    }

    private void getAllDoctors() {
        String department = String.valueOf(departmentBox.getSelectedItem());
        addDataToDoctorBox(department);
    }
    private String getGender() {
        if (jrMale.isSelected()) {
            return "Nam";
        } else {
            return "Nữ";
        }
    }

    private void increaseExaminingPatient(String doctorID) {
        try {
            Reader reader = Files.newBufferedReader(Paths.get("csv/doctorlist.csv"));
            CSVReader csvReader = new CSVReader(reader);
            List<String[]> records = csvReader.readAll();
            boolean firstRow = true;
            for (String[] data : records) {
                if (firstRow) {
                    firstRow = false;
                    continue;
                }
                if (data[0].equals(doctorID)) {
                    int currentSize = Integer.parseInt(data[3]);
                    currentSize++;
                    data[3] = currentSize + "";
                    break;
                }
            }
            reader.close();

            // Write to CSV file which is open
            CSVWriter writer = new CSVWriter(new FileWriter("csv/doctorlist.csv"));
            writer.writeAll(records);
            writer.flush();
            writer.close();
        } catch (IOException | CsvException e) {
            throw new RuntimeException(e);
        }

    }
    private void addDataToDoctorBox(String department) {
        doctorBox.removeAllItems();
        for (Doctor doctor : allDoctors) {
            if (doctor.getDepartment().equals(department)) {
                doctorBox.addItem(doctor.getId() + ". " + doctor.getName());
            }
        }
    }
    private Component createGenderPanel() {
        JPanel panel = new JPanel(new MigLayout("insets 0 10 0 10"));
        panel.putClientProperty(FlatClientProperties.STYLE, "background:null");
        jrMale = new JRadioButton("Male");
        jrFemale = new JRadioButton("Female");
        groupGender = new ButtonGroup();
        groupGender.add(jrMale);
        groupGender.add(jrFemale);
        jrMale.setSelected(true);
        panel.add(jrMale);
        panel.add(jrFemale);
        return panel;
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

    private void importDoctor(PriorityQueue doctors) {
        doctors.clear();
        try {
            Reader reader = Files.newBufferedReader(Paths.get("csv/doctorlist.csv"));
            CSVReader csvReader = new CSVReader(reader);
            List<String[]> records = csvReader.readAll();
            boolean firstRow = true;
            // Import data from CSV file to table
            for (String[] data : records) {
                if (firstRow) {
                    firstRow = false;
                    continue;
                }
                Doctor doctor = new Doctor(Integer.parseInt(data[0]), data[1], Integer.parseInt(data[3]), data[4]);
                doctors.add(doctor);
            }
            reader.close();
        } catch (IOException | CsvException e) {
            throw new RuntimeException(e);
        }
    }
}
