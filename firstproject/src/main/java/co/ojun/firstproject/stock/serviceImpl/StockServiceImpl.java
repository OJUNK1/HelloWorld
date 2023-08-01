package co.ojun.firstproject.stock.serviceImpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.ojun.firstproject.common.DataSource;
import co.ojun.firstproject.stock.service.StockService;
import co.ojun.firstproject.stock.service.StockVO;

public class StockServiceImpl implements StockService {
	private DataSource dao = DataSource.getInstance();
	private Connection connection;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;

	private void close() {
		try {
			if (resultSet != null)
				resultSet.close();
			if (preparedStatement != null)
				preparedStatement.close();
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<StockVO> transactionListAll() {
		String sql = "SELECT * FROM STOCK ORDER BY PRODUCT_CODE, STOCK_DATE";
		List<StockVO> stocks = new ArrayList<StockVO>();
		StockVO vo;
		try {
			connection = dao.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				vo = new StockVO();
				vo.setProductCode(resultSet.getString("product_code"));

				vo.setStockIn(resultSet.getInt("stock_i"));
				vo.setStockOut(resultSet.getInt("stock_o"));
				vo.setStock(resultSet.getInt("stock_number"));
				vo.setStockDate(resultSet.getDate("stock_date"));
				stocks.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return stocks;
	}

	@Override
	public List<StockVO> transactionSelect(String code) {
		String sql = "SELECT * FROM STOCK WHERE PRODUCT_CODE = ? ORDER BY STOCK_DATE";
		List<StockVO> stocks = new ArrayList<StockVO>();
		try {
			connection = dao.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, code);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				StockVO vo = new StockVO();
				vo.setProductCode(resultSet.getString("product_code"));
				vo.setStockIn(resultSet.getInt("stock_i"));
				vo.setStockOut(resultSet.getInt("stock_o"));
				vo.setStock(resultSet.getInt("stock_number"));
				vo.setStockDate(resultSet.getDate("stock_date"));
				stocks.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return stocks;
	}

	@Override
	public List<StockVO> transactionSelectByDate(Date startDate, Date endDate) {
		String sql = "select * from stock where stock_date between ? and ?";
		List<StockVO> stocks = new ArrayList<>();
		try {
			connection = dao.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setDate(1, startDate);
			preparedStatement.setDate(2, endDate);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				StockVO vo = new StockVO();
				vo.setProductCode(resultSet.getString("product_code"));
				vo.setStockIn(resultSet.getInt("stock_i"));
				vo.setStockOut(resultSet.getInt("stock_o"));
				vo.setStock(resultSet.getInt("stock_number"));
				vo.setStockDate(resultSet.getDate("stock_date"));
				stocks.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return stocks;
	}

	@Override
	public int inAndOutProduct(StockVO vo) {
		int n = 0;
		String sql = "INSERT INTO STOCK VALUES(?,?,?,?,?)";
		try {
			connection = dao.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, vo.getProductCode());
			preparedStatement.setInt(2, vo.getStockIn());
			preparedStatement.setInt(3, vo.getStockOut());
			preparedStatement.setInt(4, vo.getStock());
			preparedStatement.setDate(5, vo.getStockDate());

			n = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return n;
	}

	public StockVO getExistingStock(StockVO vo) { // 데이터베이스에서 가장 최근의 재고 정보를 가져오는 기능
		String sql = "SELECT * FROM (SELECT * FROM STOCK WHERE PRODUCT_CODE = ? ORDER BY STOCK_DATE DESC) WHERE ROWNUM = 1";
		try {
			connection = dao.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, vo.getProductCode());
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				vo = new StockVO();
				vo.setProductCode(resultSet.getString("product_code"));
				vo.setStockIn(resultSet.getInt("stock_i"));
				vo.setStockOut(resultSet.getInt("stock_o"));
				vo.setStock(resultSet.getInt("stock_number"));
				vo.setStockDate(resultSet.getDate("stock_date"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return vo;
	}
}
