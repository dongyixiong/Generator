package com.origin.main;

import com.origin.action.DTOGenerator;
import com.origin.action.FileGenerator;
import com.origin.action.GenerateInvoker;
import com.origin.action.MethodGenerator;

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
public class GeneratorMain
{
	public static void main(String[] args)
	{
		System.out.println(">>>>>>>>>>>>>>>>>Start<<<<<<<<<<<<<<<<");
		DTOGenerator dtogen = new DTOGenerator();
		FileGenerator filegen = new FileGenerator();
		MethodGenerator methodgen = new MethodGenerator();
		GenerateInvoker.generate(dtogen);
		GenerateInvoker.generate(filegen);
		GenerateInvoker.generate(methodgen);
		System.out.println(">>>>>>>>>>>>>>>>>Success<<<<<<<<<<<<<<<<");
		
	}
}
