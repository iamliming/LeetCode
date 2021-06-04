package heap;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author liming
 * @version [版本号, 5月 12, 2021]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public interface Heap
{
    void insert(int key);
    void remove();
    void shiftUp(int low);
    void shiftDown(int index);
    int top();
}
