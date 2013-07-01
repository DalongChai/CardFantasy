package cfvbaibai.cardfantasy.test;

import org.junit.Test;

import cfvbaibai.cardfantasy.data.PlayerInfo;
import cfvbaibai.cardfantasy.data.RuneData;
import cfvbaibai.cardfantasy.game.PlayerBuilder;

public class CardFantasyRuneTest {

    @Test
    public void ��ͷ����vԶ��Ы��_����() {
        TestGameBuilder.play5v5withRunes("��ͷ����", RuneData.����, "Զ��Ы��", RuneData.����);
    }

    @Test
    public void ��������vԶ��Ы��_����() {
        TestGameBuilder.play5v5withRunes("��������", RuneData.����, "Զ��Ы��", RuneData.����);
    }

    @Test
    public void ���vԶ��Ы��_����_����() {
        PlayerInfo playerA = PlayerBuilder.build("��A��", 50, "C���-10*5", "R����-4", "R����-4");
        PlayerInfo playerB = PlayerBuilder.build("��B��", 50, "CԶ��Ы��-10*5", "R����-4", "R����-4");
        TestGameBuilder.build(playerA, playerB).playGame();
    }

    @Test
    public void ��������vԶ��Ы��_�Ҿ�() {
        TestGameBuilder.play5v5withRunes("��������", RuneData.�Ҿ�, "Զ��Ы��", RuneData.�Ҿ�);
    }

    @Test
    public void ���򹭼���v����ѻ���_��ɰ() {
        PlayerInfo playerA = PlayerBuilder.build("��A��", 100, "C���򹭼���-10*15", "R��ɰ-4");
        PlayerInfo playerB = PlayerBuilder.build("��B��", 100, "C����ѻ���-10*15", "R��ɰ-4");
        TestGameBuilder.build(playerA, playerB).playGame();
    }

    @Test
    public void ţͷ������vsս��������_�ұ�() {
        TestGameBuilder.play5v5withRunes("ţͷ������", RuneData.�ұ�, "ս��������", RuneData.�ұ�);
    }

    @Test
    public void ˮԴ������vsţͷ������_ʯ��() {
        TestGameBuilder.play5v5withRunes("ˮԴ������", RuneData.�ұ�, "ţͷ������", RuneData.ʯ��);
    }

    @Test
    public void ��������vs���۾���_���() {
        TestGameBuilder.play5v5withRunes("��������", RuneData.�ұ�, "���۾���", RuneData.���);
    }

    @Test
    public void ���vs֩����Ů��_����() {
        TestGameBuilder.play5v5withRunes("���", RuneData.�ұ�, "֩����Ů��", RuneData.����);
    }

    @Test
    public void ��������vs֩����Ů��_����() {
        TestGameBuilder.play5v5withRunes("��������", RuneData.�ұ�, "֩����Ů��", RuneData.����);
    }

    @Test
    public void ����ì��vs����ͻ����_˪������() {
        TestGameBuilder.play5v5withRunes("����ì��", RuneData.˪��, "����ͻ����", RuneData.����);
    }

    @Test
    public void ħ���ᾧ��vsħ���ᾧ��_��׶() {
        TestGameBuilder.play5v5withRunes("ħ���ᾧ��", RuneData.��׶, "ħ���ᾧ��", RuneData.��׶);
    }

    @Test
    public void ħ���ᾧ��v���侫�鷨ʦ_����() {
        TestGameBuilder.play5v5withRunes("ħ���ᾧ��", RuneData.����, "���侫�鷨ʦ", RuneData.��׶);
    }

    @Test
    public void ����ì��vs����ͻ����_������Ȫ() {
        TestGameBuilder.play5v5withRunes("����ì��", RuneData.����, "����ͻ����", RuneData.��Ȫ);
    }

    @Test
    public void ħ���ᾧ��v���侫�鷨ʦ_ѩ��ŭ��() {
        PlayerInfo playerA = PlayerBuilder.build("��A��", 50, "Cħ���ᾧ��-10*5", "Rѩ��-4");
        PlayerInfo playerB = PlayerBuilder.build("��B��", 10, "C���侫�鷨ʦ-10*5", "Rŭ��-4");
        TestGameBuilder.build(playerA, playerB).playGame();
    }

    @Test
    public void �ʼ����ӽ���vs����ո���_����() {
        TestGameBuilder.play5v5withRunes("�ʼ����ӽ���", RuneData.����, "����ո���", RuneData.��Ȫ);
    }

