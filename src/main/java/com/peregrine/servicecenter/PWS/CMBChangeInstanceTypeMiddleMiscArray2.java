/**
 * CMBChangeInstanceTypeMiddleMiscArray2.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peregrine.servicecenter.PWS;

public class CMBChangeInstanceTypeMiddleMiscArray2  extends com.peregrine.servicecenter.PWS.Common.ArrayType  implements java.io.Serializable {
    private com.peregrine.servicecenter.PWS.Common.StringType[] miscArray2;

    public CMBChangeInstanceTypeMiddleMiscArray2() {
    }

    public CMBChangeInstanceTypeMiddleMiscArray2(
           java.lang.String type,
           com.peregrine.servicecenter.PWS.Common.StringType[] miscArray2) {
        super(
            type);
        this.miscArray2 = miscArray2;
    }


    /**
     * Gets the miscArray2 value for this CMBChangeInstanceTypeMiddleMiscArray2.
     * 
     * @return miscArray2
     */
    public com.peregrine.servicecenter.PWS.Common.StringType[] getMiscArray2() {
        return miscArray2;
    }


    /**
     * Sets the miscArray2 value for this CMBChangeInstanceTypeMiddleMiscArray2.
     * 
     * @param miscArray2
     */
    public void setMiscArray2(com.peregrine.servicecenter.PWS.Common.StringType[] miscArray2) {
        this.miscArray2 = miscArray2;
    }

    public com.peregrine.servicecenter.PWS.Common.StringType getMiscArray2(int i) {
        return this.miscArray2[i];
    }

    public void setMiscArray2(int i, com.peregrine.servicecenter.PWS.Common.StringType _value) {
        this.miscArray2[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CMBChangeInstanceTypeMiddleMiscArray2)) return false;
        CMBChangeInstanceTypeMiddleMiscArray2 other = (CMBChangeInstanceTypeMiddleMiscArray2) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.miscArray2==null && other.getMiscArray2()==null) || 
             (this.miscArray2!=null &&
              java.util.Arrays.equals(this.miscArray2, other.getMiscArray2())));
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
        if (getMiscArray2() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getMiscArray2());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getMiscArray2(), i);
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
        new org.apache.axis.description.TypeDesc(CMBChangeInstanceTypeMiddleMiscArray2.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", ">>CMBChangeInstanceType>middle>MiscArray2"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("miscArray2");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "MiscArray2"));
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
