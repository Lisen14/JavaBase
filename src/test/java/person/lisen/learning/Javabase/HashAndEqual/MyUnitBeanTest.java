package person.lisen.learning.Javabase.HashAndEqual;


import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import person.lisen.learning.Javabase.HashAndEqual.MyUnitBean;


/**
 * Test 
 * 
 * @author user
 *
 */
public class MyUnitBeanTest {
	
	MyUnitBean obj1 = new MyUnitBean();
	MyUnitBean obj2 = new MyUnitBean();
	
	private void initialObj(MyUnitBean mub){
		
		byte b = (byte)1;
		mub.setAbool(true);
		mub.setAbyte(b);
		mub.setAchar('c');
		mub.setAdouble(12.3);
		mub.setAfloat(12.4f);
		mub.setAlong(123);
		mub.setaObject("123123");
		mub.setAshort((short)12);
		mub.setInts(new int[]{1,2,3});
		mub.setUnits(new String[]{"123","121","1"});
	}
	
	private void initialObj1(MyUnitBean mub){
		
		byte b = (byte)1;
		mub.setAbool(false);
		mub.setAbyte(b);
		mub.setAchar('c');
		mub.setAdouble(12.3);
		mub.setAfloat(12.4f);
		mub.setAlong(123);
		mub.setaObject("123123");
		mub.setAshort((short)12);
		mub.setInts(new int[]{1,2,3});
		mub.setUnits(new String[]{"123","12","1"});
	}
	
	
	
	@Before
	public void beforetestEqual(){
		initialObj(obj1);
		initialObj1(obj2);
	}
	
	
	@Test
	public void testEqual(){
		Assert.assertTrue(obj1.equals(obj2));
	}
	
	@Test
	public void testHashCode(){
		Assert.assertTrue(obj1.hashCode()==obj2.hashCode());
	}
	
	
}
