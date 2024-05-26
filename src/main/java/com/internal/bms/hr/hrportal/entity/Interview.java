package com.internal.bms.hr.hrportal.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Interview")
public class Interview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "interviewid")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "applicationid", nullable = false)
    private Application application;

    @ManyToOne
    @JoinColumn(name = "interviewerid", nullable = false)
    private Interviewer interviewer;

    @Column(name = "interviewdate", nullable = false)
    private LocalDateTime interviewDate;

    @Column(name = "feedback")
    private String feedback;

    @Column(name = "interviewround", nullable = false)
    private int interviewRound;

    @ManyToOne
    @JoinColumn(name = "statusid", nullable = false)
    private ApplicationStatus applicationStatus;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }

    public Interviewer getInterviewer() {
        return interviewer;
    }

    public void setInterviewer(Interviewer interviewer) {
        this.interviewer = interviewer;
    }

    public LocalDateTime getInterviewDate() {
        return interviewDate;
    }

    public void setInterviewDate(LocalDateTime interviewDate) {
        this.interviewDate = interviewDate;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public int getInterviewRound() {
        return interviewRound;
    }

    public void setInterviewRound(int interviewRound) {
        this.interviewRound = interviewRound;
    }

    public ApplicationStatus getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(ApplicationStatus applicationStatus) {
        this.applicationStatus = applicationStatus;
    }
}
