package cfvbaibai.cardfantasy.engine;

import java.util.ArrayList;
import java.util.List;

import cfvbaibai.cardfantasy.CardFantasyRuntimeException;
import cfvbaibai.cardfantasy.data.Feature;
import cfvbaibai.cardfantasy.data.FeatureTag;
import cfvbaibai.cardfantasy.data.FeatureType;
import cfvbaibai.cardfantasy.data.Race;
import cfvbaibai.cardfantasy.data.RuneActivationType;
import cfvbaibai.cardfantasy.data.RuneActivator;
import cfvbaibai.cardfantasy.data.RuneData;
import cfvbaibai.cardfantasy.engine.feature.BackStabFeature;
import cfvbaibai.cardfantasy.engine.feature.BlockFeature;
import cfvbaibai.cardfantasy.engine.feature.BloodDrainFeature;
import cfvbaibai.cardfantasy.engine.feature.BloodPaintFeature;
import cfvbaibai.cardfantasy.engine.feature.BloodThirstyFeature;
import cfvbaibai.cardfantasy.engine.feature.BurningFeature;
import cfvbaibai.cardfantasy.engine.feature.BurningFlameFeature;
import cfvbaibai.cardfantasy.engine.feature.ChainAttackFeature;
import cfvbaibai.cardfantasy.engine.feature.ConfusionFeature;
import cfvbaibai.cardfantasy.engine.feature.CounterAttackFeature;
import cfvbaibai.cardfantasy.engine.feature.CounterBiteFeature;
import cfvbaibai.cardfantasy.engine.feature.CounterMagicFeature;
import cfvbaibai.cardfantasy.engine.feature.CriticalAttackFeature;
import cfvbaibai.cardfantasy.engine.feature.CurseFeature;
import cfvbaibai.cardfantasy.engine.feature.DestroyFeature;
import cfvbaibai.cardfantasy.engine.feature.DiseaseFeature;
import cfvbaibai.cardfantasy.engine.feature.DodgeFeature;
import cfvbaibai.cardfantasy.engine.feature.EscapeFeature;
import cfvbaibai.cardfantasy.engine.feature.ExplodeFeature;
import cfvbaibai.cardfantasy.engine.feature.FireMagicFeature;
import cfvbaibai.cardfantasy.engine.feature.GuardFeature;
import cfvbaibai.cardfantasy.engine.feature.HealFeature;
import cfvbaibai.cardfantasy.engine.feature.HeavenWrathFeature;
import cfvbaibai.cardfantasy.engine.feature.IceArmorFeature;
import cfvbaibai.cardfantasy.engine.feature.IceMagicFeature;
import cfvbaibai.cardfantasy.engine.feature.ImmobilityFeature;
import cfvbaibai.cardfantasy.engine.feature.ImmueFeature;
import cfvbaibai.cardfantasy.engine.feature.LighteningMagicFeature;
import cfvbaibai.cardfantasy.engine.feature.MagicShieldFeature;
import cfvbaibai.cardfantasy.engine.feature.OverdrawFeature;
import cfvbaibai.cardfantasy.engine.feature.PenetrationFeature;
import cfvbaibai.cardfantasy.engine.feature.PlagueFeature;
import cfvbaibai.cardfantasy.engine.feature.PoisonMagicFeature;
import cfvbaibai.cardfantasy.engine.feature.PrayFeature;
import cfvbaibai.cardfantasy.engine.feature.PursuitFeature;
import cfvbaibai.cardfantasy.engine.feature.RaceBuffFeature;
import cfvbaibai.cardfantasy.engine.feature.RacialAttackFeature;
import cfvbaibai.cardfantasy.engine.feature.RainfallFeature;
import cfvbaibai.cardfantasy.engine.feature.ReincarnationFeature;
import cfvbaibai.cardfantasy.engine.feature.RejuvenateFeature;
import cfvbaibai.cardfantasy.engine.feature.ResurrectionFeature;
import cfvbaibai.cardfantasy.engine.feature.ReturnFeature;
import cfvbaibai.cardfantasy.engine.feature.ReviveFeature;
import cfvbaibai.cardfantasy.engine.feature.SacrificeFeature;
import cfvbaibai.cardfantasy.engine.feature.SealFeature;
import cfvbaibai.cardfantasy.engine.feature.SnipeFeature;
import cfvbaibai.cardfantasy.engine.feature.SpikeFeature;
import cfvbaibai.cardfantasy.engine.feature.TransportFeature;
import cfvbaibai.cardfantasy.engine.feature.TrapFeature;
import cfvbaibai.cardfantasy.engine.feature.WarthFeature;
import cfvbaibai.cardfantasy.engine.feature.WeakPointAttackFeature;
import cfvbaibai.cardfantasy.engine.feature.WeakenAllFeature;
import cfvbaibai.cardfantasy.engine.feature.WeakenFeature;
import cfvbaibai.cardfantasy.engine.feature.WoundFeature;
import cfvbaibai.cardfantasy.engine.feature.ZealotFeature;

