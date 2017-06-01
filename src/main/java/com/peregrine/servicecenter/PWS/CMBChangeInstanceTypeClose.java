/**
 * CMBChangeInstanceTypeClose.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peregrine.servicecenter.PWS;

public class CMBChangeInstanceTypeClose  extends com.peregrine.servicecenter.PWS.Common.StructureType  implements java.io.Serializable {
    private com.peregrine.servicecenter.PWS.Common.DecimalType completionCode;

    private com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeCloseClosingComments closingComments;

    public CMBChangeInstanceTypeClose() {
    }

    public CMBChangeInstanceTypeClose(
           java.lang.String type,
           com.peregrine.servicecenter.PWS.Common.DecimalType completionCode,
           com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeCloseClosingComments closingComments) {
        super(
            type);
        this.completionCode = completionCode;
        this.closingComments = closingComments;
    }


    /**
     * Gets the completionCode value for this CMBChangeInstanceTypeClose.
     * 
     * @return completionCode
     */
    public com.peregrine.servicecenter.PWS.Common.DecimalType getCompletionCode() {
        return completionCode;
    }


    /**
     * Sets the completionCode value for this CMBChangeInstanceTypeClose.
     * 
     * @param completionCode
     */
    public void setCompletionCode(com.peregrine.servicecenter.PWS.Common.DecimalType completionCode) {
        this.completionCode = completionCode;
    }


    /**
     * Gets the closingComments value for this CMBChangeInstanceTypeClose.
     * 
     * @return closingComments
     */
    public com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeCloseClosingComments getClosingComments() {
        return closingComments;
    }


    /**
     * Sets the closingComments value for this CMBChangeInstanceTypeClose.
     * 
     * @param closingComments
     */
    public void setClosingComments(com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeCloseClosingComments closingComments) {
        this.closingComments = closingComments;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CMBChangeInstanceTypeClose)) return false;
        CMBChangeInstanceTypeClose other = (CMBChangeInstanceTypeClose) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.completionCode==null && other.getCompletionCode()==null) || 
             (this.completionCode!=null &&
              this.completionCode.equals(other.getCompletionCode()))) &&
            ((this.closingComments==null && other.getClosingComments()==null) || 
             (this.closingComments!=null &&
              this.closingComments.equals(other.getClosingComments())));
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
        if (getCompletionCode() != null) {
            _hashCode += getCompletionCode().hashCode();
        }
        if (getClosingComments() != null) {
            _hashCode += getClosingComments().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CMBChangeInstanceTypeClose.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", ">CMBChangeInstanceType>close"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("completionCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "CompletionCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS/Common", "DecimalType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("closingComments");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "ClosingComments"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", ">>CMBChangeInstanceType>close>ClosingComments"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
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
