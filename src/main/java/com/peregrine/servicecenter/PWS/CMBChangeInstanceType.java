/**
 * CMBChangeInstanceType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peregrine.servicecenter.PWS;

public class CMBChangeInstanceType  implements java.io.Serializable {
    private com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeHeader header;

    private com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeDescriptionStructure descriptionStructure;

    private com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeMiddle middle;

    private com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeClose close;

    private com.peregrine.servicecenter.PWS.Common.StringType approver;

    private com.peregrine.servicecenter.PWS.Common.StringType urgency;

    private com.peregrine.servicecenter.PWS.Common.StringType initialAssessment;

    private com.peregrine.servicecenter.PWS.Common.StringType releaseType;

    private com.peregrine.servicecenter.PWS.Common.StringType service;

    private com.peregrine.servicecenter.PWS.Common.BooleanType releaseCandidate;

    private com.peregrine.servicecenter.PWS.Common.DateTimeType requestedDate;

    private com.peregrine.servicecenter.PWS.Common.StringType location;

    private com.peregrine.servicecenter.PWS.Common.BooleanType emergency;

    private com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeClosureComments closureComments;

    private com.peregrine.servicecenter.PWS.Common.StringType CMBStatus;

    private com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeImplePerson implePerson;

    private com.peregrine.servicecenter.PWS.Common.BooleanType ifUrgent;

    private com.peregrine.servicecenter.PWS.Common.StringType CMBSourceID;

    private com.peregrine.servicecenter.PWS.Common.DecimalType cmbriskimportance;

    private com.peregrine.servicecenter.PWS.Common.DecimalType cmbrisksource;

    private com.peregrine.servicecenter.PWS.Common.DecimalType cmbriskimpletime;

    private com.peregrine.servicecenter.PWS.Common.DecimalType cmbriskplantime;

    private com.peregrine.servicecenter.PWS.Common.DecimalType cmbriskpossible;

    private com.peregrine.servicecenter.PWS.Common.DecimalType cmbriskretractime;

    private com.peregrine.servicecenter.PWS.Common.StringType CMBApprovalHistory;

    private com.peregrine.servicecenter.PWS.Common.StringType CMBYSTOOperator;

    private com.peregrine.servicecenter.PWS.Common.StringType CMBYSTOperator;

    private com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeCMBAttachmentsAddress CMBAttachmentsAddress;

    private com.peregrine.servicecenter.PWS.Common.StringType cmbplanreviewer;

    private com.peregrine.servicecenter.PWS.Common.StringType cmbplanreviewerfullname;

    private com.peregrine.servicecenter.PWS.Common.BooleanType cmbkeybiz;

    private com.peregrine.servicecenter.PWS.Common.DecimalType cmbriskdrate;

    private com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeImpleplannedend impleplannedend;

    private com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeImpleplannedstart impleplannedstart;

    private com.peregrine.servicecenter.PWS.Common.StringType cmbchangeevaluationresult;

    private com.peregrine.servicecenter.PWS.Common.StringType changeForm;

    private com.peregrine.servicecenter.PWS.Common.StringType CMBPlanImple;

    private com.peregrine.servicecenter.PWS.Common.StringType cmbplanimplefullname;

    private com.peregrine.servicecenter.PWS.Common.StringType cmbplanreviewermode;

    private com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeCmbService cmbService;

    private com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeCmbriskdesc cmbriskdesc;

    private com.peregrine.servicecenter.PWS.Common.StringType topSystem;

    private com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeApprovalComments approvalComments;

    private com.peregrine.servicecenter.PWS.Common.AttachmentType[] attachments;

    private java.lang.String query;  // attribute

    private java.lang.String uniquequery;  // attribute

    private java.lang.String recordid;  // attribute

    private java.lang.Long updatecounter;  // attribute

    public CMBChangeInstanceType() {
    }

    public CMBChangeInstanceType(
           com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeHeader header,
           com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeDescriptionStructure descriptionStructure,
           com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeMiddle middle,
           com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeClose close,
           com.peregrine.servicecenter.PWS.Common.StringType approver,
           com.peregrine.servicecenter.PWS.Common.StringType urgency,
           com.peregrine.servicecenter.PWS.Common.StringType initialAssessment,
           com.peregrine.servicecenter.PWS.Common.StringType releaseType,
           com.peregrine.servicecenter.PWS.Common.StringType service,
           com.peregrine.servicecenter.PWS.Common.BooleanType releaseCandidate,
           com.peregrine.servicecenter.PWS.Common.DateTimeType requestedDate,
           com.peregrine.servicecenter.PWS.Common.StringType location,
           com.peregrine.servicecenter.PWS.Common.BooleanType emergency,
           com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeClosureComments closureComments,
           com.peregrine.servicecenter.PWS.Common.StringType CMBStatus,
           com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeImplePerson implePerson,
           com.peregrine.servicecenter.PWS.Common.BooleanType ifUrgent,
           com.peregrine.servicecenter.PWS.Common.StringType CMBSourceID,
           com.peregrine.servicecenter.PWS.Common.DecimalType cmbriskimportance,
           com.peregrine.servicecenter.PWS.Common.DecimalType cmbrisksource,
           com.peregrine.servicecenter.PWS.Common.DecimalType cmbriskimpletime,
           com.peregrine.servicecenter.PWS.Common.DecimalType cmbriskplantime,
           com.peregrine.servicecenter.PWS.Common.DecimalType cmbriskpossible,
           com.peregrine.servicecenter.PWS.Common.DecimalType cmbriskretractime,
           com.peregrine.servicecenter.PWS.Common.StringType CMBApprovalHistory,
           com.peregrine.servicecenter.PWS.Common.StringType CMBYSTOOperator,
           com.peregrine.servicecenter.PWS.Common.StringType CMBYSTOperator,
           com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeCMBAttachmentsAddress CMBAttachmentsAddress,
           com.peregrine.servicecenter.PWS.Common.StringType cmbplanreviewer,
           com.peregrine.servicecenter.PWS.Common.StringType cmbplanreviewerfullname,
           com.peregrine.servicecenter.PWS.Common.BooleanType cmbkeybiz,
           com.peregrine.servicecenter.PWS.Common.DecimalType cmbriskdrate,
           com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeImpleplannedend impleplannedend,
           com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeImpleplannedstart impleplannedstart,
           com.peregrine.servicecenter.PWS.Common.StringType cmbchangeevaluationresult,
           com.peregrine.servicecenter.PWS.Common.StringType changeForm,
           com.peregrine.servicecenter.PWS.Common.StringType CMBPlanImple,
           com.peregrine.servicecenter.PWS.Common.StringType cmbplanimplefullname,
           com.peregrine.servicecenter.PWS.Common.StringType cmbplanreviewermode,
           com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeCmbService cmbService,
           com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeCmbriskdesc cmbriskdesc,
           com.peregrine.servicecenter.PWS.Common.StringType topSystem,
           com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeApprovalComments approvalComments,
           com.peregrine.servicecenter.PWS.Common.AttachmentType[] attachments,
           java.lang.String query,
           java.lang.String uniquequery,
           java.lang.String recordid,
           java.lang.Long updatecounter) {
           this.header = header;
           this.descriptionStructure = descriptionStructure;
           this.middle = middle;
           this.close = close;
           this.approver = approver;
           this.urgency = urgency;
           this.initialAssessment = initialAssessment;
           this.releaseType = releaseType;
           this.service = service;
           this.releaseCandidate = releaseCandidate;
           this.requestedDate = requestedDate;
           this.location = location;
           this.emergency = emergency;
           this.closureComments = closureComments;
           this.CMBStatus = CMBStatus;
           this.implePerson = implePerson;
           this.ifUrgent = ifUrgent;
           this.CMBSourceID = CMBSourceID;
           this.cmbriskimportance = cmbriskimportance;
           this.cmbrisksource = cmbrisksource;
           this.cmbriskimpletime = cmbriskimpletime;
           this.cmbriskplantime = cmbriskplantime;
           this.cmbriskpossible = cmbriskpossible;
           this.cmbriskretractime = cmbriskretractime;
           this.CMBApprovalHistory = CMBApprovalHistory;
           this.CMBYSTOOperator = CMBYSTOOperator;
           this.CMBYSTOperator = CMBYSTOperator;
           this.CMBAttachmentsAddress = CMBAttachmentsAddress;
           this.cmbplanreviewer = cmbplanreviewer;
           this.cmbplanreviewerfullname = cmbplanreviewerfullname;
           this.cmbkeybiz = cmbkeybiz;
           this.cmbriskdrate = cmbriskdrate;
           this.impleplannedend = impleplannedend;
           this.impleplannedstart = impleplannedstart;
           this.cmbchangeevaluationresult = cmbchangeevaluationresult;
           this.changeForm = changeForm;
           this.CMBPlanImple = CMBPlanImple;
           this.cmbplanimplefullname = cmbplanimplefullname;
           this.cmbplanreviewermode = cmbplanreviewermode;
           this.cmbService = cmbService;
           this.cmbriskdesc = cmbriskdesc;
           this.topSystem = topSystem;
           this.approvalComments = approvalComments;
           this.attachments = attachments;
           this.query = query;
           this.uniquequery = uniquequery;
           this.recordid = recordid;
           this.updatecounter = updatecounter;
    }


    /**
     * Gets the header value for this CMBChangeInstanceType.
     * 
     * @return header
     */
    public com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeHeader getHeader() {
        return header;
    }


    /**
     * Sets the header value for this CMBChangeInstanceType.
     * 
     * @param header
     */
    public void setHeader(com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeHeader header) {
        this.header = header;
    }


    /**
     * Gets the descriptionStructure value for this CMBChangeInstanceType.
     * 
     * @return descriptionStructure
     */
    public com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeDescriptionStructure getDescriptionStructure() {
        return descriptionStructure;
    }


    /**
     * Sets the descriptionStructure value for this CMBChangeInstanceType.
     * 
     * @param descriptionStructure
     */
    public void setDescriptionStructure(com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeDescriptionStructure descriptionStructure) {
        this.descriptionStructure = descriptionStructure;
    }


    /**
     * Gets the middle value for this CMBChangeInstanceType.
     * 
     * @return middle
     */
    public com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeMiddle getMiddle() {
        return middle;
    }


    /**
     * Sets the middle value for this CMBChangeInstanceType.
     * 
     * @param middle
     */
    public void setMiddle(com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeMiddle middle) {
        this.middle = middle;
    }


    /**
     * Gets the close value for this CMBChangeInstanceType.
     * 
     * @return close
     */
    public com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeClose getClose() {
        return close;
    }


    /**
     * Sets the close value for this CMBChangeInstanceType.
     * 
     * @param close
     */
    public void setClose(com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeClose close) {
        this.close = close;
    }


    /**
     * Gets the approver value for this CMBChangeInstanceType.
     * 
     * @return approver
     */
    public com.peregrine.servicecenter.PWS.Common.StringType getApprover() {
        return approver;
    }


    /**
     * Sets the approver value for this CMBChangeInstanceType.
     * 
     * @param approver
     */
    public void setApprover(com.peregrine.servicecenter.PWS.Common.StringType approver) {
        this.approver = approver;
    }


    /**
     * Gets the urgency value for this CMBChangeInstanceType.
     * 
     * @return urgency
     */
    public com.peregrine.servicecenter.PWS.Common.StringType getUrgency() {
        return urgency;
    }


    /**
     * Sets the urgency value for this CMBChangeInstanceType.
     * 
     * @param urgency
     */
    public void setUrgency(com.peregrine.servicecenter.PWS.Common.StringType urgency) {
        this.urgency = urgency;
    }


    /**
     * Gets the initialAssessment value for this CMBChangeInstanceType.
     * 
     * @return initialAssessment
     */
    public com.peregrine.servicecenter.PWS.Common.StringType getInitialAssessment() {
        return initialAssessment;
    }


    /**
     * Sets the initialAssessment value for this CMBChangeInstanceType.
     * 
     * @param initialAssessment
     */
    public void setInitialAssessment(com.peregrine.servicecenter.PWS.Common.StringType initialAssessment) {
        this.initialAssessment = initialAssessment;
    }


    /**
     * Gets the releaseType value for this CMBChangeInstanceType.
     * 
     * @return releaseType
     */
    public com.peregrine.servicecenter.PWS.Common.StringType getReleaseType() {
        return releaseType;
    }


    /**
     * Sets the releaseType value for this CMBChangeInstanceType.
     * 
     * @param releaseType
     */
    public void setReleaseType(com.peregrine.servicecenter.PWS.Common.StringType releaseType) {
        this.releaseType = releaseType;
    }


    /**
     * Gets the service value for this CMBChangeInstanceType.
     * 
     * @return service
     */
    public com.peregrine.servicecenter.PWS.Common.StringType getService() {
        return service;
    }


    /**
     * Sets the service value for this CMBChangeInstanceType.
     * 
     * @param service
     */
    public void setService(com.peregrine.servicecenter.PWS.Common.StringType service) {
        this.service = service;
    }


    /**
     * Gets the releaseCandidate value for this CMBChangeInstanceType.
     * 
     * @return releaseCandidate
     */
    public com.peregrine.servicecenter.PWS.Common.BooleanType getReleaseCandidate() {
        return releaseCandidate;
    }


    /**
     * Sets the releaseCandidate value for this CMBChangeInstanceType.
     * 
     * @param releaseCandidate
     */
    public void setReleaseCandidate(com.peregrine.servicecenter.PWS.Common.BooleanType releaseCandidate) {
        this.releaseCandidate = releaseCandidate;
    }


    /**
     * Gets the requestedDate value for this CMBChangeInstanceType.
     * 
     * @return requestedDate
     */
    public com.peregrine.servicecenter.PWS.Common.DateTimeType getRequestedDate() {
        return requestedDate;
    }


    /**
     * Sets the requestedDate value for this CMBChangeInstanceType.
     * 
     * @param requestedDate
     */
    public void setRequestedDate(com.peregrine.servicecenter.PWS.Common.DateTimeType requestedDate) {
        this.requestedDate = requestedDate;
    }


    /**
     * Gets the location value for this CMBChangeInstanceType.
     * 
     * @return location
     */
    public com.peregrine.servicecenter.PWS.Common.StringType getLocation() {
        return location;
    }


    /**
     * Sets the location value for this CMBChangeInstanceType.
     * 
     * @param location
     */
    public void setLocation(com.peregrine.servicecenter.PWS.Common.StringType location) {
        this.location = location;
    }


    /**
     * Gets the emergency value for this CMBChangeInstanceType.
     * 
     * @return emergency
     */
    public com.peregrine.servicecenter.PWS.Common.BooleanType getEmergency() {
        return emergency;
    }


    /**
     * Sets the emergency value for this CMBChangeInstanceType.
     * 
     * @param emergency
     */
    public void setEmergency(com.peregrine.servicecenter.PWS.Common.BooleanType emergency) {
        this.emergency = emergency;
    }


    /**
     * Gets the closureComments value for this CMBChangeInstanceType.
     * 
     * @return closureComments
     */
    public com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeClosureComments getClosureComments() {
        return closureComments;
    }


    /**
     * Sets the closureComments value for this CMBChangeInstanceType.
     * 
     * @param closureComments
     */
    public void setClosureComments(com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeClosureComments closureComments) {
        this.closureComments = closureComments;
    }


    /**
     * Gets the CMBStatus value for this CMBChangeInstanceType.
     * 
     * @return CMBStatus
     */
    public com.peregrine.servicecenter.PWS.Common.StringType getCMBStatus() {
        return CMBStatus;
    }


    /**
     * Sets the CMBStatus value for this CMBChangeInstanceType.
     * 
     * @param CMBStatus
     */
    public void setCMBStatus(com.peregrine.servicecenter.PWS.Common.StringType CMBStatus) {
        this.CMBStatus = CMBStatus;
    }


    /**
     * Gets the implePerson value for this CMBChangeInstanceType.
     * 
     * @return implePerson
     */
    public com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeImplePerson getImplePerson() {
        return implePerson;
    }


    /**
     * Sets the implePerson value for this CMBChangeInstanceType.
     * 
     * @param implePerson
     */
    public void setImplePerson(com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeImplePerson implePerson) {
        this.implePerson = implePerson;
    }


    /**
     * Gets the ifUrgent value for this CMBChangeInstanceType.
     * 
     * @return ifUrgent
     */
    public com.peregrine.servicecenter.PWS.Common.BooleanType getIfUrgent() {
        return ifUrgent;
    }


    /**
     * Sets the ifUrgent value for this CMBChangeInstanceType.
     * 
     * @param ifUrgent
     */
    public void setIfUrgent(com.peregrine.servicecenter.PWS.Common.BooleanType ifUrgent) {
        this.ifUrgent = ifUrgent;
    }


    /**
     * Gets the CMBSourceID value for this CMBChangeInstanceType.
     * 
     * @return CMBSourceID
     */
    public com.peregrine.servicecenter.PWS.Common.StringType getCMBSourceID() {
        return CMBSourceID;
    }


    /**
     * Sets the CMBSourceID value for this CMBChangeInstanceType.
     * 
     * @param CMBSourceID
     */
    public void setCMBSourceID(com.peregrine.servicecenter.PWS.Common.StringType CMBSourceID) {
        this.CMBSourceID = CMBSourceID;
    }


    /**
     * Gets the cmbriskimportance value for this CMBChangeInstanceType.
     * 
     * @return cmbriskimportance
     */
    public com.peregrine.servicecenter.PWS.Common.DecimalType getCmbriskimportance() {
        return cmbriskimportance;
    }


    /**
     * Sets the cmbriskimportance value for this CMBChangeInstanceType.
     * 
     * @param cmbriskimportance
     */
    public void setCmbriskimportance(com.peregrine.servicecenter.PWS.Common.DecimalType cmbriskimportance) {
        this.cmbriskimportance = cmbriskimportance;
    }


    /**
     * Gets the cmbrisksource value for this CMBChangeInstanceType.
     * 
     * @return cmbrisksource
     */
    public com.peregrine.servicecenter.PWS.Common.DecimalType getCmbrisksource() {
        return cmbrisksource;
    }


    /**
     * Sets the cmbrisksource value for this CMBChangeInstanceType.
     * 
     * @param cmbrisksource
     */
    public void setCmbrisksource(com.peregrine.servicecenter.PWS.Common.DecimalType cmbrisksource) {
        this.cmbrisksource = cmbrisksource;
    }


    /**
     * Gets the cmbriskimpletime value for this CMBChangeInstanceType.
     * 
     * @return cmbriskimpletime
     */
    public com.peregrine.servicecenter.PWS.Common.DecimalType getCmbriskimpletime() {
        return cmbriskimpletime;
    }


    /**
     * Sets the cmbriskimpletime value for this CMBChangeInstanceType.
     * 
     * @param cmbriskimpletime
     */
    public void setCmbriskimpletime(com.peregrine.servicecenter.PWS.Common.DecimalType cmbriskimpletime) {
        this.cmbriskimpletime = cmbriskimpletime;
    }


    /**
     * Gets the cmbriskplantime value for this CMBChangeInstanceType.
     * 
     * @return cmbriskplantime
     */
    public com.peregrine.servicecenter.PWS.Common.DecimalType getCmbriskplantime() {
        return cmbriskplantime;
    }


    /**
     * Sets the cmbriskplantime value for this CMBChangeInstanceType.
     * 
     * @param cmbriskplantime
     */
    public void setCmbriskplantime(com.peregrine.servicecenter.PWS.Common.DecimalType cmbriskplantime) {
        this.cmbriskplantime = cmbriskplantime;
    }


    /**
     * Gets the cmbriskpossible value for this CMBChangeInstanceType.
     * 
     * @return cmbriskpossible
     */
    public com.peregrine.servicecenter.PWS.Common.DecimalType getCmbriskpossible() {
        return cmbriskpossible;
    }


    /**
     * Sets the cmbriskpossible value for this CMBChangeInstanceType.
     * 
     * @param cmbriskpossible
     */
    public void setCmbriskpossible(com.peregrine.servicecenter.PWS.Common.DecimalType cmbriskpossible) {
        this.cmbriskpossible = cmbriskpossible;
    }


    /**
     * Gets the cmbriskretractime value for this CMBChangeInstanceType.
     * 
     * @return cmbriskretractime
     */
    public com.peregrine.servicecenter.PWS.Common.DecimalType getCmbriskretractime() {
        return cmbriskretractime;
    }


    /**
     * Sets the cmbriskretractime value for this CMBChangeInstanceType.
     * 
     * @param cmbriskretractime
     */
    public void setCmbriskretractime(com.peregrine.servicecenter.PWS.Common.DecimalType cmbriskretractime) {
        this.cmbriskretractime = cmbriskretractime;
    }


    /**
     * Gets the CMBApprovalHistory value for this CMBChangeInstanceType.
     * 
     * @return CMBApprovalHistory
     */
    public com.peregrine.servicecenter.PWS.Common.StringType getCMBApprovalHistory() {
        return CMBApprovalHistory;
    }


    /**
     * Sets the CMBApprovalHistory value for this CMBChangeInstanceType.
     * 
     * @param CMBApprovalHistory
     */
    public void setCMBApprovalHistory(com.peregrine.servicecenter.PWS.Common.StringType CMBApprovalHistory) {
        this.CMBApprovalHistory = CMBApprovalHistory;
    }


    /**
     * Gets the CMBYSTOOperator value for this CMBChangeInstanceType.
     * 
     * @return CMBYSTOOperator
     */
    public com.peregrine.servicecenter.PWS.Common.StringType getCMBYSTOOperator() {
        return CMBYSTOOperator;
    }


    /**
     * Sets the CMBYSTOOperator value for this CMBChangeInstanceType.
     * 
     * @param CMBYSTOOperator
     */
    public void setCMBYSTOOperator(com.peregrine.servicecenter.PWS.Common.StringType CMBYSTOOperator) {
        this.CMBYSTOOperator = CMBYSTOOperator;
    }


    /**
     * Gets the CMBYSTOperator value for this CMBChangeInstanceType.
     * 
     * @return CMBYSTOperator
     */
    public com.peregrine.servicecenter.PWS.Common.StringType getCMBYSTOperator() {
        return CMBYSTOperator;
    }


    /**
     * Sets the CMBYSTOperator value for this CMBChangeInstanceType.
     * 
     * @param CMBYSTOperator
     */
    public void setCMBYSTOperator(com.peregrine.servicecenter.PWS.Common.StringType CMBYSTOperator) {
        this.CMBYSTOperator = CMBYSTOperator;
    }


    /**
     * Gets the CMBAttachmentsAddress value for this CMBChangeInstanceType.
     * 
     * @return CMBAttachmentsAddress
     */
    public com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeCMBAttachmentsAddress getCMBAttachmentsAddress() {
        return CMBAttachmentsAddress;
    }


    /**
     * Sets the CMBAttachmentsAddress value for this CMBChangeInstanceType.
     * 
     * @param CMBAttachmentsAddress
     */
    public void setCMBAttachmentsAddress(com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeCMBAttachmentsAddress CMBAttachmentsAddress) {
        this.CMBAttachmentsAddress = CMBAttachmentsAddress;
    }


    /**
     * Gets the cmbplanreviewer value for this CMBChangeInstanceType.
     * 
     * @return cmbplanreviewer
     */
    public com.peregrine.servicecenter.PWS.Common.StringType getCmbplanreviewer() {
        return cmbplanreviewer;
    }


    /**
     * Sets the cmbplanreviewer value for this CMBChangeInstanceType.
     * 
     * @param cmbplanreviewer
     */
    public void setCmbplanreviewer(com.peregrine.servicecenter.PWS.Common.StringType cmbplanreviewer) {
        this.cmbplanreviewer = cmbplanreviewer;
    }


    /**
     * Gets the cmbplanreviewerfullname value for this CMBChangeInstanceType.
     * 
     * @return cmbplanreviewerfullname
     */
    public com.peregrine.servicecenter.PWS.Common.StringType getCmbplanreviewerfullname() {
        return cmbplanreviewerfullname;
    }


    /**
     * Sets the cmbplanreviewerfullname value for this CMBChangeInstanceType.
     * 
     * @param cmbplanreviewerfullname
     */
    public void setCmbplanreviewerfullname(com.peregrine.servicecenter.PWS.Common.StringType cmbplanreviewerfullname) {
        this.cmbplanreviewerfullname = cmbplanreviewerfullname;
    }


    /**
     * Gets the cmbkeybiz value for this CMBChangeInstanceType.
     * 
     * @return cmbkeybiz
     */
    public com.peregrine.servicecenter.PWS.Common.BooleanType getCmbkeybiz() {
        return cmbkeybiz;
    }


    /**
     * Sets the cmbkeybiz value for this CMBChangeInstanceType.
     * 
     * @param cmbkeybiz
     */
    public void setCmbkeybiz(com.peregrine.servicecenter.PWS.Common.BooleanType cmbkeybiz) {
        this.cmbkeybiz = cmbkeybiz;
    }


    /**
     * Gets the cmbriskdrate value for this CMBChangeInstanceType.
     * 
     * @return cmbriskdrate
     */
    public com.peregrine.servicecenter.PWS.Common.DecimalType getCmbriskdrate() {
        return cmbriskdrate;
    }


    /**
     * Sets the cmbriskdrate value for this CMBChangeInstanceType.
     * 
     * @param cmbriskdrate
     */
    public void setCmbriskdrate(com.peregrine.servicecenter.PWS.Common.DecimalType cmbriskdrate) {
        this.cmbriskdrate = cmbriskdrate;
    }


    /**
     * Gets the impleplannedend value for this CMBChangeInstanceType.
     * 
     * @return impleplannedend
     */
    public com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeImpleplannedend getImpleplannedend() {
        return impleplannedend;
    }


    /**
     * Sets the impleplannedend value for this CMBChangeInstanceType.
     * 
     * @param impleplannedend
     */
    public void setImpleplannedend(com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeImpleplannedend impleplannedend) {
        this.impleplannedend = impleplannedend;
    }


    /**
     * Gets the impleplannedstart value for this CMBChangeInstanceType.
     * 
     * @return impleplannedstart
     */
    public com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeImpleplannedstart getImpleplannedstart() {
        return impleplannedstart;
    }


    /**
     * Sets the impleplannedstart value for this CMBChangeInstanceType.
     * 
     * @param impleplannedstart
     */
    public void setImpleplannedstart(com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeImpleplannedstart impleplannedstart) {
        this.impleplannedstart = impleplannedstart;
    }


    /**
     * Gets the cmbchangeevaluationresult value for this CMBChangeInstanceType.
     * 
     * @return cmbchangeevaluationresult
     */
    public com.peregrine.servicecenter.PWS.Common.StringType getCmbchangeevaluationresult() {
        return cmbchangeevaluationresult;
    }


    /**
     * Sets the cmbchangeevaluationresult value for this CMBChangeInstanceType.
     * 
     * @param cmbchangeevaluationresult
     */
    public void setCmbchangeevaluationresult(com.peregrine.servicecenter.PWS.Common.StringType cmbchangeevaluationresult) {
        this.cmbchangeevaluationresult = cmbchangeevaluationresult;
    }


    /**
     * Gets the changeForm value for this CMBChangeInstanceType.
     * 
     * @return changeForm
     */
    public com.peregrine.servicecenter.PWS.Common.StringType getChangeForm() {
        return changeForm;
    }


    /**
     * Sets the changeForm value for this CMBChangeInstanceType.
     * 
     * @param changeForm
     */
    public void setChangeForm(com.peregrine.servicecenter.PWS.Common.StringType changeForm) {
        this.changeForm = changeForm;
    }


    /**
     * Gets the CMBPlanImple value for this CMBChangeInstanceType.
     * 
     * @return CMBPlanImple
     */
    public com.peregrine.servicecenter.PWS.Common.StringType getCMBPlanImple() {
        return CMBPlanImple;
    }


    /**
     * Sets the CMBPlanImple value for this CMBChangeInstanceType.
     * 
     * @param CMBPlanImple
     */
    public void setCMBPlanImple(com.peregrine.servicecenter.PWS.Common.StringType CMBPlanImple) {
        this.CMBPlanImple = CMBPlanImple;
    }


    /**
     * Gets the cmbplanimplefullname value for this CMBChangeInstanceType.
     * 
     * @return cmbplanimplefullname
     */
    public com.peregrine.servicecenter.PWS.Common.StringType getCmbplanimplefullname() {
        return cmbplanimplefullname;
    }


    /**
     * Sets the cmbplanimplefullname value for this CMBChangeInstanceType.
     * 
     * @param cmbplanimplefullname
     */
    public void setCmbplanimplefullname(com.peregrine.servicecenter.PWS.Common.StringType cmbplanimplefullname) {
        this.cmbplanimplefullname = cmbplanimplefullname;
    }


    /**
     * Gets the cmbplanreviewermode value for this CMBChangeInstanceType.
     * 
     * @return cmbplanreviewermode
     */
    public com.peregrine.servicecenter.PWS.Common.StringType getCmbplanreviewermode() {
        return cmbplanreviewermode;
    }


    /**
     * Sets the cmbplanreviewermode value for this CMBChangeInstanceType.
     * 
     * @param cmbplanreviewermode
     */
    public void setCmbplanreviewermode(com.peregrine.servicecenter.PWS.Common.StringType cmbplanreviewermode) {
        this.cmbplanreviewermode = cmbplanreviewermode;
    }


    /**
     * Gets the cmbService value for this CMBChangeInstanceType.
     * 
     * @return cmbService
     */
    public com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeCmbService getCmbService() {
        return cmbService;
    }


    /**
     * Sets the cmbService value for this CMBChangeInstanceType.
     * 
     * @param cmbService
     */
    public void setCmbService(com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeCmbService cmbService) {
        this.cmbService = cmbService;
    }


    /**
     * Gets the cmbriskdesc value for this CMBChangeInstanceType.
     * 
     * @return cmbriskdesc
     */
    public com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeCmbriskdesc getCmbriskdesc() {
        return cmbriskdesc;
    }


    /**
     * Sets the cmbriskdesc value for this CMBChangeInstanceType.
     * 
     * @param cmbriskdesc
     */
    public void setCmbriskdesc(com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeCmbriskdesc cmbriskdesc) {
        this.cmbriskdesc = cmbriskdesc;
    }


    /**
     * Gets the topSystem value for this CMBChangeInstanceType.
     * 
     * @return topSystem
     */
    public com.peregrine.servicecenter.PWS.Common.StringType getTopSystem() {
        return topSystem;
    }


    /**
     * Sets the topSystem value for this CMBChangeInstanceType.
     * 
     * @param topSystem
     */
    public void setTopSystem(com.peregrine.servicecenter.PWS.Common.StringType topSystem) {
        this.topSystem = topSystem;
    }


    /**
     * Gets the approvalComments value for this CMBChangeInstanceType.
     * 
     * @return approvalComments
     */
    public com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeApprovalComments getApprovalComments() {
        return approvalComments;
    }


    /**
     * Sets the approvalComments value for this CMBChangeInstanceType.
     * 
     * @param approvalComments
     */
    public void setApprovalComments(com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeApprovalComments approvalComments) {
        this.approvalComments = approvalComments;
    }


    /**
     * Gets the attachments value for this CMBChangeInstanceType.
     * 
     * @return attachments
     */
    public com.peregrine.servicecenter.PWS.Common.AttachmentType[] getAttachments() {
        return attachments;
    }


    /**
     * Sets the attachments value for this CMBChangeInstanceType.
     * 
     * @param attachments
     */
    public void setAttachments(com.peregrine.servicecenter.PWS.Common.AttachmentType[] attachments) {
        this.attachments = attachments;
    }


    /**
     * Gets the query value for this CMBChangeInstanceType.
     * 
     * @return query
     */
    public java.lang.String getQuery() {
        return query;
    }


    /**
     * Sets the query value for this CMBChangeInstanceType.
     * 
     * @param query
     */
    public void setQuery(java.lang.String query) {
        this.query = query;
    }


    /**
     * Gets the uniquequery value for this CMBChangeInstanceType.
     * 
     * @return uniquequery
     */
    public java.lang.String getUniquequery() {
        return uniquequery;
    }


    /**
     * Sets the uniquequery value for this CMBChangeInstanceType.
     * 
     * @param uniquequery
     */
    public void setUniquequery(java.lang.String uniquequery) {
        this.uniquequery = uniquequery;
    }


    /**
     * Gets the recordid value for this CMBChangeInstanceType.
     * 
     * @return recordid
     */
    public java.lang.String getRecordid() {
        return recordid;
    }


    /**
     * Sets the recordid value for this CMBChangeInstanceType.
     * 
     * @param recordid
     */
    public void setRecordid(java.lang.String recordid) {
        this.recordid = recordid;
    }


    /**
     * Gets the updatecounter value for this CMBChangeInstanceType.
     * 
     * @return updatecounter
     */
    public java.lang.Long getUpdatecounter() {
        return updatecounter;
    }


    /**
     * Sets the updatecounter value for this CMBChangeInstanceType.
     * 
     * @param updatecounter
     */
    public void setUpdatecounter(java.lang.Long updatecounter) {
        this.updatecounter = updatecounter;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CMBChangeInstanceType)) return false;
        CMBChangeInstanceType other = (CMBChangeInstanceType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.header==null && other.getHeader()==null) || 
             (this.header!=null &&
              this.header.equals(other.getHeader()))) &&
            ((this.descriptionStructure==null && other.getDescriptionStructure()==null) || 
             (this.descriptionStructure!=null &&
              this.descriptionStructure.equals(other.getDescriptionStructure()))) &&
            ((this.middle==null && other.getMiddle()==null) || 
             (this.middle!=null &&
              this.middle.equals(other.getMiddle()))) &&
            ((this.close==null && other.getClose()==null) || 
             (this.close!=null &&
              this.close.equals(other.getClose()))) &&
            ((this.approver==null && other.getApprover()==null) || 
             (this.approver!=null &&
              this.approver.equals(other.getApprover()))) &&
            ((this.urgency==null && other.getUrgency()==null) || 
             (this.urgency!=null &&
              this.urgency.equals(other.getUrgency()))) &&
            ((this.initialAssessment==null && other.getInitialAssessment()==null) || 
             (this.initialAssessment!=null &&
              this.initialAssessment.equals(other.getInitialAssessment()))) &&
            ((this.releaseType==null && other.getReleaseType()==null) || 
             (this.releaseType!=null &&
              this.releaseType.equals(other.getReleaseType()))) &&
            ((this.service==null && other.getService()==null) || 
             (this.service!=null &&
              this.service.equals(other.getService()))) &&
            ((this.releaseCandidate==null && other.getReleaseCandidate()==null) || 
             (this.releaseCandidate!=null &&
              this.releaseCandidate.equals(other.getReleaseCandidate()))) &&
            ((this.requestedDate==null && other.getRequestedDate()==null) || 
             (this.requestedDate!=null &&
              this.requestedDate.equals(other.getRequestedDate()))) &&
            ((this.location==null && other.getLocation()==null) || 
             (this.location!=null &&
              this.location.equals(other.getLocation()))) &&
            ((this.emergency==null && other.getEmergency()==null) || 
             (this.emergency!=null &&
              this.emergency.equals(other.getEmergency()))) &&
            ((this.closureComments==null && other.getClosureComments()==null) || 
             (this.closureComments!=null &&
              this.closureComments.equals(other.getClosureComments()))) &&
            ((this.CMBStatus==null && other.getCMBStatus()==null) || 
             (this.CMBStatus!=null &&
              this.CMBStatus.equals(other.getCMBStatus()))) &&
            ((this.implePerson==null && other.getImplePerson()==null) || 
             (this.implePerson!=null &&
              this.implePerson.equals(other.getImplePerson()))) &&
            ((this.ifUrgent==null && other.getIfUrgent()==null) || 
             (this.ifUrgent!=null &&
              this.ifUrgent.equals(other.getIfUrgent()))) &&
            ((this.CMBSourceID==null && other.getCMBSourceID()==null) || 
             (this.CMBSourceID!=null &&
              this.CMBSourceID.equals(other.getCMBSourceID()))) &&
            ((this.cmbriskimportance==null && other.getCmbriskimportance()==null) || 
             (this.cmbriskimportance!=null &&
              this.cmbriskimportance.equals(other.getCmbriskimportance()))) &&
            ((this.cmbrisksource==null && other.getCmbrisksource()==null) || 
             (this.cmbrisksource!=null &&
              this.cmbrisksource.equals(other.getCmbrisksource()))) &&
            ((this.cmbriskimpletime==null && other.getCmbriskimpletime()==null) || 
             (this.cmbriskimpletime!=null &&
              this.cmbriskimpletime.equals(other.getCmbriskimpletime()))) &&
            ((this.cmbriskplantime==null && other.getCmbriskplantime()==null) || 
             (this.cmbriskplantime!=null &&
              this.cmbriskplantime.equals(other.getCmbriskplantime()))) &&
            ((this.cmbriskpossible==null && other.getCmbriskpossible()==null) || 
             (this.cmbriskpossible!=null &&
              this.cmbriskpossible.equals(other.getCmbriskpossible()))) &&
            ((this.cmbriskretractime==null && other.getCmbriskretractime()==null) || 
             (this.cmbriskretractime!=null &&
              this.cmbriskretractime.equals(other.getCmbriskretractime()))) &&
            ((this.CMBApprovalHistory==null && other.getCMBApprovalHistory()==null) || 
             (this.CMBApprovalHistory!=null &&
              this.CMBApprovalHistory.equals(other.getCMBApprovalHistory()))) &&
            ((this.CMBYSTOOperator==null && other.getCMBYSTOOperator()==null) || 
             (this.CMBYSTOOperator!=null &&
              this.CMBYSTOOperator.equals(other.getCMBYSTOOperator()))) &&
            ((this.CMBYSTOperator==null && other.getCMBYSTOperator()==null) || 
             (this.CMBYSTOperator!=null &&
              this.CMBYSTOperator.equals(other.getCMBYSTOperator()))) &&
            ((this.CMBAttachmentsAddress==null && other.getCMBAttachmentsAddress()==null) || 
             (this.CMBAttachmentsAddress!=null &&
              this.CMBAttachmentsAddress.equals(other.getCMBAttachmentsAddress()))) &&
            ((this.cmbplanreviewer==null && other.getCmbplanreviewer()==null) || 
             (this.cmbplanreviewer!=null &&
              this.cmbplanreviewer.equals(other.getCmbplanreviewer()))) &&
            ((this.cmbplanreviewerfullname==null && other.getCmbplanreviewerfullname()==null) || 
             (this.cmbplanreviewerfullname!=null &&
              this.cmbplanreviewerfullname.equals(other.getCmbplanreviewerfullname()))) &&
            ((this.cmbkeybiz==null && other.getCmbkeybiz()==null) || 
             (this.cmbkeybiz!=null &&
              this.cmbkeybiz.equals(other.getCmbkeybiz()))) &&
            ((this.cmbriskdrate==null && other.getCmbriskdrate()==null) || 
             (this.cmbriskdrate!=null &&
              this.cmbriskdrate.equals(other.getCmbriskdrate()))) &&
            ((this.impleplannedend==null && other.getImpleplannedend()==null) || 
             (this.impleplannedend!=null &&
              this.impleplannedend.equals(other.getImpleplannedend()))) &&
            ((this.impleplannedstart==null && other.getImpleplannedstart()==null) || 
             (this.impleplannedstart!=null &&
              this.impleplannedstart.equals(other.getImpleplannedstart()))) &&
            ((this.cmbchangeevaluationresult==null && other.getCmbchangeevaluationresult()==null) || 
             (this.cmbchangeevaluationresult!=null &&
              this.cmbchangeevaluationresult.equals(other.getCmbchangeevaluationresult()))) &&
            ((this.changeForm==null && other.getChangeForm()==null) || 
             (this.changeForm!=null &&
              this.changeForm.equals(other.getChangeForm()))) &&
            ((this.CMBPlanImple==null && other.getCMBPlanImple()==null) || 
             (this.CMBPlanImple!=null &&
              this.CMBPlanImple.equals(other.getCMBPlanImple()))) &&
            ((this.cmbplanimplefullname==null && other.getCmbplanimplefullname()==null) || 
             (this.cmbplanimplefullname!=null &&
              this.cmbplanimplefullname.equals(other.getCmbplanimplefullname()))) &&
            ((this.cmbplanreviewermode==null && other.getCmbplanreviewermode()==null) || 
             (this.cmbplanreviewermode!=null &&
              this.cmbplanreviewermode.equals(other.getCmbplanreviewermode()))) &&
            ((this.cmbService==null && other.getCmbService()==null) || 
             (this.cmbService!=null &&
              this.cmbService.equals(other.getCmbService()))) &&
            ((this.cmbriskdesc==null && other.getCmbriskdesc()==null) || 
             (this.cmbriskdesc!=null &&
              this.cmbriskdesc.equals(other.getCmbriskdesc()))) &&
            ((this.topSystem==null && other.getTopSystem()==null) || 
             (this.topSystem!=null &&
              this.topSystem.equals(other.getTopSystem()))) &&
            ((this.approvalComments==null && other.getApprovalComments()==null) || 
             (this.approvalComments!=null &&
              this.approvalComments.equals(other.getApprovalComments()))) &&
            ((this.attachments==null && other.getAttachments()==null) || 
             (this.attachments!=null &&
              java.util.Arrays.equals(this.attachments, other.getAttachments()))) &&
            ((this.query==null && other.getQuery()==null) || 
             (this.query!=null &&
              this.query.equals(other.getQuery()))) &&
            ((this.uniquequery==null && other.getUniquequery()==null) || 
             (this.uniquequery!=null &&
              this.uniquequery.equals(other.getUniquequery()))) &&
            ((this.recordid==null && other.getRecordid()==null) || 
             (this.recordid!=null &&
              this.recordid.equals(other.getRecordid()))) &&
            ((this.updatecounter==null && other.getUpdatecounter()==null) || 
             (this.updatecounter!=null &&
              this.updatecounter.equals(other.getUpdatecounter())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getHeader() != null) {
            _hashCode += getHeader().hashCode();
        }
        if (getDescriptionStructure() != null) {
            _hashCode += getDescriptionStructure().hashCode();
        }
        if (getMiddle() != null) {
            _hashCode += getMiddle().hashCode();
        }
        if (getClose() != null) {
            _hashCode += getClose().hashCode();
        }
        if (getApprover() != null) {
            _hashCode += getApprover().hashCode();
        }
        if (getUrgency() != null) {
            _hashCode += getUrgency().hashCode();
        }
        if (getInitialAssessment() != null) {
            _hashCode += getInitialAssessment().hashCode();
        }
        if (getReleaseType() != null) {
            _hashCode += getReleaseType().hashCode();
        }
        if (getService() != null) {
            _hashCode += getService().hashCode();
        }
        if (getReleaseCandidate() != null) {
            _hashCode += getReleaseCandidate().hashCode();
        }
        if (getRequestedDate() != null) {
            _hashCode += getRequestedDate().hashCode();
        }
        if (getLocation() != null) {
            _hashCode += getLocation().hashCode();
        }
        if (getEmergency() != null) {
            _hashCode += getEmergency().hashCode();
        }
        if (getClosureComments() != null) {
            _hashCode += getClosureComments().hashCode();
        }
        if (getCMBStatus() != null) {
            _hashCode += getCMBStatus().hashCode();
        }
        if (getImplePerson() != null) {
            _hashCode += getImplePerson().hashCode();
        }
        if (getIfUrgent() != null) {
            _hashCode += getIfUrgent().hashCode();
        }
        if (getCMBSourceID() != null) {
            _hashCode += getCMBSourceID().hashCode();
        }
        if (getCmbriskimportance() != null) {
            _hashCode += getCmbriskimportance().hashCode();
        }
        if (getCmbrisksource() != null) {
            _hashCode += getCmbrisksource().hashCode();
        }
        if (getCmbriskimpletime() != null) {
            _hashCode += getCmbriskimpletime().hashCode();
        }
        if (getCmbriskplantime() != null) {
            _hashCode += getCmbriskplantime().hashCode();
        }
        if (getCmbriskpossible() != null) {
            _hashCode += getCmbriskpossible().hashCode();
        }
        if (getCmbriskretractime() != null) {
            _hashCode += getCmbriskretractime().hashCode();
        }
        if (getCMBApprovalHistory() != null) {
            _hashCode += getCMBApprovalHistory().hashCode();
        }
        if (getCMBYSTOOperator() != null) {
            _hashCode += getCMBYSTOOperator().hashCode();
        }
        if (getCMBYSTOperator() != null) {
            _hashCode += getCMBYSTOperator().hashCode();
        }
        if (getCMBAttachmentsAddress() != null) {
            _hashCode += getCMBAttachmentsAddress().hashCode();
        }
        if (getCmbplanreviewer() != null) {
            _hashCode += getCmbplanreviewer().hashCode();
        }
        if (getCmbplanreviewerfullname() != null) {
            _hashCode += getCmbplanreviewerfullname().hashCode();
        }
        if (getCmbkeybiz() != null) {
            _hashCode += getCmbkeybiz().hashCode();
        }
        if (getCmbriskdrate() != null) {
            _hashCode += getCmbriskdrate().hashCode();
        }
        if (getImpleplannedend() != null) {
            _hashCode += getImpleplannedend().hashCode();
        }
        if (getImpleplannedstart() != null) {
            _hashCode += getImpleplannedstart().hashCode();
        }
        if (getCmbchangeevaluationresult() != null) {
            _hashCode += getCmbchangeevaluationresult().hashCode();
        }
        if (getChangeForm() != null) {
            _hashCode += getChangeForm().hashCode();
        }
        if (getCMBPlanImple() != null) {
            _hashCode += getCMBPlanImple().hashCode();
        }
        if (getCmbplanimplefullname() != null) {
            _hashCode += getCmbplanimplefullname().hashCode();
        }
        if (getCmbplanreviewermode() != null) {
            _hashCode += getCmbplanreviewermode().hashCode();
        }
        if (getCmbService() != null) {
            _hashCode += getCmbService().hashCode();
        }
        if (getCmbriskdesc() != null) {
            _hashCode += getCmbriskdesc().hashCode();
        }
        if (getTopSystem() != null) {
            _hashCode += getTopSystem().hashCode();
        }
        if (getApprovalComments() != null) {
            _hashCode += getApprovalComments().hashCode();
        }
        if (getAttachments() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAttachments());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAttachments(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getQuery() != null) {
            _hashCode += getQuery().hashCode();
        }
        if (getUniquequery() != null) {
            _hashCode += getUniquequery().hashCode();
        }
        if (getRecordid() != null) {
            _hashCode += getRecordid().hashCode();
        }
        if (getUpdatecounter() != null) {
            _hashCode += getUpdatecounter().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CMBChangeInstanceType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "CMBChangeInstanceType"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("query");
        attrField.setXmlName(new javax.xml.namespace.QName("", "query"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("uniquequery");
        attrField.setXmlName(new javax.xml.namespace.QName("", "uniquequery"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("recordid");
        attrField.setXmlName(new javax.xml.namespace.QName("", "recordid"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("updatecounter");
        attrField.setXmlName(new javax.xml.namespace.QName("", "updatecounter"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        typeDesc.addFieldDesc(attrField);
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("header");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "header"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", ">CMBChangeInstanceType>header"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("descriptionStructure");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "description.structure"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", ">CMBChangeInstanceType>description.structure"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("middle");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "middle"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", ">CMBChangeInstanceType>middle"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("close");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "close"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", ">CMBChangeInstanceType>close"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("approver");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "Approver"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS/Common", "StringType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("urgency");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "Urgency"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS/Common", "StringType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("initialAssessment");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "InitialAssessment"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS/Common", "StringType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("releaseType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "ReleaseType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS/Common", "StringType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("service");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "Service"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS/Common", "StringType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("releaseCandidate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "ReleaseCandidate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS/Common", "BooleanType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("requestedDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "RequestedDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS/Common", "DateTimeType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("location");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "Location"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS/Common", "StringType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("emergency");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "Emergency"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS/Common", "BooleanType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("closureComments");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "ClosureComments"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", ">CMBChangeInstanceType>ClosureComments"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CMBStatus");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "CMBStatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS/Common", "StringType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("implePerson");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "ImplePerson"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", ">CMBChangeInstanceType>ImplePerson"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ifUrgent");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "IfUrgent"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS/Common", "BooleanType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CMBSourceID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "CMBSourceID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS/Common", "StringType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cmbriskimportance");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "cmbriskimportance"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS/Common", "DecimalType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cmbrisksource");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "cmbrisksource"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS/Common", "DecimalType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cmbriskimpletime");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "cmbriskimpletime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS/Common", "DecimalType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cmbriskplantime");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "cmbriskplantime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS/Common", "DecimalType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cmbriskpossible");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "cmbriskpossible"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS/Common", "DecimalType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cmbriskretractime");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "cmbriskretractime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS/Common", "DecimalType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CMBApprovalHistory");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "CMBApprovalHistory"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS/Common", "StringType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CMBYSTOOperator");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "CMBYSTOOperator"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS/Common", "StringType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CMBYSTOperator");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "CMBYSTOperator"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS/Common", "StringType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CMBAttachmentsAddress");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "CMBAttachmentsAddress"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", ">CMBChangeInstanceType>CMBAttachmentsAddress"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cmbplanreviewer");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "cmbplanreviewer"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS/Common", "StringType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cmbplanreviewerfullname");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "cmbplanreviewerfullname"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS/Common", "StringType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cmbkeybiz");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "cmbkeybiz"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS/Common", "BooleanType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cmbriskdrate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "cmbriskdrate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS/Common", "DecimalType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("impleplannedend");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "impleplannedend"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", ">CMBChangeInstanceType>impleplannedend"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("impleplannedstart");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "impleplannedstart"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", ">CMBChangeInstanceType>impleplannedstart"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cmbchangeevaluationresult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "cmbchangeevaluationresult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS/Common", "StringType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("changeForm");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "ChangeForm"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS/Common", "StringType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CMBPlanImple");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "CMBPlanImple"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS/Common", "StringType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cmbplanimplefullname");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "cmbplanimplefullname"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS/Common", "StringType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cmbplanreviewermode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "cmbplanreviewermode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS/Common", "StringType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cmbService");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "cmb.service"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", ">CMBChangeInstanceType>cmb.service"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cmbriskdesc");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "cmbriskdesc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", ">CMBChangeInstanceType>cmbriskdesc"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("topSystem");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "TopSystem"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS/Common", "StringType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("approvalComments");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "ApprovalComments"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", ">CMBChangeInstanceType>ApprovalComments"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("attachments");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "attachments"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS/Common", "AttachmentType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS/Common", "attachment"));
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
