/**
 * 
 */
package org.apache.dubbo.demo;

import java.util.HashMap;

/**
 * @author cyl
 *
 */
public class APIResult<T> extends HashMap<String,Object>{
	private static final long serialVersionUID = 1L;
	public static final int SUCCESS=200;
	public static final int PARAM_FAIL=400;
	public static final int BIZ_FAIL=401;
	public static final int ERROR=500;
	public static final int AUTH_FAIL=-1;
	public static final int PERM_FAIL=-2;
	private static final String DEFAULT_DATA_KEY="data";
	public boolean isSuccess(){
		if(this.get("code")==null){
			return false;
		}
		if((Integer)this.get("code")==SUCCESS){
			return true;
		}
		return false;
	}
    public APIResult(){
    	put("code",SUCCESS);
    	put("msg","success");
    }
    @SuppressWarnings("unchecked")
	public T get(){
    	return (T)get(DEFAULT_DATA_KEY);
    }
    
    @SuppressWarnings("rawtypes")
	public static APIResult success(){
    	APIResult result=new APIResult();
    	return result;
    }
    @SuppressWarnings("rawtypes")
    public static APIResult success(Object value){
    	APIResult result=new APIResult();
    	result.put(DEFAULT_DATA_KEY, value);
    	return result;
    }
    /**
     * 权限校验失败
     * @return
     */
    @SuppressWarnings("rawtypes")
    public static APIResult permFail(){
    	APIResult result=new APIResult();
    	result.put("code", PERM_FAIL);
    	result.put("msg", "没有权限，请联系管理员");
    	return result;
    }
    /**
     * 认证失效
     * @return
     */
    public static APIResult authFail(){
    	APIResult result=new APIResult();
    	result.put("code", AUTH_FAIL);
    	result.put("msg", "没有权限，请联系管理员");
    	return result;
    }
    public static APIResult fail(){
    	APIResult result=new APIResult();
    	result.put("code", ERROR);
    	result.put("msg", "系统异常");
    	return result;
    }
    public static APIResult fail(int code,String msg){
    	APIResult result=new APIResult();
    	result.put("code",code);
    	result.put("msg",msg);
    	return result;
    }
    public static APIResult fail(int code,String msg,Object value){
    	APIResult result=new APIResult();
    	result.put("code",code);
    	result.put("msg",msg);
    	result.put(DEFAULT_DATA_KEY,value);
    	return result;
    }
    public static APIResult fail(String msg){
    	
    	return fail(ERROR,msg);
    }
    public static APIResult fail(String msg,Object value){
    	
    	return fail(ERROR,msg,value);
    }
    public APIResult put(String key, Object value) {
		super.put(key, value);
		return this;
	}
    
}
