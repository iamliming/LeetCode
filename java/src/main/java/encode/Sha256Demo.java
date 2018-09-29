package encode;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author liming
 * @version [版本号, 九月 26, 2018]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class Sha256Demo
{
    /**
     * SHA256加密
     *
     * @param str 加密后的报文
     * @return
     */
    public static String getSHA256StrJava(String str)
    {
        MessageDigest messageDigest;
        String encodeStr = "";
        try
        {
            messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(str.getBytes("UTF-8"));
            encodeStr = byte2Hex(messageDigest.digest());
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }
        return encodeStr;
    }

    /**
     * 将byte转为16进制
     *
     * @param bytes
     * @return
     */
    private static String byte2Hex(byte[] bytes)
    {
        StringBuffer stringBuffer = new StringBuffer();
        String temp = null;
        for (int i = 0; i < bytes.length; i++)
        {
            temp = Integer.toHexString(bytes[i] & 0xFF);
            if (temp.length() == 1)
            {
                //1得到一位的进行补0操作
                stringBuffer.append("0");
            }
            stringBuffer.append(temp);
        }
        return stringBuffer.toString();
    }

    public static void main(String[] args)
    {
        System.out.println(Sha256Demo.getSHA256StrJava("abc"));
        System.out.println(Sha256Demo.getSHA256StrJava("abc"));
    }
}
