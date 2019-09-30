package com.aowin.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import org.springframework.stereotype.Component;

import sun.misc.BASE64Encoder;

/**
 * 图片处理的工具类
 * @author Peter
 *
 */
@SuppressWarnings("restriction")
@Component
public class ImageUtil {

	public String getImageBase64(String strCode) throws IOException {
		int width = 60, height = 20;
		// 创建一个位于缓存中的图像，宽度为60，高度为20
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		// 获取用于处理图形上下文的对象，相当于画笔
		Graphics g = image.getGraphics();
		Random random = new Random(); // 随机数对象
		g.setColor(getRandomColor(200, 250)); // 设置图像的背景色
		g.fillRect(0, 0, width, height); // 画一个矩形，坐标为（0，0），宽度为60，高度为20
		g.setFont(new Font("Times New Roman", Font.PLAIN, 18)); // 设置字体格式
		g.setColor(getRandomColor(160, 200));
		for (int i = 0; i < 130; i++) { // 产生130条干扰线
			int x = random.nextInt(width);
			int y = random.nextInt(height);
			int x1 = random.nextInt(12); // nextInt(12) 代表0到12的int类型随机数
			int y1 = random.nextInt(12);
			g.drawLine(x, y, x + x1, y + y1); // 在图像的坐标（x,y）和坐标(x+x1,y+y1)之间画干扰线
		}
		String[] strNum = strCode.split("");
		for (int i = 0; i < 4; i++) {
			// 设置字体颜色
			g.setColor(new Color(15 + random.nextInt(120), 15 + random.nextInt(120), 15 + random.nextInt(120)));
			g.drawString(strNum[i], 13 * i + 6, 16); // 将验证码依次画在图像上，坐标为(13*i+6,16)
		}
		g.dispose(); // 释放此图像的上下文以及它使用的所以系统资源
		ByteArrayOutputStream baos = new ByteArrayOutputStream();//io流
        ImageIO.write(image, "png", baos);//写入流中
        byte[] bytes = baos.toByteArray();//转换成字节
		BASE64Encoder encoder = new BASE64Encoder();
		String png_base64 =  encoder.encodeBuffer(bytes);//转换成base64串
        png_base64 = png_base64.replaceAll("\n", "").replaceAll("\r", "");//删除 \r\n
		//System.out.println(png_base64);
		return png_base64;
	}
	/**
	 * 随机颜色
	 */
	private Color getRandomColor(int fc, int bc) {
		Random random = new Random();
		Color randomcolor = null;
		if (fc > 255)
			fc = 255;
		if (bc > 255)
			bc = 255;
		// 设置0-255之间的随机颜色值
		int r = fc + random.nextInt(bc - fc);
		int g = fc + random.nextInt(bc - fc);
		int b = fc + random.nextInt(bc - fc);
		randomcolor = new Color(r, g, b);
		return randomcolor; // 返回具有红蓝绿的不透明的sRGB的颜色
	}
}
