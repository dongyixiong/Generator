package com.origin.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.origin.model.BusinessModel;
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
public class Builder
{
	public static String modularRoot = XmlUtil.getModularRoot();
	public static String junitRoot = XmlUtil.getJunitRoot();
	public static final String dtoPackage = "package "+modularRoot+".dto.service;";
	public static final String wsPackage = "package "+modularRoot+".service;";
	public static final String factoryPackage = "package "+modularRoot+".factory;";
	public static final String boPackage = "package "+modularRoot+".bo;";
	public static final String daoPackage = "package "+modularRoot+".dao;";
	public static final String testPackage = "package "+junitRoot+";";
	public static final String dtoExtends = "SOAPDataTransferObject";
	public static final String wSExtends = "WebServiceObject";
	public static final String iWSExtends = "IWebServiceObject";
	public static final String iFactoryExtends = "IBusinessObject";
	public static final String factoryExtends = "BusinessObject";
	public static final String testExtends = "BaseTestCaseJunit44";
	public static String author = XmlUtil.getAuthor();

	public static String getPropertyName(String fieldName)
	{
		return String.valueOf(fieldName.charAt(0)).toUpperCase() + fieldName.substring(1, fieldName.length());
	}

	public static String getLowPropertyName(String fieldName)
	{
		return String.valueOf(fieldName.charAt(0)).toLowerCase() + fieldName.substring(1, fieldName.length());
	}

	private static String buildTestImport(String fileName)
	{
		StringBuffer sb = new StringBuffer();
		sb.append("import org.springframework.beans.factory.annotation.Autowired;").append("\n\n");
		sb.append("import com.origin.base.BaseTestCaseJunit44;").append("\n");
		sb.append("import ").append(modularRoot).append(".bo.").append(fileName).append("BO;").append("\n\n");
		return sb.toString();
	}

	private static String buildImport(DTOModel dto)
	{
		StringBuffer sb = new StringBuffer();
		boolean check = false;
		for (FieldModel field : dto.getFields())
		{
			String type = field.getType();
			if (type.contains("List"))
			{
				sb.append("import java.util.List;").append("\n");
				check = true;
			} else if (type.contains("Date"))
			{
				sb.append("import java.util.Date;").append("\n");
				check = true;
			}
		}
		if (check)
		{
			sb.append("\n");
		}
		sb.append("import com.origin.base.SOAPDataTransferObject;").append("\n\n");
		return sb.toString();
	}

	private static String buildMethodImport(String request, String response)
	{
		StringBuffer sb = new StringBuffer();
		sb.append("import ").append(modularRoot).append(".dto.service.").append(request).append(";\n");
		sb.append("import ").append(modularRoot).append(".dto.service.").append(response).append(";\n");
		return sb.toString();
	}

	private static String buildTestMethodImport(String request, String response)
	{
		StringBuffer sb = new StringBuffer();
		sb.append("import org.junit.Test;\n").append(buildMethodImport(request, response));
		return sb.toString();
	}

	private static String buildBOMethodImport(String request, String response)
	{
		StringBuffer sb = new StringBuffer();
		sb.append("import com.origin.base.ApplicationEnvironment;\n").append(buildMethodImport(request, response));
		return sb.toString();
	}

	private static String buildIWSImport()
	{
		StringBuffer sb = new StringBuffer();
		sb.append("import com.origin.base.IWebServiceObject;").append("\n\n");
		return sb.toString();
	}

	private static String buildWSImport(String name)
	{
		StringBuffer sb = new StringBuffer();
		sb.append("import com.origin.base.WebServiceObject;").append("\n");
		sb.append("import ").append(modularRoot).append(".factory.I").append(name).append("Factory;").append("\n\n");
		return sb.toString();
	}

	private static String buildIFactoryImport()
	{
		StringBuffer sb = new StringBuffer();
		sb.append("import com.origin.base.IBusinessObject;").append("\n\n");
		return sb.toString();
	}

