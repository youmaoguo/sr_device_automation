/**
 * AttachmentType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peregrine.servicecenter.PWS.Common;

public class AttachmentType  implements java.io.Serializable {
    private java.lang.String href;  // attribute

    private java.lang.String contentId;  // attribute

    private java.lang.String action;  // attribute

    private java.lang.String name;  // attribute

    private java.lang.String type;  // attribute

    private java.lang.Integer len;  // attribute

    private java.lang.String charset;  // attribute

    private java.lang.String uploadBy;  // attribute

    private java.lang.String uploadDate;  // attribute

    private java.lang.String attachmentType;  // attribute

    public AttachmentType() {
    }

    public AttachmentType(
           java.lang.String href,
           java.lang.String contentId,
           java.lang.String action,
           java.lang.String name,
           java.lang.String type,
           java.lang.Integer len,
           java.lang.String charset,
           java.lang.String uploadBy,
           java.lang.String uploadDate,
           java.lang.String attachmentType) {
           this.href = href;
           this.contentId = contentId;
           this.action = action;
           this.name = name;
           this.type = type;
           this.len = len;
           this.charset = charset;
           this.uploadBy = uploadBy;
           this.uploadDate = uploadDate;
           this.attachmentType = attachmentType;
    }


    /**
     * Gets the href value for this AttachmentType.
     * 
     * @return href
     */
    public java.lang.String getHref() {
        return href;
    }


    /**
     * Sets the href value for this AttachmentType.
     * 
     * @param href
     */
    public void setHref(java.lang.String href) {
        this.href = href;
    }


    /**
     * Gets the contentId value for this AttachmentType.
     * 
     * @return contentId
     */
    public java.lang.String getContentId() {
        return contentId;
    }


    /**
     * Sets the contentId value for this AttachmentType.
     * 
     * @param contentId
     */
    public void setContentId(java.lang.String contentId) {
        this.contentId = contentId;
    }


    /**
     * Gets the action value for this AttachmentType.
     * 
     * @return action
     */
    public java.lang.String getAction() {
        return action;
    }


    /**
     * Sets the action value for this AttachmentType.
     * 
     * @param action
     */
    public void setAction(java.lang.String action) {
        this.action = action;
    }


    /**
     * Gets the name value for this AttachmentType.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this AttachmentType.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }


    /**
     * Gets the type value for this AttachmentType.
     * 
     * @return type
     */
    public java.lang.String getType() {
        return type;
    }


    /**
     * Sets the type value for this AttachmentType.
     * 
     * @param type
     */
    public void setType(java.lang.String type) {
        this.type = type;
    }


    /**
     * Gets the len value for this AttachmentType.
     * 
     * @return len
     */
    public java.lang.Integer getLen() {
        return len;
    }


    /**
     * Sets the len value for this AttachmentType.
     * 
     * @param len
     */
    public void setLen(java.lang.Integer len) {
        this.len = len;
    }


    /**
     * Gets the charset value for this AttachmentType.
     * 
     * @return charset
     */
    public java.lang.String getCharset() {
        return charset;
    }


    /**
     * Sets the charset value for this AttachmentType.
     * 
     * @param charset
     */
    public void setCharset(java.lang.String charset) {
        this.charset = charset;
    }


    /**
     * Gets the uploadBy value for this AttachmentType.
     * 
     * @return uploadBy
     */
    public java.lang.String getUploadBy() {
        return uploadBy;
    }


    /**
     * Sets the uploadBy value for this AttachmentType.
     * 
     * @param uploadBy
     */
    public void setUploadBy(java.lang.String uploadBy) {
        this.uploadBy = uploadBy;
    }


    /**
     * Gets the uploadDate value for this AttachmentType.
     * 
     * @return uploadDate
     */
    public java.lang.String getUploadDate() {
        return uploadDate;
    }


    /**
     * Sets the uploadDate value for this AttachmentType.
     * 
     * @param uploadDate
     */
    public void setUploadDate(java.lang.String uploadDate) {
        this.uploadDate = uploadDate;
    }


    /**
     * Gets the attachmentType value for this AttachmentType.
     * 
     * @return attachmentType
     */
    public java.lang.String getAttachmentType() {
        return attachmentType;
    }


    /**
     * Sets the attachmentType value for this AttachmentType.
     * 
     * @param attachmentType
     */
    public void setAttachmentType(java.lang.String attachmentType) {
        this.attachmentType = attachmentType;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AttachmentType)) return false;
        AttachmentType other = (AttachmentType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.href==null && other.getHref()==null) || 
             (this.href!=null &&
              this.href.equals(other.getHref()))) &&
            ((this.contentId==null && other.getContentId()==null) || 
             (this.contentId!=null &&
              this.contentId.equals(other.getContentId()))) &&
            ((this.action==null && other.getAction()==null) || 
             (this.action!=null &&
              this.action.equals(other.getAction()))) &&
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName()))) &&
            ((this.type==null && other.getType()==null) || 
             (this.type!=null &&
              this.type.equals(other.getType()))) &&
            ((this.len==null && other.getLen()==null) || 
             (this.len!=null &&
              this.len.equals(other.getLen()))) &&
            ((this.charset==null && other.getCharset()==null) || 
             (this.charset!=null &&
              this.charset.equals(other.getCharset()))) &&
            ((this.uploadBy==null && other.getUploadBy()==null) || 
             (this.uploadBy!=null &&
              this.uploadBy.equals(other.getUploadBy()))) &&
            ((this.uploadDate==null && other.getUploadDate()==null) || 
             (this.uploadDate!=null &&
              this.uploadDate.equals(other.getUploadDate()))) &&
            ((this.attachmentType==null && other.getAttachmentType()==null) || 
             (this.attachmentType!=null &&
              this.attachmentType.equals(other.getAttachmentType())));
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
        if (getHref() != null) {
            _hashCode += getHref().hashCode();
        }
        if (getContentId() != null) {
            _hashCode += getContentId().hashCode();
        }
        if (getAction() != null) {
            _hashCode += getAction().hashCode();
        }
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        if (getType() != null) {
            _hashCode += getType().hashCode();
        }
        if (getLen() != null) {
            _hashCode += getLen().hashCode();
        }
        if (getCharset() != null) {
            _hashCode += getCharset().hashCode();
        }
        if (getUploadBy() != null) {
            _hashCode += getUploadBy().hashCode();
        }
        if (getUploadDate() != null) {
            _hashCode += getUploadDate().hashCode();
        }
        if (getAttachmentType() != null) {
            _hashCode += getAttachmentType().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AttachmentType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS/Common", "AttachmentType"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("href");
        attrField.setXmlName(new javax.xml.namespace.QName("", "href"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("contentId");
        attrField.setXmlName(new javax.xml.namespace.QName("", "contentId"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("action");
        attrField.setXmlName(new javax.xml.namespace.QName("", "action"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("name");
        attrField.setXmlName(new javax.xml.namespace.QName("", "name"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("type");
        attrField.setXmlName(new javax.xml.namespace.QName("", "type"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("len");
        attrField.setXmlName(new javax.xml.namespace.QName("", "len"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("charset");
        attrField.setXmlName(new javax.xml.namespace.QName("", "charset"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("uploadBy");
        attrField.setXmlName(new javax.xml.namespace.QName("", "upload.by"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("uploadDate");
        attrField.setXmlName(new javax.xml.namespace.QName("", "upload.date"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("attachmentType");
        attrField.setXmlName(new javax.xml.namespace.QName("", "attachmentType"));
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
