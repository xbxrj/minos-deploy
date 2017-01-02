package xbp.core.base;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.github.pagehelper.Page;

import xbp.core.util.data.Maps;

/**
 * @Description: 基础页面分页基类
 * @author zhangjs
 * @date 2016年11月9日 下午4:20:14
 */
public class BasePageInfo<T> implements Serializable {

	private static final long serialVersionUID = -4066692514374768755L;

    private Page<T> pageList;

    public BasePageInfo(Map<String, Object> map) {
        if (map != null) {
            int pageNum = Maps.getInt(map, "page", 1);
            int rows = Maps.getInt(map, "rows", 25);
            pageList = new Page<>(pageNum, rows);
        } else {
            pageList = new Page<>();
        }
    }

    public int getPage() {
        int pageNum = pageList.getPageNum();
        if (pageNum <= 0) {
            pageNum = 1;
            pageList.setPageNum(pageNum);
        }
        return pageNum;
    }

    public void setPage(int page) {
        pageList.setPageNum(page);
    }

    public int getRows() {
        int rows = pageList.getPageSize();
        if (rows <= 0) {
            rows = 25;
            pageList.setPageSize(rows);
        }
        return rows;
    }

    public void setRows(int rows) {
        pageList.setPageSize(rows);
    }

    public String getOrder() {
        return pageList.getOrderBy();
    }

    public void setOrder(String order) {
        pageList.setOrderBy(order);
    }

    public long getTotal() {
        return pageList.getTotal();
    }

    public void setTotal(long total) {
        pageList.setTotal(total);
    }

    public void setList(List<T> list) {
        pageList.clear();
        pageList.addAll(list);
        if (list instanceof Page) {
            Page<T> inPage = (Page<T>) list;
            pageList.setTotal(inPage.getTotal());
        }
    }

    public List<T> getList() {
        return pageList;
    }

    public int getSartRow() {
        return pageList.getStartRow();
    }

    public int getEndRow() {
        return pageList.getEndRow();
    }
}
