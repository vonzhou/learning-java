package serialization.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang.StringUtils;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

/**
 * Jackson 工具类
 */
public final class JacksonUtils {
    private static final ObjectMapper mapper = new ObjectMapper();

    static {
        // 开启非标准json的单引号
        mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        mapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        mapper.configure(JsonParser.Feature.ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER, true);
    }

    /**
     * 对象转json字符串
     *
     * @param object
     * @return
     */
    public static String toJsonStr(Object object) {
        Writer strWriter = new StringWriter();
        try {
            mapper.writeValue(strWriter, object);
        } catch (Exception e) {
            throw new RuntimeException("Exception while converting from Java Pojo to Json.", e);
        }
        return strWriter.toString();
    }

    /**
     * json字符串转对象
     *
     * @param json  合法的json字符串
     * @param clazz 类型
     * @param <T>
     * @return
     */
    public static <T> T fromJson(String json, Class<T> clazz) {
        try {
            return (T) mapper.readValue(json, clazz);
        } catch (Exception e) {
            throw new RuntimeException("Exception occurred while converting from Json to Java Pojo.", e);
        }
    }

    /**
     * 判断字符串是否是合法的json对象
     *
     * @param jsonStr
     * @return
     */
    public static boolean isValidateJsonObj(String jsonStr) {
        if (StringUtils.isNotBlank(jsonStr) && StringUtils.startsWith(jsonStr, "{") && StringUtils.endsWith(jsonStr, "}")) {
            return true;
        }
        return false;
    }

    /**
     * json字符串中获取指定key的value
     *
     * @param json
     * @param optKey
     * @param defaultValue
     * @return
     */
    public static String optStr(String json, String optKey, String defaultValue) {
        if (StringUtils.isBlank(json) || StringUtils.isBlank(optKey)) {
            return defaultValue;
        }
        try {
            JsonNode rootNode = mapper.readTree(json);
            JsonNode jsonNode = rootNode.findValue(optKey);
            if (jsonNode != null) {
                return jsonNode.asText();
            }
        } catch (IOException e) {
        }
        return defaultValue;
    }

}
