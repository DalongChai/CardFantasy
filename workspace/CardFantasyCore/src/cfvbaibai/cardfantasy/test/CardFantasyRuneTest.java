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

    @Test
    public void ����ì��vs����ͻ����_˪������() {
        GameBuilder.play5v5withRunes("����ì��", RuneData.˪��, "����ͻ����", RuneData.����);
    }

    @Test
    public void ħ���ᾧ��vsħ���ᾧ��_��׶() {
        GameBuilder.play5v5withRunes("ħ���ᾧ��", RuneData.��׶, "ħ���ᾧ��", RuneData.��׶);
    }

    @Test
    public void ħ���ᾧ��v���侫�鷨ʦ_����() {
        GameBuilder.play5v5withRunes("ħ���ᾧ��", RuneData.����, "���侫�鷨ʦ", RuneData.��׶);
    }

    @Test
    public void ����ì��vs����ͻ����_������Ȫ() {
        GameBuilder.play5v5withRunes("����ì��", RuneData.����, "����ͻ����", RuneData.��Ȫ);
    }

    @Test
    public void ħ���ᾧ��v���侫�鷨ʦ_ѩ��ŭ��() {
        PlayerInfo playerA = PlayerBuilder.build("��A��", 50, "Cħ���ᾧ��-10*5", "Rѩ��-4");
        PlayerInfo playerB = PlayerBuilder.build("��B��", 10, "C���侫�鷨ʦ-10*5", "Rŭ��-4");
        GameBuilder.build(playerA, playerB).playGame();
    }

    @Test
    public void �ʼ����ӽ���vs����ո���_����() {
        GameBuilder.play5v5withRunes("�ʼ����ӽ���", RuneData.����, "����ո���", RuneData.��Ȫ);
    }

    @Test
    public void ħ��Э�᳤vs���ħ_ʥȪ() {
        GameBuilder.play5v5withRunes("ħ��Э�᳤", RuneData.ʥȪ, "���ħ", RuneData.��Ȫ);
    }

    @Test
    public void ����ì��vs����ͻ����_��������() {
        GameBuilder.play5v5withRunes("����ì��", RuneData.����, "����ͻ����", RuneData.����);
    }

    @Test
    public void ˮԴ������vs����ӵ����_��������() {
        PlayerInfo playerA = PlayerBuilder.build("��A��", 50, "CˮԴ������-10*5", "R����-4");
        PlayerInfo playerB = PlayerBuilder.build("��B��", 20, "C����ӵ����-10*5", "R����-4");
        GameBuilder.build(playerA, playerB).playGame();
    }

    @Test
    public void ˮԴ������vs����ӵ����_��������() {
        GameBuilder.play5v5withRunes("ˮԴ������", RuneData.����, "����ӵ����", RuneData.����);
    }

    @Test
    public void ���˼�˾vsţͷ����ʿ_����쫷�() {
        PlayerInfo playerA = PlayerBuilder.build("��A��", 50, "C���˼�˾-10*5", "R����-4");
        PlayerInfo playerB = PlayerBuilder.build("��B��", 20, "Cţͷ����ʿ-10*5", "R쫷�-4");
        GameBuilder.build(playerA, playerB).playGame();
    }

    @Test
    public void ���˼�˾vsţͷ����ʿ_���綴��() {
        PlayerInfo playerA = PlayerBuilder.build("��A��", 50, "C���˼�˾-10*5", "R����-4", "R����-4");
        PlayerInfo playerB = PlayerBuilder.build("��B��", 50, "Cţͷ����ʿ-10*5");
        GameBuilder.build(playerA, playerB).playGame();
    }
    
    @Test
    public void ˮԴ������vs����Ů��_������������() {
        PlayerInfo playerA = PlayerBuilder.build("��A��", 50, "CˮԴ������-10*10", "R����-4", "R����-4", "R����-4");
        PlayerInfo playerB = PlayerBuilder.build("��B��", 50, "C����Ů��-10*10");
        GameBuilder.build(playerA, playerB).playGame();
    }
}
