/*
 The integration developer needs to create the method processData 
 This method takes Message object of package com.sap.gateway.ip.core.customdev.util 
which includes helper methods useful for the content developer:
The methods available are:
    public java.lang.Object getBody()
	public void setBody(java.lang.Object exchangeBody)
    public java.util.Map<java.lang.String,java.lang.Object> getHeaders()
    public void setHeaders(java.util.Map<java.lang.String,java.lang.Object> exchangeHeaders)
    public void setHeader(java.lang.String name, java.lang.Object value)
    public java.util.Map<java.lang.String,java.lang.Object> getProperties()
    public void setProperties(java.util.Map<java.lang.String,java.lang.Object> exchangeProperties) 
    public void setProperty(java.lang.String name, java.lang.Object value)
    public java.util.List<com.sap.gateway.ip.core.customdev.util.SoapHeader> getSoapHeaders()
    public void setSoapHeaders(java.util.List<com.sap.gateway.ip.core.customdev.util.SoapHeader> soapHeaders) 
       public void clearSoapHeaders()
 */
import com.sap.gateway.ip.core.customdev.util.Message;
import javax.xml.namespace.QName;
import com.sap.gateway.ip.core.customdev.util.SoapHeader;

def Message processData(Message message) {
    //Body 
       def headers = new ArrayList();
     def uuidCode = UUID.randomUUID().toString();
     def xml = "<?xml version=\"1.0\" encoding=\"utf-8\"?><messageId xmlns=\"http://www.sap.com/webas/640/soap/features/messageId/\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">urn:uuid:" + uuidCode + "</messageId>";
     def header = new SoapHeader(new QName("http://www.sap.com/webas/640/soap/features/messageId/", "messageId"), xml, false, "");
     headers.add(header);
     message.setSoapHeaders(headers);
     return message;
}