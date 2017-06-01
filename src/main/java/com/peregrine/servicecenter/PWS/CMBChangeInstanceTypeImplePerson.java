/**
 * CMBChangeInstanceTypeImplePerson.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peregrine.servicecenter.PWS;

public class CMBChangeInstanceTypeImplePerson  extends com.peregrine.servicecenter.PWS.Common.ArrayType  implements java.io.Serializable {
    private com.peregrine.servicecenter.PWS.Common.StringType[] implePerson;

    public CMBChangeInstanceTypeImplePerson() {
    }

    public CMBChangeInstanceTypeImplePerson(
           java.lang.String type,
           com.peregrine.servicecenter.PWS.Common.StringType[] implePerson) {
        super(
            type);
        this.implePerson = implePerson;
    }


    /**
     * Gets the implePerson value for this CMBChangeInstanceTypeImplePerson.
     * 
     * @return implePerson
     */
    public com.peregrine.servicecenter.PWS.Common.StringType[] getImplePerson() {
        return implePerson;
    }


    /**
     * Sets the implePerson value for this CMBChangeInstanceTypeImplePerson.
     * 
     * @param implePerson
     */
    public void setImplePerson(com.peregrine.servicecenter.PWS.Common.StringType[] implePerson) {
        this.implePerson = implePerson;
    }

    public com.peregrine.servicecenter.PWS.Common.StringType getImplePerson(int i) {
        return this.implePerson[i];
    }

    public void setImplePerson(int i, com.peregrine.servicecenter.PWS.Common.StringType _value) {
        this.implePerson[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CMBChangeInstanceTypeImplePerson)) return false;
        CMBChangeInstanceTypeImplePerson other = (CMBChangeInstanceTypeImplePerson) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.implePerson==null && other.getImplePerson()==null) || 
             (this.implePerson!=null &&
              java.util.Arrays.equals(this.implePerson, other.getImplePerson())));
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
        if (getImplePerson() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getImplePerson());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getImplePerson(), i);
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
        new org.apache.axis.description.TypeDesc(CMBChangeInstanceTypeImplePerson.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", ">CMBChangeInstanceType>ImplePerson"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("implePerson");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "ImplePerson"));
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
