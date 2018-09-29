package encoding;

import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 接口签名校验工具类
 *
 * @author guokq19292
 */
public class MD5SignCheckUtil
{

    /**
     * 校验接口签名
     *
     * @param appkey
     * @param timestamp
     * @param sign
     * @param params
     * @return CheckResult
     */
    public static CheckResult signCheck(String appkey, String timestamp, String sign, Map<String, Object> params)
    {
        CheckResult result = new CheckResult();
        //先校验时间戳,间隔在10秒内的算有效请求
        try
        {
            Date time = new SimpleDateFormat("yyyyMMddHHmmss").parse(timestamp);
            Date now = new Date();
            long diff = now.getTime() - time.getTime();
            if (diff > 10000)
            {
                result.setSuccess(false);
                result.setMsg("过期的请求!");
                return result;
            }
            //组装参数
            StringBuffer message = new StringBuffer();
            message.append(appkey);
            //先拿到keys
            Set<String> keys = params.keySet();
            Object[] keyz = keys.toArray();
            //排序
            Arrays.sort(keyz);
            for (Object key : keyz)
            {
                if (key.toString().startsWith("_"))
                {
                    continue;
                }
                message.append((String)key);
                message.append(params.get((String)key));
            }
            message.append("_timestamp").append(timestamp);
            message.append(appkey);
            //MD5签名
            String _sign = getMD5(message.toString());
            if (_sign.equals(sign))
            {
                result.setMsg("接口签名校验成功!");
                result.setSuccess(true);
            }
            else
            {
                result.setMsg("接口签名校验失败!");
            }
        }
        catch (Exception e)
        {
            result.setSuccess(false);
            result.setMsg("签名校验异常：" + e);
        }
        return result;
    }

    public static String getMD5(String message)
        throws Exception
    {
        MessageDigest messageDigest = null;
        StringBuffer md5StrBuff = new StringBuffer();
        messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.reset();
        messageDigest.update(message.getBytes("UTF-8"));

        byte[] byteArray = messageDigest.digest();
        for (int i = 0; i < byteArray.length; i++)
        {
            if (Integer.toHexString(0xFF & byteArray[i]).length() == 1)
                md5StrBuff.append("0").append(Integer.toHexString(0xFF & byteArray[i]));
            else
                md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));
        }
        return md5StrBuff.toString().toUpperCase();//字母大写
    }

    public static void main(String[] args)
        throws Exception
    {
        StringBuilder sb = new StringBuilder();
        String appkey = "migusumei";
        sb.append(appkey);
        Map<String, Object> params = new HashMap<>();
        params.put("a","abc");
        params.put("b","bbc");
        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        sb.append("a").append("abc").append("b").append("bbc").append("_timestamp").append(timestamp).append(appkey);
        String signIn = getMD5(sb.toString());
        System.out.println(signCheck(appkey, timestamp, signIn, params).isSuccess());
    }
}

class CheckResult
{
    private boolean isSuccess;

    private String msg;

    CheckResult()
    {
        this.isSuccess = false;
    }

    public boolean isSuccess()
    {
        return isSuccess;
    }

    public void setSuccess(boolean isSuccess)
    {
        this.isSuccess = isSuccess;
    }

    public String getMsg()
    {
        return msg;
    }

    public void setMsg(String msg)
    {
        this.msg = msg;
    }
}



