package cfvbaibai.cardfantasy.test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

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
    
    @Test
    public void ���򹭼���vs�ѻ������() {
        game5vs5("���򹭼���", "�ѻ������");
    }
    
    @Test
    public void ħ��С��vs�ѻ������() {
        game5vs5("ħ��С��", "�ѻ������");
    }
    
    @Test
    public void ���򹭼���vs��׶�����() {
        game5vs5("���򹭼���", "��׶�����");
    }
    
    @Test
    public void �ѻ������vs��׶�����() {
        game5vs5("�ѻ������", "��׶�����");
    }
    
    @Test
    public void �ѻ������vs��ϰħ��ʿ() {
        game5vs5("�ѻ������", "��ϰħ��ʿ");
    }
    
    @Test
    public void ��׶�����vs��ϰħ��ʿ() {
        game5vs5("��׶�����", "��ϰħ��ʿ");
    }

    @Test
    public void ���ն����vs��ϰħ��ʿ() {
        game5vs5("���ն����", "��ϰħ��ʿ");
    }
    
    @Test
    public void ���ն����vs��ϰʥ��() {
        game5vs5("���ն����", "��ϰʥ��");
    }
    
    @Test
    public void ��ʦvs��ϰʥ��() {
        game5vs5("��ʦ", "��ϰʥ��");
    }
    
    @Test
    public void ��ʦvsʥ��������() {
        game5vs5("��ʦ", "ʥ��������");
    }
}
