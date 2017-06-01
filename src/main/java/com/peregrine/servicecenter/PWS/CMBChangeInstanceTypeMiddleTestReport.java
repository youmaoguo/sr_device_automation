/**
 * CMBChangeInstanceTypeMiddleTestReport.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peregrine.servicecenter.PWS;

public class CMBChangeInstanceTypeMiddleTestReport  extends com.peregrine.servicecenter.PWS.Common.ArrayType  implements java.io.Serializable {
    private com.peregrine.servicecenter.PWS.Common.StringType[] testReport;

    public CMBChangeInstanceTypeMiddleTestReport() {
    }

    public CMBChangeInstanceTypeMiddleTestReport(
           java.lang.String type,
           com.peregrine.servicecenter.PWS.Common.StringType[] testReport) {
        super(
            type);
        this.testReport = testReport;
    }


    /**
     * Gets the testReport value for this CMBChangeInstanceTypeMiddleTestReport.
     * 
     * @return testReport
     */
    public com.peregrine.servicecenter.PWS.Common.StringType[] getTestReport() {
        return testReport;
    }


    /**
     * Sets the testReport value for this CMBChangeInstanceTypeMiddleTestReport.
     * 
     * @param testReport
     */
    public void setTestReport(com.peregrine.servicecenter.PWS.Common.StringType[] testReport) {
        this.testReport = testReport;
    }

    public com.peregrine.servicecenter.PWS.Common.StringType getTestReport(int i) {
        return this.testReport[i];
    }

    public void setTestReport(int i, com.peregrine.servicecenter.PWS.Common.StringType _value) {
        this.testReport[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CMBChangeInstanceTypeMiddleTestReport)) return false;
        CMBChangeInstanceTypeMiddleTestReport other = (CMBChangeInstanceTypeMiddleTestReport) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.testReport==null && other.getTestReport()==null) || 
             (this.testReport!=null &&
              java.util.Arrays.equals(this.testReport, other.getTestReport())));
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
        if (getTestReport() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getTestReport());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getTestReport(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CMBChangeInstanceTypeMiddleTestReport.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", ">>CMBChangeInstanceType>middle>TestReport"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("testReport");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "TestReport"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS/Common", "StringType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
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
