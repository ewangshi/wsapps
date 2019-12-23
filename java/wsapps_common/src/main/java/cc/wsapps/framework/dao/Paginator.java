package  cc.wsapps.framework.dao;

import java.io.Serializable;

/**
 * 分页器
 */
public class Paginator implements Serializable {

    private static final long serialVersionUID = 2018436532193281591L;

    public static final int DEFAULT_ITEMS_PER_PAGE = 10;
    
    /** 当前页数 */
    private int page;
    /** 页大小 */
    private int pageSize = DEFAULT_ITEMS_PER_PAGE;
    
    public Paginator(int currentPage) {
    	this.page = 0 > currentPage ? currentPage : 1;
    }
    
    public Paginator(int currentPage, int pageSize) {
    	this.pageSize = (pageSize > 0 ? pageSize : DEFAULT_ITEMS_PER_PAGE);
    	this.page = currentPage;
    }

    /**
     * 得到总页数
     */
    public int getTotalPages(int items) {
        return (int) Math
                .ceil((double) items / (double) this.pageSize);
    }

    /**
     * 得到当前页
     */
    public int getPage() {
        return this.page;
    }

    /**
     * 得到每页显示记录数
     */
    public int getItemsPerPage() {
        return this.pageSize;
    }

    /**
     * 设置每页显示记录数
     */
    public void setPageSize(int itemsPerPage) {
        this.pageSize = (itemsPerPage > 0 ? itemsPerPage : DEFAULT_ITEMS_PER_PAGE);
    }

    /**
     * 得到分页记录的开始下标
     */
    public int getOffset() {
        return this.page > 0 ? this.pageSize * (this.page - 1) : 0;
    }

}