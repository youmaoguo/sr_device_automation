/**
 * CMBChangeModelType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peregrine.servicecenter.PWS;

public class CMBChangeModelType  implements java.io.Serializable {
    private com.peregrine.servicecenter.PWS.CMBChangeKeysType keys;

    private com.peregrine.servicecenter.PWS.CMBChangeInstanceType instance;

    private com.peregrine.servicecenter.PWS.Common.MessageType[] messages;

    private java.lang.String query;  // attribute

    public CMBChangeModelType() {
    }

    public CMBChangeModelType(
           com.peregrine.servicecenter.PWS.CMBChangeKeysType keys,
           com.peregrine.servicecenter.PWS.CMBChangeInstanceType instance,
           com.peregrine.servicecenter.PWS.Common.MessageType[] messages,
           java.lang.String query) {
           this.keys = keys;
           this.instance = instance;
           this.messages = messages;
           this.query = query;
    }


    /**
     * Gets the keys value for this CMBChangeModelType.
     * 
     * @return keys
     */
    public com.peregrine.servicecenter.PWS.CMBChangeKeysType getKeys() {
        return keys;
    }


    /**
     * Sets the keys value for this CMBChangeModelType.
     * 
     * @param keys
     */
    public void setKeys(com.peregrine.servicecenter.PWS.CMBChangeKeysType keys) {
        this.keys = keys;
    }


    /**
     * Gets the instance value for this CMBChangeModelType.
     * 
     * @return instance
     */
    public com.peregrine.servicecenter.PWS.CMBChangeInstanceType getInstance() {
        return instance;
    }


    /**
     * Sets the instance value for this CMBChangeModelType.
     * 
     * @param instance
     */
    public void setInstance(com.peregrine.servicecenter.PWS.CMBChangeInstanceType instance) {
        this.instance = instance;
    }


    /**
     * Gets the messages value for this CMBChangeModelType.
     * 
     * @return messages
     */
    public com.peregrine.servicecenter.PWS.Common.MessageType[] getMessages() {
        return messages;
    }


    /**
     * Sets the messages value for this CMBChangeModelType.
     * 
     * @param messages
     */
    public void setMessages(com.peregrine.servicecenter.PWS.Common.MessageType[] messages) {
        this.messages = messages;
    }


    /**
     * Gets the query value for this CMBChangeModelType.
     * 
     * @return query
     */
    public java.lang.String getQuery() {
        return query;
    }


    /**
     * Sets the query value for this CMBChangeModelType.
     * 
     * @param query
     */
    public void setQuery(java.lang.String query) {
        this.query = query;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CMBChangeModelType)) return false;
        CMBChangeModelType other = (CMBChangeModelType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.keys==null && other.getKeys()==null) || 
             (this.keys!=null &&
              this.keys.equals(other.getKeys()))) &&
            ((this.instance==null && other.getInstance()==null) || 
             (this.instance!=null &&
              this.instance.equals(other.getInstance()))) &&
            ((this.messages==null && other.getMessages()==null) || 
             (this.messages!=null &&
              java.util.Arrays.equals(this.messages, other.getMessages()))) &&
            ((this.query==null && other.getQuery()==null) || 
             (this.query!=null &&
              this.query.equals(other.getQuery())));
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
        if (getKeys() != null) {
            _hashCode += getKeys().hashCode();
        }
        if (getInstance() != null) {
            _hashCode += getInstance().hashCode();
        }
        if (getMessages() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getMessages());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getMessages(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getQuery() != null) {
            _hashCode += getQuery().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CMBChangeModelType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "CMBChangeModelType"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("query");
        attrField.setXmlName(new javax.xml.namespace.QName("", "query"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("keys");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "keys"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "CMBChangeKeysType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("instance");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "instance"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "CMBChangeInstanceType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("messages");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "messages"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS/Common", "MessageType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS/Common", "message"));
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