    @Test
    public void ħ��Э�᳤vs���ħ_ʥȪ() {
        TestGameBuilder.play5v5withRunes("ħ��Э�᳤", RuneData.ʥȪ, "���ħ", RuneData.��Ȫ);
    }

    @Test
    public void ����ì��vs����ͻ����_��������() {
        TestGameBuilder.play5v5withRunes("����ì��", RuneData.����, "����ͻ����", RuneData.����);
    }

    @Test
    public void ˮԴ������vs����ӵ����_��������() {
        PlayerInfo playerA = PlayerBuilder.build("��A��", 50, "CˮԴ������-10*5", "R����-4");
        PlayerInfo playerB = PlayerBuilder.build("��B��", 20, "C����ӵ����-10*5", "R����-4");
        TestGameBuilder.build(playerA, playerB).playGame();
    }

    @Test
    public void ˮԴ������vs����ӵ����_��������() {
        TestGameBuilder.play5v5withRunes("ˮԴ������", RuneData.����, "����ӵ����", RuneData.����);
    }

    @Test
    public void ���˼�˾vsţͷ����ʿ_����쫷�() {
        PlayerInfo playerA = PlayerBuilder.build("��A��", 50, "C���˼�˾-10*5", "R����-4");
        PlayerInfo playerB = PlayerBuilder.build("��B��", 20, "Cţͷ����ʿ-10*5", "R쫷�-4");
        TestGameBuilder.build(playerA, playerB).playGame();
    }

    @Test
    public void ���˼�˾vsţͷ����ʿ_���綴��() {
        PlayerInfo playerA = PlayerBuilder.build("��A��", 50, "C���˼�˾-10*5", "R����-4", "R����-4");
        PlayerInfo playerB = PlayerBuilder.build("��B��", 50, "Cţͷ����ʿ-10*5");
        TestGameBuilder.build(playerA, playerB).playGame();
    }
    
    @Test
    public void ˮԴ������vs����Ů��_������������() {
        PlayerInfo playerA = PlayerBuilder.build("��A��", 50, "CˮԴ������-10*10", "R����-4", "R����-4", "R����-4");
        PlayerInfo playerB = PlayerBuilder.build("��B��", 50, "C����Ů��-10*10");
        TestGameBuilder.build(playerA, playerB).playGame();
    }
    
    @Test
    public void �ڼ�����ʿvs����ɯŮ��_��ȭ����() {
        PlayerInfo playerA = PlayerBuilder.build("��A��", 50, "C�ڼ�����ʿ-10*5", "R��ȭ-4");
        PlayerInfo playerB = PlayerBuilder.build("��B��", 30, "C����ɯŮ��-10*5", "R����-4");
        TestGameBuilder.build(playerA, playerB).playGame();
    }

    @Test
    public void �ڼ�����ʿvs����ɯŮ��_�������() {
        TestGameBuilder.play5v5withRunes("�ڼ�����ʿ", RuneData.����, "����ɯŮ��", RuneData.����);
    }
    
    @Test
    public void �ڼ�����ʿvs����ɯŮ��_ڤ�����() {
        PlayerInfo playerA = PlayerBuilder.build("��A��", 50, "C�ڼ�����ʿ-10*5", "Rڤ��-4");
        PlayerInfo playerB = PlayerBuilder.build("��B��", 20, "C����ɯŮ��-10*5", "R����-4");
        TestGameBuilder.build(playerA, playerB).playGame();
    }
    
    @Test
    public void �ڼ�����ʿvs��������_�׶ܷ����׼�() {
        PlayerInfo playerA = PlayerBuilder.build("��A��", 50, "C�ڼ�����ʿ-10*5", "R����-4", "R�׼�-4");
        PlayerInfo playerB = PlayerBuilder.build("��B��", 20, "C��������-10*5", "R����-4", "R�׶�-4");
        TestGameBuilder.build(playerA, playerB).playGame();
    }
    
    @Test
    public void �ڼ�����ʿvs��������_�����ƻ�() {
        PlayerInfo playerA = PlayerBuilder.build("��A��", 50, "C�ڼ�����ʿ-10*5", "R����-4", "R�ƻ�-4");
        PlayerInfo playerB = PlayerBuilder.build("��B��", 20, "C��������-10*5");
        TestGameBuilder.build(playerA, playerB).playGame();
    }

    @Test
    public void ���ħvs��������_������ɱ() {
        PlayerInfo playerA = PlayerBuilder.build("��A��", 50, "C���ħ-10*10", "R����-4", "R��ɱ-4");
        PlayerInfo playerB = PlayerBuilder.build("��B��", 20, "C��������-10*10");
        TestGameBuilder.build(playerA, playerB).playGame();
    }
}