public class FeatureResolver {
    private StageInfo stage;

    public FeatureResolver(StageInfo stage) {
        this.stage = stage;
    }

    public StageInfo getStage() {
        return this.stage;
    }

    public List<CardInfo> getAdjacentCards(Field field, int position) {
        List<CardInfo> cards = new ArrayList<CardInfo>();
        cards.add(field.getCard(position));
        if (position > 0) {
            CardInfo leftSide = field.getCard(position - 1);
            if (leftSide != null) {
                cards.add(leftSide);
            }
        }
        CardInfo rightSide = field.getCard(position + 1);
        if (rightSide != null) {
            cards.add(rightSide);
        }
        return cards;
    }

    public void resolvePreAttackFeature(CardInfo attacker, Player defender) throws HeroDieSignal {
        for (FeatureInfo feature : attacker.getNormalUsableFeatures()) {
            if (attacker.isDead()) {
                continue;
            }
            if (feature.getType() == FeatureType.͸֧) {
                OverdrawFeature.apply(this, feature, attacker);
            }
        }
        for (FeatureInfo feature : attacker.getNormalUsableFeatures()) {
            if (attacker.isDead()) {
                continue;
            }
            if (feature.getType() == FeatureType.δ֪) {
                // JUST A PLACEHOLDER
            } else if (feature.getType() == FeatureType.����) {
                FireMagicFeature.apply(feature.getFeature(), this, attacker, defender, 1);
            } else if (feature.getType() == FeatureType.��ǽ) {
                FireMagicFeature.apply(feature.getFeature(), this, attacker, defender, 3);
            } else if (feature.getType() == FeatureType.����籩) {
                FireMagicFeature.apply(feature.getFeature(), this, attacker, defender, -1);
            } else if (feature.getType() == FeatureType.����) {
                LighteningMagicFeature.apply(feature, this, attacker, defender, 1, 50);
            } else if (feature.getType() == FeatureType.��������) {
                LighteningMagicFeature.apply(feature, this, attacker, defender, 3, 40);
            } else if (feature.getType() == FeatureType.�ױ�) {
                LighteningMagicFeature.apply(feature, this, attacker, defender, -1, 35);
            } else if (feature.getType() == FeatureType.����) {
                IceMagicFeature.apply(feature, this, attacker, defender, 1, 45);
            } else if (feature.getType() == FeatureType.˪������) {
                IceMagicFeature.apply(feature, this, attacker, defender, 3, 35);
            } else if (feature.getType() == FeatureType.����ѩ) {
                IceMagicFeature.apply(feature, this, attacker, defender, -1, 30);
            } else if (feature.getType() == FeatureType.��Һ) {
                PoisonMagicFeature.apply(feature, this, attacker, defender, 1);
            } else if (feature.getType() == FeatureType.����) {
                PoisonMagicFeature.apply(feature, this, attacker, defender, 3);
            } else if (feature.getType() == FeatureType.����) {
                PoisonMagicFeature.apply(feature, this, attacker, defender, -1);
            } else if (feature.getType() == FeatureType.����) {
                TrapFeature.apply(feature, this, attacker, defender);
            } else if (feature.getType() == FeatureType.�ѻ�) {
                SnipeFeature.apply(feature.getFeature(), this, attacker, defender, 1);
            } else if (feature.getType() == FeatureType.����) {
                HealFeature.apply(feature.getFeature(), this, attacker);
            } else if (feature.getType() == FeatureType.����) {
                RainfallFeature.apply(feature.getFeature(), this, attacker);
            } else if (feature.getType() == FeatureType.��) {
                PrayFeature.apply(feature.getFeature(), this, attacker);
            } else if (feature.getType() == FeatureType.����) {
                ReviveFeature.apply(this, feature, attacker);
            } else if (feature.getType() == FeatureType.����) {
                BackStabFeature.apply(this, feature, attacker);
            } else if (feature.getType() == FeatureType.Ⱥ������) {
                WeakenAllFeature.apply(this, feature, attacker, defender);
            } else if (feature.getType() == FeatureType.�ػ�) {
                ResurrectionFeature.apply(this, feature, attacker);
            } else if (feature.getType() == FeatureType.���ؾѻ�) {
                SnipeFeature.apply(feature.getFeature(), this, attacker, defender, 2);
            } else if (feature.getType() == FeatureType.�Ի�) {
                ConfusionFeature.apply(feature, this, attacker, defender, 1);
            } else if (feature.getType() == FeatureType.�һ����) {
                BurningFlameFeature.apply(feature, this, attacker, defender);
            } else if (feature.getType() == FeatureType.����) {
                CurseFeature.apply(this, feature.getFeature(), attacker, defender);
            } else if (feature.getType() == FeatureType.�ݻ�) {
                DestroyFeature.apply(this, feature.getFeature(), attacker, defender, 1);
            } else if (feature.getType() == FeatureType.����) {
                PlagueFeature.apply(feature, this, attacker, defender);
            } else if (feature.getType() == FeatureType.Ѫ��) {
                BloodPaintFeature.apply(feature.getFeature(), this, attacker, defender, 1);
            } else if (feature.getType() == FeatureType.��Ǵ) {
                HeavenWrathFeature.apply(this, feature.getFeature(), attacker, defender);
            } else if (feature.getType() == FeatureType.��ӡ) {
                SealFeature.apply(feature, this, attacker, defender);
            }
        }
    }

