package com.mobile.blue.util;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

@SuppressWarnings("restriction")
public class CompressPic {

	private File file = null;
	private String outputDir;
	private String outputFileName;
	private int outputWidth = 100;
	private int outputHeight = 100;
	private boolean proportion = true; 

	public CompressPic() { 
		outputDir = "";
		outputFileName = "";
		outputWidth = 100;
		outputHeight = 100;
	}
	public void setOutputDir(String outputDir) {
		this.outputDir = outputDir;
	}

	public void setOutputFileName(String outputFileName) {
		this.outputFileName = outputFileName;
	}

	public void setOutputWidth(int outputWidth) {
		this.outputWidth = outputWidth;
	}

	public void setOutputHeight(int outputHeight) {
		this.outputHeight = outputHeight;
	}

	public void setWidthAndHeight(int width, int height) {
		this.outputWidth = width;
		this.outputHeight = height;
	}

	public long getPicSize(String path) {
		file = new File(path);
		return file.length();
	}

	public String compressPic() {
		try {
			if (!file.exists()) {
				file.mkdirs(); 
			}
			// 手动设置以下权限。
			file.setWritable(true, false);
			if (!file.exists()) {
				file.mkdirs();
			}
			Image img = ImageIO.read(file);
			if (img.getWidth(null) == -1) {
				System.out.println(" can't read,retry!" + "<BR>");
				return "no";
			} else {
				int newWidth;
				int newHeight;
				if (this.proportion == true) {
					double rate1 = ((double) img.getWidth(null))
							/ (double) outputWidth + 0.1;
					double rate2 = ((double) img.getHeight(null))
							/ (double) outputHeight + 0.1;
					double rate = rate1 > rate2 ? rate1 : rate2;
					newWidth = (int) (((double) img.getWidth(null)) / rate);
					newHeight = (int) (((double) img.getHeight(null)) / rate);
				} else {
					newWidth = outputWidth; 
					newHeight = outputHeight; 
				}
				BufferedImage tag = new BufferedImage((int) newWidth,
						(int) newHeight, BufferedImage.TYPE_INT_RGB);

				tag.getGraphics().drawImage(
						img.getScaledInstance(newWidth, newHeight,
								Image.SCALE_SMOOTH), 0, 0, null);
				File f=new File(outputDir);
				if (!f.exists()){
					f.mkdirs(); 
				}
				FileOutputStream out = new FileOutputStream(outputDir
						+ outputFileName);
				JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
				encoder.encode(tag);
				out.close();
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return "ok";
	}

	public String compressPic(File file,String outputDir,String outputFileName, int width, int height,
			boolean gp) {
		this.outputDir = outputDir;
		this.outputFileName = outputFileName;
		setWidthAndHeight(width, height);
		this.proportion = gp;
		this.file=file;
		return compressPic();
	}
	public static void main(String[] args) {
		CompressPic com= new CompressPic();
		System.out.println("start work:");
//		com.compressPic("F:\\eclipseWork\\TestImg\\src\\aaa.jpg","H:\\qq.jpeg","aaa.jpg","qq.jpeg",50,50,true);
		com.compressPic(new File(""),"F:\\eclipseWork\\TestImg\\src\\","aaa.jpg",50,50,false);
	}
}
