package cfvbaibai.cardfantasy.engine.feature;

import java.util.List;

import cfvbaibai.cardfantasy.GameUI;
import cfvbaibai.cardfantasy.Randomizer;
import cfvbaibai.cardfantasy.data.Feature;
import cfvbaibai.cardfantasy.engine.CardInfo;
import cfvbaibai.cardfantasy.engine.CardStatusItem;
import cfvbaibai.cardfantasy.engine.CardStatusType;
import cfvbaibai.cardfantasy.engine.FeatureInfo;
import cfvbaibai.cardfantasy.engine.FeatureResolver;
import cfvbaibai.cardfantasy.engine.HeroDieSignal;
import cfvbaibai.cardfantasy.engine.Player;
import cfvbaibai.cardfantasy.engine.StageInfo;

public final class ConfusionFeature {
    public static void apply(FeatureInfo featureInfo, FeatureResolver resolver, CardInfo attacker, Player defender,
            int victimCount) throws HeroDieSignal {
        Feature feature = featureInfo.getFeature();
        StageInfo stage = resolver.getStage();
        Randomizer random = stage.getRandomizer();
        GameUI ui = stage.getUI();

        int rate = feature.getImpact();
        List<CardInfo> victims = random.pickRandom(defender.getField().toList(), victimCount, true, null);
        ui.useSkill(attacker, victims, feature, true);
        for (CardInfo victim : victims) {
            if (!resolver.resolveAttackBlockingFeature(attacker, victim, feature, 1).isAttackable()) {
                continue;
            }
            if (victim.getStatus().containsStatus(CardStatusType.迷惑)) {
                continue;
            }
            if (random.roll100(rate)) {
                CardStatusItem status = CardStatusItem.confused(featureInfo);
                ui.addCardStatus(attacker, victim, feature, status);
                victim.addStatus(status);
            }
        }
    }
}
