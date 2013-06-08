package cfvbaibai.cardfantasy.data;

public enum FeatureType {
    �ѻ�(25),
    ��������(25),
    ����(15),
    ʥ��(15, 15),
    ��(20),
    ����(1),
    ����(20),
    ����(10),
    ����(25),
    ����(20),
    ����(20),
    �ػ�(0),
    �ش�(30),
    ����(10),
    ��ɨ(0),
    ����(20, 5),
    ����(25),
    ����(25),
    ��(50),
    ����֮��(25),
    ħ��(140, -10);
    

    private int initImpact;
    private int incrImpact;
    
    FeatureType(int incrImpact) {
        this(0, incrImpact);
    }
    
    FeatureType(int initImpact, int incrImpact) {
        this.initImpact = initImpact;
        this.incrImpact = incrImpact;
    }
    
    public String getDisplayName() {
        return this.name();
    }

    public int getImpact(int level) {
        return initImpact + level * incrImpact;
    }
}
