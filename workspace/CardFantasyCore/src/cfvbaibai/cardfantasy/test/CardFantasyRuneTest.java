package cfvbaibai.cardfantasy.test;

import org.junit.Test;

import cfvbaibai.cardfantasy.data.PlayerInfo;
import cfvbaibai.cardfantasy.data.RuneData;

public class CardFantasyRuneTest {

    @Test
    public void ��ͷ����vԶ��Ы��_����() {
        GameBuilder.play5v5withRunes("��ͷ����", RuneData.����, "Զ��Ы��", RuneData.����);
    }

    @Test
    public void ��������vԶ��Ы��_����() {
        GameBuilder.play5v5withRunes("��������", RuneData.����, "Զ��Ы��", RuneData.����);
    }

    @Test
    public void ���vԶ��Ы��_����_����() {
        PlayerInfo playerA = PlayerBuilder.build("��A��", 50, "C���-10*5", "R����-4", "R����-4");
        PlayerInfo playerB = PlayerBuilder.build("��B��", 50, "CԶ��Ы��-10*5", "R����-4", "R����-4");
        GameBuilder.build(playerA, playerB).playGame();
    }

    @Test
    public void ��������vԶ��Ы��_�Ҿ�() {
        GameBuilder.play5v5withRunes("��������", RuneData.�Ҿ�, "Զ��Ы��", RuneData.�Ҿ�);
    }

    @Test
    public void ���򹭼���v����ѻ���_��ɰ() {
        PlayerInfo playerA = PlayerBuilder.build("��A��", 100, "C���򹭼���-10*15", "R��ɰ-4");
        PlayerInfo playerB = PlayerBuilder.build("��B��", 100, "C����ѻ���-10*15", "R��ɰ-4");
        GameBuilder.build(playerA, playerB).playGame();
    }

    @Test
    public void ţͷ������vsս��������_�ұ�() {
        GameBuilder.play5v5withRunes("ţͷ������", RuneData.�ұ�, "ս��������", RuneData.�ұ�);
    }

    @Test
    public void ˮԴ������vsţͷ������_ʯ��() {
        GameBuilder.play5v5withRunes("ˮԴ������", RuneData.�ұ�, "ţͷ������", RuneData.ʯ��);
    }

    @Test
    public void ��������vs���۾���_���() {
        GameBuilder.play5v5withRunes("��������", RuneData.�ұ�, "���۾���", RuneData.���);
    }

    @Test
    public void ���vs֩����Ů��_����() {
        GameBuilder.play5v5withRunes("���", RuneData.�ұ�, "֩����Ů��", RuneData.����);
    }

    @Test
    public void ��������vs֩����Ů��_����() {
        GameBuilder.play5v5withRunes("��������", RuneData.�ұ�, "֩����Ů��", RuneData.����);
    }
}
