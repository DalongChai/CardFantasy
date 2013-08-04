package cfvbaibai.cardfantasy.data;

public class LegionFeature extends Feature {

    public static LegionFeature create(Legion legion, Race race) {
        if (legion == null) {
            throw new IllegalArgumentException("legion cannot be null!");
        }
        int level = legion.getBuffLevel(race);
        switch (race) {
        case ����: return new LegionFeature(FeatureType.��������֮��, level);
        case ɭ��: return new LegionFeature(FeatureType.����ɭ��֮��, level);
        case ����: return new LegionFeature(FeatureType.��������֮��, level);
        case ����: return new LegionFeature(FeatureType.���ŵ���֮��, level);
        case ħ��: return new LegionFeature(FeatureType.����ħ��֮��, 0);
        default: throw new IllegalArgumentException("Unknown race: " + race); 
        }
    }

    private LegionFeature(FeatureType type, int level) {
        super(type, level);
    }

}
