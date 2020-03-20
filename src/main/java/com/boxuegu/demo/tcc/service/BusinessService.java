package com.boxuegu.demo.tcc.service;

public interface BusinessService {

    /**
     * 读者借阅图书
     *
     * @param readerCert  读者证号
     * @param barcode 图书条码号
     */
    void borrowBook(String readerCert, String barcode);
}
