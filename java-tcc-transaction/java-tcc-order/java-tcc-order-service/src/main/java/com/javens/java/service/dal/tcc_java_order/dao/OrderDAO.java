package com.javens.java.service.dal.tcc_java_order.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.javens.java.service.dal.tcc_java_order.dataobject.OrderDO;
import com.javens.java.service.dal.tcc_java_order.mapper.OrderDOMapper;

/**
* The Table TCC_ORDER.
* TCC_ORDER
*/
@Repository
public class OrderDAO{

    @Autowired
    private OrderDOMapper orderDOMapper;

    /**
    * desc:insert:TCC_ORDER.<br/>
    * descSql = INSERT INTO TCC_ORDER VALUES 
        * @param entity entity
    * @return Long
    */
    public Long insert(OrderDO entity){
        return orderDOMapper.insert(entity);
    }
    /**
    * desc:获取记录.<br/>
    * descSql =  SELECT * FROM TCC_ORDER WHERE id =#{id,jdbcType=INTEGER} and IS_DEL = 0 LIMIT 1
        * @param id id
    * @return OrderDO
    */
    public OrderDO getById(Integer id){
        return orderDOMapper.getById(id);
    }
    /**
    * desc:获取记录.<br/>
    * descSql =  SELECT * FROM TCC_ORDER WHERE id =#{id,jdbcType=INTEGER} and IS_DEL = 0 FOR UPDATE
        * @param id id
    * @return OrderDO
    */
    public OrderDO getByIdForUpdate(Integer id){
        return orderDOMapper.getByIdForUpdate(id);
    }
    /**
    * desc:获取记录.<br/>
    * descSql =  SELECT * FROM TCC_ORDER WHERE ORDER_SN =#{orderSn,jdbcType=VARCHAR} and IS_DEL = 0 FOR UPDATE
        * @param orderSn orderSn
    * @return OrderDO
    */
    public OrderDO getByOrderSnForUpdate(String orderSn){
        return orderDOMapper.getByOrderSnForUpdate(orderSn);
    }
}
