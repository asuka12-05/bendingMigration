package dto;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 売り上げDTO
 */
@Data
@NoArgsConstructor
public class SalesDto {
	
	/** 売上合計 */
	private int totalSales;
	/** 販売本数 */
	private int totalCount;
}
