package util;

import com.google.common.base.Preconditions;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * 文件操作工具类
 *
 * @author vonzhou
 * @version 2017/8/28.
 */
public class FileUtil {
    private static final Logger logger = LoggerFactory.getLogger(FileUtil.class);

    public static void strToFile(String content, File outFile) {
        OutputStream os = null;
        try {
            File parent = outFile.getParentFile();
            if (!parent.exists()) {
                parent.mkdirs();
            }
            if (!outFile.exists()) {
                outFile.createNewFile();
            }
            os = new FileOutputStream(outFile);
            IOUtils.write(content, os);
        } catch (Exception e) {
            logger.error(String.format("Write string to %s failed !", outFile.getAbsolutePath()), e);
        } finally {
            IOUtils.closeQuietly(os);
        }
    }

    public static String file2Str(File file) {
        return file2Str(file, "UTF-8");
    }

    public static String file2Str(File file, String charset) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
            return IOUtils.toString(fis, charset);
        } catch (Exception e) {
            logger.error("read file failed!", e);
        } finally {
            IOUtils.closeQuietly(fis);
        }
        return null;
    }

    public static String file2Str(String fileName) {
        File f = new File(fileName);
        if (!f.exists()) {
            return null;
        }
        return file2Str(f);
    }

    public static String computeMd5(String fileName) {
        InputStream is = null;
        try {
            is = new FileInputStream(new File(fileName));
            return DigestUtils.md5Hex(is);
        } catch (Exception e) {
            logger.error("compute md5 failed , %s", fileName);
        } finally {
            IOUtils.closeQuietly(is);
        }
        return "";
    }

    public static void listFiles(final File folder, List<String> filePaths) {
        Preconditions.checkNotNull(filePaths, "file paths list not null");
        for (final File entry : folder.listFiles()) {
            if (entry.isDirectory()) {
                listFiles(entry, filePaths);
            } else {
                filePaths.add(entry.getAbsolutePath());
            }
        }
    }


    public static void makeExecutable(File dir, Set<String> extensions) {
        Collection<File> files = FileUtils.listFiles(dir, null, true);
        if (CollectionUtils.isNotEmpty(files)) {
            for (File file : files) {
                String fileName = file.getAbsolutePath();
                String suffix = StringUtils.substringAfterLast(fileName, ".");
                if (extensions.contains(suffix)) {
                    file.setExecutable(true);
                }
            }
        }
    }

    public static void cleanDirectory(String dir, long ttl) {
        File file = new File(dir);
        String[] subDirNames = file.list(new FilenameFilter() {
            @Override
            public boolean accept(File current, String name) {
                return new File(current, name).isDirectory();
            }
        });
        if (subDirNames != null) {
            for (String name : subDirNames) {
                File subDir = new File(dir + File.separator + name);
                if (System.currentTimeMillis() - subDir.lastModified() > ttl) {
                    try {
                        logger.info(String.format("清理目录 %s", subDir.getAbsolutePath()));
                        FileUtils.deleteDirectory(subDir);
                    } catch (Exception e) {
                        logger.error(String.format("清理文件夹[%s]失败！", dir), e);
                    }
                }
            }
        }
    }

    public static void writeToFile(InputStream is, String outFile) throws Exception {
        OutputStream os = new BufferedOutputStream(new FileOutputStream(new File(outFile)));
        int bufferSize = 1024;
        byte[] buffer = new byte[bufferSize];
        int len = 0;
        while ((len = is.read(buffer)) != -1) {
            os.write(buffer, 0, len);
        }
        if (os != null)
            os.close();
    }

    public static void main(String[] args) throws Exception {
    }
}
