# Android实用代码段 #  

# 1. 启动应用  
```
public static void startApkActivity(final Context ctx, String packageName) {
	PackageManager pm = ctx.getPackageManager();
	PackageInfo pi;
	try {
		pi = pm.getPackageInfo(packageName, 0);
		Intent intent = new Intent(Intent.ACTION_MAIN, null);
		intent.addCategory(Intent.CATEGORY_LAUNCHER);
		intent.setPackage(pi.packageName);

		List<ResolveInfo> apps = pm.queryIntentActivities(intent, 0);

		ResolveInfo ri = apps.iterator().next();
		if (ri != null) {
			String className = ri.activityInfo.name;
			intent.setComponent(new ComponentName(packageName, className));
			ctx.startActivity(intent);
		}
	} catch (NameNotFoundException e) {
		Log.e("startActivity", e);
	}
}
```
# 2. 
# 3. 
