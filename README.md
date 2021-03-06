echo "# MyTest" >> README.md
git init
git add README.md
git commit -m "first commit"
git remote add origin https://github.com/zhangtejun/MyTest.git
git push -u origin master
############
username=zhangtejun
password=zhtjun1991
############
提示出错信息：fatal: remote origin already exists.
git remote rm origin
#git remote add origin https://github.com/zhangtejun/MyTest.git
############
git?checkout?-b?dev ---->git checkout命令加上-b参数表示创建并切换
用git branch命令查看当前分支：git branch命令会列出所有分支，当前分支前面会标一个*号
dev 下
vim test.tex
git add test.tex
git commit -m "testing"
在，dev分支的工作完成，我们就可以切换回master分支：
git?checkout?master?
切换回master分支后，再查看一个test1.txt（该例未修改而是新建）文件，刚才添加的内容不见了！因为那个提交是在dev分支上，而master分支此刻的提交点并没有变

现在，我们把dev分支的工作成果合并到master分支上：it?merge?dev

合并完成后，就可以放心地删除dev分支了：git?branch?-d?dev??

git push -u origin master  提交到github

3.解决分支合并冲突
准备新的feature1分支 ： git checkout -b feature1 
修改test1.txt最后一行，改为：Creating a new branch is quick AND simple.
在feature1分支上提交并切换到master分支：
在master分支上把test1.txt文件的最后一行改为：Creating a new branch is quick & simple.
这种情况下，Git无法执行“快速合并”，只能试图把各自的修改合并起来，但这种合并就可能会有冲突，我们试试看：

$ git merge feature1
Auto-merging test1.txt
CONFLICT (content): Merge conflict in test1.txt
Automatic <span style="font-size:18px;color:#ff0000;">merge failed</span>; fix conflicts and then commit the result.
果然冲突了！Git告诉我们，test1.txt文件存在冲突，必须手动解决冲突后再提交。git status也可以告诉我们冲突的文件：

$ git status
On branch master
You have unmerged paths.
  (fix conflicts and run "git commit")

Unmerged paths:
  (use "git add <file>..." to mark resolution)

        both modified:   test1.txt
我们可以直接查看test1.txt的内容：

111111
11111111111
Creating a new branch is quick.
<<<<<<< HEAD
Creating a new branch is quick & simple.
=======
Creating a new branch is quick AND simple.
>>>>>>> feature1
Git用<<<<<<<，=======，>>>>>>>标记出不同分支的内容，我们修改如下后保存：
Creating a new branch is quick and simple.
再提交：
Administrator@G3CUWWS80LUWCDG MINGW32 /f/Git/MyGitTest (master|MERGING)
$ git add test1.txt

Administrator@G3CUWWS80LUWCDG MINGW32 /f/Git/MyGitTest (master|MERGING)
$ git commit -m "conflict fixed"
[master 6a36265] conflict fixed
用带参数的git log也可以看到分支的合并情况：
最后，删除feature1分支：git branch -d feature1
做个小结：当Git无法自动合并分支时，就必须首先解决冲突。解决冲突后，再提交，合并完成。用git log --graph命令可以看到分支合并图。

：Git分支十分强大，在团队开发中应该充分应用。合并分支时，加上--no-ff参数就可以用普通模式合并，合并后的历史有分支，能看出来曾经做过合并，而fast forward合并就看不出来曾经做过合并。


5.Bug分支
软件开发中，bug就像家常便饭一样。有了bug就需要修复，在Git中，由于分支是如此的强大，所以，每个bug都可以通过一个新的临时分支来修复，修复后，合并分支，然后将临时分支删除。当你接到一个修复一个代号101的bug的任务时，很自然地，你想创建一个分支issue-101来修复它，但是，等等，当前正在dev上进行的工作还没有提交：
[plain] view plain copy 在CODE上查看代码片派生到我的代码片
$ git status  
On branch dev  
Changes not staged for commit:  
  (use "git add <file>..." to update what will be committed)  
  (use "git checkout -- <file>..." to discard changes in working directory)  
  
        modified:   test1.txt  
  
