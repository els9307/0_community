package com.cm.util;

import org.springframework.stereotype.Service;

@Service("pageAction")
public class pagingAction {
	public String paging(int count,int pageSize, int currentPage,String word) {
		System.out.println("pageAction="+word);
		String file = "javascript:page";
		int pageCount = count/pageSize + (count%pageSize==0?0:1);
		int pageBlock = 3;
		int startPage = ((currentPage-1)/pageBlock)*pageBlock+1;
		int endPage = startPage + pageBlock-1;
		if(endPage>pageCount) endPage = pageCount;
		StringBuffer sb = new StringBuffer();
		//���� Ŭ�������� ����Ŭ������ ó�����ָ� ���ڿ��� �������� ��ȭ���� �� �� ����
		//string ���� Ŭ���� ���� ����ȭ�� ���� �ɸ�
		
		if(count>0) {
			//����
			if(startPage>pageBlock) {
				sb.append("<a class='button disabled' href="+file+"(");
				sb.append((startPage-pageBlock)+","+"'"+word+"'"+")");
				sb.append(">[����]</a>");
				//localhost > pageNum= 1 or 2 & word = '�˻��'
			}
			//������
			for (int i = startPage;i<=endPage;i++) {
				if(i==currentPage) {
					sb.append("["+i+"]");
				}else {
					sb.append("<a href="+file+"(");
					sb.append(i+","+"'"+word+"'"+")");
					sb.append(">["+i+"]</a>");
				}
			}
			//����
			if(endPage<pageCount) {
				sb.append("<a href="+file+"(");
				sb.append((startPage+pageBlock)+","+"'"+word+"'"+")");
				sb.append(">[����]</a>");
			}
		}

		return sb.toString();
	}
}
