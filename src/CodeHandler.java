
public class CodeHandler
{
	public static String encoderNRZ_L (String stream)
	{
		String code = "";
		for(int i=0; i<stream.length();i++)
		{
			if(stream.charAt(i)=='1')
				code+="--";
			else if (stream.charAt(i)=='0')
				code+="++";
		}
		return code;
	}
	public static String encoderNRZI (String stream)
	{
		String code = "";
		
		if(stream.charAt(0)=='1')
			code+="a++";
		else
			code+="--";
			
		for(int i=1; i<stream.length();i++)
		{
			if(stream.charAt(i)=='1')
			{
				if(code.charAt(code.length()-1)=='+')
					code+="--";
				else
					code+="++";
			}
				
			else if (stream.charAt(i)=='0')
			{
				if(code.charAt(code.length()-1)=='+')
					code+="++";
				else
					code+="--";
			}
				
		}
		return code;
	}
	
	public static String encoderBipolar (String stream)
	{
		String code ="";
		int last = -1;
		for(int i=0; i<stream.length();i++)
		{
			if(stream.charAt(i)=='1')
			{
				if(last== -1)
					code+="++";	
				else
					code+="--";
				last =-last;
							
			}
			else if (stream.charAt(i)=='0')
				code+="00";
		}
		return code;
	}
	
	public static String encoderPsedoternary (String stream)
	{
		String code ="";
		int last = -1;
		for(int i=0; i<stream.length();i++)
		{
			if(stream.charAt(i)=='0')
			{
				if(last== -1)
					code+="++";	
				else
					code+="--";
				last =-last;
							
			}
			else if (stream.charAt(i)=='1')
				code+="00";
		}
		return code;
	}
		
	public static String encoderManchester (String stream)
	{
		String code ="";

		for(int i=0; i<stream.length();i++)
		{
			if(stream.charAt(i)=='0')
				code+="+-";
							
			
			else if (stream.charAt(i)=='1')
				code+="-+";
		}
		return code;
	}
	
	public static String encoderDiffrential (String stream)
	{
		String code ="";
		if(stream.charAt(0)=='0')
			code+="a+-";
		else
			code+="-+";
		
		for(int i=1; i<stream.length();i++)
		{
			if(stream.charAt(i)=='0')
			{
				if(code.charAt(code.length()-1)=='+')
					code+="-+";
				else
					code+="+-";
			}
			else
			{
				if(code.charAt(code.length()-1)=='+')
					code+="+-";
				else
					code+="-+";
			}
				
							
		}
		return code;
	}
	
	public static String encoderB8ZS (String stream)
	{
		String code ="";
		int zeros=0;
		int last=-1;
		for(int i=0 ; i<stream.length() ; i++)
		{
			if(stream.charAt(i)=='0')
			{
				zeros++;
				if(zeros==8)
				{
					if(last == -1)
						code+= "000000--++00++--";
					else
						code+= "000000++--00--++";
					zeros=0;
				}
					
			}
			
			else
			{
				if(zeros !=0)
				{
					for(int j=0;j<zeros;j++)
						code+="00";
					zeros=0;
				}
				if(last == -1)
					code+="++";
				else
					code+="--";
				last = -last;
			}
		
		}
			if(zeros !=0)
			{
					for(int j=0;j<zeros;j++)
						code+="00";
			}
		return code;
	}
	
	public static String encoderHDB3 (String stream)
	{
		String code ="";
		int num1s = 1;
		int last = -1;
		int zeros=0;
		
		for(int i=0 ; i<stream.length() ; i++)
		{
			if(stream.charAt(i)=='0')
			{
				zeros++;
				if(zeros==4)
				{
					if(last == -1)
					{
						if(num1s%2==0)//even
						{
							code+="++0000++";
							last = 1;
						}
							
						else//odd
							code+="000000--";
						
					}
						
					else
					{
						if(num1s%2==0)//even
						{
							code+="--0000--";
							last = -1;
						}
							
						else//odd
							code+="000000++";
					}
						
					zeros=0;
					num1s=0;
				}
					
			}
			
			else
			{
				if(zeros !=0)
				{
					for(int j=0;j<zeros;j++)
						code+="00";
					zeros=0;
				}
				if(last == -1)
					code+="++";
				else
					code+="--";
				last = -last;
				num1s++;
			}
		
		}
		
		if(zeros !=0)
			{
					for(int j=0;j<zeros;j++)
						code+="00";
			}
		return code;
	}
	
	public static String decoderNRZ_L (String code)
	{
		String stream = "";
		for(int i=0; i<code.length(); i++)
		{
			if(code.charAt(i)=='0')
				stream+="E";
			else if(code.charAt(i)=='+')
				stream+="0";
			else
				stream+="1";
		}
		return stream;
	}
	
