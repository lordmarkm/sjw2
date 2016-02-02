package com.sjw.tableau.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity(name = "_workbooks")
public class Workbook {

    @Id
    @GeneratedValue
    private Integer id;
    
    @Column(name = "name")
    private String name;
    @Column(name = "workbook_url")
    private String url;
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "workbook_id")
    private List<View> views;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public List<View> getViews() {
        return views;
    }
    public void setViews(List<View> views) {
        this.views = views;
    }
}
