$ git push auto4.1 tmp96:refs/for/master
Counting objects: 104, done.
Delta compression using up to 4 threads.
Compressing objects: 100% (27/27), done.
Writing objects: 100% (29/29), 4.25 KiB | 0 bytes/s, done.
Total 29 (delta 16), reused 0 (delta 0)
remote: Resolving deltas: 100% (16/16)
remote: Processing changes: refs: 1, done
remote: ERROR: missing Change-Id in commit message footer
remote: Suggestion for commit message:
remote: 添加车载模式界面
remote:
remote: Change-Id: Ia1121ae87ee520542ed62c28e1d50b69581f4a64
remote:
remote: Conflicts:
remote:         Android_KaolaFM/src/main/AndroidManifest.xml
remote:
remote: Change-Id: If26cfabf7c2b717cc5a177404bb9d10e56a5c0b2
remote: Hint: A potential Change-Id was found, but it was not in the footer (last paragraph) of the commit message.
remote:
remote: Hint: To automatically insert Change-Id, install the hook:
remote:   gitdir=$(git rev-parse --git-dir); scp -p -P 29418 liuyl@git.kaolafm.com:hooks/commit-msg ${gitdir}/hooks/
remote:
remote:
To ssh://liuyl@git.kaolafm.com:29418/auto/BaseKaolaFM4.1
 ! [remote rejected] tmp96 -> refs/for/master (missing Change-Id in commit message footer)
error: failed to push some refs to 'ssh://liuyl@git.kaolafm.com:29418/auto/BaseKaolaFM4.1'

========================================================================================================================
git修改历史提交 
2011-06-16 17:58
git使用amend选项提供了最后一次commit的反悔。但是对于历史提交呢，就必须使用rebase了。

git rebase -i HEAD~3

表示要修改当前版本的倒数第三次状态。

这个命令出来之后，会出来三行东东：

pick:*******

pick:*******

pick:*******

如果你要修改哪个，就把那行的pick改成edit，然后退出。

这时通过git log你可以发现，git的最后一次提交已经变成你选的那个了，这时再使用：

git commit-amend

来对commit进行修改。

修改完了之后，要回来对不对？

使用git rebase --continue

OK，一切都搞定了。




git 删除历史提交(git push过的内容)

git reset --hard 哈希值

git push -f (强制更新)


>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
$ git push origin master:refs/for/master
Counting objects: 101, done.
Delta compression using up to 4 threads.
Compressing objects: 100% (20/20), done.
Writing objects: 100% (23/23), 2.26 KiB | 0 bytes/s, done.
Total 23 (delta 17), reused 0 (delta 0)
remote: Resolving deltas: 100% (17/17)
remote: Processing changes: refs: 1, done
remote: ERROR: missing Change-Id in commit message footer
remote: Suggestion for commit message:
remote: 加入重载方法getAllChannels(ChannelType type)
remote:
remote: Change-Id: I823943fdee96c5cc4b6e5ef1e7db879445b950f4
remote:
remote: Hint: To automatically insert Change-Id, install the hook:
remote:   gitdir=$(git rev-parse --git-dir); scp -p -P 29418 liuyl@git.kaolafm.com:hooks/commit-msg ${gitdir}/hooks/
remote:
remote:
To ssh://liuyl@git.kaolafm.com:29418/auto/KaolaPo_yiche
 ! [remote rejected] master -> refs/for/master (missing Change-Id in commit message footer)
error: failed to push some refs to 'ssh://liuyl@git.kaolafm.com:29418/auto/KaolaPo_yiche'

===================================================================================================
如果2次commit之间,存在没有change id,可利用前一个有change-id的commit-id通过rebase -i commit-id命令重叠,修改pick为f(不修改第一个);
git log 
git rebase -i commit-id

注意:是commit-id不是change-id

>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

$ git rebase -i Ia57270f71d72a7516a8f9d6fefb2d364199ad5e6
fatal: Needed a single revision
invalid upstream Ia57270f71d72a7516a8f9d6fefb2d364199ad5e6

===================================================================================================
未解决

>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
V@V-PC /E/workspace/ClientAPI (master)
$ git push origin master:refs/for/master
Counting objects: 1, done.
Writing objects: 100% (1/1), 255 bytes | 0 bytes/s, done.
Total 1 (delta 0), reused 0 (delta 0)
error: unpack failed: error Missing tree ad6e2bf901e97cdd851775128962c83fd988bc09
fatal: Unpack error, check server log
To ssh://liuyl@git.kaolafm.com:29418/auto/clientapi
 ! [remote rejected] master -> refs/for/master (n/a (unpacker error))
error: failed to push some refs to 'ssh://liuyl@git.kaolafm.com:29418/auto/clientapi'
===================================================================================================

V@V-PC /E/workspace/ClientAPI (master)
$ git push --no-thin origin HEAD:refs/for/master
Counting objects: 11, done.
Delta compression using up to 4 threads.
Compressing objects: 100% (7/7), done.
Writing objects: 100% (11/11), 3.87 KiB | 0 bytes/s, done.
Total 11 (delta 0), reused 0 (delta 0)
remote: Processing changes: updated: 1, refs: 1, done
remote: (W) ec2c4a7: no files changed, message updated
remote:
remote: Updated Changes:
remote:   http://git.kaolafm.com/9468
remote:
To ssh://liuyl@git.kaolafm.com:29418/auto/clientapi
 * [new branch]      HEAD -> refs/for/master
>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
V@V-PC /e/workspace/edog (b_search)
$ git push origin b_search:refs/for/master
Counting objects: 113, done.
Delta compression using up to 4 threads.
Compressing objects: 100% (38/38), done.
Writing objects: 100% (43/43), 21.20 KiB | 0 bytes/s, done.
Total 43 (delta 28), reused 0 (delta 0)
remote: Resolving deltas: 100% (28/28)
remote: Processing changes: refs: 1, done
To ssh://liuyl@git.kaolafm.com:29418/edog_car
 ! [remote rejected] b_search -> refs/for/master (change 9404 closed)
error: failed to push some refs to 'ssh://liuyl@git.kaolafm.com:29418/edog_car'
===================================================================================================
1.git rebase -i HEAD~3
修改3个提交pick为edit
2.git  git commit --amend
删除原来的change-id:xxxxxxxx
3.git rebase --continue

>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>