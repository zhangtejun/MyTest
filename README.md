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