    public void resolvePostAttackFeature(CardInfo attacker, Player defender) {

    }

    public void resolveCounterAttackFeature(CardInfo attacker, CardInfo defender, Feature attackFeature)
            throws HeroDieSignal {
        if (attackFeature == null) {
            for (FeatureInfo feature : defender.getNormalUsableFeatures()) {
                if (feature.getType() == FeatureType.����) {
                    CounterAttackFeature.apply(feature.getFeature(), this, attacker, defender);
                } else if (feature.getType() == FeatureType.�ܴ�) {
                    SpikeFeature.apply(feature.getFeature(), this, attacker, defender);
                } else if (feature.getType() == FeatureType.ȼ��) {
                    BurningFeature.apply(feature, this, attacker, defender);
                }
            }
        }
    }

    public OnAttackBlockingResult resolveHealBlockingFeature(CardInfo healer, CardInfo healee, Feature cardFeature) {
        OnAttackBlockingResult result = new OnAttackBlockingResult(true, cardFeature.getImpact());
        if (healee.getStatus().containsStatus(CardStatusType.����)) {
            stage.getUI().healBlocked(healer, healee, cardFeature, null);
            result.setAttackable(false);
        }
        return result;
    }

    public OnAttackBlockingResult resolveAttackBlockingFeature(EntityInfo attacker, CardInfo defender, Feature cardFeature)
            throws HeroDieSignal {
        OnAttackBlockingResult result = new OnAttackBlockingResult(true, 0);
        CardStatus status = attacker.getStatus();
        if (cardFeature == null) {
            // Normal attack could be blocked by Dodge or ���, ����,
            // ���� status.
            CardInfo cardAttacker = (CardInfo) attacker;
            result.setDamage(cardAttacker.getAT());
            if (status.containsStatus(CardStatusType.����) || status.containsStatus(CardStatusType.���)
                    || status.containsStatus(CardStatusType.����) || status.containsStatus(CardStatusType.����)) {
                stage.getUI().attackBlocked(cardAttacker, defender, cardFeature, null);
                result.setAttackable(false);
            } else {
                for (FeatureInfo blockFeature : defender.getNormalUsableFeatures()) {
                    if (blockFeature.getType() == FeatureType.����) {
                        if (!result.isAttackable()) {
                            continue;
                        }
                        result.setAttackable(!DodgeFeature.apply(blockFeature.getFeature(), this, cardAttacker, defender,
                                result.getDamage()));
                    }
                }
                for (FeatureInfo blockFeature : defender.getNormalUsableFeatures()) {
                    if (!result.isAttackable()) {
                        continue;
                    }
                    if (blockFeature.getType() == FeatureType.��) {
                        result.setDamage(BlockFeature.apply(blockFeature.getFeature(), this, cardAttacker, defender,
                                result.getDamage()));
                    }
                }
                for (FeatureInfo blockFeature : defender.getNormalUsableFeatures()) {
                    if (!result.isAttackable()) {
                        continue;
                    }
                    if (blockFeature.getType() == FeatureType.����) {
                        result.setDamage(IceArmorFeature.apply(blockFeature.getFeature(), this, cardAttacker, defender,
                                result.getDamage()));
                    }
                }
            }
        } else {
            result.setDamage(cardFeature.getImpact());
            if (status.containsStatus(CardStatusType.����) || status.containsStatus(CardStatusType.����)
                    || status.containsStatus(CardStatusType.����)) {
                stage.getUI().attackBlocked(attacker, defender, cardFeature, null);
                result.setAttackable(false);
            } else {
                for (FeatureInfo blockFeature : defender.getNormalUsableFeatures()) {
                    if (blockFeature.getType() == FeatureType.��������) {
                        if (CounterMagicFeature.isFeatureBlocked(this, blockFeature.getFeature(), cardFeature,
                                attacker, defender)) {
                            result.setAttackable(false);
                        }
                    } else if (blockFeature.getType() == FeatureType.����) {
                        if (ImmueFeature.isFeatureBlocked(this, blockFeature.getFeature(), cardFeature, attacker,
                                defender)) {
                            result.setAttackable(false);
                        }
                    } else if (blockFeature.getType() == FeatureType.����) {
                        if (EscapeFeature.isFeatureEscaped(this, blockFeature.getFeature(), cardFeature, attacker,
                                defender)) {
                            result.setAttackable(false);
                        }
                    } else if (blockFeature.getType() == FeatureType.����) {
                        if (ImmobilityFeature.isFeatureBlocked(this, blockFeature.getFeature(), cardFeature, attacker,
                                defender)) {
                            result.setAttackable(false);
                        }
                    }
                }
                for (FeatureInfo blockFeature : defender.getNormalUsableFeatures()) {
                    if (!result.isAttackable()) {
                        continue;
                    }
                    if (blockFeature.getType() == FeatureType.ħ�� && cardFeature.getType().containsTag(FeatureTag.ħ��)) {
                        result.setDamage(MagicShieldFeature.apply(this, blockFeature.getFeature(), attacker, defender,
                                result.getDamage()));
                    }
                }
            }
        }
        return result;
    }

