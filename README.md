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

