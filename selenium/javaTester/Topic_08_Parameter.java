package javaTester;

public class Topic_08_Parameter {

    static String fullNameGlobal = "Automation testing";

    public static void main(String[] args) {
        // Đối số
        System.out.println(getFullName());
        setFullName("Manual Testing");
        System.out.println(getFullName());
    }

    public static void setFullName (String fullName) { // Tham số
        fullNameGlobal = fullName;
    }

    public static String getFullName() {
        return fullNameGlobal;
    }
}
