package cfvbaibai.cardfantasy;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import cfvbaibai.cardfantasy.data.Feature;
import cfvbaibai.cardfantasy.data.FeatureType;
import cfvbaibai.cardfantasy.engine.Board;
import cfvbaibai.cardfantasy.engine.CardInfo;
import cfvbaibai.cardfantasy.engine.CardStatusItem;
import cfvbaibai.cardfantasy.engine.Deck;
import cfvbaibai.cardfantasy.engine.EntityInfo;
import cfvbaibai.cardfantasy.engine.FeatureEffect;
import cfvbaibai.cardfantasy.engine.Field;
import cfvbaibai.cardfantasy.engine.GameResult;
import cfvbaibai.cardfantasy.engine.Grave;
import cfvbaibai.cardfantasy.engine.Hand;
import cfvbaibai.cardfantasy.engine.Phase;
import cfvbaibai.cardfantasy.engine.Player;
import cfvbaibai.cardfantasy.engine.RuneBox;
import cfvbaibai.cardfantasy.engine.RuneInfo;

public abstract class TextGameUI extends GameUI {
    protected abstract void say(String obj);
    
    protected void sayF(String format, Object... args) {
        say(String.format(format, args));
    }
    
    @Override
    public void playerAdded(Player player, int playerNumber) {

    }

    @Override
    public void roundStarted(Player player, int round) {
        say("======================================================");
        sayF("�غ� %d ��ʼ��<%s> �ж�", round, player.getId());
        say("======================================================");
    }

    @Override
    public void roundEnded(Player player, int round) {
        sayF("<%s> �Ļغ� %d ����", player.getId(), round);
    }

    @Override
    public void errorHappened(CardFantasyRuntimeException e) {
        e.printStackTrace();
    }

    @Override
    public void phaseChanged(Player player, Phase previous, Phase current) {
        sayF("�׶�ת��: %s => %s", previous.name().toUpperCase(), current.name().toUpperCase());
    }

    @Override
    public void playerChanged(Player previousPlayer, Player nextPlayer) {
        sayF("�ж���ҽ���: <%s> => <%s>", previousPlayer.getId(), nextPlayer.getId());
    }

    @Override
    public void cardDrawed(Player drawer, CardInfo card) {
        sayF("<%s> ����һ�ſ�: <%s (�ȼ�: %d)>", drawer.getId(), card.getUniqueName(), card.getLevel());
        showBoard();
    }

    @Override
    public void cantDrawDeckEmpty(Player drawer) {
        sayF("��� <%s> �ƶ��ѿգ��޷��鿨.", drawer.getId());
        this.showBoard();
    }

    @Override
    public void cantDrawHandFull(Player drawer) {
        sayF("��� <%s> �����������޷��鿨.", drawer.getId());
        this.showBoard();
    }

    @Override
    public void summonCard(Player player, CardInfo card) {
        sayF("<%s> �ٻ�: <%s (�ȼ�: %d)>", player.getId(), card.getUniqueName(), card.getLevel());
    }

    @Override
    public void attackCard(EntityInfo attacker, CardInfo defender, Feature cardFeature, int damage) {
        String featureClause = cardFeature == null ? "" : (" by " + cardFeature.getShortDesc() + "");
        int logicalRemainingHP = defender.getHP() - damage;
        if (logicalRemainingHP < 0) {
            sayF("%s ���� %s%s. �˺�: %d (%d ���). HP: %d -> 0.", attacker.getShortDesc(), defender.getShortDesc(),
                    featureClause, damage, -logicalRemainingHP, defender.getHP());
        } else {
            sayF("%s ���� %s%s. �˺�: %d. HP: %d -> %d", attacker.getShortDesc(), defender.getShortDesc(), featureClause,
                    damage, defender.getHP(), logicalRemainingHP);
        }
    }

    @Override
    public void cardDead(CardInfo deadCard) {
        sayF("%s ����!", deadCard.getShortDesc());
    }

