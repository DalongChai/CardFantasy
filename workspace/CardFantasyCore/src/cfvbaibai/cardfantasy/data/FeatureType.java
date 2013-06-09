package cfvbaibai.cardfantasy.data;

import java.util.HashSet;

public enum FeatureType {
    �ѻ�(25),
    ��������(25, FeatureTag.ħ��),
    ����(15),
    ʥ��(15, 15),
    ��(20),
    ����(1, FeatureTag.����),
    ����(20),
    ����(10),
    ����(25, FeatureTag.ħ��),
    ����(20, FeatureTag.ħ��),
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
    ��������(30),
    ħ��(140, -10),
    �ܴ�(20),
    ȼ��(25),
    ��ǽ(25, FeatureTag.ħ��),
    ����籩(25, FeatureTag.ħ��),
    �ױ�(25, FeatureTag.ħ��),
    ת��(30, 5),
    �����ػ�(50),
    ˪������(20, FeatureTag.ħ��),
    ����ѩ(20, FeatureTag.ħ��),
    ����(0),
    ����(25, FeatureTag.ħ��),
    ��׷�ʹ�(15),
    ����(0),
    ����(0),
    ����(0, FeatureTag.����),
    ����(40),
    �ͻ�(0, FeatureTag.����),
    Ⱥ������(5),

    // Unimplemented.
    ��ӡ(0, FeatureTag.����),
    �Ի�(0, FeatureTag.����),
    δ֪(0);
    

    private int initImpact;
    private int incrImpact;
    private HashSet <FeatureTag> tags;
    
    FeatureType(int incrImpact, FeatureTag ... tags) {
        this(0, incrImpact, tags);
    }
    
    FeatureType(int initImpact, int incrImpact, FeatureTag ... tags) {
        this.initImpact = initImpact;
        this.incrImpact = incrImpact;
        this.tags = new HashSet <FeatureTag> ();
        for (FeatureTag tag : tags) {
            this.tags.add(tag);
        }
    }
    
    public String getDisplayName() {
        return this.name();
    }

    public int getImpact(int level) {
        return initImpact + level * incrImpact;
    }
    
    public boolean containsTag(FeatureTag tag) {
        return this.tags.contains(tag);
    }
}
