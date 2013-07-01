package cfvbaibai.cardfantasy.test;

import org.junit.Test;

import cfvbaibai.cardfantasy.game.PlayerBuilder;

public class CardFantasyCrossRaceTest {
    @Test
    public void ����and�ػ�() {
        TestGameBuilder.play(PlayerBuilder.build("��A��", 50, "����֩��-10*2", "ħ��ʿ-10*3"),
                PlayerBuilder.build("��B��", 50, "���򹭼���-10*5"));
    }

    @Test
    public void ����vs�ػ�() {
        TestGameBuilder.play5v5("ʳ��ħ��ʿ", "ħ��ʿ");
    }

    @Test
    public void ��������vs֩����Ů��() {
        TestGameBuilder.play5v5("��������", "֩����Ů��");
    }

    @Test
    public void ��е���ų�vs�ڼ�����ʿ() {
        TestGameBuilder.play5v5("��е���ų�", "�ڼ�����ʿ");
    }

    @Test
    public void ����Ů��vsս��������() {
        TestGameBuilder.play5v5("����Ů��", "ս��������");
    }
}
