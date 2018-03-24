
/**
 * @author Rookie
 *
 */
public class Campaigns extends Shopping {
	protected String startDate;
	protected String endDate;
	protected String itemType;
	protected String discountRate;
	/**
	 * @param startDate if commands.txt starts with "CREATECAMPAIGN",startDate will be the third value of that line
	 * @param endDate if commands.txt starts with "CREATECAMPAIGN",endDate will be the fourth value of that line
	 * @param itemType if commands.txt starts with "CREATECAMPAIGN",itemType will be the fifth value of that line
	 * @param discountRate if commands.txt starts with "CREATECAMPAIGN",discountRate will be the sixth value of that line
	 */
	public Campaigns(String startDate, String endDate, String itemType, String discountRate) {
		this.startDate = startDate;
		this.endDate = endDate;
		this.itemType = itemType;
		this.discountRate = discountRate;
	}
	
}
