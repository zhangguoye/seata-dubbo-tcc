package com.boxuegu.demo.tcc.service.impl;

import com.boxuegu.demo.tcc.service.BookService;
import com.boxuegu.demo.tcc.service.ReaderService;
import io.seata.core.context.RootContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;

public class ReaderServiceImpl implements ReaderService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BookService.class);

    private JdbcTemplate jdbcTemplate;

    /**
     * Sets jdbc template.
     *
     * @param jdbcTemplate the jdbc template
     */
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void reduceCount(String readerCert, int count) {
        LOGGER.info("读者服务 ... 全局xid: " + RootContext.getXID());
        jdbcTemplate.update("update seata_reader set count = count - ? where reader_cert = ?",
                new Object[] {count, readerCert});
        LOGGER.info("Reader Service End ... ");
    }
}
