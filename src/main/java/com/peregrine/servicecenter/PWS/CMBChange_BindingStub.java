/**
 * CMBChange_BindingStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peregrine.servicecenter.PWS;

public class CMBChange_BindingStub extends org.apache.axis.client.Stub implements com.peregrine.servicecenter.PWS.CMBChange_PortType {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[12];
        _initOperationDesc1();
        _initOperationDesc2();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("RetrieveCMBChange");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "RetrieveCMBChangeRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", ">RetrieveCMBChangeRequest"), com.peregrine.servicecenter.PWS.RetrieveCMBChangeRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", ">RetrieveCMBChangeResponse"));
        oper.setReturnClass(com.peregrine.servicecenter.PWS.RetrieveCMBChangeResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "RetrieveCMBChangeResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("RetrieveCMBChangeKeysList");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "RetrieveCMBChangeKeysListRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", ">RetrieveCMBChangeKeysListRequest"), com.peregrine.servicecenter.PWS.RetrieveCMBChangeKeysListRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", ">RetrieveCMBChangeKeysListResponse"));
        oper.setReturnClass(com.peregrine.servicecenter.PWS.RetrieveCMBChangeKeysListResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "RetrieveCMBChangeKeysListResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("RetrieveCMBChangeList");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "RetrieveCMBChangeListRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", ">RetrieveCMBChangeListRequest"), com.peregrine.servicecenter.PWS.CMBChangeKeysType[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "keys"));
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", ">RetrieveCMBChangeListResponse"));
        oper.setReturnClass(com.peregrine.servicecenter.PWS.RetrieveCMBChangeListResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "RetrieveCMBChangeListResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("UpdateCMBChange");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "UpdateCMBChangeRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", ">UpdateCMBChangeRequest"), com.peregrine.servicecenter.PWS.UpdateCMBChangeRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", ">UpdateCMBChangeResponse"));
        oper.setReturnClass(com.peregrine.servicecenter.PWS.UpdateCMBChangeResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "UpdateCMBChangeResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("RetractCMBChange");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "RetractCMBChangeRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", ">RetractCMBChangeRequest"), com.peregrine.servicecenter.PWS.RetractCMBChangeRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", ">RetractCMBChangeResponse"));
        oper.setReturnClass(com.peregrine.servicecenter.PWS.RetractCMBChangeResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "RetractCMBChangeResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[4] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ReopenCMBChange");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "ReopenCMBChangeRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", ">ReopenCMBChangeRequest"), com.peregrine.servicecenter.PWS.ReopenCMBChangeRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", ">ReopenCMBChangeResponse"));
        oper.setReturnClass(com.peregrine.servicecenter.PWS.ReopenCMBChangeResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "ReopenCMBChangeResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[5] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("MoveToNextPhaseCMBChange");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "MoveToNextPhaseCMBChangeRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", ">MoveToNextPhaseCMBChangeRequest"), com.peregrine.servicecenter.PWS.MoveToNextPhaseCMBChangeRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", ">MoveToNextPhaseCMBChangeResponse"));
        oper.setReturnClass(com.peregrine.servicecenter.PWS.MoveToNextPhaseCMBChangeResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "MoveToNextPhaseCMBChangeResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[6] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("DenyCMBChange");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "DenyCMBChangeRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", ">DenyCMBChangeRequest"), com.peregrine.servicecenter.PWS.DenyCMBChangeRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", ">DenyCMBChangeResponse"));
        oper.setReturnClass(com.peregrine.servicecenter.PWS.DenyCMBChangeResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "DenyCMBChangeResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[7] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("CloseCMBChange");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "CloseCMBChangeRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", ">CloseCMBChangeRequest"), com.peregrine.servicecenter.PWS.CloseCMBChangeRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", ">CloseCMBChangeResponse"));
        oper.setReturnClass(com.peregrine.servicecenter.PWS.CloseCMBChangeResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "CloseCMBChangeResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[8] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ApproveCMBChange");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "ApproveCMBChangeRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", ">ApproveCMBChangeRequest"), com.peregrine.servicecenter.PWS.ApproveCMBChangeRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", ">ApproveCMBChangeResponse"));
        oper.setReturnClass(com.peregrine.servicecenter.PWS.ApproveCMBChangeResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "ApproveCMBChangeResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[9] = oper;

    }

    private static void _initOperationDesc2(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("CreateCMBChange");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "CreateCMBChangeRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", ">CreateCMBChangeRequest"), com.peregrine.servicecenter.PWS.CreateCMBChangeRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", ">CreateCMBChangeResponse"));
        oper.setReturnClass(com.peregrine.servicecenter.PWS.CreateCMBChangeResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "CreateCMBChangeResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[10] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("CancelCMBChange");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "CancelCMBChangeRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", ">CancelCMBChangeRequest"), com.peregrine.servicecenter.PWS.CancelCMBChangeRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", ">CancelCMBChangeResponse"));
        oper.setReturnClass(com.peregrine.servicecenter.PWS.CancelCMBChangeResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "CancelCMBChangeResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[11] = oper;

    }

    public CMBChange_BindingStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public CMBChange_BindingStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public CMBChange_BindingStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
        if (service == null) {
            super.service = new org.apache.axis.client.Service();
        } else {
            super.service = service;
        }
        ((org.apache.axis.client.Service)super.service).setTypeMappingVersion("1.2");
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS/Common", "ArrayType");
            cachedSerQNames.add(qName);
            cls = com.peregrine.servicecenter.PWS.Common.ArrayType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS/Common", "AttachmentsType");
            cachedSerQNames.add(qName);
            cls = com.peregrine.servicecenter.PWS.Common.AttachmentType[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS/Common", "AttachmentType");
            qName2 = new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS/Common", "attachment");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS/Common", "AttachmentType");
            cachedSerQNames.add(qName);
            cls = com.peregrine.servicecenter.PWS.Common.AttachmentType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS/Common", "BooleanType");
            cachedSerQNames.add(qName);
            cls = com.peregrine.servicecenter.PWS.Common.BooleanType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS/Common", "DateTimeType");
            cachedSerQNames.add(qName);
            cls = com.peregrine.servicecenter.PWS.Common.DateTimeType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS/Common", "DecimalType");
            cachedSerQNames.add(qName);
            cls = com.peregrine.servicecenter.PWS.Common.DecimalType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS/Common", "DurationType");
            cachedSerQNames.add(qName);
            cls = com.peregrine.servicecenter.PWS.Common.DurationType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS/Common", "IntType");
            cachedSerQNames.add(qName);
            cls = com.peregrine.servicecenter.PWS.Common.IntType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS/Common", "MessagesType");
            cachedSerQNames.add(qName);
            cls = com.peregrine.servicecenter.PWS.Common.MessageType[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS/Common", "MessageType");
            qName2 = new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS/Common", "message");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS/Common", "MessageType");
            cachedSerQNames.add(qName);
            cls = com.peregrine.servicecenter.PWS.Common.MessageType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS/Common", "StatusType");
            cachedSerQNames.add(qName);
            cls = com.peregrine.servicecenter.PWS.Common.StatusType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS/Common", "StringType");
            cachedSerQNames.add(qName);
            cls = com.peregrine.servicecenter.PWS.Common.StringType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS/Common", "StructureType");
            cachedSerQNames.add(qName);
            cls = com.peregrine.servicecenter.PWS.Common.StructureType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", ">>CMBChangeInstanceType>close>ClosingComments");
            cachedSerQNames.add(qName);
            cls = com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeCloseClosingComments.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", ">>CMBChangeInstanceType>cmb.service>Howlong");
            cachedSerQNames.add(qName);
            cls = com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeCmbServiceHowlong.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", ">>CMBChangeInstanceType>cmb.service>Impact");
            cachedSerQNames.add(qName);
            cls = com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeCmbServiceImpact.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", ">>CMBChangeInstanceType>cmb.service>Isdown");
            cachedSerQNames.add(qName);
            cls = com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeCmbServiceIsdown.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", ">>CMBChangeInstanceType>description.structure>BackoutMethod");
            cachedSerQNames.add(qName);
            cls = com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeDescriptionStructureBackoutMethod.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", ">>CMBChangeInstanceType>description.structure>Description");
            cachedSerQNames.add(qName);
            cls = com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeDescriptionStructureDescription.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", ">>CMBChangeInstanceType>description.structure>Justification");
            cachedSerQNames.add(qName);
            cls = com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeDescriptionStructureJustification.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", ">>CMBChangeInstanceType>middle>Assets");
            cachedSerQNames.add(qName);
            cls = com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeMiddleAssets.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", ">>CMBChangeInstanceType>middle>ChangePlan");
            cachedSerQNames.add(qName);
            cls = com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeMiddleChangePlan.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", ">>CMBChangeInstanceType>middle>MiscArray1");
            cachedSerQNames.add(qName);
            cls = com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeMiddleMiscArray1.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", ">>CMBChangeInstanceType>middle>MiscArray2");
            cachedSerQNames.add(qName);
            cls = com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeMiddleMiscArray2.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", ">>CMBChangeInstanceType>middle>MiscArray3");
            cachedSerQNames.add(qName);
            cls = com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeMiddleMiscArray3.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", ">>CMBChangeInstanceType>middle>TestReport");
            cachedSerQNames.add(qName);
            cls = com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeMiddleTestReport.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", ">ApproveCMBChangeRequest");
            cachedSerQNames.add(qName);
            cls = com.peregrine.servicecenter.PWS.ApproveCMBChangeRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", ">ApproveCMBChangeResponse");
            cachedSerQNames.add(qName);
            cls = com.peregrine.servicecenter.PWS.ApproveCMBChangeResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", ">CancelCMBChangeRequest");
            cachedSerQNames.add(qName);
            cls = com.peregrine.servicecenter.PWS.CancelCMBChangeRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", ">CancelCMBChangeResponse");
            cachedSerQNames.add(qName);
            cls = com.peregrine.servicecenter.PWS.CancelCMBChangeResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", ">CloseCMBChangeRequest");
            cachedSerQNames.add(qName);
            cls = com.peregrine.servicecenter.PWS.CloseCMBChangeRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", ">CloseCMBChangeResponse");
            cachedSerQNames.add(qName);
            cls = com.peregrine.servicecenter.PWS.CloseCMBChangeResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", ">CMBChangeInstanceType>ApprovalComments");
            cachedSerQNames.add(qName);
            cls = com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeApprovalComments.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", ">CMBChangeInstanceType>close");
            cachedSerQNames.add(qName);
            cls = com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeClose.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", ">CMBChangeInstanceType>ClosureComments");
            cachedSerQNames.add(qName);
            cls = com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeClosureComments.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", ">CMBChangeInstanceType>cmb.service");
            cachedSerQNames.add(qName);
            cls = com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeCmbService.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", ">CMBChangeInstanceType>CMBAttachmentsAddress");
            cachedSerQNames.add(qName);
            cls = com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeCMBAttachmentsAddress.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", ">CMBChangeInstanceType>cmbriskdesc");
            cachedSerQNames.add(qName);
            cls = com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeCmbriskdesc.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", ">CMBChangeInstanceType>description.structure");
            cachedSerQNames.add(qName);
            cls = com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeDescriptionStructure.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", ">CMBChangeInstanceType>header");
            cachedSerQNames.add(qName);
            cls = com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeHeader.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", ">CMBChangeInstanceType>ImplePerson");
            cachedSerQNames.add(qName);
            cls = com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeImplePerson.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", ">CMBChangeInstanceType>impleplannedend");
            cachedSerQNames.add(qName);
            cls = com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeImpleplannedend.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", ">CMBChangeInstanceType>impleplannedstart");
            cachedSerQNames.add(qName);
            cls = com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeImpleplannedstart.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", ">CMBChangeInstanceType>middle");
            cachedSerQNames.add(qName);
            cls = com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeMiddle.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", ">CreateCMBChangeRequest");
            cachedSerQNames.add(qName);
            cls = com.peregrine.servicecenter.PWS.CreateCMBChangeRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", ">CreateCMBChangeResponse");
            cachedSerQNames.add(qName);
            cls = com.peregrine.servicecenter.PWS.CreateCMBChangeResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", ">DenyCMBChangeRequest");
            cachedSerQNames.add(qName);
            cls = com.peregrine.servicecenter.PWS.DenyCMBChangeRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", ">DenyCMBChangeResponse");
            cachedSerQNames.add(qName);
            cls = com.peregrine.servicecenter.PWS.DenyCMBChangeResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", ">MoveToNextPhaseCMBChangeRequest");
            cachedSerQNames.add(qName);
            cls = com.peregrine.servicecenter.PWS.MoveToNextPhaseCMBChangeRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", ">MoveToNextPhaseCMBChangeResponse");
            cachedSerQNames.add(qName);
            cls = com.peregrine.servicecenter.PWS.MoveToNextPhaseCMBChangeResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", ">ReopenCMBChangeRequest");
            cachedSerQNames.add(qName);
            cls = com.peregrine.servicecenter.PWS.ReopenCMBChangeRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", ">ReopenCMBChangeResponse");
            cachedSerQNames.add(qName);
            cls = com.peregrine.servicecenter.PWS.ReopenCMBChangeResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", ">RetractCMBChangeRequest");
            cachedSerQNames.add(qName);
            cls = com.peregrine.servicecenter.PWS.RetractCMBChangeRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", ">RetractCMBChangeResponse");
            cachedSerQNames.add(qName);
            cls = com.peregrine.servicecenter.PWS.RetractCMBChangeResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", ">RetrieveCMBChangeKeysListRequest");
            cachedSerQNames.add(qName);
            cls = com.peregrine.servicecenter.PWS.RetrieveCMBChangeKeysListRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", ">RetrieveCMBChangeKeysListResponse");
            cachedSerQNames.add(qName);
            cls = com.peregrine.servicecenter.PWS.RetrieveCMBChangeKeysListResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", ">RetrieveCMBChangeListRequest");
            cachedSerQNames.add(qName);
            cls = com.peregrine.servicecenter.PWS.CMBChangeKeysType[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "CMBChangeKeysType");
            qName2 = new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "keys");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", ">RetrieveCMBChangeListResponse");
            cachedSerQNames.add(qName);
            cls = com.peregrine.servicecenter.PWS.RetrieveCMBChangeListResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", ">RetrieveCMBChangeRequest");
            cachedSerQNames.add(qName);
            cls = com.peregrine.servicecenter.PWS.RetrieveCMBChangeRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", ">RetrieveCMBChangeResponse");
            cachedSerQNames.add(qName);
            cls = com.peregrine.servicecenter.PWS.RetrieveCMBChangeResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", ">UpdateCMBChangeRequest");
            cachedSerQNames.add(qName);
            cls = com.peregrine.servicecenter.PWS.UpdateCMBChangeRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", ">UpdateCMBChangeResponse");
            cachedSerQNames.add(qName);
            cls = com.peregrine.servicecenter.PWS.UpdateCMBChangeResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "CMBChangeInstanceType");
            cachedSerQNames.add(qName);
            cls = com.peregrine.servicecenter.PWS.CMBChangeInstanceType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "CMBChangeKeysType");
            cachedSerQNames.add(qName);
            cls = com.peregrine.servicecenter.PWS.CMBChangeKeysType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://servicecenter.peregrine.com/PWS", "CMBChangeModelType");
            cachedSerQNames.add(qName);
            cls = com.peregrine.servicecenter.PWS.CMBChangeModelType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

    }

    protected org.apache.axis.client.Call createCall() throws java.rmi.RemoteException {
        try {
            org.apache.axis.client.Call _call = super._createCall();
            if (super.maintainSessionSet) {
                _call.setMaintainSession(super.maintainSession);
            }
            if (super.cachedUsername != null) {
                _call.setUsername(super.cachedUsername);
            }
            if (super.cachedPassword != null) {
                _call.setPassword(super.cachedPassword);
            }
            if (super.cachedEndpoint != null) {
                _call.setTargetEndpointAddress(super.cachedEndpoint);
            }
            if (super.cachedTimeout != null) {
                _call.setTimeout(super.cachedTimeout);
            }
            if (super.cachedPortName != null) {
                _call.setPortName(super.cachedPortName);
            }
            java.util.Enumeration keys = super.cachedProperties.keys();
            while (keys.hasMoreElements()) {
                java.lang.String key = (java.lang.String) keys.nextElement();
                _call.setProperty(key, super.cachedProperties.get(key));
            }
            // All the type mapping information is registered
            // when the first call is made.
            // The type mapping information is actually registered in
            // the TypeMappingRegistry of the service, which
            // is the reason why registration is only needed for the first call.
            synchronized (this) {
                if (firstCall()) {
                    // must set encoding style before registering serializers
                    _call.setEncodingStyle(null);
                    for (int i = 0; i < cachedSerFactories.size(); ++i) {
                        java.lang.Class cls = (java.lang.Class) cachedSerClasses.get(i);
                        javax.xml.namespace.QName qName =
                                (javax.xml.namespace.QName) cachedSerQNames.get(i);
                        java.lang.Object x = cachedSerFactories.get(i);
                        if (x instanceof Class) {
                            java.lang.Class sf = (java.lang.Class)
                                 cachedSerFactories.get(i);
                            java.lang.Class df = (java.lang.Class)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                        else if (x instanceof javax.xml.rpc.encoding.SerializerFactory) {
                            org.apache.axis.encoding.SerializerFactory sf = (org.apache.axis.encoding.SerializerFactory)
                                 cachedSerFactories.get(i);
                            org.apache.axis.encoding.DeserializerFactory df = (org.apache.axis.encoding.DeserializerFactory)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                    }
                }
            }
            return _call;
        }
        catch (java.lang.Throwable _t) {
            throw new org.apache.axis.AxisFault("Failure trying to get the Call object", _t);
        }
    }

    public com.peregrine.servicecenter.PWS.RetrieveCMBChangeResponse retrieveCMBChange(com.peregrine.servicecenter.PWS.RetrieveCMBChangeRequest retrieveCMBChangeRequest) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("Retrieve");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "RetrieveCMBChange"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {retrieveCMBChangeRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.peregrine.servicecenter.PWS.RetrieveCMBChangeResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.peregrine.servicecenter.PWS.RetrieveCMBChangeResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.peregrine.servicecenter.PWS.RetrieveCMBChangeResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.peregrine.servicecenter.PWS.RetrieveCMBChangeKeysListResponse retrieveCMBChangeKeysList(com.peregrine.servicecenter.PWS.RetrieveCMBChangeKeysListRequest retrieveCMBChangeKeysListRequest) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("RetrieveKeysList");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "RetrieveCMBChangeKeysList"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {retrieveCMBChangeKeysListRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.peregrine.servicecenter.PWS.RetrieveCMBChangeKeysListResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.peregrine.servicecenter.PWS.RetrieveCMBChangeKeysListResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.peregrine.servicecenter.PWS.RetrieveCMBChangeKeysListResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.peregrine.servicecenter.PWS.RetrieveCMBChangeListResponse retrieveCMBChangeList(com.peregrine.servicecenter.PWS.CMBChangeKeysType[] retrieveCMBChangeListRequest) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("RetrieveList");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "RetrieveCMBChangeList"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {retrieveCMBChangeListRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.peregrine.servicecenter.PWS.RetrieveCMBChangeListResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.peregrine.servicecenter.PWS.RetrieveCMBChangeListResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.peregrine.servicecenter.PWS.RetrieveCMBChangeListResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.peregrine.servicecenter.PWS.UpdateCMBChangeResponse updateCMBChange(com.peregrine.servicecenter.PWS.UpdateCMBChangeRequest updateCMBChangeRequest) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("Update");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "UpdateCMBChange"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {updateCMBChangeRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.peregrine.servicecenter.PWS.UpdateCMBChangeResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.peregrine.servicecenter.PWS.UpdateCMBChangeResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.peregrine.servicecenter.PWS.UpdateCMBChangeResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.peregrine.servicecenter.PWS.RetractCMBChangeResponse retractCMBChange(com.peregrine.servicecenter.PWS.RetractCMBChangeRequest retractCMBChangeRequest) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("Retract");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "RetractCMBChange"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {retractCMBChangeRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.peregrine.servicecenter.PWS.RetractCMBChangeResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.peregrine.servicecenter.PWS.RetractCMBChangeResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.peregrine.servicecenter.PWS.RetractCMBChangeResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.peregrine.servicecenter.PWS.ReopenCMBChangeResponse reopenCMBChange(com.peregrine.servicecenter.PWS.ReopenCMBChangeRequest reopenCMBChangeRequest) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[5]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("Reopen");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "ReopenCMBChange"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {reopenCMBChangeRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.peregrine.servicecenter.PWS.ReopenCMBChangeResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.peregrine.servicecenter.PWS.ReopenCMBChangeResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.peregrine.servicecenter.PWS.ReopenCMBChangeResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.peregrine.servicecenter.PWS.MoveToNextPhaseCMBChangeResponse moveToNextPhaseCMBChange(com.peregrine.servicecenter.PWS.MoveToNextPhaseCMBChangeRequest moveToNextPhaseCMBChangeRequest) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[6]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("MoveToNextPhase");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "MoveToNextPhaseCMBChange"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {moveToNextPhaseCMBChangeRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.peregrine.servicecenter.PWS.MoveToNextPhaseCMBChangeResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.peregrine.servicecenter.PWS.MoveToNextPhaseCMBChangeResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.peregrine.servicecenter.PWS.MoveToNextPhaseCMBChangeResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.peregrine.servicecenter.PWS.DenyCMBChangeResponse denyCMBChange(com.peregrine.servicecenter.PWS.DenyCMBChangeRequest denyCMBChangeRequest) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[7]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("Deny");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "DenyCMBChange"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {denyCMBChangeRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.peregrine.servicecenter.PWS.DenyCMBChangeResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.peregrine.servicecenter.PWS.DenyCMBChangeResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.peregrine.servicecenter.PWS.DenyCMBChangeResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.peregrine.servicecenter.PWS.CloseCMBChangeResponse closeCMBChange(com.peregrine.servicecenter.PWS.CloseCMBChangeRequest closeCMBChangeRequest) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[8]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("Close");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "CloseCMBChange"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {closeCMBChangeRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.peregrine.servicecenter.PWS.CloseCMBChangeResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.peregrine.servicecenter.PWS.CloseCMBChangeResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.peregrine.servicecenter.PWS.CloseCMBChangeResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.peregrine.servicecenter.PWS.ApproveCMBChangeResponse approveCMBChange(com.peregrine.servicecenter.PWS.ApproveCMBChangeRequest approveCMBChangeRequest) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[9]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("Approve");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "ApproveCMBChange"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {approveCMBChangeRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.peregrine.servicecenter.PWS.ApproveCMBChangeResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.peregrine.servicecenter.PWS.ApproveCMBChangeResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.peregrine.servicecenter.PWS.ApproveCMBChangeResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.peregrine.servicecenter.PWS.CreateCMBChangeResponse createCMBChange(com.peregrine.servicecenter.PWS.CreateCMBChangeRequest createCMBChangeRequest) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[10]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("Create");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "CreateCMBChange"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {createCMBChangeRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.peregrine.servicecenter.PWS.CreateCMBChangeResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.peregrine.servicecenter.PWS.CreateCMBChangeResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.peregrine.servicecenter.PWS.CreateCMBChangeResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.peregrine.servicecenter.PWS.CancelCMBChangeResponse cancelCMBChange(com.peregrine.servicecenter.PWS.CancelCMBChangeRequest cancelCMBChangeRequest) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[11]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("Cancel");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "CancelCMBChange"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {cancelCMBChangeRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.peregrine.servicecenter.PWS.CancelCMBChangeResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.peregrine.servicecenter.PWS.CancelCMBChangeResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.peregrine.servicecenter.PWS.CancelCMBChangeResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

}
