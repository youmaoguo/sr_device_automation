/**
 * CMBChangeInstanceTypeCloseClosingComments.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peregrine.servicecenter.PWS;

public class CMBChangeInstanceTypeCloseClosingComments  extends com.peregrine.servicecenter.PWS.Common.ArrayType  implements java.io.Serializable {
    private com.peregrine.servicecenter.PWS.Common.StringType[] closingComments;

    public CMBChangeInstanceTypeCloseClosingComments() {
    }

    public CMBChangeInstanceTypeCloseClosingComments(
           java.lang.String type,
           com.peregrine.servicecenter.PWS.Common.StringType[] closingComments) {
        super(
            type);
        this.closingComments = closingComments;
    }


    /**
     * Gets the closingComments value for this CMBChangeInstanceTypeCloseClosingComments.
     * 
     * @return closingComments
     */
    public com.peregrine.servicecenter.PWS.Common.StringType[] getClosingComments() {
        return closingComments;
    }


    /**
     * Sets the closingComments value for this CMBChangeInstanceTypeCloseClosingComments.
     * 
     * @param closingComments
     */
    public void setClosingComments(com.peregrine.servicecenter.PWS.Common.StringType[] closingComments) {
        this.closingComments = closingComments;
    }

    public com.peregrine.servicecenter.PWS.Common.StringType getClosingComments(int i) {
        return this.closingComments[i];
    }

    public void setClosingComments(int i, com.peregrine.servicecenter.PWS.Common.StringType _value) {
        this.closingComments[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CMBChangeInstanceTypeCloseClosingComments)) return false;
        CMBChangeInstanceTypeCloseClosingComments other = (CMBChangeInstanceTypeCloseClosingComments) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.closingComments==null && other.getClosingComments()==null) || 
             (this.closingComments!=null &&
              java.util.Arrays.equals(this.closingComments, other.getClosingComments())));
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
        if (getClosingComments() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getClosingComments());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getClosingComments(), i);
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
        new org.apache.axis.description.TypeDesc(CMBChangeInstanceTypeCloseClosingComments.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", ">>CMBChangeInstanceType>close>ClosingComments"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("closingComments");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "ClosingComments"));
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
