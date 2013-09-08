package cfvbaibai.cardfantasy.test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.junit.Test;

import cfvbaibai.cardfantasy.Table;
import cfvbaibai.cardfantasy.data.CardData;
import cfvbaibai.cardfantasy.data.CardDataStore;
import cfvbaibai.cardfantasy.data.Legion;
import cfvbaibai.cardfantasy.data.PlayerInfo;
import cfvbaibai.cardfantasy.engine.GameEngine;
import cfvbaibai.cardfantasy.engine.GameResult;
import cfvbaibai.cardfantasy.engine.Rule;
import cfvbaibai.cardfantasy.game.DummyGameUI;
import cfvbaibai.cardfantasy.game.GameResultStat;
import cfvbaibai.cardfantasy.game.PlayerBuilder;

public class FreeTest extends PveEngineTest {

    private static GameResultStat massivePlay10v10(String card1, String card2, int level) {
        return play(PlayerBuilder.build("Ӣ��" + card1, level, "C" + card1 + "-10*10"),
                PlayerBuilder.build("Ӣ��" + card2, level, "C" + card2 + "-10*10"), 1000);
    }

    private static GameResultStat massivePlay1v1(String card1, String card2, int level) {
        return play(PlayerBuilder.build("Ӣ��" + card1, level, "C" + card1 + "-10*1"),
                PlayerBuilder.build("Ӣ��" + card2, level, "C" + card2 + "-10*1"), 1000);
    }

    private static GameResultStat massivePlay1v1Lv15(String card1, String card2, int level) {
        return play(PlayerBuilder.build("Ӣ��" + card1, level, "C" + card1 + "-15"),
                PlayerBuilder.build("Ӣ��" + card2, level, "C" + card2 + "-10"), 1000);
    }

    private static GameResultStat massivePlay10v10Lv15(String card1, String card2, int level) {
        return play(PlayerBuilder.build("Ӣ��" + card1, level, "C" + card1 + "-15*10"),
                PlayerBuilder.build("Ӣ��" + card2, level, "C" + card2 + "-10*10"), 1000);
    }

    private static void showStat(GameResultStat stat) {
        System.out.println("Total: " + stat.count());
        System.out.println(String.format("%s wins %d (%d %%)", stat.getP1().getId(), stat.getP1Win(),
                stat.getP1WinRate()));
        System.out.println(String.format("%s wins %d (%d %%)", stat.getP2().getId(), stat.getP2Win(),
                stat.getP2WinRate()));
    }

    private static GameResultStat play(PlayerInfo p1, PlayerInfo p2, int count) {
        GameResultStat stat = new GameResultStat(p1, p2);
        for (int i = 0; i < count; ++i) {
            GameEngine engine = new GameEngine(new DummyGameUI(), Rule.getDefault());
            engine.RegisterPlayers(p1, p2);
            GameResult result = engine.playGame();
            stat.addResult(result);
        }
        return stat;
    }

    @Test
    public void ���侫��vs����_1000() throws IOException {
        FiveStarChallenge("���侫��", true, false);
    }

    @Test
    public void ����֮Ӱvs����_1000() throws IOException {
        FiveStarChallenge("����֮Ӱ", true, false);
    }

    @Test
    public void ��ʥvs����_1000() throws IOException {
        FiveStarChallenge("��ʥ", true, false);
    }

    @Test
    public void ������ʹvs����_1000() throws IOException {
        FiveStarChallenge("������ʹ", true, false);
    }

    @Test
    public void �������vs����_1000() throws IOException {
        FiveStarChallenge("�������", true, false);
    }

    @Test
    public void �־�֮��vs����_1000() throws IOException {
        FiveStarChallenge("�־�֮��", true, false);
    }

    @Test
    public void ���̹�����vs����_1000_10v10() throws IOException {
        FiveStarChallenge("���̹�����", true, true);
    }

    @Test
    public void ��ŭ����vs����_1000() throws IOException {
        FiveStarChallenge("��ŭ����", false, false);
    }

    @Test
    public void ��ŭ����vs����_10vs10_1000() throws IOException {
        FiveStarChallenge("��ŭ����", true, false);
    }

