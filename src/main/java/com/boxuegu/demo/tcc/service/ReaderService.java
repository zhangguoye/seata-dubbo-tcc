package com.boxuegu.demo.tcc.service;

public interface ReaderService {

    /**
     * 减少读者可借阅数
     *
     * @param readerCert 图书条码号
     * @param count  流通状态
     */
    void reduceCount(String readerCert, int count);

}
