package by.belstat.cit.eisgs.findESN.constants;

public final class SQLQueryText {
    public static final String qryfindESNById ="SELECT ei.id_esni,\n" +
            "       code_esni,\n" +
            "       CASE\n" +
            "           WHEN code_esni_unp IS NULL\n" +
            "           THEN\n" +
            "               CASE\n" +
            "                   WHEN ei.id_esnt = 70\n" +
            "                   THEN\n" +
            "                       (SELECT code_esni_unp\n" +
            "                          FROM esn_item ei_temp\n" +
            "                         WHERE     ei_temp.code_esni = ei.code_esni\n" +
            "                               AND ei_temp.ID_ESNT = 76\n" +
            "                               AND ei_temp.CODE_ESNI_UNP IS NOT NULL)\n" +
            "                   WHEN ei.id_esnt = 76\n" +
            "                   THEN\n" +
            "                       (SELECT code_esni_unp\n" +
            "                          FROM esn_item ei_temp\n" +
            "                         WHERE     ei_temp.code_esni = ei.code_esni\n" +
            "                               AND ei_temp.ID_ESNT = 70\n" +
            "                               AND ei_temp.CODE_ESNI_UNP IS NOT NULL)\n" +
            "               END\n" +
            "           ELSE\n" +
            "               code_esni_unp\n" +
            "       END    code_esni_unp,\n" +
            "       ei.id_esnt,\n" +
            "       ehc.VARC_DATA,\n" +
            "       ei.END_DATE_ESNI\n" +
            "  FROM esn_item ei, SS_METADATA.ESN_HISTORY_CV ehc\n" +
            " WHERE     ehc.ID_ESNI = ei.ID_ESNI\n" +
            "       AND ei.END_DATE_ESNI > SYSDATE\n" +
            "       AND ehc.END_DATE_ESNHCV = ei.END_DATE_ESNI\n" +
            "       AND ehc.ID_ESNC = 140\n" +
            "       AND ei.ID_ESNI = ?";
}