Untracked files:  
  (use "git add <file>..." to include in what will be committed)  
  
        .ssh/  
        hello.py  
  
no changes added to commit (use "git add" and/or "git commit -a")  
并不是你不想提交，而是工作只进行到一半，还没法提交，预计完成还需1天时间。但是，必须在两个小时内修复该bug，怎么办？
幸好，Git还提供了一个stash功能，可以把当前工作现场“储藏”起来，等以后恢复现场后继续工作：
[plain] view plain copy 在CODE上查看代码片派生到我的代码片
$ git stash  
Saved working directory and index state WIP on dev: 47adae6 add merge  
HEAD is now at 47adae6 add merge  
现在，用git status查看工作区，就是干净的（除非有没有被Git管理的文件），因此可以放心地创建分支来修复bug。
首先确定要在哪个分支上修复bug，假定需要在master分支上修复，就从master创建临时分支：
[plain] view plain copy 在CODE上查看代码片派生到我的代码片
Administrator@G3CUWWS80LUWCDG MINGW32 /f/Git/MyGitTest (dev)  
$ git checkout master  
Switched to branch 'master'  
  
Administrator@G3CUWWS80LUWCDG MINGW32 /f/Git/MyGitTest (master)  
$ git checkout -b issue-101  
Switched to a new branch 'issue-101'  
现在修复bug，需要把“add merge test”改为“add merge tests”，然后提交：
[plain] view plain copy 在CODE上查看代码片派生到我的代码片
Administrator@G3CUWWS80LUWCDG MINGW32 /f/Git/MyGitTest (issue-101)  
$ git add test1.txt  
  
Administrator@G3CUWWS80LUWCDG MINGW32 /f/Git/MyGitTest (issue-101)  
$ git commit -m "fix bug 101"  
On branch issue-101  
Untracked files:  
        .ssh/  
        hello.py  
  
nothing added to commit but untracked files present  
修复完成后，切换到master分支，并完成合并，最后删除issue-101分支：
[plain] view plain copy 在CODE上查看代码片派生到我的代码片
Administrator@G3CUWWS80LUWCDG MINGW32 /f/Git/MyGitTest (issue-101)  
$ git checkout master  
Switched to branch 'master'  
  
Administrator@G3CUWWS80LUWCDG MINGW32 /f/Git/MyGitTest (master)  
$ git merge --no-ff -m "merged bug fix 101" issue-101  
Already up-to-date.  
  
Administrator@G3CUWWS80LUWCDG MINGW32 /f/Git/MyGitTest (master)  
$ git branch -d issue-101  
Deleted branch issue-101 (was 9cb9701).  
太棒了，原计划两个小时的bug修复只花了5分钟！现在，是时候接着回到dev分支干活了！
[plain] view plain copy 在CODE上查看代码片派生到我的代码片
Administrator@G3CUWWS80LUWCDG MINGW32 /f/Git/MyGitTest (dev)  
$ git status  
On branch dev  
Untracked files:  
  (use "git add <file>..." to include in what will be committed)  
  
        .ssh/  
        hello.py  
  
nothing added to commit but untracked files present (use "git add" to track)  
工作区没有需要提交的文件，刚才的工作现场存到哪去了？用git stash list命令看看：
[plain] view plain copy 在CODE上查看代码片派生到我的代码片
Administrator@G3CUWWS80LUWCDG MINGW32 /f/Git/MyGitTest (dev)  
$ git stash list  
stash@{0}: WIP on dev: 47adae6 add merge  
工作现场还在，Git把stash内容存在某个地方了，但是需要恢复一下，有两个办法：
一是用git stash apply恢复，但是恢复后，stash内容并不删除，你需要用git stash drop来删除；另一种方式是用git stash pop，恢复的同时把stash内容也删了：
[plain] view plain copy 在CODE上查看代码片派生到我的代码片
$ git stash pop  
On branch dev  
Changes not staged for commit:  
  (use "git add <file>..." to update what will be committed)  
  (use "git checkout -- <file>..." to discard changes in working directory)  
  
        modified:   test1.txt  
  
