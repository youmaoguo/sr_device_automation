/**
 * CMBChangeInstanceTypeCmbService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peregrine.servicecenter.PWS;

public class CMBChangeInstanceTypeCmbService  extends com.peregrine.servicecenter.PWS.Common.StructureType  implements java.io.Serializable {
    private com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeCmbServiceImpact impact;

    private com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeCmbServiceHowlong howlong;

    private com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeCmbServiceIsdown isdown;

    public CMBChangeInstanceTypeCmbService() {
    }

    public CMBChangeInstanceTypeCmbService(
           java.lang.String type,
           com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeCmbServiceImpact impact,
           com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeCmbServiceHowlong howlong,
           com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeCmbServiceIsdown isdown) {
        super(
            type);
        this.impact = impact;
        this.howlong = howlong;
        this.isdown = isdown;
    }


    /**
     * Gets the impact value for this CMBChangeInstanceTypeCmbService.
     * 
     * @return impact
     */
    public com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeCmbServiceImpact getImpact() {
        return impact;
    }


    /**
     * Sets the impact value for this CMBChangeInstanceTypeCmbService.
     * 
     * @param impact
     */
    public void setImpact(com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeCmbServiceImpact impact) {
        this.impact = impact;
    }


    /**
     * Gets the howlong value for this CMBChangeInstanceTypeCmbService.
     * 
     * @return howlong
     */
    public com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeCmbServiceHowlong getHowlong() {
        return howlong;
    }


    /**
     * Sets the howlong value for this CMBChangeInstanceTypeCmbService.
     * 
     * @param howlong
     */
    public void setHowlong(com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeCmbServiceHowlong howlong) {
        this.howlong = howlong;
    }


    /**
     * Gets the isdown value for this CMBChangeInstanceTypeCmbService.
     * 
     * @return isdown
     */
    public com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeCmbServiceIsdown getIsdown() {
        return isdown;
    }


    /**
     * Sets the isdown value for this CMBChangeInstanceTypeCmbService.
     * 
     * @param isdown
     */
    public void setIsdown(com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeCmbServiceIsdown isdown) {
        this.isdown = isdown;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CMBChangeInstanceTypeCmbService)) return false;
        CMBChangeInstanceTypeCmbService other = (CMBChangeInstanceTypeCmbService) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.impact==null && other.getImpact()==null) || 
             (this.impact!=null &&
              this.impact.equals(other.getImpact()))) &&
            ((this.howlong==null && other.getHowlong()==null) || 
             (this.howlong!=null &&
              this.howlong.equals(other.getHowlong()))) &&
            ((this.isdown==null && other.getIsdown()==null) || 
             (this.isdown!=null &&
              this.isdown.equals(other.getIsdown())));
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
        if (getImpact() != null) {
            _hashCode += getImpact().hashCode();
        }
        if (getHowlong() != null) {
            _hashCode += getHowlong().hashCode();
        }
        if (getIsdown() != null) {
            _hashCode += getIsdown().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CMBChangeInstanceTypeCmbService.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", ">CMBChangeInstanceType>cmb.service"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("impact");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "Impact"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", ">>CMBChangeInstanceType>cmb.service>Impact"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("howlong");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "Howlong"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", ">>CMBChangeInstanceType>cmb.service>Howlong"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isdown");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "Isdown"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", ">>CMBChangeInstanceType>cmb.service>Isdown"));
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
