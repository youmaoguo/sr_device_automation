/**
 * CMBChangeInstanceTypeMiddle.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peregrine.servicecenter.PWS;

public class CMBChangeInstanceTypeMiddle  extends com.peregrine.servicecenter.PWS.Common.StructureType  implements java.io.Serializable {
    private com.peregrine.servicecenter.PWS.Common.StringType configurationItem;

    private com.peregrine.servicecenter.PWS.Common.StringType location;

    private com.peregrine.servicecenter.PWS.Common.StringType misc1;

    private com.peregrine.servicecenter.PWS.Common.StringType misc2;

    private com.peregrine.servicecenter.PWS.Common.StringType misc3;

    private com.peregrine.servicecenter.PWS.Common.StringType misc4;

    private com.peregrine.servicecenter.PWS.Common.StringType misc5;

    private com.peregrine.servicecenter.PWS.Common.StringType misc6;

    private com.peregrine.servicecenter.PWS.Common.StringType misc7;

    private com.peregrine.servicecenter.PWS.Common.StringType misc8;

    private com.peregrine.servicecenter.PWS.Common.StringType misc9;

    private com.peregrine.servicecenter.PWS.Common.StringType misc10;

    private com.peregrine.servicecenter.PWS.Common.DateTimeType outageStart;

    private com.peregrine.servicecenter.PWS.Common.DateTimeType outageEnd;

    private com.peregrine.servicecenter.PWS.Common.DateTimeType scheduledOutageStart;

    private com.peregrine.servicecenter.PWS.Common.DateTimeType scheduledOutageEnd;

    private com.peregrine.servicecenter.PWS.Common.DateTimeType actualOutageStart;

    private com.peregrine.servicecenter.PWS.Common.DateTimeType actualOutageEnd;

    private com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeMiddleMiscArray1 miscArray1;

    private com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeMiddleMiscArray2 miscArray2;

    private com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeMiddleMiscArray3 miscArray3;

    private com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeMiddleAssets assets;

    private com.peregrine.servicecenter.PWS.Common.StringType estimateDescription;

    private com.peregrine.servicecenter.PWS.Common.StringType estimatePrice;

    private com.peregrine.servicecenter.PWS.Common.StringType actualCost;

    private com.peregrine.servicecenter.PWS.Common.StringType actualPrice;

    private com.peregrine.servicecenter.PWS.Common.StringType cm3RSource;

    private com.peregrine.servicecenter.PWS.Common.BooleanType cmbDR;

    private com.peregrine.servicecenter.PWS.Common.StringType businesssubSYS;

    private com.peregrine.servicecenter.PWS.Common.StringType businessSYS;

    private com.peregrine.servicecenter.PWS.Common.StringType businessCategory;

    private com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeMiddleChangePlan changePlan;

    private com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeMiddleTestReport testReport;

    private com.peregrine.servicecenter.PWS.Common.BooleanType cmbnoticedept;

    private com.peregrine.servicecenter.PWS.Common.BooleanType cmbserviceimpact;

    private com.peregrine.servicecenter.PWS.Common.BooleanType cmbaddsystem;

    private com.peregrine.servicecenter.PWS.Common.BooleanType cmbimprovesla;

    public CMBChangeInstanceTypeMiddle() {
    }

    public CMBChangeInstanceTypeMiddle(
           java.lang.String type,
           com.peregrine.servicecenter.PWS.Common.StringType configurationItem,
           com.peregrine.servicecenter.PWS.Common.StringType location,
           com.peregrine.servicecenter.PWS.Common.StringType misc1,
           com.peregrine.servicecenter.PWS.Common.StringType misc2,
           com.peregrine.servicecenter.PWS.Common.StringType misc3,
           com.peregrine.servicecenter.PWS.Common.StringType misc4,
           com.peregrine.servicecenter.PWS.Common.StringType misc5,
           com.peregrine.servicecenter.PWS.Common.StringType misc6,
           com.peregrine.servicecenter.PWS.Common.StringType misc7,
           com.peregrine.servicecenter.PWS.Common.StringType misc8,
           com.peregrine.servicecenter.PWS.Common.StringType misc9,
           com.peregrine.servicecenter.PWS.Common.StringType misc10,
           com.peregrine.servicecenter.PWS.Common.DateTimeType outageStart,
           com.peregrine.servicecenter.PWS.Common.DateTimeType outageEnd,
           com.peregrine.servicecenter.PWS.Common.DateTimeType scheduledOutageStart,
           com.peregrine.servicecenter.PWS.Common.DateTimeType scheduledOutageEnd,
           com.peregrine.servicecenter.PWS.Common.DateTimeType actualOutageStart,
           com.peregrine.servicecenter.PWS.Common.DateTimeType actualOutageEnd,
           com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeMiddleMiscArray1 miscArray1,
           com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeMiddleMiscArray2 miscArray2,
           com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeMiddleMiscArray3 miscArray3,
           com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeMiddleAssets assets,
           com.peregrine.servicecenter.PWS.Common.StringType estimateDescription,
           com.peregrine.servicecenter.PWS.Common.StringType estimatePrice,
           com.peregrine.servicecenter.PWS.Common.StringType actualCost,
           com.peregrine.servicecenter.PWS.Common.StringType actualPrice,
           com.peregrine.servicecenter.PWS.Common.StringType cm3RSource,
           com.peregrine.servicecenter.PWS.Common.BooleanType cmbDR,
           com.peregrine.servicecenter.PWS.Common.StringType businesssubSYS,
           com.peregrine.servicecenter.PWS.Common.StringType businessSYS,
           com.peregrine.servicecenter.PWS.Common.StringType businessCategory,
           com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeMiddleChangePlan changePlan,
           com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeMiddleTestReport testReport,
           com.peregrine.servicecenter.PWS.Common.BooleanType cmbnoticedept,
           com.peregrine.servicecenter.PWS.Common.BooleanType cmbserviceimpact,
           com.peregrine.servicecenter.PWS.Common.BooleanType cmbaddsystem,
           com.peregrine.servicecenter.PWS.Common.BooleanType cmbimprovesla) {
        super(
            type);
        this.configurationItem = configurationItem;
        this.location = location;
        this.misc1 = misc1;
        this.misc2 = misc2;
        this.misc3 = misc3;
        this.misc4 = misc4;
        this.misc5 = misc5;
        this.misc6 = misc6;
        this.misc7 = misc7;
        this.misc8 = misc8;
        this.misc9 = misc9;
        this.misc10 = misc10;
        this.outageStart = outageStart;
        this.outageEnd = outageEnd;
        this.scheduledOutageStart = scheduledOutageStart;
        this.scheduledOutageEnd = scheduledOutageEnd;
        this.actualOutageStart = actualOutageStart;
        this.actualOutageEnd = actualOutageEnd;
        this.miscArray1 = miscArray1;
        this.miscArray2 = miscArray2;
        this.miscArray3 = miscArray3;
        this.assets = assets;
        this.estimateDescription = estimateDescription;
        this.estimatePrice = estimatePrice;
        this.actualCost = actualCost;
        this.actualPrice = actualPrice;
        this.cm3RSource = cm3RSource;
        this.cmbDR = cmbDR;
        this.businesssubSYS = businesssubSYS;
        this.businessSYS = businessSYS;
        this.businessCategory = businessCategory;
        this.changePlan = changePlan;
        this.testReport = testReport;
        this.cmbnoticedept = cmbnoticedept;
        this.cmbserviceimpact = cmbserviceimpact;
        this.cmbaddsystem = cmbaddsystem;
        this.cmbimprovesla = cmbimprovesla;
    }


    /**
     * Gets the configurationItem value for this CMBChangeInstanceTypeMiddle.
     * 
     * @return configurationItem
     */
    public com.peregrine.servicecenter.PWS.Common.StringType getConfigurationItem() {
        return configurationItem;
    }


    /**
     * Sets the configurationItem value for this CMBChangeInstanceTypeMiddle.
     * 
     * @param configurationItem
     */
    public void setConfigurationItem(com.peregrine.servicecenter.PWS.Common.StringType configurationItem) {
        this.configurationItem = configurationItem;
    }


    /**
     * Gets the location value for this CMBChangeInstanceTypeMiddle.
     * 
     * @return location
     */
    public com.peregrine.servicecenter.PWS.Common.StringType getLocation() {
        return location;
    }


    /**
     * Sets the location value for this CMBChangeInstanceTypeMiddle.
     * 
     * @param location
     */
    public void setLocation(com.peregrine.servicecenter.PWS.Common.StringType location) {
        this.location = location;
    }


    /**
     * Gets the misc1 value for this CMBChangeInstanceTypeMiddle.
     * 
     * @return misc1
     */
    public com.peregrine.servicecenter.PWS.Common.StringType getMisc1() {
        return misc1;
    }


    /**
     * Sets the misc1 value for this CMBChangeInstanceTypeMiddle.
     * 
     * @param misc1
     */
    public void setMisc1(com.peregrine.servicecenter.PWS.Common.StringType misc1) {
        this.misc1 = misc1;
    }


    /**
     * Gets the misc2 value for this CMBChangeInstanceTypeMiddle.
     * 
     * @return misc2
     */
    public com.peregrine.servicecenter.PWS.Common.StringType getMisc2() {
        return misc2;
    }


    /**
     * Sets the misc2 value for this CMBChangeInstanceTypeMiddle.
     * 
     * @param misc2
     */
    public void setMisc2(com.peregrine.servicecenter.PWS.Common.StringType misc2) {
        this.misc2 = misc2;
    }


    /**
     * Gets the misc3 value for this CMBChangeInstanceTypeMiddle.
     * 
     * @return misc3
     */
    public com.peregrine.servicecenter.PWS.Common.StringType getMisc3() {
        return misc3;
    }


    /**
     * Sets the misc3 value for this CMBChangeInstanceTypeMiddle.
     * 
     * @param misc3
     */
    public void setMisc3(com.peregrine.servicecenter.PWS.Common.StringType misc3) {
        this.misc3 = misc3;
    }


    /**
     * Gets the misc4 value for this CMBChangeInstanceTypeMiddle.
     * 
     * @return misc4
     */
    public com.peregrine.servicecenter.PWS.Common.StringType getMisc4() {
        return misc4;
    }


    /**
     * Sets the misc4 value for this CMBChangeInstanceTypeMiddle.
     * 
     * @param misc4
     */
    public void setMisc4(com.peregrine.servicecenter.PWS.Common.StringType misc4) {
        this.misc4 = misc4;
    }


    /**
     * Gets the misc5 value for this CMBChangeInstanceTypeMiddle.
     * 
     * @return misc5
     */
    public com.peregrine.servicecenter.PWS.Common.StringType getMisc5() {
        return misc5;
    }


    /**
     * Sets the misc5 value for this CMBChangeInstanceTypeMiddle.
     * 
     * @param misc5
     */
    public void setMisc5(com.peregrine.servicecenter.PWS.Common.StringType misc5) {
        this.misc5 = misc5;
    }


    /**
     * Gets the misc6 value for this CMBChangeInstanceTypeMiddle.
     * 
     * @return misc6
     */
    public com.peregrine.servicecenter.PWS.Common.StringType getMisc6() {
        return misc6;
    }


    /**
     * Sets the misc6 value for this CMBChangeInstanceTypeMiddle.
     * 
     * @param misc6
     */
    public void setMisc6(com.peregrine.servicecenter.PWS.Common.StringType misc6) {
        this.misc6 = misc6;
    }


    /**
     * Gets the misc7 value for this CMBChangeInstanceTypeMiddle.
     * 
     * @return misc7
     */
    public com.peregrine.servicecenter.PWS.Common.StringType getMisc7() {
        return misc7;
    }


    /**
     * Sets the misc7 value for this CMBChangeInstanceTypeMiddle.
     * 
     * @param misc7
     */
    public void setMisc7(com.peregrine.servicecenter.PWS.Common.StringType misc7) {
        this.misc7 = misc7;
    }


    /**
     * Gets the misc8 value for this CMBChangeInstanceTypeMiddle.
     * 
     * @return misc8
     */
    public com.peregrine.servicecenter.PWS.Common.StringType getMisc8() {
        return misc8;
    }


    /**
     * Sets the misc8 value for this CMBChangeInstanceTypeMiddle.
     * 
     * @param misc8
     */
    public void setMisc8(com.peregrine.servicecenter.PWS.Common.StringType misc8) {
        this.misc8 = misc8;
    }


    /**
     * Gets the misc9 value for this CMBChangeInstanceTypeMiddle.
     * 
     * @return misc9
     */
    public com.peregrine.servicecenter.PWS.Common.StringType getMisc9() {
        return misc9;
    }


    /**
     * Sets the misc9 value for this CMBChangeInstanceTypeMiddle.
     * 
     * @param misc9
     */
    public void setMisc9(com.peregrine.servicecenter.PWS.Common.StringType misc9) {
        this.misc9 = misc9;
    }


    /**
     * Gets the misc10 value for this CMBChangeInstanceTypeMiddle.
     * 
     * @return misc10
     */
    public com.peregrine.servicecenter.PWS.Common.StringType getMisc10() {
        return misc10;
    }


    /**
     * Sets the misc10 value for this CMBChangeInstanceTypeMiddle.
     * 
     * @param misc10
     */
    public void setMisc10(com.peregrine.servicecenter.PWS.Common.StringType misc10) {
        this.misc10 = misc10;
    }


    /**
     * Gets the outageStart value for this CMBChangeInstanceTypeMiddle.
     * 
     * @return outageStart
     */
    public com.peregrine.servicecenter.PWS.Common.DateTimeType getOutageStart() {
        return outageStart;
    }


    /**
     * Sets the outageStart value for this CMBChangeInstanceTypeMiddle.
     * 
     * @param outageStart
     */
    public void setOutageStart(com.peregrine.servicecenter.PWS.Common.DateTimeType outageStart) {
        this.outageStart = outageStart;
    }


    /**
     * Gets the outageEnd value for this CMBChangeInstanceTypeMiddle.
     * 
     * @return outageEnd
     */
    public com.peregrine.servicecenter.PWS.Common.DateTimeType getOutageEnd() {
        return outageEnd;
    }


    /**
     * Sets the outageEnd value for this CMBChangeInstanceTypeMiddle.
     * 
     * @param outageEnd
     */
    public void setOutageEnd(com.peregrine.servicecenter.PWS.Common.DateTimeType outageEnd) {
        this.outageEnd = outageEnd;
    }


    /**
     * Gets the scheduledOutageStart value for this CMBChangeInstanceTypeMiddle.
     * 
     * @return scheduledOutageStart
     */
    public com.peregrine.servicecenter.PWS.Common.DateTimeType getScheduledOutageStart() {
        return scheduledOutageStart;
    }


    /**
     * Sets the scheduledOutageStart value for this CMBChangeInstanceTypeMiddle.
     * 
     * @param scheduledOutageStart
     */
    public void setScheduledOutageStart(com.peregrine.servicecenter.PWS.Common.DateTimeType scheduledOutageStart) {
        this.scheduledOutageStart = scheduledOutageStart;
    }


    /**
     * Gets the scheduledOutageEnd value for this CMBChangeInstanceTypeMiddle.
     * 
     * @return scheduledOutageEnd
     */
    public com.peregrine.servicecenter.PWS.Common.DateTimeType getScheduledOutageEnd() {
        return scheduledOutageEnd;
    }


    /**
     * Sets the scheduledOutageEnd value for this CMBChangeInstanceTypeMiddle.
     * 
     * @param scheduledOutageEnd
     */
    public void setScheduledOutageEnd(com.peregrine.servicecenter.PWS.Common.DateTimeType scheduledOutageEnd) {
        this.scheduledOutageEnd = scheduledOutageEnd;
    }


    /**
     * Gets the actualOutageStart value for this CMBChangeInstanceTypeMiddle.
     * 
     * @return actualOutageStart
     */
    public com.peregrine.servicecenter.PWS.Common.DateTimeType getActualOutageStart() {
        return actualOutageStart;
    }


    /**
     * Sets the actualOutageStart value for this CMBChangeInstanceTypeMiddle.
     * 
     * @param actualOutageStart
     */
    public void setActualOutageStart(com.peregrine.servicecenter.PWS.Common.DateTimeType actualOutageStart) {
        this.actualOutageStart = actualOutageStart;
    }


    /**
     * Gets the actualOutageEnd value for this CMBChangeInstanceTypeMiddle.
     * 
     * @return actualOutageEnd
     */
    public com.peregrine.servicecenter.PWS.Common.DateTimeType getActualOutageEnd() {
        return actualOutageEnd;
    }


    /**
     * Sets the actualOutageEnd value for this CMBChangeInstanceTypeMiddle.
     * 
     * @param actualOutageEnd
     */
    public void setActualOutageEnd(com.peregrine.servicecenter.PWS.Common.DateTimeType actualOutageEnd) {
        this.actualOutageEnd = actualOutageEnd;
    }


    /**
     * Gets the miscArray1 value for this CMBChangeInstanceTypeMiddle.
     * 
     * @return miscArray1
     */
    public com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeMiddleMiscArray1 getMiscArray1() {
        return miscArray1;
    }


    /**
     * Sets the miscArray1 value for this CMBChangeInstanceTypeMiddle.
     * 
     * @param miscArray1
     */
    public void setMiscArray1(com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeMiddleMiscArray1 miscArray1) {
        this.miscArray1 = miscArray1;
    }


    /**
     * Gets the miscArray2 value for this CMBChangeInstanceTypeMiddle.
     * 
     * @return miscArray2
     */
    public com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeMiddleMiscArray2 getMiscArray2() {
        return miscArray2;
    }


    /**
     * Sets the miscArray2 value for this CMBChangeInstanceTypeMiddle.
     * 
     * @param miscArray2
     */
    public void setMiscArray2(com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeMiddleMiscArray2 miscArray2) {
        this.miscArray2 = miscArray2;
    }


    /**
     * Gets the miscArray3 value for this CMBChangeInstanceTypeMiddle.
     * 
     * @return miscArray3
     */
    public com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeMiddleMiscArray3 getMiscArray3() {
        return miscArray3;
    }


    /**
     * Sets the miscArray3 value for this CMBChangeInstanceTypeMiddle.
     * 
     * @param miscArray3
     */
    public void setMiscArray3(com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeMiddleMiscArray3 miscArray3) {
        this.miscArray3 = miscArray3;
    }


    /**
     * Gets the assets value for this CMBChangeInstanceTypeMiddle.
     * 
     * @return assets
     */
    public com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeMiddleAssets getAssets() {
        return assets;
    }


    /**
     * Sets the assets value for this CMBChangeInstanceTypeMiddle.
     * 
     * @param assets
     */
    public void setAssets(com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeMiddleAssets assets) {
        this.assets = assets;
    }


    /**
     * Gets the estimateDescription value for this CMBChangeInstanceTypeMiddle.
     * 
     * @return estimateDescription
     */
    public com.peregrine.servicecenter.PWS.Common.StringType getEstimateDescription() {
        return estimateDescription;
    }


    /**
     * Sets the estimateDescription value for this CMBChangeInstanceTypeMiddle.
     * 
     * @param estimateDescription
     */
    public void setEstimateDescription(com.peregrine.servicecenter.PWS.Common.StringType estimateDescription) {
        this.estimateDescription = estimateDescription;
    }


    /**
     * Gets the estimatePrice value for this CMBChangeInstanceTypeMiddle.
     * 
     * @return estimatePrice
     */
    public com.peregrine.servicecenter.PWS.Common.StringType getEstimatePrice() {
        return estimatePrice;
    }


    /**
     * Sets the estimatePrice value for this CMBChangeInstanceTypeMiddle.
     * 
     * @param estimatePrice
     */
    public void setEstimatePrice(com.peregrine.servicecenter.PWS.Common.StringType estimatePrice) {
        this.estimatePrice = estimatePrice;
    }


    /**
     * Gets the actualCost value for this CMBChangeInstanceTypeMiddle.
     * 
     * @return actualCost
     */
    public com.peregrine.servicecenter.PWS.Common.StringType getActualCost() {
        return actualCost;
    }


    /**
     * Sets the actualCost value for this CMBChangeInstanceTypeMiddle.
     * 
     * @param actualCost
     */
    public void setActualCost(com.peregrine.servicecenter.PWS.Common.StringType actualCost) {
        this.actualCost = actualCost;
    }


    /**
     * Gets the actualPrice value for this CMBChangeInstanceTypeMiddle.
     * 
     * @return actualPrice
     */
    public com.peregrine.servicecenter.PWS.Common.StringType getActualPrice() {
        return actualPrice;
    }


    /**
     * Sets the actualPrice value for this CMBChangeInstanceTypeMiddle.
     * 
     * @param actualPrice
     */
    public void setActualPrice(com.peregrine.servicecenter.PWS.Common.StringType actualPrice) {
        this.actualPrice = actualPrice;
    }


    /**
     * Gets the cm3RSource value for this CMBChangeInstanceTypeMiddle.
     * 
     * @return cm3RSource
     */
    public com.peregrine.servicecenter.PWS.Common.StringType getCm3RSource() {
        return cm3RSource;
    }


    /**
     * Sets the cm3RSource value for this CMBChangeInstanceTypeMiddle.
     * 
     * @param cm3RSource
     */
    public void setCm3RSource(com.peregrine.servicecenter.PWS.Common.StringType cm3RSource) {
        this.cm3RSource = cm3RSource;
    }


    /**
     * Gets the cmbDR value for this CMBChangeInstanceTypeMiddle.
     * 
     * @return cmbDR
     */
    public com.peregrine.servicecenter.PWS.Common.BooleanType getCmbDR() {
        return cmbDR;
    }


    /**
     * Sets the cmbDR value for this CMBChangeInstanceTypeMiddle.
     * 
     * @param cmbDR
     */
    public void setCmbDR(com.peregrine.servicecenter.PWS.Common.BooleanType cmbDR) {
        this.cmbDR = cmbDR;
    }


    /**
     * Gets the businesssubSYS value for this CMBChangeInstanceTypeMiddle.
     * 
     * @return businesssubSYS
     */
    public com.peregrine.servicecenter.PWS.Common.StringType getBusinesssubSYS() {
        return businesssubSYS;
    }


    /**
     * Sets the businesssubSYS value for this CMBChangeInstanceTypeMiddle.
     * 
     * @param businesssubSYS
     */
    public void setBusinesssubSYS(com.peregrine.servicecenter.PWS.Common.StringType businesssubSYS) {
        this.businesssubSYS = businesssubSYS;
    }


    /**
     * Gets the businessSYS value for this CMBChangeInstanceTypeMiddle.
     * 
     * @return businessSYS
     */
    public com.peregrine.servicecenter.PWS.Common.StringType getBusinessSYS() {
        return businessSYS;
    }


    /**
     * Sets the businessSYS value for this CMBChangeInstanceTypeMiddle.
     * 
     * @param businessSYS
     */
    public void setBusinessSYS(com.peregrine.servicecenter.PWS.Common.StringType businessSYS) {
        this.businessSYS = businessSYS;
    }


    /**
     * Gets the businessCategory value for this CMBChangeInstanceTypeMiddle.
     * 
     * @return businessCategory
     */
    public com.peregrine.servicecenter.PWS.Common.StringType getBusinessCategory() {
        return businessCategory;
    }


    /**
     * Sets the businessCategory value for this CMBChangeInstanceTypeMiddle.
     * 
     * @param businessCategory
     */
    public void setBusinessCategory(com.peregrine.servicecenter.PWS.Common.StringType businessCategory) {
        this.businessCategory = businessCategory;
    }


    /**
     * Gets the changePlan value for this CMBChangeInstanceTypeMiddle.
     * 
     * @return changePlan
     */
    public com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeMiddleChangePlan getChangePlan() {
        return changePlan;
    }


    /**
     * Sets the changePlan value for this CMBChangeInstanceTypeMiddle.
     * 
     * @param changePlan
     */
    public void setChangePlan(com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeMiddleChangePlan changePlan) {
        this.changePlan = changePlan;
    }


    /**
     * Gets the testReport value for this CMBChangeInstanceTypeMiddle.
     * 
     * @return testReport
     */
    public com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeMiddleTestReport getTestReport() {
        return testReport;
    }


    /**
     * Sets the testReport value for this CMBChangeInstanceTypeMiddle.
     * 
     * @param testReport
     */
    public void setTestReport(com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeMiddleTestReport testReport) {
        this.testReport = testReport;
    }


    /**
     * Gets the cmbnoticedept value for this CMBChangeInstanceTypeMiddle.
     * 
     * @return cmbnoticedept
     */
    public com.peregrine.servicecenter.PWS.Common.BooleanType getCmbnoticedept() {
        return cmbnoticedept;
    }


    /**
     * Sets the cmbnoticedept value for this CMBChangeInstanceTypeMiddle.
     * 
     * @param cmbnoticedept
     */
    public void setCmbnoticedept(com.peregrine.servicecenter.PWS.Common.BooleanType cmbnoticedept) {
        this.cmbnoticedept = cmbnoticedept;
    }


    /**
     * Gets the cmbserviceimpact value for this CMBChangeInstanceTypeMiddle.
     * 
     * @return cmbserviceimpact
     */
    public com.peregrine.servicecenter.PWS.Common.BooleanType getCmbserviceimpact() {
        return cmbserviceimpact;
    }


    /**
     * Sets the cmbserviceimpact value for this CMBChangeInstanceTypeMiddle.
     * 
     * @param cmbserviceimpact
     */
    public void setCmbserviceimpact(com.peregrine.servicecenter.PWS.Common.BooleanType cmbserviceimpact) {
        this.cmbserviceimpact = cmbserviceimpact;
    }


    /**
     * Gets the cmbaddsystem value for this CMBChangeInstanceTypeMiddle.
     * 
     * @return cmbaddsystem
     */
    public com.peregrine.servicecenter.PWS.Common.BooleanType getCmbaddsystem() {
        return cmbaddsystem;
    }


    /**
     * Sets the cmbaddsystem value for this CMBChangeInstanceTypeMiddle.
     * 
     * @param cmbaddsystem
     */
    public void setCmbaddsystem(com.peregrine.servicecenter.PWS.Common.BooleanType cmbaddsystem) {
        this.cmbaddsystem = cmbaddsystem;
    }


    /**
     * Gets the cmbimprovesla value for this CMBChangeInstanceTypeMiddle.
     * 
     * @return cmbimprovesla
     */
    public com.peregrine.servicecenter.PWS.Common.BooleanType getCmbimprovesla() {
        return cmbimprovesla;
    }


    /**
     * Sets the cmbimprovesla value for this CMBChangeInstanceTypeMiddle.
     * 
     * @param cmbimprovesla
     */
    public void setCmbimprovesla(com.peregrine.servicecenter.PWS.Common.BooleanType cmbimprovesla) {
        this.cmbimprovesla = cmbimprovesla;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CMBChangeInstanceTypeMiddle)) return false;
        CMBChangeInstanceTypeMiddle other = (CMBChangeInstanceTypeMiddle) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.configurationItem==null && other.getConfigurationItem()==null) || 
             (this.configurationItem!=null &&
              this.configurationItem.equals(other.getConfigurationItem()))) &&
            ((this.location==null && other.getLocation()==null) || 
             (this.location!=null &&
              this.location.equals(other.getLocation()))) &&
            ((this.misc1==null && other.getMisc1()==null) || 
             (this.misc1!=null &&
              this.misc1.equals(other.getMisc1()))) &&
            ((this.misc2==null && other.getMisc2()==null) || 
             (this.misc2!=null &&
              this.misc2.equals(other.getMisc2()))) &&
            ((this.misc3==null && other.getMisc3()==null) || 
             (this.misc3!=null &&
              this.misc3.equals(other.getMisc3()))) &&
            ((this.misc4==null && other.getMisc4()==null) || 
             (this.misc4!=null &&
              this.misc4.equals(other.getMisc4()))) &&
            ((this.misc5==null && other.getMisc5()==null) || 
             (this.misc5!=null &&
              this.misc5.equals(other.getMisc5()))) &&
            ((this.misc6==null && other.getMisc6()==null) || 
             (this.misc6!=null &&
              this.misc6.equals(other.getMisc6()))) &&
            ((this.misc7==null && other.getMisc7()==null) || 
             (this.misc7!=null &&
              this.misc7.equals(other.getMisc7()))) &&
            ((this.misc8==null && other.getMisc8()==null) || 
             (this.misc8!=null &&
              this.misc8.equals(other.getMisc8()))) &&
            ((this.misc9==null && other.getMisc9()==null) || 
             (this.misc9!=null &&
              this.misc9.equals(other.getMisc9()))) &&
            ((this.misc10==null && other.getMisc10()==null) || 
             (this.misc10!=null &&
              this.misc10.equals(other.getMisc10()))) &&
            ((this.outageStart==null && other.getOutageStart()==null) || 
             (this.outageStart!=null &&
              this.outageStart.equals(other.getOutageStart()))) &&
            ((this.outageEnd==null && other.getOutageEnd()==null) || 
             (this.outageEnd!=null &&
              this.outageEnd.equals(other.getOutageEnd()))) &&
            ((this.scheduledOutageStart==null && other.getScheduledOutageStart()==null) || 
             (this.scheduledOutageStart!=null &&
              this.scheduledOutageStart.equals(other.getScheduledOutageStart()))) &&
            ((this.scheduledOutageEnd==null && other.getScheduledOutageEnd()==null) || 
             (this.scheduledOutageEnd!=null &&
              this.scheduledOutageEnd.equals(other.getScheduledOutageEnd()))) &&
            ((this.actualOutageStart==null && other.getActualOutageStart()==null) || 
             (this.actualOutageStart!=null &&
              this.actualOutageStart.equals(other.getActualOutageStart()))) &&
            ((this.actualOutageEnd==null && other.getActualOutageEnd()==null) || 
             (this.actualOutageEnd!=null &&
              this.actualOutageEnd.equals(other.getActualOutageEnd()))) &&
            ((this.miscArray1==null && other.getMiscArray1()==null) || 
             (this.miscArray1!=null &&
              this.miscArray1.equals(other.getMiscArray1()))) &&
            ((this.miscArray2==null && other.getMiscArray2()==null) || 
             (this.miscArray2!=null &&
              this.miscArray2.equals(other.getMiscArray2()))) &&
            ((this.miscArray3==null && other.getMiscArray3()==null) || 
             (this.miscArray3!=null &&
              this.miscArray3.equals(other.getMiscArray3()))) &&
            ((this.assets==null && other.getAssets()==null) || 
             (this.assets!=null &&
              this.assets.equals(other.getAssets()))) &&
            ((this.estimateDescription==null && other.getEstimateDescription()==null) || 
             (this.estimateDescription!=null &&
              this.estimateDescription.equals(other.getEstimateDescription()))) &&
            ((this.estimatePrice==null && other.getEstimatePrice()==null) || 
             (this.estimatePrice!=null &&
              this.estimatePrice.equals(other.getEstimatePrice()))) &&
            ((this.actualCost==null && other.getActualCost()==null) || 
             (this.actualCost!=null &&
              this.actualCost.equals(other.getActualCost()))) &&
            ((this.actualPrice==null && other.getActualPrice()==null) || 
             (this.actualPrice!=null &&
              this.actualPrice.equals(other.getActualPrice()))) &&
            ((this.cm3RSource==null && other.getCm3RSource()==null) || 
             (this.cm3RSource!=null &&
              this.cm3RSource.equals(other.getCm3RSource()))) &&
            ((this.cmbDR==null && other.getCmbDR()==null) || 
             (this.cmbDR!=null &&
              this.cmbDR.equals(other.getCmbDR()))) &&
            ((this.businesssubSYS==null && other.getBusinesssubSYS()==null) || 
             (this.businesssubSYS!=null &&
              this.businesssubSYS.equals(other.getBusinesssubSYS()))) &&
            ((this.businessSYS==null && other.getBusinessSYS()==null) || 
             (this.businessSYS!=null &&
              this.businessSYS.equals(other.getBusinessSYS()))) &&
            ((this.businessCategory==null && other.getBusinessCategory()==null) || 
             (this.businessCategory!=null &&
              this.businessCategory.equals(other.getBusinessCategory()))) &&
            ((this.changePlan==null && other.getChangePlan()==null) || 
             (this.changePlan!=null &&
              this.changePlan.equals(other.getChangePlan()))) &&
            ((this.testReport==null && other.getTestReport()==null) || 
             (this.testReport!=null &&
              this.testReport.equals(other.getTestReport()))) &&
            ((this.cmbnoticedept==null && other.getCmbnoticedept()==null) || 
             (this.cmbnoticedept!=null &&
              this.cmbnoticedept.equals(other.getCmbnoticedept()))) &&
            ((this.cmbserviceimpact==null && other.getCmbserviceimpact()==null) || 
             (this.cmbserviceimpact!=null &&
              this.cmbserviceimpact.equals(other.getCmbserviceimpact()))) &&
            ((this.cmbaddsystem==null && other.getCmbaddsystem()==null) || 
             (this.cmbaddsystem!=null &&
              this.cmbaddsystem.equals(other.getCmbaddsystem()))) &&
            ((this.cmbimprovesla==null && other.getCmbimprovesla()==null) || 
             (this.cmbimprovesla!=null &&
              this.cmbimprovesla.equals(other.getCmbimprovesla())));
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
        if (getConfigurationItem() != null) {
            _hashCode += getConfigurationItem().hashCode();
        }
        if (getLocation() != null) {
            _hashCode += getLocation().hashCode();
        }
        if (getMisc1() != null) {
            _hashCode += getMisc1().hashCode();
        }
        if (getMisc2() != null) {
            _hashCode += getMisc2().hashCode();
        }
        if (getMisc3() != null) {
            _hashCode += getMisc3().hashCode();
        }
        if (getMisc4() != null) {
            _hashCode += getMisc4().hashCode();
        }
        if (getMisc5() != null) {
            _hashCode += getMisc5().hashCode();
        }
        if (getMisc6() != null) {
            _hashCode += getMisc6().hashCode();
        }
        if (getMisc7() != null) {
            _hashCode += getMisc7().hashCode();
        }
        if (getMisc8() != null) {
            _hashCode += getMisc8().hashCode();
        }
        if (getMisc9() != null) {
            _hashCode += getMisc9().hashCode();
        }
        if (getMisc10() != null) {
            _hashCode += getMisc10().hashCode();
        }
        if (getOutageStart() != null) {
            _hashCode += getOutageStart().hashCode();
        }
        if (getOutageEnd() != null) {
            _hashCode += getOutageEnd().hashCode();
        }
        if (getScheduledOutageStart() != null) {
            _hashCode += getScheduledOutageStart().hashCode();
        }
        if (getScheduledOutageEnd() != null) {
            _hashCode += getScheduledOutageEnd().hashCode();
        }
        if (getActualOutageStart() != null) {
            _hashCode += getActualOutageStart().hashCode();
        }
        if (getActualOutageEnd() != null) {
            _hashCode += getActualOutageEnd().hashCode();
        }
        if (getMiscArray1() != null) {
            _hashCode += getMiscArray1().hashCode();
        }
        if (getMiscArray2() != null) {
            _hashCode += getMiscArray2().hashCode();
        }
        if (getMiscArray3() != null) {
            _hashCode += getMiscArray3().hashCode();
        }
        if (getAssets() != null) {
            _hashCode += getAssets().hashCode();
        }
        if (getEstimateDescription() != null) {
            _hashCode += getEstimateDescription().hashCode();
        }
        if (getEstimatePrice() != null) {
            _hashCode += getEstimatePrice().hashCode();
        }
        if (getActualCost() != null) {
            _hashCode += getActualCost().hashCode();
        }
        if (getActualPrice() != null) {
            _hashCode += getActualPrice().hashCode();
        }
        if (getCm3RSource() != null) {
            _hashCode += getCm3RSource().hashCode();
        }
        if (getCmbDR() != null) {
            _hashCode += getCmbDR().hashCode();
        }
        if (getBusinesssubSYS() != null) {
            _hashCode += getBusinesssubSYS().hashCode();
        }
        if (getBusinessSYS() != null) {
            _hashCode += getBusinessSYS().hashCode();
        }
        if (getBusinessCategory() != null) {
            _hashCode += getBusinessCategory().hashCode();
        }
        if (getChangePlan() != null) {
            _hashCode += getChangePlan().hashCode();
        }
        if (getTestReport() != null) {
            _hashCode += getTestReport().hashCode();
        }
        if (getCmbnoticedept() != null) {
            _hashCode += getCmbnoticedept().hashCode();
        }
        if (getCmbserviceimpact() != null) {
            _hashCode += getCmbserviceimpact().hashCode();
        }
        if (getCmbaddsystem() != null) {
            _hashCode += getCmbaddsystem().hashCode();
        }
        if (getCmbimprovesla() != null) {
            _hashCode += getCmbimprovesla().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CMBChangeInstanceTypeMiddle.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", ">CMBChangeInstanceType>middle"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("configurationItem");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "ConfigurationItem"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS/Common", "StringType"));
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
        elemField.setFieldName("misc1");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "Misc1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS/Common", "StringType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("misc2");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "Misc2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS/Common", "StringType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("misc3");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "Misc3"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS/Common", "StringType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("misc4");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "Misc4"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS/Common", "StringType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("misc5");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "Misc5"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS/Common", "StringType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("misc6");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "Misc6"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS/Common", "StringType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("misc7");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "Misc7"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS/Common", "StringType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("misc8");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "Misc8"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS/Common", "StringType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("misc9");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "Misc9"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS/Common", "StringType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("misc10");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "Misc10"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS/Common", "StringType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("outageStart");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "OutageStart"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS/Common", "DateTimeType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("outageEnd");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "OutageEnd"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS/Common", "DateTimeType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("scheduledOutageStart");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "ScheduledOutageStart"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS/Common", "DateTimeType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("scheduledOutageEnd");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "ScheduledOutageEnd"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS/Common", "DateTimeType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("actualOutageStart");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "ActualOutageStart"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS/Common", "DateTimeType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("actualOutageEnd");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "ActualOutageEnd"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS/Common", "DateTimeType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("miscArray1");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "MiscArray1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", ">>CMBChangeInstanceType>middle>MiscArray1"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("miscArray2");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "MiscArray2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", ">>CMBChangeInstanceType>middle>MiscArray2"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("miscArray3");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "MiscArray3"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", ">>CMBChangeInstanceType>middle>MiscArray3"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("assets");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "Assets"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", ">>CMBChangeInstanceType>middle>Assets"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("estimateDescription");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "EstimateDescription"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS/Common", "StringType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("estimatePrice");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "EstimatePrice"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS/Common", "StringType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("actualCost");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "ActualCost"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS/Common", "StringType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("actualPrice");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "ActualPrice"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS/Common", "StringType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cm3RSource");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "Cm3rSource"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS/Common", "StringType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cmbDR");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "cmbDR"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS/Common", "BooleanType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("businesssubSYS");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "BusinesssubSYS"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS/Common", "StringType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("businessSYS");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "BusinessSYS"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS/Common", "StringType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("businessCategory");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "BusinessCategory"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS/Common", "StringType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("changePlan");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "ChangePlan"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", ">>CMBChangeInstanceType>middle>ChangePlan"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("testReport");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "TestReport"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", ">>CMBChangeInstanceType>middle>TestReport"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cmbnoticedept");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "cmbnoticedept"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS/Common", "BooleanType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cmbserviceimpact");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "cmbserviceimpact"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS/Common", "BooleanType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cmbaddsystem");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "cmbaddsystem"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS/Common", "BooleanType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cmbimprovesla");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "cmbimprovesla"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS/Common", "BooleanType"));
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
