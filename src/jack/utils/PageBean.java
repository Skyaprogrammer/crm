package jack.utils;

import java.util.List;

public class PageBean{

	//����Ϊ��ҳ�࣬������ҳ����5������
	//1.��ǰҳ��
	private Integer currentPage;
	//2.��ҳ��
	private Integer totalPage;
	//3.������
	private Integer totalCount;
	//4.һҳ����
	private Integer pageSize;
	
	//5.��ҳ�б�(ͨ���)
	private List	list;

	//ֻ����������ͨ�����ݿ��ѯ֪���ģ������Ķ�����ͨ��ҳ����д���
	public PageBean(Integer currentPage, Integer totalCount, Integer pageSize) {
		
		this.currentPage = currentPage;
		
		this.totalCount = totalCount;
		
		this.pageSize = pageSize;
		//ע��Ե�ǰҳ�����жϣ�
		if(this.currentPage == null) {
			//1�Ǹ���ʼҳ�棬��Ҫ��������
			this.currentPage = 1;
		}
		//����������Ϊ�գ�����Ҳ��Ҫ�����ʼ��¼�������һ������ҳ��Ķ�ֵ
		if(this.pageSize == null) {
			this.pageSize = 3;//Ĭ��һҳ3�� 
		}
		
		//������ҳ��
//		this.totalPage = (int) Math.ceil((this.totalCount)/(this.pageSize));
		//�ڶ���д��     100  10     ��  100+9/100 = 10   ����101+9=110/10=11   9�Ǹ��ٽ�ֵ��һ������������һ���һҳ
		this.totalPage = (this.totalCount+this.pageSize-1)/this.pageSize;
		
		
		//�жϵ�ǰҳ�ķ�Χ������С��1�����ܴ������ҳ��
		if(this.currentPage < 1) {
			this.currentPage = 1;
		}else if(this.currentPage > this.totalPage) {
			this.currentPage = this.totalPage;
		}
	}
	public int getStart() {
		return (this.currentPage-1)*this.pageSize;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	
	
	
	
}