    /**
     * 
     * @param killerCard
     * @param deadCard
     * @param cardFeature
     * @return Whether the dead card is revived.
     * @throws HeroDieSignal
     */
    public void resolveDeathFeature(EntityInfo killerCard, CardInfo deadCard, Feature cardFeature) throws HeroDieSignal {
        if (deadCard.hasDeadOnce()) {
            return;
        }
        resolveLeaveFeature(deadCard, cardFeature);
        for (FeatureInfo deadCardFeature : deadCard.getAllUsableFeatures()) {
            if (deadCardFeature.getType() == FeatureType.�Ա�) {
                ExplodeFeature.apply(this, deadCardFeature.getFeature(), killerCard, deadCard);
            }
        }
        for (FeatureInfo deadCardFeature : deadCard.getUsableDeathFeatures()) {
            if (deadCardFeature.getType() == FeatureType.Ⱥ������) {
                WeakenAllFeature.apply(this, deadCardFeature, deadCard, killerCard.getOwner());
            } else if (deadCardFeature.getType() == FeatureType.�һ����) {
                BurningFlameFeature.apply(deadCardFeature, this, deadCard, killerCard.getOwner());
            } else if (deadCardFeature.getType() == FeatureType.����) {
                ReviveFeature.apply(this, deadCardFeature, deadCard);
            } else if (deadCardFeature.getType() == FeatureType.����) {
                CurseFeature.apply(this, deadCardFeature.getFeature(), deadCard, killerCard.getOwner());
            } else if (deadCardFeature.getType() == FeatureType.����籩) {
                FireMagicFeature.apply(deadCardFeature.getFeature(), this, deadCard, killerCard.getOwner(), -1);
            }
        }
        for (FeatureInfo deadCardFeature : deadCard.getAllUsableFeatures()) {
            if (deadCardFeature.getType() == FeatureType.ת��) {
                ReincarnationFeature.apply(this, deadCardFeature.getFeature(), deadCard);
            }
        }
        deadCard.setDeadOnce(true);
    }