Untracked files:  
  (use "git add <file>..." to include in what will be committed)  
  
        .ssh/  
        hello.py  
  
no changes added to commit (use "git add" and/or "git commit -a")  
Dropped refs/stash@{0} (a785fb56c6d495372484129a5f914e4637087a16)  
再用git stash list查看，就看不到任何stash内容了：
[plain] view plain copy 在CODE上查看代码片派生到我的代码片
$ git stash list  
你可以多次stash，恢复的时候，先用git stash list查看，然后恢复指定的stash，用命令：
[plain] view plain copy 在CODE上查看代码片派生到我的代码片
$ git stash apply stash@{0}  
fatal: ambiguous argument 'stash@{0}': unknown revision or path not in the working tree.  
Use '--' to separate paths from revisions, like this:  
'git <command> [<revision>...] -- [<file>...]'  
小结一下：修复bug时，我们会通过创建新的bug分支进行修复，然后合并，最后删除；当手头工作没有完成时，先把工作现场git stash一下，然后去修复bug，修复后，再git stash pop，回到工作现场。
6.Feature分支
软件开发中，总有无穷无尽的新的功能要不断添加进来。
添加一个新功能时，你肯定不希望因为一些实验性质的代码，把主分支搞乱了，所以，每添加一个新功能，最好新建一个feature分支，在上面开发，完成后，合并，最后，删除该feature分支。现在，你终于接到了一个新任务：开发代号为Vulcan的新功能，该功能计划用于下一代星际飞船。于是准备开发：
[plain] view plain copy 在CODE上查看代码片派生到我的代码片
$ git checkout -b feature-vulcan  
Switched to a new branch 'feature-vulcan'  
5分钟后开发完毕，
[plain] view plain copy 在CODE上查看代码片派生到我的代码片
$ git add vulcan.py  
  
Administrator@G3CUWWS80LUWCDG MINGW32 /f/Git/MyGitTest (feature-vulcan)  
$ git status  
On branch feature-vulcan  
Changes to be committed:  
  (use "git reset HEAD <file>..." to unstage)  
  
        new file:   vulcan.py  
  
Changes not staged for commit:  
  (use "git add <file>..." to update what will be committed)  
  (use "git checkout -- <file>..." to discard changes in working directory)  
  
        modified:   test1.txt  
  
Untracked files:  
  (use "git add <file>..." to include in what will be committed)  
  
        .ssh/  
        hello.py  
  
  
Administrator@G3CUWWS80LUWCDG MINGW32 /f/Git/MyGitTest (feature-vulcan)  
$ git commit -m "add feature vulcan"  
[feature-vulcan 2e29e83] add feature vulcan  
 1 file changed, 0 insertions(+), 0 deletions(-)  
 create mode 100644 vulcan.py  
