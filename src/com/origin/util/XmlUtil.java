package com.origin.util;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.xml.sax.InputSource;

import com.origin.model.DTOModel;
import com.origin.model.FieldModel;
import com.origin.model.FileModel;
import com.origin.model.MethodModel;

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
public class XmlUtil
{
	private static List<String> basicList = new ArrayList<String>();
	private static List<DTOModel> dtoList = new ArrayList<DTOModel>();
	private static List<MethodModel> methodList = new ArrayList<MethodModel>();
	private static List<FileModel> fileList = new ArrayList<FileModel>();
	private static List<String> daoList = new ArrayList<String>();
	private static final String configxml = "generator_config.xml";
	private static String filepath = FilePathUtil.getJarPath(XmlUtil.class);

	private static Document readXml()
	{
		SAXBuilder sax = new SAXBuilder();
		Document doc = null;
		try
		{
			doc = sax.build(new InputSource(new FileReader(filepath + "\\" + configxml)));
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return doc;
	}

	private static List<String> transformBasic()
	{
		Document doc = readXml();
		basicList.add(doc.getRootElement().getChild("basic").getChild("author").getValue());
		basicList.add(doc.getRootElement().getChild("basic").getChild("projectroot").getValue());
		basicList.add(doc.getRootElement().getChild("basic").getChild("modularroot").getValue());
		basicList.add(doc.getRootElement().getChild("basic").getChild("springname").getValue());
		basicList.add(doc.getRootElement().getChild("basic").getChild("junitroot").getValue());
		return basicList;
	}

	@SuppressWarnings("unchecked")
	public static List<DTOModel> transformDTO()
	{
		Document doc = readXml();
		List dtos = doc.getRootElement().getChild("dtos").getChildren("dto");
		for (Object obj : dtos)
		{
			Element el = (Element) obj;
			DTOModel dto = new DTOModel();
			dto.setName(el.getAttributeValue("name"));
			dto.setNote(el.getAttributeValue("note"));
			List<FieldModel> fields = new ArrayList<FieldModel>();
			for (Object obj1 : el.getChildren("field"))
			{
				Element el1 = (Element) obj1;
				FieldModel field = new FieldModel();
				field.setName(el1.getChild("name").getValue());
				field.setType(el1.getChild("type").getValue());
				field.setNote(el1.getChild("note").getValue());
				fields.add(field);
			}
			dto.setFields(fields);
			dtoList.add(dto);
		}
		return dtoList;
	}

	@SuppressWarnings("unchecked")
	public static List<MethodModel> transformMethod()
	{
		Document doc = readXml();
		List methods = doc.getRootElement().getChild("methods").getChildren("method");
		for (Object obj : methods)
		{
			Element el = (Element) obj;
			MethodModel method = new MethodModel();
			method.setTofile(el.getAttributeValue("tofile"));
			method.setName(el.getAttributeValue("name"));
			method.setNote(el.getAttributeValue("note"));
			method.setFileTypes(el.getAttributeValue("fileType"));
			method.setParamName(el.getChild("paramterName").getValue());
			method.setParamType(el.getChild("paramterType").getValue());
			method.setReturnName(el.getChild("returnName").getValue());
			method.setReturnType(el.getChild("returnType").getValue());
			methodList.add(method);
		}
		return methodList;
	}

	@SuppressWarnings("unchecked")
	public static List<FileModel> transformFile()
	{
		Document doc = readXml();
		List files = doc.getRootElement().getChild("business").getChildren("file");
		for (Object obj : files)
		{
			Element el = (Element) obj;
			FileModel file = new FileModel();
			file.setFileName(el.getAttributeValue("name"));
			file.setNote(el.getAttributeValue("note"));
			file.setFileTypes(el.getAttributeValue("fileType"));
			fileList.add(file);
		}
		return fileList;
	}

	@SuppressWarnings("unchecked")
	public static List<String> transformDao()
	{
		Document doc = readXml();
		List daos = doc.getRootElement().getChild("daos").getChildren("dao");
		for (Object obj : daos)
		{
			Element el = (Element) obj;
			daoList.add(el.getValue());
		}
		return daoList;
	}

	public static String getAuthor()
	{
		return transformBasic().get(0);
	}

	public static String getProjectRoot()
	{
		return transformBasic().get(1);
	}

	public static String getModularRoot()
	{
		return transformBasic().get(2);
	}
	
	public static String getSpringName()
	{
		return transformBasic().get(3);
	}

	public static String getJunitRoot()
	{
		return transformBasic().get(4);
	}
}
