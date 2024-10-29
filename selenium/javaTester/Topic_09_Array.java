package javaTester;

public class Topic_09_Array {

    int[] arrayInt = {10, 11, 12};

    static String[] studentName1 = {"Nguyễn Văn A", "Lê B"};

    public static void main(String[] args) {

        String[] studentName = new String[4];
        studentName[0] = "Lê A";
        studentName[1] = "Lê B";
        studentName[2] = "Lê C";
        studentName[3] = "Lê D";

        // Muốn in các phần tử trong mảng thì dùng hàm for để duyệt qua mảng
        for(int i = 0; i < 4; i++)
            System.out.println(studentName[i]);

        // Muốn in mảng khai báo trong class phải có tiền tố static sẽ cho phép truy cập từ hàm main - vì hàm main là 1 hàm static
        // có thể gọi qua 1 hàm static hoặc biến static
        System.out.println(studentName1[1]);


        // Muốn truy cập biến non-static ngoài hàm main phải tiến hành new đối tượng - đại diện của class
        Topic_09_Array topic = new Topic_09_Array();
        // Sau khi new đối tượng thi có thể truy cập biến
        System.out.println(topic.arrayInt[1]);
    }
}
