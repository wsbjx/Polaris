package com.polaris.framework.common.lz4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import net.jpountz.lz4.LZ4BlockOutputStream;
import net.jpountz.lz4.LZ4Factory;
import net.jpountz.xxhash.XXHashFactory;

public class Test3
{
	public static void main(String[] args) throws Exception
	{
		OutputStream os = new FileOutputStream(new File("f:/test/test2.lz4"));
		LZ4BlockOutputStream bos = new LZ4BlockOutputStream(os, 1 << 16, LZ4Factory.fastestInstance().fastCompressor(), XXHashFactory
				.fastestInstance().newStreamingHash32(88888).asChecksum(), false);
		InputStream is = new FileInputStream(new File("f:/test/web.xml"));
		byte[] buffer = new byte[4096];
		while (true)
		{
			int length = is.read(buffer);
			if (length < 0)
			{
				break;
			}
			bos.write(buffer, 0, length);
		}
		bos.close();
		is.close();
		os.close();

	}
}
