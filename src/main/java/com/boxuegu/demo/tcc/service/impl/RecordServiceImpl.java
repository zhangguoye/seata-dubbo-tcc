package com.boxuegu.demo.tcc.service.impl;

import com.boxuegu.demo.tcc.service.BookService;
import com.boxuegu.demo.tcc.service.RecordService;
import io.seata.rm.tcc.api.BusinessActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RecordServiceImpl implements RecordService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BookService.class);

    @Override
    public void sendRecordMQ(BusinessActionContext actionContext, String readerCert, String barcode) {
        // 向MQ发送一条消息
        System.out.println("Send MQ Message");
        String xid = actionContext.getXid();
        LOGGER.info(
                "RecordServcice commit, xid:" + xid + ", readerCert:" + actionContext.getActionContext("readerCert") + ", barcode:" + actionContext
                        .getActionContext("barcode"));
        throw new RuntimeException();
    }

    @Override
    public boolean commit(BusinessActionContext actionContext) {
        String xid = actionContext.getXid();
        LOGGER.info(
                "RecordServcice commit, xid:" + xid + ", b:" + actionContext.getActionContext("b") + ", c:" + actionContext
                        .getActionContext("c"));
        return true;
    }

    @Override
    public boolean rollback(BusinessActionContext actionContext) {
        String xid = actionContext.getXid();
        LOGGER.info(
                "RecordServcice rollback, xid:" + xid + ", b:" + actionContext.getActionContext("b") + ", c:" + actionContext
                        .getActionContext("c"));
        // 删除已发送的消息
        System.out.println("Delete  MQ Message");
        return true;
    }
}
