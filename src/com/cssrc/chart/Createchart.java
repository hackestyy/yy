package com.cssrc.chart;

import java.awt.Color;
import java.awt.GradientPaint;
import java.io.OutputStream;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.CategoryDataset;
import org.jfree.data.DatasetUtilities;
import org.jfree.data.DefaultCategoryDataset;
import org.jfree.data.DefaultPieDataset;

import com.cssrc.bean.view.TempBean;

public class Createchart {

	public Createchart() {
	}

	// 一个数据柱状图
	public Createchart(List list, String title, String xstring, String ystring, String one, OutputStream out) {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		for (int i = 0; i < list.size(); i++) {
			TempBean tempBean = (TempBean) list.get(i);
			dataset.addValue((Integer) tempBean.getCountshai_id(), tempBean.getAssoname(), tempBean.getAssoname());
		}
		try {
			JFreeChart chart = ChartFactory.createBarChart3D(title, xstring, ystring, dataset, PlotOrientation.VERTICAL, false, false, false);
			chart.setBackgroundPaint(new GradientPaint(0, 0, Color.lightGray, 1200, 0, Color.BLUE)); // 可选，设置图片背景色
			ChartUtilities.writeChartAsJPEG(out, chart, 800, 288);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// 三个数据柱状图
	public Createchart(List list, String title, String xstring, String ystring, String one, String two, String three, OutputStream out) {
		// DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		double[][] numberdata = new double[3][list.size()];
		String[] rowKeys = { one, two, three };
		String[] columnKeys = new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			TempBean tempBean = (TempBean) list.get(i);
			numberdata[0][i] = Double.valueOf(tempBean.getCountshai_id());
			numberdata[1][i] = Double.valueOf(tempBean.getMale());
			numberdata[2][i] = Double.valueOf(tempBean.getFemale());
			columnKeys[i] = tempBean.getAssoname();
			// dataset.addValue((Integer)tempBean.getCountshai_id(),tempBean.getAssoname(),tempBean.getAssoname());
		}
		CategoryDataset dataset = DatasetUtilities.createCategoryDataset(rowKeys, columnKeys, numberdata);
		try {

			JFreeChart chart = ChartFactory.createBarChart3D(title, xstring, ystring, dataset, PlotOrientation.VERTICAL, true, false, false);
			chart.setBackgroundPaint(new GradientPaint(0, 0, Color.lightGray, 1200, 0, Color.BLUE)); // 可选，设置图片背景色
			ChartUtilities.writeChartAsJPEG(out, chart, 800, 288);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// 饼状图
	public Createchart(List list, String title, String xstring, String ystring, OutputStream out) {
		DefaultPieDataset dataset = new DefaultPieDataset();
		// DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		for (int i = 0; i < list.size(); i++) {
			TempBean tempBean = (TempBean) list.get(i);
			dataset.setValue(String.valueOf(tempBean.getAgesegment()), Double.valueOf(tempBean.getRatio()) / 100.00);
		}
		try {
			JFreeChart chart = ChartFactory.createPieChart(title, dataset, true, true, false);
			chart.setBackgroundPaint(new GradientPaint(0, 0, Color.lightGray, 1200, 0, Color.BLUE)); // 可选，设置图片背景色
			ChartUtilities.writeChartAsJPEG(out, chart, 418, 300);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
