package cfvbaibai.cardfantasy.test;

import org.junit.Test;

public class CardFantasyCrossRaceTest {
    @Test
    public void ����and�ػ�() {
        GameBuilder.play(PlayerBuilder.build("��A��", 50, "����֩��-10*2", "ħ��ʿ-10*3"),
                PlayerBuilder.build("��B��", 50, "���򹭼���-10*5"));
    }

    @Test
    public void ����vs�ػ�() {
        GameBuilder.play5v5("ʳ��ħ��ʿ", "ħ��ʿ");
    }
}