    @Override
    public void attackHero(EntityInfo attacker, Player hero, Feature cardFeature, int damage) {
        String featureClause = cardFeature == null ? "" : (" ʹ�� " + cardFeature.getShortDesc() + "");
        int logicalRemainingHP = hero.getHP() - damage;
        if (logicalRemainingHP < 0) {
            sayF("%s%s ֱ�ӹ��� <%s>! �˺�: %d (%d ���). HP: %d -> %d", attacker.getShortDesc(), featureClause, hero.getId(),
                    damage, -logicalRemainingHP, hero.getHP(), 0);
        } else {
            sayF("%s%s ֱ�ӹ��� <%s>! �˺�: %d. HP: %d -> %d", attacker.getShortDesc(), featureClause, hero.getId(), damage,
                    hero.getHP(), hero.getHP() - damage);
        }
    }

    @Override
    public void useSkill(EntityInfo attacker, List<? extends EntityInfo> victims, Feature cardFeature) {
        if (victims.isEmpty()) {
            sayF("%s �޷��ҵ�ʹ�� %s �ĺ���Ŀ��.", attacker.getShortDesc(), cardFeature.getShortDesc());
        } else {
            List<String> victimTexts = new LinkedList<String>();
            for (EntityInfo victim : victims) {
                victimTexts.add(victim.getShortDesc());
            }
            String victimsText = StringUtils.join(victimTexts, ", ");
            String featureDesc = cardFeature == null ? "����ͨ������" : cardFeature.getShortDesc();
            sayF("%s �� { %s } ʹ�� %s!", attacker.getShortDesc(), victimsText, featureDesc);
        }
    }

    @Override
    public void useSkillToHero(EntityInfo attacker, Player victimHero, Feature cardFeature) {
        String featureDesc = cardFeature == null ? "����ͨ������" : cardFeature.getShortDesc();
        sayF("%s ��Ӣ�� <%s> ʹ�� %s!", attacker.getShortDesc(), victimHero.getId(), featureDesc);
    }

    @Override
    public void addCardStatus(EntityInfo attacker, CardInfo victim, Feature cardFeature, CardStatusItem item) {
        sayF("%s.%s ʹ %s �õ�״̬: ��%s��", attacker.getShortDesc(), cardFeature.getShortDesc(), victim.getShortDesc(),
                item.getShortDesc());
    }

    @Override
    public void gameEnded(GameResult result) {
        String s = String.format("ս������. ʤ����: <%s>, ʤ����ʽ: %s", result.getWinner().getId(), result.getCause().toString());
        if (result.getDamageToBoss() >= 0) {
            s += ", ħ���ܵ��˺�: " + result.getDamageToBoss();
        }
        say(s);
    }
    
    @Override
    public void stageCreated() {
        
    }

    @Override
    public void gameStarted() {
        say("ս����ʼ!");
        sayF("����: ���������=%d, ���غ�=%d", getRule().getMaxHandCards(), getRule().getMaxRound());
        this.showBoard();
    }

    private void showBoard() {
        Board board = this.getBoard();
        say("-----------------------------------------------------------------------------");
        Player player = board.getPlayer(0);
        sayF("���: %s - HP: %d", player.getId(), player.getHP());
        showGrave(player.getGrave());
        showDeck(player.getDeck());
        showHand(player.getHand());
        say("");
        showRune(player.getRuneBox());
        showField(player.getField());
        say("");

        player = board.getPlayer(1);
        say("");
        showField(player.getField());
        showRune(player.getRuneBox());
        say("");
        showHand(player.getHand());
        showDeck(player.getDeck());
        showGrave(player.getGrave());
        sayF("���: %s - HP: %d", player.getId(), player.getHP());
        say("-----------------------------------------------------------------------------");
    }

    private void showRune(RuneBox runeBox) {
        StringBuffer sb = new StringBuffer();
        sb.append("���� : ");
        for (RuneInfo rune : runeBox.getRunes()) {
            sb.append(rune.getShortDesc());
            sb.append(", ");
        }
        say(sb.toString());
    }

