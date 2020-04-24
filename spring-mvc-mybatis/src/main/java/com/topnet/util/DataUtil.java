package com.topnet.util;

import com.alibaba.fastjson.JSONObject;
import com.topnet.service.RedisService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author
 * @create 2018-09-20 16:58
 */

public class DataUtil {

  private static Logger logger = Logger.getLogger(DataUtil.class);
  private static String code = Constant.CODE;
  private static Integer codeSuccess = Constant.CODE_SUCCESS;
  private static String msg = Constant.MSG;
    @Autowired
    RedisService redisService;

  /**
   * 返回客户端数据
   *
   * @param data
   * @return
   */
  public static JSONObject returnData(Integer coceStatus, Object data, String msgContent) {
    JSONObject result = new JSONObject();
    result.put(code, coceStatus);
    if (data != null) {
      result.put("data", data);
    } else {
      result.put("data", new JSONObject());
    }
    result.put(msg, msgContent);

    return result;
  }


    public static String unicodetoString(String unicode) {
        if (unicode == null || "".equals(unicode)) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int i = -1;
        int pos = 0;
        while ((i = unicode.indexOf("\\u", pos)) != -1) {
            sb.append(unicode.substring(pos, i));
            if (i + 5 < unicode.length()) {
                pos = i + 6;
                sb.append((char) Integer.parseInt(unicode.substring(i + 2, i + 6), 16));
            }
        }
        return sb.toString();
    }
 public static String getTicket(String accessToken) {

     String requestUrl = "https://api.weixin.qq.com/cgi-bin/ticket/getticket";
     String params = "access_token=" + accessToken + "&type=jsapi";
     JSONObject result = sendGet(requestUrl,params);
     String jsapi_ticket = result.getString("ticket");
    return jsapi_ticket;
  }
    public static String getToken(String appid, String appSecret) {

        String requestUrl = "https://api.weixin.qq.com/cgi-bin/token";
        String params = "grant_type=client_credential&appid=" +appid+ "&secret=" + appSecret + "";
        JSONObject result = sendGet(requestUrl,params);
        System.out.println("返回参数----------------:"+result);
        String accessToken = result.getString("access_token");
        return accessToken;
    }
  //微信扫码
  public  Map<String, String> sign(String url,String appid,String appSecret,String accessToken,String jsapi_ticket) {
    Map<String,String> ret=new HashMap<>();
    //这里的jsapi_ticket是获取的jsapi_ticket。
   /* String requestUrl = "https://api.weixin.qq.com/cgi-bin/ticket/getticket";
    String params = "access_token=" + accessToken + "&type=jsapi";
    JSONObject result = sendGet(requestUrl,params);*/


    String nonce_str = create_nonce_str();
    String timestamp = create_timestamp();
    String string1;
    String signature = "";
    //注意这里参数名必须全部小写，且必须有序
    string1 = "jsapi_ticket=" + jsapi_ticket + "&noncestr=" + nonce_str +"&timestamp=" + timestamp +"&url=" + url;
      System.out.println(string1);
    try
    {
      MessageDigest crypt = MessageDigest.getInstance("SHA-1");
      crypt.reset();
      crypt.update(string1.getBytes("UTF-8"));
      signature = byteToHex(crypt.digest());
      System.out.println("crypt="+crypt.toString());
      System.out.println("string1="+string1);
      System.out.println("signature="+signature);
    }
    catch (NoSuchAlgorithmException e)
    {
      e.printStackTrace();
    }
    catch (UnsupportedEncodingException e)
    {
      e.printStackTrace();
    }

    ret.put("url", url);
    ret.put("jsapi_ticket", jsapi_ticket);
    ret.put("nonceStr", nonce_str);
    ret.put("timestamp", timestamp);
    ret.put("signature", signature);
    ret.put("appid",appid);

    return ret;
  }

  private static String byteToHex(final byte[] hash) {
    Formatter formatter = new Formatter();
    for (byte b : hash)
    {
      formatter.format("%02x", b);
    }
    String result = formatter.toString();
    formatter.close();
    return result;
  }

  private static String create_nonce_str() {
    return UUID.randomUUID().toString();
  }

  private static String create_timestamp() {
    return Long.toString(System.currentTimeMillis() / 1000);
  }


    public static JSONObject sendGet(String url, String key) {
      Date start = new Date();
      String value = HttpUtil.sendGet(url, key);
      Date end = new Date();
      logger.info("发送Get请求用时:" + (end.getTime() - start.getTime()));
      JSONObject json = JSONObject.parseObject(value);
      return json;

  }

  //获取当前时间
  public static Timestamp Time(){
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Timestamp Time = Timestamp.valueOf(df.format(new Date()));
    return Time;
  }






}
