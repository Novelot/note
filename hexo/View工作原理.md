View工作原理
=
# I. 设备如何获取触摸事件
基于Linux的
# II. 触摸事件拦截和分发
onInterceptTouchEvent
onTouchEvent

# III. View的测量，布局，绘制方法
## * LayoutParams

```
ViewGroup.LayoutParams(width,height)
		|--ViewGroup.MarginLayoutParams(leftMargin,topMargin,rightMargin,bottomMargin)
			|--FrameLayout.LayoutParams(gravity)
			|--LinearLayout.LayoutParams(weight,gravity)
			|--RelativeLayout.LayoutParams(alignWithParent,rules[LEFT_OF],rules[RIGHT_OF],rules[ABOVE],rules[BELOW],rules[ALIGN_BASELINE],rules[ALIGN_LEFT],rules[ALIGN_TOP],rules[ALIGN_RIGHT],rules[ALIGN_BOTTOM],rules[ALIGN_PARENT_LEFT],rules[ALIGN_PARENT_TOP],rules[ALIGN_PARENT_RIGHT],rules[ALIGN_PARENT_BOTTO],rules[CENTER_IN_PARENT],rules[CENTER_HORIZONTAL],rules[CENTER_VERTICAL],rules[START_OF],rules[END_OF],rules[ALIGN_START],rules[ALIGN_END],rules[ALIGN_PARENT_START],rules[ALIGN_PARENT_END])
			|--GridLayout.LayoutParams(rowSpec,columnSpec)
			
```