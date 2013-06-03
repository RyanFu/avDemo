/**
 * 
 */
package com.demo.bo;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.beanutils.BeanUtils;

/**
 * @author ryan
 * 
 */
public class AbstractBusinessObject {
	
	public AbstractBusinessObject setProperty(Map<String, Object> params){

			Iterator<Entry<String, Object>> iter = params.entrySet().iterator();
			while (iter.hasNext()) {
			    Map.Entry entry = (Map.Entry) iter.next();
			    try {
					BeanUtils.setProperty(this, (String) entry.getKey(), entry.getValue());
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} 
		
		return this;
	}
	
	

}
