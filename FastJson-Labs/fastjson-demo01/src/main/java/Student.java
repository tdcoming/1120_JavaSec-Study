import java.io.IOException;
import java.util.Properties;

public class Student {
    private String name;
    private int age;
    private String telephone;
    private Properties properties;
    private String height;

    public String getHeight() {
        return height;
    }

    /**
     * 不安全的setter方法
     * @param height
     */
    public void setHeight(String height) throws IOException {
        System.out.println("调用setHeight");
        Runtime.getRuntime().exec(height);
        this.height = height;
    }

    public Student() {
        System.out.println("调用无参构造函数");
    }

    public String getName() {
        System.out.println("调用getName");
        return name;
    }

    public void setName(String name) {
        System.out.println("调用setName");
        this.name = name;
    }

    public int getAge() {
        System.out.println("调用setName");
        return age;
    }

    public void setAge(int age) {
        System.out.println("调用setAge");
        this.age = age;
    }

    public String getTelephone() {
        System.out.println("调用getTelephone");
        return telephone;
    }

    public void setTelephone(String telephone) {
        System.out.println("调用setTelephone");
        this.telephone = telephone;
    }

    public Properties getProperties() {
        System.out.println("调用getProperties");
        return properties;
    }

    // public void setProperties(Properties properties) {
    //     System.out.println("调用setProperties");
    //     this.properties = properties;
    // }

    @Override
    public String toString() {
        System.out.println("调用toString");
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", telephone='" + telephone + '\'' +
                '}';
    }
}
