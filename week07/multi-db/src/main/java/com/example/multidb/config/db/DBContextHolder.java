package com.example.multidb.config.db;

import com.example.multidb.enums.DBTypeEnum;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Kelvin Chen
 * @date 2021-08-15 17:50:24
 */
@Slf4j
public class DBContextHolder {

    private static final ThreadLocal<DBTypeEnum> contextHolder = new ThreadLocal<>();

    private static final AtomicInteger counter = new AtomicInteger(-1);

    public static void set(DBTypeEnum dbType) {
        contextHolder.set(dbType);
    }

    public static DBTypeEnum get() {
        return contextHolder.get();
    }

    public static void master() {
        set(DBTypeEnum.MASTER);
        log.info("切换到master");
    }

    public static void slave() {
        set(DBTypeEnum.SLAVE);
        log.info("切换到slave");
    }

}
