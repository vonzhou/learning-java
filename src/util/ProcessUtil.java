package util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.management.ManagementFactory;

/**
 * @author vonzhou
 * @date 2018/12/29
 */
@Slf4j
public class ProcessUtil {
    public static String runCommand(String command) {
        return runCommand(command, null);
    }

    public static String runCommand(String command, String[] enp) {
        BufferedReader reader = null;
        BufferedReader readerError = null;
        StringBuffer result = new StringBuffer();
        StringBuffer resultError = new StringBuffer();
        String res = "";
        try {
            Process process = Runtime.getRuntime().exec(command, enp, null);

            reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            readerError = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line + System.lineSeparator());

            }
            while ((line = readerError.readLine()) != null) {
                resultError.append(line + System.lineSeparator());

            }
            process.waitFor();
            log.info("exit value: " + process.exitValue());
            res = result.toString();
        } catch (Throwable e) {
            log.error(String.format("执行命令 %s 出错！", command), e);
        } finally {
            IOUtils.closeQuietly(reader);
            IOUtils.closeQuietly(readerError);
        }
        log.info("Error ====== " + resultError.toString());
        return res;
    }

    public static String getPID() {
        String pid = ManagementFactory.getRuntimeMXBean().getName()
                .substring(0, ManagementFactory.getRuntimeMXBean().getName().indexOf("@"));
        return pid;
    }

    public static void killProcess(String pid) throws Exception {
        if (StringUtils.isBlank(pid))
            return;
        Runtime rt = Runtime.getRuntime();
        if (System.getProperty("os.name").toLowerCase().indexOf("windows") > -1)
            rt.exec("taskkill " + pid);
        else
            rt.exec("kill -9 " + pid);
        log.warn(String.format("Kill process [%s]", pid));

    }

    public static void main(String[] args) {
        System.out.println(runCommand("ipconfig /all"));
    }
}
