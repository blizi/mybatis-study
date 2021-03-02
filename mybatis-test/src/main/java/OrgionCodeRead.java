import entity.Payment;
import mapper.PaymentMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class OrgionCodeRead {

    public static void main(String[] args) throws IOException {
        //1.读取配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //2、初始化mybatis，创建SqlSessionFactory类实例
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //3、创建Session实例
        SqlSession session = sqlSessionFactory.openSession();
        PaymentMapper paymentMapper = session.getMapper(PaymentMapper.class);
        Payment payment1 = paymentMapper.getPayment(1);

//        Payment payment = session.selectOne("mapper.PaymentMapper.getPayment", 36);
//        System.out.println(payment.toString());
        System.out.println(payment1.toString());

    }
}
