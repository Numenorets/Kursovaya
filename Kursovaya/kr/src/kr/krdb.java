package kr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import org.sqlite.JDBC;

public class krdb {
	private static String url1 = "jdbc:sqlite:D:/Downloads/Kursovaya/ku.db";
	private static krdb instance = null;

	public static synchronized krdb getInstance() throws SQLException {
		if (instance == null)
			instance = new krdb();
		return instance;
	}

	private Connection connection;

	private krdb() throws SQLException {
		DriverManager.registerDriver(new JDBC());
		this.connection = DriverManager.getConnection(url1);
	}

	public static int insert(users users) {
		try {
			Class.forName("org.sqlite.JDBC").getDeclaredConstructor().newInstance();
			

			try (Connection conn = DriverManager.getConnection(url1)) {				
				String sql = "INSERT INTO users (Surname, Name,Adres,Email,Telnumb,Password,Role) Values (?,?,?,?,?,?,?)";
				int rows=0;
				try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
					preparedStatement.setString(1, users.getSurname());
					preparedStatement.setString(2, users.getName());
					preparedStatement.setString(3, users.getAdres());
					preparedStatement.setString(4, users.getEmail());
					preparedStatement.setString(5, users.getTelnumb());
					preparedStatement.setString(6, users.getPassword());
					preparedStatement.setString(7, "user");
					rows = preparedStatement.executeUpdate();
				}
				conn.close();
				return rows;
			}
		} catch (Exception ex) {
			System.out.println(ex);
			return 0;
		}
	}

	public static void insertQuestion(String name, String email, String question) {
		try {
			Class.forName("org.sqlite.JDBC").getDeclaredConstructor().newInstance();
			try (Connection conn = DriverManager.getConnection(url1)) {
				String sql = "INSERT INTO feedback (name,email,question) Values (?,?,?)";
				try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
					preparedStatement.setString(1, name);
					preparedStatement.setString(2, email);
					preparedStatement.setString(3, question);
					preparedStatement.executeUpdate();
				}
				conn.close();
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	public static void insertTarif(String name, String speed, String price) {
		try {
			Class.forName("org.sqlite.JDBC").getDeclaredConstructor().newInstance();
			try (Connection conn = DriverManager.getConnection(url1)) {
				String sql = "INSERT INTO tarif (name,speed,price) Values (?,?,?)";
				try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
					preparedStatement.setString(1, name);
					preparedStatement.setString(2, speed);
					preparedStatement.setString(3, price);
					preparedStatement.executeUpdate();
				}
				conn.close();
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	public static users getUser(String email, String password) {
		try {
			Class.forName("org.sqlite.JDBC").getDeclaredConstructor().newInstance();
			try (Connection conn = DriverManager.getConnection(url1)) {
				Statement statement = conn.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM users");
				String userEmail = email;
				String userPassword = password;
				users user = new users();
				while (resultSet.next()) {
					String emailDB = resultSet.getString(5);
					String passwordDB = resultSet.getString(7);
					if (emailDB.equals(userEmail) && passwordDB.equals(userPassword)) {
						user.setID(resultSet.getString(1));
						user.setSurname(resultSet.getString(2));
						user.setName(resultSet.getString(3));
						user.setAdres(resultSet.getString(4));
						user.setEmail(resultSet.getString(5));
						user.setTelnumb(resultSet.getString(6));
						user.setPassword(resultSet.getString(7));
						user.setRole(resultSet.getString(8));
						conn.close();
						return user;
					}
				}
				conn.close();
				return null;
			}
		} catch (Exception ex) {
			System.out.println(ex);
			return null;
		}

	}

	public static List FeedbackOutput() {
		try {
			Class.forName("org.sqlite.JDBC").getDeclaredConstructor().newInstance();
			try (Connection conn = DriverManager.getConnection(url1)) {
				Statement statement = conn.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM feedback");
				List feedbackList = new LinkedList();
				while (resultSet.next()) {
					userFeedback uf = new userFeedback();
					uf.setID(resultSet.getString("id"));
					uf.setName(resultSet.getString("name"));
					uf.setEmail(resultSet.getString("email"));
					uf.setQuestion(resultSet.getString("question"));
					uf.setAnswer(resultSet.getString("answer"));
					feedbackList.add(uf);
				}
				conn.close();
				return feedbackList;
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return null;

	}

	public static List TarifOutput() {
		try {
			Class.forName("org.sqlite.JDBC").getDeclaredConstructor().newInstance();
			try (Connection conn = DriverManager.getConnection(url1)) {
				Statement statement = conn.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM tarif");
				List TarifList = new LinkedList();
				while (resultSet.next()) {
					tarif tf = new tarif();
					tf.setID(resultSet.getString("id"));
					tf.setName(resultSet.getString("name"));
					tf.setPrice(resultSet.getString("price"));
					tf.setSpeed(resultSet.getString("speed"));
					TarifList.add(tf);
				}
				conn.close();
				return TarifList;
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return null;

	}

	public static void addAnswer(String id, String answer) {
		try {
			Class.forName("org.sqlite.JDBC").getDeclaredConstructor().newInstance();
			try (Connection conn = DriverManager.getConnection(url1)) {
				Statement statement = conn.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM feedback");
				String questionID = id;
				String questionAnswer = answer;
				while (resultSet.next()) {
					String idDB = resultSet.getString(1);
					if (idDB.equals(questionID)) {
						String sql = "UPDATE feedback SET ANSWER=? WHERE id=?";
						try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
							preparedStatement.setString(1, questionAnswer);
							preparedStatement.setString(2, questionID);
							preparedStatement.executeUpdate();
						}
					}
				}
				conn.close();
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	public static List tarifSearch(String name) {
		try {
			Class.forName("org.sqlite.JDBC").getDeclaredConstructor().newInstance();
			try (Connection conn = DriverManager.getConnection(url1)) {
				Statement statement = conn.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM tarif where name like \"%" + name + "%\"");
				List TarifList = new LinkedList();
				while (resultSet.next()) {
					tarif tf = new tarif();
					tf.setID(resultSet.getString("id"));
					tf.setName(resultSet.getString("name"));
					tf.setPrice(resultSet.getString("speed"));
					tf.setSpeed(resultSet.getString("price"));
					TarifList.add(tf);
				}
				conn.close();
				return TarifList;
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return null;
	}

	public static void removeTarif(String id) {
		try {
			Class.forName("org.sqlite.JDBC").getDeclaredConstructor().newInstance();
			try (Connection conn = DriverManager.getConnection(url1)) {
				String sql = "DELETE FROM tarif WHERE ID = ?";
				try (PreparedStatement preparedStatement = conn.prepareStatement("PRAGMA foreign_keys = ON")) {
					preparedStatement.execute();
				}
				try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
					preparedStatement.setString(1, id);				
					preparedStatement.executeUpdate();
				}
				conn.close();
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	public static void updateTarif(String id, String name, String speed, String price) {
		try {
			Class.forName("org.sqlite.JDBC").getDeclaredConstructor().newInstance();
			try (Connection conn = DriverManager.getConnection(url1)) {
				String sql = "UPDATE tarif SET name=?, speed=?, price=? WHERE id=?";
				try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
					preparedStatement.setString(1, name);
					preparedStatement.setString(2, speed);
					preparedStatement.setString(3, price);
					preparedStatement.setString(4, id);
					preparedStatement.executeUpdate();
				}
				conn.close();
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}
	public static void insertUserTarif(String idTarif, String idUser) {
		try {
			Class.forName("org.sqlite.JDBC").getDeclaredConstructor().newInstance();
			try (Connection conn = DriverManager.getConnection(url1)) {
				String sql = "INSERT INTO userTarif (userID,tarifID) Values (?,?)";
				try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
					preparedStatement.setString(1, idUser);
					preparedStatement.setString(2, idTarif);
					preparedStatement.executeUpdate();
				}
				conn.close();
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}
}
