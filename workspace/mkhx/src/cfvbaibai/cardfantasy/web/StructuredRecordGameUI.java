package cfvbaibai.cardfantasy.web;

import java.util.List;

import cfvbaibai.cardfantasy.CardFantasyRuntimeException;
import cfvbaibai.cardfantasy.GameUI;
import cfvbaibai.cardfantasy.data.Feature;
import cfvbaibai.cardfantasy.data.FeatureType;
import cfvbaibai.cardfantasy.engine.CardInfo;
import cfvbaibai.cardfantasy.engine.CardStatusItem;
import cfvbaibai.cardfantasy.engine.EntityInfo;
import cfvbaibai.cardfantasy.engine.FeatureEffect;
import cfvbaibai.cardfantasy.engine.Field;
import cfvbaibai.cardfantasy.engine.GameResult;
import cfvbaibai.cardfantasy.engine.Phase;
import cfvbaibai.cardfantasy.engine.Player;
import cfvbaibai.cardfantasy.engine.RuneInfo;

public class StructuredRecordGameUI extends GameUI {

    private BattleRecord record;
    public StructuredRecordGameUI() {
        this.record = new BattleRecord();
    }
    
    public BattleRecord getRecord() {
        return this.record;
    }
    
    @Override
    public void stageCreated() {
        record.addEvent("stage-created");
    }
    
    @Override
    public void gameStarted() {
        record.addEvent("game-start");
    }

    @Override
    public void playerAdded(Player player, int playerNumber) {
        PlayerInitInfo pii = new PlayerRuntimeInfo(player, playerNumber);
        record.addEvent("player-added", pii);
    }

    @Override
    public void errorHappened(CardFantasyRuntimeException e) {
        record.addEvent("error-happened", e.getMessage());
    }

    @Override
    public void phaseChanged(Player player, Phase previous, Phase current) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void playerChanged(Player previousPlayer, Player nextPlayer) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void gameEnded(GameResult result) {
        PlayerRuntimeInfo winner = new PlayerRuntimeInfo(
                result.getWinner(), this.getPlayerNumber(result.getWinner()));
        PlayerRuntimeInfo loser = new PlayerRuntimeInfo(
                result.getLoser(), this.getPlayerNumber(result.getLoser()));
        record.addEvent("game-ended", winner, loser, result.getCause(), result.getDamageToBoss());
    }

    @Override
    public void cardDrawed(Player drawer, CardInfo card) {
        record.addEvent("card-drawed", drawer.getId(), card.getId(), card.getUniqueName(), card.getSummonDelay());
    }

    @Override
    public void cantDrawDeckEmpty(Player drawer) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void cantDrawHandFull(Player drawer) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void summonCard(Player player, CardInfo card) {
        this.record.addEvent("summon-card", player.getId(), new CardInitInfo(card));
    }

    @Override
    public void roundStarted(Player player, int round) {
        this.record.addEvent("round-started", round, player.getId());
    }

    @Override
    public void roundEnded(Player player, int round) {
        this.record.addEvent("round-ended", round, player.getId());
    }

    @Override
    public void attackCard(EntityInfo attacker, CardInfo defender, Feature cardFeature, int damage) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void cardDead(CardInfo deadCard) {
        this.record.addEvent("card-dead", deadCard.getOwner().getId(), new CardRuntimeInfo(deadCard));
    }

    @Override
    public void attackHero(EntityInfo attacker, Player hero, Feature cardFeature, int damage) {
        this.record.addEvent("attack-hero", new PlayerRuntimeInfo(hero, this.getPlayerNumber(hero)), damage);
    }

    @Override
    public void useSkill(EntityInfo caster, List<? extends EntityInfo> targets, Feature feature) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void protect(EntityInfo protector, EntityInfo attacker, EntityInfo protectee, Feature attackFeature,
            Feature protectFeature) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void useSkillToHero(EntityInfo caster, Player targetHero, Feature feature) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void addCardStatus(EntityInfo attacker, CardInfo victim, Feature cardFeature, CardStatusItem item) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void battleBegins() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void attackBlocked(EntityInfo attacker, CardInfo defender, Feature atFeature, Feature dfFeature) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void adjustAT(EntityInfo source, CardInfo target, int adjAT, Feature cardFeature) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void adjustHP(EntityInfo source, CardInfo target, int adjHP, Feature cardFeature) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void blockDamage(EntityInfo protector, EntityInfo attacker, EntityInfo defender, Feature cardFeature,
            int originalDamage, int actualDamage) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void healBlocked(EntityInfo healer, CardInfo healee, Feature cardFeature, Feature blockerFeature) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void debuffDamage(CardInfo card, CardStatusItem item, int effect) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void cannotAction(CardInfo card) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void recoverAT(CardInfo card, FeatureType cause, int recoveredAT) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void healCard(EntityInfo healer, CardInfo healee, Feature cardFeature, int healHP) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void healHero(EntityInfo healer, Player healee, Feature cardFeature, int healHP) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void loseAdjustATEffect(CardInfo ally, FeatureEffect effect) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void loseAdjustHPEffect(CardInfo ally, FeatureEffect effect) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void cardToDeck(Player player, CardInfo card) {
    }

    @Override
    public void cardToHand(Player player, CardInfo card) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void blockStatus(EntityInfo attacker, EntityInfo defender, Feature cardFeature, CardStatusItem item) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void blockFeature(EntityInfo attacker, EntityInfo defender, Feature cardFeature, Feature attackFeature) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void returnCard(CardInfo attacker, CardInfo defender, Feature cardFeature) {
        this.record.addEvent("return-card",
                attacker.getOwner().getId(), new CardRuntimeInfo(attacker),
                defender.getOwner().getId(), new CardRuntimeInfo(defender));
    }

    @Override
    public void cardToGrave(Player player, CardInfo card) {
        this.record.addEvent("card-to-grave", player.getId(), new CardRuntimeInfo(card));
    }

    @Override
    public void disableBlock(CardInfo attacker, CardInfo defender, Feature attackFeature, Feature blockFeature) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void confused(CardInfo card) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void roll100(int dice, int rate) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void useSkill(EntityInfo caster, Feature feature) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void killCard(EntityInfo attacker, CardInfo victim, Feature cardFeature) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void activateRune(RuneInfo rune) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void deactivateRune(RuneInfo rune) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void compactField(Field field) {
        this.record.addEvent("compact-field", field.getOwner().getId());
    }

    @Override
    public void showMessage(String string) {
        // TODO Auto-generated method stub
        
    }
}
