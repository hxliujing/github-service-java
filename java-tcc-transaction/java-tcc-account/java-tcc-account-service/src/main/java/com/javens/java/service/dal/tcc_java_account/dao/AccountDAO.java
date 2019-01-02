package com.javens.java.service.dal.tcc_java_account.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.javens.java.service.dal.tcc_java_account.dataobject.AccountDO;
import com.javens.java.service.dal.tcc_java_account.mapper.AccountDOMapper;

/**
* The Table TCC_ACCOUNT.
* TCC_ACCOUNT
*/
@Repository
public class AccountDAO{

    @Autowired
    private AccountDOMapper accountDOMapper;

    /**
    * desc:insert:TCC_ACCOUNT.<br/>
    * descSql = INSERT INTO TCC_ACCOUNT VALUES 
        * @param entity entity
    * @return Long
    */
    public Long insert(AccountDO entity){
        return accountDOMapper.insert(entity);
    }
    /**
    * desc:获取记录.<br/>
    * descSql =  SELECT * FROM TCC_ACCOUNT WHERE id =#{id,jdbcType=INTEGER} and IS_DEL = 0 LIMIT 1
        * @param id id
    * @return AccountDO
    */
    public AccountDO getById(Integer id){
        return accountDOMapper.getById(id);
    }
    /**
    * desc:获取记录.<br/>
    * descSql =  SELECT * FROM TCC_ACCOUNT WHERE id =#{id,jdbcType=INTEGER} and IS_DEL = 0 FOR UPDATE
        * @param id id
    * @return AccountDO
    */
    public AccountDO getByIdForUpdate(Integer id){
        return accountDOMapper.getByIdForUpdate(id);
    }
    /**
    * desc:修改账户金额.<br/>
    * descSql =  UPDATE TCC_ACCOUNT SET amount = amount + #{amount,jdbcType=DECIMAL} where id = #{id,jdbcType=INTEGER} and IS_DEL = 0
        * @param entity entity
    * @return Long
    */
    public Long updateAccountBalance(AccountDO entity){
        return accountDOMapper.updateAccountBalance(entity);
    }
}