    public void resolveExtraAttackFeature(CardInfo attacker, CardInfo defender, Player defenderHero,
            int normalAttackDamage) throws HeroDieSignal {
        if (!attacker.isDead()) {
            for (FeatureInfo feature : attacker.getNormalUsableFeatures()) {
                if (feature.getType() == FeatureType.����) {
                    PenetrationFeature.apply(feature.getFeature(), this, attacker, defenderHero, normalAttackDamage);
                } else if (feature.getType() == FeatureType.����) {
                    WeakenFeature.apply(this, feature, attacker, defender, normalAttackDamage);
                } else if (feature.getType() == FeatureType.����) {
                    WoundFeature.apply(this, feature, attacker, defender, normalAttackDamage);
                } else if (feature.getType() == FeatureType.��Ѫ) {
                    BloodThirstyFeature.apply(this, feature, attacker, normalAttackDamage);
                } else if (feature.getType() == FeatureType.��������) {
                    ChainAttackFeature.apply(this, feature, attacker, defender);
                } else if (feature.getType() == FeatureType.����) {
                    DiseaseFeature.apply(feature, this, attacker, defender, normalAttackDamage);
                } else if (feature.getType() == FeatureType.��Ѫ) {
                    BloodDrainFeature.apply(feature.getFeature(), this, attacker, defender, normalAttackDamage);
                }
            }
        }
        if (!defender.isDead()) {
            for (FeatureInfo feature : defender.getNormalUsableFeatures()) {
                if (feature.getType() == FeatureType.����) {
                    ZealotFeature.apply(feature, this, attacker, defender, normalAttackDamage);
                }
            }
        }
    }

    public void resolvePreAttackCardFeature(CardInfo attacker, CardInfo defender) throws HeroDieSignal {
        for (FeatureInfo feature : attacker.getNormalUsableFeatures()) {
            if (feature.getType() == FeatureType.ʥ��) {
                RacialAttackFeature.apply(this, feature, attacker, defender, Race.����);
            } else if (feature.getType() == FeatureType.Ҫ��) {
                RacialAttackFeature.apply(this, feature, attacker, defender, Race.����);
            } else if (feature.getType() == FeatureType.��ɱ) {
                RacialAttackFeature.apply(this, feature, attacker, defender, Race.����);
            } else if (feature.getType() == FeatureType.����) {
                CriticalAttackFeature.apply(this, feature, attacker, defender);
            } else if (feature.getType() == FeatureType.��׷�ʹ�) {
                PursuitFeature.apply(this, feature, attacker, defender);
            } else if (feature.getType() == FeatureType.�ͻ�) {
                ReturnFeature.apply(this, feature.getFeature(), attacker, defender);
            } else if (feature.getType() == FeatureType.ս��) {
                WarthFeature.apply(this, feature, attacker, defender);
            }
        }
    }

    public void removeTempEffects(CardInfo card) {
        if (card == null) {
            return;
        }
        for (FeatureEffect effect : card.getEffects()) {
            FeatureType type = effect.getCause().getType();
            if (type == FeatureType.ʥ�� || type == FeatureType.Ҫ�� || type == FeatureType.��ɱ) {
                RacialAttackFeature.remove(this, effect.getCause(), card);
            } else if (type == FeatureType.����) {
                CriticalAttackFeature.remove(this, effect.getCause(), card);
            } else if (type == FeatureType.��׷�ʹ�) {
                PursuitFeature.remove(this, effect.getCause(), card);
            } else if (type == FeatureType.����) {
                BackStabFeature.remove(this, effect.getCause(), card);
            } else if (type == FeatureType.ս��) {
                WarthFeature.remove(this, effect.getCause(), card);
            }
        }
    }

