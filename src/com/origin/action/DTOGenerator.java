package com.origin.action;

import java.util.List;

import com.origin.model.DTOModel;
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
public class DTOGenerator extends AbstractGenerator
{
	private List<DTOModel> dtoList;

	public List<DTOModel> getDtoList()
	{
		return dtoList;
	}

	public void setDtoList(List<DTOModel> dtoList)
	{
		this.dtoList = dtoList;
	}

	/*
	 * (non-Javadoc)
	 * @see com.origin.action.AbstractGenerator#configure()
	 */
	@Override
	public void configure()
	{
		dtoList = XmlUtil.transformDTO();
	}

	/*
	 * (non-Javadoc)
	 * @see com.origin.action.AbstractGenerator#generate()
	 */
	@Override
	public void generate()
	{
		for (DTOModel model : Builder.buildDTOBody(getDtoList()))
		{
			if (model != null)
			{
				FileUtil.writeDTO(model.getName(), model.getContent());
			}
		}

	}

}
