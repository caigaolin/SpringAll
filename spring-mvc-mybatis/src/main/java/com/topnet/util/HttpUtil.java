package com.topnet.util;

import java.io.*;
import java.net.*;

public class HttpUtil {
  /**
   * 向指定URL发送GET方法的请求
   *
   * @param url
   *            发送请求的URL
   * @param param
   *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
   * @return URL 所代表远程资源的响应结果
   */
  public static String sendGet(String url, String param) {
    String result = "";
    BufferedReader in = null;
    try {
      String urlNameString = url + "?" + param;
      URL realUrl = new URL(urlNameString);
      // 打开和URL之间的连接
      URLConnection connection = realUrl.openConnection();
      // 设置通用的请求属性
      connection.setRequestProperty("accept", "*/*");
      connection.setRequestProperty("connection", "Keep-Alive");
      connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
      // 建立实际的连接
      // connection.setConnectTimeout(3000);
      // connection.setReadTimeout(3000);
      connection.connect();

      // 定义 BufferedReader输入流来读取URL的响应
      in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
      String line;
      while ((line = in.readLine()) != null) {
        result += line;
      }
    } catch (SocketTimeoutException e) {
      return "延迟异常";
    } catch (ConnectException c) {
      return "服务未连接";
    } catch (Exception x) {
      System.out.println("其他异常" + x);
      x.printStackTrace();
    }
    // 使用finally块来关闭输入流
    finally {
      try {
        if (in != null) {
          in.close();
        }
      } catch (Exception e2) {
        e2.printStackTrace();
      }
    }
    return result;
  }

  /**
   * 向指定 URL 发送POST方法的请求
   *
   * @param url
   *            发送请求的 URL
   * @param param
   *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
   * @return 所代表远程资源的响应结果
   */
  public static byte[] sendPost(String url, String param) {
    PrintWriter out = null;
    BufferedReader in = null;
    // String result = "";
    try {
      URL realUrl = new URL(url);
      // 打开和URL之间的连接
      URLConnection conn = realUrl.openConnection();
      // 设置通用的请求属性
      conn.setRequestProperty("accept", "*/*");
      conn.setRequestProperty("connection", "Keep-Alive");
      conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
      conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");

      // 发送POST请求必须设置如下两行
      conn.setDoOutput(true);
      conn.setDoInput(true);

      DataOutputStream out1 = new DataOutputStream(conn.getOutputStream());
      out1.write(param.getBytes("UTF-8"));
      out1.flush();
      out1.close();

      return readStream(conn.getInputStream());
    } catch (SocketTimeoutException e) {
      return "延迟异常".getBytes();
    } catch (ConnectException c) {
      return "服务未连接".getBytes();
    } catch (Exception x) {
      System.out.println("其他异常" + x);
      x.printStackTrace();
    }
    // 使用finally块来关闭输出流、输入流
    finally {
      try {
        if (out != null) {
          out.close();
        }
        if (in != null) {
          in.close();
        }
      } catch (IOException ex) {
        ex.printStackTrace();
      }
    }
    return null;
  }

  public static String sendJsonPostData(String url, String params) {
    HttpURLConnection connection = null;
    InputStream is = null;
    try {
      URL realUrl = new URL(url);// 创建连接
      connection = (HttpURLConnection) realUrl.openConnection();
      connection.setDoOutput(true);
      connection.setDoInput(true);
      connection.setUseCaches(false);
      connection.setInstanceFollowRedirects(true);
      connection.setRequestMethod("POST"); // 设置请求方式
      connection.setRequestProperty("Accept", "application/json"); // 设置接收数据的格式
      connection.setRequestProperty("Content-Type", "application/json;charset=utf-8"); // 设置发送数据的格式
      connection.connect();
      OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream(), "UTF-8"); // utf-8编码
      out.append(params);
      out.flush();
      out.close();
      int length = (int) connection.getContentLength();// 获取长度
      is = connection.getInputStream();
      if (length != -1) {
        byte[] data = new byte[length];
        byte[] temp = new byte[512];
        int readLen = 0;
        int destPos = 0;
        while ((readLen = is.read(temp)) > 0) {
          System.arraycopy(temp, 0, data, destPos, readLen);
          destPos += readLen;
        }
        String result = new String(data, "UTF-8"); // utf-8编码
        // System.out.println(result);
        return result;
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      if (is != null) {
        try {
          is.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
    return null;
  }



  public static byte[] readStream(InputStream inStream) throws Exception {

    BufferedReader in = new BufferedReader(new InputStreamReader(inStream, "utf-8"));
    StringBuffer buffer = new StringBuffer();
    String line = "";
    while ((line = in.readLine()) != null) {
      buffer.append(line);
    }
    String str = buffer.toString();

    return str.getBytes();

  }

}
