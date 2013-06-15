package cfvbaibai.cardfantasy.data;

public enum RuneData {
    ����(RuneClass.GROUND, 3, FeatureType.��Һ, 3, 1, 1, Growth.RUNE, RuneActivator.myHeroHP(60)),
    ����(RuneClass.GROUND, 3, FeatureType.����, 1, 1, 1, Growth.RUNE, RuneActivator.enemyField(2, null)),
    �Ҿ�(RuneClass.GROUND, 3, FeatureType.���ܻ���, 3, 1, 2, Growth.RUNE, RuneActivator.enemyField(1, null)),
    ��ɰ(RuneClass.GROUND, 3, FeatureType.��Һ, 5, 1, 2, Growth.RUNE, RuneActivator.round(12)),
    �ұ�(RuneClass.GROUND, 4, FeatureType.��, 5, 1, 3, Growth.RUNE, RuneActivator.myField(1, Race.����)),
    ��Ԩ(RuneClass.GROUND, 4, FeatureType.����, 5, 1, 3, Growth.RUNE, RuneActivator.enemyGrave(1, Race.����)),
    ʯ��(RuneClass.GROUND, 4, FeatureType.��������, 5, 1, 3, Growth.RUNE, RuneActivator.myGrave(1, Race.����)),
    ���(RuneClass.GROUND, 5, FeatureType.��Ѫ, 5, 1, 4, Growth.RUNE, RuneActivator.myField(1, Race.����)),
    ����(RuneClass.GROUND, 4, FeatureType.����, 5, 1, 4, Growth.RUNE, RuneActivator.enemyField(1, Race.����)),
    ����(RuneClass.GROUND, 4, FeatureType.�ѻ�, 5, 1, 4, Growth.RUNE, RuneActivator.myGrave(2, Race.����)),
    ����(RuneClass.GROUND, 5, FeatureType.����, 6, 1, 5, Growth.RUNE, RuneActivator.myGrave(1, Race.����)),
    ����(RuneClass.GROUND, 4, FeatureType.ת��, 4, 1, 5, Growth.RUNE, RuneActivator.myGrave(1, Race.����)),
    ;
    
    private RuneClass runeClass;
    private int maxEnergy;
    private FeatureType featureType;
    private int incrFeatureLevel;
    private int initFeatureLevel;
    private Growth growth;
    private int star;
    private RuneActivator activator;

    RuneData(RuneClass runeClass, int maxEnergy, FeatureType featureType, int initFeatureLevel,
            int incrFeatureLevel, int star, Growth growth, RuneActivator activator) {
        this.runeClass = runeClass;
        this.maxEnergy = maxEnergy;
        this.featureType = featureType;
        this.initFeatureLevel = initFeatureLevel;
        this.incrFeatureLevel = incrFeatureLevel;
        this.growth = growth;
        this.star = star;
        this.activator = activator;
    }

    public RuneClass getRuneClass() {
        return runeClass;
    }

    public int getMaxEnergy() {
        return maxEnergy;
    }

    public FeatureType getFeatureType() {
        return featureType;
    }

    public int getIncrFeatureLevel() {
        return incrFeatureLevel;
    }

    public int getInitFeatureLevel() {
        return initFeatureLevel;
    }

    public Growth getGrowth() {
        return growth;
    }

    public int getStar() {
        return star;
    }
    
    public RuneActivator getActivator() {
        return this.activator;
    }
}
