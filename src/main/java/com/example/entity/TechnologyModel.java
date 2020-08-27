package com.example.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="Techonology")
public class TechnologyModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long tech_id;

    @Column(name="Tech_Name")
    private String tech_name;

    @Column(name="Status")
    private String status;

    private Date createdAt;
    private String createdBy;
    private Date updatedAt;
    private String updatedby;


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public TechnologyModel() {
    }

    public TechnologyModel(String tech_name, String status, Date createdAt, String createdBy, Date updatedAt, String updatedby) {
        this.tech_name = tech_name;
        this.status = status;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.updatedAt = updatedAt;
        this.updatedby = updatedby;
    }

    public Long getTech_id() {
        return tech_id;
    }

    public void setTech_id(Long tech_id) {
        this.tech_id = tech_id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUpdatedby() {
        return updatedby;
    }

    public void setUpdatedby(String updatedby) {
        this.updatedby = updatedby;
    }

    public String getTech_name() {
        return tech_name;
    }

    @Override
    public String toString() {
        return "TechnologyModel{" +
                "tech_id=" + tech_id +
                ", tech_name='" + tech_name + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public void setTech_name(String tech_name) {
        this.tech_name = tech_name;
    }


}

