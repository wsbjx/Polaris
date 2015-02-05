package com.polaris.framework.common.lz4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.io.IOUtils;

import net.jpountz.lz4.LZ4Compressor;
import net.jpountz.lz4.LZ4Factory;

public class Test2
{
	public static void main(String[] args) throws Exception
	{
		LZ4Factory factory = LZ4Factory.fastestInstance();
		InputStream is = new FileInputStream(new File("f:/test/web.xml"));
		byte[] src = IOUtils.toByteArray(is);
		System.out.println("src length= " + src.length);//157007
		is.close();
		final int decompressedLength = src.length;
		LZ4Compressor compressor = factory.fastCompressor();
		int maxCompressedLength = compressor.maxCompressedLength(decompressedLength);
		byte[] dest = new byte[maxCompressedLength];
		int destLength = compressor.compress(src, 0, decompressedLength, dest, 0, maxCompressedLength);
		System.out.println("dest length= " + destLength);//26600
		OutputStream os = new FileOutputStream(new File("f:/test/test.lz4"));
		os.write(dest, 0, destLength);
		os.close();
	}

}
