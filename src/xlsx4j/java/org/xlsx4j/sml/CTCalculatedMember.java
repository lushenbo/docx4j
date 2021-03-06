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


package org.xlsx4j.sml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CT_CalculatedMember complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CT_CalculatedMember">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence minOccurs="0">
 *         &lt;element name="extLst" type="{http://schemas.openxmlformats.org/spreadsheetml/2006/main}CT_ExtensionList" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="name" use="required" type="{http://schemas.openxmlformats.org/spreadsheetml/2006/main}ST_Xstring" />
 *       &lt;attribute name="mdx" use="required" type="{http://schemas.openxmlformats.org/spreadsheetml/2006/main}ST_Xstring" />
 *       &lt;attribute name="memberName" type="{http://schemas.openxmlformats.org/spreadsheetml/2006/main}ST_Xstring" />
 *       &lt;attribute name="hierarchy" type="{http://schemas.openxmlformats.org/spreadsheetml/2006/main}ST_Xstring" />
 *       &lt;attribute name="parent" type="{http://schemas.openxmlformats.org/spreadsheetml/2006/main}ST_Xstring" />
 *       &lt;attribute name="solveOrder" type="{http://www.w3.org/2001/XMLSchema}int" default="0" />
 *       &lt;attribute name="set" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CT_CalculatedMember", propOrder = {
    "extLst"
})
public class CTCalculatedMember {

    protected CTExtensionList extLst;
    @XmlAttribute(required = true)
    protected String name;
    @XmlAttribute(required = true)
    protected String mdx;
    @XmlAttribute
    protected String memberName;
    @XmlAttribute
    protected String hierarchy;
    @XmlAttribute
    protected String parent;
    @XmlAttribute
    protected Integer solveOrder;
    @XmlAttribute
    protected Boolean set;

    /**
     * Gets the value of the extLst property.
     * 
     * @return
     *     possible object is
     *     {@link CTExtensionList }
     *     
     */
    public CTExtensionList getExtLst() {
        return extLst;
    }

    /**
     * Sets the value of the extLst property.
     * 
     * @param value
     *     allowed object is
     *     {@link CTExtensionList }
     *     
     */
    public void setExtLst(CTExtensionList value) {
        this.extLst = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the mdx property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMdx() {
        return mdx;
    }

    /**
     * Sets the value of the mdx property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMdx(String value) {
        this.mdx = value;
    }

    /**
     * Gets the value of the memberName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMemberName() {
        return memberName;
    }

    /**
     * Sets the value of the memberName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMemberName(String value) {
        this.memberName = value;
    }

    /**
     * Gets the value of the hierarchy property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHierarchy() {
        return hierarchy;
    }

    /**
     * Sets the value of the hierarchy property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHierarchy(String value) {
        this.hierarchy = value;
    }

    /**
     * Gets the value of the parent property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParent() {
        return parent;
    }

    /**
     * Sets the value of the parent property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParent(String value) {
        this.parent = value;
    }

    /**
     * Gets the value of the solveOrder property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public int getSolveOrder() {
        if (solveOrder == null) {
            return  0;
        } else {
            return solveOrder;
        }
    }

    /**
     * Sets the value of the solveOrder property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSolveOrder(Integer value) {
        this.solveOrder = value;
    }

    /**
     * Gets the value of the set property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isSet() {
        if (set == null) {
            return false;
        } else {
            return set;
        }
    }

    /**
     * Sets the value of the set property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSet(Boolean value) {
        this.set = value;
    }

}
