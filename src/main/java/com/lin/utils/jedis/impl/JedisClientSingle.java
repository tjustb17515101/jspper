package com.lin.utils.jedis.impl;

import com.lin.utils.jedis.JedisTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Component
public class JedisClientSingle implements JedisTool {
	
	@Autowired
	private JedisPool jedisPool;

	@Override
	public Long expire(String key, int seconds) {
		Jedis jedis = jedisPool.getResource();
		Long time = jedis.expire(key, seconds);
		jedis.close();
		return time;
	}

	@Override
	public Long ttl(String key) {
		Jedis jedis = jedisPool.getResource();
		Long time = jedis.ttl(key);
		jedis.close();
		return time;
	}

	@Override
	public String set(String key, String value) {
		Jedis jedis = jedisPool.getResource();
		String result = jedis.set(key, value);
		jedis.close();
		return result;
	}

	@Override
	public String get(String key) {
		Jedis jedis = jedisPool.getResource();
		String result = jedis.get(key);
		jedis.close();
		return result;
	}

	@Override
	public Long incr(String key) {
		Jedis jedis = jedisPool.getResource();
		Long num = jedis.incr(key);
		jedis.close();
		return num;
	}

	@Override
	public Long del(String key) {
		Jedis jedis = jedisPool.getResource();
		Long num = jedis.del(key);
		jedis.close();
		return num;
	}

	@Override
	public Long hset(String hkey, String key, String value) {
		Jedis jedis = jedisPool.getResource();
		Long num = jedis.hset(hkey, key, value);
		jedis.close();
		return num;
	}

	@Override
	public String hget(String hkey, String key) {
		Jedis jedis = jedisPool.getResource();
		String result = jedis.hget(hkey, key);
		jedis.close();
		return result;
	}

	@Override
	public Long hdel(String hkey, String key) {
		Jedis jedis = jedisPool.getResource();
		Long num = jedis.hdel(hkey, key);
		jedis.close();
		return num;
	}

}
