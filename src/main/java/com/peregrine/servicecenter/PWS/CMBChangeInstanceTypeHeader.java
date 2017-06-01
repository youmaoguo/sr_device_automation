/**
 * CMBChangeInstanceTypeHeader.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peregrine.servicecenter.PWS;

public class CMBChangeInstanceTypeHeader  extends com.peregrine.servicecenter.PWS.Common.StructureType  implements java.io.Serializable {
    private com.peregrine.servicecenter.PWS.Common.StringType changeNumber;

    private com.peregrine.servicecenter.PWS.Common.StringType category;

    private com.peregrine.servicecenter.PWS.Common.StringType status;

    private com.peregrine.servicecenter.PWS.Common.StringType approvalStatus;

    private com.peregrine.servicecenter.PWS.Common.StringType requestedBy;

    private com.peregrine.servicecenter.PWS.Common.StringType assignedTo;

    private com.peregrine.servicecenter.PWS.Common.StringType assignmentGroup;

    private com.peregrine.servicecenter.PWS.Common.StringType coordinator;

    private com.peregrine.servicecenter.PWS.Common.StringType coordinatorPhone;

    private com.peregrine.servicecenter.PWS.Common.DateTimeType plannedStartDate;

    private com.peregrine.servicecenter.PWS.Common.DateTimeType plannedEndDate;

    private com.peregrine.servicecenter.PWS.Common.StringType reason;

    private com.peregrine.servicecenter.PWS.Common.StringType currentPhase;

    private com.peregrine.servicecenter.PWS.Common.StringType riskAssessment;

    private com.peregrine.servicecenter.PWS.Common.StringType priority;

    private com.peregrine.servicecenter.PWS.Common.DateTimeType dateEntered;

    private com.peregrine.servicecenter.PWS.Common.BooleanType open;

    private com.peregrine.servicecenter.PWS.Common.DurationType backoutDuration;

    private com.peregrine.servicecenter.PWS.Common.DateTimeType closeTime;

    private com.peregrine.servicecenter.PWS.Common.StringType foreignID;

    private com.peregrine.servicecenter.PWS.Common.StringType RFCType2;

    private com.peregrine.servicecenter.PWS.Common.StringType company;

    private com.peregrine.servicecenter.PWS.Common.StringType briefDescription;

    private com.peregrine.servicecenter.PWS.Common.StringType subcategory;

    private com.peregrine.servicecenter.PWS.Common.IntType SLAAgreementID;

    public CMBChangeInstanceTypeHeader() {
    }

    public CMBChangeInstanceTypeHeader(
           java.lang.String type,
           com.peregrine.servicecenter.PWS.Common.StringType changeNumber,
           com.peregrine.servicecenter.PWS.Common.StringType category,
           com.peregrine.servicecenter.PWS.Common.StringType status,
           com.peregrine.servicecenter.PWS.Common.StringType approvalStatus,
           com.peregrine.servicecenter.PWS.Common.StringType requestedBy,
           com.peregrine.servicecenter.PWS.Common.StringType assignedTo,
           com.peregrine.servicecenter.PWS.Common.StringType assignmentGroup,
           com.peregrine.servicecenter.PWS.Common.StringType coordinator,
           com.peregrine.servicecenter.PWS.Common.StringType coordinatorPhone,
           com.peregrine.servicecenter.PWS.Common.DateTimeType plannedStartDate,
           com.peregrine.servicecenter.PWS.Common.DateTimeType plannedEndDate,
           com.peregrine.servicecenter.PWS.Common.StringType reason,
           com.peregrine.servicecenter.PWS.Common.StringType currentPhase,
           com.peregrine.servicecenter.PWS.Common.StringType riskAssessment,
           com.peregrine.servicecenter.PWS.Common.StringType priority,
           com.peregrine.servicecenter.PWS.Common.DateTimeType dateEntered,
           com.peregrine.servicecenter.PWS.Common.BooleanType open,
           com.peregrine.servicecenter.PWS.Common.DurationType backoutDuration,
           com.peregrine.servicecenter.PWS.Common.DateTimeType closeTime,
           com.peregrine.servicecenter.PWS.Common.StringType foreignID,
           com.peregrine.servicecenter.PWS.Common.StringType RFCType2,
           com.peregrine.servicecenter.PWS.Common.StringType company,
           com.peregrine.servicecenter.PWS.Common.StringType briefDescription,
           com.peregrine.servicecenter.PWS.Common.StringType subcategory,
           com.peregrine.servicecenter.PWS.Common.IntType SLAAgreementID) {
        super(
            type);
        this.changeNumber = changeNumber;
        this.category = category;
        this.status = status;
        this.approvalStatus = approvalStatus;
        this.requestedBy = requestedBy;
        this.assignedTo = assignedTo;
        this.assignmentGroup = assignmentGroup;
        this.coordinator = coordinator;
        this.coordinatorPhone = coordinatorPhone;
        this.plannedStartDate = plannedStartDate;
        this.plannedEndDate = plannedEndDate;
        this.reason = reason;
        this.currentPhase = currentPhase;
        this.riskAssessment = riskAssessment;
        this.priority = priority;
        this.dateEntered = dateEntered;
        this.open = open;
        this.backoutDuration = backoutDuration;
        this.closeTime = closeTime;
        this.foreignID = foreignID;
        this.RFCType2 = RFCType2;
        this.company = company;
        this.briefDescription = briefDescription;
        this.subcategory = subcategory;
        this.SLAAgreementID = SLAAgreementID;
    }


    /**
     * Gets the changeNumber value for this CMBChangeInstanceTypeHeader.
     * 
     * @return changeNumber
     */
    public com.peregrine.servicecenter.PWS.Common.StringType getChangeNumber() {
        return changeNumber;
    }


    /**
     * Sets the changeNumber value for this CMBChangeInstanceTypeHeader.
     * 
     * @param changeNumber
     */
    public void setChangeNumber(com.peregrine.servicecenter.PWS.Common.StringType changeNumber) {
        this.changeNumber = changeNumber;
    }


    /**
     * Gets the category value for this CMBChangeInstanceTypeHeader.
     * 
     * @return category
     */
    public com.peregrine.servicecenter.PWS.Common.StringType getCategory() {
        return category;
    }


    /**
     * Sets the category value for this CMBChangeInstanceTypeHeader.
     * 
     * @param category
     */
    public void setCategory(com.peregrine.servicecenter.PWS.Common.StringType category) {
        this.category = category;
    }


    /**
     * Gets the status value for this CMBChangeInstanceTypeHeader.
     * 
     * @return status
     */
    public com.peregrine.servicecenter.PWS.Common.StringType getStatus() {
        return status;
    }


    /**
     * Sets the status value for this CMBChangeInstanceTypeHeader.
     * 
     * @param status
     */
    public void setStatus(com.peregrine.servicecenter.PWS.Common.StringType status) {
        this.status = status;
    }


    /**
     * Gets the approvalStatus value for this CMBChangeInstanceTypeHeader.
     * 
     * @return approvalStatus
     */
    public com.peregrine.servicecenter.PWS.Common.StringType getApprovalStatus() {
        return approvalStatus;
    }


    /**
     * Sets the approvalStatus value for this CMBChangeInstanceTypeHeader.
     * 
     * @param approvalStatus
     */
    public void setApprovalStatus(com.peregrine.servicecenter.PWS.Common.StringType approvalStatus) {
        this.approvalStatus = approvalStatus;
    }


    /**
     * Gets the requestedBy value for this CMBChangeInstanceTypeHeader.
     * 
     * @return requestedBy
     */
    public com.peregrine.servicecenter.PWS.Common.StringType getRequestedBy() {
        return requestedBy;
    }


    /**
     * Sets the requestedBy value for this CMBChangeInstanceTypeHeader.
     * 
     * @param requestedBy
     */
    public void setRequestedBy(com.peregrine.servicecenter.PWS.Common.StringType requestedBy) {
        this.requestedBy = requestedBy;
    }


    /**
     * Gets the assignedTo value for this CMBChangeInstanceTypeHeader.
     * 
     * @return assignedTo
     */
    public com.peregrine.servicecenter.PWS.Common.StringType getAssignedTo() {
        return assignedTo;
    }


    /**
     * Sets the assignedTo value for this CMBChangeInstanceTypeHeader.
     * 
     * @param assignedTo
     */
    public void setAssignedTo(com.peregrine.servicecenter.PWS.Common.StringType assignedTo) {
        this.assignedTo = assignedTo;
    }


    /**
     * Gets the assignmentGroup value for this CMBChangeInstanceTypeHeader.
     * 
     * @return assignmentGroup
     */
    public com.peregrine.servicecenter.PWS.Common.StringType getAssignmentGroup() {
        return assignmentGroup;
    }


    /**
     * Sets the assignmentGroup value for this CMBChangeInstanceTypeHeader.
     * 
     * @param assignmentGroup
     */
    public void setAssignmentGroup(com.peregrine.servicecenter.PWS.Common.StringType assignmentGroup) {
        this.assignmentGroup = assignmentGroup;
    }


    /**
     * Gets the coordinator value for this CMBChangeInstanceTypeHeader.
     * 
     * @return coordinator
     */
    public com.peregrine.servicecenter.PWS.Common.StringType getCoordinator() {
        return coordinator;
    }


    /**
     * Sets the coordinator value for this CMBChangeInstanceTypeHeader.
     * 
     * @param coordinator
     */
    public void setCoordinator(com.peregrine.servicecenter.PWS.Common.StringType coordinator) {
        this.coordinator = coordinator;
    }


    /**
     * Gets the coordinatorPhone value for this CMBChangeInstanceTypeHeader.
     * 
     * @return coordinatorPhone
     */
    public com.peregrine.servicecenter.PWS.Common.StringType getCoordinatorPhone() {
        return coordinatorPhone;
    }


    /**
     * Sets the coordinatorPhone value for this CMBChangeInstanceTypeHeader.
     * 
     * @param coordinatorPhone
     */
    public void setCoordinatorPhone(com.peregrine.servicecenter.PWS.Common.StringType coordinatorPhone) {
        this.coordinatorPhone = coordinatorPhone;
    }


    /**
     * Gets the plannedStartDate value for this CMBChangeInstanceTypeHeader.
     * 
     * @return plannedStartDate
     */
    public com.peregrine.servicecenter.PWS.Common.DateTimeType getPlannedStartDate() {
        return plannedStartDate;
    }


    /**
     * Sets the plannedStartDate value for this CMBChangeInstanceTypeHeader.
     * 
     * @param plannedStartDate
     */
    public void setPlannedStartDate(com.peregrine.servicecenter.PWS.Common.DateTimeType plannedStartDate) {
        this.plannedStartDate = plannedStartDate;
    }


    /**
     * Gets the plannedEndDate value for this CMBChangeInstanceTypeHeader.
     * 
     * @return plannedEndDate
     */
    public com.peregrine.servicecenter.PWS.Common.DateTimeType getPlannedEndDate() {
        return plannedEndDate;
    }


    /**
     * Sets the plannedEndDate value for this CMBChangeInstanceTypeHeader.
     * 
     * @param plannedEndDate
     */
    public void setPlannedEndDate(com.peregrine.servicecenter.PWS.Common.DateTimeType plannedEndDate) {
        this.plannedEndDate = plannedEndDate;
    }


    /**
     * Gets the reason value for this CMBChangeInstanceTypeHeader.
     * 
     * @return reason
     */
    public com.peregrine.servicecenter.PWS.Common.StringType getReason() {
        return reason;
    }


    /**
     * Sets the reason value for this CMBChangeInstanceTypeHeader.
     * 
     * @param reason
     */
    public void setReason(com.peregrine.servicecenter.PWS.Common.StringType reason) {
        this.reason = reason;
    }


    /**
     * Gets the currentPhase value for this CMBChangeInstanceTypeHeader.
     * 
     * @return currentPhase
     */
    public com.peregrine.servicecenter.PWS.Common.StringType getCurrentPhase() {
        return currentPhase;
    }


    /**
     * Sets the currentPhase value for this CMBChangeInstanceTypeHeader.
     * 
     * @param currentPhase
     */
    public void setCurrentPhase(com.peregrine.servicecenter.PWS.Common.StringType currentPhase) {
        this.currentPhase = currentPhase;
    }


    /**
     * Gets the riskAssessment value for this CMBChangeInstanceTypeHeader.
     * 
     * @return riskAssessment
     */
    public com.peregrine.servicecenter.PWS.Common.StringType getRiskAssessment() {
        return riskAssessment;
    }


    /**
     * Sets the riskAssessment value for this CMBChangeInstanceTypeHeader.
     * 
     * @param riskAssessment
     */
    public void setRiskAssessment(com.peregrine.servicecenter.PWS.Common.StringType riskAssessment) {
        this.riskAssessment = riskAssessment;
    }


    /**
     * Gets the priority value for this CMBChangeInstanceTypeHeader.
     * 
     * @return priority
     */
    public com.peregrine.servicecenter.PWS.Common.StringType getPriority() {
        return priority;
    }


    /**
     * Sets the priority value for this CMBChangeInstanceTypeHeader.
     * 
     * @param priority
     */
    public void setPriority(com.peregrine.servicecenter.PWS.Common.StringType priority) {
        this.priority = priority;
    }


    /**
     * Gets the dateEntered value for this CMBChangeInstanceTypeHeader.
     * 
     * @return dateEntered
     */
    public com.peregrine.servicecenter.PWS.Common.DateTimeType getDateEntered() {
        return dateEntered;
    }


    /**
     * Sets the dateEntered value for this CMBChangeInstanceTypeHeader.
     * 
     * @param dateEntered
     */
    public void setDateEntered(com.peregrine.servicecenter.PWS.Common.DateTimeType dateEntered) {
        this.dateEntered = dateEntered;
    }


    /**
     * Gets the open value for this CMBChangeInstanceTypeHeader.
     * 
     * @return open
     */
    public com.peregrine.servicecenter.PWS.Common.BooleanType getOpen() {
        return open;
    }


    /**
     * Sets the open value for this CMBChangeInstanceTypeHeader.
     * 
     * @param open
     */
    public void setOpen(com.peregrine.servicecenter.PWS.Common.BooleanType open) {
        this.open = open;
    }


    /**
     * Gets the backoutDuration value for this CMBChangeInstanceTypeHeader.
     * 
     * @return backoutDuration
     */
    public com.peregrine.servicecenter.PWS.Common.DurationType getBackoutDuration() {
        return backoutDuration;
    }


    /**
     * Sets the backoutDuration value for this CMBChangeInstanceTypeHeader.
     * 
     * @param backoutDuration
     */
    public void setBackoutDuration(com.peregrine.servicecenter.PWS.Common.DurationType backoutDuration) {
        this.backoutDuration = backoutDuration;
    }


    /**
     * Gets the closeTime value for this CMBChangeInstanceTypeHeader.
     * 
     * @return closeTime
     */
    public com.peregrine.servicecenter.PWS.Common.DateTimeType getCloseTime() {
        return closeTime;
    }


    /**
     * Sets the closeTime value for this CMBChangeInstanceTypeHeader.
     * 
     * @param closeTime
     */
    public void setCloseTime(com.peregrine.servicecenter.PWS.Common.DateTimeType closeTime) {
        this.closeTime = closeTime;
    }


    /**
     * Gets the foreignID value for this CMBChangeInstanceTypeHeader.
     * 
     * @return foreignID
     */
    public com.peregrine.servicecenter.PWS.Common.StringType getForeignID() {
        return foreignID;
    }


    /**
     * Sets the foreignID value for this CMBChangeInstanceTypeHeader.
     * 
     * @param foreignID
     */
    public void setForeignID(com.peregrine.servicecenter.PWS.Common.StringType foreignID) {
        this.foreignID = foreignID;
    }


    /**
     * Gets the RFCType2 value for this CMBChangeInstanceTypeHeader.
     * 
     * @return RFCType2
     */
    public com.peregrine.servicecenter.PWS.Common.StringType getRFCType2() {
        return RFCType2;
    }


    /**
     * Sets the RFCType2 value for this CMBChangeInstanceTypeHeader.
     * 
     * @param RFCType2
     */
    public void setRFCType2(com.peregrine.servicecenter.PWS.Common.StringType RFCType2) {
        this.RFCType2 = RFCType2;
    }


    /**
     * Gets the company value for this CMBChangeInstanceTypeHeader.
     * 
     * @return company
     */
    public com.peregrine.servicecenter.PWS.Common.StringType getCompany() {
        return company;
    }


    /**
     * Sets the company value for this CMBChangeInstanceTypeHeader.
     * 
     * @param company
     */
    public void setCompany(com.peregrine.servicecenter.PWS.Common.StringType company) {
        this.company = company;
    }


    /**
     * Gets the briefDescription value for this CMBChangeInstanceTypeHeader.
     * 
     * @return briefDescription
     */
    public com.peregrine.servicecenter.PWS.Common.StringType getBriefDescription() {
        return briefDescription;
    }


    /**
     * Sets the briefDescription value for this CMBChangeInstanceTypeHeader.
     * 
     * @param briefDescription
     */
    public void setBriefDescription(com.peregrine.servicecenter.PWS.Common.StringType briefDescription) {
        this.briefDescription = briefDescription;
    }


    /**
     * Gets the subcategory value for this CMBChangeInstanceTypeHeader.
     * 
     * @return subcategory
     */
    public com.peregrine.servicecenter.PWS.Common.StringType getSubcategory() {
        return subcategory;
    }


    /**
     * Sets the subcategory value for this CMBChangeInstanceTypeHeader.
     * 
     * @param subcategory
     */
    public void setSubcategory(com.peregrine.servicecenter.PWS.Common.StringType subcategory) {
        this.subcategory = subcategory;
    }


    /**
     * Gets the SLAAgreementID value for this CMBChangeInstanceTypeHeader.
     * 
     * @return SLAAgreementID
     */
    public com.peregrine.servicecenter.PWS.Common.IntType getSLAAgreementID() {
        return SLAAgreementID;
    }


    /**
     * Sets the SLAAgreementID value for this CMBChangeInstanceTypeHeader.
     * 
     * @param SLAAgreementID
     */
    public void setSLAAgreementID(com.peregrine.servicecenter.PWS.Common.IntType SLAAgreementID) {
        this.SLAAgreementID = SLAAgreementID;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CMBChangeInstanceTypeHeader)) return false;
        CMBChangeInstanceTypeHeader other = (CMBChangeInstanceTypeHeader) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.changeNumber==null && other.getChangeNumber()==null) || 
             (this.changeNumber!=null &&
              this.changeNumber.equals(other.getChangeNumber()))) &&
            ((this.category==null && other.getCategory()==null) || 
             (this.category!=null &&
              this.category.equals(other.getCategory()))) &&
            ((this.status==null && other.getStatus()==null) || 
             (this.status!=null &&
              this.status.equals(other.getStatus()))) &&
            ((this.approvalStatus==null && other.getApprovalStatus()==null) || 
             (this.approvalStatus!=null &&
              this.approvalStatus.equals(other.getApprovalStatus()))) &&
            ((this.requestedBy==null && other.getRequestedBy()==null) || 
             (this.requestedBy!=null &&
              this.requestedBy.equals(other.getRequestedBy()))) &&
            ((this.assignedTo==null && other.getAssignedTo()==null) || 
             (this.assignedTo!=null &&
              this.assignedTo.equals(other.getAssignedTo()))) &&
            ((this.assignmentGroup==null && other.getAssignmentGroup()==null) || 
             (this.assignmentGroup!=null &&
              this.assignmentGroup.equals(other.getAssignmentGroup()))) &&
            ((this.coordinator==null && other.getCoordinator()==null) || 
             (this.coordinator!=null &&
              this.coordinator.equals(other.getCoordinator()))) &&
            ((this.coordinatorPhone==null && other.getCoordinatorPhone()==null) || 
             (this.coordinatorPhone!=null &&
              this.coordinatorPhone.equals(other.getCoordinatorPhone()))) &&
            ((this.plannedStartDate==null && other.getPlannedStartDate()==null) || 
             (this.plannedStartDate!=null &&
              this.plannedStartDate.equals(other.getPlannedStartDate()))) &&
            ((this.plannedEndDate==null && other.getPlannedEndDate()==null) || 
             (this.plannedEndDate!=null &&
              this.plannedEndDate.equals(other.getPlannedEndDate()))) &&
            ((this.reason==null && other.getReason()==null) || 
             (this.reason!=null &&
              this.reason.equals(other.getReason()))) &&
            ((this.currentPhase==null && other.getCurrentPhase()==null) || 
             (this.currentPhase!=null &&
              this.currentPhase.equals(other.getCurrentPhase()))) &&
            ((this.riskAssessment==null && other.getRiskAssessment()==null) || 
             (this.riskAssessment!=null &&
              this.riskAssessment.equals(other.getRiskAssessment()))) &&
            ((this.priority==null && other.getPriority()==null) || 
             (this.priority!=null &&
              this.priority.equals(other.getPriority()))) &&
            ((this.dateEntered==null && other.getDateEntered()==null) || 
             (this.dateEntered!=null &&
              this.dateEntered.equals(other.getDateEntered()))) &&
            ((this.open==null && other.getOpen()==null) || 
             (this.open!=null &&
              this.open.equals(other.getOpen()))) &&
            ((this.backoutDuration==null && other.getBackoutDuration()==null) || 
             (this.backoutDuration!=null &&
              this.backoutDuration.equals(other.getBackoutDuration()))) &&
            ((this.closeTime==null && other.getCloseTime()==null) || 
             (this.closeTime!=null &&
              this.closeTime.equals(other.getCloseTime()))) &&
            ((this.foreignID==null && other.getForeignID()==null) || 
             (this.foreignID!=null &&
              this.foreignID.equals(other.getForeignID()))) &&
            ((this.RFCType2==null && other.getRFCType2()==null) || 
             (this.RFCType2!=null &&
              this.RFCType2.equals(other.getRFCType2()))) &&
            ((this.company==null && other.getCompany()==null) || 
             (this.company!=null &&
              this.company.equals(other.getCompany()))) &&
            ((this.briefDescription==null && other.getBriefDescription()==null) || 
             (this.briefDescription!=null &&
              this.briefDescription.equals(other.getBriefDescription()))) &&
            ((this.subcategory==null && other.getSubcategory()==null) || 
             (this.subcategory!=null &&
              this.subcategory.equals(other.getSubcategory()))) &&
            ((this.SLAAgreementID==null && other.getSLAAgreementID()==null) || 
             (this.SLAAgreementID!=null &&
              this.SLAAgreementID.equals(other.getSLAAgreementID())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = super.hashCode();
        if (getChangeNumber() != null) {
            _hashCode += getChangeNumber().hashCode();
        }
        if (getCategory() != null) {
            _hashCode += getCategory().hashCode();
        }
        if (getStatus() != null) {
            _hashCode += getStatus().hashCode();
        }
        if (getApprovalStatus() != null) {
            _hashCode += getApprovalStatus().hashCode();
        }
        if (getRequestedBy() != null) {
            _hashCode += getRequestedBy().hashCode();
        }
        if (getAssignedTo() != null) {
            _hashCode += getAssignedTo().hashCode();
        }
        if (getAssignmentGroup() != null) {
            _hashCode += getAssignmentGroup().hashCode();
        }
        if (getCoordinator() != null) {
            _hashCode += getCoordinator().hashCode();
        }
        if (getCoordinatorPhone() != null) {
            _hashCode += getCoordinatorPhone().hashCode();
        }
        if (getPlannedStartDate() != null) {
            _hashCode += getPlannedStartDate().hashCode();
        }
        if (getPlannedEndDate() != null) {
            _hashCode += getPlannedEndDate().hashCode();
        }
        if (getReason() != null) {
            _hashCode += getReason().hashCode();
        }
        if (getCurrentPhase() != null) {
            _hashCode += getCurrentPhase().hashCode();
        }
        if (getRiskAssessment() != null) {
            _hashCode += getRiskAssessment().hashCode();
        }
        if (getPriority() != null) {
            _hashCode += getPriority().hashCode();
        }
        if (getDateEntered() != null) {
            _hashCode += getDateEntered().hashCode();
        }
        if (getOpen() != null) {
            _hashCode += getOpen().hashCode();
        }
        if (getBackoutDuration() != null) {
            _hashCode += getBackoutDuration().hashCode();
        }
        if (getCloseTime() != null) {
            _hashCode += getCloseTime().hashCode();
        }
        if (getForeignID() != null) {
            _hashCode += getForeignID().hashCode();
        }
        if (getRFCType2() != null) {
            _hashCode += getRFCType2().hashCode();
        }
        if (getCompany() != null) {
            _hashCode += getCompany().hashCode();
        }
        if (getBriefDescription() != null) {
            _hashCode += getBriefDescription().hashCode();
        }
        if (getSubcategory() != null) {
            _hashCode += getSubcategory().hashCode();
        }
        if (getSLAAgreementID() != null) {
            _hashCode += getSLAAgreementID().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CMBChangeInstanceTypeHeader.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", ">CMBChangeInstanceType>header"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("changeNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "ChangeNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS/Common", "StringType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("category");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "Category"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS/Common", "StringType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("status");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "Status"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS/Common", "StringType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("approvalStatus");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "ApprovalStatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS/Common", "StringType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("requestedBy");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "RequestedBy"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS/Common", "StringType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("assignedTo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "AssignedTo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS/Common", "StringType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("assignmentGroup");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "AssignmentGroup"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS/Common", "StringType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("coordinator");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "Coordinator"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS/Common", "StringType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("coordinatorPhone");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "CoordinatorPhone"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS/Common", "StringType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("plannedStartDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "PlannedStartDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS/Common", "DateTimeType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("plannedEndDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "PlannedEndDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS/Common", "DateTimeType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("reason");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "Reason"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS/Common", "StringType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("currentPhase");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "CurrentPhase"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS/Common", "StringType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("riskAssessment");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "RiskAssessment"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS/Common", "StringType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("priority");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "Priority"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS/Common", "StringType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dateEntered");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "DateEntered"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS/Common", "DateTimeType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("open");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "Open"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS/Common", "BooleanType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("backoutDuration");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "BackoutDuration"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS/Common", "DurationType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("closeTime");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "CloseTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS/Common", "DateTimeType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("foreignID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "ForeignID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS/Common", "StringType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("RFCType2");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "RFCType2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS/Common", "StringType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("company");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "Company"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS/Common", "StringType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("briefDescription");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "BriefDescription"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS/Common", "StringType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("subcategory");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "Subcategory"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS/Common", "StringType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SLAAgreementID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "SLAAgreementID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS/Common", "IntType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
