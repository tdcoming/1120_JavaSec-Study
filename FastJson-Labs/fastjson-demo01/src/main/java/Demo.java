import com.alibaba.fastjson.JSON;

public class Demo {
    public static void main(String[] args) {
        Student student = new Student();
        student.setAge(5);
        student.setName("Tom");
        student.setTelephone("123456");
        String jsonString = JSON.toJSONString(student);
        System.out.println(jsonString);
    }
}