	public static String decoderNRZI (String code)
	{
		String stream = "";
		code="-"+code;
		for(int i=1; i<code.length(); i++)
		{
			if(code.charAt(i)=='0')
				stream+="E";
			else
			{
				char before= code.charAt(i-1);
				char current = code.charAt(i);
				
				if(current == before)
					stream+="0";
				else
					stream+="1";
			}
		
		}
		return stream;
	}
	
	public static String decoderBipolar (String code)
	{
		String stream="";
		int last = -1;
		for(int i=0; i<code.length(); i++)
		{
			if(code.charAt(i)== '0')
				stream+="0";
			else
			{
				if(code.charAt(i)== '+' && last ==1 || code.charAt(i)== '-' && last ==-1)
					stream+="E";
				else
				{
					stream+="1";
					last = - last;
				}
				
			}
				
		}
		return stream;
	}
	
	public static String decoderPsedoternary (String code)
	{
		String stream="";
		int last = -1;
		for(int i=0; i<code.length(); i++)
		{
			if(code.charAt(i)== '0')
				stream+="1";
			else
			{
				if(code.charAt(i)== '+' && last ==1 || code.charAt(i)== '-' && last ==-1)
					stream+="E";
				else
				{
					stream+="0";
					last = - last;
				}
				
			}
				
		}
		return stream;
	}
	
	public static String decoderManchester (String code)
	{
		String stream ="";
		for(int i=0; i<code.length(); i++)
		{
			if(code.charAt(i)== '0')
				stream += "E";
			else
			{
				if(code.charAt(i)== '+')
					stream += "0";
				else
					stream += "1";
			}
			
				
		}
		return stream;
		
		
	}
	
	
	
	public static String decoderDiffrential (String code)
	{
		String stream ="";
		code = "+"+code;
		for(int i=1; i<code.length(); i++)
		{
			if(code.charAt(i)== '0')
				stream += "E";
			else
			{
				char before= code.charAt(i-1);
				char current = code.charAt(i);
				
				if(current == before)
					stream+="0";
				else
					stream+="1";
			}
			
				
		}
		return stream;
		
		
	}
	
	public static String decoderB8ZS (String code)
	{
		String stream = "";
		int zeros = 0;
		int last = -1;
		for(int i=0; i<code.length();i++)
		{
			if(code.charAt(i)=='0')
			{
				zeros++;
				if(zeros==3)
				{
					if( i+5 >=code.length() )
					{
						stream += "000";
					}
					else
					{	
						if( isB8ZSCode(code.substring(i+1,i+6),last) )
						{
							stream +="00000000";
							i+=5;
						}
							
						else
							stream += "000";
					}
						
					
						
						
					
					zeros=0;	
				}
					
			}
			
			else
			{
				if(zeros != 0)
						for(int j=0; j<zeros ; j++)
							stream+="0";
					zeros=0;
				if(code.charAt(i)=='+' && last ==1 || code.charAt(i)=='-' && last ==-1)
					stream+="E";
				else
				{
					
					stream+="1";
					last = -last;
				}
			}
		}
			if(zeros != 0)
				for(int j=0; j<zeros ; j++)
					stream+="0";
		return stream;
	}
	
	private static boolean isB8ZSCode(String code,int last)
	{
		if(last==1)
			return code.equals("+-0-+");
		else
			return code.equals("-+0+-");
	}
	
		public static String decoderHDB3 (String code)
	{
		String stream = "";
		int last = -1;
		int num1s = 1;
		for(int i=0; i<code.length();i++)
		{
			if(i+3 >= code.length())
			{
					if(code.charAt(i)=='0')
					stream+="0";
					else
					{
						if(last == 1 && code.charAt(i)=='+' || last == -1 && code.charAt(i)=='-')
							stream+="E";
						else
						{
							stream+="1";
							last = - last;
						}	
						
					}
			}
					
			else
			{
				if( isHDB3Code(code.substring(i,i+4),last,num1s) )
				{
					stream += "0000";
					i +=3;
					if(num1s % 2 == 0)
						last = -last; 
					num1s =0;
					
				}
				else
				{
					if(code.charAt(i)=='0')
						stream+="0";
					else
					{
						if(last == 1 && code.charAt(i)=='+' || last == -1 && code.charAt(i)=='-')
							stream+="E";
						else
						{
							stream+="1";
							last = - last;
							num1s++;
						}	
						
					}
				}
			}
		}
			
		return stream;
	}
	
	private static boolean isHDB3Code(String code,int last,int num1s)
	{
		if(last ==-1)//-
		{
			if(num1s %2 !=0 )//odd
				return code.equals("000-");
			else//even
				return code.equals("+00+");
		}
		else //+
		{
			if(num1s %2 !=0 )//odd
				return code.equals("000+");
			else//even
				return code.equals("-00-");
		}
	}
	
	public static void main(String [] args)
	{
		System.out.println(decoderHDB3("+-000-+00+-+-00-0+0"));
	}
}