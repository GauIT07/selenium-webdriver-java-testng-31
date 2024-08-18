package javaTester;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class Topic_01_Data_Type {
    /*
     kiểu dữ liệu nguyên thủy (Primitive Type)
     8 loại
     Số nguyên: byte - short - int - long
     Không có phần thập phân: nhân viên trong 1 công ty/ học sinh trong 1 lớp/ trường/...
    */


    int iNumber = 5;

    byte bNumber = 1;

    /*
    Số thực: float - double
    Có phần thập phân: điểm số/ lương/...
     */
    float fNumber = 9.9f;

    double dNUmber = 10.15d;

    //ký tự: char
    char k = ' ';
    char c = 'M';

    // logic: boolean (luận lý)
    // kết quả bài test: pass/ fail
    boolean status = true;

    // Kiểu dữ liệu tham chiếu Reference Type
    // Class
    FirefoxDriver firefoxDriver = new FirefoxDriver();
    Topic_01_Data_Type topic01 = new Topic_01_Data_Type();


    // Interface
    WebDriver driver;
    JavascriptExecutor jsExecutor;


    // Object
    Object name = "Automation FC";


    // Array (kiểu nguyên thủy/ tham chiếu) - Khai báo cố định, không tăng giảm số lượng
    int[] studenAge = {15, 20, 8};
    String[] studentName = {"Automation", "Testing"};


    // Collection: List / Set/ Queue - Khai báo động, tăng giảm theo thực tế sử dụng
    List<String> studentAddress = new ArrayList<String>();
    List<String> studentCity = new LinkedList<>();
    List<String> studentPhone = new Vector<>();


    // String - Chuỗi ký tự
    String namestr = "Automation";

    // Khai báo 1 biến để lưu trữ 1 loại dữ liệu nào đó
    // Access Modifier: Phạm vi truy cập (public/ private/ protected/ default)
    /*
    Kiểu dũ liệu
    Tên biến
    Giá trị của biến - gán vào vs phép =
    Nếu như không gán: dữ liệu mặc định =0 hoặc bằng null
     */
    public int studentNumber = 200;


}
