package com.origin.util;

import java.io.UnsupportedEncodingException;

/**
 * <p>
 * Title:
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * Create Date 2011-11-29 Create By zhengzhenwen
 * 
 * Modify Date 2011-11-29 Modify By zhengzhenwen
 * 
 */
public class FilePathUtil
{
	/**
	 * »ñÈ¡JARÂ·¾¶
	 * 
	 * @param clazz
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static String getJarPath(Class clazz)
	{
		String jarPath = "";
		String path = clazz.getProtectionDomain().getCodeSource().getLocation().getFile();
		try
		{
			path = java.net.URLDecoder.decode(path, "UTF-8");
		} catch (UnsupportedEncodingException e)
		{
			e.printStackTrace();
		}
		java.io.File jarFile = new java.io.File(path);
		java.io.File parent = jarFile.getParentFile();
		if (parent != null)
		{
			jarPath = parent.getAbsolutePath();
		}
		return jarPath;
	}
}
