
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;
import java.util.Objects;

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
        this.setTitle("Quản lý bệnh viện");
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
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocation(new Point(250, 150));
        setPreferredSize(new Dimension(1000, 600));
        getContentPane().setLayout(new AbsoluteLayout());

        addPatientButton.setBackground(new Color(0, 255, 0));
        addPatientButton.setIcon(new ImageIcon("Interface-image/Patient.jpg"));
        addPatientButton.setText("Thêm bệnh nhân");
        addPatientButton.setHorizontalTextPosition(SwingConstants.RIGHT);
        addPatientButton.setPreferredSize(new Dimension(200, 80));
        addPatientButton.addActionListener(this::addPatientButtonActionPerformed);
        getContentPane().add(addPatientButton, new AbsoluteConstraints(30, 140, 196, -1));

        exitButton.setBackground(new Color(0, 255, 0));
        exitButton.setIcon(new ImageIcon("Interface-image/logout.jpg"));
        exitButton.setText("Thoát");
        exitButton.setHorizontalAlignment(SwingConstants.LEFT);
        exitButton.setPreferredSize(new Dimension(200, 80));
        exitButton.addActionListener(this::exitButtonActionPerformed);
        getContentPane().add(exitButton, new AbsoluteConstraints(30, 360, -1, -1));
        getContentPane().add(jLabel1, new AbsoluteConstraints(540, 180, -1, -1));

        doctorButton.setBackground(new Color(0, 255, 0));
        doctorButton.setIcon(changeSizeImage("Interface-image/doctor.png")); // NOI18N
        doctorButton.setText("Bác sĩ");
        doctorButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        doctorButton.setHorizontalAlignment(SwingConstants.LEFT);
        doctorButton.setPreferredSize(new Dimension(200, 80));
        doctorButton.addActionListener(this::doctorButtonActionPerformed);
        getContentPane().add(doctorButton, new AbsoluteConstraints(30, 250, 196, -1));


        jLabel2.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("Interface-image/hospital.jpg"))));
        jLabel2.setText("background");
        jLabel2.setPreferredSize(new Dimension(1000, 600));
        getContentPane().add(jLabel2, new AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }

    private void doctorButtonActionPerformed(ActionEvent actionEvent) {
        new DoctorInterface().setVisible(true);
    }

    private void addPatientButtonActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        new AddPatientRecord(allDoctors).setVisible(true);
    }

    private void exitButtonActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        int a = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn thoát?", "Select", JOptionPane.YES_NO_OPTION);
        if (a == 0) {
            setVisible(false);
            System.exit(0);
        }
    }

    private ImageIcon changeSizeImage(String fileLocation) {
        ImageIcon imageIcon = new ImageIcon(fileLocation); // load the image to a imageIcon
        Image image = imageIcon.getImage(); // transform it
        Image newimg = image.getScaledInstance(70, 70,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
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
