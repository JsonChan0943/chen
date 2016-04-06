package com.tlal.vms.base.utils;

import java.util.Arrays;
import java.util.List;

import com.tlal.vms.base.enums.enumi.IEnum;
import com.tlal.vms.base.enums.enumi.ValueIEnum;

/**
 * 枚举类的工具类
 *
 */
public class EnumUtil{
	
	//========================================getNameByValue----String=======================================
	public static String getNameByValue(Class<? extends IEnum<String>> enumClass, String value){
		IEnum<String> em = (IEnum<String>)getEnumByValue(enumClass, value);
		if (em == null) return null;
		return em.getEnName();
	}
	@SuppressWarnings("unchecked")
	public static <T extends ValueIEnum<String>> T getEnumByValue(Class<T> enumClass, String value){
	    List<T> list = getEnums(enumClass);
//	    if ((CollectionUtil.isEmpty(list)) || (StringUtil.isEmpty(value))) return null;
	    if(list.size()==0||value==""){return null;}
	    for (ValueIEnum<String> em : list) {
	      if (((String)em.getEnValue()).equals(value)) {
	        return (T)em;
	      }
	    }
	    return null;
	}
	@SuppressWarnings("unchecked")
	public static <T> List<T> getEnums(Class<T> enumClass){
	    if (enumClass == null) return null;
	    /*
	     * �˷�������һ�����飬�������Class�������ʾ��ö�������������ǵ�˳���򷵻�null����Class���󲻱�ʾö�����͵�ֵ��
	     */
	    Object[] enumArr = enumClass.getEnumConstants();//���ķ���
//	    if (ArrayUtil.isEmpty(enumArr)) return null;
//	    return Arrays.asList(enumArr);
	    if(enumArr.length==0){//��ʾ��Class���󲻱�ʾö�����͵�ֵ
	    	return null;
	    }
	    return (List<T>) Arrays.asList(enumArr);
	}
	//========================================getNameByValue----String=====================================

