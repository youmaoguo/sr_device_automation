/**
 * CMBChangeInstanceTypeMiddleMiscArray3.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peregrine.servicecenter.PWS;

public class CMBChangeInstanceTypeMiddleMiscArray3  extends com.peregrine.servicecenter.PWS.Common.ArrayType  implements java.io.Serializable {
    private com.peregrine.servicecenter.PWS.Common.StringType[] miscArray3;

    public CMBChangeInstanceTypeMiddleMiscArray3() {
    }

    public CMBChangeInstanceTypeMiddleMiscArray3(
           java.lang.String type,
           com.peregrine.servicecenter.PWS.Common.StringType[] miscArray3) {
        super(
            type);
        this.miscArray3 = miscArray3;
    }


    /**
     * Gets the miscArray3 value for this CMBChangeInstanceTypeMiddleMiscArray3.
     * 
     * @return miscArray3
     */
    public com.peregrine.servicecenter.PWS.Common.StringType[] getMiscArray3() {
        return miscArray3;
    }


    /**
     * Sets the miscArray3 value for this CMBChangeInstanceTypeMiddleMiscArray3.
     * 
     * @param miscArray3
     */
    public void setMiscArray3(com.peregrine.servicecenter.PWS.Common.StringType[] miscArray3) {
        this.miscArray3 = miscArray3;
    }

    public com.peregrine.servicecenter.PWS.Common.StringType getMiscArray3(int i) {
        return this.miscArray3[i];
    }

    public void setMiscArray3(int i, com.peregrine.servicecenter.PWS.Common.StringType _value) {
        this.miscArray3[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CMBChangeInstanceTypeMiddleMiscArray3)) return false;
        CMBChangeInstanceTypeMiddleMiscArray3 other = (CMBChangeInstanceTypeMiddleMiscArray3) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.miscArray3==null && other.getMiscArray3()==null) || 
             (this.miscArray3!=null &&
              java.util.Arrays.equals(this.miscArray3, other.getMiscArray3())));
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
        if (getMiscArray3() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getMiscArray3());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getMiscArray3(), i);
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
        new org.apache.axis.description.TypeDesc(CMBChangeInstanceTypeMiddleMiscArray3.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", ">>CMBChangeInstanceType>middle>MiscArray3"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("miscArray3");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "MiscArray3"));
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
