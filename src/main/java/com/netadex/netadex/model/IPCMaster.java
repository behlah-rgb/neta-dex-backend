package com.netadex.netadex.model;

import jakarta.persistence.*;

@Entity
@Table(name = "ipc_master")
public class IPCMaster {

    @Id
    @Column(name = "ipc_section")
    private String ipcSection;

    private String details;

    @Column(name = "severity_weight")
    private int severityWeight;

    // Required by JPA
    public IPCMaster() {}

    public IPCMaster(String ipcSection, String details, int severityWeight) {
        this.ipcSection = ipcSection;
        this.details = details;
        this.severityWeight = severityWeight;
    }

    public String getIpcSection() { return ipcSection; }

    public String getDetails() { return details; }

    public void setDetails(String details) { this.details = details; }

    public int getSeverityWeight() { return severityWeight; }

    public void setSeverityWeight(int severityWeight) {
        this.severityWeight = severityWeight;
    }
}