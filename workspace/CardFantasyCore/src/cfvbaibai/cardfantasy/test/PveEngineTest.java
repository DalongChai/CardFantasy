package cfvbaibai.cardfantasy.test;

import java.util.List;

import org.junit.Test;

import cfvbaibai.cardfantasy.Combination;
import cfvbaibai.cardfantasy.data.Card;
import cfvbaibai.cardfantasy.data.PlayerInfo;
import cfvbaibai.cardfantasy.data.Rune;
import cfvbaibai.cardfantasy.engine.Rule;
import cfvbaibai.cardfantasy.game.DeckEvaluation;
import cfvbaibai.cardfantasy.game.DeckStartupInfo;
import cfvbaibai.cardfantasy.game.DummyGameUI;
import cfvbaibai.cardfantasy.game.PlayerBuilder;
import cfvbaibai.cardfantasy.game.PveEngine;
import cfvbaibai.cardfantasy.game.PveGameResultStat;

public class PveEngineTest {

    protected PveEngine engine;
    protected PveEngine massiveEngine;

    public PveEngineTest() {
        engine = new PveEngine(new TestGameUI(), Rule.getDefault());
        massiveEngine = new PveEngine(new DummyGameUI(), Rule.getDefault());
    }

    @Test
    public void TestMap1_1_1() {
        PlayerInfo player = PlayerBuilder.build("ME", 50, "Cɭ����-1*3");
        engine.play(player, "1-1-3");
    }

    @Test
    public void TestMap10_10_1() {
        PlayerInfo player = PlayerBuilder.build("ME", 46, "R쫷�-2", "R����-3", "R��Ȫ-4", "R�ұ�-3", "C������ʿ-10", "C����-10",
                "Cս��������-10*2", "C֩����Ů��-10*2", "C�ʼ����ӽ���-10*2", "C������-10", "C������ʯ��-10");
        engine.play(player, "10-10-1");
    }

    @Test
    public void TestMap9_10_1() {
        PlayerInfo p1 = PlayerBuilder.build("ME", 47, "R����-4", "Rʯ��-4", "R���-4", "R�ұ�-4", "C���-10", "C����֮��-10",
                "C����ɯŮ��-10", "CˮԴ������-10", "Cս��������-10*2", "C������ʯ��-10", "C֩����Ů��-10*3");
        engine.play(p1, "9-10-1");
    }

    @Test
    public void TestMassivePlayMap1_1_1() {
        PlayerInfo player = PlayerBuilder.build("ME", 50, "C���򹭼���-1*1");
        PveGameResultStat stat = massiveEngine.massivePlay(player, "1-1-3", 1000);
        showStat(stat);
    }

    @Test
    public void TestMassivePlayMap8_H_3() {
        PlayerInfo player = PlayerBuilder.build("ME", 50, "C��������-10*3", "C��֮����-10", "C����֮��-10", "Cħ��Э�᳤-10",
                "C����ɯŮ��-10", "CˮԴ������-10*2", "C��¹���ػ���-10", "Cɭ��Ů��-10");// ,
                                                                      // "R����-4",
                                                                      // "R����-4",
                                                                      // "R�׶�-4",
                                                                      // "R����-4");
        PveGameResultStat stat = massiveEngine.massivePlay(player, "8-H-3", 1000);
        showStat(stat);
    }

    @Test
    public void TestMassivePlayMap10_10_1() {
        PlayerInfo player = PlayerBuilder.build("ME", 50, "C��������-10*3", "C��֮����-10", "C����֮��-10", "Cħ��Э�᳤-10",
                "C����ɯŮ��-10", "CˮԴ������-10*2", "C��¹���ػ���-10", "Cɭ��Ů��-10");// ,
                                                                      // "R����-4",
                                                                      // "R����-4",
                                                                      // "R�׶�-4",
                                                                      // "R����-4");
        PveGameResultStat stat = massiveEngine.massivePlay(player, "10-10-1", 1000);
        showStat(stat);
    }
    
    @Test
    public void TestMassivePlayMap10_10_2() {
        PlayerInfo player = PlayerBuilder.build("ME", 46,
                "C����֮��-10", "C������ʹ-10", "C����-10", "C��ʥ-10", "C������ʯ��-10",
                "C����ɯŮ��-10", "CˮԴ������-10", "C������ʹ-10", "C֩����Ů��-10", "Cս��������-10",
                "R��Ȫ-4", "R����-4", "R����-4", "R����-4");// ,
                                                                      // "R����-4",
                                                                      // "R����-4",
                                                                      // "R�׶�-4",
                                                                      // "R����-4");
        engine.play(player, "10-10-2");
        PveGameResultStat stat = massiveEngine.massivePlay(player, "10-10-2", 1000);
        showStat(stat);
    }

