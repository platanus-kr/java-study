package com.example.webapptest3.xmlparse;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Slf4j
@Service
public class XmlParserService {
    public void parse(String xml) throws ParserConfigurationException, IOException, SAXException {
        //InputSource is = new InputSource(new StringReader(xml));
        //
        //DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        //DocumentBuilder builder = factory.newDocumentBuilder();
        //Document doc = builder.parse(is);
        //
        //NodeList nodeList = doc.getElementsByTagName("BranchArea");
        //
        //for (int i = 0; i < nodeList.getLength(); i++) {
        //    Element elem = (Element) nodeList.item(i);
        //    System.out.println(elem.getElementsByTagName("DeliveryType").item(0).getTextContent()+
        //                    elem.getElementsByTagName("AreaNo").item(0).getTextContent()+
        //                    elem.getElementsByTagName("ActivationYn").item(0).getTextContent()
        //            );
        //}

         XmlMapper xmlMapper = new XmlMapper();
         xmlMapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
         Payload result = xmlMapper.readValue(xml, Payload.class);
         System.out.println(result);

        /*
        * https://stackoverflow.com/questions/54597977/cannot-deserialize-convert-unwrapped-list-when-its-second-in-class-using-jack
        * */
    }

    @Data
    public static class Payload {
        //@JsonProperty("Body")
        @JacksonXmlProperty(localName = "Body")
        private Body Body;
        @Data
        @JacksonXmlRootElement(localName = "Body")
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Body {
            //@JsonProperty("RetrieveBranchResponse")
            @JacksonXmlProperty(localName = "RetrieveBranchResponse")
            private RetrieveBranchResponse retrieveBranchResponse;
            @Data
            @JacksonXmlRootElement(localName = "RetrieveBranchResponse")
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class RetrieveBranchResponse {
                @JsonProperty("BranchAreas")
                @JacksonXmlProperty(localName = "BranchAreas")
                private BranchAreas branchAreas;
                @Data
                @JacksonXmlRootElement(localName = "BranchAreas")
                @JsonIgnoreProperties(ignoreUnknown = true)
                public static class BranchAreas {
                    //@JsonProperty("BranchArea")
                    @JacksonXmlElementWrapper(useWrapping = false)
                    @JacksonXmlProperty(localName = "BranchArea")
                    private List<BranchArea> branchArea = new ArrayList<>();
                    @Data
                    @JacksonXmlRootElement(localName = "BranchArea")
                    //@JsonIgnoreProperties(ignoreUnknown = true)
                    public static class BranchArea {
                        //@JacksonXmlText // 이건 attribute를 가져온다는 소리임
                        //@JsonProperty("DeliveryType")
                        @JacksonXmlProperty(localName = "DeliveryType")
                        private String deliveryType;
                        //@JacksonXmlText
                        //@JsonProperty("AreaNo")
                        @JacksonXmlProperty(localName = "AreaNo")
                        private String areaNo;
                        //@JacksonXmlText
                        //@JsonProperty("ActivationYn")
                        @JacksonXmlProperty(localName = "ActivationYn")
                        private String activationYn;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        XmlParserService xmlParserService = new XmlParserService();
        xmlParserService.parse("<?xml version='1.0' encoding='utf-8'?>\n" +
                "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\"\n" +
                "                  xmlns:n=\"http://shop.canxan.com/\">\n" +
                "    <soapenv:Body>\n" +
                "        <n:RetrieveBranchResponse>\n" +
                "            <n:RequestID>PLATEST</n:RequestID>\n" +
                "            <n:ResponseType>SUCCESS</n:ResponseType>\n" +
                "            <n:ResponsseTime>99999</n:ResponsseTime>\n" +
                "            <BranchId>id</BranchId>\n" +
                "            <BranchName>아이슬란드</BranchName>\n" +
                "            <PossibleDeliveryTypes>\n" +
                "                <PossibleDeliveryType>TODAY_DELIVERY</PossibleDeliveryType>\n" +
                "            </PossibleDeliveryTypes>\n" +
                "            <BranchContractInfo>12313231</BranchContractInfo>\n" +
                "            <ActivationYn>true</ActivationYn>\n" +
                "            <BranchAreas>\n" +
                "                <BranchArea>\n" +
                "                    <DeliveryType>TODAY_DELIVERY</DeliveryType>\n" +
                "                    <AreaNo>182</AreaNo>\n" +
                "                    <ActivationYn>true</ActivationYn>\n" +
                "                </BranchArea>\n" +
                "                <BranchArea>\n" +
                "                    <DeliveryType>TODAY_DELIVERY</DeliveryType>\n" +
                "                    <AreaNo>89</AreaNo>\n" +
                "                    <ActivationYn>true</ActivationYn>\n" +
                "                </BranchArea>\n" +
                "                <BranchArea>\n" +
                "                    <DeliveryType>TODAY_DELIVERY</DeliveryType>\n" +
                "                    <AreaNo>7001117</AreaNo>\n" +
                "                    <ActivationYn>false</ActivationYn>\n" +
                "                </BranchArea>\n" +
                "             </BranchAreas>\n" +
                "        </n:RetrieveBranchResponse>\n" +
                "    </soapenv:Body>\n" +
                "</soapenv:Envelope>");
    }
}