package akka;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author liming
 * @version [版本号, 五月 28, 2019]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class FSMDemo //extends FSM<FSM.State, Data
{
    public static final long MSISDN_SALT = 10000000000L;
    /**
     * 对身份ID进行异或操作，避免直接获取到身份ID
     * @param msisdn
     * @param atmosid
     * @return
     */
    public static String encodeMsisdn(String msisdn, String atmosid)
    {
        if(msisdn == null || atmosid == null || atmosid.length() == 0){
            return msisdn;
        }
        try
        {
            long flag = Long.valueOf(msisdn);
            long b = MSISDN_SALT - atmosid.charAt(0);
            return String.valueOf(flag ^ b);
        }
        catch (NumberFormatException exp){
            return msisdn;
        }
    }

    public static void main(String[] args)
    {
        String abc = "23498331717";
        String atb = "23498331717/5527c1c8ae93b2d005527d21ad211e0596b1834435d9";
        String a = encodeMsisdn(abc, atb);
        String b = encodeMsisdn(a, atb);
        System.out.println(a);
        System.out.println(b);
    }
}

