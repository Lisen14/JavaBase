package person.lisen.learning.Javabase.deepclone;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;

public class MyUnitBean implements Serializable, Cloneable{
    private short ashort;  
    private char achar;  
    private byte abyte;  
    private boolean abool;  
    private long along;  
    private float afloat;  
    private double adouble;  
    private String aObject;  
    private int[] ints;  
    private String[] units; 
    
    public boolean equals(Object obj){
    		if(! (obj instanceof MyUnitBean)){
    			return false;
    		}
    		
    		MyUnitBean mub = (MyUnitBean)obj;
    		
    		return this.ashort == mub.getAshort() 
    				&& this.achar == mub.getAchar()
    				&& this.abyte == mub.getAbyte()
    				&& this.abool == mub.isAbool()
    				&& this.along == mub.getAlong()
    				&& Float.floatToIntBits(this.afloat) == Float.floatToIntBits(mub.getAfloat())
    				&& Double.doubleToLongBits(this.adouble) == Double.doubleToLongBits(mub.getAdouble())
    				&& this.aObject.equals(mub.getaObject())
    				&& Arrays.equals(this.ints, mub.getInts())
    				&& Arrays.equals(this.units, mub.units);
    		
    }
    
    public int hashCode(){
    		int result = 17;
    		result = result*31 + (int)ashort;
    		result = result*31 + (int)achar;
    		result = result*31 + (int)abyte;
    		result = result*31 + (abool?1:0);
    		result = result*31 + (int)(along^(along>>>32));
    		result = result*31 + Float.floatToIntBits(afloat);
    		long templong = Double.doubleToLongBits(adouble);
    		result = result*31 + (int)(templong^templong>>>32);
    		result = result*31 + this.aObject.hashCode();
    		result = result*31 + this.intsHashCode(ints);
    		result = result*31 + this.unitsHashCode(units);
    	
    		return result;
    }

	public short getAshort() {
		return ashort;
	}

	public void setAshort(short ashort) {
		this.ashort = ashort;
	}

	public char getAchar() {
		return achar;
	}

	public void setAchar(char achar) {
		this.achar = achar;
	}

	public byte getAbyte() {
		return abyte;
	}

	public void setAbyte(byte abyte) {
		this.abyte = abyte;
	}

	public boolean isAbool() {
		return abool;
	}

	public void setAbool(boolean abool) {
		this.abool = abool;
	}

	public long getAlong() {
		return along;
	}

	public void setAlong(long along) {
		this.along = along;
	}

	public float getAfloat() {
		return afloat;
	}

	public void setAfloat(float afloat) {
		this.afloat = afloat;
	}

	public double getAdouble() {
		return adouble;
	}

	public void setAdouble(double adouble) {
		this.adouble = adouble;
	}

	public String getaObject() {
		return aObject;
	}

	public void setaObject(String aObject) {
		this.aObject = aObject;
	}

	public int[] getInts() {
		return ints;
	}

	public void setInts(int[] ints) {
		this.ints = ints;
	}

	public String[] getUnits() {
		return units;
	}

	public void setUnits(String[] units) {
		this.units = units;
	}
	
	  private int intsHashCode(int[] aints) {  
	       int result = 17;  
	       for (int i = 0; i < aints.length; i++)  
	           result = 31 * result + aints[i];  
	       return result;  
	    }  
	   
	    private int unitsHashCode(String[] aUnits) {  
	       int result = 17;  
	       for (int i = 0; i < aUnits.length; i++)  
	           result = 31 * result + aUnits[i].hashCode();  
	       return result;  
	    }  
	    
	 public Object clone(){
		 try {
			return (MyUnitBean)super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return null;
		}
	 }
	 
	 public MyUnitBean deepclone(){
		 MyUnitBean obj= null;
		 
		 try{
			 ByteArrayOutputStream baos = new ByteArrayOutputStream();
			 ObjectOutputStream oos = new ObjectOutputStream(baos);
			 oos.writeObject(this);
			 
			 ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
			 ObjectInputStream ois =new ObjectInputStream(bais);
			 obj= (MyUnitBean)ois.readObject();
			 
		 }catch(Exception e){
			 
		 }finally{
			 
		 }
		 
		 return obj;
	 }
    
}
