package co.ojun.firstproject.product.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.ojun.firstproject.common.DataSource;
import co.ojun.firstproject.product.service.ProductService;
import co.ojun.firstproject.product.service.ProductVO;

public class ProductServiceImpl implements ProductService {
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
	public List<ProductVO> productListAll() { // db 연결, sql 쿼리 실행 resuletSet으로 결과를 받아옴. resulset에서 데이터를 읽어와 productVO
												// 객체를 만들고 이를 리스트에 추가한뒤 리스트 반환
		String sql = "SELECT * FROM PRODUCT";
		List<ProductVO> products = new ArrayList<ProductVO>();
		ProductVO vo;

		try {
			connection = dao.getConnection();
			preparedStatement = connection.prepareStatement(sql); // SQL 쿼리를 미리 준비(prepare)하여 나중에 파라미터(?)를 설정하고 실행.
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				vo = new ProductVO();
				vo.setProductCode(resultSet.getString("product_code"));
				vo.setProductName(resultSet.getString("product_name"));
				vo.setProductPrice(resultSet.getInt("product_price"));
				vo.setProductDescription(resultSet.getString("product_description"));
				products.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return products;
	}

	@Override
	public ProductVO productSelectByCode(ProductVO vo) {
		String sql = "SELECT * FROM PRODUCT WHERE PRODUCT_CODE = ?";
		try {
			connection = dao.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, vo.getProductCode());
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				vo = new ProductVO();
				vo.setProductCode(resultSet.getString("product_code"));
				vo.setProductName(resultSet.getString("product_name"));
				vo.setProductPrice(resultSet.getInt("product_price"));
				vo.setProductDescription(resultSet.getString("product_description"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return vo;
	}

	@Override
	public ProductVO productSelectByName(ProductVO vo) {
		String sql = "SELECT * FROM PRODUCT WHERE PRODUCT_NAME = ?";
		try {
			connection = dao.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, vo.getProductName());
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				vo = new ProductVO();
				vo.setProductCode(resultSet.getString("product_code"));
				vo.setProductName(resultSet.getString("product_name"));
				vo.setProductPrice(resultSet.getInt("product_price"));
				vo.setProductDescription(resultSet.getString("product_description"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return vo;
	}

	@Override
	public int productInsert(ProductVO vo) {
		int n = 0;
		String sql = "INSERT INTO PRODUCT VALUES(?, ?, ?, ?)";
		try {
			connection = dao.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, vo.getProductCode());
			preparedStatement.setString(2, vo.getProductName());
			preparedStatement.setInt(3, vo.getProductPrice());
			preparedStatement.setString(4, vo.getProductDescription());

			n = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return n;
	}

	@Override
	public int productDelete(ProductVO vo) {
		int n = 0;
		String sql = "DELETE FROM PRODUCT WHERE PRODUCT_CODE = ?";
		try {
			connection = dao.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, vo.getProductCode());
			n = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return n;
	}

	@Override
	public int productEditPrice(ProductVO vo) { // 가격 변경
		String sql = "UPDATE PRODUCT SET PRODUCT_PRICE = ? WHERE PRODUCT_CODE = ?";
		int n = 0;
		try {
			connection = dao.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, vo.getProductPrice());
			preparedStatement.setString(2, vo.getProductCode());
			n = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return n;
	}

	public int productEditName(ProductVO vo) { // 제품명 변경
		String sql = "UPDATE PRODUCT SET PRODUCT_NAME = ? WHERE PRODUCT_CODE = ?";
		int n = 0;
		try {
			connection = dao.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, vo.getProductName());
			preparedStatement.setString(2, vo.getProductCode());
			n = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return n;
	}

	public int productEditDescription(ProductVO vo) { // 제품설명 변경
		String sql = "UPDATE PRODUCT SET PRODUCT_DESCRIPTION = ? WHERE PRODUCT_CODE = ?";
		int n = 0;
		try {
			connection = dao.getConnection(); // db 연결 
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, vo.getProductDescription());
			preparedStatement.setString(2, vo.getProductCode());
			n = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return n;
	}
}
