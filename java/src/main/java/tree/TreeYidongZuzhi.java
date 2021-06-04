package tree;

import java.util.List;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author liming
 * @version [版本号, 4月 22, 2021]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class TreeYidongZuzhi
{
    int level;
    String name;
    List<TreeYidongZuzhi> child;

    public TreeYidongZuzhi(int level, String name, List<TreeYidongZuzhi> child)
    {
        this.level = level;
        this.name = name;
        this.child = child;
    }

    public boolean hasChild(String cld){
        for(TreeYidongZuzhi z : child){
            if(z.getName().equals(cld)){
                return true;
            }
        }
        return false;
    }
    public void addChild(TreeYidongZuzhi cld){
        child.add(cld);
    }
    public int getLevel(){
        return level;
    }

    public String getName()
    {
        return name;
    }

    public TreeYidongZuzhi getChild(String cld){
        for(TreeYidongZuzhi z : child){
            if(z.getName().equals(cld)){
                return z;
            }
        }
        return null;
    }

    public List<TreeYidongZuzhi> getChilds()
    {
        return child;
    }
}
