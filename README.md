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