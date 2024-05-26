package com.internal.bms.hr.hrportal.entity;

import java.time.LocalDateTime;
import java.util.logging.Logger;

import javax.validation.constraints.Size;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "jobopening")
public class JobOpening {
	
    private static final Logger logger = Logger.getLogger(JobOpening.class.getName());
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "openingid")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "packageid", nullable = false)
    @NotNull(message = "PackageId is required")
    private JobPackage jobPackage;

    @Column(name = "postingdate", nullable = false)
    private LocalDateTime postingDate = LocalDateTime.now();

    @Column(name = "closingdate")
    private LocalDateTime closingDate;

    @Column(name = "customtitle")
    @Size(max = 255, message = "CustomTitle cannot exceed 255 characters")
    private String customTitle;

    @Column(name = "customdescription")
    private String customDescription;

    @Column(name = "customsalary")
    private String customSalary;

    @Column(name = "custombenefits")
    private String customBenefits;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public JobPackage getJobPackage() {
        return jobPackage;
    }

    public void setJobPackage(JobPackage jobPackage) {
    	System.out.println("package set..............");
        this.jobPackage = jobPackage;
    	System.out.println("package set done..............");

    }

    public LocalDateTime getPostingDate() {
        return postingDate;
    }

    public void setPostingDate(LocalDateTime postingDate) {
        this.postingDate = postingDate;
    }

    public LocalDateTime getClosingDate() {
        return closingDate;
    }

    public void setClosingDate(LocalDateTime closingDate) {
        this.closingDate = closingDate;
    }

    public String getCustomTitle() {
        return customTitle;
    }

    public void setCustomTitle(String customTitle) {
System.out.println("title set..............");
        this.customTitle = customTitle;
        System.out.println("title set..done............");

    }

    public String getCustomDescription() {
        return customDescription;
    }

    public void setCustomDescription(String customDescription) {
        this.customDescription = customDescription;
    }

    public String getCustomSalary() {
        return customSalary;
    }

    public void setCustomSalary(String customSalary) {
        this.customSalary = customSalary;
    }

    public String getCustomBenefits() {
        return customBenefits;
    }

    public void setCustomBenefits(String customBenefits) {
        this.customBenefits = customBenefits;
    }
}
