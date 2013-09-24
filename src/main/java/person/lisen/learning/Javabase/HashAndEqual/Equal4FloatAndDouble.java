/**
 * 
 */
package person.lisen.learning.Javabase.HashAndEqual;

import java.util.Date;

/**
 * @author user
覆写equals方法
1  使用instanceof操作符检查“实参是否为正确的类型”。
2  对于类中的每一个“关键域”，检查实参中的域与当前对象中对应的域值。
3. 对于非float和double类型的原语类型域，使用==比较；
4  对于对象引用域，递归调用equals方法；
5  对于float域，使用Float.floatToIntBits(afloat)转换为int，再使用==比较；
6  对于double域，使用Double.doubleToLongBits(adouble)转换为int，再使用==比较；
7  对于数组域，调用Arrays.equals方法。
 * 
 *
 */
class FloatSelf{
	private float item = 1f;
	
	public float getItem(){
		return item;
	}
	
	public boolean equals(Object object){
		//1. use instanceof check whether the item is the right type
		if(!(object instanceof FloatSelf)){
			return false;
		}
		
		//2 compare the key field value, if the field it float or double,use floatToIntBits or doubleToIntBits
		int thisValue = Float.floatToIntBits(this.item);
		int objectValue = Float.floatToIntBits(((FloatSelf)object).getItem());
		
		if(thisValue==objectValue){
			return true;
		}else{
			return false;
		}
	}
	
} 

class DoubleSelf{
	private float item = 1f;
	
	public float getItem(){
		return item;
	}
}

public class Equal4FloatAndDouble {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//just test the differences performance between the new way and common way;
		float item1 = 1.12323423423523542f;
		float item2 = 1.12323423422523542f;
		float item3 = 1.12323423423523542f;
		float item4 = 1.12323423423523542f;
		
		Date begin = new Date();
		for(int i=0;i<=200000000;i++){
			if(item1==item2){
				
			}
			//if(Float.floatToIntBits(item1)==Float.floatToIntBits(item2)){
				
			//}
			if(item3==item4){
				
			}
			//if(Float.floatToIntBits(item3)==Float.floatToIntBits(item4)){
			
			//}
			
		}
		Date end = new Date();
		System.out.println((end.getTime()-begin.getTime())+"millionsec");
	}

}
