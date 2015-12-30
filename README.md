# handling_xml

Usage sample

                String reqXML_2 = "<?xml version=\"1.0\"?>"
						    +"<BCPFORMAT "
                         +"xmlns=\"http://schemas.microsoft.com/sqlserver/2004/bulkload/format\" " 
                         +"xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">"
	                         +"<RECORD>"
		                         +"<FIELD ID=\"1\" xsi:type=\"CharTerm\" TERMINATOR=\"\\t\" " 
		                         +" MAX_LENGTH=\"12\"/>"
		                         +"<FIELD ID=\"2\" xsi:type=\"CharTerm\" TERMINATOR=\"\\t\" "
		                         +" MAX_LENGTH=\"20\" COLLATION=\"SQL_Latin1_General_CP1_CI_AS\"/>"
		                         +"<FIELD ID=\"3\" xsi:type=\"CharTerm\" TERMINATOR=\"\\r\\n\" "
		    					 +"  MAX_LENGTH=\"30\" "
		    					 +" COLLATION=\"SQL_Latin1_General_CP1_CI_AS\"/>"
	    					 +"</RECORD>"
	    					 +"<ROW>"
		    					 +" <COLUMN SOURCE=\"1\" NAME=\"age\" xsi:type=\"SQLINT\"/>"
		    					 +" <COLUMN SOURCE=\"2\" NAME=\"firstname\" xsi:type=\"SQLVARYCHAR\"/>"
		    					 +" <COLUMN SOURCE=\"3\" NAME=\"lastname\" xsi:type=\"SQLVARYCHAR\"/>"
	    					 +"</ROW>"
    					 +"</BCPFORMAT>";
		IXmlComponent xmlComp = new XmlComponent();
		xmlComp.montarObj(reqXML_2, 1);
		
		//print elements for debug propose
		xmlComp.impObj();
		
		//print object back in xml format
		System.out.println(xmlComp.getObjToString());