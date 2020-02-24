package com.ruoyi.framework.influxdb;

import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBFactory;
import org.influxdb.dto.BatchPoints;
import org.influxdb.dto.Point;
import org.influxdb.dto.Query;
import org.influxdb.dto.QueryResult;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class InfluxdbUtils {

//    @Value("${influxdb.host}")
//    private String host;
//    @Value("${influxdb.port}")
//    private String port;
//    @Value("${influxdb.database}")
    private String database;
//    @Value("${influxdb.username}")
//    private String username;
//    @Value("${influxdb.password}")
//    private String password;

    private InfluxDB influxDB;

    public InfluxdbUtils(String host,String port,String username,String password,String database){
        this.database=database;
        if (this.influxDB == null) {
            String openurl="http://"+host+":"+port;
            this.influxDB = InfluxDBFactory.connect(openurl, username, password);
            this.influxDB.createDatabase(database);
        }
    }

    /**
     * 设置数据保存策略
     * defalut 策略名 /database 数据库名/ 30d 数据保存时限30天/ 1 副本个数为1/ 结尾DEFAULT 表示 设为默认的策略
     */
    public void createRetentionPolicy() {
        String command = String.format("CREATE RETENTION POLICY \"%s\" ON \"%s\" DURATION %s REPLICATION %s DEFAULT",
                "defalut", database, "730d", 1);
        this.query(command);
    }

    /**
     * 查询
     *
     * @param command 查询语句
     * @return QueryResult
     */
    public QueryResult query(String command) {

        return influxDB.query(new Query(command, database));
    }

    /**
     * 插入
     *
     * @param tags   标签
     * @param fields 字段
     */
    public void insert(Map<String, String> tags, String table, Map<String, Object> fields) {
        Point.Builder builder = Point.measurement(table);
        builder.tag(tags);
        builder.fields(fields);
        influxDB.write(database, "", builder.build());
    }

    /**
     * 插入(自定义时间)
     *
     * @param tags   标签
     * @param fields 字段
     */
    public void insertAndTime(Map<String, String> tags, String table, Map<String, Object> fields, long time) {
        Point.Builder builder = Point.measurement(table);
        builder.tag(tags);
        builder.fields(fields);
        builder.time(time, TimeUnit.MILLISECONDS);
        influxDB.write(database, "", builder.build());
    }

    public void batchInsertAndTime(List<BatchData> batchDatas){
        BatchPoints batchPoints = BatchPoints.database(database).consistency(InfluxDB.ConsistencyLevel.ALL).build();
        for (BatchData batchData:batchDatas ) {
            Point.Builder builder = Point.measurement(batchData.getTable());
            builder.tag(batchData.getTags());
            builder.fields(batchData.getFields());
            builder.time(batchData.getTime(), TimeUnit.MILLISECONDS);
            batchPoints.point(builder.build());
        }
        influxDB.write(batchPoints);
    }

    /**
     * 删除
     *
     * @param command 删除语句
     * @return 返回错误信息
     */
    public String deleteMeasurementData(String command) {
        QueryResult result = influxDB.query(new Query(command, database));
        return result.getError();
    }

    /**
     * 创建数据库
     *
     * @param dbName
     */
    public void createDB(String dbName) {

        influxDB.createDatabase(dbName);
    }

    /**
     * 删除数据库
     *
     * @param dbName
     */
    public void deleteDB(String dbName) {

        influxDB.deleteDatabase(dbName);
    }

}
