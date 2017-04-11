Git笔记
=

### 1. 比较  
```
git diff b1 b2  比较2个分支的区别  
git diff HEAD~ HEAD  比较上次提交和上上次提交的区别  
git diff  比较尚未暂存的文件更新了哪些部分  
git diff --cached  查看已经暂存的文件和上次提交的快照的差异  
git diff --staged  
```  
### 2. 命令行显示log
```
git log --graph --decorate --all
```

### 3. 补丁

```
git format-patch HEAD~4 //从最前第1到第4个
git format-patch -4     //同上
git format-patch -1 -4  //从最前第1到第4个
会生成.patch文件

应用补丁
git apply /e/祥宁交接/aispeech/0001-for-aispeech-just-test.patch

```

### 4. 不能提交
**问题:**
```
$ git push origin master:refs/for/master
To 192.168.4.209:Android_KaolaFM/Android_KaolaFM_Auto.git
 ! [rejected]        master -> refs/for/master (fetch first)
error: failed to push some refs to 'git@192.168.4.209:Android_KaolaFM/Android_KaolaFM_Auto.git'
hint: Updates were rejected because the remote contains work that you do
hint: not have locally. This is usually caused by another repository pushing
hint: to the same ref. You may want to first integrate the remote changes
hint: (e.g., 'git pull ...') before pushing again.
hint: See the 'Note about fast-forwards' in 'git push --help' for details.
```
**解决:**  
`git push origin origin/master:refs/for/origin/master
`




