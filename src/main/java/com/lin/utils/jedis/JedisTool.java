package com.lin.utils.jedis;
/**
*  Author:大鹏
*  Date：2018年8月22日
*  	
*/
public interface JedisTool {

	/**
	 * 设置生命周期
	 * @param key 键名
	 * @param seconds 过期时间，单位为秒
	 * @return
	 */
	Long expire(String key,int seconds);
	
	/**
	 * 获取key的剩余过期时间
	 * @param key
	 * @return
	 */
	Long ttl(String key);
	
	/*
	 * String 字符串类型
	 */
	
	/**
	 * String类型赋值
	 * @param key
	 * @param value
	 * @return
	 */
	String set(String key,String value);
	
	/**
	 * String 类型取值
	 * @param key
	 * @return
	 */
	String get(String key);
	
	/**
	 * 将 key中储存的数字值增一
	 * @param key
	 * @return
	 */
	Long incr(String key);
	
	/**
	 * 删除字符串key及对应的值
	 * @param key
	 * @return
	 */
	Long del(String key);
	
	/*
	 * HASH类型 
	 * 特别适合用于存储对象
	 */
	/**
	 * hash类型赋值
	 * @param hkey
	 * @param key
	 * @param value
	 * @return
	 */
	Long hset(String hkey, String key, String value);
	
	/**
	 * hash类型取值
	 * @param hkey
	 * @param key
	 * @return
	 */
	//Redis Hget 命令用于返回哈希表中指定字段的值
	String hget(String hkey,String key);
	
	/**
	 * hash类型删除
	 * @param hkey
	 * @param key
	 * @return
	 */
	Long hdel(String hkey,String key);
	
	
}
