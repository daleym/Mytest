package com.ym.redis;

import java.util.Collections;

import redis.clients.jedis.Jedis;

/**
 * lua�ű�����ԭ���� ������redisȥִ�У�����
 * @author Administrator
 *
 */
public class RedisToolLua {

    private static final Long RELEASE_SUCCESS = 1L;

    /**
     * �ͷŷֲ�ʽ��
     * @param jedis Redis�ͻ���
     * @param lockKey ��
     * @param requestId �����ʶ
     * @return �Ƿ��ͷųɹ�
     */
    public static boolean releaseDistributedLock(Jedis jedis, String lockKey, String requestId) {

        String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
        Object result = jedis.eval(script, Collections.singletonList(lockKey), Collections.singletonList(requestId));

        if (RELEASE_SUCCESS.equals(result)) {
            return true;
        }
        return false;

    }

}
