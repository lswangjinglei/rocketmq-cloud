本项目包含 rocketmq 的服务安装以及生产者和消费者的示例代码

测试流程如下：

- 1. 服务部署参考docker.sh 脚本

- 2. 项目测试启动ConsumerApplication应用

- 3. 调用ProducerTest的单元测试testProducer方法

- 4. 再观察ConsumerApplication的消费日志