package com.cssrc.sys;

import java.awt.Color;
import java.awt.GradientPaint;
import java.io.OutputStream;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.XYDataset;
import org.jfree.data.XYSeries;
import org.jfree.data.XYSeriesCollection;

/**
 * <p>
 * Title:
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2005
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author not attributable
 * @version 1.0
 */
public class Createchart {
	private double[] rs1; // Ҫ��ͼ������
	private double[] rs2; // Ҫ��ͼ������
	private double[] rs3; // Ҫ��ͼ������
	private double[] rs4; // Ҫ��ͼ������
	private String title; // ͼƬ�ܱ���
	private String subtitle1; // ͼƬ��һ���߱���
	private String subtitle2; // ͼƬ�ڶ����߱���
	private String subtitle3; // ͼƬ�������߱���
	private String xstring; // �������ǩ
	private String ystring; // �������ǩ
	private int quantity; // ��������

	public Createchart() {
	}

	// ////��1����////////////////////
	public Createchart(double[] input_rs1, double[] input_rs2, String chart_title, String chart_xstring, String chart_ystring) {
		quantity = 1;
		title = chart_title;
		xstring = chart_xstring;
		ystring = chart_ystring;

		int iLength = 0;
		for (int i = 0; i < input_rs1.length; i++) {
			if (input_rs1[i] != 0) {
				iLength++;
			}
		}
		rs1 = new double[iLength]; // Ҫ��ͼ��2ά����
		rs2 = new double[iLength]; // Ҫ��ͼ��2ά����
		for (int i = 0; i < iLength; i++) {
			rs1[i] = input_rs1[i];
			rs2[i] = input_rs2[i];
		}
	}

	// /////��������
	public Createchart(int linequantity, double[] input_rs1, double[] input_rs2, double[] input_rs3, String chart_title, String subTitle1, String subTitle2, String chart_xstring, String chart_ystring) {
		quantity = linequantity;
		title = chart_title;
		subtitle1 = subTitle1;
		subtitle2 = subTitle2;
		xstring = chart_xstring;
		ystring = chart_ystring;

		int iLength = 0;
		for (int i = 0; i < input_rs1.length; i++) {
			if (input_rs1[i] != 0) {
				iLength++;
			}
		}
		rs1 = new double[iLength]; // Ҫ��ͼ��2ά����
		rs2 = new double[iLength]; // Ҫ��ͼ��2ά����
		rs3 = new double[iLength]; // Ҫ��ͼ��2ά����
		for (int i = 0; i < iLength; i++) {
			rs1[i] = input_rs1[i];
			rs2[i] = input_rs2[i];
			rs3[i] = input_rs3[i];
		}

	}

	// /////��������/////
	public Createchart(int linequantity, double[] input_rs1, double[] input_rs2, double[] input_rs3, double[] input_rs4, String chart_title, String subTitle1, String subTitle2, String subTitle3, String chart_xstring, String chart_ystring) {
		quantity = linequantity;
		title = chart_title;
		subtitle1 = subTitle1;
		subtitle2 = subTitle2;
		subtitle3 = subTitle3;
		xstring = chart_xstring;
		ystring = chart_ystring;
		int iLength = 0;
		for (int i = 0; i < input_rs1.length; i++) {
			if (input_rs1[i] != 0) {
				iLength++;
			}
		}
		rs1 = new double[iLength]; // Ҫ��ͼ��2ά����
		rs2 = new double[iLength]; // Ҫ��ͼ��2ά����
		rs3 = new double[iLength]; // Ҫ��ͼ��2ά����
		rs4 = new double[iLength]; // Ҫ��ͼ��2ά����
		for (int i = 0; i < iLength; i++) {
			rs1[i] = input_rs1[i];
			rs2[i] = input_rs2[i];
			rs3[i] = input_rs3[i];
			rs4[i] = input_rs4[i];
		}

	}

	// ��ά�����γɵ�����
	public XYSeriesCollection DataToSeriesCollection() {
		XYSeriesCollection collection = new XYSeriesCollection();
		if (1 == quantity) {
			XYSeries series1 = new XYSeries(title);
			try {
				for (int i = 0; i < rs1.length; i++) {
					series1.add(rs1[i], rs2[i]);
				}
			} catch (Exception e) {
				System.out.print(e.getMessage());
			}
			collection.addSeries(series1);
		} else if (3 == quantity) {
			XYSeries series1 = new XYSeries(subtitle1);
			XYSeries series2 = new XYSeries(subtitle2);
			XYSeries series3 = new XYSeries(subtitle3);
			try {
				for (int i = 0; i < rs1.length; i++) {
					series1.add(rs1[i], rs2[i]);
					series2.add(rs1[i], rs3[i]);
					series3.add(rs1[i], rs4[i]);
				}
			} catch (Exception e) {
				System.out.print(e.getMessage());
			}
			collection.addSeries(series1);
			collection.addSeries(series2);
			collection.addSeries(series3);

		}
		return collection;
	}

	// ���ݵ����껭��
	public void drawline(OutputStream out) {
		try {
			XYDataset xyDataset = DataToSeriesCollection();
			JFreeChart chart = ChartFactory.createXYLineChart(title, xstring, ystring, xyDataset, PlotOrientation.VERTICAL, true, true, true);
			// ���ñ���ɫ
			chart.setBackgroundPaint(new GradientPaint(0, 0, Color.lightGray, 1200, 0, Color.blue)); // ��ѡ
			/*
			 * chart.setTitle(new TextTitle(title, new
			 * Font("\u00C1\u00A5\u00CA��", Font.ITALIC, 15))); Font font=new
			 * Font("\u00BA\u00DA\u00CC\u00E5",Font.TRUETYPE_FONT, 12);
			 * StandardLegend legend = (StandardLegend) chart.getLegend();
			 * legend.setItemFont(font); CategoryPlot plot =
			 * (CategoryPlot)chart.getPlot(); plot.setForegroundAlpha(0.9F);
			 * CategoryAxis domain_axis = plot.getDomainAxis();
			 * domain_axis.setTickLabelFont(font);
			 * ValueAxis value_axis=plot.getRangeAxis();
			 * value_axis.setTickLabelFont(font);
			 */

			ChartUtilities.writeChartAsJPEG(out, chart, 500, 300);
		} catch (Exception e) {
			System.out.println(e);

		}
	}

}