	//=======================================getNameByValue-----Number=====================================
	public static String getNameByValue(Class<? extends IEnum<? extends Number>> enumClass, Number value){
		IEnum em = (IEnum)getEnumByValue(enumClass, value);
		if(em == null) return null;
		return em.getEnName();
	}
	public static <T extends ValueIEnum<? extends Number>> T getEnumByValue(Class<T> enumClass, Number value){
	    List<T> list = getEnums(enumClass);
//	    if ((CollectionUtil.isEmpty(list)) || (value == null)) return null;
	    if(list.size()==0||value==null){
	    	return null;
	    }
	    for (ValueIEnum em : list) {
//	      if (NumberUtil.isEQ((Number)em.getEnValue(), value)) {
//	        return (T)em;
//	      }
    	if((Number)em.getEnValue()==value){
    		return (T)em;
    	}
	    }
	    return null;
	}
	//=======================================getNameByValue-----Number=====================================
	
	
//	public static String getNameByValueEnumStr(Class<? extends IEnum<String>> enumClass, ValueIEnum<String> valueEnum){
//		IEnum em = (IEnum)getEnumByValueEnumStr(enumClass, valueEnum);
//		if (em == null) return null;
//		return em.getEnName();
//	}
//
//	public static String getNameByValueEnumNum(Class<? extends IEnum<? extends Number>> enumClass, ValueIEnum<? extends Number> valueEnum){
//		IEnum em = (IEnum)getEnumByValueEnumNum(enumClass, valueEnum);
//		if (em == null) return null;
//		return em.getEnName();
//	}
//
//	public static <T> T getValueByName(Class<? extends IEnum<T>> enumClass, String name){
//	    IEnum em = (IEnum)getEnumByName(enumClass, name);
//	    if (em == null) return null;
//	    return em.getEnValue();
//	}
//
//	public static <T> T getValueByName(Class<? extends IEnum<T>> enumClass, NameIEnum nameEnum){
//	    IEnum em = (IEnum)getEnumByName(enumClass, nameEnum);
//	    if (em == null) return null;
//	    return em.getEnValue();
//	}
//
//	
//	
//	
//
//	public static <T extends ValueIEnum<String>> T getEnumByValueEnumStr(Class<T> enumClass, ValueIEnum<String> valueEnum){
//	    if ((enumClass == null) || (isEmpty(valueEnum))) return null;
//	    return getEnumByValue(enumClass, (String)valueEnum.getEnValue());
//	}
//
//	public static <T extends ValueIEnum<? extends Number>> T getEnumByValueEnumNum(Class<T> enumClass, ValueIEnum<? extends Number> valueEnum){
//	    if ((enumClass == null) || (isEmpty(valueEnum))) return null;
//	    return getEnumByValue(enumClass, (Number)valueEnum.getEnValue());
//	}
//
//	public static <T extends NameIEnum> T getEnumByName(Class<T> enumClass, String name){
//	    List list = getEnums(enumClass);
//	    if ((CollectionUtil.isEmpty(list)) || (StringUtil.isEmpty(name))) return null;
//	    for (NameIEnum em : list) {
//	      if (em.getEnName().equals(name)) {
//	        return em;
//	      }
//	    }
//	    return null;
//	}
//
//	public static <T extends NameIEnum> T getEnumByName(Class<T> enumClass, NameIEnum nameEnum){
//	    if ((enumClass == null) || (isEmpty(nameEnum))) return null;
//	    return getEnumByName(enumClass, nameEnum.getEnName());
//	}
//
//	
//
//	public static boolean isNEmpty(Object obj){
//	    if (obj != null) {
//	      return true;
//	    }
//	    return false;
//	}
//
//	public static boolean isEmpty(Object obj){
//	    return !isNEmpty(obj);
//	}
//
//	public static boolean isEQByValue(ValueIEnum<?> em1, ValueIEnum<?> em2){
//	    if ((isEmpty(em1)) || (isEmpty(em2))) return false;
//	    if (em1.getEnValue().equals(em2.getEnValue())) {
//	      return true;
//	    }
//	    return false;
//	}
//
//	public static boolean isEQByValue(ValueIEnum<?> valEnum, Number value){
//	    if ((isEmpty(valEnum)) || (value == null)) return false;
//	    Number enValue = (Number)valEnum.getEnValue();
//	    if (enValue.doubleValue() == value.doubleValue()) {
//	      return true;
//	    }
//	    return false;
//	}
//
//	public static boolean isEQByValue(ValueIEnum<?> valEnum, String value){
//	    if ((isEmpty(valEnum)) || (value == null)) return false;
//	    if (valEnum.getEnValue().equals(value)) {
//	      return true;
//	    }
//	    return false;
//	}
//
//	public static boolean isEQByName(NameIEnum em, String name){
//	    if ((isEmpty(em)) || (name == null)) return false;
//	    if (em.getEnName().equals(name)) {
//	      return true;
//	    }
//	    return false;
//	}
//
//	public static boolean isEQByName(NameIEnum em1, NameIEnum em2){
//	    if ((isEmpty(em1)) || (isEmpty(em2))) return false;
//	    if (em1.getEnName().equals(em2.getEnName())) {
//	      return true;
//	    }
//	    return false;
//	}
//
//	public static boolean isNEQByValue(ValueIEnum<?> em1, ValueIEnum<?> em2){
//	    return !isEQByValue(em1, em2);
//	}
//
//	public static boolean isNEQByValue(ValueIEnum<?> valEnum, Number value){
//	    return !isEQByValue(valEnum, value);
//	}
//
//	public static boolean isNEQByValue(ValueIEnum<?> valEnum, String value){
//	    return !isEQByValue(valEnum, value);
//	}
//
//	public static boolean isNEQByName(NameIEnum em, String name){
//	    return !isEQByName(em, name);
//	}
//
//	public static boolean isNEQByName(NameIEnum em1, NameIEnum em2){
//	    return !isEQByName(em1, em2);
//	}
}
