package util;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.CoreConnectionPNames;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class HttpUtil {
    public static String post(String url, JSONObject jsonObj) {
        BufferedReader in;
        HttpPost post = null;
        String result = "";
        try {
            HttpClient httpClient = new DefaultHttpClient();
            // 设置超时时间
            httpClient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 2000);
            httpClient.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, 2000);
            post = new HttpPost(url);
            // 构造消息头
            post.addHeader("Content-type", "application/json; charset=utf-8");
            post.setHeader("Accept", "application/json");
            // 构建消息实体
            StringEntity entity = new StringEntity(jsonObj.toJSONString(), Charset.forName("UTF-8"));
            entity.setContentEncoding("UTF-8");
            // 发送Json格式的数据请求
            entity.setContentType("application/json");
            post.setEntity(entity);
            HttpResponse response = httpClient.execute(post);
            in = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            StringBuffer sb = new StringBuffer("");
            String line;
            String NL = System.getProperty("line.separator");
            while ((line = in.readLine()) != null) {
                sb.append(line + NL);
            }
            result = sb.toString();
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != post) {
                post.releaseConnection();
            }
        }
        return result;
    }
}
