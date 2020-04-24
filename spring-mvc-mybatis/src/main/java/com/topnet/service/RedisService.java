package com.topnet.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Iterator;
import java.util.Set;

/**
 * @author panyiwei
 * @create 2018-09-28 15:10
 */
@Service
public class RedisService {

    @Autowired
    private RedisTemplate<String, ?> redisTemplate;

    public void set(final String key, final String value) {
        redisTemplate.execute(new RedisCallback<Object>() {
            @Override
            public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {
                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
                redisConnection.set(serializer.serialize(key), serializer.serialize(value));
                return null;
            }
        });
    }

    public void deleteOne(final String key) {
        redisTemplate.delete(key);
    }

    public String get(final String key) {
        return redisTemplate.execute(new RedisCallback<String>() {
            @Override
            public String doInRedis(RedisConnection redisConnection) throws DataAccessException {
                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
                return serializer.deserialize(redisConnection.get(serializer.serialize(key)));
            }
        });
    }


    public void setEx(final String key, final String value, final Long timeOut) {

        redisTemplate.execute(new RedisCallback<Object>() {
            @Override
            public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {
                RedisSerializer<String> redisSerializer = redisTemplate.getStringSerializer();
                redisConnection.setEx(redisSerializer.serialize(key), timeOut, redisSerializer.serialize(value));
                return null;
            }
        });
    }

    public Long removeKey(final String key) {
        return redisTemplate.execute(new RedisCallback<Long>() {
            @Override
            public Long doInRedis(RedisConnection redisConnection) throws DataAccessException {
                RedisSerializer<String> redisSerializer = redisTemplate.getStringSerializer();
                return redisConnection.del(redisSerializer.serialize(key));
            }
        });
    }
    public void delByCodePattern(final String key)  {
		Assert.hasText(key, "Key is not empty.");

		Set<String> keys = redisTemplate.keys(key);
		for (String k : keys) {
			redisTemplate.delete(k);
		}
	}

    public String selectKeys(final String key)  {
        Assert.hasText(key, "Key is not empty.");
        Set<String> keys = redisTemplate.keys(key);
        for (String k : keys) {
           return k;
        }
        return null;
    }

    public Set<String> selectAllKey(final String key)  {
        Assert.hasText(key, "Key is not empty.");
        Set<String> keys = redisTemplate.keys(key);
        return keys;
    }

    public long rpush(final String key, Object obj) throws Exception {
		Assert.hasText(key, "Key is not empty.");

		final String value = JSONObject.toJSONString(obj);
		long result = redisTemplate.execute(new RedisCallback<Long>() {
			@Override
			public Long doInRedis(RedisConnection connection) {
				RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
				long count = connection.rPush(serializer.serialize(key), serializer.serialize(value));
				return count;
			}
		});
		return result;
	}

    public boolean exists(final String key) {
        Assert.hasText(key, "Key is not empty.");

        return redisTemplate.hasKey(key);
    }

    /**
     * 模糊匹配key
     * @param key
     * @return
     */
    public JSONArray getValues(final  String key){
        JSONArray arr=new JSONArray();
        Set<String> keys = redisTemplate.keys(key);
        Iterator<String> iterator=keys.iterator();
        while (iterator.hasNext()){
            String k=iterator.next();
            String value = get(k);
            JSONObject obj= JSONObject.parseObject(value);
            arr.add(obj);
        }
        return arr;
    }

}
