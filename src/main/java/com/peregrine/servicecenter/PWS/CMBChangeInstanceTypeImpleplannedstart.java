/**
 * CMBChangeInstanceTypeImpleplannedstart.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peregrine.servicecenter.PWS;

public class CMBChangeInstanceTypeImpleplannedstart  extends com.peregrine.servicecenter.PWS.Common.ArrayType  implements java.io.Serializable {
    private com.peregrine.servicecenter.PWS.Common.DateTimeType[] impleplannedstart;

    public CMBChangeInstanceTypeImpleplannedstart() {
    }

    public CMBChangeInstanceTypeImpleplannedstart(
           java.lang.String type,
           com.peregrine.servicecenter.PWS.Common.DateTimeType[] impleplannedstart) {
        super(
            type);
        this.impleplannedstart = impleplannedstart;
    }


    /**
     * Gets the impleplannedstart value for this CMBChangeInstanceTypeImpleplannedstart.
     * 
     * @return impleplannedstart
     */
    public com.peregrine.servicecenter.PWS.Common.DateTimeType[] getImpleplannedstart() {
        return impleplannedstart;
    }


    /**
     * Sets the impleplannedstart value for this CMBChangeInstanceTypeImpleplannedstart.
     * 
     * @param impleplannedstart
     */
    public void setImpleplannedstart(com.peregrine.servicecenter.PWS.Common.DateTimeType[] impleplannedstart) {
        this.impleplannedstart = impleplannedstart;
    }

    public com.peregrine.servicecenter.PWS.Common.DateTimeType getImpleplannedstart(int i) {
        return this.impleplannedstart[i];
    }

    public void setImpleplannedstart(int i, com.peregrine.servicecenter.PWS.Common.DateTimeType _value) {
        this.impleplannedstart[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CMBChangeInstanceTypeImpleplannedstart)) return false;
        CMBChangeInstanceTypeImpleplannedstart other = (CMBChangeInstanceTypeImpleplannedstart) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.impleplannedstart==null && other.getImpleplannedstart()==null) || 
             (this.impleplannedstart!=null &&
              java.util.Arrays.equals(this.impleplannedstart, other.getImpleplannedstart())));
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
        if (getImpleplannedstart() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getImpleplannedstart());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getImpleplannedstart(), i);
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
        new org.apache.axis.description.TypeDesc(CMBChangeInstanceTypeImpleplannedstart.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", ">CMBChangeInstanceType>impleplannedstart"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("impleplannedstart");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "impleplannedstart"));
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
