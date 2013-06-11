package cfvbaibai.cardfantasy.data;

public class CardFeature extends Feature implements Cloneable {
    private int unlockLevel;
    protected boolean summonFeature;
    protected boolean deathFeature;
    public CardFeature(FeatureType type, int level, int unlockLevel, boolean summonFeature, boolean deathFeature) {
        super(type, level);
        this.unlockLevel = unlockLevel;
        this.summonFeature = summonFeature;
        this.deathFeature = deathFeature;
    }
    
    public int getUnlockLevel() {
        return unlockLevel;
    }

    @Override
    public String getShortDesc() {
        String prefix = "";
        if (this.isSummonFeature()) {
            prefix += "����-";
        }
        if (this.isDeathFeature()) {
            prefix += "����-";
        }
        return String.format("��%s%s%s��", prefix, type.getDisplayName(), level == 0 ? "" : String.valueOf(level));
    }
    
    public boolean isSummonFeature() {
        return this.summonFeature;
    }

    public boolean isDeathFeature() {
        return this.deathFeature;
    }
}
