package com.cssrc.util;

import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.VerticalAlignment;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;

public class ExcelStyleFormat {
	public ExcelStyleFormat() {

	}

	public static WritableCellFormat common() {
		try {
			WritableFont wf = new WritableFont(WritableFont.ARIAL, 11, WritableFont.NO_BOLD, false);
			WritableCellFormat common = new WritableCellFormat(wf);
			common.setWrap(true);
			common.setShrinkToFit(true);
			return common;
		} catch (Exception e) {
			return null;
		}
	}

	// Style1:下线框细 右线框中 水平居中 垂直居中
	public static WritableCellFormat style1() {
		try {
			WritableCellFormat style1 = new WritableCellFormat(common());
			style1.setBorder(Border.BOTTOM, BorderLineStyle.THIN);
			style1.setBorder(Border.RIGHT, BorderLineStyle.MEDIUM);
			style1.setAlignment(Alignment.CENTRE);
			style1.setVerticalAlignment(VerticalAlignment.CENTRE);
			return style1;
		} catch (Exception e) {
			return null;
		}
	}

	// Style2:下线框细 水平居中 垂直居中
	public static WritableCellFormat style2() {
		try {
			WritableCellFormat style2 = new WritableCellFormat(common());
			style2.setBorder(Border.BOTTOM, BorderLineStyle.THIN);
			style2.setAlignment(Alignment.CENTRE);
			style2.setVerticalAlignment(VerticalAlignment.CENTRE);
			return style2;
		} catch (Exception e) {
			return null;
		}
	}

	// Style3:下线框中 水平居中 垂直居中
	public static WritableCellFormat style3() {
		try {
			WritableCellFormat style3 = new WritableCellFormat(common());
			style3.setBorder(Border.BOTTOM, BorderLineStyle.MEDIUM);
			style3.setAlignment(Alignment.CENTRE);
			style3.setVerticalAlignment(VerticalAlignment.CENTRE);
			return style3;
		} catch (Exception e) {
			return null;
		}
	}

	// Style4:下线框中 右线框中 水平居中 垂直居中
	public static WritableCellFormat style4() {
		try {
			WritableCellFormat style4 = new WritableCellFormat(common());
			style4.setBorder(Border.BOTTOM, BorderLineStyle.MEDIUM);
			style4.setBorder(Border.RIGHT, BorderLineStyle.MEDIUM);
			style4.setAlignment(Alignment.CENTRE);
			style4.setVerticalAlignment(VerticalAlignment.CENTRE);
			return style4;
		} catch (Exception e) {
			return null;
		}
	}

	// Style5:水平居中 垂直居中
	public static WritableCellFormat style5() {
		try {
			WritableCellFormat style5 = new WritableCellFormat(common());
			style5.setAlignment(Alignment.CENTRE);
			style5.setVerticalAlignment(VerticalAlignment.CENTRE);
			return style5;
		} catch (Exception e) {
			return null;
		}
	}

	// Style5:水平居上 垂直居中
	public static WritableCellFormat style55() {
		try {
			WritableCellFormat style5 = new WritableCellFormat(common());
			style5.setAlignment(Alignment.CENTRE);
			style5.setVerticalAlignment(VerticalAlignment.TOP);
			return style5;
		} catch (Exception e) {
			return null;
		}
	}

	// Style6:下线框细 右线框细 水平居中 垂直居中
	public static WritableCellFormat style6() {
		try {
			WritableCellFormat style6 = new WritableCellFormat(common());
			style6.setBorder(Border.BOTTOM, BorderLineStyle.THIN);
			style6.setBorder(Border.RIGHT, BorderLineStyle.THIN);
			style6.setAlignment(Alignment.CENTRE);
			style6.setVerticalAlignment(VerticalAlignment.CENTRE);
			return style6;
		} catch (Exception e) {
			return null;
		}
	}

	// Style7:下线框中 右线框细 水平居中 垂直居中
	public static WritableCellFormat style7() {
		try {
			WritableCellFormat style7 = new WritableCellFormat(common());
			style7.setBorder(Border.BOTTOM, BorderLineStyle.MEDIUM);
			style7.setBorder(Border.RIGHT, BorderLineStyle.THIN);
			style7.setAlignment(Alignment.CENTRE);
			style7.setVerticalAlignment(VerticalAlignment.CENTRE);
			return style7;
		} catch (Exception e) {
			return null;
		}
	}

	// Style8:上线框中 右线框中 下线框细 水平居中 垂直居中
	public static WritableCellFormat style8() {
		try {
			WritableCellFormat style8 = new WritableCellFormat(common());
			style8.setBorder(Border.TOP, BorderLineStyle.MEDIUM);
			style8.setBorder(Border.BOTTOM, BorderLineStyle.THIN);
			style8.setBorder(Border.RIGHT, BorderLineStyle.MEDIUM);
			style8.setAlignment(Alignment.CENTRE);
			style8.setVerticalAlignment(VerticalAlignment.CENTRE);
			return style8;
		} catch (Exception e) {
			return null;
		}
	}

	// Style9:左线框中 右线框细 水平居中 垂直居中
	public static WritableCellFormat style9() {
		try {
			WritableCellFormat style9 = new WritableCellFormat(common());
			style9.setBorder(Border.LEFT, BorderLineStyle.MEDIUM);
			style9.setBorder(Border.RIGHT, BorderLineStyle.THIN);
			style9.setAlignment(Alignment.CENTRE);
			style9.setVerticalAlignment(VerticalAlignment.CENTRE);
			return style9;
		} catch (Exception e) {
			return null;
		}
	}

