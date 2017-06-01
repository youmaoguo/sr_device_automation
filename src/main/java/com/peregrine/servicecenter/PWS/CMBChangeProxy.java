package com.peregrine.servicecenter.PWS;

public class CMBChangeProxy implements com.peregrine.servicecenter.PWS.CMBChange_PortType {
  private String _endpoint = null;
  private com.peregrine.servicecenter.PWS.CMBChange_PortType cMBChange_PortType = null;
  
  public CMBChangeProxy() {
    _initCMBChangeProxy();
  }
  
  public CMBChangeProxy(String endpoint) {
    _endpoint = endpoint;
    _initCMBChangeProxy();
  }
  
  private void _initCMBChangeProxy() {
    try {
      cMBChange_PortType = (new com.peregrine.servicecenter.PWS.CMBChange_ServiceLocator()).getCMBChange();
      if (cMBChange_PortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)cMBChange_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)cMBChange_PortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (cMBChange_PortType != null)
      ((javax.xml.rpc.Stub)cMBChange_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.peregrine.servicecenter.PWS.CMBChange_PortType getCMBChange_PortType() {
    if (cMBChange_PortType == null)
      _initCMBChangeProxy();
    return cMBChange_PortType;
  }
  
  public com.peregrine.servicecenter.PWS.RetrieveCMBChangeResponse retrieveCMBChange(com.peregrine.servicecenter.PWS.RetrieveCMBChangeRequest retrieveCMBChangeRequest) throws java.rmi.RemoteException{
    if (cMBChange_PortType == null)
      _initCMBChangeProxy();
    return cMBChange_PortType.retrieveCMBChange(retrieveCMBChangeRequest);
  }
  
  public com.peregrine.servicecenter.PWS.RetrieveCMBChangeKeysListResponse retrieveCMBChangeKeysList(com.peregrine.servicecenter.PWS.RetrieveCMBChangeKeysListRequest retrieveCMBChangeKeysListRequest) throws java.rmi.RemoteException{
    if (cMBChange_PortType == null)
      _initCMBChangeProxy();
    return cMBChange_PortType.retrieveCMBChangeKeysList(retrieveCMBChangeKeysListRequest);
  }
  
  public com.peregrine.servicecenter.PWS.RetrieveCMBChangeListResponse retrieveCMBChangeList(com.peregrine.servicecenter.PWS.CMBChangeKeysType[] retrieveCMBChangeListRequest) throws java.rmi.RemoteException{
    if (cMBChange_PortType == null)
      _initCMBChangeProxy();
    return cMBChange_PortType.retrieveCMBChangeList(retrieveCMBChangeListRequest);
  }
  
  public com.peregrine.servicecenter.PWS.UpdateCMBChangeResponse updateCMBChange(com.peregrine.servicecenter.PWS.UpdateCMBChangeRequest updateCMBChangeRequest) throws java.rmi.RemoteException{
    if (cMBChange_PortType == null)
      _initCMBChangeProxy();
    return cMBChange_PortType.updateCMBChange(updateCMBChangeRequest);
  }
  
  public com.peregrine.servicecenter.PWS.RetractCMBChangeResponse retractCMBChange(com.peregrine.servicecenter.PWS.RetractCMBChangeRequest retractCMBChangeRequest) throws java.rmi.RemoteException{
    if (cMBChange_PortType == null)
      _initCMBChangeProxy();
    return cMBChange_PortType.retractCMBChange(retractCMBChangeRequest);
  }
  
  public com.peregrine.servicecenter.PWS.ReopenCMBChangeResponse reopenCMBChange(com.peregrine.servicecenter.PWS.ReopenCMBChangeRequest reopenCMBChangeRequest) throws java.rmi.RemoteException{
    if (cMBChange_PortType == null)
      _initCMBChangeProxy();
    return cMBChange_PortType.reopenCMBChange(reopenCMBChangeRequest);
  }
  
  public com.peregrine.servicecenter.PWS.MoveToNextPhaseCMBChangeResponse moveToNextPhaseCMBChange(com.peregrine.servicecenter.PWS.MoveToNextPhaseCMBChangeRequest moveToNextPhaseCMBChangeRequest) throws java.rmi.RemoteException{
    if (cMBChange_PortType == null)
      _initCMBChangeProxy();
    return cMBChange_PortType.moveToNextPhaseCMBChange(moveToNextPhaseCMBChangeRequest);
  }
  
  public com.peregrine.servicecenter.PWS.DenyCMBChangeResponse denyCMBChange(com.peregrine.servicecenter.PWS.DenyCMBChangeRequest denyCMBChangeRequest) throws java.rmi.RemoteException{
    if (cMBChange_PortType == null)
      _initCMBChangeProxy();
    return cMBChange_PortType.denyCMBChange(denyCMBChangeRequest);
  }
  
  public com.peregrine.servicecenter.PWS.CloseCMBChangeResponse closeCMBChange(com.peregrine.servicecenter.PWS.CloseCMBChangeRequest closeCMBChangeRequest) throws java.rmi.RemoteException{
    if (cMBChange_PortType == null)
      _initCMBChangeProxy();
    return cMBChange_PortType.closeCMBChange(closeCMBChangeRequest);
  }
  
  public com.peregrine.servicecenter.PWS.ApproveCMBChangeResponse approveCMBChange(com.peregrine.servicecenter.PWS.ApproveCMBChangeRequest approveCMBChangeRequest) throws java.rmi.RemoteException{
    if (cMBChange_PortType == null)
      _initCMBChangeProxy();
    return cMBChange_PortType.approveCMBChange(approveCMBChangeRequest);
  }
  
  public com.peregrine.servicecenter.PWS.CreateCMBChangeResponse createCMBChange(com.peregrine.servicecenter.PWS.CreateCMBChangeRequest createCMBChangeRequest) throws java.rmi.RemoteException{
    if (cMBChange_PortType == null)
      _initCMBChangeProxy();
    return cMBChange_PortType.createCMBChange(createCMBChangeRequest);
  }
  
  public com.peregrine.servicecenter.PWS.CancelCMBChangeResponse cancelCMBChange(com.peregrine.servicecenter.PWS.CancelCMBChangeRequest cancelCMBChangeRequest) throws java.rmi.RemoteException{
    if (cMBChange_PortType == null)
      _initCMBChangeProxy();
    return cMBChange_PortType.cancelCMBChange(cancelCMBChangeRequest);
  }
  
  
}