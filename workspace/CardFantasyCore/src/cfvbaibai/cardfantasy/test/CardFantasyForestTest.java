package cfvbaibai.cardfantasy.test;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CardFantasyForestTest {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void �����vsɭ��Ů��() {
        GameBuilder.play5v5("�����", "ɭ��Ů��");
    }

    @Test
    public void ��������vs�������ڳ���() {
        GameBuilder.play5v5("��������", "�������ڳ���");
    }

    @Test
    public void �����vs�������ڳ���() {
        GameBuilder.play5v5("�����", "�������ڳ���");
    }

    @Test
    public void ɭ�������vs�������ڳ���() {
        GameBuilder.play5v5("ɭ�������", "�������ڳ���");
    }

    @Test
    public void ɭ�������vs��������() {
        GameBuilder.play5v5("ɭ�������", "��������");
    }

    @Test
    public void ���vs��������() {
        GameBuilder.play5v5("���", "��������");
    }

    @Test
    public void Ԫ������vs��������() {
        GameBuilder.play5v5("Ԫ������", "��������");
    }

    @Test
    public void Ԫ������vs���() {
        GameBuilder.play5v5("Ԫ������", "���");
    }

    @Test
    public void С���˹���vs������ʿ() {
        GameBuilder.play5v5("С���˹���", "������ʿ");
    }

    @Test
    public void С���˹���vsɭ��Ů��() {
        GameBuilder.play5v5("С���˹���", "ɭ��Ů��");
    }
}
