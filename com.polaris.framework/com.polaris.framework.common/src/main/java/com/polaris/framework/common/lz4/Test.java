package com.polaris.framework.common.lz4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.io.IOUtils;

import net.jpountz.lz4.LZ4Factory;
import net.jpountz.lz4.LZ4FastDecompressor;

//import net.jpountz.lz4.LZ4SafeDecompressor;

public class Test
{
	public static void main(String[] args) throws Exception
	{
		LZ4Factory factory = LZ4Factory.fastestInstance();
		LZ4FastDecompressor fastDecompressor = factory.fastDecompressor();
		// LZ4SafeDecompressor safeDecompressor = factory.safeDecompressor();
		InputStream is = new FileInputStream(new File("f:/test/test.lz4"));
		byte[] src = IOUtils.toByteArray(is);//26600
		is.close();
		System.out.println("src length= " + src.length);
		// byte[] dest = safeDecompressor.decompress(src, src.length * 200);
		byte[] dest = new byte[200000];
		int destLength = fastDecompressor.decompress(src, dest);
		System.out.println("dest length= " + destLength);
		OutputStream os = new FileOutputStream(new File("f:/test/test.txt"));
		os.write(dest, 0, destLength);
		os.close();
	}
}