    private void showGrave(Grave grave) {
        StringBuffer sb = new StringBuffer();
        sb.append("Ĺ��: ");
        for (CardInfo card : grave.toList()) {
            sb.append(String.format("%s (�ȼ�=%d, ����=%d, HP=%d), ", card.getUniqueName(), card.getLevel(), card.getInitAT(),
                    card.getMaxHP()));
        }
        say(sb.toString());
    }

    private void showField(Field field) {
        StringBuffer sb = new StringBuffer();
        // sb.append("Field: ");
        int i = 0;
        List<CardInfo> cards = field.getAliveCards();
        for (CardInfo card : cards) {
            sb.append(String.format("[%d] %s (�ȼ�=%d, ����=%d/%d, HP=%d/%d/%d, ״̬=%s, Ч��=%s)\r\n", i, card.getUniqueName(),
                    card.getLevel(), card.getAT(), card.getInitAT(), card.getHP(), card.getMaxHP(),
                    card.getOriginalMaxHP(), card.getStatus().getShortDesc(), card.getEffectsDesc()));
            ++i;
        }
        if (cards.size() > 0) {
            sb.deleteCharAt(sb.length() - 1);
            sb.deleteCharAt(sb.length() - 1);
        }
        say(sb.toString());
    }

    private void showHand(Hand hand) {
        StringBuffer sb = new StringBuffer();
        sb.append("����: ");
        for (CardInfo card : hand.toList()) {
            sb.append(String.format("%s (�ȼ�=%d, ����=%d, HP=%d, �ȴ�=%d), ", card.getUniqueName(), card.getLevel(),
                    card.getInitAT(), card.getMaxHP(), card.getSummonDelay()));
        }
        say(sb.toString());
    }

    private void showDeck(Deck deck) {
        StringBuffer sb = new StringBuffer();
        sb.append("�ƶ�: ");
        for (CardInfo card : deck.toList()) {
            sb.append(String.format("%s (�ȼ�=%d, ����=%d, HP=%d), ", card.getUniqueName(), card.getLevel(), card.getInitAT(),
                    card.getMaxHP()));
        }
        say(sb.toString());
    }

    @Override
    public void battleBegins() {
        this.showBoard();
    }

    @Override
    public void attackBlocked(EntityInfo attacker, CardInfo defender, Feature atFeature, Feature dfFeature) {
        String attackerDesc = attacker.getShortDesc();
        if (atFeature == null && dfFeature == null) {
            sayF("%s ����״̬ %s �У��޷�����!", attackerDesc, attacker.getStatus().getShortDesc());
        } else if (atFeature == null && dfFeature != null) {
            sayF("%s �Ĺ����� %s ʹ�� %s ������!", attackerDesc, defender.getShortDesc(), dfFeature.getShortDesc());
        } else if (atFeature != null && dfFeature == null) {
            sayF("%s ����״̬ %s �У��޷�ʹ�� %s!", attackerDesc, attacker.getStatus().getShortDesc(), atFeature.getShortDesc());
        } else if (atFeature != null && dfFeature != null) {
            sayF("%s �� %s �� %s �� %s ������!", attackerDesc, atFeature.getShortDesc(), defender.getShortDesc(),
                    dfFeature.getShortDesc());
        }
    }

    @Override
    public void adjustAT(EntityInfo source, CardInfo target, int adjAT, Feature cardFeature) {
        String verb = adjAT > 0 ? "����" : "����";
        sayF("%s ʹ�� %s %s �� %s �� %d �㹥��! %d -> %d.", source.getShortDesc(), cardFeature.getShortDesc(), verb,
                target.getShortDesc(), adjAT, target.getAT(), target.getAT() + adjAT);
    }

    @Override
    public void adjustHP(EntityInfo source, CardInfo target, int adjHP, Feature cardFeature) {
        String verb = adjHP > 0 ? "����" : "����";
        sayF("%s ʹ�� %s %s �� %s ��HP! %d -> %d.", source.getShortDesc(), cardFeature.getShortDesc(), verb,
                target.getShortDesc(), target.getHP(), target.getHP() + adjHP);
    }

