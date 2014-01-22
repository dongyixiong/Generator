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
public class DTOModel
{
	private String name;
	private String note;
	private List<FieldModel> fields;
	private String content;

	public String getContent()
	{
		return content;
	}

	public void setContent(String content)
	{
		this.content = content;
	}

	public String getName()
	{

		if (name != null && !name.equals(""))
		{
			return Builder.getPropertyName(name);
		}
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getNote()
	{
		return note;
	}

	public void setNote(String note)
	{
		this.note = note;
	}

	public List<FieldModel> getFields()
	{
		return fields;
	}

	public void setFields(List<FieldModel> fields)
	{
		this.fields = fields;
	}
}
