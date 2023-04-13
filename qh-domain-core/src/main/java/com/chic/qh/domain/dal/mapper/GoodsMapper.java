package com.chic.qh.domain.dal.mapper;

import static com.chic.qh.domain.dal.mapper.GoodsDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.chic.qh.domain.dal.model.Goods;
import java.util.List;
import javax.annotation.Generated;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.mybatis.dynamic.sql.delete.DeleteDSL;
import org.mybatis.dynamic.sql.delete.MyBatis3DeleteModelAdapter;
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider;
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider;
import org.mybatis.dynamic.sql.render.RenderingStrategy;
import org.mybatis.dynamic.sql.select.MyBatis3SelectModelAdapter;
import org.mybatis.dynamic.sql.select.QueryExpressionDSL;
import org.mybatis.dynamic.sql.select.SelectDSL;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.MyBatis3UpdateModelAdapter;
import org.mybatis.dynamic.sql.update.UpdateDSL;
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;

@Mapper
public interface GoodsMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_goods")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_goods")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_goods")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @Options(useGeneratedKeys=true,keyProperty="record.goodsId")
    int insert(InsertStatementProvider<Goods> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_goods")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("GoodsResult")
    Goods selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_goods")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="GoodsResult", value = {
        @Result(column="goods_id", property="goodsId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="goods_sn", property="goodsSn", jdbcType=JdbcType.VARCHAR),
        @Result(column="goods_name", property="goodsName", jdbcType=JdbcType.VARCHAR),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="gmt_created", property="gmtCreated", jdbcType=JdbcType.INTEGER),
        @Result(column="gmt_modify", property="gmtModify", jdbcType=JdbcType.INTEGER)
    })
    List<Goods> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_goods")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_goods")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<Long>> countByExample() {
        return SelectDSL.selectWithMapper(this::count, SqlBuilder.count())
                .from(goods);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_goods")
    default DeleteDSL<MyBatis3DeleteModelAdapter<Integer>> deleteByExample() {
        return DeleteDSL.deleteFromWithMapper(this::delete, goods);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_goods")
    default int deleteByPrimaryKey(Integer goodsId_) {
        return DeleteDSL.deleteFromWithMapper(this::delete, goods)
                .where(goodsId, isEqualTo(goodsId_))
                .build()
                .execute();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_goods")
    default int insert(Goods record) {
        return insert(SqlBuilder.insert(record)
                .into(goods)
                .map(goodsSn).toProperty("goodsSn")
                .map(goodsName).toProperty("goodsName")
                .map(remark).toProperty("remark")
                .map(gmtCreated).toProperty("gmtCreated")
                .map(gmtModify).toProperty("gmtModify")
                .build()
                .render(RenderingStrategy.MYBATIS3));
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_goods")
    default int insertSelective(Goods record) {
        return insert(SqlBuilder.insert(record)
                .into(goods)
                .map(goodsSn).toPropertyWhenPresent("goodsSn", record::getGoodsSn)
                .map(goodsName).toPropertyWhenPresent("goodsName", record::getGoodsName)
                .map(remark).toPropertyWhenPresent("remark", record::getRemark)
                .map(gmtCreated).toPropertyWhenPresent("gmtCreated", record::getGmtCreated)
                .map(gmtModify).toPropertyWhenPresent("gmtModify", record::getGmtModify)
                .build()
                .render(RenderingStrategy.MYBATIS3));
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_goods")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<List<Goods>>> selectByExample() {
        return SelectDSL.selectWithMapper(this::selectMany, goodsId, goodsSn, goodsName, remark, gmtCreated, gmtModify)
                .from(goods);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_goods")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<List<Goods>>> selectDistinctByExample() {
        return SelectDSL.selectDistinctWithMapper(this::selectMany, goodsId, goodsSn, goodsName, remark, gmtCreated, gmtModify)
                .from(goods);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_goods")
    default Goods selectByPrimaryKey(Integer goodsId_) {
        return SelectDSL.selectWithMapper(this::selectOne, goodsId, goodsSn, goodsName, remark, gmtCreated, gmtModify)
                .from(goods)
                .where(goodsId, isEqualTo(goodsId_))
                .build()
                .execute();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_goods")
    default UpdateDSL<MyBatis3UpdateModelAdapter<Integer>> updateByExample(Goods record) {
        return UpdateDSL.updateWithMapper(this::update, goods)
                .set(goodsSn).equalTo(record::getGoodsSn)
                .set(goodsName).equalTo(record::getGoodsName)
                .set(remark).equalTo(record::getRemark)
                .set(gmtCreated).equalTo(record::getGmtCreated)
                .set(gmtModify).equalTo(record::getGmtModify);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_goods")
    default UpdateDSL<MyBatis3UpdateModelAdapter<Integer>> updateByExampleSelective(Goods record) {
        return UpdateDSL.updateWithMapper(this::update, goods)
                .set(goodsSn).equalToWhenPresent(record::getGoodsSn)
                .set(goodsName).equalToWhenPresent(record::getGoodsName)
                .set(remark).equalToWhenPresent(record::getRemark)
                .set(gmtCreated).equalToWhenPresent(record::getGmtCreated)
                .set(gmtModify).equalToWhenPresent(record::getGmtModify);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_goods")
    default int updateByPrimaryKey(Goods record) {
        return UpdateDSL.updateWithMapper(this::update, goods)
                .set(goodsSn).equalTo(record::getGoodsSn)
                .set(goodsName).equalTo(record::getGoodsName)
                .set(remark).equalTo(record::getRemark)
                .set(gmtCreated).equalTo(record::getGmtCreated)
                .set(gmtModify).equalTo(record::getGmtModify)
                .where(goodsId, isEqualTo(record::getGoodsId))
                .build()
                .execute();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_goods")
    default int updateByPrimaryKeySelective(Goods record) {
        return UpdateDSL.updateWithMapper(this::update, goods)
                .set(goodsSn).equalToWhenPresent(record::getGoodsSn)
                .set(goodsName).equalToWhenPresent(record::getGoodsName)
                .set(remark).equalToWhenPresent(record::getRemark)
                .set(gmtCreated).equalToWhenPresent(record::getGmtCreated)
                .set(gmtModify).equalToWhenPresent(record::getGmtModify)
                .where(goodsId, isEqualTo(record::getGoodsId))
                .build()
                .execute();
    }
}