    @Test
    public void ����ʥŮvs����_1000() throws IOException {
        FiveStarChallenge("����ʥŮ", false, false);
    }

    @Test
    public void ����ʥŮvs����_10vs10_1000() throws IOException {
        FiveStarChallenge("����ʥŮ", true, false);
    }

    @Test
    public void ���۾���vs����_1000() throws IOException {
        FiveStarChallenge("���۾���", false, false);
    }

    @Test
    public void ���۾���vs����_10vs10_1000() throws IOException {
        FiveStarChallenge("���۾���", true, false);
    }

    @Test
    public void ɭ��Ů��vs����_10vs10_1000() throws IOException {
        FiveStarChallenge("ɭ��Ů��", true, false);
    }

    @Test
    public void ����֩��vs����_10vs10_1000() throws IOException {
        FiveStarChallenge("����֩��", true, true);
    }

    @Test
    public void ��ͷ����vs����_2vs2_1000() throws IOException {
        FiveStarChallenge("��ͷ����", false, false);
    }

    @Test
    public void �ʼ�ѱ��ʦvs����_10vs10_1000() throws IOException {
        FiveStarChallenge("�ʼ�ѱ��ʦ", true, false);
    }
    
    @Test
    public void ħ��ս() {
        PlayerInfo player = PlayerBuilder.build("���", 75, new Legion(10, 10, 10, 10), "���侫��*2", "����");
        TestGameBuilder.playBossBattle(player, "����Ů��");
    }
    
    @Test
    public void ��ɨBug() {
        TestGameBuilder.play5v5("����֮��", "��������");
    }
    
    @Test
    public void ��ɨ�ұ�Bug() {
        PlayerInfo p1 = PlayerBuilder.build("����Ӣ��", 75, "����֮��*5");
        PlayerInfo p2 = PlayerBuilder.build("����Ӣ��", 75, "ţͷ������*5", "�ұ�");
        TestGameBuilder.play(p1, p2);
    }
    
    @Test
    public void ��ɨ����() {
        TestGameBuilder.play5v5("����֮��", "������ʹ");
    }
    
    @Test
    public void ��ɱBug() {
        PlayerInfo player = PlayerBuilder.build("���", "������ʹ*4,����֮��*1,����֮��*3,�ƻ�,����,��Ȫ,��ɱ", 75);
        TestGameBuilder.playBossBattle(player, "����Ů��");
    }
    
    @Test
    public void ��������Bug() {
        PlayerInfo p1 = PlayerBuilder.build("���1", "��������*5,�׶�", 75);
        PlayerInfo p2 = PlayerBuilder.build("���2", "ս��������+��������1,����", 75);
        TestGameBuilder.play(p1, p2);
    }
    
    @Test
    public void �ػ���Bug() {
        PlayerInfo p1 = PlayerBuilder.build("���1", "а��֮��", 75);
        PlayerInfo p2 = PlayerBuilder.build("���2", "ħ��ʿ+��7*2", 75);
        TestGameBuilder.play(p1, p2);
    }
    
    @Test
    public void ������ǿvsɭ����ǿ_1000() {
        for (int i = 6; i < 10; ++i) {
            System.out.println("Level: " + (i * 10));
            PlayerInfo p1 = PlayerBuilder.build("����Ӣ��", i * 10, "C����֮��-10*10", "R����-4", "R��Ȫ-4", "R����-4");// ,
                                                                                                          // "Rŭ��-4");
            PlayerInfo p2 = PlayerBuilder.build("ɭ��Ӣ��", i * 10, "C��������-10*10", "R�׶�-4", "R����-4", "R����-4");// ,
                                                                                                          // "R����-4");
            showStat(play(p1, p2, 1000));
        }
    }

    @Test
    public void ������ǿvs��ɭ��ǿ_1000() {
        for (int i = 6; i < 10; ++i) {
            System.out.println("Level: " + (i * 10));
            PlayerInfo p1 = PlayerBuilder.build("����Ӣ��", i * 10, "C����֮��-10*10", "R����-4", "R��Ȫ-4", "R����-4", "Rŭ��-4");
            PlayerInfo p2 = PlayerBuilder.build("��ɭӢ��", i * 10, "C��������-10*5", "C������ʹ-10*5", "R�׶�-4", "R����-4", "R����-4",
                    "R��Ȫ-4");
            showStat(play(p2, p1, 10000));
        }
    }

