package com.kxw.zookeeper;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetAddress;

/**
 * 利用zookeeper的watch机制，来发现数据
 * Create by kangxiongwei on 2018/1/19 12:05.
 */
public class ZkWatch {

    private static final Logger LOGGER = LoggerFactory.getLogger(ZkWatch.class);
    private static ZooKeeper zooKeeper;

    /**
     * 初始化zk客户端
     */
    private static void initZookeeper() {
        String zkConnection = "127.0.0.1:2181";
        try {
            zooKeeper = new ZooKeeper(zkConnection, 3000, event -> {
                try {
                    //监控数据的变化
                    System.out.println(event.getState() + "," + event.getType() + "," + event.getPath());
                    zooKeeper.getChildren("/", true);
                } catch (Exception e) {
                    LOGGER.error("初始化zk客户端失败，错误信息为", e);
                }
            });
        } catch (IOException e) {
            LOGGER.error("初始化zk客户端失败，错误信息为", e);
        }
    }

    public static void main(String[] args) throws Exception {
        String ip = InetAddress.getLocalHost().getHostAddress();
        initZookeeper();
        if (zooKeeper == null) {
            LOGGER.error("初始化zk客户端为空");
            return;
        }

        String res = createPath("/app/hosts", ip, CreateMode.PERSISTENT);
        System.out.println(res);

        String data = getData("/app/hosts");
        System.out.println(data);

        setData("/app/hosts", "kangxiongwei");
    }

    /**
     * 创建目录
     *
     * @param path 路径
     * @param data 数据
     * @param mode 模式
     * @throws Exception
     */
    private static String createPath(String path, String data, CreateMode mode) throws Exception {
        Stat stat = zooKeeper.exists(path, false);
        byte[] bytes = data == null ? null : data.getBytes();
        String res = null;
        if (stat == null) {
            res = zooKeeper.create(path, bytes, ZooDefs.Ids.OPEN_ACL_UNSAFE, mode);
        }
        return res;
    }

    /**
     * 获取数据
     *
     * @param path 路径
     * @return
     * @throws Exception
     */
    private static String getData(String path) throws Exception {
        Stat stat = zooKeeper.exists(path, false);
        byte[] bytes = zooKeeper.getData(path, true, stat);
        return new String(bytes);
    }

    /**
     * 写入数据
     *
     * @param path
     * @param data
     * @throws Exception
     */
    private static void setData(String path, String data) throws Exception {
        zooKeeper.setData(path, data.getBytes(), -1);
    }

}
