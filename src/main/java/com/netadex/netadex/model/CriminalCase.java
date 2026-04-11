package com.netadex.netadex.model;

import jakarta.persistence.*;

@Entity
@Table(name = "criminal_case")
public class CriminalCase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "case_id")
    private Long caseId;

    // Many cases → one IPC section
    @ManyToOne
    @JoinColumn(name = "ipc_section", nullable = false)
    private IPCMaster ipcMaster;

    // Required by JPA
    public CriminalCase() {}

    public CriminalCase(IPCMaster ipcMaster) {
        this.ipcMaster = ipcMaster;
    }

    public Long getCaseId() { return caseId; }

    public IPCMaster getIpcMaster() { return ipcMaster; }

    public void setIpcMaster(IPCMaster ipcMaster) {
        this.ipcMaster = ipcMaster;
    }
}