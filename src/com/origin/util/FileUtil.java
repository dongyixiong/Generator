package com.origin.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
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
public class FileUtil
{
	private static final String modularRoot = XmlUtil.getModularRoot().replace(".", "\\");
	private static final String junitRoot = XmlUtil.getJunitRoot().replace(".", "\\");
	private static final String dtopath = "src\\"+modularRoot+"\\dto\\service\\";
	private static final String wspath = "src\\"+modularRoot+"\\service\\";
	private static final String factorypath = "src\\"+modularRoot+"\\factory\\";
	private static final String bopath = "src\\"+modularRoot+"\\bo\\";
	// private static final String daopath = "src\\com\\origin\\dao\\";
	private static final String testpath = "src\\"+junitRoot+"\\";
	private static final String springpath = "src\\";
	// private static final String xfirepath = "src\\WebRoot\\WEB-INF\\";

	private static final String springname = XmlUtil.getSpringName();
	// private static final String xfirename = "xfire-servlet.xml";

	private static final String path = XmlUtil.getProjectRoot();

	private static void checkPathExisted(String pathRoot)
	{
		File file = new File(pathRoot);
		if (!file.exists())
		{
			file.mkdirs();
		}
	}

	private static boolean checkFileExisted(String pathRoot)
	{
		File file = new File(pathRoot);
		if (!file.exists())
		{
			return false;
		} else
		{
			return true;
		}
	}

	private static void writeToFile(String pathRoot, String fileName, String content)
	{
		
		checkPathExisted(pathRoot);
		File file = new File(pathRoot + fileName);
		try
		{
			file.createNewFile();
			PrintWriter bw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file),
					"UTF-8")));
			bw.write(content);
			bw.flush();
			bw.close();
		} catch (UnsupportedEncodingException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void updateFile(String pathRoot, String fileName, String content, String str)
	{
		if (checkFileExisted(pathRoot + fileName))
		{
			File oldFile = new File(pathRoot + fileName);
			File newFile = new File(pathRoot + fileName + ".bak");
			try
			{
				BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(oldFile), "UTF-8"));
				PrintWriter bw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(
						new FileOutputStream(newFile), "UTF-8")));
				String line;
				while ((line = br.readLine()) != null)
				{
					bw.println(line);
					if (line != null && !line.trim().equals("") && line.contains(str))
					{
						bw.println(content);
					}
				}
				bw.flush();
				bw.close();
				br.close();
				oldFile.delete();
				newFile.renameTo(new File(pathRoot + fileName));
			} catch (FileNotFoundException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private static void updateMethod(String pathRoot, String fileName, String content, String strImport)
	{
		if (checkFileExisted(pathRoot + fileName))
		{
			File oldFile = new File(pathRoot + fileName);
			File newFile = new File(pathRoot + fileName + ".bak");
			try
			{
				BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(oldFile), "UTF-8"));
				PrintWriter bw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(
						new FileOutputStream(newFile), "UTF-8")));
				String line;
				boolean lock1 = false;
				boolean lock2 = false;
				while ((line = br.readLine()) != null)
				{
					if (!lock1 && line != null && !line.trim().equals("") && line.contains("import"))
					{
						bw.println(strImport);
						lock1 = true;
					}

					bw.println(line);
					if (!lock2 && line != null && !line.trim().equals("") && line.contains("{"))
					{
						bw.println(content);
						lock2 = true;
					}
				}
				bw.flush();
				bw.close();
				br.close();
				oldFile.delete();
				newFile.renameTo(new File(pathRoot + fileName));
			} catch (FileNotFoundException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void writeDTO(String fileName, String content)
	{
		writeToFile(path + dtopath, fileName + ".java", content);
	}

	public static void writeFile(String fileName, String content)
	{
		String filepath = "";
		if (fileName.endsWith("WS"))
		{
			filepath = wspath;
		} else if (fileName.endsWith("Factory"))
		{
			filepath = factorypath;
		} else if (fileName.endsWith("BO"))
		{
			filepath = bopath;
		} else if (fileName.endsWith("Test"))
		{
			filepath = testpath;
		}
		writeToFile(path + filepath, fileName + ".java", content);
	}

	public static void updateConfigFile(String type, String content)
	{
		String str = "";
		if (type.equalsIgnoreCase("WS"))
		{
			str = "*service*";
		} else if (type.equalsIgnoreCase("FACTORY"))
		{
			str = "*factory*";
		} else if (type.equalsIgnoreCase("BO"))
		{
			str = "*bo*";
		} else if (type.equalsIgnoreCase("DAO"))
		{
			str = "*dao*";
		}
		updateFile(path + springpath, springname, content, str);
	}

	public static void writeMethod(String fileName, String content, String strImport)
	{
		String filepath = "";
		if (fileName.endsWith("WS"))
		{
			filepath = wspath;
		} else if (fileName.endsWith("Factory"))
		{
			filepath = factorypath;
		} else if (fileName.endsWith("BO"))
		{
			filepath = bopath;
		} else if (fileName.endsWith("Test"))
		{
			filepath = testpath;
		}
		updateMethod(path + filepath, fileName + ".java", content, strImport);
	}

	// public static void main(String[] args)
	// {
	// FileUtil.updateMethod(path + wspath, "IValueCodeWS", "absc");
	// }
}