    @Test
    public void ������ǿvs������ǿ_1000() {
        for (int i = 6; i < 10; ++i) {
            System.out.println("Level: " + (i * 10));
            PlayerInfo p1 = PlayerBuilder.build("����Ӣ��", i * 10, "C����֮��-10*10", "R����-4", "R��Ȫ-4", "R����-4", "R����-4");
            PlayerInfo p2 = PlayerBuilder.build("����Ӣ��", i * 10, "C����-10*10", "R�ұ�-4", "R���-4", "R����-4", "R����-4");
            showStat(play(p2, p1, 1000));
        }
    }

    @Test
    public void ת��һ��vsʮ�彣ʥ_1000() {
        for (int i = 6; i < 10; ++i) {
            System.out.println("Level: " + (i * 10));
            PlayerInfo p1 = PlayerBuilder.build("һ��Ӣ��", i * 10, "Cת�����侫��-15*10", "R�ƻ�-4", "R����-4", "R����-4", "R쫷�-4");
            PlayerInfo p2 = PlayerBuilder.build("��ʥӢ��", i * 10, "C��ʥ-15*10", "R����-4", "R����-4", "R��Ȫ-4", "R����-4");
            showStat(play(p1, p2, 1000));
        }
    }

    @Test
    public void ����vs����_1000() {
        for (int i = 6; i < 10; ++i) {
            System.out.println("Level: " + (i * 10));
            PlayerInfo p1 = PlayerBuilder.build("����Ӣ��", i * 10, "C����֮��-10*10", "R����-4", "R��Ȫ-4", "R����-4", "R����-4");
            PlayerInfo p2 = PlayerBuilder.build("����Ӣ��", i * 10, "C˪ѩ����-10*6", "C���˼�˾-10*4", "R�׶�-4", "R����-4", "R����-4");
            showStat(play(p1, p2, 1000));
        }
    }

    @Test
    public void ����vs����_1000() {
        for (int i = 6; i < 10; ++i) {
            System.out.println("Level: " + (i * 10));
            PlayerInfo p1 = PlayerBuilder.build("����Ӣ��", i * 10, "C����֮��-10*10", "R����-4", "R��Ȫ-4", "R쫷�-4", "R����-4");
            PlayerInfo p2 = PlayerBuilder.build("����Ӣ��", i * 10, "Cս��������-10*10", "R���-4", "R����-4", "R����-4", "Rŭ��-4");
            showStat(play(p2, p1, 1000));
        }
    }

    @Test
    public void ����vs����() {
        PlayerInfo p1 = PlayerBuilder.build("����Ӣ��", 90, "C����֮��-10*10", "R����-4", "R��Ȫ-4", "R쫷�-4", "R����-4");
        PlayerInfo p2 = PlayerBuilder.build("����Ӣ��", 90, "Cս��������-10*10", "R���-4", "R����-4", "R����-4", "Rŭ��-4");
        TestGameBuilder.play(p1, p2);
    }

    @Test
    public void ��ʹvs֩��() {
        PlayerInfo p1 = PlayerBuilder.build("��ʹӢ��", 90, "C������ʹ-10*10");
        PlayerInfo p2 = PlayerBuilder.build("֩��Ӣ��", 90, "C֩����Ů��-10*10");
        showStat(play(p1, p2, 1000));
        showStat(play(p2, p1, 1000));
    }

    @Test
    public void ��������vsת����ʹ() {
        PlayerInfo p1 = PlayerBuilder.build("����Ӣ��", "ս��������+����*5,ս��������+��ɨ*5,���", 90);
        PlayerInfo p2 = PlayerBuilder.build("��ʹӢ��", "������ʹ+ת��5*5,������ʹ+����2*5,����", 90);
        TestGameBuilder.play(p1, p2);
    }
    
