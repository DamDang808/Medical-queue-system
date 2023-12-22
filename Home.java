
import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;


/**
 * @author adm
 */
public class Home extends javax.swing.JFrame {
    // Variables declaration
    private JButton addPatientButton;
    private JButton exitButton;
    private JButton doctorButton;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private List<Doctor> allDoctors;

    public Home(List<Doctor> allDoctors) {
        this.allDoctors = allDoctors;
        initComponents();
    }

    /**
     * Creates new form Home
     */
    public Home() {
        FlatRobotoFont.install();
        UIManager.put("defaultFont", new Font(FlatRobotoFont.FAMILY, Font.PLAIN, 18));

        FlatLaf.registerCustomDefaultsSource("resources.themes");
        FlatMacLightLaf.setup();

        this.setTitle("Quản lý bệnh viện");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(new Dimension(1000, 600));
        setLocationRelativeTo(null);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addPatientButton = new JButton();
        exitButton = new JButton();
        doctorButton = new JButton();

        setLayout(new MigLayout("fill,insets 20", "[center]", "[center]"));

        JPanel panel = new JPanel(new MigLayout("wrap,fillx,insets 35 45 30 45", "[fill,360]"));
        panel.putClientProperty(FlatClientProperties.STYLE, "arc:20;" +
                "[light]background:darken(@background,3%);");

        addPatientButton.putClientProperty(FlatClientProperties.STYLE, "[light]background:darken(@background,20%);" +
                "borderWidth:0;" +
                "focusWidth:0;" +
                "innerFocusWidth:0");
        exitButton.putClientProperty(FlatClientProperties.STYLE, "[light]background:darken(@background,20%);" +
                "borderWidth:0;" +
                "focusWidth:0;" +
                "innerFocusWidth:0");
        doctorButton.putClientProperty(FlatClientProperties.STYLE, "[light]background:darken(@background,20%);" +
                "borderWidth:0;" +
                "focusWidth:0;" +
                "innerFocusWidth:0");

        addPatientButton.setIcon(changeSizeImage("Interface-image/addpatient.png"));
        addPatientButton.setText("Thêm bệnh nhân");
        addPatientButton.setHorizontalAlignment(SwingConstants.LEFT);
        addPatientButton.addActionListener(this::addPatientButtonActionPerformed);

        doctorButton.setIcon(changeSizeImage("Interface-image/doctor.png")); // NOI18N
        doctorButton.setText("Bác sĩ");
        doctorButton.setHorizontalAlignment(SwingConstants.LEFT);
        doctorButton.addActionListener(this::doctorButtonActionPerformed);

        exitButton.setIcon(changeSizeImage("Interface-image/logout.jpg"));
        exitButton.setText("Thoát");
        exitButton.setHorizontalAlignment(SwingConstants.LEFT);
        exitButton.addActionListener(this::exitButtonActionPerformed);

        panel.add(addPatientButton, "gapy 8");
        panel.add(doctorButton, "gapy 8");
        panel.add(exitButton, "gapy 8");
        add(panel);
    }

    private void doctorButtonActionPerformed(ActionEvent evt) {
        String[] department = new String[]{"Khoa Nội", "Khoa Ngoại", "Khoa Phụ sản",
                "Khoa Tai-Mũi-Họng", "Khoa Hồi sức tích cực", "Khoa Răng-Hàm-Mặt", "Khoa Ung bướu", "Khoa Cấp cứu", "Khoa Xương khớp"};
        String selectedDepartment = (String) JOptionPane.showInputDialog(
                this, "Chọn khoa của bác sĩ:",
                "Danh sách khoa",
                JOptionPane.PLAIN_MESSAGE,
                null,
                department,
                department[0]
        );

        if (selectedDepartment != null && !selectedDepartment.isEmpty()) {
            new DoctorInterface(selectedDepartment).setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn khoa nào!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void addPatientButtonActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
        new AddPatientRecord().setVisible(true);
    }

    private void exitButtonActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
        int a = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn thoát?", "Thoát?", JOptionPane.YES_NO_OPTION);
        if (a == 0) {
            setVisible(false);
            System.exit(0);
        }
    }

    private ImageIcon changeSizeImage(String fileLocation) {
        ImageIcon imageIcon = new ImageIcon(fileLocation); // load the image to a imageIcon
        Image image = imageIcon.getImage(); // transform it
        Image newimg = image.getScaledInstance(70, 70, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        imageIcon = new ImageIcon(newimg);  // transform it back
        return imageIcon;
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
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                 UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new Home().setVisible(true));
    }
}
