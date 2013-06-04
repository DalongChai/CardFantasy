package cfvbaibai.cardfantasy.test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import cfvbaibai.cardfantasy.engine.GameEndCause;
import cfvbaibai.cardfantasy.engine.GameResult;

public class CardFantasyTest {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    private void game5vs5(String card1, String card2) {
        GameBuilder.play(PlayerBuilder.build("Ӣ��" + card1, 50, card1 + "-10*5"),
                PlayerBuilder.build("Ӣ��" + card2, 50, card2 + "-10*5"));
    }

    @Test
    public void ���򹭼���vs����ì��() {
        game5vs5("���򹭼���", "����ì��");
    }

    @Test
    public void ���򹭼���vs����Ѳ�߱�() {
        game5vs5("���򹭼���", "����Ѳ�߱�");
    }
    
    @Test
    public void ����ì��vs����Ѳ�߱�() {
        game5vs5("����ì��", "����Ѳ�߱�");
    }
    
    @Test
    public void ���򹭼���vs����ͻ����() {
        game5vs5("���򹭼���", "����ͻ����");
    }

    @Test
    public void ����ì��vs����ͻ����() {
        game5vs5("����ì��", "����ͻ����");
    }

    @Test
    public void ����Ѳ�߱�vs����ͻ����() {
        game5vs5("����Ѳ�߱�", "����ͻ����");
    }
    
    @Test
    public void ����Ѳ�߱�vsħ��С��() {
        game5vs5("����Ѳ�߱�", "ħ��С��");
    }
    
    @Test
    public void ���򹭼���vs��������() {
        game5vs5("���򹭼���", "��������");
    }
}
