package person.lisen.learning.Javabase.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;

/**
 * Test Soft, Weak, Phantom Reference in JAVA
 * 
 * 
 * @author user
 *
 */
public class ReferenceTest {
	public static boolean isRun=  true;
	
	public static void main(String[] argc){
		
		//SoftReference
		String item1 = new String("ab");
		//won't be gc until the heap is not enough
		SoftReference<String> srf = new SoftReference<String>(item1);
		//even the direct reference is disappear.
		item1 = null;
		
		//WeakReference
		String item2 = new String("abc");
		//will be gc when gc program find it
		WeakReference<String> wrf =  new WeakReference<String>(item2);
		item2 = null;
		System.out.println(wrf.get().toString());	
		System.gc();
		//May report nullpoint error.
		//System.out.println(wrf.get().toString());
		
		//PhantomReference
		String item3 = new String("abcd");
		//Build a queue for PhantomReference. It will be put in this Reference before the memory will be free.
		final ReferenceQueue<String> referenceQueue = new ReferenceQueue<String>(); 
		//Build a Thread to monitor the queue. when it has the object, print it to the console.
		new Thread(){
			public void run(){
				while(isRun){
					Object ob = referenceQueue.poll();
					if(ob!=null){
                        Field rereferent = null;
						try {
							rereferent = Reference.class      
							        .getDeclaredField("referent");
						} catch (SecurityException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (NoSuchFieldException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}       
                        rereferent.setAccessible(true);   
						System.out.println(ob.getClass()+ob.toString());
					}
				}
			}
			
		}.run();
		//build a PhantomReference
		PhantomReference<String> prf = new PhantomReference<String>(item3,       
	                referenceQueue);   
		item3 = null;
		try {
			Thread.currentThread().sleep(3000);
	        System.gc();       
	        Thread.currentThread().sleep(3000);       
	        isRun = false;    
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