    @Test
    public void ��ɨ����vsת����ʹ() { 
        PlayerInfo p1 = PlayerBuilder.build("����Ӣ��", "ս��������+��ɨ*5", 90);
        PlayerInfo p2 = PlayerBuilder.build("��ʹӢ��", "������ʹ+ת��5*5", 90);
        TestGameBuilder.play(p1, p2);
    }
    
    @Test
    public void �������׶���() {
        PlayerInfo p1 = PlayerBuilder.build("���1", "������ʹ*3,��������*3,ħ��Э�᳤,������ʯ��-15,��Դ���-15,�������Ů��,����,����,��Ȫ,�׶�", 68);
        PlayerInfo p2 = PlayerBuilder.build("���2", "������ʹ*5,������֮��*2,��������*2,����,����,��Ȫ,�׶�", 64);
        TestGameBuilder.play(p1, p2);
    }

    @Test
    public void ����������1() {
        PlayerInfo p1 = PlayerBuilder.build("�ҷ�Ӣ��", 74, "C��������-10*4", "C�־�֮��-10*4", "C����ո���-10*2", "R�׶�-4", "R����-4",
                "R�ƻ�-4", "R��ɱ-4");
        PlayerInfo p2 = PlayerBuilder.build("�з�Ӣ��", 84, "C��������-10*4", "C������ʹ-10*6", "R����-4", "R��Ȫ-4", "R�׶�-4", "R����-4");
        showStat(play(p1, p2, 1000));
        showStat(play(p2, p1, 1000));
        PlayerInfo p3 = PlayerBuilder.build("�з�Ӣ��", 84, "C��������-10*5", "C������ʹ-10*5", "R����-4", "R��Ȫ-4", "R�׶�-4", "R����-4");
        showStat(play(p1, p3, 1000));
        showStat(play(p3, p1, 1000));
    }

    @Test
    public void ����������2() {
        PlayerInfo p0 = PlayerBuilder.build("�з�Ӣ��", 75, "C��������-10*5", "C������ʹ-10*5", "R����-4", "R��Ȫ-4", "R�׶�-4", "R����-4");
        PlayerInfo p1 = PlayerBuilder.build("�ҷ�Ӣ��", 75, "C����֮��-10*2", "C������ʹ-10*2", "Cħ��Э�᳤-10", "C����ո���-10*2",
                "C��������-10*3", "R�׶�-4", "R��Ȫ-4", "R����-4", "R����-4");
        showStat(play(p0, p1, 1000));
        showStat(play(p1, p0, 1000));
        PlayerInfo p2 = PlayerBuilder.build("�ҷ�Ӣ��", 75, "C����֮��-10*2", "C������ʹ-10*2", "Cħ��Э�᳤-10", "C����ո���-10",
                "C�־�֮��-10", "C��������-10*3", "R�׶�-4", "R��Ȫ-4", "R����-4", "R����-4");
        showStat(play(p0, p2, 1000));
        showStat(play(p2, p0, 1000));
        PlayerInfo p3 = PlayerBuilder.build("�ҷ�Ӣ��", 75, "C����֮��-10", "C������ʹ-10*3", "Cħ��Э�᳤-10", "C����ո���-10*2",
                "C��������-10*3", "R�׶�-4", "R��Ȫ-4", "R����-4", "R����-4");
        showStat(play(p0, p3, 1000));
        showStat(play(p3, p0, 1000));
        PlayerInfo p4 = PlayerBuilder.build("�ҷ�Ӣ��", 75, "C����֮��-10", "C������ʹ-10*3", "Cħ��Э�᳤-10", "C����ո���-10", "C�־�֮��-10",
                "C��������-10*3", "R�׶�-4", "R��Ȫ-4", "R����-4", "R����-4");
        showStat(play(p0, p4, 1000));
        showStat(play(p4, p0, 1000));
    }

