/**
 * CMBChange_ServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peregrine.servicecenter.PWS;

public class CMBChange_ServiceLocator extends org.apache.axis.client.Service implements com.peregrine.servicecenter.PWS.CMBChange_Service {

    public CMBChange_ServiceLocator() {
    }


    public CMBChange_ServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public CMBChange_ServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for CMBChange
    private java.lang.String CMBChange_address = "http://ITILApp.itcenter.cmbchina.com:13081/sc62server/ws";

    public java.lang.String getCMBChangeAddress() {
        return CMBChange_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String CMBChangeWSDDServiceName = "CMBChange";

    public java.lang.String getCMBChangeWSDDServiceName() {
        return CMBChangeWSDDServiceName;
    }

    public void setCMBChangeWSDDServiceName(java.lang.String name) {
        CMBChangeWSDDServiceName = name;
    }

    public com.peregrine.servicecenter.PWS.CMBChange_PortType getCMBChange() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(CMBChange_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getCMBChange(endpoint);
    }

    public com.peregrine.servicecenter.PWS.CMBChange_PortType getCMBChange(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.peregrine.servicecenter.PWS.CMBChange_BindingStub _stub = new com.peregrine.servicecenter.PWS.CMBChange_BindingStub(portAddress, this);
            _stub.setPortName(getCMBChangeWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }
    
    public com.peregrine.servicecenter.PWS.CMBChange_PortType getCMBChange(java.net.URL portAddress, java.lang.String username, java.lang.String password) throws javax.xml.rpc.ServiceException {
        try {
            com.peregrine.servicecenter.PWS.CMBChange_BindingStub _stub = new com.peregrine.servicecenter.PWS.CMBChange_BindingStub(portAddress, this);
            _stub.setUsername(username);
            _stub.setPassword(password);
            _stub.setPortName(getCMBChangeWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setCMBChangeEndpointAddress(java.lang.String address) {
        CMBChange_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.peregrine.servicecenter.PWS.CMBChange_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                com.peregrine.servicecenter.PWS.CMBChange_BindingStub _stub = new com.peregrine.servicecenter.PWS.CMBChange_BindingStub(new java.net.URL(CMBChange_address), this);
                _stub.setPortName(getCMBChangeWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("CMBChange".equals(inputPortName)) {
            return getCMBChange();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "CMBChange");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "CMBChange"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("CMBChange".equals(portName)) {
            setCMBChangeEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