    public OnDamagedResult applyDamage(CardInfo card, int damage) {
        int actualDamage = card.applyDamage(damage);
        OnDamagedResult result = new OnDamagedResult();
        result.actualDamage = actualDamage;
        if (card.getHP() <= 0) {
            result.cardDead = true;
            cardDead(card);
        }
        return result;
    }

    public void cardDead(CardInfo deadCard) {
        if (deadCard.hasDeadOnce()) {
            return;
        }
        this.stage.getUI().cardDead(deadCard);
        Player owner = deadCard.getOwner();
        Field field = owner.getField();
        // Set field position to null
        for (int i = 0; i < field.size(); ++i) {
            CardInfo card = field.getCard(i);
            if (deadCard == card) {
                field.expelCard(i);
                owner.getGrave().addCard(card);
                break;
            }
        }
    }

    public void attackHero(CardInfo attacker, Player defenderPlayer, Feature cardFeature, int damage)
            throws HeroDieSignal {
        if (attacker == null) {
            return;
        }
        stage.getUI().useSkillToHero(attacker, defenderPlayer, cardFeature);
        if (damage > 0) {
            if (!this.resolveAttackHeroBlockingFeatures(attacker, defenderPlayer, cardFeature, damage)) {
                stage.getUI().attackHero(attacker, defenderPlayer, cardFeature, damage);
            }
        } else {
            stage.getUI().healHero(attacker, defenderPlayer, cardFeature, -damage);
        }
        defenderPlayer.setHP(defenderPlayer.getHP() - damage);
    }

    private boolean resolveAttackHeroBlockingFeatures(CardInfo attacker, Player defenderPlayer, Feature cardFeature,
            int damage) throws HeroDieSignal {
        for (CardInfo defender : defenderPlayer.getField().getAliveCards()) {
            if (defender == null) {
                continue;
            }
            for (FeatureInfo defenderFeature : defender.getNormalUsableFeatures()) {
                if (defenderFeature.getType() == FeatureType.�ػ�) {
                    GuardFeature.apply(defenderFeature.getFeature(), this, attacker, defender, damage);
                    return true;
                }
            }
        }
        return false;
    }

    public void resolveCardRoundEndingFeature(CardInfo card) {
        if (card == null) {
            return;
        }
        for (FeatureInfo cardFeature : card.getNormalUsableFeatures()) {
            if (cardFeature.getType() == FeatureType.�ش�) {
                RejuvenateFeature.apply(cardFeature.getFeature(), this, card);
            }
        }
    }

    public int attackCard(CardInfo attacker, CardInfo defender) throws HeroDieSignal {
        this.stage.getUI().useSkill(attacker, defender, null);
        OnAttackBlockingResult blockingResult = stage.getResolver().resolveAttackBlockingFeature(attacker, defender,
                null);
        if (!blockingResult.isAttackable()) {
            return -1;
        }
        this.stage.getUI().attackCard(attacker, defender, null, blockingResult.getDamage());
        OnDamagedResult damagedResult = stage.getResolver().applyDamage(defender, blockingResult.getDamage());
        if (damagedResult.cardDead) {
            stage.getResolver().resolveDeathFeature(attacker, defender, null);
        }

        resolveExtraAttackFeature(attacker, defender, defender.getOwner(), damagedResult.actualDamage);
        resolveCounterAttackFeature(attacker, defender, null);

        return damagedResult.actualDamage;
    }

    public CardInfo pickHealee(CardInfo healer) {
        Field field = healer.getOwner().getField();
        CardInfo healee = null;
        for (CardInfo card : field.getAliveCards()) {
            if (healee == null || card.getHP() < healee.getHP()) {
                healee = card;
            }
        }
        return healee;
    }

