package by.belstat.cit.eisgs.findESN.dao;

import by.belstat.cit.eisgs.findESN.constants.SQLQueryText;
import by.belstat.cit.eisgs.findESN.entity.Esn;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class FindEsnDaoImpl implements FindEsnDAO {
    private static final Logger LOGGER = LogManager.getLogger(FindEsnDaoImpl.class);
    @Autowired
    private DataSource dataSource;

    @Override
    public Esn findById(String id) {
        LOGGER.info("start findById");
        Esn esn = new Esn();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQLQueryText.QRYFIND_ESN_BY_ID);) {
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


    @Override
    public List<Esn> findAll() {
        LOGGER.info("start findAll");
        List<Esn> esnList = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SQLQueryText.QRYFIND_ESN_ALL);

        ) {
            LOGGER.debug("generate repository");
            int i = 0;
            while (resultSet.next()) {
                esnList.add(new Esn(
                        resultSet.getLong("ID_ESNI"),
                        resultSet.getString("CODE_ESNI"),
                        resultSet.getString("CODE_ESNI_UNP"),
                        resultSet.getInt("ID_ESNT"),
                        resultSet.getString("VARC_DATA")));
                if (i++ % 10000 == 0) {
                    LOGGER.debug("added esn count: " + i);
                }
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return esnList;
    }

    @Override
    public List<Esn> findAllPaginator(long start, long finish) {
        List<Esn> esnList = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQLQueryText.QRY_FIND_ALL_BY_PAGE);) {
            statement.setLong(1, start);
            statement.setLong(2, finish);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    esnList.add(new Esn(
                            resultSet.getLong("ID_ESNI"),
                            resultSet.getString("CODE_ESNI"),
                            resultSet.getString("CODE_ESNI_UNP"),
                            resultSet.getInt("ID_ESNT"),
                            resultSet.getString("VARC_DATA")));
                }
            }
        } catch (SQLException exception) {
            LOGGER.error("Ошибка при получении предприятия ");
            exception.printStackTrace();
        }
        return esnList;
    }

    @Override
    public long count() {
        long count = 0;

        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SQLQueryText.QRY_CONT_ESNI);) {
            if (resultSet.next()) {
                count = resultSet.getLong("cnt");
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return count;
    }

}
