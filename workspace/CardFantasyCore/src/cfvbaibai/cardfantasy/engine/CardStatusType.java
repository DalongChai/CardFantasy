package cfvbaibai.cardfantasy.engine;

public enum CardStatusType {
    ȼ��(true),
    ���(false),
    ����(false),
    �ж�(true),
    ����(false);

    private boolean quantitive;
    public boolean isQuantitive() {
        return this.quantitive;
    }
    
    CardStatusType(boolean quantitive) {
        this.quantitive = quantitive;
    }
}