    public void resolveSummoningFeature(CardInfo card, Field myField, Field opField) throws HeroDieSignal {
        for (FeatureInfo feature : card.getUsableSummonFeatures()) {
            if (feature.getType() == FeatureType.����) {
                TrapFeature.apply(feature, this, card, opField.getOwner());
            } else if (feature.getType() == FeatureType.����籩) {
                FireMagicFeature.apply(feature.getFeature(), this, card, opField.getOwner(), -1);
            } else if (feature.getType() == FeatureType.�ױ�) {
                LighteningMagicFeature.apply(feature, this, card, opField.getOwner(), -1, 35);
            } else if (feature.getType() == FeatureType.����ѩ) {
                IceMagicFeature.apply(feature, this, card, opField.getOwner(), -1, 30);
            } else if (feature.getType() == FeatureType.�ͻ�) {
                ReturnFeature.apply(this, feature.getFeature(), card, opField.getCard(card.getPosition()));
            } else if (feature.getType() == FeatureType.Ⱥ������) {
                WeakenAllFeature.apply(this, feature, card, opField.getOwner());
            } else if (feature.getType() == FeatureType.����) {
                TransportFeature.apply(this, feature.getFeature(), card, opField.getOwner());
            } else if (feature.getType() == FeatureType.����) {
                RainfallFeature.apply(feature.getFeature(), this, card);
            } else if (feature.getType() == FeatureType.����) {
                CurseFeature.apply(this, feature.getFeature(), card, opField.getOwner());
            } else if (feature.getType() == FeatureType.�ݻ�) {
                DestroyFeature.apply(this, feature.getFeature(), card, opField.getOwner(), 1);
            } else if (feature.getType() == FeatureType.����) {
                PlagueFeature.apply(feature, this, card, opField.getOwner());
            }
        }
        for (CardInfo fieldCard : myField.getAliveCards()) {
            for (FeatureInfo feature : fieldCard.getNormalUsableFeatures()) {
                if (feature.getType() == FeatureType.����֮��) {
                    RaceBuffFeature.apply(this, feature, fieldCard, Race.����, FeatureEffectType.ATTACK_CHANGE);
                } else if (feature.getType() == FeatureType.�����ػ�) {
                    RaceBuffFeature.apply(this, feature, fieldCard, Race.����, FeatureEffectType.MAXHP_CHANGE);
                } else if (feature.getType() == FeatureType.ɭ��֮��) {
                    RaceBuffFeature.apply(this, feature, fieldCard, null, FeatureEffectType.ATTACK_CHANGE);
                } else if (feature.getType() == FeatureType.ɭ���ػ�) {
                    RaceBuffFeature.apply(this, feature, fieldCard, null, FeatureEffectType.MAXHP_CHANGE);
                } else if (feature.getType() == FeatureType.����֮��) {
                    RaceBuffFeature.apply(this, feature, fieldCard, null, FeatureEffectType.ATTACK_CHANGE);
                } else if (feature.getType() == FeatureType.�����ػ�) {
                    RaceBuffFeature.apply(this, feature, fieldCard, null, FeatureEffectType.MAXHP_CHANGE);
                } else if (feature.getType() == FeatureType.��Դ֮��) {
                    RaceBuffFeature.apply(this, feature, fieldCard, null, FeatureEffectType.ATTACK_CHANGE);
                } else if (feature.getType() == FeatureType.��Դ�ػ�) {
                    RaceBuffFeature.apply(this, feature, fieldCard, null, FeatureEffectType.MAXHP_CHANGE);
                } else if (feature.getType() == FeatureType.����) {
                    CounterBiteFeature.apply(feature.getFeature(), this, fieldCard);
                } else if (feature.getType() == FeatureType.�׼�) {
                    SacrificeFeature.apply(this, feature, fieldCard);
                }
            }
        }
    }

