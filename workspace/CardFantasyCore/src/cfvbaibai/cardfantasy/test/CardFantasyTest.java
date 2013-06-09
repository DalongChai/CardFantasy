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

    @Test
    public void ħ��С��vs��ħȮ() {
        game5vs5("ħ��С��", "��ħȮ");
    }

    @Test
    public void ���ն����vs�����() {
        game5vs5("���ն����", "�����");
    }

    @Test
    public void ħ��С��vsħ��ʿ() {
        game5vs5("ħ��С��", "ħ��ʿ");
    }

    @Test
    public void ħ��С��vs�ؼ����() {
        game5vs5("ħ��С��", "�ؼ����");
    }

    @Test
    public void ���װ�׳���vs�ؼ����() {
        game5vs5("���װ�׳���", "�ؼ����");
    }

    @Test
    public void ħ��С��vs������ѻ() {
        game5vs5("ħ��С��", "������ѻ");
    }

    @Test
    public void ���򹭼���vsʨ��() {
        game5vs5("���򹭼���", "ʨ��");
    }

    @Test
    public void ������ѻvsħ��ʦ() {
        game5vs5("������ѻ", "ħ��ʦ");
    }

    @Test
    public void ���򹭼���vsħ��ʦ() {
        game5vs5("���򹭼���", "ħ��ʦ");
    }

    @Test
    public void �ѻ������vsħ���ᾧ��() {
        game5vs5("�ѻ������", "ħ���ᾧ��");
    }

    @Test
    public void ħ��ʿvsħ���ᾧ��() {
        game5vs5("ħ��ʿ", "ħ���ᾧ��");
    }

    @Test
    public void �ؼ����vsħ���ᾧ��() {
        game5vs5("�ؼ����", "ħ���ᾧ��");
    }

    @Test
    public void ħ��ʿvsʥ��ʿ() {
        game5vs5("ħ��ʿ", "ʥ��ʿ");
    }

    @Test
    public void ħ��ʦvsʥ��ʿ() {
        game5vs5("ħ��ʦ", "ʥ��ʿ");
    }

    @Test
    public void �ѻ������vsʥ��ʿ() {
        game5vs5("�ѻ������", "ʥ��ʿ");
    }

    @Test
    public void ������ѻvs��ѩ�ٻ�ʿ() {
        game5vs5("������ѻ", "��ѩ�ٻ�ʿ");
    }

    @Test
    public void ��ѩ�ٻ�ʿvs����ɮ��() {
        game5vs5("��ѩ�ٻ�ʿ", "����ɮ��");
    }

    @Test
    public void ��ʦvs�ʼ���ʨ() {
        game5vs5("��ʦ", "�ʼ���ʨ");
    }

    @Test
    public void ���͵���vs��������() {
        game5vs5("���͵���", "��������");
    }

    @Test
    public void ��Ӱħ��ʦvsʥ��ʿ() {
        GameBuilder.play(PlayerBuilder.build("Ӣ�۹�Ӱħ��ʦ", 50, "��Ӱħ��ʦ-10*2", "��ѩ�ٻ�ʿ-10*3"),
                PlayerBuilder.build("Ӣ��ʥ��ʿ", 50, "ʥ��ʿ-10*5"));
    }

    @Test
    public void ���װ�׳���vsʥ����ʿ() {
        game5vs5("���װ�׳���", "ʥ����ʿ");
    }

    @Test
    public void ��ѩ�ٻ�ʿvsʥ����ʿ() {
        game5vs5("��ѩ�ٻ�ʿ", "ʥ����ʿ");
    }

    @Test
    public void �ʼ����ӽ���vs������() {
        game5vs5("�ʼ����ӽ���", "������");
    }

    @Test
    public void �ʼ����ӽ���vsħ��Э�᳤() {
        game5vs5("�ʼ����ӽ���", "ħ��Э�᳤");
    }

    @Test
    public void �ʼ����ӽ���vsħ��Э�᳤_���װ�׳���() {
        GameBuilder.play(PlayerBuilder.build("Ӣ�ۻʼ����ӽ���", 50, "�ʼ����ӽ���-10*5"),
                PlayerBuilder.build("Ӣ��ħ��Э�᳤", 50, "ħ��Э�᳤-10*2", "��ѩ�ٻ�ʿ-10*3"));
    }

    @Test
    public void ��ҫ����vs��ʥ() {
        game5vs5("��ҫ����", "��ʥ");
    }

    @Test
    public void ���򹭼���vs��ʥ() {
        game5vs5("���򹭼���", "��ʥ");
    }

    @Test
    public void ʱ������vs������ʯ��() {
        game5vs5("ʱ������", "������ʯ��");
    }

    @Test
    public void ��ʥvsʱ������() {
        game5vs5("��ʥ", "ʱ������");
    }

    @Test
    public void ʨ����ʿvsʱ������() {
        game5vs5("ʨ����ʿ", "ʱ������");
    }

    @Test
    public void ��е����vsʱ������() {
        game5vs5("��е����", "ʱ������");
    }

    @Test
    public void ʨ����ʿvs��ʯ��ʯ��() {
        game5vs5("ʨ����ʿ", "��ʯ��ʯ��");
    }

    @Test
    public void �������vs��ʯ��ʯ��() {
        game5vs5("�������", "��ʯ��ʯ��");
    }

    @Test
    public void ʱ������vs������ʹ() {
        game5vs5("ʱ������", "������ʹ");
    }

    @Test
    public void ����֮��vs���򹭼���() {
        game5vs5("����֮��", "���򹭼���");
    }

    @Test
    public void ����֮��vs����ì��() {
        game5vs5("����֮��", "����ì��");
    }

    @Test
    public void ����֮��vs����ͻ����() {
        game5vs5("����֮��", "����ͻ����");
    }

    @Test
    public void ����֮��vsħ��С��() {
        game5vs5("����֮��", "ħ��С��");
    }

    @Test
    public void ����֮��vs�ؼ����() {
        game5vs5("����֮��", "�ؼ����");
    }

    @Test
    public void ����֮��vs���װ�׳���() {
        game5vs5("����֮��", "���װ�׳���");
    }

    @Test
    public void ����֮��vs�ʼ���ʨ() {
        game5vs5("����֮��", "�ʼ���ʨ");
    }

    @Test
    public void ����֮��vs������ʹ() {
        game5vs5("����֮��", "������ʹ");
    }

    @Test
    public void ����֮��vsս��() {
        game5vs5("����֮��", "ս��");
    }
}
