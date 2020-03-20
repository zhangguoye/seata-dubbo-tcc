package com.boxuegu.demo.tcc.service;

public interface BookService {

    /**
     * 修改图书状态
     *
     * @param barcode 图书条码号
     * @param status  流通状态
     */
    void updateStatus(String barcode, int status);
}
