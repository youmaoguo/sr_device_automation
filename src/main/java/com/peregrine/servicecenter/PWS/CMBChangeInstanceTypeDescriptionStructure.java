/**
 * CMBChangeInstanceTypeDescriptionStructure.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peregrine.servicecenter.PWS;

public class CMBChangeInstanceTypeDescriptionStructure  extends com.peregrine.servicecenter.PWS.Common.StructureType  implements java.io.Serializable {
    private com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeDescriptionStructureDescription description;

    private com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeDescriptionStructureJustification justification;

    private com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeDescriptionStructureBackoutMethod backoutMethod;

    public CMBChangeInstanceTypeDescriptionStructure() {
    }

    public CMBChangeInstanceTypeDescriptionStructure(
           java.lang.String type,
           com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeDescriptionStructureDescription description,
           com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeDescriptionStructureJustification justification,
           com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeDescriptionStructureBackoutMethod backoutMethod) {
        super(
            type);
        this.description = description;
        this.justification = justification;
        this.backoutMethod = backoutMethod;
    }


    /**
     * Gets the description value for this CMBChangeInstanceTypeDescriptionStructure.
     * 
     * @return description
     */
    public com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeDescriptionStructureDescription getDescription() {
        return description;
    }


    /**
     * Sets the description value for this CMBChangeInstanceTypeDescriptionStructure.
     * 
     * @param description
     */
    public void setDescription(com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeDescriptionStructureDescription description) {
        this.description = description;
    }


    /**
     * Gets the justification value for this CMBChangeInstanceTypeDescriptionStructure.
     * 
     * @return justification
     */
    public com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeDescriptionStructureJustification getJustification() {
        return justification;
    }


    /**
     * Sets the justification value for this CMBChangeInstanceTypeDescriptionStructure.
     * 
     * @param justification
     */
    public void setJustification(com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeDescriptionStructureJustification justification) {
        this.justification = justification;
    }


    /**
     * Gets the backoutMethod value for this CMBChangeInstanceTypeDescriptionStructure.
     * 
     * @return backoutMethod
     */
    public com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeDescriptionStructureBackoutMethod getBackoutMethod() {
        return backoutMethod;
    }


    /**
     * Sets the backoutMethod value for this CMBChangeInstanceTypeDescriptionStructure.
     * 
     * @param backoutMethod
     */
    public void setBackoutMethod(com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeDescriptionStructureBackoutMethod backoutMethod) {
        this.backoutMethod = backoutMethod;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CMBChangeInstanceTypeDescriptionStructure)) return false;
        CMBChangeInstanceTypeDescriptionStructure other = (CMBChangeInstanceTypeDescriptionStructure) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.description==null && other.getDescription()==null) || 
             (this.description!=null &&
              this.description.equals(other.getDescription()))) &&
            ((this.justification==null && other.getJustification()==null) || 
             (this.justification!=null &&
              this.justification.equals(other.getJustification()))) &&
            ((this.backoutMethod==null && other.getBackoutMethod()==null) || 
             (this.backoutMethod!=null &&
              this.backoutMethod.equals(other.getBackoutMethod())));
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
        if (getDescription() != null) {
            _hashCode += getDescription().hashCode();
        }
        if (getJustification() != null) {
            _hashCode += getJustification().hashCode();
        }
        if (getBackoutMethod() != null) {
            _hashCode += getBackoutMethod().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CMBChangeInstanceTypeDescriptionStructure.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", ">CMBChangeInstanceType>description.structure"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("description");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "Description"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", ">>CMBChangeInstanceType>description.structure>Description"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("justification");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "Justification"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", ">>CMBChangeInstanceType>description.structure>Justification"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("backoutMethod");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "BackoutMethod"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", ">>CMBChangeInstanceType>description.structure>BackoutMethod"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
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
