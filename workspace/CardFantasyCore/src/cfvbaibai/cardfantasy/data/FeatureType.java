package cfvbaibai.cardfantasy.data;

public enum FeatureType {
    Snipe("�ѻ�", 25),
    ChainLightening("��������", 25),
    Penetration("����", 15),
    HolyLight("ʥ��", 15, 15),
    Block("��", 20),
    MagicShield("ħ��", 140, -10);
    
    private String displayName;
    private int initImpact;
    private int incrImpact;
   
    FeatureType(String displayName) {
        this(displayName, 0, 0);
    }
    
    FeatureType(String displayName, int incrImpact) {
        this(displayName, 0, incrImpact);
    }
    
    FeatureType(String displayName, int initImpact, int incrImpact) {
        this.displayName = displayName;
        this.initImpact = initImpact;
        this.incrImpact = incrImpact;
    }
    
    public String getDisplayName() {
        return this.displayName;
    }

    public int getImpact(int level) {
        return initImpact + level * incrImpact;
    }
}
