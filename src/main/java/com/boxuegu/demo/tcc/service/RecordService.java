package com.boxuegu.demo.tcc.service;

import io.seata.rm.tcc.api.BusinessActionContext;
import io.seata.rm.tcc.api.BusinessActionContextParameter;
import io.seata.rm.tcc.api.TwoPhaseBusinessAction;

public interface RecordService {

    /**
     * 发送一条借阅记录消息
     *
     * @param readerCert 读者证号
     * @param barcode  图书条码号
     */
    @TwoPhaseBusinessAction(name="DubboTccRecord", commitMethod = "commit", rollbackMethod = "rollback")
    void sendRecordMQ(BusinessActionContext actionContext, @BusinessActionContextParameter(paramName = "readerCert") String readerCert,
                      @BusinessActionContextParameter(paramName = "barcode") String barcode);

    /**
     * Commit boolean.
     *
     * @param actionContext the action context
     * @return the boolean
     */
    boolean commit(BusinessActionContext actionContext);

    /**
     * Rollback boolean.
     *
     * @param actionContext the action context
     * @return the boolean
     */
    boolean rollback(BusinessActionContext actionContext);

}
