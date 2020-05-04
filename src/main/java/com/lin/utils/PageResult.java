package com.lin.utils;

import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 分页的结果类
 */
@Component
public class PageResult {

    /**
     * 分页前查询到的数据总数
     */
    private Long total;
    /**
     * 查询的数据的结果集
     */
    private List<?> result;


    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<?> getResult() {
        return result;
    }

    public void setResult(List<?> result) {
        this.result = result;
    }
}
