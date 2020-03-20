package com.boxuegu.demo.tcc.service.impl;

import com.boxuegu.demo.tcc.service.BookService;
import com.boxuegu.demo.tcc.service.BusinessService;
import com.boxuegu.demo.tcc.service.ReaderService;
import com.boxuegu.demo.tcc.service.RecordService;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BusinessServiceImpl implements BusinessService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BusinessService.class);

    private ReaderService readerService;
    private BookService bookService;
    private RecordService recordService;

    @Override
    @GlobalTransactional(timeoutMills = 300000)
    public void borrowBook(String readerCert, String barcode) {
        LOGGER.info("purchase begin ... xid: " + RootContext.getXID());
        readerService.reduceCount(readerCert, 1);
        bookService.updateStatus(barcode, 1);
        recordService.sendRecordMQ(null, readerCert, barcode);
    }

    public void setRecordService(RecordService recordService) {
        this.recordService = recordService;
    }

    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    public void setReaderService(ReaderService readerService) {
        this.readerService = readerService;
    }
}
