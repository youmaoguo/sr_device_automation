/**
 * MessageType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peregrine.servicecenter.PWS.Common;

public class MessageType  extends com.peregrine.servicecenter.PWS.Common.StringType  implements java.io.Serializable {
    private java.lang.Integer severity;  // attribute

    private java.lang.String module;  // attribute

    public MessageType() {
    }

    // Simple Types must have a String constructor
    public MessageType(java.lang.String _value) {
        super(_value);
    }


    /**
     * Gets the severity value for this MessageType.
     * 
     * @return severity
     */
    public java.lang.Integer getSeverity() {
        return severity;
    }


    /**
     * Sets the severity value for this MessageType.
     * 
     * @param severity
     */
    public void setSeverity(java.lang.Integer severity) {
        this.severity = severity;
    }


    /**
     * Gets the module value for this MessageType.
     * 
     * @return module
     */
    public java.lang.String getModule() {
        return module;
    }


    /**
     * Sets the module value for this MessageType.
     * 
     * @param module
     */
    public void setModule(java.lang.String module) {
        this.module = module;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof MessageType)) return false;
        MessageType other = (MessageType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.severity==null && other.getSeverity()==null) || 
             (this.severity!=null &&
              this.severity.equals(other.getSeverity()))) &&
            ((this.module==null && other.getModule()==null) || 
             (this.module!=null &&
              this.module.equals(other.getModule())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getSeverity() != null) {
            _hashCode += getSeverity().hashCode();
        }
        if (getModule() != null) {
            _hashCode += getModule().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(MessageType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS/Common", "MessageType"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("severity");
        attrField.setXmlName(new javax.xml.namespace.QName("", "severity"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("module");
        attrField.setXmlName(new javax.xml.namespace.QName("", "module"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
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
          new  org.apache.axis.encoding.ser.SimpleSerializer(
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
          new  org.apache.axis.encoding.ser.SimpleDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
