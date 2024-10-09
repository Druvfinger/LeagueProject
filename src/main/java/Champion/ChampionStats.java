package Champion;

public record ChampionStats(
        int hp,
        int hpperlevel,
        int mp,
        int mpperlevel,
        int movespeed,
        int armor,
        double armorperlevel,
        int spellblock,
        double spellblockperlevel,
        int attackrange,
        double hpregen,
        double hpregenperlevel,
        int mpregen,
        int mpregenperlevel,
        int crit,
        int critperlevel,
        int attackdamage,
        double attackdamageperlevel,
        double attackspeedperlevel,
        double attackspeed
) {
}
