/**
 * CMBChange_PortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peregrine.servicecenter.PWS;

public interface CMBChange_PortType extends java.rmi.Remote {
    public com.peregrine.servicecenter.PWS.RetrieveCMBChangeResponse retrieveCMBChange(com.peregrine.servicecenter.PWS.RetrieveCMBChangeRequest retrieveCMBChangeRequest) throws java.rmi.RemoteException;
    public com.peregrine.servicecenter.PWS.RetrieveCMBChangeKeysListResponse retrieveCMBChangeKeysList(com.peregrine.servicecenter.PWS.RetrieveCMBChangeKeysListRequest retrieveCMBChangeKeysListRequest) throws java.rmi.RemoteException;
    public com.peregrine.servicecenter.PWS.RetrieveCMBChangeListResponse retrieveCMBChangeList(com.peregrine.servicecenter.PWS.CMBChangeKeysType[] retrieveCMBChangeListRequest) throws java.rmi.RemoteException;
    public com.peregrine.servicecenter.PWS.UpdateCMBChangeResponse updateCMBChange(com.peregrine.servicecenter.PWS.UpdateCMBChangeRequest updateCMBChangeRequest) throws java.rmi.RemoteException;
    public com.peregrine.servicecenter.PWS.RetractCMBChangeResponse retractCMBChange(com.peregrine.servicecenter.PWS.RetractCMBChangeRequest retractCMBChangeRequest) throws java.rmi.RemoteException;
    public com.peregrine.servicecenter.PWS.ReopenCMBChangeResponse reopenCMBChange(com.peregrine.servicecenter.PWS.ReopenCMBChangeRequest reopenCMBChangeRequest) throws java.rmi.RemoteException;
    public com.peregrine.servicecenter.PWS.MoveToNextPhaseCMBChangeResponse moveToNextPhaseCMBChange(com.peregrine.servicecenter.PWS.MoveToNextPhaseCMBChangeRequest moveToNextPhaseCMBChangeRequest) throws java.rmi.RemoteException;
    public com.peregrine.servicecenter.PWS.DenyCMBChangeResponse denyCMBChange(com.peregrine.servicecenter.PWS.DenyCMBChangeRequest denyCMBChangeRequest) throws java.rmi.RemoteException;
    public com.peregrine.servicecenter.PWS.CloseCMBChangeResponse closeCMBChange(com.peregrine.servicecenter.PWS.CloseCMBChangeRequest closeCMBChangeRequest) throws java.rmi.RemoteException;
    public com.peregrine.servicecenter.PWS.ApproveCMBChangeResponse approveCMBChange(com.peregrine.servicecenter.PWS.ApproveCMBChangeRequest approveCMBChangeRequest) throws java.rmi.RemoteException;
    public com.peregrine.servicecenter.PWS.CreateCMBChangeResponse createCMBChange(com.peregrine.servicecenter.PWS.CreateCMBChangeRequest createCMBChangeRequest) throws java.rmi.RemoteException;
    public com.peregrine.servicecenter.PWS.CancelCMBChangeResponse cancelCMBChange(com.peregrine.servicecenter.PWS.CancelCMBChangeRequest cancelCMBChangeRequest) throws java.rmi.RemoteException;
}
