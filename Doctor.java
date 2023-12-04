import javax.swing.JTextArea;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Doctor {
    private String name;
    private String department;
    private Queue<Patient> patientQueue;
    private JTextArea notificationArea;
    private List<Doctor> allDoctors;
    private boolean isHandlingPatient = false;
    private boolean isActiveDoctor = false;
    private int patientQueueSize;

    public Doctor(String name, String department, Queue<Patient> patientQueue, JTextArea notificationArea, int patientQueueSize) {
        this.name = name;
        this.department = department;
        this.patientQueue = new LinkedList<>();
        this.notificationArea = notificationArea;
        this.patientQueueSize = 0;
    }

    public void setNotificationArea(JTextArea notificationArea) {
        this.notificationArea = notificationArea;
    }

    public void addPatientToQueue(Patient patient) {
        patientQueue.add(patient);
        updateQueueSize();
        Doctor selectedDoctor = findDoctorWithMinQueue();
        if (selectedDoctor != null && !selectedDoctor.equals(this)) {
            selectedDoctor.handlePatient(patient);
        }
    }

    public void handlePatient(Patient patient) {
        if (!isHandlingPatient) {
            isHandlingPatient = true;
            updateUI(patient);
            isHandlingPatient = false;
        }
    }

    private void updateUI(Patient patient) {
        if (notificationArea != null) {
            notificationArea.append("Doctor " + name + " is handling the patient:\n" + patient.toString() + "\n");
        }
    }

    private Doctor findDoctorWithMinQueue() {
        Doctor minQueueDoctor = null;
        int minQueueSize = Integer.MAX_VALUE;

        for (Doctor doctor : allDoctors) {
            if (doctor.getPatientQueueSize() < minQueueSize) {
                minQueueSize = doctor.getPatientQueueSize();
                minQueueDoctor = doctor;
            }
        }

        return minQueueDoctor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Queue<Patient> getPatientQueue() {
        return patientQueue;
    }

    public void setPatientQueue(Queue<Patient> patientQueue) {
        this.patientQueue = patientQueue;
    }

    public int getPatientQueueSize() {
        return patientQueueSize;
    }

    private void updateQueueSize() {
        patientQueueSize = patientQueue.size();
    }
}

