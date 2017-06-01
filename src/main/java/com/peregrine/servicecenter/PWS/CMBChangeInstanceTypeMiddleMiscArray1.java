/**
 * CMBChangeInstanceTypeMiddleMiscArray1.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peregrine.servicecenter.PWS;

public class CMBChangeInstanceTypeMiddleMiscArray1  extends com.peregrine.servicecenter.PWS.Common.ArrayType  implements java.io.Serializable {
    private com.peregrine.servicecenter.PWS.Common.StringType[] miscArray1;

    public CMBChangeInstanceTypeMiddleMiscArray1() {
    }

    public CMBChangeInstanceTypeMiddleMiscArray1(
           java.lang.String type,
           com.peregrine.servicecenter.PWS.Common.StringType[] miscArray1) {
        super(
            type);
        this.miscArray1 = miscArray1;
    }


    /**
     * Gets the miscArray1 value for this CMBChangeInstanceTypeMiddleMiscArray1.
     * 
     * @return miscArray1
     */
    public com.peregrine.servicecenter.PWS.Common.StringType[] getMiscArray1() {
        return miscArray1;
    }


    /**
     * Sets the miscArray1 value for this CMBChangeInstanceTypeMiddleMiscArray1.
     * 
     * @param miscArray1
     */
    public void setMiscArray1(com.peregrine.servicecenter.PWS.Common.StringType[] miscArray1) {
        this.miscArray1 = miscArray1;
    }

    public com.peregrine.servicecenter.PWS.Common.StringType getMiscArray1(int i) {
        return this.miscArray1[i];
    }

    public void setMiscArray1(int i, com.peregrine.servicecenter.PWS.Common.StringType _value) {
        this.miscArray1[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CMBChangeInstanceTypeMiddleMiscArray1)) return false;
        CMBChangeInstanceTypeMiddleMiscArray1 other = (CMBChangeInstanceTypeMiddleMiscArray1) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.miscArray1==null && other.getMiscArray1()==null) || 
             (this.miscArray1!=null &&
              java.util.Arrays.equals(this.miscArray1, other.getMiscArray1())));
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
        if (getMiscArray1() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getMiscArray1());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getMiscArray1(), i);
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
        new org.apache.axis.description.TypeDesc(CMBChangeInstanceTypeMiddleMiscArray1.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", ">>CMBChangeInstanceType>middle>MiscArray1"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("miscArray1");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "MiscArray1"));
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