    @Override
    public void blockDamage(EntityInfo protector, EntityInfo attacker, EntityInfo defender, Feature cardFeature,
            int originalDamage, int actualDamage) {
        sayF("%s ʹ�� %s Ϊ %s �������� %s �Ĺ���. �˺�: %d -> %d", protector.getShortDesc(), cardFeature.getShortDesc(),
                defender.getShortDesc(), attacker.getShortDesc(), originalDamage, actualDamage);
    }

    @Override
    public void debuffDamage(CardInfo card, CardStatusItem item, int damage) {
        sayF("%s ����״̬ %s ���ܵ��˺�. �˺�: %d. HP: %d -> %d", card.getShortDesc(), item.getShortDesc(), damage, card.getHP(),
                Math.max(0, card.getHP() - damage));
    }

    @Override
    public void cannotAction(CardInfo card) {
        sayF("%s ����״̬ %s �У��޷��ж�!", card.getShortDesc(), card.getStatus().getShortDesc());
    }

    @Override
    public void recoverAT(CardInfo card, FeatureType cause, int recoveredAT) {
        sayF("%s �Ĺ����� ��%s�� ��Ч���лָ�. ����: %d -> %d", card.getShortDesc(), cause.name(), card.getAT(), card.getAT()
                - recoveredAT);
    }

    @Override
    public void healCard(EntityInfo healer, CardInfo healee, Feature cardFeature, int healHP) {
        int postHealHP = healee.getHP() + healHP;
        String healText = String.valueOf(healHP);
        if (postHealHP > healee.getMaxHP()) {
            healText += " (" + (postHealHP - healee.getMaxHP()) + " overflow)";
            postHealHP = healee.getMaxHP();
        }
        sayF("%s ʹ�� %s ������ %s %s ��HP. HP: %d -> %d", healer.getShortDesc(), cardFeature.getShortDesc(),
                healee.getShortDesc(), healText, healee.getHP(), postHealHP);
    }

    @Override
    public void healHero(EntityInfo healer, Player healee, Feature cardFeature, int healHP) {
        int postHealHP = healee.getHP() + healHP;
        String healText = String.valueOf(healHP);
        if (postHealHP > healee.getMaxHP()) {
            healText += " (" + (postHealHP - healee.getMaxHP()) + " overflow)";
            postHealHP = healee.getMaxHP();
        }
        sayF("%s ʹ�� %s ������ %s %s ��HP. HP: %d -> %d", healer.getShortDesc(), cardFeature.getShortDesc(),
                healee.getShortDesc(), healText, healee.getHP(), postHealHP);
    }

    @Override
    public void loseAdjustATEffect(CardInfo ally, FeatureEffect effect) {
        sayF("%s ʧȥ�� %s �� %s ��ɵ�Ч��. ����: %d -> %d.", ally.getShortDesc(), effect.getSource().getShortDesc(), effect
                .getCause().getFeature().getShortDesc(), ally.getAT(), ally.getAT() - effect.getValue());
    }

    @Override
    public void loseAdjustHPEffect(CardInfo ally, FeatureEffect effect) {
        int currentHP = ally.getHP() > ally.getMaxHP() - effect.getValue() ? ally.getMaxHP() - effect.getValue() : ally
                .getHP();
        sayF("%s ʧȥ�� %s �� %s ��ɵ�Ч��. HP: %d -> %d.", ally.getShortDesc(), effect.getSource().getShortDesc(), effect
                .getCause().getFeature().getShortDesc(), ally.getHP(), currentHP);
    }

    @Override
    public void cardToDeck(Player player, CardInfo card) {
        sayF("%s ���Ż� %s ���ƶ�.", card.getShortDesc(), player.getShortDesc());
    }

    @Override
    public void cardToHand(Player player, CardInfo card) {
        sayF("%s ���Ż� %s ������.", card.getShortDesc(), player.getShortDesc());
    }