    public void resolveLeaveFeature(CardInfo card, Feature cardFeature) {
        for (FeatureInfo deadCardFeature : card.getNormalUsableFeatures()) {
            if (deadCardFeature.getType() == FeatureType.����֮��) {
                RaceBuffFeature.remove(this, deadCardFeature, card, Race.����);
            } else if (deadCardFeature.getType() == FeatureType.�����ػ�) {
                RaceBuffFeature.remove(this, deadCardFeature, card, Race.����);
            } else if (deadCardFeature.getType() == FeatureType.ɭ��֮��) {
                RaceBuffFeature.remove(this, deadCardFeature, card, Race.ɭ��);
            } else if (deadCardFeature.getType() == FeatureType.ɭ���ػ�) {
                RaceBuffFeature.remove(this, deadCardFeature, card, Race.ɭ��);
            } else if (deadCardFeature.getType() == FeatureType.����֮��) {
                RaceBuffFeature.remove(this, deadCardFeature, card, Race.����);
            } else if (deadCardFeature.getType() == FeatureType.�����ػ�) {
                RaceBuffFeature.remove(this, deadCardFeature, card, Race.����);
            } else if (deadCardFeature.getType() == FeatureType.��Դ֮��) {
                RaceBuffFeature.remove(this, deadCardFeature, card, null);
            } else if (deadCardFeature.getType() == FeatureType.��Դ�ػ�) {
                RaceBuffFeature.remove(this, deadCardFeature, card, null);
            }
        }
    }

    public void resolveDebuff(CardInfo card, CardStatusType debuffType) {
        if (card == null) {
            return;
        }
        List<CardStatusItem> items = card.getStatus().getStatusOf(debuffType);
        for (CardStatusItem item : items) {
            this.stage.getUI().debuffDamage(card, item, item.getEffect());
            this.applyDamage(card, item.getEffect());
        }
    }

    public static class BlockStatusResult {
        private boolean blocked;

        public boolean isBlocked() {
            return blocked;
        }

        public BlockStatusResult(boolean blocked) {
            this.blocked = blocked;
        }
    }

    public BlockStatusResult resolveBlockStatusFeature(CardInfo attacker, CardInfo victim, FeatureInfo feature,
            CardStatusItem item) {
        boolean blocked = false;
        for (FeatureInfo blockFeature : victim.getNormalUsableFeatures()) {
            if (blockFeature.getType() == FeatureType.����) {
                blocked = EscapeFeature.isStatusEscaped(blockFeature.getFeature(), this, item, victim);
            }
        }
        return new BlockStatusResult(blocked);
    }

    public void summonCard(Player player, CardInfo card) throws HeroDieSignal {
        this.stage.getUI().summonCard(player, card);
        card.reset();
        card.setFirstRound(true);
        player.getField().addCard(card);
        if (this.stage.getPlayerCount() != 2) {
            throw new CardFantasyRuntimeException("There are " + this.stage.getPlayerCount()
                    + " player(s) in the stage, but expect 2");
        }
        for (Player other : stage.getPlayers()) {
            if (other != player) {
                stage.getResolver().resolveSummoningFeature(card, player.getField(), other.getField());
            }
        }
    }

    /**
     * 
     * @param cardFeature
     * @param attacker
     * @param defender
     * @return Whether block is disabled
     */
    public boolean resolveCounterBlockFeature(Feature cardFeature, CardInfo attacker, CardInfo defender) {
        for (FeatureInfo attackerFeature : attacker.getAllUsableFeatures()) {
            if (attackerFeature.getType() == FeatureType.���㹥��) {
                return WeakPointAttackFeature.isBlockFeatureDisabled(this, attackerFeature.getFeature(), cardFeature,
                        attacker, defender);
            }
        }
        return false;
    }

    public void activateRunes(Player player) {
        for (RuneInfo rune : player.getRuneBox().getRunes()) {
            if (rune.getEnergy() <= 0) {
                continue;
            }
            RuneActivator activator = rune.getActivator();
            if (activator.getType() == RuneActivationType.HeroHP) {
                if (player.getHP() < activator.getThreshold() * player.getMaxHP() / 100) {
                    rune.activate();
                    this.stage.getUI().activateRune(rune);
                }
            }
        }
    }

    public void deactivateRunes(Player player) {
        for (RuneInfo rune : player.getRuneBox().getRunes()) {
            rune.deactivate();
        }
    }

    public void resolvePreAttackRune(Player attackerHero, Player defenderHero) throws HeroDieSignal {
        for (RuneInfo rune : attackerHero.getRuneBox().getRunes()) {
            if (!rune.isActivated()) {
                continue;
            }
            if (rune.is(RuneData.����)) {
                PoisonMagicFeature.apply(rune.getFeatureInfo(), this, rune, defenderHero, 1);
            }
        }
    }
}