    @Test
    public void ����������3() {
        PlayerInfo p0 = PlayerBuilder.build("�з�Ӣ��", 75, "C��������-10*6", "C������ʹ-10*4", "R����-4", "R��Ȫ-4", "R�׶�-4", "R����-4");
        PlayerInfo p1 = PlayerBuilder.build("�ҷ�Ӣ��", 75, "C��������-10*3", "C�������Ů��-10*2", "C����-10*3", "C��Դ���-10*1",
                "C������-10*1", "R�׶�-4", "R����-4", "R�ұ�-4", "R���-4");
        showStat(play(p0, p1, 1000));
        showStat(play(p1, p0, 1000));
        PlayerInfo p2 = PlayerBuilder.build("�ҷ�Ӣ��", 75, "C��������-10*3", "C�������Ů��-10*1", "C����-10*4", "C��Դ���-10*1",
                "C������-10*1", "R�׶�-4", "R����-4", "R�ұ�-4", "R���-4");
        showStat(play(p0, p2, 1000));
        showStat(play(p2, p0, 1000));
        PlayerInfo p3 = PlayerBuilder.build("�ҷ�Ӣ��", 75, "C��������-10*4", "C����-10*4", "C��Դ���-10*1", "C������-10*1", "R�׶�-4",
                "R����-4", "R�ұ�-4", "R���-4");
        showStat(play(p0, p3, 1000));
        showStat(play(p3, p0, 1000));
        PlayerInfo p4 = PlayerBuilder.build("�ҷ�Ӣ��", 75, "C��������-10*4", "C�������Ů��-10*1", "C����-10*4", "C������-10*1",
                "R�׶�-4", "R����-4", "R�ұ�-4", "R���-4");
        showStat(play(p0, p4, 1000));
        showStat(play(p4, p0, 1000));
    }

    @Test
    public void ����������4() {
        PlayerInfo p0 = PlayerBuilder.build("����1", 75, "C��������-10*5", "C������ʹ-10*5", "R����-4", "R��Ȫ-4", "R�׶�-4", "R����-4");
        PlayerInfo p1 = PlayerBuilder.build("����2", 75, "C��������-15*10", "R����-4", "Rʯ��-4", "R����-4", "R���-4");
        PlayerInfo p2 = PlayerBuilder.build("����3", 75, "C������ʹ-10*5", "C����ո���-10*2", "C�����ػ���-10", "C�־�֮��-10*2", "R����-4",
                "R��Ȫ-4", "R�ƻ�-4", "R��ɱ-4");
        PlayerInfo p3 = PlayerBuilder.build("����4", 75, "C��������-15*4", "C���̸��-10*2", "C�־�֮��-10*3", "C�����ػ���-10", "Rʯ��-4",
                "R�ƻ�-4", "R��ɱ-4", "R���-4");
        showStat(play(p0, p1, 1000));
        showStat(play(p0, p2, 1000));
        showStat(play(p0, p3, 1000));

        showStat(play(p1, p0, 1000));
        showStat(play(p1, p2, 1000));
        showStat(play(p1, p3, 1000));

        showStat(play(p2, p0, 1000));
        showStat(play(p2, p1, 1000));
        showStat(play(p2, p3, 1000));

        showStat(play(p3, p0, 1000));
        showStat(play(p3, p1, 1000));
        showStat(play(p3, p2, 1000));
    }
    
    @Test
    public void ����������5() {
        PlayerInfo p0 = PlayerBuilder.build("��ǿ��ɭ", 75, "C��������-10*5", "C������ʹ-10*5", "R����-4", "R��Ȫ-4", "R�׶�-4", "R����-4");
        PlayerInfo p1 = PlayerBuilder.build("�����", 75, "Cڤ�Ӵ���-10","C����ո���-10*3", "Cħ��Э�᳤-10", "C������ʹ-10*5",
                "R����-4", "R��Ȫ-4", "R����-4", "R�ƻ�-4");
        PlayerInfo p2 = PlayerBuilder.build("��ͷս��1��", 75, "Cħ��Э�᳤-10", "Cս��-10*2", "C������ʹ-10*3", "C����ո���-10*4",
                "R����-4", "R��Ȫ-4", "R����-4", "R�ƻ�-4");
        PlayerInfo p3 = PlayerBuilder.build("��ͷս��2��", 75, "Cħ��Э�᳤-10", "Cս��-10*2", "C������ʹ-10*3", "C����ո���-10*3", "Cڤ�Ӵ���-10",
                "R����-4", "R��Ȫ-4", "R����-4", "R�ƻ�-4");
        showStat(play(p0, p1, 1000));
        showStat(play(p1, p0, 1000));
        showStat(play(p0, p2, 1000));
        showStat(play(p2, p0, 1000));
        showStat(play(p0, p3, 1000));
        showStat(play(p3, p0, 1000));
    }
    
