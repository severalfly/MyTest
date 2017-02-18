package org.leon;

import java.lang.reflect.Method;

import javax.swing.plaf.basic.BasicScrollPaneUI.HSBChangeListener;

public class JavaClassExecuter
{
	public static String execute(byte[] classByte)
	{
		HackSystem.clearBuffer();
		ClassModifier cm  = new ClassModifier(classByte);
		byte[] modiBytes  = cm.modifyUTF8Constant("java/lang/System", "org.leon.HackSystem");
		HotSwapClassLoader loader = new HotSwapClassLoader();
		Class clazz = loader.loadByte(modiBytes);
		try
		{
			Method method = clazz.getMethod("main", new Class[]{String[].class});
			method.invoke(null, new String[]{null});
		}
		catch (Exception e)
		{
			e.printStackTrace(HackSystem.out);
		}
		return HackSystem.getBufferString();
	}
}
