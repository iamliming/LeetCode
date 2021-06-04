package array;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author liming
 * @version [版本号, 8月 27, 2020]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class Zhongwentihuan
{
    public static String getSubUtilSimple(String soap, String rgex)
    {
        Pattern pattern = Pattern.compile(rgex);// 匹配的模式
        Matcher m = pattern.matcher(soap);
        while (m.find())
        {
            return m.group(1);
        }
        return "";
    }

    public static void main(String[] args)
    {

        String filetext = "abc//@张小名: 25分//@李小花: 43分//@王力: 100分def";
        Pattern pp = Pattern.compile("c\\@(.*?)\\:");//正则表达式，取=和|之间的字符串，不包括=和|
        Matcher mm = pp.matcher(filetext);
        while (mm.find())
        {
            System.out.println(mm.group(0));//m.group(1)不包括这两个字符
        }
        try
        {
            //(文件完整路径),编码格式
            BufferedReader reader =
                new BufferedReader(new InputStreamReader(new FileInputStream("D:\\doc.csv"),
                    "utf-8"));//GBK
            //                 reader.readLine();//显示标题行,没有则注释掉
            //                 System.out.println(reader.readLine());
            String line = null;
            int i = 1;
            String rgex = "\"description\"\":\"\"(.*?)\"\"";
            String nameReg = "(.*?),";
            Pattern patternName = Pattern.compile(nameReg);// 匹配的模式
            Pattern pattern = Pattern.compile(rgex);// 匹配的模式
            while ((line = reader.readLine()) != null)
            {
                i++;
                Matcher mName = patternName.matcher(line);
                String k = null;
                while (mName.find())
                {
                    k = mName.group(1);
                    System.out.println(k);
                    break;
                }
                Matcher m = pattern.matcher(line);
                /*while (m.find())
                {
                    System.out.print(m.group(1));
                    break;
                }*/
            }
            System.out.println(i);
        }
        catch (Exception e)
        {

        }

       /* String k = "  homeland_rankinfo个人排行\n"
            + " getCategoryInfoList(诗词首页下诗词分类)\n"
            + " 诗词朗读计数(countPlayRecord)\n"
            + " homeland_contentrecommend(诗词首页朗读推荐)\n"
            + " homeland_contentcategories(分类下的诗词列表)\n"
            + " homeland_contentinfo(诗词朗读内容详情)\n"
            + " homeland_rank(诗词人气票数榜)\n"
            + " homeland_audioDetail（朗读作品）\n"
            + " 诗词投票(audioVote)\n"
            + " homePageTopUrl（诗词首页返回搜索地址和个人页地址）\n"
            + " userReadingCenter（个人中心主页）\n"
            + " getPlayPageInfo（录音棚）\n"
            + " searchPageInfo（搜索作品）\n"
            + " uploadAudio(录音上传"
            + "\n"
            + "\n"
            + "\n"
            + "\n"
            + "\n"
            + "\n"
            + "\n"
            + "\n"
            + "\n"
            + "\n"
            + "";
        String[] kk = k.split("\n");

        for(String s : kk)
        {
            String m = s.replaceAll("[^\u4E00-\u9FA5]", "").replaceAll("田","");
            if(m == null || m.length() == 0){
                System.out.println(s);
            }
            else{
                System.out.println(m);
            }
        }*/
    }
}
