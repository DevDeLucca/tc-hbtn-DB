import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteDAOImpl implements ClienteDAO<Cliente>{

	@Override
	public Connection connect(String urlConexao) {
		Connection con = null;
		try {
			Class.forName("org.sqlite.JDBC");
			urlConexao = "jdbc:sqlite:sqlite_database_marco_2022.db";
			con = DriverManager.getConnection(urlConexao);

		} catch (SQLException | ClassNotFoundException e) {
			System.err.println(e.getMessage());
		}

		return con;
	}

	@Override
	public void createTable(String urlConexao) {
		urlConexao = "jdbc:sqlite:sqlite_database_marco_2022.db";
		StringBuffer sql = new StringBuffer();
		sql.append("CREATE TABLE IF NOT EXISTS cliente (");
		sql.append("id integer PRIMARY KEY AUTOINCREMENT , ");
		sql.append("nome text NOT NULL, ");
		sql.append("idade integer, ");
		sql.append("cpf text NOT NULL, ");
		sql.append("rg text ");
		sql.append(")");

		try {
			Connection conn = DriverManager.getConnection(urlConexao);
			Statement stm = conn.createStatement();
			stm.execute(sql.toString());
		}catch(SQLException ex){
			Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
		}
	}


	@Override
	public void insert(String url_conexao, Cliente cliente) {
		url_conexao = "jdbc:sqlite:sqlite_database_marco_2022.db";
		String query = "INSERT INTO cliente(nome,idade, cpf, rg) VALUES(?,?,?,?)";
		try{
			Connection conn = DriverManager.getConnection(url_conexao);
			PreparedStatement pstm = conn.prepareStatement(query);
			pstm.setString(1, cliente.getNome());
			pstm.setInt(2, cliente.getIdade());
			pstm.setString(3, cliente.getCpf());
			pstm.setString(4, cliente.getRg());
			pstm.executeUpdate();

		}catch(SQLException ex){
			Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	@Override
	public void selectAll(String urlConexao) {
		urlConexao = "jdbc:sqlite:sqlite_database_marco_2022.db";
		String query = "SELECT NOME, IDADE, CPF, RG FROM CLIENTE";
		try {
			Connection conn = DriverManager.getConnection(urlConexao);
			PreparedStatement pstm = conn.prepareStatement(query);
		}catch (SQLException ex){
			Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	@Override
	public void update(String urlConexao, int id, String name, Integer idade) {
		urlConexao = "jdbc:sqlite:sqlite_database_marco_2022.db";
		String query = "UPDATE cliente SET nome = ? , idade = ? WHERE id = ?";

		try {
			Connection conn = DriverManager.getConnection(urlConexao);
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, name);
			pstmt.setInt(2, idade);
			pstmt.setInt(3, id);
			pstmt.executeUpdate();
		} catch (SQLException ex) {
			Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	@Override
	public void delete(String urlConexao, int id) {
		urlConexao = "jdbc:sqlite:sqlite_database_marco_2022.db";
		String query = "DELETE FROM cliente WHERE id = ?";

		try {
			Connection conn = DriverManager.getConnection(urlConexao);
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.executeUpdate();
		} catch (SQLException ex) {
			Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
		}

	}
}