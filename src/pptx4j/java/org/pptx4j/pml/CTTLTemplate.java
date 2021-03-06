/*
 *  Copyright 2010, Plutext Pty Ltd.
 *   
 *  This file is part of docx4j.

    docx4j is licensed under the Apache License, Version 2.0 (the "License"); 
    you may not use this file except in compliance with the License. 

    You may obtain a copy of the License at 

        http://www.apache.org/licenses/LICENSE-2.0 

    Unless required by applicable law or agreed to in writing, software 
    distributed under the License is distributed on an "AS IS" BASIS, 
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
    See the License for the specific language governing permissions and 
    limitations under the License.

 */


package org.pptx4j.pml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CT_TLTemplate complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CT_TLTemplate">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="tnLst" type="{http://schemas.openxmlformats.org/presentationml/2006/main}CT_TimeNodeList"/>
 *       &lt;/sequence>
 *       &lt;attribute name="lvl" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" default="0" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CT_TLTemplate", propOrder = {
    "tnLst"
})
public class CTTLTemplate {

    @XmlElement(required = true)
    protected CTTimeNodeList tnLst;
    @XmlAttribute
    @XmlSchemaType(name = "unsignedInt")
    protected Long lvl;

    /**
     * Gets the value of the tnLst property.
     * 
     * @return
     *     possible object is
     *     {@link CTTimeNodeList }
     *     
     */
    public CTTimeNodeList getTnLst() {
        return tnLst;
    }

    /**
     * Sets the value of the tnLst property.
     * 
     * @param value
     *     allowed object is
     *     {@link CTTimeNodeList }
     *     
     */
    public void setTnLst(CTTimeNodeList value) {
        this.tnLst = value;
    }

    /**
     * Gets the value of the lvl property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public long getLvl() {
        if (lvl == null) {
            return  0L;
        } else {
            return lvl;
        }
    }

    /**
     * Sets the value of the lvl property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setLvl(Long value) {
        this.lvl = value;
    }

}
