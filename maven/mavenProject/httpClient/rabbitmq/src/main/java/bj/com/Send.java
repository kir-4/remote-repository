package bj.com;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Send {

    public static void main(String[] args){

        ConnectionFactory factory = new ConnectionFactory() ;
//        设置连接rabbitmq的主机
        factory.setHost("192.168.223.128");
//        设置端口号
        factory.setPort(5672);
//        设置连接哪个虚拟主机
        factory.setVirtualHost("/virtual");
//        设置用户名和密码
        factory.setUsername("root");
        factory.setPassword("root");

//        获取连接对象

        try ( Connection con = factory.newConnection();
            //        获取通道
            Channel channel = con.createChannel() ;){
            /*
             * 通道绑定队列
             * 参数1 队列名称
             * 参数2 是否持久化队列
             * 参数3 是否单独使用队列
             * 参数4 是否在消费后消除队列
             * 参数5 额外附加参数
             * */
            channel.queueDeclare("queue1",false,false,false,null) ;
//        1 交换机名称 2 队列名称 3传递消息额外设置 消息的具体内容
            channel.basicPublish("", "queue1", null, "message".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }





    }
}