    @Test
    public void ����������6() {
        PlayerInfo p0 = PlayerBuilder.build("��ǿ��ɭ", 75, "C��������-10*5", "C������ʹ-10*5", "R����-4", "R����-4", "R�׶�-4", "R����-4");
        //4����1����3����2���� ����ұ��׶ܴ���
        PlayerInfo p1 = PlayerBuilder.build("��ɭһ��", 75, "C����-10*4", "C������-10", "C��������-10*3", "C�������Ů��-10*2",
                "R���-4", "R�ұ�-4", "R�׶�-4", "R����-4");
        //2����2����1����3����2����
        PlayerInfo p2 = PlayerBuilder.build("��ɭ����", 75, "C����-10*2", "C��������-10*2", "C������-10", "C��������-10*3", "C�������Ů��-10*2",
                "R���-4", "R�ұ�-4", "R�׶�-4", "R����-4");
        showStat(play(p0, p1, 1000));
        showStat(play(p1, p0, 1000));
        showStat(play(p0, p2, 1000));
        showStat(play(p2, p0, 1000));
    }
    
    
    @Test
    public void ����������7() {
        PlayerInfo p0 = PlayerBuilder.build("��ǿ��ɭ", 75, "C��������-10*5", "C������ʹ-10*5", "R����-4", "R����-4", "R�׶�-4", "R����-4");
        // 3����1����1���3����2���� �׶ܴ������ұ�
        PlayerInfo p00 = PlayerBuilder.build("��ǿ��ɭ", 75, "C����-10*3", "C��������-10", "C��Դ���-10", "C��������-10*3", "C�������Ů��-10*2",
                "R���-4", "R����-4", "R�׶�-4", "R�ұ�-4");
        //4��ʹ����ͷ��2�־壬2����1�����������ƻ������Ȫ����
        PlayerInfo p1 = PlayerBuilder.build("����һ��", 75, "C������ʹ-10*4", "Cħ��Э�᳤-10", "C�־�֮��-10*2", "C����ո���-10*2", "C����֮��-10",
                "R�ƻ�-4", "R����-4", "R��Ȫ-4", "R����-4");
        //4��ʹ����ͷ��4�־壬1����
        PlayerInfo p2 = PlayerBuilder.build("��������", 75, "C������ʹ-10*4", "Cħ��Э�᳤-10", "C�־�֮��-10*4", "C����֮��-10",
                "R�ƻ�-4", "R����-4", "R��Ȫ-4", "R����-4");
        showStat(play(p0, p1, 1000));
        showStat(play(p1, p0, 1000));
        showStat(play(p0, p2, 1000));
        showStat(play(p2, p0, 1000));
        
        showStat(play(p00, p1, 1000));
        showStat(play(p1, p00, 1000));
        showStat(play(p00, p2, 1000));
        showStat(play(p2, p00, 1000));
    }
    
    
    @Test
    public void ����������8() {
        PlayerInfo p0 = PlayerBuilder.build("��ǿ��ɭ", 85, "C��������-10*5", "C������ʹ-10*5", "R����-4", "R����-4", "R�׶�-4", "R����-4");
        // ����*1��ˮԴ*1�����*2����ͷ*1�� ����*1����е����*1����ʥ*1������*1�����*1, �׶ܣ����磬���⣬����
        PlayerInfo p1 = PlayerBuilder.build("����1", 85, "C��������-10", "CˮԴ������-10", "C���-10*2", "Cħ��Э�᳤-10", "C������ʯ��-10", "C��е����-10",
                "C��ʥ-10", "C����ո���-10", "C��Դ���-10", "R����-4", "R����-4", "R�׶�-4", "R����-4");
        // ����*1��ˮԴ*1�����*2����ͷ*1�� ����*1����е����*1���ʼ����ӳ�*1������*1�����*1, �׶ܣ����磬���⣬����
        PlayerInfo p2 = PlayerBuilder.build("����2", 85, "C��������-10", "CˮԴ������-10", "C���-10*2", "Cħ��Э�᳤-10", "C������ʯ��-10", "C��е����-10",
                "C�ʼ����ӽ���-10", "C����ո���-10", "C��Դ���-10", "R����-4", "R����-4", "R�׶�-4", "R����-4");
        // ����*1��ˮԴ*1�����*2����ͷ*1�� ����*1����е����*1��������*1������*1�����*1, �׶ܣ����磬���⣬����
        PlayerInfo p3 = PlayerBuilder.build("����3", 85, "C��������-10", "CˮԴ������-10", "C���-10*2", "Cħ��Э�᳤-10", "C������ʯ��-10", "C��е����-10",
                "C������-10", "C����ո���-10", "C��Դ���-10", "R����-4", "R����-4", "R�׶�-4", "R����-4");
        // ����*1��ˮԴ*1�����*2����ͷ*1�� ����*1����е����*1���ʼ�ѱ��ʦ������*1�����*1, �׶ܣ����磬���⣬����
        PlayerInfo p4 = PlayerBuilder.build("����4", 85, "C��������-10", "CˮԴ������-10", "C���-10*2", "Cħ��Э�᳤-10", "C������ʯ��-10", "C��е����-10",
                "C�ʼ�ѱ��ʦ-10", "C����ո���-10", "C��Դ���-10", "R����-4", "R����-4", "R�׶�-4", "R����-4");
        // ����1��ˮԴ1,���2��ɭŮ1����ͷ1������1�����1��������ʿ1������1, �����׶ܳ�ȴ���
        PlayerInfo p5 = PlayerBuilder.build("����5", 85, "C��������-10", "CˮԴ������-10", "C���-10*2", "Cɭ��Ů��-10", "Cħ��Э�᳤-10", 
                "C����ո���-10", "C��Դ���-10", "C������ʿ-10", "Cս��������-10", "R���-4", "R����-4", "R�׶�-4", "R����-4");
        // ����1��ˮԴ2,���2����ͷ1������1�����1��������ʿ1������1, �����׶ܳ�ȴ���
        PlayerInfo p6 = PlayerBuilder.build("����6", 85, "C��������-10", "CˮԴ������-10*2", "C���-10*2", "Cħ��Э�᳤-10", 
                "C����ո���-10", "C��Դ���-10", "C������ʿ-10", "Cս��������-10", "R���-4", "R����-4", "R�׶�-4", "R����-4");
        
        showStat(play(p0, p1, 1000));
        showStat(play(p1, p0, 1000));
        showStat(play(p0, p2, 1000));
        showStat(play(p2, p0, 1000));
        showStat(play(p0, p3, 1000));
        showStat(play(p3, p0, 1000));
        showStat(play(p0, p4, 1000));
        showStat(play(p4, p0, 1000));
        showStat(play(p0, p5, 1000));
        showStat(play(p5, p0, 1000));
        showStat(play(p0, p6, 1000));
        showStat(play(p6, p0, 1000));
        
        showStat(play(p1, p2, 1000));
        showStat(play(p1, p3, 1000));
        showStat(play(p1, p4, 1000));
        showStat(play(p1, p5, 1000));
        showStat(play(p1, p6, 1000));
        
        showStat(play(p2, p1, 1000));
        showStat(play(p2, p3, 1000));
        showStat(play(p2, p4, 1000));
        showStat(play(p2, p5, 1000));
        showStat(play(p2, p6, 1000));
        
        showStat(play(p3, p1, 1000));
        showStat(play(p3, p2, 1000));
        showStat(play(p3, p4, 1000));
        showStat(play(p3, p5, 1000));
        showStat(play(p3, p6, 1000));
        
        showStat(play(p4, p1, 1000));
        showStat(play(p4, p2, 1000));
        showStat(play(p4, p3, 1000));
        showStat(play(p4, p5, 1000));
        showStat(play(p4, p6, 1000));
        
        showStat(play(p5, p1, 1000));
        showStat(play(p5, p2, 1000));
        showStat(play(p5, p3, 1000));
        showStat(play(p5, p4, 1000));
        showStat(play(p5, p6, 1000));
        
        showStat(play(p6, p1, 1000));
        showStat(play(p6, p2, 1000));
        showStat(play(p6, p3, 1000));
        showStat(play(p6, p4, 1000));
        showStat(play(p6, p5, 1000));
        
        
    }
    
