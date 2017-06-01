/**
 * CMBChangeInstanceTypeClosureComments.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peregrine.servicecenter.PWS;

public class CMBChangeInstanceTypeClosureComments  extends com.peregrine.servicecenter.PWS.Common.ArrayType  implements java.io.Serializable {
    private com.peregrine.servicecenter.PWS.Common.StringType[] closureComments;

    public CMBChangeInstanceTypeClosureComments() {
    }

    public CMBChangeInstanceTypeClosureComments(
           java.lang.String type,
           com.peregrine.servicecenter.PWS.Common.StringType[] closureComments) {
        super(
            type);
        this.closureComments = closureComments;
    }


    /**
     * Gets the closureComments value for this CMBChangeInstanceTypeClosureComments.
     * 
     * @return closureComments
     */
    public com.peregrine.servicecenter.PWS.Common.StringType[] getClosureComments() {
        return closureComments;
    }


    /**
     * Sets the closureComments value for this CMBChangeInstanceTypeClosureComments.
     * 
     * @param closureComments
     */
    public void setClosureComments(com.peregrine.servicecenter.PWS.Common.StringType[] closureComments) {
        this.closureComments = closureComments;
    }

    public com.peregrine.servicecenter.PWS.Common.StringType getClosureComments(int i) {
        return this.closureComments[i];
    }

    public void setClosureComments(int i, com.peregrine.servicecenter.PWS.Common.StringType _value) {
        this.closureComments[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CMBChangeInstanceTypeClosureComments)) return false;
        CMBChangeInstanceTypeClosureComments other = (CMBChangeInstanceTypeClosureComments) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.closureComments==null && other.getClosureComments()==null) || 
             (this.closureComments!=null &&
              java.util.Arrays.equals(this.closureComments, other.getClosureComments())));
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
        if (getClosureComments() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getClosureComments());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getClosureComments(), i);
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
        new org.apache.axis.description.TypeDesc(CMBChangeInstanceTypeClosureComments.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", ">CMBChangeInstanceType>ClosureComments"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("closureComments");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "ClosureComments"));
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
