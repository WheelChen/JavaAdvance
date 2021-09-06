package com.example.multidb.config.db;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author Kelvin Chen
 * @date 2021-08-15 17:57:55
 */
public class CustomRoutingDataSource extends AbstractRoutingDataSource {
    /**
     * Determine the current lookup key. This will typically be
     * implemented to check a thread-bound transaction context.
     * <p>Allows for arbitrary keys. The returned key needs
     * to match the stored lookup key type, as resolved by the
     * {@link #resolveSpecifiedLookupKey} method.
     */
    @Override
    protected Object determineCurrentLookupKey() {
        return DBContextHolder.get();
    }
}
