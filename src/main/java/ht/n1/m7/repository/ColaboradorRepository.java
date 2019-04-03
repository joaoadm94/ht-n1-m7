package ht.n1.m7.repository;

import ht.n1.m7.entity.Colaborador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ColaboradorRepository{

    @Autowired
    DataSource dataSource;

    public List<Colaborador> listar() {
        List<Colaborador> lista = new ArrayList<>();
        try (Connection connection = dataSource.getConnection("sa", "")) {
            PreparedStatement ps = connection.prepareStatement("select * from colaborador");
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                lista.add(new Colaborador(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getInt(4), rs.getBigDecimal(5),
                        rs.getDate(6).toLocalDate()));
            }
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public List<Colaborador> pesquisar(String criterio) {
        List<Colaborador> lista = new ArrayList<>();
        try (Connection connection = dataSource.getConnection("sa", "")) {
            PreparedStatement ps = connection.prepareStatement("select * from colaborador where nome like '%" + criterio + "%'");
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                lista.add(new Colaborador(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getInt(4), rs.getBigDecimal(5),
                        rs.getDate(6).toLocalDate()));
            }
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public Colaborador obter(Integer id) {
        Colaborador colaborador = new Colaborador();
        try (Connection connection = dataSource.getConnection("sa", "")) {
            PreparedStatement ps = connection.prepareStatement("select * from colaborador where id = '%" + id + "%'");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                colaborador = new Colaborador(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getInt(4), rs.getBigDecimal(5),
                        rs.getDate(6).toLocalDate());
            }
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return colaborador;
    }

    public Integer salvar(Colaborador colaborador) {
        try (Connection connection = dataSource.getConnection("sa", "")) {
            String id = colaborador.getId() == null ? "nextval('sq_id_colaborador')" : colaborador.getId().toString();
            String insert = "Insert into colaborador values(" + id + ", " +
                    "'" + colaborador.getNome() + "','" + colaborador.getCpf() + "'," +
                    "'" + colaborador.getCargo() + "','" + colaborador.getSalario() + "'," +
                    "'" + colaborador.getSalario() + "'";
            PreparedStatement ps = connection.prepareStatement(insert);
            Integer result = ps.executeUpdate();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Integer excluir(Integer id) {
        try (Connection connection = dataSource.getConnection("sa", "")) {
            PreparedStatement ps = connection.prepareStatement("delete * from colaborador  where id = " + id + ";");
            Integer result = ps.executeUpdate();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
