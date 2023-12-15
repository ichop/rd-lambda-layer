package com.rd.project.config.db;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

public class DSConfig  {

    private static SingleConnectionDataSource dataSource = new SingleConnectionDataSource();
    public static DriverManagerDataSource getDataSource() {

        dataSource = DataSourceBuilder
                .create()
                .type(SingleConnectionDataSource.class)
                .url("jdbc:mysql://host.docker.internal:3306/course_project?zeroDateTimeBehavior=convertToNull&useCursorFetch=true&defaultFetchSize=100&serverTimezone=UTC")
                .username("root")
                .password("root")
                .build();


        return dataSource;

    }



}
