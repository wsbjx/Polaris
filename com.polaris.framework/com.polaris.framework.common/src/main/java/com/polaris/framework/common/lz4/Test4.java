package com.polaris.framework.common.lz4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import net.jpountz.lz4.LZ4BlockInputStream;
import net.jpountz.lz4.LZ4Factory;
import net.jpountz.xxhash.XXHashFactory;

public class Test4
{
	public static void main(String[] args) throws Exception
	{
		OutputStream os = new FileOutputStream(new File("f:/test/test2.txt"));
		InputStream is = new FileInputStream(new File("f:/test/test2.lz4"));
		LZ4BlockInputStream bis = new LZ4BlockInputStream(is, LZ4Factory.fastestInstance().fastDecompressor(), XXHashFactory
				.fastestInstance().newStreamingHash32(88888).asChecksum());
		byte[] buffer = new byte[4096];
		while (true)
		{
			int length = bis.read(buffer);
			if (length < 0)
			{
				break;
			}
			os.write(buffer, 0, length);
		}
		bis.close();
		is.close();
		os.close();
	}
}
