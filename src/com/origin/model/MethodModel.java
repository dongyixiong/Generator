package com.origin.model;

import java.util.List;

import com.origin.util.Builder;

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
public class MethodModel
{
	private String tofile;
	private String name;
	private String paramType;
	private String paramName;
	private String returnType;
	private String returnName;
	private String note;
	private List<BusinessModel> contents;
	private String fileTypes;

	public String getFileTypes()
	{
		return fileTypes;
	}

	public void setFileTypes(String fileTypes)
	{
		this.fileTypes = fileTypes;
	}

	public List<BusinessModel> getContents()
	{
		return contents;
	}

	public void setContents(List<BusinessModel> contents)
	{
		this.contents = contents;
	}

	public String getNote()
	{
		return note;
	}

	public void setNote(String note)
	{
		this.note = note;
	}

	public String getTofile()
	{
		if (name != null && !name.equals(""))
		{
			return Builder.getPropertyName(tofile);
		}
		return tofile;
	}

	public void setTofile(String tofile)
	{
		this.tofile = tofile;
	}

	public String getName()
	{
		if (name != null && !name.equals(""))
		{
			return Builder.getLowPropertyName(name);
		}
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getParamType()
	{
		if (paramType != null && !paramType.equals(""))
		{
			return Builder.getPropertyName(paramType);
		}
		return paramType;
	}

	public void setParamType(String paramType)
	{
		this.paramType = paramType;
	}

	public String getParamName()
	{
		return paramName;
	}

	public void setParamName(String paramName)
	{
		this.paramName = paramName;
	}

	public String getReturnType()
	{
		if (returnType != null && !returnType.equals(""))
		{
			return Builder.getPropertyName(returnType);
		}
		return returnType;
	}

	public void setReturnType(String returnType)
	{
		this.returnType = returnType;
	}

	public String getReturnName()
	{
		return returnName;
	}

	public void setReturnName(String returnName)
	{
		this.returnName = returnName;
	}

}
