package com.quest.test.PaintImage;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.util.List;

public class PaintMvv extends BufferedImage {
	protected List<Integer> dots;

	private final static int margin = 24;
	private final static int innerW = 300;
	private final static int innerH = 120;

	public PaintMvv(List<Integer> dots, int imageType) {
		super(innerW + 2 * margin, innerH + 2 * margin, imageType);
		this.dots = dots;
		draw();
	}

	private void drawXaxis(Graphics2D g2d) {
		int x1 = 0, x2 = 0, len = 15;
		int ww = innerW / len;
		for (int i = 0; i < len; i++) {
			x2 += ww;
			g2d.drawLine(x1, 0, x2, 0);
			g2d.drawLine(x2, 0, x2, -6);
			x1 = x2;
		}
		g2d.drawString("30s", x2 + 2, 0);
	}

	private void drawYaxis(Graphics2D g2d) {
		int y1 = 0, y2 = 0, len = 10, y3 = 0, y4 = 0;
		int ww = innerH / len;
		for (int i = 0; i < len / 2; i++) {
			y2 -= ww;
			y4 += ww;
			// 画y轴上半轴
			g2d.drawLine(0, y1, 0, y2);
			g2d.drawLine(0, y2, 6, y2);
			// 画y轴下半轴
			g2d.drawLine(0, y3, 0, y4);
			g2d.drawLine(0, y4, 6, y4);
			y1 = y2;
			y3 = y4;
		}
		g2d.drawString("5L", -5, y2 - 2);
		g2d.drawString("-5L", -5, y4 + 12);
		g2d.drawString("最大通气量测试曲线（MVV-T）", 70, y2 - 2);
	}

	public void draw() {
		Graphics2D g2d = this.createGraphics();
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
		g2d.setColor(Color.WHITE);//白底
		g2d.fillRect(0,0,innerW + 2 * margin, innerH + 2 * margin);//填充整个屏幕
		g2d.setColor(Color.BLACK);//黑线
		g2d.translate(margin, margin + innerH / 2);
		g2d.setFont(new Font("宋体", Font.PLAIN, 15));
		drawXaxis(g2d);
		drawYaxis(g2d);
		int x1 = 0, y1 = 0;
		float tempValue = 0;
		for (int i = 0; i < dots.size(); i++) {
			tempValue += dots.get(i) * 0.05f;
			if (i % 4 == 0) {
				int x2 = 1 + i / 2;
				int y2 = (int) -Math.round(tempValue / 1000 * 12);
				g2d.drawLine(x1, y1, x2, y2);
				x1 = x2;
				y1 = y2;
			}
		}
		g2d.dispose();
	}

}
