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
��ʾ������Ϣ��fatal: remote origin already exists.
git remote rm origin
#git remote add origin https://github.com/zhangtejun/MyTest.git
############
git?checkout?-b?dev ---->git checkout�������-b������ʾ�������л�
��git branch����鿴��ǰ��֧��git branch������г����з�֧����ǰ��֧ǰ����һ��*��
dev ��
vim test.tex
git add test.tex
git commit -m "testing"
�ڣ�dev��֧�Ĺ�����ɣ����ǾͿ����л���master��֧��
git?checkout?master?
�л���master��֧���ٲ鿴һ��test1.txt������δ�޸Ķ����½����ļ����ղ���ӵ����ݲ����ˣ���Ϊ�Ǹ��ύ����dev��֧�ϣ���master��֧�˿̵��ύ�㲢û�б�

���ڣ����ǰ�dev��֧�Ĺ����ɹ��ϲ���master��֧�ϣ�it?merge?dev

�ϲ���ɺ󣬾Ϳ��Է��ĵ�ɾ��dev��֧�ˣ�git?branch?-d?dev??

git push -u origin master  �ύ��github

3.�����֧�ϲ���ͻ
׼���µ�feature1��֧ �� git checkout -b feature1 
�޸�test1.txt���һ�У���Ϊ��Creating a new branch is quick AND simple.
��feature1��֧���ύ���л���master��֧��
��master��֧�ϰ�test1.txt�ļ������һ�и�Ϊ��Creating a new branch is quick & simple.
��������£�Git�޷�ִ�С����ٺϲ�����ֻ����ͼ�Ѹ��Ե��޸ĺϲ������������ֺϲ��Ϳ��ܻ��г�ͻ���������Կ���

$ git merge feature1
Auto-merging test1.txt
CONFLICT (content): Merge conflict in test1.txt
Automatic <span style="font-size:18px;color:#ff0000;">merge failed</span>; fix conflicts and then commit the result.
��Ȼ��ͻ�ˣ�Git�������ǣ�test1.txt�ļ����ڳ�ͻ�������ֶ������ͻ�����ύ��git statusҲ���Ը������ǳ�ͻ���ļ���

$ git status
On branch master
You have unmerged paths.
  (fix conflicts and run "git commit")

Unmerged paths:
  (use "git add <file>..." to mark resolution)

        both modified:   test1.txt
���ǿ���ֱ�Ӳ鿴test1.txt�����ݣ�

111111
11111111111
Creating a new branch is quick.
<<<<<<< HEAD
Creating a new branch is quick & simple.
=======
Creating a new branch is quick AND simple.
>>>>>>> feature1
Git��<<<<<<<��=======��>>>>>>>��ǳ���ͬ��֧�����ݣ������޸����º󱣴棺
Creating a new branch is quick and simple.
���ύ��
Administrator@G3CUWWS80LUWCDG MINGW32 /f/Git/MyGitTest (master|MERGING)
$ git add test1.txt

Administrator@G3CUWWS80LUWCDG MINGW32 /f/Git/MyGitTest (master|MERGING)
$ git commit -m "conflict fixed"
[master 6a36265] conflict fixed
�ô�������git logҲ���Կ�����֧�ĺϲ������
���ɾ��feature1��֧��git branch -d feature1
����С�᣺��Git�޷��Զ��ϲ���֧ʱ���ͱ������Ƚ����ͻ�������ͻ�����ύ���ϲ���ɡ���git log --graph������Կ�����֧�ϲ�ͼ��

��Git��֧ʮ��ǿ�����Ŷӿ�����Ӧ�ó��Ӧ�á��ϲ���֧ʱ������--no-ff�����Ϳ�������ͨģʽ�ϲ����ϲ������ʷ�з�֧���ܿ��������������ϲ�����fast forward�ϲ��Ϳ����������������ϲ���


