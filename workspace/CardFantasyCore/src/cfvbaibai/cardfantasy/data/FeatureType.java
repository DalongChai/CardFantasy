package cfvbaibai.cardfantasy.data;

import java.util.HashSet;

public enum FeatureType {

    /* �������������� */
    ����(10, FeatureTag.����, FeatureTag.���������ӳ�),
    Ⱥ������(5, FeatureTag.����, FeatureTag.���������ӳ�),
    /*
     * �������Ա�����������֮�������������߲���
     */
    ����(5, FeatureTag.����, FeatureTag.���������ӳ�),
    
    /* �������ӳɼ��� */
    �׼�(20, 10, FeatureTag.����, FeatureTag.���������ӳ�),
    Ⱥ������(15, FeatureTag.���������ӳ�),
    ����(10, FeatureTag.����, FeatureTag.���������ӳ�),
    ��Ѫ(10, FeatureTag.����, FeatureTag.���������ӳ�),
    ͸֧(20, FeatureTag.����, FeatureTag.���������ӳ�),
    а�鼳ȡ(0, 3, FeatureTag.������, FeatureTag.����, FeatureTag.���������ӳ�),
    ɭ��֮��(25, FeatureTag.���������ӳ�),
    ����֮��(25, FeatureTag.���������ӳ�),
    ����֮��(25, FeatureTag.���������ӳ�),
    ����֮��(25, FeatureTag.���������ӳ�),
    ��Դ֮��(20, FeatureTag.���������ӳ�),
    ʥ��(15, 15, FeatureTag.���⹥���ӳ�),
    Ҫ��(15, 15, FeatureTag.���⹥���ӳ�),
    ��ɱ(15, 15, FeatureTag.���⹥���ӳ�),
    ��Ⱦ(15, 15, FeatureTag.���⹥���ӳ�),
    ����(20, FeatureTag.���⹥���ӳ�),
    ��׷�ʹ�(15, FeatureTag.���⹥���ӳ�),
    ս��(15, FeatureTag.���⹥���ӳ�),
    ��������(25, FeatureTag.���⹥���ӳ�, FeatureTag.������, FeatureTag.������),
    ��ʤ׷��(40, 10, FeatureTag.���������ӳ�),
    ����(40, FeatureTag.���������ӳ�),
    ����(40, 10, FeatureTag.���������ӳ�),

    /* HP ���޵������� */
    �����ػ�(50),
    �����ػ�(50),
    �����ػ�(50),
    ɭ���ػ�(50),
    ��Դ�ػ�(40),
    ��ʥ�ػ�(50),

    �ѻ�(25, FeatureTag.������),
    ��������(25, FeatureTag.ħ��),
    ����(15, FeatureTag.������),
    ��(20),
    ����(1, FeatureTag.����),
    ����(20, FeatureTag.������),
    ����(25, FeatureTag.ħ��),
    ����(20, FeatureTag.ħ��),
    �ػ�(0),
    �ش�(30),
    ��ɨ(0, FeatureTag.������, FeatureTag.������),
    ����(20, 5, FeatureTag.������),
    ����(25),
    ����(25),
    ��(50),
    ��������(30),
    ħ��(140, -10),
    �ܴ�(20, FeatureTag.������),
    ȼ��(25),
    ��ǽ(25, FeatureTag.ħ��),
    ����籩(25, FeatureTag.ħ��),
    �ױ�(25, FeatureTag.ħ��),
    ת��(30, 5),

    ˪������(20, FeatureTag.ħ��),
    ����ѩ(20, FeatureTag.ħ��),
    ����(0, FeatureTag.������),
    ����(25, FeatureTag.ħ��),
    ����(0),
    ����(0),
    ����(0, FeatureTag.����),
    �ͻ�(0, FeatureTag.����),
    ����(190, -10, FeatureTag.������),
    �Ա�(40),
    ����(0),
    
    ����(0, FeatureTag.����),
    ���㹥��(0),
    
    �ػ�(1),
    ���ؾѻ�(25, FeatureTag.������),
    �Ի�(30, 5),
    �һ����(20),

    ��Һ(20),
    ����(20),
    ����(20),
    ��Ѫ(10),
    ����(50),
    ����(10),

    ����(30),
    �ݻ�(0, FeatureTag.����),

    ��ӡ(0, FeatureTag.����),
    Ѫ��(20),
    ��Ǵ(20),
    ���ܻ���(50),
    Ⱥ�廤��(30),

    ����֮��(15, 5),
    ɭ��֮��(15, 5),
    ����֮��(15, 5),
    ����֮��(15, 5),
    
    ʥ��(0),
    ������ʴ(20),

    ��������֮��(0, 3, FeatureTag.����, FeatureTag.���������ӳ�),
    ����ɭ��֮��(0, 3, FeatureTag.����, FeatureTag.���������ӳ�),
    ��������֮��(0, 3, FeatureTag.����, FeatureTag.���������ӳ�),
    ���ŵ���֮��(0, 3, FeatureTag.����, FeatureTag.���������ӳ�),
    ����ħ��֮��(0),
    
    ħ��֮��(2000, 0, FeatureTag.������),
    ħ��֮��(1500, 0, FeatureTag.������),
    ħ��֮��(1000, 0, FeatureTag.������),
    
    �Զ���Ѫ(0, 0, FeatureTag.���ػ�),
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
