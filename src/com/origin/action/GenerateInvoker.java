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
public class GenerateInvoker
{
	public static void generate(AbstractGenerator generator)
	{
		generator.configureFileLoaderPath();
		generator.configure();
		generator.generate();
	}
}
