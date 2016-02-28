package com.mobile.blue.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

/**
 * 
 * @author dennis zhao 2014-12-17 zipUtil class
 */
public class ZipUtil {
	/**
	 * 功能:压缩多个文件成一个zip文件
	 * 
	 * @param srcfile
	 *            ：源文件列表
	 * @param zipfile
	 *            ：压缩后的文件 只
	 */
	public static void zipFiles(List<File> srcfile, File zipfile) {
		byte[] buf = new byte[4096];
		try {
			ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipfile));
			for (File file : srcfile) {
				FileInputStream in = new FileInputStream(file);
				out.putNextEntry(new ZipEntry(file.getName()));
				int len;
				while ((len = in.read(buf)) > 0) {
					out.write(buf, 0, len);
				}
				out.closeEntry();
				in.close();
			}
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 功能:解压缩由文件组成的zip,
	 * 
	 * @param zipfile
	 *            ：需要解压缩的文件
	 * @param descDir
	 *            ：解压后的目标目录
	 * @throws Exception
	 */
	@SuppressWarnings({ "resource", "rawtypes" })
	public static void unZipFiles(File zipfile, String descDir) {
		try {
			ZipFile zf = new ZipFile(zipfile);
			for (Enumeration entries = zf.entries(); entries.hasMoreElements();) {
				ZipEntry entry = (ZipEntry) entries.nextElement();
				String zipEntryName = entry.getName();
				InputStream in = zf.getInputStream(entry);

				File outFile = new File(descDir + File.separator + zipEntryName);
				if (!outFile.getParentFile().exists()) {
					outFile.getParentFile().mkdir();
				}
				if (!outFile.exists()) {
					outFile.createNewFile();
				}
				OutputStream out = new FileOutputStream(outFile);
				byte[] buf = new byte[4096];
				int len;
				while ((len = in.read(buf)) > 0) {
					out.write(buf, 0, len);
				}
				in.close();
				out.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
			// throw new Exception("unzip files exception....");
		}
	}

	public static void main(String[] args) {
		// 3个源文件
		// File f1 = new File("R:\\zip\\detail\\xxxx_1234.zip");
		// File f2 = new File("R:\\zip\\detail\\xxxx_1235.zip");
		// File f3 = new File("R:\\zip\\detail\\yyyy_1234.zip");
		// // 压缩后的文件
		// File zipfile = new File("R:\\zip\\abc.zip");
		// zipFiles(Arrays.asList(f1, f2, f3), zipfile);
		try {
			// String md5 = EncryptMD5Util.getFileMD5("R:\\zip\\abc.zip");
			// System.out.println(md5);
			// zipfile.renameTo(new File("R:\\zip\\" + md5+".zip"));
			String fileName = "R:\\zip\\abc\\fd8365f3583930ab1e5b791ed56fff5d.zip";
			System.out.println("old file name ====" + fileName);
			System.out.println("after md5sum name====" + EncryptMD5Util.getFileMD5(fileName));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 需要解压缩的文件
		File file = new File("R:\\zip\\abc\\fd8365f3583930ab1e5b791ed56fff5d.zip");
		// 解压后的目标目录
		String dir = "R:\\zip\\detail";
		try {
			unZipFiles(file, dir);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}