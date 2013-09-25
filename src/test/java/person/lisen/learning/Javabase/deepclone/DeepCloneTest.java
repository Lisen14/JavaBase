package person.lisen.learning.Javabase.deepclone;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import person.lisen.learning.Javabase.deepclone.MyUnitBean;

public class DeepCloneTest {
	MyUnitBean obj1 = new MyUnitBean();
	MyUnitBean obj2;
	
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
		mub.setUnits(new String[]{"123","12","1"});
	}
	
	@Test
	public void testShadowClone() throws Exception{
		initialObj(obj1);
		obj2 = (MyUnitBean)obj1.clone();
		Assert.assertTrue(obj1.getAbyte() == obj2.getAbyte());
		Assert.assertTrue(obj1.getInts() == obj2.getInts());
		byte b = (byte)2;
		obj2.setAbyte(b);
		obj2.setInts(new int[]{1,2,3,4});
		Assert.assertFalse(obj1.getAbyte() == obj2.getAbyte());
		Assert.assertFalse(obj1.getInts() == obj2.getInts());
	}
	
	@Test
	public void testDeepClone(){
		initialObj(obj1);
		obj2 = obj1.deepclone();
		Assert.assertTrue(obj1.getAbyte() == obj2.getAbyte());
		Assert.assertFalse(obj1.getInts() == obj2.getInts());
		byte b = (byte)2;
		obj2.setAbyte(b);
		obj2.setInts(new int[]{1,2,3,4});
		Assert.assertFalse(obj1.getAbyte() == obj2.getAbyte());
		Assert.assertFalse(obj1.getInts() == obj2.getInts());
	}
}
