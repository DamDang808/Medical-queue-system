public class Patient {
    private String name;
    private String address;
    private String phone;
    private String age;
    private String sex;
    private String illness;


    public Patient(String name, String address, String phone, String age, String sex, String illness) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.age = age;
        this.sex = sex;
        this.illness = illness;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getIllness() {
        return illness;
    }

    public void setIllness(String illness) {
        this.illness = illness;
    }
}
