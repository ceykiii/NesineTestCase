package dto;

/**
 * PopulerBet class representing information about a popular bet.
 * This class includes the played count and market number of the bet.
 * This class is developed by Cem AÇAR.
 * Last updated on 14.11.23
 */
public class PopulerBet {

    private Integer playedCount;
    private Integer marketNo;

    /**
     * Constructs a PopulerBet object with the specified played count and market number.
     *
     * @param playedCount The played count of the popular bet.
     * @param marketNo    The market number of the popular bet.
     */
    public PopulerBet(Integer playedCount, Integer marketNo) {
        this.playedCount = playedCount;
        this.marketNo = marketNo;
    }

    /**
     * Gets the played count of the popular bet.
     *
     * @return The playedCount.
     */
    public Integer getPlayedCount() {
        return playedCount;
    }

    /**
     * Gets the market number of the popular bet.
     *
     * @return The marketNo.
     */
    public Integer getMarketNo() {
        return marketNo;
    }

}
