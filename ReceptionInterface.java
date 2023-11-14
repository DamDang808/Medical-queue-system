import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;
import java.util.Queue;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;

public class ReceptionInterface {
    private Queue<Patient> waitingRoom = new LinkedList<>();
    JFrame editFrame;
    JPanel formPanel, editPanel, menuButtonPanel;
    JButton menuButton;


    ReceptionInterface() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();


        editFrame = new JFrame("Edit");
        editFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        editFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        editFrame.setLayout(null);


        // CREATE HEADERPANEL JPANEL
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(null);
        headerPanel.setBounds(10, 10, screenSize.width - 20, 100);
        headerPanel.setBorder(new BevelBorder(BevelBorder.RAISED));

        // CREATE HEADERPANELSH JPANEL
        JPanel headerPanelsh = new JPanel();
        headerPanelsh.setLayout(null);
        headerPanelsh.setBounds(16, 16, screenSize.width - 20, 100);
        headerPanelsh.setBackground(new Color(200, 200, 200));

        // CREATE HEADING JLABEL
        JLabel heading = new JLabel("Bệnh viện đa khoa");
        Font font = new Font("Garamond", Font.BOLD, 35);
        heading.setFont(font);
        heading.setForeground(new Color(0, 255, 226));
        heading.setBounds(screenSize.width - 700, 40, 700, 45);

        // LOGO
//        ImageIcon image = new ImageIcon("C:\\Users\\diabolicfeak\\Documents\\NetBeansProjects\\hms\\src\\Images\\logo.png");
//        JLabel label = new JLabel("", image, JLabel.CENTER);
//        JPanel panel = new JPanel(new BorderLayout());
//        panel.add(label, BorderLayout.CENTER);
//        panel.setBounds(50, 15, 100, 90);

        //FOOTER JPANEL
        JButton home = new JButton("Home");
//        home.addActionListener(new ActionListener()
//        {
//            public void actionPerformed(ActionEvent ae)
//            {
//                editframe.setVisible(true);
//                new HomePage();
//            }
//        });
        home.setBounds((screenSize.width / 2) - 140, 650, 100, 30);
        editFrame.add(home);

        // ABOUT US BUTTON
        JButton aboutus = new JButton("About Us");
        aboutus.setBounds((screenSize.width / 2) - 40, 650, 100, 30);
//        aboutus.addActionListener(new ActionListener()
//        {
//            public void actionPerformed(ActionEvent ae)
//            {
//                editframe.setVisible(true);
//                new AboutUs();
//            }
//        });
        editFrame.add(aboutus);

        // CONTACT US BUTTON
        JButton contactus = new JButton("Contact Us");
//        contactus.addActionListener(new ActionListener()
//        {
//            public void actionPerformed(ActionEvent ae)
//            {
//                editframe.setVisible(true);
//                new ContactUs();
//            }
//        });
        contactus.setBounds((screenSize.width / 2) + 60, 650, 100, 30);
        editFrame.add(contactus);


        editPanel = new JPanel();
        editPanel.setLayout(null);
        editPanel.setBounds(520, 120, 400, 200);

        menuButtonPanel = new JPanel();
        menuButtonPanel.setLayout(null);
        menuButtonPanel.setBounds(500, 140, 400, 50);

        final JTextField idfield = new JTextField("Enter ID");
        idfield.setBounds(10, 10, 150, 30);
        JButton editbutton = new JButton("Edit");
        editbutton.setBounds(170, 10, 150, 30);

        menuButton = new JButton("View Patients");
        menuButton.setBounds(120, 15, 150, 30);
        menuButtonPanel.add(menuButton);
        menuButtonPanel.setVisible(false);

        editPanel.add(idfield);
        editPanel.add(editbutton);

        editFrame.add(editPanel);
        editFrame.add(menuButtonPanel);
//        editframe.add(panel);
        editFrame.add(heading);
        editFrame.add(headerPanel);
        editFrame.add(headerPanelsh);

        formPanel = new JPanel();
        formPanel.setBounds(400, 170, 600, 450);
        formPanel.setLayout(null);

        editbutton.addActionListener(ae -> {
            try {
                editform();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        editFrame.add(formPanel);
        editFrame.setVisible(true);
    }

    public void editform() {
        // EDIT FORM
        String name = "Nhập tên bệnh nhân";
        final JTextField namefield = new JTextField(name);
        namefield.setBounds(165, 60, 280, 40);
        formPanel.add(namefield);

        String address = "Địa chỉ";
        final JTextField addressfield = new JTextField(address);
        addressfield.setBounds(165, 110, 280, 40);
        formPanel.add(addressfield);

        String phone = "Số điện thoại";
        final JTextField phonefield = new JTextField(phone);
        phonefield.setBounds(165, 160, 280, 40);
        formPanel.add(phonefield);

        String age = "Tuổi";
        final JTextField agefield = new JTextField(age);
        agefield.setBounds(165, 210, 280, 40);
        formPanel.add(agefield);

        String sex = "Giới tính";
        final JTextField sexfield = new JTextField(sex);
        sexfield.setBounds(165, 260, 280, 40);
        formPanel.add(sexfield);

        String illness = "Triệu chứng";
        final JTextField illnessfield = new JTextField(illness);
        illnessfield.setBounds(165, 310, 280, 40);
        formPanel.add(illnessfield);

        JButton formeditbutton = new JButton("Submit");
        formeditbutton.setBounds(185, 380, 230, 40);
        formeditbutton.setVisible(true);
        formPanel.add(formeditbutton);

        formPanel.setBorder(new EtchedBorder(EtchedBorder.RAISED));


        editPanel.setVisible(false);
//          menubuttonpane.setVisible(true);
        formPanel.repaint();

        // SECOND ONCLICK
        formeditbutton.addActionListener(ae -> {
            try {
                Patient patient = new Patient(name, address, phone, age, sex, illness);
                JOptionPane.showMessageDialog(null, "Successfully entered details");
                waitingRoom.add(patient);
                formPanel.setVisible(false);
                editPanel.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });


//        menubutton.addActionListener(new ActionListener()
//        {
//            public void actionPerformed(ActionEvent ae)
//            {
//                new MenuPage();
//                editframe.setVisible(false);
//            }
//        });

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ReceptionInterface::new);
    }
}
