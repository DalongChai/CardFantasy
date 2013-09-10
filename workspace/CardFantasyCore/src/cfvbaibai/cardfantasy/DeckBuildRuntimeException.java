package cfvbaibai.cardfantasy;

public class DeckBuildRuntimeException extends CardFantasyRuntimeException {

    private static final long serialVersionUID = 193208372894017945L;
    private static final String HELP_MSG =
            ". ����ϸ�Ķ�������Ϣ��" +
            "<table border='0' cellspacing='1' cellpadding='5' bgcolor='#FFCCCC'>" +
            "<tr bgcolor='#FF9999'><th>��������</th><th>��������</th><th>����</th></tr>" +
            "<tr bgcolor='white'><td>����֮��û���ö��Ÿ���</td><td>��ʥ*1��е����*2</td><td>��ʥ*1,��е����*2</td></tr>" +
            "<tr bgcolor='white'><td>ʹ���˷�����</td><td>ս��������+����</td><td>ս��������+����</td></tr>" +
            "<tr bgcolor='white'><td>�д����</td><td>������ʹ+����֮��5,����</td><td>������ʹ+����֮��5,����</td></tr>" +
            "<tr bgcolor='white'><td>���Ʒ������ֲ�׼ȷ</td><td>��ʥ</td><td>��ʥ</td></tr>" +
            "<tr bgcolor='white'><td>ϴ�������ó��˼���</td><td>��ʥ-����</td><td>��ʥ+����</td></tr>" +
            "<tr bgcolor='white'><td>ϴ�����ȼ�����������˳�����</td><td>���-15+ת��5*5,��Դ���*1+����</td><td>���+ת��5-15*5,��Դ���+����*1</td></tr>" +
            "</table>";
    public DeckBuildRuntimeException(String message) {
        super(message + HELP_MSG);
    }

    public DeckBuildRuntimeException(String message, Exception inner) {
        super(message + HELP_MSG, inner);
    }

}
