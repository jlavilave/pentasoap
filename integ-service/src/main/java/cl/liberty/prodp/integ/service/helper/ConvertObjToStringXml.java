package cl.liberty.prodp.integ.service.helper;

import java.io.ByteArrayInputStream;
import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import cl.liberty.prodp.integ.commons.enums.CodigosComunesEnum;
import cl.liberty.prodp.integ.commons.exceptions.IntegSoapPentaExcepcion;

@Component("convertObjToStringXml")
public class ConvertObjToStringXml {
	
	private static final Logger LOGGER = Logger.getLogger(ConvertObjToStringXml.class);
	
	public Object xmlToObject(String xml, Class classesToBeBound) throws JAXBException{
		
		StringReader outputWriter = new StringReader(xml);
		
		JAXBContext jaxbContext = JAXBContext.newInstance(classesToBeBound);
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		
		return unmarshaller.unmarshal(outputWriter);
		
	}
	
	public <T> String objectToXml(T t, Class classesToBeBound) {
		
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(classesToBeBound);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			StringWriter sw = new StringWriter();
			jaxbMarshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
			jaxbMarshaller.marshal(t, sw);
			String xmlString = sw.toString();
//			return this.formatStringXml(xmlString);
			return xmlString;
		} catch (JAXBException e) {
			LOGGER.error(ConvertObjToStringXml.class.getSimpleName() + " : " + e, e);
			throw new IntegSoapPentaExcepcion(
					CodigosComunesEnum.ERROR_CONVERSION_XML.getCodigo(), e.getMessage());
		} catch (Exception e) {
			LOGGER.error(ConvertObjToStringXml.class.getSimpleName() + " : " + e, e);
			throw new IntegSoapPentaExcepcion(
					CodigosComunesEnum.ERROR_NO_DIFERENCIABLE.getCodigo(), e.getMessage());
		}
	}
	
	
	private String formatStringXml(String xml) {
		
		StringWriter stringWriter = new StringWriter();
		
		    try {
				Document document = DocumentBuilderFactory
						.newInstance()
						.newDocumentBuilder()
						.parse(new InputSource(new ByteArrayInputStream(xml
								.getBytes("utf-8"))));
				XPath xPath = XPathFactory.newInstance().newXPath();
				NodeList nodeList = (NodeList) xPath.evaluate(
						"//text()[normalize-space()='']", document,
						XPathConstants.NODESET);
				for (int i = 0; i < nodeList.getLength(); ++i) {
					Node node = nodeList.item(i);
					node.getParentNode().removeChild(node);
				}
				Transformer transformer = TransformerFactory.newInstance()
						.newTransformer();
				transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
				transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION,
						"yes");
				transformer.setOutputProperty(OutputKeys.INDENT, "yes");
				transformer.setOutputProperty(
						"{http://xml.apache.org/xslt}indent-amount", "4");
				StreamResult streamResult = new StreamResult(stringWriter);
				transformer.transform(new DOMSource(document), streamResult);
				return stringWriter.toString();
			} catch (Exception e) {
				LOGGER.error(ConvertObjToStringXml.class.getSimpleName() + " : " + e, e);
				throw new IntegSoapPentaExcepcion(
						CodigosComunesEnum.ERROR_NO_DIFERENCIABLE.getCodigo(), e.getMessage());
			}
	}
	
}