    @Test
    public void ����֮��vs�־�_1000() {
        PlayerInfo p1 = PlayerBuilder.build("Ӣ��������", 80, "C�������-10*1");
        PlayerInfo p2 = PlayerBuilder.build("Ӣ�ۿ־�֮��", 80, "C�־�֮��-10*1");
        showStat(play(p2, p1, 1000));
    }

    private void FiveStarChallenge(String cardName, boolean is10v10, boolean isLevel15) throws IOException {
        CardDataStore store = CardDataStore.loadDefault();
        int[] heroLevels = new int[] { 60, 70, 80, 90 };
        Table<String> table = new Table<String>();
        table.setCell(0, 0, "Ӣ�۵ȼ�");
        for (int i = 0; i < heroLevels.length; ++i) {
            table.setCell(0, i + 1, String.valueOf(heroLevels[i]));
        }
        List<CardData> cards = store.getCardOfStar(5);
        for (int i = 0; i < cards.size(); ++i) {
            table.setCell(i + 1, 0, cards.get(i).getName());
        }
        for (int i = 0; i < heroLevels.length; ++i) {
            int heroLevel = heroLevels[i];
            for (int j = 0; j < cards.size(); ++j) {
                System.out.println("Level: " + heroLevel + ", Card: " + cards.get(j).getName());
                GameResultStat stat = null;
                if (is10v10) {
                    if (isLevel15) {
                        stat = massivePlay10v10Lv15(cardName, cards.get(j).getName(), heroLevel);
                    } else {
                        stat = massivePlay10v10(cardName, cards.get(j).getName(), heroLevel);
                    }
                } else {
                    if (isLevel15) {
                        stat = massivePlay1v1Lv15(cardName, cards.get(j).getName(), heroLevel);
                    } else {
                        stat = massivePlay1v1(cardName, cards.get(j).getName(), heroLevel);
                    }
                }
                table.setCell(j + 1, i + 1, String.valueOf(stat.getP1Win()));
            }
        }
        table.outputToCsv(new File("E:\\My\\Documents\\FallenElfvsStar5s.csv"));
    }

