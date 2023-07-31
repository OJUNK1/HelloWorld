package co.ojun.firstproject.stock.service;

import java.sql.Date;
import java.util.List;

public interface StockService {

	List<StockVO> transactionListAll(); // 전체 조회

	StockVO transactionSelect(StockVO vo); // 단건조회

	List<StockVO> transactionSelectByDate(Date startDate, Date endDate); // 날짜에 따른 조회

	int inAndOutProduct(StockVO vo); // 입고 , 출고

}
