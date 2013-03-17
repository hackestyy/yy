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

	// ��״ͼ
	private void createImage(OutputStream out, HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		List list = (List) session.getAttribute("STATINFO");
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		String infoClass = request.getParameter("infoClass");
		// ��Ϣ����
		if (infoClass.equals("info")) {

		}
		// ��������
		if (infoClass.equals("syspeo")) {
			DrawHistogramImage(list, "�����п�Эѧ���Ա�������ͳ�Ʊ�", "ѧ��Ⱥ����", "����", "one", out);
		}
		if (infoClass.equals("acadpeo")) {// ���������Ʋ�ͬ
			DrawHistogramImage(list, "�����п�Эѧ���Ա�������ͳ�Ʊ�", "ѧ������", "����", "one", out);
		}
		if (infoClass.equals("academypeo")) {
			DrawHistogramImage(list, "�����п�Эѧ���Ա�������ͳ�Ʊ�", "ѧ������", "����", "one", out);
		}

		// �Ա����
		if (infoClass.equals("syssex")) {
			DrawHistogramImage(list, "�����п�Эѧ���Ա�Ա����ͳ�Ʊ�", "ѧ��Ⱥ����", "����", "������", "��������", "Ů������", out);
		}
		if (infoClass.equals("acadsex")) {
			DrawHistogramImage(list, "�����п�Эѧ���Ա�Ա����ͳ�Ʊ�", "ѧ������", "����", "������", "��������", "Ů������", out);
		}
		if (infoClass.equals("academysex")) {
			DrawCakeImage(list, "�����п�Эѧ���Ա����ͳ�Ʊ�", "����", "�ٷֱ�(%)", out);
		}
		// �������
		if (infoClass.equals("sysnation")) {
			DrawHistogramImage(list, "�����п�Эѧ���Ա�������ͳ�Ʊ�", "ѧ��Ⱥ����", "����", "������", "����", "��������", out);
		}
		if (infoClass.equals("acadnation")) {
			DrawHistogramImage(list, "�����п�Эѧ���Ա�������ͳ�Ʊ�", "ѧ������", "����", "������", "����", "��������", out);
		}
		if (infoClass.equals("academynation")) {
			DrawCakeImage(list, "�����п�Эѧ���������ͳ�Ʊ�", "����", "�ٷֱ�(%)", out);
		}

		// �������
		if (infoClass.equals("sysnationality")) {
			DrawHistogramImage(list, "�����п�Эѧ���Ա�������ͳ�Ʊ�", "ѧ��Ⱥ����", "����", "������", "�й�������", "���������", out);
		}
		if (infoClass.equals("acadnationality")) {
			DrawHistogramImage(list, "�����п�Эѧ���Ա�������ͳ�Ʊ�", "ѧ������", "����", "������", "�й�������", "���������", out);
		}
		if (infoClass.equals("academynationality")) {
			DrawCakeImage(list, "�����п�Эѧ��������ͳ�Ʊ�", "����", "�ٷֱ�(%)", out);
		}

		// ����ṹ
		if (infoClass.equals("age")) {
			DrawCakeImage(list, "�����п�Эѧ������ṹ���ͳ�Ʊ�", "����", "�ٷֱ�(%)", out);
		}
		// ѧ�����
		if (infoClass.equals("study")) {
			DrawCakeImage(list, "�����п�Эѧ��ѧ�����ͳ�Ʊ�", "����", "�ٷֱ�(%)", out);
		}
		// ְ�����
		if (infoClass.equals("rank")) {
			DrawCakeImage(list, "�����п�Эѧ�Ἴ��ְ�����ͳ�Ʊ�", "����", "�ٷֱ�(%)", out);
		}
		// ������ò���
		if (infoClass.equals("party")) {
			// ����ı䣬��ͼ���й����������޵�����ɫ�������
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

			DrawCakeImage(resultlist, "�����п�Эѧ���Ա������ò���ͳ�Ʊ�", "����", "�ٷֱ�(%)", out);
		}
	}

	// ��һ�����ݵ���״ͼ
	private void DrawHistogramImage(List list, String title, String xstring, String ystring, String one, OutputStream out) {
		Createchart chart = new Createchart(list, title, xstring, ystring, one, out);
	}

	// ���������ݵ���״ͼ
	private void DrawHistogramImage(List list, String title, String xstring, String ystring, String one, String two, String three, OutputStream out) {
		Createchart chart = new Createchart(list, title, xstring, ystring, one, two, three, out);
	}

	// ����״ͼ
	private void DrawCakeImage(List list, String title, String xstring, String ystring, OutputStream out) {
		Createchart chart = new Createchart(list, title, xstring, ystring, out);
	}

}
