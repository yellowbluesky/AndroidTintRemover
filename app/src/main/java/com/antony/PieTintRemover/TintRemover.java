package com.antony.PieTintRemover;

import java.lang.reflect.Field;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;

import static de.robv.android.xposed.XposedHelpers.findAndHookMethod;

public class TintRemover implements IXposedHookLoadPackage
{
	private void hijack(ClassLoader classLoader, final String className, String methodName, final String varName, final Object value)
	{
		findAndHookMethod(className, classLoader, methodName, new XC_MethodHook()
		{

			@Override
			protected void beforeHookedMethod(MethodHookParam param) throws Throwable
			{
				Object obj = param.thisObject;
				Field field = obj.getClass().getDeclaredField(varName);
				field.setAccessible(true);
				field.set(obj, value);
			}
		});
	}

	private void hijackAll(ClassLoader classLoader, String className)
	{
		hijack(classLoader, className, "getMainColor", "mMainColor", 0x0a000000);
		hijack(classLoader, className, "getSecondaryColor", "mSecondaryColor", 0x0a000000);
		hijack(classLoader, className, "supportsDarkText", "mSupportsDarkText", false);
	}

	@Override
	public void handleLoadPackage(LoadPackageParam lpparam)
	{
		XposedBridge.log("Loaded app: " + lpparam.packageName);
		if (!lpparam.packageName.equals("com.android.systemui"))
			return;
		XposedBridge.log("Caught systemui!");
		hijackAll(lpparam.classLoader, "com.android.internal.colorextraction.ColorExtractor$GradientColors");
		XposedBridge.log("Hooks injected.");
	}
}