5.Bug��֧
��������У�bug����ҳ��㷹һ��������bug����Ҫ�޸�����Git�У����ڷ�֧����˵�ǿ�����ԣ�ÿ��bug������ͨ��һ���µ���ʱ��֧���޸����޸��󣬺ϲ���֧��Ȼ����ʱ��֧ɾ��������ӵ�һ���޸�һ������101��bug������ʱ������Ȼ�أ����봴��һ����֧issue-101���޸��������ǣ��ȵȣ���ǰ����dev�Ͻ��еĹ�����û���ύ��
[plain] view plain copy ��CODE�ϲ鿴����Ƭ�������ҵĴ���Ƭ
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
�������㲻���ύ�����ǹ���ֻ���е�һ�룬��û���ύ��Ԥ����ɻ���1��ʱ�䡣���ǣ�����������Сʱ���޸���bug����ô�죿
�Һã�Git���ṩ��һ��stash���ܣ����԰ѵ�ǰ�����ֳ������ء����������Ժ�ָ��ֳ������������
[plain] view plain copy ��CODE�ϲ鿴����Ƭ�������ҵĴ���Ƭ
$ git stash  
Saved working directory and index state WIP on dev: 47adae6 add merge  
HEAD is now at 47adae6 add merge  
���ڣ���git status�鿴�����������Ǹɾ��ģ�������û�б�Git������ļ�������˿��Է��ĵش�����֧���޸�bug��
����ȷ��Ҫ���ĸ���֧���޸�bug���ٶ���Ҫ��master��֧���޸����ʹ�master������ʱ��֧��
[plain] view plain copy ��CODE�ϲ鿴����Ƭ�������ҵĴ���Ƭ
Administrator@G3CUWWS80LUWCDG MINGW32 /f/Git/MyGitTest (dev)  
$ git checkout master  
Switched to branch 'master'  
  
Administrator@G3CUWWS80LUWCDG MINGW32 /f/Git/MyGitTest (master)  
$ git checkout -b issue-101  
Switched to a new branch 'issue-101'  
�����޸�bug����Ҫ�ѡ�add merge test����Ϊ��add merge tests����Ȼ���ύ��
[plain] view plain copy ��CODE�ϲ鿴����Ƭ�������ҵĴ���Ƭ
Administrator@G3CUWWS80LUWCDG MINGW32 /f/Git/MyGitTest (issue-101)  
$ git add test1.txt  
  
Administrator@G3CUWWS80LUWCDG MINGW32 /f/Git/MyGitTest (issue-101)  
$ git commit -m "fix bug 101"  
On branch issue-101  
Untracked files:  
        .ssh/  
        hello.py  
  
nothing added to commit but untracked files present  
�޸���ɺ��л���master��֧������ɺϲ������ɾ��issue-101��֧��
[plain] view plain copy ��CODE�ϲ鿴����Ƭ�������ҵĴ���Ƭ
Administrator@G3CUWWS80LUWCDG MINGW32 /f/Git/MyGitTest (issue-101)  
$ git checkout master  
Switched to branch 'master'  
  
Administrator@G3CUWWS80LUWCDG MINGW32 /f/Git/MyGitTest (master)  
$ git merge --no-ff -m "merged bug fix 101" issue-101  
Already up-to-date.  
  
Administrator@G3CUWWS80LUWCDG MINGW32 /f/Git/MyGitTest (master)  
$ git branch -d issue-101  
Deleted branch issue-101 (was 9cb9701).  
̫���ˣ�ԭ�ƻ�����Сʱ��bug�޸�ֻ����5���ӣ����ڣ���ʱ����Żص�dev��֧�ɻ��ˣ�
[plain] view plain copy ��CODE�ϲ鿴����Ƭ�������ҵĴ���Ƭ
Administrator@G3CUWWS80LUWCDG MINGW32 /f/Git/MyGitTest (dev)  
$ git status  
On branch dev  
Untracked files:  
  (use "git add <file>..." to include in what will be committed)  
  
        .ssh/  
        hello.py  
  