    private void showStat(PveGameResultStat stat) {
        System.out.println("Total: " + stat.count());
        System.out.println("Lose: " + stat.countLost());
        System.out.println("Win: " + stat.countAllWin() + " (" + stat.getAllWinRate() + "%)");
        System.out.println("Adv Win: " + stat.countAdvWin() + " (" + stat.getAdvWinRate() + "%)");
    }

    @Test
    public void TestCombination() {
        List<List<Integer>> result = Combination.calculate(3, 1, 2, 3, 4, 5, 6);
        StringBuffer sb = new StringBuffer();
        for (List<Integer> entry : result) {
            for (Integer element : entry) {
                sb.append(element);
                sb.append(", ");
            }
            sb.append("\r\n");
        }
        System.out.println(sb.toString());
    }

    @Test
    public void TestOptimizeDeck() {
        List<DeckEvaluation> evals = massiveEngine.optimizeDeck(0, 1, "1-2-3", 5, -1, "C�װ�֩��-1", "C��������-1");
        for (int i = 0; i < evals.size(); ++i) {
            DeckEvaluation eval = evals.get(i);
            System.out.println("#" + i + ": AdvWinRate: " + eval.getStat().getAdvWinRate() + "%");
            showDeck(eval.getDeck());
        }
    }

    /**
     * лл¥���ˡ� ������Ȫ4������3��쫷�2��ʯ��3�� ������ս�����ޣ�����2Ů�����ӳ������̣��������ؼ����������ɳ��ȫ10��
     * ���ÿ��жӳ�10��������10���ڼ�5������5��
     */
    // TODO: Optimize this deck

    @Test
    public void TestOptimizeDeck_10_10_1() {
        List<DeckEvaluation> evals = massiveEngine.optimizeDeck(4, 10, "10-10-1", 46, 5, "R쫷�-2", "R����-3", "R��Ȫ-4",
                "R�ұ�-3", "C������ʿ-10", "C����-10", "Cս��������-10*2", "C֩����Ů��-10*2", "C�ʼ����ӽ���-10*2", "C������-10", "C������ʯ��-10",
                "C�ؼ����-10", "C����ɯŮ��-10", "C�ڼ�����ʿ-5", "C����ٿ���-5");
        // "C���۾���-10*4", "C��е����-10", "Cʨ����ʿ-10", "C��Ӱ����-10",
        // "C���ħ-10",
        // "C����������-10", "C��ҫ����-10", "C������-10", "C�����-10", "C�籩�ٻ���-10",
        // "Cʹ��֮��-10", "Cа��Ů��-10", "Cս��������-10*3",
        // "Cţͷ������-10", "C�ʼ����ӽ���-10*2", "CˮԴ������-10*4");

        for (int i = 0; i < evals.size(); ++i) {
            DeckEvaluation eval = evals.get(i);
            System.out.println("#" + i + ": AdvWinRate: " + eval.getStat().getAdvWinRate() + "%");
            showDeck(eval.getDeck());
        }
    }

    /*
     * �ҵĿ��У�1��ˡ�1������1����ɳ��1ˮԴ��2���1������3Ů������ʵ����1Ů��1�������ǿʮ�� �����д�����ʯ�֡���ȡ��ұڡ���ǿ����
     * �ȼ���47����
     */

    @Test
    public void TestOptimizeDeck_9_10_1() {
        List<DeckEvaluation> evals = massiveEngine.optimizeDeck(4, 10, "9-10-1", 47, 5, "R����-4", "Rʯ��-4", "R���-4",
                "R�ұ�-4", "C���-10", "C����֮��-10", "C����ɯŮ��-10", "CˮԴ������-10", "Cս��������-10*2", "C������ʯ��-10", "C֩����Ů��-10*3",
                "Cа��Ů��-10", "C�ڼ�����ʿ-10");
        // "C���۾���-10*4", "C��е����-10", "Cʨ����ʿ-10", "C��Ӱ����-10",
        // "C���ħ-10",
        // "C����������-10", "C��ҫ����-10", "C������-10", "C�����-10", "C�籩�ٻ���-10",
        // "Cʹ��֮��-10", "Cа��Ů��-10", "Cս��������-10*3",
        // "Cţͷ������-10", "C�ʼ����ӽ���-10*2", "CˮԴ������-10*4");

        for (int i = 0; i < evals.size(); ++i) {
            DeckEvaluation eval = evals.get(i);
            System.out.println("#" + i + ": AdvWinRate: " + eval.getStat().getAdvWinRate() + "%");
            showDeck(eval.getDeck());
        }
    }

    private void showDeck(DeckStartupInfo deck) {
        StringBuffer sb = new StringBuffer();
        sb.append("Runes: ");
        for (Rune rune : deck.getRunes()) {
            sb.append(rune.getName());
            sb.append(rune.getLevel());
            sb.append(", ");
        }
        sb.append("\r\nCards: ");
        for (Card card : deck.getCards()) {
            sb.append(card.getName());
            sb.append(card.getLevel());
            sb.append(", ");
        }
        System.out.println(sb.toString());
    }
}