    @Test
    public void TestCsvWriter() throws IOException {
        CsvWriter writer = new CsvWriter(new File("E:\\My\\Documents\\Test.csv"));
        writer.writeFields(new Object[] { "A", "b", "C" });
        writer.writeFields(new Object[] { "A", "b", "C" });
        writer.writeFields(new Object[] { "A", "b", "C" });
        writer.close();
    }

    @Test
    public void ���侫��vs����ʥŮ() {
        TestGameBuilder.play10v10("���侫��", "��������");
    }

    @Test
    public void ���侫��vs�־�֮��() {
        TestGameBuilder.play10v10("���侫��", "�־�֮��");
    }

    @Test
    public void �־�֮��vs���侫��() {
        TestGameBuilder.play10v10("�־�֮��", "���侫��");
    }

    @Test
    public void ��ʥvsս��() {
        TestGameBuilder.play10v10("��ʥ", "ս��");
    }

    @Test
    public void ������ʹvs����Ů��() {
        TestGameBuilder.play10v10("������ʹ", "����Ů��");
    }

    @Test
    public void ������ʹvs������֪() {
        TestGameBuilder.play10v10("������ʹ", "������֪");
    }

    @Test
    public void ���侫��vsʥ������() {
        TestGameBuilder.play1v1("���侫��", "ʥ������");
    }

    @Test
    public void ��ͷ����vs���() {
        TestGameBuilder.play2v2("��ͷ����", "���");
    }
    

    @Test
    public void ��ͷ����vs��ͷ����() {
        TestGameBuilder.play2v2("��ͷ����", "��ͷ����");
    }
    
    @Test
    public void �ʼ�ѱ��ʦvs��ͷ����() {
        TestGameBuilder.play10v10("�ʼ�ѱ��ʦ", "��ͷ����", 62);
    }
}
