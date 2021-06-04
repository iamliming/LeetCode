package graph;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 207. 课程表
 * 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
 *
 * 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi]
 * ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。
 *
 * 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
 * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：numCourses = 2, prerequisites = [[1,0]]
 * 输出：true
 * 解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。
 * 示例 2：
 *
 * 输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
 * 输出：false
 * 解释：总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0 ；并且学习课程 0 之前，你还应先完成课程 1 。这是不可能的。
 *
 *
 * @author liming
 * @version [版本号, 6月 01, 2021]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class CourseSchedule
{
    //bsf
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indeg = new int[numCourses];
        List<List<Integer>> edges = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            edges.add(new ArrayList<>());
        }
        for(int[] edge : prerequisites){
            //出度列表
            edges.get(edge[1]).add(edge[0]);
            //入度
            indeg[edge[0]]++;
        }
        Deque<Integer> stack = new LinkedList<>();
        int activeNum = 0;
        for(int i = 0; i < numCourses; i++){
            if(indeg[i] == 0){
                stack.push(i);
            }
        }
        while(!stack.isEmpty()){
            int idx = stack.pop();
            activeNum++;
            for(int out : edges.get(idx)){
                indeg[out]--;
                if(indeg[out] == 0){
                    stack.push(out);
                }
            }
        }
        return activeNum ==numCourses;
    }

    //dsf
    public boolean canFinishDsf(int numCourses, int[][] prerequisites) {
        int[] indeg = new int[numCourses];
        int[] status = new int[numCourses];
        List<List<Integer>> edges = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            edges.add(new ArrayList<>());
        }
        for(int[] edge : prerequisites){
            //出度列表
            edges.get(edge[1]).add(edge[0]);
            //入度
            indeg[edge[0]]++;
        }
        for(int i = 0; i < numCourses; i++){
            if(status[i] == 0){
                dsf(i, status, edges);
            }
        }
        return wuhuan;
    }
    boolean wuhuan = true;
    public void dsf(int idx, int[] status, List<List<Integer>> edges){
        status[idx] = 1;
        for(int out : edges.get(idx)){
            if(status[out] == 0){
                if(!wuhuan){
                    break;
                }
                else{
                    dsf(out, status, edges);
                }
            }
            else if(status[out] == 1){
                wuhuan = false;
                break;
            }
        }
        status[idx] = 2;
    }

    public static void main(String[] args)
    {
        CourseSchedule courseSchedule = new CourseSchedule();
        int[][] pre = new int[][]{
            {0,1},{3,1},{1,3},{3,2}};
        courseSchedule.canFinishDsf(4, pre);
    }
}
