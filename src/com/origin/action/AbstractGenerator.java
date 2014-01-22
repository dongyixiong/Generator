package com.origin.action;

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
public abstract class AbstractGenerator
{
	private String file_load_path;
	private String xml_file;
	private String xml_method;
	private String xml_dto;
	private String author;
	private String project_path;
	private String modularRoot;
	private String springName;

	public String getSpringName()
	{
		return springName;
	}

	public void setSpringName(String springName)
	{
		this.springName = springName;
	}

	public String getModularRoot()
	{
		return modularRoot;
	}

	public void setModularRoot(String modularRoot)
	{
		this.modularRoot = modularRoot;
	}

	public String getAuthor()
	{
		return author;
	}

	public void setAuthor(String author)
	{
		this.author = author;
	}

	public String getProject_path()
	{
		return project_path;
	}

	public void setProject_path(String projectPath)
	{
		project_path = projectPath;
	}

	public String getFile_load_path()
	{
		return file_load_path;
	}

	public void setFile_load_path(String fileLoadPath)
	{
		file_load_path = fileLoadPath;
	}

	public String getXml_file()
	{
		return xml_file;
	}

	public void setXml_file(String xmlFile)
	{
		xml_file = xmlFile;
	}

	public String getXml_method()
	{
		return xml_method;
	}

	public void setXml_method(String xmlMethod)
	{
		xml_method = xmlMethod;
	}

	public String getXml_dto()
	{
		return xml_dto;
	}

	public void setXml_dto(String xmlDto)
	{
		xml_dto = xmlDto;
	}

	public abstract void generate();

	public abstract void configure();

	public void configureFileLoaderPath()
	{
	}
}
