/**
 * CMBChangeInstanceTypeDescriptionStructureJustification.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peregrine.servicecenter.PWS;

public class CMBChangeInstanceTypeDescriptionStructureJustification  extends com.peregrine.servicecenter.PWS.Common.ArrayType  implements java.io.Serializable {
    private com.peregrine.servicecenter.PWS.Common.StringType[] justification;

    public CMBChangeInstanceTypeDescriptionStructureJustification() {
    }

    public CMBChangeInstanceTypeDescriptionStructureJustification(
           java.lang.String type,
           com.peregrine.servicecenter.PWS.Common.StringType[] justification) {
        super(
            type);
        this.justification = justification;
    }


    /**
     * Gets the justification value for this CMBChangeInstanceTypeDescriptionStructureJustification.
     * 
     * @return justification
     */
    public com.peregrine.servicecenter.PWS.Common.StringType[] getJustification() {
        return justification;
    }


    /**
     * Sets the justification value for this CMBChangeInstanceTypeDescriptionStructureJustification.
     * 
     * @param justification
     */
    public void setJustification(com.peregrine.servicecenter.PWS.Common.StringType[] justification) {
        this.justification = justification;
    }

    public com.peregrine.servicecenter.PWS.Common.StringType getJustification(int i) {
        return this.justification[i];
    }

    public void setJustification(int i, com.peregrine.servicecenter.PWS.Common.StringType _value) {
        this.justification[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CMBChangeInstanceTypeDescriptionStructureJustification)) return false;
        CMBChangeInstanceTypeDescriptionStructureJustification other = (CMBChangeInstanceTypeDescriptionStructureJustification) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.justification==null && other.getJustification()==null) || 
             (this.justification!=null &&
              java.util.Arrays.equals(this.justification, other.getJustification())));
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
        if (getJustification() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getJustification());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getJustification(), i);
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
        new org.apache.axis.description.TypeDesc(CMBChangeInstanceTypeDescriptionStructureJustification.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", ">>CMBChangeInstanceType>description.structure>Justification"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("justification");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "Justification"));
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
