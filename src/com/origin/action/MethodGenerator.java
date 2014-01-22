package com.origin.action;

import java.util.List;

import com.origin.model.BusinessModel;
import com.origin.model.MethodModel;
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
 * Create Date 2011-11-30 Create By zhengzhenwen
 * 
 * Modify Date 2011-11-30 Modify By zhengzhenwen
 * 
 */
public class MethodGenerator extends AbstractGenerator
{
	private List<MethodModel> methods;

	public List<MethodModel> getMethods()
	{
		return methods;
	}

	public void setMethods(List<MethodModel> methods)
	{
		this.methods = methods;
	}

	/*
	 * (non-Javadoc)
	 * @see com.origin.action.AbstractGenerator#configure()
	 */
	@Override
	public void configure()
	{
		methods = XmlUtil.transformMethod();
	}

	/*
	 * (non-Javadoc)
	 * @see com.origin.action.AbstractGenerator#generate()
	 */
	@Override
	public void generate()
	{
		for (MethodModel method : Builder.buildMethods(methods))
		{
			for (BusinessModel business : method.getContents())
			{
				if (business.getFileName() != null)
				{
					FileUtil.writeMethod(business.getFileName(), business.getContent(), business.getStrImport());
				}
			}
		}
	}

}
