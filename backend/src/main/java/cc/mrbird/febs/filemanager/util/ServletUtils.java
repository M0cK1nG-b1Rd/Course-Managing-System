package cc.mrbird.febs.filemanager.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;

/**
 * Servlet工具类
 *
 * @author huqiang
 */

public class ServletUtils {
    /**
     * 文件下载时用于写文件头部信息
     * @param request  http请求
     * @param response http响应
     * @param fileName 文件名
     */
    public static void setFileDownloadHeader(HttpServletRequest request, HttpServletResponse response, String fileName) {
        try {
            String encodedFileName = null;
            String agent = request.getHeader("USER-AGENT");
            if (null != agent && -1 != agent.indexOf("MSIE")) {
                encodedFileName = URLEncoder.encode(fileName, "UTF-8");
            } else if (null != agent && -1 != agent.indexOf("Mozilla")) {
                encodedFileName = new String(fileName.getBytes("UTF-8"),
                        "iso-8859-1");
            } else {
                encodedFileName = URLEncoder.encode(fileName, "UTF-8");
            }

            response.setHeader("Content-Disposition", "attachment; filename=\""
                    + encodedFileName + "\"");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
