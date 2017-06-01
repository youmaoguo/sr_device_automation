/**
 * CMBChange_Service.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peregrine.servicecenter.PWS;

public interface CMBChange_Service extends javax.xml.rpc.Service {
    public java.lang.String getCMBChangeAddress();

    public com.peregrine.servicecenter.PWS.CMBChange_PortType getCMBChange() throws javax.xml.rpc.ServiceException;

    public com.peregrine.servicecenter.PWS.CMBChange_PortType getCMBChange(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
    
    public com.peregrine.servicecenter.PWS.CMBChange_PortType getCMBChange(java.net.URL portAddress, java.lang.String username, java.lang.String password) throws javax.xml.rpc.ServiceException;
}