切回dev，准备合并，
[plain] view plain copy 在CODE上查看代码片派生到我的代码片
$ git checkout dev  
Switched to branch 'dev'  
一切顺利的话，feature分支和bug分支是类似的，合并，然后删除。但是，就在此时，接到上级命令，因经费不足，新功能必须取消！虽然白干了，但是这个分支还是必须就地销毁：
[plain] view plain copy 在CODE上查看代码片派生到我的代码片
$ git branch -d feature-vulcan  
error: The branch 'feature-vulcan' is not fully merged.  
If you are sure you want to delete it, run 'git branch -D feature-vulcan'.  
销毁失败。Git友情提醒，feature-vulcan分支还没有被合并，如果删除，将丢失掉修改，如果要强行删除，需要使用命令git branch -D feature-vulcan。现在我们强行删除：
[plain] view plain copy 在CODE上查看代码片派生到我的代码片
$ git branch -D feature-vulcan  
Deleted branch feature-vulcan (was 2e29e83).  
最终删除成功！
小结一下：开发一个新feature，最好新建一个分支；如果要丢弃一个没有被合并过的分支，可以通过git branch -D <name>强行删除。
7.多人协作
当你从远程仓库克隆时，实际上Git自动把本地的master分支和远程的master分支对应起来了，并且，远程仓库的默认名称是origin。要查看远程库的信息，用git remote：
[plain] view plain copy 在CODE上查看代码片派生到我的代码片
$ git remote  
origin  
或者，用git remote -v显示更详细的信息：
[plain] view plain copy 在CODE上查看代码片派生到我的代码片
$ git remote -v  
origin  git@github.com/Kevinfa2016/MyGitTest.git (fetch)  
origin  git@github.com/Kevinfa2016/MyGitTest.git (push)  
上面显示了可以抓取和推送的origin的地址。如果没有推送权限，就看不到push的地址。
7.1推送分支
推送分支，就是把该分支上的所有本地提交推送到远程库。推送时，要指定本地分支，这样，Git就会把该分支推送到远程库对应的远程分支上：
[plain] view plain copy 在CODE上查看代码片派生到我的代码片
$ git push origin master  
如果要推送其他分支，比如dev，就改成：
[plain] view plain copy 在CODE上查看代码片派生到我的代码片
$ git push origin dev  
但是，并不是一定要把本地分支往远程推送，那么，哪些分支需要推送，哪些不需要呢？
? master分支是主分支，因此要时刻与远程同步；
? dev分支是开发分支，团队所有成员都需要在上面工作，所以也需要与远程同步；
? bug分支只用于在本地修复bug，就没必要推到远程了，除非老板要看看你每周到底修复了几个bug；
? feature分支是否推到远程，取决于你是否和你的小伙伴合作在上面开发。
总之，就是在Git中，分支完全可以在本地自己藏着玩，是否推送，视你的心情而定！
7.2抓取分支
多人协作时，大家都会往master和dev分支上推送各自的修改。现在，模拟一个你的小伙伴，可以在另一台电脑（注意要把SSH Key添加到GitHub）或者同一台电脑的另一个目录下克隆：
[plain] view plain copy 在CODE上查看代码片派生到我的代码片
$ git clone git@github.com:Kevinfa2016/MyGitProcessTests.git  
Cloning into 'learngit'...  
remote: Counting objects: 46, done.  
remote: Compressing objects: 100% (26/26), done.  
remote: Total 46 (delta 16), reused 45 (delta 15)  
Receiving objects: 100% (46/46), 15.69 KiB | 6 KiB/s, done.  
Resolving deltas: 100% (16/16), done.  
当你的小伙伴从远程库clone时，默认情况下，你的小伙伴只能看到本地的master分支。不信可以用git branch命令看看：
[plain] view plain copy 在CODE上查看代码片派生到我的代码片
$ git branch  
* master  
现在，你的小伙伴要在dev分支上开发，就必须创建远程origin的dev分支到本地，于是他用这个命令创建本地dev分支：
[plain] view plain copy 在CODE上查看代码片派生到我的代码片
$ git checkout -b dev origin/dev  
现在，他就可以在dev上继续修改，然后，时不时地把dev分支push到远程：
[plain] view plain copy 在CODE上查看代码片派生到我的代码片
$ git commit -m "add /usr/bin/env"  
[dev 291bea8] add /usr/bin/env  
 1 file changed, 1 insertion(+)  
$ git push origin dev  
Counting objects: 5, done.  
Delta compression using up to 4 threads.  
Compressing objects: 100% (2/2), done.  
Writing objects: 100% (3/3), 349 bytes, done.  
Total 3 (delta 0), reused 0 (delta 0)  
To git@github.com:michaelliao/learngit.git  
   fc38031..291bea8  dev -> dev  
你的小伙伴已经向origin/dev分支推送了他的提交，而碰巧你也对同样的文件作了修改，并试图推送：
[plain] view plain copy 在CODE上查看代码片派生到我的代码片
$ git add hello.py   
$ git commit -m "add coding: utf-8"  
[dev bd6ae48] add coding: utf-8  
 1 file changed, 1 insertion(+)  
