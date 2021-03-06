package cfvbaibai.cardfantasy.test;

import cfvbaibai.cardfantasy.engine.CardInfo;
import cfvbaibai.cardfantasy.engine.GameEngine;
import cfvbaibai.cardfantasy.engine.Player;
import cfvbaibai.cardfantasy.engine.RuneInfo;
import cfvbaibai.cardfantasy.engine.StageInfo;
import cfvbaibai.cardfantasy.game.DeckStartupInfo;

public class FeatureTestContext {
    private GameEngine engine;
    private DeckStartupInfo dsi;

    public Player getPlayer(int index) {
        return getStage().getPlayers().get(index);
    }
    public StageInfo getStage() {
        return getEngine().getStage();
    }
    public GameEngine getEngine() {
        return engine;
    }
    public void setEngine(GameEngine engine) {
        this.engine = engine;
    }
    public DeckStartupInfo getDsi() {
        return dsi;
    }
    public void setDsi(DeckStartupInfo dsi) {
        this.dsi = dsi;
    }
    public CardInfo getCardInfo(int cardIndex, int playerIndex) {
        return dsi.getCardInfo(cardIndex, getStage().getPlayers().get(playerIndex));
    }
    public CardInfo addToField(int cardIndex, int playerIndex) {
        return getPlayer(playerIndex).getField().addCard(getCardInfo(cardIndex, playerIndex));
    }
    public CardInfo addToHand(int cardIndex, int playerIndex) {
        return getPlayer(playerIndex).getHand().addCard(getCardInfo(cardIndex, playerIndex));
    }
    public CardInfo addToGrave(int cardIndex, int playerIndex) {
        return getPlayer(playerIndex).getGrave().addCard(getCardInfo(cardIndex, playerIndex));
    }
    public CardInfo addToDeck(int cardIndex, int playerIndex) {
        return getPlayer(playerIndex).getDeck().addCard(getCardInfo(cardIndex, playerIndex));
    }
    public RuneInfo addToRune(int runeIndex, int playerIndex) {
        Player player = getPlayer(playerIndex);
        return player.getRuneBox().addRune(new RuneInfo(dsi.getRunes().get(runeIndex), player));
    }
}
