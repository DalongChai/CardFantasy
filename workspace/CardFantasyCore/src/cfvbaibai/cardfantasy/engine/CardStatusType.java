package cfvbaibai.cardfantasy.engine;

public enum CardStatusType {
    ȼ��(true, "ȼ"),
    ���(false, "��"),
    ����(false, "��"),
    �ж�(true, "��"),
    ����(false, "��"),
    ����(false, "��"),
    ����(false, "��"),
    �Ի�(false, "��");

    private boolean quantitive;
    public boolean isQuantitive() {
        return this.quantitive;
    }
    
    private String abbrev;
    public String getAbbrev() {
        return this.abbrev;
    }
    
    CardStatusType(boolean quantitive, String abbrev) {
        this.quantitive = quantitive;
        this.abbrev = abbrev;
    }
}