$ git push origin dev  
To git@github.com:Kevinfa2016/MyGitProcessTests.git  
 ! [rejected]        dev -> dev (non-fast-forward)  
error: failed to push some refs to 'git@github.com:Kevinfa2016/MyGitProcessTests.git'  
hint: Updates were rejected because the tip of your current branch is behind  
hint: its remote counterpart. Merge the remote changes (e.g. 'git pull')  
hint: before pushing again.  
hint: See the 'Note about fast-forwards' in 'git push --help' for details.  
推送失败，因为你的小伙伴的最新提交和你试图推送的提交有冲突，解决办法也很简单，Git已经提示我们，先用git pull把最新的提交从origin/dev抓下来，然后，在本地合并，解决冲突，再推送：
[plain] view plain copy 在CODE上查看代码片派生到我的代码片
$ git pull  
remote: Counting objects: 5, done.  
remote: Compressing objects: 100% (2/2), done.  
remote: Total 3 (delta 0), reused 3 (delta 0)  
Unpacking objects: 100% (3/3), done.  
From github.com:michaelliao/learngit  
   fc38031..291bea8  dev        -> origin/dev  
There is no tracking information for the current branch.  
Please specify which branch you want to merge with.  
See git-pull(1) for details  
  
    git pull <remote> <branch>  
  
If you wish to set tracking information for this branch you can do so with:  
  
    git branch --set-upstream dev origin/<branch>  
git pull也失败了，原因是没有指定本地dev分支与远程origin/dev分支的链接，根据提示，设置dev和origin/dev的链接：
[plain] view plain copy 在CODE上查看代码片派生到我的代码片
$ git branch --set-upstream dev origin/dev  
Branch dev set up to track remote branch dev from origin.  
再pull，
[plain] view plain copy 在CODE上查看代码片派生到我的代码片
$ git pull  
Auto-merging hello.py  
CONFLICT (content): Merge conflict in hello.py  
Automatic merge failed; fix conflicts and then commit the result.  
这回git pull成功，但是合并有冲突，需要手动解决，解决的方法和分支管理中的解决冲突完全一样。解决后，提交，再push：
[plain] view plain copy 在CODE上查看代码片派生到我的代码片
$ git commit -m "merge & fix hello.py"  
[dev adca45d] merge & fix hello.py  
$ git push origin dev  
Counting objects: 10, done.  
Delta compression using up to 4 threads.  
Compressing objects: 100% (5/5), done.  
Writing objects: 100% (6/6), 747 bytes, done.  
Total 6 (delta 0), reused 0 (delta 0)  
To git@github.com:michaelliao/learngit.git  
   291bea8..adca45d  dev -> dev  
因此，多人协作的工作模式通常是这样：
1. 首先，可以试图用git push origin branch-name推送自己的修改；
2. 如果推送失败，则因为远程分支比你的本地更新，需要先用git pull试图合并；
3. 如果合并有冲突，则解决冲突，并在本地提交；
4. 没有冲突或者解决掉冲突后，再用git push origin branch-name推送就能成功！
如果git pull提示“no tracking information”，则说明本地分支和远程分支的链接关系没有创建，用命令git branch --set-upstream branch-name origin/branch-name。这就是多人协作的工作模式，一旦熟悉了，就非常简单。
7.3小结
? 查看远程库信息，使用git remote -v；
? 本地新建的分支如果不推送到远程，对其他人就是不可见的；
? 从本地推送分支，使用git push origin branch-name，如果推送失败，先用git pull抓取远程的新提交；
? 在本地创建和远程分支对应的分支，使用git checkout -b branch-name origin/branch-name，本地和远程分支的名称最好一致；
? 建立本地分支和远程分支的关联，使用git branch --set-upstream branch-name origin/branch-name；
? 从远程抓取分支，使用git pull，如果有冲突，要先处理冲突。