	private static String buildFactoryImport(String name)
	{
		StringBuffer sb = new StringBuffer();
		sb.append("import com.origin.base.BusinessObject;").append("\n");
		sb.append("import ").append(modularRoot).append(".bo.I").append(name).append("BO;").append("\n\n");
		return sb.toString();
	}

	private static String buildIBOImport(String name)
	{
		StringBuffer sb = new StringBuffer();
		sb.append("import ").append(modularRoot).append(".factory.I").append(name).append("Factory;").append("\n\n");
		return sb.toString();
	}

	private static String buildBOImport(String name)
	{
		StringBuffer sb = new StringBuffer();
		sb.append("import ").append(modularRoot).append(".factory.").append(name).append("Factory;").append("\n\n");
		return sb.toString();
	}

	private static String buildWSMethodDescription(String note, String param)
	{
		// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		// String date = sdf.format(new Date());
		StringBuffer sb = new StringBuffer();
		sb.append("\t/**").append("\n");
		sb.append("\t * ").append(note).append("\n");
		sb.append("\t * ").append("\n");
		sb.append("\t * @param ").append(param).append("\n");
		sb.append("\t * @return").append("\n");
		sb.append("\t */").append("\n");
		return sb.toString();
	}

	private static String buildDescription(String note)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(new Date());
		StringBuffer sb = new StringBuffer();
		sb.append("/**").append("\n");
		sb.append(" * <p>").append("\n");
		sb.append(" * Title:").append(note).append("\n");
		sb.append(" * </p>").append("\n");
		sb.append(" * <p>").append("\n");
		sb.append(" * Description:").append("\n");
		sb.append(" * </p>").append("\n");
		sb.append(" * ").append("\n");
		sb.append(" * Create Date ").append(date).append(" Create By ").append(author).append("\n");
		sb.append(" * ").append("\n");
		sb.append(" * Modify Date ").append(date).append(" Modify By ").append(author).append("\n");
		sb.append(" * ").append("\n");
		sb.append(" */").append("\n");
		return sb.toString();
	}

	public static List<DTOModel> buildDTOBody(List<DTOModel> dtos)
	{
		for (DTOModel dto : dtos)
		{
			StringBuffer sb = new StringBuffer();
			sb.append(dtoPackage).append("\n\n");
			sb.append(buildImport(dto));
			sb.append(buildDescription(dto.getNote()));
			sb.append("public class ").append(dto.getName()).append(" extends ").append(dtoExtends).append("\n");
			sb.append("{\n");
			for (FieldModel field : dto.getFields())
			{
				sb.append("\tprivate ").append(field.getType()).append(" ").append(field.getName()).append(";// ")
						.append(field.getNote()).append("\n");
			}
			sb.append("\n");
			for (FieldModel field : dto.getFields())
			{
				sb.append("\tpublic ").append(field.getType()).append(" get").append(getPropertyName(field.getName()))
						.append("()").append("\n");
				sb.append("\t{\n");
				sb.append("\t\treturn ").append(field.getName()).append(";\n");
				sb.append("\t}\n\n");
				sb.append("\tpublic void").append(" set").append(getPropertyName(field.getName())).append(
						"(" + field.getType() + " " + field.getName() + ")").append("\n");
				sb.append("\t{\n");
				sb.append("\t\tthis.").append(field.getName()).append(" = ").append(field.getName()).append(";\n");
				sb.append("\t}\n\n");
			}
			sb.append("}\n");
			dto.setContent(sb.toString());
		}
		return dtos;
	}

	private static List<String> splitFileTypes(String strTypes)
	{
		List<String> fileTypes = new ArrayList<String>();
		if (strTypes != null && !strTypes.equals(""))
		{
			for (String s : strTypes.split(","))
			{
				if (!s.equals(""))
				{
					fileTypes.add(s);
				}
			}
		}
		return fileTypes;
	}

	public static List<FileModel> buildFiles(List<FileModel> files)
	{
		for (FileModel file : files)
		{
			List<String> fileTypes = splitFileTypes(file.getFileTypes());
			List<BusinessModel> contents = new ArrayList<BusinessModel>();
			for (String type : fileTypes)
			{
				String content = "";
				String iContent = "";
				BusinessModel business = new BusinessModel();
				BusinessModel iBusiness = new BusinessModel();
				if (type.equalsIgnoreCase("WS"))
				{
					content = buildWSFile(author, file);
					iContent = buildIWSFile(author, file);
					business.setFileName(file.getFileName() + "WS");
					business.setContent(content);
					business.setType("WS");
					iBusiness.setFileName("I" + file.getFileName() + "WS");
					iBusiness.setContent(iContent);
					iBusiness.setType("IWS");
				} else if (type.equalsIgnoreCase("FACTORY"))
				{
					content = buildFactoryFile(author, file);
					iContent = buildIFactoryFile(author, file);
					business.setFileName(file.getFileName() + "Factory");
					business.setContent(content);
					business.setType("FACTORY");
					iBusiness.setFileName("I" + file.getFileName() + "Factory");
					iBusiness.setContent(iContent);
					iBusiness.setType("IFACTORY");
				} else if (type.equalsIgnoreCase("BO"))
				{
					content = buildBOFile(author, file);
					iContent = buildIBOFile(author, file);
					business.setFileName(file.getFileName() + "BO");
					business.setContent(content);
					business.setType("BO");
					iBusiness.setFileName("I" + file.getFileName() + "BO");
					iBusiness.setContent(iContent);
					iBusiness.setType("IBO");
				} else if (type.equalsIgnoreCase("TEST"))
				{
					content = buildTestFile(author, file);
					business.setFileName(file.getFileName() + "BOTest");
					business.setContent(content);
					business.setType("TEST");
				}
				business.setConfig(buildConfigureFile(type, file));
				contents.add(business);
				contents.add(iBusiness);
			}
			file.setContents(contents);
		}

		return files;
	}

	public static List<MethodModel> buildMethods(List<MethodModel> methods)
	{
		for (MethodModel method : methods)
		{
			List<String> fileTypes = splitFileTypes(method.getFileTypes());
			List<BusinessModel> contents = new ArrayList<BusinessModel>();
			for (String type : fileTypes)
			{
				String content = "";
				String iContent = "";
				String strImport = buildMethodImport(method.getParamType(), method.getReturnType());
				BusinessModel business = new BusinessModel();
				BusinessModel iBusiness = new BusinessModel();
				business.setStrImport(strImport);
				iBusiness.setStrImport(strImport);
				if (type.equalsIgnoreCase("WS"))
				{
					content = buildWSMethod(author, method);
					iContent = buildIWSMethod(author, method);
					business.setFileName(method.getTofile() + "WS");
					business.setContent(content);
					business.setType("WS");
					iBusiness.setFileName("I" + method.getTofile() + "WS");
					iBusiness.setContent(iContent);
					iBusiness.setType("IWS");
				} else if (type.equalsIgnoreCase("FACTORY"))
				{
					content = buildFactoryMethod(author, method);
					iContent = buildIFactoryMethod(author, method);
					business.setFileName(method.getTofile() + "Factory");
					business.setContent(content);
					business.setType("FACTORY");
					business.setStrImport(buildBOMethodImport(method.getParamType(), method.getReturnType()));
					iBusiness.setFileName("I" + method.getTofile() + "Factory");
					iBusiness.setContent(iContent);
					iBusiness.setType("IFACTORY");
				} else if (type.equalsIgnoreCase("BO"))
				{
					content = buildBOMethod(author, method);
					iContent = buildIBOMethod(author, method);
					business.setFileName(method.getTofile() + "BO");
					business.setContent(content);
					business.setType("BO");
					business.setStrImport(buildBOMethodImport(method.getParamType(), method.getReturnType()));
					iBusiness.setFileName("I" + method.getTofile() + "BO");
					iBusiness.setContent(iContent);
					iBusiness.setType("IBO");
				} else if (type.equalsIgnoreCase("TEST"))
				{
					content = buildTestMethod(author, method);
					business.setFileName(method.getTofile() + "BOTest");
					business.setContent(content);
					business.setType("TEST");
					business.setStrImport(buildTestMethodImport(method.getParamType(), method.getReturnType()));
				}
				contents.add(business);
				contents.add(iBusiness);
			}
			method.setContents(contents);
		}
		return methods;
	}

	private static String buildTestMethod(String author, MethodModel method)
	{
		String factory = getLowPropertyName(method.getTofile()) + "BO";
		StringBuffer sb = new StringBuffer();
		sb.append("\n");
		sb.append("\tpublic void test" + getPropertyName(method.getName()) + "()\n");
		sb.append("\t{\n");
		sb.append("\t\t" + method.getParamType() + " " + method.getParamName() + " = new " + method.getParamType()
				+ "();\n");
		sb.append("\t\ttry\n");
		sb.append("\t\t{\n");
		sb.append("\t\t\t" + factory + "." + method.getName() + "BO(" + method.getParamName() + ");\n");
		sb.append("\t\t} catch (RuntimeException re)\n");
		sb.append("\t\t{\n");
		sb.append("\t\t\tre.printStackTrace();\n");
		sb.append("\t\t} catch (Exception e)\n");
		sb.append("\t\t{\n");
		sb.append("\t\t\te.printStackTrace();\n");
		sb.append("\t\t}\n");
		sb.append("\t}\n");
		return sb.toString();
	}

	private static String buildWSMethod(String author, MethodModel method)
	{
		String factory = "i" + method.getTofile();
		StringBuffer sb = new StringBuffer();
		sb.append("\tpublic " + method.getReturnType() + " " + method.getName() + "WS(" + method.getParamType() + " "
				+ method.getParamName() + ")\n");
		sb.append("\t{\n");
		sb.append("\t\t" + method.getReturnType() + " " + method.getReturnName() + " = new " + method.getReturnType()
				+ "();\n");
		sb.append("\t\ttry\n");
		sb.append("\t\t{\n");
		sb.append("\t\t\t" + method.getReturnName() + " = " + factory + "Factory." + method.getName() + "Factory("
				+ method.getParamName() + ");\n");
		sb.append("\t\t} catch (RuntimeException re)\n");
		sb.append("\t\t{\n");
		sb.append("\t\t\tre.printStackTrace();\n" + "\t\t\t" + method.getReturnName() + ".setErrorCode(\"1003\");\n");
		sb.append("\t\t\t" + method.getReturnName() + ".setErrorMessage(\"\");\n");
		sb.append("\t\t} catch (Exception e)\n");
		sb.append("\t\t{\n");
		sb.append("\t\t\te.printStackTrace();\n" + "\t\t\t" + method.getReturnName() + ".setErrorCode(\"1003\");\n");
		sb.append("\t\t\t" + method.getReturnName() + ".setErrorMessage(\"\");\n");
		sb.append("\t\t} finally\n");
		sb.append("\t\t{\n");
		sb.append("\t\t\treturn " + method.getReturnName() + ";\n");
		sb.append("\t\t}\n");
		sb.append("\t}\n");
		return sb.toString();
	}

	private static String buildIWSMethod(String author, MethodModel method)
	{
		StringBuffer sb = new StringBuffer();
		sb.append(buildWSMethodDescription(method.getNote(), method.getParamName()));
		sb.append("\tpublic " + method.getReturnType() + " " + method.getName() + "WS(" + method.getParamType() + " "
				+ method.getParamName() + ");\n");
		return sb.toString();
	}

	private static String buildFactoryMethod(String author, MethodModel method)
	{
		String BO = "i" + method.getTofile() + "BO";
		StringBuffer sb = new StringBuffer();
		sb.append("\tpublic " + method.getReturnType() + " " + method.getName() + "Factory(" + method.getParamType()
				+ " " + method.getParamName() + ") throws RuntimeException, Exception\n");
		sb.append("\t{\n");
		sb.append("\t\t" + method.getReturnType() + " " + method.getReturnName() + " = new " + method.getReturnType()
				+ "();\n");
		sb.append("\t\ttry\n");
		sb.append("\t\t{\n");
		sb.append("\t\t\t" + method.getReturnName() + " = " + BO + "." + method.getName() + "BO("
				+ method.getParamName() + ");\n");
		sb.append("\t\t} catch (RuntimeException re)\n");
		sb.append("\t\t{\n");
		sb.append("\t\t\tre.printStackTrace();\n");
		sb.append("\t\t\tlogger.error(\"" + method.getNote() + "出错!error:" + method.getTofile() + "Factory."
				+ method.getName() + "Factory\");\n\t\t\tthrow re;\n");
		sb.append("\t\t} catch (Exception e)\n");
		sb.append("\t\t{\n");
		sb.append("\t\t\te.printStackTrace();\n");
		sb.append("\t\t\tlogger.error(\"" + method.getNote() + "出错!error:" + method.getTofile() + "Factory."
				+ method.getName() + "Factory\");\n\t\t\tthrow e;\n");
		sb.append("\t\t}\n");
		sb.append("\t\treturn " + method.getReturnName() + ";\n");
		sb.append("\t}\n");
		return sb.toString();
	}

	private static String buildIFactoryMethod(String author, MethodModel method)
	{
		StringBuffer sb = new StringBuffer();
		sb.append(buildWSMethodDescription(method.getNote(), method.getParamName()));
		sb.append("\tpublic " + method.getReturnType() + " " + method.getName() + "Factory(" + method.getParamType()
				+ " " + method.getParamName() + ") throws RuntimeException, Exception;\n");
		return sb.toString();
	}

	private static String buildBOMethod(String author, MethodModel method)
	{
		StringBuffer sb = new StringBuffer();
		sb.append("\tpublic " + method.getReturnType() + " " + method.getName() + "BO(" + method.getParamType() + " "
				+ method.getParamName() + ") throws RuntimeException, Exception\n");
		sb.append("\t{\n");
		sb.append("\t\t" + method.getReturnType() + " " + method.getReturnName() + " = new " + method.getReturnType()
				+ "();\n");
		sb.append("\t\ttry\n");
		sb.append("\t\t{\n");
		sb.append("\t\t\t" + method.getReturnName() + ".setErrorCode(\"0\");\n");
		sb.append("\t\t\t" + method.getReturnName() + ".setErrorMessage(\"\");\n");
		sb.append("\t\t} catch (RuntimeException re)\n");
		sb.append("\t\t{\n");
		sb.append("\t\t\tlogger.error(\"" + method.getNote() + "出错!error:" + method.getTofile() + "BO."
				+ method.getName() + "BO\");\n\t\t\tthrow re;\n");
		sb.append("\t\t} catch (Exception e)\n");
		sb.append("\t\t{\n");
		sb.append("\t\t\tlogger.error(\"" + method.getNote() + "出错!error:" + method.getTofile() + "BO."
				+ method.getName() + "BO\");\n\t\t\tthrow e;\n");
		sb.append("\t\t}\n");
		sb.append("\t\t\treturn ").append(method.getReturnName()).append(";\n");
		sb.append("\t}\n");
		return sb.toString();
	}

	private static String buildIBOMethod(String author, MethodModel method)
	{
		StringBuffer sb = new StringBuffer();
		sb.append(buildWSMethodDescription(method.getNote(), method.getParamName()));
		sb.append("\tpublic " + method.getReturnType() + " " + method.getName() + "BO(" + method.getParamType() + " "
				+ method.getParamName() + ") throws RuntimeException, Exception;\n");
		return sb.toString();
	}

	private static String buildWSFile(String author, FileModel file)
	{
		String WS = "I" + file.getFileName() + "WS";
		String factory = "I" + file.getFileName() + "Factory";
		StringBuffer sb = new StringBuffer();
		sb.append(wsPackage).append("\n\n");
		sb.append(buildWSImport(file.getFileName()));
		sb.append(buildDescription("WS: " + file.getNote()));
		sb.append("public class ").append(file.getFileName()).append("WS extends ").append(wSExtends).append(" ");
		sb.append("implements ").append(WS).append("\n");
		sb.append("{\n");
		sb.append("\tprivate ").append(factory).append(" ").append(getLowPropertyName(factory)).append(";\n\n");
		sb.append("\tpublic void set").append(getLowPropertyName(factory)).append("(").append(factory).append(" ")
				.append(getLowPropertyName(factory)).append(")\n");
		sb.append("\t{\n");
		sb.append("\t\tthis.").append(getLowPropertyName(factory)).append(" = ").append(getLowPropertyName(factory))
				.append(";\n");
		sb.append("\t}\n");
		sb.append("}\n");
		return sb.toString();
	}

	private static String buildIWSFile(String author, FileModel file)
	{
		StringBuffer sb = new StringBuffer();
		sb.append(wsPackage).append("\n\n");
		sb.append(buildIWSImport());
		sb.append(buildDescription("WS�: " + file.getNote()));
		sb.append("public interface ").append("I" + file.getFileName()).append("WS extends ").append(iWSExtends)
				.append("\n");
		sb.append("{\n\n");
		sb.append("}\n");
		return sb.toString();
	}

	private static String buildIFactoryFile(String author, FileModel file)
	{
		StringBuffer sb = new StringBuffer();
		sb.append(factoryPackage).append("\n\n");
		sb.append(buildIFactoryImport());
		sb.append(buildDescription("FACTORY: " + file.getNote()));
		sb.append("public interface ").append("I" + file.getFileName()).append("Factory extends ").append(
				iFactoryExtends).append("\n");
		sb.append("{\n\n");
		sb.append("}\n");
		return sb.toString();
	}

	private static String buildFactoryFile(String author, FileModel file)
	{
		String factory = "I" + file.getFileName() + "Factory";
		String bo = "I" + file.getFileName() + "BO";
		StringBuffer sb = new StringBuffer();
		sb.append(factoryPackage).append("\n\n");
		sb.append(buildFactoryImport(file.getFileName()));
		sb.append(buildDescription("FACTORY: " + file.getNote()));
		sb.append("public class ").append(file.getFileName()).append("Factory extends ").append(factoryExtends).append(
				" ");
		sb.append("implements ").append(factory).append("\n");
		sb.append("{\n\n");
		sb.append("\tprivate ").append(bo).append(" ").append(getLowPropertyName(bo)).append(";\n\n");
		sb.append("\tprivate SccOpLogBO sccOpLogBO;\n\n");
		sb.append("\tpublic void set").append(getLowPropertyName(bo)).append("(").append(bo).append(" ").append(
				getLowPropertyName(bo)).append(")\n");
		sb.append("\t{\n");
		sb.append("\t\tthis.").append(getLowPropertyName(bo)).append(" = ").append(getLowPropertyName(bo))
				.append(";\n");
		sb.append("\t}\n");
		sb.append("\tpublic void set setSccOpLogBO(SccOpLogBO sccOpLogBO)\n");
		sb.append("\t{\n");
		sb.append("\t\tthis.sccOpLogBO = sccOpLogBO;\n");
		sb.append("\t}\n");
		sb.append("}\n");
		return sb.toString();
	}

	private static String buildIBOFile(String author, FileModel file)
	{
		String factory = "I" + file.getFileName() + "Factory";
		StringBuffer sb = new StringBuffer();
		sb.append(boPackage).append("\n\n");
		sb.append(buildIBOImport(file.getFileName()));
		sb.append(buildDescription("BO: " + file.getNote()));
		sb.append("public interface ").append("I" + file.getFileName()).append("BO extends ").append(factory).append(
				"\n");
		sb.append("{\n\n");
		sb.append("}\n");
		return sb.toString();
	}

	private static String buildBOFile(String author, FileModel file)
	{
		String factory = file.getFileName() + "Factory";
		String bo = "I" + file.getFileName() + "BO";
		StringBuffer sb = new StringBuffer();
		sb.append(boPackage).append("\n\n");
		sb.append(buildBOImport(file.getFileName()));
		sb.append(buildDescription("BO: " + file.getNote()));
		sb.append("public class ").append(file.getFileName()).append("BO extends ").append(factory).append(" ");
		sb.append("implements ").append(bo).append("\n");
		sb.append("{\n\n");
		sb.append("}\n");
		return sb.toString();
	}

	private static String buildTestFile(String author, FileModel file)
	{
		String bo = file.getFileName() + "BO";
		StringBuffer sb = new StringBuffer();
		sb.append(testPackage).append("\n\n");
		sb.append(buildTestImport(file.getFileName()));
		sb.append(buildDescription("BO: " + file.getNote()));
		sb.append("public class ").append(file.getFileName()).append("BOTest extends ").append(testExtends)
				.append("\n");
		sb.append("{\n\n");
		sb.append("\tprivate ").append(bo).append(" ").append(getLowPropertyName(bo)).append(";\n\n");
		sb.append("\t@Autowired\n");
		sb.append("\tpublic void set").append(getPropertyName(bo)).append("(").append(getPropertyName(bo)).append(" ")
				.append(getLowPropertyName(bo)).append(")\n");
		sb.append("\t{\n");
		sb.append("\t\tthis.").append(getLowPropertyName(bo)).append(" = ").append(getLowPropertyName(bo))
				.append(";\n");
		sb.append("\t}\n");
		
		sb.append("\t@Before\n");
		sb.append("\tpublic void init()\n");
		sb.append("\t{\n");
		sb.append("\t\tsuper.init();\n");
		sb.append("\t}\n");
		
		sb.append("\t@After\n");
		sb.append("\tpublic void close()\n");
		sb.append("\t{\n");
		sb.append("\t\t").append(getLowPropertyName(bo)).append(" = null;\n");
		sb.append("\t}\n");
		
		sb.append("\t@Test\n");
		sb.append("\tpublic void testAll()\n");
		sb.append("\t{\n");
		sb.append("\t}\n");
		
		sb.append("}\n");
		return sb.toString();
	}

	private static String buildConfigureFile(String type, FileModel file)
	{
		StringBuffer sb = new StringBuffer();
		String property = "i" + file.getFileName();
		if (type.equalsIgnoreCase("WS"))
		{
			sb.append("\t<bean id=\"").append(getLowPropertyName(file.getFileName())).append(
					"WS\" class=\"").append(modularRoot).append(".service.").append(file.getFileName()).append("WS\">\n");
			sb.append("\t\t<property name=\"").append(property).append("Factory").append("\" ref=\"").append(
					getLowPropertyName(file.getFileName())).append("Factory").append("\"></property>\n");
			sb.append("\t</bean>");
		} else if (type.equalsIgnoreCase("FACTORY"))
		{
			sb.append("\t<bean id=\"").append(getLowPropertyName(file.getFileName())).append(
					"Factory\" parent=\"txProxyTemplate\">\n");
			sb.append("\t\t<property name=\"target\">\n");
			sb.append("\t\t\t<bean class=\"").append(modularRoot).append(".factory.").append(getPropertyName(file.getFileName())).append("Factory\">\n");
			sb.append("\t\t\t\t<property name=\"").append(property).append("BO").append("\" ref=\"").append(
					getLowPropertyName(file.getFileName())).append("BO").append("\"></property>\n");
			sb.append("\t\t\t</bean>\n");
			sb.append("\t\t</property>\n");
			sb.append("\t</bean>");
		} else if (type.equalsIgnoreCase("BO"))
		{
			sb.append("\t<bean id=\"").append(getLowPropertyName(file.getFileName())).append(
					"BO\" class=\"").append(modularRoot).append(".bo.").append(file.getFileName()).append("BO\">\n ");
			sb.append("\t</bean>");
		} else if (type.equalsIgnoreCase("DAO"))
		{
			sb.append("\t<bean id=\"").append(getLowPropertyName(file.getFileName())).append(
					"DAO\" class=\"").append(modularRoot).append(".dao.").append(file.getFileName()).append("DAO\">\n");
			sb.append("\t\t<property name=\"sessionFactory\"\n");
			sb.append("\t\t\t<ref bean=\"sessionFactory\" />\n");
			sb.append("\t\t</property>\n");
			sb.append("\t</bean>");
		}
		return sb.toString();
	}
}
