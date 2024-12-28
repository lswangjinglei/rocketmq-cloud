# docker 方式部署 RocketMQ 5.0
# 参考 [https://rocketmq.apache.org/zh/docs/quickStart/02quickstartWithDocker]

# 下载镜像
$ docker pull apache/rocketmq:5.3.1

# 创建共享网络
$ docker network create rocketmq

# 启动nameServer
$ docker run -d --name rmqnamesrv -p 9876:9876 --network rocketmq apache/rocketmq:5.3.1 sh mqnamesrv

# 验证 NameServer 是否启动成功 (看到'The Name Server boot success..'， 表示NameServer 已成功启动。)
$ docker logs -f rmqnamesrv

# NameServer 成功启动后，启动 Broker 和 Proxy。
$ echo "brokerIP1=192.168.31.10" > broker.conf

# 启动 Broker 和 Proxy
$ docker run -d \
  --name rmqbroker \
  --network rocketmq \
  -p 10912:10912 -p 10911:10911 -p 10909:10909 \
  -p 8080:8080 -p 8081:8081 \
  -e "NAMESRV_ADDR=192.168.31.10:9876" \
  -v ./broker.conf:/home/rocketmq/rocketmq-5.3.1/conf/broker.conf \
  apache/rocketmq:5.3.1 sh mqbroker --enable-proxy \
  -c /home/rocketmq/rocketmq-5.3.1/conf/broker.conf

# 验证 Broker 是否启动成功(看到'The broker boot success..'， 表示 Broker 已成功启动。)
$ docker exec -it rmqbroker bash -c "tail -n 10 /home/rocketmq/logs/rocketmqlogs/proxy.log"

# 创建测试topic
$ docker exec -it rmqbroker bash
$ sh mqadmin updatetopic -t TestTopic -c DefaultCluster