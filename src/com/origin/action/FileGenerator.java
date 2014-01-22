package com.origin.action;

import java.util.List;

import com.origin.model.BusinessModel;
import com.origin.model.FileModel;
import com.origin.util.Builder;
import com.origin.util.FileUtil;
import com.origin.util.XmlUtil;

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
public class FileGenerator extends AbstractGenerator
{

	private List<FileModel> files;

	public List<FileModel> getFiles()
	{
		return files;
	}

	public void setFiles(List<FileModel> files)
	{
		this.files = files;
	}

	/*
	 * (non-Javadoc)
	 * @see com.origin.action.AbstractGenerator#configure()
	 */
	@Override
	public void configure()
	{
		files = XmlUtil.transformFile();
	}

	/*
	 * (non-Javadoc)
	 * @see com.origin.action.AbstractGenerator#generate()
	 */
	@Override
	public void generate()
	{
		for (FileModel file : Builder.buildFiles(getFiles()))
		{
			for (BusinessModel business : file.getContents())
			{
				if (business.getFileName() != null)
				{
					FileUtil.writeFile(business.getFileName(), business.getContent());
				}
				if (business.getType() != null && business.getConfig() != null && !business.getConfig().equals(""))
				{
					FileUtil.updateConfigFile(business.getType(), business.getConfig());
				}
			}
		}
	}

}
