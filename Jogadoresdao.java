package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import entidade.Jogadores;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Jogadoresdao {
	// Estrutura de Dados
	private ObservableList<Jogadores> listaJogadores=FXCollections.observableArrayList();;
	
	public Jogadoresdao() {
		//listaPessoas=FXCollections.observableArrayList();
	}
	
	public void inserir(Jogadores p) {
		Conexao con = new Conexao();
		try {
			String sql = "INSERT INTO jogadores "
					+ "(nome_jogadores, email_jogadores, idade_jogadores, time_jogadores) "
					+ "VALUES (?,?,?,?)";
			PreparedStatement prep = con.getConexao().prepareStatement(sql);
			prep.setString(1, p.getNome());
			prep.setString(2, p.getEmail());
			prep.setString(3, p.getIdade());
			prep.setInt (4, p.getTime());
			prep.executeUpdate();			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		con.desconecta();
	}
	public void alterar(Jogadores p) {
		Conexao con = new Conexao();
		try {
			String sql = "UPDATE jogadores SET "
					+ "cod_jogadores = ?, nome_jogadores = ?, email_jogadores = ?, idade_jogadores = ? "
					+ "WHERE codigo = ?, time = ?";
			PreparedStatement prep = con.getConexao().prepareStatement(sql);
			prep.setString(1, p.getNome());
			prep.setString(2, p.getEmail());
			prep.setString(3, p.getIdade());
			prep.setInt(4, p.getTime());
			prep.executeUpdate();			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		con.desconecta();
	}
	public void excluir(Jogadores p) {
		Conexao con = new Conexao();
		try {
			String sql = "DELETE FROM jogadores "
					+ "WHERE time = ?";
			PreparedStatement prep = con.getConexao().prepareStatement(sql);
			prep.setInt(1, p.getTime());
			prep.executeUpdate();			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		con.desconecta();
	}
	public ObservableList<Jogadores> listar() {
		Conexao con = new Conexao();
		try {
			String sql = "SELECT * FROM jogadores "
					+ "ORDER BY nome_jogadores";
			Statement prep = con.getConexao().createStatement();
			ResultSet res = prep.executeQuery(sql);
			while (res.next()) {
				
				Jogadores p = new Jogadores(res.getString("nome"));
				
				p.setTime(res.getInt("Time"));
				p.setEmail(res.getString("email"));
				p.setIdade(res.getString("idade"));
				listaJogadores.add(p);
			}
						
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		con.desconecta();
		
		
		//ObservableList<Jogadores> listaJogadores = ;
		//listar();
		return listaJogadores;
	}

	public ObservableList<Jogadores> getListaJogadores() {
		// TODO Auto-generated method stub
		return listar();
	}
	
}