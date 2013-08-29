package cfvbaibai.cardfantasy.data;

import java.util.HashSet;

public enum FeatureType {
    �ѻ�(25, FeatureTag.������),
    ��������(25, FeatureTag.ħ��),
    ����(15, FeatureTag.������),
    ʥ��(15, 15),
    ��(20),
    ����(1, FeatureTag.����),
    ����(20, FeatureTag.������),
    ����(10),
    ����(25, FeatureTag.ħ��),
    ����(20, FeatureTag.ħ��),
    ����(20),
    �ػ�(0),
    �ش�(30),
    ����(10, FeatureTag.����),
    ��ɨ(0),
    ����(20, 5, FeatureTag.������),
    ����(25),
    ����(25),
    ��(50),
    ����֮��(25),
    ��������(30),
    ħ��(140, -10),
    �ܴ�(20, FeatureTag.������),
    ȼ��(25),
    ��ǽ(25, FeatureTag.ħ��),
    ����籩(25, FeatureTag.ħ��),
    �ױ�(25, FeatureTag.ħ��),
    ת��(30, 5),
    �����ػ�(50),
    ˪������(20, FeatureTag.ħ��),
    ����ѩ(20, FeatureTag.ħ��),
    ����(0, FeatureTag.������),
    ����(25, FeatureTag.ħ��),
    ��׷�ʹ�(15),
    ����(0),
    ����(0),
    ����(0, FeatureTag.����),
    ����(40),
    �ͻ�(0, FeatureTag.����),
    Ⱥ������(5),
    ����(190, -10, FeatureTag.������),
    �Ա�(40),
    ͸֧(20),
    ����(0),
    ��Ѫ(10, FeatureTag.����),
    ��Դ�ػ�(40),
    ��Դ֮��(20),
    ��������(25),
    ����(0, FeatureTag.����),
    ���㹥��(0),
    Ҫ��(15, 15),
    ɭ��֮��(25),
    ɭ���ػ�(50),
    �ػ�(1),
    ���ؾѻ�(25, FeatureTag.������),
    �Ի�(30, 5),
    �һ����(20),
    ս��(15),
    ��ɱ(15, 15),
    ��Һ(20),
    ����(20),
    ����(20),
    ��Ѫ(10),
    ����(50),
    ����(10),
    ����֮��(25),
    �����ػ�(50),
    ����(30),
    �ݻ�(0, FeatureTag.����),
    �׼�(20, 10),
    ����(5),
    ��Ⱦ(15, 15),
    ����֮��(25),
    �����ػ�(50),
    ��ӡ(0, FeatureTag.����),
    Ѫ��(20),
    ��Ǵ(20),
    ���ܻ���(50),
    Ⱥ�廤��(30),
    Ⱥ������(15),
    ����֮��(15, 5),
    ɭ��֮��(15, 5),
    ����֮��(15, 5),
    ����֮��(15, 5),
    ��ʤ׷��(40, 10),
    ��ʥ�ػ�(50),
    ����(40, 10),
    ʥ��(0),
    ������ʴ(20),
    а�鼳ȡ(0, 3, FeatureTag.������),
    
    ��������֮��(0, 3),
    ����ɭ��֮��(0, 3),
    ��������֮��(0, 3),
    ���ŵ���֮��(0, 3),
    ����ħ��֮��(0),
    
    ħ��֮��(2000, 0, FeatureTag.������),
    ħ��֮��(1500, 0, FeatureTag.������),
    ħ��֮��(1000, 0, FeatureTag.������),
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
