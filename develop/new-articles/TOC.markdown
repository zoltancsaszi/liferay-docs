# Contents

[Title](Title.html)

[Copyright notice](Copyright-notice.html)

1. [Preface](Chapter-1-Preface.html)

    1.1 Portlet 1.0 Compatibility

    1.2 Additional Sources

    1.3 Who Should Read This Specification

    1.4 API Reference

    1.5 Important Dependent Java&trade; Specifications

    1.6 Dependent Java&trade; Versions

    1.7 Terminology

    1.8 Providing Feedback

    1.9 Acknowledgments

2. [Overview](Chapter-2-Overview.html)

    2.1 What is a Portlet Bridge?

    2.2 What is a Portlet?

    2.3 What is JavaServer™ Faces?

    2.4 Architectural Overview

    2.5 Terminology

    2.6 What's New in Portlet 2.0?

    2.6.1 Events

    2.6.2 Portlet Served Resources

    2.6.3 Public Render Parameters

    2.6.4 Portlet Filters and Wrappable Request/Response Objects

    2.6.5 Dispatch Changes

3. [Bridge Interface](Chapter-3-Bridge-Interface.html)

    3.1 Discovering and Instantiating the Bridge

    3.2 Initializing the Bridge

    3.3 Destroying the Bridge

    3.4 Request Processing

4. [GenericFacesPortlet](Chapter-4-GenericFacesPortlet.html)

    4.1 Configuration

    4.2 Structure

    4.2.1 init()

    4.2.2 destroy()

    4.2.3 doDispatch()

    4.2.4 doView(), doEdit(), doHelp(), processAction(), serveResource(), processEvent()

    4.2.5 Request Processing

    4.2.6 getBridgeClassName()

    4.2.7 getDefaultViewIdMap()

    4.2.8 getExcludedRequestAttributes()

    4.2.9 isPreserveActionParameters()

    4.2.10 getResponseContentType()

    4.2.11 getResponseCharacterSetEncoding()

    4.2.12 getBridgeEventHandler()

    4.2.13 getBridgePublicRenderParameterHandler()

    4.2.14 isAutoDispatchEvents()

    4.2.15 getFacesBridge()

    4.2.16 getDefaultRenderKitId()

5. [Bridge Lifecycle Requirements](Chapter-5-Bridge-Lifecycle-Requirements.html)

    5.1 Request Lifecycle

    5.1.1 Bridge Request Lifecycle

    5.1.2 Managing Lifecycle State

    5.1.2.1 Excluding Attributes from the Bridge Request Scope

    5.1.2.2 Considerations in Managing the VIEW_STATE_PARAM parameter
 
    5.1.2.3 Considerations for Managing Faces Messages

    5.2 Executing a Faces Request

    5.2.1 Acquiring a Faces Lifecycle

    5.2.2 Acquiring the Faces Context

    5.2.2.1 Identifying the Portlet Request Phase

    5.2.3 Determining the Target View

    5.2.4 Executing a Portlet Action Request

    5.2.5 Executing a Portlet Event Request

    5.2.6 Executing a Portlet Render Request

    5.2.7 Executing a Portlet Resource Request

    5.2.7 Executing a Portlet Event

    5.2.8 Releasing the Faces Context

    5.3 Processing Public Render Parameters

    5.3.1 Configuring a Public Render Parameter Mapping

    5.3.2 Processing incoming Public Render Parameters

    5.3.3 Processing outgoing Public Render Parameters (changes)

    5.4 Supporting PortletMode changes

    5.4.1 Mode changes and Lifecycle management

    5.4.2 Encoding PortletMode changes in Faces navigation

    5.4.3 Navigating to a mode's last viewId

6. [Bridge Requirements for Managing Faces](Chapter-6-Bridge-Requirements-for-Managing-Faces.html)

    6.1 External Context

    6.1.1 FacesContextFactory

    6.1.2 FacesContext

    6.1.3 ExternalContext Methods

    6.1.3.1 Methods that deviate from Faces 1.2 javadoc

    6.1.3.2 Methods that conform with Faces 1.2 javadoc

    6.2 ViewHandler

    6.2.1 Method Requirements

    6.2.2 Other Methods

    6.3 StateManager

    6.4 Phase Listeners

    6.5 Expression Language Resolution

    6.5.1 Implicit Objects

    6.5.2 Bridge ELResolver

    6.5.2.1 Additional Implicit Support for Portlets

    6.5.2.2 ELResolver Requirements

    6.5.2.3 The javax.portlet.faces.preference.Preference interface

    6.6 Namespacing

    6.7 Supporting isPostback() during RenderPhase

    6.8 Supporting PreDestroy Annotated Methods

    6.8.1 Managed Bean Changes

    6.8.2 Bridge requirements

    6.9 Setting the RenderKit used by a Portlet

7. [Supporting Faces WriteBehindResponse](Chapter-7-BridgeRenderFilter.html)

    7.1 Support via a ServletFilter

    7.1.1 Example Configuration

    7.1.2 Version Considerations

    7.1.3  Performance Considerations

    7.2 Support via Portlet 2.0 ResponseWrapper

    7.2.1 Configuring the Bridge to use  a PortletResponseWrapper/WriteBehindResponse implementation

    7.2.2 Version Considerations

8. [Faces Extensions in the Bridge Environment](Chapter-8-Faces-Extensions-in-the-Bridge-Environment.html)
    
    8.1 Configuration

    8.2 Initializing Extensions

    8.3 Portlet Considerations

    8.4 General Considerations

    8.5 Cohabiting with the Bridge's ViewHandler

    8.6 Cohabiting with the Bridge's StateManager

    8.7 Excluding Attributes
