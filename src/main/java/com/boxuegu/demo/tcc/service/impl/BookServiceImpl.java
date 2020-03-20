package com.boxuegu.demo.tcc.service.impl;

import com.boxuegu.demo.tcc.service.BookService;
import io.seata.core.context.RootContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;

public class BookServiceImpl implements BookService {


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
    public void updateStatus(String barcode, int status) {
        LOGGER.info("图书服务 ... 全局xid: " + RootContext.getXID());
        jdbcTemplate.update("update seata_book set status = ? where barcode = ?", new Object[] {status, barcode});
        LOGGER.info("Book Service End ... ");
    }
}
