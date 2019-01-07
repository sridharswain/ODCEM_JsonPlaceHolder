package com.odcem.jsonplaceholderwithjwt.model;

public class LimitModel {
    private Integer llimit;

    private Integer ulimit;

    public LimitModel(int llimit, int ulimit) {
        this.llimit = llimit;
        this.ulimit = ulimit;
    }

    public LimitModel() { }

    public Integer getLlimit() {
        return llimit;
    }

    public void setLlimit(int llimit) {
        this.llimit = llimit;
    }

    public Integer getUlimit() {
        return ulimit;
    }

    public void setUlimit(int ulimit) {
        this.ulimit = ulimit;
    }
}
