import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class Demo {
    public static void main(String[] args) {
        // Student student = new Student();
        // student.setAge(5);
        // student.setName("Tom");
        // student.setTelephone("123456");
        // // 序列化
        // // String jsonString = JSON.toJSONString(student);
        // // String jsonString = JSON.toJSONString(student, SerializerFeature.WriteClassName);
        // // System.out.println(jsonString);

        // 反序列化
        String jsonString = "{\"@type\":\"Student\",\"age\":5,\"name\":\"Tom\",\"telephone\":\"123456\", \"properties\":{}}";
        // Student obj = JSON.parseObject(jsonString, Student.class, Feature.SupportNonPublicField);
        // Student obj = JSON.parseObject(jsonString, Student.class);
        Object obj = JSON.parseObject(jsonString, Object.class);
        System.out.println(obj);
        System.out.println(obj.getClass());
    }
}
