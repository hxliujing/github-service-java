package com.javens.java.service.dal.tcc_java_order.mapper;
import org.apache.ibatis.annotations.Param;
import com.javens.java.service.dal.tcc_java_order.dataobject.OrderDO;
/**
*
* The Table TCC_ORDER.
* TCC_ORDER
*/
public interface OrderDOMapper{

    /**
    * desc:insert:TCC_ORDER.<br/>
    * descSql = INSERT INTO TCC_ORDER VALUES 
        * @param entity entity
    * @return Long
    */
        Long insert(OrderDO entity);
    /**
    * desc:获取记录.<br/>
    * descSql =  SELECT * FROM TCC_ORDER WHERE id =#{id,jdbcType=INTEGER} and IS_DEL = 0 LIMIT 1
        * @param id id
    * @return OrderDO
    */
        OrderDO getById(Integer id);
    /**
    * desc:获取记录.<br/>
    * descSql =  SELECT * FROM TCC_ORDER WHERE id =#{id,jdbcType=INTEGER} and IS_DEL = 0 FOR UPDATE
        * @param id id
    * @return OrderDO
    */
        OrderDO getByIdForUpdate(Integer id);
    /**
    * desc:获取记录.<br/>
    * descSql =  SELECT * FROM TCC_ORDER WHERE ORDER_SN =#{orderSn,jdbcType=VARCHAR} and IS_DEL = 0 FOR UPDATE
        * @param orderSn orderSn
    * @return OrderDO
    */
        OrderDO getByOrderSnForUpdate(String orderSn);
}
