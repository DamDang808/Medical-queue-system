import java.util.ArrayList;
import java.util.List;

public class HospitalSystem {
    private List<Doctor> allDoctors;

    public HospitalSystem() {
        this.allDoctors = new ArrayList<>();
    }

    public void addDoctor(Doctor doctor) {
        allDoctors.add(doctor);
    }

    public List<Doctor> getAllDoctors() {
        return allDoctors;
    }
}

