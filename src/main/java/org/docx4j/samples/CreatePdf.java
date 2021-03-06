/*
 *  Copyright 2007-2008, Plutext Pty Ltd.
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

package org.docx4j.samples;

import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.xml.bind.JAXBException;

import org.docx4j.XmlUtils;
import org.docx4j.convert.out.pdf.viaXSLFO.PdfSettings;
import org.docx4j.fonts.IdentityPlusMapper;
import org.docx4j.fonts.Mapper;
import org.docx4j.fonts.PhysicalFont;
import org.docx4j.fonts.PhysicalFonts;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.WordprocessingML.MainDocumentPart;

public class CreatePdf extends AbstractSample {
	    
	    public static void main(String[] args) 
	            throws Exception {

	    	boolean save = true;
	    	
			try {
				getInputFilePath(args);
			} catch (IllegalArgumentException e) {
		    	inputfilepath = System.getProperty("user.dir") + "/sample-docs/word/sample-docx.xml";
//		    	inputfilepath = System.getProperty("user.dir") + "/docs/Docx4j_GettingStarted.xml";	    	
			}
	    	
	    	
			WordprocessingMLPackage wordMLPackage;
			if (inputfilepath==null) {
				// Create a docx
				
				// If this is to be saved..
				inputfilepath = System.getProperty("user.dir") + "/tmp/output";
				/*
				 * NB, this currently works nicely with
				 * viaIText, and viaXSLFO (provided
				 * you view with Acrobat Reader .. it
				 * seems to overwhelm pdfviewer, which
				 * is weird, since viaIText works in both).
				 */
				
				 wordMLPackage = WordprocessingMLPackage.createPackage();
				createContent(wordMLPackage.getMainDocumentPart());	
			} else {
				// Load .docx or Flat OPC .xml
				wordMLPackage = WordprocessingMLPackage.load(new java.io.File(inputfilepath));
			}
			// Set up font mapper
			Mapper fontMapper = new IdentityPlusMapper();
			wordMLPackage.setFontMapper(fontMapper);
			
			// Example of mapping missing font Algerian to installed font Comic Sans MS
			PhysicalFont font 
					= PhysicalFonts.getPhysicalFonts().get("Comic Sans MS");
			fontMapper.getFontMappings().put("Algerian", font);
			
			// As of docx4j 2.5.0, only viaXSLFO is supported.
			// The viaIText and viaHTML source code can be found in src/docx4j-extras directory
			
			org.docx4j.convert.out.pdf.PdfConversion c 
//				= new org.docx4j.convert.out.pdf.viaHTML.Conversion(wordMLPackage);
				= new org.docx4j.convert.out.pdf.viaXSLFO.Conversion(wordMLPackage);
//				= new org.docx4j.convert.out.pdf.viaIText.Conversion(wordMLPackage);
			
			((org.docx4j.convert.out.pdf.viaXSLFO.Conversion)c).setSaveFO(new java.io.File(inputfilepath+".fo"));
			
			if (save) {
				((org.docx4j.convert.out.pdf.viaXSLFO.Conversion)c).setSaveFO(
						new java.io.File(inputfilepath + ".fo"));
				OutputStream os = new java.io.FileOutputStream(inputfilepath + ".pdf");			
				c.output(os, new PdfSettings() );
				System.out.println("Saved " + inputfilepath + ".pdf");
			}  
	    }
	    
	    public static void createContent(MainDocumentPart wordDocumentPart ) {
	    	
	    	try {
	    		// Do this explicitly, since we need
	    		// it in order to create our content
				PhysicalFonts.discoverPhysicalFonts(); 						
																
				Map<String, PhysicalFont> physicalFontMap = PhysicalFonts.getPhysicalFonts();			
				Iterator physicalFontMapIterator = physicalFontMap.entrySet().iterator();
				while (physicalFontMapIterator.hasNext()) {
				    Map.Entry pairs = (Map.Entry)physicalFontMapIterator.next();
				    if(pairs.getKey()==null) {
				    	pairs = (Map.Entry)physicalFontMapIterator.next();
				    }
				    String fontName = (String)pairs.getKey();
				    PhysicalFont pf = (PhysicalFont)pairs.getValue();
				    
				    System.out.println("Added paragraph for " + fontName);
				    addObject(wordDocumentPart, sampleText, fontName );

				    // bold, italic etc
				    PhysicalFont pfVariation = PhysicalFonts.getBoldForm(pf);
				    if (pfVariation!=null) {
					    addObject(wordDocumentPart, sampleTextBold, pfVariation.getName() );
				    }
				    pfVariation = PhysicalFonts.getBoldItalicForm(pf);
				    if (pfVariation!=null) {
					    addObject(wordDocumentPart, sampleTextBoldItalic, pfVariation.getName() );
				    }
				    pfVariation = PhysicalFonts.getItalicForm(pf);
				    if (pfVariation!=null) {
					    addObject(wordDocumentPart, sampleTextItalic, pfVariation.getName() );
				    }
				    
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}    		    
	    	
	    }
	    
	    static void addObject(MainDocumentPart wordDocumentPart, String template, String fontName ) throws JAXBException {
	    	
		    HashMap substitution = new HashMap();
		    substitution.put("fontname", fontName);
		    Object o = XmlUtils.unmarshallFromTemplate(template, substitution);
		    wordDocumentPart.addObject(o);    		    
	    	
	    }
	    
	    final static String sampleText = "<w:p xmlns:w=\"http://schemas.openxmlformats.org/wordprocessingml/2006/main\">"
			+"<w:r>"
			+"<w:rPr>"
				+"<w:rFonts w:ascii=\"${fontname}\" w:eastAsia=\"${fontname}\" w:hAnsi=\"${fontname}\" w:cs=\"${fontname}\" />"
			+"</w:rPr>"
			+"<w:t xml:space=\"preserve\">${fontname}</w:t>"
		+"</w:r>"
		+"</w:p>";
	    final static String sampleTextBold =	"<w:p xmlns:w=\"http://schemas.openxmlformats.org/wordprocessingml/2006/main\">"	+"<w:r>"
			+"<w:rPr>"
				+"<w:rFonts w:ascii=\"${fontname}\" w:eastAsia=\"${fontname}\" w:hAnsi=\"${fontname}\" w:cs=\"${fontname}\" />"
				+"<w:b />"
			+"</w:rPr>"
			+"<w:t>${fontname} bold;</w:t>"
		+"</w:r>"
		+"</w:p>";
	    final static String sampleTextItalic =	"<w:p xmlns:w=\"http://schemas.openxmlformats.org/wordprocessingml/2006/main\">"	+"<w:r>"
			+"<w:rPr>"
				+"<w:rFonts w:ascii=\"${fontname}\" w:eastAsia=\"${fontname}\" w:hAnsi=\"${fontname}\" w:cs=\"${fontname}\" />"
				+"<w:i />"
			+"</w:rPr>"
			+"<w:t>${fontname} italic; </w:t>"
		+"</w:r>"
		+"</w:p>";
	    final static String sampleTextBoldItalic ="<w:p xmlns:w=\"http://schemas.openxmlformats.org/wordprocessingml/2006/main\">"
	    	+"<w:r>"
			+"<w:rPr>"
				+"<w:rFonts w:ascii=\"${fontname}\" w:eastAsia=\"${fontname}\" w:hAnsi=\"${fontname}\" w:cs=\"${fontname}\" />"
				+"<w:b />"
				+"<w:i />"
			+"</w:rPr>"
			+"<w:t>${fontname} bold italic</w:t>"
		+"</w:r>"
	+"</w:p>";
	    
	    
	}