package com.mhq0123.service.external.config.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * Created by mhq0123 on 2016/12/18.
 *
 * 配置bean，对应配置仓库的访问规则
 */
@RefreshScope // 开启刷新功能
@Component // 容器管理
@ConfigurationProperties(prefix = "system", ignoreUnknownFields = false) // TODO 自动装载配置，prefix要与配置仓库保持一致，字段也要保持一致
public class System {

    /** 名称*/
    private String name;
    /** 版本*/
    private String version;
    /** 时间*/
    private String date;
    /** 开发者*/
    private String developers;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDevelopers() {
        return developers;
    }

    public void setDevelopers(String developers) {
        this.developers = developers;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
