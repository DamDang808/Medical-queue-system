public class Patient {
    private String ID;
    private String name;
    private String phone;
    private String address;
    private String age;
    private String gender;
    private String illness;
    private String doctorsDiagnosis = "";
    private String medicine;
    private String doctorID;

    public Patient(String ID, String name, String phone, String age, String gender, String address, String illness, String doctorID) {
        this.ID = ID;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.age = age;
        this.gender = gender;
        this.illness = illness;
        this.doctorID = doctorID;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }


    public String getIllness() {
        return illness;
    }

    public void setIllness(String illness) {
        this.illness = illness;
    }

    public String getDoctorsDiagnosis() {
        return doctorsDiagnosis;
    }

    public void setDoctorsDiagnosis(String doctorsDiagnosis) {
        this.doctorsDiagnosis = doctorsDiagnosis;
    }

    public void setMedicine(String medicine) {
        this.medicine = medicine;
    }

    public String getMedicine() {
        return medicine;
    }
    @Override
    public String toString() {
        return name + " - " + ID;
    }
}
