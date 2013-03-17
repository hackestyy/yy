// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   WriteExcel.java

package com.cssrc.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import com.cssrc.bean.admin.Academygmemberrelation;
import com.cssrc.bean.admin.Academysmemberrelation;
import com.cssrc.bean.admin.Gmemberbaseinfo;
import com.cssrc.bean.admin.Gmemberbaseinforelation;
import com.cssrc.bean.admin.Gmemberpatentinfo;
import com.cssrc.bean.admin.Gmemberresearchproduction;
import com.cssrc.bean.admin.Smemberacademicliterature;
import com.cssrc.bean.admin.Smemberbainforelation;
import com.cssrc.bean.admin.Smemberbaseinfo;
import com.cssrc.bean.admin.Smemberdeputyinfo;
import com.cssrc.bean.admin.Smemberpastjob;
import com.cssrc.bean.admin.Smemberpatentinfo;
import com.cssrc.bean.admin.Smemberresearchproduction;
import com.cssrc.bean.view.TempBean;
import com.cssrc.web.form.admin.GroupStatForm;
import com.cssrc.web.form.admin.UserLogForm;

// Referenced classes of package com.cssrc.util:
//			ExcelStyleFormat, DateUtil

public class WriteExcel {

	public WriteExcel() {
	}

	public WriteExcel(List list, String UPath, String outputFile, double one, double two, double three, String tabletitle) {
		try {
			Workbook wb = Workbook.getWorkbook(new File(UPath));
			ByteArrayOutputStream targetFile = new ByteArrayOutputStream();
			WritableWorkbook wwb = Workbook.createWorkbook(targetFile, wb);
			WritableSheet wws = wwb.getSheet("Sheet1");
			wws.addCell(new Label(0, 0, tabletitle, ExcelStyleFormat.style13()));
			for (int i = 0; i < list.size(); i++) {
				TempBean tempBean = (TempBean) (TempBean) list.get(i);
				wws.addCell(new Label(3, i + 2, String.valueOf(tempBean.getNumber()), ExcelStyleFormat.style6()));
				wws.addCell(new Label(4, i + 2, String.valueOf(tempBean.getRatio()), ExcelStyleFormat.style6()));
			}

			wwb.write();
			wwb.close();
			wb.close();
			FileOutputStream fos = new FileOutputStream(outputFile);
			targetFile.writeTo(fos);
			targetFile.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public WriteExcel(List list, String UPath, String outputFile, String three, String tabletitle) {
		try {
			Workbook wb = Workbook.getWorkbook(new File(UPath));
			ByteArrayOutputStream targetFile = new ByteArrayOutputStream();
			WritableWorkbook wwb = Workbook.createWorkbook(targetFile, wb);
			WritableSheet wws = wwb.getSheet("Sheet1");
			wws.addCell(new Label(0, 0, tabletitle, ExcelStyleFormat.style13()));
			for (int i = 0; i < list.size(); i++) {
				TempBean tempBean = (TempBean) (TempBean) list.get(i);
				if (tempBean.getSerialnumber() != null) {
					wws.addCell(new Label(0, i + 2, String.valueOf(tempBean.getSerialnumber()), ExcelStyleFormat.style14()));
				} else {
					wws.addCell(new Label(0, i + 2, "", ExcelStyleFormat.style14()));
				}
				wws.addCell(new Label(1, i + 2, String.valueOf(tempBean.getAgesegment()), ExcelStyleFormat.style6()));
				wws.addCell(new Label(2, i + 2, String.valueOf(tempBean.getNumber()), ExcelStyleFormat.style6()));
				wws.addCell(new Label(3, i + 2, String.valueOf(tempBean.getRatio()), ExcelStyleFormat.style6()));
				wws.addCell(new Label(4, i + 2, " ", ExcelStyleFormat.style6()));
			}

			wwb.write();
			wwb.close();
			wb.close();
			FileOutputStream fos = new FileOutputStream(outputFile);
			targetFile.writeTo(fos);
			targetFile.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public WriteExcel(List list, String UPath, String outputFile, int threespecial, String tabletitle, int a) {
		try {
			Workbook wb = Workbook.getWorkbook(new File(UPath));
			ByteArrayOutputStream targetFile = new ByteArrayOutputStream();
			WritableWorkbook wwb = Workbook.createWorkbook(targetFile, wb);
			WritableSheet wws = wwb.getSheet("Sheet1");
			wws.addCell(new Label(0, 0, tabletitle, ExcelStyleFormat.style13()));
			for (int i = 0; i < list.size(); i++) {
				TempBean tempBean = (TempBean) (TempBean) list.get(i);
				wws.addCell(new Label(3, i + 2, String.valueOf(tempBean.getNumber()), ExcelStyleFormat.style6()));
				wws.addCell(new Label(4, i + 2, String.valueOf(tempBean.getRatio()), ExcelStyleFormat.style6()));
			}

			wwb.write();
			wwb.close();
			wb.close();
			FileOutputStream fos = new FileOutputStream(outputFile);
			targetFile.writeTo(fos);
			targetFile.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public WriteExcel(List list, String UPath, String outputFile, double four, String tabletitle) {
		try {
			Workbook wb = Workbook.getWorkbook(new File(UPath));
			ByteArrayOutputStream targetFile = new ByteArrayOutputStream();
			WritableWorkbook wwb = Workbook.createWorkbook(targetFile, wb);
			WritableSheet wws = wwb.getSheet("Sheet1");
			wws.addCell(new Label(0, 0, tabletitle, ExcelStyleFormat.style13()));
			for (int i = 0; i < list.size(); i++) {
				TempBean tempBean = (TempBean) (TempBean) list.get(i);
				if (tempBean.getSerialnumber() != null)
					wws.addCell(new Label(0, i + 2, String.valueOf(tempBean.getSerialnumber()), ExcelStyleFormat.style14()));
				else
					wws.addCell(new Label(0, i + 2, "", ExcelStyleFormat.style14()));
				wws.addCell(new Label(1, i + 2, String.valueOf(tempBean.getAssoname()), ExcelStyleFormat.style6()));
				wws.addCell(new Label(2, i + 2, String.valueOf(tempBean.getCountshai_id()), ExcelStyleFormat.style6()));
				if (tempBean.getNumber() == null) {
					wws.addCell(new Label(3, i + 2, String.valueOf(""), ExcelStyleFormat.style6()));
				} else {
					wws.addCell(new Label(3, i + 2, String.valueOf(tempBean.getNumber()), ExcelStyleFormat.style6()));
				}
				wws.addCell(new Label(4, i + 2, " ", ExcelStyleFormat.style6()));
			}

			wwb.write();
			wwb.close();
			wb.close();
			FileOutputStream fos = new FileOutputStream(outputFile);
			targetFile.writeTo(fos);
			targetFile.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public WriteExcel(List list, String UPath, String outputFile, double four, double five, String tabletitle) {
		try {
			Workbook wb = Workbook.getWorkbook(new File(UPath));
			ByteArrayOutputStream targetFile = new ByteArrayOutputStream();
			WritableWorkbook wwb = Workbook.createWorkbook(targetFile, wb);
			WritableSheet wws = wwb.getSheet("Sheet1");
			wws.addCell(new Label(0, 0, tabletitle, ExcelStyleFormat.style13()));
			for (int i = 0; i < list.size(); i++) {
				TempBean tempBean = (TempBean) (TempBean) list.get(i);
				wws.addCell(new Label(0, i + 2, String.valueOf(tempBean.getAcadno()), ExcelStyleFormat.style14()));
				wws.addCell(new Label(1, i + 2, String.valueOf(tempBean.getAssoname()), ExcelStyleFormat.style6()));
				wws.addCell(new Label(2, i + 2, String.valueOf(tempBean.getCountshai_id()), ExcelStyleFormat.style6()));
				wws.addCell(new Label(3, i + 2, String.valueOf(tempBean.getNumber()), ExcelStyleFormat.style6()));
				wws.addCell(new Label(4, i + 2, " ", ExcelStyleFormat.style6()));
			}

			wwb.write();
			wwb.close();
			wb.close();
			FileOutputStream fos = new FileOutputStream(outputFile);
			targetFile.writeTo(fos);
			targetFile.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public WriteExcel(List list, String UPath, String outputFile, String tabletitle, int a) {
		try {
			Workbook wb = Workbook.getWorkbook(new File(UPath));
			ByteArrayOutputStream targetFile = new ByteArrayOutputStream();
			WritableWorkbook wwb = Workbook.createWorkbook(targetFile, wb);
			WritableSheet wws = wwb.getSheet("Sheet1");
			wws.addCell(new Label(0, 0, tabletitle, ExcelStyleFormat.style13()));
			for (int i = 0; i < list.size(); i++) {
				TempBean tempBean = (TempBean) (TempBean) list.get(i);
				if (tempBean.getSerialnumber() != null)
					wws.addCell(new Label(0, i + 3, String.valueOf(tempBean.getSerialnumber()), ExcelStyleFormat.style14()));
				else
					wws.addCell(new Label(0, i + 3, " ", ExcelStyleFormat.style14()));
				wws.addCell(new Label(1, i + 3, String.valueOf(tempBean.getAssoname()), ExcelStyleFormat.style14()));
				wws.addCell(new Label(2, i + 3, String.valueOf(tempBean.getCountshai_id()), ExcelStyleFormat.style6()));
				wws.addCell(new Label(3, i + 3, String.valueOf(tempBean.getMale()), ExcelStyleFormat.style6()));
				wws.addCell(new Label(4, i + 3, String.valueOf(tempBean.getMaleratio()), ExcelStyleFormat.style6()));
				wws.addCell(new Label(5, i + 3, String.valueOf(tempBean.getFemale()), ExcelStyleFormat.style6()));
				wws.addCell(new Label(6, i + 3, String.valueOf(tempBean.getFemaleratio()), ExcelStyleFormat.style6()));
			}

			wwb.write();
			wwb.close();
			wb.close();
			FileOutputStream fos = new FileOutputStream(outputFile);
			targetFile.writeTo(fos);
			targetFile.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public WriteExcel(List list, String UPath, String outputFile, String tabletitle, double four, int five) {
		try {
			Workbook wb = Workbook.getWorkbook(new File(UPath));
			ByteArrayOutputStream targetFile = new ByteArrayOutputStream();
			WritableWorkbook wwb = Workbook.createWorkbook(targetFile, wb);
			WritableSheet wws = wwb.getSheet("Sheet1");
			wws.addCell(new Label(0, 0, tabletitle, ExcelStyleFormat.style13()));
			for (int i = 0; i < list.size(); i++) {
				TempBean tempBean = (TempBean) (TempBean) list.get(i);
				wws.addCell(new Label(0, i + 3, String.valueOf(tempBean.getAcadno()), ExcelStyleFormat.style14()));
				wws.addCell(new Label(1, i + 3, String.valueOf(tempBean.getAssoname()), ExcelStyleFormat.style6()));
				wws.addCell(new Label(2, i + 3, String.valueOf(tempBean.getCountshai_id()), ExcelStyleFormat.style6()));
				wws.addCell(new Label(3, i + 3, String.valueOf(tempBean.getMale()), ExcelStyleFormat.style6()));
				wws.addCell(new Label(4, i + 3, String.valueOf(tempBean.getMaleratio()), ExcelStyleFormat.style6()));
				wws.addCell(new Label(5, i + 3, String.valueOf(tempBean.getFemale()), ExcelStyleFormat.style6()));
				wws.addCell(new Label(6, i + 3, String.valueOf(tempBean.getFemaleratio()), ExcelStyleFormat.style6()));
			}

			wwb.write();
			wwb.close();
			wb.close();
			FileOutputStream fos = new FileOutputStream(outputFile);
			targetFile.writeTo(fos);
			targetFile.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public WriteExcel(List list, String UPath, String outputFile, double four, double five, int six, String tabletitle, String a) {
		try {
			Workbook wb = Workbook.getWorkbook(new File(UPath));
			ByteArrayOutputStream targetFile = new ByteArrayOutputStream();
			WritableWorkbook wwb = Workbook.createWorkbook(targetFile, wb);
			WritableSheet wws = wwb.getSheet("Sheet1");
			wws.addCell(new Label(0, 0, tabletitle, ExcelStyleFormat.style13()));
			for (int i = 0; i < list.size(); i++) {
				TempBean tempBean = (TempBean) (TempBean) list.get(i);
				wws.addCell(new Label(0, i + 2, String.valueOf(tempBean.getAssoduty_s()), ExcelStyleFormat.style14()));
				wws.addCell(new Label(1, i + 2, String.valueOf(tempBean.getAssoduty_f()), ExcelStyleFormat.style6()));
				wws.addCell(new Label(2, i + 2, String.valueOf(tempBean.getPeoplenum()), ExcelStyleFormat.style6()));
				wws.addCell(new Label(3, i + 2, " ", ExcelStyleFormat.style6()));
			}

			wwb.write();
			wwb.close();
			wb.close();
			FileOutputStream fos = new FileOutputStream(outputFile);
			targetFile.writeTo(fos);
			targetFile.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public WriteExcel(List list, String UPath, String outputFile, double four, int five, String a, String tabletitle, int one) {
		try {
			Workbook wb = Workbook.getWorkbook(new File(UPath));
			ByteArrayOutputStream targetFile = new ByteArrayOutputStream();
			WritableWorkbook wwb = Workbook.createWorkbook(targetFile, wb);
			WritableSheet wws = wwb.getSheet("Sheet1");
			wws.addCell(new Label(0, 0, tabletitle, ExcelStyleFormat.style13()));
			for (int i = 0; i < list.size(); i++) {
				TempBean tempBean = (TempBean) (TempBean) list.get(i);
				wws.addCell(new Label(0, i + 3, String.valueOf(tempBean.getAssoduty_s()), ExcelStyleFormat.style14()));
				wws.addCell(new Label(1, i + 3, String.valueOf(tempBean.getAssoduty_f()), ExcelStyleFormat.style6()));
				wws.addCell(new Label(2, i + 3, String.valueOf(tempBean.getCountshai_id()), ExcelStyleFormat.style6()));
				wws.addCell(new Label(3, i + 3, String.valueOf(tempBean.getMale()), ExcelStyleFormat.style6()));
				wws.addCell(new Label(4, i + 3, String.valueOf(tempBean.getMaleratio()), ExcelStyleFormat.style6()));
				wws.addCell(new Label(5, i + 3, String.valueOf(tempBean.getFemale()), ExcelStyleFormat.style6()));
				wws.addCell(new Label(6, i + 3, String.valueOf(tempBean.getFemaleratio()), ExcelStyleFormat.style6()));
			}

			wwb.write();
			wwb.close();
			wb.close();
			FileOutputStream fos = new FileOutputStream(outputFile);
			targetFile.writeTo(fos);
			targetFile.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public WriteExcel(List list, String UPath, String outputFile, double four, int five, String a, String b, String tabletitle, int one) {
		try {
			Workbook wb = Workbook.getWorkbook(new File(UPath));
			ByteArrayOutputStream targetFile = new ByteArrayOutputStream();
			WritableWorkbook wwb = Workbook.createWorkbook(targetFile, wb);
			WritableSheet wws = wwb.getSheet("Sheet1");
			wws.addCell(new Label(0, 0, tabletitle, ExcelStyleFormat.style13()));
			for (int i = 0; i < list.size(); i++) {
				TempBean tempBean = (TempBean) (TempBean) list.get(i);
				if (tempBean.getSerialnumber() != null)
					wws.addCell(new Label(0, i + 2, String.valueOf(tempBean.getSerialnumber()), ExcelStyleFormat.style14()));
				else
					wws.addCell(new Label(0, i + 2, " ", ExcelStyleFormat.style14()));
				wws.addCell(new Label(1, i + 2, String.valueOf(tempBean.getAssoduty_s()), ExcelStyleFormat.style6()));
				wws.addCell(new Label(2, i + 2, String.valueOf(tempBean.getAssoduty_f()), ExcelStyleFormat.style6()));
				wws.addCell(new Label(3, i + 2, String.valueOf(tempBean.getAgesegment()), ExcelStyleFormat.style6()));
				wws.addCell(new Label(4, i + 2, String.valueOf(tempBean.getNumber()), ExcelStyleFormat.style6()));
				wws.addCell(new Label(5, i + 2, String.valueOf(tempBean.getRatio()), ExcelStyleFormat.style6()));
				wws.addCell(new Label(6, i + 2, " ", ExcelStyleFormat.style6()));
			}

			wwb.write();
			wwb.close();
			wb.close();
			FileOutputStream fos = new FileOutputStream(outputFile);
			targetFile.writeTo(fos);
			targetFile.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public WriteExcel(List list, String UPath, String outputFile, double four, int five, String a, String b, String c, String tabletitle, int one) {
		try {
			Workbook wb = Workbook.getWorkbook(new File(UPath));
			ByteArrayOutputStream targetFile = new ByteArrayOutputStream();
			WritableWorkbook wwb = Workbook.createWorkbook(targetFile, wb);
			WritableSheet wws = wwb.getSheet("Sheet1");
			TempBean bean = (TempBean) (TempBean) list.get(0);
			wws.addCell(new Label(0, 0, tabletitle, ExcelStyleFormat.style13()));
			for (int i = 0; i < list.size(); i++) {
				TempBean tempBean = (TempBean) (TempBean) list.get(i);
				wws.addCell(new Label(3, i + 2, String.valueOf(tempBean.getNumber()), ExcelStyleFormat.style6()));
				wws.addCell(new Label(4, i + 2, String.valueOf(tempBean.getRatio()), ExcelStyleFormat.style6()));
			}

			wwb.write();
			wwb.close();
			wb.close();
			FileOutputStream fos = new FileOutputStream(outputFile);
			targetFile.writeTo(fos);
			targetFile.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public WriteExcel(List list, String UPath, String outputFile, double four, int five, String a, String b, String c, String d, String tabletitle) {
		try {
			Workbook wb = Workbook.getWorkbook(new File(UPath));
			ByteArrayOutputStream targetFile = new ByteArrayOutputStream();
			WritableWorkbook wwb = Workbook.createWorkbook(targetFile, wb);
			WritableSheet wws = wwb.getSheet("Sheet1");
			TempBean bean = (TempBean) (TempBean) list.get(0);
			wws.addCell(new Label(0, 0, tabletitle, ExcelStyleFormat.style13()));
			for (int i = 0; i < list.size(); i++) {
				TempBean tempBean = (TempBean) (TempBean) list.get(i);
				wws.addCell(new Label(3, i + 2, String.valueOf(tempBean.getNumber()), ExcelStyleFormat.style6()));
				wws.addCell(new Label(4, i + 2, String.valueOf(tempBean.getRatio()), ExcelStyleFormat.style6()));
			}

			wwb.write();
			wwb.close();
			wb.close();
			FileOutputStream fos = new FileOutputStream(outputFile);
			targetFile.writeTo(fos);
			targetFile.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public WriteExcel(List list, String academyname, String UPath, String outputFile, String a, String b, String c, String d) {
		try {
			Workbook wb = Workbook.getWorkbook(new File(UPath));
			ByteArrayOutputStream targetFile = new ByteArrayOutputStream();
			WritableWorkbook wwb = Workbook.createWorkbook(targetFile, wb);
			WritableSheet wws = wwb.getSheet("Sheet1");
			String title = (new StringBuilder(String.valueOf(academyname))).append("会员列表").toString();
			wws.addCell(new Label(0, 0, title));
			for (int i = 0; i < list.size(); i++) {
				Smemberbainforelation bean = (Smemberbainforelation) list.get(i);
				wws.addCell(new Label(0, i + 2, String.valueOf(bean.getNo())));
				wws.addCell(new Label(1, i + 2, String.valueOf(bean.getMemno())));
				wws.addCell(new Label(2, i + 2, String.valueOf(bean.getMemname())));
				wws.addCell(new Label(3, i + 2, String.valueOf(bean.getMemsex())));
				wws.addCell(new Label(4, i + 2, String.valueOf(bean.getMembirthdaydate())));
				wws.addCell(new Label(5, i + 2, String.valueOf(bean.getMemparty_f())));
				wws.addCell(new Label(6, i + 2, String.valueOf(bean.getMemrank_s())));
				wws.addCell(new Label(7, i + 2, String.valueOf(bean.getMeminstitute())));
				wws.addCell(new Label(8, i + 2, String.valueOf(bean.getMemduty())));
				wws.addCell(new Label(9, i + 2, String.valueOf(bean.getMemspeciality())));
				wws.addCell(new Label(10, i + 2, String.valueOf(bean.getInstituteaddress())));
				wws.addCell(new Label(11, i + 2, String.valueOf(bean.getInstitutepostcode())));
				wws.addCell(new Label(12, i + 2, String.valueOf(bean.getInstitutetelephone())));
				wws.addCell(new Label(13, i + 2, String.valueOf(bean.getMemnation_s())));
				wws.addCell(new Label(14, i + 2, String.valueOf(bean.getMemnationality_s())));
				wws.addCell(new Label(15, i + 2, String.valueOf(bean.getMemscholar())));
				wws.addCell(new Label(16, i + 2, String.valueOf(bean.getMemdegree())));
			}

			wwb.write();
			wwb.close();
			wb.close();
			FileOutputStream fos = new FileOutputStream(outputFile);
			targetFile.writeTo(fos);
			targetFile.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public WriteExcel(List list, String academyname, String UPath, String outputFile, String a, String b, String c, String d, int e) {
		try {
			Workbook wb = Workbook.getWorkbook(new File(UPath));
			ByteArrayOutputStream targetFile = new ByteArrayOutputStream();
			WritableWorkbook wwb = Workbook.createWorkbook(targetFile, wb);
			WritableSheet wws = wwb.getSheet("Sheet1");
			String title = (new StringBuilder(String.valueOf(academyname))).append("团体会员列表").toString();
			wws.addCell(new Label(0, 0, title));
			for (int i = 0; i < list.size(); i++) {
				Gmemberbaseinforelation bean = (Gmemberbaseinforelation) (Gmemberbaseinforelation) list.get(i);
				String time = DateUtil.getCalendarString(bean.getJoindate(), "yyyy-MM-dd");
				wws.addCell(new Label(0, i + 2, String.valueOf(bean.getNo())));
				wws.addCell(new Label(1, i + 2, String.valueOf(bean.getInstitutecode())));
				wws.addCell(new Label(2, i + 2, String.valueOf(bean.getInstitutename())));
				wws.addCell(new Label(3, i + 2, String.valueOf(bean.getContactaddress())));
				wws.addCell(new Label(4, i + 2, String.valueOf(bean.getContacttelephone())));
				wws.addCell(new Label(5, i + 2, String.valueOf(bean.getContactpostcode())));
				wws.addCell(new Label(6, i + 2, String.valueOf(bean.getInstitutetype())));
				wws.addCell(new Label(7, i + 2, String.valueOf(time)));
				wws.addCell(new Label(8, i + 2, String.valueOf(bean.getIsannualregister())));
			}

			wwb.write();
			wwb.close();
			wb.close();
			FileOutputStream fos = new FileOutputStream(outputFile);
			targetFile.writeTo(fos);
			targetFile.close();
		} catch (Exception f) {
			f.printStackTrace();
		}
	}

	public WriteExcel(Smemberbaseinfo baseinfo, List dbwylist, List academysmemberList, List smemberpastjobList, List resProList, List acadLiteraList, List patentList, String UPath, String outputFile) {
		try {
			Workbook wb = Workbook.getWorkbook(new File(UPath));
			ByteArrayOutputStream targetFile = new ByteArrayOutputStream();
			WritableWorkbook wwb = Workbook.createWorkbook(targetFile, wb);
			WritableSheet wws = wwb.getSheet("Sheet1");
			wws.addCell(new Label(3, 3, baseinfo.getMemno(), ExcelStyleFormat.style8()));
			wws.addCell(new Label(3, 4, baseinfo.getMemname(), ExcelStyleFormat.style2()));
			wws.addCell(new Label(3, 5, baseinfo.getMemsex(), ExcelStyleFormat.style2()));
			wws.addCell(new Label(3, 6, baseinfo.getMemnation_s(), ExcelStyleFormat.style2()));
			wws.addCell(new Label(3, 7, baseinfo.getMemscholar(), ExcelStyleFormat.style2()));
			wws.addCell(new Label(3, 8, baseinfo.getMemnationality_s(), ExcelStyleFormat.style2()));
			wws.addCell(new Label(7, 4, baseinfo.getMemidentity(), ExcelStyleFormat.style2()));
			String birthday = DateUtil.getCalendarString(baseinfo.getMembirthday(), "yyyy-MM-dd");
			wws.addCell(new Label(7, 5, birthday, ExcelStyleFormat.style2()));
			wws.addCell(new Label(7, 6, baseinfo.getMemparty_s(), ExcelStyleFormat.style2()));
			wws.addCell(new Label(7, 7, baseinfo.getMemdegree(), ExcelStyleFormat.style2()));
			wws.addCell(new Label(7, 8, baseinfo.getIsemployee(), ExcelStyleFormat.style2()));
			wws.addCell(new Label(3, 9, baseinfo.getMeminstitute(), ExcelStyleFormat.style1()));
			wws.addCell(new Label(3, 10, baseinfo.getMemdept(), ExcelStyleFormat.style2()));
			wws.addCell(new Label(3, 11, baseinfo.getMemduty(), ExcelStyleFormat.style2()));
			wws.addCell(new Label(3, 12, baseinfo.getMemskill(), ExcelStyleFormat.style5()));
			wws.addCell(new Label(7, 10, baseinfo.getMemrank_s(), ExcelStyleFormat.style1()));
			wws.addCell(new Label(7, 11, baseinfo.getMemspeciality(), ExcelStyleFormat.style1()));
			wws.addCell(new Label(7, 12, baseinfo.getForeignlanguage(), ExcelStyleFormat.style5()));
			wws.addCell(new Label(3, 14, baseinfo.getSocialduty1(), ExcelStyleFormat.style5()));
			wws.addCell(new Label(3, 16, baseinfo.getSocialhonour1(), ExcelStyleFormat.style5()));
			wws.addCell(new Label(3, 18, baseinfo.getInterduty_s(), ExcelStyleFormat.style5()));
			wws.addCell(new Label(7, 18, baseinfo.getNationduty_s(), ExcelStyleFormat.style5()));
			wws.addCell(new Label(3, 20, baseinfo.getInstituteaddress(), ExcelStyleFormat.style5()));
			wws.addCell(new Label(8, 20, baseinfo.getInstitutepostcode(), ExcelStyleFormat.style1()));
			wws.addCell(new Label(8, 21, baseinfo.getInstitutetelephone(), ExcelStyleFormat.style1()));
			wws.addCell(new Label(3, 22, baseinfo.getHomeaddress(), ExcelStyleFormat.style5()));
			wws.addCell(new Label(8, 22, baseinfo.getHomepostcode(), ExcelStyleFormat.style1()));
			wws.addCell(new Label(8, 23, baseinfo.getHometelephone(), ExcelStyleFormat.style1()));
			wws.addCell(new Label(3, 24, baseinfo.getUseremail(), ExcelStyleFormat.style3()));
			wws.addCell(new Label(8, 24, baseinfo.getUsermobile(), ExcelStyleFormat.style4()));
			wws.addCell(new Label(2, 28, baseinfo.getUniversity(), ExcelStyleFormat.style6()));
			wws.addCell(new Label(5, 28, baseinfo.getUniversityspec(), ExcelStyleFormat.style6()));
			String start1 = DateUtil.getCalendarString(baseinfo.getUniversitystartdate(), "yyyy.MM");
			String end1 = DateUtil.getCalendarString(baseinfo.getUniversityenddate(), "yyyy.MM");
			String time1 = (new StringBuilder(String.valueOf(start1))).append("至").append(end1).toString();
			wws.addCell(new Label(8, 28, time1, ExcelStyleFormat.style1()));
			wws.addCell(new Label(2, 29, baseinfo.getSeasuniversity(), ExcelStyleFormat.style7()));
			wws.addCell(new Label(5, 29, baseinfo.getSeasuniversityspec(), ExcelStyleFormat.style7()));
			String start2 = DateUtil.getCalendarString(baseinfo.getSeasuniversitystartdate(), "yyyy.MM");
			String end2 = DateUtil.getCalendarString(baseinfo.getSeasuniversityenddate(), "yyyy.MM");
			String time2 = (new StringBuilder(String.valueOf(start2))).append("至").append(end2).toString();
			wws.addCell(new Label(8, 29, time2, ExcelStyleFormat.style1()));
			wws.addCell(new Label(1, 33, baseinfo.getAssoduty_s(), ExcelStyleFormat.style9()));
			wws.addCell(new Label(5, 33, baseinfo.getAssoduty_f()));
			Integer dbwylistSize = Integer.valueOf(dbwylist.size());
			if (dbwylistSize.intValue() == 1) {
				Smemberdeputyinfo smemberdeputyinfo = (Smemberdeputyinfo) (Smemberdeputyinfo) dbwylist.get(0);
				wws.mergeCells(1, 35, 4, 35);
				wws.mergeCells(5, 35, 10, 35);
				wws.addCell(new Label(1, 35, smemberdeputyinfo.getAssoduty_s(), ExcelStyleFormat.style10()));
				wws.addCell(new Label(5, 35, smemberdeputyinfo.getAssoduty_f(), ExcelStyleFormat.style4()));
			} else {
				for (int i = 0; i < dbwylistSize.intValue() - 1; i++) {
					Smemberdeputyinfo smemberdeputyinfo = (Smemberdeputyinfo) (Smemberdeputyinfo) dbwylist.get(i);
					wws.mergeCells(1, 35 + i, 4, 35 + i);
					wws.mergeCells(5, 35 + i, 10, 35 + i);
					wws.addCell(new Label(1, 35 + i, smemberdeputyinfo.getAssoduty_s(), ExcelStyleFormat.style11()));
					wws.addCell(new Label(5, 35 + i, smemberdeputyinfo.getAssoduty_f(), ExcelStyleFormat.style1()));
				}

				Smemberdeputyinfo smemberdeputyinfo = (Smemberdeputyinfo) (Smemberdeputyinfo) dbwylist.get(dbwylistSize.intValue() - 1);
				wws.mergeCells(1, (35 + dbwylistSize.intValue()) - 1, 4, (35 + dbwylistSize.intValue()) - 1);
				wws.mergeCells(5, (35 + dbwylistSize.intValue()) - 1, 10, (35 + dbwylistSize.intValue()) - 1);
				wws.addCell(new Label(1, (35 + dbwylistSize.intValue()) - 1, smemberdeputyinfo.getAssoduty_s(), ExcelStyleFormat.style10()));
				wws.addCell(new Label(5, (35 + dbwylistSize.intValue()) - 1, smemberdeputyinfo.getAssoduty_f(), ExcelStyleFormat.style4()));
			}
			wws.addCell(new Label(1, 35 + dbwylistSize.intValue(), ""));
			Integer currentRow = Integer.valueOf(35 + dbwylistSize.intValue() + 1);
			wws.mergeCells(1, currentRow.intValue(), 10, currentRow.intValue());
			wws.addCell(new Label(1, currentRow.intValue(), "参加学会信息", ExcelStyleFormat.style12()));
			wws.mergeCells(1, currentRow.intValue() + 1, 2, currentRow.intValue() + 1);
			wws.addCell(new Label(1, currentRow.intValue() + 1, "入会时间", ExcelStyleFormat.style11()));
			wws.mergeCells(3, currentRow.intValue() + 1, 4, currentRow.intValue() + 1);
			wws.addCell(new Label(3, currentRow.intValue() + 1, "会员类别", ExcelStyleFormat.style6()));
			wws.addCell(new Label(5, currentRow.intValue() + 1, "年度注册", ExcelStyleFormat.style6()));
			wws.mergeCells(6, currentRow.intValue() + 1, 8, currentRow.intValue() + 1);
			wws.addCell(new Label(6, currentRow.intValue() + 1, "所在专业委员会", ExcelStyleFormat.style6()));
			wws.mergeCells(9, currentRow.intValue() + 1, 10, currentRow.intValue() + 1);
			wws.addCell(new Label(9, currentRow.intValue() + 1, "学会职务", ExcelStyleFormat.style1()));
			Integer academysmemberListSize = Integer.valueOf(academysmemberList.size());
			if (academysmemberListSize.intValue() == 1) {
				Academysmemberrelation academysmemberrelation = new Academysmemberrelation();
				academysmemberrelation = (Academysmemberrelation) (Academysmemberrelation) academysmemberList.get(0);
				wws.setRowView(currentRow.intValue() + 2, 1000, false);
				wws.mergeCells(1, currentRow.intValue() + 2, 2, currentRow.intValue() + 2);
				wws.mergeCells(3, currentRow.intValue() + 2, 4, currentRow.intValue() + 2);
				wws.mergeCells(6, currentRow.intValue() + 2, 8, currentRow.intValue() + 2);
				wws.mergeCells(9, currentRow.intValue() + 2, 10, currentRow.intValue() + 2);
				String joinDate = "";
				if (academysmemberrelation.getJoindate() != null)
					joinDate = DateUtil.getDateString(academysmemberrelation.getJoindate(), "yyyy.MM");
				else
					joinDate = " ";
				wws.addCell(new Label(1, currentRow.intValue() + 2, joinDate, ExcelStyleFormat.style10()));
				wws.addCell(new Label(3, currentRow.intValue() + 2, academysmemberrelation.getMemtype(), ExcelStyleFormat.style7()));
				wws.addCell(new Label(5, currentRow.intValue() + 2, academysmemberrelation.getIsannualregister(), ExcelStyleFormat.style7()));
				wws.addCell(new Label(6, currentRow.intValue() + 2, academysmemberrelation.getBelongcommittee1(), ExcelStyleFormat.style7()));
				wws.addCell(new Label(9, currentRow.intValue() + 2, academysmemberrelation.getAcademyduty1(), ExcelStyleFormat.style4()));
			} else {
				for (int i = 0; i < academysmemberListSize.intValue() - 1; i++) {
					Academysmemberrelation academysmemberrelation = new Academysmemberrelation();
					academysmemberrelation = (Academysmemberrelation) (Academysmemberrelation) academysmemberList.get(i);
					wws.setRowView(currentRow.intValue() + 2 + i, 1000, false);
					wws.mergeCells(1, currentRow.intValue() + 2 + i, 2, currentRow.intValue() + 2 + i);
					wws.mergeCells(3, currentRow.intValue() + 2 + i, 4, currentRow.intValue() + 2 + i);
					wws.mergeCells(6, currentRow.intValue() + 2 + i, 8, currentRow.intValue() + 2 + i);
					wws.mergeCells(9, currentRow.intValue() + 2 + i, 10, currentRow.intValue() + 2 + i);
					String joinDate = "";
					if (academysmemberrelation.getJoindate() != null)
						joinDate = DateUtil.getDateString(academysmemberrelation.getJoindate(), "yyyy.MM");
					else
						joinDate = " ";
					wws.addCell(new Label(1, currentRow.intValue() + 2 + i, joinDate, ExcelStyleFormat.style11()));
					wws.addCell(new Label(3, currentRow.intValue() + 2 + i, academysmemberrelation.getMemtype(), ExcelStyleFormat.style6()));
					wws.addCell(new Label(5, currentRow.intValue() + 2 + i, academysmemberrelation.getIsannualregister(), ExcelStyleFormat.style6()));
					wws.addCell(new Label(6, currentRow.intValue() + 2 + i, academysmemberrelation.getBelongcommittee1(), ExcelStyleFormat.style6()));
					wws.addCell(new Label(9, currentRow.intValue() + 2 + i, academysmemberrelation.getAcademyduty1(), ExcelStyleFormat.style1()));
				}

				Academysmemberrelation academysmemberrelation = new Academysmemberrelation();
				academysmemberrelation = (Academysmemberrelation) (Academysmemberrelation) academysmemberList.get(academysmemberListSize.intValue() - 1);
				wws.setRowView(currentRow.intValue() + academysmemberListSize.intValue() + 1, 1000, false);
				wws.mergeCells(1, currentRow.intValue() + academysmemberListSize.intValue() + 1, 2, currentRow.intValue() + academysmemberListSize.intValue() + 1);
				wws.mergeCells(3, currentRow.intValue() + academysmemberListSize.intValue() + 1, 4, currentRow.intValue() + academysmemberListSize.intValue() + 1);
				wws.mergeCells(6, currentRow.intValue() + academysmemberListSize.intValue() + 1, 8, currentRow.intValue() + academysmemberListSize.intValue() + 1);
				wws.mergeCells(9, currentRow.intValue() + academysmemberListSize.intValue() + 1, 10, currentRow.intValue() + academysmemberListSize.intValue() + 1);
				String joinDate = "";
				if (academysmemberrelation.getJoindate() != null)
					joinDate = DateUtil.getDateString(academysmemberrelation.getJoindate(), "yyyy.MM");
				else
					joinDate = " ";
				wws.addCell(new Label(1, currentRow.intValue() + academysmemberListSize.intValue() + 1, joinDate, ExcelStyleFormat.style10()));
				wws.addCell(new Label(3, currentRow.intValue() + academysmemberListSize.intValue() + 1, academysmemberrelation.getMemtype(), ExcelStyleFormat.style7()));
				wws.addCell(new Label(5, currentRow.intValue() + academysmemberListSize.intValue() + 1, academysmemberrelation.getIsannualregister(), ExcelStyleFormat.style7()));
				wws.addCell(new Label(6, currentRow.intValue() + academysmemberListSize.intValue() + 1, academysmemberrelation.getBelongcommittee1(), ExcelStyleFormat.style7()));
				wws.addCell(new Label(9, currentRow.intValue() + academysmemberListSize.intValue() + 1, academysmemberrelation.getAcademyduty1(), ExcelStyleFormat.style4()));
			}
			wws.addCell(new Label(1, currentRow.intValue() + academysmemberListSize.intValue() + 2, ""));
			currentRow = Integer.valueOf(currentRow.intValue() + academysmemberListSize.intValue() + 3);
			wws.mergeCells(1, currentRow.intValue(), 10, currentRow.intValue());
			wws.addCell(new Label(1, currentRow.intValue(), "主要工作经历", ExcelStyleFormat.style12()));
			wws.mergeCells(1, currentRow.intValue() + 1, 3, currentRow.intValue() + 1);
			wws.addCell(new Label(1, currentRow.intValue() + 1, "单位名称", ExcelStyleFormat.style11()));
			wws.mergeCells(4, currentRow.intValue() + 1, 5, currentRow.intValue() + 1);
			wws.addCell(new Label(4, currentRow.intValue() + 1, "职称", ExcelStyleFormat.style6()));
			wws.mergeCells(6, currentRow.intValue() + 1, 8, currentRow.intValue() + 1);
			wws.addCell(new Label(6, currentRow.intValue() + 1, "起止年月", ExcelStyleFormat.style6()));
			wws.mergeCells(9, currentRow.intValue() + 1, 10, currentRow.intValue() + 1);
			wws.addCell(new Label(9, currentRow.intValue() + 1, "地点", ExcelStyleFormat.style1()));
			Integer smemberpastjobListSize = Integer.valueOf(smemberpastjobList.size());
			if (smemberpastjobListSize.intValue() == 1) {
				Smemberpastjob smemberpastjob = new Smemberpastjob();
				smemberpastjob = (Smemberpastjob) (Smemberpastjob) smemberpastjobList.get(0);
				wws.setRowView(currentRow.intValue() + academysmemberListSize.intValue() + 1, 800, false);
				wws.mergeCells(1, currentRow.intValue() + 2, 3, currentRow.intValue() + 2);
				wws.mergeCells(4, currentRow.intValue() + 2, 5, currentRow.intValue() + 2);
				wws.mergeCells(6, currentRow.intValue() + 2, 8, currentRow.intValue() + 2);
				wws.mergeCells(9, currentRow.intValue() + 2, 10, currentRow.intValue() + 2);
				wws.addCell(new Label(1, currentRow.intValue() + 2, smemberpastjob.getJobinstitute(), ExcelStyleFormat.style10()));
				wws.addCell(new Label(4, currentRow.intValue() + 2, smemberpastjob.getJobrank(), ExcelStyleFormat.style7()));
				String jobStart = "";
				if (smemberpastjob.getStartdate() != null)
					jobStart = DateUtil.getDateString(smemberpastjob.getStartdate(), "yyyy.MM");
				else
					jobStart = "/";
				String jobEnd = "";
				if (smemberpastjob.getEnddate() != null)
					jobEnd = DateUtil.getDateString(smemberpastjob.getEnddate(), "yyyy.MM");
				else
					jobEnd = "/";
				String jobdateTime = (new StringBuilder(String.valueOf(jobStart))).append("至").append(jobEnd).toString();
				wws.addCell(new Label(6, currentRow.intValue() + 2, jobdateTime, ExcelStyleFormat.style7()));
				wws.addCell(new Label(9, currentRow.intValue() + 2, smemberpastjob.getJobaddress(), ExcelStyleFormat.style4()));
			} else {
				for (int i = 0; i < smemberpastjobListSize.intValue() - 1; i++) {
					Smemberpastjob smemberpastjob = new Smemberpastjob();
					smemberpastjob = (Smemberpastjob) (Smemberpastjob) smemberpastjobList.get(i);
					wws.setRowView(currentRow.intValue() + 2 + i, 800, false);
					wws.mergeCells(1, currentRow.intValue() + 2 + i, 3, currentRow.intValue() + 2 + i);
					wws.mergeCells(4, currentRow.intValue() + 2 + i, 5, currentRow.intValue() + 2 + i);
					wws.mergeCells(6, currentRow.intValue() + 2 + i, 8, currentRow.intValue() + 2 + i);
					wws.mergeCells(9, currentRow.intValue() + 2 + i, 10, currentRow.intValue() + 2 + i);
					String jobStart = "";
					if (smemberpastjob.getStartdate() != null)
						jobStart = DateUtil.getDateString(smemberpastjob.getStartdate(), "yyyy.MM");
					else
						jobStart = "/";
					String jobEnd = "";
					if (smemberpastjob.getEnddate() != null)
						jobEnd = DateUtil.getDateString(smemberpastjob.getEnddate(), "yyyy.MM");
					else
						jobEnd = "/";
					String jobdateTime = (new StringBuilder(String.valueOf(jobStart))).append("至").append(jobEnd).toString();
					wws.addCell(new Label(1, currentRow.intValue() + 2 + i, smemberpastjob.getJobinstitute(), ExcelStyleFormat.style11()));
					wws.addCell(new Label(4, currentRow.intValue() + 2 + i, smemberpastjob.getJobrank(), ExcelStyleFormat.style6()));
					wws.addCell(new Label(6, currentRow.intValue() + 2 + i, jobdateTime, ExcelStyleFormat.style6()));
					wws.addCell(new Label(9, currentRow.intValue() + 2 + i, smemberpastjob.getJobaddress(), ExcelStyleFormat.style1()));
				}

				Smemberpastjob smemberpastjob = new Smemberpastjob();
				smemberpastjob = (Smemberpastjob) (Smemberpastjob) smemberpastjobList.get(smemberpastjobListSize.intValue() - 1);
				wws.setRowView(currentRow.intValue() + academysmemberListSize.intValue() + 1, 800, false);
				wws.mergeCells(1, currentRow.intValue() + smemberpastjobListSize.intValue() + 1, 3, currentRow.intValue() + smemberpastjobListSize.intValue() + 1);
				wws.mergeCells(4, currentRow.intValue() + smemberpastjobListSize.intValue() + 1, 5, currentRow.intValue() + smemberpastjobListSize.intValue() + 1);
				wws.mergeCells(6, currentRow.intValue() + smemberpastjobListSize.intValue() + 1, 8, currentRow.intValue() + smemberpastjobListSize.intValue() + 1);
				wws.mergeCells(9, currentRow.intValue() + smemberpastjobListSize.intValue() + 1, 10, currentRow.intValue() + smemberpastjobListSize.intValue() + 1);
				String jobStart = "";
				if (smemberpastjob.getStartdate() != null)
					jobStart = DateUtil.getDateString(smemberpastjob.getStartdate(), "yyyy.MM");
				else
					jobStart = "/";
				String jobEnd = "";
				if (smemberpastjob.getEnddate() != null)
					jobEnd = DateUtil.getDateString(smemberpastjob.getEnddate(), "yyyy.MM");
				else
					jobEnd = "/";
				String jobdateTime = (new StringBuilder(String.valueOf(jobStart))).append("至").append(jobEnd).toString();
				wws.addCell(new Label(1, currentRow.intValue() + smemberpastjobListSize.intValue() + 1, smemberpastjob.getJobinstitute(), ExcelStyleFormat.style10()));
				wws.addCell(new Label(4, currentRow.intValue() + smemberpastjobListSize.intValue() + 1, smemberpastjob.getJobrank(), ExcelStyleFormat.style7()));
				wws.addCell(new Label(6, currentRow.intValue() + smemberpastjobListSize.intValue() + 1, jobdateTime, ExcelStyleFormat.style7()));
				wws.addCell(new Label(9, currentRow.intValue() + smemberpastjobListSize.intValue() + 1, smemberpastjob.getJobaddress(), ExcelStyleFormat.style4()));
			}
			wws.addCell(new Label(1, currentRow.intValue() + smemberpastjobListSize.intValue() + 2, ""));
			currentRow = Integer.valueOf(currentRow.intValue() + smemberpastjobListSize.intValue() + 3);
			wws.mergeCells(1, currentRow.intValue(), 10, currentRow.intValue());
			wws.addCell(new Label(1, currentRow.intValue(), "主要科研成果", ExcelStyleFormat.style12()));
			wws.addCell(new Label(1, currentRow.intValue() + 1, "序号", ExcelStyleFormat.style11()));
			wws.mergeCells(2, currentRow.intValue() + 1, 4, currentRow.intValue() + 1);
			wws.addCell(new Label(2, currentRow.intValue() + 1, "成果名称", ExcelStyleFormat.style6()));
			wws.addCell(new Label(5, currentRow.intValue() + 1, "完成日期", ExcelStyleFormat.style6()));
			wws.mergeCells(6, currentRow.intValue() + 1, 8, currentRow.intValue() + 1);
			wws.addCell(new Label(6, currentRow.intValue() + 1, "获奖情况", ExcelStyleFormat.style6()));
			wws.mergeCells(9, currentRow.intValue() + 1, 10, currentRow.intValue() + 1);
			wws.addCell(new Label(9, currentRow.intValue() + 1, "成果应用", ExcelStyleFormat.style1()));
			Integer resProListSize = Integer.valueOf(resProList.size());
			if (resProListSize.intValue() == 1) {
				Smemberresearchproduction smemresprobean = new Smemberresearchproduction();
				smemresprobean = (Smemberresearchproduction) (Smemberresearchproduction) resProList.get(0);
				if (smemresprobean.getProdname().equals(" ")) {
					wws.setRowView(currentRow.intValue() + 2, 1000, false);
					wws.mergeCells(2, currentRow.intValue() + 2, 4, currentRow.intValue() + 2);
					wws.mergeCells(6, currentRow.intValue() + 2, 8, currentRow.intValue() + 2);
					wws.mergeCells(9, currentRow.intValue() + 2, 10, currentRow.intValue() + 2);
					wws.addCell(new Label(1, currentRow.intValue() + 2, " ", ExcelStyleFormat.style10()));
					wws.addCell(new Label(2, currentRow.intValue() + 2, " ", ExcelStyleFormat.style7()));
					wws.addCell(new Label(5, currentRow.intValue() + 2, " ", ExcelStyleFormat.style7()));
					wws.addCell(new Label(6, currentRow.intValue() + 2, " ", ExcelStyleFormat.style7()));
					wws.addCell(new Label(9, currentRow.intValue() + 2, " ", ExcelStyleFormat.style4()));
				} else {
					String resProDate = "";
					if (smemresprobean.getProddate() != null)
						resProDate = DateUtil.getDateString(smemresprobean.getProddate(), "yyyy.MM");
					else
						resProDate = " ";
					wws.setRowView(currentRow.intValue() + 2, 1000, false);
					wws.mergeCells(2, currentRow.intValue() + 2, 4, currentRow.intValue() + 2);
					wws.mergeCells(6, currentRow.intValue() + 2, 8, currentRow.intValue() + 2);
					wws.mergeCells(9, currentRow.intValue() + 2, 10, currentRow.intValue() + 2);
					wws.addCell(new Label(1, currentRow.intValue() + 2, "1", ExcelStyleFormat.style10()));
					wws.addCell(new Label(2, currentRow.intValue() + 2, smemresprobean.getProdname(), ExcelStyleFormat.style7()));
					wws.addCell(new Label(5, currentRow.intValue() + 2, resProDate, ExcelStyleFormat.style7()));
					wws.addCell(new Label(6, currentRow.intValue() + 2, smemresprobean.getProdrewards(), ExcelStyleFormat.style7()));
					wws.addCell(new Label(9, currentRow.intValue() + 2, smemresprobean.getProdapplication(), ExcelStyleFormat.style4()));
				}
			} else {
				for (int i = 0; i < resProListSize.intValue() - 1; i++) {
					Smemberresearchproduction smemresprobean = new Smemberresearchproduction();
					smemresprobean = (Smemberresearchproduction) (Smemberresearchproduction) resProList.get(i);
					wws.setRowView(currentRow.intValue() + 2 + i, 1000, false);
					wws.mergeCells(2, currentRow.intValue() + 2 + i, 4, currentRow.intValue() + 2 + i);
					wws.mergeCells(6, currentRow.intValue() + 2 + i, 8, currentRow.intValue() + 2 + i);
					wws.mergeCells(9, currentRow.intValue() + 2 + i, 10, currentRow.intValue() + 2 + i);
					String resProDate = "";
					if (smemresprobean.getProddate() != null)
						resProDate = DateUtil.getDateString(smemresprobean.getProddate(), "yyyy.MM");
					else
						resProDate = " ";
					Integer number = Integer.valueOf(i + 1);
					wws.addCell(new Label(1, currentRow.intValue() + 2 + i, number.toString(), ExcelStyleFormat.style11()));
					wws.addCell(new Label(2, currentRow.intValue() + 2 + i, smemresprobean.getProdname(), ExcelStyleFormat.style6()));
					wws.addCell(new Label(5, currentRow.intValue() + 2 + i, resProDate, ExcelStyleFormat.style6()));
					wws.addCell(new Label(6, currentRow.intValue() + 2 + i, smemresprobean.getProdrewards(), ExcelStyleFormat.style6()));
					wws.addCell(new Label(9, currentRow.intValue() + 2 + i, smemresprobean.getProdapplication(), ExcelStyleFormat.style1()));
				}

				Smemberresearchproduction smemresprobean = new Smemberresearchproduction();
				smemresprobean = (Smemberresearchproduction) (Smemberresearchproduction) resProList.get(resProListSize.intValue() - 1);
				wws.setRowView(currentRow.intValue() + resProListSize.intValue() + 1, 1000, false);
				wws.mergeCells(2, currentRow.intValue() + resProListSize.intValue() + 1, 4, currentRow.intValue() + resProListSize.intValue() + 1);
				wws.mergeCells(6, currentRow.intValue() + resProListSize.intValue() + 1, 8, currentRow.intValue() + resProListSize.intValue() + 1);
				wws.mergeCells(9, currentRow.intValue() + resProListSize.intValue() + 1, 10, currentRow.intValue() + resProListSize.intValue() + 1);
				String resProDate = "";
				if (smemresprobean.getProddate() != null)
					resProDate = DateUtil.getDateString(smemresprobean.getProddate(), "yyyy,MM");
				else
					resProDate = " ";
				wws.addCell(new Label(1, currentRow.intValue() + resProListSize.intValue() + 1, resProListSize.toString(), ExcelStyleFormat.style10()));
				wws.addCell(new Label(2, currentRow.intValue() + resProListSize.intValue() + 1, smemresprobean.getProdname(), ExcelStyleFormat.style7()));
				wws.addCell(new Label(5, currentRow.intValue() + resProListSize.intValue() + 1, resProDate, ExcelStyleFormat.style7()));
				wws.addCell(new Label(6, currentRow.intValue() + resProListSize.intValue() + 1, smemresprobean.getProdrewards(), ExcelStyleFormat.style7()));
				wws.addCell(new Label(9, currentRow.intValue() + resProListSize.intValue() + 1, smemresprobean.getProdapplication(), ExcelStyleFormat.style4()));
			}
			wws.addCell(new Label(1, currentRow.intValue() + resProListSize.intValue() + 2, ""));
			currentRow = Integer.valueOf(currentRow.intValue() + resProListSize.intValue() + 3);
			wws.mergeCells(1, currentRow.intValue(), 10, currentRow.intValue());
			wws.addCell(new Label(1, currentRow.intValue(), "主要学术科普论著", ExcelStyleFormat.style12()));
			wws.addCell(new Label(1, currentRow.intValue() + 1, "序号", ExcelStyleFormat.style11()));
			wws.mergeCells(2, currentRow.intValue() + 1, 4, currentRow.intValue() + 1);
			wws.addCell(new Label(2, currentRow.intValue() + 1, "学术、科普论证名称", ExcelStyleFormat.style6()));
			wws.addCell(new Label(5, currentRow.intValue() + 1, "发表日期", ExcelStyleFormat.style6()));
			wws.mergeCells(6, currentRow.intValue() + 1, 8, currentRow.intValue() + 1);
			wws.addCell(new Label(6, currentRow.intValue() + 1, "何种刊物上发表", ExcelStyleFormat.style6()));
			wws.mergeCells(9, currentRow.intValue() + 1, 10, currentRow.intValue() + 1);
			wws.addCell(new Label(9, currentRow.intValue() + 1, "出版社名称", ExcelStyleFormat.style1()));
			Integer acadLiteraListSize = Integer.valueOf(acadLiteraList.size());
			if (acadLiteraListSize.intValue() == 1) {
				Smemberacademicliterature smemacadlitera = new Smemberacademicliterature();
				smemacadlitera = (Smemberacademicliterature) (Smemberacademicliterature) acadLiteraList.get(0);
				if (smemacadlitera.getLitename().equals(" ")) {
					wws.setRowView(currentRow.intValue() + 2, 1000, false);
					wws.mergeCells(2, currentRow.intValue() + 2, 4, currentRow.intValue() + 2);
					wws.mergeCells(6, currentRow.intValue() + 2, 8, currentRow.intValue() + 2);
					wws.mergeCells(9, currentRow.intValue() + 2, 10, currentRow.intValue() + 2);
					wws.addCell(new Label(1, currentRow.intValue() + 2, " ", ExcelStyleFormat.style10()));
					wws.addCell(new Label(2, currentRow.intValue() + 2, " ", ExcelStyleFormat.style7()));
					wws.addCell(new Label(5, currentRow.intValue() + 2, " ", ExcelStyleFormat.style7()));
					wws.addCell(new Label(6, currentRow.intValue() + 2, " ", ExcelStyleFormat.style7()));
					wws.addCell(new Label(9, currentRow.intValue() + 2, " ", ExcelStyleFormat.style4()));
				} else {
					String acadLiteraDate = "";
					if (smemacadlitera.getLitedate() != null)
						acadLiteraDate = DateUtil.getDateString(smemacadlitera.getLitedate(), "yyyy.MM");
					else
						acadLiteraDate = " ";
					wws.setRowView(currentRow.intValue() + 2, 1000, false);
					wws.mergeCells(2, currentRow.intValue() + 2, 4, currentRow.intValue() + 2);
					wws.mergeCells(6, currentRow.intValue() + 2, 8, currentRow.intValue() + 2);
					wws.mergeCells(9, currentRow.intValue() + 2, 10, currentRow.intValue() + 2);
					wws.addCell(new Label(1, currentRow.intValue() + 2, "1", ExcelStyleFormat.style10()));
					wws.addCell(new Label(2, currentRow.intValue() + 2, smemacadlitera.getLitename(), ExcelStyleFormat.style7()));
					wws.addCell(new Label(5, currentRow.intValue() + 2, acadLiteraDate, ExcelStyleFormat.style7()));
					wws.addCell(new Label(6, currentRow.intValue() + 2, smemacadlitera.getLitejournal(), ExcelStyleFormat.style7()));
					wws.addCell(new Label(9, currentRow.intValue() + 2, smemacadlitera.getLitehouse(), ExcelStyleFormat.style4()));
				}
			} else {
				for (int i = 0; i < acadLiteraListSize.intValue() - 1; i++) {
					Smemberacademicliterature smemacadlitera = new Smemberacademicliterature();
					smemacadlitera = (Smemberacademicliterature) (Smemberacademicliterature) acadLiteraList.get(i);
					wws.setRowView(currentRow.intValue() + 2 + i, 1000, false);
					wws.mergeCells(2, currentRow.intValue() + 2 + i, 4, currentRow.intValue() + 2 + i);
					wws.mergeCells(6, currentRow.intValue() + 2 + i, 8, currentRow.intValue() + 2 + i);
					wws.mergeCells(9, currentRow.intValue() + 2 + i, 10, currentRow.intValue() + 2 + i);
					String acadLiteraDate = "";
					if (smemacadlitera.getLitedate() != null)
						acadLiteraDate = DateUtil.getDateString(smemacadlitera.getLitedate(), "yyyy.MM");
					else
						acadLiteraDate = " ";
					Integer number = Integer.valueOf(i + 1);
					wws.addCell(new Label(1, currentRow.intValue() + 2 + i, number.toString(), ExcelStyleFormat.style11()));
					wws.addCell(new Label(2, currentRow.intValue() + 2 + i, smemacadlitera.getLitename(), ExcelStyleFormat.style6()));
					wws.addCell(new Label(5, currentRow.intValue() + 2 + i, acadLiteraDate, ExcelStyleFormat.style6()));
					wws.addCell(new Label(6, currentRow.intValue() + 2 + i, smemacadlitera.getLitejournal(), ExcelStyleFormat.style6()));
					wws.addCell(new Label(9, currentRow.intValue() + 2 + i, smemacadlitera.getLitehouse(), ExcelStyleFormat.style1()));
				}

				Smemberacademicliterature smemacadlitera = new Smemberacademicliterature();
				smemacadlitera = (Smemberacademicliterature) (Smemberacademicliterature) acadLiteraList.get(acadLiteraListSize.intValue() - 1);
				wws.setRowView(currentRow.intValue() + acadLiteraListSize.intValue() + 1, 1000, false);
				wws.mergeCells(2, currentRow.intValue() + acadLiteraListSize.intValue() + 1, 4, currentRow.intValue() + acadLiteraListSize.intValue() + 1);
				wws.mergeCells(6, currentRow.intValue() + acadLiteraListSize.intValue() + 1, 8, currentRow.intValue() + acadLiteraListSize.intValue() + 1);
				wws.mergeCells(9, currentRow.intValue() + acadLiteraListSize.intValue() + 1, 10, currentRow.intValue() + acadLiteraListSize.intValue() + 1);
				String acadLiteraDate = "";
				if (smemacadlitera.getLitedate() != null)
					acadLiteraDate = DateUtil.getDateString(smemacadlitera.getLitedate(), "yyyy.MM");
				else
					acadLiteraDate = " ";
				wws.addCell(new Label(1, currentRow.intValue() + acadLiteraListSize.intValue() + 1, acadLiteraListSize.toString(), ExcelStyleFormat.style10()));
				wws.addCell(new Label(2, currentRow.intValue() + acadLiteraListSize.intValue() + 1, smemacadlitera.getLitename(), ExcelStyleFormat.style7()));
				wws.addCell(new Label(5, currentRow.intValue() + acadLiteraListSize.intValue() + 1, acadLiteraDate, ExcelStyleFormat.style7()));
				wws.addCell(new Label(6, currentRow.intValue() + acadLiteraListSize.intValue() + 1, smemacadlitera.getLitejournal(), ExcelStyleFormat.style7()));
				wws.addCell(new Label(9, currentRow.intValue() + acadLiteraListSize.intValue() + 1, smemacadlitera.getLitehouse(), ExcelStyleFormat.style4()));
			}
			wws.addCell(new Label(1, currentRow.intValue() + acadLiteraListSize.intValue() + 2, ""));
			currentRow = Integer.valueOf(currentRow.intValue() + acadLiteraListSize.intValue() + 3);
			wws.mergeCells(1, currentRow.intValue(), 10, currentRow.intValue());
			wws.addCell(new Label(1, currentRow.intValue(), "专利（软件著作权）情况", ExcelStyleFormat.style12()));
			wws.addCell(new Label(1, currentRow.intValue() + 1, "序号", ExcelStyleFormat.style11()));
			wws.mergeCells(2, currentRow.intValue() + 1, 4, currentRow.intValue() + 1);
			wws.addCell(new Label(2, currentRow.intValue() + 1, "专利（软件著作权）名", ExcelStyleFormat.style6()));
			wws.addCell(new Label(5, currentRow.intValue() + 1, "授权日期", ExcelStyleFormat.style6()));
			wws.mergeCells(6, currentRow.intValue() + 1, 8, currentRow.intValue() + 1);
			wws.addCell(new Label(6, currentRow.intValue() + 1, "专利类型", ExcelStyleFormat.style6()));
			wws.addCell(new Label(9, currentRow.intValue() + 1, "是否产业化", ExcelStyleFormat.style6()));
			wws.addCell(new Label(10, currentRow.intValue() + 1, "年产值", ExcelStyleFormat.style1()));
			Integer patentListSize = Integer.valueOf(patentList.size());
			if (patentListSize.intValue() == 1) {
				Smemberpatentinfo patentinfobean = new Smemberpatentinfo();
				patentinfobean = (Smemberpatentinfo) (Smemberpatentinfo) patentList.get(0);
				if (patentinfobean.getPatentname().equals(" ")) {
					wws.setRowView(currentRow.intValue() + 2, 1000, false);
					wws.mergeCells(2, currentRow.intValue() + 2, 4, currentRow.intValue() + 2);
					wws.mergeCells(6, currentRow.intValue() + 2, 8, currentRow.intValue() + 2);
					wws.addCell(new Label(1, currentRow.intValue() + 2, " ", ExcelStyleFormat.style10()));
					wws.addCell(new Label(2, currentRow.intValue() + 2, " ", ExcelStyleFormat.style7()));
					wws.addCell(new Label(5, currentRow.intValue() + 2, " ", ExcelStyleFormat.style7()));
					wws.addCell(new Label(6, currentRow.intValue() + 2, " ", ExcelStyleFormat.style7()));
					wws.addCell(new Label(9, currentRow.intValue() + 2, " ", ExcelStyleFormat.style7()));
					wws.addCell(new Label(10, currentRow.intValue() + 2, " ", ExcelStyleFormat.style4()));
				} else {
					String patentDate = "";
					if (patentinfobean.getPatentname() != null)
						patentDate = DateUtil.getDateString(patentinfobean.getPatentdate(), "yyyy.MM");
					else
						patentDate = " ";
					wws.setRowView(currentRow.intValue() + 2, 1000, false);
					wws.mergeCells(2, currentRow.intValue() + 2, 4, currentRow.intValue() + 2);
					wws.mergeCells(6, currentRow.intValue() + 2, 8, currentRow.intValue() + 2);
					wws.addCell(new Label(1, currentRow.intValue() + 2, "1", ExcelStyleFormat.style10()));
					wws.addCell(new Label(2, currentRow.intValue() + 2, patentinfobean.getPatentname(), ExcelStyleFormat.style7()));
					wws.addCell(new Label(5, currentRow.intValue() + 2, patentDate, ExcelStyleFormat.style7()));
					wws.addCell(new Label(6, currentRow.intValue() + 2, patentinfobean.getPatenttype(), ExcelStyleFormat.style7()));
					wws.addCell(new Label(9, currentRow.intValue() + 2, patentinfobean.getPatentisindustrialized(), ExcelStyleFormat.style7()));
					wws.addCell(new Label(10, currentRow.intValue() + 2, patentinfobean.getPatentvalue(), ExcelStyleFormat.style4()));
				}
			} else {
				for (int i = 0; i < patentListSize.intValue() - 1; i++) {
					Smemberpatentinfo patentinfobean = new Smemberpatentinfo();
					patentinfobean = (Smemberpatentinfo) (Smemberpatentinfo) patentList.get(i);
					wws.setRowView(currentRow.intValue() + 2 + i, 1000, false);
					wws.mergeCells(2, currentRow.intValue() + 2 + i, 4, currentRow.intValue() + 2 + i);
					wws.mergeCells(6, currentRow.intValue() + 2 + i, 8, currentRow.intValue() + 2 + i);
					String patentDate = "";
					if (patentinfobean.getPatentname() != null)
						patentDate = DateUtil.getDateString(patentinfobean.getPatentdate(), "yyyy.MM");
					else
						patentDate = " ";
					Integer number = Integer.valueOf(i + 1);
					wws.addCell(new Label(1, currentRow.intValue() + 2 + i, number.toString(), ExcelStyleFormat.style11()));
					wws.addCell(new Label(2, currentRow.intValue() + 2 + i, patentinfobean.getPatentname(), ExcelStyleFormat.style6()));
					wws.addCell(new Label(5, currentRow.intValue() + 2 + i, patentDate, ExcelStyleFormat.style6()));
					wws.addCell(new Label(6, currentRow.intValue() + 2 + i, patentinfobean.getPatenttype(), ExcelStyleFormat.style6()));
					wws.addCell(new Label(9, currentRow.intValue() + 2 + i, patentinfobean.getPatentisindustrialized(), ExcelStyleFormat.style6()));
					wws.addCell(new Label(10, currentRow.intValue() + 2 + i, patentinfobean.getPatentvalue(), ExcelStyleFormat.style1()));
				}

				Smemberpatentinfo patentinfobean = new Smemberpatentinfo();
				patentinfobean = (Smemberpatentinfo) (Smemberpatentinfo) patentList.get(patentListSize.intValue() - 1);
				wws.setRowView(currentRow.intValue() + patentListSize.intValue() + 1, 1000, false);
				wws.mergeCells(2, currentRow.intValue() + patentListSize.intValue() + 1, 4, currentRow.intValue() + patentListSize.intValue() + 1);
				wws.mergeCells(6, currentRow.intValue() + patentListSize.intValue() + 1, 8, currentRow.intValue() + patentListSize.intValue() + 1);
				String patentDate = "";
				if (patentinfobean.getPatentname() != null)
					patentDate = DateUtil.getDateString(patentinfobean.getPatentdate(), "yyyy.MM");
				else
					patentDate = " ";
				wws.addCell(new Label(1, currentRow.intValue() + patentListSize.intValue() + 1, patentListSize.toString(), ExcelStyleFormat.style10()));
				wws.addCell(new Label(2, currentRow.intValue() + patentListSize.intValue() + 1, patentinfobean.getPatentname(), ExcelStyleFormat.style7()));
				wws.addCell(new Label(5, currentRow.intValue() + patentListSize.intValue() + 1, patentDate, ExcelStyleFormat.style7()));
				wws.addCell(new Label(6, currentRow.intValue() + patentListSize.intValue() + 1, patentinfobean.getPatenttype(), ExcelStyleFormat.style7()));
				wws.addCell(new Label(9, currentRow.intValue() + patentListSize.intValue() + 1, patentinfobean.getPatentisindustrialized(), ExcelStyleFormat.style7()));
				wws.addCell(new Label(10, currentRow.intValue() + patentListSize.intValue() + 1, patentinfobean.getPatentvalue(), ExcelStyleFormat.style4()));
			}
			wwb.write();
			wwb.close();
			wb.close();
			FileOutputStream fos = new FileOutputStream(outputFile);
			targetFile.writeTo(fos);
			targetFile.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public WriteExcel(Gmemberbaseinfo gmemberbaseinfo, Academygmemberrelation academygmemberrelation, List list1, List list2, String UPath, String outputFile) {
		try {
			Workbook wb = Workbook.getWorkbook(new File(UPath));
			ByteArrayOutputStream targetFile = new ByteArrayOutputStream();
			WritableWorkbook wwb = Workbook.createWorkbook(targetFile, wb);
			WritableSheet wws = wwb.getSheet("Sheet1");
			wws.addCell(new Label(3, 3, gmemberbaseinfo.getInstitutename(), ExcelStyleFormat.style2()));
			wws.addCell(new Label(3, 4, gmemberbaseinfo.getContactname(), ExcelStyleFormat.style2()));
			wws.addCell(new Label(3, 5, gmemberbaseinfo.getInstitutetype(), ExcelStyleFormat.style2()));
			wws.addCell(new Label(3, 6, gmemberbaseinfo.getContactpostcode(), ExcelStyleFormat.style2()));
			wws.addCell(new Label(3, 7, gmemberbaseinfo.getContactperson(), ExcelStyleFormat.style2()));
			wws.addCell(new Label(3, 8, gmemberbaseinfo.getContactfax(), ExcelStyleFormat.style2()));
			wws.addCell(new Label(3, 9, gmemberbaseinfo.getContactemail(), ExcelStyleFormat.style2()));
			wws.addCell(new Label(3, 10, String.valueOf(gmemberbaseinfo.getContacthigherstaffcount()), ExcelStyleFormat.style3()));
			wws.addCell(new Label(8, 3, gmemberbaseinfo.getInstitutecode(), ExcelStyleFormat.style1()));
			wws.addCell(new Label(7, 4, DateUtil.getCalendarString(academygmemberrelation.getJoindate(), "yyyy-MM-dd"), ExcelStyleFormat.style1()));
			wws.addCell(new Label(10, 4, academygmemberrelation.getIsannualregister(), ExcelStyleFormat.style1()));
			wws.addCell(new Label(8, 5, gmemberbaseinfo.getContactaddress(), ExcelStyleFormat.style1()));
			wws.addCell(new Label(8, 6, gmemberbaseinfo.getContactdepartment(), ExcelStyleFormat.style1()));
			wws.addCell(new Label(8, 7, gmemberbaseinfo.getContacttelephone(), ExcelStyleFormat.style1()));
			wws.addCell(new Label(8, 8, gmemberbaseinfo.getContacturl(), ExcelStyleFormat.style1()));
			wws.addCell(new Label(8, 9, String.valueOf(gmemberbaseinfo.getContactstaffcount()), ExcelStyleFormat.style1()));
			wws.addCell(new Label(8, 10, gmemberbaseinfo.getContactoperationrange(), ExcelStyleFormat.style4()));
			Integer gmemberresearchproductionlistsize = Integer.valueOf(list1.size());
			if (gmemberresearchproductionlistsize.intValue() == 1) {
				Gmemberresearchproduction gmemberresearchproduction = (Gmemberresearchproduction) (Gmemberresearchproduction) list1.get(0);
				wws.addCell(new Label(1, 14, "1", ExcelStyleFormat.style2()));
				wws.addCell(new Label(2, 14, gmemberresearchproduction.getProdname(), ExcelStyleFormat.style2()));
				wws.addCell(new Label(4, 14, DateUtil.getDateString(gmemberresearchproduction.getProddate(), "yyyy-MM-dd"), ExcelStyleFormat.style2()));
				wws.addCell(new Label(6, 14, gmemberresearchproduction.getProdrewards(), ExcelStyleFormat.style2()));
				wws.addCell(new Label(8, 14, gmemberresearchproduction.getProdapplication(), ExcelStyleFormat.style1()));
			} else {
				for (int i = 0; i < gmemberresearchproductionlistsize.intValue(); i++) {
					Gmemberresearchproduction gmemberresearchproduction = (Gmemberresearchproduction) (Gmemberresearchproduction) list1.get(i);
					wws.addCell(new Label(1, 14 + i, String.valueOf(i + 1), ExcelStyleFormat.style2()));
					wws.addCell(new Label(2, 14 + i, gmemberresearchproduction.getProdname(), ExcelStyleFormat.style2()));
					wws.addCell(new Label(4, 14 + i, DateUtil.getDateString(gmemberresearchproduction.getProddate(), "yyyy-MM-dd"), ExcelStyleFormat.style2()));
					wws.addCell(new Label(6, 14 + i, gmemberresearchproduction.getProdrewards(), ExcelStyleFormat.style2()));
					wws.addCell(new Label(8, 14 + i, gmemberresearchproduction.getProdapplication(), ExcelStyleFormat.style1()));
					wws.mergeCells(2, 15 + i, 3, 15 + i);
					wws.mergeCells(4, 15 + i, 5, 15 + i);
					wws.mergeCells(6, 15 + i, 7, 15 + i);
					wws.mergeCells(8, 15 + i, 10, 15 + i);
				}

			}
			wws.addCell(new Label(1, 14 + gmemberresearchproductionlistsize.intValue(), ""));
			Integer currentRow = Integer.valueOf(14 + gmemberresearchproductionlistsize.intValue() + 1);
			wws.mergeCells(1, currentRow.intValue(), 10, currentRow.intValue());
			wws.addCell(new Label(1, currentRow.intValue(), "专利、标准信息", ExcelStyleFormat.style12()));
			wws.addCell(new Label(1, currentRow.intValue() + 1, "序号", ExcelStyleFormat.style11()));
			wws.mergeCells(2, currentRow.intValue() + 1, 3, currentRow.intValue() + 1);
			wws.addCell(new Label(2, currentRow.intValue() + 1, "专利（标准）名称", ExcelStyleFormat.style6()));
			wws.mergeCells(4, currentRow.intValue() + 1, 5, currentRow.intValue() + 1);
			wws.addCell(new Label(4, currentRow.intValue() + 1, "授权（发布）日期", ExcelStyleFormat.style6()));
			wws.mergeCells(6, currentRow.intValue() + 1, 7, currentRow.intValue() + 1);
			wws.addCell(new Label(6, currentRow.intValue() + 1, "专利类型", ExcelStyleFormat.style6()));
			wws.mergeCells(8, currentRow.intValue() + 1, 10, currentRow.intValue() + 1);
			wws.addCell(new Label(8, currentRow.intValue() + 1, "可应用领域", ExcelStyleFormat.style1()));
			Integer gmemberpatentinfoListSize = Integer.valueOf(list2.size());
			if (gmemberpatentinfoListSize.intValue() == 1) {
				Gmemberpatentinfo gmemberpatentinfo = new Gmemberpatentinfo();
				gmemberpatentinfo = (Gmemberpatentinfo) (Gmemberpatentinfo) list2.get(0);
				wws.mergeCells(2, currentRow.intValue() + 2, 3, currentRow.intValue() + 2);
				wws.mergeCells(4, currentRow.intValue() + 2, 5, currentRow.intValue() + 2);
				wws.mergeCells(6, currentRow.intValue() + 2, 7, currentRow.intValue() + 2);
				wws.mergeCells(8, currentRow.intValue() + 2, 10, currentRow.intValue() + 2);
				String joinDate = "";
				wws.addCell(new Label(1, currentRow.intValue() + 2, "1", ExcelStyleFormat.style7()));
				wws.addCell(new Label(2, currentRow.intValue() + 2, gmemberpatentinfo.getPatentname(), ExcelStyleFormat.style7()));
				wws.addCell(new Label(4, currentRow.intValue() + 2, DateUtil.getDateString(gmemberpatentinfo.getPatentdate(), "yyyy-MM-dd"), ExcelStyleFormat.style7()));
				wws.addCell(new Label(6, currentRow.intValue() + 2, gmemberpatentinfo.getPatenttype(), ExcelStyleFormat.style7()));
				wws.addCell(new Label(8, currentRow.intValue() + 2, gmemberpatentinfo.getPatentapplication(), ExcelStyleFormat.style4()));
			} else {
				for (int i = 0; i < gmemberpatentinfoListSize.intValue(); i++) {
					Gmemberpatentinfo gmemberpatentinfo = new Gmemberpatentinfo();
					gmemberpatentinfo = (Gmemberpatentinfo) (Gmemberpatentinfo) list2.get(i);
					wws.mergeCells(2, currentRow.intValue() + 2 + i, 3, currentRow.intValue() + 2 + i);
					wws.mergeCells(4, currentRow.intValue() + 2 + i, 5, currentRow.intValue() + 2 + i);
					wws.mergeCells(6, currentRow.intValue() + 2 + i, 7, currentRow.intValue() + 2 + i);
					wws.mergeCells(8, currentRow.intValue() + 2 + i, 10, currentRow.intValue() + 2 + i);
					wws.addCell(new Label(1, currentRow.intValue() + 2 + i, String.valueOf(i + 1), ExcelStyleFormat.style10()));
					wws.addCell(new Label(2, currentRow.intValue() + 2 + i, gmemberpatentinfo.getPatentname(), ExcelStyleFormat.style7()));
					wws.addCell(new Label(4, currentRow.intValue() + 2 + i, DateUtil.getDateString(gmemberpatentinfo.getPatentdate(), "yyyy-MM-dd"), ExcelStyleFormat.style7()));
					wws.addCell(new Label(6, currentRow.intValue() + 2 + i, gmemberpatentinfo.getPatenttype(), ExcelStyleFormat.style7()));
					wws.addCell(new Label(8, currentRow.intValue() + 2 + i, gmemberpatentinfo.getPatentapplication(), ExcelStyleFormat.style4()));
				}

			}
			wwb.write();
			wwb.close();
			wb.close();
			FileOutputStream fos = new FileOutputStream(outputFile);
			targetFile.writeTo(fos);
			targetFile.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public WriteExcel(List list, String UPath, String outputFile, String a, String b, String c, String d, int e) {
		try {
			Workbook wb = Workbook.getWorkbook(new File(UPath));
			ByteArrayOutputStream targetFile = new ByteArrayOutputStream();
			WritableWorkbook wwb = Workbook.createWorkbook(targetFile, wb);
			WritableSheet wws = wwb.getSheet("Sheet1");
			String title = "用户日志";
			wws.addCell(new Label(0, 0, title));
			for (int i = 0; i < list.size(); i++) {
				UserLogForm bean = (UserLogForm) (UserLogForm) list.get(i);
				wws.addCell(new Label(0, i + 2, String.valueOf(i)));
				wws.addCell(new Label(1, i + 2, String.valueOf(bean.getTemptime())));
				wws.addCell(new Label(2, i + 2, String.valueOf(bean.getUser())));
				wws.addCell(new Label(3, i + 2, String.valueOf(bean.getAcademy())));
				wws.addCell(new Label(4, i + 2, String.valueOf(bean.getOperation())));
			}

			wwb.write();
			wwb.close();
			wb.close();
			FileOutputStream fos = new FileOutputStream(outputFile);
			targetFile.writeTo(fos);
			targetFile.close();
		} catch (Exception f) {
			f.printStackTrace();
		}
	}

	public WriteExcel(List list, String UPath, String outputFile, String a, String b, String c, String d) {
		try {
			Workbook wb = Workbook.getWorkbook(new File(UPath));
			ByteArrayOutputStream targetFile = new ByteArrayOutputStream();
			WritableWorkbook wwb = Workbook.createWorkbook(targetFile, wb);
			WritableSheet wws = wwb.getSheet("Sheet1");
			int num = 0;
			for (int i = 0; i < list.size(); i++) {
				int array = num / 3;
				int line = num - array * 3;
				Smemberbaseinfo bean = (Smemberbaseinfo) (Smemberbaseinfo) list.get(i);
				if ((bean.getHomeaddress() != null) && (bean.getHomepostcode() != null) && !bean.getHomeaddress().equals("") && !bean.getHomepostcode().equals("")) {
					if (line == 0) {
						for (int y = 0; y < 3; y++) {
							wws.setRowView(array * 3 + y, 621);
							if (y == 0)
								wws.setRowView(array * 3, 450);
							else if (y == 1)
								wws.setRowView(array * 3 + 1, 913);
							else if (y == 2)
								wws.setRowView(array * 3 + 2, 500);
						}

					}
					wws.addCell(new Label(line, array * 3, "   " + String.valueOf(bean.getHomepostcode()), ExcelStyleFormat.style18()));
					wws.addCell(new Label(line, array * 3 + 1, String.valueOf(bean.getHomeaddress()), ExcelStyleFormat.style5()));
					wws.addCell(new Label(line, array * 3 + 2, String.valueOf(bean.getMemname()), ExcelStyleFormat.style55()));
					num++;
				} else if (!bean.getInstituteaddress().equals(null) && !bean.getInstitutepostcode().equals(null) && !bean.getInstituteaddress().equals("") && !bean.getInstitutepostcode().equals("")) {
					if (line == 0) {
						for (int y = 0; y < 3; y++) {
							wws.setRowView(array * 3 + y, 621);
							if (y == 0)
								wws.setRowView(array * 3, 450);
							else if (y == 1)
								wws.setRowView(array * 3 + 1, 913);
							else if (y == 2)
								wws.setRowView(array * 3 + 2, 500);
						}

					}
					String address = String.valueOf(bean.getInstituteaddress());
					if (String.valueOf(bean.getMeminstitute()) != null) {
						address = address + "\n" + String.valueOf(bean.getMeminstitute());
						if (String.valueOf(bean.getMemdept()) != null) {
							address = address + String.valueOf(bean.getMemdept());
						}
					}
					wws.addCell(new Label(line, array * 3, "   " + String.valueOf(bean.getInstitutepostcode()), ExcelStyleFormat.style18()));
					wws.addCell(new Label(line, array * 3 + 1, address, ExcelStyleFormat.style5()));
					wws.addCell(new Label(line, array * 3 + 2, String.valueOf(bean.getMemname()), ExcelStyleFormat.style55()));
					num++;
				}
			}

			wwb.write();
			wwb.close();
			wb.close();
			FileOutputStream fos = new FileOutputStream(outputFile);
			targetFile.writeTo(fos);
			targetFile.close();
		} catch (Exception f) {
			f.printStackTrace();
		}
	}

	public WriteExcel(List list, String UPath, String outputFile, String a, String b, String c, String d, String e, String g) {
		try {
			Workbook wb = Workbook.getWorkbook(new File(UPath));
			ByteArrayOutputStream targetFile = new ByteArrayOutputStream();
			WritableWorkbook wwb = Workbook.createWorkbook(targetFile, wb);
			WritableSheet wws = wwb.getSheet("Sheet1");
			int num = 0;
			for (int i = 0; i < list.size(); i++) {
				int array = num / 3;
				int line = num - array * 3;
				Smemberbainforelation bean = (Smemberbainforelation) (Smemberbainforelation) list.get(i);
				if ((bean.getHomeaddress() != null) && (bean.getHomepostcode() != null) && !bean.getHomeaddress().equals("") && !bean.getHomepostcode().equals("")) {
					if (line == 0) {
						for (int y = 0; y < 3; y++) {
							wws.setRowView(array * 3 + y, 621);
							if (y == 0)
								wws.setRowView(array * 3, 450);
							else if (y == 1)
								wws.setRowView(array * 3 + 1, 913);
							else if (y == 2)
								wws.setRowView(array * 3 + 2, 500);
						}

					}
					wws.addCell(new Label(line, array * 3, "   " + String.valueOf(bean.getHomepostcode()), ExcelStyleFormat.style18()));
					wws.addCell(new Label(line, array * 3 + 1, String.valueOf(bean.getHomeaddress()), ExcelStyleFormat.style5()));
					wws.addCell(new Label(line, array * 3 + 2, String.valueOf(bean.getMemname()), ExcelStyleFormat.style55()));
					num++;
				} else if ((bean.getInstituteaddress() != null) && (bean.getInstitutepostcode() != null) && !bean.getInstituteaddress().equals("") && !bean.getInstitutepostcode().equals("")) {
					if (line == 0) {
						for (int y = 0; y < 3; y++) {
							wws.setRowView(array * 3 + y, 621);
							if (y == 0)
								wws.setRowView(array * 3, 450);
							else if (y == 1)
								wws.setRowView(array * 3 + 1, 913);
							else if (y == 2)
								wws.setRowView(array * 3 + 2, 500);
						}
					}
					String address = String.valueOf(bean.getInstituteaddress());
					if (bean.getMeminstitute() != null) {
						address = address + "\n" + String.valueOf(bean.getMeminstitute());
						if (bean.getMemdept() != null) {
							address = address + String.valueOf(bean.getMemdept());
						}
					}

					wws.addCell(new Label(line, array * 3, "   " + String.valueOf(bean.getInstitutepostcode()), ExcelStyleFormat.style18()));
					wws.addCell(new Label(line, array * 3 + 1, address, ExcelStyleFormat.style5()));
					wws.addCell(new Label(line, array * 3 + 2, String.valueOf(bean.getMemname()), ExcelStyleFormat.style55()));
					num++;
				}
			}

			wwb.write();
			wwb.close();
			wb.close();
			FileOutputStream fos = new FileOutputStream(outputFile);
			targetFile.writeTo(fos);
			targetFile.close();
		} catch (Exception f) {
			f.printStackTrace();
		}
	}

	public WriteExcel(List list, String UPath, String outputFile, String a, String b, String c, String d, int e, String f) {
		try {
			Workbook wb = Workbook.getWorkbook(new File(UPath));
			ByteArrayOutputStream targetFile = new ByteArrayOutputStream();
			WritableWorkbook wwb = Workbook.createWorkbook(targetFile, wb);
			WritableSheet wws = wwb.getSheet("Sheet1");
			String title = f;
			wws.addCell(new Label(0, 0, title, ExcelStyleFormat.style16()));
			wws.addCell(new Label(0, 3, "其中：", ExcelStyleFormat.style16()));
			wws.addCell(new Label(1, 3, "团体会员类型", ExcelStyleFormat.style16()));
			wws.addCell(new Label(2, 3, "数量（个）", ExcelStyleFormat.style16()));
			wws.addCell(new Label(3, 3, "百分比（%）", ExcelStyleFormat.style16()));
			wws.addCell(new Label(4, 3, "", ExcelStyleFormat.style16()));
			for (int i = 0; i < list.size(); i++) {
				TempBean bean = (TempBean) (TempBean) list.get(i);
				if (i == 0) {
					wws.addCell(new Label(0, 2, String.valueOf(bean.getAcadno()), ExcelStyleFormat.style16()));
					wws.addCell(new Label(1, 2, String.valueOf(bean.getAssoname()), ExcelStyleFormat.style16()));
					wws.addCell(new Label(2, 2, String.valueOf(bean.getNumber()), ExcelStyleFormat.style16()));
					wws.addCell(new Label(3, 2, String.valueOf(bean.getCountshai_id()), ExcelStyleFormat.style16()));
					wws.addCell(new Label(4, 2, "", ExcelStyleFormat.style16()));
				} else if (i + 1 < list.size()) {
					wws.addCell(new Label(0, i + 3, String.valueOf(i), ExcelStyleFormat.style16()));
					wws.addCell(new Label(1, i + 3, String.valueOf(bean.getAgesegment()), ExcelStyleFormat.style16()));
					wws.addCell(new Label(2, i + 3, String.valueOf(bean.getNumber()), ExcelStyleFormat.style16()));
					wws.addCell(new Label(3, i + 3, String.valueOf(bean.getRatio()), ExcelStyleFormat.style16()));
					wws.addCell(new Label(4, i + 3, "", ExcelStyleFormat.style16()));
				} else if (i + 1 == list.size()) {
					wws.addCell(new Label(0, i + 3, String.valueOf(i), ExcelStyleFormat.style17()));
					wws.addCell(new Label(1, i + 3, String.valueOf(bean.getAgesegment()), ExcelStyleFormat.style17()));
					wws.addCell(new Label(2, i + 3, String.valueOf(bean.getNumber()), ExcelStyleFormat.style17()));
					wws.addCell(new Label(3, i + 3, String.valueOf(bean.getRatio()), ExcelStyleFormat.style17()));
					wws.addCell(new Label(4, i + 3, "", ExcelStyleFormat.style17()));
				}
			}

			wwb.write();
			wwb.close();
			wb.close();
			FileOutputStream fos = new FileOutputStream(outputFile);
			targetFile.writeTo(fos);
			targetFile.close();
		} catch (Exception z) {
			z.printStackTrace();
		}
	}

	public WriteExcel(List list, String UPath, String outputFile, String a, String b, String c, String d, int e, int f, String g) {
		try {
			Workbook wb = Workbook.getWorkbook(new File(UPath));
			ByteArrayOutputStream targetFile = new ByteArrayOutputStream();
			WritableWorkbook wwb = Workbook.createWorkbook(targetFile, wb);
			WritableSheet wws = wwb.getSheet("Sheet1");
			String title = g;
			wws.addCell(new Label(0, 0, title, ExcelStyleFormat.style16()));
			List namelist = new ArrayList();
			List institutelist = new ArrayList();
			namelist = (ArrayList) (ArrayList) list.get(1);
			institutelist = (ArrayList) (ArrayList) list.get(0);
			int line = namelist.size();
			for (int i = 0; i < line; i++) {
				GroupStatForm formall = new GroupStatForm();
				formall = (GroupStatForm) (GroupStatForm) namelist.get(i);
				wws.addCell(new Label(0, i + 2, String.valueOf(i + 1), ExcelStyleFormat.style16()));
				wws.addCell(new Label(1, i + 2, String.valueOf(formall.getName()), ExcelStyleFormat.style16()));
				wws.addCell(new Label(2, i + 2, String.valueOf(formall.getNum()), ExcelStyleFormat.style16()));
				wws.addCell(new Label(3, i + 2, String.valueOf(formall.getNewnum()), ExcelStyleFormat.style16()));
				wws.addCell(new Label(4, i + 2, "", ExcelStyleFormat.style16()));
			}

			wws.addCell(new Label(0, line + 2, "其中：", ExcelStyleFormat.style16()));
			wws.addCell(new Label(1, line + 2, "团体会员类型", ExcelStyleFormat.style16()));
			wws.addCell(new Label(2, line + 2, "数量（个）", ExcelStyleFormat.style16()));
			wws.addCell(new Label(3, line + 2, "百分比（%）", ExcelStyleFormat.style16()));
			wws.addCell(new Label(4, line + 2, "", ExcelStyleFormat.style16()));
			for (int i = 0; i < institutelist.size(); i++) {
				GroupStatForm formall = new GroupStatForm();
				formall = (GroupStatForm) (GroupStatForm) institutelist.get(i);
				wws.addCell(new Label(0, i + 3 + line, String.valueOf(i + 1), ExcelStyleFormat.style17()));
				wws.addCell(new Label(1, i + 3 + line, String.valueOf(formall.getName()), ExcelStyleFormat.style17()));
				wws.addCell(new Label(2, i + 3 + line, String.valueOf(formall.getNum()), ExcelStyleFormat.style17()));
				wws.addCell(new Label(3, i + 3 + line, String.valueOf(formall.getRatio()), ExcelStyleFormat.style17()));
				wws.addCell(new Label(4, i + 3 + line, "", ExcelStyleFormat.style17()));
			}

			wwb.write();
			wwb.close();
			wb.close();
			FileOutputStream fos = new FileOutputStream(outputFile);
			targetFile.writeTo(fos);
			targetFile.close();
		} catch (Exception z) {
			z.printStackTrace();
		}
	}

	public WriteExcel(List list, String UPath, String outputFile, String a, String b, String c, int d, int e, int f, String g) {
		try {
			Workbook wb = Workbook.getWorkbook(new File(UPath));
			ByteArrayOutputStream targetFile = new ByteArrayOutputStream();
			WritableWorkbook wwb = Workbook.createWorkbook(targetFile, wb);
			WritableSheet wws = wwb.getSheet("Sheet1");
			String title = g;
			wws.addCell(new Label(0, 0, title, ExcelStyleFormat.style13()));
			List namelist = new ArrayList();
			List institutelist = new ArrayList();
			namelist = (ArrayList) (ArrayList) list.get(1);
			institutelist = (ArrayList) (ArrayList) list.get(0);
			int line = namelist.size();
			for (int i = 0; i < line; i++) {
				GroupStatForm formall = new GroupStatForm();
				formall = (GroupStatForm) (GroupStatForm) namelist.get(i);
				wws.addCell(new Label(0, i + 2, String.valueOf(i + 1), ExcelStyleFormat.style16()));
				wws.addCell(new Label(1, i + 2, String.valueOf(formall.getName()), ExcelStyleFormat.style16()));
				wws.addCell(new Label(2, i + 2, String.valueOf(formall.getNum()), ExcelStyleFormat.style16()));
				wws.addCell(new Label(3, i + 2, String.valueOf(formall.getNewnum()), ExcelStyleFormat.style16()));
				wws.addCell(new Label(4, i + 2, "", ExcelStyleFormat.style16()));
			}

			wws.addCell(new Label(0, line + 2, "其中：", ExcelStyleFormat.style16()));
			wws.addCell(new Label(1, line + 2, "团体会员类型", ExcelStyleFormat.style16()));
			wws.addCell(new Label(2, line + 2, "数量（个）", ExcelStyleFormat.style16()));
			wws.addCell(new Label(3, line + 2, "百分比（%）", ExcelStyleFormat.style16()));
			wws.addCell(new Label(4, line + 2, "", ExcelStyleFormat.style16()));
			for (int i = 0; i < institutelist.size(); i++) {
				GroupStatForm formall = new GroupStatForm();
				formall = (GroupStatForm) (GroupStatForm) institutelist.get(i);
				wws.addCell(new Label(0, i + 3 + line, String.valueOf(i + 1), ExcelStyleFormat.style17()));
				wws.addCell(new Label(1, i + 3 + line, String.valueOf(formall.getName()), ExcelStyleFormat.style17()));
				wws.addCell(new Label(2, i + 3 + line, String.valueOf(formall.getNum()), ExcelStyleFormat.style17()));
				wws.addCell(new Label(3, i + 3 + line, String.valueOf(formall.getRatio()), ExcelStyleFormat.style17()));
				wws.addCell(new Label(4, i + 3 + line, "", ExcelStyleFormat.style17()));
			}

			wwb.write();
			wwb.close();
			wb.close();
			FileOutputStream fos = new FileOutputStream(outputFile);
			targetFile.writeTo(fos);
			targetFile.close();
		} catch (Exception z) {
			z.printStackTrace();
		}
	}
}