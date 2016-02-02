git push origin localNeu:refs/for/neu


gitdir=$(git rev-parse --git-dir); scp -p -P 29418 liuyl@git.kaolafm.com:hooks/commit-msg .git/hooks/
git commit --amend 
git reset HEAD build.gradle删除add

参考网址:
http://www.bootcss.com/p/git-guide/


git常用命令总结
1.对比
git diff 无需参数

2.切换本地分支
git checkout 分支名

3.暂存stash
保存:
git stash

取:
先获取stash列表;
git stash list
然后取出stash;
git stash pop stash@{0}


4.创建分支
git checkout -b 分支名
相当于
git branch 分支名
git checkout 分支名

5.提交暂存区的所有改动


6.追加,修改之前的提交,会和之前的提交合并
(1)用于修改提交说明;
(2)用于一部分一部分的提交,最后合并到一个整体的提交中;
git commit --amend

和commit -m的不同
这里使用git commit --amend而不使用git commit -m的原因，就是要保持同一个change-id，这样在gerrit的审核界面中，还是同一个review界面，不会产生新的，只是增加了一个新的patch set 2


7.rebase


8.如果2次commit之间,存在没有change id,可利用前一个有change-id的commit-id通过rebase -i commit-id命令重叠,修改pick为f(不修改第一个);
git log 
git rebase -i commit-id


9.忽略.gitignore
git rm --cached 文件名
git rm --cached *.java//忽略所有java文件

*****************************
*  downloaddemo/.gitignore  *
*  downloaddemo/*.png       *
*  downloaddemo/*.xml		*
*  downloaddemo/*.gradle	*
*  downloaddemo/*.pro		*
*  downloaddemo/*.jar		*
*****************************


10.cherry-pick
把另一个本地分支的commit修改应用到当前分支
git cherry-pick <commit id>
(fix conflicts and run "git cherry-pick --continue")
(use "git cherry-pick --abort" to cancel the cherry-pick operation)


11.绑定本地分支和远程分支
git branch --set-upstream-to=origin/<branch> master1210

12.取消已提交到gerrit上的提交后,修改changedId
1.git rebase -i HEAD~3
修改3个提交pick为edit
2.git  git commit --amend
删除原来的change-id:xxxxxxxx
3.git rebase --continue