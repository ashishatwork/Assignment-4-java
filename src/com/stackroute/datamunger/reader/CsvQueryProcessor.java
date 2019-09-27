package com.stackroute.datamunger.reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.stackroute.datamunger.query.DataTypeDefinitions;
import com.stackroute.datamunger.query.Header;

public class CsvQueryProcessor extends QueryProcessingEngine {


	private String fileName;
	private Header header;
	private DataTypeDefinitions dataTypes;
	BufferedReader br;
	/*
	 * parameterized constructor to initialize filename. As you are trying to
	 * perform file reading, hence you need to be ready to handle the IO Exceptions.
	 */
	public CsvQueryProcessor(String fileName) throws FileNotFoundException
	{
		this.fileName=fileName;
		br = new BufferedReader(new FileReader(this.fileName));
	}

	/*
	 * implementation of getHeader() method. We will have to extract the headers
	 * from the first line of the file.
	 */
	@Override
	public Header getHeader() throws IOException
	{
		header = new Header();
		String[] strHeader;
		br = new BufferedReader(new FileReader("data/ipl.csv"));
		strHeader = br.readLine().split(",");// read the first line

		header.setHeaders(strHeader);// populate the header object with the String array containing the header names
		return header;
	}
	

	/**
	 * This method will be used in the upcoming assignments
	 */
	@Override
	public void getDataRow() {

	}

	/*
	 * implementation of getColumnType() method. To find out the data types, we will
	 * read the first line from the file and extract the field values from it. In
	 * the previous assignment, we have tried to convert a specific field value to
	 * Integer or Double. However, in this assignment, we are going to use Regular
	 * Expression to find the appropriate data type of a field. Integers: should
	 * contain only digits without decimal point Double: should contain digits as
	 * well as decimal point Date: Dates can be written in many formats in the CSV
	 * file. However, in this assignment,we will test for the following date
	 * formats('dd/mm/yyyy',
	 * 'mm/dd/yyyy','dd-mon-yy','dd-mon-yyyy','dd-month-yy','dd-month-yyyy','yyyy-mm-dd')
	 */
	@Override
	public DataTypeDefinitions getColumnType() throws IOException
	{
		// TODO Auto-generated method stub
		
		// checking for Integer
		
		// checking for floating point numbers
				
		// checking for date format dd/mm/yyyy
		
		// checking for date format mm/dd/yyyy
		
		// checking for date format dd-mon-yy
		
		// checking for date format dd-mon-yyyy
		
		// checking for date format dd-month-yy
		
		// checking for date format dd-month-yyyy
		
		// checking for date format yyyy-mm-dd

		dataTypes=new DataTypeDefinitions();
		br = new BufferedReader(new FileReader("data/ipl.csv"));

		String[] head=br.readLine().split(",");
		boolean[] isInteger=new boolean[head.length];
		boolean[] isDate=new boolean[head.length];
		String[] dataType= new String[head.length];
		String[] data=br.readLine().split(",");
		for(int i=0;i<data.length;i++)
		{
			try
			{
				int column=Integer.parseInt(data[i]);
				isInteger[i]=true;
				isDate[i]=false;
			}
			catch (NumberFormatException e)
			{
				isInteger[i]=false;
				if(data[i].matches("^\\d{4}\\-(0?[1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01])$"))
					isDate[i]=true;

			}
		}

		for(int i=0;i<data.length;i++)
		{
			if(isInteger[i])
				dataType[i]="java.lang.Integer";
			else {
					if(isDate[i]==true)
						dataType[i]="java.util.Date";
					else
						dataType[i] = "java.lang.String";
			}
		}
		dataType[17]="java.lang.Object";
		dataTypes.setDataTypes(dataType);
		return dataTypes;
	}
	}
	
	

	
	