nothing added to commit but untracked files present (use "git add" to track)  
������û����Ҫ�ύ���ļ����ղŵĹ����ֳ��浽��ȥ�ˣ���git stash list�������
[plain] view plain copy ��CODE�ϲ鿴����Ƭ�������ҵĴ���Ƭ
Administrator@G3CUWWS80LUWCDG MINGW32 /f/Git/MyGitTest (dev)  
$ git stash list  
stash@{0}: WIP on dev: 47adae6 add merge  
�����ֳ����ڣ�Git��stash���ݴ���ĳ���ط��ˣ�������Ҫ�ָ�һ�£��������취��
һ����git stash apply�ָ������ǻָ���stash���ݲ���ɾ��������Ҫ��git stash drop��ɾ������һ�ַ�ʽ����git stash pop���ָ���ͬʱ��stash����Ҳɾ�ˣ�
[plain] view plain copy ��CODE�ϲ鿴����Ƭ�������ҵĴ���Ƭ
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
����git stash list�鿴���Ϳ������κ�stash�����ˣ�
[plain] view plain copy ��CODE�ϲ鿴����Ƭ�������ҵĴ���Ƭ
$ git stash list  
����Զ��stash���ָ���ʱ������git stash list�鿴��Ȼ��ָ�ָ����stash�������
[plain] view plain copy ��CODE�ϲ鿴����Ƭ�������ҵĴ���Ƭ
$ git stash apply stash@{0}  
fatal: ambiguous argument 'stash@{0}': unknown revision or path not in the working tree.  
Use '--' to separate paths from revisions, like this:  
'git <command> [<revision>...] -- [<file>...]'  
С��һ�£��޸�bugʱ�����ǻ�ͨ�������µ�bug��֧�����޸���Ȼ��ϲ������ɾ��������ͷ����û�����ʱ���Ȱѹ����ֳ�git stashһ�£�Ȼ��ȥ�޸�bug���޸�����git stash pop���ص������ֳ���
6.Feature��֧
��������У����������޾����µĹ���Ҫ������ӽ�����
���һ���¹���ʱ����϶���ϣ����ΪһЩʵ�����ʵĴ��룬������֧�����ˣ����ԣ�ÿ���һ���¹��ܣ�����½�һ��feature��֧�������濪������ɺ󣬺ϲ������ɾ����feature��֧�����ڣ������ڽӵ���һ�������񣺿�������ΪVulcan���¹��ܣ��ù��ܼƻ�������һ���Ǽʷɴ�������׼��������
[plain] view plain copy ��CODE�ϲ鿴����Ƭ�������ҵĴ���Ƭ
$ git checkout -b feature-vulcan  
Switched to a new branch 'feature-vulcan'  
5���Ӻ󿪷���ϣ�
[plain] view plain copy ��CODE�ϲ鿴����Ƭ�������ҵĴ���Ƭ
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
�л�dev��׼���ϲ���
[plain] view plain copy ��CODE�ϲ鿴����Ƭ�������ҵĴ���Ƭ
$ git checkout dev  
Switched to branch 'dev'  
һ��˳���Ļ���feature��֧��bug��֧�����Ƶģ��ϲ���Ȼ��ɾ�������ǣ����ڴ�ʱ���ӵ��ϼ�����򾭷Ѳ��㣬�¹��ܱ���ȡ������Ȼ�׸��ˣ����������֧���Ǳ���͵����٣�
[plain] view plain copy ��CODE�ϲ鿴����Ƭ�������ҵĴ���Ƭ
$ git branch -d feature-vulcan  
error: The branch 'feature-vulcan' is not fully merged.  
If you are sure you want to delete it, run 'git branch -D feature-vulcan'.  
����ʧ�ܡ�Git�������ѣ�feature-vulcan��֧��û�б��ϲ������ɾ��������ʧ���޸ģ����Ҫǿ��ɾ������Ҫʹ������git branch -D feature-vulcan����������ǿ��ɾ����
[plain] view plain copy ��CODE�ϲ鿴����Ƭ�������ҵĴ���Ƭ
$ git branch -D feature-vulcan  
Deleted branch feature-vulcan (was 2e29e83).  
����ɾ���ɹ���
С��һ�£�����һ����feature������½�һ����֧�����Ҫ����һ��û�б��ϲ����ķ�֧������ͨ��git branch -D <name>ǿ��ɾ����
7.����Э��
�����Զ�ֿ̲��¡ʱ��ʵ����Git�Զ��ѱ��ص�master��֧��Զ�̵�master��֧��Ӧ�����ˣ����ң�Զ�ֿ̲��Ĭ��������origin��Ҫ�鿴Զ�̿����Ϣ����git remote��
[plain] view plain copy ��CODE�ϲ鿴����Ƭ�������ҵĴ���Ƭ
$ git remote  
origin  
���ߣ���git remote -v��ʾ����ϸ����Ϣ��
[plain] view plain copy ��CODE�ϲ鿴����Ƭ�������ҵĴ���Ƭ
$ git remote -v  
origin  git@github.com/Kevinfa2016/MyGitTest.git (fetch)  
origin  git@github.com/Kevinfa2016/MyGitTest.git (push)  
������ʾ�˿���ץȡ�����͵�origin�ĵ�ַ�����û������Ȩ�ޣ��Ϳ�����push�ĵ�ַ��
7.1���ͷ�֧
���ͷ�֧�����ǰѸ÷�֧�ϵ����б����ύ���͵�Զ�̿⡣����ʱ��Ҫָ�����ط�֧��������Git�ͻ�Ѹ÷�֧���͵�Զ�̿��Ӧ��Զ�̷�֧�ϣ�
[plain] view plain copy ��CODE�ϲ鿴����Ƭ�������ҵĴ���Ƭ
$ git push origin master  
���Ҫ����������֧������dev���͸ĳɣ�
[plain] view plain copy ��CODE�ϲ鿴����Ƭ�������ҵĴ���Ƭ
$ git push origin dev  
���ǣ�������һ��Ҫ�ѱ��ط�֧��Զ�����ͣ���ô����Щ��֧��Ҫ���ͣ���Щ����Ҫ�أ�
? master��֧������֧�����Ҫʱ����Զ��ͬ����
? dev��֧�ǿ�����֧���Ŷ����г�Ա����Ҫ�����湤��������Ҳ��Ҫ��Զ��ͬ����
? bug��ֻ֧�����ڱ����޸�bug����û��Ҫ�Ƶ�Զ���ˣ������ϰ�Ҫ������ÿ�ܵ����޸��˼���bug��
? feature��֧�Ƿ��Ƶ�Զ�̣�ȡ�������Ƿ�����С�����������濪����
��֮��������Git�У���֧��ȫ�����ڱ����Լ������棬�Ƿ����ͣ���������������
7.2ץȡ��֧
����Э��ʱ����Ҷ�����master��dev��֧�����͸��Ե��޸ġ����ڣ�ģ��һ�����С��飬��������һ̨���ԣ�ע��Ҫ��SSH Key��ӵ�GitHub������ͬһ̨���Ե���һ��Ŀ¼�¿�¡��
[plain] view plain copy ��CODE�ϲ鿴����Ƭ�������ҵĴ���Ƭ
$ git clone git@github.com:Kevinfa2016/MyGitProcessTests.git  
Cloning into 'learngit'...  
remote: Counting objects: 46, done.  
remote: Compressing objects: 100% (26/26), done.  
remote: Total 46 (delta 16), reused 45 (delta 15)  
Receiving objects: 100% (46/46), 15.69 KiB | 6 KiB/s, done.  
Resolving deltas: 100% (16/16), done.  
�����С����Զ�̿�cloneʱ��Ĭ������£����С���ֻ�ܿ������ص�master��֧�����ſ�����git branch�������
[plain] view plain copy ��CODE�ϲ鿴����Ƭ�������ҵĴ���Ƭ
$ git branch  
* master  
���ڣ����С���Ҫ��dev��֧�Ͽ������ͱ��봴��Զ��origin��dev��֧�����أ���������������������dev��֧��
[plain] view plain copy ��CODE�ϲ鿴����Ƭ�������ҵĴ���Ƭ
$ git checkout -b dev origin/dev  
���ڣ����Ϳ�����dev�ϼ����޸ģ�Ȼ��ʱ��ʱ�ذ�dev��֧push��Զ�̣�
[plain] view plain copy ��CODE�ϲ鿴����Ƭ�������ҵĴ���Ƭ
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
���С����Ѿ���origin/dev��֧�����������ύ����������Ҳ��ͬ�����ļ������޸ģ�����ͼ���ͣ�
[plain] view plain copy ��CODE�ϲ鿴����Ƭ�������ҵĴ���Ƭ
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
����ʧ�ܣ���Ϊ���С���������ύ������ͼ���͵��ύ�г�ͻ������취Ҳ�ܼ򵥣�Git�Ѿ���ʾ���ǣ�����git pull�����µ��ύ��origin/devץ������Ȼ���ڱ��غϲ��������ͻ�������ͣ�
[plain] view plain copy ��CODE�ϲ鿴����Ƭ�������ҵĴ���Ƭ
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
git pullҲʧ���ˣ�ԭ����û��ָ������dev��֧��Զ��origin/dev��֧�����ӣ�������ʾ������dev��origin/dev�����ӣ�
[plain] view plain copy ��CODE�ϲ鿴����Ƭ�������ҵĴ���Ƭ
$ git branch --set-upstream dev origin/dev  
Branch dev set up to track remote branch dev from origin.  
��pull��
[plain] view plain copy ��CODE�ϲ鿴����Ƭ�������ҵĴ���Ƭ
$ git pull  
Auto-merging hello.py  
CONFLICT (content): Merge conflict in hello.py  
Automatic merge failed; fix conflicts and then commit the result.  
���git pull�ɹ������Ǻϲ��г�ͻ����Ҫ�ֶ����������ķ����ͷ�֧�����еĽ����ͻ��ȫһ����������ύ����push��
[plain] view plain copy ��CODE�ϲ鿴����Ƭ�������ҵĴ���Ƭ
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
��ˣ�����Э���Ĺ���ģʽͨ����������
1. ���ȣ�������ͼ��git push origin branch-name�����Լ����޸ģ�
2. �������ʧ�ܣ�����ΪԶ�̷�֧����ı��ظ��£���Ҫ����git pull��ͼ�ϲ���
3. ����ϲ��г�ͻ��������ͻ�����ڱ����ύ��
4. û�г�ͻ���߽������ͻ������git push origin branch-name���;��ܳɹ���
���git pull��ʾ��no tracking information������˵�����ط�֧��Զ�̷�֧�����ӹ�ϵû�д�����������git branch --set-upstream branch-name origin/branch-name������Ƕ���Э���Ĺ���ģʽ��һ����Ϥ�ˣ��ͷǳ��򵥡�
7.3С��
? �鿴Զ�̿���Ϣ��ʹ��git remote -v��
? �����½��ķ�֧��������͵�Զ�̣��������˾��ǲ��ɼ��ģ�
? �ӱ������ͷ�֧��ʹ��git push origin branch-name���������ʧ�ܣ�����git pullץȡԶ�̵����ύ��
? �ڱ��ش�����Զ�̷�֧��Ӧ�ķ�֧��ʹ��git checkout -b branch-name origin/branch-name�����غ�Զ�̷�֧���������һ�£�
? �������ط�֧��Զ�̷�֧�Ĺ�����ʹ��git branch --set-upstream branch-name origin/branch-name��
? ��Զ��ץȡ��֧��ʹ��git pull������г�ͻ��Ҫ�ȴ����ͻ��
