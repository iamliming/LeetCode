package jfreechart;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtilities;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author liming
 * @version [版本号, 七月 11, 2019]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class JfreechartDemo
{


        /**
         * 创建JFreeChart Line Chart（折线图）
         */
        public static void main(String[] args) {
            System.out.println(31*24*3600);
            int i = (int)((Math.log(1 + (Math.E - 1) * 31 / 31))*1000000);
            System.out.println(i);
            if(true) return;
            // 步骤1：创建CategoryDataset对象（准备数据）
            CategoryDataset dataset = createDataset();
            // 步骤2：根据Dataset 生成JFreeChart对象，以及做相应的设置
            JFreeChart freeChart = createChart(dataset);
            // 步骤3：将JFreeChart对象输出到文件，Servlet输出流等
            saveAsFile(freeChart, "E:\\line.jpg", 100, 100);
        }

        // 保存为文件
        public static void saveAsFile(JFreeChart chart, String outputPath,
            int weight, int height) {
            FileOutputStream out = null;
            try {
                File outFile = new File(outputPath);
                if (!outFile.getParentFile().exists()) {
                    outFile.getParentFile().mkdirs();
                }
                out = new FileOutputStream(outputPath);
                // 保存为PNG
                // ChartUtilities.writeChartAsPNG(out, chart, 600, 400);
                // 保存为JPEG
                ChartUtilities.writeChartAsJPEG(out, chart, 5000, 5000);
                out.flush();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (out != null) {
                    try {
                        out.close();
                    } catch (IOException e) {
                        // do nothing
                    }
                }
            }
        }

        // 根据CategoryDataset创建JFreeChart对象
        public static JFreeChart createChart(CategoryDataset categoryDataset) {
            // 创建JFreeChart对象：ChartFactory.createLineChart
            JFreeChart jfreechart = ChartFactory.createLineChart("time line", // 标题
                "day", // categoryAxisLabel （category轴，横轴，X轴标签）
                "nums", // valueAxisLabel（value轴，纵轴，Y轴的标签）
                categoryDataset, // dataset
                PlotOrientation.VERTICAL, true, // legend
                false, // tooltips
                false); // URLs
            // 使用CategoryPlot设置各种参数。以下设置可以省略。
            CategoryPlot plot = (CategoryPlot)jfreechart.getPlot();
            // 背景色 透明度
            plot.setBackgroundAlpha(0.5f);
            // 前景色 透明度
            plot.setForegroundAlpha(0.5f);
            // 其他设置 参考 CategoryPlot类
            LineAndShapeRenderer renderer = (LineAndShapeRenderer)plot.getRenderer();
            renderer.setBaseShapesVisible(true); // series 点（即数据点）可见
            renderer.setBaseLinesVisible(true); // series 点（即数据点）间有连线可见
            renderer.setUseSeriesOffset(true); // 设置偏移量
            renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
            renderer.setBaseItemLabelsVisible(false);
            return jfreechart;
        }

        /**
         * 创建CategoryDataset对象
         *
         */
        public static CategoryDataset createDataset() {
//            String[] rowKeys = {"day","day1"};
//            String[] colKeys = new String[1000];
//            double[] datas = new double[1000];
//            double[] datas1 = new double[1000];
//            for(int i = 1; i<= 2678400; i++){
//
//                colKeys[i - 1] = i+"";
//                datas[i-1] = (int)((Math.log(1 + (Math.E - 1) * i / 2678400))*1000000);
//                datas1[i-1] = (int)((Math.log(1 + (Math.E - 1) * i / 2678400))*950000);
//                System.out.println(datas[i-1]);
//                if(i == 1000) break;
//            }
//            double[][] data = {datas,datas1,};
            String[] rowKeys = {"day","day1"};
            String[] colKeys = new String[44640];
            double[] datas = new double[44640];
            double[] datas1 = new double[44640];
            for(int i = 1; i<= 44640; i++){

                colKeys[i - 1] = i+"";
                datas[i-1] = (int)((Math.log(1 + (Math.E - 1) * i / 44640))*1000000);
                datas1[i-1] = (int)(datas[i-1]/1.5);
            }
            double[][] data = {datas,datas1,};

            // 或者使用类似以下代码
            // DefaultCategoryDataset categoryDataset = new
            // DefaultCategoryDataset();
            // categoryDataset.addValue(10, "rowKey", "colKey");

            return DatasetUtilities.createCategoryDataset(rowKeys, colKeys, data);
        }
}
