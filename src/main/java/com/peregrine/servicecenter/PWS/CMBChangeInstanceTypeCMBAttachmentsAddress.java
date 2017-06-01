/**
 * CMBChangeInstanceTypeCMBAttachmentsAddress.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peregrine.servicecenter.PWS;

public class CMBChangeInstanceTypeCMBAttachmentsAddress  extends com.peregrine.servicecenter.PWS.Common.ArrayType  implements java.io.Serializable {
    private com.peregrine.servicecenter.PWS.Common.StringType[] CMBAttachmentsAddress;

    public CMBChangeInstanceTypeCMBAttachmentsAddress() {
    }

    public CMBChangeInstanceTypeCMBAttachmentsAddress(
           java.lang.String type,
           com.peregrine.servicecenter.PWS.Common.StringType[] CMBAttachmentsAddress) {
        super(
            type);
        this.CMBAttachmentsAddress = CMBAttachmentsAddress;
    }


    /**
     * Gets the CMBAttachmentsAddress value for this CMBChangeInstanceTypeCMBAttachmentsAddress.
     * 
     * @return CMBAttachmentsAddress
     */
    public com.peregrine.servicecenter.PWS.Common.StringType[] getCMBAttachmentsAddress() {
        return CMBAttachmentsAddress;
    }


    /**
     * Sets the CMBAttachmentsAddress value for this CMBChangeInstanceTypeCMBAttachmentsAddress.
     * 
     * @param CMBAttachmentsAddress
     */
    public void setCMBAttachmentsAddress(com.peregrine.servicecenter.PWS.Common.StringType[] CMBAttachmentsAddress) {
        this.CMBAttachmentsAddress = CMBAttachmentsAddress;
    }

    public com.peregrine.servicecenter.PWS.Common.StringType getCMBAttachmentsAddress(int i) {
        return this.CMBAttachmentsAddress[i];
    }

    public void setCMBAttachmentsAddress(int i, com.peregrine.servicecenter.PWS.Common.StringType _value) {
        this.CMBAttachmentsAddress[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CMBChangeInstanceTypeCMBAttachmentsAddress)) return false;
        CMBChangeInstanceTypeCMBAttachmentsAddress other = (CMBChangeInstanceTypeCMBAttachmentsAddress) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.CMBAttachmentsAddress==null && other.getCMBAttachmentsAddress()==null) || 
             (this.CMBAttachmentsAddress!=null &&
              java.util.Arrays.equals(this.CMBAttachmentsAddress, other.getCMBAttachmentsAddress())));
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
        if (getCMBAttachmentsAddress() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCMBAttachmentsAddress());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCMBAttachmentsAddress(), i);
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
        new org.apache.axis.description.TypeDesc(CMBChangeInstanceTypeCMBAttachmentsAddress.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", ">CMBChangeInstanceType>CMBAttachmentsAddress"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CMBAttachmentsAddress");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "CMBAttachmentsAddress"));
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
