# ContentProvider笔记 #

# 1. 几个概念 

AUTOHORITY一般为包名;  
```
public static String AUTOHORITY = "com.novelot.download.dao";
```

# 2. getType返回值说明
原形:  
```
public String getType(Uri uri)
```
## (1)vnd.android.cursor.dir:  
如果uri是为了得到集合,则以该字符串开头;  
举例:  
`vnd.android.cursor.dir/note`
## (2)vnd.android.cursor.item:  
如果uri是为了获取单个数据,则以该字符串开头;  
举例:  
`vnd.android.cursor.item/note`


# 3. 几个Uri相关的类
## (1)UriMatcher

用法如下:  
```
private static final UriMatcher mMatcher;

static {
	mMatcher = new UriMatcher(UriMatcher.NO_MATCH);
	mMatcher.addURI(AUTOHORITY, "t_download", 1);
	mMatcher.addURI(AUTOHORITY, "t_download/#", 2);
}  
```

## (2)ContentUris  
```
ContentUris.withAppendedId(uri, id): 为路径加上id部分;
ContentUris.parseId(uri): 从路径中获取id部分;  
```
