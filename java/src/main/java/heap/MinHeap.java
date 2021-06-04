package heap;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author liming
 * @version [版本号, 5月 12, 2021]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class MinHeap implements Heap
{
    int[] arr;

    int idx;

    public MinHeap(int len)
    {
        arr = new int[len];
        this.idx = -1;
    }

    @Override
    public void insert(int key)
    {
        if(idx < arr.length - 1)
        {
            idx++;
            arr[idx] = key;
            shiftUp(idx);
        }
        else
        {
            if(arr[0] < key)
            {
                arr[0] = key;
                shiftDown(0);
            }
        }
    }

    @Override
    public void remove()
    {

    }

    @Override
    public void shiftUp(int index)
    {
        if (index == 0)
            return;
        int upIndx = (index - 1) / 2;
        if (arr[upIndx] > arr[index])
        {
            switchVal(upIndx, index);
            shiftUp(upIndx);
        }
    }

    @Override
    public void shiftDown(int index)
    {
        if(index == idx)
            return;
        int left = (index+1)*2 - 1;
        int right = left + 1;
        if(left > idx)
            return;
        if(right > idx){
            if(arr[left] < arr[index]){
                switchVal(left, index);
            }
        }
        else {
            if(arr[left] < arr[index] && arr[left] <= arr[right]){
                switchVal(left, index);
                shiftDown(left);
            }
            else if(arr[right] < arr[index] && arr[right] <= arr[left]){
                switchVal(right, index);
                shiftDown(right);
            }
        }
    }
    public void switchVal(int index1,int index2){
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }

    @Override
    public int top()
    {
        return arr[0];
    }
}
