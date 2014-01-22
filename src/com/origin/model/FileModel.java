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
public class FileModel
{
	private String fileName;
	private String fileTypes;
	private List<String> daos;
	private String note;
	private List<BusinessModel> contents;

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

	public String getFileTypes()
	{
		return fileTypes;
	}

	public void setFileTypes(String fileTypes)
	{
		this.fileTypes = fileTypes;
	}

	public String getFileName()
	{
		if (this.fileName == null || this.fileName.equals(""))
		{
			return fileName;
		} else
		{
			return Builder.getPropertyName(fileName);
		}
	}

	public void setFileName(String fileName)
	{
		this.fileName = fileName;
	}

	public List<String> getDaos()
	{
		return daos;
	}

	public void setDaos(List<String> daos)
	{
		this.daos = daos;
	}

}
