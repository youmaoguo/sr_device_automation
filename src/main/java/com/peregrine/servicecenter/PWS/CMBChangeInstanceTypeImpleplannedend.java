/**
 * CMBChangeInstanceTypeImpleplannedend.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peregrine.servicecenter.PWS;

public class CMBChangeInstanceTypeImpleplannedend  extends com.peregrine.servicecenter.PWS.Common.ArrayType  implements java.io.Serializable {
    private com.peregrine.servicecenter.PWS.Common.DateTimeType[] impleplannedend;

    public CMBChangeInstanceTypeImpleplannedend() {
    }

    public CMBChangeInstanceTypeImpleplannedend(
           java.lang.String type,
           com.peregrine.servicecenter.PWS.Common.DateTimeType[] impleplannedend) {
        super(
            type);
        this.impleplannedend = impleplannedend;
    }


    /**
     * Gets the impleplannedend value for this CMBChangeInstanceTypeImpleplannedend.
     * 
     * @return impleplannedend
     */
    public com.peregrine.servicecenter.PWS.Common.DateTimeType[] getImpleplannedend() {
        return impleplannedend;
    }


    /**
     * Sets the impleplannedend value for this CMBChangeInstanceTypeImpleplannedend.
     * 
     * @param impleplannedend
     */
    public void setImpleplannedend(com.peregrine.servicecenter.PWS.Common.DateTimeType[] impleplannedend) {
        this.impleplannedend = impleplannedend;
    }

    public com.peregrine.servicecenter.PWS.Common.DateTimeType getImpleplannedend(int i) {
        return this.impleplannedend[i];
    }

    public void setImpleplannedend(int i, com.peregrine.servicecenter.PWS.Common.DateTimeType _value) {
        this.impleplannedend[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CMBChangeInstanceTypeImpleplannedend)) return false;
        CMBChangeInstanceTypeImpleplannedend other = (CMBChangeInstanceTypeImpleplannedend) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.impleplannedend==null && other.getImpleplannedend()==null) || 
             (this.impleplannedend!=null &&
              java.util.Arrays.equals(this.impleplannedend, other.getImpleplannedend())));
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
        if (getImpleplannedend() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getImpleplannedend());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getImpleplannedend(), i);
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
        new org.apache.axis.description.TypeDesc(CMBChangeInstanceTypeImpleplannedend.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", ">CMBChangeInstanceType>impleplannedend"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("impleplannedend");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "impleplannedend"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS/Common", "DateTimeType"));
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
