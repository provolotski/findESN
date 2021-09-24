package by.belstat.cit.eisgs.findESN.dao;

import by.belstat.cit.eisgs.findESN.constants.SQLQueryText;
import by.belstat.cit.eisgs.findESN.entity.Esn;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class FindEsnDaoImpl implements FindEsnDAO {
    private static final Logger LOGGER = LoggerFactory.getLogger(FindEsnDaoImpl.class);
    @Autowired
    private DataSource dataSource;

    @Override
    public Esn findById(String id) {
        LOGGER.info("start findById");
        Esn esn = new Esn();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQLQueryText.qryfindESNById);) {
            statement.setString(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    esn.setId(resultSet.getLong("ID_ESNI"));
                    esn.setCodeEsni(resultSet.getString("CODE_ESNI"));
                    esn.setCodeUnp(resultSet.getString("CODE_ESNI_UNP"));
                    esn.setIdEsnt(resultSet.getInt("ID_ESNT"));
                    esn.setNameEnt(resultSet.getString("VARC_DATA"));
                }
            }
        } catch (SQLException exception) {
            LOGGER.error("Ошибка при получении предприятия " + id);
            exception.printStackTrace();
        }
        return esn;
    }
}
