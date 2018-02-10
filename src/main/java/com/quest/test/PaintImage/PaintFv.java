package com.quest.test.PaintImage;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.util.List;

public class PaintFv extends BufferedImage {
	protected List<Integer> dots;

	private final static int margin = 24;
	private final static int innerW = 300;
	private final static int innerH = 120;

	public PaintFv(List<Integer> dots, int imageType) {
		super(innerW + 2 * margin, innerH + 2 * margin, imageType);
		this.dots = dots;
		draw();
	}

	private void drawXaxis(Graphics2D g2d) {
		int x1 = 0, x2 = 0, len = 8;
		int ww = innerW / len;
		for (int i = 0; i < len; i++) {
			x2 += ww;
			g2d.drawLine(x1, 0, x2, 0);
			g2d.drawLine(x2, 0, x2, -6);
			x1 = x2;
		}
		g2d.drawString("8L", x2 + 2, 0);
	}

	private void drawYaxis(Graphics2D g2d) {
		int y1 = 0, y2 = 0, len = 7;
		int ww = innerH / len;
		for (int i = 0; i < len; i++) {
			y2 -= ww;
			g2d.drawLine(0, y1, 0, y2);
			g2d.drawLine(0, y2, 6, y2);
			y1 = y2;
		}
		g2d.drawString("14L/s", -5, y2 - 2);
		g2d.drawString("流速容量曲线（F-V）", 90, y2 - 2);
	}

	public void draw() {
		Graphics2D g2d = this.createGraphics();
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
		g2d.setColor(Color.WHITE);//白底
		g2d.fillRect(0,0,innerW + 2 * margin, innerH + 2 * margin);//填充整个屏幕
		g2d.setColor(Color.BLACK);//黑线
		g2d.translate(margin, margin + innerH);
		g2d.setFont(new Font("宋体", Font.PLAIN, 15));
		drawXaxis(g2d);
		drawYaxis(g2d);
		int x1 = 0, y1 = 0;
		float tempValue = 0;
		for (int i = 0; i < dots.size(); i++) {
			tempValue += dots.get(i) * 0.033f;
			if(i % 2 ==0){				
				int x2 = (int) (1 + Math.round(tempValue / 1000 * 37.5));
				int y2 = (int) -Math.round(dots.get(i) * 8.57 / 1000);
				g2d.drawLine(x1, y1, x2, y2);
				x1 = x2;
				y1 = y2;
			}
		}
		g2d.dispose();
	}

}
