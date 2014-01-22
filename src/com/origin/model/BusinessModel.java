package com.origin.model;

/**
 * <p>
 * Title:
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * Create Date 2011-11-30 Create By zhengzhenwen
 * 
 * Modify Date 2011-11-30 Modify By zhengzhenwen
 * 
 */
public class BusinessModel
{
	private String fileName;
	private String content;
	private String type;
	private String config;
	private String strImport;

	public String getStrImport()
	{
		return strImport;
	}

	public void setStrImport(String strImport)
	{
		this.strImport = strImport;
	}

	public String getType()
	{
		return type;
	}

	public void setType(String type)
	{
		this.type = type;
	}

	public String getConfig()
	{
		return config;
	}

	public void setConfig(String config)
	{
		this.config = config;
	}

	public String getFileName()
	{
		return fileName;
	}

	public void setFileName(String fileName)
	{
		this.fileName = fileName;
	}

	public String getContent()
	{
		return content;
	}

	public void setContent(String content)
	{
		this.content = content;
	}
}
