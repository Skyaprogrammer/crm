package jack.utils;

import java.util.List;

public class PageBean{

	//该类为分页类，包含分页数据5个参数
	//1.当前页数
	private Integer currentPage;
	//2.总页数
	private Integer totalPage;
	//3.总条数
	private Integer totalCount;
	//4.一页条数
	private Integer pageSize;
	
	//5.分页列表(通配符)
	private List	list;

	//只有总条数是通过数据库查询知道的，其他的都可以通过页面进行传递
	public PageBean(Integer currentPage, Integer totalCount, Integer pageSize) {
		
		this.currentPage = currentPage;
		
		this.totalCount = totalCount;
		
		this.pageSize = pageSize;
		//注意对当前页进行判断，
		if(this.currentPage == null) {
			//1是个起始页面，需要单独定义
			this.currentPage = 1;
		}
		//如果頁面条数为空，我们也需要赋予初始记录，这个是一个我们页面的定值
		if(this.pageSize == null) {
			this.pageSize = 3;//默认一页3条 
		}
		
		//计算总页数
//		this.totalPage = (int) Math.ceil((this.totalCount)/(this.pageSize));
		//第二种写法     100  10     则  100+9/100 = 10   但是101+9=110/10=11   9是个临界值，一旦不整除，加一则多一页
		this.totalPage = (this.totalCount+this.pageSize-1)/this.pageSize;
		
		
		//判断当前页的范围，不能小于1，不能大于最大页数
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
