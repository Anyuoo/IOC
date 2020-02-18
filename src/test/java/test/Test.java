package test;


import com.anyu.IoCContainer;
import com.anyu.car.Audi;
import com.anyu.car.Buik;
import com.anyu.human.Human;
import com.anyu.human.ZhangSan;
import org.junit.Before;

public class Test {
    IoCContainer ioCContainer=new IoCContainer();
    @Before
    public void before(){
        ioCContainer.setBeans(Audi.class,"Audi");
        ioCContainer.setBeans(Buik.class,"Buik");
        ioCContainer.setBeans(ZhangSan.class,"ZhangSan","Audi");
    }
    @org.junit.Test
    public void test(){
        Human zhansan= (Human) ioCContainer.getBeans("ZhangSan");
        zhansan.gohome();
    }

}
