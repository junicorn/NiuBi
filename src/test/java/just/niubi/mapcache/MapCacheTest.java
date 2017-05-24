package just.niubi.mapcache;

import just.niubi.cache.MapCache;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by biezhi on 2017/2/7.
 */
public class MapCacheTest {

    private MapCache mapCache = new MapCache();

    @Test
    public void testSet1(){
        mapCache.set("name", "张三丰");
        System.out.println(mapCache.get("name"));
    }

    /**
     * 测试缓存3秒后失效
     *
     * @throws InterruptedException
     */
    @Test
    public void testSet2() throws InterruptedException {
        mapCache.set("name2", "张三丰2", 3);
        TimeUnit.SECONDS.sleep(5);
        System.out.println(mapCache.get("name2"));
    }

    /**
     * 测试hash缓存
     *
     * @throws InterruptedException
     */
    @Test
    public void testSet3() throws InterruptedException {
        mapCache.hset("user", "1102", "jack");
        System.out.println(mapCache.hget("user", "1102"));
    }

    /**
     * 测试删除缓存
     *
     * @throws InterruptedException
     */
    @Test
    public void testDel() throws InterruptedException {
        mapCache.set("name4", "wang");
        System.out.println(mapCache.get("name4"));
        mapCache.del("name4");
        System.out.println(mapCache.get("name4"));
    }

}
