package cfvbaibai.cardfantasy.test;

import org.junit.Test;

import cfvbaibai.cardfantasy.data.RuneData;

public class CardFatnastySavageTest {

    @Test
    public void �װ�֩��vs��ҹ����() {
        GameBuilder.play5v5("�װ�֩��", "��ҹ����");
    }

    @Test
    public void ����֩��vsɽ���˶�ʿ() {
        GameBuilder.play5v5("����֩��", "ɽ���˶�ʿ");
    }

    @Test
    public void ţͷ����ʿvsʳ��ħ��ʿ() {
        GameBuilder.play5v5("ţͷ����ʿ", "ʳ��ħ��ʿ");
    }

    @Test
    public void ���۾���vsʳ��ħ��ʿ() {
        GameBuilder.play5v5("���۾���", "ʳ��ħ��ʿ");
    }

    @Test
    public void ���۾���v�粼����ʿ() {
        GameBuilder.play5v5("���۾���", "�粼����ʿ");
    }

    @Test
    public void ��ͷ����vԶ��Ы��() {
        GameBuilder.play5v5("��ͷ����", "Զ��Ы��");
    }

    @Test
    public void ��ͷ����vԶ��Ы��_����() {
        GameBuilder.play5v5withRunes("��ͷ����", RuneData.����, "Զ��Ы��", RuneData.����);
    }
}
