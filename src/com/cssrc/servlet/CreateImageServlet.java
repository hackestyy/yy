package com.cssrc.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jfree.data.DefaultCategoryDataset;

import com.cssrc.bean.view.TempBean;
import com.cssrc.chart.Createchart;

public class CreateImageServlet extends HttpServlet {

	private static Thread t = null;

	@Override
	public void init() throws ServletException {
		super.init();
		if (t == null) {
			t = new Thread(new Runnable() {

				public void run() {
				}
			});
			t.start();
		}
	}

	public String sendPost(String url, String paramContent) {
		StringBuffer responseMessage = new StringBuffer();
		java.net.URLConnection connection = null;
		java.net.URL reqUrl = null;
		OutputStreamWriter reqOut = null;
		InputStream in = null;
		BufferedReader br = null;
		String param = paramContent;
		try {
			reqUrl = new java.net.URL(url);
			connection = reqUrl.openConnection();
			connection.setDoOutput(true);
			reqOut = new OutputStreamWriter(connection.getOutputStream(), "utf8");
			reqOut.write(param == null ? "" : param);
			reqOut.flush();
			int charCount = -1;
			in = connection.getInputStream();
			br = new BufferedReader(new InputStreamReader(in, "utf8"));
			while ((charCount = br.read()) != -1) {
				responseMessage.append((char) charCount);
			}
		} catch (Exception ex) {
		} finally {
			try {
				in.close();
				reqOut.close();
			} catch (Exception e) {
			}
		}
		return responseMessage.toString();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("image/jpeg");
		createImage(response.getOutputStream(), request);
	}

	// 柱状图
	private void createImage(OutputStream out, HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		List list = (List) session.getAttribute("STATINFO");
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		String infoClass = request.getParameter("infoClass");
		// 信息汇总
		if (infoClass.equals("info")) {

		}
		// 人数分类
		if (infoClass.equals("syspeo")) {
			DrawHistogramImage(list, "宁波市科协学会会员人数情况统计表", "学会群名称", "人数", "one", out);
		}
		if (infoClass.equals("acadpeo")) {// 横坐标名称不同
			DrawHistogramImage(list, "宁波市科协学会会员人数情况统计表", "学会名称", "人数", "one", out);
		}
		if (infoClass.equals("academypeo")) {
			DrawHistogramImage(list, "宁波市科协学会会员人数情况统计表", "学会名称", "人数", "one", out);
		}

		// 性别情况
		if (infoClass.equals("syssex")) {
			DrawHistogramImage(list, "宁波市科协学会会员性别情况统计表", "学会群名称", "人数", "总人数", "男性人数", "女性人数", out);
		}
		if (infoClass.equals("acadsex")) {
			DrawHistogramImage(list, "宁波市科协学会会员性别情况统计表", "学会名称", "人数", "总人数", "男性人数", "女性人数", out);
		}
		if (infoClass.equals("academysex")) {
			DrawCakeImage(list, "宁波市科协学会性别情况统计表", "人数", "百分比(%)", out);
		}
		// 民族情况
		if (infoClass.equals("sysnation")) {
			DrawHistogramImage(list, "宁波市科协学会会员民族情况统计表", "学会群名称", "人数", "总人数", "汉族", "少数民族", out);
		}
		if (infoClass.equals("acadnation")) {
			DrawHistogramImage(list, "宁波市科协学会会员民族情况统计表", "学会名称", "人数", "总人数", "汉族", "少数民族", out);
		}
		if (infoClass.equals("academynation")) {
			DrawCakeImage(list, "宁波市科协学会民族情况统计表", "人数", "百分比(%)", out);
		}

		// 国籍情况
		if (infoClass.equals("sysnationality")) {
			DrawHistogramImage(list, "宁波市科协学会会员国籍情况统计表", "学会群名称", "人数", "总人数", "中国籍人数", "外国籍人数", out);
		}
		if (infoClass.equals("acadnationality")) {
			DrawHistogramImage(list, "宁波市科协学会会员国籍情况统计表", "学会名称", "人数", "总人数", "中国籍人数", "外国籍人数", out);
		}
		if (infoClass.equals("academynationality")) {
			DrawCakeImage(list, "宁波市科协学会国籍情况统计表", "人数", "百分比(%)", out);
		}

		// 年龄结构
		if (infoClass.equals("age")) {
			DrawCakeImage(list, "宁波市科协学会年龄结构情况统计表", "人数", "百分比(%)", out);
		}
		// 学历情况
		if (infoClass.equals("study")) {
			DrawCakeImage(list, "宁波市科协学会学历情况统计表", "人数", "百分比(%)", out);
		}
		// 职称情况
		if (infoClass.equals("rank")) {
			DrawCakeImage(list, "宁波市科协学会技术职称情况统计表", "人数", "百分比(%)", out);
		}
		// 政治面貌情况
		if (infoClass.equals("party")) {
			// 需求改变，饼图中中国共产党和无党派颜色区别更大
			int size = list.size();
			int i = 0;
			TempBean def = new TempBean();
			def.setAgesegment("");
			def.setRatio(0.0d);
			TempBean tempBean0 = (TempBean) (size > i ? list.get(i++) : def);
			TempBean tempBean1 = (TempBean) (size > i ? list.get(i++) : def);
			TempBean tempBean2 = (TempBean) (size > i ? list.get(i++) : def);
			TempBean tempBean3 = (TempBean) (size > i ? list.get(i++) : def);
			TempBean tempBean4 = (TempBean) (size > i ? list.get(i++) : def);
			TempBean tempBean5 = (TempBean) (size > i ? list.get(i++) : def);
			TempBean tempBean6 = (TempBean) (size > i ? list.get(i++) : def);
			TempBean tempBean7 = (TempBean) (size > i ? list.get(i++) : def);
			TempBean tempBean8 = (TempBean) (size > i ? list.get(i++) : def);
			TempBean tempBean9 = (TempBean) (size > i ? list.get(i++) : def);

			List resultlist = new ArrayList();
			resultlist.add(tempBean0);
			resultlist.add(tempBean1);
			resultlist.add(tempBean2);
			resultlist.add(tempBean3);
			resultlist.add(tempBean4);
			resultlist.add(tempBean5);
			resultlist.add(tempBean6);
			resultlist.add(tempBean7);
			resultlist.add(tempBean8);
			resultlist.add(tempBean9);

			DrawCakeImage(resultlist, "宁波市科协学会会员政治面貌情况统计表", "人数", "百分比(%)", out);
		}
	}

	// 画一个数据的柱状图
	private void DrawHistogramImage(List list, String title, String xstring, String ystring, String one, OutputStream out) {
		Createchart chart = new Createchart(list, title, xstring, ystring, one, out);
	}

	// 画三个数据的柱状图
	private void DrawHistogramImage(List list, String title, String xstring, String ystring, String one, String two, String three, OutputStream out) {
		Createchart chart = new Createchart(list, title, xstring, ystring, one, two, three, out);
	}

	// 画饼状图
	private void DrawCakeImage(List list, String title, String xstring, String ystring, OutputStream out) {
		Createchart chart = new Createchart(list, title, xstring, ystring, out);
	}

}