    @Override
    public void healBlocked(EntityInfo healer, CardInfo healee, Feature cardFeature, Feature blockerFeature) {
        if (blockerFeature == null) {
            sayF("%s ����״̬ %s �У��޷��� %s �� %s ����!", healee.getShortDesc(), healee.getStatus().getShortDesc(),
                    healer.getShortDesc(), cardFeature.getShortDesc());
        } else {
            throw new CardFantasyRuntimeException("blockerFeature is not null. To be implemented.");
        }
    }

    @Override
    public void blockStatus(EntityInfo attacker, EntityInfo defender, Feature cardFeature, CardStatusItem item) {
        sayF("%s ���� %s ��� ��״̬ ��%s��", defender.getShortDesc(), cardFeature.getShortDesc(), item.getShortDesc());
    }

    @Override
    public void blockFeature(EntityInfo attacker, EntityInfo defender, Feature cardFeature, Feature attackFeature) {
        sayF("%s ʹ�� %s ���� %s", defender.getShortDesc(), cardFeature.getShortDesc(), attackFeature.getShortDesc());
    }

    @Override
    public void returnCard(CardInfo attacker, CardInfo defender, Feature cardFeature) {
        sayF("%s ʹ�� %s �� %s �ͻ����ƶ�.", attacker.getShortDesc(), cardFeature.getShortDesc(), defender.getShortDesc());
    }

    @Override
    public void cardToGrave(Player player, CardInfo card) {
        sayF("%s ������ %s ��Ĺ��", card.getShortDesc(), player.getShortDesc());
    }

    @Override
    public void disableBlock(CardInfo attacker, CardInfo defender, Feature attackFeature, Feature blockFeature) {
        sayF("%s �� %s �� %s �� %s �ƽ���.", defender.getShortDesc(), blockFeature.getShortDesc(), attacker.getShortDesc(),
                attackFeature.getShortDesc());
    }

    @Override
    public void confused(CardInfo card) {
        sayF("%s ����״̬ %s �в��ҹ����˱���Ӣ��!", card.getShortDesc(), card.getStatus().getShortDesc());
        this.attackHero(card, card.getOwner(), null, card.getAT());
    }

    @Override
    public void roll100(int dice, int rate) {
        sayF("�����ӣ������� %d%%��������%d. %s!", rate, dice, dice < rate ? "��" : "����");
    }

    @Override
    public void useSkill(EntityInfo attacker, Feature cardFeature) {
        sayF("%s ʹ�� %s", attacker.getShortDesc(), cardFeature.getShortDesc());
    }

    @Override
    public void killCard(EntityInfo attacker, CardInfo victim, Feature cardFeature) {
        sayF("%s ʹ�� %s ֱ��ɱ�� %s!", attacker.getShortDesc(), cardFeature.getShortDesc(), victim.getShortDesc());
    }

    @Override
    public void activateRune(RuneInfo rune) {
        sayF("%s ������! ʣ�෢������: %d -> %d", rune.getShortDesc(), rune.getEnergy(), rune.getEnergy() - 1);
    }

    @Override
    public void deactivateRune(RuneInfo rune) {
        sayF("%s ��Ϩ��!", rune.getShortDesc());
    }

    @Override
    public void compactField(Field field) {
        int originalSize = field.size();
        int aliveCardCount = field.getAliveCards().size();
        sayF("���� %s �ĳ��Ͽ�Ƭ... ��: %d -> %d", field.getOwner().getShortDesc(), originalSize, aliveCardCount);
    }

    @Override
    public void protect(EntityInfo protector, EntityInfo attacker, EntityInfo protectee, Feature attackFeature,
            Feature protectFeature) {
        String attackFeatureText = attackFeature == null ? "����ͨ������" : attackFeature.getShortDesc();
        sayF("%s ʹ�� %s ���� %s �������� %s �� %s ���ֺ�", protector.getShortDesc(), protectFeature.getShortDesc(),
                protectee.getShortDesc(), attacker.getShortDesc(), attackFeatureText);
    }

    @Override
    public void showMessage(String text) {
        sayF("��ϵͳ��" + text);
    }
}