	// Style10:左线框中 下线框中 右线框细 水平居中 垂直居中
	public static WritableCellFormat style10() {
		try {
			WritableCellFormat style10 = new WritableCellFormat(common());
			style10.setBorder(Border.LEFT, BorderLineStyle.MEDIUM);
			style10.setBorder(Border.RIGHT, BorderLineStyle.THIN);
			style10.setBorder(Border.BOTTOM, BorderLineStyle.MEDIUM);
			style10.setAlignment(Alignment.CENTRE);
			style10.setVerticalAlignment(VerticalAlignment.CENTRE);
			return style10;
		} catch (Exception e) {
			return null;
		}
	}

	// Style11:下线框细 右线框细 左线框中 水平居中 垂直居中
	public static WritableCellFormat style11() {
		try {
			WritableCellFormat style11 = new WritableCellFormat(common());
			style11.setBorder(Border.BOTTOM, BorderLineStyle.THIN);
			style11.setBorder(Border.RIGHT, BorderLineStyle.THIN);
			style11.setBorder(Border.LEFT, BorderLineStyle.MEDIUM);
			style11.setAlignment(Alignment.CENTRE);
			style11.setVerticalAlignment(VerticalAlignment.CENTRE);
			return style11;
		} catch (Exception e) {
			return null;
		}
	}

	// Style12:四周边框都中 水平居左 垂直居中 适用于表头
	public static WritableCellFormat style12() {
		try {
			WritableFont title = new WritableFont(WritableFont.ARIAL, 12, WritableFont.BOLD, false);
			WritableCellFormat style12 = new WritableCellFormat(title);
			style12.setBorder(Border.BOTTOM, BorderLineStyle.MEDIUM);
			style12.setBorder(Border.RIGHT, BorderLineStyle.MEDIUM);
			style12.setBorder(Border.LEFT, BorderLineStyle.MEDIUM);
			style12.setBorder(Border.TOP, BorderLineStyle.MEDIUM);
			style12.setAlignment(Alignment.LEFT);
			style12.setVerticalAlignment(VerticalAlignment.CENTRE);
			return style12;
		} catch (Exception e) {
			return null;
		}
	}

	// Style13: 定义了字体 水平居中 垂直居中 title
	public static WritableCellFormat style13() {
		try {
			WritableFont title = new WritableFont(WritableFont.ARIAL, 12, WritableFont.BOLD, false);
			WritableCellFormat style13 = new WritableCellFormat(title);
			style13.setAlignment(Alignment.CENTRE);
			style13.setVerticalAlignment(VerticalAlignment.CENTRE);
			return style13;
		} catch (Exception e) {
			return null;
		}
	}

	// Style14: 下线框细 右线框细 左线框细 水平居中 垂直居中
	public static WritableCellFormat style14() {
		try {
			WritableCellFormat style14 = new WritableCellFormat(common());
			style14.setBorder(Border.BOTTOM, BorderLineStyle.THIN);
			style14.setBorder(Border.RIGHT, BorderLineStyle.THIN);
			style14.setBorder(Border.LEFT, BorderLineStyle.THIN);
			style14.setAlignment(Alignment.CENTRE);
			style14.setVerticalAlignment(VerticalAlignment.CENTRE);
			return style14;
		} catch (Exception e) {
			return null;
		}
	}

	// Style15: 右线框细 左线框细 水平居中 垂直居中
	public static WritableCellFormat style15() {
		try {
			WritableCellFormat style14 = new WritableCellFormat(common());
			style14.setBorder(Border.RIGHT, BorderLineStyle.THIN);
			style14.setBorder(Border.LEFT, BorderLineStyle.THIN);
			style14.setAlignment(Alignment.CENTRE);
			style14.setVerticalAlignment(VerticalAlignment.CENTRE);
			return style14;
		} catch (Exception e) {
			return null;
		}
	}

	// Style16: 上线框细 右线框细 左线框细 水平居左 垂直居中
	public static WritableCellFormat style16() {
		try {
			WritableCellFormat style14 = new WritableCellFormat(common());
			style14.setBorder(Border.TOP, BorderLineStyle.THIN);
			style14.setBorder(Border.RIGHT, BorderLineStyle.THIN);
			style14.setBorder(Border.LEFT, BorderLineStyle.THIN);
			style14.setAlignment(Alignment.CENTRE);
			style14.setVerticalAlignment(VerticalAlignment.CENTRE);
			return style14;
		} catch (Exception e) {
			return null;
		}
	}

	// Style17: 上下线框细 右线框细 左线框细 水平居左 垂直居中
	public static WritableCellFormat style17() {
		try {
			WritableCellFormat style14 = new WritableCellFormat(common());
			style14.setBorder(Border.TOP, BorderLineStyle.THIN);
			style14.setBorder(Border.BOTTOM, BorderLineStyle.THIN);
			style14.setBorder(Border.RIGHT, BorderLineStyle.THIN);
			style14.setBorder(Border.LEFT, BorderLineStyle.THIN);
			style14.setAlignment(Alignment.LEFT);
			style14.setVerticalAlignment(VerticalAlignment.CENTRE);
			return style14;
		} catch (Exception e) {
			return null;
		}
	}

	// Style18: 无线框 水平居左 垂直居中
	public static WritableCellFormat style18() {
		try {
			WritableCellFormat style14 = new WritableCellFormat(common());
			style14.setAlignment(Alignment.LEFT);
			style14.setVerticalAlignment(VerticalAlignment.BOTTOM);
			return style14;
		} catch (Exception e) {
			return null;
		}
	}
}
