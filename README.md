# XFrame
基础框架搭建


# 使用 
1.在根build.gradle添加  
```
allprojects {
		repositories {
			...
			maven { url 'https://www.jitpack.io' }
		}
	}

```

2.添加依赖
```
// 基础框架
implementation 'com.github.stepyen.XFrame:xframe_lib:1.0.2'

// glide 图片实现策略  
implementation 'com.github.stepyen.XFrame:xframe_glide:1.0.2'

```
